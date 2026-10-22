package com.android.contacts.recyclebin;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.graphics.Point;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.GlobalProxyLancet;
import com.android.contacts.AbstractFragment;
import com.android.contacts.ContactsUtils;
import com.android.contacts.PinnedHeaderList.HeadersListView;
import com.android.contacts.PreferencesCallback;
import com.android.contacts.R;
import com.android.contacts.bytedanceosquickcontact.QuickContactListView;
import com.android.contacts.list.HorizontalScrollListView;
import com.android.contacts.list.SlideListView;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.util.Constants;
import com.android.contacts.util.ContactsTracker;
import com.android.contacts.util.OAlertDialogUtils;
import com.android.contacts.util.TitleBarUtil;
import com.android.contacts.widget.ProgressDialog;
import com.obric.anim.ListAnimator;
import com.obric.immersive.Immersive;
import com.obric.oui.actionbar.v2.OBottomActionBarFloating;
import com.obric.oui.button.OButtonFloating;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.forms.OEditText;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.searchbar.v2.OSearchBar;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.tracker.EventTrackerManager;
import com.obric.tracker.event.ContactPageShowEvent;
import com.obric.ui.OFloatingTitleBarHolder;
import com.obric.ui.OUIBottomActionBarTextLRHolder;
import com.obricOld.contacts.menus.LongMenuHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import obric.util.NavigationBarHelper;
import obric.widget.ButtonTabGroup;

/* JADX INFO: loaded from: classes2.dex */
public class RecycleBinMainFragment extends AbstractFragment implements AbsListView.OnScrollListener, IRecycleSearchBarView, ButtonTabGroup.OnButtonGroupItemClickListener {
    private static final int DELETE_OPERATION = 1;
    private static final int EMPTY_OPERATION = 0;
    private static final int NOTIFY_LOAD_RECYCLE_BIN = 3004;
    private static final int NOTIFY_PROGRESS_DIALOG_DISMISS = 2006;
    private static final int NOTIFY_PROGRESS_DIALOG_DISPLAY = 2007;
    private static final int NOTIFY_SET_MAIN_LIST_RESULT = 2005;
    private static final int NOTIFY_SET_SEARCH_RESULT = 2004;
    private static final int PROGRESS_DIALOG_SHOW_DELAY_TIME = 500;
    private static final int PROGRESS_DIALOG_SHOW_TIME_MIN = 200;
    private static final int REQUEST_CODE_LAUNCH_DETAIL = 9;
    private static final int RESTORE_OPERATION = 2;
    private static final int TAB_INDEX_DELETE = 0;
    private static final int TAB_INDEX_RESTORE = 1;
    private static final String TAG = "RecycleBinMainFragment";
    private static final LongMenuHelper.MenuType[] sLongMenuItems = null;
    private boolean DBG;
    private Activity mActivity;
    private OAlertDialog mAlertDialog;
    private RecycleBinHandler mBackgroundHandler;
    private HandlerThread mBackgroundThread;
    private OUIBottomActionBarTextLRHolder mBottomActionBarHolder;
    private View mBtnRight;
    private View mBtnSelectAll;
    private TextView mBtnSelectAllTextView;
    private RelativeLayout mContactBody;
    private RelativeLayout mContactsFrameView;
    private Context mContext;
    private DecelerateInterpolator mDecelerateInterpolator;
    private int mDisplayOrder;
    private long mDuration;
    private View mFragment;
    private Handler mHandler;
    private boolean mIsEdit;
    private boolean mIsFirstLoad;
    private boolean mIsSearch;
    private boolean mIsSearchAnimationing;
    private final ListAnimator mListAnimator;
    private Observer<Integer> mNavigationBarObserver;
    private OSearchBar mOSearchBarV2;
    private Point mOutSize;
    private PreferencesCallback mPreferencesCallback;
    private IRecycleSearchBarPresenter mPresenter;
    private ProgressDialog mProgress;
    private long mProgressShowTime;
    private HeadersListView mRawContactListView;
    private RelativeLayout mRecycleBinEmptyView;
    private ViewStub mRecycleBinEmptyViewStub;
    private RecycleItemListAdapter mRecycleItemListAdapter;
    private RecycleItemListener mRecycleItemListener;
    private ContentObserver mRecycleObserver;
    private TextView mSeachResultBG;
    private RelativeLayout mSeachResultView;
    private LinearLayout mSearchBarContainer;
    private TextView mSearchEmptyView;
    private OIconButtonFloating mSearchFieldBtn;
    private String mSearchKey;
    private RecycleBinSearchResultAdapter mSearchResultAdapter;
    private QuickContactListView mSearchResultList;
    private SearchThread mSearchThread;
    private SelectionSet<RecycleItem> mSelectedSet;
    private SlideListView.Listener mSlideListener;
    private int mSortOrder;
    private AnimatorSet mStartSearchAnimatorSet;
    private OFloatingTitleBarHolder mTitleBarHolder;

    /* JADX INFO: renamed from: com.android.contacts.recyclebin.RecycleBinMainFragment$30, reason: invalid class name */
    static /* synthetic */ class AnonymousClass30 {
        static final /* synthetic */ int[] $SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType = null;

        static {
            int[] r0 = new int[LongMenuHelper.MenuType.values().length];
            $SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType = r0;
            r0[LongMenuHelper.MenuType.MENU_RESTORE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType[LongMenuHelper.MenuType.MENU_DELETE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    private class DeleteRawContactsTask extends AsyncTask<List<RecycleItem>, Void, Void> {
        private static final long DELAY_TIME = 1000;
        private Context context;
        private boolean dismiss;
        private Handler handler;
        private ProgressDialog progressDialog;
        private boolean restored;
        final /* synthetic */ RecycleBinMainFragment this$0;

        static /* synthetic */ boolean access$3500(DeleteRawContactsTask r0) {
            return r0.dismiss;
        }

        static /* synthetic */ ProgressDialog access$3600(DeleteRawContactsTask r0) {
            return r0.progressDialog;
        }

        static /* synthetic */ ProgressDialog access$3602(DeleteRawContactsTask r0, ProgressDialog r1) {
            r0.progressDialog = r1;
            return r1;
        }

        static /* synthetic */ Context access$3800(DeleteRawContactsTask r0) {
            return r0.context;
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(List<RecycleItem>[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
            onPostExecute2(r1);
        }

        public DeleteRawContactsTask(RecycleBinMainFragment r1, Context r2, boolean r3) {
            this.this$0 = r1;
            this.dismiss = false;
            this.context = r2;
            this.restored = r3;
            this.handler = new Handler(Looper.getMainLooper());
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            this.dismiss = false;
            this.handler.postDelayed(new AnonymousClass1(this), 1000);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(List<RecycleItem>... r7) {
            List<RecycleItem> r8 = r7[0];
            int r0 = r8.size();
            if (this.restored == false) goto L20;
            ArrayList<ContentProviderOperation> r1 = new ArrayList();
            Iterator<RecycleItem> r2 = r8.iterator();
        L6:
            if (r2.hasNext() == false) goto L15;
            r2.next().fillRestoreOperations(r1);
            if (r1.size() <= 400) goto L6;
            RecycleBinMainFragment.access$3900(this.this$0).getContentResolver().applyBatch("com.android.contacts", r1);     // Catch: Exception -> L11
        L13:
            r1.clear();
        L11:
            e = move-exception;
            e.printStackTrace();
            goto L13
        L15:
            if (r1.size() <= 0) goto L20;
            RecycleBinMainFragment.access$3900(this.this$0).getContentResolver().applyBatch("com.android.contacts", r1);     // Catch: Exception -> L18
        L18:
            e = move-exception;
            e.printStackTrace();
        L20:
            ArrayList r3 = new ArrayList(r0);
            Iterator<RecycleItem> r9 = r8.iterator();
        L22:
            if (r9.hasNext() == false) goto L24;
            RecycleItem r4 = r9.next();
            r3.add(ContentUris.withAppendedId(RecycleBinConstants.RAW_CONTACTS_ID_URI, r4.rawContactId));
            goto L22
        L24:
            ArrayList r10 = new ArrayList(r0);
            Iterator r5 = r3.iterator();
        L26:
            if (r5.hasNext() == false) goto L28;
            r10.add(ContentProviderOperation.newDelete((Uri) r5.next()).build());
            goto L26
        L28:
            ContactsUtils.runApplyBatch(RecycleBinMainFragment.access$3900(this.this$0).getContentResolver(), RecycleBinConstants.AUTHORITY, r10);
            ContactsTracker.trackRecycleBinOperation(this.restored, r0);
            return null;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Void r1) {
            completed();
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            completed();
        }

        private void completed() {
            this.dismiss = true;
            this.handler.removeCallbacksAndMessages(null);
            dismissProgressDialogSafely();
            RecycleBinMainFragment.access$1700(this.this$0, false);
        }

        private void dismissProgressDialogSafely() {
            if (this.progressDialog != null) goto L5;
            return;
        L5:
            FragmentActivity r0 = this.this$0.getActivity();
            if (this.this$0.isAdded() == false) goto L37;
            if (r0 == null) goto L37;
            if (r0.isFinishing() == true) goto L37;
            if (r0.isDestroyed() == true) goto L37;
            if (this.progressDialog.isShowing() == true) goto L17;
            this.progressDialog = null;
            return;
        L17:
            Window r1 = this.progressDialog.getWindow();
            if (r1 != null) goto L20;
            View r2 = null;
        L21:
            if (r2 != null) goto L23;
        L35:
            this.progressDialog = null;
            return;
        L23:
            if (r2.getWindowToken() == null) goto L35;
            this.progressDialog.dismiss();     // Catch: Throwable -> L27 IllegalArgumentException -> L29
        L26:
            this.progressDialog = null;
            return;
        L29:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(RecycleBinMainFragment.TAG, "dismiss progress dialog failed", e);     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            this.progressDialog = null;
            throw th;
        L20:
            r2 = r1.getDecorView();
        L37:
            this.progressDialog = null;
        }
    }

    private class NavigationBarVisibilityChangeListener implements View.OnSystemUiVisibilityChangeListener {
        final /* synthetic */ RecycleBinMainFragment this$0;

        private NavigationBarVisibilityChangeListener(RecycleBinMainFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ NavigationBarVisibilityChangeListener(RecycleBinMainFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int r6) {
            if (r6 == 0) goto L6;
            if (r6 == 2) goto L6;
            return;
        L6:
            if (RecycleBinMainFragment.access$2900(this.this$0) != null) goto L8;
            return;
        L8:
            if (RecycleBinMainFragment.access$2600(this.this$0) == false) goto L21;
            DisplayMetrics r1 = new DisplayMetrics();
            this.this$0.getActivity().getWindow().getDecorView().getDisplay().getRealMetrics(r1);
            int r2 = this.this$0.getResources().getDimensionPixelSize(R.dimen.status_bar_height);
            int r3 = this.this$0.getResources().getDimensionPixelSize(R.dimen.navigation_bar_height);
            ViewGroup.LayoutParams r4 = RecycleBinMainFragment.access$2900(this.this$0).getLayoutParams();
            if (r6 != 0) goto L12;
            r4.height = (r1.heightPixels - r2) - r3;
        L15:
            if (RecycleBinMainFragment.access$3000(this.this$0) == null) goto L17;
            r4.height += RecycleBinMainFragment.access$3000(this.this$0).getTitleBar().getHeight();
        L17:
            RecycleBinMainFragment.access$2900(this.this$0).setLayoutParams(r4);
            return;
        L12:
            if (r6 != 2) goto L15;
            r4.height = r1.heightPixels - r2;
            goto L15
        }
    }

    private class RecycleBinHandler extends Handler {
        final /* synthetic */ RecycleBinMainFragment this$0;

        public RecycleBinHandler(RecycleBinMainFragment r1, Looper r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r4) {
            if (r4.what == RecycleBinMainFragment.NOTIFY_LOAD_RECYCLE_BIN) goto L6;
        L8:
            super.handleMessage(r4);
            return;
        L6:
            if (this.this$0.isAdded() == false) goto L8;
            List r0 = RecycleBinMainFragment.access$800(this.this$0);
            Message r1 = new Message();
            r1.what = RecycleBinMainFragment.NOTIFY_SET_MAIN_LIST_RESULT;
            r1.obj = r0;
            RecycleBinMainFragment.access$900(this.this$0).sendMessage(r1);
            goto L8
        }
    }

    private class SearchThread extends Thread {
        private boolean mIsTrue;
        protected String mSearchKey;
        final /* synthetic */ RecycleBinMainFragment this$0;

        private SearchThread(RecycleBinMainFragment r1) {
            this.this$0 = r1;
            this.mSearchKey = null;
            this.mIsTrue = true;
        }

        /* synthetic */ SearchThread(RecycleBinMainFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void setSearchKey(String r1) {
            this.mSearchKey = r1;
        }

        public void setTrue(boolean r1) {
            this.mIsTrue = r1;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (this.mSearchKey != null) goto L5;
            return;
        L5:
            if (RecycleBinMainFragment.access$2300(this.this$0) != null) goto L7;
            return;
        L7:
            if (RecycleBinMainFragment.access$2300(this.this$0).getList() == null) goto L32;
            ArrayList r0 = new ArrayList();
            Iterator r1 = ((ArrayList) ((ArrayList) RecycleBinMainFragment.access$2300(this.this$0).getList()).clone()).iterator();
        L11:
            if (r1.hasNext() == false) goto L19;
            RecycleItem r2 = (RecycleItem) r1.next();
            if (this.mIsTrue == false) goto L14;
            if (r2.search(this.mSearchKey) == false) goto L11;
            r0.add(r2);
            goto L11
        L14:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(RecycleBinMainFragment.TAG, "mSearchThread isInterrupted");
            return;
        L19:
            Collections.sort(r0, new AnonymousClass1(this));
            if (this.mIsTrue == false) goto L31;
            RecycleBinMainFragment.access$900(this.this$0).removeMessages(RecycleBinMainFragment.NOTIFY_SET_SEARCH_RESULT);
            Message r3 = new Message();
            r3.what = RecycleBinMainFragment.NOTIFY_SET_SEARCH_RESULT;
            r3.obj = r0;
            RecycleBinMainFragment.access$900(this.this$0).sendMessage(r3);
            return;
        L31:
            return;
        }
    }

    private final class SelectionSet<T> extends HashSet<T> {
        final /* synthetic */ RecycleBinMainFragment this$0;

        private SelectionSet(RecycleBinMainFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ SelectionSet(RecycleBinMainFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(T r2) {
            boolean r3 = super.add(r2);
            if (r3 == false) goto L5;
            RecycleBinMainFragment.access$4000(this.this$0, size());
        L5:
            return r3;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r2) {
            boolean r3 = super.remove(r2);
            if (r3 == false) goto L5;
            RecycleBinMainFragment.access$4000(this.this$0, size());
        L5:
            return r3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends T> r2) {
            boolean r3 = super.addAll(r2);
            if (r3 == false) goto L5;
            RecycleBinMainFragment.access$4000(this.this$0, size());
        L5:
            return r3;
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r2) {
            boolean r3 = super.removeAll(r2);
            if (r3 == false) goto L5;
            RecycleBinMainFragment.access$4000(this.this$0, size());
        L5:
            return r3;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            super.clear();
            RecycleBinMainFragment.access$4000(this.this$0, size());
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r1, int r2, int r3, int r4) {
    }

    public RecycleBinMainFragment() {
        this.DBG = false;
        this.mDuration = 200;
        this.mIsEdit = false;
        this.mSelectedSet = new SelectionSet(this, null);
        this.mIsFirstLoad = true;
        this.mNavigationBarObserver = new AnonymousClass1(this);
        this.mListAnimator = new ListAnimator(new int[]{R.id.content_container, R.id.photo_frame}, new int[0], new int[]{R.id.checkBoxFrame});
        final Looper r3 = Looper.getMainLooper();
        this.mHandler = new AnonymousClass2(this, r3);
        this.mOutSize = new Point();
        this.mIsSearch = false;
        this.mIsSearchAnimationing = false;
        this.mProgressShowTime = 0;
        final Handler r1 = new Handler();
        this.mRecycleObserver = new AnonymousClass15(this, r1);
        this.mRecycleItemListener = new AnonymousClass27(this);
        this.mSlideListener = new AnonymousClass28(this);
        this.mProgress = null;
    }

    static /* synthetic */ HeadersListView access$100(RecycleBinMainFragment r0) {
        return r0.mRawContactListView;
    }

    static /* synthetic */ void access$1000(RecycleBinMainFragment r0, int r1) {
        r0.showMultiDeletionDialog(r1);
    }

    static /* synthetic */ void access$1100(RecycleBinMainFragment r0) {
        r0.cancelSearch();
    }

    static /* synthetic */ void access$1200(RecycleBinMainFragment r0) {
        r0.onCancelEditClicked();
    }

    static /* synthetic */ void access$1300(RecycleBinMainFragment r0) {
        r0.onEditButtonClicked();
    }

    static /* synthetic */ void access$1400(RecycleBinMainFragment r0) {
        r0.onSelectAllClicked();
    }

    static /* synthetic */ OIconButtonFloating access$1500(RecycleBinMainFragment r0) {
        return r0.mSearchFieldBtn;
    }

    static /* synthetic */ IRecycleSearchBarPresenter access$1600(RecycleBinMainFragment r0) {
        return r0.getPresenter();
    }

    static /* synthetic */ void access$1700(RecycleBinMainFragment r0, boolean r1) {
        r0.triggerLoad(r1);
    }

    static /* synthetic */ void access$1900(RecycleBinMainFragment r0, boolean r1) {
        r0.doRemoveAction(r1);
    }

    static /* synthetic */ QuickContactListView access$200(RecycleBinMainFragment r0) {
        return r0.mSearchResultList;
    }

    static /* synthetic */ void access$2000(RecycleBinMainFragment r0) {
        r0.restoreScrollState();
    }

    static /* synthetic */ void access$2100(RecycleBinMainFragment r0, View r1, RecycleItem r2, boolean r3) {
        r0.doSingleRemoveAction(r1, r2, r3);
    }

    static /* synthetic */ OAlertDialog access$2200(RecycleBinMainFragment r0) {
        return r0.mAlertDialog;
    }

    static /* synthetic */ RecycleItemListAdapter access$2300(RecycleBinMainFragment r0) {
        return r0.mRecycleItemListAdapter;
    }

    static /* synthetic */ void access$2400(RecycleBinMainFragment r0, boolean r1, List r2) {
        r0.deleteRawContacts(r1, r2);
    }

    static /* synthetic */ void access$2500(RecycleBinMainFragment r0, boolean r1, boolean r2, int r3, List r4) {
        r0.processEditContacts(r1, r2, r3, r4);
    }

    static /* synthetic */ boolean access$2600(RecycleBinMainFragment r0) {
        return r0.mIsSearch;
    }

    static /* synthetic */ boolean access$2602(RecycleBinMainFragment r0, boolean r1) {
        r0.mIsSearch = r1;
        return r1;
    }

    static /* synthetic */ boolean access$2702(RecycleBinMainFragment r0, boolean r1) {
        r0.mIsSearchAnimationing = r1;
        return r1;
    }

    static /* synthetic */ Point access$2800(RecycleBinMainFragment r0) {
        return r0.mOutSize;
    }

    static /* synthetic */ RelativeLayout access$2900(RecycleBinMainFragment r0) {
        return r0.mContactsFrameView;
    }

    static /* synthetic */ String access$300(RecycleBinMainFragment r0) {
        return r0.mSearchKey;
    }

    static /* synthetic */ OFloatingTitleBarHolder access$3000(RecycleBinMainFragment r0) {
        return r0.mTitleBarHolder;
    }

    static /* synthetic */ RelativeLayout access$3100(RecycleBinMainFragment r0) {
        return r0.mSeachResultView;
    }

    static /* synthetic */ TextView access$3200(RecycleBinMainFragment r0) {
        return r0.mSeachResultBG;
    }

    static /* synthetic */ void access$3300(RecycleBinMainFragment r0) {
        r0.searchAnimationEnd();
    }

    static /* synthetic */ ProgressDialog access$3700(RecycleBinMainFragment r0) {
        return r0.mProgress;
    }

    static /* synthetic */ Context access$3900(RecycleBinMainFragment r0) {
        return r0.mContext;
    }

    static /* synthetic */ RecycleBinSearchResultAdapter access$400(RecycleBinMainFragment r0) {
        return r0.mSearchResultAdapter;
    }

    static /* synthetic */ void access$4000(RecycleBinMainFragment r0, int r1) {
        r0.refreshOptionBar(r1);
    }

    static /* synthetic */ SelectionSet access$4100(RecycleBinMainFragment r0) {
        return r0.mSelectedSet;
    }

    static /* synthetic */ void access$4200(RecycleBinMainFragment r0, View r1, int r2, RecycleItem r3) {
        r0.showSingleDeletionDialog(r1, r2, r3);
    }

    static /* synthetic */ void access$4300(RecycleBinMainFragment r0) {
        r0.hideSoftKeyboard();
    }

    static /* synthetic */ Activity access$4400(RecycleBinMainFragment r0) {
        return r0.mActivity;
    }

    static /* synthetic */ boolean access$4500(RecycleBinMainFragment r0) {
        return r0.mIsEdit;
    }

    static /* synthetic */ void access$4600(RecycleBinMainFragment r0, int r1) {
        r0.processSelectOnItemClicked(r1);
    }

    static /* synthetic */ LongMenuHelper.MenuType[] access$4700() {
        return sLongMenuItems;
    }

    static /* synthetic */ LongMenuHelper access$4800(RecycleBinMainFragment r0) {
        return r0.mLongMenuHelper;
    }

    static /* synthetic */ LongMenuHelper access$4900(RecycleBinMainFragment r0) {
        return r0.mLongMenuHelper;
    }

    static /* synthetic */ TextView access$500(RecycleBinMainFragment r0) {
        return r0.mSearchEmptyView;
    }

    static /* synthetic */ void access$600(RecycleBinMainFragment r0, List r1) {
        r0.reloadMainAdapter(r1);
    }

    static /* synthetic */ void access$700(RecycleBinMainFragment r0) {
        r0.showProgressDialog();
    }

    static /* synthetic */ List access$800(RecycleBinMainFragment r0) {
        return r0.loadRecycleItems();
    }

    static /* synthetic */ Handler access$900(RecycleBinMainFragment r0) {
        return r0.mHandler;
    }

    static {
        sLongMenuItems = new LongMenuHelper.MenuType[]{LongMenuHelper.MenuType.MENU_RESTORE, LongMenuHelper.MenuType.MENU_DELETE};
    }

    private synchronized void reloadMainAdapter(List<RecycleItem> r6) {
        monitor-enter(this);
    L45:
        th = move-exception;
        throw th;
    L4:
        if (getActivity() != null) goto L6;
    L43:
        monitor-exit(this);
        return;
    L6:
        if (getActivity().isFinishing() == true) goto L43;
        boolean r0 = false;
        if (r6 != null) goto L11;
    L14:
        boolean r2 = true;
    L15:
        View r3 = this.mBtnRight;     // Catch: Throwable -> L45
        if (r2 == true) goto L18;
        boolean r4 = true;
    L19:
        r3.setEnabled(r4);     // Catch: Throwable -> L45
        View r5 = this.mBtnSelectAll;     // Catch: Throwable -> L45
        if (r5 == null) goto L24;
        if (r2 == true) goto L23;
        r0 = true;
    L23:
        r5.setEnabled(r0);     // Catch: Throwable -> L45
    L24:
        LinearLayout r1 = this.mSearchBarContainer;     // Catch: Throwable -> L45
        if (r1 == null) goto L28;
        ViewKt.setGone(r1, r2);     // Catch: Throwable -> L45
    L28:
        if (this.mIsEdit == true) goto L30;
    L37:
        controlProgressDialogShowTime(r6);     // Catch: Throwable -> L45
        RecycleItemListAdapter r7 = this.mRecycleItemListAdapter;     // Catch: Throwable -> L45
        if (r7 != null) goto L40;
        RecycleItemListAdapter r8 = new RecycleItemListAdapter(getActivity(), r6);     // Catch: Throwable -> L45
        this.mRecycleItemListAdapter = r8;     // Catch: Throwable -> L45
        this.mRawContactListView.setAdapter(r8);     // Catch: Throwable -> L45
        this.mRecycleItemListAdapter.setRecycleItemListener(this.mRecycleItemListener);     // Catch: Throwable -> L45
        setEmptyView(this.mRawContactListView);     // Catch: Throwable -> L45
    L41:
        monitor-exit(this);
        return;
    L40:
        r7.setList(r6);     // Catch: Throwable -> L45
        goto L41
    L30:
        if (this.mSelectedSet.size() <= 0) goto L37;
        Iterator<RecycleItem> r9 = this.mSelectedSet.iterator();     // Catch: Throwable -> L45
    L33:
        if (r9.hasNext() == false) goto L37;
        if (r6.contains(r9.next()) == true) goto L33;
        r9.remove();     // Catch: Throwable -> L45
        goto L33
    L18:
        r4 = false;
        goto L19
    L11:
        if (r6.isEmpty() == true) goto L14;
        r2 = false;
        goto L15
    }

    private void controlProgressDialogShowTime(List<RecycleItem> r7) {
        long r0 = SystemClock.elapsedRealtime();
        long r2 = this.mProgressShowTime;
        long r1 = r0 - r2;
        long r4 = 0;
        if (r2 != 0) goto L6;
        this.mHandler.removeMessages(NOTIFY_PROGRESS_DIALOG_DISPLAY);
        return;
    L6:
        if (r1 >= 0) goto L8;
        return;
    L8:
        if (r1 >= 200) goto L10;
        r4 = 200 - r1;
    L10:
        this.mHandler.removeMessages(NOTIFY_PROGRESS_DIALOG_DISMISS);
        this.mHandler.sendEmptyMessageDelayed(NOTIFY_PROGRESS_DIALOG_DISMISS, r4);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView r1, int r2) {
        if (r2 != 2) goto L5;
    L6:
        hideSoftKeyboard();
        return;
    L5:
        if (r2 == 1) goto L6;
    }

    public void setPrefsCallback(PreferencesCallback r1) {
        this.mPreferencesCallback = r1;
        getSortOrder();
        getDisplayOrder();
    }

    private int getSortOrder() {
        PreferencesCallback r0 = this.mPreferencesCallback;
        if (r0 == null) goto L6;
        this.mSortOrder = r0.getSortOrder();
    L6:
        return this.mSortOrder;
    }

    private int getDisplayOrder() {
        PreferencesCallback r0 = this.mPreferencesCallback;
        if (r0 == null) goto L6;
        this.mDisplayOrder = r0.getDisplayOrder();
    L6:
        return this.mDisplayOrder;
    }

    private String[] getRawContactProjection() {
        int r0 = getDisplayOrder();
        int r2 = getSortOrder();
        if (r0 != 1) goto L9;
        if (r2 != 1) goto L8;
        return RecycleBinConstants.RawContactQuery.CONTACT_PROJECTION_PRIMARY_PRIMARY;
    L8:
        return RecycleBinConstants.RawContactQuery.CONTACT_PROJECTION_PRIMARY_ALTERNATIVE;
    L9:
        if (r2 != 1) goto L13;
        return RecycleBinConstants.RawContactQuery.CONTACT_PROJECTION_ALTERNATIVE_PRIMARY;
    L13:
        return RecycleBinConstants.RawContactQuery.CONTACT_PROJECTION_ALTERNATIVE_ALTERNATIVE;
    }

    @Override // com.android.contacts.AbstractFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        setupLongMenu();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        this.mFragment = r7.inflate(R.layout.recycle_bin_main_fragment, r8, false);
        getActivity().getWindowManager().getDefaultDisplay().getSize(this.mOutSize);
        this.mContactsFrameView = (RelativeLayout) this.mFragment.findViewById(R.id.contacts_frame_view);
        this.mContactBody = (RelativeLayout) this.mFragment.findViewById(R.id.contacts_body);
        HeadersListView r10 = (HeadersListView) this.mFragment.findViewById(R.id.main_list);
        this.mRawContactListView = r10;
        NavigationBarHelper.setBottomPaddingWhenNavigationBarStatusChange(r10);
        this.mRawContactListView.setSlideListener(this.mSlideListener);
        this.mRawContactListView.setAutoClose(false);
        this.mRecycleBinEmptyViewStub = (ViewStub) this.mFragment.findViewById(R.id.listview_emptyview_stub);
        OUIBottomActionBarTextLRHolder r11 = new OUIBottomActionBarTextLRHolder((OBottomActionBarFloating) this.mFragment.findViewById(R.id.bottom_action_bar), getResources().getString(R.string.common_restore), getResources().getString(R.string.common_delete));
        this.mBottomActionBarHolder = r11;
        r11.getLeftBtn().setOnClickListener(new AnonymousClass3(this));
        this.mBottomActionBarHolder.getRightBtn().setOnClickListener(new AnonymousClass4(this));
        this.mBottomActionBarHolder.getRightBtn().getTextView().setTextColor(ResourcesCompat.getColor(getResources(), R.color.oui_functional_red_6, null));
        TextView r12 = (TextView) this.mFragment.findViewById(R.id.sv_background);
        this.mSeachResultBG = r12;
        r12.setOnClickListener(new AnonymousClass5(this));
        this.mTitleBarHolder = new OFloatingTitleBarHolder((OFloatingTitleBar) this.mFragment.findViewById(R.id.otitlebar));
        Intent r13 = getActivity().getIntent();
        if (r13 != null) goto L5;
    L7:
        boolean r14 = false;
    L8:
        this.mTitleBarHolder.addStartAction(OFloatingTitleBarHolder.STATE_NORMAL, TitleBarUtil.getLeftRes(r14), new AnonymousClass6(this));
        this.mTitleBarHolder.addStartAction(OFloatingTitleBarHolder.STATE_EDIT, R.drawable.icon_cancel_22_22, new AnonymousClass7(this));
        this.mBtnRight = this.mTitleBarHolder.addEndAction(OFloatingTitleBarHolder.STATE_NORMAL, R.drawable.standard_icon_multi_select_selector, new AnonymousClass8(this));
        View r15 = this.mTitleBarHolder.addEndAction(OFloatingTitleBarHolder.STATE_EDIT, getResources().getString(R.string.select_all), new AnonymousClass9(this));
        this.mBtnSelectAll = r15;
        if ((r15 instanceof ViewGroup) == false) goto L13;
        View r16 = ((ViewGroup) r15).getChildAt(0);
        if ((r16 instanceof TextView) == false) goto L13;
        TextView r17 = (TextView) r16;
        this.mBtnSelectAllTextView = r17;
        r17.setTextColor(ResourcesCompat.getColor(getResources(), R.color.oui_functional_blue_6, null));
    L13:
        this.mTitleBarHolder.stateTo(OFloatingTitleBarHolder.STATE_NORMAL);
        LinearLayout r18 = (LinearLayout) this.mFragment.findViewById(R.id.search_container);
        this.mSearchBarContainer = r18;
        r18.setOnClickListener(new AnonymousClass10(this));
        this.mOSearchBarV2 = (OSearchBar) this.mFragment.findViewById(R.id.search_field_bar);
        OIconButtonFloating r19 = (OIconButtonFloating) this.mFragment.findViewById(R.id.search_field_button);
        this.mSearchFieldBtn = r19;
        r19.setVisibility(8);
        this.mSearchFieldBtn.setOnClickListener(new AnonymousClass11(this));
        OEditText r20 = this.mOSearchBarV2.getInputView();
        r20.setHint(getString(R.string.search));
        r20.setSingleLine(true);
        r20.setSaveEnabled(false);
        r20.setImeOptions(6);
        r20.setFilters(new InputFilter[]{new InputFilter.LengthFilter(100)});
        r20.setInputType(4096);
        r20.setOnFocusChangeListener(new AnonymousClass12(this));
        r20.setHint(getActivity().getString(R.string.common_search));
        this.mSeachResultView = (RelativeLayout) this.mFragment.findViewById(R.id.seachresultview);
        QuickContactListView r21 = (QuickContactListView) this.mFragment.findViewById(R.id.search_listview);
        this.mSearchResultList = r21;
        NavigationBarHelper.setBottomPaddingWhenNavigationBarStatusChange(r21);
        this.mSearchResultList.setAutoClose(false);
        this.mSearchResultList.setOnScrollListener(this);
        RecycleBinSearchResultAdapter r22 = new RecycleBinSearchResultAdapter(getActivity(), null, null);
        this.mSearchResultAdapter = r22;
        r22.setRecycleItemListener(this.mRecycleItemListener);
        this.mSearchResultList.setAdapter(this.mSearchResultAdapter);
        this.mSearchResultList.setOnScrollStateChangeListener(this.mSearchResultAdapter);
        TextView r23 = (TextView) this.mFragment.findViewById(R.id.search_empty_view);
        this.mSearchEmptyView = r23;
        r23.setOnClickListener(new AnonymousClass13(this));
        TextView r24 = (TextView) this.mFragment.findViewById(R.id.sv_background);
        this.mSeachResultBG = r24;
        r24.setOnClickListener(new AnonymousClass14(this));
        HandlerThread r25 = new HandlerThread("RecycleBin Worker");
        this.mBackgroundThread = r25;
        r25.start();
        this.mBackgroundHandler = new RecycleBinHandler(this, this.mBackgroundThread.getLooper());
        Immersive.Companion.getImmersive(getActivity()).getNavigationBarHeight().observeForever(this.mNavigationBarObserver);
        return this.mFragment;
    L5:
        if (r13.getBooleanExtra(Constants.EXTRA_FROM_SETTINGS, false) == false) goto L7;
        r14 = true;
        goto L8
    }

    @Override // com.android.contacts.AbstractFragment, com.obricOld.contacts.menus.LongMenuHelper.OnMenuItemClickedListener
    public boolean onMenuItemClicked(LongMenuHelper.MenuType r4, View r5, Object r6) {
        int r0 = AnonymousClass30.$SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType[r4.ordinal()];
        if (r0 == 1) goto L9;
        if (r0 == 2) goto L9;
        return false;
    L9:
        if (r4 != LongMenuHelper.MenuType.MENU_RESTORE) goto L11;
        int r7 = R.id.umb_restore;
    L12:
        showSingleDeletionDialog(r5, r7, (RecycleItem) r6);
        return true;
    L11:
        r7 = R.id.umb_clear;
        goto L12
    }

    private void cancelSearch() {
        OIconButtonFloating r0 = this.mSearchFieldBtn;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
    L6:
        if (this.mSearchBarContainer != null) goto L8;
        return;
    L8:
        if (this.mOSearchBarV2 == null) goto L12;
        getPresenter().cancelSearch();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity r1) {
        super.onAttach(r1);
        this.mActivity = r1;
        this.mContext = getActivity();
    }

    public boolean backToTopState() {
        if (isSearch() == false) goto L8;
        if (isSearchAnimationing() == true) goto L8;
        cancelSearch();
        return false;
    L8:
        if (this.mIsEdit == false) goto L13;
        if (this.mRawContactListView.isSelecting() == true) goto L15;
        processEditContacts(false, true);
        return false;
    L15:
        return false;
    L13:
        return true;
    }

    public boolean isSearch() {
        return this.mIsSearch;
    }

    private boolean isSearchAnimationing() {
        return this.mIsSearchAnimationing;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        RecycleBinHandler r0 = this.mBackgroundHandler;
        if (r0 == null) goto L5;
        r0.removeMessages(NOTIFY_LOAD_RECYCLE_BIN);
        this.mBackgroundHandler = null;
    L5:
        HandlerThread r1 = this.mBackgroundThread;
        if (r1 == null) goto L8;
        r1.quitSafely();
        this.mBackgroundThread = null;
    L8:
        Immersive.Companion.getImmersive(getActivity()).getNavigationBarHeight().removeObserver(this.mNavigationBarObserver);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getActivity().getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new NavigationBarVisibilityChangeListener(this, null));
        triggerLoad(this.mIsFirstLoad);
        if (this.mIsFirstLoad == false) goto L5;
        this.mIsFirstLoad = false;
    L5:
        this.mContext.getContentResolver().registerContentObserver(RecycleBinConstants.RAW_CONTACTS_URI, true, this.mRecycleObserver);
        EventTrackerManager.INSTANCE.track(new ContactPageShowEvent("settings", TAG, "", ""));
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.mIsEdit == false) goto L5;
        processEditContacts(false, true);
    L5:
        this.mContext.getContentResolver().unregisterContentObserver(this.mRecycleObserver);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.mSearchBarContainer != null) goto L5;
    L7:
        hideProgressDialog();
        OAlertDialog r0 = this.mAlertDialog;
        if (r0 == null) goto L13;
        if (r0.isShowing() == false) goto L13;
        this.mAlertDialog.dismiss();
    L13:
        if (this.mIsEdit == false) goto L15;
        processEditContacts(false, false);
    L15:
        dismissLongMenu();
        return;
    L5:
        if (this.mOSearchBarV2 == null) goto L7;
        hideSoftKeyboard();
        getPresenter().clearSearchText();
        getPresenter().cancelSearchWithoutAnimation();
        goto L7
    }

    @Override // com.android.contacts.AbstractFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        log("onDestroy");
        IRecycleSearchBarPresenter r1 = this.mPresenter;
        if (r1 == null) goto L6;
        r1.detachView();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r1) {
        super.onActivityCreated(r1);
        initPresenter();
    }

    protected void initPresenter() {
        RecycleSearchBarPresenter r0 = new RecycleSearchBarPresenter();
        this.mPresenter = r0;
        r0.attachView(this, getActivity());
    }

    private IRecycleSearchBarPresenter getPresenter() {
        if (this.mPresenter != null) goto L6;
        RecycleSearchBarPresenter r0 = new RecycleSearchBarPresenter();
        this.mPresenter = r0;
        r0.attachView(this, getActivity());
    L6:
        return this.mPresenter;
    }

    @Override // com.android.contacts.recyclebin.IRecycleSearchBarView
    public OSearchBar getSearchBar() {
        return this.mOSearchBarV2;
    }

    @Override // obric.widget.ButtonTabGroup.OnButtonGroupItemClickListener
    public void onButtonGroupItemClick(View r1, int r2) {
        if (r2 == 0) goto L7;
        if (r2 == 1) goto L7;
        return;
    L7:
        if (ContactsUtils.isJustClicked() == true) goto L10;
        showMultiDeletionDialog(r2);
        return;
    }

    private void onCancelEditClicked() {
        processEditContacts(false, true);
    }

    private void onEditButtonClicked() {
        if (getPresenter().isInSearchMode() == false) goto L5;
        return;
    L5:
        getPresenter().setSearchBarEnable(false);
        processEditContacts(true, true);
    }

    private void onSelectAllClicked() {
        RecycleItemListAdapter r0 = this.mRecycleItemListAdapter;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.getCount();
        if (r1 > 0) goto L9;
        return;
    L9:
        if (this.mSelectedSet.size() != r1) goto L11;
        this.mSelectedSet.clear();
    L12:
        refreshAdapter(true);
        return;
    L11:
        this.mSelectedSet.clear();
        this.mSelectedSet.addAll(this.mRecycleItemListAdapter.getList());
        goto L12
    }

    private void showMultiDeletionDialog(int r13) {
        if (r13 != 0) goto L4;
        String r14 = getString(R.string.delete_single_recycle_contact_dialog_title);
        String r0 = getResources().getString(R.string.btn_delete_permanently_confirm);
        DialogInterface.OnClickListener r1 = new AnonymousClass16(this);
        ButtonStyleController.TextColorType r2 = ButtonStyleController.TextColorType.Negative;
    L5:
        DialogInterface.OnClickListener r10 = new AnonymousClass18(this);
        String r9 = getResources().getString(R.string.common_cancel);
        Context r3 = getContext();
        OAlertDialogUtils.showConfirmationDialog(r3, r14, null, r0, r1, r2, r9, r10, null);
        return;
    L4:
        r14 = calcDestAccountsOfSelectionSet();
        r0 = getResources().getString(R.string.common_restore);
        r1 = new AnonymousClass17(this);
        r2 = ButtonStyleController.TextColorType.Negative;
        goto L5
    }

    private void restoreScrollState() {
        if (this.mIsSearch == false) goto L7;
        QuickContactListView r2 = this.mSearchResultList;
        if (r2 == null) goto L11;
        r2.restoreScrollState(true);
        return;
    L11:
        return;
    L7:
        HeadersListView r3 = this.mRawContactListView;
        if (r3 == null) goto L13;
        r3.restoreScrollState(true);
        return;
    }

    private void showSingleDeletionDialog(final View r12, int r13, final RecycleItem r14) {
        if (r13 != R.id.umb_clear) goto L5;
        String r15 = getString(R.string.delete_single_recycle_contact_dialog_title);
        String r0 = getResources().getString(R.string.btn_delete_permanently_confirm);
        DialogInterface.OnClickListener r1 = new AnonymousClass19(this, r12, r14);
        ButtonStyleController.TextColorType r16 = ButtonStyleController.TextColorType.Negative;
    L6:
        ButtonStyleController.TextColorType r7 = r16;
        String r8 = getResources().getString(R.string.common_cancel);
        DialogInterface.OnClickListener r9 = new AnonymousClass21(this);
        Context r2 = getContext();
        this.mAlertDialog = OAlertDialogUtils.showConfirmationDialog(r2, r15, null, r0, r1, r7, r8, r9, null);
        return;
    L5:
        r15 = RecycleItem.calcDestAccountsOfSingleItem(this.mContext, r14);
        r0 = getResources().getString(R.string.common_restore);
        r1 = new AnonymousClass20(this, r12, r14);
        r16 = ButtonStyleController.TextColorType.Negative;
        goto L6
    }

    private synchronized String calcDestAccountsOfSelectionSet() {
        monitor-enter(this);
        HashSet r0 = new HashSet();     // Catch: Throwable -> L22
        AccountWithDataSet r1 = RecycleItem.getDefaultAccount(this.mContext);     // Catch: Throwable -> L22
        Iterator<RecycleItem> r2 = this.mSelectedSet.iterator();     // Catch: Throwable -> L22
    L5:
        if (r2.hasNext() == false) goto L8;
        r0.add(Boolean.valueOf(r2.next().calcDestAccount(r1)));     // Catch: Throwable -> L22
        goto L5
    L8:
        if (r0.size() != 2) goto L14;
        if (ContactsUtils.LOCAL_ACCOUNT_TYPE.equals(r1.type) == false) goto L12;
        String r3 = this.mContext.getResources().getQuantityString(R.plurals.restore_part_to_local_accounts_msg, this.mSelectedSet.size(), new Object[]{Integer.valueOf(this.mSelectedSet.size())});     // Catch: Throwable -> L22
    L20:
        monitor-exit(this);
        return r3;
    L12:
        r3 = this.mContext.getResources().getQuantityString(R.plurals.restore_part_to_smile_cloud_accounts_msg, this.mSelectedSet.size(), new Object[]{Integer.valueOf(this.mSelectedSet.size())});     // Catch: Throwable -> L22
        goto L20
    L14:
        if (r0.contains(Boolean.TRUE) == false) goto L17;
        r3 = this.mContext.getResources().getQuantityString(R.plurals.restore_to_same_accounts_msg, this.mSelectedSet.size(), new Object[]{Integer.valueOf(this.mSelectedSet.size())});     // Catch: Throwable -> L22
        goto L20
    L17:
        if (ContactsUtils.LOCAL_ACCOUNT_TYPE.equals(r1.type) == false) goto L19;
        r3 = this.mContext.getResources().getQuantityString(R.plurals.restore_to_local_accounts_msg, this.mSelectedSet.size(), new Object[]{Integer.valueOf(this.mSelectedSet.size())});     // Catch: Throwable -> L22
        goto L20
    L19:
        r3 = this.mContext.getResources().getQuantityString(R.plurals.restore_to_smile_cloud_accounts_msg, this.mSelectedSet.size(), new Object[]{Integer.valueOf(this.mSelectedSet.size())});     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    private synchronized void doRemoveAction(final boolean r13) {
        monitor-enter(this);
    L32:
        th = move-exception;
        throw th;
    L4:
        if (this.mSelectedSet.isEmpty() == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        final ArrayList r0 = (ArrayList) ((ArrayList) this.mRecycleItemListAdapter.getList()).clone();     // Catch: Throwable -> L32
        HashSet<String> r8 = new HashSet();     // Catch: Throwable -> L32
        final ArrayList r7 = new ArrayList();     // Catch: Throwable -> L32
        ArrayList<Integer> r9 = new ArrayList();     // Catch: Throwable -> L32
        ArrayList<Integer> r10 = new ArrayList();     // Catch: Throwable -> L32
        Iterator r1 = r0.iterator();     // Catch: Throwable -> L32
        int r2 = 0;
    L9:
        if (r1.hasNext() == false) goto L20;
        RecycleItem r3 = (RecycleItem) r1.next();     // Catch: Throwable -> L32
        if (this.mSelectedSet.contains(r3) == false) goto L18;
        if (r13 == false) goto L14;
        r3.calcDestAccount(RecycleItem.getDefaultAccount(this.mContext));     // Catch: Throwable -> L32
    L14:
        r7.add(r3);     // Catch: Throwable -> L32
        r9.add(Integer.valueOf(r2));     // Catch: Throwable -> L32
        if (r8.contains(r3.getSectionHeader(this.mContext)) == true) goto L17;
        r8.add(r3.getSectionHeader(this.mContext));     // Catch: Throwable -> L32
    L17:
        r1.remove();     // Catch: Throwable -> L32
    L19:
        r2 = r2 + 1;     // Catch: Throwable -> L32
        goto L9
    L18:
        r10.add(Integer.valueOf(r2));     // Catch: Throwable -> L32
        goto L19
    L20:
        HashSet r4 = new HashSet();     // Catch: Throwable -> L32
        Iterator<String> r5 = r8.iterator();     // Catch: Throwable -> L32
    L22:
        if (r5.hasNext() == false) goto L29;
        String r6 = r5.next();     // Catch: Throwable -> L32
        Iterator r11 = r0.iterator();     // Catch: Throwable -> L32
    L25:
        if (r11.hasNext() == false) goto L22;
        if (TextUtils.equals(((RecycleItem) r11.next()).getSectionHeader(this.mContext), r6) == false) goto L25;
        r4.add(r6);     // Catch: Throwable -> L32
        goto L25
    L29:
        r8.removeAll(r4);     // Catch: Throwable -> L32
        this.mRawContactListView.setDeletedHeaderSections(r8);     // Catch: Throwable -> L32
        final HeadersListView r12 = this.mRawContactListView;     // Catch: Throwable -> L32
        final boolean r14 = true;
        new AnonymousClass22(this, r12, r14, r0, r13, r7).setResultListSize(r0.size()).setDeletedHeaderSection(r8).start(r9, r10);     // Catch: Throwable -> L32
        monitor-exit(this);
    }

    private void doSingleRemoveAction(View r3, RecycleItem r4, boolean r5) {
        if (this.mIsSearch == false) goto L5;
        HorizontalScrollListView r0 = this.mSearchResultList;
    L6:
        if (r0 == null) goto L9;
        r0.restoreScrollState(true);
        deleteSingleRawContact(r3, r5, r4);
        return;
    L9:
        return;
    L5:
        r0 = this.mRawContactListView;
        goto L6
    }

    private void deleteRawContacts(final boolean r3, final List<RecycleItem> r4) {
        this.mHandler.post(new AnonymousClass23(this, r3, r4));
    }

    private synchronized void deleteSingleRawContact(View r2, boolean r3, RecycleItem r4) {
        monitor-enter(this);
        View r5 = r2.findViewById(R.id.contact_list_item);     // Catch: Throwable -> L26
        if (r5 == null) goto L7;
        r5.setTag(null);     // Catch: Throwable -> L26
    L7:
        RecycleItem.deleteSingleRawContact(this.mContext, r3, r4);     // Catch: Throwable -> L26
        if (this.mIsSearch == false) goto L17;
        List<RecycleItem> r6 = this.mSearchResultAdapter.getList();     // Catch: Throwable -> L26
        if (r6 == null) goto L17;
        r6.remove(r4);     // Catch: Throwable -> L26
        if (r6.size() == 0) goto L14;
    L16:
        this.mSearchResultAdapter.notifyDataSetChanged();     // Catch: Throwable -> L26
        goto L17
    L14:
        if (this.mSearchResultList.getEmptyView() != null) goto L16;
        this.mSearchResultList.setEmptyView(this.mSearchEmptyView);     // Catch: Throwable -> L26
    L17:
        List<RecycleItem> r7 = this.mRecycleItemListAdapter.getList();     // Catch: Throwable -> L26
        if (r7 == null) goto L24;
        r7.remove(r4);     // Catch: Throwable -> L26
        this.mRecycleItemListAdapter.notifyDataSetChanged();     // Catch: Throwable -> L26
        if (r7.isEmpty() == false) goto L24;
        this.mBtnRight.setEnabled(false);     // Catch: Throwable -> L26
        LinearLayout r8 = this.mSearchBarContainer;     // Catch: Throwable -> L26
        if (r8 == null) goto L24;
        ViewKt.setGone(r8, true);     // Catch: Throwable -> L26
    L24:
        monitor-exit(this);
        return;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r3, int r4, Intent r5) {
        if (r3 == 9) goto L5;
        return;
    L5:
        if (r4 != (-1)) goto L18;
        RecycleItem r6 = (RecycleItem) r5.getParcelableExtra("recycle_item");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r6.rawContactId + " is restored or deleted");
        RecycleItemListAdapter r7 = this.mRecycleItemListAdapter;
        if (r7 == null) goto L11;
        List<RecycleItem> r8 = r7.getList();
        if (r8 == null) goto L11;
        r8.remove(r6);
        this.mRecycleItemListAdapter.notifyDataSetChanged();
    L11:
        RecycleBinSearchResultAdapter r9 = this.mSearchResultAdapter;
        if (r9 == null) goto L19;
        List<RecycleItem> r10 = r9.getList();
        if (r10 == null) goto L20;
        r10.remove(r6);
        this.mSearchResultAdapter.notifyDataSetChanged();
        return;
    L20:
        return;
    L19:
        return;
    }

    private void processSelectOnItemClicked(int r2) {
        RecycleItem r3 = this.mRecycleItemListAdapter.getItem(r2);
        if (this.mSelectedSet.contains(r3) == false) goto L5;
        this.mSelectedSet.remove(r3);
        return;
    L5:
        this.mSelectedSet.add(r3);
    }

    private List<RecycleItem> loadRecycleItems() {
        HashMap r0 = new HashMap();
        Cursor r1 = this.mContext.getContentResolver().query(RecycleBinConstants.RAW_CONTACTS_URI, getRawContactProjection(), null, null, null);
        int r4 = 0;
        if (r1 == null) goto L21;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
    L18:
        r1.close();
        goto L21
    L5:
        if (this.DBG == false) goto L7;
        DatabaseUtils.dumpCursor(r1);     // Catch: Throwable -> L14 IllegalStateException -> L16
    L7:
        if (r1.moveToNext() == false) goto L18;
        RecycleItem r5 = new RecycleItem();     // Catch: Throwable -> L14 IllegalStateException -> L16
        r5.rawContactId = r1.getLong(0);     // Catch: Throwable -> L14 IllegalStateException -> L16
        r5.displayName = ContactsUtils.getContactName(this.mContext, r1.getString(1));     // Catch: Throwable -> L14 IllegalStateException -> L16
        String r6 = r1.getString(2);     // Catch: Throwable -> L14 IllegalStateException -> L16
        if (TextUtils.isEmpty(r6) == false) goto L12;
        r6 = ContactsUtils.CHAR_POUND;
    L12:
        r5.sortkey = r6;     // Catch: Throwable -> L14 IllegalStateException -> L16
        r5.setSrcAccount(r1.getString(3), r1.getString(4), r1.getString(5));     // Catch: Throwable -> L14 IllegalStateException -> L16
        r5.setRecycleDate(r1.getLong(8));     // Catch: Throwable -> L14 IllegalStateException -> L16
        r5.setCallingInfo(this.mContext, r1.getString(6), r1.getString(7));     // Catch: Throwable -> L14 IllegalStateException -> L16
        r0.put(Long.valueOf(r5.rawContactId), r5);     // Catch: Throwable -> L14 IllegalStateException -> L16
        goto L7
    L21:
        Cursor r2 = this.mContext.getContentResolver().query(RecycleBinConstants.DATA_URI, RecycleBinConstants.DataQuery.DATA_PROJECTION, null, null, "_id ASC LIMIT 5000 OFFSET " + r4);
        if (r2 == null) goto L61;
        int r7 = r2.getCount();
        if (ContactsUtils.DEBUG == false) goto L63;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "offset = " + r4 + ", count = " + r7);
    L63:
        if (this.DBG == false) goto L30;
        DatabaseUtils.dumpCursor(r2);     // Catch: Throwable -> L51 IllegalStateException -> L53
    L30:
        if (r2.moveToNext() == false) goto L55;
        long r8 = r2.getLong(1);     // Catch: Throwable -> L51 IllegalStateException -> L53
        if (r0.containsKey(Long.valueOf(r8)) == false) goto L30;
        RecycleItem r9 = (RecycleItem) r0.get(Long.valueOf(r8));     // Catch: Throwable -> L51 IllegalStateException -> L53
        if ("vnd.android.cursor.item/photo".equals(r2.getString(2)) == true) goto L35;
        ContentValues r10 = new ContentValues();     // Catch: Throwable -> L51 IllegalStateException -> L53
        DatabaseUtils.cursorRowToContentValues(r2, r10);     // Catch: Throwable -> L51 IllegalStateException -> L53
        if (r9.getPrimaryDataRow() != null) goto L45;
        if ("vnd.android.cursor.item/phone_v2".equals(r10.getAsString("mimetype")) == false) goto L42;
    L43:
        r9.setPrimaryDataRow(r10);     // Catch: Throwable -> L51 IllegalStateException -> L53
    L49:
        r9.addDataRow(r10);     // Catch: Throwable -> L51 IllegalStateException -> L53
        goto L30
    L42:
        if ("vnd.android.cursor.item/email_v2".equals(r10.getAsString("mimetype")) == false) goto L49;
    L45:
        if ("vnd.android.cursor.item/phone_v2".equals(r10.getAsString("mimetype")) == false) goto L49;
        if ("vnd.android.cursor.item/email_v2".equals(r9.getPrimaryDataRow().getAsString("mimetype")) == false) goto L49;
        r9.setPrimaryDataRow(r10);     // Catch: Throwable -> L51 IllegalStateException -> L53
        goto L49
    L35:
        r9.photoBytes = r2.getBlob(20);     // Catch: Throwable -> L51 IllegalStateException -> L53
    L55:
        r2.close();
        if (r7 < 5000) goto L61;
        r4 = r4 + 5000;
        goto L21
    L51:
        th = move-exception;
        r2.close();
        throw th;
    L53:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L51
    L61:
        ArrayList r12 = new ArrayList(r0.values());
        Collections.sort(r12, new RecycleItemSortComparator());
        return r12;
    L14:
        th = move-exception;
        r1.close();
        throw th;
    }

    @Override // com.android.contacts.recyclebin.IRecycleSearchBarView
    public void setSoftKeyboardHideIView() {
        hideSoftKeyboard();
    }

    private void hideSoftKeyboard() {
        ((InputMethodManager) this.mActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.mRawContactListView.getWindowToken(), 0);
    }

    @Override // com.android.contacts.recyclebin.IRecycleSearchBarView
    public void startContactAnimationIView() {
        ContactsUtils.setAnimatorScale(this.mActivity);
        this.mSeachResultView.setVisibility(0);
        this.mSeachResultBG.setVisibility(0);
        AnimatorSet r0 = this.mStartSearchAnimatorSet;
        if (r0 == null) goto L6;
        r0.start();
        return;
    L6:
        final int r1 = this.mTitleBarHolder.getTitleBar().getHeight();
        ObjectAnimator r3 = ObjectAnimator.ofPropertyValuesHolder(this.mContactsFrameView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(MaterialConfigFormatNames.Y, new float[]{0.0f, -r1})});
        ObjectAnimator r4 = ObjectAnimator.ofPropertyValuesHolder(this.mSeachResultView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("alpha", new float[]{0.0f, 1.0f})});
        AnimatorSet r6 = new AnimatorSet();
        this.mStartSearchAnimatorSet = r6;
        r6.setStartDelay(10);
        this.mStartSearchAnimatorSet.setDuration(this.mDuration);
        this.mStartSearchAnimatorSet.playTogether(new Animator[]{r3, r4});
        this.mStartSearchAnimatorSet.addListener(new AnonymousClass24(this, r1));
        this.mStartSearchAnimatorSet.start();
    }

    private void searchAnimationEnd() {
        new Handler().postDelayed(new AnonymousClass25(this), 30);
    }

    @Override // com.android.contacts.recyclebin.IRecycleSearchBarView
    public void endContactAnimationIView() {
        int r0 = this.mTitleBarHolder.getTitleBar().getHeight();
        ContactsUtils.setAnimatorScale(this.mActivity);
        this.mSearchKey = null;
        ObjectAnimator r1 = ObjectAnimator.ofPropertyValuesHolder(this.mContactsFrameView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(MaterialConfigFormatNames.Y, new float[]{-r0, 0.0f})});
        ObjectAnimator r2 = ObjectAnimator.ofPropertyValuesHolder(this.mSeachResultView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("alpha", new float[]{1.0f, 0.0f})});
        AnimatorSet r5 = new AnimatorSet();
        r5.setDuration(this.mDuration);
        r5.playTogether(new Animator[]{r1, r2});
        r5.addListener(new AnonymousClass26(this));
        r5.start();
    }

    private void getAllsearch(String r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        SearchThread r0 = this.mSearchThread;
        AnonymousClass1 r1 = null;
        if (r0 == null) goto L8;
        r0.setTrue(false);
        this.mSearchThread = null;
    L8:
        if (TextUtils.isEmpty(r4) == false) goto L11;
        this.mSearchResultList.setVisibility(8);
        this.mSearchResultAdapter.setList(null, null);
        this.mSearchEmptyView.setVisibility(8);
        return;
    L11:
        if (this.mSearchThread != null) goto L15;
        SearchThread r2 = new SearchThread(this, r1);
        this.mSearchThread = r2;
        r2.setSearchKey(r4);
        this.mSearchThread.start();
        return;
    }

    @Override // com.android.contacts.recyclebin.IRecycleSearchBarView
    public void onQueryTextChangeIView(String r1) {
        this.mSearchKey = r1;
        getAllsearch(r1);
    }

    public void processEditContacts(boolean r3, boolean r4) {
        processEditContacts(r3, r4, 0, null);
    }

    private void processEditContacts(boolean r4, boolean r5, int r6, List<RecycleItem> r7) {
        this.mIsEdit = r4;
        HeadersListView r0 = this.mRawContactListView;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r4 == false) goto L8;
        r0.restoreScrollState(false);
    L8:
        this.mRawContactListView.setScrollEnabled(!r4);
        if (r4 == false) goto L11;
        this.mTitleBarHolder.stateTo(OFloatingTitleBarHolder.STATE_EDIT);
        refreshOptionBar(0);
    L16:
        if (r5 == false) goto L18;
        performAnimationForEdit(r4, this.mRawContactListView, r6, r7);
        return;
    L18:
        notPerformAnimationForEdit(r4, this.mRawContactListView);
        return;
    L11:
        this.mTitleBarHolder.stateTo(OFloatingTitleBarHolder.STATE_NORMAL);
        this.mSelectedSet.clear();
        OFloatingTitleBarHolder r1 = this.mTitleBarHolder;
        if (r1 == null) goto L16;
        if (r1.getCenterTitleView() == null) goto L16;
        this.mTitleBarHolder.getCenterTitleView().setText(getResources().getString(R.string.setting_contacts_recycle_bin));
        goto L16
    }

    private void performAnimationForEdit(boolean r6, ListView r7, int r8, List<RecycleItem> r9) {
        if (r6 == false) goto L5;
        this.mListAnimator.startEdit(this.mContactsFrameView, r7, this.mBottomActionBarHolder.getBottomActionBar());
        this.mBottomActionBarHolder.getBottomActionBar().setVisibility(0);
    L7:
        if (this.mSearchBarContainer != null) goto L9;
    L16:
        refreshAdapter(r6);
        freezeButtonWhenEditContacts(false);
        if (r8 == 1) goto L19;
        if (r8 == 2) goto L19;
        return;
    L19:
        Context r0 = this.mContext;
        if (r8 != 2) goto L22;
        boolean r10 = true;
    L23:
        new DeleteRawContactsTask(this, r0, r10).execute(new List[]{r9});
        return;
    L22:
        r10 = false;
        goto L23
    L9:
        if (this.mOSearchBarV2 == null) goto L16;
        getPresenter().setSearchBarEnable(!r6);
        getPresenter().setSearchBarVisible(true);
        if (r6 == false) goto L15;
        OIconButtonFloating r11 = this.mSearchFieldBtn;
        if (r11 == null) goto L15;
        r11.setVisibility(8);
    L15:
        this.mSearchBarContainer.setEnabled(!r6);
        this.mSearchBarContainer.setClickable(!r6);
        this.mSearchBarContainer.setLongClickable(!r6);
        goto L16
    L5:
        this.mListAnimator.finishEdit(this.mContactsFrameView, r7, this.mBottomActionBarHolder.getBottomActionBar());
        this.mBottomActionBarHolder.getBottomActionBar().setVisibility(8);
        goto L7
    }

    private void triggerLoad(boolean r4) {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (getActivity().isFinishing() == true) goto L13;
        this.mBackgroundHandler.removeMessages(NOTIFY_LOAD_RECYCLE_BIN);
        this.mBackgroundHandler.sendEmptyMessage(NOTIFY_LOAD_RECYCLE_BIN);
        if (r4 == false) goto L12;
        this.mHandler.removeMessages(NOTIFY_PROGRESS_DIALOG_DISPLAY);
        this.mHandler.sendEmptyMessageDelayed(NOTIFY_PROGRESS_DIALOG_DISPLAY, 500);
        return;
    L12:
        return;
    }

    private void notPerformAnimationForEdit(boolean r3, ListView r4) {
        if (r3 == false) goto L5;
        this.mBottomActionBarHolder.getBottomActionBar().setVisibility(0);
    L7:
        if (this.mSearchBarContainer != null) goto L9;
    L16:
        refreshAdapter(r3);
        return;
    L9:
        if (this.mOSearchBarV2 == null) goto L16;
        getPresenter().setSearchBarEnable(!r3);
        getPresenter().setSearchBarVisible(true);
        if (r3 == false) goto L15;
        OIconButtonFloating r5 = this.mSearchFieldBtn;
        if (r5 == null) goto L15;
        r5.setVisibility(8);
    L15:
        this.mSearchBarContainer.setEnabled(!r3);
        this.mSearchBarContainer.setClickable(!r3);
        this.mSearchBarContainer.setLongClickable(!r3);
        goto L16
    L5:
        this.mBottomActionBarHolder.getBottomActionBar().setVisibility(8);
        freezeButtonWhenEditContacts(false);
        goto L7
    }

    private void freezeButtonWhenEditContacts(boolean r2) {
        if (r2 == false) goto L5;
        this.mBtnRight.setEnabled(false);
        return;
    L5:
        if (this.mIsEdit == false) goto L7;
        this.mBtnRight.setEnabled(true);
        return;
    L7:
        RecycleItemListAdapter r3 = this.mRecycleItemListAdapter;
        if (r3 != null) goto L10;
        return;
    L10:
        if (r3.getCount() == 0) goto L16;
        this.mBtnRight.setEnabled(true);
        return;
    }

    private void refreshAdapter(boolean r3) {
        RecycleItemListAdapter r0 = this.mRecycleItemListAdapter;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mRawContactListView == null) goto L10;
        r0.setEdit(r3);
        this.mRecycleItemListAdapter.notifyDataSetChanged();
        this.mRawContactListView.setSlideEnable(r3);
        return;
    }

    private void setEmptyView(ListView r3) {
        if (isAdded() == true) goto L6;
        return;
    L6:
        if (this.mRecycleBinEmptyView != null) goto L8;
        this.mRecycleBinEmptyViewStub.inflate();
        RelativeLayout r0 = (RelativeLayout) this.mFragment.findViewById(R.id.recycle_bin_contact_empty);
        this.mRecycleBinEmptyView = r0;
        OPageStatus r1 = (OPageStatus) r0.findViewById(R.id.black_view);
        r1.setTitle(getString(R.string.recycle_bin_empty));
        r1.setMessage(getString(R.string.recycle_bin_empty_secondary));
    L8:
        r3.setEmptyView(this.mRecycleBinEmptyView);
    }

    private void refreshOptionBar(int r7) {
        RecycleItemListAdapter r0 = this.mRecycleItemListAdapter;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.getCount();
        boolean r4 = false;
        String r2 = getResources().getString(R.string.edit_contacts_option_bar_msg, new Object[]{Integer.valueOf(r7), Integer.valueOf(r1)});
        OButtonFloating r3 = this.mBottomActionBarHolder.getLeftBtn();
        if (r7 == 0) goto L8;
        boolean r5 = true;
    L9:
        r3.setEnabled(r5);
        OButtonFloating r6 = this.mBottomActionBarHolder.getRightBtn();
        if (r7 == 0) goto L12;
        boolean r8 = true;
    L13:
        r6.setEnabled(r8);
        if (this.mIsEdit == false) goto L20;
        OFloatingTitleBarHolder r9 = this.mTitleBarHolder;
        if (r9 == null) goto L20;
        if (r9.getCenterTitleView() == null) goto L20;
        this.mTitleBarHolder.getCenterTitleView().setText(r2);
    L20:
        View r10 = this.mBtnSelectAll;
        if (r10 == null) goto L25;
        if (r1 == 0) goto L24;
        r4 = true;
    L24:
        r10.setEnabled(r4);
    L25:
        TextView r11 = this.mBtnSelectAllTextView;
        if (r11 == null) goto L33;
        if (r1 == 0) goto L30;
        if (r7 != r1) goto L30;
        int r12 = R.string.common_cancel;
    L31:
        r11.setText(getResources().getString(r12));
        return;
    L30:
        r12 = R.string.select_all;
        goto L31
    L33:
        return;
    L12:
        r8 = false;
        goto L13
    L8:
        r5 = false;
        goto L9
    }

    private void showProgressDialog() {
        final FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isFinishing() == false) goto L7;
        return;
    L7:
        if (r0.isDestroyed() == false) goto L10;
        return;
    L10:
        if (this.mProgress != null) goto L13;
        ProgressDialog r1 = new ProgressDialog(this.mContext);
        this.mProgress = r1;
        r1.setMessage(getString(R.string.dialog_content_wait_message));
        this.mProgress.setCancelable(false);
        this.mProgress.setOnCancelListener(new AnonymousClass29(this, r0));
    L13:
        if (this.mProgress.isShowing() == true) goto L18;
        this.mProgress.show();
        this.mProgressShowTime = SystemClock.elapsedRealtime();
        return;
    }

    public void hideProgressDialog() {
        ProgressDialog r0 = this.mProgress;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L9;
        this.mProgress.dismiss();
        this.mProgressShowTime = 0;
        return;
    }

    private static void log(String r1) {
        if (ContactsUtils.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r1);
        return;
    }
}
