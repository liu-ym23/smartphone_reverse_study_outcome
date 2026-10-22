package com.android.contacts.recyclebin;

import android.app.Fragment;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bytedanceos.util.NameAvatarController;
import com.GlobalProxyLancet;
import com.android.contacts.Collapser;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.detail.ContactDetailDisplayUtils;
import com.android.contacts.detail.ContactDetailFragment;
import com.android.contacts.lunar.LunarCalendar;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.model.DataKind;
import com.android.contacts.model.EntityModifier;
import com.android.contacts.util.DateUtils;
import com.android.contacts.util.OSheetUtils;
import com.android.contacts.widget.AvatarImageView;
import com.android.vcard.VCardConfig;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OListItemGeneral;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.ui.OUIHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import obric.widget.ListContentItem;

/* JADX INFO: loaded from: classes2.dex */
public class RecycleItemDetailFragment extends Fragment {
    private static final int NOTE_MAX_LINES = 100;
    private static final int POSTAL_ADDRESS_MAX_LINES = 2;
    private static final int SIP_ADDRESS_MAX_LINES = 1;
    private static final String TAG = "RecycleItemDetailFragment";
    private static final int WEBSITE_MAX_LINES = 1;
    private ViewAdapter mAdapter;
    private ArrayList<ContactDetailFragment.ViewEntry> mAllEntries;
    private String mCompany;
    private Context mContext;
    private ArrayList<ContactDetailFragment.DetailViewEntry> mEmailEntries;
    private View mEmptyView;
    private ArrayList<ContactDetailFragment.DetailViewEntry> mEventEntries;
    private ArrayList<ContactDetailFragment.DetailViewEntry> mImEntries;
    private LayoutInflater mInflater;
    private ListView mListView;
    private ArrayList<ContactDetailFragment.DetailViewEntry> mNicknameEntries;
    private ArrayList<ContactDetailFragment.DetailViewEntry> mNoteEntries;
    private OInsetSheet mOInsetSheet;
    private final Map<AccountType, List<ContactDetailFragment.DetailViewEntry>> mOtherEntriesMap;
    private ArrayList<ContactDetailFragment.DetailViewEntry> mPhoneEntries;
    private ArrayList<ContactDetailFragment.DetailViewEntry> mPostalEntries;
    private RecycleItem mRecycleItem;
    private ArrayList<ContactDetailFragment.DetailViewEntry> mRelationEntries;
    private ArrayList<ContactDetailFragment.DetailViewEntry> mSipEntries;
    private ArrayList<ContactDetailFragment.DetailViewEntry> mWebsiteEntries;

    private static class BtnsViewEntry extends ContactDetailFragment.ViewEntry {
        BtnsViewEntry() {
            super(4);
        }

        BtnsViewEntry(int r1) {
            super(r1);
        }
    }

    private static class DetailViewCache {
        public final TextView data;
        public final View divider;
        public final OListItemGeneral listItemContainer;
        public final ImageView presenceIcon;
        public final View primaryActionView;
        public final RelativeLayout primaryActionViewChild;
        public final View secondaryActionViewContainer;
        public final View star;
        public final View thirdlyActionViewContainer;
        public final TextView type;
        public final OButton videoActionButton;
        public final View videoActionViewContainer;

        public DetailViewCache(View r3) {
            this.type = (TextView) r3.findViewById(R.id.type);
            this.data = (TextView) r3.findViewById(R.id.data);
            this.presenceIcon = (ImageView) r3.findViewById(R.id.presence_icon);
            this.divider = r3.findViewById(R.id.divider);
            this.star = r3.findViewById(R.id.starCheckbox);
            this.primaryActionView = r3.findViewById(R.id.primary_action_view);
            this.primaryActionViewChild = (RelativeLayout) r3.findViewById(R.id.primary_action_child);
            View r0 = r3.findViewById(R.id.secondary_action_view_container);
            this.secondaryActionViewContainer = r0;
            r0.setVisibility(8);
            View r1 = r3.findViewById(R.id.thirdly_action_view_container);
            this.thirdlyActionViewContainer = r1;
            r1.setVisibility(8);
            this.listItemContainer = (OListItemGeneral) r3.findViewById(R.id.lcit_action_view);
            this.videoActionButton = (OButton) r3.findViewById(R.id.video_action_button);
            View r4 = r3.findViewById(R.id.video_action_view_container);
            this.videoActionViewContainer = r4;
            r4.setVisibility(8);
        }
    }

    private static class HeaderViewCache {
        public final TextView companyAndNoteView;
        public final LinearLayout detailNameContainer;
        public final TextView displayNameView;
        public final int layoutResourceId;
        public final TextView phoneticNameView;
        public final ImageView photoView;

        public HeaderViewCache(View r2, int r3) {
            this.detailNameContainer = (LinearLayout) r2.findViewById(R.id.detail_name_container);
            this.displayNameView = (TextView) r2.findViewById(R.id.name);
            this.phoneticNameView = (TextView) r2.findViewById(R.id.phonetic_name);
            this.companyAndNoteView = (TextView) r2.findViewById(R.id.company_and_note);
            this.photoView = (ImageView) r2.findViewById(R.id.photo);
            this.layoutResourceId = r3;
        }
    }

    private static class HeaderViewEntry extends ContactDetailFragment.ViewEntry {
        HeaderViewEntry() {
            super(1);
        }
    }

    private static class KindTitleViewEntry extends ContactDetailFragment.ViewEntry {
        private final String mTitle;

        KindTitleViewEntry(String r2) {
            super(2);
            this.mTitle = r2;
        }

        public String getTitle() {
            return this.mTitle;
        }
    }

    private static class SeparatorViewEntry extends ContactDetailFragment.ViewEntry {
        private boolean mIsInSubSection;

        SeparatorViewEntry() {
            super(3);
            this.mIsInSubSection = false;
        }

        public void setIsInSubSection(boolean r1) {
            this.mIsInSubSection = r1;
        }

        public boolean isInSubSection() {
            return this.mIsInSubSection;
        }
    }

    private final class ViewAdapter extends BaseAdapter {
        public static final int VIEW_TYPE_BUTTON_ENTRY = 4;
        public static final int VIEW_TYPE_COUNT = 7;
        public static final int VIEW_TYPE_DETAIL_ENTRY = 0;
        public static final int VIEW_TYPE_DETAIL_PHONE_ENTRY = 6;
        public static final int VIEW_TYPE_HEADER_ENTRY = 1;
        public static final int VIEW_TYPE_KIND_TITLE_ENTRY = 2;
        public static final int VIEW_TYPE_NOTE_ENTRY = 5;
        public static final int VIEW_TYPE_SEPARATOR_ENTRY = 3;
        final /* synthetic */ RecycleItemDetailFragment this$0;

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 7;
        }

        private ViewAdapter(RecycleItemDetailFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ViewAdapter(RecycleItemDetailFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r3, View r4, ViewGroup r5) {
            if (ContactsUtils.DEBUG == false) goto L6;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_v(RecycleItemDetailFragment.TAG, "position:" + r3 + " getItemViewType(position)  " + getItemViewType(r3));
        L6:
            switch(getItemViewType(r3)) {
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L20;
                default: goto L8;
            };
        L8:
            throw new IllegalStateException("Invalid view type ID " + getItemViewType(r3));
        L10:
            return getNoteEntryView(r3, r4, r5);
        L12:
            return getButtonsView(r3, r4, r5);
        L14:
            return getSeparatorEntryView(r3, r4, r5);
        L16:
            return getKindTitleEntryView(r3, r4, r5);
        L18:
            return getHeaderEntryView(r4, r5);
        L20:
            return getDetailEntryView(r3, r4, r5);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return RecycleItemDetailFragment.access$300(this.this$0).size();
        }

        @Override // android.widget.Adapter
        public ContactDetailFragment.ViewEntry getItem(int r1) {
            return (ContactDetailFragment.ViewEntry) RecycleItemDetailFragment.access$300(this.this$0).get(r1);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int r1) {
            return ((ContactDetailFragment.ViewEntry) RecycleItemDetailFragment.access$300(this.this$0).get(r1)).getViewType();
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            ContactDetailFragment.ViewEntry r0 = (ContactDetailFragment.ViewEntry) RecycleItemDetailFragment.access$300(this.this$0).get(r1);
            if (r0 != null) goto L5;
            return -1;
        L5:
            return r0.getId();
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int r1) {
            return getItem(r1).isEnabled();
        }

        public int getViewBackgroundType(int r5) {
            int r0 = -2;
            if (r5 != 0) goto L5;
            int r1 = -2;
        L7:
            if (r5 == (getCount() - 1)) goto L10;
            r0 = getItem(r5 + 1).getViewType();
        L10:
            int r4 = getItem(r5).getViewType();
            if (r4 != r1) goto L16;
            if (r4 != r0) goto L14;
            return 3;
        L14:
            return 4;
        L16:
            if (r4 != r0) goto L21;
            if (r4 != 6) goto L19;
            return 3;
        L19:
            return 2;
        L21:
            if (r4 != 6) goto L23;
            return 4;
        L23:
            return 1;
        L5:
            r1 = getItem(r5 - 1).getViewType();
            goto L7
        }

        private View getButtonsView(int r2, View r3, ViewGroup r4) {
            if (r3 != null) goto L6;
            View r5 = RecycleItemDetailFragment.access$400(this.this$0).inflate(R.layout.recycle_item_detail_buttons_entry_view, r4, false);
            ((OCardListItem) r5.findViewById(R.id.btn_action_restore)).setOnContentClickListener(new AnonymousClass1(this));
            ((OCardListItem) r5.findViewById(R.id.btn_action_delete_permanently)).setOnContentClickListener(new AnonymousClass2(this));
            return r5;
        L6:
            return r3;
        }

        private View getHeaderEntryView(View r6, ViewGroup r7) {
            View r8 = RecycleItemDetailFragment.access$400(this.this$0).inflate(R.layout.detail_header_contact_without_updates, r7, false);
            HeaderViewCache r9 = new HeaderViewCache(r8, R.layout.detail_header_contact_without_updates);
            TextView r0 = r9.displayNameView;
            if (TextUtils.isEmpty(RecycleItemDetailFragment.access$600(this.this$0).displayName) == false) goto L5;
            String r2 = RecycleItemDetailFragment.access$700(this.this$0).getResources().getString(R.string.missing_name);
        L6:
            r0.setText(r2);
            ContactDetailDisplayUtils.setCombinedTextWithDivider(RecycleItemDetailFragment.access$700(this.this$0), r9.companyAndNoteView, RecycleItemDetailFragment.access$800(this.this$0), ContactDetailDisplayUtils.getNote(RecycleItemDetailFragment.access$900(this.this$0)));
            r9.phoneticNameView.setVisibility(8);
            r9.phoneticNameView.setText(null);
            if (r9.photoView == null) goto L20;
            byte[] r1 = RecycleItemDetailFragment.access$600(this.this$0).photoBytes;
            if ((r9.photoView instanceof AvatarImageView) == false) goto L15;
            AvatarImageView r3 = (AvatarImageView) r9.photoView;
            if (r1 == null) goto L13;
            boolean r4 = true;
        L14:
            r3.setStrokeEnabled(r4);
            goto L15
        L13:
            r4 = false;
        L15:
            if (r1 == null) goto L17;
            Bitmap r5 = BitmapFactory.decodeByteArray(r1, 0, r1.length);
        L18:
            if (r5 == null) goto L20;
            r9.photoView.setImageBitmap(NameAvatarController.getCircleBitmap(r5, false));
            goto L20
        L17:
            r5 = ContactsUtils.creatBitmapFromName(RecycleItemDetailFragment.access$700(this.this$0), RecycleItemDetailFragment.access$600(this.this$0).displayName);
        L20:
            final TextView r10 = (TextView) r8.findViewById(R.id.name);
            r10.addTextChangedListener(new AnonymousClass3(this, r10));
            ListContentItem r11 = (ListContentItem) r8.findViewById(R.id.lcic_contact_detail_head);
            RelativeLayout.LayoutParams r12 = (RelativeLayout.LayoutParams) r11.getLayoutParams();
            int r13 = (int) RecycleItemDetailFragment.access$700(this.this$0).getResources().getDimension(R.dimen.detail_item_divider_height);
            r12.topMargin = r13;
            if (RecycleItemDetailFragment.access$1000(this.this$0).size() > 0) goto L23;
            r12.bottomMargin = r13;
        L23:
            r11.setLayoutParams(r12);
            return r8;
        L5:
            r2 = RecycleItemDetailFragment.access$600(this.this$0).displayName;
            goto L6
        }

        private View getNoteEntryView(int r4, View r5, ViewGroup r6) {
            ContactDetailFragment.DetailViewEntry r0 = (ContactDetailFragment.DetailViewEntry) getItem(r4);
            if (r5 == null) goto L5;
            DetailViewCache r7 = (DetailViewCache) r5.getTag();
        L6:
            bindDetailView(r4, r5, r0);
            return r5;
        L5:
            r5 = RecycleItemDetailFragment.access$400(this.this$0).inflate(R.layout.contact_detail_note_item, r6, false);
            r5.setTag(new DetailViewCache(r5));
            goto L6
        }

        private View getSeparatorEntryView(int r1, View r2, ViewGroup r3) {
            SeparatorViewEntry r4 = (SeparatorViewEntry) getItem(r1);
            if (r2 == null) goto L6;
            return r2;
        L6:
            return RecycleItemDetailFragment.access$400(this.this$0).inflate(R.layout.contact_detail_separator_entry_view, r3, false);
        }

        private View getKindTitleEntryView(int r2, View r3, ViewGroup r4) {
            KindTitleViewEntry r5 = (KindTitleViewEntry) getItem(r2);
            if (r3 != null) goto L6;
            r3 = RecycleItemDetailFragment.access$400(this.this$0).inflate(R.layout.list_separator, r4, false);
        L6:
            ((TextView) r3.findViewById(R.id.title)).setText(r5.getTitle());
            return r3;
        }

        private View getDetailEntryView(int r4, View r5, ViewGroup r6) {
            ContactDetailFragment.DetailViewEntry r0 = (ContactDetailFragment.DetailViewEntry) getItem(r4);
            if (r5 != null) goto L5;
        L7:
            r5 = RecycleItemDetailFragment.access$400(this.this$0).inflate(R.layout.contact_detail_list_item, r6, false);
            r5.setTag(new DetailViewCache(r5));
        L8:
            bindDetailView(r4, r5, r0);
            return r5;
        L5:
            if (r5.getTag() == null) goto L7;
            goto L7
        }

        private void bindDetailView(int r6, View r7, ContactDetailFragment.DetailViewEntry r8) {
            Resources r0 = RecycleItemDetailFragment.access$700(this.this$0).getResources();
            DetailViewCache r9 = (DetailViewCache) r7.getTag();
            if (TextUtils.isEmpty(r8.typeString) == false) goto L5;
        L7:
            r9.type.setVisibility(8);
        L9:
            if ("vnd.android.cursor.item/postal-address_v2".equals(r8.mimetype) == false) goto L12;
            setMaxLines(r9.data, r8.maxLines);
            LinearLayout.LayoutParams r1 = (LinearLayout.LayoutParams) r9.primaryActionViewChild.getLayoutParams();
            int r2 = r0.getDimensionPixelSize(R.dimen.detail_item_vertical_margin);
            r1.setMargins(r1.leftMargin, r2, r1.rightMargin, r2);
            r9.primaryActionViewChild.setLayoutParams(r1);
        L12:
            if ("vnd.android.cursor.item/phone_v2".equals(r8.mimetype) == false) goto L14;
            int r3 = (int) RecycleItemDetailFragment.access$700(this.this$0).getResources().getDimension(R.dimen.contact_detail_phone_number_button_merge);
            r9.data.setPadding(r9.data.getPaddingLeft(), r9.data.getPaddingTop(), r3, r9.data.getPaddingBottom());
        L14:
            r9.data.setText(r8.data);
            int r10 = getViewBackgroundType(r6);
            if (r10 != 4) goto L17;
        L18:
            RelativeLayout.LayoutParams r11 = (RelativeLayout.LayoutParams) r9.listItemContainer.getLayoutParams();
            r11.bottomMargin = ContactsUtils.dipTopx(RecycleItemDetailFragment.access$700(this.this$0), 16.0d);
            r9.listItemContainer.setLayoutParams(r11);
        L19:
            LinearLayout.LayoutParams r12 = (LinearLayout.LayoutParams) r9.primaryActionViewChild.getLayoutParams();
            r12.width = -1;
            r12.rightMargin = (int) RecycleItemDetailFragment.access$700(this.this$0).getResources().getDimension(R.dimen.detail_sparator_title_margin_left);
            if (r8.mimetype != null) goto L22;
        L26:
            r9.data.setText(r8.data);
            return;
        L22:
            if (r8.mimetype.startsWith(ContactsUtils.WECHAT_MIMETYPE_PREFIX) == false) goto L24;
        L25:
            r9.type.setText(r8.typeString);
            goto L26
        L24:
            if (r8.mimetype.startsWith(ContactsUtils.QQ_MIMETYPE) == false) goto L26;
        L17:
            if (r10 != 1) goto L19;
        L5:
            if (r8.isNote == true) goto L7;
            r9.type.setText(r8.typeString);
            r9.type.setVisibility(0);
            goto L9
        }

        private void setMaxLines(TextView r1, int r2) {
            if (r2 != 1) goto L5;
            r1.setSingleLine(true);
        L6:
            r1.setEllipsize(TextUtils.TruncateAt.END);
            return;
        L5:
            r1.setSingleLine(false);
            r1.setMaxLines(r2);
            goto L6
        }
    }

    public RecycleItemDetailFragment() {
        this.mPhoneEntries = new ArrayList();
        this.mEmailEntries = new ArrayList();
        this.mPostalEntries = new ArrayList();
        this.mImEntries = new ArrayList();
        this.mNicknameEntries = new ArrayList();
        this.mRelationEntries = new ArrayList();
        this.mNoteEntries = new ArrayList();
        this.mWebsiteEntries = new ArrayList();
        this.mSipEntries = new ArrayList();
        this.mEventEntries = new ArrayList();
        this.mOtherEntriesMap = new HashMap();
        this.mAllEntries = new ArrayList();
    }

    static /* synthetic */ void access$100(RecycleItemDetailFragment r0, RecycleItem r1, boolean r2) {
        r0.doSingleRemoveAction(r1, r2);
    }

    static /* synthetic */ ArrayList access$1000(RecycleItemDetailFragment r0) {
        return r0.mPhoneEntries;
    }

    static /* synthetic */ OInsetSheet access$200(RecycleItemDetailFragment r0) {
        return r0.mOInsetSheet;
    }

    static /* synthetic */ ArrayList access$300(RecycleItemDetailFragment r0) {
        return r0.mAllEntries;
    }

    static /* synthetic */ LayoutInflater access$400(RecycleItemDetailFragment r0) {
        return r0.mInflater;
    }

    static /* synthetic */ void access$500(RecycleItemDetailFragment r0, int r1) {
        r0.showSingleDeletionDialog(r1);
    }

    static /* synthetic */ RecycleItem access$600(RecycleItemDetailFragment r0) {
        return r0.mRecycleItem;
    }

    static /* synthetic */ Context access$700(RecycleItemDetailFragment r0) {
        return r0.mContext;
    }

    static /* synthetic */ String access$800(RecycleItemDetailFragment r0) {
        return r0.mCompany;
    }

    static /* synthetic */ ArrayList access$900(RecycleItemDetailFragment r0) {
        return r0.mNoteEntries;
    }

    public static RecycleItemDetailFragment newInstance() {
        return new RecycleItemDetailFragment();
    }

    public void setRecycleItem(RecycleItem r1) {
        this.mRecycleItem = r1;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mContext = getActivity();
        this.mInflater = r2;
        View r5 = r2.inflate(R.layout.contact_detail_fragment, r3, false);
        ListView r6 = (ListView) r5.findViewById(android.R.id.list);
        this.mListView = r6;
        r6.setScrollBarStyle(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
        OUIHelper.OUIList.setFooterAndHeader(this.mInflater, this.mListView, null, null);
        this.mEmptyView = r5.findViewById(android.R.id.empty);
        return r5;
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        bindData();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        OInsetSheet r0 = this.mOInsetSheet;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L9;
        this.mOInsetSheet.dismiss();
        return;
    }

    private void bindData() {
        buildEntries();
        Collapser.collapseList(this.mPhoneEntries);
        Collapser.collapseList(this.mEmailEntries);
        Collapser.collapseList(this.mPostalEntries);
        Collapser.collapseList(this.mImEntries);
        Collapser.collapseList(this.mNicknameEntries);
        Collapser.collapseList(this.mWebsiteEntries);
        Collapser.collapseList(this.mRelationEntries);
        Collapser.collapseList(this.mEventEntries);
        Collapser.collapseList(this.mSipEntries);
        setupFlattenedList();
        ViewAdapter r0 = new ViewAdapter(this, null);
        this.mAdapter = r0;
        this.mListView.setAdapter(r0);
        this.mAdapter.notifyDataSetChanged();
        this.mListView.setEmptyView(this.mEmptyView);
    }

    private void buildEntries() {
        this.mAllEntries.clear();
        this.mPhoneEntries.clear();
        this.mNoteEntries.clear();
        this.mOtherEntriesMap.clear();
        AccountTypeManager r0 = AccountTypeManager.getInstance(this.mContext);
        AccountWithDataSet r1 = this.mRecycleItem.getSrcAccount();
        if (this.mRecycleItem.getDataRows() == null) goto L104;
        Iterator<ContentValues> r2 = this.mRecycleItem.getDataRows().iterator();
    L6:
        if (r2.hasNext() == false) goto L168;
        ContentValues r3 = r2.next();
        Long r4 = r3.getAsLong("_id");
        String r13 = r3.getAsString("mimetype");
        if (r13 == null) goto L6;
        if (r4 == null) goto L6;
        long r7 = r4.longValue();
        DataKind r14 = r0.getKindOrFallback(r1.type, r1.dataSet, r13);
        if (r14 == null) goto L6;
        ContactDetailFragment.DetailViewEntry r5 = ContactDetailFragment.DetailViewEntry.fromValues(this.mContext, r13, r14, r7, r3, false, -1);
        boolean r6 = !TextUtils.isEmpty(r5.data);
        Integer r8 = r3.getAsInteger("is_super_primary");
        if (r8 != null) goto L17;
    L19:
        boolean r9 = false;
    L20:
        AccountType r10 = r0.getAccountType(r1.type, r1.dataSet);
        if ("vnd.android.cursor.item/name".equals(r13) == true) goto L6;
        if ("vnd.android.cursor.item/phone_v2".equals(r13) == false) goto L28;
        if (r6 == false) goto L28;
        r5.isPrimary = r9;
        this.mPhoneEntries.add(r5);
    L28:
        if ("vnd.android.cursor.item/email_v2".equals(r13) == false) goto L32;
        if (r6 == false) goto L32;
        r5.isPrimary = r9;
        this.mEmailEntries.add(r5);
    L32:
        if ("vnd.android.cursor.item/postal-address_v2".equals(r13) == false) goto L36;
        if (r6 == false) goto L36;
        r5.maxLines = 2;
        this.mPostalEntries.add(r5);
    L36:
        if ("vnd.android.cursor.item/im".equals(r13) == false) goto L40;
        if (r6 == false) goto L40;
        this.mImEntries.add(r5);
    L40:
        if ("vnd.android.cursor.item/organization".equals(r13) == true) goto L41;
        if ("vnd.android.cursor.item/nickname".equals(r13) == false) goto L56;
        if (r6 == false) goto L56;
        this.mNicknameEntries.add(r5);
    L56:
        if ("vnd.android.cursor.item/note".equals(r13) == false) goto L60;
        if (r6 == false) goto L60;
        r5.uri = null;
        r5.maxLines = 100;
        r5.isNote = true;
        this.mNoteEntries.add(r5);
    L60:
        if ("vnd.android.cursor.item/website".equals(r13) == false) goto L64;
        if (r6 == false) goto L64;
        r5.uri = null;
        r5.maxLines = 1;
        this.mWebsiteEntries.add(r5);
    L64:
        if ("vnd.android.cursor.item/sip_address".equals(r13) == false) goto L68;
        if (r6 == false) goto L68;
        r5.uri = null;
        r5.maxLines = 1;
        this.mSipEntries.add(r5);
    L68:
        if ("vnd.android.cursor.item/contact_event".equals(r13) == false) goto L82;
        if (r6 == false) goto L82;
        if (4 == r5.type) goto L73;
    L77:
        r5.data = DateUtils.formatDate(this.mContext, r5.data);
    L78:
        r5.uri = null;
        if (r5.typeString.equals("added time") == true) goto L6;
        this.mEventEntries.add(r5);
        goto L6
    L73:
        if (EntityModifier.hasEditTypes(r14) == false) goto L77;
        if (r14.typeList.contains(new AccountType.EditType(r5.type, -1)) == false) goto L77;
        r5.data = LunarCalendar.getLunarDisplayStringFromLunarDateString(r5.data);
    L82:
        if ("vnd.android.cursor.item/relation".equals(r13) == false) goto L86;
        if (r6 == false) goto L86;
        this.mRelationEntries.add(r5);
    L86:
        if (r14.actionBody == null) goto L93;
        CharSequence r11 = r14.actionBody.inflateUsing(this.mContext, r3);
        if (r11 != null) goto L90;
        String r12 = null;
    L91:
        r5.data = r12;
        goto L93
    L90:
        r12 = r11.toString();
    L93:
        if (r13.startsWith(ContactsUtils.WECHAT_MIMETYPE_PREFIX) == false) goto L96;
        r5.typeString = ContactsContract.CommonDataKinds.Im.getProtocolLabel(this.mContext.getResources(), 100, null).toString();
    L96:
        if (r13.startsWith(ContactsUtils.QQ_MIMETYPE) == false) goto L99;
        r5.typeString = ContactsContract.CommonDataKinds.Im.getProtocolLabel(this.mContext.getResources(), 4, null).toString();
    L99:
        if (TextUtils.isEmpty(r5.data) == true) goto L6;
        if (this.mOtherEntriesMap.containsKey(r10) == true) goto L102;
        ArrayList r15 = new ArrayList();
        r15.add(r5);
        this.mOtherEntriesMap.put(r10, r15);
        goto L6
    L102:
        this.mOtherEntriesMap.get(r10).add(r5);
        goto L6
    L41:
        String r16 = r3.getAsString("data1");
        String r17 = r3.getAsString("data4");
        if (TextUtils.isEmpty(r16) == false) goto L45;
        r16 = r17;
    L49:
        if (TextUtils.isEmpty(r16) == true) goto L6;
        this.mCompany = r16;
        goto L6
    L45:
        if (TextUtils.isEmpty(r17) == true) goto L49;
        r16 = this.mContext.getString(R.string.organization_company_and_title, new Object[]{r16, r17});
        goto L49
    L17:
        if (r8.intValue() == 0) goto L19;
        r9 = true;
        goto L20
    L168:
        return;
    }

    private void setupFlattenedList() {
        this.mAllEntries.add(new HeaderViewEntry());
        flattenList(this.mPhoneEntries, false);
        flattenList(this.mEmailEntries);
        flattenList(this.mImEntries);
        flattenList(this.mNicknameEntries);
        flattenList(this.mWebsiteEntries);
        flattenList(this.mSipEntries);
        flattenList(this.mPostalEntries);
        flattenList(this.mEventEntries);
        flattenList(this.mRelationEntries);
        flattenBtns();
    }

    private void flattenList(ArrayList<ContactDetailFragment.DetailViewEntry> r2) {
        flattenList(r2, true);
    }

    private void flattenList(ArrayList<ContactDetailFragment.DetailViewEntry> r5, boolean r6) {
        int r0 = r5.size();
        if (r0 <= 0) goto L7;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        this.mAllEntries.add(r5.get(r1));
        r1 = r1 + 1;
    L7:
        if (r6 == false) goto L11;
        r5.clear();
        return;
    }

    private void flattenBtns() {
        this.mAllEntries.add(new BtnsViewEntry());
    }

    private void showSingleDeletionDialog(int r13) {
        final RecycleItem r0 = this.mRecycleItem;
        ArrayList r5 = new ArrayList();
        ArrayList r6 = new ArrayList();
        if (r13 != R.id.btn_action_delete_permanently) goto L5;
        OSheetUtils.ContentViewStyle r14 = OSheetUtils.ContentViewStyle.RED;
        String r1 = getString(R.string.delete_single_recycle_contact_dialog_title);
        r5.add(getString(R.string.btn_delete_permanently_confirm));
        r6.add(new AnonymousClass1(this, r0));
    L6:
        String r3 = r1;
        DialogInterface.OnCancelListener r9 = new AnonymousClass3(this);
        Context r2 = getContext();
        OInsetSheet.PanelWidth r4 = OInsetSheet.PanelWidth.NARROW_WIDTH;
        OInsetSheet r15 = OSheetUtils.getOSheet(r2, r4, r3, null, r5, r6, r14, null, r9, true, true);
        this.mOInsetSheet = r15;
        r15.show();
        return;
    L5:
        r14 = OSheetUtils.ContentViewStyle.BLUE;
        r1 = RecycleItem.calcDestAccountsOfSingleItem(this.mContext, r0);
        r5.add(getString(R.string.common_restore));
        r6.add(new AnonymousClass2(this, r0));
        goto L6
    }

    private void doSingleRemoveAction(RecycleItem r2, boolean r3) {
        RecycleItem.deleteSingleRawContact(this.mContext, r3, r2);
        Intent r4 = new Intent();
        r4.putExtra("recycle_item", r2);
        getActivity().setResult(-1, r4);
        getActivity().finish();
    }
}
