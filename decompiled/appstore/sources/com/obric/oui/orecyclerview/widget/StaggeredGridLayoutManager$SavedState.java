package com.obric.oui.orecyclerview.widget;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class StaggeredGridLayoutManager$SavedState implements Parcelable {
    public static final Parcelable.Creator<StaggeredGridLayoutManager$SavedState> CREATOR = null;
    boolean mAnchorLayoutFromEnd;
    int mAnchorPosition;
    List<StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> mFullSpanItems;
    boolean mLastLayoutRTL;
    boolean mReverseLayout;
    int[] mSpanLookup;
    int mSpanLookupSize;
    int[] mSpanOffsets;
    int mSpanOffsetsSize;
    int mVisibleAnchorPosition;

    public class a implements Parcelable.Creator {
        public a() {
        }

        public StaggeredGridLayoutManager$SavedState a(Parcel r10) {
            return new StaggeredGridLayoutManager$SavedState(r10);
        }

        public StaggeredGridLayoutManager$SavedState[] b(int r10) {
            return new StaggeredGridLayoutManager$SavedState[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a();
    }

    public StaggeredGridLayoutManager$SavedState() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void invalidateAnchorPositionInfo() {
        this.mSpanOffsets = null;
        this.mSpanOffsetsSize = 0;
        this.mAnchorPosition = -1;
        this.mVisibleAnchorPosition = -1;
    }

    public void invalidateSpanInfo() {
        this.mSpanOffsets = null;
        this.mSpanOffsetsSize = 0;
        this.mSpanLookupSize = 0;
        this.mSpanLookup = null;
        this.mFullSpanItems = null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeInt(this.mAnchorPosition);
        r10.writeInt(this.mVisibleAnchorPosition);
        r10.writeInt(this.mSpanOffsetsSize);
        if (this.mSpanOffsetsSize <= 0) goto L5;
        r10.writeIntArray(this.mSpanOffsets);
    L5:
        r10.writeInt(this.mSpanLookupSize);
        if (this.mSpanLookupSize <= 0) goto L8;
        r10.writeIntArray(this.mSpanLookup);
    L8:
        r10.writeInt(this.mReverseLayout ? 1 : 0);
        r10.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
        r10.writeInt(this.mLastLayoutRTL ? 1 : 0);
        r10.writeList(this.mFullSpanItems);
    }

    public StaggeredGridLayoutManager$SavedState(Parcel r10) {
        this.mAnchorPosition = r10.readInt();
        this.mVisibleAnchorPosition = r10.readInt();
        int r11 = r10.readInt();
        this.mSpanOffsetsSize = r11;
        if (r11 <= 0) goto L5;
        int[] r12 = new int[r11];
        this.mSpanOffsets = r12;
        r10.readIntArray(r12);
    L5:
        int r13 = r10.readInt();
        this.mSpanLookupSize = r13;
        if (r13 <= 0) goto L8;
        int[] r14 = new int[r13];
        this.mSpanLookup = r14;
        r10.readIntArray(r14);
    L8:
        boolean r15 = false;
        if (r10.readInt() != 1) goto L11;
        boolean r16 = true;
    L12:
        this.mReverseLayout = r16;
        if (r10.readInt() != 1) goto L15;
        boolean r17 = true;
    L16:
        this.mAnchorLayoutFromEnd = r17;
        if (r10.readInt() != 1) goto L19;
        r15 = true;
    L19:
        this.mLastLayoutRTL = r15;
        this.mFullSpanItems = r10.readArrayList(StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem.class.getClassLoader());
        return;
    L15:
        r17 = false;
        goto L16
    L11:
        r16 = false;
        goto L12
    }

    public StaggeredGridLayoutManager$SavedState(StaggeredGridLayoutManager$SavedState r10) {
        this.mSpanOffsetsSize = r10.mSpanOffsetsSize;
        this.mAnchorPosition = r10.mAnchorPosition;
        this.mVisibleAnchorPosition = r10.mVisibleAnchorPosition;
        this.mSpanOffsets = r10.mSpanOffsets;
        this.mSpanLookupSize = r10.mSpanLookupSize;
        this.mSpanLookup = r10.mSpanLookup;
        this.mReverseLayout = r10.mReverseLayout;
        this.mAnchorLayoutFromEnd = r10.mAnchorLayoutFromEnd;
        this.mLastLayoutRTL = r10.mLastLayoutRTL;
        this.mFullSpanItems = r10.mFullSpanItems;
    }
}
