package com.obric.autoaction.app.launcherpage.condition.location;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.ap;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.detail.base.RightSlideOSheet;
import com.obric.oui.sheet.v2.OSheet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.z;
import d.x;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.ak;
import kotlinx.coroutines.ca;

/* JADX INFO: compiled from: FrequentLocationEditComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23172a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ComponentActivity f23173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConditionEventLocationView f23174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.f f23175d;

    /* JADX INFO: compiled from: FrequentLocationEditComponent.kt */
    public static final class a {

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.condition.location.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: FrequentLocationEditComponent.kt */
        static final class C0503a implements d.h.a.b<Throwable, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OSheet f23176a;

            C0503a(OSheet r1) {
                this.f23176a = r1;
            }

            @Override // d.h.a.b
            public /* synthetic */ x invoke(Throwable r3) {
                a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }

            public final void a(Throwable r1) {
                a r2 = e.f23172a;
                OSheet r0 = this.f23176a;
                d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L5
                r0.dismiss();     // Catch: Throwable -> L5
                d.n.f(x.f38692a);     // Catch: Throwable -> L5
                return;
            L5:
                th = move-exception;
                d.n.a r4 = d.n.f38560a;
                d.n.f(d.o.a(th));
            }
        }

        /* JADX INFO: compiled from: FrequentLocationEditComponent.kt */
        static final class b implements d.h.a.b<ConditionLocationItemData, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.n<ConditionLocationItemData> f23177a;

            b(kotlinx.coroutines.n<? super ConditionLocationItemData> r3) {
                this.f23177a = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ x invoke(ConditionLocationItemData r3) {
                a((ConditionLocationItemData) ZeusTransformUtils.preCheckCast(r3, ConditionLocationItemData.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }

            public final void a(ConditionLocationItemData r3) {
                if (this.f23177a.a() == false) goto L6;
                d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f23177a, d.c.d.class, "com.obric.aiagent.plugin");
                d.n.a r0 = d.n.f38560a;
                r2.resumeWith(d.n.f(r3));
                return;
            }
        }

        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final Object a(ComponentActivity r6, ConditionLocationItemData r7, d.c.d<? super ConditionLocationItemData> r8) {
            ComponentActivity r5 = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r6, ComponentActivity.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            if (com.obric.autoaction.app.launcherpage.condition.config.condition.h.f23036a.a((Context) ZeusTransformUtils.preCheckCast(r5, Context.class, "com.obric.aiagent.plugin")) == true) goto L6;
            return null;
        L6:
            kotlinx.coroutines.o r10 = new kotlinx.coroutines.o(d.c.a.b.a(r9), 1);
            r10.e();
            kotlinx.coroutines.n r1 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r10, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
            r1.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new C0503a(new e(r5).a((p) ZeusTransformUtils.preCheckCast(r5, p.class, "com.obric.aiagent.plugin"), r7, (d.h.a.b) ZeusTransformUtils.preCheckCast(new b(r1), d.h.a.b.class, "com.obric.aiagent.plugin"))), d.h.a.b.class, "com.obric.aiagent.plugin"));
            Object r11 = r10.h();
            if (r11 != d.c.a.b.a()) goto L9;
            d.c.b.a.h.c(r9);
        L9:
            return r11;
        }
    }

    /* JADX INFO: compiled from: FrequentLocationEditComponent.kt */
    @d.c.b.a.f(b = "FrequentLocationEditComponent.kt", c = {149}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.condition.location.FrequentLocationEditComponent$init$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f23179b;

        b(e r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23179b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f23179b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23178a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            d.o.a(r6);
        L12:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            ak<List<ConditionLocationItemData>> r7 = e.a(this.f23179b).b();
            final e r3 = this.f23179b;
            kotlinx.coroutines.b.i<? super List<ConditionLocationItemData>> r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d<?> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23178a = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: FrequentLocationEditComponent.kt */
    /* synthetic */ class c extends d.h.b.l implements d.h.a.b<Editable, x> {
        c(Object r8) {
            super(1, r8, e.class, "afterTextChanged", "afterTextChanged(Landroid/text/Editable;)V", 0);
        }

        public final void a(Editable r3) {
            Editable r4 = (Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.aiagent.plugin");
            e.a((e) ZeusTransformUtils.preCheckCast(this.receiver, e.class, "com.obric.aiagent.plugin"), r4);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Editable r3) {
            a((Editable) ZeusTransformUtils.preCheckCast(r3, Editable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: FrequentLocationEditComponent.kt */
    /* synthetic */ class d extends d.h.b.l implements d.h.a.b<ConditionLocationItemData, x> {
        d(Object r8) {
            super(1, r8, e.class, "onSelectLocationItem", "onSelectLocationItem(Lcom/obric/autoaction/app/launcherpage/condition/location/ConditionLocationItemData;)V", 0);
        }

        public final void a(ConditionLocationItemData r3) {
            e.a((e) ZeusTransformUtils.preCheckCast(this.receiver, e.class, "com.obric.aiagent.plugin"), r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(ConditionLocationItemData r3) {
            a((ConditionLocationItemData) ZeusTransformUtils.preCheckCast(r3, ConditionLocationItemData.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    static {
        f23172a = new a(null);
    }

    public static /* synthetic */ void lambda$UpDn1HAfFdUFsc6Adg9Q6R6a9GM(ca r0, e r1, z.a r2, d.h.a.b r3, DialogInterface r4) {
        a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ x lambda$l3SqNE65DkUVTq6elbOte3NHCY4(ConditionEventLocationView r0, RightSlideOSheet r1, z.a r2, d.h.a.b r3, View r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ com.obric.autoaction.app.launcherpage.condition.location.d lambda$lzE3r6Jss0ZXIchOfgg7pvjiQAg(e r0) {
        return c(r0);
    }

    public static /* synthetic */ x lambda$wvYeiHA0EdYpYmtLx0cS4STgfHM(RightSlideOSheet r0, z.a r1, d.h.a.b r2, View r3) {
        return a(r0, r1, r2, r3);
    }

    public e(ComponentActivity r3) {
        ComponentActivity r4 = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r3, ComponentActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "activity");
        this.f23173b = r4;
        this.f23175d = d.g.a(new $$Lambda$e$lzE3r6Jss0ZXIchOfgg7pvjiQAg(this));
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.condition.location.d a(e r0) {
        return r0.a();
    }

    public static final /* synthetic */ void a(e r2, Editable r3) {
        r2.a((Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(e r0, ConditionLocationItemData r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ ConditionEventLocationView b(e r0) {
        return r0.f23174c;
    }

    private final com.obric.autoaction.app.launcherpage.condition.location.d a() {
        return (com.obric.autoaction.app.launcherpage.condition.location.d) ZeusTransformUtils.preCheckCast(this.f23175d.b(), com.obric.autoaction.app.launcherpage.condition.location.d.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.autoaction.app.launcherpage.condition.location.d c(e r3) {
        return (com.obric.autoaction.app.launcherpage.condition.location.d) ZeusTransformUtils.preCheckCast(new androidx.lifecycle.am((ap) ZeusTransformUtils.preCheckCast(r3.f23173b, ap.class, "com.obric.aiagent.plugin")).a("frequent_location_edit", com.obric.autoaction.app.launcherpage.condition.location.d.class), com.obric.autoaction.app.launcherpage.condition.location.d.class, "com.obric.aiagent.plugin");
    }

    public final OSheet a(p r18, ConditionLocationItemData r19, d.h.a.b<? super ConditionLocationItemData, x> r20) {
        p r1 = (p) ZeusTransformUtils.wrapperContextForParams(r18, p.class, "com.obric.aiagent.plugin");
        final d.h.a.b r3 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r20, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "lifecycleOwner");
        d.h.b.o.e(r19, "item");
        d.h.b.o.e(r3, "onResult");
        ComponentActivity r4 = this.f23173b;
        if (r19.getType() != 0) goto L5;
        int r6 = ZeusTransformUtils.mapRes(R.string.condition_location_edit_home_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_location_edit_home_title");
    L6:
        String r11 = r4.getString(r6);
        d.h.b.o.c(r11, "getString(...)");
        String r12 = this.f23173b.getString(ZeusTransformUtils.mapRes(R.string.condition_event_detail_to_location, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_detail_to_location"));
        d.h.b.o.c(r12, "getString(...)");
        final ConditionEventLocationView r5 = new ConditionEventLocationView((Context) ZeusTransformUtils.preCheckCast(this.f23173b, Context.class, "com.obric.aiagent.plugin"), null, r11, r12, 0, false, 50, null);
        r5.configAdapter("to", f.a(r19));
        r5.setAfterTextChangedListener((d.h.a.b) ZeusTransformUtils.preCheckCast(new c(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
        r5.setSelectLocationItemCallback((d.h.a.b) ZeusTransformUtils.preCheckCast(new d(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
        this.f23174c = r5;
        final ca r2 = a(r1);
        final z.a r7 = new z.a();
        final RightSlideOSheet r8 = new RightSlideOSheet((Context) ZeusTransformUtils.preCheckCast(this.f23173b, Context.class, "com.obric.aiagent.plugin"));
        r8.setHeaderView(null);
        r8.setBodyView((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin"));
        r8.setHeightMode(OSheet.c.f36215a);
        r8.setOnDismissListener(new $$Lambda$e$UpDn1HAfFdUFsc6Adg9Q6R6a9GM(r2, this, r7, r3));
        r8.show();
        r5.setOnConfirmButtonListener(new $$Lambda$e$l3SqNE65DkUVTq6elbOte3NHCY4(r5, r8, r7, r3));
        r5.setOnBackClickListener(new $$Lambda$e$wvYeiHA0EdYpYmtLx0cS4STgfHM(r8, r7, r3));
        return (OSheet) ZeusTransformUtils.preCheckCast(r8, OSheet.class, "com.obric.aiagent.plugin");
    L5:
        r6 = ZeusTransformUtils.mapRes(R.string.condition_location_edit_company_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_location_edit_company_title");
        goto L6
    }

    private static final void a(z.a r2, d.h.a.b<? super ConditionLocationItemData, x> r3, ConditionLocationItemData r4) {
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (r2.f38499a == false) goto L5;
        return;
    L5:
        r2.f38499a = true;
        r5.invoke(r4);
    }

    private static final void a(ca r2, e r3, z.a r4, d.h.a.b r5, DialogInterface r6) {
        ca r7 = (ca) ZeusTransformUtils.wrapperContextForParams(r2, ca.class, "com.obric.aiagent.plugin");
        d.h.a.b r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        DialogInterface r9 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r6, DialogInterface.class, "com.obric.aiagent.plugin");
        a(r4, r8, null);
        ca.a.a(r7, null, 1, null);
        r3.f23174c = null;
    }

    private static final x a(ConditionEventLocationView r2, RightSlideOSheet r3, z.a r4, d.h.a.b r5, View r6) {
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "it");
        ConditionLocationItemData r8 = r2.getSelectLocationItemData();
        if (r8 == null) goto L5;
        a(r4, r7, r8);
        r3.dismiss();
        return x.f38692a;
    L5:
        return x.f38692a;
    }

    private static final x a(RightSlideOSheet r2, z.a r3, d.h.a.b r4, View r5) {
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "it");
        a(r3, r6, null);
        r2.dismiss();
        return x.f38692a;
    }

    private final void a(ConditionLocationItemData r1) {
        ConditionEventLocationView r0 = this.f23174c;
        if (r0 == null) goto L11;
        View r2 = r0.getConfirmButton();
        if (r2 == null) goto L12;
        if (r1 == null) goto L8;
        boolean r3 = true;
    L9:
        r2.setEnabled(r3);
        return;
    L8:
        r3 = false;
        goto L9
    L12:
        return;
    }

    private final ca a(p r9) {
        p r10 = (p) ZeusTransformUtils.wrapperContextForParams(r9, p.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.app.launcherpage.condition.location.d.a(a(), (Context) ZeusTransformUtils.preCheckCast(this.f23173b, Context.class, "com.obric.aiagent.plugin"), false, false, 4, null);
        return kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(q.a(r10), am.class, "com.obric.aiagent.plugin"), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void a(Editable r9) {
        Editable r10 = (Editable) ZeusTransformUtils.wrapperContextForParams(r9, Editable.class, "com.obric.aiagent.plugin");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        com.obric.autoaction.app.launcherpage.condition.location.d.a(a(), (Context) ZeusTransformUtils.preCheckCast(this.f23173b, Context.class, "com.obric.aiagent.plugin"), false, false, 4, null);
        return;
    L11:
        a().a((Context) ZeusTransformUtils.preCheckCast(this.f23173b, Context.class, "com.obric.aiagent.plugin"), r10.toString());
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
