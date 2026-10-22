package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.BM3DModel;
import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import com.baidu.platform.comapi.bmsdk.ui.BmRichView;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class Bm3DModel extends BmDrawItem {

    /* renamed from: i, reason: collision with root package name */
    private a f8602i;

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<BmRichView> f8603j;

    /* renamed from: k, reason: collision with root package name */
    private String f8604k;

    /* renamed from: l, reason: collision with root package name */
    private BM3DModel f8605l;

    public Bm3DModel() {
        super(20, nativeCreate());
        this.f8603j = new ArrayList<>();
        this.f8604k = "";
        this.f8602i = new a();
    }

    private static native boolean nativeAddRichView(long j4, long j5);

    private static native boolean nativeClearRichViews(long j4);

    private static native long nativeCreate();

    private static native boolean nativeLoad(long j4, String str, int i4);

    private static native boolean nativeLoadByPath(long j4, String str, String str2, int i4);

    private static native boolean nativeRemoveRichView(long j4, long j5);

    private static native boolean nativeSetAlwaysShowFront(long j4, boolean z4);

    private static native boolean nativeSetAnimationIndex(long j4, int i4);

    private static native boolean nativeSetAnimationIsEnable(long j4, boolean z4);

    private static native boolean nativeSetAnimationRepeatCount(long j4, int i4);

    private static native boolean nativeSetAnimationSpeed(long j4, float f4);

    private static native boolean nativeSetBuildingId(long j4, String str);

    private static native boolean nativeSetCollisionBehavior(long j4, int i4);

    private static native boolean nativeSetCollisionPriority(long j4, int i4);

    private static native boolean nativeSetFloorId(long j4, String str);

    private static native boolean nativeSetOffset(long j4, double d4, double d5, double d6);

    private static native boolean nativeSetPosition(long j4, double d4, double d5, double d6);

    private static native boolean nativeSetRotation(long j4, float f4, float f5, float f6);

    private static native boolean nativeSetScale(long j4, float f4);

    private static native boolean nativeSetScaleByLevel(long j4, boolean z4);

    public void a(BM3DModel bM3DModel) {
        this.f8605l = bM3DModel;
    }

    public boolean b(float f4) {
        return nativeSetAnimationSpeed(this.nativeInstance, f4);
    }

    public boolean c(float f4) {
        this.f8602i.a(f4);
        return nativeSetScale(this.nativeInstance, f4);
    }

    public boolean d(boolean z4) {
        return nativeSetAnimationIsEnable(this.nativeInstance, z4);
    }

    public boolean e(boolean z4) {
        return nativeSetScaleByLevel(this.nativeInstance, z4);
    }

    public boolean f(int i4) {
        return nativeSetAnimationRepeatCount(this.nativeInstance, i4);
    }

    public boolean a(String str, String str2, int i4) {
        return nativeLoadByPath(this.nativeInstance, str, str2, i4);
    }

    public BmBaseUI b(long j4) {
        if (j4 == 0) {
            return null;
        }
        Iterator<BmRichView> it = this.f8603j.iterator();
        while (it.hasNext()) {
            BmBaseUI bmBaseUIA = it.next().a(j4);
            if (bmBaseUIA != null) {
                return bmBaseUIA;
            }
        }
        return null;
    }

    public boolean e(int i4) {
        return nativeSetAnimationIndex(this.nativeInstance, i4);
    }

    public boolean a(b bVar) {
        this.f8602i.a(bVar);
        return nativeSetPosition(this.nativeInstance, bVar.f8679a, bVar.f8680b, bVar.f8681c);
    }

    public boolean c(boolean z4) {
        return nativeSetAlwaysShowFront(this.nativeInstance, z4);
    }

    public boolean a(double d4, double d5, double d6) {
        return nativeSetOffset(this.nativeInstance, d4, d5, d6);
    }

    public boolean a(float f4, float f5, float f6) {
        this.f8602i.a(f4, f5, f6);
        return nativeSetRotation(this.nativeInstance, f4, f5, f6);
    }
}
