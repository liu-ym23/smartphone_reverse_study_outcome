package com.stepos.widget.preference;

import V3.v;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.SwitchPreferenceCompat;
import androidx.preference.l;
import com.stepos.widget.list.StepOSListItem;
import com.stepos.widget.list.b;
import com.stepos.widget.preference.StepOSSwitchPreference;
import i4.InterfaceC0761a;
import j4.g;
import j4.k;
import l3.C0844b;
import l3.h;
import l3.j;
import v3.C1184a;
import v3.C1186c;
import v3.C1190g;
import v3.C1191h;

/* loaded from: classes.dex */
public class StepOSSwitchPreference extends SwitchPreferenceCompat {

    /* renamed from: b0, reason: collision with root package name */
    private final b f16345b0;

    /* renamed from: c0, reason: collision with root package name */
    private final C1184a f16346c0;

    /* renamed from: d0, reason: collision with root package name */
    private final C1191h f16347d0;

    /* renamed from: e0, reason: collision with root package name */
    private final C1190g f16348e0;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSSwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        k.g(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(StepOSSwitchPreference stepOSSwitchPreference, final l lVar, StepOSListItem stepOSListItem, boolean z5) {
        k.g(stepOSListItem, "item");
        if (z5 == stepOSSwitchPreference.R0()) {
            return;
        }
        boolean z6 = stepOSListItem.g0() && stepOSSwitchPreference.M() && stepOSSwitchPreference.O();
        if (!stepOSSwitchPreference.d(Boolean.valueOf(z5))) {
            stepOSListItem.setSwitchChecked(stepOSSwitchPreference.R0());
            return;
        }
        stepOSSwitchPreference.S0(z5);
        if (z6) {
            stepOSSwitchPreference.f16348e0.b(new InterfaceC0761a() { // from class: v3.f
                @Override // i4.InterfaceC0761a
                public final Object invoke() {
                    return StepOSSwitchPreference.h1(lVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v h1(l lVar) {
        lVar.itemView.callOnClick();
        return v.f5542a;
    }

    @Override // androidx.preference.Preference
    public boolean M() {
        C1190g c1190g = this.f16348e0;
        return (c1190g != null && c1190g.c()) || super.M();
    }

    @Override // androidx.preference.Preference
    public boolean O() {
        C1190g c1190g = this.f16348e0;
        return (c1190g != null && c1190g.c()) || super.O();
    }

    @Override // androidx.preference.SwitchPreferenceCompat, androidx.preference.Preference
    public void W(final l lVar) throws Resources.NotFoundException {
        k.g(lVar, "holder");
        super.W(lVar);
        View view = lVar.itemView;
        k.f(view, "itemView");
        StepOSListItem stepOSListItemE1 = e1(view);
        if (stepOSListItemE1 == null) {
            return;
        }
        this.f16346c0.v(2);
        this.f16346c0.t(Boolean.valueOf(R0()));
        this.f16346c0.u(new StepOSListItem.d() { // from class: v3.e
            @Override // com.stepos.widget.list.StepOSListItem.d
            public final void a(StepOSListItem stepOSListItem, boolean z5) {
                StepOSSwitchPreference.g1(this.f23342a, lVar, stepOSListItem, z5);
            }
        });
        C1186c.h(stepOSListItemE1, this.f16345b0, this.f16346c0, I(), G(), p(), M(), false);
        this.f16347d0.a(stepOSListItemE1);
        f1(stepOSListItemE1);
    }

    @Override // androidx.preference.TwoStatePreference, androidx.preference.Preference
    protected void X() {
        if (this.f16348e0.a()) {
            return;
        }
        boolean zR0 = R0();
        super.X();
        if (zR0 != R0()) {
            this.f16347d0.c();
        }
    }

    protected StepOSListItem e1(View view) {
        k.g(view, "view");
        StepOSListItem stepOSListItem = view instanceof StepOSListItem ? (StepOSListItem) view : null;
        return stepOSListItem == null ? (StepOSListItem) view.findViewById(h.f18418J) : stepOSListItem;
    }

    protected void f1(StepOSListItem stepOSListItem) {
        k.g(stepOSListItem, "row");
    }

    public /* synthetic */ StepOSSwitchPreference(Context context, AttributeSet attributeSet, int i5, int i6, int i7, g gVar) {
        this(context, (i7 & 2) != 0 ? null : attributeSet, (i7 & 4) != 0 ? C0844b.f18287h : i5, (i7 & 8) != 0 ? l3.l.f18494q : i6);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSSwitchPreference(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        k.g(context, "context");
        this.f16345b0 = b.f16254V.d(context, attributeSet, i5, i6);
        C1184a c1184a = new C1184a();
        c1184a.v(2);
        this.f16346c0 = c1184a;
        this.f16347d0 = new C1191h();
        this.f16348e0 = new C1190g();
        z0(j.f18468k);
    }
}
