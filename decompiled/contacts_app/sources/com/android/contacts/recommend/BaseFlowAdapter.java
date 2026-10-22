package com.android.contacts.recommend;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.android.contacts.R;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseFlowAdapter extends BaseAdapter {
    public static final int HEAD = 0;
    public static final int ITEM = 1;
    private static final int VIEW_TYPE_COUNT = 2;
    private Context mContext;
    private int mHeadIndex;
    private final int mHorizontalSpace;
    private LayoutInflater mInflater;
    private final int mLeftRightPadding;
    private int mListDataPos;
    private final int mTopBottomPadding;

    public static class FlowEntry implements Parcelable {
        public static final Parcelable.Creator<FlowEntry> CREATOR = null;
        private final int itemType;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getHeadIndex() {
            return -1;
        }

        public FlowEntry(int r1) {
            this.itemType = r1;
        }

        public FlowEntry(Parcel r1) {
            this.itemType = r1.readInt();
        }

        public int getItemType() {
            return this.itemType;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeInt(this.itemType);
        }
    }

    abstract void bindHeadView(View r1, int r2);

    abstract void bindItemView(View r1, int r2, int r3);

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    abstract View newHeadView(LayoutInflater r1, ViewGroup r2);

    abstract View newItemView(LayoutInflater r1, ViewGroup r2);

    public BaseFlowAdapter(Context r2) {
        this.mListDataPos = 0;
        this.mContext = r2;
        this.mInflater = (LayoutInflater) r2.getSystemService("layout_inflater");
        this.mLeftRightPadding = this.mContext.getResources().getDimensionPixelSize(R.dimen.recommend_item_left_right_padding);
        this.mTopBottomPadding = this.mContext.getResources().getDimensionPixelSize(R.dimen.recommend_item_top_bottom_padding);
        this.mHorizontalSpace = this.mContext.getResources().getDimensionPixelSize(R.dimen.recommend_item_space);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver r1) {
        super.registerDataSetObserver(r1);
        restoreInitPos();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        restoreInitPos();
        super.notifyDataSetChanged();
    }

    private void restoreInitPos() {
        this.mListDataPos = 0;
    }

    private void restoreInitPosIfNeed() {
        if (this.mListDataPos < getCount()) goto L6;
        restoreInitPos();
        return;
    }

    @Override // android.widget.Adapter
    public View getView(int r11, View r12, ViewGroup r13) {
        restoreInitPosIfNeed();
        int r0 = getItemViewType(r11);
        if (r0 == 0) goto L21;
        if (r0 != 1) goto L29;
        int r14 = this.mLeftRightPadding;
        int r15 = this.mTopBottomPadding;
        int r1 = this.mHorizontalSpace;
        LinearLayout r2 = new LinearLayout(this.mContext);
        int r3 = r13.getWidth() - (this.mLeftRightPadding * 2);
        int r5 = 0;
    L8:
        if (this.mListDataPos >= getCount()) goto L28;
        if (((FlowEntry) getItem(this.mListDataPos)).getItemType() != 1) goto L28;
        if (r5 != 0) goto L13;
        r2.setPadding(r14, r15, r14, r15);
    L13:
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(-2, -2);
        View r7 = newItemView(this.mInflater, r13);
        bindItemView(r7, this.mHeadIndex, this.mListDataPos);
        r7.measure(0, 0);
        int r8 = r7.getMeasuredWidth();
        if (((r5 + r8) + r1) > r3) goto L15;
        if (r5 <= 0) goto L19;
        r6.leftMargin = r1;
    L19:
        r2.addView(r7, r6);
        r5 = r5 + (r8 + r1);
        this.mListDataPos++;
        goto L8
    L15:
        if (r5 > 0) goto L28;
        r2.addView(r7, r6);
        this.mListDataPos++;
    L28:
        return r2;
    L29:
        return r12;
    L21:
        View r16 = newHeadView(this.mInflater, r13);
        bindHeadView(r16, r11);
        this.mHeadIndex = ((FlowEntry) getItem(r11)).getHeadIndex();
        this.mListDataPos++;
        return r16;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int r1) {
        return ((FlowEntry) getItem(r1)).getItemType();
    }
}
