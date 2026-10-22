package com.android.contacts.common.list;

import android.accounts.Account;
import android.content.ContentUris;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.android.contacts.common.ContactPhotoManager;
import com.android.contacts.common.ContactPresenceIconUtil;
import com.android.contacts.common.ContactStatusUtil;
import com.android.contacts.common.MoreContactUtils;
import com.android.contacts.common.R;
import com.android.contacts.common.util.ViewUtil;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ContactTileAdapter extends BaseAdapter {
    private static final String TAG = "ContactTileAdapter";
    private int mAccountNameIndex;
    private int mAccountTypeIndex;
    protected int mColumnCount;
    protected Cursor mContactCursor;
    private Context mContext;
    private DisplayType mDisplayType;
    private int mDividerPosition;
    protected int mIdIndex;
    private boolean mIsQuickContactEnabled;
    private ContactTileView.Listener mListener;
    protected int mLookupIndex;
    protected int mNameIndex;
    protected int mNumFrequents;
    private final int mPaddingInPixels;
    private ContactPhotoManager mPhotoManager;
    protected int mPhotoUriIndex;
    protected int mPresenceIndex;
    private Resources mResources;
    private int mStarredIndex;
    protected int mStatusIndex;
    private final int mWhitespaceStartEnd;

    /* JADX INFO: renamed from: com.android.contacts.common.list.ContactTileAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$contacts$common$list$ContactTileAdapter$DisplayType = null;

        static {
            int[] r0 = new int[DisplayType.values().length];
            $SwitchMap$com$android$contacts$common$list$ContactTileAdapter$DisplayType = r0;
            r0[DisplayType.STARRED_ONLY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$android$contacts$common$list$ContactTileAdapter$DisplayType[DisplayType.STREQUENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$android$contacts$common$list$ContactTileAdapter$DisplayType[DisplayType.FREQUENT_ONLY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    private class ContactTileRow extends FrameLayout {
        private int mItemViewType;
        private int mLayoutResId;
        final /* synthetic */ ContactTileAdapter this$0;

        public ContactTileRow(ContactTileAdapter r1, Context r2, int r3) {
            this.this$0 = r1;
            super(r2);
            this.mItemViewType = r3;
            this.mLayoutResId = ContactTileAdapter.access$000(r1, r3);
            setImportantForAccessibility(2);
        }

        public void configureRow(ArrayList<ContactEntry> r4, boolean r5) {
            if (this.mItemViewType != 2) goto L5;
            int r0 = 1;
        L6:
            int r1 = 0;
        L7:
            if (r1 >= r0) goto L13;
            if (r1 >= r4.size()) goto L11;
            ContactEntry r2 = r4.get(r1);
        L12:
            addTileFromEntry(r2, r1, r5);
            r1 = r1 + 1;
            goto L7
        L11:
            r2 = null;
            goto L12
        L13:
            return;
        L5:
            r0 = this.this$0.mColumnCount;
            goto L6
        }

        private void addTileFromEntry(ContactEntry r5, int r6, boolean r7) {
            int r1 = 0;
            if (getChildCount() > r6) goto L5;
            ContactTileView r8 = (ContactTileView) inflate(ContactTileAdapter.access$100(this.this$0), this.mLayoutResId, null);
            ContactTileAdapter.access$100(this.this$0).getResources();
            FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, -2);
            r0.setMargins(ContactTileAdapter.access$200(this.this$0), 0, ContactTileAdapter.access$200(this.this$0), 0);
            r8.setLayoutParams(r0);
            r8.setPhotoManager(ContactTileAdapter.access$300(this.this$0));
            r8.setListener(ContactTileAdapter.access$400(this.this$0));
            addView(r8);
        L6:
            r8.loadFromContact(r5);
            int r9 = this.mItemViewType;
            if (r9 == 0) goto L13;
            if (r9 != 2) goto L16;
            if (r7 == false) goto L12;
            r1 = 8;
        L12:
            r8.setHorizontalDividerVisibility(r1);
            return;
        L16:
            return;
        L13:
            r8.setPaddingRelative((ContactTileAdapter.access$500(this.this$0) + 1) / 2, 0, ContactTileAdapter.access$500(this.this$0) / 2, 0);
            return;
        L5:
            r8 = (ContactTileView) getChildAt(r6);
            goto L6
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
            if (this.mItemViewType == 0) goto L6;
            super.onLayout(r2, r3, r4, r5, r6);
            return;
        L6:
            onLayoutForTiles();
        }

        private void onLayoutForTiles() {
            int r0 = getChildCount();
            int r1 = ContactTileAdapter.access$200(this.this$0) - ((ContactTileAdapter.access$500(this.this$0) + 1) / 2);
            int r3 = 0;
        L3:
            if (r3 >= r0) goto L13;
            if (ViewUtil.isViewLayoutRtl(this) == false) goto L7;
            int r4 = (r0 - r3) - 1;
        L8:
            View r5 = getChildAt(r4);
            if (r5 == null) goto L12;
            int r6 = r5.getMeasuredWidth() + r1;
            r5.layout(r1, 0, r6, r5.getMeasuredHeight());
            r1 = r6;
        L12:
            r3 = r3 + 1;
            goto L3
        L7:
            r4 = r3;
            goto L8
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int r2, int r3) {
            if (this.mItemViewType == 0) goto L6;
            super.onMeasure(r2, r3);
            return;
        L6:
            onMeasureForTiles(r2);
        }

        private void onMeasureForTiles(int r10) {
            int r11 = View.MeasureSpec.getSize(r10);
            int r0 = getChildCount();
            if (r0 != 0) goto L6;
            setMeasuredDimension(r11, 0);
            return;
        L6:
            int r2 = ((this.this$0.mColumnCount - 1) * ContactTileAdapter.access$500(this.this$0)) + (ContactTileAdapter.access$200(this.this$0) * 2);
            int r4 = (r11 - r2) / this.this$0.mColumnCount;
            int r5 = (r11 - (this.this$0.mColumnCount * r4)) - r2;
            int r3 = 0;
        L7:
            if (r3 >= r0) goto L17;
            View r6 = getChildAt(r3);
            if (r6 == null) goto L16;
            int r7 = (r6.getPaddingRight() + r4) + r6.getPaddingLeft();
            if (r3 >= r5) goto L14;
            int r8 = 1;
        L15:
            r6.measure(View.MeasureSpec.makeMeasureSpec(r7 + r8, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            goto L16
        L14:
            r8 = 0;
        L16:
            r3 = r3 + 1;
            goto L7
        L17:
            View r1 = getChildAt(0);
            if (r1 == null) goto L24;
            setMeasuredDimension(r11, r1.getMeasuredHeight());
            return;
        }
    }

    public static final enum DisplayType extends Enum<DisplayType> {
        private static final /* synthetic */ DisplayType[] $VALUES = null;
        public static final DisplayType FREQUENT_ONLY = null;
        public static final DisplayType GROUP_MEMBERS = null;
        public static final DisplayType STARRED_ONLY = null;
        public static final DisplayType STREQUENT = null;

        private static /* synthetic */ DisplayType[] $values() {
            return new DisplayType[]{STREQUENT, STARRED_ONLY, FREQUENT_ONLY, GROUP_MEMBERS};
        }

        private DisplayType(String r1, int r2) {
            super(r1, r2);
        }

        public static DisplayType valueOf(String r1) {
            return (DisplayType) Enum.valueOf(DisplayType.class, r1);
        }

        public static DisplayType[] values() {
            return (DisplayType[]) $VALUES.clone();
        }

        static {
            STREQUENT = new DisplayType("STREQUENT", 0);
            STARRED_ONLY = new DisplayType("STARRED_ONLY", 1);
            FREQUENT_ONLY = new DisplayType("FREQUENT_ONLY", 2);
            GROUP_MEMBERS = new DisplayType("GROUP_MEMBERS", 3);
            $VALUES = $values();
        }
    }

    protected static class ViewTypes {
        public static final int COUNT = 4;
        public static final int DIVIDER = 1;
        public static final int FREQUENT = 2;
        public static final int STARRED = 0;

        protected ViewTypes() {
        }
    }

    static {
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return r1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 4;
    }

    static /* synthetic */ int access$000(ContactTileAdapter r0, int r1) {
        return r0.getLayoutResourceId(r1);
    }

    static /* synthetic */ Context access$100(ContactTileAdapter r0) {
        return r0.mContext;
    }

    static /* synthetic */ int access$200(ContactTileAdapter r0) {
        return r0.mWhitespaceStartEnd;
    }

    static /* synthetic */ ContactPhotoManager access$300(ContactTileAdapter r0) {
        return r0.mPhotoManager;
    }

    static /* synthetic */ ContactTileView.Listener access$400(ContactTileAdapter r0) {
        return r0.mListener;
    }

    static /* synthetic */ int access$500(ContactTileAdapter r0) {
        return r0.mPaddingInPixels;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r1) {
        return getItem(r1);
    }

    public ContactTileAdapter(Context r2, ContactTileView.Listener r3, int r4, DisplayType r5) {
        this.mContactCursor = null;
        this.mIsQuickContactEnabled = false;
        this.mListener = r3;
        this.mContext = r2;
        this.mResources = r2.getResources();
        if (r5 != DisplayType.FREQUENT_ONLY) goto L5;
        r4 = 1;
    L5:
        this.mColumnCount = r4;
        this.mDisplayType = r5;
        this.mNumFrequents = 0;
        this.mPaddingInPixels = this.mContext.getResources().getDimensionPixelSize(R.dimen.contact_tile_divider_padding);
        this.mWhitespaceStartEnd = this.mContext.getResources().getDimensionPixelSize(R.dimen.contact_tile_start_end_whitespace);
        bindColumnIndices();
    }

    public void setPhotoLoader(ContactPhotoManager r1) {
        this.mPhotoManager = r1;
    }

    public void setColumnCount(int r1) {
        this.mColumnCount = r1;
    }

    public void setDisplayType(DisplayType r1) {
        this.mDisplayType = r1;
    }

    public void enableQuickContact(boolean r1) {
        this.mIsQuickContactEnabled = r1;
    }

    protected void bindColumnIndices() {
        this.mIdIndex = 0;
        this.mLookupIndex = 4;
        this.mPhotoUriIndex = 3;
        this.mNameIndex = 1;
        this.mStarredIndex = 2;
        this.mPresenceIndex = 7;
        this.mStatusIndex = 8;
        this.mAccountTypeIndex = 5;
        this.mAccountNameIndex = 6;
    }

    private static boolean cursorIsValid(Cursor r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.isClosed() == true) goto L6;
        return true;
    }

    protected void saveNumFrequentsFromCursor(Cursor r4) {
        int r0 = AnonymousClass1.$SwitchMap$com$android$contacts$common$list$ContactTileAdapter$DisplayType[this.mDisplayType.ordinal()];
        int r2 = 0;
        if (r0 != 1) goto L5;
        this.mNumFrequents = 0;
        return;
    L5:
        if (r0 == 2) goto L15;
        if (r0 != 3) goto L13;
        if (cursorIsValid(r4) == false) goto L11;
        r2 = r4.getCount();
    L11:
        this.mNumFrequents = r2;
        return;
    L13:
        throw new IllegalArgumentException("Unrecognized DisplayType " + this.mDisplayType);
    L15:
        if (cursorIsValid(r4) == false) goto L17;
        r2 = r4.getCount() - this.mDividerPosition;
    L17:
        this.mNumFrequents = r2;
    }

    public void setContactCursor(Cursor r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isClosed() == true) goto L9;
        this.mContactCursor = r2;
        this.mDividerPosition = getDividerPosition(r2);
        saveNumFrequentsFromCursor(r2);
        notifyDataSetChanged();
        return;
    }

    protected int getDividerPosition(Cursor r5) {
        int r0 = AnonymousClass1.$SwitchMap$com$android$contacts$common$list$ContactTileAdapter$DisplayType[this.mDisplayType.ordinal()];
        if (r0 != 1) goto L5;
        return -1;
    L5:
        if (r0 == 2) goto L12;
        if (r0 != 3) goto L10;
        return 0;
    L10:
        throw new IllegalStateException("Unrecognized DisplayType " + this.mDisplayType);
    L12:
        if (cursorIsValid(r5) == true) goto L14;
        return 0;
    L14:
        r5.moveToPosition(-1);
    L16:
        if (r5.moveToNext() == false) goto L22;
        if (r5.getInt(this.mStarredIndex) != 0) goto L16;
        return r5.getPosition();
    L22:
        return r5.getCount();
    }

    protected ContactEntry createContactEntryFromCursor(Cursor r8, int r9) {
        if (cursorIsValid(r8) == true) goto L5;
    L39:
        return null;
    L5:
        if (r8.getCount() <= r9) goto L39;
        r8.moveToPosition(r9);
        long r2 = r8.getLong(this.mIdIndex);
        String r10 = r8.getString(this.mPhotoUriIndex);
        String r0 = r8.getString(this.mLookupIndex);
        ContactEntry r4 = new ContactEntry();
        String r5 = r8.getString(this.mNameIndex);
        if (r5 != null) goto L11;
        r5 = this.mResources.getString(R.string.missing_name);
    L11:
        r4.namePrimary = r5;
        r4.status = r8.getString(this.mStatusIndex);
        if (r10 == null) goto L14;
        Uri r11 = Uri.parse(r10);
    L15:
        r4.photoUri = r11;
        r4.lookupKey = r0;
        r4.lookupUri = ContentUris.withAppendedId(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, r0), r2);
        int r1 = 0;
        if (r8.getInt(this.mStarredIndex) <= 0) goto L18;
        boolean r12 = true;
    L19:
        r4.isFavorite = r12;
        if (r8.isNull(this.mPresenceIndex) == true) goto L22;
        r1 = r8.getInt(this.mPresenceIndex);
        Drawable r13 = ContactPresenceIconUtil.getPresenceIcon(this.mContext, r1);
    L23:
        r4.presenceIcon = r13;
        int r14 = this.mStatusIndex;
        if (r14 != 0) goto L26;
    L28:
        String r15 = null;
    L29:
        if (r15 != null) goto L32;
        if (r1 == 0) goto L32;
        r15 = ContactStatusUtil.getStatusString(this.mContext, r1);
    L32:
        r4.status = r15;
        if (r8.isNull(this.mAccountTypeIndex) == false) goto L35;
    L37:
        r4.account = null;
    L38:
        return r4;
    L35:
        if (r8.isNull(this.mAccountTypeIndex) == true) goto L37;
        r4.account = new Account(r8.getString(this.mAccountNameIndex), r8.getString(this.mAccountTypeIndex));
        goto L38
    L26:
        if (r8.isNull(r14) == true) goto L28;
        r15 = r8.getString(this.mStatusIndex);
        goto L29
    L22:
        r13 = null;
        goto L23
    L18:
        r12 = false;
        goto L19
    L14:
        r11 = null;
        goto L15
    }

    public int getNumFrequents() {
        return this.mNumFrequents;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int r1 = 0;
        if (cursorIsValid(this.mContactCursor) == true) goto L5;
        return 0;
    L5:
        int r0 = AnonymousClass1.$SwitchMap$com$android$contacts$common$list$ContactTileAdapter$DisplayType[this.mDisplayType.ordinal()];
        if (r0 == 1) goto L22;
        if (r0 != 2) goto L10;
        int r2 = getRowCount(this.mDividerPosition);
        int r4 = this.mNumFrequents;
        if (r4 == 0) goto L20;
        r1 = r4 + 1;
    L20:
        return r2 + r1;
    L10:
        if (r0 != 3) goto L14;
        return this.mContactCursor.getCount();
    L14:
        throw new IllegalArgumentException("Unrecognized DisplayType " + this.mDisplayType);
    L22:
        return getRowCount(this.mContactCursor.getCount());
    }

    protected int getRowCount(int r1) {
        if (r1 != 0) goto L5;
        return 0;
    L5:
        return ((r1 - 1) / this.mColumnCount) + 1;
    }

    public int getColumnCount() {
        return this.mColumnCount;
    }

    @Override // android.widget.Adapter
    public ArrayList<ContactEntry> getItem(int r7) {
        ArrayList<ContactEntry> r0 = new ArrayList(this.mColumnCount);
        int r1 = this.mColumnCount * r7;
        int r2 = AnonymousClass1.$SwitchMap$com$android$contacts$common$list$ContactTileAdapter$DisplayType[this.mDisplayType.ordinal()];
        int r3 = 0;
        if (r2 == 1) goto L20;
        if (r2 == 2) goto L12;
        if (r2 != 3) goto L10;
        r0.add(createContactEntryFromCursor(this.mContactCursor, r7));
    L22:
        return r0;
    L10:
        throw new IllegalStateException("Unrecognized DisplayType " + this.mDisplayType);
    L12:
        if (r7 < getRowCount(this.mDividerPosition)) goto L14;
        r0.add(createContactEntryFromCursor(this.mContactCursor, ((r7 - getRowCount(this.mDividerPosition)) - 1) + this.mDividerPosition));
    L14:
        if (r3 >= this.mColumnCount) goto L22;
        if (r1 == this.mDividerPosition) goto L22;
        r0.add(createContactEntryFromCursor(this.mContactCursor, r1));
        r1 = r1 + 1;
        r3 = r3 + 1;
    L20:
        if (r3 >= this.mColumnCount) goto L22;
        r0.add(createContactEntryFromCursor(this.mContactCursor, r1));
        r1 = r1 + 1;
        r3 = r3 + 1;
        goto L20
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        if (this.mDisplayType == DisplayType.STREQUENT) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int r2) {
        if (r2 == getRowCount(this.mDividerPosition)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.widget.Adapter
    public View getView(int r5, View r6, ViewGroup r7) {
        int r8 = getItemViewType(r5);
        boolean r0 = false;
        if (r8 != 1) goto L11;
        if (r6 != null) goto L6;
        r6 = getDivider();
    L6:
        TextView r9 = (TextView) r6;
        if (r5 != 0) goto L9;
        r0 = true;
    L9:
        setDividerPadding(r9, r0);
        return r9;
    L11:
        ContactTileRow r10 = (ContactTileRow) r6;
        ArrayList<ContactEntry> r2 = getItem(r5);
        if (r10 != null) goto L15;
        r10 = new ContactTileRow(this, this.mContext, r8);
    L15:
        if (r5 != (getCount() - 1)) goto L17;
        r0 = true;
    L17:
        r10.configureRow(r2, r0);
        return r10;
    }

    private TextView getDivider() {
        return MoreContactUtils.createHeaderView(this.mContext, R.string.favoritesFrequentContacted);
    }

    private void setDividerPadding(TextView r1, boolean r2) {
        MoreContactUtils.setHeaderViewBottomPadding(this.mContext, r1, r2);
    }

    private int getLayoutResourceId(int r3) {
        if (r3 == 0) goto L10;
        if (r3 != 2) goto L8;
        return R.layout.contact_tile_frequent;
    L8:
        throw new IllegalArgumentException("Unrecognized viewType " + r3);
    L10:
        if (this.mIsQuickContactEnabled == false) goto L13;
        return R.layout.contact_tile_starred_quick_contact;
    L13:
        return R.layout.contact_tile_starred;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int r5) {
        int r0 = AnonymousClass1.$SwitchMap$com$android$contacts$common$list$ContactTileAdapter$DisplayType[this.mDisplayType.ordinal()];
        if (r0 != 1) goto L5;
        return 0;
    L5:
        if (r0 == 2) goto L12;
        if (r0 != 3) goto L10;
        return 2;
    L10:
        throw new IllegalStateException("Unrecognized DisplayType " + this.mDisplayType);
    L12:
        if (r5 >= getRowCount(this.mDividerPosition)) goto L15;
        return 0;
    L15:
        if (r5 != getRowCount(this.mDividerPosition)) goto L17;
        return 1;
    L17:
        return 2;
    }

    public int getFrequentHeaderPosition() {
        return getRowCount(this.mDividerPosition);
    }
}
