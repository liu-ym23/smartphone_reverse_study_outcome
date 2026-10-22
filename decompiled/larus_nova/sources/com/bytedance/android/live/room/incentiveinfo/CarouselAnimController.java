package com.bytedance.android.live.room.incentiveinfo;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class CarouselAnimController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f99602a;

    public static final class a {
    }

    public static final class b implements u81.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f99603a = null;

        public b() {
        }

        static {
            f99603a = new b();
        }

        @Override // u81.a
        public final boolean a(u81.b r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            if (r100.f549163c == null) goto L5;
        L7:
            return false;
        L5:
            if (r100.f549162b != 0) goto L7;
            return true;
        }
    }

    public static final class c implements u81.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f99604a = null;

        public c() {
        }

        static {
            f99604a = new c();
        }

        @Override // u81.a
        public final boolean a(u81.b r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            if (r100.f549163c == null) goto L5;
        L7:
            return false;
        L5:
            if (r100.f549161a != 1) goto L7;
            return true;
        }
    }

    static {
    }

    public CarouselAnimController() {
        this.f99602a = LazyKt.lazy(CarouselAnimController$interceptors$2.INSTANCE);
    }

    public static void a(boolean r100, View r101, u81.e r102, com.bytedance.android.live.room.incentiveinfo.b r103) {
        if (r101 == null) goto L29;
        if (r102 != null) goto L27;
        return;
    L27:
        if (r100 == false) goto L10;
        Animation r104 = r102.d();     // Catch: Exception -> L15 Resources.NotFoundException -> L17
        if (r104 != null) goto L14;
        Context r105 = r101.getContext();     // Catch: Exception -> L15 Resources.NotFoundException -> L17
        r102.a();     // Catch: Exception -> L15 Resources.NotFoundException -> L17
        Animation r106 = AnimationUtils.loadAnimation(r105, -1);     // Catch: Exception -> L15 Resources.NotFoundException -> L17
    L26:
    L19:
        if (r106 == null) goto L21;
        r106.setAnimationListener(new com.bytedance.android.live.room.incentiveinfo.a(r100, r103, r101));
        r101.startAnimation(r106);
        return;
    L21:
        if (r100 == false) goto L23;
        r103.d();
        r103.a();
    L24:
        Unit r107 = Unit.INSTANCE;
        return;
    L23:
        r103.b();
        r103.c();
        goto L24
    L14:
        r106 = r104;
        goto L26
    L10:
        r104 = r102.c();     // Catch: Exception -> L15 Resources.NotFoundException -> L17
        if (r104 != null) goto L14;
        Context r108 = r101.getContext();     // Catch: Exception -> L15 Resources.NotFoundException -> L17
        r102.b();     // Catch: Exception -> L15 Resources.NotFoundException -> L17
        r106 = AnimationUtils.loadAnimation(r108, -1);     // Catch: Exception -> L15 Resources.NotFoundException -> L17
    L17:
        ALogger.e("CarouselAnimController", "解析动画文件出错");
    L18:
        r106 = null;
    L15:
        e = move-exception;
        ALogger.e("CarouselAnimController", e);
        goto L18
    }
}
