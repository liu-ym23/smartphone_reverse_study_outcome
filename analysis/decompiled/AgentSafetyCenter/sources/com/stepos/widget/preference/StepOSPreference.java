package com.stepos.widget.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.Preference;
import cb.a;
import com.stepos.agentsafetycenter.R;
import f7.f;
import id.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class StepOSPreference extends Preference {

    /* renamed from: l, reason: collision with root package name */
    public final f f2890l;

    public StepOSPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, R.attr.steposPreferenceStyle, R.style.StepOSWidget_Preference);
        c.B(context, attributeSet);
        f fVar = new f(24);
        a[] aVarArr = a.f2239c;
        this.f2890l = fVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        context.getClass();
    }
}
