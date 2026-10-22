package com.baidu.platform.comapi.bmsdk;

import androidx.camera.video.AudioStats;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyleOption;
import com.baidu.platform.comapi.bmsdk.style.BmTrackStyle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class BmGeoElement extends BmObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f32769a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f32770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BmLineStyle f32771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BmTrackStyle f32772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<b> f32773e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f32774f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f32775g;

    public BmGeoElement() {
        super(70, nativeCreate(0));
        this.f32773e = new ArrayList();
        this.f32770b = 0;
    }

    private static native boolean nativeAddPoint(long r100, double r101, double r102, double r103);

    private static native boolean nativeAddStyleOption(long r100, long r101);

    private static native boolean nativeClearGradientColors(long r100);

    private static native long nativeCreate(int r100);

    private static native boolean nativeDelGradientColors(long r100, int r101);

    private static native boolean nativeRemoveStyleOption(long r100, long r101);

    private static native boolean nativeSetCoordChainHandle(long r100, long r101);

    private static native boolean nativeSetCoordChainType(long r100, int r101);

    private static native boolean nativeSetGradientColors(long r100, int r101, int[] r102, int r103);

    private static native boolean nativeSetPoints(long r100, double[] r101, int r102, int r103);

    private static native boolean nativeSetStyle(long r100, long r101);

    private static native boolean nativeSetTrackStyle(long r100, long r101);

    static {
        f32769a = true;
    }

    @Override // com.baidu.platform.comapi.bmsdk.BmObject, java.lang.AutoCloseable
    public void close() throws Exception {
        super.close();
        BmLineStyle r100 = this.f32771c;
        if (r100 != null) goto L13;
    L6:
        BmTrackStyle r101 = this.f32772d;
        if (r101 == null) goto L17;
        r101.close();     // Catch: Exception -> L11
    L9:
        this.f32772d = null;
        return;
    L17:
        return;
    L13:
        r100.close();     // Catch: Exception -> L12
    L5:
        this.f32771c = null;
        goto L6
    }

    public BmGeoElement(int r100) {
        super(70, nativeCreate(r100));
        this.f32773e = new ArrayList();
        this.f32770b = r100;
    }

    public boolean a(List<b> r100) {
        this.f32773e.clear();
        this.f32773e.addAll(r100);
        int r101 = 0;
        if (r100 != null) goto L5;
    L11:
        double[] r102 = null;
    L13:
        return nativeSetPoints(getNativeInstance(), r102, r101, 2);
    L5:
        if (r100.size() <= 0) goto L11;
        int r103 = r100.size() * 2;
        r102 = new double[r103];
    L8:
        if (r101 >= r100.size()) goto L10;
        int r104 = r101 * 2;
        r102[r104] = ((b) ListProtector.get(r100, r101)).f32817a;
        r102[r104 + 1] = ((b) ListProtector.get(r100, r101)).f32818b;
        r101 = r101 + 1;
        goto L8
    L10:
        r101 = r103;
        goto L13
    }

    public boolean b(List<b> r110) {
        this.f32773e.clear();
        this.f32773e.addAll(r110);
        int r100 = 0;
        if (r110 != null) goto L5;
    L14:
        double[] r101 = null;
    L16:
        if (f32769a == true) goto L22;
        if (r101 != null) goto L22;
        throw new AssertionError();
    L22:
        return nativeSetPoints(getNativeInstance(), r101, r100, 3);
    L5:
        if (r110.size() <= 0) goto L14;
        int r102 = r110.size() * 3;
        r101 = new double[r102];
        int r103 = 0;
    L8:
        if (r103 >= r110.size()) goto L13;
        int r104 = r103 * 3;
        r101[r104] = ((b) ListProtector.get(r110, r103)).f32817a;
        r101[r104 + 1] = ((b) ListProtector.get(r110, r103)).f32818b;
        r101[r104 + 2] = ((b) ListProtector.get(r110, r103)).f32819c;
        if (((b) ListProtector.get(r110, r103)).f32819c < AudioStats.AUDIO_AMPLITUDE_NONE) goto L11;
        r103 = r103 + 1;
        goto L8
    L11:
        return false;
    L13:
        r100 = r102;
        goto L16
    }

    public boolean a(BmLineStyle r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        BmLineStyle r101 = this.f32771c;
        if (r101 != null) goto L8;
    L10:
        this.f32771c = r100;
        return nativeSetStyle(getNativeInstance(), r100.getNativeInstance());
    L8:
        if (r101.getNativeInstance() == r100.getNativeInstance()) goto L10;
        this.f32771c.close();     // Catch: Exception -> L12
        goto L10
    }

    public boolean a(BmTrackStyle r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        BmTrackStyle r101 = this.f32772d;
        if (r101 != null) goto L8;
    L10:
        this.f32772d = r100;
        return nativeSetTrackStyle(getNativeInstance(), r100.getNativeInstance());
    L8:
        if (r101.getNativeInstance() == r100.getNativeInstance()) goto L10;
        this.f32772d.close();     // Catch: Exception -> L12
        goto L10
    }

    public boolean a(BmLineStyleOption r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return nativeAddStyleOption(getNativeInstance(), r100.getNativeInstance());
    }

    public void a(int r100) {
        this.f32775g = r100;
    }

    public void a(String r100) {
        this.f32774f = r100;
    }

    public boolean a(int r100, List<Integer> r101) {
        int r102 = 0;
        if (r101 != null) goto L5;
    L10:
        int[] r103 = null;
    L12:
        return nativeSetGradientColors(getNativeInstance(), r100, r103, r102);
    L5:
        if (r101.size() <= 0) goto L10;
        r103 = new int[r101.size()];
        Iterator<Integer> r104 = r101.iterator();
    L8:
        if (r104.hasNext() == false) goto L12;
        r103[r102] = com.baidu.platform.comapi.bmsdk.style.a.a(r104.next().intValue());
        r102 = r102 + 1;
        goto L8
    }
}
