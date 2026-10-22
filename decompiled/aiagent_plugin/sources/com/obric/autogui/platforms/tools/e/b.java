package com.obric.autogui.platforms.tools.e;

import android.content.Context;
import android.widget.Toast;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.ui.IAutoActionUIApi;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.x;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: StandardUIImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements IAutoActionUIApi {
    private static final String TAG = "Std/UI";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30217a = null;

    /* JADX INFO: compiled from: StandardUIImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.e.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: StandardUIImpl.kt */
    @f(b = "StandardUIImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.system.StandardUIImpl$showToast$1")
    static final class C0808b extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f30219b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ CharSequence f30220c;

        C0808b(Context r3, CharSequence r4, d<? super C0808b> r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
            d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.f30219b = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
            this.f30220c = r7;
            super(2, r8);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((C0808b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C0808b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r3, d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C0808b(this.f30219b, this.f30220c, r5), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f30218a != 0) goto L7;
            o.a(r2);
            Toast.makeText(this.f30219b, this.f30220c, 1).show();
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: StandardUIImpl.kt */
    @f(b = "StandardUIImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.system.StandardUIImpl$showToast$2")
    static final class c extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30221a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f30222b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f30223c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f30224d;

        c(Context r3, int r4, boolean r5, d<? super c> r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            this.f30222b = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
            this.f30223c = r4;
            this.f30224d = r5;
            super(2, r8);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r4, d<?> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new c(this.f30222b, this.f30223c, this.f30224d, r6), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f30221a != 0) goto L7;
            o.a(r4);
            Context r5 = this.f30222b;
            Toast.makeText(r5, (CharSequence) ZeusTransformUtils.preCheckCast(r5.getString(this.f30223c), CharSequence.class, "com.obric.aiagent.plugin"), !this.f30224d ? 1 : 0).show();
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f30217a = new a(null);
    }

    public b() {
    }

    @Override // com.obric.autogui.common.api.platform.ui.IAutoActionUIApi
    public void showToast(CharSequence r4, Context r5) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "text");
        if (r6 != null) goto L5;
        r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L5:
        AOThreadingTools.INSTANCE.launchUI((m) ZeusTransformUtils.preCheckCast(new C0808b(r6, r3, null), m.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.platform.ui.IAutoActionUIApi
    public void showToast(int r4, boolean r5, Context r6) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        if (r4 != 0) goto L6;
        Loog.INSTANCE.e(TAG, "[Toast] InvalidResId -> " + r4);
        return;
    L6:
        if (r3 != null) goto L8;
        r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L8:
        AOThreadingTools.INSTANCE.launchUI((m) ZeusTransformUtils.preCheckCast(new c(r3, r4, r5, null), m.class, "com.obric.aiagent.plugin"));
    }
}
