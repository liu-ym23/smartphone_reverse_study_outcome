package com.android.contacts.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.android.contacts.R;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.util.StreamItemEntry;
import com.google.android.collect.Lists;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StreamItemAdapter extends BaseAdapter {
    private static final int ITEM_VIEW_TYPE_HEADER = 0;
    private static final int ITEM_VIEW_TYPE_STREAM_ITEM = 1;
    private final Context mContext;
    private final LayoutInflater mInflater;
    private final View.OnClickListener mItemClickListener;
    private final View.OnClickListener mPhotoClickListener;
    private List<StreamItemEntry> mStreamItems;

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        if (r1 != 0) goto L6;
        return -1;
    L6:
        return r1 - 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int r1) {
        if (r1 != 0) goto L5;
        return 0;
    L5:
        return 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int r1) {
        return false;
    }

    public StreamItemAdapter(Context r1, View.OnClickListener r2, View.OnClickListener r3) {
        this.mContext = r1;
        this.mItemClickListener = r2;
        this.mPhotoClickListener = r3;
        this.mInflater = (LayoutInflater) r1.getSystemService("layout_inflater");
        this.mStreamItems = Lists.newArrayList();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int r0 = this.mStreamItems.size();
        if (r0 != 0) goto L6;
        return 0;
    L6:
        return r0 + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int r1) {
        if (r1 != 0) goto L6;
        return null;
    L6:
        return this.mStreamItems.get(r1 - 1);
    }

    @Override // android.widget.Adapter
    public View getView(int r4, View r5, ViewGroup r6) {
        if (r4 == 0) goto L5;
        StreamItemEntry r7 = (StreamItemEntry) getItem(r4);
        AccountType r8 = AccountTypeManager.getInstance(this.mContext).getAccountType(r7.getAccountType(), r7.getDataSet());
        LayoutInflater r0 = this.mInflater;
        Context r1 = this.mContext;
        if (r8.getViewStreamItemPhotoActivity() != null) goto L9;
        View.OnClickListener r2 = null;
    L10:
        View r3 = ContactDetailDisplayUtils.createStreamItemView(r0, r1, r7, null, r2);
        View r9 = r3.findViewById(R.id.stream_item_content);
        if (r8.getViewStreamItemActivity() == null) goto L13;
        r9.setTag(r7);
        r9.setFocusable(true);
        r9.setOnClickListener(this.mItemClickListener);
        r9.setEnabled(true);
    L14:
        return r3;
    L13:
        r9.setTag(null);
        r9.setFocusable(false);
        r9.setOnClickListener(null);
        r9.setClickable(false);
        r9.setEnabled(false);
        goto L14
    L9:
        r2 = this.mPhotoClickListener;
        goto L10
    L5:
        return this.mInflater.inflate(R.layout.updates_header_contact, null);
    }

    public void setStreamItems(List<StreamItemEntry> r1) {
        this.mStreamItems = r1;
        notifyDataSetChanged();
    }
}
