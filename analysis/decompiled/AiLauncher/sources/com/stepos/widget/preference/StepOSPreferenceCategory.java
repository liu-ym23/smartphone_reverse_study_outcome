package com.stepos.widget.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.PreferenceCategory;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/widget/preference/StepOSPreferenceCategory;", "Landroidx/preference/PreferenceCategory;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StepOSPreferenceCategory extends PreferenceCategory {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StepOSPreferenceCategory(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        p.i(context, "context");
    }

    public /* synthetic */ StepOSPreferenceCategory(Context context, AttributeSet attributeSet, int i10, i iVar) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSPreferenceCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.i(context, "context");
    }
}
