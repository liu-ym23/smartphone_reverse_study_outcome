package com.android.contacts.common.preference;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import com.android.contacts.common.R;
import com.android.contacts.common.activity.LicenseActivity;

/* JADX INFO: loaded from: classes.dex */
public class AboutPreferenceFragment extends PreferenceFragment {
    private static final String PRIVACY_POLICY_URL = "http://www.google.com/policies/privacy";
    private static final String TERMS_OF_SERVICE_URL = "http://www.google.com/policies/terms";

    public AboutPreferenceFragment() {
    }

    static /* synthetic */ void access$000(AboutPreferenceFragment r0, String r1) {
        r0.startActivityForUrl(r1);
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        addPreferencesFromResource(R.xml.preference_about);
        PackageManager r5 = getActivity().getPackageManager();
        PackageInfo r6 = r5.getPackageInfo(getActivity().getPackageName(), 0);     // Catch: PackageManager.NameNotFoundException -> L11
        Preference r0 = findPreference(getString(R.string.pref_build_version_key));     // Catch: PackageManager.NameNotFoundException -> L11
        if (r0 == null) goto L6;
        r0.setSummary(r6.versionName);     // Catch: PackageManager.NameNotFoundException -> L11
    L6:
        Preference r7 = findPreference(getString(R.string.pref_open_source_licenses_key));
        if (r7 == null) goto L9;
        r7.setIntent(new Intent(getActivity(), LicenseActivity.class));
    L9:
        final Preference r8 = findPreference("pref_privacy_policy");
        final Preference r1 = findPreference("pref_terms_of_service");
        Preference.OnPreferenceClickListener r2 = new AnonymousClass1(this, r8, r1);
        r8.setOnPreferenceClickListener(r2);
        r1.setOnPreferenceClickListener(r2);
    }

    @Override // android.app.Fragment
    public Context getContext() {
        return getActivity();
    }

    private void startActivityForUrl(String r3) {
        Intent r0 = new Intent();
        r0.setAction("android.intent.action.VIEW");
        r0.setData(Uri.parse(r3));
        startActivity(r0);
    }
}
