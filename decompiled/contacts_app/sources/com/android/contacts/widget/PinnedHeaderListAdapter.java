package com.android.contacts.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SectionIndexer;
import com.android.common.widget.CompositeCursorAdapter;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PinnedHeaderListAdapter extends CompositeCursorAdapter implements PinnedHeaderListView.PinnedHeaderAdapter {
    public static final int PARTITION_HEADER_TYPE = 0;
    private boolean[] mHeaderVisibility;
    private SectionIndexer mIndexer;
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
        if (this.mPinnedPartitionHeadersEnabled == true) goto L5;
    L9:
        return false;
    L5:
        if (hasHeader(r2) == false) goto L9;
        if (isPartitionEmpty(r2) == true) goto L9;
        return true;
    }

    @Override // com.android.contacts.widget.PinnedHeaderListView.PinnedHeaderAdapter
    public void setIndexer1(SectionIndexer r1) {
        this.mIndexer = r1;
    }

    public SectionIndexer getIndexer() {
        return this.mIndexer;
    }

    public View getPinnedHeaderView(int r3, View r4, ViewGroup r5) {
        if (hasHeader(r3) == false) goto L15;
        if (r4 == null) goto L10;
        Integer r0 = (Integer) r4.getTag();
        if (r0 == null) goto L10;
        if (r0.intValue() != 0) goto L10;
    L11:
        if (r4 != null) goto L13;
        r4 = newHeaderView(getContext(), r3, null, r5);
        r4.setTag(0);
        r4.setFocusable(false);
        r4.setEnabled(false);
    L13:
        bindHeaderView(r4, r3, getCursor(r3));
        return r4;
    L10:
        r4 = null;
        goto L11
    L15:
        return null;
    }

    public void configurePinnedHeaders(PinnedHeaderListView r12) {
        if (this.mPinnedPartitionHeadersEnabled == true) goto L5;
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
        r12.setHeaderInvisible(r2, true);
    L16:
        r2 = r2 + 1;
        goto L12
    L17:
        int r3 = r12.getHeaderViewsCount();
        int r5 = 0;
        int r6 = 0;
        int r7 = -1;
    L18:
        if (r5 >= r0) goto L26;
        if (this.mHeaderVisibility[r5] == false) goto L25;
        if (r5 > getPartitionForPosition(r12.getPositionAt(r6) - r3)) goto L26;
        r12.setHeaderPinnedAtTop(r5, r6, false);
        r6 = r6 + r12.getPinnedHeaderHeight(r5);
        r7 = r5;
    L25:
        r5 = r5 + 1;
    L26:
        int r8 = r12.getHeight();
        int r9 = r0;
        int r10 = 0;
    L27:
        r0 = r0 - 1;
        if (r0 <= r7) goto L43;
        if (this.mHeaderVisibility[r0] == false) goto L27;
        int r11 = r12.getPositionAt(r8 - r10) - r3;
        if (r11 < 0) goto L43;
        int r13 = getPartitionForPosition(r11 - 1);
        if (r13 == (-1)) goto L43;
        if (r0 <= r13) goto L43;
        r10 = r10 + r12.getPinnedHeaderHeight(r0);
        if (r11 >= getPositionForPartition(r0)) goto L41;
        boolean r14 = true;
    L42:
        r12.setHeaderPinnedAtBottom(r0, r8 - r10, r14);
        r9 = r0;
        goto L27
    L41:
        r14 = false;
    L43:
        int r15 = r7 + 1;
    L44:
        if (r15 >= r9) goto L49;
        if (this.mHeaderVisibility[r15] == false) goto L48;
        r12.setHeaderInvisible(r15, isPartitionEmpty(r15));
    L48:
        r15 = r15 + 1;
        goto L44
    L49:
        return;
    L8:
        if (r1.length == r0) goto L10;
        goto L9
    }

    @Override // com.android.contacts.widget.PinnedHeaderListView.PinnedHeaderAdapter
    public int getScrollPositionForHeader(int r1) {
        return getPositionForPartition(r1);
    }
}
