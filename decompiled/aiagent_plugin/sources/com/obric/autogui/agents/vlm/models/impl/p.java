package com.obric.autogui.agents.vlm.models.impl;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.google.gson.Gson;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.agents.vlm.models.omni.r;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListEvent;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListEventHolder;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.ax;
import d.h.b.z;
import d.x;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import os.teatracker.IBdInstall;

/* JADX INFO: compiled from: StandardModelUnsolicitedBlackListHandlingStep.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p extends i implements com.obric.autogui.agents.vlm.models.a.e {
    private static final String TAG = "StdMod/BlackListChk";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f27977d = null;
    private static final Set<Character> i = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f27978e;
    private String g;
    private final String h;

    /* JADX INFO: compiled from: StandardModelUnsolicitedBlackListHandlingStep.kt */
    public static final class a {

        /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.p$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: StandardModelUnsolicitedBlackListHandlingStep.kt */
        public static final enum EnumC0701a extends Enum<EnumC0701a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final EnumC0701a f27979a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final EnumC0701a f27980b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private static final /* synthetic */ EnumC0701a[] f27981c = null;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private static final /* synthetic */ d.d.a f27982d = null;

            private static final /* synthetic */ EnumC0701a[] a() {
                return new EnumC0701a[]{f27979a, f27980b};
            }

            private EnumC0701a(String r1, int r2) {
                super(r1, r2);
            }

            static {
                f27979a = new EnumC0701a("Soft", 0);
                f27980b = new EnumC0701a("UserDefined", 1);
                EnumC0701a[] r0 = a();
                f27981c = r0;
                f27982d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
            }

            public static EnumC0701a valueOf(String r2) {
                return (EnumC0701a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0701a.class, r2), EnumC0701a.class, "com.obric.aiagent.plugin");
            }

            public static EnumC0701a[] values() {
                return (EnumC0701a[]) ZeusTransformUtils.preCheckCast(f27981c.clone(), EnumC0701a[].class, "com.obric.aiagent.plugin");
            }
        }

        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    private static final String L() {
        return "Intercepted clarify-text= cleansed=, pos=, cle=";
    }

    public static /* synthetic */ String lambda$JTx_2YEdHtpYwuEmzYwl3KYXc_0() {
        return L();
    }

    public static /* synthetic */ String lambda$TxhDC2bO4crKDVf8ndDZzcqR4Z4(String r0, String r1, z.a r2, z.a r3) {
        return a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$mBRqYr-o3xst59k2KSBxv_TYHwA, reason: not valid java name */
    public static /* synthetic */ x m765lambda$mBRqYro3xst59k2KSBxv_TYHwA(p r0, r r1) {
        return a(r0, r1);
    }

    public abstract Set<String> J();

    public abstract Set<String> K();

    @Override // com.obric.autogui.agents.vlm.models.impl.i, com.obric.autogui.agents.vlm.models.impl.e, com.obric.autogui.agents.vlm.models.impl.g
    public Object a(com.obric.autogui.session.a r3, d.c.d<? super com.obric.autogui.operator.g> r4) {
        return a(this, r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.i
    public void a(com.obric.autogui.session.functions.impl.c r1) {
        d.h.b.o.e(r1, "clarifyFunction");
    }

    public abstract void b(Context r1);

    public abstract void c(boolean r1);

    public abstract a.EnumC0701a getType();

    @Override // com.obric.autogui.agents.vlm.models.impl.i, com.obric.autogui.agents.vlm.models.impl.e, com.obric.autogui.agents.vlm.models.impl.g, com.obric.autogui.agents.vlm.models.a.d
    public boolean h() {
        return false;
    }

    public p() {
        this.h = "app_blacklist";
    }

    static {
        f27977d = new a(null);
        i = ax.a(new Character[]{(char) 65292, (char) 12290, (char) 12289, (char) 65311, (char) 65281});
    }

    public final String I() {
        return this.f27978e;
    }

    public final void l(String r1) {
        this.f27978e = r1;
    }

    public final void m(String r1) {
        this.g = r1;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.i
    public final String G() {
        return this.h;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.i
    public final Map<String, String> H() {
        Map r0 = ao.a();
        String r1 = this.f27978e;
        String r2 = null;
        if (r1 != null) goto L5;
    L10:
        String r5 = this.g;
        if (r5 == null) goto L18;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L15;
        r2 = r5;
    L15:
        if (r2 == null) goto L18;
        r0.put("package_name", r2);
    L18:
        return ao.a(r0);
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L10;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r0.put(IBdInstall.PARAM_APP_NAME, r1), String.class, "com.obric.aiagent.plugin");
        goto L10
    }

    static /* synthetic */ Object a(final p r2, com.obric.autogui.session.a r3, d.c.d<? super com.obric.autogui.operator.g> r4) {
        d.c.d<? super com.obric.autogui.operator.g> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        r3.a(new $$Lambda$p$mBRqYro3xst59k2KSBxv_TYHwA(r2));
        return super.a(r3, r5);
    }

    private static final x a(p r1, r r2) {
        d.h.b.o.e(r2, "it");
        String r0 = r1.E();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        List<String> r3 = r1.F();
        if (r3 != null) goto L8;
        r3 = d.a.p.b();
    L8:
        r2.a(r0, r3);
        return x.f38692a;
    }

    private static final String a(String r2, String r3, z.a r4, z.a r5) {
        return "- [BL] intercepted clarify-text=" + r2 + ", cleansed=" + r3 + ", pos=" + r4.f38499a + ", cle=" + r5.f38499a;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.i, com.obric.autogui.agents.vlm.models.impl.e, com.obric.autogui.agents.vlm.models.impl.g, com.obric.autogui.agents.vlm.models.a.d
    public Bundle g() {
        Bundle r0 = super.g();
        if (r0 != null) goto L5;
        r0 = new Bundle();
    L5:
        String r6 = "";
        if (getType() != a.EnumC0701a.f27979a) goto L11;
        com.obric.autogui.agents.vlm.models.impl.applist.black.i r1 = com.obric.autogui.agents.vlm.models.impl.applist.a.f27315a.a();
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        int r5 = ZeusTransformUtils.mapRes(R.string.std_model_blcl_uc4_b_short, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_blcl_uc4_b_short");
        Object[] r4 = new Object[1];
        String r8 = this.f27978e;
        if (r8 != null) goto L10;
        r8 = "";
    L10:
        r4[0] = r8;
        String r3 = r1.a(r2, "blcl_uc4_b_content_short", r5, r4);
    L15:
        Gson r7 = com.obric.eventkit.eventstaskmanager.b.a();
        List<String> r9 = F();
        String r10 = null;
        if (r9 == null) goto L18;
        String r11 = (String) ZeusTransformUtils.preCheckCast(d.a.p.l(r9), String.class, "com.obric.aiagent.plugin");
    L19:
        if (r11 != null) goto L21;
        r11 = "";
    L21:
        List<String> r12 = F();
        if (r12 == null) goto L24;
        r10 = (String) ZeusTransformUtils.preCheckCast(d.a.p.n(r12), String.class, "com.obric.aiagent.plugin");
    L24:
        if (r10 == null) goto L27;
        r6 = r10;
    L27:
        r0.putString("clarify_blacklist_params", r7.toJson(new IAutoAgentWidgetStateListener.ClarifyBlackListParams(r3, r6, r11)));
        r0.putString("clarify_type", "BLACKLIST");
        return r0;
    L18:
        r11 = null;
        goto L19
    L11:
        com.obric.autogui.agents.vlm.models.impl.applist.black.i r13 = com.obric.autogui.agents.vlm.models.impl.applist.a.f27315a.a();
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        int r15 = ZeusTransformUtils.mapRes(R.string.std_model_blcl_uc4_c_short, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_blcl_uc4_c_short");
        Object[] r16 = new Object[1];
        String r17 = this.f27978e;
        if (r17 != null) goto L14;
        r17 = "";
    L14:
        r16[0] = r17;
        r3 = r13.a(r14, "blcl_uc4_c_content_short", r15, r16);
        goto L15
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.i
    public boolean a(com.obric.autogui.session.a r11, final String r12) {
        d.h.b.o.e(r11, SensitiveType.SESSION);
        d.h.b.o.e(r12, "text");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin");
        Appendable r2 = (Appendable) ZeusTransformUtils.preCheckCast(new StringBuilder(), Appendable.class, "com.obric.aiagent.plugin");
        int r3 = r0.length();
        int r5 = 0;
    L4:
        if (r5 >= r3) goto L9;
        char r7 = r0.charAt(r5);
        if ((true ^ i.contains(Character.valueOf(r7))) == false) goto L8;
        r2.append(r7);
    L8:
        r5 = r5 + 1;
        goto L4
    L9:
        String r1 = ((StringBuilder) ZeusTransformUtils.preCheckCast(r2, StringBuilder.class, "com.obric.aiagent.plugin")).toString();
        d.h.b.o.c(r1, "toString(...)");
        final String r4 = r1.toLowerCase(Locale.ROOT);
        d.h.b.o.c(r4, "toLowerCase(...)");
        final z.a r6 = new z.a();
        final z.a r8 = new z.a();
        Set<String> r9 = J();
        if (r9 != null) goto L12;
    L14:
        Set<String> r10 = K();
        if (r10 != null) goto L17;
    L19:
        Loog.INSTANCE.ip(TAG, new $$Lambda$p$TxhDC2bO4crKDVf8ndDZzcqR4Z4(r12, r4, r8, r6), $$Lambda$p$JTx_2YEdHtpYwuEmzYwl3KYXc_0.INSTANCE);
        AppBlackListEvent r13 = AppBlackListEventHolder.INSTANCE.getBlackListEvent();
        if (r13 == null) goto L23;
        r13.setAcknowledged(true);
    L23:
        if (r6.f38499a == false) goto L25;
        c(r8.f38499a);
    L26:
        return true;
    L25:
        b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        goto L26
    L17:
        if (r10.contains(r4) == false) goto L19;
        r6.f38499a = true;
        r8.f38499a = false;
        goto L19
    L12:
        if (r9.contains(r4) == false) goto L14;
        r6.f38499a = true;
        r8.f38499a = true;
        goto L14
    }
}
