package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {
    private static final String TAG = "PreferenceGroup";
    private boolean mAttachedToHierarchy;
    private final Runnable mClearRecycleCacheRunnable;
    private int mCurrentPreferenceOrder;
    private final Handler mHandler;
    final SimpleArrayMap<String, Long> mIdRecycleCache;
    private int mInitialExpandedChildrenCount;
    private OnExpandButtonClickListener mOnExpandButtonClickListener;
    private boolean mOrderingAsAdded;
    private final List<Preference> mPreferences;

    public interface OnExpandButtonClickListener {
        void onExpandButtonClick();
    }

    public interface PreferencePositionCallback {
        int getPreferenceAdapterPosition(Preference r1);

        int getPreferenceAdapterPosition(String r1);
    }

    static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int mInitialExpandedChildrenCount;

        static {
            CREATOR = new AnonymousClass1();
        }

        SavedState(Parcel r1) {
            super(r1);
            this.mInitialExpandedChildrenCount = r1.readInt();
        }

        SavedState(Parcelable r1, int r2) {
            super(r1);
            this.mInitialExpandedChildrenCount = r2;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.mInitialExpandedChildrenCount);
        }
    }

    protected boolean isOnSameScreenAsChildren() {
        return true;
    }

    public PreferenceGroup(Context r4, AttributeSet r5, int r6, int r7) {
        super(r4, r5, r6, r7);
        this.mIdRecycleCache = new SimpleArrayMap();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mOrderingAsAdded = true;
        this.mCurrentPreferenceOrder = 0;
        this.mAttachedToHierarchy = false;
        this.mInitialExpandedChildrenCount = Integer.MAX_VALUE;
        this.mOnExpandButtonClickListener = null;
        this.mClearRecycleCacheRunnable = new AnonymousClass1(this);
        this.mPreferences = new ArrayList();
        TypedArray r8 = r4.obtainStyledAttributes(r5, R.styleable.PreferenceGroup, r6, r7);
        this.mOrderingAsAdded = TypedArrayUtils.getBoolean(r8, R.styleable.PreferenceGroup_orderingFromXml, R.styleable.PreferenceGroup_orderingFromXml, true);
        if (r8.hasValue(R.styleable.PreferenceGroup_initialExpandedChildrenCount) == false) goto L5;
        setInitialExpandedChildrenCount(TypedArrayUtils.getInt(r8, R.styleable.PreferenceGroup_initialExpandedChildrenCount, R.styleable.PreferenceGroup_initialExpandedChildrenCount, Integer.MAX_VALUE));
    L5:
        r8.recycle();
    }

    public PreferenceGroup(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public PreferenceGroup(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public void setOrderingAsAdded(boolean r1) {
        this.mOrderingAsAdded = r1;
    }

    public boolean isOrderingAsAdded() {
        return this.mOrderingAsAdded;
    }

    public void setInitialExpandedChildrenCount(int r3) {
        if (r3 != Integer.MAX_VALUE) goto L5;
    L7:
        this.mInitialExpandedChildrenCount = r3;
        return;
    L5:
        if (hasKey() == true) goto L7;
        Log.e(TAG, getClass().getSimpleName() + " should have a key defined if it contains an expandable preference");
        goto L7
    }

    public int getInitialExpandedChildrenCount() {
        return this.mInitialExpandedChildrenCount;
    }

    public void addItemFromInflater(Preference r1) {
        addPreference(r1);
    }

    public int getPreferenceCount() {
        return this.mPreferences.size();
    }

    public Preference getPreference(int r1) {
        return this.mPreferences.get(r1);
    }

    public boolean addPreference(Preference r7) {
        if (this.mPreferences.contains(r7) == false) goto L6;
        return true;
    L6:
        if (r7.getKey() == null) goto L15;
        PreferenceGroup r0 = this;
    L9:
        if (r0.getParent() == null) goto L11;
        r0 = r0.getParent();
        goto L9
    L11:
        String r2 = r7.getKey();
        if (r0.findPreference(r2) == null) goto L15;
        Log.e(TAG, "Found duplicated key: \"" + r2 + "\". This can cause unintended behaviour, please use unique keys for every preference.");
    L15:
        if (r7.getOrder() == Integer.MAX_VALUE) goto L17;
    L22:
        int r1 = Collections.binarySearch(this.mPreferences, r7);
        if (r1 >= 0) goto L26;
        r1 = (r1 * (-1)) - 1;
    L26:
        if (onPrepareAddPreference(r7) == true) goto L29;
        return false;
    L29:
        monitor-enter(this);
        this.mPreferences.add(r1, r7);     // Catch: Throwable -> L43
        monitor-exit(this);     // Catch: Throwable -> L43
        PreferenceManager r3 = getPreferenceManager();
        String r4 = r7.getKey();
        if (r4 != null) goto L35;
    L37:
        long r5 = r3.getNextId();
    L38:
        r7.onAttachedToHierarchy(r3, r5);
        r7.assignParent(this);
        if (this.mAttachedToHierarchy == false) goto L41;
        r7.onAttached();
    L41:
        notifyHierarchyChanged();
        return true;
    L35:
        if (this.mIdRecycleCache.containsKey(r4) == false) goto L37;
        r5 = this.mIdRecycleCache.get(r4).longValue();
        this.mIdRecycleCache.remove(r4);
    L43:
        th = move-exception;
        throw th;
    L17:
        if (this.mOrderingAsAdded == false) goto L20;
        int r6 = this.mCurrentPreferenceOrder;
        this.mCurrentPreferenceOrder = r6 + 1;
        r7.setOrder(r6);
    L20:
        if ((r7 instanceof PreferenceGroup) == false) goto L22;
        ((PreferenceGroup) r7).setOrderingAsAdded(this.mOrderingAsAdded);
        goto L22
    }

    public boolean removePreference(Preference r1) {
        boolean r2 = removePreferenceInt(r1);
        notifyHierarchyChanged();
        return r2;
    }

    public boolean removePreferenceRecursively(CharSequence r1) {
        Preference r0 = findPreference(r1);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.getParent().removePreference(r0);
    }

    private boolean removePreferenceInt(Preference r6) {
        monitor-enter(this);
        r6.onPrepareForRemoval();     // Catch: Throwable -> L16
        if (r6.getParent() != this) goto L6;
        r6.assignParent(null);     // Catch: Throwable -> L16
    L6:
        boolean r0 = this.mPreferences.remove(r6);     // Catch: Throwable -> L16
        if (r0 == false) goto L14;
        String r1 = r6.getKey();     // Catch: Throwable -> L16
        if (r1 == null) goto L12;
        this.mIdRecycleCache.put(r1, Long.valueOf(r6.getId()));     // Catch: Throwable -> L16
        this.mHandler.removeCallbacks(this.mClearRecycleCacheRunnable);     // Catch: Throwable -> L16
        this.mHandler.post(this.mClearRecycleCacheRunnable);     // Catch: Throwable -> L16
    L12:
        if (this.mAttachedToHierarchy == false) goto L14;
        r6.onDetached();     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
        return r0;
    L16:
        th = move-exception;
        throw th;
    }

    public void removeAll() {
        monitor-enter(this);
        List<Preference> r0 = this.mPreferences;     // Catch: Throwable -> L9
        int r1 = r0.size() - 1;     // Catch: Throwable -> L9
    L4:
        if (r1 < 0) goto L6;
        removePreferenceInt(r0.get(0));     // Catch: Throwable -> L9
        r1 = r1 - 1;     // Catch: Throwable -> L9
        goto L4
    L6:
        monitor-exit(this);     // Catch: Throwable -> L9
        notifyHierarchyChanged();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    protected boolean onPrepareAddPreference(Preference r2) {
        r2.onParentChanged(this, shouldDisableDependents());
        return true;
    }

    public <T extends Preference> T findPreference(CharSequence r5) {
        if (r5 == null) goto L20;
        if (TextUtils.equals(getKey(), r5) == false) goto L6;
        return this;
    L6:
        int r0 = getPreferenceCount();
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L17;
        PreferenceGroup r2 = (T) getPreference(r1);
        if (TextUtils.equals(r2.getKey(), r5) == true) goto L10;
        if ((r2 instanceof PreferenceGroup) == false) goto L16;
        T r3 = (T) r2.findPreference(r5);
        if (r3 == null) goto L16;
        return r3;
    L16:
        r1 = r1 + 1;
        goto L7
    L10:
        return r2;
    L17:
        return null;
    L20:
        throw new IllegalArgumentException("Key cannot be null");
    }

    public boolean isAttached() {
        return this.mAttachedToHierarchy;
    }

    public void setOnExpandButtonClickListener(OnExpandButtonClickListener r1) {
        this.mOnExpandButtonClickListener = r1;
    }

    public OnExpandButtonClickListener getOnExpandButtonClickListener() {
        return this.mOnExpandButtonClickListener;
    }

    @Override // androidx.preference.Preference
    public void onAttached() {
        super.onAttached();
        this.mAttachedToHierarchy = true;
        int r0 = getPreferenceCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        getPreference(r1).onAttached();
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.preference.Preference
    public void onDetached() {
        super.onDetached();
        int r0 = 0;
        this.mAttachedToHierarchy = false;
        int r1 = getPreferenceCount();
    L3:
        if (r0 >= r1) goto L5;
        getPreference(r0).onDetached();
        r0 = r0 + 1;
        goto L3
    }

    @Override // androidx.preference.Preference
    public void notifyDependencyChange(boolean r4) {
        super.notifyDependencyChange(r4);
        int r0 = getPreferenceCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        getPreference(r1).onParentChanged(this, r4);
        r1 = r1 + 1;
        goto L3
    }

    void sortPreferences() {
        monitor-enter(this);
        Collections.sort(this.mPreferences);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // androidx.preference.Preference
    protected void dispatchSaveInstanceState(Bundle r4) {
        super.dispatchSaveInstanceState(r4);
        int r0 = getPreferenceCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        getPreference(r1).dispatchSaveInstanceState(r4);
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.preference.Preference
    protected void dispatchRestoreInstanceState(Bundle r4) {
        super.dispatchRestoreInstanceState(r4);
        int r0 = getPreferenceCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        getPreference(r1).dispatchRestoreInstanceState(r4);
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.preference.Preference
    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.mInitialExpandedChildrenCount);
    }

    @Override // androidx.preference.Preference
    protected void onRestoreInstanceState(Parcelable r3) {
        if (r3 != null) goto L4;
    L8:
        super.onRestoreInstanceState(r3);
        return;
    L4:
        if (r3.getClass().equals(SavedState.class) == false) goto L8;
        SavedState r4 = (SavedState) r3;
        this.mInitialExpandedChildrenCount = r4.mInitialExpandedChildrenCount;
        super.onRestoreInstanceState(r4.getSuperState());
    }
}
