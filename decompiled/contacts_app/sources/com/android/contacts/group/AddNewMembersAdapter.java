package com.android.contacts.group;

import android.content.ContentUris;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import com.android.contacts.ContactPhotoManager;
import com.android.contacts.ContactPresenceIconUtil;
import com.android.contacts.ContactStatusUtil;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.list.ContactTileView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class AddNewMembersAdapter extends BaseAdapter {
    private static final String TAG = "AddNewMembersAdapter";
    private int mColumnCount;
    private Cursor mContactCursor;
    private ContactTileView.Listener mContactTileListener;
    private Context mContext;
    private DisplayType mDisplayType;
    private int mDividerPosition;
    private int mIdIndex;
    private boolean mIsQuickContactEnabled;
    private Listener mListener;
    private int mLookupIndex;
    private int mNameIndex;
    private final int mPaddingInPixels;
    private int mPhoneNumberIndex;
    private int mPhoneNumberLabelIndex;
    private int mPhoneNumberTypeIndex;
    private ContactPhotoManager mPhotoManager;
    private int mPhotoUriIndex;
    private int mPresenceIndex;
    private Resources mResources;
    private int mStarredIndex;
    private int mStatusIndex;

    /* JADX INFO: renamed from: com.android.contacts.group.AddNewMembersAdapter$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$android$contacts$group$AddNewMembersAdapter$DisplayType = null;

        static {
            int[] r0 = new int[DisplayType.values().length];
            $SwitchMap$com$android$contacts$group$AddNewMembersAdapter$DisplayType = r0;
            r0[DisplayType.STREQUENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$android$contacts$group$AddNewMembersAdapter$DisplayType[DisplayType.STREQUENT_PHONE_ONLY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$android$contacts$group$AddNewMembersAdapter$DisplayType[DisplayType.GROUP_MEMBERS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$android$contacts$group$AddNewMembersAdapter$DisplayType[DisplayType.STARRED_ONLY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$android$contacts$group$AddNewMembersAdapter$DisplayType[DisplayType.FREQUENT_ONLY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static class ContactEntry {
        public Uri lookupKey;
        public String name;
        public String phoneLabel;
        public String phoneNumber;
        public Uri photoUri;
        public Drawable presenceIcon;
        public long rawContactId;
        public String status;

        public ContactEntry() {
        }
    }

    private class ContactTileRow extends FrameLayout {
        private int mItemViewType;
        private int mLayoutResId;
        final /* synthetic */ AddNewMembersAdapter this$0;

        @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
        public void sendAccessibilityEvent(int r1) {
        }

        public ContactTileRow(AddNewMembersAdapter r1, Context r2, int r3) {
            this.this$0 = r1;
            super(r2);
            this.mItemViewType = r3;
            this.mLayoutResId = AddNewMembersAdapter.access$200(r1, r3);
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
            r0 = AddNewMembersAdapter.access$300(this.this$0);
            goto L6
        }

        private void addTileFromEntry(ContactEntry r7, int r8, boolean r9) {
            int r1 = 0;
            if (getChildCount() > r8) goto L5;
            ContactTileView r0 = (ContactTileView) inflate(this.mContext, this.mLayoutResId, null);
            Resources r2 = this.mContext.getResources();
            FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-2, -2);
            r3.setMargins(r2.getDimensionPixelSize(R.dimen.detail_item_side_margin), 0, r2.getDimensionPixelSize(R.dimen.detail_item_side_margin), 0);
            r0.setLayoutParams(r3);
            r0.setPhotoManager(AddNewMembersAdapter.access$400(this.this$0));
            r0.setListener(AddNewMembersAdapter.access$500(this.this$0));
            addView(r0);
        L6:
            if (r0 == null) goto L8;
            r0.loadFromContact(r7);
        L8:
            int r10 = this.mItemViewType;
            if (r10 == 0) goto L20;
            if (r10 != 2) goto L13;
            if (r0 == null) goto L28;
            if (r9 == false) goto L18;
            r1 = 8;
        L18:
            r0.setHorizontalDividerVisibility(r1);
            return;
        L28:
            return;
        L13:
            if (r10 == 3) goto L20;
            return;
        L20:
            if (r8 < (AddNewMembersAdapter.access$300(this.this$0) - 1)) goto L22;
            int r11 = 0;
        L23:
            if (r9 == false) goto L25;
            int r6 = 0;
        L26:
            r0.setPadding(0, 0, r11, r6);
            return;
        L25:
            r6 = AddNewMembersAdapter.access$600(this.this$0);
            goto L26
        L22:
            r11 = AddNewMembersAdapter.access$600(this.this$0);
            goto L23
        L5:
            r0 = (ContactTileView) getChildAt(r8);
            goto L6
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
            int r0 = this.mItemViewType;
            if (r0 != 0) goto L5;
        L8:
            onLayoutForTiles(r4, r5, r6, r7);
            return;
        L5:
            if (r0 == 3) goto L8;
            super.onLayout(r3, r4, r5, r6, r7);
        }

        private void onLayoutForTiles(int r4, int r5, int r6, int r7) {
            int r8 = getChildCount();
            int r9 = 0;
            int r10 = 0;
        L3:
            if (r9 >= r8) goto L8;
            View r0 = getChildAt(r9);
            if (r0 == null) goto L7;
            int r1 = r0.getMeasuredWidth() + r10;
            r0.layout(r10, 0, r1, r0.getMeasuredHeight());
            r10 = r1;
        L7:
            r9 = r9 + 1;
            goto L3
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int r3, int r4) {
            int r0 = this.mItemViewType;
            if (r0 != 0) goto L5;
        L8:
            onMeasureForTiles(r3, r4);
            return;
        L5:
            if (r0 == 3) goto L8;
            super.onMeasure(r3, r4);
        }

        private void onMeasureForTiles(int r10, int r11) {
            int r12 = View.MeasureSpec.getSize(r10);
            int r13 = getChildCount();
            if (r13 != 0) goto L6;
            setMeasuredDimension(r12, 0);
            return;
        L6:
            int r1 = (AddNewMembersAdapter.access$300(this.this$0) - 1) * AddNewMembersAdapter.access$600(this.this$0);
            int r3 = (r12 - r1) / AddNewMembersAdapter.access$300(this.this$0);
            int r4 = (r12 - (AddNewMembersAdapter.access$300(this.this$0) * r3)) - r1;
            int r2 = 0;
        L7:
            if (r2 >= r13) goto L13;
            View r5 = getChildAt(r2);
            int r6 = r5.getPaddingRight() + r3;
            if (r2 >= r4) goto L11;
            int r7 = 1;
        L12:
            r5.measure(View.MeasureSpec.makeMeasureSpec(r6 + r7, 1073741824), View.MeasureSpec.makeMeasureSpec(r5.getPaddingBottom() + r3, 1073741824));
            r2 = r2 + 1;
            goto L7
        L11:
            r7 = 0;
            goto L12
        L13:
            setMeasuredDimension(r12, 79);
        }
    }

    public static final enum DisplayType extends Enum<DisplayType> {
        private static final /* synthetic */ DisplayType[] $VALUES = null;
        public static final DisplayType FREQUENT_ONLY = null;
        public static final DisplayType GROUP_MEMBERS = null;
        public static final DisplayType STARRED_ONLY = null;
        public static final DisplayType STREQUENT = null;
        public static final DisplayType STREQUENT_PHONE_ONLY = null;

        private static /* synthetic */ DisplayType[] $values() {
            return new DisplayType[]{STREQUENT, STREQUENT_PHONE_ONLY, STARRED_ONLY, FREQUENT_ONLY, GROUP_MEMBERS};
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
            STREQUENT_PHONE_ONLY = new DisplayType("STREQUENT_PHONE_ONLY", 1);
            STARRED_ONLY = new DisplayType("STARRED_ONLY", 2);
            FREQUENT_ONLY = new DisplayType("FREQUENT_ONLY", 3);
            GROUP_MEMBERS = new DisplayType("GROUP_MEMBERS", 4);
            $VALUES = $values();
        }
    }

    public interface Listener {
        void onContactSelected(Uri r1, Rect r2);
    }

    private static class ViewTypes {
        public static final int COUNT = 4;
        public static final int DIVIDER = 1;
        public static final int FREQUENT = 2;
        public static final int STARRED = 0;
        public static final int STARRED_WITH_SECONDARY_ACTION = 3;

        private ViewTypes() {
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return r1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 4;
    }

    static /* synthetic */ Listener access$000(AddNewMembersAdapter r0) {
        return r0.mListener;
    }

    static /* synthetic */ Context access$100(AddNewMembersAdapter r0) {
        return r0.mContext;
    }

    static /* synthetic */ int access$200(AddNewMembersAdapter r0, int r1) {
        return r0.getLayoutResourceId(r1);
    }

    static /* synthetic */ int access$300(AddNewMembersAdapter r0) {
        return r0.mColumnCount;
    }

    static /* synthetic */ ContactPhotoManager access$400(AddNewMembersAdapter r0) {
        return r0.mPhotoManager;
    }

    static /* synthetic */ ContactTileView.Listener access$500(AddNewMembersAdapter r0) {
        return r0.mContactTileListener;
    }

    static /* synthetic */ int access$600(AddNewMembersAdapter r0) {
        return r0.mPaddingInPixels;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r1) {
        return getItem(r1);
    }

    public AddNewMembersAdapter(Context r2, Listener r3, int r4, DisplayType r5) {
        this.mContactCursor = null;
        this.mIsQuickContactEnabled = false;
        this.mContactTileListener = new AnonymousClass1(this);
        this.mListener = r3;
        this.mContext = r2;
        this.mResources = r2.getResources();
        if (r5 != DisplayType.FREQUENT_ONLY) goto L5;
        r4 = 1;
    L5:
        this.mColumnCount = r4;
        this.mDisplayType = r5;
        this.mPaddingInPixels = this.mContext.getResources().getDimensionPixelSize(R.dimen.contact_tile_divider_padding);
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

    private void bindColumnIndices() {
        if (this.mDisplayType != DisplayType.GROUP_MEMBERS) goto L5;
        this.mIdIndex = 0;
        this.mLookupIndex = 2;
        this.mPhotoUriIndex = 1;
        this.mNameIndex = 3;
        this.mPresenceIndex = 4;
        this.mStatusIndex = 5;
        return;
    L5:
        this.mIdIndex = 0;
        this.mLookupIndex = 4;
        this.mPhotoUriIndex = 3;
        this.mNameIndex = 1;
        this.mStarredIndex = 2;
        this.mPresenceIndex = 5;
        this.mStatusIndex = 6;
        this.mPhoneNumberIndex = 5;
        this.mPhoneNumberTypeIndex = 6;
        this.mPhoneNumberLabelIndex = 7;
    }

    public void setContactCursor(Cursor r1) {
        this.mContactCursor = r1;
        this.mDividerPosition = getDividerPosition(r1);
        notifyDataSetChanged();
    }

    private int getDividerPosition(Cursor r4) {
        if (r4 == null) goto L30;
        if (r4.isClosed() == true) goto L30;
        int r0 = AnonymousClass2.$SwitchMap$com$android$contacts$group$AddNewMembersAdapter$DisplayType[this.mDisplayType.ordinal()];
        if (r0 != 1) goto L8;
    L20:
        r4.moveToPosition(-1);
    L22:
        if (r4.moveToNext() == false) goto L28;
        if (r4.getInt(this.mStarredIndex) != 0) goto L22;
        return r4.getPosition();
    L28:
        return r4.getCount();
    L8:
        if (r0 == 2) goto L20;
        if (r0 != 3) goto L12;
    L19:
        return -1;
    L12:
        if (r0 == 4) goto L19;
        if (r0 != 5) goto L18;
        return 0;
    L18:
        throw new IllegalStateException("Unrecognized DisplayType " + this.mDisplayType);
    L30:
        throw new IllegalStateException("Unable to access cursor");
    }

    private ContactEntry createContactEntryFromCursor(Cursor r8, int r9) {
        String r0 = null;
        if (r8 != null) goto L5;
    L34:
        return null;
    L5:
        if (r8.isClosed() == true) goto L34;
        if (r8.getCount() <= r9) goto L34;
        r8.moveToPosition(r9);
        long r1 = r8.getLong(this.mIdIndex);
        String r10 = r8.getString(this.mPhotoUriIndex);
        String r3 = r8.getString(this.mLookupIndex);
        ContactEntry r4 = new ContactEntry();
        String r5 = r8.getString(this.mNameIndex);
        if (r5 != null) goto L13;
        r5 = this.mResources.getString(R.string.missing_name);
    L13:
        r4.name = r5;
        r4.status = r8.getString(this.mStatusIndex);
        if (r10 == null) goto L16;
        Uri r11 = Uri.parse(r10);
    L17:
        r4.photoUri = r11;
        r4.lookupKey = ContentUris.withAppendedId(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, r3), r1);
        if (this.mDisplayType != DisplayType.STREQUENT_PHONE_ONLY) goto L21;
        r4.phoneLabel = (String) ContactsContract.CommonDataKinds.Phone.getTypeLabel(this.mResources, r8.getInt(this.mPhoneNumberTypeIndex), r8.getString(this.mPhoneNumberLabelIndex));
        r4.phoneNumber = r8.getString(this.mPhoneNumberIndex);
    L33:
        return r4;
    L21:
        if (r8.isNull(this.mPresenceIndex) == true) goto L23;
        int r12 = r8.getInt(this.mPresenceIndex);
        Drawable r2 = ContactPresenceIconUtil.getPresenceIcon(this.mContext, r12);
    L24:
        r4.presenceIcon = r2;
        int r6 = this.mStatusIndex;
        if (r6 != 0) goto L27;
    L29:
        if (r0 != null) goto L32;
        if (r12 == 0) goto L32;
        r0 = ContactStatusUtil.getStatusString(this.mContext, r12);
    L32:
        r4.status = r0;
        goto L33
    L27:
        if (r8.isNull(r6) == true) goto L29;
        r0 = r8.getString(this.mStatusIndex);
        goto L29
    L23:
        r12 = 0;
        r2 = null;
        goto L24
    L16:
        r11 = null;
        goto L17
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor r0 = this.mContactCursor;
        int r1 = 0;
        if (r0 != null) goto L5;
    L29:
        return 0;
    L5:
        if (r0.isClosed() == true) goto L29;
        int r2 = AnonymousClass2.$SwitchMap$com$android$contacts$group$AddNewMembersAdapter$DisplayType[this.mDisplayType.ordinal()];
        if (r2 != 1) goto L10;
    L23:
        int r3 = getRowCount(this.mDividerPosition);
        int r4 = this.mContactCursor.getCount() - this.mDividerPosition;
        if (r4 == 0) goto L28;
        r1 = 1;
    L28:
        return r3 + (r4 + r1);
    L10:
        if (r2 == 2) goto L23;
        if (r2 == 3) goto L22;
        if (r2 == 4) goto L22;
        if (r2 != 5) goto L20;
        return this.mContactCursor.getCount();
    L20:
        throw new IllegalArgumentException("Unrecognized DisplayType " + this.mDisplayType);
    L22:
        return getRowCount(this.mContactCursor.getCount());
    }

    private int getRowCount(int r1) {
        if (r1 != 0) goto L5;
        return 0;
    L5:
        return ((r1 - 1) / this.mColumnCount) + 1;
    }

    @Override // android.widget.Adapter
    public ArrayList<ContactEntry> getItem(int r7) {
        ArrayList<ContactEntry> r0 = new ArrayList(this.mColumnCount);
        int r1 = this.mColumnCount * r7;
        int r2 = AnonymousClass2.$SwitchMap$com$android$contacts$group$AddNewMembersAdapter$DisplayType[this.mDisplayType.ordinal()];
        int r3 = 0;
        if (r2 == 1) goto L19;
        if (r2 == 2) goto L19;
        if (r2 == 3) goto L16;
        if (r2 == 4) goto L16;
        if (r2 != 5) goto L14;
        r0.add(createContactEntryFromCursor(this.mContactCursor, r7));
    L26:
        return r0;
    L14:
        throw new IllegalStateException("Unrecognized DisplayType " + this.mDisplayType);
    L16:
        if (r3 >= this.mColumnCount) goto L26;
        r0.add(createContactEntryFromCursor(this.mContactCursor, r1));
        r1 = r1 + 1;
        r3 = r3 + 1;
    L19:
        if (r7 < getRowCount(this.mDividerPosition)) goto L21;
        r0.add(createContactEntryFromCursor(this.mContactCursor, ((r7 - getRowCount(this.mDividerPosition)) - 1) + this.mDividerPosition));
    L21:
        if (r3 >= this.mColumnCount) goto L26;
        if (r1 == this.mDividerPosition) goto L26;
        r0.add(createContactEntryFromCursor(this.mContactCursor, r1));
        r1 = r1 + 1;
        r3 = r3 + 1;
        goto L21
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        if (this.mDisplayType != DisplayType.STREQUENT) goto L5;
    L7:
        return false;
    L5:
        if (this.mDisplayType == DisplayType.STREQUENT_PHONE_ONLY) goto L7;
        return true;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int r2) {
        if (r2 == getRowCount(this.mDividerPosition)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.widget.Adapter
    public View getView(int r4, View r5, ViewGroup r6) {
        int r7 = getItemViewType(r4);
        boolean r0 = true;
        if (r7 != 1) goto L7;
        if (r5 == null) goto L6;
        return r5;
    L6:
        return getDivider();
    L7:
        ContactTileRow r8 = (ContactTileRow) r5;
        ArrayList<ContactEntry> r1 = getItem(r4);
        if (r8 != null) goto L11;
        r8 = new ContactTileRow(this, this.mContext, r7);
    L11:
        if (r4 == (getCount() - 1)) goto L14;
        r0 = false;
    L14:
        r8.configureRow(r1, r0);
        return r8;
    }

    public View getDivider() {
        Context r0 = this.mContext;
        if (this.mDisplayType != DisplayType.STREQUENT_PHONE_ONLY) goto L5;
        int r2 = R.string.favoritesFrequentCalled;
    L7:
        return ContactsUtils.createHeaderView(r0, r2);
    L5:
        r2 = R.string.favoritesFrequentContacted;
        goto L7
    }

    private int getLayoutResourceId(int r3) {
        if (r3 == 0) goto L17;
        if (r3 == 2) goto L12;
        if (r3 != 3) goto L10;
        return R.layout.contact_tile_starred_secondary_target;
    L10:
        throw new IllegalArgumentException("Unrecognized viewType " + r3);
    L12:
        if (this.mDisplayType != DisplayType.STREQUENT_PHONE_ONLY) goto L14;
        return R.layout.contact_tile_frequent_phone;
    L14:
        return R.layout.contact_tile_frequent;
    L17:
        if (this.mIsQuickContactEnabled == false) goto L19;
        return R.layout.contact_tile_starred_quick_contact;
    L19:
        return R.layout.contact_tile_starred;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int r6) {
        int r0 = AnonymousClass2.$SwitchMap$com$android$contacts$group$AddNewMembersAdapter$DisplayType[this.mDisplayType.ordinal()];
        if (r0 == 1) goto L23;
        if (r0 == 2) goto L16;
        if (r0 != 3) goto L8;
    L14:
        return 0;
    L8:
        if (r0 == 4) goto L14;
        if (r0 != 5) goto L13;
        return 2;
    L13:
        throw new IllegalStateException("Unrecognized DisplayType " + this.mDisplayType);
    L16:
        if (r6 >= getRowCount(this.mDividerPosition)) goto L19;
        return 3;
    L19:
        if (r6 != getRowCount(this.mDividerPosition)) goto L21;
        return 1;
    L21:
        return 2;
    L23:
        if (r6 >= getRowCount(this.mDividerPosition)) goto L26;
        return 0;
    L26:
        if (r6 != getRowCount(this.mDividerPosition)) goto L28;
        return 1;
    L28:
        return 2;
    }

    public int getFrequentHeaderPosition() {
        return getRowCount(this.mDividerPosition);
    }
}
