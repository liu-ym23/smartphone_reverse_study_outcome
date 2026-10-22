package androidx.core.view.accessibility;

import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityRecordCompat {
    private final AccessibilityRecord mRecord;

    static class Api15Impl {
        private Api15Impl() {
        }

        static int getMaxScrollX(AccessibilityRecord r0) {
            return r0.getMaxScrollX();
        }

        static void setMaxScrollX(AccessibilityRecord r0, int r1) {
            r0.setMaxScrollX(r1);
        }

        static int getMaxScrollY(AccessibilityRecord r0) {
            return r0.getMaxScrollY();
        }

        static void setMaxScrollY(AccessibilityRecord r0, int r1) {
            r0.setMaxScrollY(r1);
        }
    }

    static class Api16Impl {
        private Api16Impl() {
        }

        static void setSource(AccessibilityRecord r0, View r1, int r2) {
            r0.setSource(r1, r2);
        }
    }

    @Deprecated
    public AccessibilityRecordCompat(Object r1) {
        this.mRecord = (AccessibilityRecord) r1;
    }

    @Deprecated
    public Object getImpl() {
        return this.mRecord;
    }

    @Deprecated
    public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat r1) {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain(r1.mRecord));
    }

    @Deprecated
    public static AccessibilityRecordCompat obtain() {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain());
    }

    @Deprecated
    public void setSource(View r1) {
        this.mRecord.setSource(r1);
    }

    @Deprecated
    public void setSource(View r1, int r2) {
        setSource(this.mRecord, r1, r2);
    }

    public static void setSource(AccessibilityRecord r0, View r1, int r2) {
        Api16Impl.setSource(r0, r1, r2);
    }

    @Deprecated
    public AccessibilityNodeInfoCompat getSource() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mRecord.getSource());
    }

    @Deprecated
    public int getWindowId() {
        return this.mRecord.getWindowId();
    }

    @Deprecated
    public boolean isChecked() {
        return this.mRecord.isChecked();
    }

    @Deprecated
    public void setChecked(boolean r1) {
        this.mRecord.setChecked(r1);
    }

    @Deprecated
    public boolean isEnabled() {
        return this.mRecord.isEnabled();
    }

    @Deprecated
    public void setEnabled(boolean r1) {
        this.mRecord.setEnabled(r1);
    }

    @Deprecated
    public boolean isPassword() {
        return this.mRecord.isPassword();
    }

    @Deprecated
    public void setPassword(boolean r1) {
        this.mRecord.setPassword(r1);
    }

    @Deprecated
    public boolean isFullScreen() {
        return this.mRecord.isFullScreen();
    }

    @Deprecated
    public void setFullScreen(boolean r1) {
        this.mRecord.setFullScreen(r1);
    }

    @Deprecated
    public boolean isScrollable() {
        return this.mRecord.isScrollable();
    }

    @Deprecated
    public void setScrollable(boolean r1) {
        this.mRecord.setScrollable(r1);
    }

    @Deprecated
    public int getItemCount() {
        return this.mRecord.getItemCount();
    }

    @Deprecated
    public void setItemCount(int r1) {
        this.mRecord.setItemCount(r1);
    }

    @Deprecated
    public int getCurrentItemIndex() {
        return this.mRecord.getCurrentItemIndex();
    }

    @Deprecated
    public void setCurrentItemIndex(int r1) {
        this.mRecord.setCurrentItemIndex(r1);
    }

    @Deprecated
    public int getFromIndex() {
        return this.mRecord.getFromIndex();
    }

    @Deprecated
    public void setFromIndex(int r1) {
        this.mRecord.setFromIndex(r1);
    }

    @Deprecated
    public int getToIndex() {
        return this.mRecord.getToIndex();
    }

    @Deprecated
    public void setToIndex(int r1) {
        this.mRecord.setToIndex(r1);
    }

    @Deprecated
    public int getScrollX() {
        return this.mRecord.getScrollX();
    }

    @Deprecated
    public void setScrollX(int r1) {
        this.mRecord.setScrollX(r1);
    }

    @Deprecated
    public int getScrollY() {
        return this.mRecord.getScrollY();
    }

    @Deprecated
    public void setScrollY(int r1) {
        this.mRecord.setScrollY(r1);
    }

    @Deprecated
    public int getMaxScrollX() {
        return getMaxScrollX(this.mRecord);
    }

    public static int getMaxScrollX(AccessibilityRecord r0) {
        return Api15Impl.getMaxScrollX(r0);
    }

    @Deprecated
    public void setMaxScrollX(int r1) {
        setMaxScrollX(this.mRecord, r1);
    }

    public static void setMaxScrollX(AccessibilityRecord r0, int r1) {
        Api15Impl.setMaxScrollX(r0, r1);
    }

    @Deprecated
    public int getMaxScrollY() {
        return getMaxScrollY(this.mRecord);
    }

    public static int getMaxScrollY(AccessibilityRecord r0) {
        return Api15Impl.getMaxScrollY(r0);
    }

    @Deprecated
    public void setMaxScrollY(int r1) {
        setMaxScrollY(this.mRecord, r1);
    }

    public static void setMaxScrollY(AccessibilityRecord r0, int r1) {
        Api15Impl.setMaxScrollY(r0, r1);
    }

    @Deprecated
    public int getAddedCount() {
        return this.mRecord.getAddedCount();
    }

    @Deprecated
    public void setAddedCount(int r1) {
        this.mRecord.setAddedCount(r1);
    }

    @Deprecated
    public int getRemovedCount() {
        return this.mRecord.getRemovedCount();
    }

    @Deprecated
    public void setRemovedCount(int r1) {
        this.mRecord.setRemovedCount(r1);
    }

    @Deprecated
    public CharSequence getClassName() {
        return this.mRecord.getClassName();
    }

    @Deprecated
    public void setClassName(CharSequence r1) {
        this.mRecord.setClassName(r1);
    }

    @Deprecated
    public List<CharSequence> getText() {
        return this.mRecord.getText();
    }

    @Deprecated
    public CharSequence getBeforeText() {
        return this.mRecord.getBeforeText();
    }

    @Deprecated
    public void setBeforeText(CharSequence r1) {
        this.mRecord.setBeforeText(r1);
    }

    @Deprecated
    public CharSequence getContentDescription() {
        return this.mRecord.getContentDescription();
    }

    @Deprecated
    public void setContentDescription(CharSequence r1) {
        this.mRecord.setContentDescription(r1);
    }

    @Deprecated
    public Parcelable getParcelableData() {
        return this.mRecord.getParcelableData();
    }

    @Deprecated
    public void setParcelableData(Parcelable r1) {
        this.mRecord.setParcelableData(r1);
    }

    @Deprecated
    public void recycle() {
        this.mRecord.recycle();
    }

    @Deprecated
    public int hashCode() {
        AccessibilityRecord r0 = this.mRecord;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    @Deprecated
    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof AccessibilityRecordCompat) == true) goto L8;
        return false;
    L8:
        AccessibilityRecordCompat r5 = (AccessibilityRecordCompat) r4;
        AccessibilityRecord r3 = this.mRecord;
        if (r3 != null) goto L16;
        if (r5.mRecord != null) goto L14;
        return true;
    L14:
        return false;
    L16:
        return r3.equals(r5.mRecord);
    }
}
