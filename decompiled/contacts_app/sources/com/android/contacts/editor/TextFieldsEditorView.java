package com.android.contacts.editor;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.DataKind;
import com.android.contacts.model.EntityDelta;
import com.android.contacts.util.BytedanceApi;
import com.android.contacts.util.PhoneNumberFormatter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class TextFieldsEditorView extends LabeledEditorView {
    private EditText[] mFieldEditTexts;
    private ViewGroup mFields;
    private boolean mHasShortAndLongForms;
    private boolean mHideOptional;
    private Resources mRes;

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public int[] mVisibilities;

        /* synthetic */ SavedState(Parcel r1, AnonymousClass1 r2) {
            this(r1);
        }

        SavedState(Parcelable r1) {
            super(r1);
        }

        private SavedState(Parcel r2) {
            super(r2);
            int[] r0 = new int[r2.readInt()];
            this.mVisibilities = r0;
            r2.readIntArray(r0);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.mVisibilities.length);
            r1.writeIntArray(this.mVisibilities);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    @Override // com.android.contacts.editor.Editor
    public void changeEditorBackground() {
    }

    public TextFieldsEditorView(Context r1) {
        super(r1);
        this.mFieldEditTexts = null;
        this.mFields = null;
        this.mHideOptional = true;
    }

    public TextFieldsEditorView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mFieldEditTexts = null;
        this.mFields = null;
        this.mHideOptional = true;
    }

    public TextFieldsEditorView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mFieldEditTexts = null;
        this.mFields = null;
        this.mHideOptional = true;
    }

    @Override // com.android.contacts.editor.LabeledEditorView, android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        setDrawingCacheEnabled(true);
        setAlwaysDrawnWithCacheEnabled(true);
        this.mRes = getResources();
        this.mFields = (ViewGroup) findViewById(R.id.editors);
        this.mHideOptional = true;
    }

    @Override // com.android.contacts.editor.LabeledEditorView, android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        if (this.mFieldEditTexts == null) goto L13;
        int r1 = 0;
    L5:
        EditText[] r2 = this.mFieldEditTexts;
        if (r1 >= r2.length) goto L17;
        EditText r3 = r2[r1];
        if (isReadOnly() == true) goto L11;
        if (r5 == false) goto L11;
        boolean r4 = true;
    L12:
        r3.setEnabled(r4);
        r1 = r1 + 1;
    L11:
        r4 = false;
        goto L12
    L17:
        return;
    }

    @Override // com.android.contacts.editor.LabeledEditorView
    public EditText getFirstFocusedEditText() {
        EditText[] r1 = this.mFieldEditTexts;
        if (r1 != null) goto L5;
    L7:
        return null;
    L5:
        if (r1.length <= 0) goto L7;
        return r1[0];
    }

    @Override // com.android.contacts.editor.LabeledEditorView
    protected void requestFocusForFirstEditField() {
        requestFocusForFirstEditField(this.mFieldEditTexts);
    }

    @Override // com.android.contacts.editor.LabeledEditorView, com.android.contacts.editor.Editor
    public void setValues(final DataKind r28, final EntityDelta.ValuesDelta r29, EntityDelta r30, boolean r31, ViewIdGenerator r32) {
        DataKind r7 = r28;
        EntityDelta r9 = r30;
        super.setValues(r28, r29, r30, r31, r32);
        EditText[] r0 = this.mFieldEditTexts;
        if (r0 == null) goto L7;
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        this.mFields.removeView(r0[r2]);
        r2 = r2 + 1;
    L7:
        boolean r11 = "#displayName".equals(r7.mimeType);
        if (ContactsUtils.FEATURE_SIM_PHONEBOOK == true) goto L10;
    L12:
        boolean r13 = false;
    L13:
        if (r13 == false) goto L15;
        this.mHideOptional = true;
    L15:
        int r14 = r7.fieldList.size();
        ArrayList r15 = new ArrayList();
        getResources().getDimensionPixelSize(R.dimen.text_field_content_padding_left);
        int r5 = this.mRes.getColor(R.color.detail_primary_color);
        int r4 = this.mRes.getColor(R.color.oui_functional_blue_6);
        int r3 = this.mRes.getColor(R.color.detail_hint_color);
        int r6 = this.mRes.getColor(R.color.detail_note_hint_color);
        float r8 = this.mRes.getDimensionPixelSize(R.dimen.editfragment_primary_textsize);
        boolean r16 = true;
        int r10 = 0;
        boolean r17 = false;
    L16:
        if (r10 >= r14) goto L113;
        AccountType.EditField r12 = r7.fieldList.get(r10);
        if (r11 == true) goto L20;
        int r19 = r14;
    L28:
        final EditText r18 = new EditText(this.mContext);
        r18.setSingleLine(true);
        int r20 = r4;
        r18.setEllipsize(TextUtils.TruncateAt.END);
        r18.setHorizontallyScrolling(true);
        r18.setTextCursorDrawable(getResources().getDrawable(R.drawable.contactedit_custom_cursor));
        r18.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if ("vnd.android.cursor.item/postal-address_v2".equals(r7.mimeType) == false) goto L32;
        int r21 = r10;
        r18.setFilters(new InputFilter[]{new InputFilter.LengthFilter(200)});
    L36:
        final String r22 = r12.column;
        String r23 = r29.getAsString(r22);
        r18.setBackgroundResource(R.color.Transparent);
        r18.setHeight(ContactsUtils.dipTopx(this.mContext, 48.0d));
        if (r11 == false) goto L41;
        if (r13 == true) goto L41;
        if (r16 == false) goto L41;
        r16 = false;
    L41:
        r18.setTextColor(r5);
        if (r7.mimeType.equals("vnd.android.cursor.item/note") == false) goto L44;
        r18.setHintTextColor(r6);
    L45:
        r18.setTextSize(0, r8);
        if ("vnd.android.cursor.item/note".equals(r7.mimeType) == false) goto L49;
        BytedanceApi.setMaxTextSize(r18, ContactsUtils.dipTopx(this.mContext, 16.0d));
    L49:
        if ("vnd.android.cursor.item/email_v2".equals(r7.mimeType) == false) goto L52;
        BytedanceApi.setMaxTextSize(r18, ContactsUtils.dipTopx(this.mContext, 18.0d));
    L52:
        if ("vnd.android.cursor.item/im".equals(r7.mimeType) == false) goto L55;
        BytedanceApi.setMaxTextSize(r18, ContactsUtils.dipTopx(this.mContext, 16.0d));
        r18.setEllipsize(TextUtils.TruncateAt.END);
    L55:
        if ("vnd.android.cursor.item/sip_address".equals(r7.mimeType) == false) goto L57;
        r18.setEllipsize(TextUtils.TruncateAt.END);
    L57:
        r18.setGravity(16);
        ArrayList r24 = r15;
        r24.add(r18);
        EntityDelta r110 = r30;
        int r25 = r21;
        r18.setId(r32.getId(r110, r7, r29, r25));
        if (r12.titleRes <= 0) goto L60;
        r18.setHint(r12.titleRes);
    L60:
        int r26 = r12.inputType;
        r18.setInputType(r26);
        r18.setImeOptions(5);
        r18.setText(r23);
        if (TextUtils.isEmpty(r23) == true) goto L65;
        r18.setSelection(r18.getText().length());
    L65:
        if (r26 != 3) goto L67;
        PhoneNumberFormatter.setPhoneNumberFormattingTextWatcher(this.mContext, r18, false);
        int r27 = r20;
        r18.setTextColor(r27);
    L68:
        setDeleteButtonVisible(!TextUtils.isEmpty(r23));
        int r210 = r25;
        int r211 = r27;
        r18.addTextChangedListener(new AnonymousClass1(this, r22, r29, r18, r28));
        if (isEnabled() == false) goto L72;
        if (r31 == true) goto L72;
        boolean r33 = true;
    L73:
        r18.setEnabled(r33);
        int r34 = 8;
        if (r12.shortForm == false) goto L81;
        boolean r35 = true;
        this.mHasShortAndLongForms = true;
        if (this.mHideOptional == false) goto L78;
        r34 = 0;
    L78:
        r18.setVisibility(r34);
    L79:
        r17 = r35;
    L108:
        if (r29.mIsTextBoldAndBlue == false) goto L110;
        r18.setTextColor(this.mRes.getColor(R.color.contact_detail_bule));
        boolean r36 = true;
        r18.getPaint().setFakeBoldText(true);
        r18.requestFocus();
    L111:
        r18.setTag(this.mRes.getString(r12.titleRes));
        this.mFields.addView(r18);
    L112:
        r10 = r210 + 1;
        r7 = r28;
        r15 = r24;
        r9 = r110;
        r14 = r19;
        r8 = r8;
        r4 = r211;
        r6 = r6;
        r3 = r3;
        r5 = r5;
        goto L16
    L110:
        r36 = true;
        goto L111
    L81:
        if (r12.longForm == false) goto L88;
        this.mHasShortAndLongForms = true;
        if (this.mHideOptional == true) goto L86;
        r34 = 0;
    L86:
        r18.setVisibility(r34);
        r17 = true;
        goto L108
    L88:
        if (ContactsUtils.isGraphic(r23) == false) goto L90;
    L92:
        boolean r37 = false;
    L94:
        if (this.mHideOptional == false) goto L97;
        if (r37 == false) goto L97;
        boolean r38 = true;
    L98:
        if (r38 == true) goto L101;
        r34 = 0;
    L101:
        r18.setVisibility(r34);
        if (r17 == true) goto L106;
        if (r37 == true) goto L106;
        r35 = false;
    L106:
        r35 = true;
    L97:
        r38 = false;
        goto L98
    L90:
        if (r12.optional == false) goto L92;
        r37 = true;
    L72:
        r33 = false;
        goto L73
    L67:
        r27 = r20;
        goto L68
    L44:
        r18.setHintTextColor(r3);
        goto L45
    L32:
        r21 = r10;
        if ("vnd.android.cursor.item/note".equals(r7.mimeType) == true) goto L36;
        r18.setFilters(new InputFilter[]{new InputFilter.LengthFilter(100)});
        goto L36
    L20:
        if (r13 == false) goto L24;
        r19 = r14;
        if ("data1".equals(r12.column) == true) goto L28;
    L26:
        r210 = r10;
        r6 = r6;
        r211 = r4;
        r110 = r9;
        r24 = r15;
        r36 = true;
        goto L112
    L24:
        r19 = r14;
        if ("data1".equals(r12.column) == true) goto L28;
    L113:
        this.mFieldEditTexts = (EditText[]) r15.toArray(new EditText[0]);
        return;
    L10:
        if ("com.android.sim".equals(r9.getRawContactAccountType(this.mContext).accountType) == false) goto L12;
        r13 = true;
        goto L13
    }

    @Override // com.android.contacts.editor.Editor
    public boolean isEmpty() {
        int r1 = 0;
    L4:
        if (r1 >= this.mFields.getChildCount()) goto L14;
        View r2 = this.mFields.getChildAt(r1);
        if (r2 == null) goto L8;
        EditText r3 = (EditText) r2;
    L9:
        if (r3 == null) goto L13;
        if (TextUtils.isEmpty(r3.getText()) == true) goto L13;
        return false;
    L13:
        r1 = r1 + 1;
        goto L4
    L8:
        r3 = null;
        goto L9
    L14:
        return true;
    }

    public boolean areOptionalFieldsVisible() {
        return !this.mHideOptional;
    }

    public boolean hasShortAndLongForms() {
        return this.mHasShortAndLongForms;
    }

    public void acquireEditorBounds(Rect r4) {
        EditText[] r0 = this.mFieldEditTexts;
        if (r0 == null) goto L14;
        int r1 = r0.length;
    L5:
        r1 = r1 - 1;
        if (r1 < 0) goto L15;
        EditText r2 = this.mFieldEditTexts[r1];
        if (r2.getVisibility() != 0) goto L5;
        r4.set(r2.getLeft(), r2.getTop(), r2.getRight(), r2.getBottom());
        return;
    L15:
        return;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        EditText[] r0 = this.mFieldEditTexts;
        int r2 = 0;
        if (r0 != null) goto L5;
        int r3 = 0;
    L6:
        r1.mVisibilities = new int[r3];
    L7:
        if (r2 >= r3) goto L9;
        r1.mVisibilities[r2] = this.mFieldEditTexts[r2].getVisibility();
        r2 = r2 + 1;
        goto L7
    L9:
        return r1;
    L5:
        r3 = r0.length;
        goto L6
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r5) {
        SavedState r6 = (SavedState) r5;
        super.onRestoreInstanceState(r6.getSuperState());
        int r0 = Math.min(this.mFieldEditTexts.length, r6.mVisibilities.length);
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mFieldEditTexts[r1].setVisibility(r6.mVisibilities[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public void setVisible(boolean r4) {
        if (r4 == false) goto L10;
        int r0 = 0;
    L5:
        if (r0 >= this.mFields.getChildCount()) goto L14;
        if (this.mRes.getString(R.string.name_prefix).equals(this.mFields.getChildAt(r0).getTag()) == false) goto L9;
        this.mFields.getChildAt(r0).setVisibility(0);
    L9:
        r0 = r0 + 1;
        goto L5
    L14:
        return;
    }

    @Override // com.android.contacts.editor.Editor
    public void clearAllFields() {
        EditText[] r4 = this.mFieldEditTexts;
        if (r4 == null) goto L7;
        int r0 = r4.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r4[r1].setText("");
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }
}
