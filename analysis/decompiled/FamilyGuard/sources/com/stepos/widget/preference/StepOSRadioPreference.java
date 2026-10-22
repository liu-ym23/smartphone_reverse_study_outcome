package com.stepos.widget.preference;

import V3.v;
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
import com.stepos.widget.list.StepOSListItem;
import com.stepos.widget.preference.StepOSRadioPreference;
import g4.C0743a;
import j4.g;
import j4.k;
import l3.C0844b;
import l3.m;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class StepOSRadioPreference extends StepOSPreference {

    /* renamed from: V, reason: collision with root package name */
    private String f16343V;

    /* renamed from: W, reason: collision with root package name */
    private String f16344W;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSRadioPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        k.g(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean V0(StepOSRadioPreference stepOSRadioPreference, Preference preference) {
        k.g(preference, "it");
        stepOSRadioPreference.X0();
        return true;
    }

    private final void X0() {
        SharedPreferences sharedPreferencesL;
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutString;
        String str = this.f16343V;
        if (str == null || W0() || !d(this.f16344W)) {
            return;
        }
        j jVarE = E();
        if (jVarE != null && (sharedPreferencesL = jVarE.l()) != null && (editorEdit = sharedPreferencesL.edit()) != null && (editorPutString = editorEdit.putString(str, this.f16344W)) != null) {
            editorPutString.apply();
        }
        PreferenceGroup preferenceGroupV = v();
        if (preferenceGroupV == null) {
            Q();
            return;
        }
        int iX0 = preferenceGroupV.X0();
        for (int i5 = 0; i5 < iX0; i5++) {
            Preference preferenceW0 = preferenceGroupV.W0(i5);
            StepOSRadioPreference stepOSRadioPreference = preferenceW0 instanceof StepOSRadioPreference ? (StepOSRadioPreference) preferenceW0 : null;
            if (stepOSRadioPreference != null) {
                StepOSRadioPreference stepOSRadioPreference2 = k.b(stepOSRadioPreference.f16343V, str) ? stepOSRadioPreference : null;
                if (stepOSRadioPreference2 != null) {
                    stepOSRadioPreference2.Q();
                }
            }
        }
    }

    @Override // com.stepos.widget.preference.StepOSPreference, androidx.preference.Preference
    public void W(l lVar) throws Resources.NotFoundException {
        k.g(lVar, "holder");
        super.W(lVar);
        View view = lVar.itemView;
        k.f(view, "itemView");
        StepOSListItem stepOSListItemR0 = R0(view);
        if (stepOSListItemR0 != null) {
            stepOSListItemR0.setReservesCheckSlot(true);
            stepOSListItemR0.setChecked(W0());
        }
    }

    public final boolean W0() {
        SharedPreferences sharedPreferencesL;
        String str = this.f16343V;
        if (str == null) {
            return false;
        }
        j jVarE = E();
        String string = null;
        if (jVarE != null && (sharedPreferencesL = jVarE.l()) != null) {
            string = sharedPreferencesL.getString(str, null);
        }
        return k.b(string, this.f16344W);
    }

    public /* synthetic */ StepOSRadioPreference(Context context, AttributeSet attributeSet, int i5, int i6, int i7, g gVar) {
        this(context, (i7 & 2) != 0 ? null : attributeSet, (i7 & 4) != 0 ? C0844b.f18287h : i5, (i7 & 8) != 0 ? l3.l.f18494q : i6);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSRadioPreference(Context context, AttributeSet attributeSet, int i5, int i6) throws Exception {
        super(context, attributeSet, i5, i6);
        k.g(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f18583O3);
        try {
            this.f16343V = typedArrayObtainStyledAttributes.getString(m.f18589P3);
            String string = typedArrayObtainStyledAttributes.getString(m.f18595Q3);
            if (string == null && (string = s()) == null) {
                string = BuildConfig.FLAVOR;
            }
            this.f16344W = string;
            v vVar = v.f5542a;
            C0743a.a(typedArrayObtainStyledAttributes, null);
            T0(0);
            C0(new Preference.e() { // from class: v3.d
                @Override // androidx.preference.Preference.e
                public final boolean f(Preference preference) {
                    return StepOSRadioPreference.V0(this.f23341a, preference);
                }
            });
        } finally {
        }
    }
}
