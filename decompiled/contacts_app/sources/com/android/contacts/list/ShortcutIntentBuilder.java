package com.android.contacts.list;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.text.TextPaint;
import android.text.TextUtils;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.util.BytedanceContactContract;
import com.android.contacts.util.Constants;
import com.bytedance.framwork.core.sdklib.DBHelper;

/* JADX INFO: loaded from: classes2.dex */
public class ShortcutIntentBuilder {
    private static final String[] CONTACT_COLUMNS = null;
    private static final int CONTACT_DISPLAY_NAME_COLUMN_INDEX = 0;
    private static final int CONTACT_PHOTO_ID_COLUMN_INDEX = 1;
    private static final String[] PHONE_COLUMNS = null;
    private static final int PHONE_DISPLAY_NAME_COLUMN_INDEX = 0;
    private static final int PHONE_LABEL_COLUMN_INDEX = 4;
    private static final int PHONE_NUMBER_COLUMN_INDEX = 2;
    private static final int PHONE_PHOTO_ID_COLUMN_INDEX = 1;
    private static final int PHONE_TYPE_COLUMN_INDEX = 3;
    private static final String[] PHOTO_COLUMNS = null;
    private static final int PHOTO_PHOTO_COLUMN_INDEX = 0;
    private static final String PHOTO_SELECTION = "_id=?";
    private final int mBorderColor;
    private final int mBorderWidth;
    private final Context mContext;
    private final int mIconDensity;
    private int mIconSize;
    private final OnShortcutIntentCreatedListener mListener;

    private final class ContactLoadingAsyncTask extends LoadingAsyncTask {
        final /* synthetic */ ShortcutIntentBuilder this$0;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
            onPostExecute2(r1);
        }

        public ContactLoadingAsyncTask(ShortcutIntentBuilder r1, Uri r2) {
            this.this$0 = r1;
            super(r1, r2);
        }

        @Override // com.android.contacts.list.ShortcutIntentBuilder.LoadingAsyncTask
        protected void loadData() {
            if (this.mUri == null) goto L13;
            Cursor r0 = ShortcutIntentBuilder.access$000(this.this$0).getContentResolver().query(this.mUri, ShortcutIntentBuilder.access$200(), null, null, null);
            if (r0 == null) goto L16;
        L10:
            th = move-exception;
            r0.close();
            throw th;
        L7:
            if (r0.moveToFirst() == false) goto L9;
            this.mDisplayName = r0.getString(0);     // Catch: Throwable -> L10
            this.mPhotoId = r0.getLong(1);     // Catch: Throwable -> L10
        L9:
            r0.close();
            return;
        L16:
            return;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Void r3) {
            if (this.mUri == null) goto L6;
            ShortcutIntentBuilder.access$300(this.this$0, this.mUri, this.mDisplayName, this.mBitmapData);
            return;
        }
    }

    private abstract class LoadingAsyncTask extends AsyncTask<Void, Void, Void> {
        protected byte[] mBitmapData;
        protected String mDisplayName;
        protected long mPhotoId;
        protected Uri mUri;
        final /* synthetic */ ShortcutIntentBuilder this$0;

        protected abstract void loadData();

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        public LoadingAsyncTask(ShortcutIntentBuilder r1, Uri r2) {
            this.this$0 = r1;
            this.mUri = r2;
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(Void... r1) {
            loadData();
            loadPhoto();
            return null;
        }

        private void loadPhoto() {
            if (this.mPhotoId != 0) goto L5;
            return;
        L5:
            Cursor r0 = ShortcutIntentBuilder.access$000(this.this$0).getContentResolver().query(ContactsContract.Data.CONTENT_URI, ShortcutIntentBuilder.access$100(), ShortcutIntentBuilder.PHOTO_SELECTION, new String[]{String.valueOf(this.mPhotoId)}, null);
            if (r0 != null) goto L15;
            return;
        L15:
        L11:
            th = move-exception;
            r0.close();
            throw th;
        L8:
            if (r0.moveToFirst() == false) goto L10;
            this.mBitmapData = r0.getBlob(0);     // Catch: Throwable -> L11
        L10:
            r0.close();
        }
    }

    public interface OnShortcutIntentCreatedListener {
        void onShortcutIntentCreated(Uri r1, Intent r2);
    }

    private final class PhoneNumberLoadingAsyncTask extends LoadingAsyncTask {
        private String mPhoneLabel;
        private String mPhoneNumber;
        private int mPhoneType;
        private final String mShortcutAction;
        final /* synthetic */ ShortcutIntentBuilder this$0;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
            onPostExecute2(r1);
        }

        public PhoneNumberLoadingAsyncTask(ShortcutIntentBuilder r1, Uri r2, String r3) {
            this.this$0 = r1;
            super(r1, r2);
            this.mShortcutAction = r3;
        }

        @Override // com.android.contacts.list.ShortcutIntentBuilder.LoadingAsyncTask
        protected void loadData() {
            Cursor r0 = ShortcutIntentBuilder.access$000(this.this$0).getContentResolver().query(this.mUri, ShortcutIntentBuilder.access$400(), null, null, null);
            if (r0 != null) goto L12;
            return;
        L12:
        L8:
            th = move-exception;
            r0.close();
            throw th;
        L5:
            if (r0.moveToFirst() == false) goto L7;
            this.mDisplayName = r0.getString(0);     // Catch: Throwable -> L8
            this.mPhotoId = r0.getLong(1);     // Catch: Throwable -> L8
            this.mPhoneNumber = r0.getString(2);     // Catch: Throwable -> L8
            this.mPhoneType = r0.getInt(3);     // Catch: Throwable -> L8
            this.mPhoneLabel = r0.getString(4);     // Catch: Throwable -> L8
        L7:
            r0.close();
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Void r9) {
            ShortcutIntentBuilder.access$500(this.this$0, this.mUri, this.mDisplayName, this.mBitmapData, this.mPhoneNumber, this.mPhoneType, this.mPhoneLabel, this.mShortcutAction);
        }
    }

    static /* synthetic */ Context access$000(ShortcutIntentBuilder r0) {
        return r0.mContext;
    }

    static /* synthetic */ String[] access$100() {
        return PHOTO_COLUMNS;
    }

    static /* synthetic */ String[] access$200() {
        return CONTACT_COLUMNS;
    }

    static /* synthetic */ void access$300(ShortcutIntentBuilder r0, Uri r1, String r2, byte[] r3) {
        r0.createContactShortcutIntent(r1, r2, r3);
    }

    static /* synthetic */ String[] access$400() {
        return PHONE_COLUMNS;
    }

    static /* synthetic */ void access$500(ShortcutIntentBuilder r0, Uri r1, String r2, byte[] r3, String r4, int r5, String r6, String r7) {
        r0.createPhoneNumberShortcutIntent(r1, r2, r3, r4, r5, r6, r7);
    }

    static {
        CONTACT_COLUMNS = new String[]{"display_name", "photo_id"};
        PHONE_COLUMNS = new String[]{"display_name", "photo_id", "data1", DBHelper.COL_DATA2, DBHelper.COL_DATA3};
        PHOTO_COLUMNS = new String[]{BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG};
    }

    public ShortcutIntentBuilder(Context r2, OnShortcutIntentCreatedListener r3) {
        this.mContext = r2;
        this.mListener = r3;
        Resources r4 = r2.getResources();
        ActivityManager r5 = (ActivityManager) r2.getSystemService("activity");
        int r0 = r4.getDimensionPixelSize(R.dimen.shortcut_icon_size);
        this.mIconSize = r0;
        if (r0 != 0) goto L5;
        this.mIconSize = r5.getLauncherLargeIconSize();
    L5:
        this.mIconDensity = r5.getLauncherLargeIconDensity();
        this.mBorderWidth = r4.getDimensionPixelOffset(R.dimen.shortcut_icon_border_width);
        this.mBorderColor = r4.getColor(R.color.shortcut_overlay_text_background);
    }

    public void createContactShortcutIntent(Uri r2) {
        new ContactLoadingAsyncTask(this, r2).execute(new Void[0]);
    }

    public void createPhoneNumberShortcutIntent(Uri r2, String r3) {
        new PhoneNumberLoadingAsyncTask(this, r2, r3).execute(new Void[0]);
    }

    private Bitmap getPhotoBitmap(byte[] r2, String r3) {
        if (r2 == null) goto L5;
        return BitmapFactory.decodeByteArray(r2, 0, r2.length, null);
    L5:
        return ContactsUtils.creatBitmapFromName(this.mContext, r3);
    }

    private void createContactShortcutIntent(Uri r4, String r5, byte[] r6) {
        Bitmap r7 = getPhotoBitmap(r6, r5);
        Intent r0 = new Intent("android.intent.action.VIEW");
        r0.setFlags(402653184);
        r0.setData(r4);
        r0.setPackage(this.mContext.getPackageName());
        Bitmap r8 = generateQuickContactIcon(r7);
        Intent r1 = new Intent();
        r1.putExtra("android.intent.extra.shortcut.ICON", r8);
        r1.putExtra("android.intent.extra.shortcut.INTENT", r0);
        r1.putExtra("android.intent.extra.shortcut.NAME", r5);
        this.mListener.onShortcutIntentCreated(r4, r1);
    }

    private void createPhoneNumberShortcutIntent(Uri r3, String r4, byte[] r5, String r6, int r7, String r8, String r9) {
        Bitmap r10 = getPhotoBitmap(r5, null);
        if ("android.intent.action.CALL".equals(r9) == false) goto L5;
        Uri r11 = Uri.fromParts(Constants.SCHEME_TEL, r6, null);
        Bitmap r12 = generatePhoneNumberIcon(r10, r7, r8, R.drawable.badge_action_call);
    L6:
        Intent r13 = new Intent(r9, r11);
        r13.setFlags(67108864);
        Intent r14 = new Intent();
        r14.putExtra("android.intent.extra.shortcut.ICON", r12);
        r14.putExtra("android.intent.extra.shortcut.INTENT", r13);
        r14.putExtra("android.intent.extra.shortcut.NAME", r4);
        this.mListener.onShortcutIntentCreated(r3, r14);
        return;
    L5:
        r11 = Uri.fromParts("smsto", r6, null);
        r12 = generatePhoneNumberIcon(r10, r7, r8, R.drawable.badge_action_sms);
        goto L6
    }

    private void drawBorder(Canvas r3, Rect r4) {
        Paint r0 = new Paint();
        r0.setColor(this.mBorderColor);
        r0.setStyle(Paint.Style.STROKE);
        r0.setStrokeWidth(this.mBorderWidth * 2);
        r3.drawRect(r4, r0);
    }

    private Bitmap generateQuickContactIcon(Bitmap r8) {
        int r0 = this.mIconSize;
        Bitmap r1 = Bitmap.createBitmap(r0, r0, Bitmap.Config.ARGB_8888);
        Canvas r2 = new Canvas(r1);
        Paint r3 = new Paint();
        r3.setDither(true);
        r3.setFilterBitmap(true);
        Rect r4 = new Rect(0, 0, r8.getWidth(), r8.getHeight());
        int r7 = this.mIconSize;
        r2.drawBitmap(r8, r4, new Rect(0, 0, r7, r7), r3);
        r2.setBitmap(null);
        return r1;
    }

    private Bitmap generatePhoneNumberIcon(Bitmap r19, int r20, String r21, int r22) {
        Resources r1 = this.mContext.getResources();
        float r2 = r1.getDisplayMetrics().density;
        Bitmap r3 = ((BitmapDrawable) r1.getDrawableForDensity(r22, this.mIconDensity)).getBitmap();
        int r4 = this.mIconSize;
        Bitmap r5 = Bitmap.createBitmap(r4, r4, Bitmap.Config.ARGB_8888);
        Canvas r12 = new Canvas(r5);
        Paint r13 = new Paint();
        r13.setDither(true);
        r13.setFilterBitmap(true);
        Rect r14 = new Rect(0, 0, r19.getWidth(), r19.getHeight());
        int r6 = this.mIconSize;
        Rect r11 = new Rect(0, 0, r6, r6);
        r12.drawBitmap(r19, r14, r11, r13);
        drawBorder(r12, r11);
        CharSequence r7 = ContactsContract.CommonDataKinds.Phone.getTypeLabel(r1, r20, r21);
        if (r7 == null) goto L6;
        TextPaint r10 = new TextPaint(257);
        r10.setTextSize(r1.getDimension(R.dimen.shortcut_overlay_text_size));
        r10.setColor(r1.getColor(R.color.textColorIconOverlay));
        r10.setShadowLayer(4.0f, 0.0f, 2.0f, r1.getColor(R.color.textColorIconOverlayShadow));
        Paint.FontMetricsInt r8 = r10.getFontMetricsInt();
        Paint r9 = new Paint();
        r9.setColor(this.mBorderColor);
        r9.setStyle(Paint.Style.FILL);
        int r15 = r1.getDimensionPixelOffset(R.dimen.shortcut_overlay_text_background_padding);
        int r16 = (r8.descent - r8.ascent) + (r15 * 2);
        int r17 = this.mBorderWidth;
        int r18 = this.mIconSize;
        r11.set(r17 + 0, r18 - r16, r18 - r17, r18 - r17);
        r12.drawRect(r11, r9);
        CharSequence r23 = TextUtils.ellipsize(r7, r10, this.mIconSize - (this.mBorderWidth * 2.0f), TextUtils.TruncateAt.END_SMALL);
        float r24 = r10.measureText(r23, 0, r23.length());
        int r25 = r23.length();
        int r110 = this.mIconSize;
        r12.drawText(r23, 0, r25, (r110 - r24) / 2.0f, (r110 - r8.descent) - r15, r10);
    L6:
        r14.set(0, 0, r3.getWidth(), r3.getHeight());
        int r26 = r5.getWidth();
        r11.set(r26 - ((int) (20.0f * r2)), -1, r26, (int) (19.0f * r2));
        int r0 = this.mBorderWidth;
        r11.offset(-r0, r0);
        r12.drawBitmap(r3, r14, r11, r13);
        r12.setBitmap(null);
        return r5;
    }
}
