package com.stepos.widget.preference;

import F6.a;
import H6.b;
import M0.i;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.SwitchPreferenceCompat;
import com.stepos.ability.R;
import com.stepos.widget.list.StepOSListItem;
import g1.AbstractC1451a;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import u1.d;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/stepos/widget/preference/StepOSSwitchPreference;", "Landroidx/preference/SwitchPreferenceCompat;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public class StepOSSwitchPreference extends SwitchPreferenceCompat {

    /* renamed from: a, reason: collision with root package name */
    public final a f4154a;
    public final d b;
    public final b c;
    public final H6.a d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSSwitchPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.steposPreferenceStyle, R.style.StepOSWidget_Preference);
        k.f(context, "context");
        this.f4154a = i.A(context, attributeSet);
        d dVar = new d(2);
        dVar.b = 2;
        this.b = dVar;
        this.c = new b();
        this.d = new H6.a();
        setLayoutResource(R.layout.stepos_preference_bridge);
    }

    @Override // androidx.preference.Preference
    public final boolean isEnabled() {
        H6.a aVar = this.d;
        return (aVar != null && aVar.f755a) || super.isEnabled();
    }

    @Override // androidx.preference.Preference
    public final boolean isSelectable() {
        H6.a aVar = this.d;
        return (aVar != null && aVar.f755a) || super.isSelectable();
    }

    @Override // androidx.preference.SwitchPreferenceCompat, androidx.preference.Preference
    public final void onBindViewHolder(PreferenceViewHolder holder) throws Resources.NotFoundException {
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
        d dVar = this.b;
        dVar.b = 2;
        dVar.c = Boolean.valueOf(isChecked());
        dVar.d = new A6.a(1, this, holder);
        AbstractC1451a.p(stepOSListItem2, this.f4154a, dVar, getTitle(), getSummary(), getIcon(), isEnabled());
        b bVar = this.c;
        bVar.getClass();
        bVar.f756a = new WeakReference(stepOSListItem2);
        stepOSListItem2.setSwitchHapticFeedbackOwner$StepOSWidget_release(bVar);
        stepOSListItem2.setSwitchHapticFeedbackEnabled(true);
    }

    @Override // androidx.preference.TwoStatePreference, androidx.preference.Preference
    public final void onClick() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        StepOSListItem stepOSListItem;
        H6.a aVar = this.d;
        if (aVar.f755a) {
            aVar.f755a = false;
            return;
        }
        boolean zIsChecked = isChecked();
        super.onClick();
        if (zIsChecked != isChecked()) {
            b bVar = this.c;
            WeakReference weakReference = bVar.f756a;
            StepOSListItem stepOSListItem2 = null;
            if (weakReference != null && (stepOSListItem = (StepOSListItem) weakReference.get()) != null && stepOSListItem.getSwitchHapticFeedbackOwner() == bVar) {
                stepOSListItem2 = stepOSListItem;
            }
            if (stepOSListItem2 != null) {
                E6.i.a(stepOSListItem2);
            }
        }
    }
}
