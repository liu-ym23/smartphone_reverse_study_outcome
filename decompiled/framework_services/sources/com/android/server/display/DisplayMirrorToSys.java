package com.android.server.display;

import android.content.ComponentName;
import android.graphics.Point;
import android.media.AudioManager;
import android.os.IBinder;
import android.util.Slog;
import android.view.Display;
import android.view.InputEvent;
import android.view.PointerIcon;
import com.android.server.wm.ActivityRecord;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayMirrorToSys {
    private Method mActivityRecordGetComponentName;
    private Method mActivityRecordGetPidPublic;
    private Method mDisplayGetMirrorDisplayId;
    private Method mDisplayGetWrapDisplayId;
    private Method mDisplaySetMirrorDisplayId;
    private Method mDisplaySetWrapDisplayId;
    private Method mPointerIconSetMirrorInfo;
    private Method mSetRemotePackage;

    public interface MirrorToATMSCallback {
        void allTaskToDisplay(int r1, int r2, boolean r3);

        void continueStartActivity(boolean r1);

        String getLableOfActivity(ActivityRecord r1);

        int getTopFullTaskId();

        boolean mirrorGameBox(boolean r1, int r2);

        void taskToDisplay(int r1, int r2, boolean r3);
    }

    public interface MirrorToDMSCallback {
        void forceScheduleTraversal();
    }

    public interface MirrorToIMSCallback {
        void getMousePosition(Point r1);

        void injectInputEventWithDeviceId(InputEvent r1, int r2, int r3);

        void reloadPointerIcons();

        void sendMouseCmd(int r1);

        void setMirrorDisplayId(int r1);

        void setMousePosition(int r1, int r2);
    }

    public interface MirrorToWMSCallback {
        void applyRotationAnimationImmediate();

        int getDisplayIdForWindow(IBinder r1);

        ActivityRecord getTopFullActivity(int r1);

        ActivityRecord getTopFullActivityOfDisplay(int r1);
    }

    public DisplayMirrorToSys() {
        this.mActivityRecordGetPidPublic = null;
        this.mActivityRecordGetComponentName = null;
        this.mDisplaySetMirrorDisplayId = null;
        this.mDisplayGetMirrorDisplayId = null;
        this.mDisplaySetWrapDisplayId = null;
        this.mDisplayGetWrapDisplayId = null;
        this.mPointerIconSetMirrorInfo = null;
        this.mSetRemotePackage = null;
        initMethod();
    }

    private void initMethod() {
        this.mActivityRecordGetPidPublic = ActivityRecord.class.getMethod("getPidPublic", new Class[0]);     // Catch: Exception -> L4
        this.mActivityRecordGetComponentName = ActivityRecord.class.getMethod("getComponentName", new Class[0]);     // Catch: Exception -> L4
        this.mDisplaySetMirrorDisplayId = Display.class.getMethod("setMirrorDisplayId", new Class[]{Integer.TYPE});     // Catch: Exception -> L4
        this.mDisplayGetMirrorDisplayId = Display.class.getMethod("getMirrorDisplayId", new Class[0]);     // Catch: Exception -> L4
        this.mDisplaySetWrapDisplayId = Display.class.getMethod("setWrapDisplayId", new Class[]{Integer.TYPE});     // Catch: Exception -> L4
        this.mDisplayGetWrapDisplayId = Display.class.getMethod("getWrapDisplayId", new Class[0]);     // Catch: Exception -> L4
        this.mPointerIconSetMirrorInfo = PointerIcon.class.getMethod("setMirrorInfo", new Class[]{Integer.TYPE, Integer.TYPE});     // Catch: Exception -> L4
        this.mSetRemotePackage = AudioManager.class.getMethod("setRemotePackage", new Class[]{String.class});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public int getPidPublic(ActivityRecord r) {
        if (this.mActivityRecordGetPidPublic != null) goto L10;
        return -1;
    L10:
        return ((Integer) this.mActivityRecordGetPidPublic.invoke(r, new Object[0])).intValue();
    L7:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    public ComponentName getComponentName(ActivityRecord r) {
        if (this.mActivityRecordGetComponentName != null) goto L10;
        return null;
    L10:
        return (ComponentName) this.mActivityRecordGetComponentName.invoke(r, new Object[0]);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public void setMirrorDisplayIdToDisplay(int displayId) {
        if (this.mDisplaySetMirrorDisplayId != null) goto L10;
        return;
    L10:
        this.mDisplaySetMirrorDisplayId.invoke(null, new Object[]{Integer.valueOf(displayId)});     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public int getMirrorDisplayIdToDisplay() {
        if (this.mDisplayGetMirrorDisplayId != null) goto L10;
        return -1;
    L10:
        return ((Integer) this.mDisplayGetMirrorDisplayId.invoke(null, new Object[0])).intValue();
    L7:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    public void setWrapDisplayIdToDisplay(int displayId) {
        if (this.mDisplaySetWrapDisplayId != null) goto L10;
        return;
    L10:
        this.mDisplaySetWrapDisplayId.invoke(null, new Object[]{Integer.valueOf(displayId)});     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public int getWrapDisplayIdToDisplay() {
        if (this.mDisplayGetWrapDisplayId != null) goto L10;
        return -1;
    L10:
        return ((Integer) this.mDisplayGetWrapDisplayId.invoke(null, new Object[0])).intValue();
    L7:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    public void setMirrorInfoToPointerIcon(int displayId, int scale) {
        if (this.mPointerIconSetMirrorInfo != null) goto L10;
        return;
    L10:
        this.mPointerIconSetMirrorInfo.invoke(null, new Object[]{Integer.valueOf(displayId), Integer.valueOf(scale)});     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public void setRemotePackage(AudioManager audioManager, String packageName) {
        if (this.mSetRemotePackage != null) goto L11;
        Slog.e("NDMCtrl", "setRemotePackage null");
        return;
    L11:
        this.mSetRemotePackage.invoke(audioManager, new Object[]{packageName});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }
}
