package com.stepos.ailauncher.agent.aispace.skill.wecom;

import Z8.C1173v;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextPaint;
import com.autonavi.aps.amapapi.config.Const;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.stepos.agentframework.chatui.view.AssistantImageCardView;
import com.stepos.ailauncher.agent.R$drawable;
import com.stepos.ame.sdk.SkillStoreKt;
import com.zyql.ai.selector.config.PictureConfig;
import com.zyql.ai.selector.config.PictureMimeType;
import java.io.OutputStream;
import java.util.ArrayList;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ5\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\bH\u0002¢\u0006\u0004\b\"\u0010#J\u001f\u0010$\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b$\u0010\u001aJ/\u0010)\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\bH\u0002¢\u0006\u0004\b)\u0010*J?\u00104\u001a\u00020\u00182\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u00062\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.2\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020\bH\u0002¢\u0006\u0004\b4\u00105R\u0014\u00106\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00108\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u00107R\u0014\u00109\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u00107R\u0014\u0010:\u001a\u00020.8\u0002X\u0082T¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020.8\u0002X\u0082T¢\u0006\u0006\n\u0004\b<\u0010;R\u0014\u0010=\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u00107R\u0014\u0010>\u001a\u00020.8\u0002X\u0082T¢\u0006\u0006\n\u0004\b>\u0010;¨\u0006?"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/wecom/W;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "url", "", "sizePx", "Landroid/graphics/Bitmap;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/content/Context;Ljava/lang/String;I)Landroid/graphics/Bitmap;", "title", "description", "expirationHint", "c", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/graphics/Bitmap;", "bitmap", "displayName", "Landroid/net/Uri;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/content/Context;Landroid/graphics/Bitmap;Ljava/lang/String;)Landroid/net/Uri;", "qr", "LY8/t;", "f", "(Landroid/content/Context;Landroid/graphics/Bitmap;)V", "n", "", "", Const.INTENT_KEY_PKGNAME, "(I)[[Z", "version", "", Const.INTENT_KEY_APIKEY, "(I)[I", Const.INTENT_KEY_BACKGROUND_COMMAND, SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Lcom/google/zxing/qrcode/decoder/ErrorCorrectionLevel;", "errorCorrection", "margin", "e", "(Ljava/lang/String;ILcom/google/zxing/qrcode/decoder/ErrorCorrectionLevel;I)Landroid/graphics/Bitmap;", "Landroid/graphics/Canvas;", "canvas", "text", "", "cx", "startY", "Landroid/text/TextPaint;", "paint", "maxWidth", Const.INTENT_KEY_UMID, "(Landroid/graphics/Canvas;Ljava/lang/String;FFLandroid/text/TextPaint;I)V", "CARD_WIDTH_PX", "I", "CARD_HEIGHT_PX", "MARGIN_MODULES", "MODULE_INSET_FRAC", "F", "TILE_SIZE_FRAC", "TILE_COLOR", "LOGO_SIZE_FRAC", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class W {
    private static final int CARD_HEIGHT_PX = 1380;
    private static final int CARD_WIDTH_PX = 1080;
    private static final float LOGO_SIZE_FRAC = 0.182f;
    private static final int MARGIN_MODULES = 2;
    private static final float MODULE_INSET_FRAC = 0.1f;
    private static final float TILE_SIZE_FRAC = 0.27f;
    public static final W INSTANCE = new W();
    private static final int TILE_COLOR = Color.parseColor("#0B0B0C");

    public final int[] a(int version) {
        switch (version) {
            case 1:
                return new int[0];
            case 2:
                return new int[]{6, 18};
            case 3:
                return new int[]{6, 22};
            case 4:
                return new int[]{6, 26};
            case 5:
                return new int[]{6, 30};
            case 6:
                return new int[]{6, 34};
            case 7:
                return new int[]{6, 22, 38};
            case 8:
                return new int[]{6, 24, 42};
            case 9:
                return new int[]{6, 26, 46};
            case 10:
                return new int[]{6, 28, 50};
            case 11:
                return new int[]{6, 30, 54};
            case 12:
                return new int[]{6, 32, 58};
            case 13:
                return new int[]{6, 34, 62};
            case 14:
                return new int[]{6, 26, 46, 66};
            case 15:
                return new int[]{6, 26, 48, 70};
            case 16:
                return new int[]{6, 26, 50, 74};
            case 17:
                return new int[]{6, 30, 54, 78};
            case 18:
                return new int[]{6, 30, 56, 82};
            case 19:
                return new int[]{6, 30, 58, 86};
            case 20:
                return new int[]{6, 34, 62, 90};
            case 21:
                return new int[]{6, 28, 50, 72, 94};
            case 22:
                return new int[]{6, 26, 50, 74, 98};
            case 23:
                return new int[]{6, 30, 54, 78, 102};
            case 24:
                return new int[]{6, 28, 54, 80, 106};
            case 25:
                return new int[]{6, 32, 58, 84, 110};
            case 26:
                return new int[]{6, 30, 58, 86, 114};
            case 27:
                return new int[]{6, 34, 62, 90, 118};
            case 28:
                return new int[]{6, 26, 50, 74, 98, 122};
            case 29:
                return new int[]{6, 30, 54, 78, 102, 126};
            case 30:
                return new int[]{6, 26, 52, 78, 104, 130};
            case 31:
                return new int[]{6, 30, 56, 82, 108, 134};
            case 32:
                return new int[]{6, 34, 60, 86, 112, 138};
            case 33:
                return new int[]{6, 30, 58, 86, 114, 142};
            case 34:
                return new int[]{6, 34, 62, 90, 118, 146};
            case 35:
                return new int[]{6, 30, 54, 78, 102, 126, com.stepos.ailauncher.chat.wake.circle.F.GESTURE_HEIGHT_DP};
            case 36:
                return new int[]{6, 24, 50, 76, 102, 128, 154};
            case 37:
                return new int[]{6, 28, 54, 80, 106, 132, 158};
            case 38:
                return new int[]{6, 32, 58, 84, 110, 136, 162};
            case 39:
                return new int[]{6, 26, 54, 82, 110, 138, PictureConfig.PREVIEW_VIDEO_CODE};
            default:
                return new int[]{6, 30, 58, 86, 114, 142, 170};
        }
    }

    public final boolean[][] b(int n10) {
        boolean z10;
        int i10;
        int i11;
        int i12;
        boolean z11;
        int i13 = (n10 - 17) / 4;
        boolean[][] zArr = new boolean[n10][];
        for (int i14 = 0; i14 < n10; i14++) {
            zArr[i14] = new boolean[n10];
        }
        int i15 = 0;
        while (true) {
            z10 = true;
            if (i15 >= 9) {
                break;
            }
            for (int i16 = 0; i16 < 9; i16++) {
                zArr[i15][i16] = true;
            }
            i15++;
        }
        for (int i17 = 0; i17 < 9; i17++) {
            for (int i18 = n10 - 9; i18 < n10; i18++) {
                zArr[i17][i18] = true;
            }
        }
        int i19 = n10 - 9;
        for (int i20 = i19; i20 < n10; i20++) {
            for (int i21 = 0; i21 < 9; i21++) {
                zArr[i20][i21] = true;
            }
        }
        int i22 = 0;
        while (true) {
            i10 = 8;
            if (i22 >= n10) {
                break;
            }
            zArr[6][i22] = true;
            boolean[] zArr2 = zArr[i22];
            zArr2[6] = true;
            zArr[8][i22] = true;
            zArr2[8] = true;
            i22++;
        }
        if (i13 >= 7) {
            for (int i23 = 0; i23 < 6; i23++) {
                for (int i24 = 0; i24 < 3; i24++) {
                    int i25 = (n10 - 11) + i24;
                    zArr[i23][i25] = true;
                    zArr[i25][i23] = true;
                }
            }
        }
        int[] iArrA = a(i13);
        int length = iArrA.length;
        int i26 = 0;
        while (i26 < length) {
            int i27 = iArrA[i26];
            int[] iArrA2 = a(i13);
            int length2 = iArrA2.length;
            int i28 = 0;
            while (i28 < length2) {
                int i29 = iArrA2[i28];
                if ((i27 > i10 || i29 > i10) && ((i27 > i10 || i29 < i19) && ((i27 < i19 || i29 > i10) && i27 - 2 <= (i12 = i27 + 2)))) {
                    while (true) {
                        z11 = z10;
                        int i30 = i29 - 2;
                        int i31 = i29 + 2;
                        if (i30 <= i31) {
                            while (true) {
                                zArr[i11][i30] = z11;
                                if (i30 == i31) {
                                    break;
                                }
                                i30++;
                            }
                        }
                        if (i11 != i12) {
                            i11++;
                            z10 = z11;
                        }
                    }
                } else {
                    z11 = z10;
                }
                i28++;
                z10 = z11;
                i10 = 8;
            }
            i26++;
            i10 = 8;
        }
        return zArr;
    }

    public final Bitmap c(Context context, String url, String title, String description, String expirationHint) throws WriterException {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(url, "url");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(description, "description");
        kotlin.jvm.internal.p.i(expirationHint, "expirationHint");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(CARD_WIDTH_PX, CARD_HEIGHT_PX, Bitmap.Config.ARGB_8888);
        kotlin.jvm.internal.p.h(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-1);
        float f10 = CARD_WIDTH_PX;
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, f10, CARD_HEIGHT_PX), 48.0f, 48.0f, paint);
        TextPaint textPaint = new TextPaint(1);
        textPaint.setColor(Color.parseColor("#1F1F1F"));
        textPaint.setTextSize(64.0f);
        textPaint.setFakeBoldText(true);
        Paint.Align align = Paint.Align.CENTER;
        textPaint.setTextAlign(align);
        float f11 = f10 / 2.0f;
        canvas.drawText(title, f11, 160.0f, textPaint);
        TextPaint textPaint2 = new TextPaint(1);
        textPaint2.setColor(Color.parseColor("#666666"));
        textPaint2.setTextSize(32.0f);
        textPaint2.setTextAlign(align);
        d(canvas, description, f11, 240.0f, textPaint2, 920);
        Bitmap bitmapE = e(url, 800, ErrorCorrectionLevel.H, 0);
        f(context, bitmapE);
        canvas.drawBitmap(bitmapE, AssistantImageCardView.MAX_WIDTH_DP / 2.0f, 380, (Paint) null);
        bitmapE.recycle();
        TextPaint textPaint3 = new TextPaint(1);
        textPaint3.setColor(Color.parseColor("#999999"));
        textPaint3.setTextSize(30.0f);
        textPaint3.setTextAlign(align);
        canvas.drawText(expirationHint, f11, 1260, textPaint3);
        return bitmapCreateBitmap;
    }

    public final void d(Canvas canvas, String text, float cx, float startY, TextPaint paint, int maxWidth) {
        int i10;
        ArrayList arrayList = new ArrayList();
        Rect rect = new Rect();
        int i11 = 0;
        for (int i12 = 0; i12 < text.length(); i12 = i10) {
            i10 = i12;
            while (i10 < text.length()) {
                int i13 = i10 + 1;
                String strSubstring = text.substring(i12, i13);
                kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
                paint.getTextBounds(strSubstring, 0, strSubstring.length(), rect);
                if (rect.width() > maxWidth) {
                    break;
                } else {
                    i10 = i13;
                }
            }
            if (i10 == i12) {
                i10 = i12 + 1;
            }
            String strSubstring2 = text.substring(i12, i10);
            kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
            arrayList.add(strSubstring2);
        }
        float textSize = paint.getTextSize() * 1.4f;
        for (Object obj : arrayList) {
            int i14 = i11 + 1;
            if (i11 < 0) {
                C1173v.w();
            }
            canvas.drawText((String) obj, cx, (i11 * textSize) + startY, paint);
            i11 = i14;
        }
    }

    public final Bitmap e(String content, int sizePx, ErrorCorrectionLevel errorCorrection, int margin) throws WriterException {
        D3.b bVarA = new A3.b().a(content, BarcodeFormat.QR_CODE, sizePx, sizePx, kotlin.collections.a.m(Y8.j.a(EncodeHintType.CHARACTER_SET, "UTF-8"), Y8.j.a(EncodeHintType.ERROR_CORRECTION, errorCorrection), Y8.j.a(EncodeHintType.MARGIN, Integer.valueOf(margin))));
        kotlin.jvm.internal.p.h(bVarA, "encode(...)");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(sizePx, sizePx, Bitmap.Config.ARGB_8888);
        kotlin.jvm.internal.p.h(bitmapCreateBitmap, "createBitmap(...)");
        for (int i10 = 0; i10 < sizePx; i10++) {
            for (int i11 = 0; i11 < sizePx; i11++) {
                bitmapCreateBitmap.setPixel(i11, i10, bVarA.g(i11, i10) ? -16777216 : -1);
            }
        }
        return bitmapCreateBitmap;
    }

    public final void f(Context context, Bitmap qr) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(BitmapFactory.decodeResource(context.getResources(), R$drawable.ic_wecom_logo));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        Bitmap bitmap = (Bitmap) objB;
        if (bitmap == null) {
            return;
        }
        Canvas canvas = new Canvas(qr);
        int width = (int) (qr.getWidth() * 0.22f);
        float f10 = (r8 - width) / 2.0f;
        Paint paint = new Paint(1);
        paint.setColor(-1);
        float f11 = f10 - 12.0f;
        float f12 = width + f10;
        float f13 = 12.0f + f12;
        canvas.drawRoundRect(new RectF(f11, f11, f13, f13), 16.0f, 16.0f, paint);
        int i10 = (int) f10;
        int i11 = (int) f12;
        canvas.drawBitmap(bitmap, (Rect) null, new Rect(i10, i10, i11, i11), new Paint(3));
        bitmap.recycle();
    }

    public final void g(Context context, Bitmap qr) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(BitmapFactory.decodeResource(context.getResources(), R$drawable.ic_wecom_logo));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        Bitmap bitmap = (Bitmap) objB;
        if (bitmap == null) {
            return;
        }
        Canvas canvas = new Canvas(qr);
        float width = qr.getWidth();
        float f10 = TILE_SIZE_FRAC * width;
        float f11 = (width - f10) / 2.0f;
        Paint paint = new Paint(1);
        paint.setColor(TILE_COLOR);
        float f12 = f11 + f10;
        canvas.drawRect(f11, f11, f12, f12, paint);
        float f13 = (r9 - r10) / 2.0f;
        int i10 = (int) f13;
        int i11 = (int) (f13 + ((int) (width * LOGO_SIZE_FRAC)));
        canvas.drawBitmap(bitmap, (Rect) null, new Rect(i10, i10, i11, i11), new Paint(3));
        bitmap.recycle();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap h(android.content.Context r21, java.lang.String r22, int r23) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.skill.wecom.W.h(android.content.Context, java.lang.String, int):android.graphics.Bitmap");
    }

    public final Uri i(Context context, Bitmap bitmap, String displayName) {
        Object objB;
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(bitmap, "bitmap");
        kotlin.jvm.internal.p.i(displayName, "displayName");
        ContentResolver contentResolver = context.getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", displayName);
        contentValues.put("mime_type", PictureMimeType.PNG_Q);
        contentValues.put("relative_path", Environment.DIRECTORY_DCIM + "/Clawphone");
        boolean z10 = true;
        contentValues.put("is_pending", (Integer) 1);
        Uri uriInsert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (uriInsert == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uriInsert);
            if (outputStreamOpenOutputStream == null) {
                l9.b.a(outputStreamOpenOutputStream, null);
                z10 = false;
            } else {
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStreamOpenOutputStream);
                    l9.b.a(outputStreamOpenOutputStream, null);
                } finally {
                }
            }
            objB = Result.b(Boolean.valueOf(z10));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        if (!((Boolean) objB).booleanValue()) {
            contentResolver.delete(uriInsert, null, null);
            return null;
        }
        contentValues.clear();
        contentValues.put("is_pending", (Integer) 0);
        contentResolver.update(uriInsert, contentValues, null, null);
        return uriInsert;
    }
}
