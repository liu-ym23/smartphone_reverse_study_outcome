package com.android.contacts.setting;

import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.ContactsContract;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.loader.app.LoaderManager;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.PreferencesCallback;
import com.android.contacts.R;
import com.android.contacts.group.GroupSelectionActivity;
import com.android.contacts.list.SlideExpandableListView;
import com.android.contacts.pick.PickerFragment;
import com.android.contacts.util.Constants;
import com.android.contacts.util.NameConverter;
import com.android.contacts.util.NameSortComparator;
import com.android.contacts.util.TitleBarUtil;
import com.android.contacts.widget.ProgressDialog;
import com.android.contacts.widget.ProgressDialogKt;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.immersive.Immersive;
import com.obric.oui.button.OButton;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.dialog.alert.OAlertDialog;
import com.obric.oui.dialog.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.input.InputBodyController;
import com.obric.oui.forms.OEditText;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.ui.OFloatingTitleBarHolder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import obric.util.NavigationBarHelper;

/* JADX INFO: loaded from: classes2.dex */
public class ManualJoinContactFragment extends Fragment implements View.OnClickListener, ManualJoinContactAdapter.JoinedContactNameEditListener {
    public static final int COMPLETED = 3;
    private static final boolean DEBUG_SUGGESTIONS = false;
    private static final int LOADER_CONTACTS = 0;
    public static final int SCANNED = 1;
    public static final int SELECTED = 2;
    public static final int START = 0;
    private static final String TAG = "ManualJoinContact";
    private ManualJoinContactAdapter mAdapter;
    private int mAggregateState;
    private AggregationTask mAggregationTask;
    private View mBtnOperation;
    private OTextView mBtnOperationTextView;
    private OCheckBox mCheckBox;
    private final LoaderManager.LoaderCallbacks<Cursor> mContactsLoaderListener;
    private Activity mContext;
    private OPageStatus mEmptyView;
    private RelativeLayout mJoinContactEmptyView;
    private ViewStub mJoinContactEmptyViewStub;
    private ManualJoinContactListener mJoinContactListener;
    private LoadSuggestionsTask mLoadSuggestionsTask;
    private Observer<Integer> mNavigationBarObserver;
    private View mOptionBar;
    private PreferencesCallback mPreferencesCallback;
    private ProgressDialog mProgressDialogForAggregation;
    private ProgressDialog mProgressDialogForScan;
    private TextView mSizeView;
    private List<List<AggregationSuggestionUnit>> mSuggestionGroupList;
    private SlideExpandableListView mSuggestionsListView;
    private OFloatingTitleBarHolder mTitleBarHolder;
    private View mView;
    private TextView primaryHint;
    private TextView secondaryHint;

    private class AggregationTask extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ ManualJoinContactFragment this$0;

        private AggregationTask(ManualJoinContactFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ AggregationTask(ManualJoinContactFragment r1, AnonymousClass1 r2) {
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
            ManualJoinContactFragment.access$1600(this.this$0);
            return null;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Void r4) {
            new Handler(Looper.getMainLooper()).postDelayed(new AnonymousClass1(this), 300);
        }
    }

    private interface JoinContactQuery {
        public static final int CONTACT_ID = 1;
        public static final int DISPLAY_NAME_SOURCE = 2;
        public static final String[] PROJECTION = null;
        public static final int _ID = 0;

        static {
            PROJECTION = new String[]{"_id", "contact_id", "display_name_source"};
        }
    }

    private class LoadSuggestionsTask extends AsyncTask<Cursor, Void, Map<Long, List<AggregationSuggestionUnit>>> {
        final /* synthetic */ ManualJoinContactFragment this$0;

        private LoadSuggestionsTask(ManualJoinContactFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ LoadSuggestionsTask(ManualJoinContactFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Map<Long, List<AggregationSuggestionUnit>> doInBackground(Cursor[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Map<Long, List<AggregationSuggestionUnit>> r1) {
            onPostExecute2(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Map<Long, List<AggregationSuggestionUnit>> doInBackground2(Cursor... r2) {
            return ManualJoinContactFragment.access$1300(this.this$0, r2[0]);
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Map<Long, List<AggregationSuggestionUnit>> r4) {
            if (ManualJoinContactFragment.access$1400(this.this$0) == null) goto L8;
            if (ManualJoinContactFragment.access$1400(this.this$0).isShowing() == false) goto L8;
            ManualJoinContactFragment.access$1400(this.this$0).dismiss();
            ManualJoinContactFragment.access$1402(this.this$0, null);
        L8:
            if (ManualJoinContactFragment.access$1500(this.this$0) == null) goto L13;
            if (ManualJoinContactFragment.access$1500(this.this$0).isShowing() == false) goto L13;
            ManualJoinContactFragment.access$1500(this.this$0).dismiss();
            ManualJoinContactFragment.access$1502(this.this$0, null);
        L13:
            if (ManualJoinContactFragment.access$100(this.this$0) != null) goto L15;
            ManualJoinContactFragment.access$102(this.this$0, new ManualJoinContactAdapter(this.this$0));
            ManualJoinContactFragment.access$000(this.this$0).setAdapter(ManualJoinContactFragment.access$100(this.this$0));
        L15:
            if (r4 != null) goto L17;
        L26:
            ManualJoinContactFragment.access$100(this.this$0).setSuggestionContacts(new ArrayList());
            ManualJoinContactFragment.access$100(this.this$0).notifyDataSetChanged();
            ManualJoinContactFragment.access$500(this.this$0, 3);
            return;
        L17:
            if (r4.size() <= 0) goto L26;
            ManualJoinContactFragment.access$302(this.this$0, new ArrayList());
            Iterator<List<AggregationSuggestionUnit>> r5 = r4.values().iterator();
        L20:
            if (r5.hasNext() == false) goto L25;
            List<AggregationSuggestionUnit> r0 = r5.next();
            if (r0.size() < 2) goto L20;
            ManualJoinContactFragment.access$300(this.this$0).add(r0);
            goto L20
        L25:
            ManualJoinContactFragment.access$100(this.this$0).setSuggestionContacts(ManualJoinContactFragment.access$300(this.this$0));
            ManualJoinContactFragment.access$100(this.this$0).setJoinedContactNameEditListener(this.this$0);
            ManualJoinContactFragment.access$100(this.this$0).notifyDataSetChanged();
            ManualJoinContactFragment.access$500(this.this$0, 1);
        }
    }

    interface ManualJoinContactListener {
        void aggregateStateUpdated(int r1);
    }

    private static final class RawContactsQuery {
        public static final int CONTACT_ID = 2;
        public static final int DATA1 = 4;
        public static final int DISPLAY_NAME = 10;
        public static final int FAMILY_NAME = 8;
        public static final int GIVEN_NAME = 6;
        public static final int HAS_PHONE_NUMBER = 13;
        public static final int ID = 0;
        public static final int LOOKUP_KEY = 12;
        public static final int MIDDLE_NAME = 7;
        public static final int MIMETYPE = 3;
        public static final int PHONEBOOK_LABEL = 14;
        public static final int PREFIX = 5;
        public static final int RAW_CONTACT_ID = 1;
        public static final int SORT_KEY = 11;
        public static final int SUFFIX = 9;
        public static final String[] _PROJECTION_DATA_ALTERNATIVE_ALTERNATIVE = null;
        public static final String[] _PROJECTION_DATA_ALTERNATIVE_PRIMARY = null;
        public static final String[] _PROJECTION_DATA_PRIMARY_ALTERNATIVE = null;
        public static final String[] _PROJECTION_DATA_PRIMARY_PRIMARY = null;

        private RawContactsQuery() {
        }

        static {
            _PROJECTION_DATA_PRIMARY_PRIMARY = new String[]{"_id", GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, "contact_id", "mimetype", "data1", "data4", DBHelper.COL_DATA2, "data5", DBHelper.COL_DATA3, "data6", "display_name", PickerFragment.CONTACT_SORT_CNAME, "lookup", "has_phone_number", Constants.ContactsColumns.PHONEBOOK_LABEL_ALTERNATIVE};
            _PROJECTION_DATA_PRIMARY_ALTERNATIVE = new String[]{"_id", GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, "contact_id", "mimetype", "data1", "data4", DBHelper.COL_DATA2, "data5", DBHelper.COL_DATA3, "data6", "display_name", "sort_key_alt", "lookup", "has_phone_number", Constants.ContactsColumns.PHONEBOOK_LABEL_ALTERNATIVE};
            _PROJECTION_DATA_ALTERNATIVE_PRIMARY = new String[]{"_id", GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, "contact_id", "mimetype", "data1", "data4", DBHelper.COL_DATA2, "data5", DBHelper.COL_DATA3, "data6", "display_name_alt", PickerFragment.CONTACT_SORT_CNAME, "lookup", "has_phone_number", Constants.ContactsColumns.PHONEBOOK_LABEL_PRIMARY};
            _PROJECTION_DATA_ALTERNATIVE_ALTERNATIVE = new String[]{"_id", GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, "contact_id", "mimetype", "data1", "data4", DBHelper.COL_DATA2, "data5", DBHelper.COL_DATA3, "data6", "display_name_alt", "sort_key_alt", "lookup", "has_phone_number", Constants.ContactsColumns.PHONEBOOK_LABEL_PRIMARY};
        }
    }

    public ManualJoinContactFragment() {
        this.mEmptyView = null;
        this.mNavigationBarObserver = new AnonymousClass1(this);
        this.mContactsLoaderListener = new AnonymousClass7(this);
    }

    static /* synthetic */ SlideExpandableListView access$000(ManualJoinContactFragment r0) {
        return r0.mSuggestionsListView;
    }

    static /* synthetic */ ManualJoinContactAdapter access$100(ManualJoinContactFragment r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ void access$1000(ManualJoinContactFragment r0, Cursor r1) {
        r0.triggerSuggestionsLoad(r1);
    }

    static /* synthetic */ ManualJoinContactAdapter access$102(ManualJoinContactFragment r0, ManualJoinContactAdapter r1) {
        r0.mAdapter = r1;
        return r1;
    }

    static /* synthetic */ Map access$1300(ManualJoinContactFragment r0, Cursor r1) {
        return r0.loadSuggestions(r1);
    }

    static /* synthetic */ ProgressDialog access$1400(ManualJoinContactFragment r0) {
        return r0.mProgressDialogForScan;
    }

    static /* synthetic */ ProgressDialog access$1402(ManualJoinContactFragment r0, ProgressDialog r1) {
        r0.mProgressDialogForScan = r1;
        return r1;
    }

    static /* synthetic */ ProgressDialog access$1500(ManualJoinContactFragment r0) {
        return r0.mProgressDialogForAggregation;
    }

    static /* synthetic */ ProgressDialog access$1502(ManualJoinContactFragment r0, ProgressDialog r1) {
        r0.mProgressDialogForAggregation = r1;
        return r1;
    }

    static /* synthetic */ void access$1600(ManualJoinContactFragment r0) {
        r0.aggregateSelectedContacts();
    }

    static /* synthetic */ void access$1700(ManualJoinContactFragment r0) {
        r0.startLoading();
    }

    static /* synthetic */ void access$200(ManualJoinContactFragment r0, List r1) {
        r0.setFirstCheckedInGroup(r1);
    }

    static /* synthetic */ List access$300(ManualJoinContactFragment r0) {
        return r0.mSuggestionGroupList;
    }

    static /* synthetic */ List access$302(ManualJoinContactFragment r0, List r1) {
        r0.mSuggestionGroupList = r1;
        return r1;
    }

    static /* synthetic */ int access$400(ManualJoinContactFragment r0, List r1, boolean r2) {
        return r0.getItemSize(r1, r2);
    }

    static /* synthetic */ void access$500(ManualJoinContactFragment r0, int r1) {
        r0.setAggregateState(r1);
    }

    static /* synthetic */ void access$600(ManualJoinContactFragment r0) {
        r0.updateOptionBar();
    }

    static /* synthetic */ LoadSuggestionsTask access$700(ManualJoinContactFragment r0) {
        return r0.mLoadSuggestionsTask;
    }

    static /* synthetic */ LoadSuggestionsTask access$702(ManualJoinContactFragment r0, LoadSuggestionsTask r1) {
        r0.mLoadSuggestionsTask = r1;
        return r1;
    }

    static /* synthetic */ Activity access$800(ManualJoinContactFragment r0) {
        return r0.mContext;
    }

    static /* synthetic */ String[] access$900(ManualJoinContactFragment r0) {
        return r0.getRawContactProjection();
    }

    public void setJoinContactListener(ManualJoinContactListener r1) {
        this.mJoinContactListener = r1;
    }

    public void setPrefsCallback(PreferencesCallback r1) {
        this.mPreferencesCallback = r1;
    }

    private int getSortOrder() {
        return this.mPreferencesCallback.getSortOrder();
    }

    private int getDisplayOrder() {
        return this.mPreferencesCallback.getDisplayOrder();
    }

    private void configTitleBar() {
        if (this.mContext == null) goto L9;
        Intent r0 = getActivity().getIntent();
        if (r0 == null) goto L9;
        if (r0.getBooleanExtra(Constants.EXTRA_FROM_SETTINGS, false) == false) goto L9;
        boolean r1 = true;
    L10:
        OFloatingTitleBarHolder r3 = new OFloatingTitleBarHolder((OFloatingTitleBar) this.mView.findViewById(R.id.otitlebar));
        this.mTitleBarHolder = r3;
        r3.addStartAction(OFloatingTitleBarHolder.STATE_NORMAL, TitleBarUtil.getLeftRes(r1), new AnonymousClass2(this));
        View r2 = this.mTitleBarHolder.addEndAction(OFloatingTitleBarHolder.STATE_NORMAL, getResources().getString(R.string.btn_start_scan), new AnonymousClass3(this));
        this.mBtnOperation = r2;
        if ((r2 instanceof ViewGroup) == false) goto L16;
        View r4 = ((ViewGroup) r2).getChildAt(0);
        if ((r4 instanceof OTextView) == false) goto L17;
        OTextView r5 = (OTextView) r4;
        this.mBtnOperationTextView = r5;
        r5.setTextColor(ResourcesCompat.getColor(getResources(), R.color.oui_functional_blue_6, null));
        return;
    L17:
        return;
    L16:
        return;
    L9:
        r1 = false;
        goto L10
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mContext = getActivity();
        this.mView = r2.inflate(R.layout.manual_join_contact_fragment, r3, false);
        configTitleBar();
        SlideExpandableListView r5 = (SlideExpandableListView) this.mView.findViewById(R.id.suggestions_list);
        this.mSuggestionsListView = r5;
        NavigationBarHelper.setBottomPaddingWhenNavigationBarStatusChange(r5);
        this.mJoinContactEmptyViewStub = (ViewStub) this.mView.findViewById(R.id.listview_emptyview_stub);
        this.mOptionBar = this.mView.findViewById(R.id.option_bar);
        this.mSizeView = (TextView) this.mView.findViewById(R.id.option_size);
        OCheckBox r6 = (OCheckBox) this.mView.findViewById(R.id.checkBox);
        this.mCheckBox = r6;
        r6.setOnClickListener(this);
        this.mSuggestionsListView.setOnChildClickListener(new AnonymousClass4(this));
        this.mSuggestionsListView.setSlideListener(new AnonymousClass5(this));
        setAggregateState(0);
        Immersive.Companion.getImmersive(getActivity()).getNavigationBarHeight().observeForever(this.mNavigationBarObserver);
        return this.mView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Immersive.Companion.getImmersive(getActivity()).getNavigationBarHeight().removeObserver(this.mNavigationBarObserver);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        if (r5.getId() != R.id.checkBox) goto L23;
        boolean r6 = this.mCheckBox.isChecked();
        Iterator<List<AggregationSuggestionUnit>> r0 = this.mSuggestionGroupList.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        List<AggregationSuggestionUnit> r1 = r0.next();
        Iterator<AggregationSuggestionUnit> r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L7;
        r2.next().setChecked(r6);
        setFirstCheckedInGroup(r1);
        goto L10
    L12:
        ManualJoinContactAdapter r7 = this.mAdapter;
        if (r7 == null) goto L16;
        r7.notifyDataSetChanged();
    L16:
        if (getItemSize(this.mSuggestionGroupList, true) <= 0) goto L18;
        setAggregateState(2);
    L19:
        updateOptionBar();
        return;
    L18:
        setAggregateState(1);
        goto L19
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        log("onDestroy");
        cancelLoad();
    }

    private void cancelLoad() {
        LoadSuggestionsTask r0 = this.mLoadSuggestionsTask;
        if (r0 == null) goto L5;
        r0.cancel(true);
        this.mLoadSuggestionsTask = null;
    L5:
        AggregationTask r1 = this.mAggregationTask;
        if (r1 == null) goto L9;
        r1.cancel(true);
        this.mAggregationTask = null;
        return;
    }

    private void updateEmptyView() {
        if (isAdded() == true) goto L6;
        return;
    L6:
        if (this.mJoinContactEmptyView != null) goto L9;
        this.mJoinContactEmptyViewStub.inflate();
        RelativeLayout r0 = (RelativeLayout) this.mView.findViewById(R.id.join_contact_empty);
        this.mJoinContactEmptyView = r0;
        OPageStatus r1 = (OPageStatus) r0.findViewById(R.id.black_view);
        this.mEmptyView = r1;
        r1.setTitle(getString(R.string.common_merge_duplicate_contacts));
        this.primaryHint = this.mEmptyView.getTitleView();
        this.mEmptyView.setMessage(getString(R.string.join_contact_empty_secondary));
        this.secondaryHint = this.mEmptyView.getMessageView();
    L9:
        if (this.mAggregateState != 3) goto L11;
        this.primaryHint.setText(R.string.join_contact_empty_scanned);
        this.secondaryHint.setVisibility(8);
    L12:
        this.mSuggestionsListView.setEmptyView(this.mJoinContactEmptyView);
        return;
    L11:
        this.primaryHint.setText(R.string.common_merge_duplicate_contacts);
        this.secondaryHint.setVisibility(0);
        goto L12
    }

    private void updateOptionBar() {
        if (isAdded() == true) goto L5;
        return;
    L5:
        int r0 = this.mAggregateState;
        boolean r1 = true;
        if (r0 == 1) goto L12;
        if (r0 == 2) goto L12;
        this.mOptionBar.setVisibility(8);
        return;
    L12:
        if (this.mOptionBar.getVisibility() == 0) goto L14;
        this.mOptionBar.setVisibility(0);
    L14:
        int r2 = getItemSize(this.mSuggestionGroupList, true);
        int r3 = getItemSize(this.mSuggestionGroupList, false);
        this.mSizeView.setText("(" + r2 + LibrarianImpl.Constants.SEPARATOR + r3 + ")");
        OCheckBox r6 = this.mCheckBox;
        if (r2 == r3) goto L18;
        r1 = false;
    L18:
        r6.setChecked(r1);
    }

    private int getItemSize(List<List<AggregationSuggestionUnit>> r5, boolean r6) {
        if (r5 == null) goto L34;
        Iterator<List<AggregationSuggestionUnit>> r7 = r5.iterator();
        int r0 = 0;
    L6:
        if (r7.hasNext() == false) goto L20;
        List<AggregationSuggestionUnit> r1 = r7.next();
        if (r6 == true) goto L9;
        r0 = r0 + r1.size();
        goto L6
    L9:
        Iterator<AggregationSuggestionUnit> r2 = r1.iterator();
        int r3 = 0;
    L11:
        if (r2.hasNext() == false) goto L16;
        if (r2.next().isChecked() == false) goto L11;
        r3 = r3 + 1;
        goto L11
    L16:
        if (r3 <= 1) goto L6;
        r0 = r0 + r3;
        goto L6
    L20:
        return r0;
    L34:
        return 0;
    }

    private void setAggregateState(int r1) {
        this.mAggregateState = r1;
        aggregateStateUpdated(r1);
        updateEmptyView();
        updateOptionBar();
    }

    private void aggregateStateUpdated(int r4) {
        View r0 = this.mBtnOperation;
        if (r4 == 1) goto L5;
        boolean r2 = true;
    L6:
        r0.setEnabled(r2);
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L10;
        this.mBtnOperationTextView.setText(R.string.common_merge);
        return;
    L10:
        if (r4 != 3) goto L18;
        this.mBtnOperationTextView.setText(R.string.common_done);
        return;
    L18:
        return;
    L14:
        this.mBtnOperationTextView.setText(R.string.btn_start_scan);
        return;
    L5:
        r2 = false;
        goto L6
    }

    private void startLoading() {
        ProgressDialog r0 = this.mProgressDialogForAggregation;
        if (r0 != null) goto L5;
    L6:
        showScanProgressDialog();
    L7:
        LoaderManager.getInstance(this).restartLoader(0, null, this.mContactsLoaderListener);
        return;
    L5:
        if (r0.isShowing() == true) goto L7;
        goto L6
    }

    private void startAggregation() {
        showAggregationProgressDialog();
        triggerAggregation();
    }

    private void showScanProgressDialog() {
        if (this.mProgressDialogForScan != null) goto L5;
        String r0 = getString(R.string.scan_suggestions);
        ProgressDialog r2 = new ProgressDialog(this.mContext);
        this.mProgressDialogForScan = r2;
        r2.setTitle(r0);
        this.mProgressDialogForScan.setCancelable(false);
        this.mProgressDialogForScan.setDim(ProgressDialogKt.getTargetWindowDimAmount(this.mContext));
        this.mProgressDialogForScan.setOnCancelListener(new AnonymousClass6(this));
    L5:
        this.mProgressDialogForScan.setMessage(getString(R.string.scan_suggestions_progress_message, new Object[]{0}));
        this.mProgressDialogForScan.show();
    }

    private void showAggregationProgressDialog() {
        if (this.mProgressDialogForAggregation != null) goto L5;
        String r0 = getString(R.string.join_contacts_msg);
        ProgressDialog r2 = new ProgressDialog(this.mContext);
        this.mProgressDialogForAggregation = r2;
        r2.setTitle(r0);
        this.mProgressDialogForAggregation.setCancelable(false);
        this.mProgressDialogForAggregation.setDim(ProgressDialogKt.getTargetWindowDimAmount(this.mContext));
    L5:
        this.mProgressDialogForAggregation.setMessage(getString(R.string.join_contact_progress_message, new Object[]{0, Integer.valueOf(getItemSize(this.mSuggestionGroupList, true))}));
        this.mProgressDialogForAggregation.show();
    }

    private String[] getRawContactProjection() {
        int r0 = getDisplayOrder();
        int r2 = getSortOrder();
        if (r0 != 1) goto L9;
        if (r2 != 1) goto L8;
        return RawContactsQuery._PROJECTION_DATA_PRIMARY_PRIMARY;
    L8:
        return RawContactsQuery._PROJECTION_DATA_PRIMARY_ALTERNATIVE;
    L9:
        if (r2 != 1) goto L13;
        return RawContactsQuery._PROJECTION_DATA_ALTERNATIVE_PRIMARY;
    L13:
        return RawContactsQuery._PROJECTION_DATA_ALTERNATIVE_ALTERNATIVE;
    }

    private void triggerSuggestionsLoad(Cursor r4) {
        LoadSuggestionsTask r0 = this.mLoadSuggestionsTask;
        if (r0 != null) goto L5;
    L7:
        LoadSuggestionsTask r1 = new LoadSuggestionsTask(this, null);
        this.mLoadSuggestionsTask = r1;
        r1.execute(new Cursor[]{r4});
        return;
    L5:
        if (r0.getStatus() == AsyncTask.Status.FINISHED) goto L7;
        this.mLoadSuggestionsTask.cancel(true);
        goto L7
    }

    private void triggerAggregation() {
        AggregationTask r0 = new AggregationTask(this, null);
        this.mAggregationTask = r0;
        r0.execute(new Void[0]);
    }

    public void doOperation() {
        int r0 = this.mAggregateState;
        if (r0 != 0) goto L5;
        startLoading();
        return;
    L5:
        if (r0 != 2) goto L7;
        startAggregation();
        return;
    L7:
        if (r0 == 3) goto L10;
        return;
    L10:
        if (getActivity() == null) goto L15;
        getActivity().finish();
        return;
    }

    private Map<Long, List<AggregationSuggestionUnit>> loadSuggestions(Cursor r18) {
        HashMap r2 = new HashMap();
        int r3 = 2;
        int r4 = 0;
        if (r18 != null) goto L5;
    L25:
        ArrayList r1 = new ArrayList(r2.values());
        int r5 = 0;
        int r6 = 0;
    L27:
        if (r5 >= (r1.size() - 1)) goto L62;
        AggregationSuggestionUnit r7 = (AggregationSuggestionUnit) r1.get(r5);
        if (r7.getMatchedRawContactId() != (-1)) goto L61;
        int r8 = r5 + 1;
    L33:
        if (r8 >= r1.size()) goto L61;
        AggregationSuggestionUnit r9 = (AggregationSuggestionUnit) r1.get(r8);
        if (r7.getContactId() == r9.getContactId()) goto L60;
        if (r9.getMatchedRawContactId() != (-1)) goto L60;
        String[] r11 = new String[2];
        int r10 = r7.match(r9, r11);
        if (r10 <= 0) goto L60;
        if (r7.getMatchedRawContactId() != (-1)) goto L44;
        r7.setMatchedRawContactId(r7.getRawContactId());
        r6 = r6 + 1;
    L44:
        r6 = r6 + 1;
        if (r7.getMatchedRawContactId() == (-1)) goto L48;
        r9.setMatchedRawContactId(r7.getMatchedRawContactId());
    L48:
        if (r7.getMatchedField() != null) goto L54;
        int r12 = 2;
        if (r10 != 2) goto L52;
        String r14 = ContactsUtils.formatNumber(r11[0]);
    L53:
        r7.setMatchedField(r14);
    L55:
        if (r10 != r12) goto L57;
        String r13 = ContactsUtils.formatNumber(r11[1]);
    L58:
        r9.setMatchedField(r13);
        showSuggestionsScanProgress(r6);
        goto L60
    L57:
        r13 = r11[1];
        goto L58
    L52:
        r14 = r11[0];
        goto L53
    L54:
        r12 = 2;
    L60:
        r8 = r8 + 1;
    L61:
        r5 = r5 + 1;
        goto L27
    L62:
        HashMap r0 = new HashMap();
        Iterator r15 = r1.iterator();
    L64:
        if (r15.hasNext() == false) goto L71;
        AggregationSuggestionUnit r16 = (AggregationSuggestionUnit) r15.next();
        long r17 = r16.getMatchedRawContactId();
        if (r17 == (-1)) goto L64;
        if (r0.get(Long.valueOf(r17)) != null) goto L70;
        r0.put(Long.valueOf(r17), new ArrayList());
    L70:
        ((List) r0.get(Long.valueOf(r17))).add(r16);
        goto L64
    L71:
        Iterator r19 = r0.entrySet().iterator();
    L73:
        if (r19.hasNext() == false) goto L75;
        Collections.sort((List) ((Map.Entry) r19.next()).getValue(), new NameSortComparator());
        goto L73
    L75:
        return r0;
    L5:
        if (r18.isClosed() == true) goto L25;
        r18.moveToPosition(-1);
    L8:
        if (r18.moveToNext() == false) goto L25;
        long r110 = r18.getLong(1);
        long r111 = r18.getLong(r3);
        long r20 = r18.getLong(r4);
        String r21 = r18.getString(4);
        String r112 = r18.getString(3);
        if (r2.get(Long.valueOf(r110)) != null) goto L13;
        AggregationSuggestionUnit r22 = new AggregationSuggestionUnit(r110, r111, this.mContext.getResources().getBoolean(R.bool.config_editor_field_order_primary));
        String r23 = r18.getString(10);
        r22.name = ContactsUtils.getContactName(this.mContext, r23);
        r22.hasname = !TextUtils.isEmpty(r23);
        r22.sortkey = r18.getString(11);
        r22.phoneBookLabel = r18.getString(14);
        r22.section = ContactsUtils.getContactSection(r22.sortkey, r22.phoneBookLabel);
        r2.put(Long.valueOf(r110), r22);
    L13:
        AggregationSuggestionUnit r24 = (AggregationSuggestionUnit) r2.get(Long.valueOf(r110));
        if ("vnd.android.cursor.item/name".equals(r112) == false) goto L17;
        r24.setDisplayName(r21);
        r24.setStructuredNameDataId(r20);
        r24.setSplittedName(r18.getString(5), r18.getString(6), r18.getString(7), r18.getString(8), r18.getString(9));
    L24:
        r3 = 2;
        r4 = 0;
        goto L8
    L17:
        if ("vnd.android.cursor.item/phone_v2".equals(r112) == false) goto L22;
        if (TextUtils.isEmpty(r21) == true) goto L22;
        r24.addPhoneNumber(r21);
    L22:
        if ("vnd.android.cursor.item/email_v2".equals(r112) == false) goto L24;
        r24.addEmail(r21);
        goto L24
    }

    private void showSuggestionsScanProgress(final int r3) {
        if (getActivity() == null) goto L6;
        getActivity().runOnUiThread(new AnonymousClass8(this, r3));
        return;
    }

    private void aggregateSelectedContacts() {
        List<List<AggregationSuggestionUnit>> r0 = this.mSuggestionGroupList;
        if (r0 != null) goto L5;
        return;
    L5:
        final int[] r1 = new int[1];
        Iterator<List<AggregationSuggestionUnit>> r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L22;
        List<AggregationSuggestionUnit> r3 = r2.next();
        ArrayList r4 = new ArrayList();
        Iterator<AggregationSuggestionUnit> r5 = r3.iterator();
        AggregationSuggestionUnit r6 = null;
    L10:
        if (r5.hasNext() == false) goto L17;
        AggregationSuggestionUnit r7 = r5.next();
        if (r7.isChecked() == false) goto L10;
        r4.add(r7);
        if (r7.isFirstCheckedInGroup() == false) goto L10;
        r6 = r7;
        goto L10
    L17:
        if (r4.size() < 2) goto L7;
        updateJoinedName(r4, r6);
        joinContacts(r4);
        r1[0] = r1[0] + r4.size();
        if (getActivity() == null) goto L7;
        getActivity().runOnUiThread(new AnonymousClass9(this, r1));
        goto L7
    }

    private void updateJoinedName(List<AggregationSuggestionUnit> r13, AggregationSuggestionUnit r14) {
        if (r13 == null) goto L70;
        if (r14 == null) goto L71;
        ArrayList r0 = new ArrayList();
        if (Locale.CHINESE.getLanguage().equals(Locale.getDefault().getLanguage()) == false) goto L29;
        String r1 = r14.getModifiedDisplayName();
        if (ContactsUtils.isGraphic(r1) == true) goto L12;
        r1 = null;
    L12:
        if (TextUtils.isEmpty(r1) == false) goto L17;
        if (TextUtils.isEmpty(r14.getDisplayName()) == true) goto L17;
        r1 = r14.getDisplayName();
    L17:
        if (TextUtils.isEmpty(r1) == true) goto L57;
        Iterator<AggregationSuggestionUnit> r15 = r13.iterator();
    L20:
        if (r15.hasNext() == false) goto L57;
        AggregationSuggestionUnit r16 = r15.next();
        if (r16.getStructuredNameDataId() == (-1)) goto L20;
        ContentProviderOperation.Builder r17 = ContentProviderOperation.newUpdate(ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, r16.getStructuredNameDataId()));
        r17.withValue("data1", r1);
        Map<String, String> r4 = NameConverter.displayNameToStructuredName(this.mContext, r1);
        Iterator<String> r5 = r4.keySet().iterator();
    L25:
        if (r5.hasNext() == false) goto L27;
        String r6 = r5.next();
        r17.withValue(r6, r4.get(r6));
        goto L25
    L27:
        r0.add(r17.build());
    L57:
        ContactsUtils.runApplyBatch(this.mContext.getContentResolver(), "com.android.contacts", r0);
        return;
    L29:
        if (TextUtils.isEmpty(r14.getModifiedSplittedName()) == true) goto L31;
        String r2 = r14.getModifiedPrefix();
        String r7 = r14.getModifiedFamilyName();
        String r8 = r14.getModifiedMiddleName();
        String r9 = r14.getModifiedGivenName();
        String r18 = r14.getModifiedSuffix();
    L32:
        Iterator<AggregationSuggestionUnit> r19 = r13.iterator();
    L34:
        if (r19.hasNext() == false) goto L57;
        AggregationSuggestionUnit r10 = r19.next();
        boolean r11 = true;
        if (r10.getStructuredNameDataId() == (-1)) goto L38;
        ContentProviderOperation.Builder r12 = ContentProviderOperation.newUpdate(ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, r10.getStructuredNameDataId()));
        boolean r20 = false;
    L40:
        if (TextUtils.isEmpty(r2) == true) goto L43;
        r12.withValue("data4", r2);
        r20 = true;
    L43:
        if (TextUtils.isEmpty(r7) == true) goto L46;
        r12.withValue(DBHelper.COL_DATA3, r7);
        r20 = true;
    L46:
        if (TextUtils.isEmpty(r8) == true) goto L49;
        r12.withValue("data5", r8);
        r20 = true;
    L49:
        if (TextUtils.isEmpty(r9) == true) goto L52;
        r12.withValue(DBHelper.COL_DATA2, r9);
        r20 = true;
    L52:
        if (TextUtils.isEmpty(r18) == true) goto L54;
        r12.withValue("data6", r18);
    L55:
        if (r11 == false) goto L34;
        r0.add(r12.build());
        goto L34
    L54:
        r11 = r20;
        goto L55
    L38:
        ContentProviderOperation.Builder r21 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        r21.withValue("mimetype", "vnd.android.cursor.item/name");
        r21.withValue(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, Long.valueOf(r10.getRawContactId()));
        r12 = r21;
        r20 = true;
        goto L40
    L31:
        r2 = r14.getPrefix();
        r7 = r14.getFamilyName();
        r8 = r14.getMiddleName();
        r9 = r14.getGivenName();
        r18 = r14.getSuffix();
        goto L32
    L71:
        return;
    }

    private void joinContacts(List<AggregationSuggestionUnit> r14) {
        HashSet r0 = new HashSet();
        Iterator<AggregationSuggestionUnit> r1 = r14.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        r0.add(Long.valueOf(r1.next().getContactId()));
        goto L4
    L7:
        if (r0.size() >= 2) goto L9;
        return;
    L9:
        ContentResolver r10 = this.mContext.getContentResolver();
        StringBuilder r3 = new StringBuilder("contact_id IN (");
        Iterator r4 = r0.iterator();
        int r5 = 0;
    L10:
        int r12 = 1;
        if (r4.hasNext() == false) goto L16;
        r3.append((Long) r4.next());
        if (r5 == (r0.size() - 1)) goto L15;
        r3.append(", ");
    L15:
        r5 = r5 + 1;
        goto L10
    L16:
        r3.append(")");
        Cursor r6 = r10.query(ContactsContract.RawContacts.CONTENT_URI, JoinContactQuery.PROJECTION, r3.toString(), null, null);
        int r2 = r6.getCount();     // Catch: Throwable -> L28
        long[] r9 = new long[r2];     // Catch: Throwable -> L28
        int r7 = -1;
        int r8 = 0;
    L18:
        if (r8 >= r2) goto L23;
        r6.moveToPosition(r8);     // Catch: Throwable -> L28
        r9[r8] = r6.getLong(0);     // Catch: Throwable -> L28
        int r11 = r6.getInt(2);     // Catch: Throwable -> L28
        if (r11 <= r7) goto L22;
        r7 = r11;
    L22:
        r8 = r8 + 1;
        goto L18
    L23:
        r6.close();
        ArrayList<ContentProviderOperation> r13 = new ArrayList();
    L24:
        if (r12 >= r2) goto L26;
        buildJoinContactDiff(r13, r9[0], r9[r12]);
        r12 = r12 + 1;
        goto L24
    L26:
        ContactsUtils.runApplyBatch(r10, "com.android.contacts", r13);
        return;
    L28:
        th = move-exception;
        r6.close();
        throw th;
    }

    private void buildJoinContactDiff(ArrayList<ContentProviderOperation> r3, long r4, long r6) {
        ContentProviderOperation.Builder r2 = ContentProviderOperation.newUpdate(ContactsContract.AggregationExceptions.CONTENT_URI);
        r2.withValue("type", 1);
        r2.withValue("raw_contact_id1", Long.valueOf(r4));
        r2.withValue("raw_contact_id2", Long.valueOf(r6));
        r3.add(r2.build());
    }

    @Override // com.android.contacts.setting.ManualJoinContactAdapter.JoinedContactNameEditListener
    public void onJoinedContactNameEdit(List<AggregationSuggestionUnit> r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (Locale.CHINESE.getLanguage().equals(Locale.getDefault().getLanguage()) == false) goto L7;
        editDisplayName(r3);
        return;
    L7:
        editSplittedName(r3);
    }

    private void setFirstCheckedInGroup(List<AggregationSuggestionUnit> r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.size() == 0) goto L37;
        Iterator<AggregationSuggestionUnit> r7 = r8.iterator();
        AggregationSuggestionUnit r1 = null;
        boolean r2 = false;
        int r3 = 0;
    L8:
        if (r7.hasNext() == false) goto L15;
        AggregationSuggestionUnit r4 = r7.next();
        if (r4.isChecked() == false) goto L8;
        r3 = r3 + 1;
        if (r4.isFirstCheckedInGroup() == true) goto L13;
        r1 = r4;
        goto L8
    L13:
        r1 = r4;
        r2 = true;
        goto L8
    L15:
        if (r2 == false) goto L17;
        return;
    L17:
        if (r2 == true) goto L21;
        if (r3 != 1) goto L21;
        r1.setFirstCheckedInGroup(true);
        return;
    L21:
        if (r3 != 0) goto L36;
        Iterator<AggregationSuggestionUnit> r9 = r8.iterator();
    L24:
        if (r9.hasNext() == false) goto L38;
        r9.next().setFirstCheckedInGroup(false);
        goto L24
    L38:
        return;
    L36:
        return;
    }

    private void editDisplayName(final List<AggregationSuggestionUnit> r8) {
        InputBodyController r0 = new InputBodyController(getContext());
        final EditText r1 = r0.getInputText();
        r1.setHint(R.string.full_name);
        boolean r2 = true;
        r1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(100)});
        Iterator<AggregationSuggestionUnit> r3 = r8.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        AggregationSuggestionUnit r4 = r3.next();
        if (TextUtils.isEmpty(r4.getCurrentDisplayName()) == true) goto L4;
        r1.setText(r4.getCurrentDisplayName());
    L8:
        OAlertDialog r9 = new OAlertDialogBuilder(this.mContext).withBodyWithMatchParent(true).autoDismiss(false).title(R.string.joined_contact_name_title).body(r0).horizontalButton().negativeButton(R.string.common_cancel, new AnonymousClass11(this)).positiveButton(R.string.common_ok, new AnonymousClass10(this, r1, r8)).build();
        r9.setCancelable(true);
        final OButton r5 = r9.getPositiveButton();
        if (r5 != null) goto L11;
    L15:
        showSoftInput(r9.getWindow());
        r1.addTextChangedListener(new AnonymousClass12(this, r5));
        r9.show();
        return;
    L11:
        if (r1.getText().length() > 0) goto L14;
        r2 = false;
    L14:
        r5.setEnabled(r2);
        goto L15
    }

    private void editSplittedName(final List<AggregationSuggestionUnit> r17) {
        ManualJoinContactDialogBodyController r1 = new ManualJoinContactDialogBodyController(this.mContext, this.mContext.getResources().getBoolean(R.bool.config_editor_field_order_primary));
        final OEditText r2 = r1.getPrefixEdit();
        final OEditText r3 = r1.getFamilyNameEdit();
        final OEditText r4 = r1.getMiddleNameEdit();
        final OEditText r5 = r1.getGivenNameEdit();
        final OEditText r6 = r1.getSuffixEdit();
        HashSet r0 = new HashSet();
        Iterator<AggregationSuggestionUnit> r7 = r17.iterator();
    L4:
        if (r7.hasNext() == false) goto L21;
        AggregationSuggestionUnit r9 = r7.next();
        if (TextUtils.isEmpty(r9.getPrefix()) == true) goto L9;
        r0.add("data4");
    L9:
        if (TextUtils.isEmpty(r9.getFamilyName()) == true) goto L12;
        r0.add(DBHelper.COL_DATA3);
    L12:
        if (TextUtils.isEmpty(r9.getMiddleName()) == true) goto L15;
        r0.add("data5");
    L15:
        if (TextUtils.isEmpty(r9.getGivenName()) == true) goto L18;
        r0.add(DBHelper.COL_DATA2);
    L18:
        if (TextUtils.isEmpty(r9.getSuffix()) == true) goto L4;
        r0.add("data6");
        goto L4
    L21:
        if (r0.size() != 0) goto L23;
        r0.add(DBHelper.COL_DATA3);
        r0.add(DBHelper.COL_DATA2);
    L23:
        final ArrayList r10 = new ArrayList();
        if (r0.contains("data4") == false) goto L27;
        r1.getPrefix().setVisibility(0);
        r10.add(r2);
    L27:
        if (r0.contains(DBHelper.COL_DATA3) == false) goto L30;
        r1.getFamilyName().setVisibility(0);
        r10.add(r3);
    L30:
        if (r0.contains("data5") == false) goto L33;
        r1.getMiddleName().setVisibility(0);
        r10.add(r4);
    L33:
        if (r0.contains(DBHelper.COL_DATA2) == false) goto L36;
        r1.getGivenName().setVisibility(0);
        r10.add(r5);
    L36:
        if (r0.contains("data6") == false) goto L38;
        r1.getSuffix().setVisibility(0);
        r10.add(r6);
    L38:
        Iterator<AggregationSuggestionUnit> r8 = r17.iterator();
    L40:
        if (r8.hasNext() == false) goto L75;
        AggregationSuggestionUnit r11 = r8.next();
        if (TextUtils.isEmpty(r11.getModifiedSplittedName()) == false) goto L44;
        if (r11.isFirstCheckedInGroup() == false) goto L40;
        if (r10.contains(r2) == false) goto L64;
        r2.setText(r11.getPrefix());
    L64:
        if (r10.contains(r3) == false) goto L67;
        r3.setText(r11.getFamilyName());
    L67:
        if (r10.contains(r4) == false) goto L70;
        r4.setText(r11.getMiddleName());
    L70:
        if (r10.contains(r5) == false) goto L73;
        r5.setText(r11.getGivenName());
    L73:
        if (r10.contains(r6) == false) goto L75;
        r6.setText(r11.getSuffix());
        goto L75
    L44:
        if (r10.contains(r2) == false) goto L47;
        r2.setText(r11.getModifiedPrefix());
    L47:
        if (r10.contains(r3) == false) goto L50;
        r3.setText(r11.getModifiedFamilyName());
    L50:
        if (r10.contains(r4) == false) goto L53;
        r4.setText(r11.getModifiedMiddleName());
    L53:
        if (r10.contains(r5) == false) goto L56;
        r5.setText(r11.getModifiedGivenName());
    L56:
        if (r10.contains(r6) == false) goto L75;
        r6.setText(r11.getModifiedSuffix());
    L75:
        Iterator r12 = r10.iterator();
        boolean r13 = true;
    L77:
        if (r12.hasNext() == false) goto L81;
        if (TextUtils.isEmpty(((OEditText) r12.next()).getText()) == true) goto L77;
        r13 = false;
        goto L77
    L81:
        OAlertDialog r14 = new OAlertDialogBuilder(this.mContext).withBodyWithMatchParent(true).autoDismiss(false).title(R.string.joined_contact_name_title).body(r1).horizontalButton().negativeButton(R.string.common_cancel, new AnonymousClass14(this)).positiveButton(R.string.common_ok, new AnonymousClass13(this, r2, r3, r4, r5, r6, r17)).build();
        r14.setCancelable(true);
        final OButton r15 = r14.getPositiveButton();
        if (r15 == null) goto L84;
        r15.setEnabled(!r13);
    L84:
        showSoftInput(r14.getWindow());
        TextWatcher r16 = new AnonymousClass15(this, r10, r15);
        Iterator r18 = r10.iterator();
    L86:
        if (r18.hasNext() == false) goto L88;
        ((EditText) r18.next()).addTextChangedListener(r16);
        goto L86
    L88:
        r14.show();
    }

    private void showSoftInput(Window r1) {
        r1.setSoftInputMode(5);
    }

    private static void log(String r1) {
        if (ContactsUtils.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r1);
        return;
    }
}
