package com.obric.autogui.operator.a.b.a.a;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.k;
import d.h.a.m;
import d.h.b.h;
import d.h.b.z;
import d.n.l;
import d.o;
import d.s;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: AppLabelCollector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements d {
    private static final String TAG = "Op-OpenApp/AL-Coll";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0756a f29420a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f29421b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, String> f29422c = null;

    /* JADX INFO: renamed from: com.obric.autogui.operator.a.b.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppLabelCollector.kt */
    public static final class C0756a {
        public /* synthetic */ C0756a(h r1) {
            this();
        }

        private C0756a() {
        }
    }

    /* JADX INFO: compiled from: AppLabelCollector.kt */
    @f(b = "AppLabelCollector.kt", c = {85, 91}, d = "invokeSuspend", e = "com.obric.autogui.operator.impl.op.openapp.appname.AppLabelCollector$collect$1")
    static final class b extends k implements m<l<? super com.obric.autogui.operator.a.b.a.b.a>, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29423a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29424b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f29425c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f29426d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f29427e;
        final /* synthetic */ z.f<Collection<String>> f;
        final /* synthetic */ Context g;
        final /* synthetic */ String h;
        private /* synthetic */ Object i;

        b(z.f<Collection<String>> r3, Context r4, String r5, d.c.d<? super b> r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            this.g = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
            this.h = r5;
            super(2, r8);
        }

        public final Object a(l<? super com.obric.autogui.operator.a.b.a.b.a> r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            b r0 = new b(this.f, this.g, this.h, r7);
            r0.i = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(l<? super com.obric.autogui.operator.a.b.a.b.a> r3, d.c.d<? super x> r4) {
            return a((l) ZeusTransformUtils.preCheckCast(r3, l.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Type inference failed for: r12v14, types: [T, com.obric.autogui.operator.a.b.a.b.a] */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f29427e;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            o.a(r12);
        L29:
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            Iterator r2 = (Iterator) ZeusTransformUtils.preCheckCast(this.f29426d, Iterator.class, "com.obric.aiagent.plugin");
            String r5 = (String) ZeusTransformUtils.preCheckCast(this.f29425c, String.class, "com.obric.aiagent.plugin");
            Context r6 = (Context) ZeusTransformUtils.preCheckCast(this.f29424b, Context.class, "com.obric.aiagent.plugin");
            z.f r7 = (z.f) ZeusTransformUtils.preCheckCast(this.f29423a, z.f.class, "com.obric.aiagent.plugin");
            l r8 = (l) ZeusTransformUtils.preCheckCast(this.i, l.class, "com.obric.aiagent.plugin");
            o.a(r12);
        L12:
            if (r2.hasNext() == false) goto L23;
            String r13 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");
            com.obric.autogui.operator.a.b.a.d.a r14 = com.obric.autogui.operator.a.b.a.d.f29526a.a(r6, r13, r5);
            if (r14 == null) goto L12;
            if (r14.b() == true) goto L17;
            if (r7.f38504a != 0) goto L12;
            r7.f38504a = r14.a();
            goto L12
        L17:
            com.obric.autogui.operator.a.b.a.b.a r15 = r14.a();
            this.i = r8;
            this.f29423a = r7;
            this.f29424b = r6;
            this.f29425c = r5;
            this.f29426d = r2;
            this.f29427e = 1;
            if (r8.a(r15, this) != r0) goto L12;
            return r0;
        L23:
            com.obric.autogui.operator.a.b.a.b.a r16 = (com.obric.autogui.operator.a.b.a.b.a) ZeusTransformUtils.preCheckCast(r7.f38504a, com.obric.autogui.operator.a.b.a.b.a.class, "com.obric.aiagent.plugin");
            if (r16 == null) goto L29;
            this.i = null;
            this.f29423a = null;
            this.f29424b = null;
            this.f29425c = null;
            this.f29426d = null;
            this.f29427e = 2;
            if (r8.a(r16, this) != r0) goto L29;
            return r0;
        L10:
            o.a(r12);
            l r17 = (l) ZeusTransformUtils.preCheckCast(this.i, l.class, "com.obric.aiagent.plugin");
            z.f r3 = new z.f();
            Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(this.f.f38504a, Iterable.class, "com.obric.aiagent.plugin");
            r6 = this.g;
            String r10 = this.h;
            r8 = r17;
            r7 = r3;
            r2 = r9.iterator();
            r5 = r10;
            goto L12
        }
    }

    public a() {
    }

    static {
        f29420a = new C0756a(null);
        f29422c = ao.a(new d.m[]{s.a("飞书", "com.ss.android.lark"), s.a("飛書", "com.ss.android.lark"), s.a("lark", "com.ss.android.lark"), s.a("feishu", "com.ss.android.lark"), s.a("微信", "com.tencent.mm"), s.a("weixin", "com.tencent.mm"), s.a("wechat", "com.tencent.mm")});
    }

    /* JADX WARN: Type inference failed for: r1v22, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, java.util.Collection] */
    @Override // com.obric.autogui.operator.a.b.a.a.d
    public d.a a(Context r12, String r13) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "context");
        d.h.b.o.e(r13, "appName");
        z.f r14 = new z.f();
        r14.f38504a = IAutoActionPackagesApi.DefaultImpls.getPackageNamesForLabel$default((IAutoActionPackagesApi) ZeusTransformUtils.preCheckCast(AOPackagesTools.INSTANCE, IAutoActionPackagesApi.class, "com.obric.aiagent.plugin"), r11, r13, false, 4, null);
        if (((Collection) ZeusTransformUtils.preCheckCast(r14.f38504a, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L10;
        if (f29421b == false) goto L10;
        String r1 = (String) ZeusTransformUtils.preCheckCast(f29422c.get(r13), String.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L10;
        r14.f38504a = p.a(r1);
    L10:
        if (((Collection) ZeusTransformUtils.preCheckCast(r14.f38504a, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L14;
        Loog.INSTANCE.e(TAG, "no installed package available (appName=" + r13 + ')');
        d.a.C0758a r15 = d.a.f29442a;
        com.obric.autogui.operator.a.b.a.b r2 = com.obric.autogui.operator.a.b.a.b.f;
        String r3 = r11.getString(ZeusTransformUtils.mapRes(R.string.agent_task_open_app_failed_not_installed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_open_app_failed_not_installed"), new Object[]{r13});
        d.h.b.o.c(r3, "getString(...)");
        return r15.a(new com.obric.autogui.operator.a.b.a.c(r2, r3, "appName=" + r13, null, null, false, null, 120, null));
    L14:
        return new d.a(com.obric.autogui.operator.a.b.a.c.f29521a.a(), d.n.m.a((m) ZeusTransformUtils.preCheckCast(new b(r14, r11, r13, null), m.class, "com.obric.aiagent.plugin")));
    }
}
