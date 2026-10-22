package com.baidu.platform.comapi.bmsdk.animation;

import com.baidu.mapapi.map.TrackAnimationUpdateListener;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGeoElement;
import com.baidu.platform.comapi.bmsdk.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class BmTrackAnimation extends BmAnimation {
    public static final int TRACK_BACKWARD = 64;
    public static final int TRACK_FORWARD = 32;
    public static final int TRACK_MOVE_BACKWARD = 256;
    public static final int TRACK_MOVE_FORWARD = 128;
    public static final int TRACK_NONE = 0;
    public static final int TRACK_X = 1;
    public static final int TRACK_XY = 3;
    public static final int TRACK_Y = 2;
    private static Object sync;
    private static List<WeakReference<BmTrackAnimation>> wkListenerAnimations;
    private b mFromPt;
    private float mFromRadio;
    private b mToPt;
    private float mToRadio;
    private a mTrackListener;
    public TrackAnimationUpdateListener trackAnimationUpdateListener;

    public interface a {
        void a(b r100, float r101, float r102);
    }

    private static native long nativeCreate();

    private static native boolean nativeSetSdkTrack(long r100, long r101);

    private static native boolean nativeSetTrackEndPos(long r100, double r101, double r102);

    private static native boolean nativeSetTrackEndRadio(long r100, float r101);

    private static native boolean nativeSetTrackLine(long r100, long r101);

    private static native boolean nativeSetTrackPath(long r100, long r101);

    private static native boolean nativeSetTrackPos(long r100, double r101, double r102, double r103, double r104);

    private static native boolean nativeSetTrackPosRadio(long r100, float r101, float r102);

    private static native boolean nativeSetTrackUpdateListener(long r100, boolean r101);

    static {
        sync = new Object();
        wkListenerAnimations = new ArrayList();
    }

    public BmTrackAnimation() {
        super(85, nativeCreate());
        this.mTrackListener = null;
        this.trackAnimationUpdateListener = null;
    }

    private static void addAnimation(BmTrackAnimation r100) {
        Object r101 = sync;
        monitor-enter(r101);
        int r102 = wkListenerAnimations.size() - 1;     // Catch: Throwable -> L16
        boolean r103 = false;
    L5:
        if (r102 < 0) goto L12;
        BmTrackAnimation r104 = wkListenerAnimations.get(r102).get();     // Catch: Throwable -> L16
        if (r104 != null) goto L9;
        wkListenerAnimations.remove(r102);     // Catch: Throwable -> L16
    L11:
        r102 = r102 - 1;     // Catch: Throwable -> L16
        goto L5
    L9:
        if (r104 != r100) goto L11;
        r103 = true;
        goto L11
    L12:
        if (r103 == true) goto L14;
        wkListenerAnimations.add(new WeakReference(r100));     // Catch: Throwable -> L16
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private static void removeAnimation(BmTrackAnimation r100) {
        Object r101 = sync;
        monitor-enter(r101);
        int r102 = wkListenerAnimations.size() - 1;     // Catch: Throwable -> L14
    L5:
        if (r102 < 0) goto L12;
        BmTrackAnimation r103 = wkListenerAnimations.get(r102).get();     // Catch: Throwable -> L14
        if (r103 != null) goto L9;
        wkListenerAnimations.remove(r102);     // Catch: Throwable -> L14
    L11:
        r102 = r102 - 1;     // Catch: Throwable -> L14
        goto L5
    L9:
        if (r103 != r100) goto L11;
        wkListenerAnimations.remove(r102);     // Catch: Throwable -> L14
        goto L11
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public boolean setSdkTrack(BmDrawItem r100) {
        if (r100 != null) goto L4;
    L7:
        long r101 = this.nativeInstance;
        if (r100 != null) goto L10;
        long r102 = 0;
    L12:
        return nativeSetSdkTrack(r101, r102);
    L10:
        r102 = r100.getNativeInstance();
        goto L12
    L4:
        if (r100.getObjType() == 25) goto L7;
        return false;
    }

    public void setTrackAnimationUpdateListener(TrackAnimationUpdateListener r100) {
        this.trackAnimationUpdateListener = r100;
    }

    public boolean setTrackLine(BmDrawItem r100) {
        if (r100 == null) goto L11;
        int r101 = r100.getObjType();
        if (r101 == 8) goto L11;
        if (r101 == 9) goto L11;
        if (r101 == 10) goto L11;
        return false;
    L11:
        long r102 = this.nativeInstance;
        if (r100 != null) goto L14;
        long r103 = 0;
    L16:
        return nativeSetTrackLine(r102, r103);
    L14:
        r103 = r100.getNativeInstance();
        goto L16
    }

    public boolean setTrackPath(BmGeoElement r100) {
        long r101 = this.nativeInstance;
        if (r100 != null) goto L5;
        long r102 = 0;
    L7:
        return nativeSetTrackPath(r101, r102);
    L5:
        r102 = r100.getNativeInstance();
        goto L7
    }

    public boolean setTrackPos(b r100) {
        this.mToPt = r100;
        this.mFromRadio = -1.0f;
        this.mToRadio = -1.0f;
        return nativeSetTrackEndPos(this.nativeInstance, r100.f32817a, r100.f32818b);
    }

    public boolean setTrackPosRadio(float r100) {
        this.mToRadio = r100;
        this.mFromPt = null;
        this.mToPt = null;
        return nativeSetTrackEndRadio(this.nativeInstance, r100);
    }

    public boolean setTrackUpdateListener(a r100) {
        this.mTrackListener = r100;
        if (r100 == null) goto L5;
        addAnimation(this);
    L6:
        long r101 = this.nativeInstance;
        if (r100 != null) goto L9;
        boolean r102 = false;
    L11:
        return nativeSetTrackUpdateListener(r101, r102);
    L9:
        r102 = true;
        goto L11
    L5:
        removeAnimation(this);
        goto L6
    }

    public boolean setTrackPos(b r110, b r111) {
        this.mFromPt = r110;
        this.mToPt = r111;
        this.mFromRadio = -1.0f;
        this.mToRadio = -1.0f;
        return nativeSetTrackPos(this.nativeInstance, r110.f32817a, r110.f32818b, r111.f32817a, r111.f32818b);
    }

    public boolean setTrackPosRadio(float r100, float r101) {
        this.mFromRadio = r100;
        this.mToRadio = r101;
        this.mFromPt = null;
        this.mToPt = null;
        return nativeSetTrackPosRadio(this.nativeInstance, r100, r101);
    }

    public static boolean dispatchTrackUpdateListener(long r100, double r101, double r110, float r111, float r112) {
        Object r102 = sync;
        monitor-enter(r102);
        int r103 = wkListenerAnimations.size() - 1;     // Catch: Throwable -> L17
    L5:
        if (r103 < 0) goto L15;
        BmTrackAnimation r104 = wkListenerAnimations.get(r103).get();     // Catch: Throwable -> L17
        if (r104 != null) goto L10;
        wkListenerAnimations.remove(r103);     // Catch: Throwable -> L17
    L14:
        r103 = r103 - 1;     // Catch: Throwable -> L17
        goto L5
    L10:
        if (r104.getNativeInstance() != r100) goto L14;
        a r105 = r104.mTrackListener;     // Catch: Throwable -> L17
        if (r105 == null) goto L14;
        r105.a(new b(r101, r110), r111, r112);     // Catch: Throwable -> L17
        goto L14
    L15:
        monitor-exit(r102);     // Catch: Throwable -> L17
        return true;
    L17:
        th = move-exception;
        throw th;
    }
}
