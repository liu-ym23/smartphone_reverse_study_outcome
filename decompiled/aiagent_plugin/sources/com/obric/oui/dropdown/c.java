package com.obric.oui.dropdown;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.popover.OPopover;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/* JADX INFO: compiled from: ODropdownRatio.kt */
/* JADX INFO: loaded from: classes4.dex */
public class c<V> implements com.obric.oui.dropdown.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<V> f35237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Consumer<V>> f35238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private V f35239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f35240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f35241e;
    private d.h.a.b<? super CharSequence, x> f;
    private d.h.a.a<x> g;

    /* JADX INFO: compiled from: ODropdownRatio.kt */
    static final class a extends p implements m<View, Integer, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c<V> f35242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ODropdownTrigger f35243b;

        a(c<V> r1, ODropdownTrigger r2) {
            this.f35242a = r1;
            this.f35243b = r2;
            super(2);
        }

        @Override // d.h.a.m
        public /* synthetic */ x invoke(View r3, Integer r4) {
            a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue());
            return x.f38692a;
        }

        public final void a(View r4, int r5) {
            o.e(r4, "$noName_0");
            Object r6 = c.a(this.f35242a).get(r5);
            c.a(this.f35242a, r6);
            d.h.a.b r0 = c.b(this.f35242a);
            d.h.a.a r1 = null;
            if (r0 != null) goto L5;
            o.c("onTextChanged");
            r0 = null;
        L5:
            r0.invoke(String.valueOf(c.a(this.f35242a).get(r5)));
            if (ZeusTransformUtils.instanceOf(r6, com.obric.oui.dropdown.a.class) == false) goto L8;
            this.f35243b.getValue().setCompoundDrawablesRelativeWithIntrinsicBounds(((com.obric.oui.dropdown.a) ZeusTransformUtils.preCheckCast(r6, com.obric.oui.dropdown.a.class, "com.obric.aiagent.plugin")).a(), 0, 0, 0);
        L8:
            d.h.a.a r3 = c.c(this.f35242a);
            if (r3 != null) goto L11;
            o.c("dismiss");
        L12:
            r1.invoke();
            return;
        L11:
            r1 = r3;
            goto L12
        }
    }

    /* JADX INFO: compiled from: ODropdownRatio.kt */
    static final class b extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OPopover f35244a;

        b(OPopover r1) {
            this.f35244a = r1;
            super(0);
        }

        public final void a() {
            this.f35244a.dismiss();
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.dropdown.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ODropdownRatio.kt */
    public static final class C0955c implements OPopover.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<x> f35245a;

        C0955c(d.h.a.a<x> r3) {
            this.f35245a = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.oui.popover.OPopover.e
        public void a() {
            this.f35245a.invoke();
        }
    }

    public c(List<? extends V> r4, int r5) {
        List<V> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r6, "options");
        this.f35237a = r6;
        this.f35238b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.f35239c = r6.get(r5);
        this.f35240d = 10000;
    }

    public static final /* synthetic */ List a(c r0) {
        return r0.f35237a;
    }

    public static final /* synthetic */ void a(c r0, Object r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ d.h.a.b b(c r0) {
        return r0.f;
    }

    public static final /* synthetic */ d.h.a.a c(c r0) {
        return r0.g;
    }

    public final List<Consumer<V>> a() {
        return this.f35238b;
    }

    private final void a(V r4) {
        if (o.a(this.f35239c, r4) == false) goto L5;
        return;
    L5:
        this.f35239c = r4;
        Iterator<Consumer<V>> r3 = this.f35238b.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        ((Consumer) ZeusTransformUtils.preCheckCast(r3.next(), Consumer.class, "com.obric.aiagent.plugin")).accept(r4);
        goto L7
    }

    public final OPopover a(ODropdownTrigger r16, Activity r17, OPopoverEntranceMenuView r18, d.h.a.a<x> r19) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r17, Activity.class, "com.obric.aiagent.plugin");
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r19, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r16, "dropdown");
        o.e(r3, "activity");
        o.e(r18, "menuView");
        o.e(r5, "onDismiss");
        OPopover r2 = new OPopover.a(r3).a(false).a((View) ZeusTransformUtils.preCheckCast(r18, View.class, "com.obric.aiagent.plugin")).a(this.f35240d).b(true).a((OPopover.e) ZeusTransformUtils.preCheckCast(new C0955c(r5), OPopover.e.class, "com.obric.aiagent.plugin")).a(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(r3, Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_basic_bg_base_2_2_low_elevation, "color", "oui_basic_bg_base_2_2_low_elevation"))).R();
        this.g = (d.h.a.a) ZeusTransformUtils.preCheckCast(new b(r2), d.h.a.a.class, "com.obric.aiagent.plugin");
        com.obric.oui.popover.c.a(r2, (View) ZeusTransformUtils.preCheckCast(r16, View.class, "com.obric.aiagent.plugin"), 80, true, 0.0f, 0, 0, false, 120, null);
        return r2;
    }

    public final OPopoverEntranceMenuView a(Activity r19, ODropdownTrigger r20) {
        Activity r2 = (Activity) ZeusTransformUtils.wrapperContextForParams(r19, Activity.class, "com.obric.aiagent.plugin");
        o.e(r2, "activity");
        o.e(r20, "caller");
        OPopoverEntranceMenuView.a r4 = new OPopoverEntranceMenuView.a((Context) ZeusTransformUtils.preCheckCast(r2, Context.class, "com.obric.aiagent.plugin"));
        r4.b();
        if (this.f35241e == false) goto L5;
        r4.a(r20.getMeasuredWidth() - g.a((Context) ZeusTransformUtils.preCheckCast(r2, Context.class, "com.obric.aiagent.plugin"), 12));
    L5:
        Iterator<V> r3 = this.f35237a.iterator();
    L7:
        if (r3.hasNext() == false) goto L19;
        V r5 = r3.next();
        int r7 = 0;
        if (r5 != null) goto L12;
    L10:
        boolean r13 = false;
    L14:
        String r6 = String.valueOf(r5);
        if (ZeusTransformUtils.instanceOf(r5, com.obric.oui.dropdown.a.class) == false) goto L17;
        r7 = ((com.obric.oui.dropdown.a) ZeusTransformUtils.preCheckCast(r5, com.obric.oui.dropdown.a.class, "com.obric.aiagent.plugin")).a();
    L17:
        OPopoverEntranceMenuView.a.a(r4, false, Integer.valueOf(r7), null, null, (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), null, false, r13, (m) ZeusTransformUtils.preCheckCast(new a(this, r20), m.class, "com.obric.aiagent.plugin"), 77, null);
        goto L7
    L12:
        if (r5.equals(this.f35239c) != true) goto L10;
        r13 = true;
        goto L14
    L19:
        return r4.d();
    }

    @Override // com.obric.oui.dropdown.b
    public void a(ODropdownTrigger r3, Activity r4, d.h.a.a<x> r5, d.h.a.b<? super CharSequence, x> r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin");
        d.h.a.a<x> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super CharSequence, x> r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r3, "caller");
        o.e(r7, "activity");
        o.e(r8, "onDismiss");
        o.e(r9, "onTextChanged");
        this.f = r9;
        a(r3, r7, a(r7, r3), r8);
    }
}
