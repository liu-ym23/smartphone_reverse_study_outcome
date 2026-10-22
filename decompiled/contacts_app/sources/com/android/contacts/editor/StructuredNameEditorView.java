package com.android.contacts.editor;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.android.contacts.model.DataKind;
import com.android.contacts.model.EntityDelta;
import com.android.contacts.util.NameConverter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class StructuredNameEditorView extends TextFieldsEditorView {
    private boolean mChanged;
    private ContentValues mSnapshot;

    /* JADX INFO: renamed from: com.android.contacts.editor.StructuredNameEditorView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public boolean mChanged;
        public ContentValues mSnapshot;
        public Parcelable mSuperState;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* synthetic */ SavedState(Parcel r1, AnonymousClass1 r2) {
            this(r1);
        }

        SavedState(Parcelable r1) {
            this.mSuperState = r1;
        }

        private SavedState(Parcel r3) {
            ClassLoader r0 = getClass().getClassLoader();
            this.mSuperState = r3.readParcelable(r0);
            if (r3.readInt() == 0) goto L5;
            boolean r1 = true;
        L6:
            this.mChanged = r1;
            this.mSnapshot = (ContentValues) r3.readParcelable(r0);
            return;
        L5:
            r1 = false;
            goto L6
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            r2.writeParcelable(this.mSuperState, 0);
            r2.writeInt(this.mChanged ? 1 : 0);
            r2.writeParcelable(this.mSnapshot, 0);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    public StructuredNameEditorView(Context r1) {
        super(r1);
    }

    public StructuredNameEditorView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public StructuredNameEditorView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // com.android.contacts.editor.TextFieldsEditorView, com.android.contacts.editor.LabeledEditorView, com.android.contacts.editor.Editor
    public void setValues(DataKind r1, EntityDelta.ValuesDelta r2, EntityDelta r3, boolean r4, ViewIdGenerator r5) {
        super.setValues(r1, r2, r3, r4, r5);
        if (this.mSnapshot != null) goto L5;
        this.mSnapshot = new ContentValues(getValues().getCompleteValues());
        this.mChanged = r2.isInsert();
        return;
    L5:
        this.mChanged = false;
    }

    @Override // com.android.contacts.editor.LabeledEditorView, com.android.contacts.editor.Editor
    public void onFieldChanged(String r2, String r3) {
        if (isFieldChanged(r2, r3) == true) goto L5;
        return;
    L5:
        saveValue(r2, r3);
        this.mChanged = true;
        if (hasShortAndLongForms() == true) goto L8;
    L11:
        notifyEditorListener();
        return;
    L8:
        if (areOptionalFieldsVisible() == false) goto L10;
        rebuildFullName(getValues());
        goto L11
    L10:
        rebuildStructuredName(getValues());
        goto L11
    }

    @Override // com.android.contacts.editor.LabeledEditorView
    protected void onOptionalFieldVisibilityChange() {
        if (hasShortAndLongForms() == true) goto L5;
    L8:
        super.onOptionalFieldVisibilityChange();
        return;
    L5:
        if (areOptionalFieldsVisible() == false) goto L7;
        switchFromFullNameToStructuredName();
        goto L8
    L7:
        switchFromStructuredNameToFullName();
        goto L8
    }

    private void switchFromFullNameToStructuredName() {
        EntityDelta.ValuesDelta r0 = getValues();
        if (this.mChanged == true) goto L8;
        String[] r1 = NameConverter.STRUCTURED_NAME_FIELDS;
        int r2 = r1.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L7;
        String r4 = r1[r3];
        r0.put(r4, this.mSnapshot.getAsString(r4));
        r3 = r3 + 1;
        goto L5
    L7:
        return;
    L8:
        String r5 = r0.getAsString("data1");
        Map<String, String> r6 = NameConverter.displayNameToStructuredName(getContext(), r5);
        if (r6.isEmpty() == true) goto L14;
        eraseFullName(r0);
        Iterator<String> r7 = r6.keySet().iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        String r8 = r7.next();
        r0.put(r8, r6.get(r8));
    L14:
        this.mSnapshot.clear();
        this.mSnapshot.putAll(r0.getCompleteValues());
        this.mSnapshot.put("data1", r5);
    }

    private void switchFromStructuredNameToFullName() {
        EntityDelta.ValuesDelta r0 = getValues();
        if (this.mChanged == true) goto L6;
        r0.put("data1", this.mSnapshot.getAsString("data1"));
        return;
    L6:
        Map<String, String> r1 = valuesToStructuredNameMap(r0);
        String r3 = NameConverter.structuredNameToDisplayName(getContext(), r1);
        if (TextUtils.isEmpty(r3) == true) goto L9;
        eraseStructuredName(r0);
        r0.put("data1", r3);
    L9:
        this.mSnapshot.clear();
        this.mSnapshot.put("data1", r0.getAsString("data1"));
        Iterator<String> r2 = r1.keySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        String r4 = r2.next();
        this.mSnapshot.put(r4, r1.get(r4));
        goto L11
    }

    private Map<String, String> valuesToStructuredNameMap(EntityDelta.ValuesDelta r6) {
        HashMap r5 = new HashMap();
        String[] r0 = NameConverter.STRUCTURED_NAME_FIELDS;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        String r3 = r0[r2];
        r5.put(r3, r6.getAsString(r3));
        r2 = r2 + 1;
        goto L3
    L5:
        return r5;
    }

    private void eraseFullName(EntityDelta.ValuesDelta r1) {
        r1.putNull("data1");
    }

    private void rebuildFullName(EntityDelta.ValuesDelta r2) {
        Map<String, String> r0 = valuesToStructuredNameMap(r2);
        r2.put("data1", NameConverter.structuredNameToDisplayName(getContext(), r0));
    }

    private void eraseStructuredName(EntityDelta.ValuesDelta r4) {
        String[] r3 = NameConverter.STRUCTURED_NAME_FIELDS;
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r4.putNull(r3[r1]);
        r1 = r1 + 1;
        goto L3
    }

    private void rebuildStructuredName(EntityDelta.ValuesDelta r4) {
        String r0 = r4.getAsString("data1");
        Map<String, String> r3 = NameConverter.displayNameToStructuredName(getContext(), r0);
        Iterator<String> r1 = r3.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        String r2 = r1.next();
        r4.put(r2, r3.get(r2));
        goto L4
    }

    private static void appendQueryParameter(Uri.Builder r1, String r2, String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L6;
        r1.appendQueryParameter(r2, r3);
        return;
    }

    @Override // com.android.contacts.editor.TextFieldsEditorView, android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r0 = new SavedState(super.onSaveInstanceState());
        r0.mChanged = this.mChanged;
        r0.mSnapshot = this.mSnapshot;
        return r0;
    }

    @Override // com.android.contacts.editor.TextFieldsEditorView, android.view.View
    protected void onRestoreInstanceState(Parcelable r2) {
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.mSuperState);
        this.mChanged = r3.mChanged;
        this.mSnapshot = r3.mSnapshot;
    }
}
