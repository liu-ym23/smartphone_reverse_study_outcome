package com.baidu.platform.comapi.bmsdk;

import androidx.camera.video.AudioStats;
import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import com.baidu.platform.comapi.bmsdk.ui.BmRichView;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes39.dex */
public abstract class BmBaseMarker extends BmDrawItem {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private double f32746i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private double f32747j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private double f32748k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f32749l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f32750m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f32751n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f32752o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f32753p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f32754q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f32755r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f32756s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f32757t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f32758u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ArrayList<BmRichView> f32759v;

    private BmBaseMarker() {
        super(3, 0);
        this.f32746i = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f32747j = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f32748k = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f32749l = 0;
        this.f32750m = 0;
        this.f32751n = 0;
        this.f32752o = 0.0f;
        this.f32753p = 1.0f;
        this.f32754q = 1.0f;
        this.f32755r = 1.0f;
        this.f32756s = "";
        this.f32757t = "";
        this.f32758u = "";
        this.f32759v = new ArrayList();
    }

    private static native boolean nativeAddRichView(long r100, long r101);

    private static native boolean nativeClearRichViews(long r100);

    private static native boolean nativeRemoveRichView(long r100, long r101);

    private static native boolean nativeSetAnchorX(long r100, float r101);

    private static native boolean nativeSetAnchorY(long r100, float r101);

    private static native boolean nativeSetBuildingId(long r100, String r101);

    private static native boolean nativeSetCollisionBehavior(long r100, int r101);

    private static native boolean nativeSetCollisionPriority(long r100, int r101);

    private static native boolean nativeSetDrawFullscreenMaskFlag(long r100, boolean r101);

    private static native boolean nativeSetFixX(long r100, int r101);

    private static native boolean nativeSetFixY(long r100, int r101);

    private static native boolean nativeSetFloorId(long r100, String r101);

    private static native boolean nativeSetFollowMapRotateAxis(long r100, int r101);

    private static native boolean nativeSetHeight(long r100, int r101);

    private static native boolean nativeSetId(long r100, String r101);

    private static native boolean nativeSetIsFix(long r100, int r101);

    private static native boolean nativeSetLocated(long r100, int r101);

    private static native boolean nativeSetOffsetX(long r100, int r101, int r102);

    private static native boolean nativeSetOffsetY(long r100, int r101, int r102);

    private static native boolean nativeSetPerspective(long r100, int r101);

    private static native boolean nativeSetRotate(long r100, float r101);

    private static native boolean nativeSetRotateFeature(long r100, int r101);

    private static native boolean nativeSetScale(long r100, float r101);

    private static native boolean nativeSetScaleX(long r100, float r101);

    private static native boolean nativeSetScaleY(long r100, float r101);

    private static native boolean nativeSetTrackBy(long r100, int r101);

    private static native boolean nativeSetWidth(long r100, int r101);

    private static native boolean nativeSetX(long r100, double r101);

    private static native boolean nativeSetXYZ(long r100, double r101, double r102, double r103);

    private static native boolean nativeSetY(long r100, double r101);

    private static native boolean nativeSetZ(long r100, double r101);

    public boolean c() {
        this.f32759v.clear();
        return nativeClearRichViews(getNativeInstance());
    }

    public boolean a(b r110) {
        this.f32746i = r110.f32817a;
        this.f32747j = r110.f32818b;
        this.f32748k = r110.f32819c;
        return nativeSetXYZ(getNativeInstance(), this.f32746i, this.f32747j, this.f32748k);
    }

    public BmBaseUI b(long r100) {
        if (r100 == 0) goto L10;
        Iterator<BmRichView> r101 = this.f32759v.iterator();
    L6:
        if (r101.hasNext() == false) goto L15;
        BmBaseUI r102 = r101.next().a(r100);
        if (r102 == null) goto L6;
        return r102;
    L15:
        return null;
    L10:
        return null;
    }

    public boolean c(float r100) {
        return nativeSetAnchorY(getNativeInstance(), r100);
    }

    public boolean d(float r100) {
        this.f32752o = r100;
        return nativeSetRotate(getNativeInstance(), r100);
    }

    public boolean e(float r100) {
        this.f32753p = r100;
        this.f32754q = r100;
        return nativeSetScale(getNativeInstance(), r100);
    }

    public boolean f(int r100) {
        long r101 = getNativeInstance();
        if (r100 >= 0) goto L6;
        r100 = 0;
    L6:
        return nativeSetCollisionPriority(r101, r100);
    }

    public boolean g(float r100) {
        this.f32754q = r100;
        return nativeSetScaleY(getNativeInstance(), r100);
    }

    public boolean h(int r100) {
        return nativeSetFixY(getNativeInstance(), r100);
    }

    public boolean i(int r100) {
        return nativeSetFollowMapRotateAxis(getNativeInstance(), r100);
    }

    public boolean j(int r100) {
        return nativeSetIsFix(getNativeInstance(), r100);
    }

    public boolean k(int r100) {
        this.f32749l = r100;
        return nativeSetLocated(getNativeInstance(), r100);
    }

    public boolean l(int r100) {
        return a(r100, d.f32821a);
    }

    public boolean m(int r100) {
        return b(r100, d.f32821a);
    }

    public boolean n(int r100) {
        return nativeSetPerspective(getNativeInstance(), r100);
    }

    public boolean a(BmRichView r100) {
        this.f32759v.add(r100);
        return nativeAddRichView(getNativeInstance(), r100.getNativeInstance());
    }

    public boolean b(BmRichView r100) {
        this.f32759v.remove(r100);
        return nativeRemoveRichView(getNativeInstance(), r100.getNativeInstance());
    }

    public boolean e(int r100) {
        return nativeSetCollisionBehavior(getNativeInstance(), r100);
    }

    public boolean f(float r100) {
        this.f32753p = r100;
        return nativeSetScaleX(getNativeInstance(), r100);
    }

    public boolean g(int r100) {
        return nativeSetFixX(getNativeInstance(), r100);
    }

    public boolean a(String r100) {
        return nativeSetId(getNativeInstance(), r100);
    }

    public boolean b(float r100) {
        return nativeSetAnchorX(getNativeInstance(), r100);
    }

    public BmBaseMarker(int r100, long r101) {
        super(r100, r101);
        this.f32746i = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f32747j = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f32748k = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f32749l = 0;
        this.f32750m = 0;
        this.f32751n = 0;
        this.f32752o = 0.0f;
        this.f32753p = 1.0f;
        this.f32754q = 1.0f;
        this.f32755r = 1.0f;
        this.f32756s = "";
        this.f32757t = "";
        this.f32758u = "";
        this.f32759v = new ArrayList();
    }

    public boolean a(int r100, d r101) {
        this.f32750m = r100;
        return nativeSetOffsetX(getNativeInstance(), r100, r101.a());
    }

    public boolean b(int r100, d r101) {
        this.f32751n = r100;
        return nativeSetOffsetY(getNativeInstance(), r100, r101.a());
    }
}
