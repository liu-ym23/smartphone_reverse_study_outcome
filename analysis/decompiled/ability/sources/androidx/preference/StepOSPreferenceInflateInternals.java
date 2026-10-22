package androidx.preference;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0005¨\u0006\r"}, d2 = {"Landroidx/preference/StepOSPreferenceInflateInternals;", "", AppAgent.CONSTRUCT, "()V", "inflateFromResource", "Landroidx/preference/PreferenceScreen;", "context", "Landroid/content/Context;", "manager", "Landroidx/preference/PreferenceManager;", "resId", "", "root", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public final class StepOSPreferenceInflateInternals {
    public static final StepOSPreferenceInflateInternals INSTANCE = new StepOSPreferenceInflateInternals();

    private StepOSPreferenceInflateInternals() {
    }

    public final PreferenceScreen inflateFromResource(Context context, PreferenceManager manager, @XmlRes int resId, PreferenceScreen root) throws Resources.NotFoundException {
        k.f(context, "context");
        k.f(manager, "manager");
        Preference preferenceInflate = new StepOSRemappingPreferenceInflater(context, manager).inflate(resId, root);
        k.d(preferenceInflate, "null cannot be cast to non-null type androidx.preference.PreferenceScreen");
        PreferenceScreen preferenceScreen = (PreferenceScreen) preferenceInflate;
        preferenceScreen.onAttachedToHierarchy(manager);
        return preferenceScreen;
    }
}
