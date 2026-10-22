package com.obric.autoaction.app.launcherpage.detail.base.container;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.activity.ComponentActivity;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.ui.NestedScrollableLayout;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.oui.calendar.OWeekPickerView;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DetailRepeatViewContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u extends z<t> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23355a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f23356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.obric.autoaction.app.launcherpage.a.i f23357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<com.obric.autoaction.app.launcherpage.utils.j<com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a>> f23358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f23359e;
    private boolean f;
    private boolean g;

    /* JADX INFO: compiled from: DetailRepeatViewContainer.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: DetailRepeatViewContainer.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23360a = null;

        static {
            int[] r0 = new int[com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a.values().length];
            r0[com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a.f22916b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a.f22917c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a.f22918d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a.f22915a.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a.g.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a.f22919e.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a.f.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f23360a = r0;
        }
    }

    /* JADX INFO: compiled from: DetailRepeatViewContainer.kt */
    public static final class c implements OWeekPickerView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OWeekPickerView f23361a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f23362b;

        c(OWeekPickerView r1, u r2) {
            this.f23361a = r1;
            this.f23362b = r2;
        }

        @Override // com.obric.oui.calendar.OWeekPickerView.a
        public void a(List<Integer> r6) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r7, "selectedDays");
            if (r7.isEmpty() == false) goto L6;
            this.f23361a.setSelectedDays(u.a(this.f23362b));
            return;
        L6:
            t r0 = (t) ZeusTransformUtils.preCheckCast(this.f23362b.f(), t.class, "com.obric.aiagent.plugin");
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r9 = r8.iterator();
        L8:
            if (r9.hasNext() == false) goto L10;
            r2.add(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r9.next(), Number.class, "com.obric.aiagent.plugin")).intValue() + 1));
            goto L8
        L10:
            r0.a(com.obric.autoaction.app.launcherpage.condition.a.f.a(d.a.p.e((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin"))));
            com.obric.autoaction.app.launcherpage.a.i r10 = u.b(this.f23362b);
            if (r10 != null) goto L13;
            d.h.b.o.c("binding");
            r10 = null;
        L13:
            OCardListItem r11 = r10.f22825c;
            u r1 = this.f23362b;
            r11.setEndDetailText((CharSequence) ZeusTransformUtils.preCheckCast(u.a(r1, ((t) ZeusTransformUtils.preCheckCast(r1.f(), t.class, "com.obric.aiagent.plugin")).d()), CharSequence.class, "com.obric.aiagent.plugin"), -2);
            u.c(this.f23362b);
        }
    }

    static {
        f23355a = new a(null);
    }

    public u() {
        this(false, 1, null);
    }

    /* JADX INFO: renamed from: lambda$5Wn0YpRnULHaNd-nYLy1DC8U8oY, reason: not valid java name */
    public static /* synthetic */ CharSequence m486lambda$5Wn0YpRnULHaNdnYLy1DC8U8oY(com.obric.autoaction.app.launcherpage.utils.j r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$R19Pp4bsrHRq9ziysmJtZYSzJe0(u r0, com.obric.oui.picker.reels.a.a.b r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$XAbrRXiUfgEZzfEXGym_AgXIHTE(u r0, View r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$ZcyiTeyIBHeZ3FID4IbHCSj3H8o(u r0, d.m r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$lGs68YeWNLAAB4eVORTJgHT2w_Q(u r0, View r1) {
        b(r0, r1);
    }

    public static /* synthetic */ d.x lambda$yZ34f_KYlG6QtONeLFRZhpjcBKc(u r0, com.obric.autoaction.app.launcherpage.utils.j r1, int r2) {
        return a(r0, r1, r2);
    }

    public /* synthetic */ u(boolean r1, int r2, d.h.b.h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        this(r1);
    }

    public static final /* synthetic */ String a(u r2, List r3) {
        return r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ List a(u r0) {
        return r0.k();
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.a.i b(u r0) {
        return r0.f23357c;
    }

    public static final /* synthetic */ void c(u r0) {
        r0.o();
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public /* synthetic */ com.obric.autoaction.app.launcherpage.detail.base.f b(com.obric.autoaction.app.launcherpage.detail.base.a r2) {
        return (com.obric.autoaction.app.launcherpage.detail.base.f) ZeusTransformUtils.preCheckCast(a(r2), com.obric.autoaction.app.launcherpage.detail.base.f.class, "com.obric.aiagent.plugin");
    }

    public u(boolean r20) {
        this.f23356b = r20;
        this.f23358d = d.a.p.b(new com.obric.autoaction.app.launcherpage.utils.j[]{new com.obric.autoaction.app.launcherpage.utils.j(com.obric.autoaction.app.launcherpage.condition.a.f22910a.a(), false, com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a.f22915a, null, null, 26, null), new com.obric.autoaction.app.launcherpage.utils.j(com.obric.autoaction.app.launcherpage.condition.a.f22910a.b(), false, com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a.f22916b, null, null, 26, null), new com.obric.autoaction.app.launcherpage.utils.j(com.obric.autoaction.app.launcherpage.condition.a.f22910a.c(), false, com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a.f22917c, null, null, 26, null), new com.obric.autoaction.app.launcherpage.utils.j(com.obric.autoaction.app.launcherpage.condition.a.f22910a.d(), false, com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a.f22918d, null, null, 26, null), new com.obric.autoaction.app.launcherpage.utils.j(com.obric.autoaction.app.launcherpage.condition.a.f22910a.f(), false, com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a.f22919e, null, com.obric.autoaction.app.launcherpage.condition.a.f22910a.g(), 10, null), new com.obric.autoaction.app.launcherpage.utils.j(com.obric.autoaction.app.launcherpage.condition.a.f22910a.h(), false, com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a.f, null, null, 26, null), new com.obric.autoaction.app.launcherpage.utils.j(com.obric.autoaction.app.launcherpage.condition.a.f22910a.e(), false, com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a.g, null, null, 26, null)});
    }

    private final String a(com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a r7) {
        int r8 = b.f23360a[r7.ordinal()];
        if (r8 == 1) goto L20;
        String r4 = null;
        if (r8 != 2) goto L7;
        Integer r6 = ((t) ZeusTransformUtils.preCheckCast(f(), t.class, "com.obric.aiagent.plugin")).e();
        if (r6 == null) goto L16;
        r4 = com.obric.autoaction.app.launcherpage.condition.a.a.a((com.obric.autoaction.app.launcherpage.condition.a.c) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.condition.a.b(((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue()), com.obric.autoaction.app.launcherpage.condition.a.c.class, "com.obric.aiagent.plugin"), null, 1, null);
    L16:
        if (r4 != null) goto L24;
        return "";
    L24:
        return r4;
    L7:
        if (r8 != 3) goto L25;
        Integer r9 = ((t) ZeusTransformUtils.preCheckCast(f(), t.class, "com.obric.aiagent.plugin")).f();
        Integer r10 = ((t) ZeusTransformUtils.preCheckCast(f(), t.class, "com.obric.aiagent.plugin")).g();
        if (r9 == null) goto L21;
        if (r10 != null) goto L23;
        return "";
    L23:
        return com.obric.autoaction.app.launcherpage.condition.a.a.a((com.obric.autoaction.app.launcherpage.condition.a.c) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.condition.a.d(r9.intValue()), com.obric.autoaction.app.launcherpage.condition.a.c.class, "com.obric.aiagent.plugin"), null, 1, null) + com.obric.autoaction.app.launcherpage.condition.a.a.a((com.obric.autoaction.app.launcherpage.condition.a.c) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.condition.a.b(r10.intValue()), com.obric.autoaction.app.launcherpage.condition.a.c.class, "com.obric.aiagent.plugin"), r9);
    L21:
        return "";
    L25:
        return "";
    L20:
        return a(((t) ZeusTransformUtils.preCheckCast(f(), t.class, "com.obric.aiagent.plugin")).d());
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public View a(ViewGroup r4) {
        d.h.b.o.e(r4, "parent");
        com.obric.autoaction.app.launcherpage.a.i r5 = com.obric.autoaction.app.launcherpage.a.i.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r4, false);
        d.h.b.o.c(r5, "inflate(...)");
        this.f23357c = r5;
        if (r5 != null) goto L5;
        d.h.b.o.c("binding");
        r5 = null;
    L5:
        LinearLayout r3 = r5.b();
        d.h.b.o.c(r3, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
    }

    public t a(com.obric.autoaction.app.launcherpage.detail.base.a r25) {
        d.h.b.o.e(r25, "context");
        EventTask r0 = r25.c().a();
        Integer r2 = null;
        if (ZeusTransformUtils.instanceOf(r0, ConditionTask.class) == false) goto L5;
        ConditionTask r1 = (ConditionTask) ZeusTransformUtils.preCheckCast(r0, ConditionTask.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L9;
        PeriodicPolicy r3 = r1.getPeriodicPolicy();
        if (r3 == null) goto L9;
    L10:
        PeriodicPolicy r17 = r3;
        String r4 = r17.getYearly();
        if (r4 == null) goto L21;
        List r5 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"-"}, false, 0, 6, null);
        if (r5 == null) goto L21;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r8 = r6.iterator();
    L16:
        if (r8.hasNext() == false) goto L20;
        Integer r9 = d.o.o.d((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin"));
        if (r9 == null) goto L16;
        r7.add(r9);
        goto L16
    L20:
        List r10 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
    L22:
        Calendar r11 = Calendar.getInstance();
        int r12 = r11.get(5);
        boolean r13 = true;
        int r14 = r11.get(2) + 1;
        boolean r15 = this.f23356b;
        com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a r16 = com.obric.autoaction.app.launcherpage.condition.a.a.c(r17);
        if (r16 != null) goto L25;
        r16 = com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a.f22915a;
    L25:
        com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a r19 = r16;
        List<com.obric.autoaction.app.launcherpage.utils.j<Integer>> r20 = com.obric.autoaction.app.launcherpage.condition.a.f.a(r17.getWeekly());
        Integer r18 = Integer.valueOf(r17.getMonthly());
        int r21 = ((Number) ZeusTransformUtils.preCheckCast(r18, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (1 > r21) goto L29;
        if (r21 >= 32) goto L29;
        boolean r22 = true;
    L31:
        if (Boolean.valueOf(r22).booleanValue() == true) goto L34;
        r18 = null;
    L34:
        if (r18 == null) goto L36;
        int r23 = r18.intValue();
    L37:
        Integer r24 = Integer.valueOf(r23);
        if (r10 == null) goto L52;
        Integer r26 = (Integer) ZeusTransformUtils.preCheckCast(d.a.p.d(r10, 0), Integer.class, "com.obric.aiagent.plugin");
        if (r26 == null) goto L52;
        int r27 = ((Number) ZeusTransformUtils.preCheckCast(r26, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (1 <= r27) goto L44;
    L46:
        boolean r28 = false;
    L47:
        if (r28 == true) goto L50;
        r26 = null;
    L50:
        if (r26 == null) goto L52;
        r14 = r26.intValue();
        goto L52
    L44:
        if (r27 >= 13) goto L46;
        r28 = true;
    L52:
        Integer r29 = Integer.valueOf(r14);
        if (r10 == null) goto L66;
        Integer r30 = (Integer) ZeusTransformUtils.preCheckCast(d.a.p.d(r10, 1), Integer.class, "com.obric.aiagent.plugin");
        if (r30 == null) goto L66;
        int r31 = ((Number) ZeusTransformUtils.preCheckCast(r30, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (1 > r31) goto L60;
        if (r31 >= 32) goto L60;
    L61:
        if (r13 == false) goto L63;
        r2 = r30;
    L63:
        if (r2 == null) goto L66;
        r12 = r2.intValue();
    L60:
        r13 = false;
    L66:
        return new t(r17, r15, r19, r20, r24, r29, Integer.valueOf(r12));
    L36:
        r23 = r12;
    L29:
        r22 = false;
    L21:
        r10 = null;
    L9:
        r3 = new PeriodicPolicy(true, null, 0, null, false, false, null, false, null, 510, null);
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public void a() {
        j();
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public void b() {
        i();
    }

    private final void i() {
        com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a r0 = ((t) ZeusTransformUtils.preCheckCast(f(), t.class, "com.obric.aiagent.plugin")).c();
        if (r0 != null) goto L5;
        r0 = com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a.f22915a;
    L5:
        com.obric.autoaction.app.launcherpage.a.i r1 = null;
        a(null, r0);
        com.obric.autoaction.app.launcherpage.a.i r2 = this.f23357c;
        if (r2 != null) goto L8;
        d.h.b.o.c("binding");
        r2 = null;
    L8:
        OCardListItem r3 = r2.f22824b;
        PeriodicPolicy r4 = ((t) ZeusTransformUtils.preCheckCast(f(), t.class, "com.obric.aiagent.plugin")).a();
        if (r4 == null) goto L14;
        com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a r5 = com.obric.autoaction.app.launcherpage.condition.a.a.c(r4);
        if (r5 == null) goto L14;
        String r6 = r5.a();
        if (r6 == null) goto L14;
    L15:
        OCardListItem.setEndDetailText$default(r3, (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
        if (((t) ZeusTransformUtils.preCheckCast(f(), t.class, "com.obric.aiagent.plugin")).b() != true) goto L22;
        com.obric.autoaction.app.launcherpage.a.i r7 = this.f23357c;
        if (r7 != null) goto L20;
        d.h.b.o.c("binding");
    L21:
        OTextView r8 = r1.f22826d;
        d.h.b.o.c(r8, "conditionEventTriggerSetting");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"));
        return;
    L20:
        r1 = r7;
        goto L21
    L22:
        com.obric.autoaction.app.launcherpage.a.i r9 = this.f23357c;
        if (r9 != null) goto L25;
        d.h.b.o.c("binding");
    L26:
        OTextView r10 = r1.f22826d;
        d.h.b.o.c(r10, "conditionEventTriggerSetting");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin"));
        return;
    L25:
        r1 = r9;
    L14:
        r6 = "";
        goto L15
    }

    private final void j() {
        com.obric.autoaction.app.launcherpage.a.i r0 = this.f23357c;
        com.obric.autoaction.app.launcherpage.a.i r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        r0.f22824b.setOnContentClickListener(new $$Lambda$u$XAbrRXiUfgEZzfEXGym_AgXIHTE(this));
        com.obric.autoaction.app.launcherpage.a.i r2 = this.f23357c;
        if (r2 != null) goto L8;
        d.h.b.o.c("binding");
    L9:
        r1.f22825c.setOnContentClickListener(new $$Lambda$u$lGs68YeWNLAAB4eVORTJgHT2w_Q(this));
        return;
    L8:
        r1 = r2;
        goto L9
    }

    private static final void a(final u r12, View r13) {
        com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a r14 = ((t) ZeusTransformUtils.preCheckCast(r12.f(), t.class, "com.obric.aiagent.plugin")).c();
        if (r14 != null) goto L5;
        return;
    L5:
        com.obric.autoaction.app.launcherpage.a.i r0 = r12.f23357c;
        if (r0 != null) goto L8;
        d.h.b.o.c("binding");
        r0 = null;
    L8:
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r1, "getContext(...)");
        ComponentActivity r2 = (ComponentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.autoaction.app.launcherpage.ui.e.a(r1), "com.obric.aiagent.plugin"), ComponentActivity.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.app.launcherpage.detail.base.a r4 = r12.getContext();
        if (r4 == null) goto L13;
        com.obric.autoaction.app.launcherpage.detail.base.d r5 = r4.a();
        if (r5 == null) goto L13;
        Dialog r6 = r5.getDialog();
    L14:
        com.obric.autoaction.app.launcherpage.a.i r7 = r12.f23357c;
        if (r7 != null) goto L17;
        d.h.b.o.c("binding");
        r7 = null;
    L17:
        OCardListItem r3 = r7.f22824b;
        d.h.b.o.c(r3, "conditionEventRepeatModeItem");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r12.f23358d, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L19:
        if (r8.hasNext() == false) goto L26;
        Object r9 = r8.next();
        if (((com.obric.autoaction.app.launcherpage.utils.j) ZeusTransformUtils.preCheckCast(r9, com.obric.autoaction.app.launcherpage.utils.j.class, "com.obric.aiagent.plugin")).c() != r14) goto L23;
        boolean r10 = true;
    L24:
        if (r10 == false) goto L19;
    L27:
        com.obric.autoaction.app.launcherpage.utils.j r11 = (com.obric.autoaction.app.launcherpage.utils.j) ZeusTransformUtils.preCheckCast(r9, com.obric.autoaction.app.launcherpage.utils.j.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.app.launcherpage.utils.p.a((Activity) ZeusTransformUtils.preCheckCast(r2, Activity.class, "com.obric.aiagent.plugin"), r6, (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"), new com.obric.autoaction.app.launcherpage.utils.i(r12.f23358d, r14.ordinal(), com.obric.autoaction.app.launcherpage.utils.p.a(ZeusTransformUtils.mapRes(R.string.condition_event_repeat_mode, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_repeat_mode"), null, 1, null), OInsetSheet.b.f36197b), r11, new $$Lambda$u$yZ34f_KYlG6QtONeLFRZhpjcBKc(r12));
        return;
    L23:
        r10 = false;
        goto L24
    L26:
        r9 = null;
    L13:
        r6 = null;
        goto L14
    }

    private static final d.x a(u r2, com.obric.autoaction.app.launcherpage.utils.j r3, int r4) {
        d.h.b.o.e(r3, "itemData");
        r2.a(r3, (com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a) ZeusTransformUtils.preCheckCast(r3.c(), com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a.class, "com.obric.aiagent.plugin"));
        return d.x.f38692a;
    }

    private static final void b(u r9, View r10) {
        int r11 = b.f23360a[((t) ZeusTransformUtils.preCheckCast(r9.f(), t.class, "com.obric.aiagent.plugin")).c().ordinal()];
        if (r11 == 1) goto L33;
        if (r11 == 2) goto L20;
        if (r11 != 3) goto L46;
        r9.n();
        com.obric.autoaction.app.launcherpage.a.i r12 = r9.f23357c;
        if (r12 != null) goto L10;
        d.h.b.o.c("binding");
        r12 = null;
    L10:
        OCardListItem r13 = r12.f;
        d.h.b.o.c(r13, "conditionEventYearlyPicker");
        if (com.obric.oui.common.util.k.d((View) ZeusTransformUtils.preCheckCast(r13, View.class, "com.obric.aiagent.plugin")) == false) goto L16;
        com.obric.autoaction.app.launcherpage.a.i r14 = r9.f23357c;
        if (r14 != null) goto L15;
        d.h.b.o.c("binding");
        r14 = null;
    L15:
        OCardListItem r15 = r14.f;
        d.h.b.o.c(r15, "conditionEventYearlyPicker");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r15, View.class, "com.obric.aiagent.plugin"));
        goto L46
    L16:
        com.obric.autoaction.app.launcherpage.a.i r16 = r9.f23357c;
        if (r16 != null) goto L19;
        d.h.b.o.c("binding");
        r16 = null;
    L19:
        OCardListItem r17 = r16.f;
        d.h.b.o.c(r17, "conditionEventYearlyPicker");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r17, View.class, "com.obric.aiagent.plugin"));
    L46:
        com.obric.autoaction.app.launcherpage.a.i r18 = r9.f23357c;
        if (r18 != null) goto L49;
        d.h.b.o.c("binding");
        r18 = null;
    L49:
        OCardListItem r19 = r18.f22827e;
        d.h.b.o.c(r19, "conditionEventWeeklyPicker");
        if (com.obric.oui.common.util.k.d((View) ZeusTransformUtils.preCheckCast(r19, View.class, "com.obric.aiagent.plugin")) == true) goto L66;
        com.obric.autoaction.app.launcherpage.a.i r110 = r9.f23357c;
        if (r110 != null) goto L54;
        d.h.b.o.c("binding");
        r110 = null;
    L54:
        OCardListItem r111 = r110.f22823a;
        d.h.b.o.c(r111, "conditionEventMonthlyPicker");
        if (com.obric.oui.common.util.k.d((View) ZeusTransformUtils.preCheckCast(r111, View.class, "com.obric.aiagent.plugin")) == true) goto L66;
        com.obric.autoaction.app.launcherpage.a.i r112 = r9.f23357c;
        if (r112 != null) goto L59;
        d.h.b.o.c("binding");
        r112 = null;
    L59:
        OCardListItem r113 = r112.f;
        d.h.b.o.c(r113, "conditionEventYearlyPicker");
        if (com.obric.oui.common.util.k.d((View) ZeusTransformUtils.preCheckCast(r113, View.class, "com.obric.aiagent.plugin")) == true) goto L66;
        com.obric.autoaction.app.launcherpage.a.i r20 = r9.f23357c;
        if (r20 != null) goto L65;
        d.h.b.o.c("binding");
        r20 = null;
    L65:
        OCardListItem.setCardPosition$default(r20.f22825c, 3, false, 2, null);
        return;
    L66:
        com.obric.autoaction.app.launcherpage.a.i r21 = r9.f23357c;
        if (r21 != null) goto L69;
        d.h.b.o.c("binding");
        r21 = null;
    L69:
        OCardListItem.setCardPosition$default(r21.f22825c, 2, false, 2, null);
        return;
    L20:
        r9.m();
        com.obric.autoaction.app.launcherpage.a.i r114 = r9.f23357c;
        if (r114 != null) goto L23;
        d.h.b.o.c("binding");
        r114 = null;
    L23:
        OCardListItem r115 = r114.f22823a;
        d.h.b.o.c(r115, "conditionEventMonthlyPicker");
        if (com.obric.oui.common.util.k.d((View) ZeusTransformUtils.preCheckCast(r115, View.class, "com.obric.aiagent.plugin")) == false) goto L29;
        com.obric.autoaction.app.launcherpage.a.i r116 = r9.f23357c;
        if (r116 != null) goto L28;
        d.h.b.o.c("binding");
        r116 = null;
    L28:
        OCardListItem r117 = r116.f22823a;
        d.h.b.o.c(r117, "conditionEventMonthlyPicker");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r117, View.class, "com.obric.aiagent.plugin"));
        goto L46
    L29:
        com.obric.autoaction.app.launcherpage.a.i r118 = r9.f23357c;
        if (r118 != null) goto L32;
        d.h.b.o.c("binding");
        r118 = null;
    L32:
        OCardListItem r119 = r118.f22823a;
        d.h.b.o.c(r119, "conditionEventMonthlyPicker");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r119, View.class, "com.obric.aiagent.plugin"));
        goto L46
    L33:
        r9.l();
        com.obric.autoaction.app.launcherpage.a.i r120 = r9.f23357c;
        if (r120 != null) goto L36;
        d.h.b.o.c("binding");
        r120 = null;
    L36:
        OCardListItem r121 = r120.f22827e;
        d.h.b.o.c(r121, "conditionEventWeeklyPicker");
        if (com.obric.oui.common.util.k.d((View) ZeusTransformUtils.preCheckCast(r121, View.class, "com.obric.aiagent.plugin")) == false) goto L42;
        com.obric.autoaction.app.launcherpage.a.i r122 = r9.f23357c;
        if (r122 != null) goto L41;
        d.h.b.o.c("binding");
        r122 = null;
    L41:
        OCardListItem r123 = r122.f22827e;
        d.h.b.o.c(r123, "conditionEventWeeklyPicker");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r123, View.class, "com.obric.aiagent.plugin"));
        goto L46
    L42:
        com.obric.autoaction.app.launcherpage.a.i r124 = r9.f23357c;
        if (r124 != null) goto L45;
        d.h.b.o.c("binding");
        r124 = null;
    L45:
        OCardListItem r125 = r124.f22827e;
        d.h.b.o.c(r125, "conditionEventWeeklyPicker");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r125, View.class, "com.obric.aiagent.plugin"));
        goto L46
    }

    private final List<Integer> k() {
        List<com.obric.autoaction.app.launcherpage.utils.j<Integer>> r4 = ((t) ZeusTransformUtils.preCheckCast(f(), t.class, "com.obric.aiagent.plugin")).d();
        if (r4 == null) goto L16;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L10;
        Object r2 = r6.next();
        if (((com.obric.autoaction.app.launcherpage.utils.j) ZeusTransformUtils.preCheckCast(r2, com.obric.autoaction.app.launcherpage.utils.j.class, "com.obric.aiagent.plugin")).b() == false) goto L6;
        r0.add(r2);
        goto L6
    L10:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r7, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r8 = r7.iterator();
    L12:
        if (r8.hasNext() == false) goto L23;
        r1.add(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(((com.obric.autoaction.app.launcherpage.utils.j) ZeusTransformUtils.preCheckCast(r8.next(), com.obric.autoaction.app.launcherpage.utils.j.class, "com.obric.aiagent.plugin")).c(), Number.class, "com.obric.aiagent.plugin")).intValue() - 1));
        goto L12
    L23:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
    L16:
        return d.a.p.b();
    }

    private final void l() {
        if (this.f23359e == false) goto L5;
        return;
    L5:
        com.obric.autoaction.app.launcherpage.a.i r1 = this.f23357c;
        if (r1 != null) goto L8;
        d.h.b.o.c("binding");
        r1 = null;
    L8:
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r2, "getContext(...)");
        OWeekPickerView r0 = new OWeekPickerView(r2, null, 0, 0, 14, null);
        r0.setSelectionMode(com.obric.oui.calendar.m.f34389b);
        r0.setFirstDayOfWeek(2);
        r0.setOnDaysChangedListener((OWeekPickerView.a) ZeusTransformUtils.preCheckCast(new c(r0, this), OWeekPickerView.a.class, "com.obric.aiagent.plugin"));
        r0.setSelectedDays(k());
        com.obric.autoaction.app.launcherpage.a.i r3 = this.f23357c;
        if (r3 != null) goto L11;
        d.h.b.o.c("binding");
        r3 = null;
    L11:
        r3.f22827e.setCustomStartView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.a.i r4 = this.f23357c;
        if (r4 != null) goto L14;
        d.h.b.o.c("binding");
        r4 = null;
    L14:
        r4.f22827e.showCustomStart(true);
        com.obric.autoaction.app.launcherpage.a.i r5 = this.f23357c;
        if (r5 != null) goto L17;
        d.h.b.o.c("binding");
        r5 = null;
    L17:
        OCardListItem r6 = r5.f22827e;
        d.h.b.o.c(r6, "conditionEventWeeklyPicker");
        com.obric.autoaction.app.launcherpage.utils.p.a(r6, 0, 1, null);
        this.f23359e = true;
    }

    private final void m() {
        if (this.f == false) goto L5;
        return;
    L5:
        com.obric.autoaction.app.launcherpage.a.i r0 = this.f23357c;
        if (r0 != null) goto L8;
        d.h.b.o.c("binding");
        r0 = null;
    L8:
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        com.obric.oui.picker.reels.a.a.C0970a r11 = new com.obric.oui.picker.reels.a.a.C0970a();
        com.obric.autoaction.app.launcherpage.a.i r4 = this.f23357c;
        if (r4 != null) goto L11;
        d.h.b.o.c("binding");
        r4 = null;
    L11:
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r5, "getContext(...)");
        com.obric.oui.picker.reels.a.a.C0970a.b(r11, r5, 1003, ((t) ZeusTransformUtils.preCheckCast(f(), t.class, "com.obric.aiagent.plugin")).e(), null, 8, null);
        r11.a(new $$Lambda$u$R19Pp4bsrHRq9ziysmJtZYSzJe0(this));
        com.obric.oui.picker.reels.a.b r6 = (com.obric.oui.picker.reels.a.b) ZeusTransformUtils.preCheckCast(r11, com.obric.oui.picker.reels.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r1);
        View r10 = ((com.obric.oui.picker.reels.a.a) ZeusTransformUtils.preCheckCast(com.obric.oui.picker.reels.a.b.a.a(r6, r1, null, 0, 6, null), com.obric.oui.picker.reels.a.a.class, "com.obric.aiagent.plugin")).a();
        NestedScrollableLayout r12 = new NestedScrollableLayout(r1, null, 0, 6, null);
        if (r10 == null) goto L14;
        r12.addView(r10, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-2, -2, 17), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
    L14:
        com.obric.autoaction.app.launcherpage.a.i r2 = this.f23357c;
        if (r2 != null) goto L17;
        d.h.b.o.c("binding");
        r2 = null;
    L17:
        r2.f22823a.setCustomStartView((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.a.i r3 = this.f23357c;
        if (r3 != null) goto L20;
        d.h.b.o.c("binding");
        r3 = null;
    L20:
        r3.f22823a.showCustomStart(true);
        com.obric.autoaction.app.launcherpage.a.i r7 = this.f23357c;
        if (r7 != null) goto L23;
        d.h.b.o.c("binding");
        r7 = null;
    L23:
        OCardListItem r8 = r7.f22823a;
        d.h.b.o.c(r8, "conditionEventMonthlyPicker");
        com.obric.autoaction.app.launcherpage.utils.p.a(r8, 0, 1, null);
        this.f = true;
    }

    private static final void a(u r4, com.obric.oui.picker.reels.a.a.b r5) {
        d.h.b.o.e(r5, "it");
        Integer r6 = (Integer) ZeusTransformUtils.preCheckCast(r5.a().get(1003), Integer.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L9;
        ((t) ZeusTransformUtils.preCheckCast(r4.f(), t.class, "com.obric.aiagent.plugin")).a(Integer.valueOf(r6.intValue() + 1));
        com.obric.autoaction.app.launcherpage.a.i r7 = r4.f23357c;
        if (r7 != null) goto L7;
        d.h.b.o.c("binding");
        r7 = null;
    L7:
        OCardListItem.setEndDetailText$default(r7.f22825c, (CharSequence) ZeusTransformUtils.preCheckCast(r4.a(com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a.f22917c), CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
        r4.o();
        return;
    }

    private final void n() {
        if (this.g == false) goto L5;
        return;
    L5:
        com.obric.autoaction.app.launcherpage.a.i r0 = this.f23357c;
        if (r0 != null) goto L8;
        d.h.b.o.c("binding");
        r0 = null;
    L8:
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.app.launcherpage.detail.condition.b.d r1 = new com.obric.autoaction.app.launcherpage.detail.condition.b.d();
        d.h.b.o.a(r5);
        Integer r6 = ((t) ZeusTransformUtils.preCheckCast(f(), t.class, "com.obric.aiagent.plugin")).f();
        int r7 = -1;
        if (r6 == null) goto L11;
        int r8 = r6.intValue();
    L12:
        Integer r9 = Integer.valueOf(r8);
        Integer r10 = ((t) ZeusTransformUtils.preCheckCast(f(), t.class, "com.obric.aiagent.plugin")).g();
        if (r10 == null) goto L15;
        r7 = r10.intValue();
    L15:
        View r2 = r1.a(r5, new d.m(r9, Integer.valueOf(r7)), new $$Lambda$u$ZcyiTeyIBHeZ3FID4IbHCSj3H8o(this)).a();
        NestedScrollableLayout r11 = new NestedScrollableLayout(r5, null, 0, 6, null);
        if (r2 == null) goto L18;
        r11.addView(r2, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-2, -2, 17), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
    L18:
        com.obric.autoaction.app.launcherpage.a.i r3 = this.f23357c;
        if (r3 != null) goto L21;
        d.h.b.o.c("binding");
        r3 = null;
    L21:
        r3.f.setCustomStartView((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.a.i r4 = this.f23357c;
        if (r4 != null) goto L24;
        d.h.b.o.c("binding");
        r4 = null;
    L24:
        r4.f.showCustomStart(true);
        com.obric.autoaction.app.launcherpage.a.i r12 = this.f23357c;
        if (r12 != null) goto L27;
        d.h.b.o.c("binding");
        r12 = null;
    L27:
        OCardListItem r13 = r12.f;
        d.h.b.o.c(r13, "conditionEventYearlyPicker");
        com.obric.autoaction.app.launcherpage.utils.p.a(r13, 0, 1, null);
        this.g = true;
        return;
    L11:
        r8 = -1;
        goto L12
    }

    private static final void a(u r4, d.m r5) {
        d.h.b.o.e(r5, "it");
        ((t) ZeusTransformUtils.preCheckCast(r4.f(), t.class, "com.obric.aiagent.plugin")).b((Integer) ZeusTransformUtils.preCheckCast(r5.a(), Integer.class, "com.obric.aiagent.plugin"));
        ((t) ZeusTransformUtils.preCheckCast(r4.f(), t.class, "com.obric.aiagent.plugin")).c((Integer) ZeusTransformUtils.preCheckCast(r5.b(), Integer.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.a.i r6 = r4.f23357c;
        if (r6 != null) goto L5;
        d.h.b.o.c("binding");
        r6 = null;
    L5:
        OCardListItem.setEndDetailText$default(r6.f22825c, (CharSequence) ZeusTransformUtils.preCheckCast(r4.a(com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a.f22918d), CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
        r4.o();
    }

    private final void a(com.obric.autoaction.app.launcherpage.utils.j<com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a> r14, com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a r15) {
        if (r14 == null) goto L9;
        com.obric.autoaction.app.launcherpage.a.i r5 = this.f23357c;
        if (r5 != null) goto L7;
        d.h.b.o.c("binding");
        r5 = null;
    L7:
        OCardListItem.setEndDetailText$default(r5.f22824b, (CharSequence) ZeusTransformUtils.preCheckCast(r14.a(), CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
        ((t) ZeusTransformUtils.preCheckCast(f(), t.class, "com.obric.aiagent.plugin")).a(r15);
        o();
    L9:
        switch(b.f23360a[r15.ordinal()]) {
            case 1: goto L92;
            case 2: goto L60;
            case 3: goto L28;
            case 4: goto L12;
            case 5: goto L12;
            case 6: goto L12;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        com.obric.autoaction.app.launcherpage.a.i r16 = this.f23357c;
        if (r16 != null) goto L15;
        d.h.b.o.c("binding");
        r16 = null;
    L15:
        OCardListItem r17 = r16.f22825c;
        d.h.b.o.c(r17, "conditionEventRepeatTime");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r17, View.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.a.i r18 = this.f23357c;
        if (r18 != null) goto L18;
        d.h.b.o.c("binding");
        r18 = null;
    L18:
        OCardListItem r19 = r18.f22827e;
        d.h.b.o.c(r19, "conditionEventWeeklyPicker");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r19, View.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.a.i r110 = this.f23357c;
        if (r110 != null) goto L21;
        d.h.b.o.c("binding");
        r110 = null;
    L21:
        OCardListItem r111 = r110.f22823a;
        d.h.b.o.c(r111, "conditionEventMonthlyPicker");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r111, View.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.a.i r112 = this.f23357c;
        if (r112 != null) goto L24;
        d.h.b.o.c("binding");
        r112 = null;
    L24:
        OCardListItem r113 = r112.f;
        d.h.b.o.c(r113, "conditionEventYearlyPicker");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r113, View.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.a.i r13 = this.f23357c;
        if (r13 != null) goto L27;
        d.h.b.o.c("binding");
        r13 = null;
    L27:
        OCardListItem.setCardPosition$default(r13.f22824b, 0, false, 2, null);
        return;
    L28:
        com.obric.autoaction.app.launcherpage.a.i r114 = this.f23357c;
        if (r114 != null) goto L31;
        d.h.b.o.c("binding");
        r114 = null;
    L31:
        OCardListItem r115 = r114.f22825c;
        d.h.b.o.c(r115, "conditionEventRepeatTime");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r115, View.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.a.i r116 = this.f23357c;
        if (r116 != null) goto L34;
        d.h.b.o.c("binding");
        r116 = null;
    L34:
        r116.f22825c.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.utils.p.a(ZeusTransformUtils.mapRes(R.string.condition_event_repeat_mode_time, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_repeat_mode_time"), null, 1, null), CharSequence.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.a.i r117 = this.f23357c;
        if (r117 != null) goto L37;
        d.h.b.o.c("binding");
        r117 = null;
    L37:
        OCardListItem r118 = r117.f22827e;
        d.h.b.o.c(r118, "conditionEventWeeklyPicker");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r118, View.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.a.i r119 = this.f23357c;
        if (r119 != null) goto L40;
        d.h.b.o.c("binding");
        r119 = null;
    L40:
        OCardListItem r120 = r119.f22823a;
        d.h.b.o.c(r120, "conditionEventMonthlyPicker");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r120, View.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.a.i r121 = this.f23357c;
        if (r121 != null) goto L43;
        d.h.b.o.c("binding");
        r121 = null;
    L43:
        OCardListItem r122 = r121.f;
        d.h.b.o.c(r122, "conditionEventYearlyPicker");
        if (com.obric.oui.common.util.k.d((View) ZeusTransformUtils.preCheckCast(r122, View.class, "com.obric.aiagent.plugin")) == false) goto L49;
        com.obric.autoaction.app.launcherpage.a.i r123 = this.f23357c;
        if (r123 != null) goto L48;
        d.h.b.o.c("binding");
        r123 = null;
    L48:
        OCardListItem.setCardPosition$default(r123.f22825c, 2, false, 2, null);
    L53:
        com.obric.autoaction.app.launcherpage.a.i r124 = this.f23357c;
        if (r124 != null) goto L56;
        d.h.b.o.c("binding");
        r124 = null;
    L56:
        OCardListItem.setEndDetailText$default(r124.f22825c, (CharSequence) ZeusTransformUtils.preCheckCast(a(r15), CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
        com.obric.autoaction.app.launcherpage.a.i r125 = this.f23357c;
        if (r125 != null) goto L59;
        d.h.b.o.c("binding");
        r125 = null;
    L59:
        OCardListItem.setCardPosition$default(r125.f22824b, 1, false, 2, null);
        return;
    L49:
        com.obric.autoaction.app.launcherpage.a.i r126 = this.f23357c;
        if (r126 != null) goto L52;
        d.h.b.o.c("binding");
        r126 = null;
    L52:
        OCardListItem.setCardPosition$default(r126.f22825c, 3, false, 2, null);
        goto L53
    L60:
        com.obric.autoaction.app.launcherpage.a.i r127 = this.f23357c;
        if (r127 != null) goto L63;
        d.h.b.o.c("binding");
        r127 = null;
    L63:
        OCardListItem r128 = r127.f22825c;
        d.h.b.o.c(r128, "conditionEventRepeatTime");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r128, View.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.a.i r129 = this.f23357c;
        if (r129 != null) goto L66;
        d.h.b.o.c("binding");
        r129 = null;
    L66:
        r129.f22825c.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.utils.p.a(ZeusTransformUtils.mapRes(R.string.condition_event_repeat_mode_time, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_repeat_mode_time"), null, 1, null), CharSequence.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.a.i r130 = this.f23357c;
        if (r130 != null) goto L69;
        d.h.b.o.c("binding");
        r130 = null;
    L69:
        OCardListItem r131 = r130.f22827e;
        d.h.b.o.c(r131, "conditionEventWeeklyPicker");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r131, View.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.a.i r132 = this.f23357c;
        if (r132 != null) goto L72;
        d.h.b.o.c("binding");
        r132 = null;
    L72:
        OCardListItem r133 = r132.f;
        d.h.b.o.c(r133, "conditionEventYearlyPicker");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r133, View.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.a.i r134 = this.f23357c;
        if (r134 != null) goto L75;
        d.h.b.o.c("binding");
        r134 = null;
    L75:
        OCardListItem r135 = r134.f22823a;
        d.h.b.o.c(r135, "conditionEventMonthlyPicker");
        if (com.obric.oui.common.util.k.d((View) ZeusTransformUtils.preCheckCast(r135, View.class, "com.obric.aiagent.plugin")) == false) goto L81;
        com.obric.autoaction.app.launcherpage.a.i r136 = this.f23357c;
        if (r136 != null) goto L80;
        d.h.b.o.c("binding");
        r136 = null;
    L80:
        OCardListItem.setCardPosition$default(r136.f22825c, 2, false, 2, null);
    L85:
        com.obric.autoaction.app.launcherpage.a.i r137 = this.f23357c;
        if (r137 != null) goto L88;
        d.h.b.o.c("binding");
        r137 = null;
    L88:
        OCardListItem.setEndDetailText$default(r137.f22825c, (CharSequence) ZeusTransformUtils.preCheckCast(a(r15), CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
        com.obric.autoaction.app.launcherpage.a.i r138 = this.f23357c;
        if (r138 != null) goto L91;
        d.h.b.o.c("binding");
        r138 = null;
    L91:
        OCardListItem.setCardPosition$default(r138.f22824b, 1, false, 2, null);
        return;
    L81:
        com.obric.autoaction.app.launcherpage.a.i r139 = this.f23357c;
        if (r139 != null) goto L84;
        d.h.b.o.c("binding");
        r139 = null;
    L84:
        OCardListItem.setCardPosition$default(r139.f22825c, 3, false, 2, null);
        goto L85
    L92:
        com.obric.autoaction.app.launcherpage.a.i r140 = this.f23357c;
        if (r140 != null) goto L95;
        d.h.b.o.c("binding");
        r140 = null;
    L95:
        OCardListItem r141 = r140.f22825c;
        d.h.b.o.c(r141, "conditionEventRepeatTime");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r141, View.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.a.i r142 = this.f23357c;
        if (r142 != null) goto L98;
        d.h.b.o.c("binding");
        r142 = null;
    L98:
        r142.f22825c.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.utils.p.a(ZeusTransformUtils.mapRes(R.string.condition_event_repeat_mode_time, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_repeat_mode_time"), null, 1, null), CharSequence.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.a.i r143 = this.f23357c;
        if (r143 != null) goto L101;
        d.h.b.o.c("binding");
        r143 = null;
    L101:
        OCardListItem r144 = r143.f22823a;
        d.h.b.o.c(r144, "conditionEventMonthlyPicker");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r144, View.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.a.i r145 = this.f23357c;
        if (r145 != null) goto L104;
        d.h.b.o.c("binding");
        r145 = null;
    L104:
        OCardListItem r146 = r145.f;
        d.h.b.o.c(r146, "conditionEventYearlyPicker");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r146, View.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.a.i r147 = this.f23357c;
        if (r147 != null) goto L107;
        d.h.b.o.c("binding");
        r147 = null;
    L107:
        OCardListItem r148 = r147.f22827e;
        d.h.b.o.c(r148, "conditionEventWeeklyPicker");
        if (com.obric.oui.common.util.k.d((View) ZeusTransformUtils.preCheckCast(r148, View.class, "com.obric.aiagent.plugin")) == false) goto L113;
        com.obric.autoaction.app.launcherpage.a.i r149 = this.f23357c;
        if (r149 != null) goto L112;
        d.h.b.o.c("binding");
        r149 = null;
    L112:
        OCardListItem.setCardPosition$default(r149.f22825c, 2, false, 2, null);
    L117:
        com.obric.autoaction.app.launcherpage.a.i r150 = this.f23357c;
        if (r150 != null) goto L120;
        d.h.b.o.c("binding");
        r150 = null;
    L120:
        r150.f22825c.setEndDetailText((CharSequence) ZeusTransformUtils.preCheckCast(a(((t) ZeusTransformUtils.preCheckCast(f(), t.class, "com.obric.aiagent.plugin")).d()), CharSequence.class, "com.obric.aiagent.plugin"), -2);
        com.obric.autoaction.app.launcherpage.a.i r151 = this.f23357c;
        if (r151 != null) goto L123;
        d.h.b.o.c("binding");
        r151 = null;
    L123:
        LinearLayout r152 = r151.f22825c.getTitleContainer();
        ViewGroup.LayoutParams r153 = r152.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r153, ConstraintLayout.LayoutParams.class) == false) goto L126;
        ConstraintLayout.LayoutParams r154 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r153, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
    L127:
        if (r154 == null) goto L130;
        r154.matchConstraintMinWidth = -2;
        r152.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r154, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
    L130:
        com.obric.autoaction.app.launcherpage.a.i r155 = this.f23357c;
        if (r155 != null) goto L133;
        d.h.b.o.c("binding");
        r155 = null;
    L133:
        View r156 = r155.f22825c.findViewById(ZeusTransformUtils.mapRes(R.id.custom_end_container, DbHelper.COL_ID, "custom_end_container"));
        if (r156 == null) goto L142;
        ViewGroup.LayoutParams r157 = r156.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r157, ConstraintLayout.LayoutParams.class) == false) goto L138;
        ConstraintLayout.LayoutParams r158 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r157, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
    L139:
        if (r158 == null) goto L142;
        r158.matchConstraintMinWidth = 0;
        r158.matchConstraintMaxWidth = 0;
        r156.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r158, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        goto L142
    L138:
        r158 = null;
    L142:
        com.obric.autoaction.app.launcherpage.a.i r159 = this.f23357c;
        if (r159 != null) goto L145;
        d.h.b.o.c("binding");
        r159 = null;
    L145:
        OCardListItem.setCardPosition$default(r159.f22824b, 1, false, 2, null);
        return;
    L126:
        r154 = null;
        goto L127
    L113:
        com.obric.autoaction.app.launcherpage.a.i r160 = this.f23357c;
        if (r160 != null) goto L116;
        d.h.b.o.c("binding");
        r160 = null;
    L116:
        OCardListItem.setCardPosition$default(r160.f22825c, 3, false, 2, null);
        goto L117
    L11:
        throw new d.k();
    }

    private final String a(List<com.obric.autoaction.app.launcherpage.utils.j<Integer>> r11) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L11;
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r14 = r12.iterator();
    L6:
        if (r14.hasNext() == false) goto L10;
        Object r1 = r14.next();
        if (((com.obric.autoaction.app.launcherpage.utils.j) ZeusTransformUtils.preCheckCast(r1, com.obric.autoaction.app.launcherpage.utils.j.class, "com.obric.aiagent.plugin")).b() == false) goto L6;
        r13.add(r1);
        goto L6
    L10:
        List r15 = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin");
    L12:
        if (r15 != null) goto L15;
        r15 = d.a.p.b();
    L15:
        if (r15.size() < 7) goto L18;
        return "每天";
    L18:
        return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$u$5Wn0YpRnULHaNdnYLy1DC8U8oY.INSTANCE, 30, null);
    L11:
        r15 = null;
        goto L12
    }

    private static final CharSequence a(com.obric.autoaction.app.launcherpage.utils.j r3) {
        d.h.b.o.e(r3, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(21608 + com.obric.autoaction.app.launcherpage.condition.a.f.a(((Number) ZeusTransformUtils.preCheckCast(r3.c(), Number.class, "com.obric.aiagent.plugin")).intValue()), CharSequence.class, "com.obric.aiagent.plugin");
    }

    private final void o() {
        com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a r0 = ((t) ZeusTransformUtils.preCheckCast(f(), t.class, "com.obric.aiagent.plugin")).c();
        if (r0 != null) goto L5;
        r0 = com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a.f22915a;
    L5:
        int r1 = b.f23360a[r0.ordinal()];
        if (r1 == 1) goto L33;
        int r3 = 0;
        if (r1 != 2) goto L10;
        Integer r2 = ((t) ZeusTransformUtils.preCheckCast(f(), t.class, "com.obric.aiagent.plugin")).e();
        if (r2 == null) goto L32;
        r3 = r2.intValue();
    L32:
        PeriodicPolicy r4 = new PeriodicPolicy(false, null, r3, null, false, false, null, false, null, 507, null);
    L48:
        ((t) ZeusTransformUtils.preCheckCast(f(), t.class, "com.obric.aiagent.plugin")).a(r4);
        com.obric.autoaction.app.launcherpage.detail.base.a r5 = getContext();
        if (r5 == null) goto L58;
        r5.a((com.obric.autoaction.app.launcherpage.detail.base.h) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.detail.base.j.i(r4), com.obric.autoaction.app.launcherpage.detail.base.h.class, "com.obric.aiagent.plugin"));
        return;
    L58:
        return;
    L10:
        if (r1 != 3) goto L12;
        Integer r6 = ((t) ZeusTransformUtils.preCheckCast(f(), t.class, "com.obric.aiagent.plugin")).f();
        if (r6 == null) goto L24;
        int r7 = r6.intValue();
    L25:
        Integer r8 = ((t) ZeusTransformUtils.preCheckCast(f(), t.class, "com.obric.aiagent.plugin")).g();
        if (r8 == null) goto L28;
        r3 = r8.intValue();
    L28:
        r4 = new PeriodicPolicy(false, null, 0, com.obric.autoaction.app.launcherpage.condition.a.e.a(r7) + '-' + com.obric.autoaction.app.launcherpage.condition.a.e.a(r3), false, false, null, false, null, 503, null);
        goto L48
    L24:
        r7 = 0;
        goto L25
    L12:
        if (r1 != 4) goto L14;
        r4 = new PeriodicPolicy(true, null, 0, null, false, false, null, false, null, 510, null);
        goto L48
    L14:
        if (r1 != 6) goto L16;
        r4 = new PeriodicPolicy(false, null, 0, null, true, false, null, false, null, 495, null);
        goto L48
    L16:
        if (r1 == 7) goto L18;
        r4 = new PeriodicPolicy(false, null, 0, null, false, false, null, true, null, 383, null);
        goto L48
    L18:
        r4 = new PeriodicPolicy(false, null, 0, null, false, true, null, false, null, 479, null);
        goto L48
    L33:
        List<com.obric.autoaction.app.launcherpage.utils.j<Integer>> r9 = ((t) ZeusTransformUtils.preCheckCast(f(), t.class, "com.obric.aiagent.plugin")).d();
        if (r9 == null) goto L46;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r10.iterator();
    L37:
        if (r12.hasNext() == false) goto L41;
        Object r13 = r12.next();
        if (((com.obric.autoaction.app.launcherpage.utils.j) ZeusTransformUtils.preCheckCast(r13, com.obric.autoaction.app.launcherpage.utils.j.class, "com.obric.aiagent.plugin")).b() == false) goto L37;
        r11.add(r13);
        goto L37
    L41:
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r14, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r16 = r14.iterator();
    L43:
        if (r16.hasNext() == false) goto L45;
        r15.add(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(((com.obric.autoaction.app.launcherpage.utils.j) ZeusTransformUtils.preCheckCast(r16.next(), com.obric.autoaction.app.launcherpage.utils.j.class, "com.obric.aiagent.plugin")).c(), Number.class, "com.obric.aiagent.plugin")).intValue()));
        goto L43
    L45:
        int[] r17 = d.a.p.e((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin"));
    L47:
        r4 = new PeriodicPolicy(false, r17, 0, null, false, false, null, false, null, 509, null);
        goto L48
    L46:
        r17 = null;
        goto L47
    }
}
