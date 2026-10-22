package com.obric.autogui.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ActionExecStatusMessage.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0726a f28959a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f28960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f28961d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f28962e;
    private final b f;
    private final boolean g;
    private final int h;

    /* JADX INFO: renamed from: com.obric.autogui.common.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionExecStatusMessage.kt */
    public static final class C0726a {
        public /* synthetic */ C0726a(h r1) {
            this();
        }

        private C0726a() {
        }
    }

    /* JADX INFO: compiled from: ActionExecStatusMessage.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f28963a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f28964b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ b[] f28965c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f28966d = null;

        private static final /* synthetic */ b[] a() {
            return new b[]{f28963a, f28964b};
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f28963a = new b("DEFAULT", 0);
            f28964b = new b("RETRY_STEP", 1);
            b[] r0 = a();
            f28965c = r0;
            f28966d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f28965c.clone(), b[].class, "com.obric.aiagent.plugin");
        }
    }

    static {
        f28959a = new C0726a(null);
    }

    @Override // com.obric.autogui.common.c
    public e a() {
        return this.f28960c;
    }

    public final String b() {
        return this.f28961d;
    }

    public final String c() {
        return this.f28962e;
    }

    public final b d() {
        return this.f;
    }

    public final boolean e() {
        return this.g;
    }

    public final int f() {
        return this.h;
    }

    public a(boolean r3, e r4, String r5, String r6, b r7, boolean r8, int r9) {
        o.e(r4, "wrapped");
        o.e(r7, "postExecAction");
        super(r3, r4.h(), r4.i());
        this.f28960c = r4;
        this.f28961d = r5;
        this.f28962e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
