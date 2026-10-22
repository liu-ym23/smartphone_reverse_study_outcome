package com.android.contacts.editor;

import android.content.ContentUris;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.model.DataKind;
import com.android.contacts.model.EntityDelta;
import com.android.contacts.model.EntityModifier;
import com.bytedance.framwork.core.sdklib.DBHelper;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class RawContactReadOnlyEditorView extends BaseRawContactEditorView implements View.OnClickListener {
    private String mAccountName;
    private String mAccountType;
    private String mDataSet;
    private Button mEditExternallyButton;
    private ViewGroup mGeneral;
    private LayoutInflater mInflater;
    private Listener mListener;
    private TextView mName;
    private View mPhotoStub;
    private long mRawContactId;

    public interface Listener {
        void onExternalEditorRequest(AccountWithDataSet r1, Uri r2);
    }

    public RawContactReadOnlyEditorView(Context r3) {
        super(r3);
        this.mRawContactId = -1;
    }

    public RawContactReadOnlyEditorView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mRawContactId = -1;
    }

    public void setListener(Listener r1) {
        this.mListener = r1;
    }

    @Override // com.android.contacts.editor.BaseRawContactEditorView, android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        this.mPhotoStub = findViewById(R.id.stub_photo);
        this.mName = (TextView) findViewById(R.id.read_only_name);
        Button r0 = (Button) findViewById(R.id.button_edit_externally);
        this.mEditExternallyButton = r0;
        r0.setOnClickListener(this);
        this.mGeneral = (ViewGroup) findViewById(R.id.sect_general);
    }

    @Override // com.android.contacts.editor.BaseRawContactEditorView
    public void setState(EntityDelta r12, AccountType r13, ViewIdGenerator r14, boolean r15) {
        this.mGeneral.removeAllViews();
        if (r12 == null) goto L65;
        if (r13 == null) goto L67;
        EntityModifier.ensureKindExists(r12, r13, "vnd.android.cursor.item/name");
        EntityDelta.ValuesDelta r0 = r12.getValues();
        this.mAccountName = r0.getAsString("account_name");
        this.mAccountType = r0.getAsString("account_type");
        this.mDataSet = r0.getAsString("data_set");
        this.mRawContactId = r0.getAsLong("_id").longValue();
        DataKind r2 = r13.getKindForMimetype("vnd.android.cursor.item/photo");
        if (r2 == null) goto L17;
        EntityModifier.ensureKindExists(r12, r13, "vnd.android.cursor.item/photo");
        if (r13.getKindForMimetype("vnd.android.cursor.item/photo") == null) goto L11;
        boolean r10 = true;
    L12:
        setHasPhotoEditor(r10);
        getPhotoEditor().setValues(r2, r12.getPrimaryEntry("vnd.android.cursor.item/photo"), r12, !r13.areContactsWritable(), r14);
        View r16 = this.mPhotoStub;
        if (r10 == false) goto L15;
        int r1 = 0;
    L16:
        r16.setVisibility(r1);
    L18:
        EntityDelta.ValuesDelta r17 = r12.getPrimaryEntry("vnd.android.cursor.item/name");
        TextView r18 = this.mName;
        if (r17 == null) goto L21;
        String r19 = r17.getAsString("data1");
    L22:
        r18.setText(r19);
        if (r13.getEditContactActivityClassName() != null) goto L25;
        int r110 = 8;
    L26:
        this.mEditExternallyButton.setVisibility(r110);
        Resources r111 = this.mContext.getResources();
        ArrayList<EntityDelta.ValuesDelta> r112 = r12.getMimeEntries("vnd.android.cursor.item/phone_v2");
        if (r112 == null) goto L40;
        int r3 = 0;
    L30:
        if (r3 >= r112.size()) goto L40;
        EntityDelta.ValuesDelta r4 = r112.get(r3);
        String r5 = PhoneNumberUtils.formatNumber(r4.getAsString("data1"), r4.getAsString("data4"), ContactsUtils.getCurrentCountryIso(getContext()));
        if (r4.containsKey(DBHelper.COL_DATA2) == false) goto L34;
        CharSequence r6 = ContactsContract.CommonDataKinds.Phone.getTypeLabel(r111, r4.getAsInteger(DBHelper.COL_DATA2).intValue(), r4.getAsString(DBHelper.COL_DATA3));
    L35:
        CharSequence r7 = this.mContext.getText(R.string.common_phone);
        if (r3 != 0) goto L38;
        boolean r11 = true;
    L39:
        bindData(r7, r5, r6, r11);
        r3 = r3 + 1;
        goto L30
    L38:
        r11 = false;
        goto L39
    L34:
        r6 = null;
    L40:
        ArrayList<EntityDelta.ValuesDelta> r113 = r12.getMimeEntries("vnd.android.cursor.item/email_v2");
        if (r113 == null) goto L55;
        int r114 = 0;
    L44:
        if (r114 >= r113.size()) goto L55;
        EntityDelta.ValuesDelta r8 = r113.get(r114);
        String r9 = r8.getAsString("data1");
        if (r8.containsKey(DBHelper.COL_DATA2) == false) goto L48;
        CharSequence r20 = ContactsContract.CommonDataKinds.Email.getTypeLabel(r111, r8.getAsInteger(DBHelper.COL_DATA2).intValue(), r8.getAsString(DBHelper.COL_DATA3));
    L49:
        CharSequence r21 = this.mContext.getText(R.string.email);
        if (r114 != 0) goto L52;
        boolean r22 = true;
    L53:
        bindData(r21, r9, r20, r22);
        r114 = r114 + 1;
        goto L44
    L52:
        r22 = false;
        goto L53
    L48:
        r20 = null;
    L55:
        if (this.mGeneral.getChildCount() <= 0) goto L57;
        this.mGeneral.setVisibility(0);
        return;
    L57:
        this.mGeneral.setVisibility(8);
        return;
    L25:
        r110 = 0;
        goto L26
    L21:
        r19 = this.mContext.getString(R.string.missing_name);
        goto L22
    L15:
        r1 = 8;
        goto L16
    L11:
        r10 = false;
        goto L12
    L17:
        this.mPhotoStub.setVisibility(0);
        goto L18
    L67:
        return;
    }

    private void bindData(CharSequence r5, CharSequence r6, CharSequence r7, boolean r8) {
        View r0 = this.mInflater.inflate(R.layout.item_read_only_field, this.mGeneral, false);
        if (r8 == false) goto L5;
        View r9 = r0.findViewById(R.id.horizontal_divider);
        TextView r1 = (TextView) r0.findViewById(R.id.kind_title);
        r9.setVisibility(0);
        r1.setVisibility(0);
        r1.setText(r5);
    L5:
        ((TextView) r0.findViewById(R.id.data)).setText(r6);
        TextView r10 = (TextView) r0.findViewById(R.id.type);
        if (TextUtils.isEmpty(r7) == true) goto L8;
        r10.setText(r7);
    L9:
        this.mGeneral.addView(r0);
        return;
    L8:
        r10.setVisibility(8);
        goto L9
    }

    @Override // com.android.contacts.editor.BaseRawContactEditorView
    public long getRawContactId() {
        return this.mRawContactId;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        if (r5.getId() != R.id.button_edit_externally) goto L8;
        Listener r6 = this.mListener;
        if (r6 == null) goto L9;
        r6.onExternalEditorRequest(new AccountWithDataSet(this.mAccountName, this.mAccountType, this.mDataSet), ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, this.mRawContactId));
        return;
    L9:
        return;
    }
}
