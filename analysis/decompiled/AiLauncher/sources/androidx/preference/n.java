package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.widget.preference.StepOSPreference;
import com.stepos.widget.preference.StepOSPreferenceCategory;
import com.stepos.widget.preference.StepOSRadioPreference;
import com.stepos.widget.preference.StepOSSwitchPreference;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0013\u001a\u00020\f2\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/preference/n;", "Landroidx/preference/i;", "Landroid/content/Context;", "context", "Landroidx/preference/j;", "preferenceManager", "<init>", "(Landroid/content/Context;Landroidx/preference/j;)V", "", "name", "Landroid/util/AttributeSet;", "attrs", "Landroidx/preference/Preference;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Landroid/util/AttributeSet;)Landroidx/preference/Preference;", "Ljava/lang/Class;", "l", "(Ljava/lang/String;)Ljava/lang/Class;", "clazz", "m", "(Ljava/lang/Class;Landroid/util/AttributeSet;)Landroidx/preference/Preference;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class n extends i {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(Context context, j preferenceManager) {
        super(context, preferenceManager);
        p.i(context, "context");
        p.i(preferenceManager, "preferenceManager");
    }

    @Override // androidx.preference.i
    public Preference g(String name, AttributeSet attrs) throws ClassNotFoundException {
        p.i(name, "name");
        p.i(attrs, "attrs");
        Class<? extends Preference> clsL = l(name);
        if (clsL != null) {
            return m(clsL, attrs);
        }
        Preference preferenceG = super.g(name, attrs);
        p.h(preferenceG, "onCreateItem(...)");
        return preferenceG;
    }

    public final Class<? extends Preference> l(String name) {
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

    public final Preference m(Class<? extends Preference> clazz, AttributeSet attrs) {
        try {
            return clazz.getConstructor(Context.class, AttributeSet.class).newInstance(c(), attrs);
        } catch (NoSuchMethodException unused) {
            return clazz.getConstructor(Context.class).newInstance(c());
        }
    }
}
