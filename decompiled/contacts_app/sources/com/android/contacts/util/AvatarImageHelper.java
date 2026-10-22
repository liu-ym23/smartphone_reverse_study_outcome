package com.android.contacts.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import bytedanceos.util.NameAvatarController;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AvatarImageHelper {
    private static final String CHINESE_TYPEFACE_NAME = "FZCCHK.TTF";
    private static final String ENGLIST_TYPEFACE_NAME = "Gotham-Ultra.otf";
    private static final double FONT_OFFSET_LEFT = 0.3d;
    private static final double FONT_OFFSET_LEFT_SMALL = 0.0d;
    private static final double FONT_OFFSET_TOP = 3.3d;
    private static final double FONT_OFFSET_TOP_SMALL = 2.3d;
    private static final float FONT_SIZE = 34.0f;
    private static final float FONT_SIZE_SMALL = 13.0f;
    public static final boolean NEED_HARDWARD_ACC = false;
    private static final String TAG = "AvatarImageHelper";
    private static Paint sChinesePaint;
    private static Paint sChinesePaintSmall;
    private static Typeface sChineseTypeface;
    private static Paint sEnglishPaint;
    private static Paint sEnglishPaintSmall;
    private static Typeface sEnglishTypeface;
    private static int sOffsetLeft;
    private static int sOffsetLeftSmarll;
    private static int sOffsetTop;
    private static int sOffsetTopSmall;
    private static Bitmap sRoundBG;
    private Context mContext;
    private List<OnAvatarTextFontChangeListener> mListeners;

    /* JADX INFO: renamed from: com.android.contacts.util.AvatarImageHelper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class InternalHolder {
        public static final AvatarImageHelper sAvatarImageHelper = null;

        private InternalHolder() {
        }

        static {
            sAvatarImageHelper = new AvatarImageHelper(ContactsApplication.getInstance(), null);
        }
    }

    public interface OnAvatarTextFontChangeListener {
        void onAvatarTextFontChanged();
    }

    static {
    }

    /* synthetic */ AvatarImageHelper(Context r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static AvatarImageHelper getIntance() {
        return InternalHolder.sAvatarImageHelper;
    }

    private AvatarImageHelper(Context r9) {
        this.mListeners = new ArrayList();
        this.mContext = r9;
        Paint r0 = new Paint();
        sChinesePaint = r0;
        r0.setColor(-1);
        sChinesePaint.setTypeface(sChineseTypeface);
        sChinesePaint.setAntiAlias(true);
        sChinesePaint.setTextSize(ContactsUtils.dipTopx(r9, 34.0d));
        Paint r1 = new Paint(sChinesePaint);
        sChinesePaintSmall = r1;
        r1.setTextSize(ContactsUtils.dipTopx(r9, 13.0d));
        Paint r2 = new Paint();
        sEnglishPaint = r2;
        r2.setColor(-1);
        sEnglishPaint.setTypeface(sEnglishTypeface);
        sEnglishPaint.setAntiAlias(true);
        sEnglishPaint.setTextSize(ContactsUtils.dipTopx(r9, 34.0d));
        Paint r3 = new Paint(sEnglishPaint);
        sEnglishPaintSmall = r3;
        r3.setTextSize(ContactsUtils.dipTopx(r9, 13.0d));
        sOffsetTop = ContactsUtils.dipTopx(this.mContext, FONT_OFFSET_TOP);
        sOffsetLeft = ContactsUtils.dipTopx(this.mContext, FONT_OFFSET_LEFT);
        sOffsetTopSmall = ContactsUtils.dipTopx(this.mContext, FONT_OFFSET_TOP_SMALL);
        sOffsetLeftSmarll = ContactsUtils.dipTopx(this.mContext, FONT_OFFSET_LEFT_SMALL);
        sRoundBG = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.roundphotobg);
    }

    public void addAvatarTextFontChangeListener(OnAvatarTextFontChangeListener r2) {
        if (this.mListeners.contains(r2) == true) goto L6;
        this.mListeners.add(r2);
        return;
    }

    public void removeAvatarTextFontChangeListener(OnAvatarTextFontChangeListener r2) {
        if (this.mListeners.contains(r2) == false) goto L6;
        this.mListeners.remove(r2);
        return;
    }

    public void updateAvatarImageTypeface() {
        Paint r0 = sChinesePaint;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        Paint r3 = sChinesePaintSmall;
        if (r3 != null) goto L11;
    L13:
        Paint r4 = sEnglishPaint;
        if (r4 != null) goto L16;
    L18:
        Paint r5 = sEnglishPaintSmall;
        if (r5 != null) goto L21;
    L23:
        r1 = r2;
    L24:
        if (r1 == true) goto L26;
        return;
    L26:
        if (this.mListeners.isEmpty() == true) goto L33;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "refreshTextPaint");
        Iterator<OnAvatarTextFontChangeListener> r6 = this.mListeners.iterator();
    L29:
        if (r6.hasNext() == false) goto L34;
        r6.next().onAvatarTextFontChanged();
        goto L29
    L34:
        return;
    L33:
        return;
    L21:
        if (r5.getTypeface() != null) goto L23;
        sEnglishPaintSmall.setTypeface(sEnglishTypeface);
        goto L24
    L16:
        if (r4.getTypeface() != null) goto L18;
        sEnglishPaint.setTypeface(sEnglishTypeface);
        r2 = true;
        goto L18
    L11:
        if (r3.getTypeface() != null) goto L13;
        sChinesePaintSmall.setTypeface(sChineseTypeface);
        r2 = true;
        goto L13
    L5:
        if (r0.getTypeface() != null) goto L7;
        sChinesePaint.setTypeface(sChineseTypeface);
        r2 = true;
        goto L8
    }

    public static void init(Context r2) {
        sChineseTypeface = Typeface.createFromAsset(r2.getAssets(), CHINESE_TYPEFACE_NAME);     // Catch: Exception -> L4
        sEnglishTypeface = Typeface.createFromAsset(r2.getAssets(), ENGLIST_TYPEFACE_NAME);     // Catch: Exception -> L4
    L5:
        InternalHolder.sAvatarImageHelper.updateAvatarImageTypeface();
        return;
    L4:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Failed to load typefaces from asset.");
        goto L5
    }

    public static void drawName(String r1, Bitmap r2) {
        drawName(r1, r2, false);
    }

    public static void drawName(String r1, Bitmap r2, boolean r3) {
        getIntance().drawNameInternal(r1, r2, r3);
    }

    private void drawNameInternal(String r1, Bitmap r2, boolean r3) {
        NameAvatarController.getInstances(this.mContext).drawName(r1, r2);
    }

    public static void drawAvatarDrawable(Bitmap r1, Bitmap r2) {
        getIntance().drawAvatarDrawableInternal(r1, r2);
    }

    private void drawAvatarDrawableInternal(Bitmap r5, Bitmap r6) {
        Paint r4 = sEnglishPaint;
        int r0 = r6.getWidth();
        Rect r1 = new Rect(0, 0, r0, r0);
        Canvas r2 = new Canvas(r6);
        r2.drawBitmap(sRoundBG, r1, r1, r4);
        r2.drawBitmap(ThumbnailUtils.extractThumbnail(r5.copy(Bitmap.Config.ARGB_8888, true), r0, r0), r1, r1, r4);
    }

    public static Bitmap getAvatarBitmap(Bitmap r1, int r2) {
        return getIntance().getAvatarBitmapInternal(r1, r2);
    }

    private Bitmap getAvatarBitmapInternal(Bitmap r8, int r9) {
        Paint r7 = sEnglishPaint;
        Rect r0 = new Rect(0, 0, r9, r9);
        Bitmap r2 = getAvatarBase(r9);
        Canvas r3 = new Canvas(r2);
        Rect r4 = new Rect(0, 0, sRoundBG.getWidth(), sRoundBG.getWidth());
        r3.drawBitmap(sRoundBG, r4, r0, r7);
        r3.drawBitmap(ThumbnailUtils.extractThumbnail(r8.copy(Bitmap.Config.ARGB_8888, true), r9, r9), r0, r0, r7);
        return r2;
    }

    public static void reInitRoundBG(Context r2) {
        Bitmap r0 = sRoundBG;
        if (r0 == null) goto L5;
        r0.recycle();
    L5:
        new BitmapFactory.Options().inMutable = true;
        sRoundBG = BitmapFactory.decodeResource(r2.getResources(), R.drawable.roundphotobg);
    }

    public static Bitmap getAvatarBase(int r1) {
        return Bitmap.createBitmap(r1, r1, Bitmap.Config.ARGB_8888);
    }

    public static void saveDrawableToSD(Drawable r0, String r1) {
        saveBitmapToSD(((BitmapDrawable) r0).getBitmap(), r1);
    }

    public static void saveBitmapToSD(Bitmap r3, String r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        File r0 = new File("/sdcard/avatar/");
        if (r0.exists() == true) goto L7;
        r0.mkdir();
    L7:
        File r1 = new File("/sdcard/avatar/" + r4 + ".png");
        r1.createNewFile();     // Catch: IOException -> L10
    L33:
        FileOutputStream r5 = new FileOutputStream(r1);     // Catch: IOException -> L22 FileNotFoundException -> L24
        r3.compress(Bitmap.CompressFormat.PNG, 100, r5);     // Catch: Throwable -> L16
        r5.flush();     // Catch: Throwable -> L16
        r5.close();     // Catch: IOException -> L22 FileNotFoundException -> L24
        return;
    L16:
        th = move-exception;
        r5.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: IOException -> L22 FileNotFoundException -> L24
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L22 FileNotFoundException -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
        return;
    L22:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "Exception when fOut.flush:" + e);
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L33
    }
}
