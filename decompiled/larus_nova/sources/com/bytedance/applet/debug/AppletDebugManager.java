package com.bytedance.applet.debug;

import android.net.Uri;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.utils.g;
import com.bytedance.ies.bullet.service.router.d;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.o0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes14.dex */
public final class AppletDebugManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f191566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f191567b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f191568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f191569b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f191568a, r101.f191568a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f191569b, r101.f191569b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f191568a.hashCode() * 31) + this.f191569b.hashCode();
        }

        public final String toString() {
            return "PreviewDebugInfo(debugInfo=" + this.f191568a + ", debugToken=" + this.f191569b + ')';
        }

        public a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "debugInfo");
            Intrinsics.checkNotNullParameter(r101, "debugToken");
            this.f191568a = r100;
            this.f191569b = r101;
        }
    }

    public static final class b implements IAISDKDebugService.a {
        public b() {
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService.a
        public final void a() {
            boolean r100 = AppletDebugManager.f191566a;
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AppletDebugManager$showDebugModeClosedToast$1(null), 3, null);
        }
    }

    public AppletDebugManager() {
    }

    static {
        f191567b = new b();
    }

    public static a a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        String r101 = d.a(r100, "debugInfo");
        String r102 = d.a(r100, "securityToken");
        if (o0.d(r101) == false) goto L5;
        String r103 = Uri.decode(r101);
    L7:
        if (o0.d(r102) == false) goto L9;
        String r104 = Uri.decode(r102);
    L10:
        if (r103 == null) goto L13;
        Intrinsics.checkNotNull(r104);
        return new a(r103, r104);
    L13:
        return null;
    L9:
        r104 = "";
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    public static boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Uri r101 = UriProtector.parse(r100);
        String r102 = d.a(r101, "short_token");
        a r103 = a(r101);
        if (Intrinsics.areEqual(r101.getScheme(), "doubaoapp") == true) goto L5;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == false) goto L13;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AppletDebugManager$isDebugMode$1(r102, r103, null), 3, null);
    L13:
        return r104;
    L5:
        if (Intrinsics.areEqual(r101.getHost(), "debug") == false) goto L10;
        if (o0.d(r102) == true) goto L9;
        if (r103 == null) goto L10;
    L9:
        r104 = true;
        goto L11
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "packageName");
        g.f37637a.i("AppletDebugActivity", "setDebugConfig: " + r100);
        IAISDKDebugService.f36186a.q(r100, r101);
    }
}
