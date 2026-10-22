package com.android.contacts.detail;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.provider.Telephony;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import bytedanceos.util.NameAvatarController;
import com.GlobalProxyLancet;
import com.android.contacts.AbstractFragment;
import com.android.contacts.CallLogSaveService;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.contacts.CootekManager;
import com.android.contacts.DSUtils;
import com.android.contacts.PhoneCallDetails;
import com.android.contacts.R;
import com.android.contacts.activities.ContactCalllogsActivity;
import com.android.contacts.activities.ContactSelectionActivity;
import com.android.contacts.activities.NumberMarkActivity;
import com.android.contacts.calllog.CallLogQueryHandler;
import com.android.contacts.calllog.ContactInfoHelper;
import com.android.contacts.calllog.PhoneNumberHelper;
import com.android.contacts.detail.item.action.PhoneActionView;
import com.android.contacts.detail.item.action.PhoneActionViewLayout;
import com.android.contacts.detail.item.button.ContactItemButtonCard;
import com.android.contacts.numberassistant.NumberInfosManager;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.AvatarImageHelper;
import com.android.contacts.util.BlackListQueryHandler;
import com.android.contacts.util.Constants;
import com.android.contacts.util.ContactPhotoUtils;
import com.android.contacts.util.ContactsIntentUtils;
import com.android.contacts.util.OAlertDialogUtils;
import com.android.contacts.widget.AvatarImageView;
import com.bytedance.common.utility.UIUtils;
import com.obric.matrix.platform.sdk.ones.producttype.ProductTypeUtils;
import com.obric.matrix.platform.sdk.ones.region.RegionUtil;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.text.OTextView;
import com.obric.tracker.CallScreenShowUtils;
import com.obric.tracker.event.CallScreenShowEvent;
import com.obric.ui.popover.Direct;
import com.obric.ui.popover.ItemType;
import com.obric.ui.popover.MenuItemData;
import com.obric.ui.popover.OUIPopoverHelper;
import com.obric.utils.views.commonitemview.ContactsCommonListItem;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import obric.app.tracker.Agent;

/* JADX INFO: loaded from: classes.dex */
public class ContactDetailStrangerFragment extends AbstractFragment implements View.OnClickListener, BlackListQueryHandler.BlackListChangeListener {
    private static final int ALL_NUMBER_IN_BLACK_LIST = 1;
    private static final int BLACK_LIST_DEFAULT_TAG = -1;
    private static final int DATA_TYPE_EMAIL = 1;
    private static final int DATA_TYPE_PHONE = 0;
    private static final String MARK_STATE_MARK = "mark";
    private static final String MARK_STATE_UNMARK = "unmark";
    private static final int NOT_ALL_NUMBER_IN_BLACK_LIST = 0;
    private static final int REQUEST_CODE_GET_NUMBER_MARK = 1009;
    private static final String TAG = "ContactDetailStrangerFragment";
    private boolean isMarkEnable;
    private FragmentActivity mActivity;
    private BlackListQueryHandler mBlackListHandler;
    private int mBlackListViewRefreshFlag;
    private boolean mBlacklistFlag;
    private ImageView mBlacklistPhoto;
    private Function5<Boolean, Boolean, Boolean, TextView, View, Unit> mBlockedBtnClick;
    private BlockedContentHelper mBlockedContentHelper;
    private LinearLayout mBottomButtonsLayout;
    private ContactItemButtonCard mBtnAddNewContact;
    private ContactItemButtonCard mBtnAddToContacts;
    private ContactItemButtonCard mBtnBlockedCall;
    private OTextView mBtnBlockedCallText;
    private ContactItemButtonCard mBtnCallLog;
    private ContactItemButtonCard mBtnJoinBlackList;
    private ContactDetailCallLogView mCallLogView;
    private Callback mCallback;
    private TextView mCompanyAndNote;
    private ContactsCommonListItem.ContactsCommonListItemClickListener mContactsItemClickListener;
    private CootekManager mCootekManager;
    private String mCountryIso;
    private String mData;
    private int mDataType;
    private boolean mExitIfNumberSaved;
    private String mFormatedNumber;
    private boolean mFreeCallAvailable;
    private final View.OnClickListener mFreeCallOnClickListener;
    private Handler mHander;
    private boolean mHideStrangerCallLog;
    private int mInterceptType;
    private boolean mIsAllCallLogEmpty;
    private String mLabel;
    private View.OnLongClickListener mLongClickListener;
    private OPopover mMenuPopover;
    private String mName;
    private TextView mNameText;
    private boolean mNeedMarkBtn;
    private boolean mNeedRefreshFreeCall;
    private BroadcastReceiver mNetworkConnStatusReceiver;
    private TextView mNumberIdentification;
    private NumberInfosManager mNumberInfosManager;
    private int mNumberMainMarkClassify;
    private PhoneActionViewLayout mPhoneActionLayout;
    private ImageView mPhotoView;
    private int mPhotoWidth;
    private int mPresentation;
    private PriorityBlockingQueue<PhotoItem> mPriorityBlockingQueuePhotos;
    private String mPublicName;
    private boolean mUseStrictPhoneNumberComparation;
    private View mView;
    private String markState;
    private CallLogQueryHandler.Listener queryAllCallLogListener;

    public interface Callback {
        PhoneCallDetails[] getPhoneCallDetails();

        boolean hasCallLog();

        void makeFreeCall(List<String> r1);

        void playBlacklistSound(boolean r1);

        void startVolteCall(String r1);

        void startVolteCall(List<String> r1);
    }

    private static class PhotoItem {
        static int BLACK_LIST_PRIORITY = 4;
        static int DEFAULT_PHOTO_PRIORITY = 5;
        static int NUMBER_MARK_PRIORITY = 3;
        static int PUBLIC_NUMBER_LOGO_PRIORITY = 2;
        static int VOICE_MAIL_PRIORITY = 1;
        private Bitmap mBitmap;
        private int mPriority;

        static {
        }

        static /* synthetic */ int access$100(PhotoItem r0) {
            return r0.mPriority;
        }

        static /* synthetic */ Bitmap access$200(PhotoItem r0) {
            return r0.mBitmap;
        }

        public PhotoItem(int r1, Bitmap r2) {
            this.mBitmap = r2;
            this.mPriority = r1;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L15:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L15;
            if (this.mPriority != ((PhotoItem) r5).mPriority) goto L14;
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            return this.mPriority;
        }

        public String toString() {
            return "{PhotoItem: mPriority=" + this.mPriority + ", mBitmap=" + this.mBitmap + "}";
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
    }

    public ContactDetailStrangerFragment() {
        this.mHander = new Handler();
        this.mExitIfNumberSaved = false;
        this.mBlacklistFlag = false;
        this.mHideStrangerCallLog = false;
        this.mBlackListViewRefreshFlag = -1;
        this.mNumberMainMarkClassify = 0;
        this.mNetworkConnStatusReceiver = new AnonymousClass1(this);
        this.mBlockedContentHelper = new BlockedContentHelper();
        this.isMarkEnable = true;
        this.markState = null;
        this.mMenuPopover = null;
        this.mPriorityBlockingQueuePhotos = new PriorityBlockingQueue(4, new AnonymousClass2(this));
        this.mPhotoWidth = 0;
        this.mIsAllCallLogEmpty = false;
        this.queryAllCallLogListener = new AnonymousClass9(this);
        this.mLongClickListener = new AnonymousClass10(this);
        this.mFreeCallOnClickListener = new AnonymousClass11(this);
        this.mContactsItemClickListener = new AnonymousClass12(this);
        this.mBlockedBtnClick = new AnonymousClass15(this);
    }

    static /* synthetic */ void access$000(ContactDetailStrangerFragment r0) {
        r0.requeryFreeCall();
    }

    static /* synthetic */ int access$1000(ContactDetailStrangerFragment r0) {
        return r0.mDataType;
    }

    static /* synthetic */ void access$1100(ContactDetailStrangerFragment r0) {
        r0.refreshAllCallLog();
    }

    static /* synthetic */ boolean access$1202(ContactDetailStrangerFragment r0, boolean r1) {
        r0.mIsAllCallLogEmpty = r1;
        return r1;
    }

    static /* synthetic */ String access$1300(ContactDetailStrangerFragment r0) {
        return r0.mData;
    }

    static /* synthetic */ Callback access$1400(ContactDetailStrangerFragment r0) {
        return r0.mCallback;
    }

    static /* synthetic */ void access$1500(ContactDetailStrangerFragment r0, String r1) {
        r0.copyToClipboard(r1);
    }

    static /* synthetic */ BlackListQueryHandler access$1600(ContactDetailStrangerFragment r0) {
        return r0.mBlackListHandler;
    }

    static /* synthetic */ int access$1700(ContactDetailStrangerFragment r0) {
        return r0.mNumberMainMarkClassify;
    }

    static /* synthetic */ int access$1702(ContactDetailStrangerFragment r0, int r1) {
        r0.mNumberMainMarkClassify = r1;
        return r1;
    }

    static /* synthetic */ TextView access$1800(ContactDetailStrangerFragment r0) {
        return r0.mCompanyAndNote;
    }

    static /* synthetic */ TextView access$1900(ContactDetailStrangerFragment r0) {
        return r0.mNumberIdentification;
    }

    static /* synthetic */ int access$2000(ContactDetailStrangerFragment r0) {
        return r0.getNumberIdentificationSourceRes();
    }

    static /* synthetic */ int access$2100(ContactDetailStrangerFragment r0) {
        return r0.getNumberIdentificationCertifiedRes();
    }

    static /* synthetic */ String access$2202(ContactDetailStrangerFragment r0, String r1) {
        r0.mPublicName = r1;
        return r1;
    }

    static /* synthetic */ String access$2300(ContactDetailStrangerFragment r0) {
        return r0.markState;
    }

    static /* synthetic */ String access$2302(ContactDetailStrangerFragment r0, String r1) {
        r0.markState = r1;
        return r1;
    }

    static /* synthetic */ int access$2400(ContactDetailStrangerFragment r0) {
        return r0.mPhotoWidth;
    }

    static /* synthetic */ void access$2500(ContactDetailStrangerFragment r0, PhotoItem r1) {
        r0.addPhotoItem(r1);
    }

    static /* synthetic */ void access$2600(ContactDetailStrangerFragment r0, int r1) {
        r0.removePhotoItem(r1);
    }

    static /* synthetic */ String access$2700(ContactDetailStrangerFragment r0) {
        return r0.mLabel;
    }

    static /* synthetic */ String access$2800(ContactDetailStrangerFragment r0) {
        return r0.mCountryIso;
    }

    static /* synthetic */ void access$2900(ContactDetailStrangerFragment r0, String r1, String r2, String r3) {
        r0.saveLabel(r1, r2, r3);
    }

    static /* synthetic */ void access$300(ContactDetailStrangerFragment r0) {
        r0.setShowContactCalllog();
    }

    static /* synthetic */ int access$3000(ContactDetailStrangerFragment r0) {
        return r0.mInterceptType;
    }

    static /* synthetic */ int access$3100(ContactDetailStrangerFragment r0) {
        return r0.mBlackListViewRefreshFlag;
    }

    static /* synthetic */ OTextView access$3200(ContactDetailStrangerFragment r0) {
        return r0.mBtnBlockedCallText;
    }

    static /* synthetic */ ContactItemButtonCard access$3300(ContactDetailStrangerFragment r0) {
        return r0.mBtnBlockedCall;
    }

    static /* synthetic */ Function5 access$3400(ContactDetailStrangerFragment r0) {
        return r0.mBlockedBtnClick;
    }

    static /* synthetic */ BlockedContentHelper access$3500(ContactDetailStrangerFragment r0) {
        return r0.mBlockedContentHelper;
    }

    static /* synthetic */ void access$3600(ContactDetailStrangerFragment r0) {
        r0.showBlackSheet();
    }

    static /* synthetic */ void access$3700(ContactDetailStrangerFragment r0, String r1) {
        r0.getStrangeNumberClassify(r1);
    }

    static /* synthetic */ OPopover access$3800(ContactDetailStrangerFragment r0) {
        return r0.mMenuPopover;
    }

    static /* synthetic */ void access$3900(ContactDetailStrangerFragment r0) {
        r0.doAddNewContactAction();
    }

    static /* synthetic */ void access$400(ContactDetailStrangerFragment r0) {
        r0.onClickCall();
    }

    static /* synthetic */ boolean access$4002(ContactDetailStrangerFragment r0, boolean r1) {
        r0.mExitIfNumberSaved = r1;
        return r1;
    }

    static /* synthetic */ void access$4100(ContactDetailStrangerFragment r0) {
        r0.doAddToContactAction();
    }

    static /* synthetic */ void access$4200(ContactDetailStrangerFragment r0) {
        r0.onClickBlock();
    }

    static /* synthetic */ boolean access$4302(ContactDetailStrangerFragment r0, boolean r1) {
        r0.mNeedRefreshFreeCall = r1;
        return r1;
    }

    static /* synthetic */ Handler access$4400(ContactDetailStrangerFragment r0) {
        return r0.mHander;
    }

    static /* synthetic */ void access$500(ContactDetailStrangerFragment r0) {
        r0.onClickVideo();
    }

    static /* synthetic */ void access$600(ContactDetailStrangerFragment r0) {
        r0.onClickMessage();
    }

    static /* synthetic */ FragmentActivity access$700(ContactDetailStrangerFragment r0) {
        return r0.mActivity;
    }

    static /* synthetic */ boolean access$800(ContactDetailStrangerFragment r0) {
        return r0.isNotStrangerAnymore();
    }

    static /* synthetic */ String access$900(ContactDetailStrangerFragment r0) {
        return r0.mFormatedNumber;
    }

    private synchronized void addPhotoItem(PhotoItem r5) {
        monitor-enter(this);
        if (r5 != null) goto L32;
    L30:
        monitor-exit(this);
        return;
    L32:
    L27:
        th = move-exception;
        throw th;
    L5:
        if (PhotoItem.access$200(r5) == null) goto L30;
        if (this.mPriorityBlockingQueuePhotos.contains(r5) == false) goto L10;
        this.mPriorityBlockingQueuePhotos.remove(new PhotoItem(PhotoItem.access$100(r5), null));     // Catch: Throwable -> L27
    L10:
        this.mPriorityBlockingQueuePhotos.add(r5);     // Catch: Throwable -> L27
        PhotoItem r6 = this.mPriorityBlockingQueuePhotos.peek();     // Catch: Throwable -> L27
        if (isAdded() == false) goto L25;
        ImageView r0 = this.mPhotoView;     // Catch: Throwable -> L27
        if (r0 == null) goto L25;
        if (r6 == null) goto L25;
        if ((r0 instanceof AvatarImageView) == false) goto L24;
        AvatarImageView r1 = (AvatarImageView) r0;     // Catch: Throwable -> L27
        if (PhotoItem.access$100(r6) != PhotoItem.DEFAULT_PHOTO_PRIORITY) goto L20;
    L22:
        boolean r2 = false;
    L23:
        r1.setStrokeEnabled(r2);     // Catch: Throwable -> L27
        goto L24
    L20:
        if (PhotoItem.access$100(r6) == PhotoItem.NUMBER_MARK_PRIORITY) goto L22;
        r2 = true;
    L24:
        this.mPhotoView.setImageBitmap(NameAvatarController.getCircleBitmap(PhotoItem.access$200(r6), false));     // Catch: Throwable -> L27
    L25:
        monitor-exit(this);
    }

    private synchronized void removePhotoItem(int r5) {
        monitor-enter(this);
        this.mPriorityBlockingQueuePhotos.remove(new PhotoItem(r5, null));     // Catch: Throwable -> L20
        PhotoItem r6 = this.mPriorityBlockingQueuePhotos.peek();     // Catch: Throwable -> L20
        if (isAdded() == false) goto L18;
        ImageView r0 = this.mPhotoView;     // Catch: Throwable -> L20
        if (r0 == null) goto L18;
        if (r6 == null) goto L18;
        if ((r0 instanceof AvatarImageView) == false) goto L17;
        AvatarImageView r1 = (AvatarImageView) r0;     // Catch: Throwable -> L20
        if (PhotoItem.access$100(r6) != PhotoItem.DEFAULT_PHOTO_PRIORITY) goto L13;
    L15:
        boolean r2 = false;
    L16:
        r1.setStrokeEnabled(r2);     // Catch: Throwable -> L20
        goto L17
    L13:
        if (PhotoItem.access$100(r6) == PhotoItem.NUMBER_MARK_PRIORITY) goto L15;
        r2 = true;
    L17:
        this.mPhotoView.setImageBitmap(NameAvatarController.getCircleBitmap(PhotoItem.access$200(r6), false));     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.android.contacts.AbstractFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.mNumberInfosManager = NumberInfosManager.getInstance();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity r2) {
        super.onAttach(r2);
        this.mUseStrictPhoneNumberComparation = r2.getResources().getBoolean(R.bool.config_use_strict_phone_number_comparation);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mActivity = getActivity();
        BlackListQueryHandler r5 = new BlackListQueryHandler(this.mActivity);
        this.mBlackListHandler = r5;
        r5.setCallback(this);
        View r6 = r2.inflate(R.layout.contact_detail_stranger_fragment, r3, false);
        this.mView = r6;
        ContactDetailCallLogView r7 = (ContactDetailCallLogView) r6.findViewById(R.id.detail_call_log_view);
        this.mCallLogView = r7;
        r7.setMoreItemClickListener(new AnonymousClass3(this));
        this.mNameText = (TextView) this.mView.findViewById(R.id.name);
        this.mCompanyAndNote = (TextView) this.mView.findViewById(R.id.company_and_note);
        TextView r8 = (TextView) this.mView.findViewById(R.id.number_identification);
        this.mNumberIdentification = r8;
        if (r8 == null) goto L5;
        r8.setVisibility(8);
    L5:
        ContactItemButtonCard r9 = (ContactItemButtonCard) this.mView.findViewById(R.id.btn_blocked_call);
        this.mBtnBlockedCall = r9;
        this.mBtnBlockedCallText = r9.getItemText();
        ContactItemButtonCard r10 = (ContactItemButtonCard) this.mView.findViewById(R.id.btn_join_blacklist);
        this.mBtnJoinBlackList = r10;
        r10.setOnContentClickListener(new ContactDetailStrangerFragment$$ExternalSyntheticLambda0(this));
        ContactItemButtonCard r11 = (ContactItemButtonCard) this.mView.findViewById(R.id.btn_add_new_contact);
        this.mBtnAddNewContact = r11;
        r11.setOnContentClickListener(new ContactDetailStrangerFragment$$ExternalSyntheticLambda1(this));
        ContactItemButtonCard r12 = (ContactItemButtonCard) this.mView.findViewById(R.id.btn_add_to_contacts);
        this.mBtnAddToContacts = r12;
        r12.setOnContentClickListener(new ContactDetailStrangerFragment$$ExternalSyntheticLambda2(this));
        ContactItemButtonCard r13 = (ContactItemButtonCard) this.mView.findViewById(R.id.btn_calllog);
        this.mBtnCallLog = r13;
        r13.setOnContentClickListener(new ContactDetailStrangerFragment$$ExternalSyntheticLambda3(this));
        this.mBtnBlockedCall.setCardPosition(0);
        this.mBtnAddNewContact.setCardPosition(1);
        this.mBtnAddToContacts.setCardPosition(3);
        this.mBtnCallLog.setCardPosition(3);
        this.mBottomButtonsLayout = (LinearLayout) this.mView.findViewById(R.id.first_line);
        this.mPhotoView = (ImageView) this.mView.findViewById(R.id.photo);
        this.mBlacklistPhoto = (ImageView) this.mView.findViewById(R.id.blacklist_photo);
        initPhoneAction(this.mView);
        this.mPhotoWidth = ContactsUtils.dipTopx(getActivity(), getResources().getDimensionPixelSize(R.dimen.detail_photo_width));
        addPhotoItem(new PhotoItem(PhotoItem.DEFAULT_PHOTO_PRIORITY, AvatarImageHelper.getAvatarBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.photo_default_in_detail), this.mPhotoWidth)));
        return this.mView;
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-contacts-detail-ContactDetailStrangerFragment, reason: not valid java name */
    /* synthetic */ void m168xa968130(View r1) {
        onClickBlock();
    }

    /* JADX INFO: renamed from: lambda$onCreateView$1$com-android-contacts-detail-ContactDetailStrangerFragment, reason: not valid java name */
    /* synthetic */ void m169x1b4c4df1(View r3) {
        if (ContactsUtils.isJustClicked() == true) goto L6;
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_NEW_CONTACT);
        doAddNewContactAction();
        this.mExitIfNumberSaved = true;
        return;
    }

    /* JADX INFO: renamed from: lambda$onCreateView$2$com-android-contacts-detail-ContactDetailStrangerFragment, reason: not valid java name */
    /* synthetic */ void m170x2c021ab2(View r1) {
        doAddToContactAction();
        this.mExitIfNumberSaved = true;
    }

    /* JADX INFO: renamed from: lambda$onCreateView$3$com-android-contacts-detail-ContactDetailStrangerFragment, reason: not valid java name */
    /* synthetic */ void m171x3cb7e773(View r1) {
        if (ContactsUtils.isJustClicked() == true) goto L6;
        setShowContactCalllog();
        return;
    }

    private void initPhoneAction(View r3) {
        PhoneActionViewLayout r4 = (PhoneActionViewLayout) r3.findViewById(R.id.phone_action_container);
        this.mPhoneActionLayout = r4;
        r4.getButtonActionCall().setOnClickListener(new AnonymousClass4(this));
        r4.getButtonActionVideo().setOnClickListener(new AnonymousClass5(this));
        r4.getButtonActionMessage().setOnClickListener(new AnonymousClass6(this));
        if (ContactsApplication.getInstance().getTelephonyUtil().isVoLteSupport() == false) goto L6;
        r4.getButtonActionVideo().setEnabled(false);
        return;
    }

    private void onClickMessage() {
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_SEND_MMS);
        this.mActivity.startActivity(ContactsIntentUtils.getSendMessageIntent(this.mData));
        AnimationUtil.switchActivityAnimation(this.mActivity, 1);
    }

    private void onClickCall() {
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_CALL_ICON);
        Intent r0 = DSUtils.getSelectSimDialogIntentIfNeeded(this.mActivity, null, this.mData, true, false);
        if (r0 == null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "onClickCall show select sim dialog");
        startActivity(r0);
        return;
    L6:
        Intent r1 = ContactsIntentUtils.newDialNumberIntent(this.mData);
        if (r1 == null) goto L9;
        this.mActivity.startActivity(r1);
        CallScreenShowUtils.INSTANCE.start(new CallScreenShowEvent());
        return;
    L9:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "onClick intents is null");
    }

    private void onClickVideo() {
        if (ContactsUtils.isJustClicked() == false) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Ignore just clicked VoLTE call");
        return;
    L7:
        if (ContactsApplication.getInstance().getTelephonyUtil().isVtCapable() == false) goto L13;
        ArrayList r0 = new ArrayList(1);
        r0.add(this.mFormatedNumber);
        if (ContactsUtils.DEBUG == false) goto L11;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "start VoLTE call");
    L11:
        this.mCallback.startVolteCall(r0);
        return;
    }

    public void updateVolteCallBtn() {
        PhoneActionView r0 = this.mPhoneActionLayout.getButtonActionVideo();
        if (ContactsApplication.getInstance().getTelephonyUtil().isVtCapable() == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        r0.setEnabled(r2);
        return;
    L5:
        if (TextUtils.isEmpty(this.mFormatedNumber) == true) goto L7;
        r2 = true;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        setData(this.mActivity.getIntent());
        requeryFreeCall();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.android.contacts.detail.ContactDetailStrangerFragment$7] */
    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mBlacklistFlag == false) goto L6;
        this.mBlackListHandler.initBlacklist(this.mData);
    L6:
        if (this.mExitIfNumberSaved == false) goto L9;
        new AnonymousClass7(this).start();
        this.mExitIfNumberSaved = false;
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    private boolean isNotStrangerAnymore() {
        String r0 = ContactsUtils.getCurrentCountryIso(getActivity());
        ContactInfoHelper r1 = new ContactInfoHelper(this.mActivity, r0);
        if (this.mDataType == 1) goto L5;
        String r5 = this.mFormatedNumber;
        if (TextUtils.isEmpty(r5) == false) goto L10;
        return false;
    L10:
        if (r1.lookupNumber(r5, r0) == null) goto L12;
        return true;
    L12:
        return false;
    L5:
        return r1.lookupEmail(this.mData);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mHideStrangerCallLog = this.mActivity.getIntent().getBooleanExtra(ContactsUtils.EXTRA_HIDE_STRANGER_CALL_LOG, false);
        IntentFilter r0 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(getActivity(), this.mNetworkConnStatusReceiver, r0);
        new Handler().postDelayed(new AnonymousClass8(this), 300);
        if (ContactsUtils.isFeatureUSEnabled() == false) goto L5;
    L7:
        this.mNeedRefreshFreeCall = this.mFreeCallAvailable;
        return;
    L5:
        if (ContactsUtils.isFeatureDomestic() == false) goto L7;
        this.mFreeCallAvailable = CootekManager.getInstance().hasRegisteredPhoneNumber();
        goto L7
    }

    private void refreshAllCallLog() {
        new CallLogQueryHandler(this.mActivity.getContentResolver(), this.queryAllCallLogListener).fetchContactCalls(getCallLogSelectionWithNum(), null);
    }

    private String getCallLogSelectionWithNum() {
        StringBuilder r0 = new StringBuilder("1 = 0");
        Uri r1 = this.mActivity.getIntent().getData();
        if (r1 == null) goto L5;
        r0.append(" OR lookup_uri = '" + r1.toString() + "'");
    L5:
        Intent r2 = this.mActivity.getIntent();
        if ("android.intent.action.INSERT_OR_EDIT".equals(r2.getAction()) == false) goto L8;
    L11:
        String r3 = r2.getStringExtra("phone");
    L13:
        if (TextUtils.isEmpty(r3) == true) goto L16;
        r0.append(" OR PHONE_NUMBERS_EQUAL(number,").append("'" + r3 + "',").append(this.mUseStrictPhoneNumberComparation ? 1 : 0).append(")");
    L16:
        return r0.toString();
    L8:
        if (ContactSelectionActivity.ACTION_BYTEDANCE_INSERT_OR_EDIT.equals(r2.getAction()) == true) goto L11;
        r3 = r2.getStringExtra(ContactsUtils.EXTRA_PHONE_NUMBERS);
        goto L13
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(this.mNetworkConnStatusReceiver);
    }

    private void setData(Intent r6) {
        this.mHideStrangerCallLog = r6.getBooleanExtra(ContactsUtils.EXTRA_HIDE_STRANGER_CALL_LOG, false);
        String r0 = r6.getAction();
        Bundle r2 = r6.getExtras();
        this.mPresentation = r6.getIntExtra(ContactsUtils.EXTRA_PHONE_NUMBERS_PRESENTATION, 1);
        this.mCountryIso = r6.getStringExtra(ContactsUtils.EXTRA_COUNTRY_ISO);
        this.mLabel = r6.getStringExtra(ContactsUtils.EXTRA_LABEL);
        this.mInterceptType = r6.getIntExtra(ContactsUtils.EXTRA_INTERCEPT_TYPE, 0);
        this.mCootekManager = CootekManager.getInstance();
        if ("android.intent.action.INSERT_OR_EDIT".equals(r0) == false) goto L5;
    L8:
        this.mNeedMarkBtn = false;
        if (r2 == null) goto L14;
        this.mName = r2.getString("name");
        String r7 = r2.getString("phone");
        if (TextUtils.isEmpty(r7) == false) goto L13;
        r7 = r2.getString("email");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "The necessary address is null.");
    L13:
        this.mData = r7;
    L14:
        this.mDataType = Telephony.Mms.isEmailAddress(this.mData) ? 1 : 0;
        bindData();
        return;
    L5:
        if (ContactSelectionActivity.ACTION_BYTEDANCE_INSERT_OR_EDIT.equals(r0) == true) goto L8;
        this.mBlacklistFlag = true;
        this.mNeedMarkBtn = true;
        this.mData = r6.getStringExtra(ContactsUtils.EXTRA_PHONE_NUMBERS);
        goto L14
    }

    private void bindData() {
        TextView r0 = this.mNumberIdentification;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
    L6:
        if (this.mDataType != 1) goto L11;
        this.mPhoneActionLayout.getButtonActionMessage().setEnabled(false);
        this.mPhoneActionLayout.getButtonActionCall().setEnabled(false);
        this.mPhoneActionLayout.getButtonActionVideo().setEnabled(false);
        TextView r1 = this.mNameText;
        String r4 = this.mName;
        if (r4 != null) goto L10;
        r4 = this.mData;
    L10:
        r1.setText(r4);
        updateBtnEnable(this.mBtnCallLog, false);
        updateButtonPosition(false);
    L21:
        bindCallLogSection(this.mCallback.getPhoneCallDetails());
        if (this.mInterceptType <= 0) goto L26;
        UIUtils.setViewVisibility(this.mBtnCallLog, 8);
        updateButtonPosition(false);
        UIUtils.setViewVisibility(this.mBtnAddToContacts, 8);
        UIUtils.setViewVisibility(this.mBtnAddNewContact, 8);
        UIUtils.setViewVisibility(this.mBtnBlockedCall, 0);
        this.mBtnBlockedCallText.setText(R.string.allow_calls);
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) this.mBtnAddToContacts.getLayoutParams();
        if (r2 == null) goto L26;
        r2.bottomMargin = (int) this.mActivity.getResources().getDimension(R.dimen.contact_detail_bottom_margin);
    L26:
        UIUtils.setViewVisibility(this.mBtnJoinBlackList, 8);
        if (ContactsApplication.getInstance().getTelephonyUtil().isVoLteSupport() == true) goto L29;
        return;
    L29:
        if (ContactsApplication.getInstance().getTelephonyUtil().isVtCapable() == true) goto L31;
        return;
    L31:
        if (TextUtils.isEmpty(this.mFormatedNumber) == true) goto L36;
        this.mPhoneActionLayout.getButtonActionVideo().setEnabled(true);
        return;
    L36:
        return;
    L11:
        this.markState = MARK_STATE_MARK;
        updateBtnEnable(this.mBtnCallLog, true);
        updateButtonPosition(true);
        if (PhoneNumberHelper.canPlaceCallsTo(this.mPresentation) == false) goto L20;
        String r3 = ContactsUtils.formatNumber(this.mData);
        this.mFormatedNumber = r3;
        TextView r5 = this.mNameText;
        String r6 = this.mName;
        if (r6 == null) goto L17;
        r3 = r6;
    L17:
        r5.setText(r3);
        getPublicNumberLogo(this.mData);
        getStrangeNumberClassify(this.mData);
        checkStrangeNumberVoiceMail(this.mData);
        if (ContactsUtils.isEmergencyNumber(this.mData) == false) goto L21;
        this.isMarkEnable = false;
        goto L21
    L20:
        CharSequence r7 = new PhoneNumberHelper(getResources()).getDisplayNumber(this.mData, null, this.mPresentation);
        this.mNameText.setText(r7);
        this.isMarkEnable = false;
        this.mPhoneActionLayout.getButtonActionCall().setEnabled(false);
        this.mPhoneActionLayout.getButtonActionMessage().setEnabled(false);
        this.mPhoneActionLayout.getButtonActionVideo().setEnabled(false);
        this.mBottomButtonsLayout.setVisibility(8);
        goto L21
    }

    private void updateButtonPosition(boolean r3) {
        if (r3 == false) goto L5;
        this.mBtnAddNewContact.setCardPosition(1);
        this.mBtnAddToContacts.setCardPosition(2);
        this.mBtnCallLog.setCardPosition(3);
        return;
    L5:
        this.mBtnAddNewContact.setCardPosition(1);
        this.mBtnAddToContacts.setCardPosition(3);
        this.mBtnCallLog.setCardPosition(3);
    }

    private void updateBtnEnable(View r1, boolean r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        r1.setEnabled(r2);
    }

    public void refreshCallLog() {
        bindCallLogSection(this.mCallback.getPhoneCallDetails());
    }

    private void bindCallLogSection(PhoneCallDetails[] r7) {
        if (this.mHideStrangerCallLog == false) goto L6;
        this.mCallLogView.setVisibility(8);
        this.mBtnCallLog.setVisibility(8);
        updateButtonPosition(false);
        return;
    L6:
        this.mCallLogView.setVisibility(0);
        this.mCallLogView.setData(r7, null, this.mInterceptType, this.mActivity);
        if (r7 != null) goto L9;
    L11:
        this.mBtnCallLog.setVisibility(0);
        updateButtonPosition(true);
        return;
    L9:
        if (r7.length <= 0) goto L11;
        this.mBtnCallLog.setVisibility(8);
        updateButtonPosition(false);
    }

    private void copyToClipboard(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return;
    L5:
        boolean r1 = true;
        if (this.mDataType != 1) goto L8;
        String r0 = "vnd.android.cursor.item/email_v2";
    L9:
        String[] r2 = {r0};
        FragmentActivity r3 = this.mActivity;
        if (DSUtils.isMultiSimEnabled() == true) goto L12;
    L14:
        r1 = false;
    L15:
        ContactsUtils.showCopyToClipboardDialog(r3, null, r2, r6, r1);
        return;
    L12:
        if (DSUtils.isCalling(getContext()) == true) goto L14;
    L8:
        r0 = "vnd.android.cursor.item/phone_v2";
        goto L9
    }

    private void showBlackSheet() {
        OAlertDialogUtils.showDefaultBlacklistConfirmationDialog(this.mActivity, new AnonymousClass13(this));
    }

    private void doAddNewContactAction() {
        Intent r1 = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
        r1.setPackage("com.android.contacts");
        r1.setFlags(3);
        addIntentExtra(r1);
        addPublicLogo(r1);
        this.mActivity.startActivity(r1);
    }

    private void doAddToContactAction() {
        Intent r0 = new Intent(this.mActivity, ContactSelectionActivity.class);
        r0.setAction("android.intent.action.INSERT_OR_EDIT");
        r0.setPackage("com.android.contacts");
        r0.setType("vnd.android.cursor.item/contact");
        addIntentExtra(r0);
        this.mActivity.startActivity(r0);
        AnimationUtil.switchActivityAnimation(this.mActivity, 1);
    }

    private void setShowContactCalllog() {
        Intent r0 = new Intent(ContactCalllogsActivity.ACTION_VIEW);
        Bundle r1 = new Bundle();
        r1.putString(ContactCalllogsActivity.SELECTION_KEY, "PHONE_NUMBERS_EQUAL(number,'" + this.mData + "')");
        if (this.mCallback == null) goto L5;
        r1.putBoolean(ContactCalllogsActivity.EXTRA_HAS_CALL_LOG, !this.mIsAllCallLogEmpty);
    L5:
        r0.putExtras(r1);
        getActivity().startActivity(r0);
        AnimationUtil.switchActivityAnimation(getActivity(), 1);
    }

    private void addIntentExtra(Intent r3) {
        String r0 = this.mName;
        if (r0 == null) goto L6;
        r3.putExtra("name", r0);
    L9:
        if (this.mDataType != 1) goto L11;
        r3.putExtra("email", this.mData);
        return;
    L11:
        String r1 = this.mFormatedNumber;
        if (r1 != null) goto L14;
        r1 = this.mData;
    L14:
        r3.putExtra("phone", r1);
        return;
    L6:
        if (TextUtils.isEmpty(this.mPublicName) == true) goto L9;
        r3.putExtra("name", this.mPublicName);
        goto L9
    }

    private void addPublicLogo(Intent r4) {
        PhotoItem r0 = this.mPriorityBlockingQueuePhotos.peek();
        if (r0 != null) goto L5;
        return;
    L5:
        if (PhotoItem.access$100(r0) != PhotoItem.PUBLIC_NUMBER_LOGO_PRIORITY) goto L11;
        Uri r3 = ContactPhotoUtils.generateTempImageUriForBitmap(this.mActivity, PhotoItem.access$200(r0));
        if (r3 == null) goto L12;
        r4.putExtra(ContactsUtils.EXTRA_PUBLIC_LOGO, r3);
        return;
    L12:
        return;
    }

    public void setCallback(Callback r1) {
        this.mCallback = r1;
    }

    private void checkStrangeNumberVoiceMail(String r4) {
        if (new PhoneNumberHelper(getResources()).isVoicemailNumber(r4) == false) goto L5;
        addPhotoItem(new PhotoItem(PhotoItem.VOICE_MAIL_PRIORITY, AvatarImageHelper.getAvatarBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.voicemail), this.mPhotoWidth)));
        return;
    L5:
        removePhotoItem(PhotoItem.VOICE_MAIL_PRIORITY);
    }

    private int getNumberIdentificationSourceRes() {
        if (shouldUseTeddyNumberIdentification() == false) goto L5;
        return R.string.number_identification_teddy_source;
    L5:
        return R.string.number_identification_source;
    }

    private int getNumberIdentificationCertifiedRes() {
        if (shouldUseTeddyNumberIdentification() == false) goto L5;
        return R.string.number_identification_teddy_certified;
    L5:
        return R.string.number_identification_certified;
    }

    private boolean shouldUseTeddyNumberIdentification() {
        if (RegionUtil.INSTANCE.isCN() == true) goto L5;
    L9:
        return false;
    L5:
        if (ProductTypeUtils.INSTANCE.isNerida() == false) goto L7;
    L8:
        return true;
    L7:
        if (ProductTypeUtils.INSTANCE.isPike() == false) goto L9;
        goto L8
    }

    private void getStrangeNumberClassify(final String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        NumberInfosManager.getInstance().getBaseAndMarkInfosAsync(r3, new AnonymousClass14(this, r3).toDestroyObservable(getDestroyObservable()));
    }

    private void saveLabel(String r3, String r4, String r5) {
        FragmentActivity r2 = this.mActivity;
        if (r2 == null) goto L6;
        ContentValues r0 = new ContentValues();
        r0.put("numberlabel", r5);
        Intent r6 = CallLogSaveService.createUpdateCallLogIntent(r2, r0);
        r6.putExtra("number", r3);
        r6.putExtra("countryiso", r4);
        r2.startService(r6);
        return;
    }

    public void getPublicNumberLogo(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        NumberInfosManager.getInstance().getPublicNumberLogoAsync(r3, new AnonymousClass16(this).toDestroyObservable(getDestroyObservable()));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r2, int r3, Intent r4) {
        if (r3 == (-1)) goto L5;
        return;
    L5:
        if (r2 != 1009) goto L17;
        if (r4 == null) goto L20;
        int r5 = r4.getIntExtra("position", -1);
        NumberInfosManager.NumberInfosListener r6 = new AnonymousClass17(this).toDestroyObservable(getDestroyObservable());
        if (NumberInfosManager.Classify.isValidIndex(r5) == false) goto L11;
        this.mNumberInfosManager.setMarkInfoAsync(this.mData, r5, r6);
        return;
    L11:
        String r7 = r4.getStringExtra("flag");
        if (TextUtils.isEmpty(r7) == true) goto L14;
        this.mNumberInfosManager.setCustomMarkInfoAsync(this.mData, r7, r6);
        return;
    L14:
        this.mNumberInfosManager.clearMarkInfoAsync(this.mData, new AnonymousClass18(this).toDestroyObservable(getDestroyObservable()));
        return;
    L20:
        return;
    }

    public void doMarkAction() {
        if (this.mNumberMainMarkClassify != 536870912) goto L7;
        Toast.makeText(this.mActivity, getString(R.string.number_mark_zte_blacklist_not_supported), 0).show();
        return;
    L7:
        if (isAdded() == false) goto L10;
        startActivityForResult(new Intent(this.mActivity, NumberMarkActivity.class), 1009);
        return;
    }

    public void doUnmarkAction() {
        if (this.mNumberMainMarkClassify != 536870912) goto L7;
        Toast.makeText(this.mActivity, getString(R.string.number_mark_zte_blacklist_not_supported), 0).show();
        return;
    L7:
        if (isAdded() == false) goto L10;
        Intent r0 = new Intent(this.mActivity, NumberMarkActivity.class);
        r0.putExtra(NumberMarkActivity.EXTRA_PARAM_MARKED, true);
        startActivityForResult(r0, 1009);
        return;
    }

    public void onClickMenu(View r4) {
        OPopover r0 = OUIPopoverHelper.genPopover(this.mActivity, getMenuList(), false);
        this.mMenuPopover = r0;
        OUIPopoverHelper.showPopupAtAnchorView(this.mActivity, r0, Direct.TOP_RIGHT, r4, null);
    }

    private List<MenuItemData> getMenuList() {
        ArrayList r1 = new ArrayList();
        if (this.isMarkEnable == false) goto L6;
        r1.add(new MenuItemData(ItemType.TEXT, Integer.valueOf(R.drawable.btn_mark), null, null, getResources().getString(R.string.common_tag), null, null, null, null, new AnonymousClass19(this)));
    L6:
        if (this.mInterceptType <= 0) goto L9;
        r1.add(new MenuItemData(ItemType.TEXT, Integer.valueOf(R.drawable.menu_icon_create_contacts), null, null, getResources().getString(R.string.menu_create_contacts), null, null, null, null, new AnonymousClass20(this)));
        r1.add(new MenuItemData(ItemType.TEXT, Integer.valueOf(R.drawable.icon_user), null, null, getResources().getString(R.string.recentCalls_addToContact), null, null, null, null, new AnonymousClass21(this)));
    L9:
        if (isBlockBtnEnable() == true) goto L11;
    L15:
        return r1;
    L11:
        if (isInBlackList() == false) goto L13;
        int r2 = R.string.common_remove_from_blocklist;
    L14:
        String r9 = getResources().getString(r2);
        r1.add(new MenuItemData(ItemType.TEXT, Integer.valueOf(R.drawable.menu_icon_blacked), null, null, r9, null, null, null, null, new AnonymousClass22(this)));
        goto L15
    L13:
        r2 = R.string.common_add_to_blacklist;
        goto L14
    }

    private boolean isBlockBtnEnable() {
        if (this.mDataType != 1) goto L6;
    L8:
        boolean r0 = false;
    L10:
        if (this.mInterceptType <= 0) goto L13;
        return false;
    L13:
        return r0;
    L6:
        if (PhoneNumberHelper.canPlaceCallsTo(this.mPresentation) == false) goto L8;
        r0 = this.mBlacklistFlag;
        goto L10
    }

    private void onClickBlock() {
        int r0 = this.mBlackListViewRefreshFlag;
        if (r0 != 1) goto L5;
        this.mBlackListHandler.doRemoveBlacklistAction(this.mData);
        this.mBlockedContentHelper.toastRemoveFromBlackList(getActivity());
        return;
    L5:
        if (r0 != 0) goto L9;
        showBlackSheet();
        return;
    }

    private boolean isInBlackList() {
        if (this.mBlackListViewRefreshFlag == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.android.contacts.util.BlackListQueryHandler.BlackListChangeListener
    public void updateUIForBlacklist(boolean r11, boolean r12) {
        if (isAdded() == true) goto L5;
        return;
    L5:
        AnimationUtil.setVisibilityWithAnimation(this.mBlacklistPhoto, r11, r12);
        ImageView r13 = this.mPhotoView;
        if (r13 == null) goto L11;
        if (r11 == false) goto L9;
        int r0 = 8;
    L10:
        r13.setVisibility(r0);
        goto L11
    L9:
        r0 = 0;
    L11:
        this.mBlockedContentHelper.tryUpdateBlockedCallBtn(this.mInterceptType, this.mNumberMainMarkClassify, r11, this.mData, this.mBtnBlockedCallText, this.mBtnBlockedCall, getActivity().getContentResolver(), this.mBlockedBtnClick);
        if (r11 == false) goto L14;
        addPhotoItem(new PhotoItem(PhotoItem.BLACK_LIST_PRIORITY, AvatarImageHelper.getAvatarBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.photo_blacklist_in_detail), this.mPhotoWidth)));
    L15:
        this.mBlackListViewRefreshFlag = r11 ? 1 : 0;
        return;
    L14:
        removePhotoItem(PhotoItem.BLACK_LIST_PRIORITY);
        goto L15
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.android.contacts.detail.ContactDetailStrangerFragment$23] */
    private void requeryFreeCall() {
        final String r0 = this.mFormatedNumber;
        new AnonymousClass23(this, r0).start();
    }
}
