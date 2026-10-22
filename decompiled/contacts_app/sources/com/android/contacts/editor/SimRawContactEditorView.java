package com.android.contacts.editor;

import android.content.Context;
import android.database.Cursor;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.contacts.R;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.DataKind;
import com.android.contacts.model.EntityDelta;
import com.android.contacts.model.EntityModifier;
import com.obric.oui.button.OButton;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class SimRawContactEditorView extends BaseRawContactEditorView {
    private static final int NOTE_VIEW_DEFINED_LOCATION = 0;
    EntityDelta.ValuesDelta entry;
    DataKind kind;
    private ImageView mAccountIcon;
    private TextView mAccountNameTextView;
    private TextView mAccountTypeTextView;
    private boolean mAutoAddToDefaultGroup;
    private long mContactId;
    private ViewGroup mFields;
    private DataKind mGroupMembershipKind;
    private Cursor mGroupMetaData;
    private LayoutInflater mInflater;
    private BaseRawContactEditorView.Listener mListener;
    private StructuredNameEditorView mName;
    private boolean mPhoneticNameAdded;
    private View mPhotoStub;
    private long mRawContactId;
    private OButton mRemoveContacatButton;
    private EntityDelta mState;
    EntityDelta mstate;
    ViewIdGenerator mvig;
    boolean readOnly;

    static /* synthetic */ BaseRawContactEditorView.Listener access$000(SimRawContactEditorView r0) {
        return r0.mListener;
    }

    public SimRawContactEditorView(Context r3) {
        super(r3);
        this.mRawContactId = -1;
        this.mContactId = -1;
        this.mAutoAddToDefaultGroup = true;
    }

    public SimRawContactEditorView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mRawContactId = -1;
        this.mContactId = -1;
        this.mAutoAddToDefaultGroup = true;
    }

    public void setListener(BaseRawContactEditorView.Listener r1) {
        this.mListener = r1;
    }

    @Override // android.view.View
    public void setEnabled(boolean r4) {
        super.setEnabled(r4);
        PhotoEditorView r0 = getPhotoEditor();
        if (r0 == null) goto L5;
        r0.setEnabled(r4);
    L5:
        StructuredNameEditorView r1 = this.mName;
        if (r1 == null) goto L8;
        r1.setEnabled(r4);
    L8:
        ViewGroup r2 = this.mFields;
        if (r2 == null) goto L16;
        int r3 = r2.getChildCount();
        int r5 = 0;
    L11:
        if (r5 >= r3) goto L20;
        View r6 = this.mFields.getChildAt(r5);
        if (r6 == null) goto L15;
        r6.setEnabled(r4);
    L15:
        r5 = r5 + 1;
        goto L11
    L20:
        return;
    }

    @Override // com.android.contacts.editor.BaseRawContactEditorView, android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        StructuredNameEditorView r0 = (StructuredNameEditorView) findViewById(R.id.edit_name);
        this.mName = r0;
        r0.setDeletable(false);
        this.mFields = (ViewGroup) findViewById(R.id.sect_fields);
        this.mAccountIcon = (ImageView) findViewById(R.id.account_icon);
        this.mAccountTypeTextView = (TextView) findViewById(R.id.account_type);
        this.mAccountNameTextView = (TextView) findViewById(R.id.account_name);
        OButton r1 = (OButton) findViewById(R.id.Button_remove_contact);
        this.mRemoveContacatButton = r1;
        r1.setOnClickListener(new AnonymousClass1(this));
    }

    @Override // com.android.contacts.editor.BaseRawContactEditorView
    public void setState(EntityDelta r16, AccountType r17, ViewIdGenerator r18, boolean r19) {
        this.mState = r16;
        this.mFields.removeAllViews();
        if (r16 == null) goto L48;
        if (r17 == null) goto L49;
        setId(r18.getId(r16, null, null, -1));
        EntityModifier.ensureKindExists(r16, r17, "vnd.android.cursor.item/name");
        EntityModifier.ensureKindExists(r16, r17, "vnd.android.cursor.item/organization");
        EntityModifier.ensureKindExists(r16, r17, "vnd.android.cursor.item/note");
        EntityModifier.ensureKindExists(r16, r17, "vnd.android.cursor.item/phone_v2");
        EntityDelta.ValuesDelta r1 = r16.getValues();
        if (r1.getAsLong("_id") == null) goto L9;
        this.mRawContactId = r1.getAsLong("_id").longValue();
    L9:
        EntityModifier.ensureKindExists(r16, r17, "vnd.android.cursor.item/photo");
        if (r17.getKindForMimetype("vnd.android.cursor.item/photo") == null) goto L12;
        boolean r2 = true;
    L13:
        setHasPhotoEditor(r2);
        getPhotoEditor().setEnabled(isEnabled());
        this.mName.setEnabled(isEnabled());
        this.mFields.setVisibility(0);
        this.mName.setVisibility(0);
        Iterator<DataKind> r14 = r17.getSortedDataKinds().iterator();
    L15:
        if (r14.hasNext() == false) goto L31;
        DataKind r3 = r14.next();
        if (r3.editable == false) goto L15;
        String r4 = r3.mimeType;
        if ("vnd.android.cursor.item/name".equals(r4) == true) goto L21;
        if ("vnd.android.cursor.item/photo".equals(r4) == true) goto L24;
        if (r3.fieldList == null) goto L15;
        KindSectionView r5 = (KindSectionView) this.mInflater.inflate(R.layout.item_kind_section, this.mFields, false);
        r5.setEnabled(isEnabled());
        r5.setState(r3, r16, false, r18);
        if ("vnd.android.cursor.item/note".equals(r4) == true) goto L15;
        this.mFields.addView(r5);
        goto L15
    L24:
        getPhotoEditor().setValues(r3, r16.getPrimaryEntry(r4), r16, true, r18);
        goto L15
    L21:
        this.entry = r16.getPrimaryEntry(r4);
        this.mstate = r16;
        this.readOnly = false;
        this.mvig = r18;
        goto L15
    L31:
        this.mName.setValues(r17.getKindForMimetype("#displayName"), this.entry, this.mstate, false, r18);
        return;
    L12:
        r2 = false;
        goto L13
    L49:
        return;
    }

    public TextFieldsEditorView getNameEditor() {
        return this.mName;
    }

    @Override // com.android.contacts.editor.BaseRawContactEditorView
    public long getRawContactId() {
        return this.mRawContactId;
    }
}
