package com.stepos.widget.preference;

import B5.a;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceViewHolder;
import com.stepos.ability.R;
import com.stepos.ability.task.executor.e;
import com.stepos.widget.list.StepOSListItem;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import w6.AbstractC2104a;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/stepos/widget/preference/StepOSRadioPreference;", "Lcom/stepos/widget/preference/StepOSPreference;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public class StepOSRadioPreference extends StepOSPreference {
    public final String c;
    public final String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSRadioPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        k.f(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC2104a.h);
        try {
            this.c = typedArrayObtainStyledAttributes.getString(0);
            String string = typedArrayObtainStyledAttributes.getString(1);
            if (string == null && (string = getKey()) == null) {
                string = "";
            }
            this.d = string;
            e.s(typedArrayObtainStyledAttributes, null);
            this.b.b = 0;
            notifyChanged();
            setOnPreferenceClickListener(new a(this, 4));
        } finally {
        }
    }

    @Override // com.stepos.widget.preference.StepOSPreference, androidx.preference.Preference
    public final void onBindViewHolder(PreferenceViewHolder holder) throws Resources.NotFoundException {
        boolean zB;
        SharedPreferences sharedPreferences;
        k.f(holder, "holder");
        super.onBindViewHolder(holder);
        View itemView = holder.itemView;
        k.e(itemView, "itemView");
        String string = null;
        StepOSListItem stepOSListItem = itemView instanceof StepOSListItem ? (StepOSListItem) itemView : null;
        if (stepOSListItem == null) {
            stepOSListItem = (StepOSListItem) itemView.findViewById(R.id.stepos_preference_bridge_row);
        }
        if (stepOSListItem != null) {
            stepOSListItem.setReservesCheckSlot(true);
            String str = this.c;
            if (str == null) {
                zB = false;
            } else {
                PreferenceManager preferenceManager = getPreferenceManager();
                if (preferenceManager != null && (sharedPreferences = preferenceManager.getSharedPreferences()) != null) {
                    string = sharedPreferences.getString(str, null);
                }
                zB = k.b(string, this.d);
            }
            stepOSListItem.setChecked(zB);
        }
    }
}
