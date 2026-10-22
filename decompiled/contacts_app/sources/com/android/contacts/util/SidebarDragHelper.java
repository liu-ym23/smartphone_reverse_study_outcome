package com.android.contacts.util;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import bytedanceos.util.NameAvatarController;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;

/* JADX INFO: loaded from: classes2.dex */
public class SidebarDragHelper {
    private static volatile SidebarDragHelper sSidebarDragHelper;
    private int mAvatarHeight;
    private int mAvatarWidth;
    private Context mContext;
    private Bitmap mDefaultAvatarBitmap;
    private Bitmap mPanelBitmap;

    private static class ContactDragPhotoFetcher extends AsyncTask<Long, Void, Bitmap> {
        private Context context;
        private CharSequence dragText;
        private View dragView;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Bitmap doInBackground(Long[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Bitmap r1) {
            onPostExecute2(r1);
        }

        public ContactDragPhotoFetcher(Context r1, View r2, CharSequence r3) {
            this.context = r1;
            this.dragView = r2;
            this.dragText = r3;
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Bitmap doInBackground2(Long... r11) {
            long r1 = r11[0].longValue();
            Bitmap r3 = null;
            if (r1 <= 0) goto L16;
            Cursor r12 = this.context.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{"photo_id", BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG}, "mimetype = \"vnd.android.cursor.item/photo\" AND _id = ?", new String[]{String.valueOf(r1)}, null);
            if (r12 == null) goto L16;
        L13:
            th = move-exception;
            r12.close();
            throw th;
        L7:
            if (r12.moveToFirst() == false) goto L12;
            byte[] r2 = r12.getBlob(1);     // Catch: Throwable -> L13
            if (r2 == null) goto L12;
            r3 = NameAvatarController.getCircleBitmap(BitmapFactory.decodeByteArray(r2, 0, r2.length, null), true);     // Catch: Throwable -> L13
        L12:
            r12.close();
        L16:
            return r3;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Bitmap r3) {
            SidebarDragHelper.getInstance(this.context).dragContact(this.dragView, this.dragText, r3);
        }
    }

    private static class ContactDragTextFetcher extends AsyncTask<Uri, Void, String> {
        private Bitmap avatar;
        private Context context;
        private View dragView;
        private boolean forceTouch;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ String doInBackground(Uri[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(String r1) {
            onPostExecute2(r1);
        }

        public ContactDragTextFetcher(Context r1, View r2, Bitmap r3, boolean r4) {
            this.context = r1;
            this.dragView = r2;
            this.avatar = r3;
            this.forceTouch = r4;
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected String doInBackground2(Uri... r8) {
            Uri r2 = r8[0];
            Cursor r7 = this.context.getContentResolver().query(r2, null, null, null, null);
            String r9 = null;
            if (r7 != null) goto L12;
        L11:
            return r9;
        L12:
        L8:
            th = move-exception;
            r7.close();
            throw th;
        L5:
            if (r7.moveToFirst() == false) goto L7;
            r9 = r7.getString(1);     // Catch: Throwable -> L8
        L7:
            r7.close();
            goto L11
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(String r3) {
            if (TextUtils.isEmpty(r3) == false) goto L6;
            return;
        L6:
            if (this.forceTouch == false) goto L8;
            SidebarDragHelper.getInstance(this.context).dragText(this.dragView, r3, true);
            return;
        L8:
            SidebarDragHelper.getInstance(this.context).dragContact(this.dragView, r3, this.avatar);
        }
    }

    public void dragText(View r1, CharSequence r2, boolean r3) {
    }

    public static SidebarDragHelper getInstance(Context r2) {
        if (sSidebarDragHelper != null) goto L18;
        monitor-enter(SidebarDragHelper.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (sSidebarDragHelper != null) goto L12;
        if (r2 != null) goto L10;
        Context r3 = ContactsApplication.getInstance();     // Catch: Throwable -> L14
    L11:
        sSidebarDragHelper = new SidebarDragHelper(r3);     // Catch: Throwable -> L14
        goto L12
    L10:
        r3 = r2.getApplicationContext();     // Catch: Throwable -> L14
    L12:
        monitor-exit(SidebarDragHelper.class);     // Catch: Throwable -> L14
    L18:
        return sSidebarDragHelper;
    }

    private SidebarDragHelper(Context r1) {
        this.mContext = r1;
        init();
    }

    private void init() {
        this.mAvatarWidth = ContactsUtils.dipTopx(this.mContext, 26.0d);
        this.mAvatarHeight = ContactsUtils.dipTopx(this.mContext, 26.0d);
    }

    public boolean isSidebarShowing(View r1) {
        SmtPcUtils.isPcMode(this.mContext);
        return false;
    }

    public void dragContact(View r2, CharSequence r3) {
        dragContact(r2, r3, getDefaultAvatarBitmap());
    }

    public void dragContact(View r1, CharSequence r2, Bitmap r3) {
        if (r3 == null) goto L4;
        NameAvatarController.getCircleBitmap(Bitmap.createScaledBitmap(r3, this.mAvatarWidth, this.mAvatarHeight, false), false);
        return;
    L4:
        getDefaultAvatarBitmap();
    }

    public void dragContact(View r2, Uri r3, Bitmap r4, boolean r5) {
        if (r3 != null) goto L4;
        return;
    L4:
        Uri r6 = Uri.withAppendedPath(r3, "dragtext");
        new ContactDragTextFetcher(this.mContext, r2, r4, r5).execute(new Uri[]{r6});
    }

    public void dragContact(View r2, CharSequence r3, long r4) {
        new ContactDragPhotoFetcher(this.mContext, r2, r3).execute(new Long[]{Long.valueOf(r4)});
    }

    private Bitmap getDefaultAvatarBitmap() {
        if (this.mDefaultAvatarBitmap != null) goto L6;
        this.mDefaultAvatarBitmap = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.sidebar_drag_default_avatar);
    L6:
        return this.mDefaultAvatarBitmap;
    }

    private Bitmap getPanelBitmap() {
        if (this.mPanelBitmap != null) goto L6;
        this.mPanelBitmap = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.sidebar_drag_panel);
    L6:
        return this.mPanelBitmap;
    }
}
