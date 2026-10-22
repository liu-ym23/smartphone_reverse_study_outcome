package com.android.contacts.editor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import bytedanceos.util.NameAvatarController;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.model.DataKind;
import com.android.contacts.model.EntityDelta;
import com.android.contacts.util.BytedanceContactContract;
import com.android.contacts.util.ContactPhotoUtils;
import com.android.contacts.widget.AvatarImageView;
import com.obric.oui.layout.OUIFrameLayout;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class PhotoEditorView extends FrameLayout implements Editor {
    private static final String TAG = "PhotoEditorView";
    private Context mContext;
    private EntityDelta.ValuesDelta mEntry;
    private OUIFrameLayout mFrameView;
    private boolean mHasSetPhoto;
    public Editor.EditorListener mListener;
    public AvatarImageView mPhotoImageView;
    private boolean mReadOnly;

    @Override // com.android.contacts.editor.Editor
    public void changeEditorBackground() {
    }

    @Override // com.android.contacts.editor.Editor
    public void deleteEditor() {
    }

    @Override // com.android.contacts.editor.Editor
    public void deleteEditor(ViewGroup r1) {
    }

    @Override // com.android.contacts.editor.Editor
    public void setDeletable(boolean r1) {
    }

    public PhotoEditorView(Context r2) {
        super(r2);
        this.mHasSetPhoto = false;
        this.mContext = r2;
    }

    public PhotoEditorView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mHasSetPhoto = false;
        this.mContext = r1;
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        this.mFrameView.setEnabled(r1);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mPhotoImageView = (AvatarImageView) findViewById(R.id.photo);
        OUIFrameLayout r0 = (OUIFrameLayout) findViewById(R.id.frame);
        this.mFrameView = r0;
        r0.setOnClickListener(new AnonymousClass1(this));
    }

    @Override // com.android.contacts.editor.Editor
    public void onFieldChanged(String r1, String r2) {
        throw new UnsupportedOperationException("Photos don't support direct field changes");
    }

    @Override // com.android.contacts.editor.Editor
    public void setValues(DataKind r2, EntityDelta.ValuesDelta r3, EntityDelta r4, boolean r5, ViewIdGenerator r6) {
        this.mEntry = r3;
        this.mReadOnly = r5;
        setId(r6.getId(r4, r2, r3, 0));
        if (r3 == null) goto L31;
        String r7 = r3.getAsString("data14");
        if (TextUtils.isEmpty(r7) == true) goto L22;
        byte[] r8 = null;
        InputStream r9 = this.mContext.getContentResolver().openInputStream(Uri.withAppendedPath(ContactsContract.DisplayPhoto.CONTENT_URI, String.valueOf(r7)));     // Catch: Exception -> L14
        if (r9 != null) goto L34;
    L16:
        if (r8 == null) goto L21;
        Bitmap r10 = BitmapFactory.decodeByteArray(r8, 0, r8.length);
        if (r10 == null) goto L20;
        this.mPhotoImageView.setStrokeEnabled(true);
        this.mPhotoImageView.setImageBitmap(NameAvatarController.getCircleBitmap(r10, false));
        this.mFrameView.setEnabled(isEnabled());
        this.mHasSetPhoto = true;
        this.mEntry.setFromTemplate(false);
        return;
    L20:
        resetDefault();
        return;
    L21:
        resetDefault();
        return;
    L34:
        r8 = ContactsUtils.InputStreamToByte(r9);     // Catch: Throwable -> L11
        r9.close();     // Catch: Exception -> L14
        goto L16
    L11:
        th = move-exception;
        r9.close();     // Catch: Exception -> L14
        throw th;     // Catch: Exception -> L14
    L14:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "setValues failure:" + e);
        goto L16
    L22:
        byte[] r11 = r3.getAsByteArray(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG);
        if (r11 != null) goto L25;
    L30:
        resetDefault();
        return;
    L25:
        if (r11.length == 0) goto L30;
        Bitmap r12 = BitmapFactory.decodeByteArray(r11, 0, r11.length);
        if (r12 == null) goto L29;
        this.mPhotoImageView.setStrokeEnabled(true);
        this.mPhotoImageView.setImageBitmap(NameAvatarController.getCircleBitmap(r12));
        this.mFrameView.setEnabled(isEnabled());
        this.mHasSetPhoto = true;
        this.mEntry.setFromTemplate(false);
        return;
    L29:
        resetDefault();
        return;
    L31:
        resetDefault();
    }

    public boolean hasSetPhoto() {
        return this.mHasSetPhoto;
    }

    public void setPhotoBitmap(Bitmap r5, boolean r6) {
        if (r5 != null) goto L10;
        byte[] r2 = (byte[]) null;
        this.mEntry.put(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, null);
        if (r6 == false) goto L7;
        this.mEntry.updateRefValuesDelta(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, null);
    L7:
        resetDefault();
        return;
    L10:
        if (r5.getHeight() >= 144) goto L12;
        r5 = getPhotoBitmapScale(r5);
    L12:
        if (r6 == false) goto L14;
        int r1 = 162;
    L15:
        byte[] r3 = ContactPhotoUtils.compressBitmap(Bitmap.createScaledBitmap(r5, r1, r1, false));
        if (r3 == null) goto L20;
        this.mEntry.setPhoto(r3);
        if (r6 == false) goto L20;
        this.mEntry.updateRefValuesDelta(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, r3);
    L20:
        this.mPhotoImageView.setStrokeEnabled(true);
        this.mPhotoImageView.setImageBitmap(NameAvatarController.getCircleBitmap(r5));
        this.mFrameView.setEnabled(isEnabled());
        this.mHasSetPhoto = true;
        this.mEntry.setFromTemplate(false);
        if (r6 == false) goto L23;
        this.mEntry.setRefFromTemplate(false);
    L23:
        this.mEntry.put("is_super_primary", 1);
        return;
    L14:
        r1 = ContactsUtils.getThumbnailSize(getContext());
        goto L15
    }

    public Bitmap getPhotoBitmapScale(Bitmap r8) {
        Matrix r5 = new Matrix();
        r5.postScale(144.0f / r8.getWidth(), 144.0f / r8.getHeight());
        return Bitmap.createBitmap(r8, 0, 0, r8.getWidth(), r8.getHeight(), r5, true);
    }

    public void setSuperPrimary(boolean r2) {
        this.mEntry.put("is_super_primary", r2 ? 1 : 0);
    }

    protected void resetDefault() {
        this.mPhotoImageView.setStrokeEnabled(false);
        this.mPhotoImageView.setImageResource(R.drawable.photo_default_in_detail);
        OUIFrameLayout r0 = this.mFrameView;
        if (this.mReadOnly == false) goto L5;
    L7:
        boolean r2 = false;
    L8:
        r0.setEnabled(r2);
        this.mHasSetPhoto = false;
        this.mEntry.setFromTemplate(true);
        return;
    L5:
        if (isEnabled() == false) goto L7;
        r2 = true;
        goto L8
    }

    @Override // com.android.contacts.editor.Editor
    public void setEditorListener(Editor.EditorListener r1) {
        this.mListener = r1;
    }

    @Override // com.android.contacts.editor.Editor
    public boolean isEmpty() {
        return !this.mHasSetPhoto;
    }

    @Override // com.android.contacts.editor.Editor
    public void clearAllFields() {
        resetDefault();
    }
}
