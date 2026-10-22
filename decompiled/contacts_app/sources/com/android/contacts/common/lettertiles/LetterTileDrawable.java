package com.android.contacts.common.lettertiles;

import android.accounts.Account;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.contacts.common.MoreContactUtils;
import com.android.contacts.common.R;
import junit.framework.Assert;

/* JADX INFO: loaded from: classes.dex */
public class LetterTileDrawable extends Drawable {
    private static Bitmap DEFAULT_BUSINESS_AVATAR = null;
    private static Bitmap[] DEFAULT_CUSTOMIZE_SIM_PERSON_AVATAR = null;
    private static Bitmap DEFAULT_PERSON_AVATAR = null;
    private static Bitmap DEFAULT_SIM_PERSON_AVATAR = null;
    private static Bitmap DEFAULT_VOICEMAIL_AVATAR = null;
    public static final int TYPE_BUSINESS = 2;
    public static final int TYPE_DEFAULT = 1;
    public static final int TYPE_PERSON = 1;
    public static final int TYPE_VOICEMAIL = 3;
    private static TypedArray sColors;
    private static int sDefaultColor;
    private static final char[] sFirstChar = null;
    private static float sLetterToTileRatio;
    private static final Paint sPaint = null;
    private static final Rect sRect = null;
    private static int sTileFontColor;
    private final String TAG;
    private Account mAccount;
    private int mColor;
    private int mContactType;
    private Context mContext;
    private boolean mIsCircle;
    private Character mLetter;
    private float mOffset;
    private final Paint mPaint;
    private float mScale;

    private static boolean isEnglishLetter(char r1) {
        if ('A' > r1) goto L7;
        if (r1 > 'Z') goto L7;
    L10:
        return true;
    L7:
        if ('a' <= r1) goto L9;
    L11:
        return false;
    L9:
        if (r1 > 'z') goto L11;
        goto L10
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    static {
        DEFAULT_CUSTOMIZE_SIM_PERSON_AVATAR = new Bitmap[MoreContactUtils.IC_SIM_PICTURE.length];
        sPaint = new Paint();
        sRect = new Rect();
        sFirstChar = new char[1];
    }

    public LetterTileDrawable(Resources r2) {
        this(r2, null, null);
    }

    public LetterTileDrawable(Resources r6, Context r7, Account r8) {
        this.TAG = "LetterTileDrawable";
        this.mContactType = 1;
        this.mScale = 1.0f;
        this.mOffset = 0.0f;
        this.mIsCircle = false;
        this.mLetter = null;
        if (sColors != null) goto L9;
        sColors = r6.obtainTypedArray(R.array.letter_tile_colors);
        sDefaultColor = r6.getColor(R.color.letter_tile_default_color);
        sTileFontColor = r6.getColor(R.color.letter_tile_font_color);
        sLetterToTileRatio = r6.getFraction(R.dimen.letter_to_tile_ratio, 1, 1);
        DEFAULT_PERSON_AVATAR = BitmapFactory.decodeResource(r6, R.drawable.ic_person_white_120dp);
        DEFAULT_BUSINESS_AVATAR = BitmapFactory.decodeResource(r6, R.drawable.ic_business_white_120dp);
        DEFAULT_VOICEMAIL_AVATAR = BitmapFactory.decodeResource(r6, R.drawable.ic_voicemail_avatar);
        DEFAULT_SIM_PERSON_AVATAR = BitmapFactory.decodeResource(r6, R.drawable.ic_contact_picture_sim);
        int r2 = 0;
    L6:
        if (r2 >= MoreContactUtils.IC_SIM_PICTURE.length) goto L8;
        DEFAULT_CUSTOMIZE_SIM_PERSON_AVATAR[r2] = BitmapFactory.decodeResource(r6, MoreContactUtils.IC_SIM_PICTURE[r2]);
        r2 = r2 + 1;
        goto L6
    L8:
        Paint r3 = sPaint;
        r3.setTypeface(Typeface.create(r6.getString(R.string.letter_tile_letter_font_family), 0));
        r3.setTextAlign(Paint.Align.CENTER);
        r3.setAntiAlias(true);
    L9:
        Paint r9 = new Paint();
        this.mPaint = r9;
        r9.setFilterBitmap(true);
        r9.setDither(true);
        this.mColor = sDefaultColor;
        this.mAccount = r8;
        this.mContext = r7;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r3) {
        Rect r0 = getBounds();
        if (isVisible() == true) goto L5;
        return;
    L5:
        if (r0.isEmpty() == true) goto L10;
        drawLetterTile(r3);
        return;
    }

    private void drawBitmap(Bitmap r8, int r9, int r10, Canvas r11) {
        Rect r0 = copyBounds();
        int r1 = (int) ((this.mScale * Math.min(r0.width(), r0.height())) / 2.0f);
        r0.set(r0.centerX() - r1, (int) ((r0.centerY() - r1) + (this.mOffset * r0.height())), r0.centerX() + r1, (int) ((r0.centerY() + r1) + (this.mOffset * r0.height())));
        Rect r2 = sRect;
        r2.set(0, 0, r9, r10);
        r11.drawBitmap(r8, r2, r0, this.mPaint);
    }

    private void drawLetterTile(Canvas r9) {
        Paint r6 = sPaint;
        r6.setColor(this.mColor);
        r6.setAlpha(this.mPaint.getAlpha());
        Rect r0 = getBounds();
        int r1 = Math.min(r0.width(), r0.height());
        if (this.mIsCircle == false) goto L5;
        r9.drawCircle(r0.centerX(), r0.centerY(), r1 / 2, r6);
    L7:
        if (this.mLetter == null) goto L14;
        Account r2 = this.mAccount;
        if (r2 == null) goto L13;
        if (r2 == null) goto L14;
        if (r2.type.equals("com.android.sim") == true) goto L14;
    L13:
        char[] r3 = sFirstChar;
        r3[0] = this.mLetter.charValue();
        r6.setTextSize((this.mScale * sLetterToTileRatio) * r1);
        Rect r4 = sRect;
        r6.getTextBounds(r3, 0, 1, r4);
        r6.setColor(sTileFontColor);
        r9.drawText(r3, 0, 1, r0.centerX(), (r0.centerY() + (this.mOffset * r0.height())) - r4.exactCenterY(), r6);
        return;
    L14:
        Bitmap r5 = getBitmapForContactType(this.mContactType, this.mAccount, this.mContext);
        drawBitmap(r5, r5.getWidth(), r5.getHeight(), r9);
        return;
    L5:
        r9.drawRect(r0, r6);
        goto L7
    }

    public int getColor() {
        return this.mColor;
    }

    private int pickColor(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L10;
        if (this.mContactType == 3) goto L10;
        int r1 = (r2.hashCode() & Integer.MAX_VALUE) % sColors.length();
        return sColors.getColor(r1, sDefaultColor);
    L10:
        return sDefaultColor;
    }

    private static Bitmap getBitmapForContactType(int r4, Account r5, Context r6) {
        if (r6 == null) goto L18;
        TelephonyManager r1 = (TelephonyManager) r6.getSystemService("phone");
        if (r5 == null) goto L18;
        if ("com.android.sim".equals(r5.type) == false) goto L18;
        if (r1.getPhoneCount() <= 1) goto L17;
        int r7 = MoreContactUtils.getCurrentSimIconIndex(r6, MoreContactUtils.getSubscription("com.android.sim", r5.name));
        if (r7 >= 0) goto L15;
        return DEFAULT_PERSON_AVATAR;
    L15:
        return DEFAULT_CUSTOMIZE_SIM_PERSON_AVATAR[r7];
    L17:
        return DEFAULT_SIM_PERSON_AVATAR;
    L18:
        if (r4 == 1) goto L30;
        if (r4 == 2) goto L28;
        if (r4 == 3) goto L26;
        return DEFAULT_PERSON_AVATAR;
    L26:
        return DEFAULT_VOICEMAIL_AVATAR;
    L28:
        return DEFAULT_BUSINESS_AVATAR;
    L30:
        return DEFAULT_PERSON_AVATAR;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
        this.mPaint.setAlpha(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
        this.mPaint.setColorFilter(r1);
    }

    public LetterTileDrawable setScale(float r1) {
        this.mScale = r1;
        return this;
    }

    public LetterTileDrawable setOffset(float r2) {
        if (r2 >= (-0.5f)) goto L5;
    L7:
        boolean r0 = false;
    L8:
        Assert.assertTrue(r0);
        this.mOffset = r2;
        return this;
    L5:
        if (r2 > 0.5f) goto L7;
        r0 = true;
        goto L8
    }

    public LetterTileDrawable setLetter(Character r1) {
        this.mLetter = r1;
        return this;
    }

    public LetterTileDrawable setColor(int r1) {
        this.mColor = r1;
        return this;
    }

    public LetterTileDrawable setLetterAndColorFromContactDetails(String r3, String r4) {
        if (r3 != null) goto L4;
    L8:
        this.mLetter = null;
    L9:
        this.mColor = pickColor(r4);
        return this;
    L4:
        if (r3.length() <= 0) goto L8;
        if (isEnglishLetter(r3.charAt(0)) == false) goto L8;
        this.mLetter = Character.valueOf(Character.toUpperCase(r3.charAt(0)));
        goto L9
    }

    public LetterTileDrawable setContactType(int r1) {
        this.mContactType = r1;
        return this;
    }

    public LetterTileDrawable setIsCircular(boolean r1) {
        this.mIsCircle = r1;
        return this;
    }
}
