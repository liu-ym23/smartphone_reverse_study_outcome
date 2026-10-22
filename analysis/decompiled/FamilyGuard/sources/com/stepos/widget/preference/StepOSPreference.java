package com.stepos.widget.preference;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.Preference;
import androidx.preference.l;
import com.stepos.widget.list.StepOSListItem;
import com.stepos.widget.list.b;
import j4.g;
import j4.k;
import l3.C0844b;
import l3.h;
import l3.j;
import v3.C1184a;
import v3.C1186c;

/* loaded from: classes.dex */
public class StepOSPreference extends Preference {

    /* renamed from: T, reason: collision with root package name */
    private final b f16341T;

    /* renamed from: U, reason: collision with root package name */
    private final C1184a f16342U;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        k.g(context, "context");
    }

    protected StepOSListItem R0(View view) {
        k.g(view, "view");
        StepOSListItem stepOSListItem = view instanceof StepOSListItem ? (StepOSListItem) view : null;
        return stepOSListItem == null ? (StepOSListItem) view.findViewById(h.f18418J) : stepOSListItem;
    }

    protected void S0(StepOSListItem stepOSListItem) {
        k.g(stepOSListItem, "row");
    }

    public final void T0(int i5) {
        this.f16342U.v(Integer.valueOf(i5));
        Q();
    }

    @Override // androidx.preference.Preference
    public void W(l lVar) throws Resources.NotFoundException {
        k.g(lVar, "holder");
        super.W(lVar);
        View view = lVar.itemView;
        k.f(view, "itemView");
        StepOSListItem stepOSListItemR0 = R0(view);
        if (stepOSListItemR0 == null) {
            return;
        }
        C1186c.h(stepOSListItemR0, this.f16341T, this.f16342U, I(), G(), p(), M(), false);
        S0(stepOSListItemR0);
    }

    public /* synthetic */ StepOSPreference(Context context, AttributeSet attributeSet, int i5, int i6, int i7, g gVar) {
        this(context, (i7 & 2) != 0 ? null : attributeSet, (i7 & 4) != 0 ? C0844b.f18287h : i5, (i7 & 8) != 0 ? l3.l.f18494q : i6);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSPreference(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        k.g(context, "context");
        this.f16341T = b.f16254V.d(context, attributeSet, i5, i6);
        this.f16342U = new C1184a();
        z0(j.f18468k);
    }
}
