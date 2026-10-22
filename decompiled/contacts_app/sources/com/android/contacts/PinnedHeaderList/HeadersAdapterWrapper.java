package com.android.contacts.PinnedHeaderList;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import com.android.contacts.list.ContactsListBaseAdapter;

/* JADX INFO: loaded from: classes.dex */
final class HeadersAdapterWrapper extends BaseAdapter {
    private final Context context;
    final HeadersAdapter delegate;
    private Drawable divider;
    private int dividerHeight;
    private OnHeaderClickListener onHeaderClickListener;

    public interface OnHeaderClickListener {
        void onHeaderClick(View r1, int r2, long r3);
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ View getView(int r1, View r2, ViewGroup r3) {
        return getView(r1, r2, r3);
    }

    HeadersAdapterWrapper(Context r1, HeadersAdapter r2) {
        this.context = r1;
        this.delegate = r2;
    }

    void setDivider(Drawable r1) {
        this.divider = r1;
    }

    void setDividerHeight(int r1) {
        this.dividerHeight = r1;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.delegate.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int r1) {
        return this.delegate.isEnabled(r1);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver r1) {
        this.delegate.registerDataSetObserver(r1);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver r1) {
        this.delegate.unregisterDataSetObserver(r1);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.delegate.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int r1) {
        return this.delegate.getItem(r1);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return this.delegate.getItemId(r1);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.delegate.hasStableIds();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int r1) {
        return this.delegate.getItemViewType(r1);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.delegate.getViewTypeCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    private View configureHeader(WrapperView r2, int r3) {
        View r0 = r2.header;
        View r1 = this.delegate.getHeaderView(r3, r0, r2);
        if (r1 == null) goto L7;
        r1.setClickable(true);
        r1.setOnClickListener(null);
        return r1;
    L7:
        throw new NullPointerException("Header view must not be null.");
    }

    private boolean previousPositionHasSameHeader(int r4) {
        if (r4 != 0) goto L4;
    L6:
        return false;
    L4:
        if (this.delegate.getHeaderId(r4) != this.delegate.getHeaderId(r4 - 1)) goto L6;
        return true;
    }

    @Override // android.widget.Adapter
    public WrapperView getView(int r3, View r4, ViewGroup r5) {
        if (r4 != null) goto L4;
        WrapperView r6 = new WrapperView(this.context);
    L5:
        View r7 = this.delegate.getView(r3, r6.item, r6);
        if (previousPositionHasSameHeader(r3) == true) goto L8;
        View r8 = configureHeader(r6, r3);
    L9:
        boolean r0 = r7 instanceof Checkable;
        if (r0 == true) goto L12;
    L14:
        if (r0 == false) goto L16;
    L18:
        r6.update(r7, r8, this.divider, this.dividerHeight);
        HeadersAdapter r2 = this.delegate;
        if ((r2 instanceof ContactsListBaseAdapter) == true) goto L21;
    L23:
        return r6;
    L21:
        if (((ContactsListBaseAdapter) r2).isEditMode() == true) goto L23;
        r6.item.setTranslationX(0.0f);
        r6.setTranslationX(0.0f);
        goto L23
    L16:
        if ((r6 instanceof CheckableWrapperView) == false) goto L18;
        r6 = new WrapperView(this.context);
        goto L18
    L12:
        if ((r6 instanceof CheckableWrapperView) == true) goto L14;
        r6 = new CheckableWrapperView(this.context);
        goto L18
    L8:
        r8 = null;
        goto L9
    L4:
        r6 = (WrapperView) r4;
        goto L5
    }

    public void setOnHeaderClickListener(OnHeaderClickListener r1) {
        this.onHeaderClickListener = r1;
    }
}
