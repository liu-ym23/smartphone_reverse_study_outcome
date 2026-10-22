package com.obric.autoaction.app.launcherpage.detail.base.container;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.activity.ComponentActivity;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.agent.omnimodel.IOmniModelService;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.RepeatTaskHistoryActivity;
import com.obric.autoaction.app.launcherpage.a.au;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.TriggerControlPolicy;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DetailModelExtraViewContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends z<m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f23335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f23336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f23337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private au f23338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f23339e;

    public n() {
        this(null, false, false, 7, null);
    }

    /* JADX INFO: renamed from: lambda$BtAWGtMHej-3z37_xaFb4I__eiU, reason: not valid java name */
    public static /* synthetic */ void m482lambda$BtAWGtMHej3z37_xaFb4I__eiU(n r0, CompoundButton r1, boolean r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ d.x lambda$EHwLH25zage_55Yv4ahWAYfT6Uo(String r0, n r1, com.obric.autoaction.app.launcherpage.utils.j r2, int r3) {
        return a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$O3gCAd53ODsdS-otDKNTnahTFYw, reason: not valid java name */
    public static /* synthetic */ void m483lambda$O3gCAd53ODsdSotDKNTnahTFYw(n r0, View r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$wGONNXsBWO_AORUJj4usOQow-h0, reason: not valid java name */
    public static /* synthetic */ void m484lambda$wGONNXsBWO_AORUJj4usOQowh0(n r0, View r1) {
        b(r0, r1);
    }

    public /* synthetic */ n(String r2, boolean r3, boolean r4, int r5, d.h.b.h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = false;
    L11:
        this(r2, r3, r4);
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public /* synthetic */ com.obric.autoaction.app.launcherpage.detail.base.f b(com.obric.autoaction.app.launcherpage.detail.base.a r2) {
        return (com.obric.autoaction.app.launcherpage.detail.base.f) ZeusTransformUtils.preCheckCast(a(r2), com.obric.autoaction.app.launcherpage.detail.base.f.class, "com.obric.aiagent.plugin");
    }

    public n(String r1, boolean r2, boolean r3) {
        this.f23335a = r1;
        this.f23336b = r2;
        this.f23337c = r3;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public View a(ViewGroup r4) {
        d.h.b.o.e(r4, "parent");
        au r5 = au.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r4, false);
        d.h.b.o.c(r5, "inflate(...)");
        this.f23338d = r5;
        if (r5 != null) goto L5;
        d.h.b.o.c("binding");
        r5 = null;
    L5:
        LinearLayout r3 = r5.b();
        d.h.b.o.c(r3, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
    }

    public m a(com.obric.autoaction.app.launcherpage.detail.base.a r12) {
        d.h.b.o.e(r12, "context");
        EventTask r11 = r12.c().a();
        IOmniModelService r0 = IOmniModelService.Companion.a();
        boolean r1 = true;
        String r3 = null;
        if (r11 == null) goto L11;
        String r4 = r11.getOmniModel();
        if (r4 == null) goto L11;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
        r4 = null;
    L10:
        if (r4 == null) goto L11;
    L12:
        String r6 = r4;
        if (ZeusTransformUtils.instanceOf(r11, ConditionTask.class) == false) goto L15;
        ConditionTask r2 = (ConditionTask) ZeusTransformUtils.preCheckCast(r11, ConditionTask.class, "com.obric.aiagent.plugin");
    L17:
        if (r2 == null) goto L23;
        TriggerControlPolicy r5 = r2.getTriggerControlPolicy();
        if (r5 == null) goto L23;
        Boolean r7 = r5.getEnable();
        if (r7 == null) goto L23;
        boolean r8 = r7.booleanValue();
    L24:
        String r13 = r12.c().c();
        if (r13 != null) goto L27;
        r13 = "0";
    L27:
        String r9 = r13;
        if (r11 == null) goto L37;
        String r14 = r11.getId();
        if (r14 == null) goto L37;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L35;
        r1 = false;
    L35:
        if (r1 == false) goto L37;
        String r10 = r14;
    L38:
        if (r11 == null) goto L40;
        r3 = o.a(r11);
    L40:
        if (r3 != null) goto L42;
        String r15 = "";
    L44:
        return new m(r6, r8, r9, r10, r15);
    L42:
        r15 = r3;
    L37:
        r10 = null;
    L23:
        r8 = false;
        goto L24
    L15:
        r2 = null;
    L11:
        r4 = r0.defaultDisplayModel();
        goto L12
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public void a() {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.f23335a, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        au r3 = null;
        if (r1 == false) goto L15;
        au r2 = this.f23338d;
        if (r2 != null) goto L14;
        d.h.b.o.c("binding");
        r2 = null;
    L14:
        OTextView r4 = r2.f22780b;
        d.h.b.o.c(r4, "detailModelExtraTitle");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"));
    L22:
        au r5 = this.f23338d;
        if (r5 != null) goto L25;
        d.h.b.o.c("binding");
        r5 = null;
    L25:
        r5.f22781c.setOnContentClickListener(new $$Lambda$n$O3gCAd53ODsdSotDKNTnahTFYw(this));
        au r6 = this.f23338d;
        if (r6 != null) goto L28;
        d.h.b.o.c("binding");
        r6 = null;
    L28:
        OSwitch r7 = r6.f22779a.getEndSwitch();
        if (r7 == null) goto L31;
        r7.setOnCheckedChangeListener(new $$Lambda$n$BtAWGtMHej3z37_xaFb4I__eiU(this));
    L31:
        au r8 = this.f23338d;
        if (r8 != null) goto L34;
        d.h.b.o.c("binding");
    L35:
        r3.f22782d.setOnContentClickListener(new $$Lambda$n$wGONNXsBWO_AORUJj4usOQowh0(this));
        return;
    L34:
        r3 = r8;
        goto L35
    L15:
        au r9 = this.f23338d;
        if (r9 != null) goto L18;
        d.h.b.o.c("binding");
        r9 = null;
    L18:
        r9.f22780b.setText((CharSequence) ZeusTransformUtils.preCheckCast(this.f23335a, CharSequence.class, "com.obric.aiagent.plugin"));
        au r10 = this.f23338d;
        if (r10 != null) goto L21;
        d.h.b.o.c("binding");
        r10 = null;
    L21:
        OTextView r11 = r10.f22780b;
        d.h.b.o.c(r11, "detailModelExtraTitle");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.aiagent.plugin"));
        goto L22
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    private static final void a(n r0, View r1) {
        r0.m();
    }

    private static final void a(n r3, CompoundButton r4, boolean r5) {
        if (r3.f23339e == false) goto L5;
        return;
    L5:
        com.obric.autoaction.app.launcherpage.detail.base.a r6 = r3.getContext();
        if (r6 == null) goto L9;
        r6.a((com.obric.autoaction.app.launcherpage.detail.base.h) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.detail.base.j.f(new TriggerControlPolicy(Boolean.valueOf(r5), null, 2, null)), com.obric.autoaction.app.launcherpage.detail.base.h.class, "com.obric.aiagent.plugin"));
        return;
    }

    private static final void b(n r4, View r5) {
        String r6 = ((m) ZeusTransformUtils.preCheckCast(r4.f(), m.class, "com.obric.aiagent.plugin")).d();
        if (r6 != null) goto L5;
        return;
    L5:
        RepeatTaskHistoryActivity.a r0 = RepeatTaskHistoryActivity.Companion;
        au r2 = r4.f23338d;
        if (r2 != null) goto L8;
        d.h.b.o.c("binding");
        r2 = null;
    L8:
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r3, "getContext(...)");
        r0.a(r3, r6, ((m) ZeusTransformUtils.preCheckCast(r4.f(), m.class, "com.obric.aiagent.plugin")).e());
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public void b() {
        i();
        j();
        k();
        l();
    }

    private final void i() {
        au r0 = this.f23338d;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        OCardListItem r1 = r0.f22781c;
        d.h.b.o.c(r1, "detailModelSelectItem");
        r1.setDefaultTailIcon(1);
        r1.showTailIcon(true);
        OCardListItem.setEndDetailText$default(r1, (CharSequence) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(f(), m.class, "com.obric.aiagent.plugin")).a(), CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
    }

    private final void j() {
        au r2 = null;
        if (this.f23336b == true) goto L10;
        au r5 = this.f23338d;
        if (r5 != null) goto L7;
        d.h.b.o.c("binding");
    L8:
        OCardListItem r6 = r2.f22779a;
        d.h.b.o.c(r6, "detailFrequencyControlItem");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"));
        return;
    L7:
        r2 = r5;
        goto L8
    L10:
        au r0 = this.f23338d;
        if (r0 != null) goto L13;
        d.h.b.o.c("binding");
        r0 = null;
    L13:
        OCardListItem r1 = r0.f22779a;
        d.h.b.o.c(r1, "detailFrequencyControlItem");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"));
        au r3 = this.f23338d;
        if (r3 != null) goto L16;
        d.h.b.o.c("binding");
    L17:
        OSwitch r4 = r2.f22779a.getEndSwitch();
        if (r4 != null) goto L20;
        return;
    L20:
        this.f23339e = true;
        r4.setChecked(((m) ZeusTransformUtils.preCheckCast(f(), m.class, "com.obric.aiagent.plugin")).b());
        this.f23339e = false;
        return;
    L16:
        r2 = r3;
        goto L17
    }

    private final void k() {
        au r4 = null;
        if (this.f23337c == true) goto L10;
        au r5 = this.f23338d;
        if (r5 != null) goto L7;
        d.h.b.o.c("binding");
    L8:
        OCardListItem r6 = r4.f22782d;
        d.h.b.o.c(r6, "detailRunHistoryItem");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"));
        return;
    L7:
        r4 = r5;
        goto L8
    L10:
        au r0 = this.f23338d;
        if (r0 != null) goto L13;
        d.h.b.o.c("binding");
        r0 = null;
    L13:
        OCardListItem r1 = r0.f22782d;
        d.h.b.o.c(r1, "detailRunHistoryItem");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"));
        au r2 = this.f23338d;
        if (r2 != null) goto L16;
        d.h.b.o.c("binding");
        r2 = null;
    L16:
        r2.f22782d.setDefaultTailIcon(0);
        au r3 = this.f23338d;
        if (r3 != null) goto L19;
        d.h.b.o.c("binding");
        r3 = null;
    L19:
        OCardListItem.setEndDetailText$default(r3.f22782d, (CharSequence) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(f(), m.class, "com.obric.aiagent.plugin")).c(), CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
    }

    private final void l() {
        List r0 = d.a.p.a();
        au r1 = this.f23338d;
        if (r1 != null) goto L5;
        d.h.b.o.c("binding");
        r1 = null;
    L5:
        OCardListItem r2 = r1.f22781c;
        d.h.b.o.c(r2, "detailModelSelectItem");
        r0.add(r2);
        if (this.f23336b == false) goto L12;
        au r3 = this.f23338d;
        if (r3 != null) goto L10;
        d.h.b.o.c("binding");
        r3 = null;
    L10:
        OCardListItem r4 = r3.f22779a;
        d.h.b.o.c(r4, "detailFrequencyControlItem");
        r0.add(r4);
    L12:
        if (this.f23337c == false) goto L17;
        au r8 = this.f23338d;
        if (r8 != null) goto L16;
        d.h.b.o.c("binding");
        r8 = null;
    L16:
        OCardListItem r9 = r8.f22782d;
        d.h.b.o.c(r9, "detailRunHistoryItem");
        r0.add(r9);
    L17:
        List r10 = d.a.p.a(r0);
        if (r10.size() != 1) goto L20;
        OCardListItem.setCardPosition$default((OCardListItem) ZeusTransformUtils.preCheckCast(d.a.p.k(r10), OCardListItem.class, "com.obric.aiagent.plugin"), 0, false, 2, null);
        return;
    L20:
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L22:
        if (r5.hasNext() == false) goto L24;
        OCardListItem.setCardPosition$default((OCardListItem) ZeusTransformUtils.preCheckCast(r5.next(), OCardListItem.class, "com.obric.aiagent.plugin"), 2, false, 2, null);
        goto L22
    L24:
        OCardListItem.setCardPosition$default((OCardListItem) ZeusTransformUtils.preCheckCast(d.a.p.k(r10), OCardListItem.class, "com.obric.aiagent.plugin"), 1, false, 2, null);
        OCardListItem.setCardPosition$default((OCardListItem) ZeusTransformUtils.preCheckCast(d.a.p.m(r10), OCardListItem.class, "com.obric.aiagent.plugin"), 3, false, 2, null);
    }

    private final void m() {
        IOmniModelService r1 = IOmniModelService.Companion.a();
        IOmniModelService.a r2 = IOmniModelService.Companion;
        com.obric.autoaction.app.launcherpage.detail.base.a r3 = getContext();
        Object r5 = null;
        if (r3 == null) goto L15;
        com.obric.autoaction.app.launcherpage.detail.base.b r4 = r3.c();
        if (r4 == null) goto L15;
        EventTask r6 = r4.a();
        if (r6 == null) goto L15;
        String r7 = r6.getOmniModel();
        if (r7 == null) goto L15;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L14;
        r7 = null;
    L14:
        if (r7 == null) goto L15;
    L16:
        final String r8 = r2.a(r7);
        List<IOmniModelService.c> r9 = r1.availableEntries();
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r10, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r10.iterator();
    L18:
        if (r12.hasNext() == false) goto L20;
        IOmniModelService.c r13 = (IOmniModelService.c) ZeusTransformUtils.preCheckCast(r12.next(), IOmniModelService.c.class, "com.obric.aiagent.plugin");
        r11.add(new com.obric.autoaction.app.launcherpage.utils.j(r13.a(), d.h.b.o.a(IOmniModelService.Companion.a(r13.a()), r8), r13.a(), null, null, 24, null));
        goto L18
    L20:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin");
        Iterator<IOmniModelService.c> r15 = r9.iterator();
        int r16 = 0;
    L22:
        if (r15.hasNext() == false) goto L27;
        if (d.h.b.o.a(IOmniModelService.Companion.a(((IOmniModelService.c) ZeusTransformUtils.preCheckCast(r15.next(), IOmniModelService.c.class, "com.obric.aiagent.plugin")).a()), r8) == true) goto L28;
        r16 = r16 + 1;
    L28:
        int r17 = d.l.n.c(r16, 0);
        au r18 = this.f23338d;
        if (r18 != null) goto L31;
        d.h.b.o.c("binding");
        r18 = null;
    L31:
        Context r19 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r18.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r19, "getContext(...)");
        Activity r20 = (Activity) ZeusTransformUtils.preCheckCast((ComponentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.autoaction.app.launcherpage.ui.e.a(r19), "com.obric.aiagent.plugin"), ComponentActivity.class, "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.app.launcherpage.detail.base.a r21 = getContext();
        if (r21 == null) goto L36;
        com.obric.autoaction.app.launcherpage.detail.base.d r22 = r21.a();
        if (r22 == null) goto L36;
        Dialog r23 = r22.getDialog();
    L37:
        au r24 = this.f23338d;
        if (r24 != null) goto L40;
        d.h.b.o.c("binding");
        r24 = null;
    L40:
        OCardListItem r25 = r24.f22781c;
        d.h.b.o.c(r25, "detailModelSelectItem");
        View r110 = (View) ZeusTransformUtils.preCheckCast(r25, View.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.app.launcherpage.utils.i r111 = new com.obric.autoaction.app.launcherpage.utils.i(r14, r17, com.obric.autoaction.app.launcherpage.utils.p.a(ZeusTransformUtils.mapRes(R.string.omni_mode_select_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "omni_mode_select_title"), null, 1, null), OInsetSheet.b.f36196a);
        Iterator r26 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L42:
        if (r26.hasNext() == false) goto L46;
        Object r27 = r26.next();
        if (d.h.b.o.a(IOmniModelService.Companion.a((String) ZeusTransformUtils.preCheckCast(((com.obric.autoaction.app.launcherpage.utils.j) ZeusTransformUtils.preCheckCast(r27, com.obric.autoaction.app.launcherpage.utils.j.class, "com.obric.aiagent.plugin")).c(), String.class, "com.obric.aiagent.plugin")), r8) == false) goto L42;
        r5 = r27;
    L46:
        com.obric.autoaction.app.launcherpage.utils.p.a(r20, r23, r110, r111, (com.obric.autoaction.app.launcherpage.utils.j) ZeusTransformUtils.preCheckCast(r5, com.obric.autoaction.app.launcherpage.utils.j.class, "com.obric.aiagent.plugin"), new $$Lambda$n$EHwLH25zage_55Yv4ahWAYfT6Uo(r8, this));
        return;
    L36:
        r23 = null;
        goto L37
    L27:
        r16 = -1;
    L15:
        r7 = r1.defaultDisplayModel();
        goto L16
    }

    private static final d.x a(String r4, n r5, com.obric.autoaction.app.launcherpage.utils.j r6, int r7) {
        d.h.b.o.e(r6, "itemData");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r6.c(), String.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(IOmniModelService.Companion.a(r8), r4) == true) goto L11;
        au r9 = r5.f23338d;
        if (r9 != null) goto L7;
        d.h.b.o.c("binding");
        r9 = null;
    L7:
        OCardListItem.setEndDetailText$default(r9.f22781c, (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
        com.obric.autoaction.app.launcherpage.detail.base.a r10 = r5.getContext();
        if (r10 == null) goto L11;
        r10.a((com.obric.autoaction.app.launcherpage.detail.base.h) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.detail.base.j.g(r8), com.obric.autoaction.app.launcherpage.detail.base.h.class, "com.obric.aiagent.plugin"));
    L11:
        return d.x.f38692a;
    }
}
