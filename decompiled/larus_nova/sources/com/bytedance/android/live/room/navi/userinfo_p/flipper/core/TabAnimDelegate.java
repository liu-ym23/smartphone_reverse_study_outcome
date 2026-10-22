package com.bytedance.android.live.room.navi.userinfo_p.flipper.core;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bytedance.android.live.core.log.ALogger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class TabAnimDelegate implements w91.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f100032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f100033b;

    public static final class a implements w91.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f100034a = null;

        public a() {
        }

        static {
            f100034a = new a();
        }

        @Override // w91.d.a
        public final boolean a(w91.d.b r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            if (r100.f558722c == null) goto L5;
        L7:
            return false;
        L5:
            if (r100.f558721b != 0) goto L7;
            return true;
        }
    }

    public static final class b implements w91.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f100035a = null;

        public b() {
        }

        static {
            f100035a = new b();
        }

        @Override // w91.d.a
        public final boolean a(w91.d.b r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            if (r100.f558722c == null) goto L5;
        L7:
            return false;
        L5:
            if (r100.f558720a != 1) goto L7;
            return true;
        }
    }

    public TabAnimDelegate() {
        this.f100032a = "TabAnimDelegate";
        this.f100033b = LazyKt.lazy(TabAnimDelegate$interceptors$2.INSTANCE);
    }

    @Override // w91.d
    public final boolean a(w91.d.b r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        List r101 = (List) this.f100033b.getValue();
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        if (((w91.d.a) r102.next()).a(r100) == false) goto L9;
        boolean r103 = true;
    L15:
        return !r103;
    L13:
        r103 = false;
        goto L15
    L5:
        if (r101.isEmpty() == false) goto L7;
        goto L7
    }

    @Override // w91.d
    public final void b(w91.f r100, w91.f r101, d r102) {
        Intrinsics.checkNotNullParameter(r101, "enterHolder");
        Intrinsics.checkNotNullParameter(r102, "listener");
        f r103 = new f(this, r100, r102, r101);
        View r104 = null;
        if (r100 == null) goto L5;
        q91.a r105 = r100.c();
    L6:
        if (r100 == null) goto L8;
        r104 = r100.a();
    L8:
        q91.a r106 = r101.c();
        View r107 = r101.a();
        if (r104 == null) goto L11;
        r104.clearAnimation();
    L11:
        r107.clearAnimation();
        r106.e(r107, r103);
        c(false, r105, r104, r103);
        c(true, r106, r107, r103);
        return;
    L5:
        r105 = null;
        goto L6
    }

    public final void c(boolean r100, w91.c r101, View r102, f r103) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r102 != null) goto L28;
        return;
    L28:
        if (r100 == false) goto L11;
        Animation r104 = r101.d();     // Catch: Exception -> L16 Resources.NotFoundException -> L18
        if (r104 != null) goto L15;
        Context r105 = r102.getContext();     // Catch: Exception -> L16 Resources.NotFoundException -> L18
        r101.a();     // Catch: Exception -> L16 Resources.NotFoundException -> L18
        Animation r106 = AnimationUtils.loadAnimation(r105, -1);     // Catch: Exception -> L16 Resources.NotFoundException -> L18
    L27:
    L20:
        if (r106 == null) goto L22;
        r106.setAnimationListener(new g(r100, r103, r102));
        r102.startAnimation(r106);
        return;
    L22:
        if (r100 == false) goto L24;
        r103.d();
        r103.a();
    L25:
        Unit r107 = Unit.INSTANCE;
        return;
    L24:
        r103.b();
        r103.c();
        goto L25
    L15:
        r106 = r104;
        goto L27
    L11:
        r104 = r101.c();     // Catch: Exception -> L16 Resources.NotFoundException -> L18
        if (r104 != null) goto L15;
        Context r108 = r102.getContext();     // Catch: Exception -> L16 Resources.NotFoundException -> L18
        r101.b();     // Catch: Exception -> L16 Resources.NotFoundException -> L18
        r106 = AnimationUtils.loadAnimation(r108, -1);     // Catch: Exception -> L16 Resources.NotFoundException -> L18
    L18:
        ALogger.e(this.f100032a, "解析动画文件出错");
    L19:
        r106 = null;
    L16:
        e = move-exception;
        ALogger.e(this.f100032a, e);
        goto L19
    }
}
