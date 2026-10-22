package com.baidu.platform.comapi.bmsdk;

import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyleOption;
import com.baidu.platform.comapi.bmsdk.style.BmTrackStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class BmGeoElement extends BmObject {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f8631a = true;

    /* renamed from: b, reason: collision with root package name */
    private final int f8632b;

    /* renamed from: c, reason: collision with root package name */
    private BmLineStyle f8633c;

    /* renamed from: d, reason: collision with root package name */
    private BmTrackStyle f8634d;

    /* renamed from: e, reason: collision with root package name */
    private List<b> f8635e;

    /* renamed from: f, reason: collision with root package name */
    private String f8636f;

    /* renamed from: g, reason: collision with root package name */
    private int f8637g;

    public BmGeoElement() {
        super(70, nativeCreate(0));
        this.f8635e = new ArrayList();
        this.f8632b = 0;
    }

    private static native boolean nativeAddPoint(long j4, double d4, double d5, double d6);

    private static native boolean nativeAddStyleOption(long j4, long j5);

    private static native boolean nativeClearGradientColors(long j4);

    private static native long nativeCreate(int i4);

    private static native boolean nativeDelGradientColors(long j4, int i4);

    private static native boolean nativeRemoveStyleOption(long j4, long j5);

    private static native boolean nativeSetCoordChainHandle(long j4, long j5);

    private static native boolean nativeSetCoordChainType(long j4, int i4);

    private static native boolean nativeSetGradientColors(long j4, int i4, int[] iArr, int i5);

    private static native boolean nativeSetPoints(long j4, double[] dArr, int i4, int i5);

    private static native boolean nativeSetStyle(long j4, long j5);

    private static native boolean nativeSetTrackStyle(long j4, long j5);

    public boolean a(BmLineStyle bmLineStyle) {
        this.f8633c = bmLineStyle;
        return nativeSetStyle(this.nativeInstance, bmLineStyle.getNativeInstance());
    }

    public boolean b(List<b> list) {
        double[] dArr;
        this.f8635e.clear();
        this.f8635e.addAll(list);
        int i4 = 0;
        if (list == null || list.size() <= 0) {
            dArr = null;
        } else {
            int size = list.size() * 3;
            dArr = new double[size];
            for (int i5 = 0; i5 < list.size(); i5++) {
                int i6 = i5 * 3;
                dArr[i6] = list.get(i5).f8679a;
                dArr[i6 + 1] = list.get(i5).f8680b;
                dArr[i6 + 2] = list.get(i5).f8681c;
                if (list.get(i5).f8681c < 0.0d) {
                    return false;
                }
            }
            i4 = size;
        }
        if (f8631a || dArr != null) {
            return nativeSetPoints(this.nativeInstance, dArr, i4, 3);
        }
        throw new AssertionError();
    }

    public boolean a(BmTrackStyle bmTrackStyle) {
        this.f8634d = bmTrackStyle;
        return nativeSetTrackStyle(this.nativeInstance, bmTrackStyle.getNativeInstance());
    }

    public BmGeoElement(int i4) {
        super(70, nativeCreate(i4));
        this.f8635e = new ArrayList();
        this.f8632b = i4;
    }

    public boolean a(BmLineStyleOption bmLineStyleOption) {
        if (bmLineStyleOption == null) {
            return false;
        }
        return nativeAddStyleOption(this.nativeInstance, bmLineStyleOption.getNativeInstance());
    }

    public boolean a(List<b> list) {
        double[] dArr;
        this.f8635e.clear();
        this.f8635e.addAll(list);
        int i4 = 0;
        if (list == null || list.size() <= 0) {
            dArr = null;
        } else {
            int size = list.size() * 2;
            dArr = new double[size];
            while (i4 < list.size()) {
                int i5 = i4 * 2;
                dArr[i5] = list.get(i4).f8679a;
                dArr[i5 + 1] = list.get(i4).f8680b;
                i4++;
            }
            i4 = size;
        }
        return nativeSetPoints(this.nativeInstance, dArr, i4, 2);
    }

    public void a(String str) {
        this.f8636f = str;
    }

    public void a(int i4) {
        this.f8637g = i4;
    }

    public boolean a(int i4, List<Integer> list) {
        int[] iArr;
        int i5 = 0;
        if (list == null || list.size() <= 0) {
            iArr = null;
        } else {
            iArr = new int[list.size()];
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                iArr[i5] = com.baidu.platform.comapi.bmsdk.style.a.a(it.next().intValue());
                i5++;
            }
        }
        return nativeSetGradientColors(this.nativeInstance, i4, iArr, i5);
    }
}
