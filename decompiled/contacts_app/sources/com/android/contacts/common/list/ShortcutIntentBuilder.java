package com.android.contacts.common.list;

import android.accounts.Account;
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
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.android.contacts.common.ContactPhotoManager;
import com.android.contacts.common.R;
import com.android.contacts.util.BytedanceContactContract;
import com.android.contacts.util.Constants;
import com.bytedance.framwork.core.sdklib.DBHelper;

/* JADX INFO: loaded from: classes.dex */
public class ShortcutIntentBuilder {
    private static final int CONTACT_ACCOUNT_NAME_COLUMN_INDEX = 4;
    private static final int CONTACT_ACCOUNT_TYPE_COLUMN_INDEX = 3;
    private static final String[] CONTACT_COLUMNS = null;
    private static final int CONTACT_DISPLAY_NAME_COLUMN_INDEX = 0;
    private static final int CONTACT_LOOKUP_KEY_COLUMN_INDEX = 2;
    private static final int CONTACT_PHOTO_ID_COLUMN_INDEX = 1;
    public static final String INTENT_EXTRA_IGNORE_LAUNCH_ANIMATION = "com.android.launcher.intent.extra.shortcut.INGORE_LAUNCH_ANIMATION";
    private static final int PHONE_ACCOUNT_NAME_COLUMN_INDEX = 7;
    private static final int PHONE_ACCOUNT_TYPE_COLUMN_INDEX = 6;
    private static final String[] PHONE_COLUMNS = null;
    private static final int PHONE_DISPLAY_NAME_COLUMN_INDEX = 0;
    private static final int PHONE_LABEL_COLUMN_INDEX = 4;
    private static final int PHONE_LOOKUP_KEY_COLUMN_INDEX = 5;
    private static final int PHONE_NUMBER_COLUMN_INDEX = 2;
    private static final int PHONE_PHOTO_ID_COLUMN_INDEX = 1;
    private static final int PHONE_TYPE_COLUMN_INDEX = 3;
    private static final String[] PHOTO_COLUMNS = null;
    private static final int PHOTO_PHOTO_COLUMN_INDEX = 0;
    private static final String PHOTO_SELECTION = "_id=?";
    private final Context mContext;
    private final int mIconDensity;
    private int mIconSize;
    private final OnShortcutIntentCreatedListener mListener;
    private final int mOverlayTextBackgroundColor;
    private final Resources mResources;

    private final class ContactLoadingAsyncTask extends LoadingAsyncTask {
        private Account mAccount;
        final /* synthetic */ ShortcutIntentBuilder this$0;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
            onPostExecute2(r1);
        }

        public ContactLoadingAsyncTask(ShortcutIntentBuilder r1, Uri r2) {
            this.this$0 = r1;
            super(r1, r2);
        }

        @Override // com.android.contacts.common.list.ShortcutIntentBuilder.LoadingAsyncTask
        protected void loadData() {
            Cursor r0 = ShortcutIntentBuilder.access$000(this.this$0).getContentResolver().query(this.mUri, ShortcutIntentBuilder.access$200(), null, null, null);
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
            String r1 = r0.getString(3);     // Catch: Throwable -> L8
            this.mAccount = new Account(r0.getString(4), r1);     // Catch: Throwable -> L8
            this.mLookupKey = r0.getString(2);     // Catch: Throwable -> L8
        L7:
            r0.close();
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Void r8) {
            ShortcutIntentBuilder.access$300(this.this$0, this.mUri, this.mContentType, this.mDisplayName, this.mAccount, this.mLookupKey, this.mBitmapData);
        }
    }

    private abstract class LoadingAsyncTask extends AsyncTask<Void, Void, Void> {
        protected byte[] mBitmapData;
        protected String mContentType;
        protected String mDisplayName;
        protected String mLookupKey;
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
        protected Void doInBackground2(Void... r2) {
            this.mContentType = ShortcutIntentBuilder.access$000(this.this$0).getContentResolver().getType(this.mUri);
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
        private Account mAccount;
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

        @Override // com.android.contacts.common.list.ShortcutIntentBuilder.LoadingAsyncTask
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
            String r1 = r0.getString(6);     // Catch: Throwable -> L8
            this.mAccount = new Account(r0.getString(7), r1);     // Catch: Throwable -> L8
            this.mLookupKey = r0.getString(5);     // Catch: Throwable -> L8
        L7:
            r0.close();
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Void r11) {
            ShortcutIntentBuilder.access$500(this.this$0, this.mUri, this.mDisplayName, this.mLookupKey, this.mBitmapData, this.mPhoneNumber, this.mPhoneType, this.mPhoneLabel, this.mAccount, this.mShortcutAction);
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

    static /* synthetic */ void access$300(ShortcutIntentBuilder r0, Uri r1, String r2, String r3, Account r4, String r5, byte[] r6) {
        r0.createContactShortcutIntent(r1, r2, r3, r4, r5, r6);
    }

    static /* synthetic */ String[] access$400() {
        return PHONE_COLUMNS;
    }

    static /* synthetic */ void access$500(ShortcutIntentBuilder r0, Uri r1, String r2, String r3, byte[] r4, String r5, int r6, String r7, Account r8, String r9) {
        r0.createPhoneNumberShortcutIntent(r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    static {
        CONTACT_COLUMNS = new String[]{"display_name", "photo_id", "lookup", "account_type", "account_name"};
        PHONE_COLUMNS = new String[]{"display_name", "photo_id", "data1", DBHelper.COL_DATA2, DBHelper.COL_DATA3, "lookup", "account_type", "account_name"};
        PHOTO_COLUMNS = new String[]{BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG};
    }

    public ShortcutIntentBuilder(Context r2, OnShortcutIntentCreatedListener r3) {
        this.mContext = r2;
        this.mListener = r3;
        Resources r4 = r2.getResources();
        this.mResources = r4;
        ActivityManager r5 = (ActivityManager) r2.getSystemService("activity");
        int r0 = r4.getDimensionPixelSize(R.dimen.shortcut_icon_size);
        this.mIconSize = r0;
        if (r0 != 0) goto L5;
        this.mIconSize = r5.getLauncherLargeIconSize();
    L5:
        this.mIconDensity = r5.getLauncherLargeIconDensity();
        this.mOverlayTextBackgroundColor = r4.getColor(R.color.shortcut_overlay_text_background);
    }

    public void createContactShortcutIntent(Uri r2) {
        new ContactLoadingAsyncTask(this, r2).execute(new Void[0]);
    }

    public void createPhoneNumberShortcutIntent(Uri r2, String r3) {
        new PhoneNumberLoadingAsyncTask(this, r2, r3).execute(new Void[0]);
    }

    private Drawable getPhotoDrawable(byte[] r3, String r4, String r5, Account r6) {
        if (r3 == null) goto L6;
        Bitmap r7 = BitmapFactory.decodeByteArray(r3, 0, r3.length, null);
        return new BitmapDrawable(this.mContext.getResources(), r7);
    L6:
        Context r2 = this.mContext;
        return ContactPhotoManager.getDefaultAvatarDrawableForContact(r2, r2.getResources(), false, new ContactPhotoManager.DefaultImageRequest(r4, r5, false), r6);
    }

    private void createContactShortcutIntent(Uri r2, String r3, String r4, Account r5, String r6, byte[] r7) {
        Drawable r8 = getPhotoDrawable(r7, r4, r6, r5);
        Intent r9 = new Intent("android.provider.action.QUICK_CONTACT");
        r9.addFlags(268533760);
        r9.putExtra(INTENT_EXTRA_IGNORE_LAUNCH_ANIMATION, true);
        r9.setDataAndType(r2, r3);
        String[] r10 = (String[]) null;
        r9.putExtra("android.provider.extra.EXCLUDE_MIMES", null);
        Bitmap r11 = generateQuickContactIcon(r8);
        Intent r12 = new Intent();
        r12.putExtra("android.intent.extra.shortcut.ICON", r11);
        r12.putExtra("android.intent.extra.shortcut.INTENT", r9);
        if (TextUtils.isEmpty(r4) == false) goto L5;
        r12.putExtra("android.intent.extra.shortcut.NAME", this.mContext.getResources().getString(R.string.missing_name));
    L6:
        this.mListener.onShortcutIntentCreated(r2, r12);
        return;
    L5:
        r12.putExtra("android.intent.extra.shortcut.NAME", r4);
        goto L6
    }

    private void createPhoneNumberShortcutIntent(Uri r2, String r3, String r4, byte[] r5, String r6, int r7, String r8, Account r9, String r10) {
        Drawable r11 = getPhotoDrawable(r5, r3, r4, r9);
        if ("android.intent.action.CALL".equals(r10) == false) goto L5;
        Uri r12 = Uri.fromParts(Constants.SCHEME_TEL, r6, null);
        Bitmap r13 = generatePhoneNumberIcon(r11, r7, r8, R.drawable.ic_call);
    L6:
        Intent r14 = new Intent(r10, r12);
        r14.setFlags(67108864);
        Intent r15 = new Intent();
        r15.putExtra("android.intent.extra.shortcut.ICON", r13);
        r15.putExtra("android.intent.extra.shortcut.INTENT", r14);
        if (TextUtils.isEmpty(r3) == false) goto L10;
        r3 = this.mContext.getResources().getString(R.string.missing_name);
    L10:
        if (TextUtils.equals(r10, "android.intent.action.CALL") == false) goto L13;
        r15.putExtra("android.intent.extra.shortcut.NAME", this.mContext.getResources().getString(R.string.call_by_shortcut, new Object[]{r3}));
    L15:
        this.mListener.onShortcutIntentCreated(r2, r15);
        return;
    L13:
        if (TextUtils.equals(r10, "android.intent.action.SENDTO") == false) goto L15;
        r15.putExtra("android.intent.extra.shortcut.NAME", this.mContext.getResources().getString(R.string.sms_by_shortcut, new Object[]{r3}));
        goto L15
    L5:
        r12 = Uri.fromParts("smsto", r6, null);
        r13 = generatePhoneNumberIcon(r11, r7, r8, R.drawable.ic_message_24dp_mirrored);
        goto L6
    }

    private Bitmap generateQuickContactIcon(Drawable r6) {
        int r0 = this.mIconSize;
        Bitmap r1 = Bitmap.createBitmap(r0, r0, Bitmap.Config.ARGB_8888);
        Canvas r2 = new Canvas(r1);
        int r4 = this.mIconSize;
        Rect r3 = new Rect(0, 0, r4, r4);
        r6.setBounds(r3);
        r6.draw(r2);
        RoundedBitmapDrawable r7 = RoundedBitmapDrawableFactory.create(this.mResources, r1);
        r7.setAntiAlias(true);
        r7.setCornerRadius(this.mIconSize / 2);
        int r5 = this.mIconSize;
        Bitmap r8 = Bitmap.createBitmap(r5, r5, Bitmap.Config.ARGB_8888);
        r2.setBitmap(r8);
        r7.setBounds(r3);
        r7.draw(r2);
        r2.setBitmap(null);
        return r8;
    }

    private Bitmap generatePhoneNumberIcon(Drawable r17, int r18, String r19, int r20) {
        Resources r1 = this.mContext.getResources();
        float r2 = r1.getDisplayMetrics().density;
        Bitmap r3 = ((BitmapDrawable) r1.getDrawableForDensity(r20, this.mIconDensity)).getBitmap();
        Bitmap r4 = generateQuickContactIcon(r17);
        Canvas r12 = new Canvas(r4);
        Paint r13 = new Paint();
        r13.setDither(true);
        r13.setFilterBitmap(true);
        int r5 = this.mIconSize;
        Rect r14 = new Rect(0, 0, r5, r5);
        CharSequence r6 = ContactsContract.CommonDataKinds.Phone.getTypeLabel(r1, r18, r19);
        if (r6 == null) goto L5;
        TextPaint r11 = new TextPaint(257);
        r11.setTextSize(r1.getDimension(R.dimen.shortcut_overlay_text_size));
        r11.setColor(r1.getColor(R.color.textColorIconOverlay));
        r11.setShadowLayer(4.0f, 0.0f, 2.0f, r1.getColor(R.color.textColorIconOverlayShadow));
        Paint.FontMetricsInt r7 = r11.getFontMetricsInt();
        Paint r8 = new Paint();
        r8.setColor(this.mOverlayTextBackgroundColor);
        r8.setStyle(Paint.Style.FILL);
        int r9 = r1.getDimensionPixelOffset(R.dimen.shortcut_overlay_text_background_padding);
        int r10 = (r7.descent - r7.ascent) + (r9 * 2);
        int r15 = this.mIconSize;
        r14.set(0, r15 - r10, r15, r15);
        r12.drawRect(r14, r8);
        CharSequence r16 = TextUtils.ellipsize(r6, r11, this.mIconSize, TextUtils.TruncateAt.END);
        float r21 = r11.measureText(r16, 0, r16.length());
        int r110 = r16.length();
        int r0 = this.mIconSize;
        r12.drawText(r16, 0, r110, (r0 - r21) / 2.0f, (r0 - r7.descent) - r9, r11);
    L5:
        Rect r22 = new Rect(0, 0, r3.getWidth(), r3.getHeight());
        int r23 = r4.getWidth();
        r14.set(r23 - ((int) (20.0f * r2)), -1, r23, (int) (r2 * 19.0f));
        r12.drawBitmap(r3, r22, r14, r13);
        r12.setBitmap(null);
        return r4;
    }
}
