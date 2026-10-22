package com.bytedance.android.annie.ng;

import android.app.Application;
import com.bytedance.android.annie.Annie;
import com.bytedance.ies.bullet.base.BulletSdk;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o8.c f39657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o8.b f39658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o8.d f39659c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Application f39660a;

        public final void a() {
            boolean r100 = BulletSdk.f246267a;
            BulletSdk.c(this.f39660a);
            Application r101 = this.f39660a;
            Application r102 = g.f39669a;
            Intrinsics.checkNotNullParameter(r101, "<set-?>");
            g.f39669a = r101;
            d r103 = new d(e.f39662b, e.f39663c, e.f39664d);
            f r104 = new f();
            Intrinsics.checkNotNullParameter(r103, "<set-?>");
            g.f39670b = r103;
            Intrinsics.checkNotNullParameter(r104, "<set-?>");
            com.bytedance.android.annie.ng.a.C0738a r105 = new com.bytedance.android.annie.ng.a.C0738a("host");
            AnnieGlobalConfig$Builder$init$2 r106 = AnnieGlobalConfig$Builder$init$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r106, "block");
            r106.invoke(r105.f39650d);
            AnnieGlobalConfig$Builder$init$3 r107 = AnnieGlobalConfig$Builder$init$3.INSTANCE;
            Intrinsics.checkNotNullParameter(r107, "block");
            r107.invoke(r105.f39648b);
            AnnieGlobalConfig$Builder$init$4 r108 = AnnieGlobalConfig$Builder$init$4.INSTANCE;
            Intrinsics.checkNotNullParameter(r108, "block");
            r108.invoke(r105.f39649c);
            AnnieGlobalConfig$Builder$init$5 r109 = AnnieGlobalConfig$Builder$init$5.INSTANCE;
            Intrinsics.checkNotNullParameter(r109, "block");
            r109.invoke(r105.f39651e);
            r105.a();
            if (g.f39675g == true) goto L5;
            ((b9.b) Annie.getService$default(b9.b.class, null, 2, null)).init();
        L5:
            g.f39675g = true;
            Map<String, j> r110 = i.f39677b;
            monitor-enter(r110);
            Iterator r111 = ((LinkedHashMap) r110).entrySet().iterator();     // Catch: Throwable -> L14
        L9:
            if (r111.hasNext() == false) goto L11;
            ((j) ((Map.Entry) r111.next()).getValue()).onCallback();     // Catch: Throwable -> L14
            goto L9
        L11:
            Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L14
            monitor-exit(r110);
            return;
        L14:
            th = move-exception;
            throw th;
        }

        public a(Application r100) {
            Intrinsics.checkNotNullParameter(r100, "application");
            this.f39660a = r100;
        }
    }

    public d(o8.c r100, o8.b r101, o8.d r102) {
        o8.a r103 = e.f39661a;
        this.f39657a = r100;
        this.f39658b = r101;
        this.f39659c = r102;
    }
}
