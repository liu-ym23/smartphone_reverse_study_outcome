package com.android.contacts.editor;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.model.DataKind;
import com.android.contacts.model.EntityDelta;
import com.android.contacts.model.EntityModifier;
import com.google.common.base.Ascii;
import com.obric.oui.lisitem.OCardListItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class KindSectionView extends LinearLayout implements Editor.EditorListener {
    private static final String TAG = "KindSectionView";
    private boolean isAdditem;
    private ViewGroup mEditors;
    private Editor.EditorListener mExternalEditorListener;
    private LayoutInflater mInflater;
    private DataKind mKind;
    private boolean mReadOnly;
    private int[] mResIds;
    private EntityDelta mState;
    int mTextFieldLabelExtraPaddingRight;
    int mTextFieldLabelMaxWidth;
    int mTextFieldLabelMinWidth;
    private String mTitleString;
    private ViewIdGenerator mViewIdGenerator;

    private class MyHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        private Context context;
        final /* synthetic */ KindSectionView this$0;

        public MyHierarchyChangeListener(KindSectionView r1, Context r2) {
            this.this$0 = r1;
            this.context = r2;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View r3, View r4) {
            if ((r4 instanceof LabeledEditorView) == true) goto L5;
            return;
        L5:
            LabeledEditorView r5 = (LabeledEditorView) r4;
            r5.setOnLabelChangeListener(new MyLabelChangeListener(this.this$0, this.context, r5));
            KindSectionView.access$000(this.this$0);
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View r3, View r4) {
            if ((r4 instanceof LabeledEditorView) == true) goto L5;
            return;
        L5:
            LabeledEditorView r5 = (LabeledEditorView) r4;
            r5.setOnLabelChangeListener(new MyLabelChangeListener(this.this$0, this.context, r5));
            Spinner r6 = r5.getLabel();
            if (r6 == null) goto L8;
            r6.setTag(R.id.tag_spinner_measured_width, null);
        L8:
            KindSectionView.access$000(this.this$0);
        }
    }

    private class MyLabelChangeListener implements LabeledEditorView.OnLabelChangeListener {
        private Context context;
        private LabeledEditorView editorView;
        final /* synthetic */ KindSectionView this$0;

        public MyLabelChangeListener(KindSectionView r1, Context r2, LabeledEditorView r3) {
            this.this$0 = r1;
            this.context = r2;
            this.editorView = r3;
        }

        @Override // com.android.contacts.editor.LabeledEditorView.OnLabelChangeListener
        public void onLabelChanged() {
            KindSectionView.access$000(this.this$0);
        }
    }

    static /* synthetic */ void access$000(KindSectionView r0) {
        r0.traverseLabels();
    }

    public void setExternalEditorListener(Editor.EditorListener r1) {
        this.mExternalEditorListener = r1;
    }

    private int getIconResIdByMimeType(String r2) {
        if ("#displayName".equals(r2) == false) goto L6;
        return R.drawable.textfieldseditorview_user_name_icon;
    L6:
        r2.hashCode();
        switch(r2.hashCode()) {
            case -1569536764: goto L58;
            case -1328682538: goto L54;
            case -1079210633: goto L50;
            case -601229436: goto L46;
            case -213986043: goto L42;
            case 456415478: goto L38;
            case 684173810: goto L34;
            case 689862072: goto L30;
            case 950831081: goto L26;
            case 1409846529: goto L22;
            case 1464725403: goto L18;
            case 2034973555: goto L14;
            case 2050851590: goto L10;
            default: goto L8;
        };
    L8:
        byte r1 = -1;
    L61:
        switch(r1) {
            case 0: goto L87;
            case 1: goto L85;
            case 2: goto L83;
            case 3: goto L81;
            case 4: goto L79;
            case 5: goto L77;
            case 6: goto L75;
            case 7: goto L73;
            case 8: goto L71;
            case 9: goto L69;
            case 10: goto L67;
            case 11: goto L65;
            case 12: goto L63;
            default: goto L62;
        };
    L62:
        return -1;
    L63:
        return R.drawable.textfieldseditorview_gender_icon;
    L65:
        return R.drawable.textfieldseditorview_nickname_icon;
    L67:
        return R.drawable.textfieldseditorview_group_membership_icon;
    L69:
        return R.drawable.textfieldseditorview_relation_icon;
    L71:
        return R.drawable.textfieldseditorview_im_icon;
    L73:
        return R.drawable.textfieldseditorview_organization_icon;
    L75:
        return R.drawable.textfieldseditorview_phone_icon;
    L77:
        return R.drawable.textfieldseditorview_website_icon;
    L79:
        return R.drawable.textfieldseditorview_cardid_icon;
    L81:
        return R.drawable.textfieldseditorview_address_icon;
    L83:
        return R.drawable.textfieldseditorview_note_icon;
    L85:
        return R.drawable.textfieldseditorview_birthday_icon;
    L87:
        return R.drawable.textfieldseditorview_email_icon;
    L10:
        if (r2.equals("vnd.android.cursor.item/gender") == false) goto L89;
        r1 = Ascii.FF;
        goto L61
    L89:
        r1 = -1;
        goto L61
    L14:
        if (r2.equals("vnd.android.cursor.item/nickname") == false) goto L90;
        r1 = Ascii.VT;
        goto L61
    L90:
        r1 = -1;
        goto L61
    L18:
        if (r2.equals("vnd.android.cursor.item/group_membership") == false) goto L91;
        r1 = 10;
        goto L61
    L91:
        r1 = -1;
        goto L61
    L22:
        if (r2.equals("vnd.android.cursor.item/relation") == false) goto L92;
        r1 = 9;
        goto L61
    L92:
        r1 = -1;
        goto L61
    L26:
        if (r2.equals("vnd.android.cursor.item/im") == false) goto L93;
        r1 = 8;
        goto L61
    L93:
        r1 = -1;
        goto L61
    L30:
        if (r2.equals("vnd.android.cursor.item/organization") == false) goto L94;
        r1 = 7;
        goto L61
    L94:
        r1 = -1;
        goto L61
    L34:
        if (r2.equals("vnd.android.cursor.item/phone_v2") == false) goto L95;
        r1 = 6;
        goto L61
    L95:
        r1 = -1;
        goto L61
    L38:
        if (r2.equals("vnd.android.cursor.item/website") == false) goto L96;
        r1 = 5;
        goto L61
    L96:
        r1 = -1;
        goto L61
    L42:
        if (r2.equals("vnd.android.cursor.item/card_id") == false) goto L97;
        r1 = 4;
        goto L61
    L97:
        r1 = -1;
        goto L61
    L46:
        if (r2.equals("vnd.android.cursor.item/postal-address_v2") == false) goto L98;
        r1 = 3;
        goto L61
    L98:
        r1 = -1;
        goto L61
    L50:
        if (r2.equals("vnd.android.cursor.item/note") == false) goto L99;
        r1 = 2;
        goto L61
    L99:
        r1 = -1;
        goto L61
    L54:
        if (r2.equals("vnd.android.cursor.item/contact_event") == false) goto L100;
        r1 = 1;
        goto L61
    L100:
        r1 = -1;
        goto L61
    L58:
        if (r2.equals("vnd.android.cursor.item/email_v2") == false) goto L101;
        r1 = 0;
        goto L61
    L101:
        r1 = -1;
        goto L61
    }

    public KindSectionView(Context r2) {
        this(r2, null);
    }

    public KindSectionView(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.isAdditem = false;
        this.mResIds = new int[]{R.drawable.textfieldseditorview_phone_icon, R.drawable.textfieldseditorview_email_icon, R.drawable.textfieldseditorview_cardid_icon, R.drawable.textfieldseditorview_relation_icon, R.drawable.textfieldseditorview_birthday_icon, R.drawable.textfieldseditorview_organization_icon, R.drawable.textfieldseditorview_address_icon, R.drawable.textfieldseditorview_im_icon, R.drawable.textfieldseditorview_nickname_icon, R.drawable.textfieldseditorview_note_icon, R.drawable.textfieldseditorview_website_icon, R.drawable.textfieldseditorview_user_name_icon, R.drawable.textfieldseditorview_ringtone_icon, R.drawable.textfieldseditorview_group_membership_icon};
        this.mTextFieldLabelMinWidth = r2.getResources().getDimensionPixelSize(R.dimen.text_field_label_min_width);
        this.mTextFieldLabelMaxWidth = r2.getResources().getDimensionPixelSize(R.dimen.text_field_label_max_width);
        this.mTextFieldLabelExtraPaddingRight = r2.getResources().getDimensionPixelSize(R.dimen.text_field_label_extra_padding_right);
    }

    @Override // android.view.View
    public void setEnabled(boolean r4) {
        super.setEnabled(r4);
        ViewGroup r0 = this.mEditors;
        if (r0 == null) goto L10;
        int r1 = r0.getChildCount();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L14;
        View r3 = this.mEditors.getChildAt(r2);
        if (r3 == null) goto L9;
        r3.setEnabled(r4);
    L9:
        r2 = r2 + 1;
        goto L5
    L14:
        return;
    }

    public boolean isReadOnly() {
        return this.mReadOnly;
    }

    public ViewGroup getEditprs() {
        return this.mEditors;
    }

    public void setEditorsViewLeft(int r2) {
        this.mEditors.setX(r2);
        invalidate();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        setDrawingCacheEnabled(true);
        setAlwaysDrawnWithCacheEnabled(true);
        this.mInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup r0 = (ViewGroup) findViewById(R.id.kind_editors);
        this.mEditors = r0;
        r0.setOnHierarchyChangeListener(new MyHierarchyChangeListener(this, this.mContext));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.contacts.editor.Editor.EditorListener
    public void onDeleteRequested(Editor r3) {
        if (getEditorCount() != 1) goto L5;
        r3.clearAllFields();
    L6:
        updateAddFooterVisible();
        updateSectionVisible();
        Editor.EditorListener r2 = this.mExternalEditorListener;
        if (r2 == null) goto L10;
        r2.onRequest(5);
        return;
    L10:
        return;
    L5:
        r3.deleteEditor();
        View r4 = (View) r3;
        this.mEditors.removeView(r4);
        EditorAnimator.getInstance().removeEditorView(r4, this.mEditors);
        goto L6
    }

    @Override // com.android.contacts.editor.Editor.EditorListener
    public void onRequest(int r2) {
        if (r2 != 3) goto L5;
    L6:
        updateAddFooterVisible();
    L8:
        if (r2 != 5) goto L10;
        rebuildFromState();
        updateAddFooterVisible();
    L10:
        Editor.EditorListener r1 = this.mExternalEditorListener;
        if (r1 == null) goto L14;
        r1.onRequest(r2);
        return;
    L14:
        return;
    L5:
        if (r2 != 4) goto L8;
        goto L6
    }

    public void setState(DataKind r2, EntityDelta r3, boolean r4, ViewIdGenerator r5) {
        this.mKind = r2;
        this.mState = r3;
        this.mReadOnly = r4;
        this.mViewIdGenerator = r5;
        setId(r5.getId(r3, r2, null, -1));
        if (r2.titleRes != (-1)) goto L5;
    L8:
        String r6 = "";
    L9:
        this.mTitleString = r6;
        rebuildFromState();
        if (r2.mimeType.equals("vnd.android.cursor.item/phone_v2") == false) goto L12;
    L31:
        this.isAdditem = true;
    L32:
        updateAddFooterVisible();
        updateSectionVisible();
        return;
    L12:
        if (r2.mimeType.equals("vnd.android.cursor.item/organization") == true) goto L31;
        if (r2.mimeType.equals("vnd.android.cursor.item/website") == true) goto L31;
        if (r2.mimeType.equals("vnd.android.cursor.item/email_v2") == true) goto L31;
        if (r2.mimeType.equals("vnd.android.cursor.item/card_id") == true) goto L31;
        if (r2.mimeType.equals("vnd.android.cursor.item/group_membership") == true) goto L31;
        if (r2.mimeType.equals("vnd.android.cursor.item/im") == true) goto L31;
        if (r2.mimeType.equals("vnd.android.cursor.item/postal-address_v2") == true) goto L31;
        if (r2.mimeType.equals("vnd.android.cursor.item/relation") == true) goto L31;
        if (r2.mimeType.equals("vnd.android.cursor.item/contact_event") == true) goto L31;
        if (r2.mimeType.equals("vnd.android.cursor.item/gender") == false) goto L32;
    L5:
        if (r2.titleRes == 0) goto L8;
        r6 = getResources().getString(r2.titleRes);
        goto L9
    }

    public String getTitle() {
        return this.mTitleString;
    }

    public void rebuildFromState() {
        this.mEditors.removeAllViews();
        if (this.mState.hasMimeEntries(this.mKind.mimeType) == false) goto L14;
        Iterator<EntityDelta.ValuesDelta> r0 = this.mState.getMimeEntries(this.mKind.mimeType).iterator();
    L6:
        if (r0.hasNext() == false) goto L14;
        EntityDelta.ValuesDelta r1 = r0.next();
        if (r1.isVisible() == false) goto L6;
        if (isEmptyNoop(r1) == true) goto L6;
        createEditorView(r1);
    L14:
        updateSectionVisible();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View createNoteEditorView(EntityDelta.ValuesDelta r11) {
        if (this.mEditors.getChildCount() < 10) goto L15;
        return null;
    L15:
        View r0 = this.mInflater.inflate(this.mKind.editorLayoutResourceId, this.mEditors, false);     // Catch: Exception -> L12
        r0.setEnabled(isEnabled());
        if ((r0 instanceof Editor) == false) goto L10;
        Editor r1 = (Editor) r0;
        r1.setDeletable(false);
        r1.setValues(this.mKind, r11, this.mState, this.mReadOnly, this.mViewIdGenerator);
        r1.setEditorListener(this);
    L10:
        r0.findViewById(R.id.item_label).setVisibility(8);
        int r12 = ContactsUtils.dipTopx(getContext(), 10.0d);
        ((LinearLayout.LayoutParams) ((LinearLayout) r0.findViewById(R.id.editors)).getLayoutParams()).leftMargin = 0;
        this.mEditors.setPadding(r12, 0, 0, 0);
        this.mEditors.addView(r0);
        return r0;
    L12:
        e = move-exception;
        throw new RuntimeException("Cannot allocate editor with layout resource ID " + this.mKind.editorLayoutResourceId + " for MIME type " + this.mKind.mimeType + " with error " + e.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View createEditorView(EntityDelta.ValuesDelta r9) {
        if ("vnd.android.cursor.item/phone_v2".equals(this.mKind.mimeType) == false) goto L8;
        if (this.mEditors.getChildCount() < 20) goto L31;
        return null;
    L31:
        View r0 = this.mInflater.inflate(this.mKind.editorLayoutResourceId, this.mEditors, false);     // Catch: Exception -> L28
        r0.setEnabled(isEnabled());
        if ((r0 instanceof Editor) == false) goto L15;
        Editor r1 = (Editor) r0;
        r1.setDeletable(true);
        r1.setValues(this.mKind, r9, this.mState, this.mReadOnly, this.mViewIdGenerator);
        r1.setEditorListener(this);
    L15:
        if (this.mKind.mimeType.equals("vnd.android.cursor.item/note") == false) goto L17;
    L20:
        r0.findViewById(R.id.item_label).setVisibility(8);
    L21:
        ImageView r10 = (ImageView) r0.findViewById(R.id.spinner_icon);
        if (r10 == null) goto L26;
        int r2 = getIconResIdByMimeType(this.mKind.mimeType);
        if (r2 == (-1)) goto L26;
        r10.setImageResource(r2);
    L26:
        this.mEditors.addView(r0);
        return r0;
    L17:
        if (this.mKind.mimeType.equals("vnd.android.cursor.item/nickname") == true) goto L20;
        if (this.mKind.mimeType.equals("vnd.android.cursor.item/website") == false) goto L21;
    L28:
        e = move-exception;
        throw new RuntimeException("Cannot allocate editor with layout resource ID " + this.mKind.editorLayoutResourceId + " for MIME type " + this.mKind.mimeType + " with error " + e.toString());
    L8:
        if (this.mEditors.getChildCount() < 10) goto L31;
        return null;
    }

    private boolean isEmptyNoop(EntityDelta.ValuesDelta r5) {
        if (r5.isNoop() == true) goto L5;
        return false;
    L5:
        int r0 = this.mKind.fieldList.size();
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L11;
        if (TextUtils.isEmpty(r5.getAsString(this.mKind.fieldList.get(r2).column)) == false) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    private void updateSectionVisible() {
        if (getEditorCount() == 0) goto L5;
        int r0 = 0;
    L6:
        setVisibility(r0);
        int r1 = this.mEditors.getChildCount();
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L30;
        View r3 = this.mEditors.getChildAt(r2);
        OCardListItem r4 = (OCardListItem) r3.findViewById(R.id.textfields_editor_item);
        if (r4 == null) goto L29;
        boolean r5 = true;
        if (r2 != 0) goto L17;
        if (r1 != 1) goto L15;
        r4.setCardPosition(0);
    L20:
        ImageView r6 = (ImageView) r3.findViewById(R.id.spinner_icon);
        if (r6 == null) goto L29;
        if (r2 > 0) goto L25;
        r5 = false;
    L25:
        if (r5 == false) goto L27;
        int r7 = 4;
    L28:
        r6.setVisibility(r7);
        goto L29
    L27:
        r7 = 0;
        goto L28
    L15:
        r4.setCardPosition(1);
        goto L20
    L17:
        if (r2 != (r1 - 1)) goto L19;
        r4.setCardPosition(3);
        goto L20
    L19:
        r4.setCardPosition(2);
    L29:
        r2 = r2 + 1;
        goto L7
    L30:
        return;
    L5:
        r0 = 8;
        goto L6
    }

    protected void updateAddFooterVisible() {
        if (this.mReadOnly == false) goto L5;
        return;
    L5:
        if (this.mKind.typeOverallMax == 1) goto L18;
        updateEmptyEditors();
        if (hasEditor() == true) goto L9;
        return;
    L9:
        if (hasEmptyEditor() == false) goto L11;
        return;
    L11:
        if (EntityModifier.canInsert(this.mState, this.mKind) == true) goto L13;
        return;
    L13:
        if (this.isAdditem == false) goto L15;
        addItem();
    L15:
        this.isAdditem = true;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateEmptyEditors() {
        List<View> r0 = getEmptyEditors();
        if (r0.size() <= 1) goto L10;
        Iterator<View> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        View r2 = r1.next();
        if (r2.findFocus() != null) goto L6;
        this.mEditors.removeView(r2);
        ((Editor) r2).deleteEditor(this.mEditors);
        EditorAnimator.getInstance().removeEditorView(r2, this.mEditors);
        updateSectionVisible();
        goto L6
    L16:
        return;
    }

    private List<View> getEmptyEditors() {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= this.mEditors.getChildCount()) goto L11;
        KeyEvent.Callback r2 = this.mEditors.getChildAt(r1);
        if (r2 == null) goto L10;
        if (((Editor) r2).isEmpty() == false) goto L10;
        r0.add(r2);
    L10:
        r1 = r1 + 1;
        goto L4
    L11:
        return r0;
    }

    private boolean hasEmptyEditor() {
        if (getEmptyEditors().size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean hasEditor() {
        if (this.mEditors.getChildCount() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isEmpty() {
        int r1 = 0;
    L4:
        if (r1 >= this.mEditors.getChildCount()) goto L9;
        if (((Editor) this.mEditors.getChildAt(r1)).isEmpty() == false) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    public void addItem() {
        if (this.mKind.typeOverallMax == 1) goto L5;
    L12:
        EntityDelta.ValuesDelta r0 = null;
    L13:
        if (r0 != null) goto L15;
        r0 = EntityModifier.insertChild(this.mState, this.mKind);
    L15:
        createEditorView(r0);
        if (this.mKind.mimeType.equals("vnd.android.cursor.item/organization") == true) goto L18;
        EditorAnimator.getInstance().updateChildsBackground(this.mEditors);
    L18:
        updateSectionVisible();
        return;
    L5:
        if (getEditorCount() != 1) goto L7;
        return;
    L7:
        ArrayList<EntityDelta.ValuesDelta> r1 = this.mState.getMimeEntries(this.mKind.mimeType);
        if (r1 == null) goto L12;
        if (r1.size() <= 0) goto L12;
        r0 = r1.get(0);
        goto L13
    }

    public int getEditorCount() {
        return this.mEditors.getChildCount();
    }

    public DataKind getKind() {
        return this.mKind;
    }

    private void traverseLabels() {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= this.mEditors.getChildCount()) goto L17;
        View r3 = this.mEditors.getChildAt(r1);
        if ((r3 instanceof LabeledEditorView) == false) goto L16;
        Spinner r4 = ((LabeledEditorView) r3).getLabel();
        if (r4 == null) goto L16;
        r0.add(r4);
        Integer r5 = (Integer) r4.getTag(R.id.tag_spinner_measured_width);
        if (r5 == null) goto L16;
        if (r5.intValue() <= r2) goto L16;
        r2 = r5.intValue();
    L16:
        r1 = r1 + 1;
        goto L4
    }
}
