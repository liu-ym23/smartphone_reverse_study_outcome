package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.BM3DModel;
import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import com.baidu.platform.comapi.bmsdk.ui.BmRichView;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes39.dex */
public class Bm3DModel extends BmDrawItem {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f32739i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ArrayList<BmRichView> f32740j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f32741k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private BM3DModel f32742l;

    private static native boolean nativeAddRichView(long r100, long r101);

    private static native boolean nativeClearRichViews(long r100);

    private static native long nativeCreate();

    private static native boolean nativeLoad(long r100, String r101, int r102);

    private static native boolean nativeLoadByPath(long r100, String r101, String r102, int r103);

    private static native boolean nativeRemoveRichView(long r100, long r101);

    private static native boolean nativeSetAlwaysShowFront(long r100, boolean r101);

    private static native boolean nativeSetAnimationIndex(long r100, int r101);

    private static native boolean nativeSetAnimationIsEnable(long r100, boolean r101);

    private static native boolean nativeSetAnimationRepeatCount(long r100, int r101);

    private static native boolean nativeSetAnimationSpeed(long r100, float r101);

    private static native boolean nativeSetBuildingId(long r100, String r101);

    private static native boolean nativeSetCollisionBehavior(long r100, int r101);

    private static native boolean nativeSetCollisionPriority(long r100, int r101);

    private static native boolean nativeSetFloorId(long r100, String r101);

    private static native boolean nativeSetOffset(long r100, double r101, double r102, double r103);

    private static native boolean nativeSetPosition(long r100, double r101, double r102, double r103);

    private static native boolean nativeSetRotation(long r100, float r101, float r102, float r103);

    private static native boolean nativeSetScale(long r100, float r101);

    private static native boolean nativeSetScaleByLevel(long r100, boolean r101);

    public Bm3DModel() {
        super(20, nativeCreate());
        this.f32740j = new ArrayList();
        this.f32741k = "";
        this.f32739i = new a();
    }

    public boolean a(b r110) {
        this.f32739i.a(r110);
        return nativeSetPosition(this.nativeInstance, r110.f32817a, r110.f32818b, r110.f32819c);
    }

    public BmBaseUI b(long r100) {
        if (r100 == 0) goto L10;
        Iterator<BmRichView> r101 = this.f32740j.iterator();
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
        this.f32739i.a(r100);
        return nativeSetScale(this.nativeInstance, r100);
    }

    public boolean d(boolean r100) {
        return nativeSetAnimationIsEnable(this.nativeInstance, r100);
    }

    public boolean e(int r100) {
        return nativeSetAnimationIndex(this.nativeInstance, r100);
    }

    public boolean f(int r100) {
        return nativeSetAnimationRepeatCount(this.nativeInstance, r100);
    }

    public void a(BM3DModel r100) {
        this.f32742l = r100;
    }

    public boolean b(float r100) {
        return nativeSetAnimationSpeed(this.nativeInstance, r100);
    }

    public boolean c(boolean r100) {
        return nativeSetAlwaysShowFront(this.nativeInstance, r100);
    }

    public boolean e(boolean r100) {
        return nativeSetScaleByLevel(this.nativeInstance, r100);
    }

    public boolean a(float r100, float r101, float r102) {
        this.f32739i.a(r100, r101, r102);
        return nativeSetRotation(this.nativeInstance, r100, r101, r102);
    }

    public boolean a(double r100, double r110, double r111) {
        return nativeSetOffset(this.nativeInstance, r100, r110, r111);
    }

    public boolean a(String r100, String r101, int r102) {
        return nativeLoadByPath(this.nativeInstance, r100, r101, r102);
    }
}
