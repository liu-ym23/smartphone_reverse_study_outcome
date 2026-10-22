package com.stepos.aiengine.modelmanager.pref;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.preference.h;
import com.stepos.aiengine.R;
import kotlin.jvm.internal.g;
import lb.n;
import zb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class NavPreference extends BaseEnginePreference {
    public final String R;
    public final int S;
    public final int T;
    public final boolean U;
    public final a<n> V;

    public NavPreference(Context context, String str, int i10, int i11, boolean z, a aVar) {
        super(context, null);
        this.R = str;
        this.S = i10;
        this.T = i11;
        this.U = z;
        this.V = aVar;
        this.I = R.layout.pref_nav;
        if (!this.f2361t) {
            this.f2361t = true;
            j();
        }
        this.f2363v = false;
    }

    @Override // androidx.preference.Preference
    public final void n(h holder) {
        g.f(holder, "holder");
        super.n(holder);
        holder.itemView.setTag(R.id.mm_card_pos, new int[]{this.S, this.T});
        View viewA = holder.a(R.id.mm_nav_title);
        g.d(viewA, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) viewA;
        textView.setText(this.R);
        textView.setTextColor(textView.getContext().getColor(R.color.mm_on_surface));
        View viewA2 = holder.a(R.id.mm_nav_arrow);
        g.d(viewA2, "null cannot be cast to non-null type android.view.View");
        viewA2.setVisibility(this.U ? 0 : 8);
    }

    @Override // androidx.preference.Preference
    public final void o() {
        this.V.invoke();
    }
}
