package bpb;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends q5c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20002a = null;

    static {
        f20002a = new a();
    }

    public a() {
    }

    public static String a(Locale r100) {
        String r101 = r100.getLanguage() + '_' + r100.getCountry();
        if (Intrinsics.areEqual(r101, "in_ID") == false) goto L6;
        return "id_ID";
    L6:
        return r101;
    }
}
