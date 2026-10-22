package android.preference;

import android.content.Context;

/* loaded from: classes.dex */
public class StepOSPreferenceGroupAdapterExtImpl implements IStepOSPreferenceGroupAdapterExt {
    private boolean mIsThemeLight;

    public void onAttach(PreferenceGroupAdapter host) {
    }

    public void onBindPreferenceGroup(PreferenceGroup preferenceGroup) {
        this.mIsThemeLight = computeIsColorThemeListModel(preferenceGroup);
    }

    public boolean isLightThemeListRowModel() {
        return this.mIsThemeLight;
    }

    public boolean isListRowEnabledWhenLightTheme(PreferenceGroupAdapter host, int position) {
        Preference preference = host.getItem(position);
        if (preference == null) {
            return true;
        }
        if (preference.isEnabled()) {
            return preference.isSelectable();
        }
        return false;
    }

    public boolean areAllListRowsEnabledWhenLightTheme(PreferenceGroupAdapter host) {
        return true;
    }

    private static boolean computeIsColorThemeListModel(PreferenceGroup preferenceGroup) {
        Context context;
        if (preferenceGroup == null || (context = preferenceGroup.getContext()) == null) {
            return false;
        }
        return context.isColorTheme();
    }
}
