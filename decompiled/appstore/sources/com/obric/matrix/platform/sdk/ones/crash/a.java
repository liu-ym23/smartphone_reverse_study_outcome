package com.obric.matrix.platform.sdk.ones.crash;

import android.app.Application;
import com.bytedance.platform.godzilla.crash.uncaughtexecption.SuperUncaughtExceptionPlugin;
import com.bytedance.platform.godzilla.plugin.StartType;
import java.util.List;
import kotlin.jvm.internal.q;
import q5.b;
import u5.c;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11903a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f11904b;

    /* JADX INFO: renamed from: com.obric.matrix.platform.sdk.ones.crash.a$a, reason: collision with other inner class name */
    public static final class C0184a implements SuperUncaughtExceptionPlugin.ConfigFetcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MatrixCrashConfigBuilder f11905a;

        public C0184a(MatrixCrashConfigBuilder r10) {
            this.f11905a = r10;
        }

        @Override // com.bytedance.platform.godzilla.crash.uncaughtexecption.SuperUncaughtExceptionPlugin.ConfigFetcher
        public String getAppVersion() {
            return this.f11905a.m();
        }

        @Override // com.bytedance.platform.godzilla.crash.uncaughtexecption.SuperUncaughtExceptionPlugin.ConfigFetcher
        public List getCrashPortrait() {
            return (List) this.f11905a.o().invoke();
        }

        @Override // com.bytedance.platform.godzilla.crash.uncaughtexecption.SuperUncaughtExceptionPlugin.ConfigFetcher
        public int getUpdateVersion() {
            return this.f11905a.y();
        }

        @Override // com.bytedance.platform.godzilla.crash.uncaughtexecption.SuperUncaughtExceptionPlugin.ConfigFetcher
        public void onCrashCatchSucceed(c r10) {
            if (r10 == null) goto L5;
            this.f11905a.x().invoke(r10);
            return;
        }
    }

    static {
        f11903a = new a();
    }

    public a() {
    }

    public final void a(MatrixCrashConfigBuilder r10) {
        q.g(r10, "configBuilder");
        if (f11904b == false) goto L6;
        return;
    L6:
        if (f11904b == false) goto L8;
        return;
    L8:
        Application r11 = r10.n();
        p5.a.b r12 = new p5.a.b(r11);
        if (r10.t() == false) goto L12;
        r12.b(new b());
    L12:
        if (r10.u() == false) goto L15;
        r12.b(new v5.b());
    L15:
        if (r10.s() == false) goto L18;
        r12.b(new v5.a());
    L18:
        if (r10.p() == false) goto L21;
        r12.b(new q5.a());
    L21:
        if (r10.q() == false) goto L24;
        r12.b(new a6.a());
    L24:
        if (r10.r() == false) goto L27;
        r12.b(new a6.b());
    L27:
        if (r10.w() == false) goto L30;
        r12.b(new a6.c());
    L30:
        if (r10.v() == false) goto L32;
        r12.b(new SuperUncaughtExceptionPlugin(new C0184a(r10), r11));
    L32:
        p5.a.a(r12.a()).b();
        p5.a.d().c(StartType.REGISTER_EXCEPTION);
        f11904b = true;
    }
}
