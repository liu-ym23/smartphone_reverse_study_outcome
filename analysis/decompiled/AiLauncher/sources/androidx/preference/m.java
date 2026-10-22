package androidx.preference;

import android.content.Context;
import android.content.res.Resources;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/preference/m;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroidx/preference/j;", "manager", "", "resId", "Landroidx/preference/PreferenceScreen;", Parameters.ROOT, Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Landroidx/preference/j;ILandroidx/preference/PreferenceScreen;)Landroidx/preference/PreferenceScreen;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f14431a = new m();

    public final PreferenceScreen a(Context context, j manager, int resId, PreferenceScreen root) throws Resources.NotFoundException {
        p.i(context, "context");
        p.i(manager, "manager");
        Preference preferenceD = new n(context, manager).d(resId, root);
        p.g(preferenceD, "null cannot be cast to non-null type androidx.preference.PreferenceScreen");
        PreferenceScreen preferenceScreen = (PreferenceScreen) preferenceD;
        preferenceScreen.onAttachedToHierarchy(manager);
        return preferenceScreen;
    }
}
