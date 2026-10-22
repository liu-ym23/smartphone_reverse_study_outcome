package com.stepos.aiengine.modelmanager.settings;

import android.content.Context;
import android.content.res.Resources;
import androidx.preference.SwitchPreferenceCompat;
import androidx.preference.h;
import com.stepos.aiengine.R;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class WifiAutoUpdateSwitchPreference extends SwitchPreferenceCompat {
    public final int Z;

    public WifiAutoUpdateSwitchPreference(Context context) {
        super(context, null);
        this.Z = 1;
        this.I = R.layout.pref_switch_card;
        if (this.F) {
            this.F = false;
            j();
        }
    }

    @Override // androidx.preference.SwitchPreferenceCompat, androidx.preference.Preference
    public final void n(h holder) throws Resources.NotFoundException {
        g.f(holder, "holder");
        super.n(holder);
        holder.itemView.setTag(R.id.mm_card_pos, new int[]{0, this.Z});
        holder.itemView.setBackground(null);
    }
}
