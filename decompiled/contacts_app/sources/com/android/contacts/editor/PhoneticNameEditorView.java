package com.android.contacts.editor;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.android.contacts.model.DataKind;
import com.android.contacts.model.EntityDelta;
import com.android.contacts.util.HanziToPinyin;

/* JADX INFO: loaded from: classes.dex */
public class PhoneticNameEditorView extends TextFieldsEditorView {

    private static class PhoneticValuesDelta extends EntityDelta.ValuesDelta {
        private String mPhoneticName;
        private EntityDelta.ValuesDelta mValues;

        public PhoneticValuesDelta(EntityDelta.ValuesDelta r1) {
            this.mValues = r1;
            buildPhoneticName();
        }

        @Override // com.android.contacts.model.EntityDelta.ValuesDelta
        public void put(String r2, String r3) {
            if (r2.equals("#phoneticName") == false) goto L5;
            this.mPhoneticName = r3;
            parsePhoneticName(r3);
            return;
        L5:
            this.mValues.put(r2, r3);
            buildPhoneticName();
        }

        @Override // com.android.contacts.model.EntityDelta.ValuesDelta
        public String getAsString(String r2) {
            if (r2.equals("#phoneticName") == false) goto L7;
            return this.mPhoneticName;
        L7:
            return this.mValues.getAsString(r2);
        }

        private void parsePhoneticName(String r4) {
            ContentValues r5 = PhoneticNameEditorView.parsePhoneticName(r4, null);
            this.mValues.put("data9", r5.getAsString("data9"));
            this.mValues.put("data8", r5.getAsString("data8"));
            this.mValues.put("data7", r5.getAsString("data7"));
        }

        private void buildPhoneticName() {
            this.mPhoneticName = PhoneticNameEditorView.buildPhoneticName(this.mValues.getAsString("data9"), this.mValues.getAsString("data8"), this.mValues.getAsString("data7"));
        }

        @Override // com.android.contacts.model.EntityDelta.ValuesDelta
        public Long getId() {
            return this.mValues.getId();
        }

        @Override // com.android.contacts.model.EntityDelta.ValuesDelta
        public boolean isVisible() {
            return this.mValues.isVisible();
        }
    }

    public boolean hasData() {
        return false;
    }

    public static ContentValues parsePhoneticName(String r7, ContentValues r8) {
        String r1 = null;
        if (TextUtils.isEmpty(r7) == true) goto L13;
        String[] r9 = r7.split(HanziToPinyin.Token.SEPARATOR, 3);
        int r0 = r9.length;
        if (r0 != 1) goto L7;
        String r2 = null;
        r1 = r9[0];
        String r10 = null;
    L14:
        if (r8 != null) goto L16;
        r8 = new ContentValues();
    L16:
        r8.put("data9", r1);
        r8.put("data8", r2);
        r8.put("data7", r10);
        return r8;
    L7:
        if (r0 == 2) goto L11;
        if (r0 != 3) goto L13;
        r1 = r9[0];
        r2 = r9[1];
        r10 = r9[2];
        goto L14
    L11:
        String r3 = r9[0];
        r10 = r9[1];
        r1 = r3;
        r2 = null;
    L13:
        r10 = null;
        r2 = null;
        goto L14
    }

    public static String buildPhoneticName(String r3, String r4, String r5) {
        if (TextUtils.isEmpty(r3) == true) goto L5;
    L11:
        StringBuilder r0 = new StringBuilder();
        if (TextUtils.isEmpty(r3) == true) goto L15;
        r0.append(r3.trim()).append(' ');
    L15:
        if (TextUtils.isEmpty(r4) == true) goto L18;
        r0.append(r4.trim()).append(' ');
    L18:
        if (TextUtils.isEmpty(r5) == true) goto L20;
        r0.append(r5.trim()).append(' ');
    L20:
        r0.setLength(r0.length() - 1);
        return r0.toString();
    L5:
        if (TextUtils.isEmpty(r4) == false) goto L11;
        if (TextUtils.isEmpty(r5) == false) goto L11;
        return null;
    }

    public static boolean isUnstructuredPhoneticNameColumn(String r1) {
        return "#phoneticName".equals(r1);
    }

    public PhoneticNameEditorView(Context r1) {
        super(r1);
    }

    public PhoneticNameEditorView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public PhoneticNameEditorView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // com.android.contacts.editor.TextFieldsEditorView, com.android.contacts.editor.LabeledEditorView, com.android.contacts.editor.Editor
    public void setValues(DataKind r8, EntityDelta.ValuesDelta r9, EntityDelta r10, boolean r11, ViewIdGenerator r12) {
        if ((r9 instanceof PhoneticValuesDelta) == true) goto L5;
        EntityDelta.ValuesDelta r3 = new PhoneticValuesDelta(r9);
    L6:
        super.setValues(r8, r3, r10, r11, r12);
        return;
    L5:
        r3 = r9;
        goto L6
    }

    @Override // com.android.contacts.editor.LabeledEditorView, com.android.contacts.editor.Editor
    public void onFieldChanged(String r3, String r4) {
        if (isFieldChanged(r3, r4) == true) goto L6;
        return;
    L6:
        if (hasShortAndLongForms() == false) goto L10;
        PhoneticValuesDelta r0 = (PhoneticValuesDelta) getEntry();
        if ((!areOptionalFieldsVisible()) != isUnstructuredPhoneticNameColumn(r3)) goto L12;
        super.onFieldChanged(r3, r4);
        return;
    L12:
        return;
    L10:
        super.onFieldChanged(r3, r4);
    }
}
