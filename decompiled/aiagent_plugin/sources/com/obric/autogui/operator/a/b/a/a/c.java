package com.obric.autogui.operator.a.b.a.a;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.packages.appinfo.DoubaoMiniAppInfo;
import com.obric.autogui.common.api.platform.packages.appinfo.LauncherEntryInfo;
import com.obric.autogui.common.api.platform.packages.appinfo.LauncherItemInfo;
import com.obric.autogui.common.api.platform.packages.appinfo.LauncherShortcutInfo;
import com.obric.autogui.operator.a.b.a.b.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.k;
import d.h.a.m;
import d.h.b.h;
import d.n.j;
import d.n.l;
import d.o;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: LauncherEntryCollector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements d {
    private static final String TAG = "Op-OpenApp/LE-Coll";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f29436a = null;

    /* JADX INFO: compiled from: LauncherEntryCollector.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: LauncherEntryCollector.kt */
    @f(b = "LauncherEntryCollector.kt", c = {84, 93}, d = "invokeSuspend", e = "com.obric.autogui.operator.impl.op.openapp.appname.LauncherEntryCollector$makeExactMatchFirst$1")
    static final class b extends k implements m<l<? super com.obric.autogui.operator.a.b.a.b.a>, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29438b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f29439c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Collection<LauncherItemInfo> f29440d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f29441e;
        final /* synthetic */ c f;
        final /* synthetic */ Context g;
        private /* synthetic */ Object h;

        b(Collection<? extends LauncherItemInfo> r3, String r4, c r5, Context r6, d.c.d<? super b> r7) {
            Collection<LauncherItemInfo> r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
            Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29440d = r8;
            this.f29441e = r4;
            this.f = r5;
            this.g = ZeusTransformUtils.wrapperContext(r9, "com.obric.aiagent.plugin");
            super(2, r10);
        }

        /* JADX INFO: renamed from: lambda$MKppNUrNcZgI__sgmbQYaWi-eos, reason: not valid java name */
        public static /* synthetic */ String m831lambda$MKppNUrNcZgI__sgmbQYaWieos(LauncherItemInfo r0, String r1) {
            return a(r0, r1);
        }

        public static /* synthetic */ String lambda$lqgDM96Mv7_UMqKPx7kJtOGPbuM(String r0, LauncherItemInfo r1) {
            return a(r0, r1);
        }

        public final Object a(l<? super com.obric.autogui.operator.a.b.a.b.a> r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            b r11 = new b(this.f29440d, this.f29441e, this.f, this.g, r7);
            r11.h = r9;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r11, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(l<? super com.obric.autogui.operator.a.b.a.b.a> r3, d.c.d<? super x> r4) {
            return a((l) ZeusTransformUtils.preCheckCast(r3, l.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r13) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f29439c;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            o.a(r13);
        L23:
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            Iterator<LauncherItemInfo> r2 = (Iterator) ZeusTransformUtils.preCheckCast(this.f29438b, Iterator.class, "com.obric.aiagent.plugin");
            LinkedList r5 = (LinkedList) ZeusTransformUtils.preCheckCast(this.f29437a, LinkedList.class, "com.obric.aiagent.plugin");
            l r6 = (l) ZeusTransformUtils.preCheckCast(this.h, l.class, "com.obric.aiagent.plugin");
            o.a(r13);
        L12:
            if (r2.hasNext() == false) goto L19;
            final LauncherItemInfo r14 = (LauncherItemInfo) ZeusTransformUtils.preCheckCast(r2.next(), LauncherItemInfo.class, "com.obric.aiagent.plugin");
            if (d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(this.f29441e, CharSequence.class, "com.obric.aiagent.plugin"), r14.getLabel()) == true) goto L15;
            Loog r7 = Loog.INSTANCE;
            final String r9 = this.f29441e;
            r7.dp(c.TAG, new $$Lambda$c$b$MKppNUrNcZgI__sgmbQYaWieos(r14, r9));
            d.c.b.a.b.a(r5.add(c.a(this.f, r14, this.g, this.f29441e)));
            goto L12
        L15:
            Loog r8 = Loog.INSTANCE;
            final String r10 = this.f29441e;
            r8.dp(c.TAG, new $$Lambda$c$b$lqgDM96Mv7_UMqKPx7kJtOGPbuM(r10, r14));
            com.obric.autogui.operator.a.b.a.b.a r15 = c.a(this.f, r14, this.g, this.f29441e);
            d.c.d<? super x> r11 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r6;
            this.f29437a = r5;
            this.f29438b = r2;
            this.f29439c = 1;
            if (r6.a(r15, r11) != r0) goto L12;
            return r0;
        L19:
            Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = null;
            this.f29437a = null;
            this.f29438b = null;
            this.f29439c = 2;
            if (r6.a(r16, r3) != r0) goto L23;
            return r0;
        L10:
            o.a(r13);
            l r17 = (l) ZeusTransformUtils.preCheckCast(this.h, l.class, "com.obric.aiagent.plugin");
            LinkedList r4 = new LinkedList();
            Iterator<LauncherItemInfo> r12 = this.f29440d.iterator();
            r6 = r17;
            r5 = r4;
            r2 = r12;
            goto L12
        }

        private static final String a(String r2, LauncherItemInfo r3) {
            return " - [OpenApp|launcher-label-exact-match] viable LauncherEntry for `" + r2 + "`: " + r3;
        }

        private static final String a(LauncherItemInfo r2, String r3) {
            return " - [OpenApp|launcher-label-part-match] app " + r2.getLabel() + " !== `" + r3 + "`: " + r2;
        }
    }

    static {
        f29436a = new a(null);
    }

    private static final String a() {
        return "no launcher entry available";
    }

    private static final String b() {
        return "viable launcher entry available";
    }

    private static final String c() {
        return "unhandleable LauncherItemInfo";
    }

    public static /* synthetic */ String lambda$Ch6iqURYsOsyVFlL241d6IuxMf0(LauncherItemInfo r0) {
        return a(r0);
    }

    public static /* synthetic */ String lambda$RbCWs0ms1knbxzWj7U8mZng2cZg() {
        return c();
    }

    /* JADX INFO: renamed from: lambda$fP26Tmx5JcIXAOOyN-Klg0Wigeg, reason: not valid java name */
    public static /* synthetic */ String m830lambda$fP26Tmx5JcIXAOOyNKlg0Wigeg() {
        return a();
    }

    public static /* synthetic */ String lambda$oz04lwKLzdbbYDVB0lvCwPydoG4(String r0, List r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ String lambda$py0MDj3aqS8SCUKyYM5wuBkAEJs(String r0, List r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ String lambda$zM_YiprRCJO13GlD2U4m5SHc1lU() {
        return b();
    }

    public c() {
    }

    public static final /* synthetic */ com.obric.autogui.operator.a.b.a.b.a a(c r2, LauncherItemInfo r3, Context r4, String r5) {
        return r2.a(r3, (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), r5);
    }

    @Override // com.obric.autogui.operator.a.b.a.a.d
    public d.a a(Context r14, final String r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r16, "context");
        d.h.b.o.e(r15, "appName");
        Collection<LauncherEntryInfo> r0 = AOPackagesTools.INSTANCE.getLauncherEntriesForLabel(r16, r15, true);
        if (r0 != null) goto L5;
        r0 = (Collection) ZeusTransformUtils.preCheckCast(p.b(), Collection.class, "com.obric.aiagent.plugin");
    L5:
        Collection<LauncherShortcutInfo> r3 = AOPackagesTools.INSTANCE.getLauncherShortcutsForLabel(r16, r15, true);
        if (r3 != null) goto L8;
        r3 = (Collection) ZeusTransformUtils.preCheckCast(p.b(), Collection.class, "com.obric.aiagent.plugin");
    L8:
        final List r4 = p.c(r0, (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin"));
        if (r4.isEmpty() == false) goto L12;
        Loog.INSTANCE.ep(TAG, new $$Lambda$c$oz04lwKLzdbbYDVB0lvCwPydoG4(r15, r4), $$Lambda$c$fP26Tmx5JcIXAOOyNKlg0Wigeg.INSTANCE);
        d.a.C0758a r13 = d.a.f29442a;
        com.obric.autogui.operator.a.b.a.b r5 = com.obric.autogui.operator.a.b.a.b.h;
        String r6 = r16.getString(ZeusTransformUtils.mapRes(R.string.agent_task_open_app_failed_not_on_launcher, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_open_app_failed_not_on_launcher"), new Object[]{r15});
        d.h.b.o.c(r6, "getString(...)");
        return r13.a(new com.obric.autogui.operator.a.b.a.c(r5, r6, "appName=" + r15 + ", found=" + r0, null, null, false, null, 120, null));
    L12:
        Loog.INSTANCE.ip(TAG, new $$Lambda$c$py0MDj3aqS8SCUKyYM5wuBkAEJs(r15, r4), $$Lambda$c$zM_YiprRCJO13GlD2U4m5SHc1lU.INSTANCE);
        return new d.a(com.obric.autogui.operator.a.b.a.c.f29521a.a(), a(r16, (Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin"), r15));
    }

    private static final String a(String r2, List r3) {
        return "no launcher entry available (appName=" + r2 + "), found=" + ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    private static final String b(String r2, List r3) {
        return "viable launcher entry available for (appName=" + r2 + "), found=" + ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin")).size();
    }

    private final j<com.obric.autogui.operator.a.b.a.b.a> a(Context r9, Collection<? extends LauncherItemInfo> r10, String r11) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        return d.n.m.a((m) ZeusTransformUtils.preCheckCast(new b((Collection) ZeusTransformUtils.wrapperContextForParams(r10, Collection.class, "com.obric.aiagent.plugin"), r11, this, r6, null), m.class, "com.obric.aiagent.plugin"));
    }

    private final com.obric.autogui.operator.a.b.a.b.a a(final LauncherItemInfo r9, Context r10, String r11) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, LauncherEntryInfo.class) == false) goto L7;
        return (com.obric.autogui.operator.a.b.a.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.a.b.d(((LauncherEntryInfo) ZeusTransformUtils.preCheckCast(r9, LauncherEntryInfo.class, "com.obric.aiagent.plugin")).getIntent(), r11), com.obric.autogui.operator.a.b.a.b.a.class, "com.obric.aiagent.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r9, DoubaoMiniAppInfo.class) == false) goto L11;
        return (com.obric.autogui.operator.a.b.a.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.a.b.f(((DoubaoMiniAppInfo) ZeusTransformUtils.preCheckCast(r9, DoubaoMiniAppInfo.class, "com.obric.aiagent.plugin")).getShortcutId(), r9.getAppPackageName(), r11, ((DoubaoMiniAppInfo) ZeusTransformUtils.preCheckCast(r9, DoubaoMiniAppInfo.class, "com.obric.aiagent.plugin")).getMiniAppId()), com.obric.autogui.operator.a.b.a.b.a.class, "com.obric.aiagent.plugin");
    L11:
        if (ZeusTransformUtils.instanceOf(r9, LauncherShortcutInfo.class) == true) goto L13;
        Loog.INSTANCE.ep(TAG, new $$Lambda$c$Ch6iqURYsOsyVFlL241d6IuxMf0(r9), $$Lambda$c$RbCWs0ms1knbxzWj7U8mZng2cZg.INSTANCE);
        return (com.obric.autogui.operator.a.b.a.b.a) ZeusTransformUtils.preCheckCast(new e(r8, r9.getAppPackageName()), com.obric.autogui.operator.a.b.a.b.a.class, "com.obric.aiagent.plugin");
    L13:
        return (com.obric.autogui.operator.a.b.a.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.a.b.f(((LauncherShortcutInfo) ZeusTransformUtils.preCheckCast(r9, LauncherShortcutInfo.class, "com.obric.aiagent.plugin")).getShortcutId(), r9.getAppPackageName(), r11, null, 8, null), com.obric.autogui.operator.a.b.a.b.a.class, "com.obric.aiagent.plugin");
    }

    private static final String a(LauncherItemInfo r2) {
        return "unhandleable LauncherItemInfo: " + r2 + " -> falling back to PackageOpener";
    }
}
