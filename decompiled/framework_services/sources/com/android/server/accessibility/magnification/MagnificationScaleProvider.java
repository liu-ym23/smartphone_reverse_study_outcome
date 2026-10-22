package com.android.server.accessibility.magnification;

import android.content.Context;
import android.provider.Settings;
import android.util.MathUtils;
import android.util.SparseArray;
import com.android.internal.accessibility.common.MagnificationConstants;
import com.android.internal.os.BackgroundThread;

/* JADX INFO: loaded from: classes.dex */
public class MagnificationScaleProvider {
    protected static final float DEFAULT_MAGNIFICATION_SCALE = 2.0f;
    public static final float MAX_SCALE = 0.0f;
    public static final float MIN_SCALE = 1.0f;
    private final Context mContext;
    private int mCurrentUserId;
    private final Object mLock;
    private final SparseArray<SparseArray<Float>> mUsersScales;

    public static /* synthetic */ void $r8$lambda$xFOq5u_p0fa3TUXGkenIYejfzP4(MagnificationScaleProvider r0, float r1) {
        r0.lambda$putScale$0(r1);
    }

    static {
        MAX_SCALE = MagnificationConstants.SCALE_MAX_VALUE;
    }

    public MagnificationScaleProvider(Context context) {
        this.mUsersScales = new SparseArray();
        this.mCurrentUserId = 0;
        this.mLock = new Object();
        this.mContext = context;
    }

    void putScale(final float scale, int displayId) {
        if (displayId != 0) goto L4;
        BackgroundThread.getHandler().post(new MagnificationScaleProvider$$ExternalSyntheticLambda0(this, scale));
        return;
    L4:
        Object r0 = this.mLock;
        monitor-enter(r0);
        getScalesWithCurrentUser().put(displayId, Float.valueOf(scale));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$putScale$0(float scale) {
        Settings.Secure.putFloatForUser(this.mContext.getContentResolver(), "accessibility_display_magnification_scale", scale, this.mCurrentUserId);
    }

    float getScale(int displayId) {
        if (displayId == 0) goto L5;
        Object r1 = this.mLock;
        monitor-enter(r1);
        float r0 = getScalesWithCurrentUser().get(displayId, Float.valueOf(DEFAULT_MAGNIFICATION_SCALE)).floatValue();     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return r0;
    L11:
        th = move-exception;
        throw th;
    L5:
        return Settings.Secure.getFloatForUser(this.mContext.getContentResolver(), "accessibility_display_magnification_scale", DEFAULT_MAGNIFICATION_SCALE, this.mCurrentUserId);
    }

    private SparseArray<Float> getScalesWithCurrentUser() {
        SparseArray<Float> scales = this.mUsersScales.get(this.mCurrentUserId);
        if (scales != null) goto L6;
        SparseArray<Float> scales2 = new SparseArray();
        this.mUsersScales.put(this.mCurrentUserId, scales2);
        return scales2;
    L6:
        return scales;
    }

    void onUserChanged(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mCurrentUserId = userId;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void onUserRemoved(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUsersScales.remove(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void onDisplayRemoved(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int userCounts = this.mUsersScales.size();     // Catch: Throwable -> L7
        int i = userCounts - 1;     // Catch: Throwable -> L7
    L5:
        if (i < 0) goto L10;
        this.mUsersScales.get(i).remove(displayId);     // Catch: Throwable -> L7
        i = i - 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public String toString() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String r1 = "MagnificationScaleProvider{mCurrentUserId=" + this.mCurrentUserId + "Scale on the default display=" + getScale(0) + "Scales on non-default displays=" + getScalesWithCurrentUser() + '}';     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    static float constrainScale(float scale) {
        return MathUtils.constrain(scale, 1.0f, MagnificationConstants.SCALE_MAX_VALUE);
    }
}
