package com.obric.autoaction.presentation.provider;

import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OAutoStateProviderStatusDict.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "OAutoState-Dict";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f25106a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f25107b;

    /* JADX INFO: compiled from: OAutoStateProviderStatusDict.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f25108a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f25109b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f25110c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f25111d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f25112e = null;
        public static final a f = null;
        private static final /* synthetic */ a[] h = null;
        private static final /* synthetic */ d.d.a i = null;
        private final String g;

        private static final /* synthetic */ a[] b() {
            return new a[]{f25108a, f25109b, f25110c, f25111d, f25112e, f};
        }

        private a(String r1, int r2, String r3) {
            super(r1, r2);
            this.g = r3;
        }

        public final String a() {
            return this.g;
        }

        static {
            f25108a = new a("Idle", 0, "IDLE");
            f25109b = new a("Waiting", 1, "WAITING");
            f25110c = new a("Executing", 2, "EXECUTING");
            f25111d = new a("Clarifying", 3, "CLARIFYING");
            f25112e = new a("CallUser", 4, "CALL_USER");
            f = new a("Paused", 5, "PAUSED");
            a[] r0 = b();
            h = r0;
            i = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(h.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    private b() {
    }

    static {
        f25106a = new b();
        f25107b = a.f25108a;
    }

    public final void a(a r3) {
        o.e(r3, "state");
        if (r3 == f25107b) goto L6;
        f25107b = r3;
        OAutoStateProviderImpl.Companion.a("external_state_changed");
        Loog.INSTANCE.i(TAG, "[StateProvider] OAuto state changed to: " + r3);
        return;
    }

    public final a a() {
        return f25107b;
    }
}
