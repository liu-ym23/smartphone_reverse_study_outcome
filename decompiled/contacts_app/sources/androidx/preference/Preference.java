package androidx.preference;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class Preference implements Comparable<Preference> {
    private static final String CLIPBOARD_ID = "Preference";
    public static final int DEFAULT_ORDER = Integer.MAX_VALUE;
    private boolean mAllowDividerAbove;
    private boolean mAllowDividerBelow;
    private boolean mBaseMethodCalled;
    private final View.OnClickListener mClickListener;
    private final Context mContext;
    private boolean mCopyingEnabled;
    private Object mDefaultValue;
    private String mDependencyKey;
    private boolean mDependencyMet;
    private List<Preference> mDependents;
    private boolean mEnabled;
    private Bundle mExtras;
    private String mFragment;
    private boolean mHasId;
    private boolean mHasSingleLineTitleAttr;
    private Drawable mIcon;
    private int mIconResId;
    private boolean mIconSpaceReserved;
    private long mId;
    private Intent mIntent;
    private String mKey;
    private int mLayoutResId;
    private OnPreferenceChangeInternalListener mListener;
    private OnPreferenceChangeListener mOnChangeListener;
    private OnPreferenceClickListener mOnClickListener;
    private OnPreferenceCopyListener mOnCopyListener;
    private int mOrder;
    private boolean mParentDependencyMet;
    private PreferenceGroup mParentGroup;
    private boolean mPersistent;
    private PreferenceDataStore mPreferenceDataStore;
    private PreferenceManager mPreferenceManager;
    private boolean mRequiresKey;
    private boolean mSelectable;
    private boolean mShouldDisableView;
    private boolean mSingleLineTitle;
    private CharSequence mSummary;
    private SummaryProvider mSummaryProvider;
    private CharSequence mTitle;
    private int mViewId;
    private boolean mVisible;
    private boolean mWasDetached;
    private int mWidgetLayoutResId;

    public static class BaseSavedState extends AbsSavedState {
        public static final Parcelable.Creator<BaseSavedState> CREATOR = null;

        static {
            CREATOR = new AnonymousClass1();
        }

        public BaseSavedState(Parcel r1) {
            super(r1);
        }

        public BaseSavedState(Parcelable r1) {
            super(r1);
        }
    }

    interface OnPreferenceChangeInternalListener {
        void onPreferenceChange(Preference r1);

        void onPreferenceHierarchyChange(Preference r1);

        void onPreferenceVisibilityChange(Preference r1);
    }

    public interface OnPreferenceChangeListener {
        boolean onPreferenceChange(Preference r1, Object r2);
    }

    public interface OnPreferenceClickListener {
        boolean onPreferenceClick(Preference r1);
    }

    private static class OnPreferenceCopyListener implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
        private final Preference mPreference;

        OnPreferenceCopyListener(Preference r1) {
            this.mPreference = r1;
        }

        @Override // android.view.View.OnCreateContextMenuListener
        public void onCreateContextMenu(ContextMenu r1, View r2, ContextMenu.ContextMenuInfo r3) {
            CharSequence r4 = this.mPreference.getSummary();
            if (this.mPreference.isCopyingEnabled() == true) goto L5;
            return;
        L5:
            if (TextUtils.isEmpty(r4) == true) goto L10;
            r1.setHeaderTitle(r4);
            r1.add(0, 0, 0, R.string.copy).setOnMenuItemClickListener(this);
            return;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem r6) {
            ClipboardManager r7 = (ClipboardManager) this.mPreference.getContext().getSystemService("clipboard");
            CharSequence r0 = this.mPreference.getSummary();
            r7.setPrimaryClip(ClipData.newPlainText(Preference.CLIPBOARD_ID, r0));
            Toast.makeText(this.mPreference.getContext(), this.mPreference.getContext().getString(R.string.preference_copied, new Object[]{r0}), 0).show();
            return true;
        }
    }

    public interface SummaryProvider<T extends Preference> {
        CharSequence provideSummary(T r1);
    }

    protected void onClick() {
    }

    protected Object onGetDefaultValue(TypedArray r1, int r2) {
        return null;
    }

    @Deprecated
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat r1) {
    }

    protected void onSetInitialValue(Object r1) {
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Preference r1) {
        return compareTo2(r1);
    }

    public Preference(Context r5, AttributeSet r6, int r7, int r8) {
        this.mOrder = Integer.MAX_VALUE;
        this.mViewId = 0;
        this.mEnabled = true;
        this.mSelectable = true;
        this.mPersistent = true;
        this.mDependencyMet = true;
        this.mParentDependencyMet = true;
        this.mVisible = true;
        this.mAllowDividerAbove = true;
        this.mAllowDividerBelow = true;
        this.mSingleLineTitle = true;
        this.mShouldDisableView = true;
        this.mLayoutResId = R.layout.preference;
        this.mClickListener = new AnonymousClass1(this);
        this.mContext = r5;
        TypedArray r9 = r5.obtainStyledAttributes(r6, R.styleable.Preference, r7, r8);
        this.mIconResId = TypedArrayUtils.getResourceId(r9, R.styleable.Preference_icon, R.styleable.Preference_android_icon, 0);
        this.mKey = TypedArrayUtils.getString(r9, R.styleable.Preference_key, R.styleable.Preference_android_key);
        this.mTitle = TypedArrayUtils.getText(r9, R.styleable.Preference_title, R.styleable.Preference_android_title);
        this.mSummary = TypedArrayUtils.getText(r9, R.styleable.Preference_summary, R.styleable.Preference_android_summary);
        this.mOrder = TypedArrayUtils.getInt(r9, R.styleable.Preference_order, R.styleable.Preference_android_order, Integer.MAX_VALUE);
        this.mFragment = TypedArrayUtils.getString(r9, R.styleable.Preference_fragment, R.styleable.Preference_android_fragment);
        this.mLayoutResId = TypedArrayUtils.getResourceId(r9, R.styleable.Preference_layout, R.styleable.Preference_android_layout, R.layout.preference);
        this.mWidgetLayoutResId = TypedArrayUtils.getResourceId(r9, R.styleable.Preference_widgetLayout, R.styleable.Preference_android_widgetLayout, 0);
        this.mEnabled = TypedArrayUtils.getBoolean(r9, R.styleable.Preference_enabled, R.styleable.Preference_android_enabled, true);
        this.mSelectable = TypedArrayUtils.getBoolean(r9, R.styleable.Preference_selectable, R.styleable.Preference_android_selectable, true);
        this.mPersistent = TypedArrayUtils.getBoolean(r9, R.styleable.Preference_persistent, R.styleable.Preference_android_persistent, true);
        this.mDependencyKey = TypedArrayUtils.getString(r9, R.styleable.Preference_dependency, R.styleable.Preference_android_dependency);
        this.mAllowDividerAbove = TypedArrayUtils.getBoolean(r9, R.styleable.Preference_allowDividerAbove, R.styleable.Preference_allowDividerAbove, this.mSelectable);
        this.mAllowDividerBelow = TypedArrayUtils.getBoolean(r9, R.styleable.Preference_allowDividerBelow, R.styleable.Preference_allowDividerBelow, this.mSelectable);
        if (r9.hasValue(R.styleable.Preference_defaultValue) == false) goto L6;
        this.mDefaultValue = onGetDefaultValue(r9, R.styleable.Preference_defaultValue);
    L8:
        this.mShouldDisableView = TypedArrayUtils.getBoolean(r9, R.styleable.Preference_shouldDisableView, R.styleable.Preference_android_shouldDisableView, true);
        boolean r10 = r9.hasValue(R.styleable.Preference_singleLineTitle);
        this.mHasSingleLineTitleAttr = r10;
        if (r10 == false) goto L11;
        this.mSingleLineTitle = TypedArrayUtils.getBoolean(r9, R.styleable.Preference_singleLineTitle, R.styleable.Preference_android_singleLineTitle, true);
    L11:
        this.mIconSpaceReserved = TypedArrayUtils.getBoolean(r9, R.styleable.Preference_iconSpaceReserved, R.styleable.Preference_android_iconSpaceReserved, false);
        this.mVisible = TypedArrayUtils.getBoolean(r9, R.styleable.Preference_isPreferenceVisible, R.styleable.Preference_isPreferenceVisible, true);
        this.mCopyingEnabled = TypedArrayUtils.getBoolean(r9, R.styleable.Preference_enableCopying, R.styleable.Preference_enableCopying, false);
        r9.recycle();
        return;
    L6:
        if (r9.hasValue(R.styleable.Preference_android_defaultValue) == false) goto L8;
        this.mDefaultValue = onGetDefaultValue(r9, R.styleable.Preference_android_defaultValue);
        goto L8
    }

    public Preference(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public Preference(Context r3, AttributeSet r4) {
        this(r3, r4, TypedArrayUtils.getAttr(r3, R.attr.preferenceStyle, android.R.attr.preferenceStyle));
    }

    public Preference(Context r2) {
        this(r2, null);
    }

    public void setIntent(Intent r1) {
        this.mIntent = r1;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public void setFragment(String r1) {
        this.mFragment = r1;
    }

    public String getFragment() {
        return this.mFragment;
    }

    public void setPreferenceDataStore(PreferenceDataStore r1) {
        this.mPreferenceDataStore = r1;
    }

    public PreferenceDataStore getPreferenceDataStore() {
        PreferenceDataStore r0 = this.mPreferenceDataStore;
        if (r0 == null) goto L5;
        return r0;
    L5:
        PreferenceManager r1 = this.mPreferenceManager;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getPreferenceDataStore();
    }

    public Bundle getExtras() {
        if (this.mExtras != null) goto L6;
        this.mExtras = new Bundle();
    L6:
        return this.mExtras;
    }

    public Bundle peekExtras() {
        return this.mExtras;
    }

    public void setLayoutResource(int r1) {
        this.mLayoutResId = r1;
    }

    public final int getLayoutResource() {
        return this.mLayoutResId;
    }

    public void setWidgetLayoutResource(int r1) {
        this.mWidgetLayoutResId = r1;
    }

    public final int getWidgetLayoutResource() {
        return this.mWidgetLayoutResId;
    }

    public void onBindViewHolder(PreferenceViewHolder r9) {
        View r0 = r9.itemView;
        r0.setOnClickListener(this.mClickListener);
        r0.setId(this.mViewId);
        TextView r1 = (TextView) r9.findViewById(android.R.id.summary);
        int r3 = 8;
        if (r1 == null) goto L8;
        CharSequence r5 = getSummary();
        if (TextUtils.isEmpty(r5) == true) goto L7;
        r1.setText(r5);
        r1.setVisibility(0);
        Integer r2 = Integer.valueOf(r1.getCurrentTextColor());
    L9:
        TextView r6 = (TextView) r9.findViewById(android.R.id.title);
        if (r6 == null) goto L23;
        CharSequence r7 = getTitle();
        if (TextUtils.isEmpty(r7) == true) goto L22;
        r6.setText(r7);
        r6.setVisibility(0);
        if (this.mHasSingleLineTitleAttr == false) goto L17;
        r6.setSingleLine(this.mSingleLineTitle);
    L17:
        if (isSelectable() == true) goto L23;
        if (isEnabled() == false) goto L23;
        if (r2 == null) goto L23;
        r6.setTextColor(r2.intValue());
        goto L23
    L22:
        r6.setVisibility(8);
    L23:
        ImageView r4 = (ImageView) r9.findViewById(android.R.id.icon);
        if (r4 == null) goto L43;
        int r8 = this.mIconResId;
        if (r8 != 0) goto L30;
        if (this.mIcon != null) goto L30;
    L36:
        if (this.mIcon == null) goto L39;
        r4.setVisibility(0);
        goto L43
    L39:
        if (this.mIconSpaceReserved == false) goto L41;
        int r10 = 4;
    L42:
        r4.setVisibility(r10);
        goto L43
    L41:
        r10 = 8;
    L30:
        if (this.mIcon != null) goto L32;
        this.mIcon = AppCompatResources.getDrawable(this.mContext, r8);
    L32:
        Drawable r11 = this.mIcon;
        if (r11 == null) goto L36;
        r4.setImageDrawable(r11);
    L43:
        View r12 = r9.findViewById(R.id.icon_frame);
        if (r12 != null) goto L46;
        r12 = r9.findViewById(16908350);
    L46:
        if (r12 == null) goto L55;
        if (this.mIcon == null) goto L51;
        r12.setVisibility(0);
        goto L55
    L51:
        if (this.mIconSpaceReserved == false) goto L53;
        r3 = 4;
    L53:
        r12.setVisibility(r3);
    L55:
        if (this.mShouldDisableView == false) goto L57;
        setEnabledStateOnViews(r0, isEnabled());
    L58:
        boolean r13 = isSelectable();
        r0.setFocusable(r13);
        r0.setClickable(r13);
        r9.setDividerAllowedAbove(this.mAllowDividerAbove);
        r9.setDividerAllowedBelow(this.mAllowDividerBelow);
        boolean r14 = isCopyingEnabled();
        if (r14 == true) goto L61;
    L63:
        if (r14 == false) goto L65;
        OnPreferenceCopyListener r15 = this.mOnCopyListener;
    L66:
        r0.setOnCreateContextMenuListener(r15);
        r0.setLongClickable(r14);
        if (r14 == false) goto L71;
        if (r13 == true) goto L72;
        ViewCompat.setBackground(r0, null);
        return;
    L72:
        return;
    L71:
        return;
    L65:
        r15 = null;
        goto L66
    L61:
        if (this.mOnCopyListener != null) goto L63;
        this.mOnCopyListener = new OnPreferenceCopyListener(this);
        goto L63
    L57:
        setEnabledStateOnViews(r0, true);
        goto L58
    L7:
        r1.setVisibility(8);
    L8:
        r2 = null;
        goto L9
    }

    private void setEnabledStateOnViews(View r3, boolean r4) {
        r3.setEnabled(r4);
        if ((r3 instanceof ViewGroup) == false) goto L7;
        ViewGroup r5 = (ViewGroup) r3;
        int r0 = r5.getChildCount() - 1;
    L5:
        if (r0 < 0) goto L9;
        setEnabledStateOnViews(r5.getChildAt(r0), r4);
        r0 = r0 - 1;
        goto L5
    L9:
        return;
    }

    public void setOrder(int r2) {
        if (r2 == this.mOrder) goto L6;
        this.mOrder = r2;
        notifyHierarchyChanged();
        return;
    }

    public int getOrder() {
        return this.mOrder;
    }

    public void setViewId(int r1) {
        this.mViewId = r1;
    }

    public void setTitle(CharSequence r2) {
        if (TextUtils.equals(r2, this.mTitle) == true) goto L6;
        this.mTitle = r2;
        notifyChanged();
        return;
    }

    public void setTitle(int r2) {
        setTitle(this.mContext.getString(r2));
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public void setIcon(Drawable r2) {
        if (this.mIcon == r2) goto L6;
        this.mIcon = r2;
        this.mIconResId = 0;
        notifyChanged();
        return;
    }

    public void setIcon(int r2) {
        setIcon(AppCompatResources.getDrawable(this.mContext, r2));
        this.mIconResId = r2;
    }

    public Drawable getIcon() {
        if (this.mIcon != null) goto L8;
        int r0 = this.mIconResId;
        if (r0 == 0) goto L8;
        this.mIcon = AppCompatResources.getDrawable(this.mContext, r0);
    L8:
        return this.mIcon;
    }

    public CharSequence getSummary() {
        if (getSummaryProvider() == null) goto L7;
        return getSummaryProvider().provideSummary(this);
    L7:
        return this.mSummary;
    }

    public void setSummary(CharSequence r2) {
        if (getSummaryProvider() != null) goto L9;
        if (TextUtils.equals(this.mSummary, r2) == true) goto L10;
        this.mSummary = r2;
        notifyChanged();
        return;
    L10:
        return;
    L9:
        throw new IllegalStateException("Preference already has a SummaryProvider set.");
    }

    public void setSummary(int r2) {
        setSummary(this.mContext.getString(r2));
    }

    public void setEnabled(boolean r2) {
        if (this.mEnabled == r2) goto L6;
        this.mEnabled = r2;
        notifyDependencyChange(shouldDisableDependents());
        notifyChanged();
        return;
    }

    public boolean isEnabled() {
        if (this.mEnabled == true) goto L5;
    L9:
        return false;
    L5:
        if (this.mDependencyMet == false) goto L9;
        if (this.mParentDependencyMet == false) goto L9;
        return true;
    }

    public void setSelectable(boolean r2) {
        if (this.mSelectable == r2) goto L6;
        this.mSelectable = r2;
        notifyChanged();
        return;
    }

    public boolean isSelectable() {
        return this.mSelectable;
    }

    public void setShouldDisableView(boolean r2) {
        if (this.mShouldDisableView == r2) goto L6;
        this.mShouldDisableView = r2;
        notifyChanged();
        return;
    }

    public boolean getShouldDisableView() {
        return this.mShouldDisableView;
    }

    public final void setVisible(boolean r2) {
        if (this.mVisible == r2) goto L8;
        this.mVisible = r2;
        OnPreferenceChangeInternalListener r3 = this.mListener;
        if (r3 == null) goto L9;
        r3.onPreferenceVisibilityChange(this);
        return;
    L9:
        return;
    }

    public final boolean isVisible() {
        return this.mVisible;
    }

    public final boolean isShown() {
        if (isVisible() == true) goto L6;
        return false;
    L6:
        if (getPreferenceManager() != null) goto L9;
        return false;
    L9:
        if (this != getPreferenceManager().getPreferenceScreen()) goto L12;
        return true;
    L12:
        PreferenceGroup r2 = getParent();
        if (r2 != null) goto L16;
        return false;
    L16:
        return r2.isShown();
    }

    long getId() {
        return this.mId;
    }

    public void setKey(String r1) {
        this.mKey = r1;
        if (this.mRequiresKey == true) goto L5;
        return;
    L5:
        if (hasKey() == true) goto L9;
        requireKey();
        return;
    }

    public String getKey() {
        return this.mKey;
    }

    void requireKey() {
        if (TextUtils.isEmpty(this.mKey) == true) goto L7;
        this.mRequiresKey = true;
        return;
    L7:
        throw new IllegalStateException("Preference does not have a key assigned.");
    }

    public boolean hasKey() {
        return !TextUtils.isEmpty(this.mKey);
    }

    public boolean isPersistent() {
        return this.mPersistent;
    }

    protected boolean shouldPersist() {
        if (this.mPreferenceManager != null) goto L5;
    L9:
        return false;
    L5:
        if (isPersistent() == false) goto L9;
        if (hasKey() == false) goto L9;
        return true;
    }

    public void setPersistent(boolean r1) {
        this.mPersistent = r1;
    }

    public void setSingleLineTitle(boolean r2) {
        this.mHasSingleLineTitleAttr = true;
        this.mSingleLineTitle = r2;
    }

    public boolean isSingleLineTitle() {
        return this.mSingleLineTitle;
    }

    public void setIconSpaceReserved(boolean r2) {
        if (this.mIconSpaceReserved == r2) goto L6;
        this.mIconSpaceReserved = r2;
        notifyChanged();
        return;
    }

    public boolean isIconSpaceReserved() {
        return this.mIconSpaceReserved;
    }

    public void setCopyingEnabled(boolean r2) {
        if (this.mCopyingEnabled == r2) goto L6;
        this.mCopyingEnabled = r2;
        notifyChanged();
        return;
    }

    public boolean isCopyingEnabled() {
        return this.mCopyingEnabled;
    }

    public final void setSummaryProvider(SummaryProvider r1) {
        this.mSummaryProvider = r1;
        notifyChanged();
    }

    public final SummaryProvider getSummaryProvider() {
        return this.mSummaryProvider;
    }

    public boolean callChangeListener(Object r2) {
        OnPreferenceChangeListener r0 = this.mOnChangeListener;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.onPreferenceChange(this, r2) == true) goto L8;
        return false;
    }

    public void setOnPreferenceChangeListener(OnPreferenceChangeListener r1) {
        this.mOnChangeListener = r1;
    }

    public OnPreferenceChangeListener getOnPreferenceChangeListener() {
        return this.mOnChangeListener;
    }

    public void setOnPreferenceClickListener(OnPreferenceClickListener r1) {
        this.mOnClickListener = r1;
    }

    public OnPreferenceClickListener getOnPreferenceClickListener() {
        return this.mOnClickListener;
    }

    protected void performClick(View r1) {
        performClick();
    }

    public void performClick() {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        if (isSelectable() == false) goto L25;
        onClick();
        OnPreferenceClickListener r0 = this.mOnClickListener;
        if (r0 != null) goto L10;
    L12:
        PreferenceManager r1 = getPreferenceManager();
        if (r1 == null) goto L20;
        PreferenceManager.OnPreferenceTreeClickListener r2 = r1.getOnPreferenceTreeClickListener();
        if (r2 == null) goto L20;
        if (r2.onPreferenceTreeClick(this) == false) goto L20;
        return;
    L20:
        if (this.mIntent == null) goto L24;
        getContext().startActivity(this.mIntent);
        return;
    L24:
        return;
    L10:
        if (r0.onPreferenceClick(this) == false) goto L12;
        return;
    }

    public Context getContext() {
        return this.mContext;
    }

    public SharedPreferences getSharedPreferences() {
        if (this.mPreferenceManager != null) goto L5;
        return null;
    L5:
        if (getPreferenceDataStore() == null) goto L8;
        return null;
    L8:
        return this.mPreferenceManager.getSharedPreferences();
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Preference r3) {
        int r0 = this.mOrder;
        int r1 = r3.mOrder;
        if (r0 != r1) goto L5;
        CharSequence r2 = this.mTitle;
        CharSequence r4 = r3.mTitle;
        if (r2 != r4) goto L10;
        return 0;
    L10:
        if (r2 != null) goto L13;
        return 1;
    L13:
        if (r4 != null) goto L17;
        return -1;
    L17:
        return r2.toString().compareToIgnoreCase(r3.mTitle.toString());
    L5:
        return r0 - r1;
    }

    final void setOnPreferenceChangeInternalListener(OnPreferenceChangeInternalListener r1) {
        this.mListener = r1;
    }

    protected void notifyChanged() {
        OnPreferenceChangeInternalListener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onPreferenceChange(this);
        return;
    }

    protected void notifyHierarchyChanged() {
        OnPreferenceChangeInternalListener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onPreferenceHierarchyChange(this);
        return;
    }

    public PreferenceManager getPreferenceManager() {
        return this.mPreferenceManager;
    }

    protected void onAttachedToHierarchy(PreferenceManager r3) {
        this.mPreferenceManager = r3;
        if (this.mHasId == true) goto L5;
        this.mId = r3.getNextId();
    L5:
        dispatchSetInitialValue();
    }

    protected void onAttachedToHierarchy(PreferenceManager r1, long r2) {
        this.mId = r2;
        this.mHasId = true;
        onAttachedToHierarchy(r1);     // Catch: Throwable -> L6
        this.mHasId = false;
        return;
    L6:
        th = move-exception;
        this.mHasId = false;
        throw th;
    }

    void assignParent(PreferenceGroup r2) {
        if (r2 != null) goto L4;
    L8:
        this.mParentGroup = r2;
        return;
    L4:
        if (this.mParentGroup == null) goto L8;
        throw new IllegalStateException("This preference already has a parent. You must remove the existing parent before assigning a new one.");
    }

    public void onAttached() {
        registerDependency();
    }

    public void onDetached() {
        unregisterDependency();
        this.mWasDetached = true;
    }

    final boolean wasDetached() {
        return this.mWasDetached;
    }

    final void clearWasDetached() {
        this.mWasDetached = false;
    }

    private void registerDependency() {
        if (TextUtils.isEmpty(this.mDependencyKey) == false) goto L5;
        return;
    L5:
        Preference r0 = findPreferenceInHierarchy(this.mDependencyKey);
        if (r0 == null) goto L10;
        r0.registerDependent(this);
        return;
    L10:
        throw new IllegalStateException("Dependency \"" + this.mDependencyKey + "\" not found for preference \"" + this.mKey + "\" (title: \"" + this.mTitle + "\"");
    }

    private void unregisterDependency() {
        String r0 = this.mDependencyKey;
        if (r0 == null) goto L8;
        Preference r1 = findPreferenceInHierarchy(r0);
        if (r1 == null) goto L9;
        r1.unregisterDependent(this);
        return;
    L9:
        return;
    }

    protected <T extends Preference> T findPreferenceInHierarchy(String r1) {
        PreferenceManager r0 = this.mPreferenceManager;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (T) r0.findPreference(r1);
    }

    private void registerDependent(Preference r2) {
        if (this.mDependents != null) goto L5;
        this.mDependents = new ArrayList();
    L5:
        this.mDependents.add(r2);
        r2.onDependencyChanged(this, shouldDisableDependents());
    }

    private void unregisterDependent(Preference r1) {
        List<Preference> r0 = this.mDependents;
        if (r0 == null) goto L6;
        r0.remove(r1);
        return;
    }

    public void notifyDependencyChange(boolean r5) {
        List<Preference> r0 = this.mDependents;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.size();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        r0.get(r2).onDependencyChanged(this, r5);
        r2 = r2 + 1;
        goto L6
    }

    public void onDependencyChanged(Preference r1, boolean r2) {
        if (this.mDependencyMet != r2) goto L6;
        this.mDependencyMet = !r2;
        notifyDependencyChange(shouldDisableDependents());
        notifyChanged();
        return;
    }

    public void onParentChanged(Preference r1, boolean r2) {
        if (this.mParentDependencyMet != r2) goto L6;
        this.mParentDependencyMet = !r2;
        notifyDependencyChange(shouldDisableDependents());
        notifyChanged();
        return;
    }

    public boolean shouldDisableDependents() {
        return !isEnabled();
    }

    public void setDependency(String r1) {
        unregisterDependency();
        this.mDependencyKey = r1;
        registerDependency();
    }

    public String getDependency() {
        return this.mDependencyKey;
    }

    public PreferenceGroup getParent() {
        return this.mParentGroup;
    }

    protected void onPrepareForRemoval() {
        unregisterDependency();
    }

    public void setDefaultValue(Object r1) {
        this.mDefaultValue = r1;
    }

    private void dispatchSetInitialValue() {
        if (getPreferenceDataStore() == null) goto L7;
        onSetInitialValue(true, this.mDefaultValue);
        return;
    L7:
        if (shouldPersist() == true) goto L9;
    L12:
        Object r0 = this.mDefaultValue;
        if (r0 == null) goto L17;
        onSetInitialValue(false, r0);
        return;
    L17:
        return;
    L9:
        if (getSharedPreferences().contains(this.mKey) == false) goto L12;
        onSetInitialValue(true, null);
    }

    @Deprecated
    protected void onSetInitialValue(boolean r1, Object r2) {
        onSetInitialValue(r2);
    }

    private void tryCommit(SharedPreferences.Editor r1) {
        if (this.mPreferenceManager.shouldCommit() == false) goto L6;
        r1.apply();
        return;
    }

    protected boolean persistString(String r4) {
        if (shouldPersist() == true) goto L7;
        return false;
    L7:
        if (TextUtils.equals(r4, getPersistedString(null)) == false) goto L9;
        return true;
    L9:
        PreferenceDataStore r0 = getPreferenceDataStore();
        if (r0 == null) goto L12;
        r0.putString(this.mKey, r4);
    L13:
        return true;
    L12:
        SharedPreferences.Editor r1 = this.mPreferenceManager.getEditor();
        r1.putString(this.mKey, r4);
        tryCommit(r1);
        goto L13
    }

    protected String getPersistedString(String r2) {
        if (shouldPersist() == true) goto L5;
        return r2;
    L5:
        PreferenceDataStore r0 = getPreferenceDataStore();
        if (r0 == null) goto L10;
        return r0.getString(this.mKey, r2);
    L10:
        return this.mPreferenceManager.getSharedPreferences().getString(this.mKey, r2);
    }

    public boolean persistStringSet(Set<String> r4) {
        if (shouldPersist() == true) goto L7;
        return false;
    L7:
        if (r4.equals(getPersistedStringSet(null)) == false) goto L9;
        return true;
    L9:
        PreferenceDataStore r0 = getPreferenceDataStore();
        if (r0 == null) goto L12;
        r0.putStringSet(this.mKey, r4);
    L13:
        return true;
    L12:
        SharedPreferences.Editor r1 = this.mPreferenceManager.getEditor();
        r1.putStringSet(this.mKey, r4);
        tryCommit(r1);
        goto L13
    }

    public Set<String> getPersistedStringSet(Set<String> r2) {
        if (shouldPersist() == true) goto L5;
        return r2;
    L5:
        PreferenceDataStore r0 = getPreferenceDataStore();
        if (r0 == null) goto L10;
        return r0.getStringSet(this.mKey, r2);
    L10:
        return this.mPreferenceManager.getSharedPreferences().getStringSet(this.mKey, r2);
    }

    protected boolean persistInt(int r4) {
        if (shouldPersist() == true) goto L7;
        return false;
    L7:
        if (r4 != getPersistedInt(~r4)) goto L9;
        return true;
    L9:
        PreferenceDataStore r0 = getPreferenceDataStore();
        if (r0 == null) goto L12;
        r0.putInt(this.mKey, r4);
    L13:
        return true;
    L12:
        SharedPreferences.Editor r1 = this.mPreferenceManager.getEditor();
        r1.putInt(this.mKey, r4);
        tryCommit(r1);
        goto L13
    }

    protected int getPersistedInt(int r2) {
        if (shouldPersist() == true) goto L5;
        return r2;
    L5:
        PreferenceDataStore r0 = getPreferenceDataStore();
        if (r0 == null) goto L10;
        return r0.getInt(this.mKey, r2);
    L10:
        return this.mPreferenceManager.getSharedPreferences().getInt(this.mKey, r2);
    }

    protected boolean persistFloat(float r4) {
        if (shouldPersist() == true) goto L7;
        return false;
    L7:
        if (r4 != getPersistedFloat(Float.NaN)) goto L9;
        return true;
    L9:
        PreferenceDataStore r0 = getPreferenceDataStore();
        if (r0 == null) goto L12;
        r0.putFloat(this.mKey, r4);
    L13:
        return true;
    L12:
        SharedPreferences.Editor r1 = this.mPreferenceManager.getEditor();
        r1.putFloat(this.mKey, r4);
        tryCommit(r1);
        goto L13
    }

    protected float getPersistedFloat(float r2) {
        if (shouldPersist() == true) goto L5;
        return r2;
    L5:
        PreferenceDataStore r0 = getPreferenceDataStore();
        if (r0 == null) goto L10;
        return r0.getFloat(this.mKey, r2);
    L10:
        return this.mPreferenceManager.getSharedPreferences().getFloat(this.mKey, r2);
    }

    protected boolean persistLong(long r4) {
        if (shouldPersist() == true) goto L7;
        return false;
    L7:
        if (r4 != getPersistedLong(~r4)) goto L9;
        return true;
    L9:
        PreferenceDataStore r0 = getPreferenceDataStore();
        if (r0 == null) goto L12;
        r0.putLong(this.mKey, r4);
    L13:
        return true;
    L12:
        SharedPreferences.Editor r1 = this.mPreferenceManager.getEditor();
        r1.putLong(this.mKey, r4);
        tryCommit(r1);
        goto L13
    }

    protected long getPersistedLong(long r2) {
        if (shouldPersist() == true) goto L5;
        return r2;
    L5:
        PreferenceDataStore r0 = getPreferenceDataStore();
        if (r0 == null) goto L10;
        return r0.getLong(this.mKey, r2);
    L10:
        return this.mPreferenceManager.getSharedPreferences().getLong(this.mKey, r2);
    }

    protected boolean persistBoolean(boolean r4) {
        if (shouldPersist() == true) goto L7;
        return false;
    L7:
        if (r4 != getPersistedBoolean(!r4)) goto L9;
        return true;
    L9:
        PreferenceDataStore r0 = getPreferenceDataStore();
        if (r0 == null) goto L12;
        r0.putBoolean(this.mKey, r4);
    L13:
        return true;
    L12:
        SharedPreferences.Editor r1 = this.mPreferenceManager.getEditor();
        r1.putBoolean(this.mKey, r4);
        tryCommit(r1);
        goto L13
    }

    protected boolean getPersistedBoolean(boolean r2) {
        if (shouldPersist() == true) goto L5;
        return r2;
    L5:
        PreferenceDataStore r0 = getPreferenceDataStore();
        if (r0 == null) goto L10;
        return r0.getBoolean(this.mKey, r2);
    L10:
        return this.mPreferenceManager.getSharedPreferences().getBoolean(this.mKey, r2);
    }

    public String toString() {
        return getFilterableStringBuilder().toString();
    }

    StringBuilder getFilterableStringBuilder() {
        StringBuilder r0 = new StringBuilder();
        CharSequence r1 = getTitle();
        if (TextUtils.isEmpty(r1) == true) goto L5;
        r0.append(r1).append(' ');
    L5:
        CharSequence r4 = getSummary();
        if (TextUtils.isEmpty(r4) == true) goto L9;
        r0.append(r4).append(' ');
    L9:
        if (r0.length() <= 0) goto L11;
        r0.setLength(r0.length() - 1);
    L11:
        return r0;
    }

    public void saveHierarchyState(Bundle r1) {
        dispatchSaveInstanceState(r1);
    }

    void dispatchSaveInstanceState(Bundle r3) {
        if (hasKey() == false) goto L10;
        this.mBaseMethodCalled = false;
        Parcelable r0 = onSaveInstanceState();
        if (this.mBaseMethodCalled == false) goto L9;
        if (r0 == null) goto L11;
        r3.putParcelable(this.mKey, r0);
        return;
    L11:
        return;
    L9:
        throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
    }

    protected Parcelable onSaveInstanceState() {
        this.mBaseMethodCalled = true;
        return BaseSavedState.EMPTY_STATE;
    }

    public void restoreHierarchyState(Bundle r1) {
        dispatchRestoreInstanceState(r1);
    }

    void dispatchRestoreInstanceState(Bundle r2) {
        if (hasKey() == false) goto L11;
        Parcelable r3 = r2.getParcelable(this.mKey);
        if (r3 == null) goto L12;
        this.mBaseMethodCalled = false;
        onRestoreInstanceState(r3);
        if (this.mBaseMethodCalled == false) goto L10;
        return;
    L10:
        throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
    L12:
        return;
    }

    protected void onRestoreInstanceState(Parcelable r2) {
        this.mBaseMethodCalled = true;
        if (r2 == BaseSavedState.EMPTY_STATE) goto L8;
        if (r2 != null) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
    }
}
