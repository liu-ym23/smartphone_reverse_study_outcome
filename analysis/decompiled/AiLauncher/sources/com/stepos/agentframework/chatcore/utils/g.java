package com.stepos.agentframework.chatcore.utils;

import La.H;
import Y8.t;
import Z8.F;
import Z8.Y;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import e9.InterfaceC4014c;
import h8.C4148a;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import u6.C5578a;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\nJ\u001f\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\nJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u0016J\"\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0086@¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0 8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0 8\u0006¢\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b&\u0010$R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010\"¨\u0006("}, d2 = {"Lcom/stepos/agentframework/chatcore/utils/g;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "uri", "", "e", "(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "fileName", "", "f", "(Ljava/lang/String;)I", "fileType", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(I)Z", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/String;", "c", "Ljava/io/File;", "targetFile", "Landroid/graphics/Bitmap;", "bitmap", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/io/File;Landroid/graphics/Bitmap;Le9/c;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "", "IMAGE_EXTS", "Ljava/util/Set;", "getIMAGE_EXTS", "()Ljava/util/Set;", "CODE_EXTS", "getCODE_EXTS", "ATTACHMENT_EXTS", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class g {
    public static final g INSTANCE = new g();
    private static final String TAG = "FileUtil";
    private static final Set<String> IMAGE_EXTS = Y.j("png", C5578a.DST_JPG, "jpeg", "gif", "webp", "bmp");
    private static final Set<String> CODE_EXTS = Y.j("js", "ts", "py", "java", "go", "css", "json");
    private static final Set<String> ATTACHMENT_EXTS = Y.j("pdf", ChatTracker.CONTENT_DOC, "docx", ChatTracker.CONTENT_PPT, "pptx", "xls", "xlsx", "zip", "html", "htm");

    public final String a(String fileName) {
        String lowerCase;
        p.i(fileName, "fileName");
        String strC = c(fileName);
        if (strC != null) {
            lowerCase = strC.toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (lowerCase == null) {
            return "";
        }
        int iHashCode = lowerCase.hashCode();
        return iHashCode != 3304 ? iHashCode != 3401 ? iHashCode != 3593 ? iHashCode != 3711 ? iHashCode != 98819 ? iHashCode != 3254818 ? (iHashCode == 3271912 && lowerCase.equals("json")) ? "json" : "" : !lowerCase.equals("java") ? "" : "java" : !lowerCase.equals("css") ? "" : "css" : !lowerCase.equals("ts") ? "" : "typescript" : !lowerCase.equals("py") ? "" : "python" : !lowerCase.equals("js") ? "" : "javascript" : !lowerCase.equals("go") ? "" : "go";
    }

    public final String b(Context context, Uri uri) {
        p.i(context, "context");
        p.i(uri, "uri");
        String str = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        String strD = d(context, uri);
        if (strD == null) {
            strD = Const.STR_FILE;
        }
        return "FILE_" + str + "." + strD;
    }

    public final String c(String fileName) {
        p.i(fileName, "fileName");
        String strS1 = H.s1(fileName, '.', null, 2, null);
        if (strS1.length() > 0) {
            return strS1;
        }
        return null;
    }

    public final String d(Context context, Uri uri) {
        p.i(context, "context");
        p.i(uri, "uri");
        try {
            String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri));
            if (extensionFromMimeType != null) {
                return extensionFromMimeType;
            }
            String string = uri.toString();
            p.h(string, "toString(...)");
            String strS1 = H.s1(string, '.', null, 2, null);
            if (strS1.length() > 0) {
                return strS1;
            }
            return null;
        } catch (Exception e10) {
            C4148a.g(TAG, "获取文件扩展名失败: " + e10.getMessage(), e10, false, 8, null);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005a A[Catch: Exception -> 0x0049, TryCatch #0 {Exception -> 0x0049, blocks: (B:7:0x0020, B:9:0x0026, B:19:0x0045, B:32:0x005a, B:34:0x0060, B:39:0x0071, B:25:0x004f, B:26:0x0052, B:23:0x004d, B:10:0x0028, B:12:0x0031, B:14:0x003a, B:18:0x0043), top: B:44:0x0020, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071 A[Catch: Exception -> 0x0049, TRY_LEAVE, TryCatch #0 {Exception -> 0x0049, blocks: (B:7:0x0020, B:9:0x0026, B:19:0x0045, B:32:0x005a, B:34:0x0060, B:39:0x0071, B:25:0x004f, B:26:0x0052, B:23:0x004d, B:10:0x0028, B:12:0x0031, B:14:0x003a, B:18:0x0043), top: B:44:0x0020, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0076 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String e(android.content.Context r11, android.net.Uri r12) {
        /*
            r10 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.p.i(r11, r0)
            java.lang.String r0 = "uri"
            kotlin.jvm.internal.p.i(r12, r0)
            java.lang.String r0 = r12.getScheme()     // Catch: java.lang.Exception -> L53
            java.lang.String r1 = "content"
            boolean r0 = kotlin.jvm.internal.p.d(r0, r1)     // Catch: java.lang.Exception -> L53
            r1 = 0
            if (r0 == 0) goto L56
            android.content.ContentResolver r2 = r11.getContentResolver()     // Catch: java.lang.Exception -> L53
            r6 = 0
            r7 = 0
            r4 = 0
            r5 = 0
            r3 = r12
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L49
            if (r12 == 0) goto L57
            java.io.Closeable r12 = (java.io.Closeable) r12     // Catch: java.lang.Exception -> L49
            r0 = r12
            android.database.Cursor r0 = (android.database.Cursor) r0     // Catch: java.lang.Throwable -> L3f
            boolean r2 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L3f
            if (r2 == 0) goto L42
            java.lang.String r2 = "_display_name"
            int r2 = r0.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L3f
            r4 = -1
            if (r2 == r4) goto L42
            java.lang.String r0 = r0.getString(r2)     // Catch: java.lang.Throwable -> L3f
            goto L43
        L3f:
            r0 = move-exception
            r1 = r0
            goto L4d
        L42:
            r0 = r1
        L43:
            Y8.t r2 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L3f
            l9.b.a(r12, r1)     // Catch: java.lang.Exception -> L49
            goto L58
        L49:
            r0 = move-exception
        L4a:
            r12 = r0
            r6 = r12
            goto L77
        L4d:
            throw r1     // Catch: java.lang.Throwable -> L4e
        L4e:
            r0 = move-exception
            l9.b.a(r12, r1)     // Catch: java.lang.Exception -> L49
            throw r0     // Catch: java.lang.Exception -> L49
        L53:
            r0 = move-exception
            r3 = r12
            goto L4a
        L56:
            r3 = r12
        L57:
            r0 = r1
        L58:
            if (r0 != 0) goto L6f
            java.lang.String r12 = r3.getPath()     // Catch: java.lang.Exception -> L49
            if (r12 == 0) goto L6e
            r0 = 47
            r2 = 2
            java.lang.String r12 = La.H.s1(r12, r0, r1, r2, r1)     // Catch: java.lang.Exception -> L49
            int r0 = r12.length()     // Catch: java.lang.Exception -> L49
            if (r0 <= 0) goto L6e
            r1 = r12
        L6e:
            r0 = r1
        L6f:
            if (r0 != 0) goto L76
            java.lang.String r10 = r10.b(r11, r3)     // Catch: java.lang.Exception -> L49
            return r10
        L76:
            return r0
        L77:
            java.lang.String r4 = com.stepos.agentframework.chatcore.utils.g.TAG
            java.lang.String r12 = r6.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "获取文件名失败: "
            r0.append(r1)
            r0.append(r12)
            java.lang.String r5 = r0.toString()
            r8 = 8
            r9 = 0
            r7 = 0
            h8.C4148a.g(r4, r5, r6, r7, r8, r9)
            java.lang.String r10 = r10.b(r11, r3)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.utils.g.e(android.content.Context, android.net.Uri):java.lang.String");
    }

    public final int f(String fileName) {
        String lowerCase;
        p.i(fileName, "fileName");
        String strC = c(fileName);
        if (strC != null) {
            lowerCase = strC.toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (p.d(lowerCase, "md")) {
            return 11;
        }
        if (F.f0(CODE_EXTS, lowerCase)) {
            return 12;
        }
        if (p.d(lowerCase, "pdf")) {
            return 4;
        }
        if (p.d(lowerCase, ChatTracker.CONTENT_DOC) || p.d(lowerCase, "docx") || p.d(lowerCase, "word")) {
            return 8;
        }
        if (p.d(lowerCase, ChatTracker.CONTENT_PPT) || p.d(lowerCase, "pptx")) {
            return 7;
        }
        if (p.d(lowerCase, "xls") || p.d(lowerCase, "xlsx") || p.d(lowerCase, "excel")) {
            return 9;
        }
        if (p.d(lowerCase, "zip")) {
            return 13;
        }
        if (p.d(lowerCase, "html") || p.d(lowerCase, "htm")) {
            return 14;
        }
        if (p.d(lowerCase, "txt") || p.d(lowerCase, "csv")) {
            return 10;
        }
        if (p.d(lowerCase, "mp4")) {
            return 2;
        }
        return F.f0(IMAGE_EXTS, lowerCase) ? 1 : 5;
    }

    public final boolean g(int fileType) {
        return fileType == 11 || fileType == 12;
    }

    public final Object h(File file, Bitmap bitmap, InterfaceC4014c<? super String> interfaceC4014c) {
        try {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                return null;
            }
            if (!parentFile.exists() && !parentFile.mkdirs()) {
                C4148a.h(TAG, "创建父目录失败: " + parentFile.getAbsolutePath(), false, 4, null);
                return null;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                t tVar = t.f7040a;
                l9.b.a(fileOutputStream, null);
                C4148a.d(TAG, "save success: " + file.getAbsolutePath(), false, 4, null);
                return file.getAbsolutePath();
            } finally {
            }
        } catch (Exception e10) {
            C4148a.g(TAG, "save failed", e10, false, 8, null);
            e10.printStackTrace();
            return null;
        }
    }
}
