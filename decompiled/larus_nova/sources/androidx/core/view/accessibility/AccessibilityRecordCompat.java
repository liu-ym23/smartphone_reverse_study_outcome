package androidx.core.view.accessibility;

import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.ReplaceWith;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public class AccessibilityRecordCompat {
    private final AccessibilityRecord mRecord;

    public static AccessibilityRecordCompat obtain() {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain());
    }

    public int getAddedCount() {
        return this.mRecord.getAddedCount();
    }

    public CharSequence getBeforeText() {
        return this.mRecord.getBeforeText();
    }

    public CharSequence getClassName() {
        return this.mRecord.getClassName();
    }

    public CharSequence getContentDescription() {
        return this.mRecord.getContentDescription();
    }

    public int getCurrentItemIndex() {
        return this.mRecord.getCurrentItemIndex();
    }

    public int getFromIndex() {
        return this.mRecord.getFromIndex();
    }

    public int getItemCount() {
        return this.mRecord.getItemCount();
    }

    public int getMaxScrollX() {
        return getMaxScrollX(this.mRecord);
    }

    public int getMaxScrollY() {
        return getMaxScrollY(this.mRecord);
    }

    public Parcelable getParcelableData() {
        return this.mRecord.getParcelableData();
    }

    public int getRemovedCount() {
        return this.mRecord.getRemovedCount();
    }

    public int getScrollX() {
        return this.mRecord.getScrollX();
    }

    public int getScrollY() {
        return this.mRecord.getScrollY();
    }

    public AccessibilityNodeInfoCompat getSource() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mRecord.getSource());
    }

    public List<CharSequence> getText() {
        return this.mRecord.getText();
    }

    public int getToIndex() {
        return this.mRecord.getToIndex();
    }

    public int getWindowId() {
        return this.mRecord.getWindowId();
    }

    public int hashCode() {
        AccessibilityRecord r100 = this.mRecord;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public boolean isChecked() {
        return this.mRecord.isChecked();
    }

    public boolean isEnabled() {
        return this.mRecord.isEnabled();
    }

    public boolean isFullScreen() {
        return this.mRecord.isFullScreen();
    }

    public boolean isPassword() {
        return this.mRecord.isPassword();
    }

    public boolean isScrollable() {
        return this.mRecord.isScrollable();
    }

    public void recycle() {
        this.mRecord.recycle();
    }

    public Object getImpl() {
        return this.mRecord;
    }

    public AccessibilityRecordCompat(Object r100) {
        this.mRecord = (AccessibilityRecord) r100;
    }

    @ReplaceWith(expression = "record.getMaxScrollX()")
    public static int getMaxScrollX(AccessibilityRecord r100) {
        return r100.getMaxScrollX();
    }

    @ReplaceWith(expression = "record.getMaxScrollY()")
    public static int getMaxScrollY(AccessibilityRecord r100) {
        return r100.getMaxScrollY();
    }

    public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat r100) {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain(r100.mRecord));
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AccessibilityRecordCompat) == true) goto L8;
        return false;
    L8:
        AccessibilityRecordCompat r101 = (AccessibilityRecordCompat) r100;
        AccessibilityRecord r102 = this.mRecord;
        if (r102 != null) goto L16;
        if (r101.mRecord == null) goto L17;
        return false;
    L17:
        return true;
    L16:
        return r102.equals(r101.mRecord);
    }

    public void setAddedCount(int r100) {
        this.mRecord.setAddedCount(r100);
    }

    public void setBeforeText(CharSequence r100) {
        this.mRecord.setBeforeText(r100);
    }

    public void setChecked(boolean r100) {
        this.mRecord.setChecked(r100);
    }

    public void setClassName(CharSequence r100) {
        this.mRecord.setClassName(r100);
    }

    public void setContentDescription(CharSequence r100) {
        this.mRecord.setContentDescription(r100);
    }

    public void setCurrentItemIndex(int r100) {
        this.mRecord.setCurrentItemIndex(r100);
    }

    public void setEnabled(boolean r100) {
        this.mRecord.setEnabled(r100);
    }

    public void setFromIndex(int r100) {
        this.mRecord.setFromIndex(r100);
    }

    public void setFullScreen(boolean r100) {
        this.mRecord.setFullScreen(r100);
    }

    public void setItemCount(int r100) {
        this.mRecord.setItemCount(r100);
    }

    public void setMaxScrollX(int r100) {
        setMaxScrollX(this.mRecord, r100);
    }

    public void setMaxScrollY(int r100) {
        setMaxScrollY(this.mRecord, r100);
    }

    public void setParcelableData(Parcelable r100) {
        this.mRecord.setParcelableData(r100);
    }

    public void setPassword(boolean r100) {
        this.mRecord.setPassword(r100);
    }

    public void setRemovedCount(int r100) {
        this.mRecord.setRemovedCount(r100);
    }

    public void setScrollX(int r100) {
        this.mRecord.setScrollX(r100);
    }

    public void setScrollY(int r100) {
        this.mRecord.setScrollY(r100);
    }

    public void setScrollable(boolean r100) {
        this.mRecord.setScrollable(r100);
    }

    public void setSource(View r100) {
        this.mRecord.setSource(r100);
    }

    public void setToIndex(int r100) {
        this.mRecord.setToIndex(r100);
    }

    @ReplaceWith(expression = "record.setMaxScrollX(maxScrollX)")
    public static void setMaxScrollX(AccessibilityRecord r100, int r101) {
        r100.setMaxScrollX(r101);
    }

    @ReplaceWith(expression = "record.setMaxScrollY(maxScrollY)")
    public static void setMaxScrollY(AccessibilityRecord r100, int r101) {
        r100.setMaxScrollY(r101);
    }

    public void setSource(View r100, int r101) {
        setSource(this.mRecord, r100, r101);
    }

    @ReplaceWith(expression = "record.setSource(root, virtualDescendantId)")
    public static void setSource(AccessibilityRecord r100, View r101, int r102) {
        r100.setSource(r101, r102);
    }
}
