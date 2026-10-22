package com.obric.autoaction.app.launcherpage.utils;

import android.content.Context;
import android.content.pm.ShortcutInfo;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.model.EventTask;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.cx;

/* JADX INFO: compiled from: PinShortcutAccountSyncer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {
    private static final String TAG = "PinShortcutAccountSyncer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f24490a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final am f24491b = null;

    /* JADX INFO: compiled from: PinShortcutAccountSyncer.kt */
    @d.c.b.a.f(b = "PinShortcutAccountSyncer.kt", c = {139}, d = "hasTask", e = "com.obric.autoaction.app.launcherpage.utils.PinShortcutAccountSyncer")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f24492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f24493b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f24494c;

        a(h r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24493b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f24492a = r3;
            this.f24494c |= Integer.MIN_VALUE;
            return h.a(this.f24493b, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: PinShortcutAccountSyncer.kt */
    @d.c.b.a.f(b = "PinShortcutAccountSyncer.kt", c = {98, 116}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.utils.PinShortcutAccountSyncer$syncAllInternal$1$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f24495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f24496b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f24497c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f24498d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f24499e;
        Object f;
        int g;
        final /* synthetic */ Context h;
        final /* synthetic */ IFlowAppIntentIDL i;

        b(Context r3, IFlowAppIntentIDL r4, d.c.d<? super b> r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            IFlowAppIntentIDL r7 = (IFlowAppIntentIDL) ZeusTransformUtils.wrapperContextForParams(r4, IFlowAppIntentIDL.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
            this.i = r7;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.h, this.i, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x0287 -> B:78:0x02f8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0295 -> B:78:0x02f8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x02a6 -> B:78:0x02f8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x02e0 -> B:74:0x02e3). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r18) {
            Object r1 = d.c.a.b.a();
            int r2 = this.g;
            int r6 = 1;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            String r3 = (String) ZeusTransformUtils.preCheckCast(this.f, String.class, "com.obric.aiagent.plugin");
            Iterator r9 = (Iterator) ZeusTransformUtils.preCheckCast(this.f24499e, Iterator.class, "com.obric.aiagent.plugin");
            List<String> r10 = (List) ZeusTransformUtils.preCheckCast(this.f24498d, List.class, "com.obric.aiagent.plugin");
            List<String> r11 = (List) ZeusTransformUtils.preCheckCast(this.f24497c, List.class, "com.obric.aiagent.plugin");
            List<String> r12 = (List) ZeusTransformUtils.preCheckCast(this.f24496b, List.class, "com.obric.aiagent.plugin");
            String r13 = (String) ZeusTransformUtils.preCheckCast(this.f24495a, String.class, "com.obric.aiagent.plugin");
            d.o.a(r18);
            String r5 = r3;
            Object r4 = r18;
        L75:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L77;
            r12.add(r5);
        L78:
            r6 = 1;
        L52:
            if (r9.hasNext() == false) goto L80;
            ShortcutInfo r7 = (ShortcutInfo) ZeusTransformUtils.preCheckCast(r9.next(), ShortcutInfo.class, "com.obric.aiagent.plugin");
            r5 = r7.getId();
            d.h.b.o.c(r5, "getId(...)");
            String r8 = g.f24481a.a(r7);
            CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin");
            if (r14 != null) goto L56;
        L59:
            int r15 = r6;
        L60:
            if (r15 == 0) goto L69;
            h r16 = h.f24490a;
            this.f24495a = r13;
            this.f24496b = r12;
            this.f24497c = r11;
            this.f24498d = r10;
            this.f24499e = r9;
            this.f = r5;
            this.g = r6;
            Object r17 = h.a(r16, r5, this);
            if (r17 != r1) goto L65;
            return r1;
        L65:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r17, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L67;
            Loog.INSTANCE.i(h.TAG, "task uid is empty,now database has this task");
            r12.add(r5);
            r10.add(r5);
            goto L78
        L67:
            Loog.INSTANCE.i(h.TAG, "task uid is empty, and now database don't has this task");
            r11.add(r5);
            goto L78
        L69:
            if (d.h.b.o.a(r8, r13) == true) goto L71;
            Loog.INSTANCE.i(h.TAG, "task uid not same task:" + r8 + "  current: " + r13);
            r11.add(r5);
            goto L78
        L71:
            h r19 = h.f24490a;
            this.f24495a = r13;
            this.f24496b = r12;
            this.f24497c = r11;
            this.f24498d = r10;
            this.f24499e = r9;
            this.f = r5;
            this.g = 2;
            r4 = h.a(r19, r5, this);
            if (r4 != r1) goto L75;
            return r1;
        L56:
            if (r14.length() == 0) goto L59;
            r15 = 0;
            goto L60
        L80:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L82;
            g r20 = g.f24481a;
            Context r21 = this.h;
            d.h.b.o.a(r13);
            r20.a(r21, r10, r13);
        L82:
            List<String> r22 = r10;
            List<String> r110 = r11;
            List<String> r111 = r12;
        L83:
            Loog.INSTANCE.i(h.TAG, "syncAll enable=" + r111.size() + " disable=" + r110.size() + " backfill=" + r22.size());
            g.f24481a.a(this.h, r111);
            g.f24481a.b(this.h, r110);
            return x.f38692a;
        L77:
            r11.add(r5);
            goto L78
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            String r23 = (String) ZeusTransformUtils.preCheckCast(this.f, String.class, "com.obric.aiagent.plugin");
            r9 = (Iterator) ZeusTransformUtils.preCheckCast(this.f24499e, Iterator.class, "com.obric.aiagent.plugin");
            r10 = (List) ZeusTransformUtils.preCheckCast(this.f24498d, List.class, "com.obric.aiagent.plugin");
            r11 = (List) ZeusTransformUtils.preCheckCast(this.f24497c, List.class, "com.obric.aiagent.plugin");
            r12 = (List) ZeusTransformUtils.preCheckCast(this.f24496b, List.class, "com.obric.aiagent.plugin");
            r13 = (String) ZeusTransformUtils.preCheckCast(this.f24495a, String.class, "com.obric.aiagent.plugin");
            d.o.a(r18);
            r5 = r23;
            r17 = r18;
            goto L65
        L10:
            d.o.a(r18);
            List<ShortcutInfo> r24 = g.f24481a.a(this.h);
            if (r24.isEmpty() == false) goto L14;
            Loog.INSTANCE.i(h.TAG, "syncAll skip, no pin shortcut");
            return x.f38692a;
        L14:
            Iterable r25 = (Iterable) ZeusTransformUtils.preCheckCast(r24, Iterable.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r25, Collection.class) == true) goto L17;
        L19:
            Iterator r26 = r25.iterator();
        L21:
            if (r26.hasNext() == false) goto L18;
            if (d.h.b.o.a(((ShortcutInfo) ZeusTransformUtils.preCheckCast(r26.next(), ShortcutInfo.class, "com.obric.aiagent.plugin")).getId(), "launcher_page_icon_shortcut") == false) goto L21;
            boolean r27 = true;
        L25:
            Iterable r28 = (Iterable) ZeusTransformUtils.preCheckCast(r24, Iterable.class, "com.obric.aiagent.plugin");
            Collection r112 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r29 = r28.iterator();
        L27:
            if (r29.hasNext() == false) goto L31;
            Object r113 = r29.next();
            String r114 = ((ShortcutInfo) ZeusTransformUtils.preCheckCast(r113, ShortcutInfo.class, "com.obric.aiagent.plugin")).getId();
            d.h.b.o.c(r114, "getId(...)");
            if (d.o.o.b(r114, "st_", false, 2, null) == false) goto L27;
            r112.add(r113);
            goto L27
        L31:
            List r30 = (List) ZeusTransformUtils.preCheckCast(r112, List.class, "com.obric.aiagent.plugin");
            if (r27 == false) goto L34;
        L37:
            if (r27 == false) goto L39;
            e.f24474a.d(this.h);
        L39:
            boolean r115 = this.i.isEnterpriseAccount();
            String r116 = this.i.getUserId();
            Loog.INSTANCE.i(h.TAG, "PinShortcutAccountSyncer start sync isEnterpriseAccount:" + r115 + " currentUid:" + r116);
            r111 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            r110 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            r22 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            if (r115 == false) goto L48;
            Iterable r31 = (Iterable) ZeusTransformUtils.preCheckCast(r30, Iterable.class, "com.obric.aiagent.plugin");
            Collection r32 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r31, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r33 = r31.iterator();
        L43:
            if (r33.hasNext() == false) goto L45;
            String r34 = ((ShortcutInfo) ZeusTransformUtils.preCheckCast(r33.next(), ShortcutInfo.class, "com.obric.aiagent.plugin")).getId();
            d.h.b.o.c(r34, "getId(...)");
            r32.add(r34);
            goto L43
        L45:
            r110.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r32, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin"));
            if (r27 == false) goto L83;
            r110.add("launcher_page_icon_shortcut");
            goto L83
        L48:
            if (r27 == false) goto L50;
            r111.add("launcher_page_icon_shortcut");
        L50:
            r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r30, Iterable.class, "com.obric.aiagent.plugin")).iterator();
            r10 = r22;
            r11 = r110;
            r13 = r116;
            r12 = r111;
            goto L52
        L34:
            if (r30.isEmpty() == false) goto L37;
            Loog.INSTANCE.i(h.TAG, "syncAll skip, no owned pin shortcut");
            return x.f38692a;
        L18:
            r27 = false;
            goto L25
        L17:
            if (((Collection) ZeusTransformUtils.preCheckCast(r25, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L19;
            goto L18
        }
    }

    /* JADX INFO: renamed from: lambda$fVV-G4MddMEeK6xRgcrR1JB3bzE, reason: not valid java name */
    public static /* synthetic */ void m569lambda$fVVG4MddMEeK6xRgcrR1JB3bzE(Context r0, IFlowAppIntentIDL r1) {
        a(r0, r1);
    }

    private h() {
    }

    public static final /* synthetic */ Object a(h r2, String r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static {
        f24490a = new h();
        f24491b = an.a(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
    }

    public final void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "context");
        b(r4);
    }

    private final void b(Context r7) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.assistant.idl.r.a(aa.b(IFlowAppIntentIDL.class), false, false, new $$Lambda$h$fVVG4MddMEeK6xRgcrR1JB3bzE(r6), 3, null);
    }

    private static final void a(Context r8, IFlowAppIntentIDL r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        IFlowAppIntentIDL r11 = (IFlowAppIntentIDL) ZeusTransformUtils.wrapperContextForParams(r9, IFlowAppIntentIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "ipc");
        kotlinx.coroutines.i.a(f24491b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r10, r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final Object a(String r7, d.c.d<? super Boolean> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
        if ((r0.f24494c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f24494c -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f24492a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f24494c;
        boolean r5 = true;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        d.o.a(r10);     // Catch: Throwable -> L28
    L21:
        EventTask r6 = (EventTask) ZeusTransformUtils.preCheckCast(r10, EventTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
    L23:
        if (r6 != null) goto L26;
        r5 = false;
    L26:
        Object r11 = d.n.f(d.c.b.a.b.a(r5));     // Catch: Throwable -> L28
    L30:
        Boolean r12 = d.c.b.a.b.a(false);
        if (d.n.b(r11) == true) goto L33;
        return r11;
    L33:
        return r12;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        d.o.a(r10);
        d.n.a r13 = d.n.f38560a;     // Catch: Throwable -> L28
        h r14 = (h) ZeusTransformUtils.preCheckCast(this, h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        IEventTaskApi r15 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        if (r15 == null) goto L22;
        r0.f24494c = 1;     // Catch: Throwable -> L28
        r10 = r15.getEventTask(r7, r0);     // Catch: Throwable -> L28
        if (r10 != r2) goto L21;
        return r2;
    L22:
        r6 = null;
    L28:
        th = move-exception;
        d.n.a r16 = d.n.f38560a;
        r11 = d.n.f(d.o.a(th));
    L7:
        r0 = new a(this, r9);
        goto L8
    }
}
