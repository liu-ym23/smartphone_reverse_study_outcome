package com.obric.autogui.evaluation.a;

import android.content.Context;
import android.content.Intent;
import com.obric.autogui.common.api.presentation.AOUserInterfaceTools;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.o;
import d.x;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: KnowledgeDebugBindingSignedCallingExecutor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f29065a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f29066b = null;

    /* JADX INFO: renamed from: com.obric.autogui.evaluation.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: KnowledgeDebugBindingSignedCallingExecutor.kt */
    @d.c.b.a.f(b = "KnowledgeDebugBindingSignedCallingExecutor.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.evaluation.signedcalling.KnowledgeDebugBindingSignedCallingExecutor$execute$2")
    static final class C0731a extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f29067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f29068b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f29069c;

        C0731a(Context r3, String r4, d.c.d<? super C0731a> r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29068b = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
            this.f29069c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((C0731a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0731a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0731a(this.f29068b, this.f29069c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f29067a != 0) goto L7;
            o.a(r4);
            AOUserInterfaceTools.INSTANCE.showAppToast(this.f29068b, (CharSequence) ZeusTransformUtils.preCheckCast("Completed with kId=" + this.f29069c, CharSequence.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private a() {
    }

    public final void a() {
        d.f29074a.a((d.a) ZeusTransformUtils.preCheckCast(this, d.a.class, "com.obric.aiagent.plugin"));
    }

    static {
        f29065a = new a();
        f29066b = "knowledge_binding_260319";
    }

    @Override // com.obric.autogui.evaluation.a.d.a
    public String b() {
        return f29066b;
    }

    @Override // com.obric.autogui.evaluation.a.d.a
    public Object a(Context r3, Intent r4, d.c.d<? super com.obric.autogui.common.e> r5) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        String r7 = r4.getStringExtra("knowledge_id");
        if (r7 != null) goto L5;
        r7 = r4.getStringExtra("payload");
    L5:
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L8;
    L11:
        boolean r9 = true;
    L12:
        if (r9 == true) goto L14;
        b.f29070a.update(r7);
        AOThreadingTools.INSTANCE.launchUI((m) ZeusTransformUtils.preCheckCast(new C0731a(r2, r7, null), m.class, "com.obric.aiagent.plugin"));
        return com.obric.autogui.common.e.f29014b.a();
    L14:
        return com.obric.autogui.common.e.f29014b.b("knowledge_id missing");
    L8:
        if (d.o.o.d(r8) == true) goto L11;
        r9 = false;
        goto L12
    }
}
