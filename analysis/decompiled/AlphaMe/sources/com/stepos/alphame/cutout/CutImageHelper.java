package com.stepos.alphame.cutout;

import B0.g;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.RuleUpdater;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.NamedThreadFactory;
import com.stepos.alphame.utils.NetworkHelper;
import com.stepos.alphame.utils.Property;
import com.stepos.alphame.utils.ThreadPool;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class CutImageHelper {
    private static final long CUT_RELEASE_TIME = 1800000;
    private static final int MSG_RELEASE = 0;
    public static final String PACKAGE_NAME_GALLERY = "com.stepos.media.gallery";
    public static final String PACKAGE_NAME_PICKER = "com.stepos.picker";
    private static final String SEG_MODEL_DIR = "seg_model";
    private static final String SEG_MODEL_NAME = "seg_model.mnn";
    private static final String TAG = "CutImageHelper";
    private static WeakReference<CutImageBinder> mBitmapCacheGallery = null;
    private static WeakReference<CutImageBinder> mBitmapCachePicker = null;
    private static final Handler mHandler;
    private static boolean mInit = false;
    private static final ExecutorService POOL = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("cut-single"));
    private static final ConcurrentHashMap<String, Integer> mReferenceMap = new ConcurrentHashMap<>();

    public static class Instance {
        private static CutImageHelper INSTANCE = new CutImageHelper();

        private Instance() {
        }
    }

    public class UpdaterJob implements ThreadPool.Job<Boolean> {
        public /* synthetic */ UpdaterJob(CutImageHelper cutImageHelper, int i4) {
            this();
        }

        private UpdaterJob() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.stepos.alphame.utils.ThreadPool.Job
        public Boolean run() {
            AlphaMeLogger.wLog("CutImageHelper, UpdaterJob download start");
            RuleUpdater.getInstance().updateEx(NetworkHelper.isWifiNetwork(ApplicationImpl.getApplication()) ? 1 : 0);
            return Boolean.TRUE;
        }
    }

    static {
        Log.i(TAG, "cut handThread instance");
        HandlerThread handlerThread = new HandlerThread("cutImage");
        handlerThread.start();
        mHandler = new Handler(handlerThread.getLooper()) { // from class: com.stepos.alphame.cutout.CutImageHelper.1
            @Override // android.os.Handler
            public void handleMessage(@NonNull Message message) {
                AlphaMeLogger.debugLog(CutImageHelper.TAG, "handle msg " + message.what);
                if (message.what != 0) {
                    return;
                }
                CutImageHelper.releaseCutImage();
            }
        };
    }

    public static CutImageHelper getInstance() {
        return Instance.INSTANCE;
    }

    private void put(String str) {
        try {
            ConcurrentHashMap<String, Integer> concurrentHashMap = mReferenceMap;
            if (concurrentHashMap.containsKey(str)) {
                concurrentHashMap.put(str, Integer.valueOf(concurrentHashMap.get(str).intValue() + 1));
            } else {
                concurrentHashMap.put(str, 1);
            }
            AlphaMeLogger.debugLog(TAG, "put " + str + " size " + concurrentHashMap.get(str));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void releaseCutImage() {
        runTaskAndWait(new Callable<Void>() { // from class: com.stepos.alphame.cutout.CutImageHelper.2
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                AlphaMeLogger.debugLog(CutImageHelper.TAG, "delay release " + Thread.currentThread().getName());
                return null;
            }
        });
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i4) {
        if (i4 == 0) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postRotate(i4);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    private static <T> T runTaskAndWait(Callable<T> callable) {
        try {
            return POOL.submit(callable).get();
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean saveToImageBinder(Bitmap bitmap, String str) {
        if (PACKAGE_NAME_GALLERY.equals(str)) {
            CutImageBinder cutImageBinder = new CutImageBinder();
            cutImageBinder.insert(bitmap, str);
            mBitmapCacheGallery = new WeakReference<>(cutImageBinder);
            return true;
        }
        if (!PACKAGE_NAME_PICKER.equals(str)) {
            return false;
        }
        CutImageBinder cutImageBinder2 = new CutImageBinder();
        cutImageBinder2.insert(bitmap, str);
        mBitmapCachePicker = new WeakReference<>(cutImageBinder2);
        return true;
    }

    private static void sendCutReleaseDelayMsg() {
        Handler handler = mHandler;
        if (handler != null) {
            AlphaMeLogger.debugLog(TAG, "send cut release delay msg");
            handler.removeMessages(0);
            handler.sendMessageDelayed(Message.obtain(handler, 0), 1800000L);
        }
    }

    public String cutImage(String str, String str2, int i4) {
        StringBuilder sbX = g.x("cutImage fromApp: ", str2, " bitmapUri: ", str, " rotateAngle: ");
        sbX.append(i4);
        AlphaMeLogger.debugLog(TAG, sbX.toString());
        if (!mInit) {
            if (!hasModelFile()) {
                AlphaMeLogger.debugLog(TAG, "cutImage download start");
                ThreadPool.getInstance().submit(new UpdaterJob(this, 0));
                return null;
            }
            AlphaMeLogger.debugLog(TAG, "cutImage init start");
            init(str2);
            if (!mInit) {
                AlphaMeLogger.debugLog(TAG, "cutImage init error");
                return null;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            return (String) runTaskAndWait(new Callable<String>() { // from class: com.stepos.alphame.cutout.CutImageHelper.4
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return null;
                }
            });
        }
        AlphaMeLogger.debugLog(TAG, "cutImage bitmapUri empty");
        return null;
    }

    public IBinder getCutImage(String str) {
        WeakReference<CutImageBinder> weakReference;
        sendCutReleaseDelayMsg();
        if (PACKAGE_NAME_GALLERY.equals(str)) {
            WeakReference<CutImageBinder> weakReference2 = mBitmapCacheGallery;
            if (weakReference2 != null) {
                return weakReference2.get();
            }
            return null;
        }
        if (!PACKAGE_NAME_PICKER.equals(str) || (weakReference = mBitmapCachePicker) == null) {
            return null;
        }
        return weakReference.get();
    }

    public String getModelDir() {
        File file = new File(ApplicationImpl.getApplication().getCacheDir(), SEG_MODEL_DIR);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public String getModelFilePath() {
        StringBuilder sb = new StringBuilder();
        sb.append(getModelDir());
        return g.r(sb, File.separator, SEG_MODEL_NAME);
    }

    public String getZipFile() {
        StringBuilder sb = new StringBuilder();
        sb.append(getModelDir());
        return g.r(sb, File.separator, "seg_model.zip");
    }

    public boolean hasModelDir() {
        return new File(getZipFile()).exists();
    }

    public boolean hasModelFile() {
        return new File(getModelFilePath()).exists();
    }

    public synchronized boolean init(@NonNull String str) {
        AlphaMeLogger.debugLog(TAG, "CutImageHelper, init start, callee: " + str);
        if (!hasModelFile()) {
            AlphaMeLogger.debugLog(TAG, "init error, model file not exist");
            mInit = false;
            Property.setCutImageVersion("");
            ThreadPool.getInstance().submit(new UpdaterJob(this, 0));
            return false;
        }
        if (mInit) {
            AlphaMeLogger.wLog("CutImageHelper, init ignore");
        } else {
            String modelFilePath = getModelFilePath();
            long jCurrentTimeMillis = System.currentTimeMillis();
            AlphaMeLogger.debugLog(TAG, "init start, modelFilePath: " + modelFilePath);
            runTaskAndWait(new Callable<Void>() { // from class: com.stepos.alphame.cutout.CutImageHelper.3
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    AlphaMeLogger.debugLog(CutImageHelper.TAG, " init thread " + Thread.currentThread().getName());
                    return null;
                }
            });
            AlphaMeLogger.debugLog(TAG, "init end, result: " + mInit + " cost " + (System.currentTimeMillis() - jCurrentTimeMillis));
        }
        put(str);
        return mInit;
    }

    public synchronized void release(@NonNull String str) {
        try {
            Log.i(TAG, "thread " + Thread.currentThread().getName());
            try {
                ConcurrentHashMap<String, Integer> concurrentHashMap = mReferenceMap;
                if (concurrentHashMap.size() > 0) {
                    int iIntValue = concurrentHashMap.get(str).intValue();
                    int i4 = iIntValue - 1;
                    if (i4 == 0) {
                        concurrentHashMap.remove(str);
                    } else {
                        concurrentHashMap.put(str, Integer.valueOf(i4));
                    }
                    AlphaMeLogger.debugLog(TAG, "remove " + str + " size " + iIntValue);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
