package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.RestrictTo;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.widget.preference.StepOSPreference;
import com.stepos.widget.preference.StepOSPreferenceCategory;
import com.stepos.widget.preference.StepOSRadioPreference;
import com.stepos.widget.preference.StepOSSwitchPreference;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014J\u001a\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0002J \u0010\u0010\u001a\u00020\t2\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u000f2\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u0012"}, d2 = {"Landroidx/preference/StepOSRemappingPreferenceInflater;", "Landroidx/preference/PreferenceInflater;", "context", "Landroid/content/Context;", "preferenceManager", "Landroidx/preference/PreferenceManager;", AppAgent.CONSTRUCT, "(Landroid/content/Context;Landroidx/preference/PreferenceManager;)V", "onCreateItem", "Landroidx/preference/Preference;", HintConstants.AUTOFILL_HINT_NAME, "", "attrs", "Landroid/util/AttributeSet;", "mapShortName", "Ljava/lang/Class;", "newInstance", "clazz", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public final class StepOSRemappingPreferenceInflater extends PreferenceInflater {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSRemappingPreferenceInflater(Context context, PreferenceManager preferenceManager) {
        super(context, preferenceManager);
        k.f(context, "context");
        k.f(preferenceManager, "preferenceManager");
    }

    private final Class<? extends Preference> mapShortName(String name) {
        switch (name.hashCode()) {
            case 190073777:
                if (name.equals("SwitchPreferenceCompat")) {
                    return StepOSSwitchPreference.class;
                }
                return null;
            case 533633275:
                if (name.equals("Preference")) {
                    return StepOSPreference.class;
                }
                return null;
            case 889856847:
                if (name.equals("SwitchPreference")) {
                    return StepOSSwitchPreference.class;
                }
                return null;
            case 1599399702:
                if (name.equals("RadioPreference")) {
                    return StepOSRadioPreference.class;
                }
                return null;
            case 2041351961:
                if (name.equals("PreferenceCategory")) {
                    return StepOSPreferenceCategory.class;
                }
                return null;
            default:
                return null;
        }
    }

    private final Preference newInstance(Class<? extends Preference> clazz, AttributeSet attrs) {
        try {
            return clazz.getConstructor(Context.class, AttributeSet.class).newInstance(getContext(), attrs);
        } catch (NoSuchMethodException unused) {
            return clazz.getConstructor(Context.class).newInstance(getContext());
        }
    }

    @Override // androidx.preference.PreferenceInflater
    public Preference onCreateItem(String name, AttributeSet attrs) throws ClassNotFoundException {
        k.f(name, "name");
        k.f(attrs, "attrs");
        Class<? extends Preference> clsMapShortName = mapShortName(name);
        if (clsMapShortName != null) {
            return newInstance(clsMapShortName, attrs);
        }
        Preference preferenceOnCreateItem = super.onCreateItem(name, attrs);
        k.e(preferenceOnCreateItem, "onCreateItem(...)");
        return preferenceOnCreateItem;
    }
}
