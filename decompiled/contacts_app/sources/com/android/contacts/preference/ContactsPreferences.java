package com.android.contacts.preference;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.android.contacts.R;

/* JADX INFO: loaded from: classes2.dex */
public final class ContactsPreferences extends ContentObserver {
    public static final String PREF_DISPLAY_ONLY_PHONES = "only_phones";
    public static final boolean PREF_DISPLAY_ONLY_PHONES_DEFAULT = false;
    private Context mContext;
    private int mDisplayOrder;
    private Handler mHandler;
    private ChangeListener mListener;
    private int mSortOrder;

    public interface ChangeListener {
        void onChange();
    }

    static /* synthetic */ Context access$000(ContactsPreferences r0) {
        return r0.mContext;
    }

    static /* synthetic */ int access$102(ContactsPreferences r0, int r1) {
        r0.mSortOrder = r1;
        return r1;
    }

    static /* synthetic */ int access$202(ContactsPreferences r0, int r1) {
        r0.mDisplayOrder = r1;
        return r1;
    }

    static /* synthetic */ ChangeListener access$300(ContactsPreferences r0) {
        return r0.mListener;
    }

    public ContactsPreferences(Context r3) {
        super(null);
        this.mSortOrder = -1;
        this.mDisplayOrder = -1;
        this.mListener = null;
        this.mContext = r3.getApplicationContext();
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    public boolean isSortOrderUserChangeable() {
        return this.mContext.getResources().getBoolean(R.bool.config_sort_order_user_changeable);
    }

    public int getDefaultSortOrder() {
        if (this.mContext.getResources().getBoolean(R.bool.config_default_sort_order_primary) == false) goto L6;
        return 1;
    L6:
        return 2;
    }

    public int getSortOrder() {
        if (isSortOrderUserChangeable() == true) goto L7;
        return getDefaultSortOrder();
    L7:
        if (this.mSortOrder != (-1)) goto L12;
        this.mSortOrder = Settings.System.getInt(this.mContext.getContentResolver(), "android.contacts.SORT_ORDER");     // Catch: Settings.SettingNotFoundException -> L10
    L10:
        this.mSortOrder = getDefaultSortOrder();
    L12:
        return this.mSortOrder;
    }

    public void setSortOrder(int r2) {
        this.mSortOrder = r2;
        Settings.System.putInt(this.mContext.getContentResolver(), "android.contacts.SORT_ORDER", r2);
    }

    public boolean isDisplayOrderUserChangeable() {
        return this.mContext.getResources().getBoolean(R.bool.config_display_order_user_changeable);
    }

    public int getDefaultDisplayOrder() {
        if (this.mContext.getResources().getBoolean(R.bool.config_default_display_order_primary) == false) goto L6;
        return 1;
    L6:
        return 2;
    }

    public int getDisplayOrder() {
        if (isDisplayOrderUserChangeable() == true) goto L7;
        return getDefaultDisplayOrder();
    L7:
        if (this.mDisplayOrder != (-1)) goto L12;
        this.mDisplayOrder = Settings.System.getInt(this.mContext.getContentResolver(), "android.contacts.DISPLAY_ORDER");     // Catch: Settings.SettingNotFoundException -> L10
    L10:
        this.mDisplayOrder = getDefaultDisplayOrder();
    L12:
        return this.mDisplayOrder;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.android.contacts.preference.ContactsPreferences$1] */
    public void setDisplayOrder(int r3) {
        this.mDisplayOrder = r3;
        Settings.System.putInt(this.mContext.getContentResolver(), "android.contacts.DISPLAY_ORDER", r3);
        new AnonymousClass1(this).execute(new Void[0]);
    }

    public void registerChangeListener(ChangeListener r3) {
        if (this.mListener == null) goto L5;
        unregisterChangeListener();
    L5:
        this.mListener = r3;
        this.mDisplayOrder = -1;
        this.mSortOrder = -1;
        ContentResolver r4 = this.mContext.getContentResolver();
        r4.registerContentObserver(Settings.System.getUriFor("android.contacts.SORT_ORDER"), false, this);
        r4.registerContentObserver(Settings.System.getUriFor("android.contacts.DISPLAY_ORDER"), false, this);
    }

    public void unregisterChangeListener() {
        if (this.mListener == null) goto L6;
        this.mContext.getContentResolver().unregisterContentObserver(this);
        this.mListener = null;
        return;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r2) {
        this.mHandler.post(new AnonymousClass2(this));
    }
}
