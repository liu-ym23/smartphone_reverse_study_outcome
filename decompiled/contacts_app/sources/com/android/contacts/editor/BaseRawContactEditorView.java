package com.android.contacts.editor;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.android.contacts.R;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.EntityDelta;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseRawContactEditorView extends LinearLayout {
    private View mBody;
    private View mDivider;
    private boolean mExpanded;
    private boolean mHasPhotoEditor;
    private PhotoEditorView mPhoto;

    public interface Listener {
        String getAction();

        ContactEditorFragment getContactEditorFragment();
    }

    public abstract long getRawContactId();

    public void setGroupMetaData(Cursor r1) {
    }

    public abstract void setState(EntityDelta r1, AccountType r2, ViewIdGenerator r3, boolean r4);

    protected void updateEditPhotoButtonText() {
    }

    public BaseRawContactEditorView(Context r1) {
        super(r1);
        this.mHasPhotoEditor = false;
        this.mExpanded = true;
    }

    public BaseRawContactEditorView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mHasPhotoEditor = false;
        this.mExpanded = true;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mBody = findViewById(R.id.body);
        this.mDivider = findViewById(R.id.divider);
        PhotoEditorView r0 = (PhotoEditorView) findViewById(R.id.edit_photo);
        this.mPhoto = r0;
        r0.setEnabled(isEnabled());
    }

    public void setPhotoBitmap(Bitmap r2) {
        setPhotoBitmap(r2, false);
    }

    public void setPhotoBitmap(Bitmap r2, boolean r3) {
        this.mPhoto.setPhotoBitmap(r2, r3);
        updateEditPhotoButtonText();
    }

    protected void setHasPhotoEditor(boolean r1) {
        this.mHasPhotoEditor = r1;
        PhotoEditorView r0 = this.mPhoto;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public boolean hasPhotoEditor() {
        return this.mHasPhotoEditor;
    }

    public boolean hasSetPhoto() {
        return this.mPhoto.hasSetPhoto();
    }

    public PhotoEditorView getPhotoEditor() {
        return this.mPhoto;
    }

    void setExpanded(boolean r5) {
        if ((getParent() instanceof ViewGroup) == false) goto L8;
        if (((ViewGroup) getParent()).getChildCount() != 1) goto L8;
        r5 = true;
    L8:
        if (r5 != this.mExpanded) goto L10;
        return;
    L10:
        this.mExpanded = r5;
        View r0 = this.mBody;
        int r1 = 0;
        if (r5 == false) goto L13;
        int r3 = 0;
    L14:
        r0.setVisibility(r3);
        View r4 = this.mDivider;
        if (r5 == false) goto L17;
        r1 = 8;
    L17:
        r4.setVisibility(r1);
        return;
    L13:
        r3 = 8;
        goto L14
    }
}
