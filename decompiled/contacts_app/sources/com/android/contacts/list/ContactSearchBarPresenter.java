package com.android.contacts.list;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.text.method.TextKeyListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.obric.oui.forms.OEditText;
import com.obric.oui.popover.OPopover;
import com.obric.oui.searchbar.v2.OSearchBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import obric.widget.support.AbsMenuItem;
import obric.widget.support.IMenuItem;

/* JADX INFO: loaded from: classes2.dex */
public class ContactSearchBarPresenter implements IContactSearchBarPresenter {
    public static final String KEY_ICON_RESOURCE = "resource";
    public static final String KEY_IS_SELECTED = "selected";
    public static final String KEY_SORT_TYPE = "sort_type";
    public static final String KEY_SORT_TYPE_NAME = "sort_type_name";
    public static final int SORT_BY_ADD_TIME = 8;
    public static final int SORT_BY_BUSINESS_CARD = 128;
    public static final int SORT_BY_COMPANY = 16;
    public static final int SORT_BY_FREQUENCY = 4;
    public static final int SORT_BY_LOCATION = 2;
    public static final int SORT_BY_NAME = 1;
    public static final int SORT_BY_PHONE_CONTACTS = 256;
    public static final int SORT_BY_SIM1 = 32;
    public static final int SORT_BY_SIM2 = 64;
    private int DEFAULT_MENU_SELECTED;
    private Activity mActivity;
    private Context mContext;
    private boolean mIsPlaySearchModeAnimation;
    private boolean mIsSearchMode;
    private boolean mIsSortByBusinessCardSupported;
    private int mMenuLastSelectItem;
    private OPopover mOPopover;
    private OSearchBar mOSearchBar;
    private OEditText mOSearchEditor;
    HashMap<String, Object> mSortByBusinessCard;
    private int mSortByBusinessCardIndex;
    private int mSortByPhoneContactsIndex;
    HashMap<String, Object> mSortBySim1;
    private int mSortBySim1Index;
    HashMap<String, Object> mSortBySim2;
    private int mSortBySim2Index;
    private int mSortMode;
    private List<SortTypeItemResource> mSortTypes;
    private List<SortTypeItemResource> mTopSortTypes;
    private IContactSearchBarView mView;
    private List<IMenuItem> menuList;

    public interface Action {
        void execute();
    }

    public class MenuItem extends AbsMenuItem {
        int iconRes;
        boolean isSelected;
        final /* synthetic */ ContactSearchBarPresenter this$0;
        String title;

        public MenuItem(ContactSearchBarPresenter r1) {
            this.this$0 = r1;
        }

        @Override // obric.widget.support.AbsMenuItem, obric.widget.support.IMenuItem
        public String getTitle() {
            return this.title;
        }

        @Override // obric.widget.support.AbsMenuItem, obric.widget.support.IMenuItem
        public void setMenuIcon(ImageView r1) {
            r1.setImageResource(this.iconRes);
        }

        @Override // obric.widget.support.AbsMenuItem, obric.widget.support.IMenuItem
        public boolean isSelected() {
            return this.isSelected;
        }

        public int getMenuIcon() {
            return this.iconRes;
        }

        public void setSelected(boolean r1) {
            this.isSelected = r1;
        }
    }

    private class SortTypeItemResource {
        Action action;
        int lable;
        HashMap<String, Object> map;
        final /* synthetic */ ContactSearchBarPresenter this$0;

        public SortTypeItemResource(ContactSearchBarPresenter r1, int r2, HashMap<String, Object> r3, Action r4) {
            this.this$0 = r1;
            this.lable = r2;
            this.map = r3;
            this.action = r4;
        }
    }

    @Override // com.android.contacts.list.IContactSearchBarPresenter
    public void setListener(SearchBar.Listener r1) {
    }

    public ContactSearchBarPresenter() {
        this.mIsSortByBusinessCardSupported = false;
        this.mIsPlaySearchModeAnimation = false;
        this.mIsSearchMode = false;
        this.mTopSortTypes = new ArrayList(5);
        this.menuList = new ArrayList();
        this.mSortByPhoneContactsIndex = -1;
        this.mSortBySim1Index = -1;
        this.mSortBySim2Index = -1;
        this.mSortByBusinessCardIndex = -1;
        this.DEFAULT_MENU_SELECTED = 0;
        this.mSortMode = 1;
        this.mMenuLastSelectItem = 0;
    }

    static /* synthetic */ IContactSearchBarView access$000(ContactSearchBarPresenter r0) {
        return r0.mView;
    }

    static /* synthetic */ boolean access$100(ContactSearchBarPresenter r0) {
        return r0.mIsSearchMode;
    }

    @Override // com.android.contacts.list.IContactSearchBarPresenter
    public void attachView(IContactSearchBarView r1, Context r2, Activity r3) {
        this.mView = r1;
        this.mOSearchBar = r1.getSearchBar();
        this.mContext = r2;
        this.mActivity = r3;
        initViews();
        initDefaultSortTypes();
    }

    private void initViews() {
        OEditText r0 = this.mOSearchBar.getInputView();
        if (r0 == null) goto L6;
        this.mOSearchEditor = r0;
        r0.setOnEditorActionListener(new AnonymousClass1(this));
        this.mOSearchEditor.addTextChangedListener(new AnonymousClass2(this));
        this.mOSearchEditor.setOnClickListener(new AnonymousClass3(this));
        return;
    }

    public void hideKeyboard() {
        ((InputMethodManager) this.mContext.getSystemService("input_method")).hideSoftInputFromWindow(this.mOSearchEditor.getWindowToken(), 2);
    }

    public void showKeyboard() {
        ((InputMethodManager) this.mContext.getSystemService("input_method")).showSoftInput(this.mOSearchEditor, 0);
    }

    @Override // com.android.contacts.list.IContactSearchBarPresenter
    public void detachView() {
        this.mView = null;
    }

    @Override // com.android.contacts.list.IContactSearchBarPresenter
    public void setSortByBusinessCardSupported(boolean r1) {
        this.mIsSortByBusinessCardSupported = r1;
    }

    @Override // com.android.contacts.list.IContactSearchBarPresenter
    public boolean isPopupWindowShowing() {
        OPopover r0 = this.mOPopover;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isShowing() == false) goto L7;
        return true;
    }

    @Override // com.android.contacts.list.IContactSearchBarPresenter
    public boolean isPlayingSearchAnimation() {
        return this.mIsPlaySearchModeAnimation;
    }

    @Override // com.android.contacts.list.IContactSearchBarPresenter
    public void requestSeachViewFocus() {
        if (this.mOSearchEditor != null) goto L5;
        return;
    L5:
        if (isInSearchMode() == false) goto L9;
        this.mOSearchEditor.requestFocus();
        return;
    }

    @Override // com.android.contacts.list.IContactSearchBarPresenter
    public void cancelSearch() {
        this.mIsSearchMode = false;
        clearSearchText();
        this.mOSearchEditor.clearFocus();
        this.mView.endContactAnimationIView();
        hideKeyboard();
    }

    @Override // com.android.contacts.list.IContactSearchBarPresenter
    public void startSearch() {
        this.mIsSearchMode = true;
        if (isPopupWindowShowing() == false) goto L5;
        this.mOPopover.dismiss();
    L5:
        updateSearchMode();
        showKeyboard();
    }

    private void updateSearchMode() {
        this.mOSearchEditor.setCursorVisible(this.mIsSearchMode);
        this.mOSearchEditor.setFocusableInTouchMode(this.mIsSearchMode);
        if (this.mIsSearchMode == false) goto L5;
        this.mOSearchEditor.requestFocus();
        return;
    L5:
        this.mOSearchEditor.clearFocus();
        TextKeyListener.clear(this.mOSearchEditor.getText());
    }

    @Override // com.android.contacts.list.IContactSearchBarPresenter
    public void switchSortMode(int r2) {
        OPopover r0 = this.mOPopover;
        if (r0 == null) goto L8;
        if (r0.isShowing() == false) goto L8;
        this.mOPopover.dismiss();
    L8:
        if (this.mSortMode != r2) goto L11;
        return;
    L11:
        if (this.mView.onModeChangeIView(r2) == false) goto L14;
        this.mSortMode = r2;
        return;
    }

    @Override // com.android.contacts.list.IContactSearchBarPresenter
    public void setSortMode(int r2) {
        if (this.mSortMode != r2) goto L5;
        return;
    L5:
        this.mSortMode = r2;
        updateSelectedStateForSortTypes();
    }

    @Override // com.android.contacts.list.IContactSearchBarPresenter
    public void clearSearchText() {
        OEditText r1 = this.mOSearchEditor;
        if (r1 == null) goto L6;
        r1.setText("");
        return;
    }

    @Override // com.android.contacts.list.IContactSearchBarPresenter
    public void cancelSearchWithoutAnimation() {
        this.mIsSearchMode = false;
        hideKeyboard();
        clearSearchText();
        this.mView.cancelSearchWithoutAnimation();
        this.mOSearchEditor.clearFocus();
    }

    @Override // com.android.contacts.list.IContactSearchBarPresenter
    public void setSearchEnable(boolean r2) {
        this.mOSearchBar.setEnabled(r2);
        this.mIsSearchMode = this.mOSearchEditor.isInEditMode();
    }

    @Override // com.android.contacts.list.IContactSearchBarPresenter
    public boolean isInSearchMode() {
        return this.mIsSearchMode;
    }

    @Override // com.android.contacts.list.IContactSearchBarPresenter
    public void freezeSearchView(boolean r1) {
        this.mOSearchEditor.setEnabled(!r1);
    }

    @Override // com.android.contacts.list.IContactSearchBarPresenter
    public int getWidth() {
        return this.mOSearchBar.getWidth();
    }

    @Override // com.android.contacts.list.IContactSearchBarPresenter
    public void setTranslationX(float r1) {
        this.mOSearchBar.setTranslationX(r1);
    }

    @Override // com.android.contacts.list.IContactSearchBarPresenter
    public void setLayerType(int r1, Paint r2) {
        this.mOSearchBar.setLayerType(r1, r2);
    }

    @Override // com.android.contacts.list.IContactSearchBarPresenter
    public void returnToSortByName() {
        if (this.mSortMode != 1) goto L5;
        return;
    L5:
        switchSortMode(1);
    }

    @Override // com.android.contacts.list.IContactSearchBarPresenter
    public void setCursorVisible(boolean r1) {
        this.mOSearchBar.getInputView().setCursorVisible(r1);
    }

    private List<IMenuItem> initMenuItems() {
        List<IMenuItem> r0 = this.menuList;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        int r1 = 0;
    L7:
        if (r1 >= this.mSortTypes.size()) goto L14;
        HashMap<String, Object> r2 = this.mSortTypes.get(r1).map;
        MenuItem r3 = new MenuItem(this);
        if (r2.containsKey("sort_type") == false) goto L11;
        String r4 = this.mContext.getString(((Integer) r2.get("sort_type")).intValue());
    L12:
        r3.title = r4;
        r3.iconRes = ((Integer) r2.get("resource")).intValue();
        r3.isSelected = ((Boolean) r2.get("selected")).booleanValue();
        this.menuList.add(r3);
        r1 = r1 + 1;
        goto L7
    L11:
        r4 = (String) r2.get("sort_type_name");
        goto L12
    L14:
        return this.menuList;
    }

    private void initDefaultSortTypes() {
        HashMap r0 = new HashMap();
        r0.put("resource", Integer.valueOf(R.drawable.sort_menu_name_icon));
        r0.put("sort_type", Integer.valueOf(R.string.common_given_name));
        r0.put("selected", true);
        SortTypeItemResource r6 = new SortTypeItemResource(this, 1, r0, new AnonymousClass4(this));
        this.mTopSortTypes.add(r6);
        if (ContactsUtils.isFeatureDomestic() == false) goto L5;
        HashMap r1 = new HashMap();
        r1.put("resource", Integer.valueOf(R.drawable.sort_menu_location_icon));
        r1.put("sort_type", Integer.valueOf(R.string.sort_city));
        r1.put("selected", false);
        SortTypeItemResource r7 = new SortTypeItemResource(this, 2, r1, new AnonymousClass5(this));
        this.mTopSortTypes.add(r7);
    L5:
        HashMap r2 = new HashMap();
        r2.put("resource", Integer.valueOf(R.drawable.sort_menu_frequency_icon));
        r2.put("sort_type", Integer.valueOf(R.string.sort_times));
        r2.put("selected", false);
        SortTypeItemResource r8 = new SortTypeItemResource(this, 4, r2, new AnonymousClass6(this));
        this.mTopSortTypes.add(r8);
        HashMap r3 = new HashMap();
        r3.put("resource", Integer.valueOf(R.drawable.sort_menu_creat_time_icon));
        r3.put("sort_type", Integer.valueOf(R.string.sort_add_times));
        r3.put("selected", false);
        SortTypeItemResource r4 = new SortTypeItemResource(this, 8, r3, new AnonymousClass7(this));
        this.mTopSortTypes.add(r4);
    }

    private void initNewSortTypes() {
        ArrayList r0 = new ArrayList(8);
        r0.addAll(this.mTopSortTypes);
        if (ContactsUtils.FEATURE_SIM_PHONEBOOK == false) goto L19;
        if (DSUtils.isMultiSimEnabled() == false) goto L19;
        if (DSUtils.hasIccCard(0) == true) goto L9;
    L11:
        this.mSortBySim1Index = -1;
    L13:
        if (DSUtils.hasIccCard(1) == true) goto L15;
    L17:
        this.mSortBySim2Index = -1;
        goto L19
    L15:
        if (DSUtils.isSimEnable(1) == false) goto L17;
        Action r1 = new AnonymousClass9(this);
        r0.add(new SortTypeItemResource(this, 64, this.mSortBySim2, r1));
        this.mSortBySim2Index = r0.size() - 1;
        goto L19
    L9:
        if (DSUtils.isSimEnable(0) == false) goto L11;
        Action r2 = new AnonymousClass8(this);
        r0.add(new SortTypeItemResource(this, 32, this.mSortBySim1, r2));
        this.mSortBySim1Index = r0.size() - 1;
    L19:
        if (this.mSortByBusinessCard != null) goto L22;
        HashMap<String, Object> r3 = new HashMap();
        this.mSortByBusinessCard = r3;
        r3.put("resource", Integer.valueOf(R.drawable.sort_menu_business_icon));
        this.mSortByBusinessCard.put("sort_type", Integer.valueOf(R.string.sort_business_card));
        this.mSortByBusinessCard.put("selected", false);
    L22:
        if (this.mIsSortByBusinessCardSupported == true) goto L24;
        this.mSortByBusinessCardIndex = -1;
    L25:
        this.mSortTypes = r0;
        updateSelectedStateForSortTypes();
        return;
    L24:
        Action r4 = new AnonymousClass10(this);
        r0.add(new SortTypeItemResource(this, 128, this.mSortByBusinessCard, r4));
        this.mSortByBusinessCardIndex = r0.size() - 1;
        goto L25
    }

    private void updateSelectedStateForSortTypes() {
        List<SortTypeItemResource> r0 = this.mSortTypes;
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<SortTypeItemResource> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        SortTypeItemResource r2 = r1.next();
        if (this.mSortMode == r2.lable) goto L10;
        r2.map.put("selected", false);
        goto L7
    L10:
        r2.map.put("selected", true);
        goto L7
    }
}
