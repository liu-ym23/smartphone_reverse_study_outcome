package com.smt.obric.appstore.domain.app;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.session.MediaController;
import android.media.session.PlaybackState;
import com.bytedanceos.common.utils.ReflectTool;
import com.smt.obric.appstore.domain.app.entity.AppInstallMode;
import com.smt.obric.appstore.domain.sysapp.SysAppUtilKt;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.o1;

/* JADX INFO: loaded from: classes4.dex */
public final class AppInstaller {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f17948b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f17949a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ String a(a r10, Context r11, String r12) {
            return r10.c(r11, r12);
        }

        public static final /* synthetic */ boolean b(a r10, Context r11) {
            return r10.d(r11);
        }

        public final String c(Context r10, String r11) {
            String r12 = r10.getFilesDir().getAbsolutePath();
            q.f(r12, "getAbsolutePath(...)");
            Path r13 = Paths.get(r12, (String[]) Arrays.copyOf(new String[]{"apk", r11 + ".tmp_apk"}, 2));
            q.f(r13, "get(...)");
            return r13.toString();
        }

        public final boolean d(Context r10) {
            Pair r11 = com.smt.obric.appstore.ktx.a.b(r10);
            int r12 = ((Number) r11.component1()).intValue();
            boolean r13 = ((Boolean) r11.component2()).booleanValue();
            boolean r14 = true;
            if (r13 == true) goto L10;
            if (r12 <= 0) goto L10;
            if (r12 >= 20) goto L10;
            r14 = false;
        L10:
            com.bytedanceos.common.toolbox.j.o("[AppStatus][AppInstaller][InstallStage][AutoUpdate] isAllowAutoUpdateInstall=" + r14 + ", battery: level=" + r12 + ", charging=" + r13);
            return r14;
        }

        public a() {
        }
    }

    static {
        f17948b = new a(null);
    }

    public AppInstaller(Context r10) {
        q.g(r10, "context");
        this.f17949a = r10;
    }

    public static final /* synthetic */ Object a(AppInstaller r10, Context r11, String r12, Continuation r13) {
        return r10.d(r11, r12, r13);
    }

    public static final /* synthetic */ Context b(AppInstaller r10) {
        return r10.f17949a;
    }

    public static final /* synthetic */ Object c(AppInstaller r10, String r11, int r12, long r13, Continuation r14) {
        return r10.f(r11, r12, r13, r14);
    }

    public final Object d(Context r10, String r11, Continuation r12) {
        PackageManager r13 = r10.getPackageManager();
        q.f(r13, "getPackageManager(...)");
        return AppInstallerKt.e(r13, r11, 0, r12, 2, null);
    }

    public final Object e(com.smt.obric.appstore.domain.app.entity.a r12, Continuation r13) {
        if ((r13 instanceof AppInstaller$installApp$1) == false) goto L7;
        AppInstaller$installApp$1 r10 = (AppInstaller$installApp$1) r13;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r14 = r10.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r10.label;
        if (r16 == 0) goto L21;
        if (r16 == 1) goto L19;
        if (r16 == 2) goto L18;
        if (r16 == 3) goto L17;
        if (r16 != 4) goto L16;
        kotlin.c.b(r14);
    L80:
        return r14;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r12 = (com.smt.obric.appstore.domain.app.entity.a) r10.L$1;
        AppInstaller this = (AppInstaller) r10.L$0;
        kotlin.c.b(r14);
    L68:
        boolean r17 = ((Boolean) r14).booleanValue();
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstaller][InstallStage] installApp: force install, user confirm = " + r17 + ", task=" + r12.P());
        if (r17 == true) goto L74;
        return i.f18022d.d(r12);
    L74:
        if (r12.A() == 0) goto L76;
        CoroutineDispatcher r18 = l0.b();
        AppInstaller$installApp$2 r19 = new AppInstaller$installApp$2(r12, this, null);
        r10.L$0 = null;
        r10.L$1 = null;
        r10.label = 4;
        r14 = kotlinx.coroutines.h.g(r18, r19, r10);
        if (r14 != r15) goto L80;
        return r15;
    L76:
        return i.f18022d.c(r12);
    L18:
        com.smt.obric.appstore.domain.app.entity.a r110 = (com.smt.obric.appstore.domain.app.entity.a) r10.L$1;
        AppInstaller r111 = (AppInstaller) r10.L$0;
        kotlin.c.b(r14);
        com.smt.obric.appstore.domain.app.entity.a r20 = r110;
        this = r111;
    L59:
        if (((Boolean) r14).booleanValue() == false) goto L62;
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstaller][InstallStage] installApp: sys ime displaying, retry later, task=" + r20.P());
        return new i(r20, -990000, null, 4, null);
    L62:
        r12 = r20;
        goto L74
    L19:
        r12 = (com.smt.obric.appstore.domain.app.entity.a) r10.L$1;
        this = (AppInstaller) r10.L$0;
        kotlin.c.b(r14);
    L20:
        r20 = r12;
        if (((Boolean) r14).booleanValue() == false) goto L50;
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstaller][InstallStage] installApp: app has active media session, retry later, task=" + r20.P());
        return new i(r20, -990000, null, 4, null);
    L50:
        if (ReflectTool.isAppInTop(r20.E()) == false) goto L54;
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstaller][InstallStage] installApp: app is in top, retry later, task=" + r20.P());
        return new i(r20, -990000, null, 4, null);
    L54:
        if (q.b("com.bytedance.android.doubaoime", r20.E()) == false) goto L62;
        Context r112 = this.f17949a;
        r10.L$0 = this;
        r10.L$1 = r20;
        r10.label = 2;
        r14 = SysAppUtilKt.g(r112, r10);
        if (r14 != r15) goto L59;
        return r15;
    L21:
        kotlin.c.b(r14);
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstaller][InstallStage] installApp: task=" + r12.P());
        if (r12.M() == true) goto L81;
    L34:
        AppInstallMode r113 = r12.C();
        if (q.b(r113, AppInstallMode.c.f17964a) == false) goto L64;
        if (r12.L() == true) goto L39;
    L42:
        String r21 = r12.E();
        r10.L$0 = this;
        r10.L$1 = r12;
        r10.label = 1;
        r14 = f(r21, 5, 1000, r10);
        if (r14 != r15) goto L20;
        return r15;
    L39:
        if (a.b(f17948b, this.f17949a) == true) goto L42;
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstaller][InstallStage][AutoUpdate] installApp: skip install, environment check failed, pkg=" + r12.P());
        return new i(r12, -990000, null, 4, null);
    L64:
        if (q.b(r113, AppInstallMode.d.f17966a) == false) goto L72;
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstaller][InstallStage] installApp: force install, user confirm await, task=" + r12.P());
        o1 r114 = l0.c();
        AppInstaller$installApp$userConfirm$1 r22 = new AppInstaller$installApp$userConfirm$1(this, r12, null);
        r10.L$0 = this;
        r10.L$1 = r12;
        r10.label = 3;
        r14 = kotlinx.coroutines.h.g(r114, r22, r10);
        if (r14 != r15) goto L68;
        return r15;
    L72:
        q.b(r113, AppInstallMode.b.f17962a);
        goto L74
    L81:
        Result.a r115 = Result.Companion;     // Catch: Throwable -> L25
        Object r116 = Result.m35constructorimpl(this.f17949a.getPackageManager().getPackageInfo(r12.E(), 0));     // Catch: Throwable -> L25
    L28:
        if (Result.m41isFailureimpl(r116) == false) goto L31;
        r116 = null;
    L31:
        if (((PackageInfo) r116) != null) goto L34;
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstaller][InstallStage][SysAutoUpdate] installApp: skip install, package info not found, task=" + r12.P());
        return i.f18022d.b(r12);
    L25:
        th = move-exception;
        Result.a r23 = Result.Companion;
        r116 = Result.m35constructorimpl(kotlin.c.a(th));
    L7:
        r10 = new AppInstaller$installApp$1(this, r13);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004a -> B:22:0x0067). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x005f -> B:21:0x0063). Please report as a decompilation issue!!! */
    public final Object f(String r10, int r11, long r12, Continuation r13) {
        if ((r13 instanceof AppInstaller$testHasActivePlaybackWithRetry$1) == false) goto L7;
        AppInstaller$testHasActivePlaybackWithRetry$1 r14 = (AppInstaller$testHasActivePlaybackWithRetry$1) r13;
        int r15 = r14.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r14.label = r15 - Integer.MIN_VALUE;
    L8:
        Object r16 = r14.result;
        Object r17 = kotlin.coroutines.intrinsics.a.d();
        int r18 = r14.label;
        if (r18 == 0) goto L14;
        if (r18 != 1) goto L13;
        int r19 = r14.I$1;
        long r20 = r14.J$0;
        int r110 = r14.I$0;
        String r111 = (String) r14.L$1;
        AppInstaller r21 = (AppInstaller) r14.L$0;
        kotlin.c.b(r16);
    L21:
        String r112 = r111;
        long r113 = r20;
        AppInstaller r22 = r21;
    L22:
        List r23 = com.smt.obric.appstore.ktx.a.a(r22.f17949a, r112);
        if (r23.isEmpty() == false) goto L27;
        return tf.a.a(false);
    L27:
        if (r23.isEmpty() == true) goto L38;
        Iterator r24 = r23.iterator();
    L31:
        if (r24.hasNext() == false) goto L38;
        PlaybackState r25 = ((MediaController) r24.next()).getPlaybackState();
        if (r25 == null) goto L31;
        if (r25.isActive() != true) goto L31;
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstaller][InstallStage] hasActivePlayback=true, pkg=" + r112);
        return tf.a.a(true);
    L38:
        r19 = r19 + 1;
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstaller][InstallStage] hasActiveMediaSession but hasActivePlayback=false, pkg=" + r112 + ", tried " + r19 + '/' + r110 + " times, may test later in " + r113 + " ms");
    L15:
        if (r19 >= r110) goto L40;
        if (r19 <= 0) goto L22;
        r14.L$0 = r22;
        r14.L$1 = r112;
        r14.I$0 = r110;
        r14.J$0 = r113;
        r14.I$1 = r19;
        r14.label = 1;
        if (DelayKt.b(r113, r14) != r17) goto L20;
        return r17;
    L20:
        r21 = r22;
        long r26 = r113;
        r111 = r112;
        r20 = r26;
        goto L21
    L40:
        return tf.a.a(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r16);
        r113 = r12;
        r110 = r11;
        r112 = r10;
        r22 = this;
        r19 = 0;
    L7:
        r14 = new AppInstaller$testHasActivePlaybackWithRetry$1(this, r13);
        goto L8
    }
}
