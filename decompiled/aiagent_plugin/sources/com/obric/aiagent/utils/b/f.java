package com.obric.aiagent.utils.b;

import android.webkit.MimeTypeMap;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Locale;

/* JADX INFO: compiled from: MediaFileUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f22331a = null;

    static {
        f22331a = new f();
    }

    private f() {
    }

    public final String a(String r8) {
        o.e(r8, "fileNameOrPath");
        String r7 = d.o.o.c(r8, '/', null, 2, null);
        int r9 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), '.', 0, false, 6, null);
        if (r9 >= 0) goto L5;
    L7:
        return "";
    L5:
        if (r9 >= d.o.o.e((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"))) goto L7;
        String r10 = r7.substring(r9 + 1);
        o.c(r10, "substring(...)");
        return r10;
    }

    public final String b(String r2) {
        o.e(r2, "fileNameOrPath");
        String r1 = a(r2).toLowerCase(Locale.ROOT);
        o.c(r1, "toLowerCase(...)");
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L7;
        r1 = null;
    L7:
        if (r1 != null) goto L9;
        return "application/octet-stream";
    L9:
        String r3 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r1);
        if (r3 != null) goto L13;
        return "application/octet-stream";
    L13:
        return r3;
    }

    public final boolean c(String r4) {
        o.e(r4, DBDefinition.MIME_TYPE);
        return d.o.o.b(r4, "image/", false, 2, null);
    }

    public final boolean d(String r4) {
        o.e(r4, DBDefinition.MIME_TYPE);
        return d.o.o.b(r4, "video/", false, 2, null);
    }
}
