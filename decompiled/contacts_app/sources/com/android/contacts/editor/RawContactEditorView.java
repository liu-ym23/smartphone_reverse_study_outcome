package com.android.contacts.editor;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.TrackOptUtils;
import com.android.contacts.interactions.ContactDeletionInteraction;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.DataKind;
import com.android.contacts.model.EntityDelta;
import com.android.contacts.model.EntityModifier;
import com.google.common.base.Objects;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.popover.v2.OPopoverHelperEx;
import com.obric.utils.ClickUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;

/* JADX INFO: loaded from: classes.dex */
public class RawContactEditorView extends BaseRawContactEditorView {
    private ContactDeletionInteraction dialog;
    private OCardListItem mAddFieldContainer;
    private boolean mAutoAddToDefaultGroup;
    private OCardListItem mBtnGroupMembership;
    private OCardListItem mBtnSetRingtone;
    public CardIdEditorView mCardIdEditorView;
    private Editor.EditorListener mExternalEditorListener;
    private ViewGroup mFields;
    private DataKind mGroupMembershipKind;
    private GroupMembershipView mGroupMembershipView;
    private Cursor mGroupMetaData;
    private LayoutInflater mInflater;
    private BaseRawContactEditorView.Listener mListener;
    private StructuredNameEditorView mName;
    private KindSectionView mNoteView;
    private OPopover mOPopover;
    private OrganizationFieldEditorView mOrganizationView;
    private long mRawContactId;
    private OCardListItem mRemoveContacatButton;
    private EntityDelta mState;

    static /* synthetic */ BaseRawContactEditorView.Listener access$000(RawContactEditorView r0) {
        return r0.mListener;
    }

    static /* synthetic */ OCardListItem access$100(RawContactEditorView r0) {
        return r0.mBtnGroupMembership;
    }

    static /* synthetic */ void access$200(RawContactEditorView r0, View r1) {
        r0.showOMenus(r1);
    }

    static /* synthetic */ long access$300(RawContactEditorView r2) {
        return r2.mRawContactId;
    }

    static /* synthetic */ void access$400(RawContactEditorView r0, String r1) {
        r0.trackDeleteOperation(r1);
    }

    static /* synthetic */ ContactDeletionInteraction access$502(RawContactEditorView r0, ContactDeletionInteraction r1) {
        r0.dialog = r1;
        return r1;
    }

    public RawContactEditorView(Context r3) {
        super(r3);
        this.mRawContactId = -1;
        this.mAutoAddToDefaultGroup = true;
        this.dialog = null;
    }

    public RawContactEditorView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mRawContactId = -1;
        this.mAutoAddToDefaultGroup = true;
        this.dialog = null;
    }

    public void setListener(BaseRawContactEditorView.Listener r1) {
        this.mListener = r1;
    }

    public void setExternalEditorListener(Editor.EditorListener r1) {
        this.mExternalEditorListener = r1;
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
        if (r2 == null) goto L13;
        int r3 = r2.getChildCount();
        int r5 = 0;
    L11:
        if (r5 >= r3) goto L13;
        this.mFields.getChildAt(r5).setEnabled(r4);
        r5 = r5 + 1;
    L13:
        GroupMembershipView r6 = this.mGroupMembershipView;
        if (r6 == null) goto L16;
        r6.setEnabled(r4);
    L16:
        this.mAddFieldContainer.setEnabled(r4);
    }

    @Override // com.android.contacts.editor.BaseRawContactEditorView, android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        StructuredNameEditorView r0 = (StructuredNameEditorView) findViewById(R.id.editors);
        this.mName = r0;
        r0.setDeletable(false);
        this.mFields = (ViewGroup) findViewById(R.id.sect_fields);
        ClickUtilsKt.setOnDebouncedClickListener(findViewById(R.id.edit_photo_btn), new AnonymousClass1(this));
        OCardListItem r1 = (OCardListItem) findViewById(R.id.ringtone_item);
        this.mBtnSetRingtone = r1;
        r1.setOnContentClickListener(new AnonymousClass2(this));
        TextView r2 = (TextView) findViewById(R.id.ringtone_label);
        boolean r3 = "zh".equals(Locale.getDefault().getLanguage());
        boolean r4 = ContactsUtils.isScaledFontApplied(getContext());
        int r5 = R.dimen.text_field_label_width_big_font;
        if (r4 == false) goto L7;
        if (r3 == true) goto L9;
        r5 = R.dimen.text_field_lable_width_git_font_foreign;
    L9:
        ViewGroup.LayoutParams r6 = r2.getLayoutParams();
        r6.width = getResources().getDimensionPixelSize(r5);
        r2.setLayoutParams(r6);
        OCardListItem r7 = (OCardListItem) findViewById(R.id.group_membership);
        this.mBtnGroupMembership = r7;
        r7.setOnContentClickListener(new AnonymousClass3(this));
        OCardListItem r8 = (OCardListItem) findViewById(R.id.add_field_container);
        this.mAddFieldContainer = r8;
        r8.setOnContentClickListener(new AnonymousClass4(this));
        OCardListItem r9 = (OCardListItem) findViewById(R.id.Button_remove_contact);
        this.mRemoveContacatButton = r9;
        r9.setOnContentClickListener(new AnonymousClass5(this));
        return;
    L7:
        if (r3 == false) goto L9;
        r5 = R.dimen.text_field_label_width;
        goto L9
    }

    public void intentsDeleteCount() {
        FragmentActivity r0 = this.mListener.getContactEditorFragment().getActivity();
        if (r0 != null) goto L6;
        return;
    L6:
        if ("android.intent.action.INSERT".equals(this.mListener.getAction()) == true) goto L13;
        Uri r1 = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, this.mListener.getContactEditorFragment().getContactId());
        long r2 = this.mRawContactId;
        if (r2 != (-115)) goto L11;
        trackDeleteOperation("dec");
        this.dialog = ContactDeletionInteraction.start(r0, r1, true);
        return;
    L11:
        if (r2 == (-1)) goto L16;
        Uri r3 = ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, this.mRawContactId);
        trackDeleteOperation("der");
        this.dialog = ContactDeletionInteraction.start(r0, r1, true, true, r3);
        return;
    L16:
        return;
    L13:
        r0.finish();
    }

    public void intentsCloseDeleteDialog() {
        ContactDeletionInteraction r0 = this.dialog;
        if (r0 == null) goto L6;
        r0.onDestroyView();
        return;
    }

    @Override // com.android.contacts.editor.BaseRawContactEditorView
    public void setState(EntityDelta r7, AccountType r8, ViewIdGenerator r9, boolean r10) {
        setState(r7, r8, null, r9, r10);
    }

    public void setState(EntityDelta r17, AccountType r18, List<AccountType> r19, ViewIdGenerator r20, boolean r21) {
        this.mState = r17;
        this.mFields.removeAllViews();
        if (r17 == null) goto L73;
        if (r18 == null) goto L74;
        setId(r20.getId(r17, null, null, -1));
        EntityModifier.ensureKindExists(r17, r18, "vnd.android.cursor.item/name");
        EntityModifier.ensureKindExists(r17, r18, "vnd.android.cursor.item/phone_v2");
        EntityModifier.ensureKindExists(r17, r18, "vnd.android.cursor.item/organization");
        this.mRawContactId = r17.getValues().getAsLong("_id").longValue();
        EntityModifier.ensureKindExists(r17, r18, "vnd.android.cursor.item/photo");
        int r12 = 0;
        if (r18.getKindForMimetype("vnd.android.cursor.item/photo") == null) goto L9;
        boolean r1 = true;
    L10:
        setHasPhotoEditor(r1);
        getPhotoEditor().setEnabled(isEnabled());
        this.mName.setEnabled(isEnabled());
        updateEditPhotoButtonText();
        this.mFields.setVisibility(0);
        this.mName.setVisibility(0);
        DataKind r2 = r18.getKindForMimetype("vnd.android.cursor.item/group_membership");
        this.mGroupMembershipKind = r2;
        if (r2 == null) goto L13;
        GroupMembershipView r3 = (GroupMembershipView) this.mInflater.inflate(R.layout.layout_card_list_item_new_contact_group_membership, null, false);
        this.mGroupMembershipView = r3;
        r3.setKind(this.mGroupMembershipKind);
        this.mGroupMembershipView.setEnabled(isEnabled());
        this.mGroupMembershipView.setExternalEditorListener(this.mExternalEditorListener);
        this.mBtnGroupMembership.setCustomStartView(this.mGroupMembershipView);
    L13:
        ArrayList<DataKind> r14 = new ArrayList();
        if (r19 == null) goto L19;
        Iterator<AccountType> r4 = r19.iterator();
    L17:
        if (r4.hasNext() == false) goto L19;
        r14.addAll(r4.next().getSortedDataKinds());
    L19:
        Iterator<DataKind> r15 = r18.getSortedDataKinds().iterator();
    L21:
        if (r15.hasNext() == false) goto L45;
        DataKind r5 = r15.next();
        if (r14.size() <= 0) goto L28;
        if (isContainDataKind(r14, r5) == false) goto L21;
    L28:
        if (r5.editable == false) goto L21;
        String r6 = r5.mimeType;
        if ("vnd.android.cursor.item/name".equals(r6) == true) goto L32;
        if ("vnd.android.cursor.item/photo".equals(r6) == true) goto L35;
        if ("vnd.android.cursor.item/group_membership".equals(r6) == true) goto L38;
        if (r5.fieldList == null) goto L21;
        KindSectionView r7 = (KindSectionView) this.mInflater.inflate(R.layout.item_kind_section, this.mFields, false);
        r7.setEnabled(isEnabled());
        r7.setState(r5, r17, false, r20);
        r7.setExternalEditorListener(this.mExternalEditorListener);
        this.mFields.addView(r7);
        goto L21
    L38:
        GroupMembershipView r8 = this.mGroupMembershipView;
        if (r8 == null) goto L21;
        r8.setState(r17);
        goto L21
    L35:
        getPhotoEditor().setValues(r5, r17.getPrimaryEntry(r6), r17, false, r20);
        goto L21
    L32:
        this.mName.setValues(r18.getKindForMimetype("#displayName"), r17.getPrimaryEntry(r6), r17, false, r20);
        goto L21
    L45:
        int r9 = getSectionViewsWithoutFields().size();
        OCardListItem r10 = this.mAddFieldContainer;
        if (r9 > 0) goto L49;
        r12 = 8;
    L49:
        r10.setVisibility(r12);
        this.mAddFieldContainer.setEnabled(isEnabled());
        return;
    L9:
        r1 = false;
        goto L10
    L74:
        return;
    }

    private boolean isContainDataKind(ArrayList<DataKind> r3, DataKind r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        Iterator<DataKind> r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L15;
        if (r5.next().mimeType.equals(r4.mimeType) == false) goto L7;
        return true;
    L15:
        return false;
    }

    public void setContactEditorFragment(ContactEditorFragment r1) {
        GroupMembershipView r0 = this.mGroupMembershipView;
        if (r0 == null) goto L6;
        r0.setContactEditorFragment(r1);
        return;
    }

    public void setGroupNameToAdd(String r1) {
        GroupMembershipView r0 = this.mGroupMembershipView;
        if (r0 == null) goto L6;
        r0.setGroupNameToAdd(r1);
        return;
    }

    @Override // com.android.contacts.editor.BaseRawContactEditorView
    public void setGroupMetaData(Cursor r1) {
        this.mGroupMetaData = r1;
        addToDefaultGroupIfNeeded();
        GroupMembershipView r2 = this.mGroupMembershipView;
        if (r2 == null) goto L6;
        r2.setGroupMetaData(this.mGroupMetaData);
        return;
    }

    public void setAutoAddToDefaultGroup(boolean r1) {
        this.mAutoAddToDefaultGroup = r1;
    }

    private void addToDefaultGroupIfNeeded() {
        if (this.mAutoAddToDefaultGroup == false) goto L33;
        Cursor r0 = this.mGroupMetaData;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isClosed() == true) goto L35;
        EntityDelta r1 = this.mState;
        if (r1 == null) goto L38;
        ArrayList<EntityDelta.ValuesDelta> r2 = r1.getMimeEntries("vnd.android.cursor.item/group_membership");
        if (r2 == null) goto L21;
        Iterator<EntityDelta.ValuesDelta> r3 = r2.iterator();
    L15:
        if (r3.hasNext() == false) goto L21;
        Long r4 = r3.next().getAsLong("data1");
        if (r4 == null) goto L15;
        if (r4.longValue() == 0) goto L15;
        boolean r5 = true;
    L22:
        if (r5 == true) goto L36;
        long r6 = getDefaultGroupId();
        if (r6 == (-1)) goto L37;
        EntityModifier.insertChild(this.mState, this.mGroupMembershipKind).put("data1", r6);
        return;
    L37:
        return;
    L36:
        return;
    L21:
        r5 = false;
        goto L22
    L38:
        return;
    L35:
        return;
    }

    private long getDefaultGroupId() {
        String r0 = this.mState.getValues().getAsString("account_type");
        String r1 = this.mState.getValues().getAsString("account_name");
        String r2 = this.mState.getValues().getAsString("data_set");
        this.mGroupMetaData.moveToPosition(-1);
    L4:
        if (this.mGroupMetaData.moveToNext() == false) goto L16;
        String r3 = this.mGroupMetaData.getString(0);
        String r4 = this.mGroupMetaData.getString(1);
        String r5 = this.mGroupMetaData.getString(2);
        if (r3.equals(r1) == false) goto L4;
        if (r4.equals(r0) == false) goto L4;
        if (Objects.equal(r5, r2) == false) goto L4;
        long r6 = this.mGroupMetaData.getLong(3);
        if (this.mGroupMetaData.isNull(5) == true) goto L4;
        if (this.mGroupMetaData.getInt(5) == 0) goto L4;
        return r6;
    L16:
        return -1;
    }

    public TextFieldsEditorView getNameEditor() {
        return this.mName;
    }

    public TextView getRingtoneTextView() {
        return (TextView) this.mBtnSetRingtone.getCustomStartView().findViewById(R.id.btn_setringtone);
    }

    @Override // com.android.contacts.editor.BaseRawContactEditorView
    public long getRawContactId() {
        return this.mRawContactId;
    }

    private void showOMenus(View r15) {
        final ArrayList<KindSectionView> r0 = getSectionViewsWithoutFields();
        OPopoverEntranceMenuView.Builder r11 = new OPopoverEntranceMenuView.Builder(getContext());
        int r13 = 0;
    L4:
        if (r13 >= r0.size()) goto L6;
        r11.addPopoverItem(0, 0, 0, r0.get(r13).getTitle(), null, null, false, null, new RawContactEditorView$$ExternalSyntheticLambda1(this, r0));
        r13 = r13 + 1;
        goto L4
    L6:
        OPopoverEntranceMenuView r1 = r11.build();
        r1.setElevation(100.0f);
        this.mOPopover = new OPopover.Builder((Activity) getContext()).setView(r1).build();
        OPopoverHelperEx.INSTANCE.showPopoverSmartly(this.mOPopover, r15, 48);
    }

    /* JADX INFO: renamed from: lambda$showOMenus$2$com-android-contacts-editor-RawContactEditorView, reason: not valid java name */
    /* synthetic */ Unit m192xfe433af1(ArrayList r4, View r5, Integer r6) {
        final KindSectionView r7 = (KindSectionView) r4.get(r6.intValue());
        if ("#phoneticName".equals(r7.getKind().mimeType) == false) goto L5;
        this.mName.setVisible(true);
    L7:
        if (r4.size() != 1) goto L9;
        this.mAddFieldContainer.setVisibility(8);
        this.mRemoveContacatButton.setCardPosition(0);
    L9:
        OPopover r3 = this.mOPopover;
        if (r3 == null) goto L13;
        r3.dismiss();
    L13:
        return Unit.INSTANCE;
    L5:
        r7.addItem();
        postDelayed(new RawContactEditorView$$ExternalSyntheticLambda0(this, r7), 100);
        goto L7
    }

    /* JADX INFO: renamed from: lambda$showOMenus$1$com-android-contacts-editor-RawContactEditorView, reason: not valid java name */
    /* synthetic */ void m191xc9994d2(KindSectionView r4) {
        View r5 = r4.getChildAt(0);
        if ((r5 instanceof LabeledEditorView) == false) goto L8;
        LabeledEditorView r6 = (LabeledEditorView) r5;
        r6.performAddFieldAction();
        final EditText r7 = r6.getFirstFocusedEditText();
        if (r7 == null) goto L9;
        r7.postDelayed(new RawContactEditorView$$ExternalSyntheticLambda2(this, r7), 100);
        return;
    L9:
        return;
    }

    /* JADX INFO: renamed from: lambda$showOMenus$0$com-android-contacts-editor-RawContactEditorView, reason: not valid java name */
    /* synthetic */ void m190x1aefeeb3(EditText r1) {
        ContactsUtils.showKeyBoard(getContext(), r1);
    }

    private ArrayList<KindSectionView> getSectionViewsWithoutFields() {
        int r0 = this.mFields.getChildCount();
        ArrayList<KindSectionView> r1 = new ArrayList(r0);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L22;
        View r3 = this.mFields.getChildAt(r2);
        if ((r3 instanceof KindSectionView) == false) goto L21;
        KindSectionView r4 = (KindSectionView) r3;
        if (r4.getEditorCount() > 0) goto L21;
        DataKind r5 = r4.getKind();
        if (r5.typeOverallMax != 1) goto L15;
        if (r4.getEditorCount() != 0) goto L21;
    L15:
        if ("#displayName".equals(r5.mimeType) == true) goto L21;
        if ("#phoneticName".equals(r5.mimeType) == true) goto L21;
        r1.add(r4);
    L21:
        r2 = r2 + 1;
        goto L3
    L22:
        return r1;
    }

    private void trackDeleteOperation(String r2) {
        ViewGroup r1 = (ViewGroup) this.mName.findViewById(R.id.editors);
        if (r1 == null) goto L11;
        View r3 = r1.getChildAt(0);
        if (r3 == null) goto L11;
        if ((r3 instanceof EditText) == false) goto L11;
        EditText r4 = (EditText) r3;
        if (r4.getText() == null) goto L11;
        String r5 = r4.getText().toString();
    L12:
        TrackOptUtils.trackDeleteOperation(r2, r5);
        return;
    L11:
        r5 = null;
        goto L12
    }

    @Override // com.android.contacts.editor.BaseRawContactEditorView
    protected void updateEditPhotoButtonText() {
        OButton r0 = (OButton) findViewById(R.id.edit_photo_btn);
        if (hasPhotoEditor() == true) goto L5;
    L7:
        r0.setText(R.string.btn_photo_add);
        return;
    L5:
        if (getPhotoEditor().hasSetPhoto() == false) goto L7;
        r0.setText(R.string.common_edit);
    }
}
