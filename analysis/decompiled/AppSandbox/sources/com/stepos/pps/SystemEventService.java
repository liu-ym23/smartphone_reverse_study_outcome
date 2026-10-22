package com.stepos.pps;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.os.Process;
import android.util.Log;
import com.bytedance.applog.AppLog;
import com.stepos.pps.IPPSClientService;
import com.stepos.pps.data.stats.helper.exceptioncode.MetricReporter;
import com.stepos.pps.data.systemusage.SystemUsageManager;
import com.stepos.pps.data.util.DeviceUtils;
import com.stepos.pps.push.DataSyncManager;
import com.stepos.pps.reflect.ExceptionManagerStepOS;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class SystemEventService extends Service {
    private static final String TAG = "SystemEventService";
    private final IPPSClientService mImpl = new IPPSClientServiceImpl();

    private class IPPSClientServiceImpl extends IPPSClientService.Stub {
        private IPPSClientServiceImpl(SystemEventService systemEventService) {
        }

        @Override // com.stepos.pps.IPPSClientService
        public void onProcessLifecycle(int i, int i2, int i3, String str, long j, long j2) {
            SystemUsageManager systemUsageManager = SystemUsageManager.getInstance();
            if (systemUsageManager == null) {
                Log.w(SystemEventService.TAG, "onProcessLifecycle dropped: SystemUsageManager not ready (event=" + i + " pid=" + i2 + ")");
                return;
            }
            if (i == 1) {
                systemUsageManager.onProcStarted(i2, i3, str, j, j2);
            } else {
                if (i == 2) {
                    systemUsageManager.onProcDied(i2, j);
                    return;
                }
                Log.e(SystemEventService.TAG, "unknown lifecycle event=" + i);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        return this.mImpl.asBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        Log.d(TAG, "onCreate");
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind");
        return super.onUnbind(intent);
    }

    @Override // android.app.Service
    protected void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            printWriter.println("error args");
            return;
        }
        if ("datasync".equals(strArr[0])) {
            DataSyncManager.getInstance().dump(printWriter, strArr);
            return;
        }
        if ("excode_pull".equals(strArr[0])) {
            Log.d(TAG, "execute excode_pull from dump");
            PPSApplication.getInstance().getExCodeStatsCollector().getMetrics();
            return;
        }
        if ("app_alive".equals(strArr[0])) {
            SystemUsageManager systemUsageManager = SystemUsageManager.getInstance();
            if (systemUsageManager != null) {
                systemUsageManager.dumpAppAlive(printWriter);
                return;
            } else {
                printWriter.println("SystemUsageManager is not initialized yet.");
                return;
            }
        }
        if ("boot_dur".equals(strArr[0])) {
            SystemUsageManager systemUsageManager2 = SystemUsageManager.getInstance();
            if (systemUsageManager2 != null) {
                systemUsageManager2.dumpBootDur(printWriter);
                return;
            }
            return;
        }
        if ("device_usage".equals(strArr[0])) {
            SystemUsageManager systemUsageManager3 = SystemUsageManager.getInstance();
            if (systemUsageManager3 != null) {
                systemUsageManager3.dumpDeviceUsage(printWriter);
                return;
            }
            return;
        }
        if ("metric".equals(strArr[0])) {
            MetricReporter.getInstance(getApplicationContext()).dump(printWriter);
        } else if ("deviceid".equals(strArr[0])) {
            dumpDeviceId(printWriter);
        } else if ("graphics_oom".equals(strArr[0])) {
            dumpGraphicsOom(printWriter, strArr.length > 1 ? strArr[1] : "diagnose");
        }
    }

    private void dumpDeviceId(PrintWriter printWriter) {
        String ssid;
        String deviceId = null;
        try {
            ssid = AppLog.getSsid();
        } catch (Throwable th) {
            Log.w(TAG, "getSsid failed: " + th);
            ssid = null;
        }
        printWriter.println("ssid=" + ssid);
        try {
            deviceId = DeviceUtils.getDeviceId();
        } catch (Throwable th2) {
            Log.w(TAG, "getDeviceId(encrypted oaid) failed: " + th2);
        }
        printWriter.println("encryptedOaid=" + deviceId);
    }

    private void dumpGraphicsOom(PrintWriter printWriter, String str) {
        String str2 = "fatal".equalsIgnoreCase(str) ? ExceptionManagerStepOS.EXCEPTION_LEVEL_TYPE_FATAL : "DIAGNOSE";
        Object exceptionType = ExceptionManagerStepOS.getExceptionType("GRAPHICS_OOM");
        Object exceptionLevel = ExceptionManagerStepOS.getExceptionLevel(str2);
        if (exceptionType == null || exceptionLevel == null) {
            printWriter.println("graphics_oom: type or level not found (EMS not ready?), level=".concat(str2));
            return;
        }
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString(ExceptionManagerStepOS.SUBJECT, "graphics_oom test (" + str2 + ")");
        persistableBundle.putString(ExceptionManagerStepOS.PACKAGE, getPackageName());
        persistableBundle.putString(ExceptionManagerStepOS.PROCESS, getPackageName());
        persistableBundle.putInt(ExceptionManagerStepOS.PID, Process.myPid());
        persistableBundle.putInt(ExceptionManagerStepOS.UID, Process.myUid());
        ExceptionManagerStepOS.reportException(exceptionType, exceptionLevel, persistableBundle);
        printWriter.println("graphics_oom: reported, level=".concat(str2));
    }
}
