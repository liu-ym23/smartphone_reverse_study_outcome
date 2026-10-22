package com.android.contacts.common.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.android.common.widget.CompositeCursorAdapter;

/* JADX INFO: loaded from: classes.dex */
public abstract class PinnedHeaderListAdapter extends CompositeCursorAdapter implements PinnedHeaderListView.PinnedHeaderAdapter {
    public static final int PARTITION_HEADER_TYPE = 0;
    private boolean[] mHeaderVisibility;
    private boolean mPinnedPartitionHeadersEnabled;

    public PinnedHeaderListAdapter(Context r1) {
        super(r1);
    }

    public PinnedHeaderListAdapter(Context r1, int r2) {
        super(r1, r2);
    }

    public boolean getPinnedPartitionHeadersEnabled() {
        return this.mPinnedPartitionHeadersEnabled;
    }

    public void setPinnedPartitionHeadersEnabled(boolean r1) {
        this.mPinnedPartitionHeadersEnabled = r1;
    }

    public int getPinnedHeaderCount() {
        if (this.mPinnedPartitionHeadersEnabled == true) goto L5;
        return 0;
    L5:
        return getPartitionCount();
    }

    protected boolean isPinnedPartitionHeaderVisible(int r2) {
        if (getPinnedPartitionHeadersEnabled() == true) goto L5;
    L9:
        return false;
    L5:
        if (hasHeader(r2) == false) goto L9;
        if (isPartitionEmpty(r2) == true) goto L9;
        return true;
    }

    public View getPinnedHeaderView(int r3, View r4, ViewGroup r5) {
        if (hasHeader(r3) == false) goto L12;
        if (r4 == null) goto L8;
        Integer r6 = (Integer) r4.getTag();
        if (r6 == null) goto L8;
        r6.intValue();
    L8:
        View r7 = newHeaderView(getContext(), r3, null, r5);
        if (r7 == null) goto L11;
        r7.setTag(0);
        r7.setFocusable(false);
        r7.setEnabled(false);
        bindHeaderView(r7, r3, getCursor(r3));
        r7.setLayoutDirection(r5.getLayoutDirection());
    L11:
        return r7;
    L12:
        return null;
    }

    public void configurePinnedHeaders(PinnedHeaderListView r11) {
        if (getPinnedPartitionHeadersEnabled() == true) goto L5;
        return;
    L5:
        int r0 = getPartitionCount();
        boolean[] r1 = this.mHeaderVisibility;
        if (r1 != null) goto L8;
    L9:
        this.mHeaderVisibility = new boolean[r0];
    L10:
        int r2 = 0;
    L12:
        if (r2 >= r0) goto L17;
        boolean r4 = isPinnedPartitionHeaderVisible(r2);
        this.mHeaderVisibility[r2] = r4;
        if (r4 == true) goto L16;
        r11.setHeaderInvisible(r2, true);
    L16:
        r2 = r2 + 1;
        goto L12
    L17:
        int r3 = r11.getHeaderViewsCount();
        int r5 = 0;
        int r6 = 0;
        int r7 = -1;
    L18:
        if (r5 >= r0) goto L26;
        if (this.mHeaderVisibility[r5] == false) goto L25;
        if (r5 > getPartitionForPosition(r11.getPositionAt(r6) - r3)) goto L26;
        r11.setHeaderPinnedAtTop(r5, r6, false);
        r6 = r6 + r11.getPinnedHeaderHeight(r5);
        r7 = r5;
    L25:
        r5 = r5 + 1;
    L26:
        int r8 = r11.getHeight();
        int r9 = r0;
        int r10 = 0;
    L27:
        r0 = r0 - 1;
        if (r0 <= r7) goto L39;
        if (this.mHeaderVisibility[r0] == false) goto L27;
        int r12 = r11.getPositionAt(r8 - r10) - r3;
        if (r12 < 0) goto L39;
        int r13 = getPartitionForPosition(r12 - 1);
        if (r13 == (-1)) goto L39;
        if (r0 <= r13) goto L39;
        r10 = r10 + r11.getPinnedHeaderHeight(r0);
        r11.setHeaderPinnedAtBottom(r0, r8 - r10, false);
        r9 = r0;
    L39:
        int r14 = r7 + 1;
    L40:
        if (r14 >= r9) goto L45;
        if (this.mHeaderVisibility[r14] == false) goto L44;
        r11.setHeaderInvisible(r14, isPartitionEmpty(r14));
    L44:
        r14 = r14 + 1;
        goto L40
    L45:
        return;
    L8:
        if (r1.length == r0) goto L10;
        goto L9
    }

    @Override // com.android.contacts.common.list.PinnedHeaderListView.PinnedHeaderAdapter
    public int getScrollPositionForHeader(int r1) {
        return getPositionForPartition(r1);
    }
}
