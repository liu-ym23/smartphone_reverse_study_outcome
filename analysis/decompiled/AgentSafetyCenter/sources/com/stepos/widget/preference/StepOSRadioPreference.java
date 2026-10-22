package com.stepos.widget.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import xa.a;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class StepOSRadioPreference extends StepOSPreference {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSRadioPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        context.getClass();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f15602e);
        try {
            typedArrayObtainStyledAttributes.getString(0);
            typedArrayObtainStyledAttributes.getString(1);
            t2.a.h(typedArrayObtainStyledAttributes, null);
            this.f2890l.getClass();
        } finally {
        }
    }
}
