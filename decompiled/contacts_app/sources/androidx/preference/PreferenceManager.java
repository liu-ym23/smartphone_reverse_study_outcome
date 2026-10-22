package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceManager {
    public static final String KEY_HAS_SET_DEFAULT_VALUES = "_has_set_default_values";
    private static final int STORAGE_DEFAULT = 0;
    private static final int STORAGE_DEVICE_PROTECTED = 1;
    private final Context mContext;
    private SharedPreferences.Editor mEditor;
    private long mNextId;
    private boolean mNoCommit;
    private OnDisplayPreferenceDialogListener mOnDisplayPreferenceDialogListener;
    private OnNavigateToScreenListener mOnNavigateToScreenListener;
    private OnPreferenceTreeClickListener mOnPreferenceTreeClickListener;
    private PreferenceComparisonCallback mPreferenceComparisonCallback;
    private PreferenceDataStore mPreferenceDataStore;
    private PreferenceScreen mPreferenceScreen;
    private SharedPreferences mSharedPreferences;
    private int mSharedPreferencesMode;
    private String mSharedPreferencesName;
    private int mStorage;

    public interface OnDisplayPreferenceDialogListener {
        void onDisplayPreferenceDialog(Preference r1);
    }

    public interface OnNavigateToScreenListener {
        void onNavigateToScreen(PreferenceScreen r1);
    }

    public interface OnPreferenceTreeClickListener {
        boolean onPreferenceTreeClick(Preference r1);
    }

    public static abstract class PreferenceComparisonCallback {
        public abstract boolean arePreferenceContentsTheSame(Preference r1, Preference r2);

        public abstract boolean arePreferenceItemsTheSame(Preference r1, Preference r2);

        public PreferenceComparisonCallback() {
        }
    }

    public static class SimplePreferenceComparisonCallback extends PreferenceComparisonCallback {
        public SimplePreferenceComparisonCallback() {
        }

        @Override // androidx.preference.PreferenceManager.PreferenceComparisonCallback
        public boolean arePreferenceItemsTheSame(Preference r3, Preference r4) {
            if (r3.getId() != r4.getId()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.preference.PreferenceManager.PreferenceComparisonCallback
        public boolean arePreferenceContentsTheSame(Preference r3, Preference r4) {
            if (r3.getClass() == r4.getClass()) goto L5;
            return false;
        L5:
            if (r3 != r4) goto L10;
            if (r3.wasDetached() == false) goto L10;
            return false;
        L10:
            if (TextUtils.equals(r3.getTitle(), r4.getTitle()) == true) goto L13;
            return false;
        L13:
            if (TextUtils.equals(r3.getSummary(), r4.getSummary()) == true) goto L15;
            return false;
        L15:
            Drawable r2 = r3.getIcon();
            Drawable r0 = r4.getIcon();
            if (r2 == r0) goto L22;
            if (r2 != null) goto L19;
        L20:
            return false;
        L19:
            if (r2.equals(r0) == false) goto L20;
        L22:
            if (r3.isEnabled() == r4.isEnabled()) goto L25;
            return false;
        L25:
            if (r3.isSelectable() == r4.isSelectable()) goto L28;
            return false;
        L28:
            if ((r3 instanceof TwoStatePreference) == false) goto L33;
            if (((TwoStatePreference) r3).isChecked() == ((TwoStatePreference) r4).isChecked()) goto L33;
            return false;
        L33:
            if ((r3 instanceof DropDownPreference) == false) goto L36;
            if (r3 == r4) goto L38;
            return false;
        L38:
            return true;
        L36:
            return true;
        }
    }

    private static int getDefaultSharedPreferencesMode() {
        return 0;
    }

    public PreferenceManager(Context r3) {
        this.mNextId = 0;
        this.mStorage = 0;
        this.mContext = r3;
        setSharedPreferencesName(getDefaultSharedPreferencesName(r3));
    }

    public static SharedPreferences getDefaultSharedPreferences(Context r2) {
        return r2.getSharedPreferences(getDefaultSharedPreferencesName(r2), getDefaultSharedPreferencesMode());
    }

    private static String getDefaultSharedPreferencesName(Context r1) {
        return r1.getPackageName() + "_preferences";
    }

    public static void setDefaultValues(Context r2, int r3, boolean r4) {
        setDefaultValues(r2, getDefaultSharedPreferencesName(r2), getDefaultSharedPreferencesMode(), r3, r4);
    }

    public static void setDefaultValues(Context r3, String r4, int r5, int r6, boolean r7) {
        SharedPreferences r2 = r3.getSharedPreferences(KEY_HAS_SET_DEFAULT_VALUES, 0);
        if (r7 == false) goto L5;
    L6:
        PreferenceManager r8 = new PreferenceManager(r3);
        r8.setSharedPreferencesName(r4);
        r8.setSharedPreferencesMode(r5);
        r8.inflateFromResource(r3, r6, null);
        r2.edit().putBoolean(KEY_HAS_SET_DEFAULT_VALUES, true).apply();
        return;
    L5:
        if (r2.getBoolean(KEY_HAS_SET_DEFAULT_VALUES, false) == false) goto L6;
    }

    public PreferenceScreen inflateFromResource(Context r2, int r3, PreferenceScreen r4) {
        setNoCommit(true);
        PreferenceScreen r5 = (PreferenceScreen) new PreferenceInflater(r2, this).inflate(r3, r4);
        r5.onAttachedToHierarchy(this);
        setNoCommit(false);
        return r5;
    }

    public PreferenceScreen createPreferenceScreen(Context r3) {
        PreferenceScreen r0 = new PreferenceScreen(r3, null);
        r0.onAttachedToHierarchy(this);
        return r0;
    }

    long getNextId() {
        monitor-enter(this);
        long r0 = this.mNextId;     // Catch: Throwable -> L6
        this.mNextId = 1 + r0;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public String getSharedPreferencesName() {
        return this.mSharedPreferencesName;
    }

    public void setSharedPreferencesName(String r1) {
        this.mSharedPreferencesName = r1;
        this.mSharedPreferences = null;
    }

    public int getSharedPreferencesMode() {
        return this.mSharedPreferencesMode;
    }

    public void setSharedPreferencesMode(int r1) {
        this.mSharedPreferencesMode = r1;
        this.mSharedPreferences = null;
    }

    public void setStorageDefault() {
        this.mStorage = 0;
        this.mSharedPreferences = null;
    }

    public void setStorageDeviceProtected() {
        this.mStorage = 1;
        this.mSharedPreferences = null;
    }

    public boolean isStorageDefault() {
        if (this.mStorage != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isStorageDeviceProtected() {
        if (this.mStorage == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void setPreferenceDataStore(PreferenceDataStore r1) {
        this.mPreferenceDataStore = r1;
    }

    public PreferenceDataStore getPreferenceDataStore() {
        return this.mPreferenceDataStore;
    }

    public SharedPreferences getSharedPreferences() {
        if (getPreferenceDataStore() == null) goto L7;
        return null;
    L7:
        if (this.mSharedPreferences != null) goto L14;
        if (this.mStorage == 1) goto L11;
        Context r0 = this.mContext;
    L12:
        this.mSharedPreferences = r0.getSharedPreferences(this.mSharedPreferencesName, this.mSharedPreferencesMode);
        goto L14
    L11:
        r0 = ContextCompat.createDeviceProtectedStorageContext(this.mContext);
    L14:
        return this.mSharedPreferences;
    }

    public PreferenceScreen getPreferenceScreen() {
        return this.mPreferenceScreen;
    }

    public boolean setPreferences(PreferenceScreen r2) {
        PreferenceScreen r0 = this.mPreferenceScreen;
        if (r2 == r0) goto L8;
        if (r0 == null) goto L6;
        r0.onDetached();
    L6:
        this.mPreferenceScreen = r2;
        return true;
    L8:
        return false;
    }

    public <T extends Preference> T findPreference(CharSequence r1) {
        PreferenceScreen r0 = this.mPreferenceScreen;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (T) r0.findPreference(r1);
    }

    SharedPreferences.Editor getEditor() {
        if (this.mPreferenceDataStore == null) goto L7;
        return null;
    L7:
        if (this.mNoCommit == false) goto L14;
        if (this.mEditor != null) goto L12;
        this.mEditor = getSharedPreferences().edit();
    L12:
        return this.mEditor;
    L14:
        return getSharedPreferences().edit();
    }

    boolean shouldCommit() {
        return !this.mNoCommit;
    }

    private void setNoCommit(boolean r2) {
        if (r2 == true) goto L6;
        SharedPreferences.Editor r0 = this.mEditor;
        if (r0 == null) goto L6;
        r0.apply();
    L6:
        this.mNoCommit = r2;
    }

    public Context getContext() {
        return this.mContext;
    }

    public PreferenceComparisonCallback getPreferenceComparisonCallback() {
        return this.mPreferenceComparisonCallback;
    }

    public void setPreferenceComparisonCallback(PreferenceComparisonCallback r1) {
        this.mPreferenceComparisonCallback = r1;
    }

    public OnDisplayPreferenceDialogListener getOnDisplayPreferenceDialogListener() {
        return this.mOnDisplayPreferenceDialogListener;
    }

    public void setOnDisplayPreferenceDialogListener(OnDisplayPreferenceDialogListener r1) {
        this.mOnDisplayPreferenceDialogListener = r1;
    }

    public void showDialog(Preference r1) {
        OnDisplayPreferenceDialogListener r0 = this.mOnDisplayPreferenceDialogListener;
        if (r0 == null) goto L6;
        r0.onDisplayPreferenceDialog(r1);
        return;
    }

    public void setOnPreferenceTreeClickListener(OnPreferenceTreeClickListener r1) {
        this.mOnPreferenceTreeClickListener = r1;
    }

    public OnPreferenceTreeClickListener getOnPreferenceTreeClickListener() {
        return this.mOnPreferenceTreeClickListener;
    }

    public void setOnNavigateToScreenListener(OnNavigateToScreenListener r1) {
        this.mOnNavigateToScreenListener = r1;
    }

    public OnNavigateToScreenListener getOnNavigateToScreenListener() {
        return this.mOnNavigateToScreenListener;
    }
}
