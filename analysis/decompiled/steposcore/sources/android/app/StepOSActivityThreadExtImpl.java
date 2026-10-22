package android.app;

import android.app.ActivityThread;
import android.app.asyncinflate.AsyncInflateStub;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemProperties;
import android.util.Slog;
import com.stepos.dylog.ReflectDynamicalLogHelper;
import com.stepos.dylog.SurfaceControlDynamicalLogHelper;
import com.stepos.feature.StepOSFeature;
import com.stepos.internal.picker.UrlCapture;
import java.util.List;

/* loaded from: classes.dex */
public class StepOSActivityThreadExtImpl implements IStepOSActivityThreadExt {
    private static final String TAG = "StepOSActivityThreadExtImpl";
    private ActivityThread mHost;
    public static boolean mDoFrameOptEnable = SystemProperties.getBoolean("persist.debug.frameopt.enable", true);
    public static boolean mAppDoFrameOptEnable = false;

    public void setAppDoFrameOptEnable(boolean r) {
        mAppDoFrameOptEnable = r;
    }

    public void onAttach(ActivityThread host) {
        this.mHost = host;
    }

    public void onDispatchMessage(Message msg) {
    }

    public void fillAssistContextExtras(Activity activity, int requestType, Bundle data) {
        if (StepOSFeature.STEPOS_FEATURE_GLOBAL_DRAG && requestType == 10) {
            UrlCapture.fillInfo(data, activity);
        }
    }

    public void setActivityName(Context activityContext, String activityName) {
        AsyncInflateStub.get().setActivityName(activityContext, activityName);
    }

    public void setTheme(int theme) {
        AsyncInflateStub.get().setTheme(theme);
    }

    public void onFinished(String activityName) {
        AsyncInflateStub.get().finished(activityName);
    }

    public void onDestroy(ActivityThread.ActivityClientRecord r) {
        String targetActivity = null;
        if (r.activityInfo.targetActivity != null) {
            targetActivity = r.activityInfo.targetActivity;
        } else {
            ComponentName componentName = r.intent != null ? r.intent.getComponent() : null;
            if (componentName != null) {
                targetActivity = componentName.getClassName();
            }
        }
        if (targetActivity != null) {
            AsyncInflateStub.get().destroy(targetActivity);
        }
    }

    public void onBindApplication(Context appContext) {
        AsyncInflateStub.get().init(appContext);
    }

    public void setDynamicalLog(String className, List<String> fields, boolean value) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException {
        try {
            Class<?> clazz = Class.forName(className);
            ReflectDynamicalLogHelper.setDynamicalConfig(clazz, fields, value);
            Slog.d(TAG, "setDynamicalLog: className=" + className + ", fields=" + fields + ", value=" + value);
        } catch (ClassNotFoundException e) {
            Slog.e(TAG, "setDynamicalLog ClassNotFoundException: " + e);
        }
    }

    public void setDynamicalLogSurfaceControl(String matchCall) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException {
        SurfaceControlDynamicalLogHelper.apply(matchCall);
        Slog.d(TAG, "setDynamicalLogSurfaceControl: matchCall=" + matchCall);
    }

    public void setApexService(Intent intent) {
        StepOSViewCaptureManager.getInstance().setApexService(intent);
    }

    public void notifyActivityLifecycle(Activity activity, int event) {
        StepOSViewCaptureManager.getInstance().notifyActivityLifecycle(activity, event);
    }

    public void notifyActivityResumed(Activity activity) {
        StepOSViewCaptureManager.getInstance().notifyActivityResumed(activity);
    }
}
