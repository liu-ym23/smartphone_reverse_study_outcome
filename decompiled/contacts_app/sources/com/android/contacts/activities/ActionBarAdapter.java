package com.android.contacts.activities;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.SearchView;
import com.android.contacts.R;
import com.android.contacts.list.ContactsRequest;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarAdapter implements SearchView.OnQueryTextListener, SearchView.OnCloseListener {
    private static final TabState DEFAULT_TAB = null;
    private static final String EXTRA_KEY_QUERY = "navBar.query";
    private static final String EXTRA_KEY_SEARCH_MODE = "navBar.searchMode";
    private static final String EXTRA_KEY_SELECTED_TAB = "navBar.selectedTab";
    private static final String PERSISTENT_LAST_TAB = "actionBarAdapter.lastTab";
    private final ActionBar mActionBar;
    private final Context mContext;
    private TabState mCurrentTab;
    private Listener mListener;
    private final SharedPreferences mPrefs;
    private String mQueryString;
    private boolean mSearchMode;
    private SearchView mSearchView;
    private boolean mShowHomeIcon;
    private boolean mShowTabsAsText;
    private final MyTabListener mTabListener;

    /* JADX INFO: renamed from: com.android.contacts.activities.ActionBarAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public interface Listener {

        public static final enum Action extends Enum<Action> {
            private static final /* synthetic */ Action[] $VALUES = null;
            public static final Action CHANGE_SEARCH_QUERY = null;
            public static final Action START_SEARCH_MODE = null;
            public static final Action STOP_SEARCH_MODE = null;

            private static /* synthetic */ Action[] $values() {
                return new Action[]{CHANGE_SEARCH_QUERY, START_SEARCH_MODE, STOP_SEARCH_MODE};
            }

            private Action(String r1, int r2) {
                super(r1, r2);
            }

            public static Action valueOf(String r1) {
                return (Action) Enum.valueOf(Action.class, r1);
            }

            public static Action[] values() {
                return (Action[]) $VALUES.clone();
            }

            static {
                CHANGE_SEARCH_QUERY = new Action("CHANGE_SEARCH_QUERY", 0);
                START_SEARCH_MODE = new Action("START_SEARCH_MODE", 1);
                STOP_SEARCH_MODE = new Action("STOP_SEARCH_MODE", 2);
                $VALUES = $values();
            }
        }

        void onAction(Action r1);

        void onSelectedTabChanged();
    }

    private class MyTabListener implements ActionBar.TabListener {
        public boolean mIgnoreTabSelected;
        final /* synthetic */ ActionBarAdapter this$0;

        @Override // android.app.ActionBar.TabListener
        public void onTabReselected(ActionBar.Tab r1, FragmentTransaction r2) {
        }

        @Override // android.app.ActionBar.TabListener
        public void onTabUnselected(ActionBar.Tab r1, FragmentTransaction r2) {
        }

        private MyTabListener(ActionBarAdapter r1) {
            this.this$0 = r1;
        }

        /* synthetic */ MyTabListener(ActionBarAdapter r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.app.ActionBar.TabListener
        public void onTabSelected(ActionBar.Tab r1, FragmentTransaction r2) {
            if (this.mIgnoreTabSelected == true) goto L6;
            this.this$0.setCurrentTab((TabState) r1.getTag());
            return;
        }
    }

    public static final enum TabState extends Enum<TabState> {
        private static final /* synthetic */ TabState[] $VALUES = null;
        public static final TabState ALL = null;
        public static final TabState CITY = null;
        public static final TabState FAVORITES = null;
        public static final TabState GROUPS = null;

        private static /* synthetic */ TabState[] $values() {
            return new TabState[]{GROUPS, ALL, FAVORITES, CITY};
        }

        private TabState(String r1, int r2) {
            super(r1, r2);
        }

        public static TabState valueOf(String r1) {
            return (TabState) Enum.valueOf(TabState.class, r1);
        }

        public static TabState[] values() {
            return (TabState[]) $VALUES.clone();
        }

        static {
            GROUPS = new TabState("GROUPS", 0);
            ALL = new TabState("ALL", 1);
            FAVORITES = new TabState("FAVORITES", 2);
            CITY = new TabState("CITY", 3);
            $VALUES = $values();
        }

        public static TabState fromInt(int r3) {
            TabState r0 = GROUPS;
            if (r0.ordinal() != r3) goto L5;
            return r0;
        L5:
            TabState r1 = ALL;
            if (r1.ordinal() != r3) goto L8;
            return r1;
        L8:
            TabState r2 = FAVORITES;
            if (r2.ordinal() != r3) goto L11;
            return r2;
        L11:
            TabState r4 = CITY;
            if (r4.ordinal() != r3) goto L15;
            return r4;
        L15:
            throw new IllegalArgumentException("Invalid value: " + r3);
        }
    }

    static {
        DEFAULT_TAB = TabState.ALL;
    }

    public ActionBarAdapter(Context r3, Listener r4, ActionBar r5, boolean r6) {
        this.mTabListener = new MyTabListener(this, null);
        this.mCurrentTab = DEFAULT_TAB;
        this.mContext = r3;
        this.mListener = r4;
        this.mActionBar = r5;
        this.mPrefs = PreferenceManager.getDefaultSharedPreferences(r3);
        this.mShowHomeIcon = r3.getResources().getBoolean(R.bool.show_home_icon);
        this.mShowTabsAsText = r6;
        View r7 = LayoutInflater.from(r5.getThemedContext()).inflate(R.layout.custom_action_bar, null);
        int r8 = r3.getResources().getDimensionPixelSize(R.dimen.search_view_width);
        if (r8 != 0) goto L5;
        r8 = -1;
    L5:
        ActionBar.LayoutParams r0 = new ActionBar.LayoutParams(r8, -2);
        SearchView r9 = (SearchView) r7.findViewById(R.id.search_view);
        this.mSearchView = r9;
        r9.setIconifiedByDefault(true);
        this.mSearchView.setQueryHint(r3.getString(R.string.hint_findContacts));
        this.mSearchView.setOnQueryTextListener(this);
        this.mSearchView.setOnCloseListener(this);
        this.mSearchView.setQuery(this.mQueryString, false);
        r5.setCustomView(r7, r0);
        addTab(TabState.GROUPS, R.drawable.ic_tab_groups, R.string.common_groups);
        addTab(TabState.ALL, R.drawable.ic_tab_all, R.string.common_all_contacts);
        addTab(TabState.FAVORITES, R.drawable.ic_tab_starred, R.string.common_favorites);
        addTab(TabState.CITY, R.drawable.ic_tab_starred, R.string.common_favorites);
    }

    public void initialize(Bundle r1, ContactsRequest r2) {
        if (r1 != null) goto L4;
        this.mSearchMode = r2.isSearchMode();
        this.mQueryString = r2.getQueryString();
        this.mCurrentTab = loadLastTabPreference();
    L5:
        update();
        return;
    L4:
        this.mSearchMode = r1.getBoolean(EXTRA_KEY_SEARCH_MODE);
        this.mQueryString = r1.getString(EXTRA_KEY_QUERY);
        this.mCurrentTab = TabState.fromInt(r1.getInt(EXTRA_KEY_SELECTED_TAB));
        goto L5
    }

    public void setListener(Listener r1) {
        this.mListener = r1;
    }

    private void addTab(TabState r2, int r3, int r4) {
        ActionBar.Tab r0 = this.mActionBar.newTab();
        r0.setTag(r2);
        r0.setTabListener(this.mTabListener);
        if (this.mShowTabsAsText == false) goto L5;
        r0.setText(r4);
    L6:
        this.mActionBar.addTab(r0);
        return;
    L5:
        r0.setIcon(r3);
        r0.setContentDescription(r4);
        goto L6
    }

    public void setCurrentTab(TabState r2) {
        setCurrentTab(r2, true);
    }

    public void setCurrentTab(TabState r3, boolean r4) {
        r3.getClass();
        if (r3 != this.mCurrentTab) goto L5;
        return;
    L5:
        this.mCurrentTab = r3;
        int r5 = r3.ordinal();
        if (this.mActionBar.getNavigationMode() == 2) goto L8;
    L10:
        if (r4 == false) goto L14;
        Listener r6 = this.mListener;
        if (r6 == null) goto L14;
        r6.onSelectedTabChanged();
    L14:
        saveLastTabPreference(this.mCurrentTab);
        return;
    L8:
        if (r5 == this.mActionBar.getSelectedNavigationIndex()) goto L10;
        this.mActionBar.setSelectedNavigationItem(r5);
        goto L10
    }

    public TabState getCurrentTab() {
        return this.mCurrentTab;
    }

    public boolean isSearchMode() {
        return this.mSearchMode;
    }

    public void setSearchMode(boolean r2) {
        if (this.mSearchMode == r2) goto L12;
        this.mSearchMode = r2;
        if (this.mSearchView != null) goto L7;
        return;
    L7:
        update();
        if (this.mSearchMode == false) goto L10;
        setFocusOnSearchView();
        return;
    L10:
        this.mSearchView.setQuery(null, false);
        return;
    }

    public String getQueryString() {
        if (this.mSearchMode == true) goto L7;
        return null;
    L7:
        return this.mQueryString;
    }

    public void setQueryString(String r2) {
        this.mQueryString = r2;
        SearchView r1 = this.mSearchView;
        if (r1 == null) goto L6;
        r1.setQuery(r2, false);
        return;
    }

    public boolean isUpShowing() {
        return this.mSearchMode;
    }

    private void updateDisplayOptions() {
        int r0 = this.mActionBar.getDisplayOptions() & 30;
        if (this.mShowHomeIcon == false) goto L5;
        int r2 = 10;
    L6:
        boolean r3 = this.mSearchMode;
        if (r3 == false) goto L9;
        r2 = ((r2 | 2) | 4) | 16;
    L9:
        this.mActionBar.setHomeButtonEnabled(r3);
        if (r0 == r2) goto L13;
        this.mActionBar.setDisplayOptions(r2, 30);
        return;
    L13:
        return;
    L5:
        r2 = 8;
        goto L6
    }

    private void update() {
        if (this.mSearchMode == false) goto L11;
        setFocusOnSearchView();
        this.mSearchView.onActionViewExpanded();
        if (this.mActionBar.getNavigationMode() == 0) goto L7;
        this.mActionBar.setNavigationMode(0);
    L7:
        Listener r0 = this.mListener;
        if (r0 == null) goto L16;
        r0.onAction(Listener.Action.START_SEARCH_MODE);
    L16:
        updateDisplayOptions();
        return;
    L11:
        if (this.mActionBar.getNavigationMode() == 2) goto L13;
        this.mTabListener.mIgnoreTabSelected = true;
        this.mActionBar.setNavigationMode(2);
        this.mActionBar.setSelectedNavigationItem(this.mCurrentTab.ordinal());
        this.mTabListener.mIgnoreTabSelected = false;
    L13:
        this.mActionBar.setTitle(null);
        this.mSearchView.onActionViewCollapsed();
        Listener r1 = this.mListener;
        if (r1 == null) goto L16;
        r1.onAction(Listener.Action.STOP_SEARCH_MODE);
        this.mListener.onSelectedTabChanged();
        goto L16
    }

    @Override // android.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextChange(String r3) {
        if (r3.equals(this.mQueryString) == false) goto L6;
        return false;
    L6:
        this.mQueryString = r3;
        if (this.mSearchMode == false) goto L9;
        Listener r2 = this.mListener;
        if (r2 == null) goto L14;
        r2.onAction(Listener.Action.CHANGE_SEARCH_QUERY);
    L14:
        return true;
    L9:
        if (TextUtils.isEmpty(r3) == true) goto L14;
        setSearchMode(true);
        goto L14
    }

    @Override // android.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String r3) {
        if (this.mSearchView == null) goto L10;
        InputMethodManager r4 = (InputMethodManager) this.mContext.getSystemService("input_method");
        if (r4 == null) goto L7;
        r4.hideSoftInputFromWindow(this.mSearchView.getWindowToken(), 0);
    L7:
        this.mSearchView.clearFocus();
        return true;
    L10:
        return true;
    }

    @Override // android.widget.SearchView.OnCloseListener
    public boolean onClose() {
        setSearchMode(false);
        return false;
    }

    public void onSaveInstanceState(Bundle r3) {
        r3.putBoolean(EXTRA_KEY_SEARCH_MODE, this.mSearchMode);
        r3.putString(EXTRA_KEY_QUERY, this.mQueryString);
        r3.putInt(EXTRA_KEY_SELECTED_TAB, this.mCurrentTab.ordinal());
    }

    public void clearFocusOnSearchView() {
        if (isSearchMode() == false) goto L8;
        SearchView r1 = this.mSearchView;
        if (r1 == null) goto L9;
        r1.clearFocus();
        return;
    L9:
        return;
    }

    private void setFocusOnSearchView() {
        this.mSearchView.requestFocus();
        this.mSearchView.setIconified(false);
    }

    private void saveLastTabPreference(TabState r2) {
        this.mPrefs.edit().putInt(PERSISTENT_LAST_TAB, r2.ordinal()).apply();
    }

    private TabState loadLastTabPreference() {
        return TabState.fromInt(this.mPrefs.getInt(PERSISTENT_LAST_TAB, DEFAULT_TAB.ordinal()));
    L5:
        return DEFAULT_TAB;
    }
}
