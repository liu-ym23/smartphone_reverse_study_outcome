package com.bytedance.android.livesdk.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import bytedance.io.BdMediaFileSystem;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import java.io.OutputStream;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f158092a = null;

    static {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        String r100 = Environment.getExternalStorageDirectory().getPath() + '/' + Environment.DIRECTORY_DCIM + "/Camera/";
    L6:
        f158092a = r100;
        return;
    L5:
        r100 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath() + "/Camera/";
        goto L6
    }

    public static Bitmap a(View r100) {
        if (r100 != null) goto L10;
    L8:
        return null;
    L10:
        int r101 = (int) 1.0f;     // Catch: Exception -> L6
        Bitmap r102 = Bitmap.createBitmap(r100.getWidth() * r101, r100.getHeight() * r101, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L6
        Canvas r103 = new Canvas(r102);     // Catch: Exception -> L6
        r103.scale(1.0f, 1.0f);     // Catch: Exception -> L6
        r100.draw(r103);     // Catch: Exception -> L6
        return r102;
    L6:
        e = move-exception;
        ALogger.d("ttlive_poster", "draw bitmap failure: " + e.getMessage());
        goto L8
    }

    @JvmStatic
    public static final Uri c(Context r100, Bitmap r101) {
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r100 != null) goto L12;
        return null;
    L12:
        Uri r102 = BdMediaFileSystem.createImageUri(r100, "clip_screen_method_" + System.currentTimeMillis() + RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT, "image/png");     // Catch: Exception -> L9
        OutputStream r103 = ContentResolverWrapper.openOutputStream(r100.getContentResolver(), r102);     // Catch: Exception -> L9
        Bitmap.CompressFormat r104 = Bitmap.CompressFormat.PNG;     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L9
        r101.compress(r104, 100, r103);     // Catch: Exception -> L9
        return r102;
    L9:
        e = move-exception;
        ALogger.d("ttlive_poster", "save bitmap failure: " + e.getMessage());
        return null;
    }

    @JvmStatic
    public static final Bitmap b(ConstraintLayout r100, int r101, Rect r102) {
        int r103 = (int) 2.0f;     // Catch: Exception -> L4
        Bitmap r104 = Bitmap.createBitmap(((r100.getWidth() * r103) + r102.left) + r102.right, ((r100.getHeight() * r103) + r102.top) + r102.bottom, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L4
        Canvas r105 = new Canvas(r104);     // Catch: Exception -> L4
        r105.drawColor(r101);     // Catch: Exception -> L4
        r105.translate(r102.left, r102.top);     // Catch: Exception -> L4
        r105.scale(2.0f, 2.0f);     // Catch: Exception -> L4
        r100.draw(r105);     // Catch: Exception -> L4
        return r104;
    L4:
        e = move-exception;
        ALogger.d("ttlive_poster", "draw bitmap failure: " + e.getMessage());
        return null;
    }

    @JvmStatic
    public static final String d(Context r100, Bitmap r101, String r102) {
        if (r101 == null) goto L17;
        if (r100 == null) goto L18;
        StringBuilder r103 = new StringBuilder();     // Catch: Exception -> L12
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        r103.append(r102);     // Catch: Exception -> L12
        r103.append('_');     // Catch: Exception -> L12
        r103.append(System.currentTimeMillis());     // Catch: Exception -> L12
        r103.append(RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT);     // Catch: Exception -> L12
        String r104 = r103.toString();     // Catch: Exception -> L12
        OutputStream r105 = ContentResolverWrapper.openOutputStream(r100.getContentResolver(), BdMediaFileSystem.createImageUri(r100, r104, "image/png"));     // Catch: Exception -> L12
        Bitmap.CompressFormat r106 = Bitmap.CompressFormat.PNG;     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r105);     // Catch: Exception -> L12
        r101.compress(r106, 100, r105);     // Catch: Exception -> L12
        return f158092a + r104;
    L12:
        e = move-exception;
        ALogger.d("ttlive_poster", "save bitmap failure: " + e.getMessage());
        return "";
    L18:
        return "";
    L17:
        return "";
    }
}
