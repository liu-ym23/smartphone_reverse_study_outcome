package com.android.contacts.common.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SectionIndexer;
import com.android.contacts.util.HanziToPinyin;

/* JADX INFO: loaded from: classes.dex */
public abstract class IndexerListAdapter extends PinnedHeaderListAdapter implements SectionIndexer {
    protected Context mContext;
    private View mHeader;
    private int mIndexedPartition;
    private SectionIndexer mIndexer;
    private Placement mPlacementCache;
    private boolean mSectionHeaderDisplayEnabled;

    public static final class Placement {
        public boolean firstInSection;
        public boolean lastInSection;
        private int position;
        public String sectionHeader;

        public Placement() {
            this.position = -1;
        }

        static /* synthetic */ int access$000(Placement r0) {
            return r0.position;
        }

        static /* synthetic */ int access$002(Placement r0, int r1) {
            r0.position = r1;
            return r1;
        }

        public void invalidate() {
            this.position = -1;
        }
    }

    protected abstract View createPinnedSectionHeaderView(Context r1, ViewGroup r2);

    protected abstract void setPinnedSectionTitle(View r1, String r2);

    public IndexerListAdapter(Context r2) {
        super(r2);
        this.mIndexedPartition = 0;
        this.mPlacementCache = new Placement();
        this.mContext = r2;
    }

    public boolean isSectionHeaderDisplayEnabled() {
        return this.mSectionHeaderDisplayEnabled;
    }

    public void setSectionHeaderDisplayEnabled(boolean r1) {
        this.mSectionHeaderDisplayEnabled = r1;
    }

    public int getIndexedPartition() {
        return this.mIndexedPartition;
    }

    public void setIndexedPartition(int r1) {
        this.mIndexedPartition = r1;
    }

    public SectionIndexer getIndexer() {
        return this.mIndexer;
    }

    public void setIndexer(SectionIndexer r1) {
        this.mIndexer = r1;
        this.mPlacementCache.invalidate();
    }

    @Override // android.widget.SectionIndexer
    public Object[] getSections() {
        SectionIndexer r0 = this.mIndexer;
        if (r0 != null) goto L7;
        return new String[]{HanziToPinyin.Token.SEPARATOR};
    L7:
        return r0.getSections();
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int r1) {
        SectionIndexer r0 = this.mIndexer;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getPositionForSection(r1);
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int r1) {
        SectionIndexer r0 = this.mIndexer;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getSectionForPosition(r1);
    }

    @Override // com.android.contacts.common.list.PinnedHeaderListAdapter, com.android.contacts.common.list.PinnedHeaderListView.PinnedHeaderAdapter
    public int getPinnedHeaderCount() {
        if (isSectionHeaderDisplayEnabled() == false) goto L7;
        return super.getPinnedHeaderCount() + 1;
    L7:
        return super.getPinnedHeaderCount();
    }

    @Override // com.android.contacts.common.list.PinnedHeaderListAdapter, com.android.contacts.common.list.PinnedHeaderListView.PinnedHeaderAdapter
    public View getPinnedHeaderView(int r2, View r3, ViewGroup r4) {
        if (isSectionHeaderDisplayEnabled() == false) goto L12;
        if (r2 != (getPinnedHeaderCount() - 1)) goto L12;
        if (this.mHeader != null) goto L10;
        this.mHeader = createPinnedSectionHeaderView(this.mContext, r4);
    L10:
        return this.mHeader;
    L12:
        return super.getPinnedHeaderView(r2, r3, r4);
    }

    @Override // com.android.contacts.common.list.PinnedHeaderListAdapter, com.android.contacts.common.list.PinnedHeaderListView.PinnedHeaderAdapter
    public void configurePinnedHeaders(PinnedHeaderListView r9) {
        super.configurePinnedHeaders(r9);
        if (isSectionHeaderDisplayEnabled() == true) goto L5;
        return;
    L5:
        boolean r1 = true;
        int r0 = getPinnedHeaderCount() - 1;
        if (this.mIndexer != null) goto L8;
    L29:
        r9.setHeaderInvisible(r0, false);
        return;
    L8:
        if (getCount() == 0) goto L29;
        int r2 = r9.getPositionAt(r9.getTotalTopPinnedHeaderHeight());
        int r4 = r2 - r9.getHeaderViewsCount();
        if (getPartitionForPosition(r4) != this.mIndexedPartition) goto L15;
        int r5 = getOffsetInPartition(r4);
        if (r5 == (-1)) goto L15;
        int r6 = getSectionForPosition(r5);
    L16:
        if (r6 != (-1)) goto L18;
        r9.setHeaderInvisible(r0, false);
        return;
    L18:
        View r7 = r9.getChildAt(r2);
        if (r7 == null) goto L21;
        this.mHeader.setMinimumHeight(r7.getMeasuredHeight());
    L21:
        setPinnedSectionTitle(this.mHeader, (String) this.mIndexer.getSections()[r6]);
        int r8 = getPositionForPartition(this.mIndexedPartition);
        if (hasHeader(this.mIndexedPartition) == false) goto L25;
        r8 = r8 + 1;
    L25:
        if (r4 == ((r8 + getPositionForSection(r6 + 1)) - 1)) goto L28;
        r1 = false;
    L28:
        r9.setFadingHeader(r0, r2, r1);
        return;
    L15:
        r6 = -1;
        goto L16
    }

    public Placement getItemPlacementInSection(int r6) {
        if (Placement.access$000(this.mPlacementCache) == r6) goto L5;
        Placement.access$002(this.mPlacementCache, r6);
        boolean r2 = false;
        if (isSectionHeaderDisplayEnabled() == false) goto L18;
        int r0 = getSectionForPosition(r6);
        if (r0 != (-1)) goto L11;
    L13:
        this.mPlacementCache.firstInSection = false;
        this.mPlacementCache.sectionHeader = null;
    L14:
        Placement r1 = this.mPlacementCache;
        if ((getPositionForSection(r0 + 1) - 1) != r6) goto L17;
        r2 = true;
    L17:
        r1.lastInSection = r2;
    L20:
        return this.mPlacementCache;
    L11:
        if (getPositionForSection(r0) != r6) goto L13;
        this.mPlacementCache.firstInSection = true;
        this.mPlacementCache.sectionHeader = (String) getSections()[r0];
        goto L14
    L18:
        this.mPlacementCache.firstInSection = false;
        this.mPlacementCache.lastInSection = false;
        this.mPlacementCache.sectionHeader = null;
        goto L20
    L5:
        return this.mPlacementCache;
    }
}
