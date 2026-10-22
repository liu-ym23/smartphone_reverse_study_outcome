package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import android.content.Context;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public abstract class a implements sg2.e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.room.j f149416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f149417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f149418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f149419d;

    public a() {
        this(false);
    }

    public abstract boolean c(sg2.a r100);

    public boolean d() {
        return false;
    }

    public abstract void e(String r100, boolean r101);

    public final Context getContext() {
        com.bytedance.android.livesdk.livecommerce.room.j r100 = this.f149416a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getContext();
    }

    public a(boolean r100) {
        this.f149419d = r100;
    }

    @Override // sg2.e0
    public final <T> boolean a(sg2.e0.a<T> r100) throws Exception {
        T r101 = r100.getMessage();
        boolean r102 = false;
        if ((r101 instanceof sg2.a) == false) goto L28;
        sg2.a r103 = (sg2.a) r101;
        int r104 = RoomContextController.f151593h;
        RoomContextController r105 = RoomContextController.a.b(this.f149417b, this.f149418c);
        if (d() == false) goto L12;
        if (r105.x() == false) goto L12;
        if (r105.M() == false) goto L28;
    L12:
        if (this.f149419d == true) goto L27;
        sg2.b r106 = r103.getCommon();
        if (r106 == null) goto L16;
        String r107 = r106.f541774e;
    L17:
        if (r107 != null) goto L19;
    L22:
        boolean r108 = true;
    L23:
        if (r108 == true) goto L27;
        if ((!Intrinsics.areEqual(r107, this.f149417b)) == false) goto L27;
    L19:
        if (r107.length() == 0) goto L22;
        r108 = false;
        goto L23
    L16:
        r107 = null;
    L27:
        r102 = c(r103);
    L28:
        if (r102 == false) goto L31;
        return true;
    L31:
        return r100.a(r100.getMessage());
    }

    public final <R> R b(Class<R> r100, sg2.a r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        String r102 = null;
        if (this.f149419d == false) goto L11;
        com.bytedance.android.livesdk.livecommerce.room.j r103 = this.f149416a;
        if (r103 == null) goto L15;
        if (r101 == null) goto L16;
        sg2.b r104 = r101.getCommon();
        if (r104 == null) goto L16;
        r102 = r104.f541774e;
    L16:
        return (R) com.bytedance.android.livesdk.livecommerce.room.k.a(r103, r100, r102);
    L15:
        return null;
    L11:
        com.bytedance.android.livesdk.livecommerce.room.j r105 = this.f149416a;
        if (r105 != null) goto L14;
        return null;
    L14:
        return (R) com.bytedance.android.livesdk.livecommerce.room.k.a(r105, r100, null);
    }
}
