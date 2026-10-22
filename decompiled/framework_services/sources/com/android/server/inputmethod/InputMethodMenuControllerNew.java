package com.android.server.inputmethod;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Printer;
import android.util.Slog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodInfo;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.internal.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class InputMethodMenuControllerNew {
    private static final int HORIZONTAL_OFFSET = 16;
    private static final String TAG = null;
    private static final String WINDOW_TITLE = "IME Switcher Menu";
    private AlertDialog mDialog;
    private final InputMethodDialogWindowContext mDialogWindowContext;
    private List<MenuItem> mMenuItems;

    private static final class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private static final int TYPE_DIVIDER = 2;
        private static final int TYPE_HEADER = 1;
        private static final int TYPE_SUBTYPE = 0;
        private static final int TYPE_UNKNOWN = -1;
        private final LayoutInflater mInflater;
        private final List<MenuItem> mItems;
        private final OnClickListener mListener;
        private final int mSelectedIndex;

        private static final class DividerViewHolder extends RecyclerView.ViewHolder {
            DividerViewHolder(View itemView) {
                super(itemView);
            }
        }

        private static final class HeaderViewHolder extends RecyclerView.ViewHolder {
            private final TextView mTitle;

            HeaderViewHolder(View itemView) {
                super(itemView);
                this.mTitle = (TextView) itemView.requireViewById(R.id.inter_character);
            }

            void bind(HeaderItem item) {
                this.mTitle.setText(item.mTitle);
            }
        }

        private static final class SubtypeViewHolder extends RecyclerView.ViewHolder {
            private final ImageView mCheckmark;
            private final View mContainer;
            private boolean mIsSelected;
            private SubtypeItem mItem;
            private final TextView mLayout;
            private final TextView mName;

            /* JADX INFO: renamed from: $r8$lambda$Gyl9DaLB6ibpLPHtVu3WemQ5-Kw, reason: not valid java name */
            public static /* synthetic */ void m4782$r8$lambda$Gyl9DaLB6ibpLPHtVu3WemQ5Kw(SubtypeViewHolder r0, OnClickListener r1, View r2) {
                r0.lambda$new$0(r1, r2);
            }

            SubtypeViewHolder(View itemView, final OnClickListener listener) {
                super(itemView);
                this.mContainer = itemView;
                this.mName = (TextView) itemView.requireViewById(16909866);
                this.mLayout = (TextView) itemView.requireViewById(R.id.text2);
                this.mCheckmark = (ImageView) itemView.requireViewById(R.id.left_icon);
                this.mContainer.setOnClickListener(new InputMethodMenuControllerNew$Adapter$SubtypeViewHolder$$ExternalSyntheticLambda0(this, listener));
            }

            private /* synthetic */ void lambda$new$0(OnClickListener listener, View v) {
                if (this.mItem == null) goto L6;
                listener.onClick(this.mItem, this.mIsSelected);
                return;
            }

            void bind(SubtypeItem item, boolean isSelected) {
                this.mItem = item;
                this.mIsSelected = isSelected;
                if (TextUtils.isEmpty(item.mSubtypeName) == false) goto L5;
                CharSequence name = item.mImeName;
            L6:
                this.mContainer.setActivated(isSelected);
                this.mContainer.setSelected(isSelected);
                this.mName.setSelected(isSelected);
                this.mName.setText(name);
                this.mLayout.setText(SubtypeItem.m4783$$Nest$fgetmLayoutName(item));
                TextView r1 = this.mLayout;
                int r3 = 8;
                if (TextUtils.isEmpty(SubtypeItem.m4783$$Nest$fgetmLayoutName(item)) == true) goto L9;
                int r2 = 0;
            L10:
                r1.setVisibility(r2);
                ImageView r4 = this.mCheckmark;
                if (isSelected == false) goto L13;
                r3 = 0;
            L13:
                r4.setVisibility(r3);
                return;
            L9:
                r2 = 8;
                goto L10
            L5:
                name = item.mSubtypeName;
                goto L6
            }
        }

        Adapter(List<MenuItem> items, int selectedIndex, LayoutInflater inflater, OnClickListener listener) {
            this.mItems = items;
            this.mSelectedIndex = selectedIndex;
            this.mInflater = inflater;
            this.mListener = listener;
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            switch(viewType) {
                case 0: goto L10;
                case 1: goto L8;
                case 2: goto L6;
                default: goto L5;
            };
        L6:
            View view = this.mInflater.inflate(R.layout.notification_2025_template_header, parent, false);
            return new DividerViewHolder(view);
        L8:
            View view2 = this.mInflater.inflate(R.layout.notification_2025_template_heads_up_base, parent, false);
            return new HeaderViewHolder(view2);
        L10:
            View view3 = this.mInflater.inflate(R.layout.notification_2025_text, parent, false);
            return new SubtypeViewHolder(view3, this.mListener);
        L5:
            throw new IllegalArgumentException("Unknown viewType: " + viewType);
        }

        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            MenuItem item = this.mItems.get(position);
            if ((holder instanceof SubtypeViewHolder) == false) goto L12;
            SubtypeViewHolder subtypeHolder = (SubtypeViewHolder) holder;
            if ((item instanceof SubtypeItem) == false) goto L12;
            SubtypeItem subtypeItem = (SubtypeItem) item;
            if (position != this.mSelectedIndex) goto L9;
            boolean r3 = true;
        L10:
            subtypeHolder.bind(subtypeItem, r3);
            return;
        L9:
            r3 = false;
        L12:
            if ((holder instanceof HeaderViewHolder) == false) goto L17;
            HeaderViewHolder headerHolder = (HeaderViewHolder) holder;
            if ((item instanceof HeaderItem) == false) goto L17;
            HeaderItem headerItem = (HeaderItem) item;
            headerHolder.bind(headerItem);
            return;
        L17:
            if ((holder instanceof DividerViewHolder) == true) goto L19;
        L21:
            Slog.w(InputMethodMenuControllerNew.m4781$$Nest$sfgetTAG(), "Holder type: " + holder + " doesn't match item type: " + item);
            return;
        L19:
            if ((item instanceof DividerItem) == false) goto L21;
        }

        public int getItemCount() {
            return this.mItems.size();
        }

        public int getItemViewType(int position) {
            MenuItem item = this.mItems.get(position);
            if ((item instanceof SubtypeItem) == false) goto L7;
            return 0;
        L7:
            if ((item instanceof HeaderItem) == false) goto L11;
            return 1;
        L11:
            if ((item instanceof DividerItem) == false) goto L14;
            return 2;
        L14:
            return -1;
        }
    }

    static final class DividerItem implements MenuItem {
        private static DividerItem sInstance;

        DividerItem() {
        }

        static DividerItem getInstance() {
            if (sInstance != null) goto L6;
            sInstance = new DividerItem();
        L6:
            return sInstance;
        }

        public String toString() {
            return "DividerItem{}";
        }
    }

    static final class HeaderItem implements MenuItem {
        final CharSequence mTitle;

        HeaderItem(CharSequence title) {
            this.mTitle = title;
        }

        public String toString() {
            return "HeaderItem{mTitle=" + this.mTitle + "}";
        }
    }

    interface MenuItem {
    }

    private interface OnClickListener {
        void onClick(SubtypeItem r1, boolean r2);
    }

    static final class SubtypeItem implements MenuItem {
        final CharSequence mImeName;
        final InputMethodInfo mImi;
        private final CharSequence mLayoutName;
        final int mSubtypeIndex;
        final CharSequence mSubtypeName;

        /* JADX INFO: renamed from: -$$Nest$fgetmLayoutName, reason: not valid java name */
        static /* bridge */ /* synthetic */ CharSequence m4783$$Nest$fgetmLayoutName(SubtypeItem r0) {
            return r0.mLayoutName;
        }

        SubtypeItem(CharSequence imeName, CharSequence subtypeName, CharSequence layoutName, InputMethodInfo imi, int subtypeIndex) {
            this.mImeName = imeName;
            this.mSubtypeName = subtypeName;
            this.mLayoutName = layoutName;
            this.mImi = imi;
            this.mSubtypeIndex = subtypeIndex;
        }

        public String toString() {
            return "SubtypeItem{mImeName=" + this.mImeName + " mSubtypeName=" + this.mSubtypeName + " mSubtypeIndex=" + this.mSubtypeIndex + "}";
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-DHIbVCBBdP5s-oOHAerDovyFm8, reason: not valid java name */
    public static /* synthetic */ void m4778$r8$lambda$DHIbVCBBdP5soOHAerDovyFm8(InputMethodMenuControllerNew r0, int r1, int r2, SubtypeItem r3, boolean r4) {
        r0.lambda$show$0(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$-V0SmxAJd2epW9mgI18qNRIpE1g, reason: not valid java name */
    public static /* synthetic */ void m4779$r8$lambda$V0SmxAJd2epW9mgI18qNRIpE1g(InputMethodMenuControllerNew r0, Intent r1, int r2, int r3, View r4) {
        r0.lambda$updateLanguageSettingsButton$3(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$IEatni96P396ZHF_MES0J1HuJPI(InputMethodMenuControllerNew r0, int r1, int r2, DialogInterface r3) {
        r0.lambda$show$2(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$R-zNyHV2aHiVuwa1KBqp5SRtKcM, reason: not valid java name */
    public static /* synthetic */ void m4780$r8$lambda$RzNyHV2aHiVuwa1KBqp5SRtKcM(RecyclerView r0, int r1) {
        lambda$show$1(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m4781$$Nest$sfgetTAG() {
        return TAG;
    }

    InputMethodMenuControllerNew() {
        this.mDialogWindowContext = new InputMethodDialogWindowContext();
    }

    static {
        TAG = InputMethodMenuControllerNew.class.getSimpleName();
    }

    void show(List<InputMethodSubtypeSwitchingController.ImeSubtypeListItem> items, String selectedImeId, int selectedSubtypeIndex, boolean isScreenLocked, final int displayId, final int userId) {
        hide(displayId, userId);
        List<MenuItem> menuItems = getMenuItems(items);
        final int selectedIndex = getSelectedIndex(menuItems, selectedImeId, selectedSubtypeIndex);
        if (selectedIndex != (-1)) goto L5;
        Slog.w(TAG, "Switching menu shown with no item selected, IME id: " + selectedImeId + ", subtype index: " + selectedSubtypeIndex);
    L5:
        Context dialogWindowContext = this.mDialogWindowContext.get(displayId);
        AlertDialog.Builder builder = new AlertDialog.Builder(dialogWindowContext, R.style.Widget.Holo.Light.Button.Borderless);
        LayoutInflater inflater = LayoutInflater.from(builder.getContext());
        MenuItem r3 = null;
        View contentView = inflater.inflate(R.layout.notification_2025_template_expanded_media, null);
        contentView.setAccessibilityPaneTitle(dialogWindowContext.getText(R.string.use_a_different_app));
        builder.setView(contentView);
        OnClickListener onClickListener = new InputMethodMenuControllerNew$$ExternalSyntheticLambda0(this, userId, displayId);
        final RecyclerView recyclerView = contentView.requireViewById(R.id.list);
        recyclerView.setAdapter(new Adapter(menuItems, selectedIndex, inflater, onClickListener));
        recyclerView.post(new InputMethodMenuControllerNew$$ExternalSyntheticLambda1(recyclerView, selectedIndex));
        recyclerView.requestFocus();
        if (selectedIndex <= (-1)) goto L8;
        r3 = menuItems.get(selectedIndex);
    L8:
        MenuItem selectedItem = r3;
        updateLanguageSettingsButton(selectedItem, contentView, isScreenLocked, displayId, userId);
        builder.setOnCancelListener(new InputMethodMenuControllerNew$$ExternalSyntheticLambda2(this, displayId, userId));
        this.mMenuItems = menuItems;
        this.mDialog = builder.create();
        this.mDialog.setCanceledOnTouchOutside(true);
        Window w = this.mDialog.getWindow();
        w.setHideOverlayWindows(true);
        WindowManager.LayoutParams attrs = w.getAttributes();
        attrs.token = dialogWindowContext.getWindowContextToken();
        attrs.gravity = Gravity.getAbsoluteGravity(8388693, dialogWindowContext.getResources().getConfiguration().getLayoutDirection());
        attrs.x = 16;
        attrs.privateFlags = 16 | attrs.privateFlags;
        attrs.type = 2012;
        attrs.setTitle(WINDOW_TITLE);
        w.setAttributes(attrs);
        this.mDialog.show();
        InputMethodManagerInternal.get().updateShouldShowImeSwitcher(displayId, userId);
    }

    private /* synthetic */ void lambda$show$0(int userId, int displayId, SubtypeItem item, boolean isSelected) {
        if (isSelected == true) goto L4;
        InputMethodManagerInternal.get().switchToInputMethod(item.mImi.getId(), item.mSubtypeIndex, userId);
    L4:
        hide(displayId, userId);
    }

    private static /* synthetic */ void lambda$show$1(RecyclerView recyclerView, int selectedIndex) {
        recyclerView.scrollToPosition(selectedIndex);
    }

    private /* synthetic */ void lambda$show$2(int displayId, int userId, DialogInterface dialog) {
        hide(displayId, userId);
    }

    void hide(int displayId, int userId) {
        this.mMenuItems = null;
        if (this.mDialog == null) goto L6;
        this.mDialog.dismiss();
        this.mDialog = null;
        InputMethodManagerInternal.get().updateShouldShowImeSwitcher(displayId, userId);
        return;
    }

    boolean isShowing() {
        if (this.mDialog != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mDialog.isShowing() == false) goto L7;
        return true;
    }

    void dump(Printer pw, String prefix) {
        boolean showing = isShowing();
        pw.println(prefix + "isShowing: " + showing);
        if (showing == false) goto L6;
        pw.println(prefix + "menuItems: " + this.mMenuItems);
        return;
    }

    static List<MenuItem> getMenuItems(List<InputMethodSubtypeSwitchingController.ImeSubtypeListItem> items) {
        ArrayList<MenuItem> menuItems = new ArrayList();
        if (items.isEmpty() == false) goto L5;
        return menuItems;
    L5:
        ArrayList<InputMethodSubtypeSwitchingController.ImeSubtypeListItem> itemsArray = (ArrayList) items;
        int numItems = itemsArray.size();
        String prevImeId = ((InputMethodSubtypeSwitchingController.ImeSubtypeListItem) itemsArray.getLast()).mImi.getId();
        boolean firstGroup = true;
        int i = 0;
    L6:
        if (i >= numItems) goto L26;
        InputMethodSubtypeSwitchingController.ImeSubtypeListItem item = itemsArray.get(i);
        String imeId = item.mImi.getId();
        boolean addHeader = true;
        boolean groupChange = !imeId.equals(prevImeId);
        if (groupChange == false) goto L24;
        if (firstGroup == true) goto L12;
        menuItems.add(DividerItem.getInstance());
    L12:
        if ((i + 1) >= numItems) goto L14;
        String nextItemId = itemsArray.get(i + 1).mImi.getId();
    L16:
        if (item.mSubtypeName == null) goto L18;
    L21:
        if (addHeader == false) goto L23;
        menuItems.add(new HeaderItem(item.mImeName));
    L23:
        firstGroup = false;
        prevImeId = imeId;
        goto L24
    L18:
        if (imeId.equals(nextItemId) == true) goto L21;
        addHeader = false;
        goto L21
    L14:
        nextItemId = null;
    L24:
        menuItems.add(new SubtypeItem(item.mImeName, item.mSubtypeName, item.mLayoutName, item.mImi, item.mSubtypeIndex));
        i = i + 1;
        goto L6
    L26:
        return menuItems;
    }

    static int getSelectedIndex(List<MenuItem> items, String selectedImeId, int selectedSubtypeIndex) {
        int i = 0;
    L4:
        if (i >= items.size()) goto L16;
        MenuItem item = items.get(i);
        if ((item instanceof SubtypeItem) == false) goto L14;
        SubtypeItem subtypeItem = (SubtypeItem) item;
        String imeId = subtypeItem.mImi.getId();
        int subtypeIndex = subtypeItem.mSubtypeIndex;
        if (imeId.equals(selectedImeId) == false) goto L14;
        if (subtypeIndex != 0) goto L11;
        if (selectedSubtypeIndex != (-1)) goto L11;
    L13:
        return i;
    L11:
        if (subtypeIndex == (-1)) goto L13;
        if (subtypeIndex == selectedSubtypeIndex) goto L13;
    L14:
        i = i + 1;
        goto L4
    L16:
        return -1;
    }

    private void updateLanguageSettingsButton(MenuItem selectedItem, View view, boolean isScreenLocked, final int displayId, final int userId) {
        if ((selectedItem instanceof SubtypeItem) == false) goto L5;
        SubtypeItem selectedSubtypeItem = (SubtypeItem) selectedItem;
        final Intent settingsIntent = selectedSubtypeItem.mImi.createImeLanguageSettingsActivityIntent();
    L6:
        boolean hasButton = true;
        if (Settings.Global.getInt(view.getContext().getContentResolver(), "device_provisioned", 0) == 0) goto L9;
        boolean isDeviceProvisioned = true;
    L10:
        if (settingsIntent == null) goto L14;
        if (isScreenLocked == true) goto L14;
        if (isDeviceProvisioned == false) goto L14;
    L15:
        View buttonBar = view.requireViewById(R.id.checked);
        Button button = (Button) view.requireViewById(R.id.button1);
        RecyclerView recyclerView = view.requireViewById(R.id.list);
        if (hasButton == false) goto L18;
        settingsIntent.setFlags(268435456);
        buttonBar.setVisibility(0);
        button.setOnClickListener(new InputMethodMenuControllerNew$$ExternalSyntheticLambda3(this, settingsIntent, userId, displayId));
        recyclerView.setScrollIndicators(2);
        return;
    L18:
        buttonBar.setVisibility(8);
        button.setOnClickListener(null);
        recyclerView.setScrollIndicators(0);
        return;
    L14:
        hasButton = false;
        goto L15
    L9:
        isDeviceProvisioned = false;
        goto L10
    L5:
        settingsIntent = null;
        goto L6
    }

    private /* synthetic */ void lambda$updateLanguageSettingsButton$3(Intent settingsIntent, int userId, int displayId, View v) {
        v.getContext().startActivityAsUser(settingsIntent, UserHandle.of(userId));
        hide(displayId, userId);
    }
}
