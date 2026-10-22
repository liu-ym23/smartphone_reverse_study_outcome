package ch8;

import android.content.Intent;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23807a = null;

    static {
        f23807a = new a();
    }

    public a() {
    }

    public static b a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rawPath");
        if (StringsKt.isBlank(r100) == false) goto L32;
        return null;
    L32:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L12
        if (StringsKt.startsWith$default(r100, "intent:", false, 2, null) == false) goto L9;
        Uri r102 = Intent.parseUri(r100, 1).getData();     // Catch: Throwable -> L12
    L10:
        Object r103 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r103) == false) goto L17;
        r103 = null;
    L17:
        Uri r104 = (Uri) r103;
        if (r104 != null) goto L21;
        return null;
    L21:
        if (StringsKt.equals("content", r104.getScheme(), true) == false) goto L24;
        return new b.a(r104);
    L24:
        if (StringsKt.equals("file", r104.getScheme(), true) == false) goto L29;
        String r105 = r104.getPath();
        if (r105 != null) goto L36;
        return null;
    L36:
        return new b.C0447b(new PolarisFileWrapper(r105));
    L29:
        if (r104.getScheme() == null) goto L31;
        return null;
    L31:
        return new b.C0447b(new PolarisFileWrapper(r100));
    L9:
        r102 = UriProtector.parse(r100);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }
}
