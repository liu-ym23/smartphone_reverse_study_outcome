package com.stepos.aiengine.modelmanager.settings;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceScreen;
import androidx.preference.f;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.aiengine.R;
import com.stepos.core.cta.CTAPermissionManager;
import com.stepos.core.ota.d;
import i6.a;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelManagerSettingsFragment extends PreferenceFragmentCompat {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreatePreferences$lambda$1$lambda$0(Preference preference, Object obj) {
        g.f(preference, "<unused var>");
        g.d(obj, "null cannot be cast to non-null type kotlin.Boolean");
        CTAPermissionManager.INSTANCE.setWlanAutoUpgrade(((Boolean) obj).booleanValue());
        return true;
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle bundle, String str) {
        Context contextRequireContext = requireContext();
        g.e(contextRequireContext, "requireContext(...)");
        f preferenceManager = getPreferenceManager();
        preferenceManager.getClass();
        PreferenceScreen preferenceScreen = new PreferenceScreen(contextRequireContext, null);
        preferenceScreen.m(preferenceManager);
        WifiAutoUpdateSwitchPreference wifiAutoUpdateSwitchPreference = new WifiAutoUpdateSwitchPreference(contextRequireContext);
        Context context = wifiAutoUpdateSwitchPreference.f2347a;
        String string = context.getString(R.string.mm_pref_wifi_auto_update_title);
        if (!TextUtils.equals(string, wifiAutoUpdateSwitchPreference.f2353k)) {
            wifiAutoUpdateSwitchPreference.f2353k = string;
            wifiAutoUpdateSwitchPreference.j();
        }
        wifiAutoUpdateSwitchPreference.x(context.getString(R.string.mm_pref_wifi_auto_update_summary));
        wifiAutoUpdateSwitchPreference.f2363v = false;
        wifiAutoUpdateSwitchPreference.B(CTAPermissionManager.INSTANCE.isWlanAutoUpgradeEnabled());
        wifiAutoUpdateSwitchPreference.f2351e = new d(29);
        preferenceScreen.B(wifiAutoUpdateSwitchPreference);
        setPreferenceScreen(preferenceScreen);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        g.f(view, "view");
        super.onViewCreated(view, bundle);
        setDivider(null);
        setDividerHeight(0);
        getListView().setPadding(getListView().getPaddingLeft(), (int) (8 * getResources().getDisplayMetrics().density), getListView().getPaddingRight(), getListView().getPaddingBottom());
        getListView().setClipToPadding(false);
        RecyclerView listView = getListView();
        Context contextRequireContext = requireContext();
        g.e(contextRequireContext, "requireContext(...)");
        listView.addItemDecoration(new a(contextRequireContext));
    }
}
