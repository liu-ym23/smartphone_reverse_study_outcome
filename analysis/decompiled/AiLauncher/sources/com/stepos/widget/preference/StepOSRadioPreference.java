package com.stepos.widget.preference;

import Y8.t;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.j;
import androidx.preference.l;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import com.stepos.widget.list.StepOSListItem;
import com.stepos.widget.preference.StepOSRadioPreference;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import n9.C4946a;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0003\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0017¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R(\u0010\u001b\u001a\u0004\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u0011\u0010 \u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/stepos/widget/preference/StepOSRadioPreference;", "Lcom/stepos/widget/preference/StepOSPreference;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "LY8/t;", "selectThis", "()V", "Landroidx/preference/l;", "holder", "onBindViewHolder", "(Landroidx/preference/l;)V", "", "groupKeyState", "Ljava/lang/String;", "radioValueState", UxipConstants.f30680s, "getRadioGroupKey", "()Ljava/lang/String;", "setRadioGroupKey", "(Ljava/lang/String;)V", "radioGroupKey", "getRadioValue", "setRadioValue", "radioValue", "", "isRadioSelected", "()Z", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StepOSRadioPreference extends StepOSPreference {
    private String groupKeyState;
    private String radioValueState;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSRadioPreference(Context context) {
        this(context, null, 0, 0, 14, null);
        p.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$1(StepOSRadioPreference stepOSRadioPreference, Preference it) {
        p.i(it, "it");
        stepOSRadioPreference.selectThis();
        return true;
    }

    private final void selectThis() {
        SharedPreferences sharedPreferencesJ;
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutString;
        String str = this.groupKeyState;
        if (str == null || isRadioSelected() || !callChangeListener(this.radioValueState)) {
            return;
        }
        j preferenceManager = getPreferenceManager();
        if (preferenceManager != null && (sharedPreferencesJ = preferenceManager.j()) != null && (editorEdit = sharedPreferencesJ.edit()) != null && (editorPutString = editorEdit.putString(str, this.radioValueState)) != null) {
            editorPutString.apply();
        }
        PreferenceGroup parent = getParent();
        if (parent == null) {
            notifyChanged();
            return;
        }
        int preferenceCount = parent.getPreferenceCount();
        for (int i10 = 0; i10 < preferenceCount; i10++) {
            Preference preference = parent.getPreference(i10);
            StepOSRadioPreference stepOSRadioPreference = preference instanceof StepOSRadioPreference ? (StepOSRadioPreference) preference : null;
            if (stepOSRadioPreference != null) {
                StepOSRadioPreference stepOSRadioPreference2 = p.d(stepOSRadioPreference.groupKeyState, str) ? stepOSRadioPreference : null;
                if (stepOSRadioPreference2 != null) {
                    stepOSRadioPreference2.notifyChanged();
                }
            }
        }
    }

    /* renamed from: getRadioGroupKey, reason: from getter */
    public final String getGroupKeyState() {
        return this.groupKeyState;
    }

    /* renamed from: getRadioValue, reason: from getter */
    public final String getRadioValueState() {
        return this.radioValueState;
    }

    public final boolean isRadioSelected() {
        SharedPreferences sharedPreferencesJ;
        String str = this.groupKeyState;
        if (str == null) {
            return false;
        }
        j preferenceManager = getPreferenceManager();
        String string = null;
        if (preferenceManager != null && (sharedPreferencesJ = preferenceManager.j()) != null) {
            string = sharedPreferencesJ.getString(str, null);
        }
        return p.d(string, this.radioValueState);
    }

    @Override // com.stepos.widget.preference.StepOSPreference, androidx.preference.Preference
    public void onBindViewHolder(l holder) throws Resources.NotFoundException {
        p.i(holder, "holder");
        super.onBindViewHolder(holder);
        View itemView = holder.itemView;
        p.h(itemView, "itemView");
        StepOSListItem stepOSListItemFindListItem = findListItem(itemView);
        if (stepOSListItemFindListItem != null) {
            stepOSListItemFindListItem.setReservesCheckSlot(true);
            stepOSListItemFindListItem.setChecked(isRadioSelected());
        }
    }

    public final void setRadioGroupKey(String str) {
        this.groupKeyState = str;
        notifyChanged();
    }

    public final void setRadioValue(String value) {
        p.i(value, "value");
        this.radioValueState = value;
        notifyChanged();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSRadioPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        p.i(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSRadioPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        p.i(context, "context");
    }

    public /* synthetic */ StepOSRadioPreference(Context context, AttributeSet attributeSet, int i10, int i11, int i12, i iVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.steposPreferenceStyle : i10, (i12 & 8) != 0 ? R.style.StepOSWidget_Preference : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSRadioPreference(Context context, AttributeSet attributeSet, int i10, int i11) throws Exception {
        super(context, attributeSet, i10, i11);
        p.i(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StepOSRadioPreference);
        try {
            this.groupKeyState = typedArrayObtainStyledAttributes.getString(R.styleable.StepOSRadioPreference_steposRadioGroupKey);
            String string = typedArrayObtainStyledAttributes.getString(R.styleable.StepOSRadioPreference_steposRadioValue);
            if (string == null && (string = getKey()) == null) {
                string = "";
            }
            this.radioValueState = string;
            t tVar = t.f7040a;
            C4946a.a(typedArrayObtainStyledAttributes, null);
            setTrailingType(0);
            setOnPreferenceClickListener(new Preference.d() { // from class: R7.b
                @Override // androidx.preference.Preference.d
                public final boolean a(Preference preference) {
                    return StepOSRadioPreference._init_$lambda$1(this.f5552a, preference);
                }
            });
        } finally {
        }
    }
}
