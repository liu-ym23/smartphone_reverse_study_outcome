package com.stepos.ailauncher.common.utils;

import Z8.Y;
import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.webkit.MimeTypeMap;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import com.zyql.ai.selector.config.PictureMimeType;
import h8.C4148a;
import java.io.File;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/common/utils/A;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "imageUrl", "saveFileName", "", "c", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z", "raw", "e", "(Ljava/lang/String;)Ljava/lang/String;", "url", Const.INTENT_KEY_UMID, "Companion", Const.INTENT_KEY_APIKEY, "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class A {
    private static final String TAG = "ImageDownloader";
    private static volatile A instance;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> ALLOWED_SCHEMES = Y.j("http", "https");
    private static final Regex UNSAFE_FILE_NAME_CHARS = new Regex("[\\x00-\\x1f:*?\"<>|]");

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/common/utils/A$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/common/utils/A;", "c", "()Lcom/stepos/ailauncher/common/utils/A;", "", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "TAG", "Ljava/lang/String;", "", "ALLOWED_SCHEMES", "Ljava/util/Set;", "Lkotlin/text/Regex;", "UNSAFE_FILE_NAME_CHARS", "Lkotlin/text/Regex;", "instance", "Lcom/stepos/ailauncher/common/utils/A;", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.common.utils.A$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final String b() {
            return "image_" + System.currentTimeMillis() + PictureMimeType.JPG;
        }

        public final A c() {
            A a10;
            A a11 = A.instance;
            if (a11 != null) {
                return a11;
            }
            synchronized (this) {
                a10 = new A();
                A.instance = a10;
            }
            return a10;
        }

        public Companion() {
        }
    }

    public final boolean c(Context context, String imageUrl, String saveFileName) {
        String lowerCase;
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(imageUrl, "imageUrl");
        kotlin.jvm.internal.p.i(saveFileName, "saveFileName");
        Uri uri = Uri.parse(imageUrl);
        Set<String> set = ALLOWED_SCHEMES;
        String scheme = uri.getScheme();
        if (scheme != null) {
            lowerCase = scheme.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (!Z8.F.f0(set, lowerCase)) {
            C4148a.u(TAG, "reject download: unsupported scheme=" + uri.getScheme(), false, 4, null);
            return false;
        }
        String strE = e(saveFileName);
        try {
            DownloadManager.Request description = new DownloadManager.Request(uri).setAllowedNetworkTypes(3).setNotificationVisibility(1).setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, File.separator + strE).setMimeType(d(imageUrl)).setTitle("图片下载").setDescription("正在保存图片到相册...");
            Object systemService = context.getSystemService(com.stepos.ailauncher.chat.trace.a.BUTTON_DOWNLOAD);
            kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.app.DownloadManager");
            ((DownloadManager) systemService).enqueue(description);
            return true;
        } catch (Throwable th) {
            C4148a.t(TAG, "enqueue download failed", th, false, 8, null);
            return false;
        }
    }

    public final String d(String url) {
        try {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(url));
            return mimeTypeFromExtension == null ? "image/jpeg" : mimeTypeFromExtension;
        } catch (Exception unused) {
            return "image/jpeg";
        }
    }

    public final String e(String raw) {
        String strI1 = La.H.I1(La.H.D1(UNSAFE_FILE_NAME_CHARS.l(La.H.s1(La.H.s1(raw, JsonPointer.SEPARATOR, null, 2, null), '\\', null, 2, null), "_")).toString(), '.');
        return strI1.length() == 0 ? INSTANCE.b() : strI1;
    }
}
