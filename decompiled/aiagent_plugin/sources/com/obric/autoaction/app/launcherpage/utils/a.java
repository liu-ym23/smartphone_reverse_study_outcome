package com.obric.autoaction.app.launcherpage.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.keva.Keva;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.model.EventTask;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.Collection;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: AddIconGuideHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24463a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Keva f24464b = null;

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.utils.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AddIconGuideHelper.kt */
    @d.c.b.a.f(b = "AddIconGuideHelper.kt", c = {78, 79}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.utils.AddIconGuideHelper$shouldShowCoachMarkGuide$2")
    static final class C0562a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f24466b;

        C0562a(Context r3, d.c.d<? super C0562a> r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24466b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((C0562a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0562a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0562a(this.f24466b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24465a;
            List r2 = null;
            boolean r4 = false;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            d.o.a(r8);
        L30:
            r2 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
        L31:
            Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin");
            if (r9 != null) goto L34;
        L37:
            boolean r10 = true;
        L38:
            if (r10 == false) goto L41;
            boolean r11 = false;
        L43:
            if (a.b(a.f24463a) == false) goto L49;
            if (r11 == false) goto L49;
            if (e.f24474a.b(this.f24466b) == true) goto L49;
            r4 = true;
        L49:
            return d.c.b.a.b.a(r4);
        L41:
            r11 = true;
            goto L43
        L34:
            if (r9.isEmpty() == true) goto L37;
            r10 = false;
            goto L38
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r8);
        L15:
            List r12 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
        L17:
            Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin");
            if (r13 != null) goto L20;
        L23:
            boolean r14 = true;
        L24:
            if (r14 == false) goto L41;
            IEventTaskApi r15 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            if (r15 == null) goto L31;
            d.c.d<? super List<? extends EventTask>> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24465a = 2;
            r8 = r15.getEventTasksByType(3, 0, 1, r3);
            if (r8 != r0) goto L30;
            return r0;
        L20:
            if (r13.isEmpty() == true) goto L23;
            r14 = false;
            goto L24
        L10:
            d.o.a(r8);
            IEventTaskApi r16 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            if (r16 == null) goto L16;
            d.c.d<? super List<? extends EventTask>> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24465a = 1;
            r8 = r16.getAllEventTasks(r5);
            if (r8 != r0) goto L15;
            return r0;
        L16:
            r12 = null;
            goto L17
        }
    }

    /* JADX INFO: compiled from: AddIconGuideHelper.kt */
    @d.c.b.a.f(b = "AddIconGuideHelper.kt", c = {70, 71}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.utils.AddIconGuideHelper$shouldShowGuide$2")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f24468b;

        b(Context r3, d.c.d<? super b> r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24468b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f24468b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24467a;
            List r2 = null;
            boolean r4 = false;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            d.o.a(r8);
        L30:
            r2 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
        L31:
            Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin");
            if (r9 != null) goto L34;
        L37:
            boolean r10 = true;
        L38:
            if (r10 == false) goto L41;
            boolean r11 = false;
        L43:
            if (a.a(a.f24463a) == false) goto L49;
            if (r11 == false) goto L49;
            if (e.f24474a.b(this.f24468b) == true) goto L49;
            r4 = true;
        L49:
            return d.c.b.a.b.a(r4);
        L41:
            r11 = true;
            goto L43
        L34:
            if (r9.isEmpty() == true) goto L37;
            r10 = false;
            goto L38
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r8);
        L15:
            List r12 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
        L17:
            Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin");
            if (r13 != null) goto L20;
        L23:
            boolean r14 = true;
        L24:
            if (r14 == false) goto L41;
            IEventTaskApi r15 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            if (r15 == null) goto L31;
            d.c.d<? super List<? extends EventTask>> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24467a = 2;
            r8 = r15.getEventTasksByType(3, 0, 1, r3);
            if (r8 != r0) goto L30;
            return r0;
        L20:
            if (r13.isEmpty() == true) goto L23;
            r14 = false;
            goto L24
        L10:
            d.o.a(r8);
            IEventTaskApi r16 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            if (r16 == null) goto L16;
            d.c.d<? super List<? extends EventTask>> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24467a = 1;
            r8 = r16.getAllEventTasks(r5);
            if (r8 != r0) goto L15;
            return r0;
        L16:
            r12 = null;
            goto L17
        }
    }

    private a() {
    }

    public static final /* synthetic */ boolean a(a r0) {
        return r0.g();
    }

    public static final /* synthetic */ boolean b(a r0) {
        return r0.h();
    }

    static {
        f24463a = new a();
        f24464b = Keva.getRepo("obric_add_launcher_icon_guide");
    }

    public final void a() {
        f24464b.clear();
    }

    private final boolean g() {
        return f24464b.getBoolean("show_guide", true);
    }

    private final boolean h() {
        return f24464b.getBoolean("should_show_coachmark_guide", false);
    }

    public final void b() {
        f24464b.storeBoolean("should_show_coachmark_guide", false);
    }

    public final void c() {
        f24464b.storeBoolean("show_guide", false);
    }

    public final void d() {
        f24464b.storeBoolean("should_show_coachmark_guide", true);
    }

    public final boolean e() {
        return f24464b.getBoolean("show_task_guide", true);
    }

    public final void f() {
        f24464b.storeBoolean("show_task_guide", false);
    }

    public final Object a(Context r4, d.c.d<? super Boolean> r5) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }

    public final Object b(Context r4, d.c.d<? super Boolean> r5) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0562a(r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }

    public final void a(Activity r12, View r13) {
        Activity r14 = (Activity) ZeusTransformUtils.wrapperContextForParams(r12, Activity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r14, "activity");
        if (r13 != null) goto L11;
        return;
    L11:
        com.obric.oui.coachmark.a.C0933a.a(new com.obric.oui.coachmark.a.C0933a(r14).a(com.obric.oui.coachmark.a.b.f34449b).a(80).a((CharSequence) ZeusTransformUtils.preCheckCast(r14.getString(ZeusTransformUtils.mapRes(R.string.main_menu_add_launcher_icon_coach_mark_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "main_menu_add_launcher_icon_coach_mark_title")), CharSequence.class, "com.obric.aiagent.plugin")), (CharSequence) ZeusTransformUtils.preCheckCast(r14.getString(ZeusTransformUtils.mapRes(R.string.main_menu_add_launcher_icon_coach_mark_message, WsChannelMultiProcessSharedProvider.STRING_TYPE, "main_menu_add_launcher_icon_coach_mark_message")), CharSequence.class, "com.obric.aiagent.plugin"), null, null, 6, null).b((CharSequence) ZeusTransformUtils.preCheckCast(r14.getString(ZeusTransformUtils.mapRes(R.string.main_menu_add_launcher_icon_coach_mark_close, WsChannelMultiProcessSharedProvider.STRING_TYPE, "main_menu_add_launcher_icon_coach_mark_close")), CharSequence.class, "com.obric.aiagent.plugin")).a(androidx.appcompat.a.a.a.b((Context) ZeusTransformUtils.preCheckCast(r14, Context.class, "com.obric.aiagent.plugin"), e.f24474a.a())).b(a(r14, r13, d.i.a.a(TypedValue.applyDimension(1, 320, Resources.getSystem().getDisplayMetrics())))).a(true).a(r13);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Loog.INSTANCE.e("AddIconGuideHelper", "showLauncherIconGuideCoachmark error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    private final int a(Activity r4, View r5, int r6) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin");
        int[] r1 = new int[2];
        r5.getLocationOnScreen(r1);
        return (r1[0] + (r5.getWidth() / 2)) - ((ZeusTransformUtils.getResources(r3, "com.obric.aiagent.plugin").getDisplayMetrics().widthPixels - (r6 / 2)) - d.i.a.a(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics())));
    }
}
