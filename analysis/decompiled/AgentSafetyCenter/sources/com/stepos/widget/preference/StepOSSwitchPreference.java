package com.stepos.widget.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.SwitchPreferenceCompat;
import cb.a;
import com.stepos.agentsafetycenter.R;
import id.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class StepOSSwitchPreference extends SwitchPreferenceCompat {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSSwitchPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.steposPreferenceStyle, R.style.StepOSWidget_Preference);
        context.getClass();
        c.B(context, attributeSet);
        a[] aVarArr = a.f2239c;
    }
}
