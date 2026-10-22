package com.android.contacts.editor;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.DataKind;
import com.android.contacts.model.EntityDelta;
import com.android.contacts.model.EntityModifier;
import com.android.contacts.util.BytedanceApi;
import com.android.contacts.util.DialogManager;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.misc.OSimpleFormDialog;
import com.obric.oui.forms.OEditText;
import com.obric.oui.popover.v2.OPopover;
import com.obric.ui.dialog.OUIDialogHelper;
import com.obric.ui.popover.Direct;
import com.obric.ui.popover.ItemType;
import com.obric.ui.popover.MenuItemData;
import com.obric.ui.popover.OUIPopoverHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: classes.dex */
public abstract class LabeledEditorView extends LinearLayout implements Editor, DialogManager.DialogShowingView {
    public static final AccountType.EditType CUSTOM_SELECTION = null;
    private static final int DIALOG_ID_CUSTOM = 1;
    protected static final String DIALOG_ID_KEY = "dialog_id";
    public static final int INPUT_TYPE_CUSTOM = 8193;
    private OButton mDelete;
    private DialogManager mDialogManager;
    private EntityDelta.ValuesDelta mEntry;
    private boolean mHasCustomSelection;
    private boolean mIsAttachedToWindow;
    private boolean mIsDeletable;
    protected boolean mIsMixedContact;
    private TextView mItemLabel;
    private DataKind mKind;
    private LinearLayout mLabel;
    protected Editor.EditorListener mListener;
    protected int mMinLineItemHeight;
    private OnLabelChangeListener mOnLabelChangeListener;
    private boolean mReadOnly;
    private Resources mRes;
    private ArrayList<AccountType.EditType> mSpinnerItems;
    private AdapterView.OnItemSelectedListener mSpinnerListener;
    private OPopover mSpinnerPopover;
    private TextView mSpinnerText;
    protected EntityDelta mState;
    private AccountType.EditType mType;
    private ViewIdGenerator mViewIdGenerator;
    private boolean mWasEmpty;

    private class EditTypeAdapter extends ArrayAdapter<AccountType.EditType> {
        private boolean mHasCustomSelection;
        private final LayoutInflater mInflater;
        final /* synthetic */ LabeledEditorView this$0;

        public EditTypeAdapter(LabeledEditorView r2, Context r3) {
            this.this$0 = r2;
            super(r3, 0);
            this.mInflater = LayoutInflater.from(r3);
            if (LabeledEditorView.access$500(r2) != null) goto L5;
        L12:
            ArrayList<AccountType.EditType> r4 = EntityModifier.getValidTypes(r2.mState, LabeledEditorView.access$700(r2), LabeledEditorView.access$500(r2));
            Iterator<AccountType.EditType> r5 = r4.iterator();
        L14:
            if (r5.hasNext() == false) goto L18;
            if (r5.next().disappearWhenUserAdd == false) goto L14;
            r5.remove();
            goto L14
        L18:
            addAll(r4);
            return;
        L5:
            if (LabeledEditorView.access$500(r2).customColumn == null) goto L10;
            if (LabeledEditorView.access$600(r2).getAsString(LabeledEditorView.access$500(r2).customColumn) == null) goto L12;
            add(LabeledEditorView.CUSTOM_SELECTION);
            this.mHasCustomSelection = true;
            goto L12
        L10:
            if (LabeledEditorView.access$500(r2).disappearWhenUserAdd == false) goto L12;
            add(LabeledEditorView.access$500(r2));
            goto L12
        }

        public boolean hasCustomSelection() {
            return this.mHasCustomSelection;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int r2, View r3, ViewGroup r4) {
            return createViewFromResource(r2, r3, r4, R.layout.custom_simple_spinner_item);
        }

        @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
        public View getDropDownView(int r2, View r3, ViewGroup r4) {
            return createViewFromResource(r2, r3, r4, R.layout.lable_spinner_dropdown_item);
        }

        private View createViewFromResource(int r3, View r4, ViewGroup r5, int r6) {
            if (r4 != null) goto L4;
            TextView r7 = (TextView) this.mInflater.inflate(r6, r5, false);
            r7.setTextSize(0, LabeledEditorView.access$800(this.this$0).getDimensionPixelSize(R.dimen.editfragment_secondary_textsize));
            BytedanceApi.setMaxTextSize(r7, ContactsUtils.dipTopx(LabeledEditorView.access$900(this.this$0), 15.0d) * 1.33f);
            r7.setSingleLine(true);
        L5:
            AccountType.EditType r8 = getItem(r3);
            if (r8 != LabeledEditorView.CUSTOM_SELECTION) goto L8;
            String r2 = LabeledEditorView.access$600(this.this$0).getAsString(LabeledEditorView.access$500(this.this$0).customColumn);
        L9:
            r7.setText(r2);
            return r7;
        L8:
            r2 = getContext().getString(r8.labelRes);
            goto L9
        L4:
            r7 = (TextView) r4;
            goto L5
        }
    }

    public interface OnLabelChangeListener {
        void onLabelChanged();
    }

    public EditText getFirstFocusedEditText() {
        return null;
    }

    public Spinner getLabel() {
        return null;
    }

    protected abstract void requestFocusForFirstEditField();

    static /* synthetic */ void access$000(LabeledEditorView r0, View r1) {
        r0.showSpinnerMenu(r1);
    }

    static /* synthetic */ boolean access$100(LabeledEditorView r0) {
        return r0.mIsAttachedToWindow;
    }

    static /* synthetic */ void access$200(LabeledEditorView r0, int r1) {
        r0.spinnerClick(r1);
    }

    static /* synthetic */ TextView access$300(LabeledEditorView r0) {
        return r0.mSpinnerText;
    }

    static /* synthetic */ void access$400(LabeledEditorView r0) {
        r0.rebuildLabel();
    }

    static /* synthetic */ AccountType.EditType access$500(LabeledEditorView r0) {
        return r0.mType;
    }

    static /* synthetic */ EntityDelta.ValuesDelta access$600(LabeledEditorView r0) {
        return r0.mEntry;
    }

    static /* synthetic */ DataKind access$700(LabeledEditorView r0) {
        return r0.mKind;
    }

    static /* synthetic */ Resources access$800(LabeledEditorView r0) {
        return r0.mRes;
    }

    static /* synthetic */ Context access$900(LabeledEditorView r0) {
        return r0.mContext;
    }

    static {
        CUSTOM_SELECTION = new AccountType.EditType(0, 0);
    }

    public void setOnLabelChangeListener(OnLabelChangeListener r1) {
        this.mOnLabelChangeListener = r1;
    }

    public LabeledEditorView(Context r2) {
        super(r2);
        this.mIsMixedContact = false;
        this.mWasEmpty = true;
        this.mIsDeletable = true;
        this.mDialogManager = null;
        this.mSpinnerItems = new ArrayList();
        this.mSpinnerListener = new AnonymousClass1(this);
        init(r2);
    }

    public LabeledEditorView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mIsMixedContact = false;
        this.mWasEmpty = true;
        this.mIsDeletable = true;
        this.mDialogManager = null;
        this.mSpinnerItems = new ArrayList();
        this.mSpinnerListener = new AnonymousClass1(this);
        init(r1);
    }

    public LabeledEditorView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mIsMixedContact = false;
        this.mWasEmpty = true;
        this.mIsDeletable = true;
        this.mDialogManager = null;
        this.mSpinnerItems = new ArrayList();
        this.mSpinnerListener = new AnonymousClass1(this);
        init(r1);
    }

    private void init(Context r3) {
        this.mMinLineItemHeight = r3.getResources().getDimensionPixelSize(R.dimen.editor_min_line_item_height);
        this.mContext = r3;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mRes = getResources();
        this.mLabel = (LinearLayout) findViewById(R.id.spinner_btn_layout);
        this.mSpinnerText = (TextView) findViewById(R.id.spinner_text);
        LinearLayout r0 = this.mLabel;
        if (r0 == null) goto L7;
        r0.setOnClickListener(new AnonymousClass2(this));
        TextView r1 = (TextView) findViewById(R.id.item_label);
        this.mItemLabel = r1;
        if (r1 == null) goto L7;
        BytedanceApi.setMaxTextSize(r1, ContactsUtils.dipTopx(this.mContext, 15.0d) * 1.33f);
    L7:
        OButton r2 = (OButton) findViewById(R.id.delete_button);
        this.mDelete = r2;
        if (r2 == null) goto L11;
        r2.setOnClickListener(new AnonymousClass3(this));
        return;
    }

    private void showSpinnerMenu(View r4) {
        this.mSpinnerPopover = OUIPopoverHelper.genPopover((Activity) getContext(), getMenuList(), false);
        OUIPopoverHelper.showPopupAtAnchorView((Activity) getContext(), this.mSpinnerPopover, Direct.TOP_MID, r4, null);
    }

    private List<MenuItemData> getMenuList() {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= this.mSpinnerItems.size()) goto L6;
        String r8 = getSpinnerTextByIndex(r1);
        r0.add(new MenuItemData(ItemType.TEXT, null, null, null, r8, null, null, null, null, new AnonymousClass4(this)));
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsAttachedToWindow = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mIsAttachedToWindow = false;
    }

    @Override // com.android.contacts.editor.Editor
    public void deleteEditor(ViewGroup r1) {
        this.mEntry.markDeleted();
    }

    @Override // com.android.contacts.editor.Editor
    public void deleteEditor() {
        this.mEntry.markDeleted();
        if (this.mIsMixedContact == false) goto L6;
        this.mEntry.markRefDeleted();
        return;
    }

    public boolean isReadOnly() {
        return this.mReadOnly;
    }

    public int getBaseline(int r1) {
        if (r1 != 0) goto L7;
        LinearLayout r0 = this.mLabel;
        if (r0 != null) goto L6;
        return -1;
    L6:
        return r0.getBaseline();
    L7:
        return -1;
    }

    private void setupLabelButton(boolean r4) {
        if (r4 == false) goto L15;
        LinearLayout r5 = this.mLabel;
        if (r5 != null) goto L7;
        return;
    L7:
        if (this.mReadOnly == false) goto L9;
    L11:
        boolean r2 = false;
    L12:
        r5.setEnabled(r2);
        this.mLabel.setVisibility(0);
        TextView r3 = this.mItemLabel;
        if (r3 == null) goto L22;
        r3.setVisibility(8);
        return;
    L22:
        return;
    L9:
        if (isEnabled() == false) goto L11;
        r2 = true;
        goto L12
    L15:
        LinearLayout r6 = this.mLabel;
        if (r6 == null) goto L24;
        r6.setVisibility(8);
        TextView r7 = this.mItemLabel;
        if (r7 == null) goto L25;
        r7.setVisibility(0);
        this.mItemLabel.setText(this.mKind.titleRes);
        return;
    L25:
        return;
    }

    private void setupDeleteButton() {
        if (this.mIsDeletable == false) goto L15;
        OButton r0 = this.mDelete;
        boolean r1 = false;
        if (r0 == null) goto L7;
        r0.setVisibility(0);
    L7:
        OButton r2 = this.mDelete;
        if (r2 != null) goto L10;
        return;
    L10:
        if (this.mReadOnly == false) goto L12;
    L14:
        r2.setEnabled(r1);
        return;
    L12:
        if (isEnabled() == false) goto L14;
        r1 = true;
        goto L14
    L15:
        OButton r3 = this.mDelete;
        if (r3 == null) goto L21;
        r3.setVisibility(8);
        return;
    }

    public void setDeleteButtonVisible(boolean r3) {
        if (this.mIsDeletable == false) goto L10;
        OButton r0 = this.mDelete;
        if (r0 == null) goto L10;
        if (r3 == false) goto L8;
        int r1 = 0;
    L9:
        r0.setVisibility(r1);
        goto L10
    L8:
        r1 = 4;
    L10:
        this.mWasEmpty = !r3;
    }

    public void deleteViewQuite() {
        this.mIsAttachedToWindow = true;
        this.mDelete.performClick();
    }

    protected void onOptionalFieldVisibilityChange() {
        Editor.EditorListener r1 = this.mListener;
        if (r1 == null) goto L6;
        r1.onRequest(5);
        return;
    }

    @Override // com.android.contacts.editor.Editor
    public void setEditorListener(Editor.EditorListener r1) {
        this.mListener = r1;
    }

    @Override // com.android.contacts.editor.Editor
    public void setDeletable(boolean r1) {
        this.mIsDeletable = r1;
        setupDeleteButton();
    }

    @Override // android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        LinearLayout r0 = this.mLabel;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L10:
        OButton r2 = this.mDelete;
        if (r2 != null) goto L13;
        return;
    L13:
        if (this.mReadOnly == true) goto L16;
        if (r5 == false) goto L16;
    L17:
        r2.setEnabled(r1);
        return;
    L16:
        r1 = false;
        goto L17
    L5:
        if (this.mReadOnly == true) goto L8;
        if (r5 == false) goto L8;
        boolean r3 = true;
    L9:
        r0.setEnabled(r3);
    L8:
        r3 = false;
        goto L9
    }

    public OButton getDelete() {
        return this.mDelete;
    }

    protected DataKind getKind() {
        return this.mKind;
    }

    protected EntityDelta.ValuesDelta getEntry() {
        return this.mEntry;
    }

    protected AccountType.EditType getType() {
        return this.mType;
    }

    private void rebuildLabel() {
        buildSpinnerItem();
        if (this.mHasCustomSelection == false) goto L5;
        int r0 = this.mSpinnerItems.indexOf(CUSTOM_SELECTION);
    L22:
        updateSpinnerTextInMain(getSpinnerTextByIndex(r0));
        return;
    L5:
        r0 = this.mSpinnerItems.indexOf(this.mType);
        if (r0 != (-1)) goto L22;
        ArrayList<AccountType.EditType> r1 = EntityModifier.getValidTypes(this.mState, this.mKind, this.mType);
        if (r1 == null) goto L21;
        Iterator<AccountType.EditType> r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L16;
        AccountType.EditType r3 = r2.next();
        if (r3.equals(this.mType) == false) goto L12;
    L17:
        if (r3 == null) goto L21;
        if (this.mSpinnerItems.size() <= 0) goto L21;
        ArrayList<AccountType.EditType> r4 = this.mSpinnerItems;
        r4.add(r4.size() - 1, this.mType);
        goto L21
    L16:
        r3 = null;
    L21:
        r0 = this.mSpinnerItems.indexOf(this.mType);
        goto L22
    }

    private void buildSpinnerItem() {
        this.mSpinnerItems.clear();
        this.mHasCustomSelection = false;
        AccountType.EditType r0 = this.mType;
        if (r0 != null) goto L5;
    L12:
        ArrayList<AccountType.EditType> r1 = EntityModifier.getValidTypes(this.mState, this.mKind, this.mType);
        Iterator<AccountType.EditType> r2 = r1.iterator();
    L14:
        if (r2.hasNext() == false) goto L18;
        if (r2.next().disappearWhenUserAdd == false) goto L14;
        r2.remove();
        goto L14
    L18:
        spinnerItemAdd(r1);
        return;
    L5:
        if (r0.customColumn == null) goto L10;
        if (this.mEntry.getAsString(this.mType.customColumn) == null) goto L12;
        this.mSpinnerItems.add(CUSTOM_SELECTION);
        this.mHasCustomSelection = true;
        goto L12
    L10:
        if (this.mType.disappearWhenUserAdd == false) goto L12;
        this.mSpinnerItems.add(this.mType);
        goto L12
    }

    private void spinnerItemAdd(ArrayList<AccountType.EditType> r6) {
        int r1 = 0;
    L4:
        if (r1 >= r6.size()) goto L16;
        AccountType.EditType r2 = r6.get(r1);
        int r3 = 0;
    L7:
        if (r3 >= this.mSpinnerItems.size()) goto L12;
        if (this.mSpinnerItems.get(r3) == r2) goto L10;
        r3 = r3 + 1;
        goto L7
    L10:
        boolean r4 = false;
    L13:
        if (r4 == false) goto L15;
        this.mSpinnerItems.add(r2);
    L15:
        r1 = r1 + 1;
        goto L4
    L12:
        r4 = true;
        goto L13
    }

    private void spinnerClick(int r2) {
        onTypeSelectionChange(r2);
        OPopover r0 = this.mSpinnerPopover;
        if (r0 == null) goto L5;
        r0.dismiss();
    L5:
        updateSpinnerTextInMain(getSpinnerTextByIndex(r2));
    }

    private String getSpinnerTextByIndex(int r2) {
        if (r2 != (-1)) goto L5;
        return null;
    L5:
        if (this.mSpinnerItems.size() == 0) goto L15;
        AccountType.EditType r3 = this.mSpinnerItems.get(r2);
        if (r3 != CUSTOM_SELECTION) goto L11;
        return this.mEntry.getAsString(this.mType.customColumn);
    L11:
        return getContext().getString(r3.labelRes);
    L15:
        return null;
    }

    private void updateSpinnerTextInMain(final String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L7;
        LinearLayout r0 = this.mLabel;
        if (r0 == null) goto L7;
        r0.setVisibility(8);
    L7:
        new Handler(Looper.getMainLooper()).post(new AnonymousClass5(this, r3));
    }

    @Override // com.android.contacts.editor.Editor
    public void onFieldChanged(String r2, String r3) {
        if (isFieldChanged(r2, r3) == true) goto L5;
        return;
    L5:
        saveValue(r2, r3);
        notifyEditorListener();
    }

    protected void saveValue(String r2, String r3) {
        this.mEntry.put(r2, r3);
        if (this.mIsMixedContact == false) goto L6;
        this.mEntry.updateRefValuesDelta(r2, r3);
        return;
    }

    protected void notifyEditorListener() {
        Editor.EditorListener r0 = this.mListener;
        if (r0 == null) goto L5;
        r0.onRequest(2);
    L5:
        boolean r1 = isEmpty();
        if (this.mWasEmpty != r1) goto L8;
        return;
    L8:
        if (r1 == false) goto L15;
        Editor.EditorListener r2 = this.mListener;
        if (r2 == null) goto L13;
        r2.onRequest(3);
    L13:
        if (this.mIsDeletable == false) goto L21;
        this.mDelete.setVisibility(4);
    L21:
        this.mWasEmpty = r1;
        return;
    L15:
        Editor.EditorListener r3 = this.mListener;
        if (r3 == null) goto L19;
        r3.onRequest(4);
    L19:
        if (this.mIsDeletable == false) goto L21;
        this.mDelete.setVisibility(0);
        goto L21
    }

    protected boolean isFieldChanged(String r1, String r2) {
        String r0 = this.mEntry.getAsString(r1);
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        return !TextUtils.equals(r0, r2);
    }

    protected void rebuildValues() {
        setValues(this.mKind, this.mEntry, this.mState, this.mReadOnly, this.mViewIdGenerator);
    }

    public void setValues(DataKind r5, EntityDelta.ValuesDelta r6, EntityDelta r7, boolean r8, ViewIdGenerator r9) {
        this.mKind = r5;
        this.mEntry = r6;
        this.mState = r7;
        boolean r1 = true;
        if (r7.getRawContactId().longValue() != (-115)) goto L5;
        boolean r0 = true;
    L6:
        this.mIsMixedContact = r0;
        this.mReadOnly = r8;
        this.mViewIdGenerator = r9;
        setId(r9.getId(r7, r5, r6, -1));
        if (r6.isVisible() == true) goto L10;
        setVisibility(8);
        return;
    L10:
        setVisibility(0);
        boolean r10 = EntityModifier.hasEditTypes(r5);
        setupLabelButton(r10);
        LinearLayout r11 = this.mLabel;
        if (r11 == null) goto L22;
        if (r8 == false) goto L14;
    L16:
        r1 = false;
    L17:
        r11.setEnabled(r1);
        AccountType r12 = this.mState.getRawContactAccountType(this.mContext);
        if (r12 == null) goto L22;
        if ("com.android.sim".equals(r12.accountType) == false) goto L22;
        this.mLabel.setEnabled(false);
        goto L22
    L14:
        if (isEnabled() == false) goto L16;
    L22:
        if (r10 == false) goto L25;
        this.mType = EntityModifier.getCurrentType(r6, r5);
        rebuildLabel();
        return;
    L25:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public EntityDelta.ValuesDelta getValues() {
        return this.mEntry;
    }

    private Dialog createCustomDialog() {
        final boolean[] r2 = {false};
        final OSimpleFormDialog r4 = OUIDialogHelper.getSimpleFormDialog(getContext(), getContext().getString(R.string.customLabelPickerTitle), "", getContext().getString(R.string.common_ok), getContext().getString(R.string.common_cancel), "", "", false, new LabeledEditorView$$ExternalSyntheticLambda0(this, r2, r1), new LabeledEditorView$$ExternalSyntheticLambda1(this, r2));
        final OSimpleFormDialog[] r1 = {r4};
        r4.setAutoDismiss(true);
        r4.setCancelable(true);
        final OEditText r3 = r4.getInputView1().getVInput();
        r3.setInputType(INPUT_TYPE_CUSTOM);
        r3.setSaveEnabled(true);
        r3.requestFocus();
        AccountType.EditType r0 = this.mType;
        if (r0 != null) goto L5;
    L9:
        r3.addTextChangedListener(new AnonymousClass6(this, r4));
        r4.setOnDismissListener(new AnonymousClass7(this, r2));
        r4.setOnShowListener(new AnonymousClass8(this, r3, r4));
        return r4;
    L5:
        if (r0.customColumn == null) goto L9;
        String r5 = this.mEntry.getAsString(this.mType.customColumn);
        if (TextUtils.isEmpty(r5) == true) goto L9;
        r3.setText(r5);
        r3.setSelection(r5.length());
        goto L9
    }

    /* JADX INFO: renamed from: lambda$createCustomDialog$0$com-android-contacts-editor-LabeledEditorView, reason: not valid java name */
    /* synthetic */ Unit m188x89521c4f(boolean[] r4, OSimpleFormDialog[] r5) {
        r4[0] = true;
        String r6 = r5[0].getInputView1().getVInput().getText().toString().trim();
        if (ContactsUtils.isGraphic(r6) == false) goto L14;
        ArrayList<AccountType.EditType> r7 = EntityModifier.getValidTypes(this.mState, this.mKind, null);
        this.mType = null;
        Iterator<AccountType.EditType> r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L11;
        AccountType.EditType r1 = r8.next();
        if (r1.customColumn == null) goto L6;
        this.mType = r1;
    L11:
        if (this.mType != null) goto L13;
        return null;
    L13:
        this.mEntry.put(this.mKind.typeColumn, this.mType.rawValue);
        this.mEntry.put(this.mType.customColumn, r6);
        rebuildLabel();
        requestFocusForFirstEditField();
        onLabelRebuilt();
    L15:
        updateSpinnerTextInMain(r6);
        return null;
    L14:
        rebuildLabel();
        requestFocusForFirstEditField();
        goto L15
    }

    /* JADX INFO: renamed from: lambda$createCustomDialog$1$com-android-contacts-editor-LabeledEditorView, reason: not valid java name */
    /* synthetic */ Unit m189xfecc4290(boolean[] r3) {
        r3[0] = true;
        rebuildLabel();
        requestFocusForFirstEditField();
        onLabelRebuilt();
        return null;
    }

    protected void onLabelRebuilt() {
        OnLabelChangeListener r0 = this.mOnLabelChangeListener;
        if (r0 == null) goto L6;
        r0.onLabelChanged();
        return;
    }

    protected void onTypeSelectionChange(int r3) {
        AccountType.EditType r4 = this.mSpinnerItems.get(r3);
        if (this.mHasCustomSelection == true) goto L5;
    L7:
        AccountType.EditType r0 = this.mType;
        if (r0 != r4) goto L13;
        if (r0.customColumn != null) goto L13;
        return;
    L13:
        if (r4.customColumn == null) goto L15;
        showDialog(1);
        return;
    L15:
        this.mType = r4;
        this.mEntry.put(this.mKind.typeColumn, this.mType.rawValue);
        rebuildLabel();
        requestFocusForFirstEditField();
        onLabelRebuilt();
        return;
    L5:
        if (r4 != CUSTOM_SELECTION) goto L7;
    }

    void showDialog(int r3) {
        Bundle r0 = new Bundle();
        r0.putInt(DIALOG_ID_KEY, r3);
        getDialogManager().showDialogInView(this, r0);
    }

    private DialogManager getDialogManager() {
        if (this.mDialogManager != null) goto L10;
        Object r0 = getContext();
        if ((r0 instanceof DialogManager.DialogShowingViewActivity) == false) goto L8;
        this.mDialogManager = ((DialogManager.DialogShowingViewActivity) r0).getDialogManager();
        goto L10
    L8:
        throw new IllegalStateException("View must be hosted in an Activity that implements DialogManager.DialogShowingViewActivity");
    L10:
        return this.mDialogManager;
    }

    public Dialog createDialog(Bundle r3) {
        if (r3 == null) goto L10;
        int r4 = r3.getInt(DIALOG_ID_KEY);
        if (r4 != 1) goto L8;
        Dialog r2 = createCustomDialog();
        r2.getWindow().setSoftInputMode(5);
        return r2;
    L8:
        throw new IllegalArgumentException("Invalid dialogId: " + r4);
    L10:
        throw new IllegalArgumentException("bundle must not be null");
    }

    protected final void requestFocusForFirstEditField(EditText[] r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.length == 0) goto L23;
        int r5 = r6.length;
        boolean r0 = false;
        EditText r1 = null;
        int r2 = 0;
    L6:
        if (r2 >= r5) goto L16;
        EditText r3 = r6[r2];
        if (r1 != null) goto L13;
        if (r3.getVisibility() != 0) goto L13;
        r1 = r3;
    L13:
        if (r3.hasFocus() == true) goto L14;
        r2 = r2 + 1;
        goto L6
    L14:
        r0 = true;
    L16:
        if (r0 == true) goto L24;
        if (r1 == null) goto L25;
        r1.requestFocus();
        return;
    L25:
        return;
    L24:
        return;
    }

    protected void performAddFieldAction() {
        requestFocusForFirstEditField();
    }
}
