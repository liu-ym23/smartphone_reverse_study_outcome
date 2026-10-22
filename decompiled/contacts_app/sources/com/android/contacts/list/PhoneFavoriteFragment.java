package com.android.contacts.list;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import com.GlobalProxyLancet;
import com.android.contacts.AbstractFragment;
import com.android.contacts.ContactFragmentsCallback;
import com.android.contacts.ContactPhotoManager;
import com.android.contacts.ContactSaveService;
import com.android.contacts.ContactsUtils;
import com.android.contacts.PreferencesCallback;
import com.android.contacts.R;
import com.android.contacts.activities.ContactSelectionActivity;
import com.android.contacts.activities.DialtactsActivity;
import com.android.contacts.bytedanceosquickcontact.QuickContactClickedView;
import com.android.contacts.group.GroupSelectionActivity;
import com.android.contacts.util.BytedanceContactContract;
import com.android.contacts.util.Constants;
import com.android.contacts.util.OSheetUtils;
import com.android.contacts.widget.ProgressDialog;
import com.android.contacts.widget.SelectAllState;
import com.android.contacts.widget.dslv.DragSortListView;
import com.android.contacts.widget.dslv.ForceTouchAdapterController;
import com.android.vcard.VCardConfig;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.obric.anim.ListAnimator;
import com.obric.oui.button.OButton;
import com.obric.oui.selection.OActionSheet;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.sheet.OInsetSheetTitleBar;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.titlebar.OCTitleBar;
import com.obricOld.contacts.menus.LongMenuHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import obric.app.tracker.Agent;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(since = "废弃不再使用，请关注 NewPhoneFavoriteFragment")
public class PhoneFavoriteFragment extends AbstractFragment implements View.OnTouchListener, View.OnClickListener, AbsListView.OnScrollListener, DialtactsActivity.ViewPagerVisibilityListener, DialtactsActivity.PageEnableListener, AdapterView.OnItemClickListener, DialtactsActivity.ReleaseResourceListener, DialtactsActivity.onBackPressListener {
    private static final int DELAY_TIME_TO_QUERY = 500;
    private static final int MSG_FAVORITE_EXIT_EDIT_MODE = 1;
    private static final int MSG_REFRESH_LISTVIEW = 4;
    private static final int MSG_RELOAD_FAVORITE_AFTER_DB_CHANGE = 2;
    private static final int PRELOAD_VIEW_COUNT = 10;
    public static final int REQUEST_CODE_PICK_UNFAVORITE = 30;
    private static final int SHOW_PROGRESS_DELAY = 1000;
    public static final String TAG = "PhoneFavoriteFragment";
    private static final LongMenuHelper.MenuType[] sLongMenuItems = null;
    private String TAG_LIST;
    private boolean dismissDialog;
    private Activity mActivity;
    private FavoriteAdapter mAdapter;
    private BottomDeleteLayoutListener mBottomDeleteLayoutListener;
    private OButton mBtnAdd;
    private OButton mBtnDone;
    private OButton mBtnEdit;
    private OButton mBtnSelectedAllView;
    private ChangeThread mChangeThread;
    ContactsContent mContactsContent;
    private volatile UIMode mCurMode;
    private OActionSheet mDeleteSheet;
    private DialtactsActivity mDialtactsActivity;
    private boolean mDraging;
    private Vector<FavoriteContact> mFavoriteContacts;
    private View mFavoriteFragment;
    private HashMap<Long, ArrayList<String>> mFavoriteNumberMap;
    private ForceTouchAdapterController mForceTouchController;
    private ContactFragmentsCallback mFragmentsCallback;
    private Handler mHandler;
    private boolean mIsAnimationing;
    private boolean mIsClickedBtnAdd;
    private HorizontalScrollListView.ItemLongClickedListener mItemLongClickedListener;
    private final ListAnimator mListAnimator;
    private Stack mListItemViewStack;
    private DragSortListView mListView;
    private boolean mNeedReloadData;
    private OCTitleBar mOTitleBar;
    private DragSortListView.DragListener mOnDrag;
    private DragSortListView.DragStartListener mOnDragStart;
    private DragSortListView.DropListener mOnDrop;
    private DragSortListView.MoveListener mOnMove;
    private DragSortListView.RemoveListener mOnRemove;
    private ContactPhotoManager mPhotoManager;
    private ExecutorService mPool;
    private PreferencesCallback mPrefersCallback;
    private ProgressDialog mProgressDialog;
    private boolean mProviderIsNormal;
    private QuickContactClickedView mQuickContactClickedView;
    private float mQuickbartableLeft;
    private SelectAllState mSelectedAll;
    private boolean mVisible;

    /* JADX INFO: renamed from: com.android.contacts.list.PhoneFavoriteFragment$18, reason: invalid class name */
    static /* synthetic */ class AnonymousClass18 {
        static final /* synthetic */ int[] $SwitchMap$com$android$contacts$list$PhoneFavoriteFragment$UIMode = null;

        static {
            int[] r0 = new int[UIMode.values().length];
            $SwitchMap$com$android$contacts$list$PhoneFavoriteFragment$UIMode = r0;
            r0[UIMode.MODE_NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$android$contacts$list$PhoneFavoriteFragment$UIMode[UIMode.MODE_TO_NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$android$contacts$list$PhoneFavoriteFragment$UIMode[UIMode.MODE_EDIT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$android$contacts$list$PhoneFavoriteFragment$UIMode[UIMode.MODE_TO_EDIT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    private class ChangeThread extends Thread {
        final /* synthetic */ PhoneFavoriteFragment this$0;

        private ChangeThread(PhoneFavoriteFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ChangeThread(PhoneFavoriteFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            List<FavoriteContact> r3 = PhoneFavoriteFragment.access$400(this.this$0).getList();     // Catch: Throwable -> L12
            String[] r4 = new String[r3.size()];     // Catch: Throwable -> L12
            int r5 = 0;
        L5:
            if (r5 >= r3.size()) goto L7;
            r4[r5] = r3.get(r5).number;     // Catch: Throwable -> L12
            r5 = r5 + 1;     // Catch: Throwable -> L12
            goto L5
        L7:
            ContactSaveService.setPhoneStarted(this.this$0.getActivity(), r4, ContactSaveService.FavoriteAction.RESET);     // Catch: Throwable -> L12
            if (PhoneFavoriteFragment.access$1600(this.this$0).isChanging() == true) goto L20;
            PhoneFavoriteFragment.access$1700(this.this$0).sendEmptyMessageDelayed(1, 0);
            return;
        L20:
            return;
        L12:
            th = move-exception;
            if (PhoneFavoriteFragment.access$1600(this.this$0).isChanging() == true) goto L16;
            PhoneFavoriteFragment.access$1700(this.this$0).sendEmptyMessageDelayed(1, 0);
        L16:
            throw th;
        }
    }

    private class ContactsContent extends ContentObserver {
        final /* synthetic */ PhoneFavoriteFragment this$0;

        public ContactsContent(PhoneFavoriteFragment r1, Handler r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r2) {
            super.onChange(r2);
            if (PhoneFavoriteFragment.access$400(this.this$0) == null) goto L6;
            PhoneFavoriteFragment.access$400(this.this$0).setFavoriteCancleState(false);
        L6:
            if (this.this$0.getActivity() != null) goto L9;
            return;
        L9:
            if (PhoneFavoriteFragment.access$2800(this.this$0) == true) goto L15;
            if (ContactsUtils.DEBUG == false) goto L22;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(PhoneFavoriteFragment.TAG, "The contact database state hasn't ready.");
            return;
        L22:
            return;
        L15:
            if (PhoneFavoriteFragment.access$1600(this.this$0).isNormal() == false) goto L17;
            PhoneFavoriteFragment.access$1700(this.this$0).removeMessages(2);
            PhoneFavoriteFragment.access$1700(this.this$0).sendEmptyMessage(2);
            return;
        L17:
            if (ContactsUtils.DEBUG == false) goto L23;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(PhoneFavoriteFragment.TAG, "Database has change but status is edit, so return it");
            return;
        }
    }

    private static class FavoriteQuery {
        public static final int FAVORITE_CONTACT_ID = 10;
        public static final int FAVORITE_CUSTOM_LABEL_RES = 3;
        public static final int FAVORITE_DATA1 = 1;
        public static final int FAVORITE_DATA4 = 4;
        public static final int FAVORITE_DATA_ID = 6;
        public static final int FAVORITE_DISPLAY_NAME = 9;
        public static final int FAVORITE_INDEX = 5;
        public static final int FAVORITE_LOOKUP_KEY = 8;
        public static final int FAVORITE_PHONE_LABEL = 2;
        public static final int FAVORITE_PHOTO_ID = 7;
        public static final int FAVORITE_RAW_CONTACT_ID = 0;
        public static final String SELECTION = "data15 = 1 AND mimetype='vnd.android.cursor.item/phone_v2'";
        private static final String[] sFavoriteProjection = null;

        private FavoriteQuery() {
        }

        static {
            sFavoriteProjection = new String[]{GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, "data1", DBHelper.COL_DATA2, DBHelper.COL_DATA3, "data4", "data14", "_id", "photo_id", "lookup", "display_name", "contact_id"};
        }

        public static String[] getFavoriteProjection(int r2) {
            if (r2 != 2) goto L5;
            sFavoriteProjection[9] = "display_name_alt";
        L7:
            return sFavoriteProjection;
        L5:
            sFavoriteProjection[9] = "display_name";
            goto L7
        }
    }

    public interface Listener {
        void onContactSelected(Uri r1, Rect r2);
    }

    private class RemoveTask extends AsyncTask<HashMap<Long, FavoriteContact>, Void, Void> {
        final /* synthetic */ PhoneFavoriteFragment this$0;

        private RemoveTask(PhoneFavoriteFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ RemoveTask(PhoneFavoriteFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(HashMap<Long, FavoriteContact>[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
            onPostExecute2(r1);
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            PhoneFavoriteFragment.access$1200(this.this$0);
            PhoneFavoriteFragment.access$2500(this.this$0);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(HashMap<Long, FavoriteContact>... r6) {
            int r0 = 0;
            HashMap<Long, FavoriteContact> r7 = r6[0];
            int r1 = r7.size();
            if (r1 <= 0) goto L12;
            String[] r2 = new String[r1];
            Iterator<FavoriteContact> r3 = r7.values().iterator();
        L6:
            if (r3.hasNext() == false) goto L8;
            r2[r0] = r3.next().number;
            r0 = r0 + 1;
            goto L6
        L8:
            r7.clear();
            ContactSaveService.setPhoneStarted(this.this$0.getActivity(), r2, ContactSaveService.FavoriteAction.REMOVE);
            return null;
        L12:
            return null;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Void r2) {
            PhoneFavoriteFragment.access$1302(this.this$0, true);
            PhoneFavoriteFragment.access$2300(this.this$0).liftVeil();
            PhoneFavoriteFragment.access$2600(this.this$0).callOnClick();
            if (PhoneFavoriteFragment.access$700(this.this$0) != null) goto L5;
            return;
        L5:
            if ((PhoneFavoriteFragment.access$700(this.this$0) instanceof DialtactsActivity) == false) goto L9;
            ((DialtactsActivity) PhoneFavoriteFragment.access$700(this.this$0)).notifyDBDataChanged();
            return;
        }
    }

    private static final enum UIMode extends Enum<UIMode> {
        private static final /* synthetic */ UIMode[] $VALUES = null;
        public static final UIMode MODE_EDIT = null;
        public static final UIMode MODE_NORMAL = null;
        public static final UIMode MODE_TO_EDIT = null;
        public static final UIMode MODE_TO_NORMAL = null;

        private static /* synthetic */ UIMode[] $values() {
            return new UIMode[]{MODE_NORMAL, MODE_EDIT, MODE_TO_NORMAL, MODE_TO_EDIT};
        }

        private UIMode(String r1, int r2) {
            super(r1, r2);
        }

        public static UIMode valueOf(String r1) {
            return (UIMode) Enum.valueOf(UIMode.class, r1);
        }

        public static UIMode[] values() {
            return (UIMode[]) $VALUES.clone();
        }

        static {
            MODE_NORMAL = new UIMode("MODE_NORMAL", 0);
            MODE_EDIT = new UIMode("MODE_EDIT", 1);
            MODE_TO_NORMAL = new UIMode("MODE_TO_NORMAL", 2);
            MODE_TO_EDIT = new UIMode("MODE_TO_EDIT", 3);
            $VALUES = $values();
        }

        public boolean isEdit() {
            if (this != MODE_EDIT) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isNormal() {
            if (this != MODE_NORMAL) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isToNormal() {
            if (this != MODE_TO_NORMAL) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isToEdit() {
            if (this != MODE_TO_EDIT) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isChanging() {
            if (this != MODE_TO_EDIT) goto L5;
        L8:
            return true;
        L5:
            if (this == MODE_TO_NORMAL) goto L8;
            return false;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r1, int r2, int r3, int r4) {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r1, MotionEvent r2) {
        return true;
    }

    public void setListener(Listener r1) {
    }

    public PhoneFavoriteFragment() {
        this.mFavoriteContacts = new Vector();
        this.mAdapter = null;
        this.mQuickbartableLeft = 0.0f;
        this.mBtnEdit = null;
        this.mBtnAdd = null;
        this.mBtnSelectedAllView = null;
        this.mBtnDone = null;
        this.mSelectedAll = null;
        this.TAG_LIST = "TAG_LIST";
        this.mCurMode = UIMode.MODE_NORMAL;
        this.mDraging = false;
        this.mIsAnimationing = false;
        this.mIsClickedBtnAdd = false;
        this.mNeedReloadData = false;
        this.mContactsContent = null;
        this.mListAnimator = new ListAnimator(new int[]{R.id.photo_frame, R.id.name_frame}, new int[]{R.id.drag_handle, R.id.arrow}, new int[]{R.id.checkBoxFrame});
        this.mHandler = new AnonymousClass1(this);
        this.mItemLongClickedListener = new AnonymousClass3(this);
        this.mOnDrag = new AnonymousClass4(this);
        this.mOnDrop = new AnonymousClass5(this);
        this.mOnDragStart = new AnonymousClass6(this);
        this.mOnMove = new AnonymousClass7(this);
        this.mOnRemove = new AnonymousClass8(this);
        this.mPool = Executors.newSingleThreadExecutor();
        this.mFavoriteNumberMap = new HashMap();
        this.mListItemViewStack = new Stack();
        this.mVisible = false;
        this.mProviderIsNormal = true;
    }

    static /* synthetic */ void access$000(PhoneFavoriteFragment r0) {
        r0.triggerLoad();
    }

    static /* synthetic */ void access$100(PhoneFavoriteFragment r0) {
        r0.dismissProgressDialog();
    }

    static /* synthetic */ LongMenuHelper access$1000(PhoneFavoriteFragment r0) {
        return r0.mLongMenuHelper;
    }

    static /* synthetic */ boolean access$1102(PhoneFavoriteFragment r0, boolean r1) {
        r0.mDraging = r1;
        return r1;
    }

    static /* synthetic */ void access$1200(PhoneFavoriteFragment r0) {
        r0.updateButtonsState();
    }

    static /* synthetic */ boolean access$1302(PhoneFavoriteFragment r0, boolean r1) {
        r0.mNeedReloadData = r1;
        return r1;
    }

    static /* synthetic */ DragSortListView access$1400(PhoneFavoriteFragment r0) {
        return r0.mListView;
    }

    static /* synthetic */ void access$1500(PhoneFavoriteFragment r0) {
        r0.updateSelectedStatus();
    }

    static /* synthetic */ UIMode access$1600(PhoneFavoriteFragment r0) {
        return r0.mCurMode;
    }

    static /* synthetic */ Handler access$1700(PhoneFavoriteFragment r0) {
        return r0.mHandler;
    }

    static /* synthetic */ Vector access$1802(PhoneFavoriteFragment r0, Vector r1) {
        r0.mFavoriteContacts = r1;
        return r1;
    }

    static /* synthetic */ Vector access$1900(PhoneFavoriteFragment r0) {
        return r0.getAllPhoneStared();
    }

    static /* synthetic */ void access$200(PhoneFavoriteFragment r0) {
        r0.refreshListView();
    }

    static /* synthetic */ Stack access$2000(PhoneFavoriteFragment r0) {
        return r0.mListItemViewStack;
    }

    static /* synthetic */ void access$2100(PhoneFavoriteFragment r0) {
        r0.doRemoveAction();
    }

    static /* synthetic */ OActionSheet access$2200(PhoneFavoriteFragment r0) {
        return r0.mDeleteSheet;
    }

    static /* synthetic */ ContactFragmentsCallback access$2300(PhoneFavoriteFragment r0) {
        return r0.mFragmentsCallback;
    }

    static /* synthetic */ void access$2500(PhoneFavoriteFragment r0) {
        r0.showProgressDialog();
    }

    static /* synthetic */ OButton access$2600(PhoneFavoriteFragment r0) {
        return r0.mBtnDone;
    }

    static /* synthetic */ boolean access$2800(PhoneFavoriteFragment r0) {
        return r0.mProviderIsNormal;
    }

    static /* synthetic */ boolean access$2900(PhoneFavoriteFragment r0) {
        return r0.dismissDialog;
    }

    static /* synthetic */ SelectAllState access$300(PhoneFavoriteFragment r0) {
        return r0.mSelectedAll;
    }

    static /* synthetic */ ProgressDialog access$3000(PhoneFavoriteFragment r0) {
        return r0.mProgressDialog;
    }

    static /* synthetic */ FavoriteAdapter access$400(PhoneFavoriteFragment r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ BottomDeleteLayoutListener access$500(PhoneFavoriteFragment r0) {
        return r0.mBottomDeleteLayoutListener;
    }

    static /* synthetic */ OCTitleBar access$600(PhoneFavoriteFragment r0) {
        return r0.mOTitleBar;
    }

    static /* synthetic */ Activity access$700(PhoneFavoriteFragment r0) {
        return r0.mActivity;
    }

    static /* synthetic */ LongMenuHelper.MenuType[] access$800() {
        return sLongMenuItems;
    }

    static /* synthetic */ LongMenuHelper access$900(PhoneFavoriteFragment r0) {
        return r0.mLongMenuHelper;
    }

    static {
        sLongMenuItems = new LongMenuHelper.MenuType[]{LongMenuHelper.MenuType.MENU_PHONE, LongMenuHelper.MenuType.MENU_PHONE1, LongMenuHelper.MenuType.MENU_PHONE2, LongMenuHelper.MenuType.MENU_MESSAGE, LongMenuHelper.MenuType.MENU_STAR, LongMenuHelper.MenuType.MENU_WECHAT};
    }

    public void setFragmentsCallback(ContactFragmentsCallback r1) {
        this.mFragmentsCallback = r1;
    }

    private void refreshListView() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        FavoriteAdapter r0 = this.mAdapter;
        if (r0 != null) goto L8;
        FavoriteAdapter r1 = new FavoriteAdapter(getActivity(), this.mFavoriteContacts, this.mPhotoManager);
        this.mAdapter = r1;
        this.mListView.setAdapter(r1);
        this.mForceTouchController.setAdapter(this.mAdapter);
        FavoriteAdapter r2 = this.mAdapter;
        r2.mHSListView = this.mListView;
    L10:
        if (this.mCurMode.isNormal() == true) goto L12;
    L14:
        setEmptyView();
        dismissLongMenu();
        updateButtonsState();
        return;
    L12:
        if (this.mVisible == false) goto L14;
        ContactDetailCacheManager.getInstance().refreshCache(this.mListView);
        goto L14
    L8:
        r0.setList(this.mFavoriteContacts);
        goto L10
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity r1) {
        super.onAttach(r1);
        this.mActivity = r1;
    }

    @Override // com.android.contacts.AbstractFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.mPhotoManager = ContactPhotoManager.getInstance(getActivity());
        setupLongMenu();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = inflateAndSetupView(r2, r3, r4, R.layout.favorite_fragment);
        preloadListItemView(getActivity());
        return r5;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        setObserverToWork(true);
    }

    protected View inflateAndSetupView(LayoutInflater r2, ViewGroup r3, Bundle r4, int r5) {
        View r6 = r2.inflate(r5, r3, false);
        this.mFavoriteFragment = r6;
        this.mListView = (DragSortListView) r6.findViewById(R.id.main_list1);
        OCTitleBar r7 = (OCTitleBar) this.mFavoriteFragment.findViewById(R.id.otitlebar);
        this.mOTitleBar = r7;
        OButton r8 = getTitleBtn(R.drawable.standard_icon_multi_select_selector, true, r7);
        this.mBtnEdit = r8;
        r8.setContentDescription(getString(R.string.common_edit));
        this.mBtnEdit.setOnClickListener(this);
        this.mBtnEdit.setEnabled(false);
        OButton r9 = this.mOTitleBar.createNeutralButton(getContext(), this.mOTitleBar.mLeftContainer);
        this.mBtnSelectedAllView = r9;
        r9.setContentDescription(getString(R.string.select_all));
        this.mSelectedAll = new SelectAllState(this.mBtnSelectedAllView);
        this.mBtnSelectedAllView.setOnClickListener(new AnonymousClass2(this));
        this.mBtnSelectedAllView.setVisibility(8);
        OButton r10 = getTitleBtn(R.drawable.standard_icon_common_add_selector, false, this.mOTitleBar);
        this.mBtnAdd = r10;
        r10.setContentDescription(getString(R.string.accessibility_btn_add_contact));
        this.mBtnAdd.setOnClickListener(this);
        OButton r11 = this.mOTitleBar.createNeutralButton(getContext(), this.mOTitleBar.mRightContainer);
        this.mBtnDone = r11;
        r11.setText(R.string.common_cancel);
        this.mBtnDone.setContentDescription(getString(R.string.accessibility_btn_cancel));
        this.mBtnDone.setOnClickListener(this);
        this.mBtnDone.setVisibility(8);
        this.mListView.setAutoClose(false);
        this.mListView.setDropListener(this.mOnDrop);
        this.mListView.setRemoveListener(this.mOnRemove);
        this.mListView.setDragListener(this.mOnDrag);
        this.mListView.setDragStartListener(this.mOnDragStart);
        this.mListView.setMoveListener(this.mOnMove);
        this.mListView.setOnScrollListener(this);
        this.mListView.setTag(this.TAG_LIST);
        this.mListView.setOnItemClickListener(this);
        this.mListView.setItemLongClickedListener(this.mItemLongClickedListener);
        ForceTouchAdapterController r12 = new ForceTouchAdapterController(this.mListView, getActivity(), this.mListView.getController());
        this.mForceTouchController = r12;
        this.mListView.setOnTouchListener(r12);
        QuickContactClickedView r13 = (QuickContactClickedView) this.mFavoriteFragment.findViewById(R.id.quickcontactclickedview);
        this.mQuickContactClickedView = r13;
        this.mListView.setQuickContactClickedView(r13);
        return this.mFavoriteFragment;
    }

    private OButton getTitleBtn(int r2, boolean r3, OCTitleBar r4) {
        LinearLayout r0 = r4.mLeftContainer;
        if (r3 == true) goto L5;
        r0 = r4.mRightContainer;
    L5:
        OButton r5 = r4.createTransIconButton(getContext(), r0);
        r5.setMIcon(getResources().getDrawable(r2));
        return r5;
    }

    @Override // com.android.contacts.AbstractFragment, com.obricOld.contacts.menus.LongMenuHelper.OnMenuItemClickedListener
    public boolean onMenuItemClicked(LongMenuHelper.MenuType r2, View r3, Object r4) {
        if (r2 != LongMenuHelper.MenuType.MENU_STAR) goto L11;
        FavoriteAdapter r1 = this.mAdapter;
        if (r1 != null) goto L7;
        return true;
    L7:
        if ((r4 instanceof FavoriteContact) == false) goto L14;
        r1.unstar(r3, (FavoriteContact) r4);
        return true;
    L14:
        return true;
    L11:
        return false;
    }

    private void setEmptyView() {
        if (this.mListView.getEmptyView() != null) goto L6;
        View r0 = this.mFavoriteFragment.findViewById(R.id.empty_view);
        OPageStatus r1 = (OPageStatus) r0.findViewById(R.id.black_view);
        r1.setTitle(getString(R.string.listTotalContactsZeroStarred));
        r1.setMessage(getString(R.string.listTotalAllContactsZeroStarredHint));
        this.mListView.setEmptyView(r0);
        return;
    }

    private void updateButtonsState() {
        int r0 = AnonymousClass18.$SwitchMap$com$android$contacts$list$PhoneFavoriteFragment$UIMode[this.mCurMode.ordinal()];
        boolean r2 = true;
        if (r0 != 1) goto L5;
    L30:
        this.mBtnDone.setVisibility(8);
        this.mBtnSelectedAllView.setVisibility(8);
        this.mBtnEdit.setVisibility(0);
        this.mBtnAdd.setVisibility(0);
        OButton r1 = this.mBtnEdit;
        if (this.mCurMode.isChanging() == false) goto L34;
    L32:
        boolean r3 = false;
    L40:
        r1.setEnabled(r3);
        this.mBtnAdd.setEnabled(!this.mCurMode.isChanging());
        this.mBottomDeleteLayoutListener.setLayoutVisible(false);
        this.mSelectedAll.setSelectAll(false);
        this.mOTitleBar.setTitleText(getString(R.string.common_favorites));
    L41:
        DialtactsActivity r4 = this.mDialtactsActivity;
        if (this.mCurMode.isChanging() == false) goto L44;
    L46:
        r2 = false;
    L47:
        r4.setTabOnclickEnabled(r2);
        return;
    L44:
        if (this.mDraging == true) goto L46;
    L34:
        if (this.mIsAnimationing == true) goto L32;
        FavoriteAdapter r5 = this.mAdapter;
        if (r5 == null) goto L32;
        if (r5.isEmpty() == true) goto L32;
        r3 = true;
        goto L40
    L5:
        if (r0 == 2) goto L30;
        if (r0 != 3) goto L9;
    L11:
        this.mBtnDone.setVisibility(0);
        this.mBtnSelectedAllView.setVisibility(0);
        this.mBtnEdit.setVisibility(8);
        this.mBtnAdd.setVisibility(8);
        OButton r6 = this.mBtnDone;
        if (this.mCurMode.isChanging() == false) goto L14;
    L17:
        boolean r7 = false;
    L18:
        r6.setEnabled(r7);
        this.mBottomDeleteLayoutListener.setLayoutVisible(true);
        BottomDeleteLayoutListener r8 = this.mBottomDeleteLayoutListener;
        if (this.mCurMode.isChanging() == false) goto L21;
    L28:
        boolean r9 = false;
    L29:
        r8.setBottomBtnEnable(r9);
        this.mOTitleBar.setTitleText(getString(R.string.delete_selected_item_numbers, new Object[]{Integer.valueOf(this.mAdapter.getRemoveCache().size())}));
        goto L41
    L21:
        if (this.mDraging == true) goto L28;
        FavoriteAdapter r10 = this.mAdapter;
        if (r10 == null) goto L28;
        if (r10.getRemoveCache().isEmpty() == true) goto L28;
        r9 = true;
        goto L29
    L14:
        if (this.mDraging == true) goto L17;
        r7 = true;
        goto L18
    L9:
        if (r0 == 4) goto L11;
        goto L11
    }

    public void setDialtactsActivity(DialtactsActivity r1) {
        this.mDialtactsActivity = r1;
    }

    private void triggerLoad() {
        if (this.mProviderIsNormal == true) goto L6;
        updateButtonsState();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "return triggerLoad mProviderIsNormal is false");
        return;
    L6:
        Thread r0 = new Thread(new AnonymousClass9(this));
        this.mPool.submit(r0);
    }

    public void setPrefsCallback(PreferencesCallback r1) {
        this.mPrefersCallback = r1;
    }

    public void onPreferencesChanged() {
        this.mHandler.removeMessages(2);
        this.mHandler.sendEmptyMessage(2);
    }

    private boolean hasExistInMap(long r3, String r5) {
        ArrayList<String> r0 = this.mFavoriteNumberMap.get(Long.valueOf(r3));
        if (r0 != null) goto L7;
        ArrayList<String> r1 = new ArrayList();
        r1.add(r5);
        this.mFavoriteNumberMap.put(Long.valueOf(r3), r1);
        return false;
    L7:
        if (hasExist(r0, r5) == false) goto L10;
        return true;
    L10:
        r0.add(r5);
        return false;
    }

    private boolean hasExist(ArrayList<String> r2, String r3) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.size() == 0) goto L18;
        Iterator<String> r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L19;
        if (PhoneNumberUtils.compare(r4.next(), r3) == false) goto L9;
        return true;
    L19:
        return false;
    L18:
        return false;
    }

    private synchronized Vector<FavoriteContact> getAllPhoneStared() {
        monitor-enter(this);
        this.mFavoriteNumberMap.clear();     // Catch: Throwable -> L28
        Vector<FavoriteContact> r0 = new Vector();     // Catch: Throwable -> L28
        Cursor r1 = getActivity().getApplicationContext().getContentResolver().query(ContactsContract.Data.CONTENT_URI, FavoriteQuery.getFavoriteProjection(this.mPrefersCallback.getDisplayOrder()), "data15 = 1 AND mimetype='vnd.android.cursor.item/phone_v2'", null, "CAST(data14 AS DECIMAL)");     // Catch: Throwable -> L28
        if (r1 != null) goto L32;
    L24:
        if (r1 == null) goto L26;
        r1.close();     // Catch: Throwable -> L28
    L26:
        monitor-exit(this);
        return r0;
    L32:
    L20:
        th = move-exception;
        if (r1 == null) goto L23;
        r1.close();     // Catch: Throwable -> L28
    L23:
        throw th;     // Catch: Throwable -> L28
    L6:
        if (r1.moveToFirst() == false) goto L24;
    L7:
        FavoriteContact r2 = new FavoriteContact();     // Catch: Throwable -> L20
        String r3 = r1.getString(5);     // Catch: Throwable -> L20
        if (r3 != null) goto L10;
        int r4 = 0;
    L11:
        r2.position = r4;     // Catch: Throwable -> L20
        r2.id = r1.getLong(6);     // Catch: Throwable -> L20
        r2.photoId = r1.getLong(7);     // Catch: Throwable -> L20
        r2.LookKey = r1.getString(8);     // Catch: Throwable -> L20
        r2.raw_contactid = r1.getLong(0);     // Catch: Throwable -> L20
        r2.number = r1.getString(1);     // Catch: Throwable -> L20
        r2.type = r1.getInt(2);     // Catch: Throwable -> L20
        if (r2.type != 0) goto L14;
        r2.label = r1.getString(3);     // Catch: Throwable -> L20
    L14:
        r2.name = r1.getString(9);     // Catch: Throwable -> L20
        r2.contactid = r1.getLong(10);     // Catch: Throwable -> L20
        if (hasExistInMap(r2.contactid, r2.number) == true) goto L18;
        r0.add(r2);     // Catch: Throwable -> L20
    L18:
        if (r1.moveToNext() == true) goto L7;
    L10:
        r4 = Integer.parseInt(r3);     // Catch: Throwable -> L20
        goto L11
    L28:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.contacts.list.PhoneFavoriteFragment$10] */
    private void preloadListItemView(final Context r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        final String r1 = "preloadListItemView";
        new AnonymousClass10(this, r1, r3).start();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mIsClickedBtnAdd = false;
        if (this.mCurMode.isNormal() == false) goto L6;
        triggerLoad();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        DragSortListView r0 = this.mListView;
        if (r0 == null) goto L6;
        r0.hideQuickContact();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.mDraging == false) goto L6;
        this.mDraging = false;
        updateButtonsState();
    L6:
        if (this.mCurMode.isNormal() == true) goto L12;
        exitEditMode();
        OActionSheet r0 = this.mDeleteSheet;
        if (r0 == null) goto L12;
        if (r0.isShowing() == false) goto L12;
        this.mDeleteSheet.dismiss();
        this.mDeleteSheet = null;
    L12:
        dismissLongMenu();
    }

    @Override // com.android.contacts.AbstractFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        setObserverToWork(false);
    }

    public float getQuickBarLeft() {
        return this.mQuickbartableLeft;
    }

    private void hideSoftKeyboard() {
        ((InputMethodManager) this.mActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.mListView.getWindowToken(), 0);
    }

    public void startActivityAndForwardResult(Intent r2) {
        r2.setFlags(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
        Bundle r0 = getActivity().getIntent().getExtras();
        if (r0 == null) goto L5;
        r2.putExtras(r0);
    L5:
        startActivity(r2);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView r1, int r2) {
        hideSoftKeyboard();
        if (this.mCurMode.isNormal() == false) goto L7;
        if (r2 != 0) goto L8;
        ContactDetailCacheManager.getInstance().refreshCache(r1);
        return;
    L8:
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        if (r4 != this.mBtnAdd) goto L8;
        if (this.mIsClickedBtnAdd == true) goto L21;
        ActivityOptions r5 = ActivityOptions.makeCustomAnimation(getActivity(), R.anim.activity_slide_in_from_bottom, R.anim.activity_slide_do_nothing);
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_STAR);
        Intent r0 = new Intent();
        r0.setAction(ContactSelectionActivity.ACTION_PICK_UNFAVORITE_NUMS);
        startActivityForResult(r0, 30, r5.toBundle());
        this.mIsClickedBtnAdd = true;
        return;
    L21:
        return;
    L8:
        if (r4 != this.mBtnEdit) goto L18;
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_EDIT_FAVORITE);
        FavoriteAdapter r6 = this.mAdapter;
        if (r6 != null) goto L12;
        return;
    L12:
        if (r6.isEmpty() == false) goto L14;
        return;
    L14:
        if (this.mAdapter.getFavoriteCancleState() == false) goto L16;
        return;
    L16:
        this.mCurMode = UIMode.MODE_TO_EDIT;
        updateListViewState();
        updateButtonsState();
        editAnimation();
        return;
    L18:
        if (r4 != this.mBtnDone) goto L26;
        clickedBtnCancel();
        return;
    }

    public void showDeleteFavoriteDialog() {
        String r3 = getString(R.string.sheet_title_remove_favorite_number);
        OActionSheet r0 = OSheetUtils.getActionSheet(getContext(), OInsetSheet.PanelWidth.NARROW_WIDTH, r3, null, getString(R.string.common_ok), OSheetUtils.ContentViewStyle.RED, new AnonymousClass11(this), new AnonymousClass12(this));
        this.mDeleteSheet = r0;
        r0.show();
    }

    private View getDeleteHeaderView() {
        this.mAdapter.getRemoveCache().size();
        String r0 = getResources().getString(R.string.sheet_title_remove_favorite_number);
        OInsetSheetTitleBar r1 = new OInsetSheetTitleBar(getContext());
        r1.setShowLeftBack(false);
        r1.setTitleText(r0);
        OButton r2 = r1.createNeutralButton(getContext(), r1.mRightContainer);
        r2.setButtonSourceBitmap(R.drawable.o_ic_close);
        r2.setOnClickListener(new AnonymousClass13(this));
        return r1;
    }

    private View getDeleteContentView() {
        LinearLayout r0 = new LinearLayout(getContext());
        r0.setOrientation(1);
        r0.setPadding(0, 0, 0, ContactsUtils.dipTopx(getContext(), 15.0d));
        OButton r1 = (OButton) LayoutInflater.from(getContext()).inflate(R.layout.sheet_button_center_red, null);
        r1.setText(R.string.common_ok);
        r1.setOnClickListener(new AnonymousClass14(this));
        r1.setWidth(ContactsUtils.dipTopx(getContext(), 296.0d));
        r1.setHeight(ContactsUtils.dipTopx(getContext(), 56.0d));
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(-2, -2);
        r2.gravity = 17;
        r2.bottomMargin = ContactsUtils.dipTopx(getContext(), 5.0d);
        r0.addView(r1, r2);
        return r0;
    }

    private void doRemoveAction() {
        final Vector r0 = (Vector) this.mFavoriteContacts.clone();
        final HashMap<Long, FavoriteContact> r1 = this.mAdapter.getRemoveCache();
        ArrayList<Integer> r2 = new ArrayList();
        ArrayList<Integer> r3 = new ArrayList();
        Iterator r4 = r0.iterator();
        int r5 = 0;
    L4:
        if (r4.hasNext() == false) goto L10;
        FavoriteContact r6 = (FavoriteContact) r4.next();
        if (r1.keySet().contains(Long.valueOf(r6.id)) == false) goto L8;
        r2.add(Integer.valueOf(r5));
        r4.remove();
    L9:
        r5 = r5 + 1;
        goto L4
    L8:
        r3.add(Integer.valueOf(r5));
        goto L9
    L10:
        final DragSortListView r7 = this.mListView;
        new AnonymousClass15(this, r7, r0, r1).setResultListSize(r0.size()).start(r2, r3);
    }

    private void clickedBtnCancel() {
        if (this.mCurMode.isEdit() == true) goto L5;
        return;
    L5:
        if (this.mDraging == true) goto L15;
        this.mCurMode = UIMode.MODE_TO_NORMAL;
        updateListViewState();
        this.mBottomDeleteLayoutListener.startTransition(false);
        updateButtonsState();
        FavoriteAdapter r0 = this.mAdapter;
        if (r0 != null) goto L10;
    L12:
        cancelAnimation();
        return;
    L10:
        if (r0.isDataChanged() == false) goto L12;
        showProgressDialog();
        ChangeThread r1 = new ChangeThread(this, null);
        this.mChangeThread = r1;
        r1.start();
        goto L12
    }

    private void editAnimation() {
        if (this.mListView != null) goto L5;
        return;
    L5:
        if (this.mAdapter == null) goto L10;
        this.mBottomDeleteLayoutListener.startTransition(true);
        this.mListAnimator.startEdit(this.mListView);
        this.mCurMode = UIMode.MODE_EDIT;
        this.mAdapter.notifyDataSetChanged();
        updateListViewState();
        updateButtonsState();
        return;
    }

    private void cancelAnimation() {
        if (this.mListView != null) goto L5;
        return;
    L5:
        if (this.mAdapter != null) goto L8;
        return;
    L8:
        if (this.mCurMode != UIMode.MODE_TO_NORMAL) goto L14;
        this.mCurMode = UIMode.MODE_NORMAL;
        updateListViewState();
        ChangeThread r0 = this.mChangeThread;
        if (r0 != null) goto L12;
    L13:
        onExitEditMode();
        goto L14
    L12:
        if (r0.isAlive() == false) goto L13;
    L14:
        this.mListAnimator.finishEdit(this.mListView);
    }

    private void setObserverToWork(boolean r2) {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (r2 == false) goto L7;
        registerObserver();
        return;
    L7:
        unregisterObserver();
    }

    private void registerObserver() {
        if (this.mContactsContent != null) goto L6;
        this.mContactsContent = new ContactsContent(this, new Handler());
        getActivity().getContentResolver().registerContentObserver(Uri.withAppendedPath(ContactsContract.Data.CONTENT_URI, BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG), true, this.mContactsContent);
        return;
    }

    private void unregisterObserver() {
        if (this.mContactsContent == null) goto L6;
        getActivity().getContentResolver().unregisterContentObserver(this.mContactsContent);
        this.mContactsContent = null;
        return;
    }

    @Override // com.android.contacts.activities.DialtactsActivity.ViewPagerVisibilityListener
    public void onVisibilityChanged(boolean r3) {
        if (this.mVisible != r3) goto L5;
    L18:
        this.mVisible = r3;
        return;
    L5:
        if (r3 == true) goto L13;
        DragSortListView r1 = this.mListView;
        if (r1 != null) goto L9;
    L12:
        setObserverToWork(false);
        exitEditMode();
        dismissLongMenu();
        goto L18
    L9:
        if (r1.isShowQuickContact() == false) goto L11;
        this.mListView.hideQuickContact();
    L11:
        this.mListView.setScrollEnabled(true);
        goto L12
    L13:
        setObserverToWork(true);
        if (isResumed() == false) goto L18;
        if (this.mCurMode.isNormal() == false) goto L18;
        triggerLoad();
        goto L18
    }

    public void exitEditMode() {
        if (this.mCurMode.isNormal() == true) goto L5;
        this.mCurMode = UIMode.MODE_NORMAL;
    L5:
        this.mNeedReloadData = true;
        onExitEditMode();
    }

    private void onExitEditMode() {
        if (this.mCurMode.isNormal() == false) goto L18;
        DragSortListView r0 = this.mListView;
        if (r0 == null) goto L7;
        r0.stopScrolling();
        this.mListView.cancelDrag();
        updateListViewState();
    L7:
        FavoriteAdapter r1 = this.mAdapter;
        if (r1 == null) goto L14;
        r1.setDataChanged(false);
        if (this.mAdapter.getRemoveCache() == null) goto L12;
        this.mAdapter.getRemoveCache().clear();
    L12:
        this.mAdapter.notifyDataSetInvalidated();
    L14:
        if (this.mNeedReloadData == false) goto L16;
        this.mNeedReloadData = false;
        triggerLoad();
        return;
    L16:
        updateButtonsState();
        return;
    }

    public void updateListViewState() {
        boolean r1 = true;
        if (this.mListView != null) goto L5;
    L17:
        FavoriteAdapter r0 = this.mAdapter;
        if (r0 != null) goto L20;
        return;
    L20:
        if (this.mCurMode.isEdit() == false) goto L22;
    L25:
        r0.setIsEdit(r1);
        return;
    L22:
        if (this.mCurMode.isChanging() == true) goto L25;
        r1 = false;
        goto L25
    L5:
        if (this.mCurMode.isChanging() == false) goto L10;
        this.mListView.setIsDoingAnimation(true);
        this.mListView.setScrollEnabled(false);
        if (this.mCurMode.isToEdit() == false) goto L16;
        this.mListView.restoreScrollState(false);
    L16:
        this.mListView.setDragEnabled(this.mCurMode.isEdit());
        goto L17
    L10:
        if (this.mCurMode.isEdit() == false) goto L13;
        this.mListView.setScrollEnabled(false);
    L15:
        this.mListView.setIsDoingAnimation(false);
        goto L16
    L13:
        if (this.mCurMode.isNormal() == false) goto L15;
        this.mListView.setScrollEnabled(true);
        goto L15
    }

    @Override // com.android.contacts.activities.DialtactsActivity.PageEnableListener
    public void setEnable(boolean r3, boolean r4) {
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "setEnable visible:" + r3 + "; mProviderIsNormal:" + this.mProviderIsNormal);
    L5:
        this.mProviderIsNormal = r3;
        if (r3 == true) goto L8;
        return;
    L8:
        if (this.mCurMode.isNormal() == false) goto L13;
        if (r4 == false) goto L14;
        triggerLoad();
        return;
    L14:
        return;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        if (this.mAdapter.getItem(r3) != null) goto L6;
        return;
    L6:
        if (this.mAdapter.getEditState() == false) goto L9;
        FavoriteAdapter r5 = this.mAdapter;
        r5.checkTo(r3, !r5.isChecked(r3));
        updateButtonsState();
        this.mAdapter.notifyDataSetChanged();
        updateSelectedStatus();
        return;
    L9:
        if (ContactsUtils.isJustClicked() == true) goto L13;
        this.mAdapter.goDetail(r3);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        if (r3 == (-1)) goto L6;
        return;
    L6:
        if (r2 != 30) goto L16;
        final ArrayList<String> r5 = r4.getStringArrayListExtra("com.android.contacts.extra.PHONE_URIS");
        if (r5 != null) goto L11;
        return;
    L11:
        if (r5.size() == 0) goto L17;
        new Thread(new AnonymousClass16(this, r5)).start();
        return;
    L17:
        return;
    }

    @Override // com.android.contacts.activities.DialtactsActivity.ReleaseResourceListener
    public void release() {
        if (this.mVisible == true) goto L11;
        DragSortListView r0 = this.mListView;
        if (r0 == null) goto L7;
        r0.setAdapter(null);
        this.mListView.setOnScrollStateChangeListener(null);
    L7:
        FavoriteAdapter r1 = this.mAdapter;
        if (r1 == null) goto L12;
        r1.setList(null);
        this.mAdapter.mHSListView = null;
        this.mAdapter = null;
        this.mFavoriteContacts = null;
        return;
    L12:
        return;
    }

    @Override // com.android.contacts.activities.DialtactsActivity.onBackPressListener
    public boolean backToTopState() {
        DragSortListView r0 = this.mListView;
        if (r0 != null) goto L5;
    L20:
        return true;
    L5:
        if (r0.isSelecting() == false) goto L11;
        if (ContactsUtils.DEBUG == false) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "ListView is selecting...");
    L9:
        return false;
    L11:
        if (this.mListView.isShowQuickContact() == false) goto L16;
        this.mListView.hideQuickContact();
        if (ContactsUtils.DEBUG == false) goto L22;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "QuickContact is showing...");
        return false;
    L22:
        return false;
    L16:
        if (this.mCurMode.isEdit() == false) goto L20;
        clickedBtnCancel();
        if (ContactsUtils.DEBUG == false) goto L24;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "In edit mode...");
        return false;
    L24:
        return false;
    }

    private void showProgressDialog() {
        this.dismissDialog = false;
        if (this.mProgressDialog != null) goto L5;
        ProgressDialog r1 = new ProgressDialog(this.mActivity);
        this.mProgressDialog = r1;
        r1.setMessage(R.string.progress_dialog_message_for_wait);
        this.mProgressDialog.setCancelable(false);
    L5:
        this.mHandler.postDelayed(new AnonymousClass17(this), 1000);
    }

    private void dismissProgressDialog() {
        this.dismissDialog = true;
        ProgressDialog r0 = this.mProgressDialog;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L9;
        this.mProgressDialog.dismiss();
        return;
    }

    public void setBottomDeleteLayoutListener(BottomDeleteLayoutListener r1) {
        this.mBottomDeleteLayoutListener = r1;
    }

    private void updateSelectedStatus() {
        boolean r3 = true;
        int r2 = 0;
        boolean r4 = false;
    L4:
        if (r2 >= this.mAdapter.getCount()) goto L17;
        if (this.mAdapter.isChecked(r2) == false) goto L9;
        if (r3 == false) goto L9;
        r3 = true;
    L11:
        if (this.mAdapter.isChecked(r2) == true) goto L15;
        if (r4 == true) goto L15;
        r4 = false;
    L16:
        r2 = r2 + 1;
    L15:
        r4 = true;
    L9:
        r3 = false;
        goto L11
    L17:
        this.mSelectedAll.setSelectAll(r3);
        this.mBottomDeleteLayoutListener.setBottomBtnEnable(r4);
    }
}
