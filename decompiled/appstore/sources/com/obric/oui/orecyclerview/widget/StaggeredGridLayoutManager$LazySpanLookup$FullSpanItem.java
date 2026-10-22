package com.obric.oui.orecyclerview.widget;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"BanParcelableUsage"})
class StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem implements Parcelable {
    public static final Parcelable.Creator<StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> CREATOR = null;
    int mGapDir;
    int[] mGapPerSpan;
    boolean mHasUnwantedGapAfter;
    int mPosition;

    public class a implements Parcelable.Creator {
        public a() {
        }

        public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem a(Parcel r10) {
            return new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem(r10);
        }

        public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem[] b(int r10) {
            return new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem[r10];
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

    public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem(Parcel r10) {
        this.mPosition = r10.readInt();
        this.mGapDir = r10.readInt();
        boolean r11 = true;
        if (r10.readInt() == 1) goto L6;
        r11 = false;
    L6:
        this.mHasUnwantedGapAfter = r11;
        int r12 = r10.readInt();
        if (r12 <= 0) goto L10;
        int[] r13 = new int[r12];
        this.mGapPerSpan = r13;
        r10.readIntArray(r13);
        return;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getGapForSpan(int r10) {
        int[] r11 = this.mGapPerSpan;
        if (r11 != null) goto L6;
        return 0;
    L6:
        return r11[r10];
    }

    public String toString() {
        return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.mGapDir + ", mHasUnwantedGapAfter=" + this.mHasUnwantedGapAfter + ", mGapPerSpan=" + Arrays.toString(this.mGapPerSpan) + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeInt(this.mPosition);
        r10.writeInt(this.mGapDir);
        r10.writeInt(this.mHasUnwantedGapAfter ? 1 : 0);
        int[] r12 = this.mGapPerSpan;
        if (r12 != null) goto L5;
    L7:
        r10.writeInt(0);
        return;
    L5:
        if (r12.length <= 0) goto L7;
        r10.writeInt(r12.length);
        r10.writeIntArray(this.mGapPerSpan);
    }

    public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem() {
    }
}
