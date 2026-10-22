package ae7;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.ss.android.downloadlib.constants.MimeType;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f3112a = 0;

    static {
    }

    public static boolean b() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.W1();
        if (r103 == null) goto L9;
        boolean r104 = r103.booleanValue();
    L10:
        if (r104 == true) goto L12;
    L14:
        return false;
    L12:
        if (Build.VERSION.SDK_INT < 29) goto L14;
        return true;
    L9:
        r104 = true;
        goto L10
    }

    public static String c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter("image/jpeg", "defaultType");
        if (StringsKt.endsWith$default(r100, ".jpeg", false, 2, null) == false) goto L5;
        return "image/jpeg";
    L5:
        if (StringsKt.endsWith$default(r100, ".jpg", false, 2, null) == false) goto L8;
        return "image/jpeg";
    L8:
        if (StringsKt.endsWith$default(r100, RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT, false, 2, null) == false) goto L11;
        return "image/png";
    L11:
        if (StringsKt.endsWith$default(r100, EffectConstants.GIF_FILE_SUFFIX, false, 2, null) == false) goto L14;
        return MimeType.GIF;
    L14:
        if (StringsKt.endsWith$default(r100, ".webp", false, 2, null) == false) goto L17;
        return MimeType.WEBP;
    L17:
        if (StringsKt.endsWith$default(r100, ".bmp", false, 2, null) == false) goto L20;
        return "image/bmp";
    L20:
        if (StringsKt.endsWith$default(r100, ".jpg2", false, 2, null) == false) goto L23;
        return "image/jp2";
    L23:
        if (StringsKt.endsWith$default(r100, ".tif", false, 2, null) == false) goto L25;
    L26:
        return MimeType.TIFF;
    L25:
        if (StringsKt.endsWith$default(r100, ".tiff", false, 2, null) == true) goto L26;
        return "image/jpeg";
    }

    public static Uri a(Context r100, String r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "path");
        PolarisFileWrapper r101 = new PolarisFileWrapper(r110);
        if (r111 == false) goto L9;
        if (b() == false) goto L7;
        String r112 = r101.getName();
        String r102 = c.f3110a;
        Uri r113 = c.d(r100, r112, c(r112));
    L32:
        if (r113 != null) goto L42;
        return null;
    L42:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L36
        c.b(new PolarisFileInputStreamWrapper(r110), ContentResolverWrapper.openOutputStream(r100.getContentResolver(), r113));     // Catch: Throwable -> L36
        Result.m9449constructorimpl(Boolean.valueOf(c.g(r110)));     // Catch: Throwable -> L36
    L39:
        if (c.e(r100, r113) == false) goto L41;
        r100.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", r113));
    L41:
        return r113;
    L36:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L39
    L7:
        String r114 = r101.getName();
        String r105 = c.f3110a;
        r113 = c.c(r100, r114, c(r114));
        goto L32
    L9:
        if (b() == false) goto L11;
        String r115 = r101.getName();
        String r106 = c.f3110a;
        ContentValues r107 = new ContentValues();
        r107.put("title", r115);
        r107.put("_display_name", r115);
        r107.put("mime_type", MimeType.MP4);
        r113 = c.a(r100.getContentResolver(), MediaStore.Video.Media.EXTERNAL_CONTENT_URI, r107);
        goto L32
    L11:
        String r116 = r101.getName();
        String r108 = c.f3110a;
        PolarisFileWrapper r109 = new PolarisFileWrapper(c.f3110a);
        if (r109.exists() == true) goto L14;
        r109.mkdirs();
    L14:
        String r117 = Environment.DIRECTORY_DCIM + "/Camera/";
        if (r100 != null) goto L17;
    L31:
        r113 = null;
        goto L32
    L17:
        if (TextUtils.isEmpty(r116) == true) goto L31;
        if (TextUtils.isEmpty(r117) == true) goto L31;
        if (r117.endsWith(HTTP.URL_DEFAULT) == true) goto L23;
        r117 = r117.concat(HTTP.URL_DEFAULT);
    L23:
        ContentValues r118 = new ContentValues();
        r118.put("_display_name", r116);
        r118.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        r118.put("mime_type", MimeType.MP4);
        if (Build.VERSION.SDK_INT < 29) goto L26;
        boolean r119 = true;
    L27:
        if (r119 == false) goto L29;
        Uri r120 = MediaStore.Video.Media.getContentUri("external_primary");
        r118.put(LynxEventReporter.PROP_NAME_RELATIVE_PATH, r117);
    L30:
        r113 = c.a(r100.getContentResolver(), r120, r118);
        goto L32
    L29:
        Uri r121 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        r118.put("_data", c.f(Environment.getExternalStorageDirectory().getPath() + HTTP.URL_DEFAULT + r117 + HTTP.URL_DEFAULT + r116));
        r120 = r121;
        goto L30
    L26:
        r119 = false;
        goto L27
    }
}
