package com.autonavi.base.ae.gmap.gloverlay;

import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public abstract class GLOverlay {
    protected boolean isNightStyle;
    protected int mCode;
    protected int mEngineID;
    protected IAMapDelegate mGLMapView;
    boolean mIsInBundle;
    protected int mItemPriority;
    protected long mNativeInstance;

    public static final enum EAMapOverlayTpye extends Enum<EAMapOverlayTpye> {
        private static final /* synthetic */ EAMapOverlayTpye[] $VALUES = null;
        public static final EAMapOverlayTpye AMAPOVERLAY_ARROW = null;
        public static final EAMapOverlayTpye AMAPOVERLAY_VECTOR = null;
        public static final EAMapOverlayTpye AMAPROUTE_OVERLAY = null;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private int f30033id;

        static {
            EAMapOverlayTpye r100 = new EAMapOverlayTpye("AMAPOVERLAY_ARROW", 0, 4);
            AMAPOVERLAY_ARROW = r100;
            EAMapOverlayTpye r101 = new EAMapOverlayTpye("AMAPOVERLAY_VECTOR", 1, 5);
            AMAPOVERLAY_VECTOR = r101;
            EAMapOverlayTpye r102 = new EAMapOverlayTpye("AMAPROUTE_OVERLAY", 2, 16);
            AMAPROUTE_OVERLAY = r102;
            $VALUES = new EAMapOverlayTpye[]{r100, r101, r102};
        }

        public static EAMapOverlayTpye[] values() {
            return (EAMapOverlayTpye[]) $VALUES.clone();
        }

        public int getId() {
            return this.f30033id;
        }

        public static EAMapOverlayTpye valueOf(String r100) {
            return (EAMapOverlayTpye) a.a(EAMapOverlayTpye.class, r100);
        }

        private EAMapOverlayTpye(String r100, int r101, int r102) {
            super(r100, r101);
            this.f30033id = r102;
        }
    }

    private static native int nativeGetCount(long r100);

    private static native int nativeGetOverlayPriority(long r100);

    private static native int nativeGetSubType(long r100);

    private static native int nativeGetType(long r100);

    private static native boolean nativeIsClickable(long r100);

    private static native boolean nativeIsVisible(long r100);

    private static native void nativeRemoveAll(long r100);

    private static native void nativeRemoveItem(long r100, int r101);

    private static native void nativeSetClickable(long r100, boolean r101);

    private static native void nativeSetMaxDisplayLevel(long r100, float r101);

    private static native void nativeSetMinDisplayLevel(long r100, float r101);

    private static native void nativeSetOverlayOnTop(long r100, boolean r101);

    private static native void nativeSetOverlayPriority(long r100, int r101);

    private static native void nativeSetOverlayPriorityOnly(long r100, int r101);

    public static native void nativeSetVisible(long r100, boolean r101);

    public void clearFocus() {
    }

    public int getOverlayPriority() {
        return nativeGetOverlayPriority(this.mNativeInstance);
    }

    public int getSize() {
        long r100 = this.mNativeInstance;
        if (r100 != 0) goto L7;
        return 0;
    L7:
        return nativeGetCount(r100);
    }

    public int getSubType() {
        long r100 = this.mNativeInstance;
        if (r100 != 0) goto L7;
        return -1;
    L7:
        return nativeGetSubType(r100);
    }

    public int getType() {
        long r100 = this.mNativeInstance;
        if (r100 != 0) goto L7;
        return -1;
    L7:
        return nativeGetType(r100);
    }

    public boolean isClickable() {
        long r100 = this.mNativeInstance;
        if (r100 != 0) goto L7;
        return false;
    L7:
        return nativeIsClickable(r100);
    }

    public boolean isVisible() {
        long r100 = this.mNativeInstance;
        if (r100 != 0) goto L7;
        return false;
    L7:
        return nativeIsVisible(r100);
    }

    public void releaseInstance() {
        if (this.mNativeInstance == 0) goto L6;
        this.mNativeInstance = 0;
        return;
    }

    public void removeAll() {
        long r100 = this.mNativeInstance;
        if (r100 != 0) goto L5;
        return;
    L5:
        nativeRemoveAll(r100);
    }

    public int getCode() {
        return this.mCode;
    }

    public boolean getIsInBundle() {
        return this.mIsInBundle;
    }

    public long getNativeInstatnce() {
        return this.mNativeInstance;
    }

    public void removeItem(int r100) {
        long r101 = this.mNativeInstance;
        if (r101 != 0) goto L5;
        return;
    L5:
        nativeRemoveItem(r101, r100);
    }

    public void setClickable(boolean r100) {
        long r101 = this.mNativeInstance;
        if (r101 != 0) goto L5;
        return;
    L5:
        nativeSetClickable(r101, r100);
    }

    public void setMaxDisplayLevel(float r100) {
        nativeSetMaxDisplayLevel(this.mNativeInstance, r100);
    }

    public void setMinDisplayLevel(float r100) {
        nativeSetMinDisplayLevel(this.mNativeInstance, r100);
    }

    public void setOverlayItemPriority(int r100) {
        this.mItemPriority = r100;
    }

    public void setOverlayOnTop(boolean r100) {
        nativeSetOverlayOnTop(this.mNativeInstance, r100);
    }

    public void setOverlayPriority(int r100) {
        nativeSetOverlayPriority(this.mNativeInstance, r100);
        IAMapDelegate r101 = this.mGLMapView;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getGLMapEngine() == null) goto L11;
        GLOverlayBundle r102 = this.mGLMapView.getGLMapEngine().getOverlayBundle(this.mEngineID);
        if (r102 == null) goto L12;
        r102.sortOverlay();
        return;
    L12:
        return;
    }

    public void setOverlayPriorityOnly(int r100) {
        long r101 = this.mNativeInstance;
        if (r101 != 0) goto L5;
        return;
    L5:
        nativeSetOverlayPriorityOnly(r101, r100);
    }

    public void setVisible(boolean r100) {
        long r101 = this.mNativeInstance;
        if (r101 != 0) goto L5;
        return;
    L5:
        nativeSetVisible(r101, r100);
    }

    public void useNightStyle(boolean r100) {
        this.isNightStyle = r100;
    }

    public GLOverlay(int r100, IAMapDelegate r101, int r102) {
        this.isNightStyle = false;
        this.mIsInBundle = false;
        this.mEngineID = r100;
        this.mGLMapView = r101;
        this.mCode = r102;
        this.mNativeInstance = 0;
        this.mItemPriority = 0;
    }
}
