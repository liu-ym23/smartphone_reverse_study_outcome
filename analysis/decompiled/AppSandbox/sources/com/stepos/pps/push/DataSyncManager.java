package com.stepos.pps.push;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import android.util.Log;
import com.stepos.pps.PPSApplication;
import com.stepos.pps.data.ouc.cloud.UserTypeManager;
import com.stepos.pps.data.ouc.ems.EmsConfigSyncManager;
import com.stepos.pps.data.util.DeviceUtils;
import com.stepos.pps.data.util.LogUtil;
import com.stepos.pps.data.util.Utils;
import com.stepos.pps.push.utils.DataThreadFactory;
import com.stepos.pps.reflect.BuildExtStepOS;
import com.stepos.pps.reflect.ExceptionManagerStepOS;
import com.stepos.pps.reflect.SystemProperties;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

/* loaded from: classes.dex */
public class DataSyncManager {
    private static final String ADDRESS_CONFIG_F9 = "https://syscloud.zyql.com/api/v1/power/config";
    private static final int CHECK_IMEI_AGAIN = 6;
    private static final long CHECK_IMEI_AGAIN_DELAY = 240000;
    private static final int CORESIZE = 4;
    private static final int DATA_NULL_CODE = 120015;
    public static boolean DEBUG = false;
    private static final String EMS_CONFIG_F10;
    private static final String EMS_HOST_PROD = "mic-collect.stepaos.com";
    private static final String EMS_HOST_TEST = "mic-collect.t-stepos.com";
    private static final long INITIALIZE_TIME_STAP = 1590336000000L;
    private static DataSyncManager INSTANCE = null;
    private static final long KEEPALIVETIME = 60000;
    private static final int MAXSIZE = 10;
    private static final int PARAMSERRO = 110001;
    private static final int PARAMSERROR = 120001;
    private static final int SCUCCESS_CODE = 200;
    private static final int SERVERCACHEERROR = 193000;
    private static final int SERVERINNRERROR = 100000;
    private static final String SHRINKER_SERVER_TIME = "shrinker_server_time";
    private static final int SIGNERROR = 198002;
    private static final int SIGN_ERROR_CODE = 198001;
    private static final String TAG = "DataSyncManager";
    private static final String TIMESTAMP_WAITING = "timestamp Waiting!";
    private String DEVICE = Build.DEVICE;
    private final String STEPOS_VERSION = Build.DISPLAY;
    ArrayList<OnConfigPushListener> mConfigListeners = new ArrayList<>();
    private Context mContext;
    private DataThreadFactory mDataThreadFactory;
    private ThreadPoolExecutor mThreadPoolExecutor;

    public interface DownloadListener {
        void downFailed();

        void downSucceeded(String str);
    }

    public interface OnConfigPushListener {
        void onConfigChanged();
    }

    private static boolean isProdEnv() {
        if ("prd".equalsIgnoreCase(SystemProperties.get("persist.stepos.pps.env", ""))) {
            return true;
        }
        String str = SystemProperties.get("ro.build.aios_publish_type", UserTypeManager.DEV);
        return "beta".equalsIgnoreCase(str) || "mp".equalsIgnoreCase(str);
    }

    static {
        StringBuilder sb = new StringBuilder("https://");
        sb.append(isProdEnv() ? EMS_HOST_PROD : EMS_HOST_TEST);
        sb.append("/v1/crash/config");
        EMS_CONFIG_F10 = sb.toString();
    }

    public static DataSyncManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataSyncManager();
        }
        return INSTANCE;
    }

    private DataSyncManager() {
        initVariable();
    }

    private void initVariable() {
        this.mContext = PPSApplication.getInstance();
        this.mDataThreadFactory = new DataThreadFactory(ExceptionManagerStepOS.USER_CONFIG_BUNDLE_DATA);
        this.mThreadPoolExecutor = new ThreadPoolExecutor(4, 10, KEEPALIVETIME, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), this.mDataThreadFactory);
        this.DEVICE = BuildExtStepOS.DEVICE;
        FetchConfigJobService.triggerJob(this.mContext);
    }

    public void updateData() {
        if (Utils.canLogCollect(this.mContext)) {
            EmsConfigSyncManager.getInstance().syncEmsConfig();
        } else {
            LogUtil.w("DataSyncManager", "Ignore syncEmsConfig for user privacy!!!");
        }
    }

    private class GetDownloadURLRunable implements Runnable {
        private DownloadListener mDownloadListener;
        private String mUrl;
        private Map<String, String> params;

        public GetDownloadURLRunable(DataSyncManager dataSyncManager, String str, Map<String, String> map) {
            this.mUrl = str;
            this.params = map;
        }

        public void setDownloadListener(DownloadListener downloadListener) {
            this.mDownloadListener = downloadListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            new HttpDownloader().getData(this.mUrl, this.params, this.mDownloadListener);
        }
    }

    public void dump(PrintWriter printWriter, String[] strArr) {
        printWriter.println("data sync..");
        if ("local".equals(strArr.length > 1 ? strArr[1] : "empty")) {
            Iterator<OnConfigPushListener> it = this.mConfigListeners.iterator();
            while (it.hasNext()) {
                it.next().onConfigChanged();
            }
        }
    }

    public void addOnConfigChangedListener(OnConfigPushListener onConfigPushListener) {
        this.mConfigListeners.add(onConfigPushListener);
    }

    public void fetchEmsConfig(PersistableBundle persistableBundle, DownloadListener downloadListener) {
        if (!Utils.canLogCollect(this.mContext)) {
            LogUtil.w("DataSyncManager", "Ignore fetchEmsConfig for user privacy!!!");
            return;
        }
        HashMap map = new HashMap();
        String string = persistableBundle.getString("version", "0");
        String string2 = persistableBundle.getString("updateTime", "0");
        map.put("deviceId", Utils.md5checkSum(DeviceUtils.getDeviceId()).toLowerCase());
        map.put("firmware", this.STEPOS_VERSION);
        map.put("device", BuildExtStepOS.DEVICE);
        map.put("version", string);
        map.put("updateTime", string2);
        LogUtil.d("DataSyncManager", "fetchEmsConfig --- param=" + map.toString());
        if (DEBUG) {
            final StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("fetch ems config: \n");
            map.forEach(new BiConsumer() { // from class: com.stepos.pps.push.DataSyncManager$$ExternalSyntheticLambda0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    stringBuffer.append((String) obj).append("=").append((String) obj2).append("\n");
                }
            });
            LogUtil.d("DataSyncManager", stringBuffer.toString());
        }
        GetDownloadURLRunable getDownloadURLRunable = new GetDownloadURLRunable(this, EMS_CONFIG_F10, map);
        getDownloadURLRunable.setDownloadListener(downloadListener);
        this.mThreadPoolExecutor.execute(getDownloadURLRunable);
    }

    public static class FetchConfigJobService extends JobService {
        public static final String TAG = "FetchConfigJobService";
        public static final long INTERVAL_MILLIS = TimeUnit.DAYS.toMillis(1);
        private static final int JOB_ID = "fetch_config".hashCode();
        private static final ExecutorService sJobExecutor = Executors.newSingleThreadExecutor();

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            return false;
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(final JobParameters jobParameters) {
            LogUtil.d(TAG, "onStartJob");
            sJobExecutor.execute(new Runnable() { // from class: com.stepos.pps.push.DataSyncManager$FetchConfigJobService$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onStartJob$0(jobParameters);
                }
            });
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onStartJob$0(JobParameters jobParameters) {
            try {
                DataSyncManager.getInstance().updateData();
            } catch (Throwable th) {
                try {
                    LogUtil.w(TAG, "updateData failed: " + th);
                } finally {
                    jobFinished(jobParameters, false);
                }
            }
        }

        public static void triggerJob(Context context) {
            LogUtil.d(TAG, "trigger job");
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
            if (jobScheduler == null) {
                Log.e(TAG, "failed to triggerJob because scheduler is null");
                return;
            }
            JobInfo.Builder builder = new JobInfo.Builder(JOB_ID, new ComponentName(context, (Class<?>) FetchConfigJobService.class));
            builder.setRequiredNetworkType(1);
            builder.setRequiresBatteryNotLow(true);
            builder.setPeriodic(INTERVAL_MILLIS);
            jobScheduler.schedule(builder.build());
        }
    }
}
