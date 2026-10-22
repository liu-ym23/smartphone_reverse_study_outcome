package com.bumptech.glide.integration.heif;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.bumptech.glide.integration.heif.bean.Heif;
import com.bumptech.glide.integration.heif.bean.HeifData;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J$\u0010\u001a\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000RB\u0010\u0007\u001a6\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t0\bj\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bumptech/glide/integration/heif/HeifDecoder;", "", "<init>", "()V", "TAG", "", "MIME_TYPE_HEIF", "resolutionCache", "Ljava/util/HashMap;", "Lkotlin/Pair;", "", "Lkotlin/collections/HashMap;", "decode", "Landroid/graphics/Bitmap;", HTTP.CONTENT_RANGE_BYTES, "", "offset", "length", "opts", "Landroid/graphics/BitmapFactory$Options;", "releasePixelBufferAfterCopy", "", "([BLjava/lang/Integer;Ljava/lang/Integer;Landroid/graphics/BitmapFactory$Options;Z)Landroid/graphics/Bitmap;", "decodeMeta", "", "parseBytes", "decodeBitmap", "logMsg", "msg", "lark-glide-heif_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HeifDecoder {
    public static final HeifDecoder INSTANCE = null;
    private static final String MIME_TYPE_HEIF = "image/heif";
    private static final String TAG = "HeifDecoder";
    private static final HashMap<String, Pair<Integer, Integer>> resolutionCache = null;

    private HeifDecoder() {
    }

    static {
        INSTANCE = new HeifDecoder();
        resolutionCache = new HashMap();
    }

    private final void logMsg(String r100) {
        if (r100 == null) goto L5;
        Log.i(TAG, r100);
        return;
    }

    private final void decodeMeta(byte[] r110, BitmapFactory.Options r111) {
        logMsg("decodeMeta start:" + r110.length);
        StringBuilder r100 = new StringBuilder();
        r100.append(ArraysKt.first(r110));
        r100.append('_');
        r100.append(r110.length);
        r100.append('_');
        r100.append(ArraysKt.last(r110));
        String r101 = r100.toString();
        HashMap<String, Pair<Integer, Integer>> r102 = resolutionCache;
        Pair<Integer, Integer> r103 = r102.get(r101);
        int r104 = 0;
        if (r103 != null) goto L9;
        int[] r105 = Heif.parseSimpleMeta(r110, r110.length);
        if (r105 != null) goto L7;
    L10:
        if (r103 == null) goto L12;
        int r106 = r103.getFirst().intValue();
    L13:
        r111.outWidth = r106;
        if (r103 == null) goto L16;
        r104 = r103.getSecond().intValue();
    L16:
        r111.outHeight = r104;
        return;
    L12:
        r106 = 0;
        goto L13
    L7:
        if (r105.length < 2) goto L10;
        r103 = new Pair(Integer.valueOf(r105[0]), Integer.valueOf(r105[1]));
        r102.put(r101, r103);
        logMsg("decodeMeta success:" + r101 + ", result:" + ArraysKt.joinToString$default(r105, null, null, null, 0, null, null, 63, null));
        goto L10
    L9:
        logMsg("decodeMeta use resolution cache:" + r101);
        goto L10
    }

    private final Bitmap decodeBitmap(byte[] r110, BitmapFactory.Options r111, boolean r112) {
        logMsg("decodeBitmap start:" + r110.length);
        if (r111 == null) goto L5;
        int r100 = r111.inSampleSize;
    L6:
        HeifData r101 = Heif.toRgba(r110, r110.length, false, RangesKt.coerceAtLeast(r100, 1), 0, 0, 0, 0);
        Bitmap r102 = null;
        if (r101 == null) goto L9;
        r102 = r101.newBitmap(null, r112);
    L9:
        int r113 = 0;
        if (r111 == null) goto L15;
        if (r102 == null) goto L13;
        int r103 = r102.getWidth();
    L14:
        r111.outWidth = r103;
        goto L15
    L13:
        r103 = 0;
    L15:
        if (r111 == null) goto L19;
        if (r102 == null) goto L18;
        r113 = r102.getHeight();
    L18:
        r111.outHeight = r113;
    L19:
        if (r102 == null) goto L21;
        logMsg("decodeBitmap success:" + r110.length);
    L21:
        return r102;
    L5:
        r100 = 1;
        goto L6
    }

    public final Bitmap decode(byte[] r100, Integer r101, Integer r102, BitmapFactory.Options r103, boolean r104) {
        Bitmap r105 = null;
        if (r100 == null) goto L33;
        if (r101 == null) goto L33;
        if (r102 == null) goto L33;
        if ((r101.intValue() | r102.intValue()) < 0) goto L33;
        if (r100.length < (r101.intValue() + r102.intValue())) goto L33;
    L31:
        th = move-exception;
        logMsg("decode failed:" + r100.length + ", msg:" + th);
        goto L33
    L13:
        if (r101.intValue() <= 0) goto L15;
        byte[] r106 = ArraysKt.copyOfRange(r100, r101.intValue(), r101.intValue() + r102.intValue());     // Catch: Throwable -> L31
    L16:
        boolean r107 = false;
        if (r103 != null) goto L19;
    L21:
        if (r107 == false) goto L23;
        decodeMeta(r106, r103);     // Catch: Throwable -> L31
    L25:
        if (Build.VERSION.SDK_INT < 26) goto L28;
        if (r103 == null) goto L28;
        r103.outConfig = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L31
    L28:
        if (r103 == null) goto L33;
        r103.outMimeType = MIME_TYPE_HEIF;     // Catch: Throwable -> L31
        goto L33
    L23:
        r105 = decodeBitmap(r106, r103, r104);     // Catch: Throwable -> L31
        goto L25
    L19:
        if (r103.inJustDecodeBounds != true) goto L21;
        r107 = true;
        goto L21
    L15:
        r106 = r100;
    L33:
        return r105;
    }

    public static /* synthetic */ Bitmap decode$default(HeifDecoder r100, byte[] r101, Integer r102, Integer r103, BitmapFactory.Options r110, boolean r111, int r112, Object r113) {
        if ((r112 & 16) == 0) goto L5;
        boolean r104 = false;
    L7:
        return r100.decode(r101, r102, r103, r110, r104);
    L5:
        r104 = r111;
        goto L7
    }
}
