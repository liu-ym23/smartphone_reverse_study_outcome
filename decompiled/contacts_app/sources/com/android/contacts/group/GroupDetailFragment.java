package com.android.contacts.group;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.loader.app.LoaderManager;
import com.GlobalProxyLancet;
import com.android.contacts.AbstractFragment;
import com.android.contacts.BlacklistManager;
import com.android.contacts.ContactLoader;
import com.android.contacts.ContactPhotoManager;
import com.android.contacts.ContactPresenceIconUtil;
import com.android.contacts.ContactSaveService;
import com.android.contacts.ContactStatusUtil;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.contacts.GroupMemberLoader;
import com.android.contacts.PreferencesCallback;
import com.android.contacts.R;
import com.android.contacts.activities.ContactSelectionActivity;
import com.android.contacts.activities.GroupEditorActivity;
import com.android.contacts.bytedanceosquickcontact.QuickContactClickedView;
import com.android.contacts.bytedanceosquickcontact.QuickContactListener;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.forcetouch.ForceTouchController;
import com.android.contacts.list.BottomDeleteLayoutListener;
import com.android.contacts.list.ContactDetailCacheManager;
import com.android.contacts.list.ContactTileAdapter;
import com.android.contacts.list.ContactsListBaseAdapter;
import com.android.contacts.list.HorizontalScrollListView;
import com.android.contacts.list.LetterMatcher;
import com.android.contacts.list.SamContact;
import com.android.contacts.list.SlideListView;
import com.android.contacts.pick.PickerFragment;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.Constants;
import com.android.contacts.util.NameSortComparator;
import com.android.contacts.util.OAlertDialogUtils;
import com.android.contacts.util.SidebarDragHelper;
import com.android.contacts.widget.AvatarImageView;
import com.android.contacts.widget.SelectAllState;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.anim.ListAnimator;
import com.obric.immersive.Immersive;
import com.obric.oui.actionbar.v2.OBottomActionBarFloating;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.indexscrollbar.OIndexScrollbar;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.ui.OFloatingTitleBarHolder;
import com.obric.ui.OUIBottomActionBarTextLRHolder;
import com.obric.ui.OUIHelper;
import com.obric.utils.views.ObricBottomDeleteBarView;
import com.obricOld.contacts.menus.LongMenuHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import obric.api.IntentSmt;
import obric.app.tracker.Agent;

/* JADX INFO: loaded from: classes2.dex */
public class GroupDetailFragment extends AbstractFragment implements AbsListView.OnScrollListener, View.OnClickListener {
    private static final int CACHE_COUNT = 10;
    private static final int EDIT_GROUP_MEMBER = 1;
    private static final int EDIT_NONE = 0;
    private static final int EDIT_SEND_EMAIL = 3;
    private static final int EDIT_SEND_MESSAGE = 2;
    private static final int LOADER_MEMBERS = 1;
    private static final int LOADER_METADATA = 0;
    private static final int REQUEST_CODE_ADD_GROUP_MEMBER = 1000;
    private static final int SHOW_STATE_NONE = 5;
    private static final int SHOW_STATE_NORMAL = 2;
    private static final int SHOW_STATE_REMOVEABLE = 3;
    private static final int SHOW_STATE_SELECT = 1;
    private static final int SHOW_STATE_SEND = 4;
    private static final String STATE_CANCEL = "STATE_CANCEL";
    private static final String STATE_NONE = "STATE_NONE";
    private static final String STATE_NORMAL = "STATE_NORMAL";
    private static final String STATE_REMOVE = "STATE_REMOVE";
    private static final String STATE_SELECT = "STATE_SELECT";
    private static final String STATE_SEND = "STATE_SEND";
    private static final String TAG = "GroupDetailFragment";
    private static final LongMenuHelper.MenuType[] sLongMeneItems = null;
    private String ACCOUNTNAME;
    private String ACCOUNTTYPE;
    private String mAccountName;
    private String mAccountType;
    private ContactTileAdapter mAdapter;
    private BlacklistManager mBlacklistManager;
    private OUIBottomActionBarTextLRHolder mBottomActionBarHolder;
    private FrameLayout mBottomBarFrame;
    private ObricBottomDeleteBarView mBottomDeleteBar;
    private BottomDeleteLayoutListener mBottomDeleteLayoutListener;
    private View mBtnSend;
    private View mButtonEdit;
    private OPageStatus mBvEmpty;
    private OCheckBox mCheckBox;
    private ArrayList<SamContact> mContactsToSendEmail;
    private ArrayList<SamContact> mContactsToSendMessage;
    private Context mContext;
    private int mCurEditState;
    private OAlertDialog mDeleteDialog;
    private RelativeLayout mEditFrame;
    private HashSet<Long> mEmailIds;
    private View mEmptyView;
    private OFloatingTitleBarHolder mFloatingTitleBarHolder;
    private ForceTouchController mForceTouchController;
    private HashMap<String, String> mGroupBrowse;
    private long mGroupId;
    private ArrayList<ContactTileAdapter.ContactEntry> mGroupMemberList;
    private final LoaderManager.LoaderCallbacks<Cursor> mGroupMemberListLoaderListener;
    private final LoaderManager.LoaderCallbacks<Cursor> mGroupMetadataLoaderListener;
    private String mGroupName;
    private TextView mGroupOptionBarTitle;
    private TextView mGroupSize;
    private Uri mGroupUri;
    private Handler mHandler;
    private boolean mIsClickBtnSendEmail;
    private boolean mIsClickBtnSendMessage;
    private boolean mIsEditMode;
    private boolean mIsLoadGroup;
    private boolean mIsLoadedEmail;
    private boolean mIsLoadedNumber;
    private boolean mIsRemovingContacts;
    private boolean mIsUngrouped;
    private boolean mIsUsedMode;
    private HorizontalScrollListView.ItemLongClickedListener mItemLongClickedListener;
    private final ListAnimator mListAnimator;
    private LoadEmailTask mLoadEmailTask;
    private Runnable mLoadMemberRunnable;
    private LoadMemberTask mLoadMemberTask;
    private LoadNumberTask mLoadNumberTask;
    private SlideListView mMemberListView;
    private Observer<Integer> mNavigationBarObserver;
    private View mOptionBar;
    private HashSet<Long> mPhoneIds;
    private ContactPhotoManager mPhotoManager;
    private PreferencesCallback mPrefsCallback;
    private OIndexScrollbar.QBListener mQBListener;
    private OIndexScrollbar mQuickBar;
    private QuickContactClickedView mQuickContactClickedView;
    private boolean mQuitCacheLayoutThread;
    private View mRootView;
    private Runnable mScrollIdle;
    private SelectAllState mSelectAllState;
    private OTextView mSelectTextView;
    private SendGroupAdapter mSendEmailAdapter;
    private SendGroupAdapter mSendMessageAdapter;
    private SidebarDragHelper mSidebarDragHelper;
    private SlideListView.Listener mSlideListener;
    private OIndexScrollbar.SurnameListener mSurnameListener;
    private LinkedList<View> mViewCache;
    private ContactsListBaseAdapter.VoiceBtnCallBack mVoiceBtnCallBack;
    private TextView secondaryHintTextView;

    private class LoadEmailTask extends AsyncTask<ArrayList<Long>, Void, Void> {
        ArrayList<SamContact> contactsToSendEmail;
        HashSet<Long> dataIds;
        final /* synthetic */ GroupDetailFragment this$0;

        private LoadEmailTask(GroupDetailFragment r1) {
            this.this$0 = r1;
            this.contactsToSendEmail = new ArrayList();
            this.dataIds = new HashSet();
        }

        /* synthetic */ LoadEmailTask(GroupDetailFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(ArrayList<Long>[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
            onPostExecute2(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(ArrayList<Long>... r3) {
            GroupDetailFragment.access$4902(this.this$0, false);
            this.this$0.updateContactEmail(r3[0], this.contactsToSendEmail, this.dataIds);
            return null;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Void r7) {
            if (this.this$0.isAdded() == true) goto L5;
            return;
        L5:
            GroupDetailFragment.access$5002(this.this$0, this.contactsToSendEmail);
            GroupDetailFragment.access$5102(this.this$0, this.dataIds);
            if (GroupDetailFragment.access$5200(this.this$0) != null) goto L8;
            GroupDetailFragment r8 = this.this$0;
            GroupDetailFragment r4 = this.this$0;
            GroupDetailFragment.access$5202(r8, new SendGroupAdapter(r4, GroupDetailFragment.access$5000(r4), true));
        L13:
            GroupDetailFragment.access$4902(this.this$0, true);
            if (GroupDetailFragment.access$5300(this.this$0) == false) goto L17;
            GroupDetailFragment.access$4800(this.this$0).getRightBtn().setTitle(R.string.btn_sendemail);
            this.this$0.setSendEmailMode();
            GroupDetailFragment.access$5302(this.this$0, false);
        L17:
            if (GroupDetailFragment.access$5000(this.this$0).size() == 0) goto L19;
            return;
        L19:
            if (GroupDetailFragment.access$4200(this.this$0) != 3) goto L23;
            this.this$0.setCancelEditMode();
            return;
        L23:
            return;
        L8:
            GroupDetailFragment.access$5200(this.this$0).setContacts(GroupDetailFragment.access$5000(this.this$0), GroupDetailFragment.access$5100(this.this$0));
            SendGroupAdapter r9 = GroupDetailFragment.access$5200(this.this$0);
            if (GroupDetailFragment.access$4200(this.this$0) != 3) goto L11;
            boolean r3 = true;
        L12:
            r9.notifyDataSetChanged(r3);
            goto L13
        L11:
            r3 = false;
            goto L12
        }
    }

    private class LoadMemberRunnable implements Runnable {
        final /* synthetic */ GroupDetailFragment this$0;

        private LoadMemberRunnable(GroupDetailFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ LoadMemberRunnable(GroupDetailFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            GroupDetailFragment.access$2802(this.this$0, new LoadMemberTask(this.this$0, null));
            GroupDetailFragment.access$2800(this.this$0).execute(new Void[0]);
        }
    }

    private class LoadMemberTask extends AsyncTask<Void, Void, Void> {
        ArrayList<Long> mRawContactIds;
        final /* synthetic */ GroupDetailFragment this$0;

        private LoadMemberTask(GroupDetailFragment r1) {
            this.this$0 = r1;
            this.mRawContactIds = new ArrayList();
        }

        /* synthetic */ LoadMemberTask(GroupDetailFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
            onPostExecute2(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(Void... r1) {
            GroupDetailFragment r2 = this.this$0;
            GroupDetailFragment.access$4002(r2, GroupDetailFragment.access$4100(r2, this.mRawContactIds));
            return null;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Void r4) {
            if (this.this$0.isAdded() == true) goto L5;
            return;
        L5:
            GroupDetailFragment.access$2000("load members finish and refresh");
            ContactTileAdapter r5 = GroupDetailFragment.access$1300(this.this$0);
            ArrayList<ContactTileAdapter.ContactEntry> r0 = GroupDetailFragment.access$4000(this.this$0);
            boolean r2 = true;
            if (GroupDetailFragment.access$4200(this.this$0) == 1) goto L9;
            r2 = false;
        L9:
            r5.setList(r0, r2);
            if (GroupDetailFragment.access$1000(this.this$0) == true) goto L12;
            ContactDetailCacheManager.getInstance().refreshCache(GroupDetailFragment.access$100(this.this$0));
        L12:
            GroupDetailFragment.access$4300(this.this$0, this.mRawContactIds);
        }
    }

    private class LoadNumberTask extends AsyncTask<ArrayList<Long>, Void, Void> {
        ArrayList<SamContact> contactsToSendMessage;
        HashSet<Long> dateIds;
        final /* synthetic */ GroupDetailFragment this$0;

        private LoadNumberTask(GroupDetailFragment r1) {
            this.this$0 = r1;
            this.contactsToSendMessage = new ArrayList();
            this.dateIds = new HashSet();
        }

        /* synthetic */ LoadNumberTask(GroupDetailFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(ArrayList<Long>[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
            onPostExecute2(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(ArrayList<Long>... r3) {
            GroupDetailFragment.access$4402(this.this$0, false);
            this.this$0.updateContactPhone(r3[0], this.contactsToSendMessage, this.dateIds);
            return null;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Void r7) {
            if (this.this$0.isAdded() == true) goto L5;
            return;
        L5:
            GroupDetailFragment.access$4502(this.this$0, this.contactsToSendMessage);
            GroupDetailFragment.access$4602(this.this$0, this.dateIds);
            if (GroupDetailFragment.access$1600(this.this$0) != null) goto L8;
            GroupDetailFragment r8 = this.this$0;
            GroupDetailFragment r4 = this.this$0;
            GroupDetailFragment.access$1602(r8, new SendGroupAdapter(r4, GroupDetailFragment.access$4500(r4), false));
        L13:
            GroupDetailFragment.access$4402(this.this$0, true);
            if (GroupDetailFragment.access$4700(this.this$0) == false) goto L17;
            GroupDetailFragment.access$4800(this.this$0).getLeftBtn().setTitle(R.string.btn_sendmessage);
            this.this$0.setSendMessageMode();
            GroupDetailFragment.access$4702(this.this$0, false);
        L17:
            if (GroupDetailFragment.access$4500(this.this$0).size() == 0) goto L19;
            return;
        L19:
            if (GroupDetailFragment.access$4200(this.this$0) != 2) goto L23;
            this.this$0.setCancelEditMode();
            return;
        L23:
            return;
        L8:
            GroupDetailFragment.access$1600(this.this$0).setContacts(GroupDetailFragment.access$4500(this.this$0), GroupDetailFragment.access$4600(this.this$0));
            SendGroupAdapter r9 = GroupDetailFragment.access$1600(this.this$0);
            if (GroupDetailFragment.access$4200(this.this$0) != 2) goto L11;
            boolean r3 = true;
        L12:
            r9.notifyDataSetChanged(r3);
            goto L13
        L11:
            r3 = false;
            goto L12
        }
    }

    protected static class PhoneQuery {
        public static final int Email_CONTACT_ID = 4;
        public static final int Email_DISPLAY_NAME = 7;
        public static final int Email_ID = 0;
        public static final int Email_LABEL = 2;
        public static final int Email_LABEL_PRIMARY = 9;
        public static final int Email_LOOKUP_KEY = 5;
        public static final int Email_NUMBER = 3;
        public static final int Email_PHOTO_ID = 6;
        public static final int Email_RAW_CONTACT_ID = 10;
        public static final int Email_SORT_KEY = 8;
        public static final int Email_TYPE = 1;
        public static final int PHONE_BOOK_LABEL_PRIMARY = 9;
        public static final int PHONE_CONTACT_ID = 4;
        public static final int PHONE_DISPLAY_NAME = 7;
        public static final int PHONE_ID = 0;
        public static final int PHONE_LABEL = 2;
        public static final int PHONE_LOOKUP_KEY = 5;
        public static final int PHONE_NUMBER = 3;
        public static final int PHONE_PHOTO_ID = 6;
        public static final int PHONE_RAW_CONTACT_ID = 10;
        public static final int PHONE_SORT_KEY = 8;
        public static final int PHONE_TYPE = 1;
        private static final String[] PROJECTION_EMAIL = null;
        private static final String[] PROJECTION_PHONE = null;

        protected PhoneQuery() {
        }

        static {
            PROJECTION_PHONE = new String[]{"_id", DBHelper.COL_DATA2, DBHelper.COL_DATA3, "data1", "contact_id", "lookup", "photo_id", "display_name", PickerFragment.CONTACT_SORT_CNAME, Constants.ContactsColumns.PHONEBOOK_LABEL_PRIMARY, GroupSelectionActivity.EXTRA_RAW_CONTACT_ID};
            PROJECTION_EMAIL = new String[]{"_id", DBHelper.COL_DATA2, DBHelper.COL_DATA3, "data1", "contact_id", "lookup", "photo_id", "display_name", PickerFragment.CONTACT_SORT_CNAME, Constants.ContactsColumns.PHONEBOOK_LABEL_PRIMARY, GroupSelectionActivity.EXTRA_RAW_CONTACT_ID};
        }

        public static String[] getPhoneProjection(int r3, int r4) {
            if (r3 != 2) goto L5;
            PROJECTION_PHONE[7] = "display_name_alt";
        L7:
            if (r4 != 2) goto L9;
            PROJECTION_PHONE[8] = "sort_key_alt";
        L11:
            return PROJECTION_PHONE;
        L9:
            PROJECTION_PHONE[8] = PickerFragment.CONTACT_SORT_CNAME;
            goto L11
        L5:
            PROJECTION_PHONE[7] = "display_name";
            goto L7
        }

        public static String[] getEmailProjection(int r3, int r4) {
            if (r3 != 2) goto L5;
            PROJECTION_EMAIL[7] = "display_name_alt";
        L7:
            if (r4 != 2) goto L9;
            PROJECTION_EMAIL[8] = "sort_key_alt";
        L11:
            return PROJECTION_EMAIL;
        L9:
            PROJECTION_EMAIL[8] = PickerFragment.CONTACT_SORT_CNAME;
            goto L11
        L5:
            PROJECTION_EMAIL[7] = "display_name";
            goto L7
        }
    }

    private static class RawContactNameQuery {
        public static final int RAW_CONTACT_DISPLAY_NAME = 1;
        public static final int RAW_CONTACT_ID = 0;
        private static final String[] sProjection = null;

        private RawContactNameQuery() {
        }

        static {
            sProjection = new String[]{"_id", "display_name"};
        }

        public static String[] getProjection(int r2) {
            if (r2 != 2) goto L5;
            sProjection[1] = "display_name_alt";
        L7:
            return sProjection;
        L5:
            sProjection[1] = "display_name";
            goto L7
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r1, int r2, int r3, int r4) {
    }

    static /* synthetic */ void access$000(GroupDetailFragment r0) {
        r0.hideVoiceSearchBtn();
    }

    static /* synthetic */ SlideListView access$100(GroupDetailFragment r0) {
        return r0.mMemberListView;
    }

    static /* synthetic */ boolean access$1000(GroupDetailFragment r0) {
        return r0.mIsEditMode;
    }

    static /* synthetic */ void access$1100(GroupDetailFragment r0) {
        r0.doRemoveAction();
    }

    static /* synthetic */ OAlertDialog access$1200(GroupDetailFragment r0) {
        return r0.mDeleteDialog;
    }

    static /* synthetic */ ContactTileAdapter access$1300(GroupDetailFragment r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ boolean access$1400(GroupDetailFragment r0) {
        return r0.mIsRemovingContacts;
    }

    static /* synthetic */ boolean access$1402(GroupDetailFragment r0, boolean r1) {
        r0.mIsRemovingContacts = r1;
        return r1;
    }

    static /* synthetic */ long access$1500(GroupDetailFragment r2) {
        return r2.mGroupId;
    }

    static /* synthetic */ SendGroupAdapter access$1600(GroupDetailFragment r0) {
        return r0.mSendMessageAdapter;
    }

    static /* synthetic */ SendGroupAdapter access$1602(GroupDetailFragment r0, SendGroupAdapter r1) {
        r0.mSendMessageAdapter = r1;
        return r1;
    }

    static /* synthetic */ Handler access$1700(GroupDetailFragment r0) {
        return r0.mHandler;
    }

    static /* synthetic */ Uri access$1800(GroupDetailFragment r0) {
        return r0.mGroupUri;
    }

    static /* synthetic */ Context access$1900(GroupDetailFragment r0) {
        return r0.mContext;
    }

    static /* synthetic */ boolean access$200(GroupDetailFragment r0) {
        return r0.mQuitCacheLayoutThread;
    }

    static /* synthetic */ void access$2000(String r0) {
        log(r0);
    }

    static /* synthetic */ void access$2100(GroupDetailFragment r0, Cursor r1) {
        r0.bindGroupMetaData(r1);
    }

    static /* synthetic */ void access$2200(GroupDetailFragment r0) {
        r0.startGroupMembersLoader();
    }

    static /* synthetic */ String access$2300(GroupDetailFragment r0) {
        return r0.mAccountName;
    }

    static /* synthetic */ String access$2400(GroupDetailFragment r0) {
        return r0.mAccountType;
    }

    static /* synthetic */ String access$2500(GroupDetailFragment r0) {
        return r0.mGroupName;
    }

    static /* synthetic */ void access$2600(GroupDetailFragment r0, int r1, int r2) {
        r0.updateSize(r1, r2);
    }

    static /* synthetic */ void access$2700(GroupDetailFragment r0, String r1) {
        r0.updateTitle(r1);
    }

    static /* synthetic */ LoadMemberTask access$2800(GroupDetailFragment r0) {
        return r0.mLoadMemberTask;
    }

    static /* synthetic */ LoadMemberTask access$2802(GroupDetailFragment r0, LoadMemberTask r1) {
        r0.mLoadMemberTask = r1;
        return r1;
    }

    static /* synthetic */ LinkedList access$300(GroupDetailFragment r0) {
        return r0.mViewCache;
    }

    static /* synthetic */ boolean access$3000(GroupDetailFragment r0) {
        return r0.mIsUngrouped;
    }

    static /* synthetic */ PreferencesCallback access$3100(GroupDetailFragment r0) {
        return r0.mPrefsCallback;
    }

    static /* synthetic */ void access$3200(GroupDetailFragment r0, int r1) {
        r0.updateUI(r1);
    }

    static /* synthetic */ boolean access$3300(GroupDetailFragment r0) {
        return r0.mIsLoadGroup;
    }

    static /* synthetic */ boolean access$3302(GroupDetailFragment r0, boolean r1) {
        r0.mIsLoadGroup = r1;
        return r1;
    }

    static /* synthetic */ void access$3400(GroupDetailFragment r0, Cursor r1) {
        r0.fastLoadMembers(r1);
    }

    static /* synthetic */ void access$3500(GroupDetailFragment r0) {
        r0.notifyBuildLayoutCache();
    }

    static /* synthetic */ void access$3600(GroupDetailFragment r0) {
        r0.triggerMemberLoad();
    }

    static /* synthetic */ void access$400(GroupDetailFragment r0) {
        r0.showDeleteGroupMembersDialog();
    }

    static /* synthetic */ ArrayList access$4000(GroupDetailFragment r0) {
        return r0.mGroupMemberList;
    }

    static /* synthetic */ ArrayList access$4002(GroupDetailFragment r0, ArrayList r1) {
        r0.mGroupMemberList = r1;
        return r1;
    }

    static /* synthetic */ ArrayList access$4100(GroupDetailFragment r0, ArrayList r1) {
        return r0.initGroupMemberList(r1);
    }

    static /* synthetic */ int access$4200(GroupDetailFragment r0) {
        return r0.mCurEditState;
    }

    static /* synthetic */ void access$4300(GroupDetailFragment r0, ArrayList r1) {
        r0.triggerNumberEmailLoad(r1);
    }

    static /* synthetic */ boolean access$4402(GroupDetailFragment r0, boolean r1) {
        r0.mIsLoadedNumber = r1;
        return r1;
    }

    static /* synthetic */ ArrayList access$4500(GroupDetailFragment r0) {
        return r0.mContactsToSendMessage;
    }

    static /* synthetic */ ArrayList access$4502(GroupDetailFragment r0, ArrayList r1) {
        r0.mContactsToSendMessage = r1;
        return r1;
    }

    static /* synthetic */ HashSet access$4600(GroupDetailFragment r0) {
        return r0.mPhoneIds;
    }

    static /* synthetic */ HashSet access$4602(GroupDetailFragment r0, HashSet r1) {
        r0.mPhoneIds = r1;
        return r1;
    }

    static /* synthetic */ boolean access$4700(GroupDetailFragment r0) {
        return r0.mIsClickBtnSendMessage;
    }

    static /* synthetic */ boolean access$4702(GroupDetailFragment r0, boolean r1) {
        r0.mIsClickBtnSendMessage = r1;
        return r1;
    }

    static /* synthetic */ OUIBottomActionBarTextLRHolder access$4800(GroupDetailFragment r0) {
        return r0.mBottomActionBarHolder;
    }

    static /* synthetic */ boolean access$4902(GroupDetailFragment r0, boolean r1) {
        r0.mIsLoadedEmail = r1;
        return r1;
    }

    static /* synthetic */ void access$500(GroupDetailFragment r0) {
        r0.onSendMsgButtonClicked();
    }

    static /* synthetic */ ArrayList access$5000(GroupDetailFragment r0) {
        return r0.mContactsToSendEmail;
    }

    static /* synthetic */ ArrayList access$5002(GroupDetailFragment r0, ArrayList r1) {
        r0.mContactsToSendEmail = r1;
        return r1;
    }

    static /* synthetic */ HashSet access$5100(GroupDetailFragment r0) {
        return r0.mEmailIds;
    }

    static /* synthetic */ HashSet access$5102(GroupDetailFragment r0, HashSet r1) {
        r0.mEmailIds = r1;
        return r1;
    }

    static /* synthetic */ SendGroupAdapter access$5200(GroupDetailFragment r0) {
        return r0.mSendEmailAdapter;
    }

    static /* synthetic */ SendGroupAdapter access$5202(GroupDetailFragment r0, SendGroupAdapter r1) {
        r0.mSendEmailAdapter = r1;
        return r1;
    }

    static /* synthetic */ boolean access$5300(GroupDetailFragment r0) {
        return r0.mIsClickBtnSendEmail;
    }

    static /* synthetic */ boolean access$5302(GroupDetailFragment r0, boolean r1) {
        r0.mIsClickBtnSendEmail = r1;
        return r1;
    }

    static /* synthetic */ boolean access$5400(GroupDetailFragment r0, AdapterView r1, View r2, int r3, long r4, int r6, int r7) {
        return r0.handleSidebarEvent(r1, r2, r3, r4, r6, r7);
    }

    static /* synthetic */ FrameLayout access$5500(GroupDetailFragment r0) {
        return r0.mBottomBarFrame;
    }

    static /* synthetic */ ObricBottomDeleteBarView access$5600(GroupDetailFragment r0) {
        return r0.mBottomDeleteBar;
    }

    static /* synthetic */ void access$600(GroupDetailFragment r0) {
        r0.onSendMailButtonClicked();
    }

    static /* synthetic */ void access$700(GroupDetailFragment r0) {
        r0.onClickBtnAdd();
    }

    static /* synthetic */ void access$800(GroupDetailFragment r0) {
        r0.onClickBtnEdit();
    }

    static /* synthetic */ void access$900(GroupDetailFragment r0) {
        r0.clickOnSelectAll();
    }

    static {
        sLongMeneItems = new LongMenuHelper.MenuType[]{LongMenuHelper.MenuType.MENU_PHONE, LongMenuHelper.MenuType.MENU_PHONE1, LongMenuHelper.MenuType.MENU_PHONE2, LongMenuHelper.MenuType.MENU_MESSAGE, LongMenuHelper.MenuType.MENU_STAR, LongMenuHelper.MenuType.MENU_WECHAT};
    }

    public void showVoiceSearchBtn() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        View r0 = getActivity().findViewById(R.id.voice_search);
        if (r0 != null) goto L9;
        return;
    L9:
        if (isResumed() == true) goto L11;
        return;
    L11:
        if (this.mIsEditMode == false) goto L13;
        return;
    L13:
        if (ContactsUtils.hasContacts() == false) goto L18;
        r0.setEnabled(true);
        AnimationUtil.showVoiceBtnWithAnimation(r0);
        return;
    }

    private void hideVoiceSearchBtn() {
        this.mHandler.removeCallbacks(this.mScrollIdle);
        if (getActivity() != null) goto L5;
        return;
    L5:
        View r2 = getActivity().findViewById(R.id.voice_search);
        if (r2 == null) goto L9;
        r2.setEnabled(false);
        AnimationUtil.hideVoiceBtnWithAnimation(r2);
        return;
    }

    public void setPrefsCallback(PreferencesCallback r1) {
        this.mPrefsCallback = r1;
    }

    public GroupDetailFragment() {
        this.mGroupUri = null;
        this.mGroupId = -1;
        this.ACCOUNTTYPE = "ACCOUNTTYPE";
        this.ACCOUNTNAME = "ACCOUNTNAME";
        this.mGroupBrowse = new HashMap();
        this.mIsEditMode = false;
        this.mIsUsedMode = false;
        this.mContactsToSendMessage = new ArrayList();
        this.mPhoneIds = new HashSet();
        this.mContactsToSendEmail = new ArrayList();
        this.mEmailIds = new HashSet();
        this.mCurEditState = 0;
        this.mIsLoadedNumber = false;
        this.mIsClickBtnSendMessage = false;
        this.mIsLoadedEmail = false;
        this.mIsClickBtnSendEmail = false;
        this.mIsLoadGroup = false;
        this.mListAnimator = new ListAnimator(new int[]{R.id.common_avatar_layout, R.id.title_container}, new int[0], new int[]{R.id.common_check_box});
        this.mHandler = new Handler();
        this.mGroupMemberList = new ArrayList();
        this.mVoiceBtnCallBack = new AnonymousClass1(this);
        this.mNavigationBarObserver = new AnonymousClass2(this);
        this.mViewCache = new LinkedList();
        this.mQuitCacheLayoutThread = false;
        this.mQBListener = new AnonymousClass16(this);
        this.mSurnameListener = new AnonymousClass17(this);
        this.mSlideListener = new AnonymousClass18(this);
        this.mIsRemovingContacts = false;
        this.mGroupMetadataLoaderListener = new AnonymousClass23(this);
        this.mGroupMemberListLoaderListener = new AnonymousClass24(this);
        this.mScrollIdle = new AnonymousClass25(this);
        this.mItemLongClickedListener = new AnonymousClass26(this);
        this.mBottomDeleteLayoutListener = new AnonymousClass27(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context r2) {
        super.onAttach(r2);
        this.mContext = getActivity();
        ContactTileAdapter r3 = new ContactTileAdapter(this);
        this.mAdapter = r3;
        r3.setVoiceButtonCallBack(this.mVoiceBtnCallBack);
        configurePhotoLoader();
        startCacheLayout();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.android.contacts.group.GroupDetailFragment$3] */
    private void startCacheLayout() {
        final LayoutInflater r0 = LayoutInflater.from(this.mContext);
        new AnonymousClass3(this, r0).start();
    }

    public View getLayoutCache() {
        if (this.mViewCache.isEmpty() == false) goto L7;
        return null;
    L7:
        return this.mViewCache.pop();
    }

    private void quitCacheLayoutThread() {
        this.mQuitCacheLayoutThread = true;
        notifyBuildLayoutCache();
    }

    private void notifyBuildLayoutCache() {
        LinkedList<View> r0 = this.mViewCache;
        monitor-enter(r0);
        this.mViewCache.notify();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        quitCacheLayoutThread();
        this.mContext = null;
    }

    public void setCancelEditMode() {
        this.mBottomDeleteLayoutListener.startTransition(false);
        this.mBottomDeleteLayoutListener.setLayoutVisible(false);
        setCancelEditMode(true);
    }

    public void setCancelEditMode(boolean r7) {
        int r0 = this.mCurEditState;
        int r1 = 2;
        int r2 = 8;
        if (r0 != 1) goto L5;
        this.mAdapter.getSelectedContactIds().clear();
        setSize(0);
        this.mBottomActionBarHolder.getBottomActionBar().setVisibility(0);
        this.mEditFrame.setVisibility(8);
        if (r7 == false) goto L28;
        editAnimation(false);
    L29:
        this.mFloatingTitleBarHolder.startButtonToState("STATE_NORMAL");
        ContactTileAdapter r8 = this.mAdapter;
        if (r8 != null) goto L32;
    L35:
        boolean r9 = true;
    L36:
        if (r9 == false) goto L38;
        r1 = 1;
    L38:
        showStateTo(r1);
        setEditState(0);
        showVoiceSearchBtnWithDealyed(200);
        this.mMemberListView.setScrollEnabled(true);
        return;
    L32:
        if (r8.getCount() == 0) goto L35;
        r9 = false;
        goto L36
    L28:
        cancelEditWithoutAnim();
        this.mAdapter.setEditMode(false);
        goto L29
    L5:
        if (r0 != 2) goto L7;
        this.mSendMessageAdapter.getSecletedContacts().clear();
        setSize(0);
        this.mBottomActionBarHolder.getBottomActionBar().setVisibility(0);
        this.mEditFrame.setVisibility(8);
        this.mMemberListView.setAdapter(this.mAdapter);
        if (this.mAdapter.getCount() < 30) goto L20;
        boolean r10 = true;
    L21:
        OIndexScrollbar r3 = this.mQuickBar;
        if (r10 == false) goto L24;
        r2 = 0;
    L24:
        r3.setVisibility(r2);
        goto L29
    L20:
        r10 = false;
        goto L21
    L7:
        if (r0 != 3) goto L29;
        this.mSendEmailAdapter.getSecletedContacts().clear();
        setSize(0);
        this.mBottomActionBarHolder.getBottomActionBar().setVisibility(0);
        this.mEditFrame.setVisibility(8);
        this.mMemberListView.setAdapter(this.mAdapter);
        if (this.mAdapter.getCount() < 30) goto L12;
        boolean r11 = true;
    L13:
        OIndexScrollbar r4 = this.mQuickBar;
        if (r11 == false) goto L16;
        r2 = 0;
    L16:
        r4.setVisibility(r2);
        goto L29
    L12:
        r11 = false;
        goto L13
    }

    private void showVoiceSearchBtnWithDealyed(long r3) {
        this.mHandler.postDelayed(new AnonymousClass4(this), r3);
    }

    private void setEditState(int r4) {
        this.mCurEditState = r4;
        this.mQuickBar.hideLetterGrid();
        boolean r0 = false;
        if (r4 != 0) goto L5;
        this.mMemberListView.setSlideEnable(false);
        this.mIsUsedMode = false;
        this.mIsEditMode = false;
        this.mPhotoManager.resume();
        this.mBlacklistManager.resume();
        return;
    L5:
        if (r4 != 1) goto L7;
        r0 = true;
    L12:
        this.mMemberListView.setSlideEnable(true);
        this.mIsEditMode = true;
        this.mIsUsedMode = true;
        this.mPhotoManager.pause();
        this.mBlacklistManager.pause();
        if (r0 == true) goto L17;
        hideVoiceSearchBtn();
        return;
    L17:
        return;
    L7:
        if (r4 == 2) goto L12;
        if (r4 == 3) goto L12;
    }

    public boolean isEditMode() {
        if (this.mCurEditState == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.contacts.AbstractFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.mSidebarDragHelper = SidebarDragHelper.getInstance(getActivity());
        setupLongMenu();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        setHasOptionsMenu(true);
        if (getActivity() != null) goto L5;
        return null;
    L5:
        View r10 = r7.inflate(R.layout.group_detail_fragment, r8, false);
        this.mRootView = r10;
        this.mOptionBar = r10.findViewById(R.id.search_or_option_bar);
        this.mBottomBarFrame = (FrameLayout) this.mRootView.findViewById(R.id.bottom_bar_frame);
        ObricBottomDeleteBarView r11 = (ObricBottomDeleteBarView) this.mRootView.findViewById(R.id.bottom_delete_bar);
        this.mBottomDeleteBar = r11;
        r11.getDeleteBtn().setOnClickListener(new AnonymousClass5(this));
        OUIBottomActionBarTextLRHolder r12 = new OUIBottomActionBarTextLRHolder((OBottomActionBarFloating) this.mRootView.findViewById(R.id.bottom_action_bar), getString(R.string.btn_sendmessage), getString(R.string.btn_sendemail));
        this.mBottomActionBarHolder = r12;
        r12.getLeftBtn().setOnClickListener(new AnonymousClass6(this));
        this.mBottomActionBarHolder.getRightBtn().setOnClickListener(new AnonymousClass7(this));
        this.mEditFrame = (RelativeLayout) this.mRootView.findViewById(R.id.frame_edit);
        this.mGroupOptionBarTitle = (TextView) this.mRootView.findViewById(R.id.group_option_title);
        this.mGroupSize = (TextView) this.mRootView.findViewById(R.id.group_size);
        OCheckBox r13 = (OCheckBox) this.mRootView.findViewById(R.id.checkBox);
        this.mCheckBox = r13;
        r13.setOnClickListener(this);
        View r14 = this.mRootView.findViewById(android.R.id.empty);
        this.mEmptyView = r14;
        OPageStatus r15 = (OPageStatus) r14.findViewById(R.id.black_view);
        this.mBvEmpty = r15;
        r15.setTitle(getString(R.string.group_empty));
        this.mBvEmpty.setMessage(getString(R.string.group_empty_secondary));
        this.secondaryHintTextView = this.mBvEmpty.getMessageView();
        this.mEmptyView.setOnClickListener(this);
        SlideListView r16 = (SlideListView) this.mRootView.findViewById(android.R.id.list);
        this.mMemberListView = r16;
        r16.setOnScrollListener(this);
        this.mMemberListView.setSlideListener(this.mSlideListener);
        this.mMemberListView.setEmptyView(this.mEmptyView);
        ForceTouchController r17 = new ForceTouchController(this.mMemberListView, getActivity());
        this.mForceTouchController = r17;
        this.mMemberListView.setOnTouchListener(r17);
        OIndexScrollbar r18 = (OIndexScrollbar) this.mRootView.findViewById(R.id.quickbar);
        this.mQuickBar = r18;
        r18.setQBListener(this.mQBListener);
        this.mQuickBar.setSurnameListener(this.mSurnameListener);
        this.mQuickBar.setOnTouchListener(new AnonymousClass8(this));
        this.mAdapter.setQuickContactListener(this.mMemberListView);
        this.mAdapter.setQuickBar(this.mQuickBar);
        QuickContactClickedView r19 = (QuickContactClickedView) this.mRootView.findViewById(R.id.quickcontactclickedview);
        this.mQuickContactClickedView = r19;
        this.mMemberListView.setQuickContactClickedView(r19);
        this.mMemberListView.setQuickBar(this.mQuickBar);
        OFloatingTitleBarHolder r20 = new OFloatingTitleBarHolder((OFloatingTitleBar) this.mRootView.findViewById(R.id.group_detail_title_bar));
        this.mFloatingTitleBarHolder = r20;
        r20.addStartAction("STATE_NORMAL", R.drawable.icon_back_22_22, new AnonymousClass9(this));
        this.mFloatingTitleBarHolder.addEndAction("STATE_NORMAL", R.drawable.standard_icon_common_add_selector, new AnonymousClass10(this));
        this.mButtonEdit = this.mFloatingTitleBarHolder.addEndAction("STATE_NORMAL", R.drawable.standard_icon_multi_select_selector, new AnonymousClass11(this));
        OTextView r21 = (OTextView) ((ViewGroup) this.mFloatingTitleBarHolder.addEndAction(STATE_SELECT, getResources().getString(R.string.select_all), new AnonymousClass12(this))).getChildAt(0);
        this.mSelectTextView = r21;
        r21.setTextColor(ResourcesCompat.getColor(getResources(), R.color.oui_functional_blue_6, null));
        this.mSelectAllState = new SelectAllState(this.mSelectTextView);
        View r22 = this.mFloatingTitleBarHolder.addEndAction("STATE_SEND", getResources().getString(R.string.send), new AnonymousClass13(this));
        this.mBtnSend = r22;
        r22.setContentDescription(getString(R.string.send));
        ((OTextView) ((ViewGroup) this.mBtnSend).getChildAt(0)).setTextColor(ResourcesCompat.getColor(getResources(), R.color.oui_functional_blue_6, null));
        ((OTextView) ((ViewGroup) this.mFloatingTitleBarHolder.addEndAction(STATE_REMOVE, getResources().getString(R.string.btn_remove), new AnonymousClass14(this))).getChildAt(0)).setTextColor(ResourcesCompat.getColor(getResources(), R.color.oui_functional_red_6, null));
        this.mFloatingTitleBarHolder.addStartAction("STATE_CANCEL", R.drawable.icon_cancel_22_22, new AnonymousClass15(this));
        this.mFloatingTitleBarHolder.startButtonToState("STATE_NORMAL");
        this.mFloatingTitleBarHolder.endButtonToState("STATE_NORMAL");
        this.mAdapter.setQuickContactListener(this.mMemberListView);
        this.mMemberListView.setAdapter(this.mAdapter);
        this.mForceTouchController.setAdapter(this.mAdapter);
        this.mAdapter.setOnLongClickListener(this.mItemLongClickedListener);
        Immersive.Companion.getImmersive(getActivity()).getNavigationBarHeight().observeForever(this.mNavigationBarObserver);
        OUIHelper.OUIList.setFooter(getLayoutInflater(), this.mMemberListView, null);
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mHandler.removeCallbacksAndMessages(null);
        ContactTileAdapter r0 = this.mAdapter;
        if (r0 == null) goto L5;
        r0.setVoiceButtonCallBack(null);
    L5:
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L9;
        Immersive.Companion.getImmersive(r1).getNavigationBarHeight().removeObserver(this.mNavigationBarObserver);
        return;
    }

    public QuickContactListener getQuickContactListener() {
        return this.mMemberListView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mGroupUri == null) goto L6;
        startGroupMetadataLoader();
        return;
    }

    public void send() {
        int r0 = this.mCurEditState;
        if (r0 != 2) goto L5;
        setSendMessage();
        return;
    L5:
        if (r0 != 3) goto L11;
        setSendEmail();
        return;
    }

    public void back() {
        if (this.mIsEditMode == false) goto L11;
        setCancelEditMode();
        OIndexScrollbar r0 = this.mQuickBar;
        if (r0 == null) goto L7;
        r0.hideLetterGrid();
    L7:
        cancelLoad();
        this.mMemberListView.setSelection(0);
        stopGroupMetadataLoader();
        if (getQuickContactListener().isShowQuickContact() == false) goto L14;
        getQuickContactListener().hideQuickContact();
        return;
    L14:
        return;
    L11:
        if (getActivity() == null) goto L16;
        getActivity().finish();
        return;
    }

    private void clickOnSelectAll() {
        if (this.mGroupId != (-1)) goto L5;
        return;
    L5:
        int r0 = this.mCurEditState;
        if (r0 == 1) goto L21;
        if (r0 == 2) goto L17;
        if (r0 == 3) goto L13;
        return;
    L13:
        if (this.mSendEmailAdapter.getSecletedContacts().size() != this.mSendEmailAdapter.getCount()) goto L15;
        this.mSendEmailAdapter.setSecletAll(false);
        this.mCheckBox.setChecked(false);
        return;
    L15:
        this.mSendEmailAdapter.setSecletAll(true);
        this.mCheckBox.setChecked(true);
        return;
    L17:
        if (this.mSendMessageAdapter.getSecletedContacts().size() != this.mSendMessageAdapter.getCount()) goto L19;
        this.mSendMessageAdapter.setSecletAll(false);
        this.mCheckBox.setChecked(false);
        return;
    L19:
        this.mSendMessageAdapter.setSecletAll(true);
        this.mCheckBox.setChecked(true);
        return;
    L21:
        if (this.mAdapter.getSelectedContactIds().size() != this.mAdapter.getCount()) goto L23;
        this.mAdapter.setSecletAll(false);
        return;
    L23:
        this.mAdapter.setSecletAll(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (r3.getId() != R.id.checkBox) goto L5;
        clickOnSelectAll();
        return;
    L5:
        r3.getId();
    }

    private void onClickBtnEdit() {
        if (isEditMode() == false) goto L5;
        return;
    L5:
        this.mIsClickBtnSendMessage = false;
        this.mIsClickBtnSendEmail = false;
        setEditState(1);
        this.mSelectAllState.setSelectAll(false);
        this.mFloatingTitleBarHolder.startButtonToState("STATE_CANCEL");
        showStateTo(1);
        this.mEditFrame.setVisibility(0);
        this.mBottomDeleteLayoutListener.startTransition(true);
        this.mBottomDeleteLayoutListener.setLayoutVisible(true);
        this.mBottomActionBarHolder.getBottomActionBar().setVisibility(8);
        updateTitle(getResources().getString(R.string.label_members_chosen));
        updateSize(this.mAdapter.getCount(), 0);
        editAnimation(true);
        this.mMemberListView.restoreScrollState(false);
        this.mMemberListView.setScrollEnabled(false);
    }

    private void onClickBtnAdd() {
        if (this.mGroupUri != null) goto L5;
        return;
    L5:
        Intent r0 = new Intent(getActivity(), ContactSelectionActivity.class);
        r0.setAction("com.android.contacts.action.GET_MULTIPLE_PHONES");
        r0.setType("vnd.android.cursor.dir/raw_contact");
        ArrayList r1 = new ArrayList();
        int r2 = 0;
    L7:
        if (r2 >= this.mAdapter.getCount()) goto L10;
        r1.add(Long.valueOf(this.mAdapter.getItem(r2).rawContactId));
        r2 = r2 + 1;
        goto L7
    L10:
        if (r1.size() <= 0) goto L12;
        r0.putExtra("com.android.contacts.extra.PHONE_IDS", r1);
    L12:
        r0.putExtra(this.ACCOUNTNAME, this.mAccountName);
        r0.putExtra(this.ACCOUNTTYPE, this.mAccountType);
        r0.putExtra("enter_from", "group_detail");
        startActivityForResult(r0, 1000);
        AnimationUtil.switchActivityAnimation(getActivity(), 1);
    }

    private void onSendMailButtonClicked() {
        if (isEditMode() == false) goto L6;
        return;
    L6:
        if (this.mIsClickBtnSendMessage == false) goto L8;
        return;
    L8:
        if (this.mIsLoadedEmail == true) goto L10;
    L20:
        this.mBottomActionBarHolder.getRightBtn().setTitle(R.string.common_loading);
        this.mIsClickBtnSendEmail = true;
        return;
    L10:
        if (this.mIsClickBtnSendEmail == true) goto L20;
        SendGroupAdapter r0 = this.mSendEmailAdapter;
        if (r0 != null) goto L15;
    L18:
        ContactsApplication.showToast(R.string.group_empty_email, 1);
        return;
    L15:
        if (r0.getCount() == 0) goto L18;
        setSendEmailMode();
        this.mMemberListView.restoreScrollState(false);
        this.mMemberListView.setScrollEnabled(false);
    }

    private void onSendMsgButtonClicked() {
        if (isEditMode() == false) goto L6;
        return;
    L6:
        if (this.mIsClickBtnSendEmail == false) goto L8;
        return;
    L8:
        if (this.mIsLoadedNumber == true) goto L10;
    L20:
        this.mBottomActionBarHolder.getLeftBtn().setTitle(R.string.common_loading);
        this.mIsClickBtnSendMessage = true;
        return;
    L10:
        if (this.mIsClickBtnSendMessage == true) goto L20;
        SendGroupAdapter r0 = this.mSendMessageAdapter;
        if (r0 != null) goto L15;
    L18:
        ContactsApplication.showToast(R.string.group_empty_sms, 1);
        return;
    L15:
        if (r0.getCount() == 0) goto L18;
        setSendMessageMode();
        this.mMemberListView.restoreScrollState(false);
        this.mMemberListView.setScrollEnabled(false);
    }

    public void groupSaveCompleted() {
        this.mIsRemovingContacts = false;
        startGroupMetadataLoader();
    }

    private void showDeleteGroupMembersDialog() {
        if (this.mAdapter.getSelectedContactIds().size() != 0) goto L5;
        return;
    L5:
        String r2 = getString(R.string.sheet_title_remove_group_number);
        String r4 = getString(R.string.common_ok);
        DialogInterface.OnClickListener r5 = new AnonymousClass19(this);
        String r7 = getString(R.string.common_cancel);
        DialogInterface.OnClickListener r8 = new AnonymousClass20(this);
        OAlertDialog r0 = OAlertDialogUtils.showConfirmationDialog(this.mContext, r2, null, r4, r5, ButtonStyleController.TextColorType.Negative, r7, r8, null);
        this.mDeleteDialog = r0;
        r0.setCanceledOnTouchOutside(true);
    }

    private void doRemoveAction() {
        HashSet r0 = new HashSet(this.mAdapter.getSelectedContactIds());
        int r1 = r0.size();
        if (r1 != 0) goto L5;
        return;
    L5:
        ArrayList<Integer> r2 = new ArrayList(r1);
        ArrayList<Integer> r3 = new ArrayList(r1);
        final ArrayList r4 = (ArrayList) this.mGroupMemberList.clone();
        Iterator r5 = r4.iterator();
        int r6 = 0;
    L7:
        if (r5.hasNext() == false) goto L13;
        if (r0.contains(Long.valueOf(((ContactTileAdapter.ContactEntry) r5.next()).rawContactId)) == false) goto L11;
        r2.add(Integer.valueOf(r6));
        r5.remove();
    L12:
        r6 = r6 + 1;
        goto L7
    L11:
        r3.add(Integer.valueOf(r6));
        goto L12
    L13:
        final SlideListView r7 = this.mMemberListView;
        new AnonymousClass21(this, r7, r4).setResultListSize(r4.size()).start(r2, r3);
    }

    public void setSendMessageMode() {
        setEditState(2);
        int r1 = 0;
        this.mEditFrame.setVisibility(0);
        this.mBottomActionBarHolder.getBottomActionBar().setVisibility(8);
        this.mFloatingTitleBarHolder.startButtonToState("STATE_CANCEL");
        showStateTo(4);
        updateTitle(getResources().getString(R.string.label_addressee_to_sendmessage));
        this.mMemberListView.setAdapter(this.mSendMessageAdapter);
        this.mMemberListView.setOnScrollStateChangeListener(null);
        boolean r3 = true;
        this.mSendMessageAdapter.setSecletAll(true);
        if (this.mSendMessageAdapter.getCount() >= 30) goto L6;
        r3 = false;
    L6:
        OIndexScrollbar r0 = this.mQuickBar;
        if (r3 == true) goto L10;
        r1 = 8;
    L10:
        r0.setVisibility(r1);
        if (getQuickContactListener().isShowQuickContact() == false) goto L14;
        getQuickContactListener().hideQuickContact();
        return;
    }

    public void setSendEmailMode() {
        setEditState(3);
        int r1 = 0;
        this.mEditFrame.setVisibility(0);
        this.mBottomActionBarHolder.getBottomActionBar().setVisibility(8);
        this.mFloatingTitleBarHolder.startButtonToState("STATE_CANCEL");
        showStateTo(4);
        updateTitle(getResources().getString(R.string.label_addressee_to_sendemail));
        this.mMemberListView.setAdapter(this.mSendEmailAdapter);
        this.mMemberListView.setOnScrollStateChangeListener(null);
        boolean r3 = true;
        this.mSendEmailAdapter.setSecletAll(true);
        if (this.mSendEmailAdapter.getCount() >= 30) goto L6;
        r3 = false;
    L6:
        OIndexScrollbar r0 = this.mQuickBar;
        if (r3 == true) goto L10;
        r1 = 8;
    L10:
        r0.setVisibility(r1);
        if (getQuickContactListener().isShowQuickContact() == false) goto L14;
        getQuickContactListener().hideQuickContact();
        return;
    }

    public void setSendMessage() {
        if (this.mSendMessageAdapter.getSecletedContacts().size() <= 0) goto L6;
        new Thread(new AnonymousClass22(this)).start();
        return;
    }

    public boolean isUsed() {
        return this.mIsUsedMode;
    }

    public void setSendEmail() {
        if (this.mSendEmailAdapter.getSecletedContacts().size() <= 0) goto L25;
        Iterator<Long> r0 = this.mSendEmailAdapter.getSecletedContacts().keySet().iterator();
        String r2 = "";
        int r3 = 0;
    L6:
        if (r3 >= this.mSendEmailAdapter.getSecletedContacts().size()) goto L10;
        if (r3 == 0) goto L9;
        r2 = r2 + ";";
    L9:
        r2 = r2 + this.mSendEmailAdapter.getSecletedContacts().get(r0.next());
        r3 = r3 + 1;
        goto L6
    L10:
        Intent r1 = new Intent("android.intent.action.SEND");
        if (TextUtils.isEmpty(r2) == false) goto L13;
        String[] r4 = null;
    L14:
        r1.putExtra("android.intent.extra.EMAIL", r4);
        r1.setType("message/rfc822");
        r1.setPackage(Constants.EMAIL_PACKAGE_NAME);
        r1.putExtra(IntentSmt.get_EXTRA_BYTEDANCE_ANIM_RESOURCE_ID(), new int[]{0, R.anim.slide_down_out});     // Catch: Exception -> L17
        startActivity(r1);     // Catch: Exception -> L17
    L18:
        setCancelEditMode();
        return;
    L17:
        ContactsApplication.showToast(R.string.bind_accound, 0);
        goto L18
    L13:
        r4 = r2.split(";");
        goto L14
    }

    public void setSize(int r5) {
        int r0 = this.mCurEditState;
        if (r0 == 1) goto L26;
        if (r0 != 2) goto L7;
        SendGroupAdapter r1 = this.mSendMessageAdapter;
        if (r1 != null) goto L20;
        return;
    L20:
        if (r1.getCount() != r5) goto L23;
        if (r5 <= 0) goto L23;
        this.mCheckBox.setChecked(true);
    L24:
        updateSize(this.mSendMessageAdapter.getCount(), r5);
        return;
    L23:
        this.mCheckBox.setChecked(false);
        goto L24
    L7:
        if (r0 != 3) goto L36;
        SendGroupAdapter r2 = this.mSendEmailAdapter;
        if (r2 != null) goto L12;
        return;
    L12:
        if (r2.getCount() != r5) goto L15;
        if (r5 <= 0) goto L15;
        this.mCheckBox.setChecked(true);
    L16:
        updateSize(this.mSendEmailAdapter.getCount(), r5);
        return;
    L15:
        this.mCheckBox.setChecked(false);
        goto L16
    L36:
        return;
    L26:
        if (this.mAdapter.getCount() != r5) goto L29;
        if (r5 <= 0) goto L29;
        this.mCheckBox.setChecked(true);
    L30:
        updateSize(this.mAdapter.getCount(), r5);
        return;
    L29:
        this.mCheckBox.setChecked(false);
        goto L30
    }

    public void loadGroup(Uri r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.mIsLoadGroup = true;
        log("GroupDetailFragment loadGroup(" + r4 + ")");
        if (r4.equals(this.mGroupUri) == true) goto L15;
        this.mSendEmailAdapter = null;
        this.mSendMessageAdapter = null;
        if (r4.getBooleanQueryParameter(GroupListItem.URI_KEY_IS_UNGROUPED, false) == false) goto L11;
        this.mIsUngrouped = true;
        this.mAccountName = r4.getQueryParameter(GroupListItem.URI_KEY_ACCOUNT_NAME);
        this.mAccountType = r4.getQueryParameter(GroupListItem.URI_KEY_ACCOUNT_TYPE);
        TextView r0 = this.secondaryHintTextView;
        if (r0 == null) goto L14;
        r0.setText("");
        this.secondaryHintTextView.setVisibility(8);
    L14:
        this.mGroupUri = r4;
        goto L15
    L11:
        this.mIsUngrouped = false;
        TextView r1 = this.secondaryHintTextView;
        if (r1 == null) goto L14;
        r1.setVisibility(0);
        this.secondaryHintTextView.setText(getResources().getString(R.string.group_empty_secondary));
    L15:
        Agent.getInstance().onAttach(TAG);
        startGroupMetadataLoader();
    }

    private void configurePhotoLoader() {
        Context r0 = this.mContext;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mPhotoManager != null) goto L7;
        this.mPhotoManager = ContactPhotoManager.getInstance(r0);
    L7:
        ContactTileAdapter r1 = this.mAdapter;
        if (r1 == null) goto L11;
        r1.setPhotoLoader(this.mPhotoManager);
    L11:
        if (this.mBlacklistManager != null) goto L15;
        this.mBlacklistManager = BlacklistManager.getInstances(this.mContext);
        return;
    }

    private void startGroupMetadataLoader() {
        if (this.mIsUngrouped == true) goto L5;
        getLoaderManager().restartLoader(0, null, this.mGroupMetadataLoaderListener);
        return;
    L5:
        bindGroupMetaData(null);
        startGroupMembersLoader();
    }

    private void stopGroupMetadataLoader() {
        getLoaderManager().destroyLoader(0);
        getLoaderManager().destroyLoader(1);
    }

    private void startGroupMembersLoader() {
        getLoaderManager().restartLoader(1, null, this.mGroupMemberListLoaderListener);
    }

    private void updateUI(int r7) {
        boolean r0 = true;
        int r1 = 0;
        if (r7 != 0) goto L5;
        boolean r2 = true;
    L6:
        RelativeLayout r3 = this.mEditFrame;
        if (r2 == false) goto L9;
    L12:
        int r5 = 8;
    L13:
        r3.setVisibility(r5);
        OBottomActionBarFloating r4 = this.mBottomActionBarHolder.getBottomActionBar();
        if (r2 == false) goto L16;
    L21:
        int r6 = 8;
    L22:
        r4.setVisibility(r6);
        View r8 = this.mOptionBar;
        if (r2 == false) goto L25;
    L28:
        int r9 = 8;
    L29:
        r8.setVisibility(r9);
        updateButtonsVisibility(r2);
        if (r7 >= 30) goto L33;
        r0 = false;
    L33:
        OIndexScrollbar r10 = this.mQuickBar;
        if (r0 == true) goto L36;
    L38:
        r1 = 8;
    L39:
        r10.setVisibility(r1);
        return;
    L36:
        if (this.mMemberListView.isStateIdle() == false) goto L38;
    L25:
        if (this.mIsUngrouped == true) goto L28;
        r9 = 0;
        goto L29
    L16:
        if (this.mIsUngrouped == true) goto L21;
        if (this.mIsEditMode == true) goto L21;
        r6 = 0;
        goto L22
    L9:
        if (this.mIsEditMode == false) goto L12;
        r5 = 0;
        goto L13
    L5:
        r2 = false;
        goto L6
    }

    public boolean setMemberListSelection(String r7, int r8) {
        LetterMatcher r0 = LetterMatcher.getInstance();
        int r1 = this.mCurEditState;
        if (r1 != 2) goto L20;
        SendGroupAdapter r2 = this.mSendMessageAdapter;
        if (r2 != null) goto L8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "mSendMessageAdapter is null, The Letter should disable");
        return true;
    L8:
        List<SamContact> r3 = r2.getContactsList();
        int r4 = 0;
    L10:
        if (r4 >= r3.size()) goto L50;
        if (r0.match(r3.get(r4), r7, r8) == true) goto L14;
        r4 = r4 + 1;
        goto L10
    L14:
        if (this.mMemberListView.isShowQuickContact() == false) goto L16;
        this.mMemberListView.hideQuickContact();
    L16:
        this.mMemberListView.setSelectionFromTop(r4, 0);
        return true;
    L50:
        return false;
    L20:
        if (r1 != 3) goto L37;
        SendGroupAdapter r5 = this.mSendEmailAdapter;
        if (r5 != null) goto L25;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "mSendEmailAdapter is null, The Letter should disable");
        return true;
    L25:
        List<SamContact> r6 = r5.getContactsList();
        int r9 = 0;
    L27:
        if (r9 >= r6.size()) goto L50;
        if (r0.match(r6.get(r9), r7, r8) == true) goto L31;
        r9 = r9 + 1;
        goto L27
    L31:
        if (this.mMemberListView.isShowQuickContact() == false) goto L33;
        this.mMemberListView.hideQuickContact();
    L33:
        this.mMemberListView.setSelectionFromTop(r9, 0);
        return true;
    L37:
        if (this.mAdapter != null) goto L40;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "mNorAdapter is null, The Letter should disable");
        return true;
    L40:
        int r10 = this.mGroupMemberList.size();
        int r11 = 0;
    L41:
        if (r11 >= r10) goto L50;
        if (r0.match(this.mGroupMemberList.get(r11), r7, r8) == true) goto L45;
        r11 = r11 + 1;
        goto L41
    L45:
        if (this.mMemberListView.isShowQuickContact() == false) goto L47;
        this.mMemberListView.hideQuickContact();
    L47:
        this.mMemberListView.setSelectionFromTop(r11, 0);
        return true;
    }

    private void updateButtonsVisibility(boolean r5) {
        if (this.mIsUngrouped == false) goto L6;
        showStateTo(5);
        return;
    L6:
        boolean r1 = false;
        if (r5 == false) goto L9;
        this.mButtonEdit.setEnabled(false);
        showStateTo(2);
        return;
    L9:
        int r2 = 1;
        this.mButtonEdit.setEnabled(true);
        if (this.mIsEditMode == true) goto L13;
        showStateTo(2);
        return;
    L13:
        int r6 = this.mCurEditState;
        if (r6 == 1) goto L19;
        if (r6 == 2) goto L18;
        if (r6 == 3) goto L18;
        return;
    L18:
        showStateTo(4);
        return;
    L19:
        ListAdapter r7 = this.mMemberListView.getAdapter();
        if (r7 != null) goto L22;
    L24:
        if (r7 != null) goto L26;
    L30:
        if (r1 == false) goto L32;
        r2 = 3;
    L32:
        showStateTo(r2);
        return;
    L26:
        if ((r7 instanceof ContactTileAdapter) == false) goto L30;
        if (((ContactTileAdapter) r7).getSelectedContactIds().size() <= 0) goto L30;
        r1 = true;
        goto L30
    L22:
        if ((r7 instanceof HeaderViewListAdapter) == false) goto L24;
        r7 = ((HeaderViewListAdapter) r7).getWrappedAdapter();
        goto L24
    }

    private void showStateTo(int r3) {
        if (r3 != 1) goto L5;
        this.mFloatingTitleBarHolder.endButtonToState(STATE_SELECT);
        this.mBottomDeleteLayoutListener.setBottomBtnEnable(false);
        return;
    L5:
        if (r3 != 2) goto L7;
        this.mFloatingTitleBarHolder.endButtonToState("STATE_NORMAL");
        return;
    L7:
        if (r3 != 3) goto L9;
        this.mBottomDeleteLayoutListener.setBottomBtnEnable(true);
        return;
    L9:
        if (r3 != 4) goto L11;
        this.mFloatingTitleBarHolder.endButtonToState("STATE_SEND");
        return;
    L11:
        if (r3 != 5) goto L23;
        this.mFloatingTitleBarHolder.endButtonToState("STATE_NONE");
        return;
    }

    private void bindGroupMetaData(Cursor r3) {
        if (this.mIsUngrouped == true) goto L7;
        r3.moveToPosition(-1);
        if (r3.moveToNext() == false) goto L9;
        this.mAccountType = r3.getString(1);
        this.mAccountName = r3.getString(0);
        this.mGroupId = r3.getLong(3);
        this.mGroupName = r3.getString(4);
        this.mFloatingTitleBarHolder.getTitleBar().setCenterTitle(this.mGroupName);
        return;
    L9:
        return;
    L7:
        this.mGroupId = -1;
        this.mGroupName = getResources().getString(R.string.contact_group_name_ungrouped);
        this.mFloatingTitleBarHolder.getTitleBar().setCenterTitle(this.mGroupName);
    }

    private void triggerMemberLoad() {
        log("triggerMemberLoad");
        LoadMemberTask r0 = this.mLoadMemberTask;
        AnonymousClass1 r1 = null;
        if (r0 != null) goto L5;
    L10:
        LoadMemberTask r2 = new LoadMemberTask(this, r1);
        this.mLoadMemberTask = r2;
        r2.execute(new Void[0]);
        return;
    L5:
        if (r0.getStatus() == AsyncTask.Status.FINISHED) goto L10;
        Runnable r3 = this.mLoadMemberRunnable;
        if (r3 == null) goto L9;
        this.mHandler.removeCallbacks(r3);
    L9:
        log("LoadMemberTask is running, delay to load again");
        LoadMemberRunnable r4 = new LoadMemberRunnable(this, r1);
        this.mLoadMemberRunnable = r4;
        this.mHandler.postDelayed(r4, 150);
    }

    private void triggerNumberEmailLoad(ArrayList<Long> r6) {
        LoadNumberTask r0 = this.mLoadNumberTask;
        if (r0 != null) goto L5;
    L7:
        AnonymousClass1 r2 = null;
        LoadNumberTask r1 = new LoadNumberTask(this, r2);
        this.mLoadNumberTask = r1;
        r1.execute(new ArrayList[]{r6});
        LoadEmailTask r3 = this.mLoadEmailTask;
        if (r3 != null) goto L10;
    L12:
        LoadEmailTask r4 = new LoadEmailTask(this, r2);
        this.mLoadEmailTask = r4;
        r4.execute(new ArrayList[]{r6});
        return;
    L10:
        if (r3.getStatus() == AsyncTask.Status.FINISHED) goto L12;
        this.mLoadEmailTask.cancel(true);
        goto L12
    L5:
        if (r0.getStatus() == AsyncTask.Status.FINISHED) goto L7;
        this.mLoadNumberTask.cancel(true);
        goto L7
    }

    private void cancelLoad() {
        this.mIsLoadedNumber = false;
        this.mIsClickBtnSendMessage = false;
        this.mIsLoadedEmail = false;
        this.mIsClickBtnSendEmail = false;
        this.mBottomActionBarHolder.getLeftBtn().setTitle(R.string.btn_sendmessage);
        this.mBottomActionBarHolder.getRightBtn().setTitle(R.string.btn_sendemail);
        LoadMemberTask r0 = this.mLoadMemberTask;
        if (r0 == null) goto L5;
        r0.cancel(true);
        this.mLoadMemberTask = null;
    L5:
        LoadNumberTask r1 = this.mLoadNumberTask;
        if (r1 == null) goto L8;
        r1.cancel(true);
        this.mLoadNumberTask = null;
    L8:
        LoadEmailTask r2 = this.mLoadEmailTask;
        if (r2 == null) goto L12;
        r2.cancel(true);
        this.mLoadEmailTask = null;
        return;
    }

    private void fastLoadMembers(Cursor r3) {
        log("fastLoadMembers");
        this.mGroupMemberList = initGroupMemberListFast(r3);
        log("initGroupMemberListFast complete ! mGroupMemberList size is " + this.mGroupMemberList.size());
        ContactTileAdapter r4 = this.mAdapter;
        ArrayList<ContactTileAdapter.ContactEntry> r0 = this.mGroupMemberList;
        boolean r1 = true;
        if (this.mCurEditState == 1) goto L6;
        r1 = false;
    L6:
        r4.setList(r0, r1);
    }

    private ArrayList<ContactTileAdapter.ContactEntry> initGroupMemberListFast(Cursor r7) {
        ArrayList<ContactTileAdapter.ContactEntry> r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        if (r7 != null) goto L5;
    L26:
        return r0;
    L5:
        if (r7.isClosed() == true) goto L26;
        int r3 = 20;
        if (r7.moveToFirst() == false) goto L17;
    L9:
        ContactTileAdapter.ContactEntry r2 = parseCursor(r7);
        if (ContactsUtils.CHAR_POUND.equals(r2.section) == false) goto L12;
        r1.add(r2);
    L16:
        if (r7.moveToNext() == true) goto L9;
    L12:
        r0.add(r2);
        r3 = r3 - 1;
        if (r3 != 0) goto L16;
    L17:
        Collections.sort(r0, new NameSortComparator());
        if (r3 <= 0) goto L26;
        if (r1.size() <= 0) goto L26;
        Collections.sort(r1, new NameSortComparator());
        int r6 = r1.size();
        List r4 = r1;
        if (r3 >= r6) goto L25;
        r4 = r1.subList(0, r3);
    L25:
        r0.addAll(r4);
        goto L26
    }

    private ArrayList<ContactTileAdapter.ContactEntry> initGroupMemberList(ArrayList<Long> r9) {
        r9.clear();
        ArrayList<ContactTileAdapter.ContactEntry> r0 = new ArrayList();
        Context r1 = this.mContext;
        if (r1 != null) goto L5;
    L33:
        return r0;
    L5:
        if (((Activity) r1).isFinishing() == true) goto L33;
        if (this.mIsUngrouped == true) goto L10;
        Uri r2 = ContactsContract.AUTHORITY_URI.buildUpon().appendPath("group_raw_members").build();
    L11:
        Uri r3 = r2;
        StringBuilder r4 = new StringBuilder();
        if (this.mIsUngrouped == true) goto L14;
        r4.append("mimetype=? AND data1=?");
    L16:
        if (this.mIsUngrouped == true) goto L18;
        String[] r5 = {"vnd.android.cursor.item/group_membership", String.valueOf(this.mGroupId)};
    L19:
        Cursor r6 = this.mContext.getContentResolver().query(r3, GroupMemberLoader.GroupDetailQuery.getProjection(this.mPrefsCallback.getDisplayOrder(), this.mPrefsCallback.getSortOrder()), r4.toString(), r5, null);
        if (r6 != null) goto L34;
    L31:
        if (r6 == null) goto L33;
        r6.close();
        goto L33
    L34:
    L27:
        th = move-exception;
        if (r6 == null) goto L30;
        r6.close();
    L30:
        throw th;
    L22:
        if (r6.moveToFirst() == false) goto L31;
    L23:
        ContactTileAdapter.ContactEntry r7 = parseCursor(r6);     // Catch: Throwable -> L27
        r9.add(Long.valueOf(r6.getLong(6)));     // Catch: Throwable -> L27
        r0.add(r7);     // Catch: Throwable -> L27
        if (r6.moveToNext() == true) goto L23;
        Collections.sort(r0, new NameSortComparator());     // Catch: Throwable -> L27
        goto L31
    L18:
        r5 = new String[]{this.mAccountName, this.mAccountType};
        goto L19
    L14:
        r4.append("account_name = ? AND account_type = ?");
        goto L16
    L10:
        r2 = ContactsContract.AUTHORITY_URI.buildUpon().appendPath("ungroup_raw_members").build();
        goto L11
    }

    private ContactTileAdapter.ContactEntry parseCursor(Cursor r10) {
        String r1 = r10.getString(1);
        String r2 = r10.getString(2);
        ContactTileAdapter.ContactEntry r3 = new ContactTileAdapter.ContactEntry();
        r3.contactId = r10.getLong(0);
        r3.status = r10.getString(5);
        String r6 = null;
        if (r1 == null) goto L5;
        Uri r4 = Uri.parse(r1);
    L6:
        r3.photoUri = r4;
        r3.lookupUri = ContentUris.withAppendedId(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, r2), r3.contactId);
        r3.rawContactId = r10.getLong(6);
        r3.photoId = r10.getLong(8);
        r3.sortkey = r10.getString(7);
        r3.section = ContactsUtils.getContactSection(r3.sortkey);
        if (r10.isNull(4) == true) goto L9;
        int r5 = r10.getInt(4);
        Drawable r7 = ContactPresenceIconUtil.getPresenceIcon(this.mContext, r5);
    L10:
        r3.presenceIcon = r7;
        if (r10.isNull(5) == true) goto L13;
        r6 = r10.getString(5);
    L13:
        if (r6 != null) goto L16;
        if (r5 == 0) goto L16;
        r6 = ContactStatusUtil.getStatusString(this.mContext, r5);
    L16:
        r3.status = r6;
        String r11 = r10.getString(3);
        if (TextUtils.isEmpty(r11) == false) goto L19;
        r3.hasname = false;
        r3.name = this.mContext.getString(R.string.missing_name);
    L20:
        return r3;
    L19:
        r3.hasname = true;
        r3.name = r11;
        goto L20
    L9:
        r5 = 0;
        r7 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public void updateContactPhone(ArrayList<Long> r9, ArrayList<SamContact> r10, HashSet<Long> r11) {
        r10.clear();
        r11.clear();
        Uri r0 = ContactsContract.RawContacts.CONTENT_URI;
        HashMap<Long, String> r1 = getRawContactNameList(r9);
        Uri r3 = ContactsContract.CommonDataKinds.Phone.CONTENT_URI.buildUpon().appendQueryParameter("directory", String.valueOf(0)).build().buildUpon().appendQueryParameter("remove_duplicate_entries", "true").build();
        Context r2 = this.mContext;
        if (r2 != null) goto L5;
        return;
    L5:
        if (((Activity) r2).isFinishing() == true) goto L16;
        Cursor r8 = this.mContext.getContentResolver().query(r3, PhoneQuery.getPhoneProjection(this.mPrefsCallback.getDisplayOrder(), this.mPrefsCallback.getSortOrder()), "raw_contact_id in (" + TextUtils.join(SimContactsConstants.EMAIL_SEP, r9) + ")", null, null);
        if (r8.moveToFirst() == false) goto L11;
    L9:
        SamContact r12 = new SamContact(0);
        r12.phoneId = r8.getLong(0);
        r11.add(Long.valueOf(r12.phoneId));
        r12.name = r1.get(Long.valueOf(r8.getLong(10)));
        r12.phone = r8.getString(3);
        r12.labelType = r8.getInt(1);
        r12.label = r8.getString(2);
        r12.sortkey = r8.getString(8);
        r12.phoneBookLabel = r8.getString(9);
        r12.section = ContactsUtils.getContactSection(r12.sortkey, r12.phoneBookLabel);
        r12.hasname = true ^ TextUtils.isEmpty(r12.name);
        r10.add(r12);
        if (r8.moveToNext() == true) goto L9;
    L11:
        r8.close();
        Collections.sort(r10, new NameSortComparator());
        return;
    }

    private HashMap<Long, String> getRawContactNameList(ArrayList<Long> r8) {
        Uri r1 = ContactsContract.RawContacts.CONTENT_URI;
        HashMap<Long, String> r6 = new HashMap();
        Context r0 = this.mContext;
        if (r0 != null) goto L5;
    L20:
        return r6;
    L5:
        if (((Activity) r0).isFinishing() == true) goto L20;
        Cursor r7 = this.mContext.getContentResolver().query(r1, RawContactNameQuery.getProjection(this.mPrefsCallback.getDisplayOrder()), "_id in (" + TextUtils.join(SimContactsConstants.EMAIL_SEP, r8) + ")", null, null);
        if (r7 != null) goto L21;
    L18:
        if (r7 == null) goto L20;
        r7.close();
        goto L20
    L21:
    L14:
        th = move-exception;
        if (r7 == null) goto L17;
        r7.close();
    L17:
        throw th;
    L10:
        if (r7.moveToFirst() == false) goto L18;
    L11:
        long r2 = r7.getLong(0);     // Catch: Throwable -> L14
        r6.put(Long.valueOf(r2), r7.getString(1));     // Catch: Throwable -> L14
        if (r7.moveToNext() == true) goto L11;
        goto L18
    }

    public void updateContactEmail(ArrayList<Long> r9, ArrayList<SamContact> r10, HashSet<Long> r11) {
        r10.clear();
        r11.clear();
        Uri r0 = ContactsContract.RawContacts.CONTENT_URI;
        HashMap<Long, String> r1 = getRawContactNameList(r9);
        Uri r3 = ContactsContract.CommonDataKinds.Email.CONTENT_URI.buildUpon().appendQueryParameter("remove_duplicate_entries", "true").build();
        Context r2 = this.mContext;
        if (r2 != null) goto L5;
        return;
    L5:
        if (((Activity) r2).isFinishing() == true) goto L19;
        Cursor r8 = this.mContext.getContentResolver().query(r3, PhoneQuery.getEmailProjection(this.mPrefsCallback.getDisplayOrder(), this.mPrefsCallback.getSortOrder()), "raw_contact_id in (" + TextUtils.join(SimContactsConstants.EMAIL_SEP, r9) + ")", null, null);
        if (r8.moveToFirst() == false) goto L14;
    L9:
        SamContact r12 = new SamContact(0);
        r12.phoneId = r8.getLong(0);
        r11.add(Long.valueOf(r12.phoneId));
        r12.name = r1.get(Long.valueOf(r8.getLong(10)));
        r12.phone = r8.getString(3);
        r12.labelType = r8.getInt(1);
        r12.label = r8.getString(2);
        r12.sortkey = r8.getString(8);
        r12.phoneBookLabel = r8.getString(9);
        r12.section = ContactsUtils.getContactSection(r12.sortkey, r12.phoneBookLabel);
        r12.hasname = true ^ TextUtils.isEmpty(r12.name);
        if (r10.contains(r12) == true) goto L13;
        r10.add(r12);
    L13:
        if (r8.moveToNext() == true) goto L9;
    L14:
        r8.close();
        Collections.sort(r10, new NameSortComparator());
        return;
    }

    private void updateTitle(String r1) {
        this.mGroupOptionBarTitle.setText(r1);
    }

    private void configUI(int r6) {
        int r0 = this.mCurEditState;
        boolean r2 = true;
        if (r0 != 1) goto L5;
        this.mFloatingTitleBarHolder.startButtonToState("STATE_CANCEL");
        if (r6 <= 0) goto L21;
        showStateTo(3);
        return;
    L21:
        showStateTo(1);
        return;
    L5:
        if (r0 == 2) goto L13;
        if (r0 != 3) goto L26;
        View r5 = this.mBtnSend;
        if (r6 > 0) goto L12;
        r2 = false;
    L12:
        r5.setEnabled(r2);
        return;
    L26:
        return;
    L13:
        View r7 = this.mBtnSend;
        if (r6 > 0) goto L17;
        r2 = false;
    L17:
        r7.setEnabled(r2);
    }

    private void updateSize(int r3, int r4) {
        if (r3 != (-1)) goto L6;
        String r0 = null;
    L9:
        TextView r1 = this.mGroupSize;
        if (r1 == null) goto L12;
        r1.setText(r0);
    L12:
        SelectAllState r2 = this.mSelectAllState;
        if (r4 != r3) goto L15;
        boolean r5 = true;
    L16:
        r2.setSelectAll(r5);
        return;
    L15:
        r5 = false;
        goto L16
    L6:
        if (this.mIsEditMode == false) goto L8;
        configUI(r4);
    L8:
        r0 = "( " + r4 + LibrarianImpl.Constants.SEPARATOR + r3 + " )";
        goto L9
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView r3, int r4) {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.findViewById(R.id.voice_search);
        if (r4 != 2) goto L8;
    L16:
        this.mPhotoManager.pause();
        this.mBlacklistManager.pause();
        this.mHandler.removeCallbacks(this.mScrollIdle);
        if (this.mIsEditMode == true) goto L22;
        hideVoiceSearchBtn();
        return;
    L22:
        return;
    L8:
        if (r4 == 1) goto L16;
        this.mPhotoManager.resume();
        this.mBlacklistManager.resume();
        if (this.mIsEditMode == true) goto L14;
        ContactDetailCacheManager.getInstance().refreshCache(r3);
    L14:
        if (this.mIsEditMode == true) goto L20;
        this.mHandler.removeCallbacks(this.mScrollIdle);
        this.mHandler.postDelayed(this.mScrollIdle, 150);
        return;
    }

    public long getGroupId() {
        return this.mGroupId;
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivity(Intent r1) {
        super.startActivity(r1);
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L6;
        AnimationUtil.switchActivityAnimation(r0, 1);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r9, int r10, Intent r11) {
        super.onActivityResult(r9, r10, r11);
        if (r10 == (-1)) goto L5;
        return;
    L5:
        if (isAdded() == true) goto L8;
        return;
    L8:
        if (r9 != 1000) goto L25;
        ArrayList r12 = (ArrayList) r11.getExtra("com.android.contacts.extra.PHONE_IDS");
        if (r12 != null) goto L13;
        return;
    L13:
        if (r12.size() <= 0) goto L23;
        long[] r4 = new long[r12.size()];
        int r13 = 0;
    L16:
        if (r13 >= r12.size()) goto L18;
        r4[r13] = ((Long) r12.get(r13)).longValue();
        r13 = r13 + 1;
        goto L16
    L18:
        Intent r14 = ContactSaveService.createGroupUpdateIntent(getActivity(), this.mGroupId, this.mGroupName, r4, null, getActivity().getClass(), GroupEditorActivity.ACTION_SAVE_COMPLETED);
        getActivity().startService(r14);
        return;
    L23:
        return;
    }

    private void cancelEditWithoutAnim() {
        showVoiceSearchBtn();
    }

    private void editAnimation(boolean r3) {
        if (r3 == false) goto L4;
        this.mMemberListView.hideQuickContact();
        hideVoiceSearchBtn();
        this.mListAnimator.startEdit(this.mMemberListView);
    L5:
        this.mAdapter.setEditMode(r3);
        return;
    L4:
        showVoiceSearchBtn();
        this.mListAnimator.finishEdit(this.mMemberListView);
        goto L5
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        OAlertDialog r0 = this.mDeleteDialog;
        if (r0 == null) goto L5;
        r0.dismiss();
        this.mDeleteDialog = null;
    L5:
        stopGroupMetadataLoader();
        dismissLongMenu();
    }

    public boolean isSelecting() {
        return this.mMemberListView.isSelecting();
    }

    public boolean onVisibilityChanged(boolean r2) {
        if (r2 == false) goto L6;
        return false;
    L6:
        if (this.mQuickBar.isShown() == false) goto L9;
        this.mQuickBar.hideLetterGrid();
    L9:
        if (isEditMode() == true) goto L11;
    L13:
        return false;
    L11:
        if (isSelecting() == true) goto L13;
        setCancelEditMode(false);
        goto L13
    }

    private boolean handleSidebarEvent(AdapterView<?> r8, View r9, int r10, long r11, int r13, int r14) {
        if (this.mSidebarDragHelper.isSidebarShowing(r9) == true) goto L11;
        ContactTileAdapter.ContactEntry r12 = this.mAdapter.getItem(r10);
        ContactDetailCacheManager.getInstance().loadResultData(r12.lookupUri);
        ContactLoader.Result r15 = ContactDetailCacheManager.getInstance().getResult(r12.lookupUri);
        LongMenuHelper r0 = this.mLongMenuHelper;
        if (r15 != null) goto L7;
        Object r3 = r12;
    L8:
        r0.setMenuItemDatas(r9, R.id.item_foreground, r3, r13, r14, sLongMeneItems);
        this.mLongMenuHelper.show();
        return true;
    L7:
        r3 = r15;
        goto L8
    L11:
        if (this.mAdapter == null) goto L22;
        AvatarImageView r16 = (AvatarImageView) r9.findViewById(R.id.photo);
        if (r16 != null) goto L15;
    L19:
        Bitmap r17 = null;
    L20:
        ContactTileAdapter.ContactEntry r18 = this.mAdapter.getItem(r10);
        this.mSidebarDragHelper.dragContact(r9, r18.lookupUri, r17, false);
        return true;
    L15:
        if (r16.getPhotoID() <= 0) goto L19;
        if (r16.getDrawable() == null) goto L19;
        r17 = ((BitmapDrawable) r16.getDrawable()).getBitmap();
        goto L20
    L22:
        return false;
    }

    private static void log(String r1) {
        if (ContactsUtils.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r1);
        return;
    }
}
