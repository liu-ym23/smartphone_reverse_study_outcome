package com.stepos.widget.preference;

import F6.a;
import M0.i;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.stepos.ability.R;
import com.stepos.widget.list.StepOSListItem;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import u1.d;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/stepos/widget/preference/StepOSPreference;", "Landroidx/preference/Preference;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public class StepOSPreference extends Preference {

    /* renamed from: a, reason: collision with root package name */
    public final a f4153a;
    public final d b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        k.f(context, "context");
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder holder) throws Resources.NotFoundException {
        k.f(holder, "holder");
        super.onBindViewHolder(holder);
        View itemView = holder.itemView;
        k.e(itemView, "itemView");
        StepOSListItem stepOSListItem = itemView instanceof StepOSListItem ? (StepOSListItem) itemView : null;
        if (stepOSListItem == null) {
            stepOSListItem = (StepOSListItem) itemView.findViewById(R.id.stepos_preference_bridge_row);
        }
        StepOSListItem stepOSListItem2 = stepOSListItem;
        if (stepOSListItem2 == null) {
            return;
        }
        AbstractC1451a.p(stepOSListItem2, this.f4153a, this.b, getTitle(), getSummary(), getIcon(), isEnabled());
    }

    public StepOSPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, R.attr.steposPreferenceStyle, R.style.StepOSWidget_Preference);
        this.f4153a = i.A(context, attributeSet);
        this.b = new d(2);
        setLayoutResource(R.layout.stepos_preference_bridge);
    }
}
