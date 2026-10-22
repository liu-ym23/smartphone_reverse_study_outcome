package com.android.contacts.editor;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.DataKind;
import com.android.contacts.model.EntityDelta;
import java.util.ArrayList;
import java.util.List;
import obric.widget.support.AbsMenuItem;
import obric.widget.support.IMenuItem;
import obric.widget.support.ListPopMenuStandardAdapter;
import obric.widget.support.ListPopupMenu;

/* JADX INFO: loaded from: classes.dex */
public class OrganizationFieldEditorView extends LabeledEditorView {
    private Context mContext;
    private int mCurrentToken;
    private EditText[] mFieldsEditTexts;
    private boolean mHasCompanyTitle;
    private ListPopMenuStandardAdapter mOrganizationAdapter;
    private OrganizationQueryHandler mOrganizationQueryHandler;
    private ListPopupMenu mOrganizationReminderWindow;
    private boolean mReminderBtnVisible;
    private Cursor mReminderCursor;
    private Resources mResources;
    private List<IMenuItem> menuItems;

    class MenuItem extends AbsMenuItem {
        int iconRes;
        boolean isSelected;
        final /* synthetic */ OrganizationFieldEditorView this$0;
        String title;

        @Override // obric.widget.support.AbsMenuItem, obric.widget.support.IMenuItem
        public boolean hasMenuIcon() {
            return false;
        }

        MenuItem(OrganizationFieldEditorView r1) {
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
    }

    private class OrganizationQueryHandler extends AsyncOrgInfoQueryHandler {
        final /* synthetic */ OrganizationFieldEditorView this$0;

        public OrganizationQueryHandler(OrganizationFieldEditorView r1, ContentResolver r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // com.android.contacts.editor.AsyncOrgInfoQueryHandler
        protected void onMarkComplete(int r1) {
            OrganizationFieldEditorView.access$200(this.this$0, 10);
        }

        @Override // com.android.contacts.editor.AsyncOrgInfoQueryHandler
        protected void onQueryComplete(int r3, Cursor r4) {
            OrganizationFieldEditorView.access$300("onQueryComplete");
            if (20 != r3) goto L23;
            if (r4 == null) goto L47;
            OrganizationFieldEditorView.access$300("cursor count: " + r4.getCount());
        L20:
            e = move-exception;
            e.printStackTrace();
            return;
        L7:
            if (OrganizationFieldEditorView.access$400(this.this$0) != null) goto L9;
        L11:
            OrganizationFieldEditorView.access$402(this.this$0, r4);     // Catch: Exception -> L20
            OrganizationFieldEditorView r0 = this.this$0;     // Catch: Exception -> L20
            if (r4.getCount() <= 0) goto L14;
            boolean r1 = true;
        L15:
            OrganizationFieldEditorView.access$502(r0, r1);     // Catch: Exception -> L20
            if (r4.moveToFirst() == false) goto L18;
            OrganizationFieldEditorView.access$600(this.this$0, r4, r3);     // Catch: Exception -> L20
            return;
        L18:
            r4.close();     // Catch: Exception -> L20
            return;
        L14:
            r1 = false;
            goto L15
        L9:
            if (OrganizationFieldEditorView.access$400(this.this$0).isClosed() == true) goto L11;
            OrganizationFieldEditorView.access$400(this.this$0).close();     // Catch: Exception -> L20
            goto L11
        L47:
            return;
        L23:
            if (30 != r3) goto L50;
            if (r4 == null) goto L51;
            OrganizationFieldEditorView.access$300("cursor count: " + r4.getCount());
        L42:
            e = move-exception;
            e.printStackTrace();
            return;
        L27:
            if (OrganizationFieldEditorView.access$400(this.this$0) != null) goto L29;
        L31:
            OrganizationFieldEditorView.access$402(this.this$0, r4);     // Catch: Exception -> L42
            if (r4.getCount() > 0) goto L34;
        L36:
            r4.close();     // Catch: Exception -> L42
            if (OrganizationFieldEditorView.access$100(this.this$0) != null) goto L39;
            return;
        L39:
            if (OrganizationFieldEditorView.access$100(this.this$0).isShowing() == false) goto L54;
            OrganizationFieldEditorView.access$100(this.this$0).dismiss();     // Catch: Exception -> L42
            return;
        L54:
            return;
        L34:
            if (r4.moveToFirst() == false) goto L36;
            OrganizationFieldEditorView.access$600(this.this$0, r4, r3);     // Catch: Exception -> L42
            return;
        L29:
            if (OrganizationFieldEditorView.access$400(this.this$0).isClosed() == true) goto L31;
            OrganizationFieldEditorView.access$400(this.this$0).close();     // Catch: Exception -> L42
            goto L31
        L51:
            return;
        }
    }

    private class deleteItemListener implements View.OnClickListener {
        final /* synthetic */ OrganizationFieldEditorView this$0;

        @Override // android.view.View.OnClickListener
        public void onClick(View r1) {
        }

        private deleteItemListener(OrganizationFieldEditorView r1) {
            this.this$0 = r1;
        }
    }

    @Override // com.android.contacts.editor.Editor
    public void changeEditorBackground() {
    }

    static /* synthetic */ void access$000(OrganizationFieldEditorView r0, int r1, String r2) {
        r0.startQueryReminderInfo(r1, r2);
    }

    static /* synthetic */ ListPopupMenu access$100(OrganizationFieldEditorView r0) {
        return r0.mOrganizationReminderWindow;
    }

    static /* synthetic */ List access$1000(OrganizationFieldEditorView r0) {
        return r0.menuItems;
    }

    static /* synthetic */ EditText[] access$1100(OrganizationFieldEditorView r0) {
        return r0.mFieldsEditTexts;
    }

    static /* synthetic */ void access$200(OrganizationFieldEditorView r0, int r1) {
        r0.startQueryReminderInfo(r1);
    }

    static /* synthetic */ void access$300(String r0) {
        log(r0);
    }

    static /* synthetic */ Cursor access$400(OrganizationFieldEditorView r0) {
        return r0.mReminderCursor;
    }

    static /* synthetic */ Cursor access$402(OrganizationFieldEditorView r0, Cursor r1) {
        r0.mReminderCursor = r1;
        return r1;
    }

    static /* synthetic */ boolean access$502(OrganizationFieldEditorView r0, boolean r1) {
        r0.mReminderBtnVisible = r1;
        return r1;
    }

    static /* synthetic */ void access$600(OrganizationFieldEditorView r0, Cursor r1, int r2) {
        r0.showListPopupWindow(r1, r2);
    }

    static /* synthetic */ ListPopMenuStandardAdapter access$700(OrganizationFieldEditorView r0) {
        return r0.mOrganizationAdapter;
    }

    static /* synthetic */ void access$800(OrganizationFieldEditorView r0, String r1) {
        r0.markAsNoReminde(r1);
    }

    static /* synthetic */ void access$900(OrganizationFieldEditorView r0, ListPopupMenu r1) {
        r0.updateOrgListViewLayoutParams(r1);
    }

    public OrganizationFieldEditorView(Context r2) {
        super(r2);
        this.mReminderBtnVisible = false;
        this.menuItems = new ArrayList();
        this.mContext = r2;
    }

    public OrganizationFieldEditorView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mReminderBtnVisible = false;
        this.menuItems = new ArrayList();
        this.mContext = r1;
    }

    public OrganizationFieldEditorView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mReminderBtnVisible = false;
        this.menuItems = new ArrayList();
        this.mContext = r1;
    }

    @Override // com.android.contacts.editor.LabeledEditorView, com.android.contacts.editor.Editor
    public void setDeletable(boolean r1) {
        super.setDeletable(false);
    }

    @Override // com.android.contacts.editor.LabeledEditorView, android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mResources = getResources();
        startQueryReminderInfo(10);
    }

    @Override // com.android.contacts.editor.LabeledEditorView, com.android.contacts.editor.Editor
    public void setValues(DataKind r8, EntityDelta.ValuesDelta r9, EntityDelta r10, boolean r11, ViewIdGenerator r12) {
        setValues(r8, r9, r10, r11, r12, false);
    }

    public void setValues(DataKind r8, EntityDelta.ValuesDelta r9, EntityDelta r10, boolean r11, ViewIdGenerator r12, boolean r13) {
        int r0 = 2;
        if (r8.fieldList.size() != 2) goto L25;
        super.setValues(r8, r9, r10, r11, r12);
        removeAllViews();
        boolean r14 = hasOrganizationTitle(r8, r9);
        this.mHasCompanyTitle = r14;
        if (r14 == true) goto L8;
        r0 = 1;
    L8:
        this.mFieldsEditTexts = new EditText[r0];
        getResources().getDimensionPixelSize(R.dimen.text_field_content_padding_left);
        int r15 = 0;
    L9:
        if (r15 >= r0) goto L23;
        AccountType.EditField r1 = r8.fieldList.get(r15);
        View r2 = LayoutInflater.from(this.mContext).inflate(R.layout.edit_field_organization_list_with_delete_view, this, false);
        if (r2 == null) goto L22;
        EditText r3 = (EditText) r2.findViewById(R.id.text);
        r3.setTextCursorDrawable(getResources().getDrawable(R.drawable.contactedit_custom_cursor));
        this.mFieldsEditTexts[r15] = r3;
        r3.setFilters(new InputFilter[]{new InputFilter.LengthFilter(100)});
        r3.setBackgroundColor(0);
        r3.setTextColor(this.mResources.getColor(R.color.detail_primary_color));
        r3.setHintTextColor(this.mResources.getColor(R.color.detail_hint_color));
        r3.setTextSize(0, this.mResources.getDimensionPixelSize(R.dimen.editfragment_primary_textsize));
        r3.setGravity(16);
        if (r1.titleRes <= 0) goto L16;
        r3.setHint(r1.titleRes);
    L16:
        r3.setInputType(r1.inputType);
        r3.setSingleLine(true);
        r3.setEllipsize(TextUtils.TruncateAt.END);
        r3.setImeOptions(5);
        final String r4 = r1.column;
        r3.setText(r9.getAsString(r4));
        r3.addTextChangedListener(new AnonymousClass1(this, r4));
        if (isEnabled() == false) goto L20;
        if (r11 == true) goto L20;
        boolean r5 = true;
    L21:
        r3.setEnabled(r5);
        addView(r2);
    L20:
        r5 = false;
    L22:
        r15 = r15 + 1;
        goto L9
    L23:
        return;
    L25:
        throw new IllegalStateException("Organization kind must have 2 fields");
    }

    private void setDeleteBtnVisible(View r3, View r4, String r5, boolean r6) {
        if (r6 == false) goto L5;
        r3.setVisibility(0);
        r4.setVisibility(8);
        return;
    L5:
        r3.setVisibility(8);
        if (this.mReminderBtnVisible == true) goto L8;
        return;
    L8:
        if (r5.equals("data1") == false) goto L13;
        r4.setVisibility(0);
        return;
    }

    private void startQueryReminderInfo(int r2) {
        startQueryReminderInfo(r2, null);
    }

    private void startQueryReminderInfo(int r3, String r4) {
        log("startQueryReminderInfo");
        if (this.mOrganizationQueryHandler == null) goto L14;
    L10:
        OrganizationQueryHandler r2 = this.mOrganizationQueryHandler;
        if (r2 == null) goto L16;
        r2.startQuery(r3, r4);
        return;
    L16:
        return;
    L14:
        ContentResolver r0 = this.mContext.getContentResolver();     // Catch: Exception -> L6
    L8:
        if (r0 == null) goto L10;
        this.mOrganizationQueryHandler = new OrganizationQueryHandler(this, r0);
    L6:
        e = move-exception;
        e.printStackTrace();
        r0 = null;
        goto L8
    }

    private void showListPopupWindow(Cursor r10, final int r11) {
        log("showListPopupWindow");
        ListPopupMenu r0 = this.mOrganizationReminderWindow;
        if (r0 != null) goto L5;
    L15:
        final EditText r1 = this.mFieldsEditTexts[0];
        r1.setCursorVisible(false);
        final ListPopupMenu r8 = new ListPopupMenu(this.mContext);
        getOrgMenuItem(r10);
        ListPopMenuStandardAdapter r12 = new ListPopMenuStandardAdapter(this.mContext, this.menuItems);
        this.mOrganizationAdapter = r12;
        r12.setMenuItemStyle(2);
        this.mOrganizationAdapter.setCloseIconClickListener(new AnonymousClass2(this, r11, r8));
        r8.setContentAreaWidth(r1.getWidth() + ContactsUtils.dipTopx(this.mContext, 25.6d));
        r8.setAdapter(this.mOrganizationAdapter);
        r8.setMenuListTitleVisible(false);
        r8.setAnchorView(r1);
        updateOrgListViewLayoutParams(r8);
        r8.setOnItemClickListener(new AnonymousClass3(this, r8));
        r8.setOnDismissListener(new AnonymousClass4(this, r1));
        if (30 != r11) goto L18;
        r1.setCursorVisible(true);
        r8.getPopupWindow().setInputMethodMode(1);
        r8.setFocusable(false);
        this.mOrganizationAdapter.setCloseIconVisible(false);
    L19:
        int r4 = ContactsUtils.dipTopx(this.mContext, -18.5d);
        if (20 != r11) goto L22;
        int r6 = r1.getWidth() - ContactsUtils.dipTopx(this.mContext, 7.6d);
        r8.show(0, r4, ContactsUtils.dipTopx(this.mContext, -18.0d), r6, 0);
    L23:
        this.mOrganizationReminderWindow = r8;
        this.mCurrentToken = r11;
        return;
    L22:
        r8.setArrowInvisible();
        r8.show(0, r4, ContactsUtils.dipTopx(this.mContext, -12.0d), 0, 0);
        goto L23
    L18:
        hideSoftKeyboard();
        r8.setFocusable(true);
        goto L19
    L5:
        if (r0.isShowing() == false) goto L15;
        if (this.mCurrentToken != r11) goto L14;
        getOrgMenuItem(r10);
        this.mOrganizationAdapter.notifyDataSetChanged();
        if (r10 != null) goto L11;
        return;
    L11:
        if (r10.isClosed() == true) goto L26;
        r10.close();
        return;
    L26:
        return;
    L14:
        this.mOrganizationReminderWindow.dismiss();
        goto L15
    }

    private void updateOrgListViewLayoutParams(ListPopupMenu r6) {
        r6.getListViewHeight();
        ListPopMenuStandardAdapter r0 = this.mOrganizationAdapter;
        if (r0 == null) goto L8;
        if (r0.getCount() <= 5) goto L8;
        View r1 = this.mOrganizationAdapter.getView(0, null, r6.getListView());
        r1.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        r6.getListView().getLayoutParams().height = (r1.getMeasuredHeight() * 5) + (getResources().getDimensionPixelSize(R.dimen.list_divider_height) * 4);
        return;
    L8:
        if (this.mOrganizationAdapter.getCount() != 5) goto L12;
        r6.getListView().getLayoutParams().height = -2;
        return;
    }

    private void hideSoftKeyboard() {
        InputMethodManager r0 = (InputMethodManager) this.mContext.getSystemService("input_method");
        if (r0 == null) goto L6;
        r0.hideSoftInputFromWindow(getWindowToken(), 2);
        return;
    }

    private void getOrgMenuItem(Cursor r3) {
        if (this.menuItems != null) goto L5;
        this.menuItems = new ArrayList();
    L5:
        this.menuItems.clear();
        if (r3 != null) goto L8;
        return;
    L8:
        if (r3.moveToFirst() == false) goto L14;
    L9:
        MenuItem r0 = new MenuItem(this);
        r0.title = r3.getString(1);
        r0.isSelected = false;
        this.menuItems.add(r0);
        if (r3.moveToNext() == true) goto L9;
        return;
    }

    private void markAsNoReminde(String r2) {
        this.mOrganizationQueryHandler.startMark(40, r2);
    }

    private boolean hasOrganizationTitle(DataKind r1, EntityDelta.ValuesDelta r2) {
        return !TextUtils.isEmpty(r2.getAsString(r1.fieldList.get(1).column));
    }

    @Override // com.android.contacts.editor.LabeledEditorView, com.android.contacts.editor.Editor
    public void onFieldChanged(String r4, String r5) {
        if (isFieldChanged(r4, r5) == true) goto L5;
        return;
    L5:
        EntityDelta.ValuesDelta r0 = getEntry();
        if (r0 != null) goto L8;
    L10:
        saveValue(r4, r5);
        notifyEditorListener();
        return;
    L8:
        if (TextUtils.equals(r0.getMimetype(), "vnd.android.cursor.item/organization") == false) goto L10;
        r0.put("data14", String.valueOf(System.currentTimeMillis()));
        goto L10
    }

    @Override // com.android.contacts.editor.Editor
    public boolean isEmpty() {
        EditText[] r5 = this.mFieldsEditTexts;
        if (r5 != null) goto L5;
        return true;
    L5:
        int r1 = r5.length;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L11;
        if (TextUtils.isEmpty(r5[r3].getText()) == false) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    @Override // com.android.contacts.editor.Editor
    public void clearAllFields() {
        EditText[] r4 = this.mFieldsEditTexts;
        if (r4 != null) goto L5;
        return;
    L5:
        int r0 = r4.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L8;
        r4[r1].setText("");
        r1 = r1 + 1;
        goto L6
    }

    @Override // com.android.contacts.editor.LabeledEditorView
    public EditText getFirstFocusedEditText() {
        EditText[] r1 = this.mFieldsEditTexts;
        if (r1 != null) goto L5;
    L7:
        return null;
    L5:
        if (r1.length <= 0) goto L7;
        return r1[0];
    }

    @Override // com.android.contacts.editor.LabeledEditorView
    protected void requestFocusForFirstEditField() {
        requestFocusForFirstEditField(this.mFieldsEditTexts);
    }

    private static void log(String r1) {
        if (ContactsUtils.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("OrganizationFieldEditorView", r1);
        return;
    }
}
