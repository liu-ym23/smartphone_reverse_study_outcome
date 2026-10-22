package fc;

import a7.c;
import kotlin.Result;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19643a = null;

    static {
        f19643a = new a();
    }

    public a() {
    }

    public final String a() {
        if (c() == false) goto L6;
        return "release";
    L6:
        return "dev";
    }

    public final String b() {
        Object r10 = "";
        Result.a r11 = Result.Companion;     // Catch: Throwable -> L5
        Object r12 = Result.m35constructorimpl(c.a("ro.os.ota.version", ""));     // Catch: Throwable -> L5
    L8:
        if (Result.m41isFailureimpl(r12) == true) goto L12;
        r10 = r12;
    L12:
        return (String) r10;
    L5:
        th = move-exception;
        Result.a r13 = Result.Companion;
        r12 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L8
    }

    public final boolean c() {
        return StringsKt__StringsKt.E(b(), "release", false, 2, null);
    }
}
