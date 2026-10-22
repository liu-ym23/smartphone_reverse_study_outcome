package com.android.contacts.editor;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.model.DataKind;
import com.android.contacts.model.EntityDelta;
import com.android.contacts.model.EntityModifier;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.obric.oui.button.OButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CardIdEditorView extends LinearLayout implements Editor.EditorListener {
    public static final int REQUEST_CODE_CREATE_CARD = 1002;
    private static final String TAG = "CardIdEditorView";
    private int BACK_CARD;
    private int ID_CARD;
    private boolean isAdditem;
    private ArrayList<Long> mCardIDsList;
    private ViewGroup mEditors;
    private boolean mEnabled;
    private LayoutInflater mInflater;
    private DataKind mKind;
    private boolean mReadOnly;
    private EntityDelta mState;
    int mTextFieldLabelExtraPaddingRight;
    int mTextFieldLabelMaxWidth;
    int mTextFieldLabelMinWidth;
    private String mTitleString;
    private ViewIdGenerator mViewIdGenerator;

    private class MyHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        private Context context;
        final /* synthetic */ CardIdEditorView this$0;

        public MyHierarchyChangeListener(CardIdEditorView r1, Context r2) {
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
            Spinner r6 = r5.getLabel();
            if (r6 == null) goto L8;
            CardIdEditorView.access$100(this.this$0, this.context, r6);
        L8:
            CardIdEditorView.access$200(this.this$0);
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
            CardIdEditorView.access$200(this.this$0);
        }
    }

    private class MyLabelChangeListener implements LabeledEditorView.OnLabelChangeListener {
        private Context context;
        private LabeledEditorView editorView;
        final /* synthetic */ CardIdEditorView this$0;

        public MyLabelChangeListener(CardIdEditorView r1, Context r2, LabeledEditorView r3) {
            this.this$0 = r1;
            this.context = r2;
            this.editorView = r3;
        }

        @Override // com.android.contacts.editor.LabeledEditorView.OnLabelChangeListener
        public void onLabelChanged() {
            CardIdEditorView.access$100(this.this$0, this.context, this.editorView.getLabel());
            CardIdEditorView.access$200(this.this$0);
        }
    }

    static /* synthetic */ ArrayList access$000(CardIdEditorView r0) {
        return r0.mCardIDsList;
    }

    static /* synthetic */ void access$100(CardIdEditorView r0, Context r1, Spinner r2) {
        r0.tagLabelMeasuredWidth(r1, r2);
    }

    static /* synthetic */ void access$200(CardIdEditorView r0) {
        r0.traverseLabels();
    }

    public void setCardIDsList(ArrayList<Long> r1) {
        this.mCardIDsList = r1;
    }

    public CardIdEditorView(Context r2) {
        this(r2, null);
    }

    public CardIdEditorView(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.isAdditem = false;
        this.ID_CARD = 1;
        this.BACK_CARD = 2;
        this.mCardIDsList = new ArrayList();
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
        if (r2 >= r1) goto L10;
        View r3 = this.mEditors.getChildAt(r2);
        if (r3 == null) goto L9;
        r3.setEnabled(r4);
    L9:
        r2 = r2 + 1;
    L10:
        this.mEnabled = r4;
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
        updateAddFooterVisibleForDelete();
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
        if (r2 != 5) goto L11;
        rebuildFromState();
        updateAddFooterVisible();
        return;
    L11:
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
    L29:
        this.isAdditem = true;
    L30:
        updateAddFooterVisible();
        updateSectionVisible();
        return;
    L12:
        if (r2.mimeType.equals("vnd.android.cursor.item/organization") == true) goto L29;
        if (r2.mimeType.equals("vnd.android.cursor.item/website") == true) goto L29;
        if (r2.mimeType.equals("vnd.android.cursor.item/email_v2") == true) goto L29;
        if (r2.mimeType.equals("vnd.android.cursor.item/group_membership") == true) goto L29;
        if (r2.mimeType.equals("vnd.android.cursor.item/im") == true) goto L29;
        if (r2.mimeType.equals("vnd.android.cursor.item/postal-address_v2") == true) goto L29;
        if (r2.mimeType.equals("vnd.android.cursor.item/relation") == true) goto L29;
        if (r2.mimeType.equals("vnd.android.cursor.item/contact_event") == true) goto L29;
        if (r2.mimeType.equals("vnd.android.cursor.item/card_id") == false) goto L30;
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
        if (this.mState.hasMimeEntries(this.mKind.mimeType) == false) goto L20;
        Iterator<EntityDelta.ValuesDelta> r0 = this.mState.getMimeEntries(this.mKind.mimeType).iterator();
    L6:
        if (r0.hasNext() == false) goto L31;
        EntityDelta.ValuesDelta r1 = r0.next();
        if (r1.isVisible() == false) goto L6;
        if (isEmptyNoop(r1) == true) goto L6;
        Long r2 = r1.getAsLong(DBHelper.COL_DATA3);
        String r3 = r1.getAsString("data1");
        if (r2 != null) goto L16;
    L17:
        if (r3 == null) goto L6;
    L19:
        createEditorView(r1);
        goto L6
    L16:
        if (r2.longValue() != (-1)) goto L19;
    L31:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View createNoteEditorView(EntityDelta.ValuesDelta r11) {
        View r0 = this.mInflater.inflate(this.mKind.editorLayoutResourceId, this.mEditors, false);     // Catch: Exception -> L8
        r0.setEnabled(isEnabled());
        if ((r0 instanceof Editor) == false) goto L6;
        Editor r1 = (Editor) r0;
        r1.setDeletable(false);
        r1.setValues(this.mKind, r11, this.mState, this.mReadOnly, this.mViewIdGenerator);
        r1.setEditorListener(this);
    L6:
        r0.findViewById(R.id.item_label).setVisibility(8);
        r0.findViewById(R.id.body);
        this.mEditors.addView(r0);
        return r0;
    L8:
        e = move-exception;
        throw new RuntimeException("Cannot allocate editor with layout resource ID " + this.mKind.editorLayoutResourceId + " for MIME type " + this.mKind.mimeType + " with error " + e.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View createEditorView(final EntityDelta.ValuesDelta r9) {
        if (this.mEditors.getChildCount() < 10) goto L15;
        return null;
    L15:
        final View r0 = this.mInflater.inflate(this.mKind.editorLayoutResourceId, this.mEditors, false);     // Catch: Exception -> L12
        r0.setEnabled(isEnabled());
        if ((r0 instanceof Editor) == false) goto L10;
        Editor r1 = (Editor) r0;
        r1.setDeletable(true);
        r1.setValues(this.mKind, r9, this.mState, this.mReadOnly, this.mViewIdGenerator);
        r1.setEditorListener(this);
    L10:
        ((OButton) r0.findViewById(R.id.delete_button)).setOnClickListener(new AnonymousClass1(this, r9, r0));
        this.mEditors.addView(r0);
        return r0;
    L12:
        e = move-exception;
        throw new RuntimeException("Cannot allocate editor with layout resource ID " + this.mKind.editorLayoutResourceId + " for MIME type " + this.mKind.mimeType + " with error " + e.toString());
    }

    private boolean isEmptyNoop(EntityDelta.ValuesDelta r8) {
        if (r8.isNoop() == true) goto L5;
        return false;
    L5:
        int r0 = this.mKind.fieldList.size();
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L17;
        if (TextUtils.isEmpty(r8.getAsString(this.mKind.fieldList.get(r2).column)) == false) goto L9;
        Long r3 = r8.getAsLong(DBHelper.COL_DATA3);
        if (r3 != null) goto L16;
        if (r3.longValue() != (-1)) goto L16;
        r2 = r2 + 1;
    L16:
        return false;
    L9:
        return false;
    L17:
        return true;
    }

    private void updateSectionVisible() {
        if (getEditorCount() == 0) goto L5;
        int r0 = 0;
    L6:
        setVisibility(r0);
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

    protected void updateAddFooterVisibleForDelete() {
        if (this.mReadOnly == false) goto L5;
        return;
    L5:
        if (this.mKind.typeOverallMax == 1) goto L18;
        updateEmptyEditors();
        if (hasEditor() == true) goto L9;
        return;
    L9:
        if (hasEmptyEditorForDelete() == false) goto L11;
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
    public void updateEmptyEditors() {
        List<View> r0 = getEmptyEditors();
        int r1 = r0.size();
        if (r0.size() <= 1) goto L12;
        Iterator<View> r2 = r0.iterator();
        int r3 = 0;
    L6:
        if (r2.hasNext() == false) goto L20;
        View r4 = r2.next();
        if ((r1 - r3) <= 1) goto L6;
        if (r4.findFocus() != null) goto L6;
        this.mEditors.removeView(r4);
        ((Editor) r4).deleteEditor(this.mEditors);
        EditorAnimator.getInstance().removeEditorView(r4, this.mEditors);
        r3 = r3 + 1;
        goto L6
    L20:
        return;
    }

    private List<View> getEmptyEditors() {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= this.mEditors.getChildCount()) goto L14;
        KeyEvent.Callback r2 = this.mEditors.getChildAt(r1);
        Long r3 = this.mState.getMimeEntries("vnd.android.cursor.item/card_id").get(r1).getAsLong(DBHelper.COL_DATA3);
        if (r2 == null) goto L13;
        if (((Editor) r2).isEmpty() == false) goto L13;
        if (r3 != null) goto L11;
    L12:
        r0.add(r2);
        goto L13
    L11:
        if (r3.longValue() == (-1)) goto L12;
    L13:
        r1 = r1 + 1;
        goto L4
    L14:
        return r0;
    }

    private boolean hasEmptyEditor() {
        if (getEmptyEditors().size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean hasEmptyEditorForDelete() {
        ArrayList r0 = new ArrayList();
        int r2 = 0;
    L4:
        if (r2 >= this.mEditors.getChildCount()) goto L21;
        KeyEvent.Callback r3 = this.mEditors.getChildAt(r2);
        ContentValues r4 = this.mState.getMimeEntries("vnd.android.cursor.item/card_id").get(r2).getAfter();
        if (r4 != null) goto L11;
        if (r3 == null) goto L19;
        if (((Editor) r3).isEmpty() == false) goto L19;
        r0.add(r3);
    L19:
        r2 = r2 + 1;
        goto L4
    L11:
        Long r5 = r4.getAsLong(DBHelper.COL_DATA3);
        if (r3 == null) goto L19;
        if (((Editor) r3).isEmpty() == false) goto L19;
        if (r5 != null) goto L17;
    L18:
        r0.add(r3);
        goto L19
    L17:
        if (r5.longValue() != (-1)) goto L19;
    L21:
        if (r0.size() <= 0) goto L32;
        return true;
    L32:
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
        if (r0 != null) goto L18;
        r0 = EntityModifier.insertChild(this.mState, this.mKind);
        if (this.mEditors.getChildCount() <= 0) goto L17;
        r0.put(DBHelper.COL_DATA2, this.BACK_CARD);
        goto L18
    L17:
        r0.put(DBHelper.COL_DATA2, this.ID_CARD);
    L18:
        createEditorView(r0);
        if (this.mKind.mimeType.equals("vnd.android.cursor.item/organization") == true) goto L21;
        EditorAnimator.getInstance().updateChildsBackground(this.mEditors);
    L21:
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
    L17:
        if (r2 > 0) goto L19;
        return;
    L19:
        if (r2 <= this.mTextFieldLabelMinWidth) goto L21;
        r2 = r2 + this.mTextFieldLabelExtraPaddingRight;
    L21:
        int r6 = this.mTextFieldLabelMaxWidth;
        if (r2 <= r6) goto L24;
        r2 = r6;
    L24:
        Iterator r7 = r0.iterator();
    L26:
        if (r7.hasNext() == false) goto L36;
        Spinner r8 = (Spinner) r7.next();
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        r9.width = r2;
        r8.setLayoutParams(r9);
        goto L26
    }

    private void tagLabelMeasuredWidth(Context r3, Spinner r4) {
        int r2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r5 = View.MeasureSpec.makeMeasureSpec(ContactsUtils.dipTopx(r3, 43.0d), 1073741824);
        if (r4 == null) goto L6;
        r4.measure(r2, r5);
        r4.setTag(R.id.tag_spinner_measured_width, Integer.valueOf(r4.getMeasuredWidth()));
        return;
    }
}
