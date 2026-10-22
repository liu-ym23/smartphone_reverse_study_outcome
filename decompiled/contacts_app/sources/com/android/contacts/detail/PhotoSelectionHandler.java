package com.android.contacts.detail;

import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.android.contacts.editor.PhotoActionPopup;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.EntityDelta;
import com.android.contacts.model.EntityDeltaList;
import com.android.contacts.model.EntityModifier;
import com.android.contacts.util.Constants;
import com.android.contacts.util.ContactPhotoUtils;
import com.obric.oui.dialog.v2.action.OActionDialog;
import java.io.FileNotFoundException;
import java.util.List;
import obric.api.IntentSmt;

/* JADX INFO: loaded from: classes.dex */
public abstract class PhotoSelectionHandler implements View.OnClickListener {
    private static final int REQUEST_CODE_CAMERA_WITH_DATA = 1001;
    private static final int REQUEST_CODE_PHOTO_PICKED_WITH_DATA = 1002;
    private static final int REQUEST_CROP_PHOTO = 1003;
    private static final String TAG = "PhotoSelectionHandler";
    protected final Context mContext;
    private final Uri mCroppedPhotoUri;
    private final boolean mIsDirectoryContact;
    private final int mPhotoPickSize;
    private final View mPhotoView;
    private OActionDialog mPopup;
    private final EntityDeltaList mState;
    protected final Uri mTempPhotoUri;

    public abstract class PhotoActionListener implements PhotoActionPopup.Listener {
        final /* synthetic */ PhotoSelectionHandler this$0;

        public abstract Uri getCurrentPhotoUri();

        public abstract void onPhotoSelected(Uri r1) throws FileNotFoundException;

        public abstract void onPhotoSelectionDismissed();

        @Override // com.android.contacts.editor.PhotoActionPopup.Listener
        public void onRemovePictureChosen() {
        }

        @Override // com.android.contacts.editor.PhotoActionPopup.Listener
        public void onUseAsPrimaryChosen() {
        }

        public PhotoActionListener(PhotoSelectionHandler r1) {
            this.this$0 = r1;
        }

        @Override // com.android.contacts.editor.PhotoActionPopup.Listener
        public void onTakePhotoChosen() {
            PhotoSelectionHandler r0 = this.this$0;     // Catch: ActivityNotFoundException -> L4
            PhotoSelectionHandler.access$000(r0, r0.mTempPhotoUri);     // Catch: ActivityNotFoundException -> L4
            return;
        L4:
            Toast.makeText(this.this$0.mContext, R.string.photoPickerNotFoundText, 1).show();
        }

        @Override // com.android.contacts.editor.PhotoActionPopup.Listener
        public void onPickFromGalleryChosen() {
            PhotoSelectionHandler r0 = this.this$0;     // Catch: ActivityNotFoundException -> L4
            r0.startPickFromGalleryActivity(r0.mTempPhotoUri);     // Catch: ActivityNotFoundException -> L4
            return;
        L4:
            Toast.makeText(this.this$0.mContext, R.string.photoPickerNotFoundText, 1).show();
        }
    }

    private int getPhotoPickSize() {
        return Constants.BYTEDANCEOS_DISPLAY_PHOTO_DIM;
    }

    public abstract PhotoActionListener getListener();

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
    }

    protected abstract void startPhotoActivity(Intent r1, int r2, Uri r3);

    static /* synthetic */ void access$000(PhotoSelectionHandler r0, Uri r1) {
        r0.startTakePhotoActivity(r1);
    }

    public PhotoSelectionHandler(Context r1, View r2, boolean r3, EntityDeltaList r4) {
        this.mContext = r1;
        this.mPhotoView = r2;
        this.mTempPhotoUri = ContactPhotoUtils.generateTempImageUri(r1);
        this.mCroppedPhotoUri = ContactPhotoUtils.generateTempCroppedImageUri(r1);
        this.mIsDirectoryContact = r3;
        this.mState = r4;
        this.mPhotoPickSize = getPhotoPickSize();
    }

    public void destroy() {
        OActionDialog r0 = this.mPopup;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    public void showPhotoActionPopupWindow(int r4) {
        final PhotoActionListener r0 = getListener();
        if (r0 != null) goto L5;
        return;
    L5:
        if (getWritableEntityIndex() == (-1)) goto L14;
        OActionDialog r1 = this.mPopup;
        if (r1 != null) goto L9;
    L11:
        OActionDialog r5 = PhotoActionPopup.createMenuDialog(this.mContext, r0, r4);
        this.mPopup = r5;
        r5.setCanceledOnTouchOutside(false);
        this.mPopup.setOnDismissListener(new AnonymousClass1(this, r0));
        this.mPopup.show();
        return;
    L9:
        if (r1.isShowing() == false) goto L11;
        return;
    }

    public boolean handlePhotoActivityResult(int r5, int r6, Intent r7) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "handlePhotoActivityResult " + r5);
        PhotoActionListener r0 = getListener();
        if (r6 == (-1)) goto L5;
    L31:
        return false;
    L5:
        switch(r5) {
            case 1001: goto L15;
            case 1002: goto L15;
            case 1003: goto L7;
            default: goto L31;
        };
    L7:
        if (r7 != null) goto L9;
    L11:
        Uri r8 = this.mCroppedPhotoUri;
    L32:
        this.mContext.getContentResolver().delete(this.mTempPhotoUri, null, null);     // Catch: FileNotFoundException -> L14
        r0.onPhotoSelected(r8);     // Catch: FileNotFoundException -> L14
        return true;
    L14:
        return false;
    L9:
        if (r7.getData() == null) goto L11;
        r8 = r7.getData();
        goto L32
    L15:
        if (r7 != null) goto L17;
    L19:
        Uri r9 = r0.getCurrentPhotoUri();
        boolean r10 = true;
    L20:
        if (r10 == false) goto L23;
        if (r9 == null) goto L23;
    L28:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "before doCropPhoto: " + r9 + this.mCroppedPhotoUri);
        doCropPhoto(r9, this.mCroppedPhotoUri);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "after doCropPhoto: " + r9 + this.mCroppedPhotoUri);
        return true;
    L23:
        Uri r11 = this.mTempPhotoUri;
        if (ContactPhotoUtils.savePhotoFromUriToUri(this.mContext, r9, r11, false, false) == true) goto L27;
        return false;
    L27:
        r9 = r11;
    L30:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "Did not have read-access to uri : " + r9);
        goto L31
    L17:
        if (r7.getData() == null) goto L19;
        r9 = r7.getData();
        r10 = false;
        goto L20
    }

    private int getWritableEntityIndex() {
        if (this.mIsDirectoryContact == false) goto L7;
        return -1;
    L7:
        return this.mState.indexOfFirstWritableRawContact(this.mContext);
    }

    protected long getWritableEntityId() {
        int r0 = getWritableEntityIndex();
        if (r0 != (-1)) goto L7;
        return -1;
    L7:
        return this.mState.get(r0).getValues().getId().longValue();
    }

    public EntityDeltaList getDeltaForAttachingPhotoToContact() {
        int r0 = getWritableEntityIndex();
        if (r0 == (-1)) goto L9;
        EntityDelta r1 = this.mState.get(r0);
        ContentValues r2 = r1.getValues().getCompleteValues();
        String r3 = r2.getAsString("account_type");
        String r4 = r2.getAsString("data_set");
        EntityDelta.ValuesDelta r5 = EntityModifier.ensureKindExists(r1, AccountTypeManager.getInstance(this.mContext).getAccountType(r3, r4), "vnd.android.cursor.item/photo");
        if (r5 == null) goto L8;
        r5.setFromTemplate(false);
        r5.setSuperPrimary(true);
    L8:
        return this.mState;
    L9:
        return null;
    }

    private ResolveInfo getIntentHandler(Intent r2) {
        List<ResolveInfo> r1 = this.mContext.getPackageManager().queryIntentActivities(r2, 1114112);
        if (r1 != null) goto L5;
    L7:
        return null;
    L5:
        if (r1.size() <= 0) goto L7;
        return r1.get(0);
    }

    private void doCropPhoto(Uri r4, Uri r5) {
        Intent r6 = getCropImageIntent(r4, r5);
        ResolveInfo r0 = getIntentHandler(r6);
        if (r0 == null) goto L15;
        r6.setPackage(r0.activityInfo.packageName);
        startPhotoActivity(r6, 1003, r4);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Cannot crop image", e);
        Toast.makeText(this.mContext, R.string.photoPickerNotFoundText, 1).show();
        return;
    L15:
        getListener().onPhotoSelected(r4);     // Catch: FileNotFoundException -> L6
        return;
    L6:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Cannot save uncropped photo", e);
        Toast.makeText(this.mContext, "R.string.contactPhotoSavedErrorToast", 1).show();
    }

    private void startTakePhotoActivity(Uri r3) {
        startPhotoActivity(getTakePhotoIntent(r3), 1001, r3);
    }

    protected void startPickFromGalleryActivity(Uri r5) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "startPickFromGalleryActivity 1: " + r5);
        Intent r0 = getPhotoPickIntent(r5);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "startPickFromGalleryActivity 2: " + r5);
        startPhotoActivity(r0, 1002, r5);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "startPickFromGalleryActivity 3: " + r5);
    }

    private Intent getTakePhotoIntent(Uri r3) {
        Intent r2 = new Intent("android.media.action.IMAGE_CAPTURE", null);
        ContactPhotoUtils.addPhotoPickerExtras(r2, r3);
        return r2;
    }

    private Intent getPhotoPickIntent(Uri r4) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getPhotoPickIntent:" + r4);
        Intent r3 = new Intent("android.intent.action.PICK", null);
        r3.setType("image/*");
        r3.putExtra(IntentSmt.EXTRA_REVONE_SMT_LAUNCH_TYPE, "phone");
        ContactPhotoUtils.addPhotoPickerExtras(r3, r4);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getPhotoPickIntent intent:" + r3);
        return r3;
    }

    private Intent getCropImageIntent(Uri r5, Uri r6) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getCropImageIntent: " + r5 + r6);
        Intent r0 = new Intent("com.android.camera.action.CROP");
        r0.setDataAndType(r5, "image/*");
        ContactPhotoUtils.addPhotoPickerExtras(r0, r6);
        ContactPhotoUtils.addCropExtras(r0, this.mPhotoPickSize);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getCropImageIntent: " + r0);
        return r0;
    }
}
