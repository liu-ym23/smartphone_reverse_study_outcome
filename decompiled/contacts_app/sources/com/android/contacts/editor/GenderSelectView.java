package com.android.contacts.editor;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.model.DataKind;
import com.android.contacts.model.EntityDelta;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.popover.v2.OPopover;
import com.obric.ui.popover.Direct;
import com.obric.ui.popover.ItemType;
import com.obric.ui.popover.MenuItemData;
import com.obric.ui.popover.OUIPopoverHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class GenderSelectView extends LinearLayout implements Editor {
    private ArrayList<Integer> ganderList;
    private boolean mDeletable;
    private Editor.EditorListener mEditorListener;
    private TextView mGroupFieldLabel;
    private DataKind mKind;
    private OPopover mOPopover;
    private TextView mSpinnerText;
    private EntityDelta mState;
    private EntityDelta.ValuesDelta mValuesDelta;

    @Override // com.android.contacts.editor.Editor
    public void changeEditorBackground() {
    }

    @Override // com.android.contacts.editor.Editor
    public void onFieldChanged(String r1, String r2) {
    }

    static /* synthetic */ TextView access$000(GenderSelectView r0) {
        return r0.mSpinnerText;
    }

    static /* synthetic */ void access$100(GenderSelectView r0, View r1) {
        r0.showGanderMenus(r1);
    }

    static /* synthetic */ EntityDelta.ValuesDelta access$200(GenderSelectView r0) {
        return r0.mValuesDelta;
    }

    static /* synthetic */ EntityDelta.ValuesDelta access$202(GenderSelectView r0, EntityDelta.ValuesDelta r1) {
        r0.mValuesDelta = r1;
        return r1;
    }

    static /* synthetic */ EntityDelta access$300(GenderSelectView r0) {
        return r0.mState;
    }

    static /* synthetic */ DataKind access$400(GenderSelectView r0) {
        return r0.mKind;
    }

    static /* synthetic */ OPopover access$500(GenderSelectView r0) {
        return r0.mOPopover;
    }

    static /* synthetic */ Editor.EditorListener access$600(GenderSelectView r0) {
        return r0.mEditorListener;
    }

    public GenderSelectView(Context r4) {
        super(r4);
        this.ganderList = new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(R.string.not_set), Integer.valueOf(R.string.genderMale), Integer.valueOf(R.string.genderFemale)}));
    }

    public GenderSelectView(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.ganderList = new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(R.string.not_set), Integer.valueOf(R.string.genderMale), Integer.valueOf(R.string.genderFemale)}));
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mGroupFieldLabel = (TextView) findViewById(R.id.group_field_label);
        boolean r0 = "zh".equals(Locale.getDefault().getLanguage());
        boolean r1 = ContactsUtils.isScaledFontApplied(getContext());
        int r2 = R.dimen.text_field_label_width_big_font;
        if (r1 == false) goto L7;
        if (r0 == true) goto L9;
        r2 = R.dimen.text_field_lable_width_git_font_foreign;
    L9:
        ViewGroup.LayoutParams r3 = this.mGroupFieldLabel.getLayoutParams();
        r3.width = getResources().getDimensionPixelSize(r2);
        this.mGroupFieldLabel.setLayoutParams(r3);
        return;
    L7:
        if (r0 == false) goto L9;
        r2 = R.dimen.text_field_label_width;
        goto L9
    }

    public void setKind(DataKind r1) {
        this.mKind = r1;
    }

    public boolean hasSelectedGender() {
        EntityDelta.ValuesDelta r2 = this.mValuesDelta;
        if (r2 != null) goto L5;
        return false;
    L5:
        Integer r3 = r2.getAsInteger("data1");
        if (r3 != null) goto L8;
        return false;
    L8:
        if (r3.intValue() == 0) goto L12;
        return true;
    L12:
        return false;
    }

    public void setState(EntityDelta r4) {
        this.mState = r4;
        ArrayList<EntityDelta.ValuesDelta> r5 = r4.getMimeEntries("vnd.android.cursor.item/gender");
        int r0 = 0;
        if (r5 == null) goto L10;
        Iterator<EntityDelta.ValuesDelta> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L10;
        EntityDelta.ValuesDelta r1 = r6.next();
        this.mValuesDelta = r1;
        Integer r2 = r1.getAsInteger("data1");
        if (r2 == null) goto L6;
        r0 = r2.intValue();
    L10:
        TextView r7 = (TextView) findViewById(R.id.group_field_text);
        this.mSpinnerText = r7;
        r7.setText(this.ganderList.get(r0).intValue());
        if (r0 == 0) goto L13;
        this.mSpinnerText.setTextColor(getResources().getColor(R.color.oui_basic_text_1));
    L14:
        ((OCardListItem) findViewById(R.id.textfields_editor_item)).setOnContentClickListener(new AnonymousClass1(this));
        return;
    L13:
        this.mSpinnerText.setTextColor(getResources().getColor(R.color.oui_basic_text_3));
        goto L14
    }

    private void showGanderMenus(View r4) {
        this.mOPopover = OUIPopoverHelper.genPopover((Activity) getContext(), getMenuList(), false);
        OUIPopoverHelper.showPopupAtAnchorView((Activity) getContext(), this.mOPopover, Direct.TOP_MID, r4, null);
    }

    private List<MenuItemData> getMenuList() {
        ArrayList r1 = new ArrayList();
        final int r3 = 0;
    L4:
        if (r3 >= this.ganderList.size()) goto L6;
        final String r11 = getContext().getString(this.ganderList.get(r3).intValue());
        r1.add(new MenuItemData(ItemType.TEXT, null, null, null, r11, null, false, null, null, new AnonymousClass2(this, r3, r11)));
        r3 = r3 + 1;
        goto L4
    L6:
        return r1;
    }

    @Override // com.android.contacts.editor.Editor
    public boolean isEmpty() {
        EntityDelta.ValuesDelta r2 = this.mValuesDelta;
        if (r2 != null) goto L5;
        return true;
    L5:
        Integer r3 = r2.getAsInteger("data1");
        if (r3 != null) goto L8;
        return true;
    L8:
        if (r3.intValue() == 0) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // com.android.contacts.editor.Editor
    public void setValues(DataKind r1, EntityDelta.ValuesDelta r2, EntityDelta r3, boolean r4, ViewIdGenerator r5) {
        this.mKind = r1;
        this.mValuesDelta = r2;
        this.mState = r3;
        setState(r3);
    }

    @Override // com.android.contacts.editor.Editor
    public void setDeletable(boolean r1) {
        this.mDeletable = r1;
    }

    @Override // com.android.contacts.editor.Editor
    public void setEditorListener(Editor.EditorListener r1) {
        this.mEditorListener = r1;
    }

    @Override // com.android.contacts.editor.Editor
    public void deleteEditor() {
        Editor.EditorListener r0 = this.mEditorListener;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mDeletable == false) goto L9;
        r0.onDeleteRequested(this);
        return;
    }

    @Override // com.android.contacts.editor.Editor
    public void deleteEditor(ViewGroup r2) {
        Editor.EditorListener r3 = this.mEditorListener;
        if (r3 != null) goto L5;
        return;
    L5:
        if (this.mDeletable == false) goto L9;
        r3.onDeleteRequested(this);
        return;
    }

    @Override // com.android.contacts.editor.Editor
    public void clearAllFields() {
        EntityDelta.ValuesDelta r0 = this.mValuesDelta;
        if (r0 == null) goto L8;
        r0.put("data1", 0);
        TextView r1 = this.mSpinnerText;
        if (r1 == null) goto L9;
        r1.setText(this.ganderList.get(0).intValue());
        this.mSpinnerText.setTextColor(getResources().getColor(R.color.oui_basic_text_3));
        return;
    L9:
        return;
    }
}
