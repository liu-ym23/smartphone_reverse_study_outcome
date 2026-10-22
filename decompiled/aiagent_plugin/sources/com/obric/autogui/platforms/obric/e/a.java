package com.obric.autogui.platforms.obric.e;

import android.app.assist.AssistStructure;
import android.view.WindowManager;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.obric.autogui.common.api.platform.thermal.IAutoActionThermalStateApi;
import com.obric.autogui.common.e;
import com.obric.autogui.platforms.obric.e.a.b;
import com.obric.autogui.platforms.tools.internal.viewhierarchy.ViewHierarchyDumpAsync;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: ObricSystemApiImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.obric.autogui.platforms.tools.e.a {
    private static final String TAG = "O/SystemApi";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0795a f30103a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.obric.autogui.platforms.tools.internal.b f30104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f30105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ViewHierarchyDumpAsync f30106e;

    /* JADX INFO: renamed from: com.obric.autogui.platforms.obric.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ObricSystemApiImpl.kt */
    public static final class C0795a {
        public /* synthetic */ C0795a(h r1) {
            this();
        }

        private C0795a() {
        }
    }

    /* JADX INFO: compiled from: ObricSystemApiImpl.kt */
    @f(b = "ObricSystemApiImpl.kt", c = {58}, d = "dumpViewHierarchy", e = "com.obric.autogui.platforms.obric.system.ObricSystemApiImpl")
    static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f30108b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f30109c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f30110d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f30111e;
        int f;

        b(a r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30111e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f30110d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f30111e.dumpViewHierarchy(0, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f30103a = new C0795a(null);
    }

    public static /* synthetic */ String lambda$VAatDZWWd9enX96RijaVkC97eVA(int r0, long r1, long r3, long r5) {
        return a(r0, r1, r3, r5);
    }

    public a() {
        this.f30104c = new com.obric.autogui.platforms.tools.internal.b(WindowManager.LayoutParams.class, "privateFlags");
        this.f30105d = new b();
        this.f30106e = new ViewHierarchyDumpAsync();
    }

    @Override // com.obric.autogui.platforms.tools.e.a, com.obric.autogui.common.api.platform.system.IAutoActionSystemApi
    public void setTrustedOverlay(WindowManager.LayoutParams r4) {
        o.e(r4, "params");
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(this.f30104c.a(r4), Integer.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        int r1 = r0.intValue();
        this.f30104c.a(r4, Integer.valueOf(r1 | 536870912));
        return;
    }

    @Override // com.obric.autogui.platforms.tools.e.a, com.obric.autogui.common.api.platform.system.IAutoActionSystemApi
    public IAutoActionThermalStateApi getThermalManager() {
        return (IAutoActionThermalStateApi) ZeusTransformUtils.preCheckCast(this.f30105d, IAutoActionThermalStateApi.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.platforms.tools.e.a, com.obric.autogui.common.api.platform.system.IAutoActionSystemApi
    public Object dumpViewHierarchy(int r19, boolean r20, d.c.d<? super com.obric.autogui.common.d<List<ViewHierarchyDump>>> r21) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, b.class) == false) goto L7;
        b r4 = (b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.aiagent.plugin");
        if ((r4.f & Integer.MIN_VALUE) == 0) goto L7;
        r4.f -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f30110d;
        Object r5 = d.c.a.b.a();
        int r6 = r4.f;
        boolean r7 = true;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        long r0 = r4.f30109c;
        boolean r8 = r4.f30108b;
        int r9 = r4.f30107a;
        d.o.a(r3);
        final long r14 = r0;
        Object r1 = r3;
        final int r11 = r9;
        boolean r10 = r8;
    L18:
        com.obric.autogui.common.d r12 = (com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r1, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin");
        if (r12.g() == false) goto L21;
        AssistStructure r13 = (AssistStructure) ZeusTransformUtils.preCheckCast(r12.a(), AssistStructure.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L26;
        Loog.INSTANCE.e(TAG, "dumpViewHierarchy: dump is null");
        return com.obric.autogui.common.d.f29012a.a("nulled_dump");
    L26:
        final long r15 = AOSystemTools.INSTANCE.nowTimeMillis();
        com.obric.autogui.platforms.tools.internal.viewhierarchy.b r16 = com.obric.autogui.platforms.tools.internal.viewhierarchy.b.f30401a;     // Catch: Throwable -> L34
        if (r10 == true) goto L31;
        r7 = false;
    L31:
        List<ViewHierarchyDump> r17 = r16.a(r13, r7);     // Catch: Throwable -> L34
        final long r18 = AOSystemTools.INSTANCE.nowTimeMillis();
        Loog.INSTANCE.dp(TAG, new $$Lambda$a$VAatDZWWd9enX96RijaVkC97eVA(r11, r15, r14, r18));
        return com.obric.autogui.common.d.f29012a.a(r17);
    L34:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "dumpViewHierarchy: exception: " + th);
        return com.obric.autogui.common.d.f29012a.a("parse_failed");
    L21:
        return com.obric.autogui.common.d.f29012a.a((e) ZeusTransformUtils.preCheckCast(r12, e.class, "com.obric.aiagent.plugin"));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r3);
        long r22 = AOSystemTools.INSTANCE.nowTimeMillis();
        ViewHierarchyDumpAsync r23 = this.f30106e;
        r4.f30107a = r19;
        r10 = r20;
        r4.f30108b = r10;
        r4.f30109c = r22;
        r4.f = 1;
        r1 = r23.a(r19, r4);
        if (r1 != r5) goto L17;
        return r5;
    L17:
        r11 = r19;
        r14 = r22;
    L7:
        r4 = new b(this, r2);
        goto L8
    }

    private static final String a(int r2, long r3, long r5, long r7) {
        return "dumpViewHierarchy (d=" + r2 + ") (latency): result=" + (r3 - r5) + "ms; parse=" + (r7 - r3) + "ms; total=" + (r7 - r5) + "ms; ";
    }
}
