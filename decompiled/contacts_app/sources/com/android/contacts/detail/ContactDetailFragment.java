package com.android.contacts.detail;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Entity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListPopupWindow;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import bytedanceos.util.MultiSimAdapter;
import com.GlobalProxyLancet;
import com.android.contacts.AbstractFragment;
import com.android.contacts.Collapser;
import com.android.contacts.ContactFragmentsCallback;
import com.android.contacts.ContactLoader;
import com.android.contacts.ContactPresenceIconUtil;
import com.android.contacts.ContactSaveService;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.contacts.CootekManager;
import com.android.contacts.DSUtils;
import com.android.contacts.GroupMetaData;
import com.android.contacts.NfcHandler;
import com.android.contacts.PhoneCallDetails;
import com.android.contacts.R;
import com.android.contacts.TypePrecedence;
import com.android.contacts.activities.ContactDetailActivity;
import com.android.contacts.calllog.CallLogQueryHandler;
import com.android.contacts.detail.item.action.ContactItemCard;
import com.android.contacts.detail.item.action.PhoneActionEntry;
import com.android.contacts.detail.item.action.PhoneActionViewLayout;
import com.android.contacts.detail.item.button.ContactItemButtonCard;
import com.android.contacts.detail.item.section.SectionEntry;
import com.android.contacts.dialpad.T9Search;
import com.android.contacts.editor.SelectAccountDialogFragment;
import com.android.contacts.interactions.ContactDeletionInteraction;
import com.android.contacts.list.ContactBaseData;
import com.android.contacts.list.ContactDetailCacheManager;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.model.DataKind;
import com.android.contacts.model.EntityDelta;
import com.android.contacts.model.EntityDeltaList;
import com.android.contacts.model.EntityModifier;
import com.android.contacts.numberassistant.NumberInfosManager;
import com.android.contacts.util.AccountsListAdapter;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.BlackListQueryHandler;
import com.android.contacts.util.BytedanceContactContract;
import com.android.contacts.util.Constants;
import com.android.contacts.util.ContactsIntentUtils;
import com.android.contacts.util.DataStatus;
import com.android.contacts.util.HanziToPinyin;
import com.android.contacts.util.OAlertDialogUtils;
import com.android.vcard.VCardConfig;
import com.bytedance.common.utility.UIUtils;
import com.obric.immersive.Immersive;
import com.obric.oui.dialog.v2.action.OActionDialog;
import com.obric.oui.dialog.v2.selection.OSelectionDialog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import com.obric.tracker.CallScreenShowUtils;
import com.obric.tracker.event.CallScreenShowEvent;
import com.obric.ui.OUIHelper;
import com.obric.ui.dialog.OUIDialogHelper;
import com.obric.ui.dialog.action.ActionButtonStyle;
import com.obric.ui.dialog.action.ActionDialogItemData;
import com.obric.ui.dialog.selection.SelectionButton;
import com.obric.ui.dialog.selection.SelectionDialogItemData;
import com.obric.ui.dialog.selection.SelectionType;
import com.obric.ui.popover.Direct;
import com.obric.ui.popover.ItemType;
import com.obric.ui.popover.MenuItemData;
import com.obric.ui.popover.OUIPopoverHelper;
import com.obric.utils.views.commonitemview.ContactsCommonListItem;
import com.obricOld.contacts.menus.LongMenuHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import obric.app.tracker.Agent;
import obric.util.NavigationBarHelper;
import obric.widget.ListContentItemCustom;

/* JADX INFO: loaded from: classes.dex */
public class ContactDetailFragment extends AbstractFragment implements ContactDetailActivity.FragmentKeyListener, SelectAccountDialogFragment.Listener, BlackListQueryHandler.BlackListChangeListener, DSUtils.DSFatureStatusListener {
    private static final int ALL_NUMBER_IN_BLACK_LIST = 1;
    private static final int BLACK_LIST_DEFAULT_TAG = -1;
    static final int CAMCARD_COMPANY_MAX_LINES = 2;
    static final int GROUP_MAX_LINES = 10;
    private static final String KEY_CONTACT_URI = "contactUri";
    private static final String KEY_LIST_STATE = "liststate";
    static final String KEY_NEW_INTENT = "new_intent";
    private static final int MSG_UPDATE_LOCATION_INFO = 1001;
    static final int NOTE_MAX_LINES = 100;
    private static final int NOT_ALL_NUMBER_IN_BLACK_LIST = 0;
    static final int POSTAL_ADDRESS_MAX_LINES = 2;
    static final int SIP_ADDRESS_MAX_LINES = 1;
    public static final String TAG = "ContactDetailFragment";
    static final int WEBSITE_MAX_LINES = 1;
    private static final boolean isDebug = false;
    private String contactsName;
    private FragmentActivity mActivity;
    private ViewAdapter mAdapter;
    private ArrayList<ViewEntry> mAllEntries;
    private Dialog mBarcodeDialog;
    private BlackListQueryHandler mBlackListHandler;
    private int mBlackListViewRefreshFlag;
    private View mBlacklistPhoto;
    private Function5<Boolean, Boolean, Boolean, TextView, View, Unit> mBlockedBtnClick;
    private BlockedContentHelper mBlockedContentHelper;
    private Set<String> mCachedPhoneNumber;
    private CallLogQueryHandler.Listener mCalLogQueryHandlerListener;
    public Callback mCallback;
    private ArrayList<DetailViewEntry> mCamCardCompanyEntries;
    private ArrayList<DetailViewEntry> mCardIdEntries;
    private ContactLoader.Result mContactData;
    private ContactDetailBuildEntryTask mContactDetailBuildEntryTask;
    private Context mContext;
    private Set<String> mCurrentPhoneNumber;
    private String mDisplayName;
    private ArrayList<DetailViewEntry> mEmailEntries;
    private View mEmptyView;
    private ArrayList<DetailViewEntry> mEventEntries;
    private HashSet<String> mFavoriteNumberList;
    private ContactFragmentsCallback mFragmentsCallback;
    private boolean mFreeCallAvailable;
    private ArrayList<String> mFreeCallNumberList;
    private boolean mFromBCR;
    private ArrayList<DetailViewEntry> mGenderEntries;
    private ArrayList<DetailViewEntry> mGroupEntries;
    private boolean mHasCallLog;
    private boolean mHasPhone;
    private boolean mHasSms;
    private ArrayList<DetailViewEntry> mImEntries;
    private LayoutInflater mInflater;
    private float mInitialAlphaValue;
    private int mInterceptType;
    private boolean mIsUniqueEmail;
    private boolean mIsUniqueNumber;
    private Parcelable mListState;
    private ListView mListView;
    private Listener mListener;
    private Handler mLocationWorkerHandler;
    private Uri mLookupUri;
    private OPopover mMenuPopover;
    private Observer<Integer> mNavigationBarObserver;
    private String mNeedHighlighNumber;
    private ArrayList<String> mNeedHighlightNumbers;
    private boolean mNeedRequeryFreeCall;
    private BroadcastReceiver mNetworkConnStatusReceiver;
    private ArrayList<DetailViewEntry> mNicknameEntries;
    private ArrayList<DetailViewEntry> mNoteEntries;
    private int mNumberMainMarkClassify;
    AdapterView.OnItemClickListener mOnItemClickListener;
    private Map<AccountType, List<DetailViewEntry>> mOtherEntriesMap;
    private ArrayList<DetailViewEntry> mPhoneEntries;
    private ArrayList<String> mPhoneNumberList;
    private int mPhoneSize;
    private int mPhotoViewRefreshFlag;
    private ArrayList<DetailViewEntry> mPostalEntries;
    private Uri mPrimaryPhoneUri;
    private ArrayList<Long> mRawContactIds;
    private ArrayList<DetailViewEntry> mRelationEntries;
    private boolean mShowStaticPhoto;
    private ArrayList<DetailViewEntry> mSipEntries;
    private ArrayList<DetailViewEntry> mSmsEntries;
    private OActionDialog mStarActionDialog;
    private ImageView mStaticPhotoView;
    private boolean mUseStrictPhoneNumberComparation;
    private AbsListView.OnScrollListener mVerticalScrollListener;
    private View mView;
    private ArrayList<DetailViewEntry> mWebsiteEntries;
    private HandlerThread mWorkerThread;

    private class AddToMyContactsQuickFix extends QuickFix {
        final /* synthetic */ ContactDetailFragment this$0;

        private AddToMyContactsQuickFix(ContactDetailFragment r1) {
            this.this$0 = r1;
            super(null);
        }

        @Override // com.android.contacts.detail.ContactDetailFragment.QuickFix
        public boolean isApplicable() {
            boolean r1 = false;
            if (ContactDetailFragment.access$4700(this.this$0) != null) goto L5;
        L34:
            return false;
        L5:
            if (ContactDetailFragment.access$4700(this.this$0).isDirectoryEntry() == true) goto L34;
            if (ContactDetailFragment.access$4700(this.this$0).isUserProfile() == false) goto L11;
            return false;
        L11:
            if (ContactDetailFragment.access$4700(this.this$0).getEntities().size() == 1) goto L13;
            return false;
        L13:
            List<GroupMetaData> r0 = ContactDetailFragment.access$4700(this.this$0).getGroupMetaData();
            if (r0 != null) goto L16;
            return false;
        L16:
            long r3 = ContactDetailFragment.access$7500(this.this$0, r0);
            if (r3 != (-1)) goto L19;
            return false;
        L19:
            Entity r2 = ContactDetailFragment.access$4700(this.this$0).getEntities().get(0);
            ContentValues r5 = r2.getEntityValues();
            AccountType r8 = AccountTypeManager.getInstance(ContactDetailFragment.access$600(this.this$0)).getAccountType(r5.getAsString("account_type"), r5.getAsString("data_set"));
            if (r8 == null) goto L34;
            if (r8.areContactsWritable() == false) goto L34;
            Iterator<Entity.NamedContentValues> r9 = r2.getSubValues().iterator();
        L26:
            if (r9.hasNext() == false) goto L33;
            Entity.NamedContentValues r4 = r9.next();
            if ("vnd.android.cursor.item/group_membership".equals(r4.values.getAsString("mimetype")) == false) goto L26;
            if (r4.values.getAsLong("data1").longValue() != r3) goto L26;
            r1 = true;
        L33:
            return !r1;
        }

        @Override // com.android.contacts.detail.ContactDetailFragment.QuickFix
        public String getTitle() {
            return this.this$0.getString(R.string.add_to_my_contacts);
        }

        @Override // com.android.contacts.detail.ContactDetailFragment.QuickFix
        public void execute() {
            ContactDetailFragment r0 = this.this$0;
            long r1 = ContactDetailFragment.access$7500(r0, ContactDetailFragment.access$4700(r0).getGroupMetaData());
            if (r1 != (-1)) goto L5;
            return;
        L5:
            EntityDeltaList r4 = EntityDeltaList.fromIterator(ContactDetailFragment.access$4700(this.this$0).getEntities().iterator());
            EntityDelta r2 = r4.get(0);
            AccountTypeManager r3 = AccountTypeManager.getInstance(ContactDetailFragment.access$600(this.this$0));
            EntityDelta.ValuesDelta r5 = r2.getValues();
            EntityModifier.insertChild(r2, r3.getAccountType(r5.getAsString("account_type"), r5.getAsString("data_set")).getKindForMimetype("vnd.android.cursor.item/group_membership")).put("data1", r1);
            FragmentActivity r11 = this.this$0.getActivity();
            if (r11 == null) goto L9;
            r11.startService(ContactSaveService.createSaveContactIntent(r11, r4, "", 0, false, r11.getClass(), "android.intent.action.VIEW", null));
            return;
        }
    }

    private static class BtnsViewEntry extends ViewEntry {
        BtnsViewEntry() {
            super(4);
        }

        BtnsViewEntry(int r1) {
            super(r1);
        }
    }

    private static class BusinessCardEntry extends ViewEntry {
        BusinessCardEntry() {
            super(8);
        }
    }

    public interface Callback {
        void cancelShareContact();

        void clearUpCallLog();

        void doDeleteContact();

        PhoneCallDetails[] getPhoneCallDetails();

        boolean hasCallLog();

        void makeFreeCall(List<String> r1, boolean r2);

        void playBlacklistSound(boolean r1);

        void setShareContact(String r1);

        void setShareTextContact();

        void setShowContactCalllog(String r1, List<String> r2, boolean r3, int r4);

        void setTitle(String r1);

        void startVolteCall(String r1);

        void startVolteCall(List<String> r1);
    }

    private static class CalllogViewEntry extends ViewEntry {
        CalllogViewEntry() {
            super(11);
        }
    }

    private interface ContextMenuIds {
        public static final int CLEAR_DEFAULT = 1;
        public static final int COPY_TEXT = 0;
        public static final int SET_DEFAULT = 2;
    }

    private static class CustomRingtoneViewEntry extends ViewEntry {
        Thread loadRingtoneName;
        private Context mContext;
        Uri mRingtoneUri;
        private String mTitle;

        static /* synthetic */ Context access$4900(CustomRingtoneViewEntry r0) {
            return r0.mContext;
        }

        static /* synthetic */ String access$5002(CustomRingtoneViewEntry r0, String r1) {
            r0.mTitle = r1;
            return r1;
        }

        CustomRingtoneViewEntry(Context r2, Uri r3) {
            super(7);
            this.mTitle = null;
            this.mContext = null;
            this.mRingtoneUri = null;
            Thread r0 = new AnonymousClass1(this);
            this.loadRingtoneName = r0;
            this.mContext = r2;
            this.mRingtoneUri = r3;
            r0.start();
        }

        public String getTitle() {
            if (TextUtils.isEmpty(this.mTitle) == false) goto L6;
            this.mTitle = ContactsUtils.getContactRingtoneTitle(this.mContext, this.mRingtoneUri);
        L6:
            return this.mTitle;
        }
    }

    private static class DetailViewCache {
        public final ContactItemCard contactItemCard;
        public final ActionViewContainerFrame contentItemCustom;
        public final TextView data;
        public final ImageView presenceIcon;
        public final View primaryActionView;
        public final RelativeLayout primaryActionViewChild;
        public final View star;
        public final TextView type;

        public DetailViewCache(View r1, ContactsCommonListItem.ContactsCommonListItemClickListener r2, View.OnClickListener r3, View.OnClickListener r4) {
            this.type = (TextView) r1.findViewById(R.id.type);
            this.data = (TextView) r1.findViewById(R.id.data);
            this.presenceIcon = (ImageView) r1.findViewById(R.id.presence_icon);
            this.star = r1.findViewById(R.id.starCheckbox);
            this.primaryActionView = r1.findViewById(R.id.primary_action_view);
            this.primaryActionViewChild = (RelativeLayout) r1.findViewById(R.id.primary_action_child);
            this.contentItemCustom = (ActionViewContainerFrame) r1.findViewById(R.id.lcit_action_view);
            ContactItemCard r5 = (ContactItemCard) r1.findViewById(R.id.actions_view_container);
            this.contactItemCard = r5;
            r5.setOnClickListener(r2);
        }
    }

    public static class DetailViewEntry extends ViewEntry implements Collapser.Collapsible<DetailViewEntry> {
        public Integer cardTopPadding;
        public int chatCapability;
        public int collapseCount;
        public Context context;
        public String data;
        public CharSequence footerLine;
        public ArrayList<Long> ids;
        public Intent intent;
        public boolean isNote;
        public boolean isPrimary;
        public String kind;
        private boolean mIsInSubSection;
        public boolean mStarred;
        public int maxLines;
        public String mimetype;
        public int presence;
        public String rawData;
        public String resPackageName;
        public int secondaryActionDescription;
        public int secondaryActionIcon;
        public Intent secondaryIntent;
        public ArrayList<Intent> socialIntents;
        public int type;
        public String typeString;
        public Uri uri;

        @Override // com.android.contacts.Collapser.Collapsible
        public /* bridge */ /* synthetic */ boolean collapseWith(DetailViewEntry r1) {
            return collapseWith2(r1);
        }

        @Override // com.android.contacts.Collapser.Collapsible
        public /* bridge */ /* synthetic */ boolean shouldCollapseWith(DetailViewEntry r1) {
            return shouldCollapseWith2(r1);
        }

        DetailViewEntry() {
            super(0);
            this.type = -1;
            this.maxLines = 1;
            this.isNote = false;
            this.context = null;
            this.resPackageName = null;
            this.isPrimary = false;
            this.secondaryActionIcon = -1;
            this.secondaryActionDescription = -1;
            this.secondaryIntent = null;
            this.ids = new ArrayList();
            this.collapseCount = 0;
            this.presence = -1;
            this.chatCapability = 0;
            this.mStarred = false;
            this.footerLine = null;
            this.mIsInSubSection = false;
            this.cardTopPadding = null;
            this.isEnabled = true;
        }

        DetailViewEntry(int r5) {
            super(r5);
            this.type = -1;
            this.maxLines = 1;
            this.isNote = false;
            this.context = null;
            this.resPackageName = null;
            this.isPrimary = false;
            this.secondaryActionIcon = -1;
            this.secondaryActionDescription = -1;
            this.secondaryIntent = null;
            this.ids = new ArrayList();
            this.collapseCount = 0;
            this.presence = -1;
            this.chatCapability = 0;
            this.mStarred = false;
            this.footerLine = null;
            this.mIsInSubSection = false;
            this.cardTopPadding = null;
            this.isEnabled = true;
        }

        public static DetailViewEntry fromValues(Context r4, String r5, DataKind r6, long r7, ContentValues r9, boolean r10, long r11) {
            if (r5.equals("vnd.android.cursor.item/phone_v2") == false) goto L6;
            DetailViewEntry r1 = new DetailViewEntry(6);
        L9:
            r1.id = r7;
            r1.context = r4;
            Uri r8 = ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, r1.id);
            r1.uri = r8;
            if (r10 == false) goto L12;
            r1.uri = r8.buildUpon().appendQueryParameter("directory", String.valueOf(r11)).build();
        L12:
            r1.mimetype = r5;
            if (r6.titleRes != (-1)) goto L15;
        L18:
            String r12 = "";
        L19:
            r1.kind = r12;
            r1.data = ContactDetailFragment.access$5100(r6, r9, r4);
            r1.resPackageName = r6.resPackageName;
            if (r6.typeColumn != null) goto L22;
        L38:
            int r13 = EntityModifier.guessBestValidLabelResourceFromMimeType(r5);
            if (r13 != (-1)) goto L41;
            r1.typeString = r1.kind;
        L43:
            if (ContactsUtils.isFeatureUSEnabled() == false) goto L45;
        L50:
            return r1;
        L45:
            if ("vnd.android.cursor.item/phone_v2".equals(r5) == false) goto L50;
            if (r9 == null) goto L50;
            String r14 = r9.getAsString(BytedanceContactContract.BytedancePhoneColumn.NUMBER_LOCATION_NAME);
            if (TextUtils.isEmpty(r14) == true) goto L50;
            r1.typeString += HanziToPinyin.Token.SEPARATOR + r14;
            goto L50
        L41:
            r1.typeString = r4.getString(r13);
            goto L43
        L22:
            if (r9.getAsInteger(r6.typeColumn) == null) goto L38;
            r1.type = r9.getAsInteger(r6.typeColumn).intValue();
            r1.typeString = "";
            Iterator<AccountType.EditType> r15 = r6.typeList.iterator();
        L25:
            if (r15.hasNext() == false) goto L33;
            AccountType.EditType r16 = r15.next();
            if (r16.rawValue != r1.type) goto L25;
            if (r16.customColumn != null) goto L31;
            r1.typeString = r4.getString(r16.labelRes);
            goto L33
        L31:
            r1.typeString = r9.getAsString(r16.customColumn);
        L33:
            if (TextUtils.isEmpty(r1.typeString) == false) goto L43;
            AccountType.EditType r17 = EntityModifier.guessBestValidTypeFromKind(r6);
            if (r17 == null) goto L37;
            r1.typeString = r4.getString(r17.labelRes);
            goto L43
        L37:
            r1.typeString = r1.kind;
            goto L43
        L15:
            if (r6.titleRes == 0) goto L18;
            r12 = r4.getString(r6.titleRes);
            goto L19
        L6:
            if (r5.equals("vnd.android.cursor.item/note") == false) goto L8;
            r1 = new DetailViewEntry(5);
            goto L9
        L8:
            r1 = new DetailViewEntry();
            goto L9
        }

        public DetailViewEntry applyStatus(DataStatus r2, boolean r3) {
            this.presence = r2.getPresence();
            if (r3 == true) goto L5;
        L7:
            return this;
        L5:
            if (r2.isValid() == false) goto L7;
            this.data = r2.getStatus().toString();
            this.footerLine = r2.getTimestampLabel(this.context);
            goto L7
        }

        public void setStarred(boolean r1) {
            this.mStarred = r1;
        }

        public boolean isStarred() {
            return this.mStarred;
        }

        public void setIsInSubSection(boolean r1) {
            this.mIsInSubSection = r1;
        }

        public boolean isInSubSection() {
            return this.mIsInSubSection;
        }

        /* JADX INFO: renamed from: collapseWith, reason: avoid collision after fix types in other method */
        public boolean collapseWith2(DetailViewEntry r5) {
            if (shouldCollapseWith2(r5) == true) goto L7;
            return false;
        L7:
            if (TypePrecedence.getTypePrecedence(this.mimetype, this.type) <= TypePrecedence.getTypePrecedence(r5.mimetype, r5.type)) goto L9;
            this.type = r5.type;
            this.kind = r5.kind;
            this.typeString = r5.typeString;
        L9:
            this.maxLines = Math.max(this.maxLines, r5.maxLines);
            if (ContactsContract.StatusUpdates.getPresencePrecedence(this.presence) >= ContactsContract.StatusUpdates.getPresencePrecedence(r5.presence)) goto L13;
            this.presence = r5.presence;
        L13:
            if (r5.isPrimary == false) goto L15;
            boolean r0 = true;
        L16:
            this.isPrimary = r0;
            this.ids.add(Long.valueOf(r5.getId()));
            this.collapseCount++;
            return true;
        L15:
            r0 = this.isPrimary;
            goto L16
        }

        /* JADX INFO: renamed from: shouldCollapseWith, reason: avoid collision after fix types in other method */
        public boolean shouldCollapseWith2(DetailViewEntry r11) {
            if (r11 != null) goto L6;
            return false;
        L6:
            if (TextUtils.equals(this.mimetype, r11.mimetype) == true) goto L8;
        L16:
            String r3 = this.mimetype;
            String r4 = this.data;
            String r5 = r11.mimetype;
            String r6 = r11.data;
            if (this.type != r11.type) goto L19;
            boolean r8 = true;
        L21:
            if (ContactsUtils.shouldCollapse(r3, r4, r5, r6, true, r8) == true) goto L24;
            return false;
        L24:
            if (TextUtils.equals(this.mimetype, r11.mimetype) == true) goto L26;
        L31:
            return false;
        L26:
            if (ContactsIntentUtils.areIntentActionEqual(this.intent, r11.intent) == false) goto L31;
            if (ContactsIntentUtils.areIntentActionEqual(this.secondaryIntent, r11.secondaryIntent) == false) goto L31;
            return true;
        L19:
            r8 = false;
            goto L21
        L8:
            if (TextUtils.equals(this.mimetype, "vnd.android.cursor.item/im") == false) goto L16;
            if (this.type != r11.type) goto L12;
            boolean r9 = true;
        L14:
            if (ContactsUtils.shouldCollapse(this.mimetype, this.data, r11.mimetype, r11.data, true, r9) == true) goto L24;
            return false;
        L12:
            r9 = false;
            goto L14
        }

        @Override // com.android.contacts.detail.ContactDetailFragment.ViewEntry
        public void click(View r2, Listener r3, Map<String, Object> r4) {
            if (r3 != null) goto L4;
            return;
        L4:
            if (this.intent == null) goto L27;
            String r5 = this.mimetype;
            if (r5 != null) goto L9;
        L18:
            if (r4 == null) goto L20;
            Intent r6 = (Intent) r4.get(ContactDetailFragment.KEY_NEW_INTENT);
        L21:
            if (r6 == null) goto L23;
            r3.onItemClicked(r6);
            return;
        L23:
            r3.onItemClicked(this.intent);
            return;
        L20:
            r6 = null;
            goto L21
        L9:
            if (r5.startsWith(ContactsUtils.WECHAT_MIMETYPE_PREFIX) == false) goto L11;
        L12:
            ArrayList<Intent> r7 = this.socialIntents;
            if (r7 == null) goto L18;
            if (r7.size() <= 1) goto L18;
            r3.on3rdSocialItemClicked(this.data, this.socialIntents);
            return;
        L11:
            if (this.mimetype.startsWith(ContactsUtils.WHATSAPP_MINTYPE) == false) goto L18;
        }
    }

    private class FreeCallRequeryTask extends AsyncTask<HashMap<String, Boolean>, Void, Boolean> {
        final /* synthetic */ ContactDetailFragment this$0;

        private FreeCallRequeryTask(ContactDetailFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ FreeCallRequeryTask(ContactDetailFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Boolean doInBackground(HashMap<String, Boolean>[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Boolean r1) {
            onPostExecute2(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Boolean doInBackground2(HashMap<String, Boolean>... r5) {
            int r4 = 0;
            HashMap<String, Boolean> r6 = r5[0];
            if (r6 == null) goto L5;
            String[] r0 = new String[r6.size()];
            boolean[] r1 = new boolean[r6.size()];
            Iterator<Map.Entry<String, Boolean>> r7 = r6.entrySet().iterator();
        L8:
            if (r7.hasNext() == false) goto L10;
            Map.Entry<String, Boolean> r2 = r7.next();
            r0[r4] = r2.getKey();
            r1[r4] = r2.getValue().booleanValue();
            r4 = r4 + 1;
            goto L8
        L10:
            boolean[] r8 = CootekManager.getInstance().areUsersExist(r0);
            if (ContactsUtils.DEBUG == false) goto L14;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ContactDetailFragment.TAG, "query numbers = " + Arrays.toString(r0));
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ContactDetailFragment.TAG, "current result = " + Arrays.toString(r1));
        L14:
            if (Arrays.equals(r1, r8) == false) goto L18;
            return Boolean.FALSE;
        L18:
            if (ContactsUtils.DEBUG == false) goto L20;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ContactDetailFragment.TAG, "updated result = " + Arrays.toString(r8));
        L20:
            FreeCallHelper.getMe().updateCache(r0, r8);
            return Boolean.TRUE;
        L5:
            return Boolean.FALSE;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Boolean r4) {
            ContactDetailFragment r0 = this.this$0;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.isVisible() == true) goto L7;
            return;
        L7:
            if (r4.booleanValue() == false) goto L12;
            new Handler().postDelayed(new AnonymousClass1(this), 100);
            return;
        }
    }

    static class GroupNameWithID extends ContactBaseData {
        public long gid;
        public String gname;

        public GroupNameWithID(long r1, String r3) {
            this.gid = r1;
            this.gname = r3;
            this.name = r3;
            this.hasname = !TextUtils.isEmpty(this.name);
            this.sortkey = ContactsUtils.getPinyinChineseName(this.name);
            this.section = ContactsUtils.getContactSection(this.sortkey);
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

    private static class HeaderViewEntry extends ViewEntry {
        HeaderViewEntry() {
            super(1);
        }
    }

    private static final class InvitableAccountTypesAdapter extends BaseAdapter {
        private final ArrayList<AccountType> mAccountTypes;
        private final ContactLoader.Result mContactData;
        private final Context mContext;
        private final LayoutInflater mInflater;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        public InvitableAccountTypesAdapter(Context r3, ContactLoader.Result r4) {
            this.mContext = r3;
            this.mInflater = LayoutInflater.from(r3);
            this.mContactData = r4;
            ArrayList<AccountType> r5 = r4.getInvitableAccountTypes();
            this.mAccountTypes = new ArrayList(r5.size());
            AccountTypeManager.getInstance(r3);
            int r6 = 0;
        L4:
            if (r6 >= r5.size()) goto L6;
            this.mAccountTypes.add(r5.get(r6));
            r6 = r6 + 1;
            goto L4
        L6:
            Collections.sort(this.mAccountTypes, new AccountType.DisplayLabelComparator(this.mContext));
        }

        @Override // android.widget.Adapter
        public View getView(int r7, View r8, ViewGroup r9) {
            if (r8 != null) goto L6;
            r8 = this.mInflater.inflate(R.layout.account_selector_list_item, r9, false);
        L6:
            TextView r10 = (TextView) r8.findViewById(R.id.text1);
            TextView r1 = (TextView) r8.findViewById(R.id.text2);
            ImageView r2 = (ImageView) r8.findViewById(R.id.icon);
            AccountType r11 = this.mAccountTypes.get(r7);
            CharSequence r3 = r11.getInviteContactActionLabel(this.mContext);
            CharSequence r4 = r11.getDisplayLabel(this.mContext);
            if (TextUtils.isEmpty(r3) == false) goto L9;
            r10.setText(r4);
            r1.setVisibility(8);
        L10:
            r2.setImageDrawable(r11.getDisplayIcon(this.mContext));
            return r8;
        L9:
            r10.setText(r3);
            r1.setVisibility(0);
            r1.setText(r4);
            goto L10
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mAccountTypes.size();
        }

        @Override // android.widget.Adapter
        public AccountType getItem(int r1) {
            return this.mAccountTypes.get(r1);
        }
    }

    private static class KindTitleViewEntry extends ViewEntry {
        private final String mTitle;

        KindTitleViewEntry(String r2) {
            super(2);
            this.mTitle = r2;
        }

        public String getTitle() {
            return this.mTitle;
        }
    }

    public interface Listener {
        void on3rdSocialItemClicked(String r1, List<Intent> r2);

        void onCreateRawContactRequested(ArrayList<ContentValues> r1, AccountWithDataSet r2);

        void onItemClicked(Intent r1);
    }

    private static class LocationWorkerHandler extends Handler {
        private Context mContext;

        static /* synthetic */ Context access$8400(LocationWorkerHandler r0) {
            return r0.mContext;
        }

        public LocationWorkerHandler(Context r1, Looper r2) {
            super(r2);
            this.mContext = r1.getApplicationContext();
        }

        @Override // android.os.Handler
        public void handleMessage(Message r4) {
            if (r4.what == 1001) goto L6;
            return;
        L6:
            if (r4.getData() != null) goto L19;
            return;
        L19:
            ContentValues r5 = (ContentValues) r4.getData().getParcelable("entryValues");     // Catch: Exception -> L16
            if (r5 != null) goto L11;
            return;
        L11:
            if ("vnd.android.cursor.item/phone_v2".equals(r5.getAsString("mimetype")) == false) goto L21;
            final long r0 = r5.getAsLong("_id").longValue();     // Catch: Exception -> L16
            String r6 = r5.getAsString("data1");     // Catch: Exception -> L16
            NumberInfosManager.NumberInfosListenerAdatper r2 = new AnonymousClass1(this, r0);     // Catch: Exception -> L16
            NumberInfosManager.getInstance().getBaseInfos(r6, r2);     // Catch: Exception -> L16
            return;
        L21:
            return;
        L16:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ContactDetailFragment.TAG, "Exception occurred when update location, ignore it for the present.");
            e.printStackTrace();
        }
    }

    private class MakeLocalCopyQuickFix extends QuickFix {
        final /* synthetic */ ContactDetailFragment this$0;

        private MakeLocalCopyQuickFix(ContactDetailFragment r1) {
            this.this$0 = r1;
            super(null);
        }

        @Override // com.android.contacts.detail.ContactDetailFragment.QuickFix
        public boolean isApplicable() {
            if (ContactDetailFragment.access$4700(this.this$0) != null) goto L5;
        L12:
            return false;
        L5:
            if (ContactDetailFragment.access$4700(this.this$0).isDirectoryEntry() == false) goto L12;
            if (ContactDetailFragment.access$4700(this.this$0).getDirectoryExportSupport() != 0) goto L10;
            return false;
        L10:
            return true;
        }

        @Override // com.android.contacts.detail.ContactDetailFragment.QuickFix
        public String getTitle() {
            return this.this$0.getString(R.string.menu_copyContact);
        }

        @Override // com.android.contacts.detail.ContactDetailFragment.QuickFix
        public void execute() {
            if (ContactDetailFragment.access$400(this.this$0) != null) goto L5;
            return;
        L5:
            int r0 = ContactDetailFragment.access$4700(this.this$0).getDirectoryExportSupport();
            if (r0 != 1) goto L8;
            ContactDetailFragment.access$7600(this.this$0, new AccountWithDataSet(ContactDetailFragment.access$4700(this.this$0).getDirectoryAccountName(), ContactDetailFragment.access$4700(this.this$0).getDirectoryAccountType(), null));
            return;
        L8:
            if (r0 != 2) goto L30;
            List<AccountWithDataSet> r1 = AccountTypeManager.getInstance(ContactDetailFragment.access$600(this.this$0)).getAccounts(true);
            if (r1.isEmpty() == false) goto L15;
            ContactDetailFragment.access$7600(this.this$0, null);
            return;
        L15:
            if (r1.size() != 1) goto L19;
            ContactDetailFragment.access$7600(this.this$0, r1.get(0));
            return;
        L19:
            if (r1.size() <= 2) goto L22;
            SelectAccountDialogFragment.show(this.this$0.getParentFragmentManager(), this.this$0, R.string.dialog_new_contact_account, AccountsListAdapter.AccountListFilter.ACCOUNTS_CONTACT_WRITABLE, null);
            return;
        L22:
            if (r1.size() != 1) goto L24;
            ContactDetailFragment.access$7600(this.this$0, r1.get(0));
            return;
        L24:
            ContactDetailFragment.access$7600(this.this$0, new AccountWithDataSet(ContactDetailFragment.access$4700(this.this$0).getDirectoryAccountName(), ContactDetailFragment.access$4700(this.this$0).getDirectoryAccountType(), null));
            return;
        }
    }

    private static abstract class QuickFix {
        public abstract void execute();

        public abstract String getTitle();

        public abstract boolean isApplicable();

        private QuickFix() {
        }

        /* synthetic */ QuickFix(AnonymousClass1 r1) {
            this();
        }
    }

    private static class SeparatorViewEntry extends ViewEntry {
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

    public final class ViewAdapter extends BaseAdapter {
        public static final int VIER_TYPE_PHONE_ACTION = 10;
        public static final int VIEW_TYPE_BUSINESS_CARD_ENTRY = 8;
        public static final int VIEW_TYPE_BUTTON_ENTRY = 4;
        public static final int VIEW_TYPE_CALLLOG = 11;
        public static final int VIEW_TYPE_COUNT = 13;
        public static final int VIEW_TYPE_CUSTOM_RINGTONE_ENTRY = 7;
        public static final int VIEW_TYPE_DETAIL_ENTRY = 0;
        public static final int VIEW_TYPE_DETAIL_PHONE_ENTRY = 6;
        public static final int VIEW_TYPE_HEADER_ENTRY = 1;
        public static final int VIEW_TYPE_KIND_TITLE_ENTRY = 2;
        public static final int VIEW_TYPE_NOTE_ENTRY = 5;
        public static final int VIEW_TYPE_RECHARGE = 9;
        public static final int VIEW_TYPE_SECTION = 12;
        public static final int VIEW_TYPE_SEPARATOR_ENTRY = 3;
        private boolean isOtherPhone;
        private final View.OnClickListener mFreeCallOnClickListener;
        private ColorStateList mHiglightDateColor;
        private final View.OnLongClickListener mLongClickListener;
        private OPopover mMenuPopover;
        private ColorStateList mNormalDateColor;
        private GestureDetector mPopupGestureDetector;
        ContactDetailCallLogView mResult;
        private final View.OnClickListener mSecondaryActionClickListener;
        private int mTheFirstPhonePos;
        private final ContactsCommonListItem.ContactsCommonListItemClickListener onContactsItemClickListener;
        private OSelectionDialog phoneActionDialog;
        final /* synthetic */ ContactDetailFragment this$0;

        static /* synthetic */ Unit lambda$getPhoneActionDialog$3() {
            return null;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 13;
        }

        public ViewAdapter(ContactDetailFragment r2) {
            this.this$0 = r2;
            this.mResult = null;
            this.isOtherPhone = false;
            this.mTheFirstPhonePos = -1;
            this.mLongClickListener = new AnonymousClass9(this);
            this.mMenuPopover = null;
            this.onContactsItemClickListener = new AnonymousClass15(this);
            this.mSecondaryActionClickListener = new AnonymousClass16(this);
            this.mFreeCallOnClickListener = new AnonymousClass17(this);
        }

        static /* synthetic */ void access$5400(ViewAdapter r0) {
            r0.onPhoneActionCallClick();
        }

        static /* synthetic */ void access$5500(ViewAdapter r0) {
            r0.onPhoneActionVideoClick();
        }

        static /* synthetic */ void access$5600(ViewAdapter r0) {
            r0.onPhoneActionMessageClick();
        }

        static /* synthetic */ OSelectionDialog access$5700(ViewAdapter r0) {
            return r0.phoneActionDialog;
        }

        static /* synthetic */ void access$6400(ViewAdapter r0, DetailViewEntry r1) {
            r0.onClickVideo(r1);
        }

        static /* synthetic */ OPopover access$6600(ViewAdapter r0) {
            return r0.mMenuPopover;
        }

        static /* synthetic */ OPopover access$6602(ViewAdapter r0, OPopover r1) {
            r0.mMenuPopover = r1;
            return r1;
        }

        static /* synthetic */ void access$6700(ViewAdapter r0, DetailViewEntry r1) {
            r0.onClickMessage(r1);
        }

        static /* synthetic */ void access$6800(ViewAdapter r0, View r1, ViewEntry r2, Integer r3) {
            r0.onClickCall(r1, r2, r3);
        }

        static /* synthetic */ List access$6900(ViewAdapter r0, DetailViewEntry r1) {
            return r0.getLongClickMenu(r1);
        }

        static /* synthetic */ OCardListItem access$7000(ViewAdapter r0, View r1) {
            return r0.findCardListItem(r1);
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r3, View r4, ViewGroup r5) {
            if (ContactDetailFragment.access$5200() == false) goto L6;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_v(ContactDetailFragment.TAG, "position:" + r3 + " getItemViewType(position)  " + getItemViewType(r3));
        L6:
            switch(getItemViewType(r3)) {
                case 0: goto L30;
                case 1: goto L28;
                case 2: goto L26;
                case 3: goto L24;
                case 4: goto L22;
                case 5: goto L20;
                case 6: goto L30;
                case 7: goto L18;
                case 8: goto L16;
                case 9: goto L8;
                case 10: goto L14;
                case 11: goto L12;
                case 12: goto L10;
                default: goto L8;
            };
        L8:
            throw new IllegalStateException("Invalid view type ID " + getItemViewType(r3));
        L10:
            return getSectionView(r3, r4, r5);
        L12:
            return getCalllogEntryView(r4, r5);
        L14:
            return getPhoneActionView(r3, r4, r5);
        L16:
            return getBusinessCardView(r3, r4, r5);
        L18:
            return getCustomRingtoneEntryView(r3, r4, r5);
        L20:
            return getNoteEntryView(r3, r4, r5);
        L22:
            return getButtonsView(r3, r4, r5);
        L24:
            return getSeparatorEntryView(r3, r4, r5);
        L26:
            return getKindTitleEntryView(r3, r4, r5);
        L28:
            return getHeaderEntryView(r4, r5);
        L30:
            return getDetailEntryView(r3, r4, r5);
        }

        private View getSectionView(int r3, View r4, ViewGroup r5) {
            if (r4 == null) goto L4;
            FrameLayout r6 = (FrameLayout) r4;
        L5:
            ((OSectionTitleBar) r6.findViewById(R.id.contact_section)).setTitleText(((SectionEntry) getItem(r3)).getTitle());
            return r6;
        L4:
            r6 = (FrameLayout) ContactDetailFragment.access$5300(this.this$0).inflate(R.layout.layout_section, r5, false);
            goto L5
        }

        private View getPhoneActionView(int r2, View r3, ViewGroup r4) {
            if ((r3 instanceof PhoneActionViewLayout) == false) goto L5;
            PhoneActionViewLayout r5 = (PhoneActionViewLayout) r3;
        L6:
            r5.setEnabled(!ContactDetailFragment.access$1100(this.this$0).isEmpty());
            if (ContactsApplication.getInstance().getTelephonyUtil().isVtCapable() == true) goto L9;
            r5.getButtonActionVideo().setEnabled(false);
        L9:
            return r5;
        L5:
            r5 = (PhoneActionViewLayout) ContactDetailFragment.access$5300(this.this$0).inflate(R.layout.layout_phone_action, r4, false);
            r5.getButtonActionCall().setOnClickListener(new AnonymousClass1(this));
            r5.getButtonActionVideo().setOnClickListener(new AnonymousClass2(this));
            r5.getButtonActionMessage().setOnClickListener(new AnonymousClass3(this));
            goto L6
        }

        private void onPhoneActionMessageClick() {
            if (ContactDetailFragment.access$1100(this.this$0).isEmpty() == false) goto L6;
            return;
        L6:
            if (ContactDetailFragment.access$1100(this.this$0).size() != 1) goto L8;
            onClickMessage((DetailViewEntry) ContactDetailFragment.access$1100(this.this$0).get(0));
            return;
        L8:
            getPhoneActionDialog(new ContactDetailFragment$ViewAdapter$$ExternalSyntheticLambda0(this)).show();
        }

        /* JADX INFO: renamed from: lambda$onPhoneActionMessageClick$0$com-android-contacts-detail-ContactDetailFragment$ViewAdapter, reason: not valid java name */
        /* synthetic */ Unit m166x4aba9eac(SelectionDialogItemData r1, Integer r2) {
            onClickMessage((DetailViewEntry) ContactDetailFragment.access$1100(this.this$0).get(r2.intValue()));
            return null;
        }

        private void onPhoneActionVideoClick() {
            if (ContactDetailFragment.access$1100(this.this$0).isEmpty() == false) goto L6;
            return;
        L6:
            if (ContactDetailFragment.access$1100(this.this$0).size() != 1) goto L8;
            onClickVideo((DetailViewEntry) ContactDetailFragment.access$1100(this.this$0).get(0));
            return;
        L8:
            getPhoneActionDialog(new ContactDetailFragment$ViewAdapter$$ExternalSyntheticLambda2(this)).show();
        }

        /* JADX INFO: renamed from: lambda$onPhoneActionVideoClick$1$com-android-contacts-detail-ContactDetailFragment$ViewAdapter, reason: not valid java name */
        /* synthetic */ Unit m167x8fc130f9(SelectionDialogItemData r1, Integer r2) {
            onClickVideo((DetailViewEntry) ContactDetailFragment.access$1100(this.this$0).get(r2.intValue()));
            return null;
        }

        private void onPhoneActionCallClick() {
            if (ContactDetailFragment.access$1100(this.this$0).isEmpty() == false) goto L6;
            return;
        L6:
            if (ContactDetailFragment.access$1100(this.this$0).size() != 1) goto L8;
            onClickCall(null, (ViewEntry) ContactDetailFragment.access$1100(this.this$0).get(0), null);
            return;
        L8:
            getPhoneActionDialog(new ContactDetailFragment$ViewAdapter$$ExternalSyntheticLambda4(this)).show();
        }

        /* JADX INFO: renamed from: lambda$onPhoneActionCallClick$2$com-android-contacts-detail-ContactDetailFragment$ViewAdapter, reason: not valid java name */
        /* synthetic */ Unit m165x7328e467(SelectionDialogItemData r1, Integer r2) {
            onClickCall(null, (ViewEntry) ContactDetailFragment.access$1100(this.this$0).get(r2.intValue()), null);
            return null;
        }

        private OSelectionDialog getPhoneActionDialog(final Function2<SelectionDialogItemData, Integer, Unit> r11) {
            OSelectionDialog r12 = OUIDialogHelper.getSelectionDialog(ContactDetailFragment.access$700(this.this$0), this.this$0.getResources().getString(R.string.select_phone_number), "", SelectionType.NONE, getPhoneActionItemData(), null, new SelectionButton(true, this.this$0.getResources().getString(R.string.common_cancel), new ContactDetailFragment$ViewAdapter$$ExternalSyntheticLambda5()), new AnonymousClass4(this, r11));
            this.phoneActionDialog = r12;
            return r12;
        }

        private List<SelectionDialogItemData> getPhoneActionItemData() {
            final ArrayList r0 = new ArrayList();
            ContactDetailFragment.access$1100(this.this$0).forEach(new ContactDetailFragment$ViewAdapter$$ExternalSyntheticLambda3(r0));
            return r0;
        }

        static /* synthetic */ void lambda$getPhoneActionItemData$4(List r3, DetailViewEntry r4) {
            r3.add(new SelectionDialogItemData(r4.data, r4.typeString, false));
        }

        private View getHeaderEntryView(View r7, ViewGroup r8) {
            if (r7 == null) goto L8;
            HeaderViewCache r2 = (HeaderViewCache) r7.getTag();
            if (r2.layoutResourceId == R.layout.detail_header_contact_without_updates) goto L10;
            r7 = null;
        L10:
            if (r7 != null) goto L15;
            r7 = ContactDetailCacheManager.getInstance().getCachedView(R.layout.detail_header_contact_without_updates);
            if (r7 != null) goto L14;
            r7 = ContactDetailFragment.access$5300(this.this$0).inflate(R.layout.detail_header_contact_without_updates, r8, false);
        L14:
            r2 = new HeaderViewCache(r7, R.layout.detail_header_contact_without_updates);
            r7.setTag(r2);
        L15:
            ContactDetailDisplayUtils.setDisplayName(ContactDetailFragment.access$600(this.this$0), ContactDetailFragment.access$4700(this.this$0), r2.displayNameView);
            String r9 = ContactDetailDisplayUtils.getCompany(ContactDetailFragment.access$600(this.this$0), ContactDetailFragment.access$4700(this.this$0));
            String r0 = ContactDetailDisplayUtils.getNote(ContactDetailFragment.access$1200(this.this$0));
            if (TextUtils.isEmpty(r9) == false) goto L18;
            TextUtils.isEmpty(r0);
        L18:
            ContactDetailDisplayUtils.setCombinedTextWithDivider(ContactDetailFragment.access$600(this.this$0), r2.companyAndNoteView, r9, r0);
            r2.companyAndNoteView.setOnClickListener(new AnonymousClass5(this));
            String r10 = ContactDetailDisplayUtils.getPhoneticName(ContactDetailFragment.access$600(this.this$0), ContactDetailFragment.access$4700(this.this$0));
            if ((!TextUtils.isEmpty(r10)) == false) goto L21;
            r2.phoneticNameView.setVisibility(0);
            r2.phoneticNameView.setText(r10);
        L23:
            if (r2.photoView == null) goto L25;
            ContactDetailDisplayUtils.setPhoto(ContactDetailFragment.access$600(this.this$0), ContactDetailFragment.access$4700(this.this$0), r2.photoView);
        L25:
            ContactDetailFragment.access$5802(this.this$0, r7.findViewById(R.id.blacklist_photo));
            if (ContactDetailFragment.access$5900(this.this$0) != 1) goto L31;
            ContactDetailFragment.access$5800(this.this$0).setVisibility(0);
            if (r2.photoView == null) goto L35;
            r2.photoView.setVisibility(8);
        L35:
            TextView r11 = (TextView) r7.findViewById(R.id.name);
            ListContentItemCustom r1 = (ListContentItemCustom) r7.findViewById(R.id.lcic_contact_detail_head);
            RelativeLayout.LayoutParams r3 = (RelativeLayout.LayoutParams) r1.getLayoutParams();
            if (ContactDetailFragment.access$3300(this.this$0) > 0) goto L38;
            r1.setLayoutParams(r3);
        L39:
            ContactDetailFragment.access$302(this.this$0, r11.getText().toString());
            return r7;
        L38:
            r1.setLayoutParams(r3);
            goto L39
        L31:
            if (ContactDetailFragment.access$5900(this.this$0) != 0) goto L35;
            ContactDetailFragment.access$5800(this.this$0).setVisibility(8);
            if (r2.photoView == null) goto L35;
            r2.photoView.setVisibility(0);
            goto L35
        L21:
            r2.phoneticNameView.setVisibility(8);
            r2.phoneticNameView.setText(null);
            goto L23
        L8:
            r7 = null;
            r2 = null;
            goto L10
        }

        private View getCalllogEntryView(View r4, ViewGroup r5) {
            ContactDetailCallLogView r6 = this.mResult;
            if (r6 != null) goto L5;
            r6 = (ContactDetailCallLogView) ContactDetailFragment.access$5300(this.this$0).inflate(R.layout.detail_calllog_contact, r5, false);
        L5:
            r6.setData(this.this$0.mCallback.getPhoneCallDetails(), ContactDetailFragment.access$900(this.this$0), ContactDetailFragment.access$4100(this.this$0), ContactDetailFragment.access$700(this.this$0));
            this.mResult = r6;
            r6.setMoreItemClickListener(new AnonymousClass6(this));
            return r6;
        }

        private View getSeparatorEntryView(int r1, View r2, ViewGroup r3) {
            SeparatorViewEntry r4 = (SeparatorViewEntry) getItem(r1);
            if (r2 == null) goto L6;
            return r2;
        L6:
            return ContactDetailFragment.access$5300(this.this$0).inflate(R.layout.contact_detail_separator_entry_view, r3, false);
        }

        private View getKindTitleEntryView(int r2, View r3, ViewGroup r4) {
            KindTitleViewEntry r5 = (KindTitleViewEntry) getItem(r2);
            if (r3 != null) goto L6;
            r3 = ContactDetailFragment.access$5300(this.this$0).inflate(R.layout.list_separator, r4, false);
        L6:
            ((TextView) r3.findViewById(R.id.title)).setText(r5.getTitle());
            return r3;
        }

        private View getCustomRingtoneEntryView(int r4, View r5, ViewGroup r6) {
            if (r5 == null) goto L5;
            DetailViewCache r7 = (DetailViewCache) r5.getTag();
        L9:
            CustomRingtoneViewEntry r3 = (CustomRingtoneViewEntry) getItem(r4);
            if (r3.cardPosition != null) goto L12;
        L14:
            r7.data.setText(r3.getTitle());
            r7.type.setText(R.string.label_ringtone);
            r7.primaryActionView.setClickable(false);
            r7.contentItemCustom.setOnClickListener(null);
            return r5;
        L12:
            if ((r5 instanceof ContactItemCard) == false) goto L14;
            ContactItemCard r8 = (ContactItemCard) r5;
            r8.setCardPosition(r3.cardPosition.intValue());
            r8.showDivider(r3.cardNeedDivider);
            goto L14
        L5:
            r5 = ContactDetailCacheManager.getInstance().getCachedView(R.layout.contact_detail_list_item_2);
            if (r5 != null) goto L8;
            r5 = ContactDetailFragment.access$5300(this.this$0).inflate(R.layout.contact_detail_list_item_2, r6, false);
        L8:
            r7 = new DetailViewCache(r5, null, null, null);
            r5.setTag(r7);
            goto L9
        }

        private View getButtonsView(int r10, View r11, ViewGroup r12) {
            int r13 = 0;
            if (r11 != null) goto L6;
            r11 = ContactDetailFragment.access$5300(this.this$0).inflate(R.layout.contact_detail_buttons_entry_view, r12, false);
        L6:
            ContactItemButtonCard r14 = (ContactItemButtonCard) r11.findViewById(R.id.btn_blocked_call);
            ContactDetailFragment.access$4500(this.this$0).tryUpdateBlockedCallBtn(ContactDetailFragment.access$4100(this.this$0), ContactDetailFragment.access$4000(this.this$0), ContactDetailFragment.access$6100(this.this$0), ContactDetailFragment.access$4300(this.this$0), r14.getItemText(), r14, this.this$0.getActivity().getContentResolver(), ContactDetailFragment.access$4400(this.this$0));
            ContactItemButtonCard r0 = (ContactItemButtonCard) r11.findViewById(R.id.lcic_recent);
            r0.setOnContentClickListener(new ContactDetailFragment$ViewAdapter$$ExternalSyntheticLambda1(this));
            if (ContactDetailFragment.access$4100(this.this$0) <= 0) goto L9;
            UIUtils.setViewVisibility(r0, 8);
            UIUtils.setViewVisibility(r14, 0);
        L11:
            if (this.this$0.mCallback.hasCallLog() == false) goto L13;
            r13 = 8;
        L13:
            r0.setVisibility(r13);
            if (ContactsUtils.DEBUG == false) goto L16;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ContactDetailFragment.TAG, "refresh btnStar");
        L16:
            return r11;
        L9:
            UIUtils.setViewVisibility(r0, 0);
            UIUtils.setViewVisibility(r14, 8);
            goto L11
        }

        /* JADX INFO: renamed from: lambda$getButtonsView$5$com-android-contacts-detail-ContactDetailFragment$ViewAdapter, reason: not valid java name */
        /* synthetic */ void m164x162c4155(View r4) {
            if (ContactsUtils.isJustClicked() == false) goto L5;
            return;
        L5:
            if (this.this$0.mCallback == null) goto L9;
            String r5 = getCallLogSelection();
            this.this$0.mCallback.setShowContactCalllog(r5, null, ContactDetailFragment.access$6000(this.this$0), ContactDetailFragment.access$900(this.this$0).size());
            return;
        }

        private View getBusinessCardView(int r1, View r2, ViewGroup r3) {
            if (r2 == null) goto L5;
            return r2;
        L5:
            return ContactDetailFragment.access$5300(this.this$0).inflate(R.layout.from_business_card, r3, false);
        }

        private void setShareContent() {
            StringBuilder r0 = new StringBuilder();
            r0.append("[" + this.this$0.getString(R.string.full_name) + "] " + ContactDetailDisplayUtils.getDisplayName(ContactDetailFragment.access$600(this.this$0), ContactDetailFragment.access$4700(this.this$0)) + ";");
            Iterator r1 = ContactDetailFragment.access$3200(this.this$0).iterator();
        L4:
            if (r1.hasNext() == false) goto L10;
            ViewEntry r4 = (ViewEntry) r1.next();
            if (6 != r4.getViewType()) goto L4;
            DetailViewEntry r5 = (DetailViewEntry) r4;
            if ("vnd.android.cursor.item/phone_v2".equals(r5.mimetype) == false) goto L4;
            r0.append("\n[" + r5.typeString + "] " + r5.data + ";");
            goto L4
        L10:
            ContactDetailFragment.access$4700(this.this$0).setShareString(r0.toString());
        }

        public String getCallLogSelection() {
            StringBuilder r0 = new StringBuilder("1 = 0");
            if (ContactDetailFragment.access$6200(this.this$0) == null) goto L5;
            r0.append(" OR lookup_uri = '" + ContactDetailFragment.access$6200(this.this$0).toString() + "'");
        L5:
            Iterator r1 = ContactDetailFragment.access$3200(this.this$0).iterator();
        L7:
            if (r1.hasNext() == false) goto L14;
            ViewEntry r3 = (ViewEntry) r1.next();
            if (6 != r3.getViewType()) goto L7;
            DetailViewEntry r4 = (DetailViewEntry) r3;
            if ("vnd.android.cursor.item/phone_v2".equals(r4.mimetype) == false) goto L7;
            r0.append(" OR PHONE_NUMBERS_EQUAL(number,").append("'" + r4.data + "',").append(ContactDetailFragment.access$6300(this.this$0) ? 1 : 0).append(")");
            goto L7
        L14:
            return r0.toString();
        }

        private ColorStateList getNormalDateColor(Context r9) {
            if (this.mNormalDateColor != null) goto L6;
            this.mNormalDateColor = new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_focused}, new int[]{0}}, new int[]{r9.getResources().getColor(R.color.oui_text_1), r9.getResources().getColor(R.color.oui_text_1), r9.getResources().getColor(R.color.oui_text_1)});
        L6:
            return this.mNormalDateColor;
        }

        private ColorStateList getHiglightDateColor(Context r9) {
            if (this.mHiglightDateColor != null) goto L6;
            this.mHiglightDateColor = new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_focused}, new int[]{0}}, new int[]{r9.getResources().getColor(R.color.oui_text_1), r9.getResources().getColor(R.color.oui_text_1), r9.getResources().getColor(R.color.oui_text_1)});
        L6:
            return this.mHiglightDateColor;
        }

        private View getDetailEntryView(int r5, View r6, ViewGroup r7) {
            DetailViewEntry r0 = (DetailViewEntry) getItem(r5);
            if (r6 != null) goto L5;
        L7:
            r6 = ContactDetailFragment.access$5300(this.this$0).inflate(R.layout.contact_detail_list_item_2, r7, false);
            View.OnClickListener r8 = new AnonymousClass7(this);
            r6.setTag(new DetailViewCache(r6, this.onContactsItemClickListener, this.mSecondaryActionClickListener, r8));
        L8:
            bindDetailView(r5, r6, r0);
            return r6;
        L5:
            if (r6.getTag() == null) goto L7;
            goto L7
        }

        private void onClickVideo(DetailViewEntry r3) {
            if (ContactsUtils.isJustClicked() == false) goto L7;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(ContactDetailFragment.TAG, "Ignore just clicked VoLTE call");
            return;
        L7:
            if (ContactsApplication.getInstance().getTelephonyUtil().isVtCapable() == true) goto L9;
            return;
        L9:
            if (ContactsUtils.DEBUG == false) goto L12;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ContactDetailFragment.TAG, "start VoLTE call");
        L12:
            if ("vnd.android.cursor.item/phone_v2".equals(r3.mimetype) == true) goto L14;
            return;
        L14:
            String r4 = r3.data;
            this.this$0.mCallback.startVolteCall(r4);
        }

        private View getNoteEntryView(int r5, View r6, ViewGroup r7) {
            DetailViewEntry r0 = (DetailViewEntry) getItem(r5);
            if (r6 == null) goto L5;
            DetailViewCache r8 = (DetailViewCache) r6.getTag();
        L6:
            bindDetailView(r5, r6, r0);
            return r6;
        L5:
            r6 = ContactDetailFragment.access$5300(this.this$0).inflate(R.layout.contact_detail_note_item, r7, false);
            View.OnClickListener r9 = new AnonymousClass8(this);
            r6.setTag(new DetailViewCache(r6, this.onContactsItemClickListener, this.mSecondaryActionClickListener, r9));
            goto L6
        }

        private void bindDetailView(int r9, View r10, DetailViewEntry r11) {
            Resources r0 = ContactDetailFragment.access$600(this.this$0).getResources();
            DetailViewCache r1 = (DetailViewCache) r10.getTag();
            if (r11.cardPosition == null) goto L8;
            if ((r10 instanceof ContactItemCard) == false) goto L8;
            ContactItemCard r2 = (ContactItemCard) r10;
            r2.setCardPosition(r11.cardPosition.intValue());
            r2.showDivider(r11.cardNeedDivider);
        L8:
            if (r11.cardTopPadding == null) goto L11;
            r10.setPadding(r10.getPaddingLeft(), r11.cardTopPadding.intValue(), r10.getPaddingRight(), r10.getPaddingBottom());
        L11:
            if (TextUtils.isEmpty(r11.typeString) == false) goto L13;
        L15:
            r1.type.setVisibility(8);
        L17:
            if ("vnd.android.cursor.item/postal-address_v2".equals(r11.mimetype) == false) goto L19;
        L20:
            setMaxLines(r1.data, r11.maxLines);
        L21:
            r1.primaryActionView.setClickable(false);
            r1.contactItemCard.setOnClickListener(this.onContactsItemClickListener);
            if (r11.mimetype != null) goto L24;
        L28:
            r1.data.setText(r11.data);
            Drawable r12 = ContactPresenceIconUtil.getPresenceIcon(ContactDetailFragment.access$600(this.this$0), r11.presence);
            ImageView r4 = r1.presenceIcon;
            if (r12 == null) goto L31;
            r4.setImageDrawable(r12);
            r4.setVisibility(0);
        L32:
            String r13 = r1.data.getText().toString();
            if (TextUtils.isEmpty(ContactDetailFragment.access$4300(this.this$0)) == true) goto L39;
            if (PhoneNumberUtils.compare(r13, ContactDetailFragment.access$4300(this.this$0)) == false) goto L37;
            r1.data.setText(new SpannableString(r13));
            r1.data.setTextColor(getHiglightDateColor(ContactDetailFragment.access$600(this.this$0)));
            goto L39
        L37:
            r1.data.setText(new SpannableString(r13));
            r1.data.setTextColor(getNormalDateColor(ContactDetailFragment.access$600(this.this$0)));
        L39:
            if (ContactDetailFragment.access$6500(this.this$0) == null) goto L53;
            if (ContactDetailFragment.access$6500(this.this$0).isEmpty() == true) goto L48;
            Iterator r5 = ContactDetailFragment.access$6500(this.this$0).iterator();
        L44:
            if (r5.hasNext() == false) goto L48;
            if (PhoneNumberUtils.compare(r13, (String) r5.next()) == false) goto L44;
            boolean r6 = true;
        L49:
            if (r6 == false) goto L51;
            SpannableString r7 = new SpannableString(r13);
            r7.setSpan(new StyleSpan(1), 0, r7.length(), 33);
            r1.data.setText(r7);
            r1.data.setTextColor(getHiglightDateColor(ContactDetailFragment.access$600(this.this$0)));
            goto L53
        L51:
            r1.data.setText(new SpannableString(r13));
            r1.data.setTextColor(getNormalDateColor(ContactDetailFragment.access$600(this.this$0)));
        L48:
            r6 = false;
        L53:
            if (this.isOtherPhone == true) goto L55;
            this.mTheFirstPhonePos = r9;
            this.isOtherPhone = true;
        L55:
            ActionsViewContainer r14 = (ActionsViewContainer) r1.primaryActionView;
            r1.contentItemCustom.setTag(r11);
            r1.contentItemCustom.setPosition(r9);
            r1.contactItemCard.getContentContainer().setTag(R.id.detail_entry, r11);
            r14.setTag(r11);
            r14.setPosition(r9);
            if (r11.secondaryActionIcon == (-1)) goto L59;
            Drawable r15 = r0.getDrawable(r11.secondaryActionIcon);
            r0.getString(r11.secondaryActionDescription);
        L65:
            View r3 = r1.primaryActionView;
            LinearLayout.LayoutParams r8 = (LinearLayout.LayoutParams) r1.primaryActionViewChild.getLayoutParams();
            if (r11.secondaryIntent == null) goto L76;
            if (r15 == null) goto L76;
            r8.width = -1;
            r8.rightMargin = 0;
            if ("vnd.android.cursor.item/phone_v2".equals(r11.mimetype) == true) goto L71;
            return;
        L71:
            if (ContactDetailFragment.access$1500(this.this$0).contains(ContactsUtils.formatNumber(r11.data)) == false) goto L73;
            r1.star.setVisibility(0);
        L74:
            r3.setVisibility(0);
            return;
        L73:
            r1.star.setVisibility(8);
        L76:
            if (r11.secondaryIntent != null) goto L78;
        L80:
            r3.setVisibility(0);
            return;
        L78:
            if ("vnd.android.cursor.item/card_id".equals(r11.mimetype) == false) goto L80;
            r8.width = -1;
            r8.rightMargin = (int) ContactDetailFragment.access$600(this.this$0).getResources().getDimension(R.dimen.detail_sparator_title_margin_left);
            r3.setVisibility(0);
            return;
        L59:
            if ((r11.chatCapability & 4) == 0) goto L62;
            r15 = r0.getDrawable(R.drawable.sym_action_videochat_holo_light);
            r0.getString(R.string.video_chat);
            goto L65
        L62:
            if ((r11.chatCapability & 1) == 0) goto L64;
            r15 = r0.getDrawable(R.drawable.sym_action_audiochat_holo_light);
            r0.getString(R.string.audio_chat);
            goto L65
        L64:
            r15 = null;
            goto L65
        L31:
            r4.setVisibility(8);
            goto L32
        L24:
            if (r11.mimetype.startsWith(ContactsUtils.WECHAT_MIMETYPE_PREFIX) == false) goto L26;
        L27:
            r1.type.setText(r11.typeString);
            goto L28
        L26:
            if (r11.mimetype.startsWith(ContactsUtils.QQ_MIMETYPE) == false) goto L28;
        L19:
            if (ContactsUtils.CAM_CARD_COMPANY_MIMETYPE.equals(r11.mimetype) == false) goto L21;
        L13:
            if (r11.isNote == true) goto L15;
            r1.type.setText(r11.typeString);
            r1.type.setVisibility(0);
            goto L17
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

        private List<MenuItemData> getLongClickMenu(final DetailViewEntry r28) {
            ArrayList r2 = new ArrayList();
            if (r28 != null) goto L5;
            return r2;
        L5:
            boolean r3 = "vnd.android.cursor.item/phone_v2".equals(r28.mimetype);
            r2.add(new MenuItemData(ItemType.TEXT, Integer.valueOf(R.drawable.menu_icon_copy_number), null, null, getCopyMenuText(r3), null, null, null, null, new AnonymousClass10(this, r28)));
            if (r3 == false) goto L11;
            r2.add(new MenuItemData(ItemType.TEXT, Integer.valueOf(R.drawable.menu_icon_message), null, null, this.this$0.getResources().getString(R.string.common_send_sms), null, null, null, null, new AnonymousClass11(this, r28)));
            if (DSUtils.useDSFeature() == false) goto L10;
            r2.add(new MenuItemData(ItemType.TEXT, Integer.valueOf(LongMenuHelper.MenuType.MENU_PHONE1.drawable), null, null, getSimMenuTitle(LongMenuHelper.MenuType.MENU_PHONE1, 0), null, null, null, null, new AnonymousClass12(this, r28)));
            r2.add(new MenuItemData(ItemType.TEXT, Integer.valueOf(LongMenuHelper.MenuType.MENU_PHONE2.drawable), null, null, getSimMenuTitle(LongMenuHelper.MenuType.MENU_PHONE2, 1), null, null, null, null, new AnonymousClass13(this, r28)));
            goto L11
        L10:
            r2.add(new MenuItemData(ItemType.TEXT, Integer.valueOf(R.drawable.menu_icon_phone), null, null, this.this$0.getResources().getString(R.string.menu_phone), null, null, null, null, new AnonymousClass14(this, r28)));
        L11:
            return r2;
        }

        private String getCopyMenuText(boolean r1) {
            if (r1 == false) goto L6;
            return this.this$0.getResources().getString(R.string.menu_copy_number);
        L6:
            return this.this$0.getResources().getString(R.string.copy);
        }

        private String getSimMenuTitle(LongMenuHelper.MenuType r2, int r3) {
            int r0 = DSUtils.getCallingSim(ContactDetailFragment.access$600(this.this$0));
            if (r0 >= 0) goto L6;
            r0 = DSUtils.getDefaultCallSim();
        L6:
            if (r3 != r0) goto L10;
            if (r0 != 0) goto L10;
            return this.this$0.getResources().getString(R.string.menu_phone1_default);
        L10:
            if (r3 != r0) goto L16;
            if (r0 != 1) goto L16;
            return this.this$0.getResources().getString(R.string.menu_phone2_default);
        L16:
            return this.this$0.getResources().getString(r2.text);
        }

        private OCardListItem findCardListItem(View r2) {
        L3:
            if (r2 == null) goto L12;
            if ((r2 instanceof OCardListItem) == true) goto L7;
            Object r3 = r2.getParent();
            if ((r3 instanceof View) == true) goto L10;
            r2 = null;
            goto L3
        L10:
            r2 = (View) r3;
            goto L3
        L7:
            return (OCardListItem) r2;
        L12:
            return null;
        }

        private void onClickCall(View r5, ViewEntry r6, Integer r7) {
            if (r6 != null) goto L4;
            return;
        L4:
            if (r7 != null) goto L14;
            if ((r6 instanceof DetailViewEntry) == false) goto L14;
            DetailViewEntry r0 = (DetailViewEntry) r6;
            if ("vnd.android.cursor.item/phone_v2".equals(r0.mimetype) == false) goto L14;
            String r1 = r0.data;
            Intent r2 = DSUtils.getSelectSimDialogIntentIfNeeded(ContactDetailFragment.access$600(this.this$0), null, r1, false, false);
            if (r2 == null) goto L14;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ContactDetailFragment.TAG, "onClickCall show select sim dialog");
            this.this$0.startActivity(r2);
            return;
        L14:
            if ((r6 instanceof DetailViewEntry) == false) goto L20;
            if (r7 != null) goto L17;
            int r8 = DSUtils.getDefaultCallSim();
        L18:
            Integer r9 = Integer.valueOf(r8);
            Intent r10 = DSUtils.getCallIntent(ContactDetailFragment.access$600(this.this$0), ((DetailViewEntry) r6).data, r9.intValue());
            HashMap r3 = new HashMap();
            r3.put(ContactDetailFragment.KEY_NEW_INTENT, r10);
            r6.click(r5, ContactDetailFragment.access$400(this.this$0), r3);
            CallScreenShowUtils.INSTANCE.start(new CallScreenShowEvent());
            return;
        L17:
            r8 = r7.intValue();
            goto L18
        }

        private void onClickMessage(DetailViewEntry r4) {
            if (r4.secondaryIntent == null) goto L5;
            Intent r5 = r4.secondaryIntent;
        L6:
            if (r5 != null) goto L8;
            return;
        L8:
            Agent.getInstance().onClick(ContactDetailFragment.TAG, Constants.ContactsTracker.EVENT_SEND_MMS);
            ContactDetailFragment.access$400(this.this$0).onItemClicked(r5);
            return;
        L5:
            r5 = ContactsIntentUtils.getSendMessageIntent(r4.data);
            goto L6
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ContactDetailFragment.access$3200(this.this$0).size();
        }

        @Override // android.widget.Adapter
        public ViewEntry getItem(int r1) {
            return (ViewEntry) ContactDetailFragment.access$3200(this.this$0).get(r1);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int r1) {
            ViewEntry r0 = getItem(r1);
            if (r0 != null) goto L7;
            return -1;
        L7:
            return r0.getViewType();
        }

        public int getViewBackgroundStyle(int r5) {
            int r0 = -2;
            if (r5 != 0) goto L5;
            int r1 = -2;
        L7:
            if (r5 == (getCount() - 1)) goto L10;
            r0 = getItem(r5 + 1).getViewType();
        L10:
            int r4 = getItem(r5).getViewType();
            if (r4 != 6) goto L13;
            return 3;
        L13:
            if (r4 != r1) goto L18;
            if (r4 != r0) goto L16;
            return 3;
        L16:
            return 4;
        L18:
            if (r4 != r0) goto L21;
            return 2;
        L21:
            return 1;
        L5:
            r1 = getItem(r5 - 1).getViewType();
            goto L7
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            ViewEntry r0 = (ViewEntry) ContactDetailFragment.access$3200(this.this$0).get(r1);
            if (r0 != null) goto L5;
            return -1;
        L5:
            return r0.getId();
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int r1) {
            return getItem(r1).isEnabled();
        }
    }

    public static class ViewEntry {
        public boolean cardNeedDivider;
        public Integer cardPosition;
        protected long id;
        protected boolean isEnabled;
        private final int viewTypeForAdapter;

        public void click(View r1, Listener r2, Map<String, Object> r3) {
        }

        public ViewEntry(int r3) {
            this.id = -1;
            this.isEnabled = false;
            this.viewTypeForAdapter = r3;
        }

        public int getViewType() {
            return this.viewTypeForAdapter;
        }

        public long getId() {
            return this.id;
        }

        public boolean isEnabled() {
            return this.isEnabled;
        }
    }

    private static class ViewEntryDimensions {
        private final int mPaddingBottom;
        private final int mPaddingLeft;
        private final int mPaddingRight;
        private final int mPaddingTop;
        private final int mWidePaddingLeft;

        public ViewEntryDimensions(Resources r5) {
            int r0 = r5.getDimensionPixelSize(R.dimen.detail_item_side_margin);
            this.mPaddingLeft = r0;
            int r1 = r5.getDimensionPixelSize(R.dimen.detail_item_vertical_margin);
            this.mPaddingTop = r1;
            this.mWidePaddingLeft = (r5.getDimensionPixelSize(R.dimen.detail_item_icon_margin) + r0) + r5.getDimensionPixelSize(R.dimen.detail_network_icon_size);
            this.mPaddingRight = r0;
            this.mPaddingBottom = r1;
        }

        public int getWidePaddingLeft() {
            return this.mWidePaddingLeft;
        }

        public int getPaddingLeft() {
            return this.mPaddingLeft;
        }

        public int getPaddingRight() {
            return this.mPaddingRight;
        }

        public int getPaddingTop() {
            return this.mPaddingTop;
        }

        public int getPaddingBottom() {
            return this.mPaddingBottom;
        }
    }

    @Override // com.android.contacts.editor.SelectAccountDialogFragment.Listener
    public void onAccountSelectorCancelled() {
    }

    static /* synthetic */ void access$000(ContactDetailFragment r0) {
        r0.requeryFreeCall();
    }

    static /* synthetic */ ListView access$100(ContactDetailFragment r0) {
        return r0.mListView;
    }

    static /* synthetic */ ArrayList access$1000(ContactDetailFragment r0) {
        return r0.mFreeCallNumberList;
    }

    static /* synthetic */ ArrayList access$1002(ContactDetailFragment r0, ArrayList r1) {
        r0.mFreeCallNumberList = r1;
        return r1;
    }

    static /* synthetic */ ArrayList access$1100(ContactDetailFragment r0) {
        return r0.mPhoneEntries;
    }

    static /* synthetic */ ArrayList access$1102(ContactDetailFragment r0, ArrayList r1) {
        r0.mPhoneEntries = r1;
        return r1;
    }

    static /* synthetic */ ArrayList access$1200(ContactDetailFragment r0) {
        return r0.mNoteEntries;
    }

    static /* synthetic */ ArrayList access$1202(ContactDetailFragment r0, ArrayList r1) {
        r0.mNoteEntries = r1;
        return r1;
    }

    static /* synthetic */ ArrayList access$1302(ContactDetailFragment r0, ArrayList r1) {
        r0.mRawContactIds = r1;
        return r1;
    }

    static /* synthetic */ Uri access$1402(ContactDetailFragment r0, Uri r1) {
        r0.mPrimaryPhoneUri = r1;
        return r1;
    }

    static /* synthetic */ HashSet access$1500(ContactDetailFragment r0) {
        return r0.mFavoriteNumberList;
    }

    static /* synthetic */ HashSet access$1502(ContactDetailFragment r0, HashSet r1) {
        r0.mFavoriteNumberList = r1;
        return r1;
    }

    static /* synthetic */ Set access$1602(ContactDetailFragment r0, Set r1) {
        r0.mCurrentPhoneNumber = r1;
        return r1;
    }

    static /* synthetic */ Map access$1702(ContactDetailFragment r0, Map r1) {
        r0.mOtherEntriesMap = r1;
        return r1;
    }

    static /* synthetic */ ArrayList access$1802(ContactDetailFragment r0, ArrayList r1) {
        r0.mEventEntries = r1;
        return r1;
    }

    static /* synthetic */ ArrayList access$1902(ContactDetailFragment r0, ArrayList r1) {
        r0.mGenderEntries = r1;
        return r1;
    }

    static /* synthetic */ ViewAdapter access$200(ContactDetailFragment r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ ArrayList access$2002(ContactDetailFragment r0, ArrayList r1) {
        r0.mCardIdEntries = r1;
        return r1;
    }

    static /* synthetic */ ViewAdapter access$202(ContactDetailFragment r0, ViewAdapter r1) {
        r0.mAdapter = r1;
        return r1;
    }

    static /* synthetic */ ArrayList access$2102(ContactDetailFragment r0, ArrayList r1) {
        r0.mSipEntries = r1;
        return r1;
    }

    static /* synthetic */ ArrayList access$2202(ContactDetailFragment r0, ArrayList r1) {
        r0.mWebsiteEntries = r1;
        return r1;
    }

    static /* synthetic */ ArrayList access$2302(ContactDetailFragment r0, ArrayList r1) {
        r0.mCamCardCompanyEntries = r1;
        return r1;
    }

    static /* synthetic */ ArrayList access$2402(ContactDetailFragment r0, ArrayList r1) {
        r0.mRelationEntries = r1;
        return r1;
    }

    static /* synthetic */ ArrayList access$2502(ContactDetailFragment r0, ArrayList r1) {
        r0.mGroupEntries = r1;
        return r1;
    }

    static /* synthetic */ ArrayList access$2602(ContactDetailFragment r0, ArrayList r1) {
        r0.mNicknameEntries = r1;
        return r1;
    }

    static /* synthetic */ ArrayList access$2702(ContactDetailFragment r0, ArrayList r1) {
        r0.mImEntries = r1;
        return r1;
    }

    static /* synthetic */ ArrayList access$2802(ContactDetailFragment r0, ArrayList r1) {
        r0.mPostalEntries = r1;
        return r1;
    }

    static /* synthetic */ ArrayList access$2900(ContactDetailFragment r0) {
        return r0.mEmailEntries;
    }

    static /* synthetic */ ArrayList access$2902(ContactDetailFragment r0, ArrayList r1) {
        r0.mEmailEntries = r1;
        return r1;
    }

    static /* synthetic */ String access$300(ContactDetailFragment r0) {
        return r0.contactsName;
    }

    static /* synthetic */ ArrayList access$3002(ContactDetailFragment r0, ArrayList r1) {
        r0.mSmsEntries = r1;
        return r1;
    }

    static /* synthetic */ String access$302(ContactDetailFragment r0, String r1) {
        r0.contactsName = r1;
        return r1;
    }

    static /* synthetic */ boolean access$3102(ContactDetailFragment r0, boolean r1) {
        r0.mFromBCR = r1;
        return r1;
    }

    static /* synthetic */ ArrayList access$3200(ContactDetailFragment r0) {
        return r0.mAllEntries;
    }

    static /* synthetic */ int access$3300(ContactDetailFragment r0) {
        return r0.mPhoneSize;
    }

    static /* synthetic */ int access$3302(ContactDetailFragment r0, int r1) {
        r0.mPhoneSize = r1;
        return r1;
    }

    static /* synthetic */ boolean access$3402(ContactDetailFragment r0, boolean r1) {
        r0.mIsUniqueNumber = r1;
        return r1;
    }

    static /* synthetic */ boolean access$3502(ContactDetailFragment r0, boolean r1) {
        r0.mIsUniqueEmail = r1;
        return r1;
    }

    static /* synthetic */ void access$3600(ContactDetailFragment r0) {
        r0.setupFlattenedList();
    }

    static /* synthetic */ Parcelable access$3700(ContactDetailFragment r0) {
        return r0.mListState;
    }

    static /* synthetic */ Parcelable access$3702(ContactDetailFragment r0, Parcelable r1) {
        r0.mListState = r1;
        return r1;
    }

    static /* synthetic */ View access$3800(ContactDetailFragment r0) {
        return r0.mEmptyView;
    }

    static /* synthetic */ void access$3900(ContactDetailFragment r0) {
        r0.startQueryCallLog();
    }

    static /* synthetic */ Listener access$400(ContactDetailFragment r0) {
        return r0.mListener;
    }

    static /* synthetic */ int access$4000(ContactDetailFragment r0) {
        return r0.mNumberMainMarkClassify;
    }

    static /* synthetic */ int access$4002(ContactDetailFragment r0, int r1) {
        r0.mNumberMainMarkClassify = r1;
        return r1;
    }

    static /* synthetic */ int access$4100(ContactDetailFragment r0) {
        return r0.mInterceptType;
    }

    static /* synthetic */ int access$4200(ContactDetailFragment r0) {
        return r0.mBlackListViewRefreshFlag;
    }

    static /* synthetic */ String access$4300(ContactDetailFragment r0) {
        return r0.mNeedHighlighNumber;
    }

    static /* synthetic */ Function5 access$4400(ContactDetailFragment r0) {
        return r0.mBlockedBtnClick;
    }

    static /* synthetic */ BlockedContentHelper access$4500(ContactDetailFragment r0) {
        return r0.mBlockedContentHelper;
    }

    static /* synthetic */ void access$4600(ContactDetailFragment r0) {
        r0.showBlackSheet();
    }

    static /* synthetic */ ContactLoader.Result access$4700(ContactDetailFragment r0) {
        return r0.mContactData;
    }

    static /* synthetic */ void access$4800(ContactDetailFragment r0, View r1, ListAdapter r2, AdapterView.OnItemClickListener r3) {
        r0.showListPopup(r1, r2, r3);
    }

    static /* synthetic */ View access$500(ContactDetailFragment r0) {
        return r0.mView;
    }

    static /* synthetic */ String access$5100(DataKind r0, ContentValues r1, Context r2) {
        return buildDataString(r0, r1, r2);
    }

    static /* synthetic */ boolean access$5200() {
        return isDebug;
    }

    static /* synthetic */ LayoutInflater access$5300(ContactDetailFragment r0) {
        return r0.mInflater;
    }

    static /* synthetic */ View access$5800(ContactDetailFragment r0) {
        return r0.mBlacklistPhoto;
    }

    static /* synthetic */ View access$5802(ContactDetailFragment r0, View r1) {
        r0.mBlacklistPhoto = r1;
        return r1;
    }

    static /* synthetic */ int access$5900(ContactDetailFragment r0) {
        return r0.mPhotoViewRefreshFlag;
    }

    static /* synthetic */ Context access$600(ContactDetailFragment r0) {
        return r0.mContext;
    }

    static /* synthetic */ boolean access$6000(ContactDetailFragment r0) {
        return r0.mHasCallLog;
    }

    static /* synthetic */ boolean access$6002(ContactDetailFragment r0, boolean r1) {
        r0.mHasCallLog = r1;
        return r1;
    }

    static /* synthetic */ boolean access$6100(ContactDetailFragment r0) {
        return r0.isInBlackList();
    }

    static /* synthetic */ Uri access$6200(ContactDetailFragment r0) {
        return r0.mLookupUri;
    }

    static /* synthetic */ boolean access$6300(ContactDetailFragment r0) {
        return r0.mUseStrictPhoneNumberComparation;
    }

    static /* synthetic */ ArrayList access$6500(ContactDetailFragment r0) {
        return r0.mNeedHighlightNumbers;
    }

    static /* synthetic */ FragmentActivity access$700(ContactDetailFragment r0) {
        return r0.mActivity;
    }

    static /* synthetic */ void access$7100(ContactDetailFragment r0, String r1) {
        r0.cancelStar(r1);
    }

    static /* synthetic */ void access$7200(ContactDetailFragment r0) {
        r0.dismissStarActionDialog();
    }

    static /* synthetic */ void access$7300(ContactDetailFragment r0, String r1) {
        r0.starNumber(r1);
    }

    static /* synthetic */ long access$7500(ContactDetailFragment r0, List r1) {
        return r0.getDefaultGroupId(r1);
    }

    static /* synthetic */ void access$7600(ContactDetailFragment r0, AccountWithDataSet r1) {
        r0.createCopy(r1);
    }

    static /* synthetic */ CallLogQueryHandler.Listener access$7700(ContactDetailFragment r0) {
        return r0.mCalLogQueryHandlerListener;
    }

    static /* synthetic */ OPopover access$7800(ContactDetailFragment r0) {
        return r0.mMenuPopover;
    }

    static /* synthetic */ void access$7900(ContactDetailFragment r0) {
        r0.onClickStar();
    }

    static /* synthetic */ void access$800(ContactDetailFragment r0) {
        r0.checkOutCallLogState();
    }

    static /* synthetic */ void access$8000(ContactDetailFragment r0) {
        r0.onClickShare();
    }

    static /* synthetic */ void access$8100(ContactDetailFragment r0) {
        r0.onClickBlock();
    }

    static /* synthetic */ void access$8200(ContactDetailFragment r0) {
        r0.onClickDelete();
    }

    static /* synthetic */ ArrayList access$900(ContactDetailFragment r0) {
        return r0.mPhoneNumberList;
    }

    static /* synthetic */ ArrayList access$902(ContactDetailFragment r0, ArrayList r1) {
        r0.mPhoneNumberList = r1;
        return r1;
    }

    static {
        isDebug = ContactsUtils.DEBUG;
    }

    public void setFragmentsCallback(ContactFragmentsCallback r1) {
        this.mFragmentsCallback = r1;
    }

    public ContactDetailFragment() {
        this.mPrimaryPhoneUri = null;
        this.mPhoneNumberList = new ArrayList();
        this.mFreeCallNumberList = new ArrayList();
        this.mShowStaticPhoto = true;
        this.mFavoriteNumberList = new HashSet();
        this.mNeedHighlighNumber = null;
        this.mNumberMainMarkClassify = 0;
        this.mInterceptType = 0;
        this.mDisplayName = "";
        this.mNetworkConnStatusReceiver = new AnonymousClass1(this);
        this.mRawContactIds = new ArrayList();
        this.mPhoneEntries = new ArrayList();
        this.mSmsEntries = new ArrayList();
        this.mEmailEntries = new ArrayList();
        this.mPostalEntries = new ArrayList();
        this.mImEntries = new ArrayList();
        this.mNicknameEntries = new ArrayList();
        this.mGroupEntries = new ArrayList();
        this.mRelationEntries = new ArrayList();
        this.mNoteEntries = new ArrayList();
        this.mCamCardCompanyEntries = new ArrayList();
        this.mWebsiteEntries = new ArrayList();
        this.mSipEntries = new ArrayList();
        this.mEventEntries = new ArrayList();
        this.mGenderEntries = new ArrayList();
        this.mCardIdEntries = new ArrayList();
        this.mOtherEntriesMap = new HashMap();
        this.mAllEntries = new ArrayList();
        this.mPhotoViewRefreshFlag = -1;
        this.mBlackListViewRefreshFlag = -1;
        this.mBarcodeDialog = null;
        this.mCachedPhoneNumber = null;
        this.mCurrentPhoneNumber = new HashSet();
        this.mBlockedContentHelper = new BlockedContentHelper();
        this.mNavigationBarObserver = new AnonymousClass2(this);
        this.mOnItemClickListener = new AnonymousClass5(this);
        this.mBlockedBtnClick = new AnonymousClass8(this);
        this.contactsName = null;
        this.mHasCallLog = true;
        this.mCalLogQueryHandlerListener = new AnonymousClass17(this);
        this.mMenuPopover = null;
    }

    @Override // com.android.contacts.AbstractFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (r2 == null) goto L5;
        this.mLookupUri = (Uri) r2.getParcelable("contactUri");
        this.mListState = r2.getParcelable(KEY_LIST_STATE);
    L5:
        NfcHandler.register(getActivity(), this);
        this.mUseStrictPhoneNumberComparation = getActivity().getResources().getBoolean(R.bool.config_use_strict_phone_number_comparation);
        if (DSUtils.isMultiSimEnabled() == false) goto L13;
        DSUtils.registerDSFeatureStatusListener(this);
        if (DSUtils.sShouldUpdateShowSimIcon == true) goto L10;
        return;
    L10:
        if (DSUtils.useDSFeature() == false) goto L15;
        new CallLogQueryHandler(getActivity().getContentResolver(), this.mCalLogQueryHandlerListener).updateShowSimId();
        DSUtils.sShouldUpdateShowSimIcon = false;
        return;
    L15:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mFreeCallAvailable = false;
        if (ContactsUtils.isFeatureUSEnabled() == false) goto L5;
    L7:
        this.mNeedRequeryFreeCall = this.mFreeCallAvailable;
        if (this.mContactData == null) goto L10;
        bindData();
    L10:
        IntentFilter r0 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(getActivity(), this.mNetworkConnStatusReceiver, r0);
        return;
    L5:
        if (ContactsUtils.isFeatureDomestic() == false) goto L7;
        this.mFreeCallAvailable = CootekManager.getInstance().hasRegisteredPhoneNumber();
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(this.mNetworkConnStatusReceiver);
    }

    @Override // com.android.contacts.AbstractFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        NfcHandler.unregister(getActivity());     // Catch: IllegalStateException -> L5
    L8:
        if (DSUtils.isMultiSimEnabled() == false) goto L10;
        DSUtils.unregisterDSFeatureStatusListener(this);
    L10:
        Dialog r0 = this.mBarcodeDialog;
        if (r0 != null) goto L13;
    L15:
        destroyWorkerHandler();
        return;
    L13:
        if (r0.isShowing() == false) goto L15;
        this.mBarcodeDialog.dismiss();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        r3.putParcelable("contactUri", this.mLookupUri);
        ListView r2 = this.mListView;
        if (r2 == null) goto L6;
        r3.putParcelable(KEY_LIST_STATE, r2.onSaveInstanceState());
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity r1) {
        super.onAttach(r1);
        this.mContext = r1;
        this.mActivity = (FragmentActivity) r1;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Bundle r6 = getActivity().getIntent().getExtras();
        BlackListQueryHandler r0 = new BlackListQueryHandler(getActivity());
        this.mBlackListHandler = r0;
        r0.setCallback(this);
        if (r6 == null) goto L5;
        this.mNeedHighlighNumber = r6.getString(ContactsUtils.EXTRA_PHONE_NUMBERS);
        this.mNeedHighlightNumbers = r6.getStringArrayList(ContactsUtils.EXTRA_PHONE_NUMBERS_HIGHLIGHT);
        this.mInterceptType = r6.getInt(ContactsUtils.EXTRA_INTERCEPT_TYPE, 0);
    L5:
        View r7 = ContactDetailCacheManager.getInstance().getCachedView(R.layout.contact_detail_fragment);
        this.mView = r7;
        if (r7 != null) goto L8;
        this.mView = r3.inflate(R.layout.contact_detail_fragment, r4, false);
    L8:
        this.mInflater = r3;
        this.mStaticPhotoView = (ImageView) this.mView.findViewById(R.id.photo);
        this.mVerticalScrollListener = new AnonymousClass3(this);
        this.mListView = (ListView) this.mView.findViewById(android.R.id.list);
        Immersive.Companion.getImmersive(getActivity()).getNavigationBarHeight().observeForever(this.mNavigationBarObserver);
        NavigationBarHelper.setBottomPaddingWhenNavigationBarStatusChange(this.mListView);
        this.mListView.setScrollBarStyle(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
        this.mListView.setOnItemClickListener(this.mOnItemClickListener);
        this.mListView.setItemsCanFocus(true);
        this.mListView.setOnScrollListener(this.mVerticalScrollListener);
        this.mListView.setAccessibilityDelegate(new AnonymousClass4(this));
        OUIHelper.OUIList.setHeader(r3, this.mListView, null);
        this.mEmptyView = this.mView.findViewById(android.R.id.empty);
        this.mView.setVisibility(4);
        if (this.mContactData == null) goto L12;
        bindData();
    L12:
        return this.mView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Immersive.Companion.getImmersive(getActivity()).getNavigationBarHeight().removeObserver(this.mNavigationBarObserver);
        ContactDetailBuildEntryTask r0 = this.mContactDetailBuildEntryTask;
        if (r0 == null) goto L6;
        r0.cancel(true);
        this.mContactDetailBuildEntryTask = null;
        return;
    }

    protected View inflate(int r1, ViewGroup r2, boolean r3) {
        return this.mInflater.inflate(r1, r2, r3);
    }

    public void setListener(Listener r1) {
        this.mListener = r1;
    }

    protected Context getSelfContext() {
        return this.mContext;
    }

    protected Listener getListener() {
        return this.mListener;
    }

    protected ContactLoader.Result getContactData() {
        return this.mContactData;
    }

    public void setVerticalScrollListener(AbsListView.OnScrollListener r1) {
        this.mVerticalScrollListener = r1;
    }

    public Uri getUri() {
        return this.mLookupUri;
    }

    public void setShowStaticPhoto(boolean r1) {
        this.mShowStaticPhoto = r1;
    }

    public void showEmptyState() {
        setData(null, null);
    }

    public void setData(Uri r1, ContactLoader.Result r2) {
        this.mLookupUri = r1;
        this.mContactData = r2;
        bindData();
    }

    public void resetAdapter() {
        ListView r0 = this.mListView;
        if (r0 == null) goto L6;
        r0.setAdapter(this.mAdapter);
        return;
    }

    public int getFirstListItemOffset() {
        return ContactDetailDisplayUtils.getFirstListItemOffset(this.mListView);
    }

    public void requestToMoveToOffset(int r1) {
        ContactDetailDisplayUtils.requestToMoveToOffset(this.mListView, r1);
    }

    protected void bindData() {
        if (this.mView != null) goto L5;
        return;
    L5:
        ContactDetailBuildEntryTask r0 = this.mContactDetailBuildEntryTask;
        boolean r1 = true;
        if (r0 == null) goto L8;
        r0.cancel(true);
        this.mContactDetailBuildEntryTask = null;
    L8:
        ContactLoader.Result r2 = this.mContactData;
        if (r2 != null) goto L15;
        this.mView.setVisibility(4);
        this.mPhoneEntries.clear();
        this.mAllEntries.clear();
        ViewAdapter r10 = this.mAdapter;
        if (r10 == null) goto L28;
        r10.notifyDataSetChanged();
        return;
    L28:
        return;
    L15:
        if (this.mFreeCallAvailable == true) goto L17;
    L19:
        r1 = false;
    L20:
        this.mFreeCallAvailable = r1;
        this.mNeedRequeryFreeCall = r1;
        ImageView r3 = this.mStaticPhotoView;
        if (r3 != null) goto L23;
    L26:
        ContactDetailBuildEntryTask r4 = new ContactDetailBuildEntryTask(getActivity(), this, this.mContactData, this.mFreeCallAvailable, new AnonymousClass6(this));
        this.mContactDetailBuildEntryTask = r4;
        r4.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        getNumberClassify(this.mNeedHighlighNumber);
        return;
    L23:
        if (this.mShowStaticPhoto == false) goto L25;
        r3.setVisibility(0);
        ContactDetailDisplayUtils.setPhoto(this.mContext, this.mContactData, this.mStaticPhotoView);
        goto L26
    L25:
        r3.setVisibility(8);
        goto L26
    L17:
        if (r2.isUserProfile() == true) goto L19;
        goto L19
    }

    private void getNumberClassify(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        NumberInfosManager.getInstance().getBaseAndMarkInfosAsync(r3, new AnonymousClass7(this).toDestroyObservable(getDestroyObservable()));
    }

    private long getDefaultGroupId(List<GroupMetaData> r6) {
        Iterator<GroupMetaData> r5 = r6.iterator();
        long r2 = -1;
    L4:
        if (r5.hasNext() == false) goto L11;
        GroupMetaData r7 = r5.next();
        if (r7.isDefaultGroup() == false) goto L4;
        if (r2 != (-1)) goto L9;
        r2 = r7.getGroupId();
        goto L4
    L9:
        return -1;
    L11:
        return r2;
    }

    private void checkOutCallLogState() {
        Callback r0 = this.mCallback;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.getPhoneCallDetails() != null) goto L8;
        return;
    L8:
        if (this.mCallback.getPhoneCallDetails().length == 0) goto L36;
        Set<String> r1 = this.mCachedPhoneNumber;
        if (r1 != null) goto L14;
        HashSet r2 = new HashSet();
        this.mCachedPhoneNumber = r2;
        r2.addAll(this.mCurrentPhoneNumber);
        return;
    L14:
        if (r1.size() != 0) goto L17;
        return;
    L17:
        if (this.mCurrentPhoneNumber.size() != 0) goto L21;
        this.mCallback.clearUpCallLog();
        this.mCachedPhoneNumber.clear();
        this.mCachedPhoneNumber.addAll(this.mCurrentPhoneNumber);
        return;
    L21:
        if (this.mCachedPhoneNumber.size() == this.mCurrentPhoneNumber.size()) goto L24;
        this.mCallback.clearUpCallLog();
        this.mCachedPhoneNumber.clear();
        this.mCachedPhoneNumber.addAll(this.mCurrentPhoneNumber);
        return;
    L24:
        Iterator<String> r3 = this.mCachedPhoneNumber.iterator();
    L26:
        if (r3.hasNext() == false) goto L37;
        String r4 = r3.next();
        if (this.mCurrentPhoneNumber.contains(r4) == true) goto L26;
        this.mCallback.clearUpCallLog();
        this.mCachedPhoneNumber.clear();
        this.mCachedPhoneNumber.addAll(this.mCurrentPhoneNumber);
        return;
    L37:
        return;
    }

    private void setupFlattenedList() {
        if (isAdded() == true) goto L5;
        return;
    L5:
        this.mAllEntries.add(new HeaderViewEntry());
        flattenPhoneAction();
        boolean r1 = false;
        ArrayList<DetailViewEntry> r0 = flattenList(this.mPhoneEntries, false);
        setCardTopPadding(r0);
        setCardPosition(r0, true);
        this.mAllEntries.addAll(r0);
        ContactsUtils.isFeatureDomestic();
        if (this.mCallback.hasCallLog() == false) goto L8;
        this.mAllEntries.add(new CalllogViewEntry());
    L8:
        ContactLoader.Result r2 = this.mContactData;
        Uri r3 = null;
        if (r2 != null) goto L11;
        String r4 = null;
    L13:
        if (TextUtils.isEmpty(r4) == true) goto L16;
        r3 = Uri.parse(r4);
    L16:
        if (r3 == null) goto L21;
        if (RingtoneManager.isDefault(r3) == true) goto L21;
        r1 = true;
    L21:
        if (this.mSmsEntries.isEmpty() == true) goto L23;
    L47:
        this.mAllEntries.add(new SectionEntry(getResources().getString(R.string.label_person_information)));
    L48:
        ArrayList<? extends ViewEntry> r5 = new ArrayList();
        r5.addAll(flattenList(this.mSmsEntries));
        r5.addAll(flattenList(this.mEmailEntries));
        r5.addAll(flattenList(this.mImEntries));
        r5.addAll(flattenList(this.mNicknameEntries));
        r5.addAll(flattenList(this.mCamCardCompanyEntries));
        r5.addAll(flattenList(this.mWebsiteEntries));
        r5.addAll(flattenList(this.mGenderEntries));
        r5.addAll(flattenList(this.mCardIdEntries));
        r5.addAll(addNetworks());
        r5.addAll(flattenList(this.mSipEntries));
        r5.addAll(flattenList(this.mPostalEntries));
        r5.addAll(flattenList(this.mEventEntries));
        r5.addAll(flattenList(this.mGroupEntries));
        r5.addAll(flattenList(this.mRelationEntries));
        if (r1 == false) goto L51;
        r5.add(new CustomRingtoneViewEntry(getActivity(), r3));
    L51:
        setCardPosition(r5, true);
        this.mAllEntries.addAll(r5);
        flattenBtns();
        flattenBusinessCard();
        return;
    L23:
        if (this.mEmailEntries.isEmpty() == false) goto L47;
        if (this.mImEntries.isEmpty() == false) goto L47;
        if (this.mNicknameEntries.isEmpty() == false) goto L47;
        if (this.mCamCardCompanyEntries.isEmpty() == false) goto L47;
        if (this.mWebsiteEntries.isEmpty() == false) goto L47;
        if (this.mSipEntries.isEmpty() == false) goto L47;
        if (this.mPostalEntries.isEmpty() == false) goto L47;
        if (this.mEventEntries.isEmpty() == false) goto L47;
        if (this.mGroupEntries.isEmpty() == false) goto L47;
        if (this.mRelationEntries.isEmpty() == false) goto L47;
        if (this.mGenderEntries.isEmpty() == false) goto L47;
        if (this.mCardIdEntries.isEmpty() == false) goto L47;
        if (r1 == false) goto L48;
    L11:
        r4 = r2.getCustomRingtone();
        goto L13
    }

    private void setCardTopPadding(ArrayList<DetailViewEntry> r2) {
        if (r2.isEmpty() == false) goto L5;
        return;
    L5:
        if (getContext() == null) goto L10;
        DetailViewEntry r3 = r2.get(0);
        r3.cardTopPadding = Integer.valueOf(getResources().getDimensionPixelSize(R.dimen.contact_detail_phone_action_top_padding));
        return;
    }

    private void setCardPosition(ArrayList<? extends ViewEntry> r6, boolean r7) {
        if (r6.isEmpty() == false) goto L5;
        return;
    L5:
        int r5 = r6.size();
        if (r5 != 1) goto L8;
        r6.get(0).cardPosition = 0;
        return;
    L8:
        int r2 = 0;
    L9:
        if (r2 >= r5) goto L32;
        ViewEntry r3 = r6.get(r2);
        if (r2 != 0) goto L16;
        r3.cardPosition = 1;
        if (r7 == false) goto L23;
        r3.cardNeedDivider = true;
    L23:
        r2 = r2 + 1;
        goto L9
    L16:
        if (r2 != (r5 - 1)) goto L20;
        r3.cardPosition = 3;
        if (r7 == false) goto L23;
        r3.cardNeedDivider = false;
        goto L23
    L20:
        r3.cardPosition = 2;
        if (r7 == false) goto L23;
        r3.cardNeedDivider = true;
        goto L23
    }

    private void addPhoneticName() {
        String r0 = ContactDetailDisplayUtils.getPhoneticName(this.mContext, this.mContactData);
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return;
    L5:
        String r1 = this.mContext.getString(R.string.name_phonetic);
        this.mAllEntries.add(new KindTitleViewEntry(r1));
        DetailViewEntry r2 = new DetailViewEntry();
        r2.kind = r1;
        r2.data = r0;
        this.mAllEntries.add(r2);
    }

    private ArrayList<DetailViewEntry> addNetworks() {
        String r0 = ContactDetailDisplayUtils.getAttribution(this.mContext, this.mContactData);
        ArrayList<DetailViewEntry> r1 = new ArrayList();
        boolean r2 = !TextUtils.isEmpty(r0);
        int r4 = this.mOtherEntriesMap.keySet().size();
        if (this.mContactData.getInvitableAccountTypes() == null) goto L5;
        int r5 = this.mContactData.getInvitableAccountTypes().size();
    L6:
        if (r2 == true) goto L10;
        if (r4 != 0) goto L10;
        if (r5 != 0) goto L10;
        return r1;
    L10:
        String r6 = this.mContext.getString(R.string.connections);
        if (r2 == false) goto L13;
        DetailViewEntry r3 = new DetailViewEntry();
        r3.kind = r6;
        r3.data = r0;
        r1.add(r3);
    L13:
        Iterator<AccountType> r7 = this.mOtherEntriesMap.keySet().iterator();
    L15:
        if (r7.hasNext() == false) goto L34;
        AccountType r8 = r7.next();
        HashMap r9 = new HashMap();
        Iterator<DetailViewEntry> r10 = this.mOtherEntriesMap.get(r8).iterator();
    L18:
        if (r10.hasNext() == false) goto L15;
        DetailViewEntry r11 = r10.next();
        r11.setIsInSubSection(true);
        if (r11.mimetype == null) goto L33;
        if (r11.mimetype.startsWith(ContactsUtils.WECHAT_MIMETYPE_PREFIX) == true) goto L26;
        if (r11.mimetype.startsWith(ContactsUtils.WHATSAPP_MINTYPE) == false) goto L33;
    L26:
        if (r9.get(r11.mimetype) == null) goto L27;
        DetailViewEntry r12 = r1.get(((Integer) r9.get(r11.mimetype)).intValue());
        if ((r12 instanceof DetailViewEntry) == false) goto L18;
        DetailViewEntry r13 = r12;
        if (r13.socialIntents == null) goto L18;
        r13.socialIntents.add(r11.intent);
        goto L18
    L27:
        r9.put(r11.mimetype, Integer.valueOf(r1.size()));
        r11.socialIntents = new ArrayList();
        r11.socialIntents.add(r11.intent);
        r1.add(r11);
    L33:
        r1.add(r11);
        goto L18
    L34:
        this.mOtherEntriesMap.clear();
        if (r5 <= 0) goto L37;
        addMoreNetworks();
    L37:
        return r1;
    L5:
        r5 = 0;
        goto L6
    }

    private void addMoreNetworks() {
        final InvitableAccountTypesAdapter r0 = new InvitableAccountTypesAdapter(this.mContext, this.mContactData);
        final AdapterView.OnItemClickListener r1 = new AnonymousClass9(this, r0);
        new AnonymousClass10(this, r0, r1);
    }

    private ArrayList<DetailViewEntry> flattenList(ArrayList<DetailViewEntry> r2) {
        return flattenList(r2, true);
    }

    private ArrayList<DetailViewEntry> flattenList(ArrayList<DetailViewEntry> r8, boolean r9) {
        int r0 = r8.size();
        ArrayList<DetailViewEntry> r1 = new ArrayList();
        if (r0 <= 0) goto L37;
        int r2 = 0;
        if (r8.get(0).mimetype.equals("mimetype") == false) goto L26;
        boolean r3 = true;
        if (r0 <= 1) goto L24;
        String r7 = getResources().getString(R.string.symbol_comma);
        StringBuilder r4 = new StringBuilder();
        Iterator<DetailViewEntry> r5 = r8.iterator();
    L10:
        if (r5.hasNext() == false) goto L23;
        DetailViewEntry r6 = r5.next();
        if (r3 == false) goto L14;
        r3 = false;
    L16:
        if (r6.rawData != null) goto L22;
        if (r6.data != null) goto L20;
        String r10 = "";
    L21:
        r6.rawData = r10;
        goto L22
    L20:
        r10 = r6.data;
    L22:
        r4.append(r6.rawData);
        goto L10
    L14:
        r4.append(r7);
        goto L16
    L23:
        r8.get(0).data = r4.toString();
    L24:
        r1.add(r8.get(0));
        goto L37
    L26:
        if (r8.get(0).mimetype.equals("vnd.android.cursor.item/phone_v2") == false) goto L32;
    L27:
        if (r2 >= r0) goto L37;
        if (r8.get(r2) == null) goto L31;
        r1.add(r8.get(r2));
    L31:
        r2 = r2 + 1;
    L32:
        if (r2 >= r0) goto L37;
        if (r8.get(r2) == null) goto L36;
        r1.add(r8.get(r2));
    L36:
        r2 = r2 + 1;
    L37:
        if (r9 == false) goto L39;
        r8.clear();
    L39:
        return r1;
    }

    private void flattenCustomRingtone() {
        this.mAllEntries.add(new CustomRingtoneViewEntry(getActivity(), Uri.parse(this.mContactData.getCustomRingtone())));
    }

    private void flattenBtns() {
        this.mAllEntries.add(new BtnsViewEntry());
    }

    private void flattenBusinessCard() {
        if (this.mFromBCR == false) goto L6;
        this.mAllEntries.add(new BusinessCardEntry());
        return;
    }

    private void flattenPhoneAction() {
        this.mAllEntries.add(new PhoneActionEntry());
    }

    private void addRechargeButton() {
        if (ContactsUtils.isFeatureUSEnabled() == false) goto L5;
        return;
    L5:
        if (this.mContactData.isUserProfile() == false) goto L9;
        this.mAllEntries.add(new ViewEntry(9));
        return;
    }

    private void handleGroupMembership(ArrayList<GroupNameWithID> r4, List<GroupMetaData> r5, long r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        ArrayList r3 = new ArrayList();
        Iterator<GroupNameWithID> r0 = r4.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        r3.add(r0.next().gname);
        goto L6
    L8:
        Iterator<GroupMetaData> r7 = r5.iterator();
    L10:
        if (r7.hasNext() == false) goto L31;
        GroupMetaData r1 = r7.next();
        if (r1.getGroupId() != r6) goto L10;
        if (r1.isDefaultGroup() == false) goto L16;
        return;
    L16:
        if (r1.isFavorites() == true) goto L28;
        String r8 = r1.getTitle();
        if (TextUtils.isEmpty(r8) == false) goto L20;
        return;
    L20:
        if (r3.contains(r8) == true) goto L30;
        r4.add(new GroupNameWithID(r6, r8));
        return;
    L30:
        return;
    L28:
        return;
    }

    private static String buildDataString(DataKind r2, ContentValues r3, Context r4) {
        if (r2.actionBody != null) goto L5;
        return null;
    L5:
        CharSequence r5 = r2.actionBody.inflateUsing(r4, r3);
        if (r5 != null) goto L9;
        return null;
    L9:
        return r5.toString();
    }

    public static void buildImActions(Context r5, DetailViewEntry r6, ContentValues r7) {
        boolean r0 = "vnd.android.cursor.item/email_v2".equals(r7.getAsString("mimetype"));
        if (r0 == false) goto L5;
    L7:
        String r1 = r7.getAsString("data1");
        if (TextUtils.isEmpty(r1) == false) goto L11;
        return;
    L11:
        if (r0 == false) goto L13;
        int r2 = 5;
    L15:
        if (r2 != 5) goto L27;
        Integer r8 = r7.getAsInteger("chat_capability");
        if (r8 != null) goto L19;
        int r9 = 0;
    L20:
        r6.chatCapability = r9;
        r6.typeString = ContactsContract.CommonDataKinds.Im.getProtocolLabel(r5.getResources(), 5, null).toString();
        if ((r9 & 4) == 0) goto L24;
        r6.intent = new Intent("android.intent.action.SENDTO", Uri.parse("xmpp:" + r1 + "?message"));
        r6.secondaryIntent = new Intent("android.intent.action.SENDTO", Uri.parse("xmpp:" + r1 + "?call"));
        return;
    L24:
        if ((r9 & 1) == 0) goto L26;
        r6.intent = new Intent("android.intent.action.SENDTO", Uri.parse("xmpp:" + r1 + "?message"));
        r6.secondaryIntent = new Intent("android.intent.action.SENDTO", Uri.parse("xmpp:" + r1 + "?call"));
        return;
    L26:
        r6.intent = new Intent("android.intent.action.SENDTO", Uri.parse("xmpp:" + r1 + "?message"));
        return;
    L19:
        r9 = r8.intValue();
        goto L20
    L27:
        String r10 = r7.getAsString("data6");
        if (r2 == (-1)) goto L31;
        r10 = ContactsUtils.lookupProviderNameFromId(r2);
    L31:
        if (TextUtils.isEmpty(r10) == true) goto L37;
        r6.intent = new Intent("android.intent.action.SENDTO", new Uri.Builder().scheme("imto").authority(r10.toLowerCase()).appendPath(r1).build());
        return;
    L37:
        return;
    L13:
        r2 = r7.getAsInteger("data5").intValue();
        goto L15
    L5:
        if (isProtocolValid(r7) == true) goto L7;
    }

    private static boolean isProtocolValid(ContentValues r1) {
        String r2 = r1.getAsString("data5");
        if (r2 != null) goto L9;
        return false;
    L9:
        Integer.valueOf(r2);     // Catch: NumberFormatException -> L8
        return true;
    L8:
        return false;
    }

    private void showListPopup(View r4, ListAdapter r5, final AdapterView.OnItemClickListener r6) {
        final ListPopupWindow r0 = new ListPopupWindow(this.mContext, null);
        r0.setAnchorView(r4);
        r0.setWidth(r4.getWidth());
        r0.setAdapter(r5);
        r0.setModal(true);
        r0.setOnItemClickListener(new AnonymousClass11(this, r6, r0));
        r0.show();
    }

    public void refreshCallLog() {
        ViewAdapter r0 = this.mAdapter;
        if (r0 == null) goto L6;
        r0.notifyDataSetChanged();
        return;
    }

    private void showStartSheet() {
        OActionDialog r0 = OUIDialogHelper.getActionDialog(this.mActivity, getResources().getString(R.string.select_phone_number), "", getStarActionItemData(), true);
        this.mStarActionDialog = r0;
        r0.show();
    }

    private List<ActionDialogItemData> getStarActionItemData() {
        ArrayList r0 = new ArrayList();
        Iterator<String> r1 = this.mPhoneNumberList.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        final String r2 = ContactsUtils.formatNumber(r1.next());
        if (this.mFavoriteNumberList.contains(r2) == true) goto L7;
        r0.add(new ActionDialogItemData(getString(R.string.add_to_favorites, new Object[]{HanziToPinyin.Token.SEPARATOR + r2}), ActionButtonStyle.Neutral, new AnonymousClass13(this, r2)));
        goto L4
    L7:
        r0.add(new ActionDialogItemData(getString(R.string.remove_from_favorites, new Object[]{HanziToPinyin.Token.SEPARATOR + r2}), ActionButtonStyle.Neutral, new AnonymousClass12(this, r2)));
        goto L4
    L9:
        r0.add(new ActionDialogItemData(getString(R.string.common_cancel), ActionButtonStyle.Neutral, new AnonymousClass14(this)));
        return r0;
    }

    private void dismissStarActionDialog() {
        OActionDialog r0 = this.mStarActionDialog;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L9;
        this.mStarActionDialog.dismiss();
        return;
    }

    private void showBlackSheet() {
        OAlertDialogUtils.showDefaultBlacklistConfirmationDialog(this.mContext, new AnonymousClass15(this));
    }

    private void cancelStar(String r6) {
        this.mContext.startService(ContactSaveService.createSetPhoneStarredIntent(this.mContext, this.mContactData.getId(), new String[]{r6}, false));
        this.mFavoriteNumberList.remove(r6);
    }

    private ArrayList<String> getPhoneNumbers() {
        ArrayList<String> r0 = new ArrayList();
        Iterator<ViewEntry> r4 = this.mAllEntries.iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        ViewEntry r1 = r4.next();
        if (r1.getViewType() != 6) goto L4;
        DetailViewEntry r2 = (DetailViewEntry) r1;
        if ("vnd.android.cursor.item/phone_v2".equals(r2.mimetype) == false) goto L4;
        r0.add(r2.data);
        goto L4
    L10:
        return r0;
    }

    @Override // com.android.contacts.editor.SelectAccountDialogFragment.Listener
    public void onAccountChosen(AccountWithDataSet r1, Bundle r2) {
        createCopy(r1);
    }

    private void createCopy(AccountWithDataSet r2) {
        Listener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onCreateRawContactRequested(this.mContactData.getContentValues(), r2);
        return;
    }

    @Override // androidx.fragment.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu r1, View r2, ContextMenu.ContextMenuInfo r3) {
        super.onCreateContextMenu(r1, r2, r3);
        DetailViewEntry r4 = (DetailViewEntry) this.mAllEntries.get(((AdapterView.AdapterContextMenuInfo) r3).position);
        r1.setHeaderTitle(r4.data);
        r1.add(0, 0, 0, getString(R.string.copy_text));
        String r0 = r4.mimetype;
        if ("vnd.android.cursor.item/phone_v2".equals(r0) == true) goto L7;
        "vnd.android.cursor.item/email_v2".equals(r0);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onContextItemSelected(MenuItem r5) {
        AdapterView.AdapterContextMenuInfo r0 = (AdapterView.AdapterContextMenuInfo) r5.getMenuInfo();     // Catch: ClassCastException -> L16
        int r1 = r5.getItemId();
        if (r1 == 0) goto L14;
        if (r1 != 1) goto L7;
        clearDefaultContactMethod(this.mListView.getItemIdAtPosition(r0.position));
        return true;
    L7:
        if (r1 != 2) goto L11;
        setDefaultContactMethod(this.mListView.getItemIdAtPosition(r0.position));
        return true;
    L11:
        throw new IllegalArgumentException("Unknown menu option " + r5.getItemId());
    L14:
        copyToClipboard(r0.position);
        return true;
    L16:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "bad menuInfo", e);
        return false;
    }

    private void setDefaultContactMethod(long r2) {
        Intent r3 = ContactSaveService.createSetSuperPrimaryIntent(this.mContext, r2);
        this.mContext.startService(r3);
    }

    private void clearDefaultContactMethod(long r2) {
        Intent r3 = ContactSaveService.createClearPrimaryIntent(this.mContext, r2);
        this.mContext.startService(r3);
    }

    private void copyToClipboard(DetailViewEntry r7) {
        String r0 = r7.data;
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return;
    L5:
        boolean r1 = true;
        String[] r2 = {r7.mimetype};
        FragmentActivity r3 = getActivity();
        String r8 = r7.typeString;
        if (DSUtils.isMultiSimEnabled() == true) goto L8;
    L10:
        r1 = false;
    L11:
        ContactsUtils.showCopyToClipboardDialog(r3, r8, r2, r0, r1);
        return;
    L8:
        if (DSUtils.isCalling(getSelfContext()) == true) goto L10;
        goto L10
    }

    private void copyToClipboard(int r6) {
        DetailViewEntry r7 = (DetailViewEntry) this.mAllEntries.get(r6);
        String r0 = r7.data;
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return;
    L5:
        ((ClipboardManager) getActivity().getSystemService("clipboard")).setPrimaryClip(new ClipData(r7.typeString, new String[]{r7.mimetype}, new ClipData.Item(r0)));
        Toast.makeText(getActivity(), getString(R.string.toast_text_copied), 0).show();
    }

    @Override // com.android.contacts.activities.ContactDetailActivity.FragmentKeyListener
    public boolean handleKeyDown(int r5) {
        if (r5 == 5) goto L6;
    L7:
        return false;
    L6:
        if (MultiSimAdapter.phoneIsIdle(this.mContext) == false) goto L7;
        int r6 = this.mListView.getSelectedItemPosition();
        if (r6 == (-1)) goto L19;
        DetailViewEntry r7 = (DetailViewEntry) this.mAdapter.getItem(r6);
        if (r7 != null) goto L13;
    L22:
        return false;
    L13:
        if (r7.intent == null) goto L22;
        if (r7.intent.getAction() != "android.intent.action.CALL_PRIVILEGED") goto L22;
        r7.intent.setPackage(Constants.PHONE_PACKAGE_NAME);
        this.mContext.startActivity(r7.intent);
        return true;
    L19:
        if (this.mPrimaryPhoneUri == null) goto L22;
        Intent r8 = new Intent("android.intent.action.CALL_PRIVILEGED", this.mPrimaryPhoneUri);
        r8.setPackage(Constants.PHONE_PACKAGE_NAME);
        this.mContext.startActivity(r8);
        return true;
    }

    public void setCallback(Callback r1) {
        this.mCallback = r1;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Callback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.cancelShareContact();
        return;
    }

    public void doRemoveBlacklistAction(ArrayList<ViewEntry> r5) {
        ArrayList<HashMap<String, Object>> r0 = new ArrayList();
        Iterator<ViewEntry> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L10;
        ViewEntry r1 = r6.next();
        if (r1.getViewType() != 6) goto L4;
        DetailViewEntry r2 = (DetailViewEntry) r1;
        if ("vnd.android.cursor.item/phone_v2".equals(r2.mimetype) == false) goto L4;
        HashMap<String, Object> r3 = new HashMap();
        r3.put("number", r2.data);
        r0.add(r3);
        goto L4
    L10:
        this.mBlackListHandler.doMultiRemoveBlacklistAction(r0);
    }

    public void doJoinBlacklistAction(ArrayList<ViewEntry> r7) {
        ArrayList<HashMap<String, Object>> r0 = new ArrayList();
        String r1 = ContactDetailDisplayUtils.getDisplayName(getActivity(), this.mContactData).toString();
        byte[] r2 = this.mContactData.getPhotoBinaryData();
        Iterator<ViewEntry> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L10;
        ViewEntry r3 = r8.next();
        if (r3.getViewType() != 6) goto L4;
        DetailViewEntry r4 = (DetailViewEntry) r3;
        if ("vnd.android.cursor.item/phone_v2".equals(r4.mimetype) == false) goto L4;
        HashMap<String, Object> r5 = new HashMap();
        r5.put("number", r4.data);
        r5.put("name", r1);
        r5.put(BlackListQueryHandler.KEY_PHOTO, r2);
        r0.add(r5);
        goto L4
    L10:
        this.mBlackListHandler.doMultiJoinBlacklistAction(r0);
        if (r0.isEmpty() == true) goto L21;
        this.mCallback.playBlacklistSound(true);
        return;
    }

    public void initBlacklistAction(ArrayList<DetailViewEntry> r3) {
        this.mPhotoViewRefreshFlag = -1;
        this.mBlackListViewRefreshFlag = -1;
        ArrayList<String> r0 = new ArrayList();
        if (r3 == null) goto L13;
        if (r3.isEmpty() == true) goto L13;
        Iterator<DetailViewEntry> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L13;
        DetailViewEntry r1 = r4.next();
        if (r1 == null) goto L8;
        r0.add(r1.data);
    L13:
        if (r0.size() <= 0) goto L15;
        this.mBlackListHandler.initBlacklist(r0);
        return;
    L15:
        updateUIForBlacklist(false, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.contacts.util.BlackListQueryHandler.BlackListChangeListener
    public void updateUIForBlacklist(boolean r10, boolean r11) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "execute updateUIForBlacklist");
        if (isAdded() == true) goto L5;
        return;
    L5:
        View r0 = this.mBlacklistPhoto;
        if (r0 == null) goto L15;
        AnimationUtil.setVisibilityWithAnimation(r0, r10, r11);
        View r12 = (View) this.mBlacklistPhoto.getParent();
        if (r12 == null) goto L16;
        View r13 = r12.findViewById(R.id.photo);
        if (r13 == null) goto L16;
        if (r10 == false) goto L13;
        int r1 = 8;
    L14:
        r13.setVisibility(r1);
        goto L16
    L13:
        r1 = 0;
    L16:
        ContactItemButtonCard r6 = (ContactItemButtonCard) this.mView.findViewById(R.id.btn_blocked_call);
        if (r6 == null) goto L19;
        OTextView r14 = r6.getItemText();
    L20:
        BlockedContentHelper r2 = this.mBlockedContentHelper;
        int r3 = this.mInterceptType;
        int r4 = this.mNumberMainMarkClassify;
        String r5 = this.mNeedHighlighNumber;
        r2.tryUpdateBlockedCallBtn(r3, r4, r10, r5, r14, r6, getActivity().getContentResolver(), this.mBlockedBtnClick);
        this.mBlackListViewRefreshFlag = r10 ? 1 : 0;
        return;
    L19:
        r14 = null;
        goto L20
    L15:
        this.mPhotoViewRefreshFlag = r10 ? 1 : 0;
        goto L16
    }

    private void startQueryCallLog() {
        if (this.mContext != null) goto L5;
        return;
    L5:
        if (this.mAdapter == null) goto L10;
        new Handler().postDelayed(new AnonymousClass16(this), 300);
        return;
    }

    @Override // com.android.contacts.DSUtils.DSFatureStatusListener
    public void onDSFeatureStatusChanged() {
        if (DSUtils.useDSFeature() == false) goto L7;
        Context r0 = this.mContext;
        if (r0 == null) goto L7;
        new CallLogQueryHandler(r0.getContentResolver(), this.mCalLogQueryHandlerListener).updateShowSimId();
    L7:
        ViewAdapter r3 = this.mAdapter;
        if (r3 == null) goto L11;
        r3.notifyDataSetChanged();
        return;
    }

    public void onClickMenu(View r4) {
        OPopover r0 = OUIPopoverHelper.genPopover(this.mActivity, getMenuList(), false);
        this.mMenuPopover = r0;
        OUIPopoverHelper.showPopupAtAnchorView(this.mActivity, r0, Direct.TOP_RIGHT, r4, null);
    }

    private List<MenuItemData> getMenuList() {
        ArrayList r1 = new ArrayList();
        if (canStar() == true) goto L5;
    L14:
        r1.add(new MenuItemData(ItemType.TEXT, Integer.valueOf(R.drawable.ic_share), null, null, getResources().getString(R.string.menu_share), null, null, null, null, new AnonymousClass19(this)));
        r1.add(new MenuItemData(ItemType.DIVIDER, null, null, null, null, null, null, null, null, null));
        if (this.mInterceptType <= 0) goto L17;
    L25:
        r1.add(new MenuItemData(ItemType.TEXT, Integer.valueOf(R.drawable.menu_icon_delete), null, null, getResources().getString(R.string.common_delete), null, null, true, null, new AnonymousClass21(this)));
        return r1;
    L17:
        if (blockBtnEnable() == false) goto L25;
        if (this.mContactData.isUserProfile() == true) goto L25;
        if (isInBlackList() == false) goto L23;
        int r2 = R.string.common_remove_from_blocklist;
    L24:
        String r9 = getResources().getString(r2);
        r1.add(new MenuItemData(ItemType.TEXT, Integer.valueOf(R.drawable.menu_icon_blacked), null, null, r9, null, null, null, null, new AnonymousClass20(this)));
        goto L25
    L23:
        r2 = R.string.common_add_to_blacklist;
        goto L24
    L5:
        if (this.mContactData.isUserProfile() == true) goto L14;
        boolean r3 = isAllStared();
        if (r3 == false) goto L9;
        int r4 = R.drawable.menu_icon_starred;
    L10:
        if (r3 == false) goto L12;
        int r5 = R.string.common_remove_from_favorites;
    L13:
        String r10 = getResources().getString(r5);
        r1.add(new MenuItemData(ItemType.TEXT, Integer.valueOf(r4), null, Integer.valueOf(ResourcesCompat.getColor(getResources(), R.color.oui_fill_icon_as_action, null)), r10, null, null, null, null, new AnonymousClass18(this)));
        goto L14
    L12:
        r5 = R.string.common_favorites;
        goto L13
    L9:
        r4 = R.drawable.menu_icon_unstarred;
        goto L10
    }

    private void onClickDelete() {
        ContactLoader.Result r0 = getContactData();
        if (r0 == null) goto L6;
        Uri r1 = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, r0.mId);
        ContactDeletionInteraction.start(this.mActivity, r1, true);
        return;
    }

    private void onClickBlock() {
        if (isInBlackList() == false) goto L5;
        doRemoveBlacklistAction(this.mAllEntries);
        this.mBlockedContentHelper.toastRemoveFromBlackList(this.mActivity);
        return;
    L5:
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_JOIN_BLACKLIST);
        showBlackSheet();
    }

    private boolean blockBtnEnable() {
        if (this.mPhoneSize != 0) goto L6;
        return false;
    L6:
        return true;
    }

    private boolean isInBlackList() {
        if (this.mBlackListViewRefreshFlag == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void onClickShare() {
        if (ContactsUtils.isJustClicked() == false) goto L5;
        return;
    L5:
        if (this.mCallback == null) goto L9;
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_SHARE);
        this.mCallback.setShareContact(this.mDisplayName);
        return;
    }

    private void onClickStar() {
        if (this.mContactData.isUserProfile() == false) goto L5;
        Toast.makeText(this.mContext.getApplicationContext(), R.string.unabletostarred, 0).show();
        return;
    L5:
        ArrayList<String> r0 = this.mPhoneNumberList;
        if (r0 != null) goto L8;
        Toast.makeText(this.mContext.getApplicationContext(), R.string.nonstarred, 0).show();
        return;
    L8:
        if (r0.size() != 1) goto L14;
        if (this.mFavoriteNumberList.size() != 0) goto L12;
        starNumber(this.mPhoneNumberList.get(0));
        return;
    L12:
        cancelStar(this.mPhoneNumberList.get(0));
        return;
    L14:
        if (this.mPhoneNumberList.size() <= 1) goto L21;
        showStartSheet();
        return;
    }

    private boolean isAllStared() {
        if (this.mFavoriteNumberList.size() != this.mPhoneEntries.size()) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean canStar() {
        return !this.mPhoneEntries.isEmpty();
    }

    private void requeryFreeCall() {
        if (this.mNeedRequeryFreeCall == true) goto L9;
        if (ContactsUtils.DEBUG == false) goto L36;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "Duplicated requery");
        return;
    L36:
        return;
    L9:
        if (ContactsUtils.isNetworkConnected(this.mContext) == false) goto L11;
        ArrayList<String> r0 = this.mPhoneNumberList;
        if (r0 == null) goto L28;
        if (r0.size() == 0) goto L28;
        this.mNeedRequeryFreeCall = false;
        HashMap r1 = new HashMap();
        Iterator<String> r2 = this.mPhoneNumberList.iterator();
    L21:
        if (r2.hasNext() == false) goto L25;
        String r3 = r2.next();
        if (r3 == null) goto L21;
        r1.put(T9Search.removeNonDigits(r3), Boolean.valueOf(this.mFreeCallNumberList.contains(r3)));
        goto L21
    L25:
        new FreeCallRequeryTask(this, null).execute(new HashMap[]{r1});
        return;
    L28:
        if (ContactsUtils.DEBUG == false) goto L38;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "No phone numbers is bind");
        return;
    L38:
        return;
    L11:
        if (ContactsUtils.DEBUG == false) goto L37;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "Network is not connected");
        return;
    }

    void updateLocationInfo(ContentValues r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (this.mLocationWorkerHandler != null) goto L8;
        initWorkerHandler();     // Catch: Throwable -> L11
    L8:
        monitor-exit(this);     // Catch: Throwable -> L11
        Message r0 = this.mLocationWorkerHandler.obtainMessage(1001);
        Bundle r1 = new Bundle();
        r1.putParcelable("entryValues", r4);
        r0.setData(r1);
        this.mLocationWorkerHandler.sendMessage(r0);
    }

    private void initWorkerHandler() {
        HandlerThread r0 = new HandlerThread("LocationWorkerHandler");
        this.mWorkerThread = r0;
        r0.setPriority(1);
        if (this.mWorkerThread.isAlive() == true) goto L5;
        this.mWorkerThread.start();
    L5:
        this.mLocationWorkerHandler = new LocationWorkerHandler(this.mContext, this.mWorkerThread.getLooper());
    }

    private void destroyWorkerHandler() {
        monitor-enter(this);
        HandlerThread r0 = this.mWorkerThread;     // Catch: Throwable -> L10
        if (r0 != null) goto L6;
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L6:
        if (r0.getLooper() == null) goto L8;
        this.mWorkerThread.getLooper().quitSafely();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private void starNumber(String r7) {
        this.mContext.startService(ContactSaveService.createSetPhoneStarredIntent(this.mContext, this.mContactData.getId(), new String[]{r7}, true));
        this.mFavoriteNumberList.add(r7);
    }
}
