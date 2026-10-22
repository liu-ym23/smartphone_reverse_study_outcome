package com.bytedance.ai.debugscene;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ai.debug.NativeDebugPanelType;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f0 f36346a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f36347b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f36348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static c f36349d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NativeDebugPanelType f36350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.bytedance.ai.debug.h f36351b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b f36352c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final j0 f36353d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f36350a == r101.f36350a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f36351b, r101.f36351b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f36352c, r101.f36352c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f36353d, r101.f36353d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f36350a.hashCode() * 31) + this.f36351b.hashCode()) * 31) + this.f36352c.hashCode()) * 31) + this.f36353d.hashCode();
        }

        public final String toString() {
            return "CurrentPanel(type=" + this.f36350a + ", listener=" + this.f36351b + ", dispatcher=" + this.f36352c + ", handle=" + this.f36353d + ')';
        }

        public final NativeDebugPanelType getType() {
            return this.f36350a;
        }

        public a(NativeDebugPanelType r100, com.bytedance.ai.debug.h r101, b r102, j0 r103) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "listener");
            Intrinsics.checkNotNullParameter(r102, "dispatcher");
            Intrinsics.checkNotNullParameter(r103, "handle");
            this.f36350a = r100;
            this.f36351b = r101;
            this.f36352c = r102;
            this.f36353d = r103;
        }
    }

    public static final class b implements k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.ai.debug.h f36354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f36355b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicBoolean f36356c;

        public b(com.bytedance.ai.debug.h r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            this.f36354a = r100;
            this.f36355b = new AtomicBoolean(true);
            this.f36356c = new AtomicBoolean(false);
        }

        @Override // com.bytedance.ai.debugscene.k0
        public final void a(final String r100, final String r101, final o2 r102) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "message");
            Intrinsics.checkNotNullParameter(r102, "reply");
            if (this.f36355b.get() == true) goto L6;
            com.bytedance.ai.utils.g.f37637a.w("AIDebugPanelCoordinator", "reject panel message because session is unavailable, type:" + r100);
            b(r102, -2, "MESSAGE_TYPE_NOT_REGISTERED", null);
            return;
        L6:
            f0.f36347b.post(new g0(this, r102, r100, r101));
        }

        public static void c(com.bytedance.ai.debug.i r100, int r101, String r102, String r103) {
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L4
            r100.a(r101, r102, r103);     // Catch: Throwable -> L4
            Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        L6:
            Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
            if (r106 == null) goto L12;
            com.bytedance.ai.utils.g.f37637a.e("AIDebugPanelCoordinator", "panel reply failed, code:" + r101 + ", error:" + r106.getMessage());
            return;
        L12:
            return;
        L4:
            th = move-exception;
            Result.Companion r107 = Result.Companion;
            r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L6
        }

        public final void b(final com.bytedance.ai.debug.i r100, final int r110, final String r111, final String r112) {
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
            c(r100, r110, r111, r112);
            return;
        L5:
            f0.f36347b.post(new i0(this, r100, r110, r111, r112));
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NativeDebugPanelType f36357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f36358b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bytedance.ai.debug.h f36359c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Activity f36360d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f36357a == r101.f36357a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f36358b, r101.f36358b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f36359c, r101.f36359c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f36360d, r101.f36360d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f36357a.hashCode() * 31) + this.f36358b.hashCode()) * 31) + this.f36359c.hashCode()) * 31) + this.f36360d.hashCode();
        }

        public final String toString() {
            return "PanelRequest(type=" + this.f36357a + ", launchParamsJson=" + this.f36358b + ", listener=" + this.f36359c + ", activity=" + this.f36360d + ')';
        }

        public final Activity getActivity() {
            return this.f36360d;
        }

        public final NativeDebugPanelType getType() {
            return this.f36357a;
        }

        public c(NativeDebugPanelType r100, String r101, com.bytedance.ai.debug.h r102, Activity r103) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "launchParamsJson");
            Intrinsics.checkNotNullParameter(r102, "listener");
            Intrinsics.checkNotNullParameter(r103, "activity");
            this.f36357a = r100;
            this.f36358b = r101;
            this.f36359c = r102;
            this.f36360d = r103;
        }
    }

    public f0() {
    }

    static {
        f36346a = new f0();
        f36347b = new Handler(Looper.getMainLooper());
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [com.bytedance.ai.debugscene.d0] */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.bytedance.ai.debugscene.e0] */
    public final boolean a(c r100) {
        final b r101 = new b(r100.f36359c);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        w0 r103 = w0.f36532a;     // Catch: Throwable -> L5
        Activity r104 = r100.getActivity();     // Catch: Throwable -> L5
        NativeDebugPanelType r105 = r100.getType();     // Catch: Throwable -> L5
        String r106 = r100.f36358b;     // Catch: Throwable -> L5
        ?? r107 = new d0(this, r101);     // Catch: Throwable -> L5
        ?? r108 = new e0(this, r101);     // Catch: Throwable -> L5
        r103.getClass();     // Catch: Throwable -> L5
        Object r109 = Result.m9449constructorimpl(w0.a(r104, r105, r106, r101, r107, r108));     // Catch: Throwable -> L5
    L7:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L11;
        com.bytedance.ai.utils.g.f37637a.e("AIDebugPanelCoordinator", "show panel failed, type:" + r100.getType() + ", error:" + r110.getMessage());
    L11:
        if (Result.m9455isFailureimpl(r109) == false) goto L13;
        r109 = null;
    L13:
        j0 r111 = (j0) r109;
        if (r111 != null) goto L17;
        r101.f36355b.set(false);
        return false;
    L17:
        f36348c = new a(r100.getType(), r100.f36359c, r101, r111);
        com.bytedance.ai.utils.g.f37637a.i("AIDebugPanelCoordinator", "show panel accepted, type:" + r100.getType());
        return true;
    L5:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final boolean b(c r100) {
        a r101 = f36348c;
        if (r101 != null) goto L7;
        return a(r100);
    L7:
        if (r101.f36353d.a(r100.getActivity()) == true) goto L11;
        f36349d = r100;
        com.bytedance.ai.utils.g.f37637a.i("AIDebugPanelCoordinator", "replace panel because host Activity changed, type:" + r100.getType());
        r101.f36353d.close();
        return true;
    L11:
        if (r101.getType() == r100.getType()) goto L13;
        f36349d = r100;
        com.bytedance.ai.utils.g.f37637a.i("AIDebugPanelCoordinator", "replace panel, from:" + r101.getType() + ", to:" + r100.getType());
        r101.f36353d.close();
        return true;
    L13:
        if (r101.f36351b == r100.f36359c) goto L16;
        f36349d = r100;
        com.bytedance.ai.utils.g.f37637a.i("AIDebugPanelCoordinator", "replace panel because listener differs, type:" + r100.getType());
        r101.f36353d.close();
        return true;
    L16:
        r101.f36353d.b(r100.f36358b);
        com.bytedance.ai.utils.g.f37637a.i("AIDebugPanelCoordinator", "update panel params, type:" + r100.getType());
        return true;
    }
}
