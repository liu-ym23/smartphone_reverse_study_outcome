package bx4;

import android.text.TextUtils;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final boolean b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        return StringsKt.startsWith$default(r100, "fake_", false, 2, null);
    }

    @JvmStatic
    public static final String c(boolean r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "suffix");
        if (r100 == true) goto L6;
        r101 = null;
    L6:
        String r103 = "";
        if (r100 == true) goto L10;
        r102 = "";
    L10:
        StringBuilder r104 = new StringBuilder();
        if (r101 == null) goto L16;
        String r105 = "_".concat(r101);
        if (r105 == null) goto L16;
        r103 = r105;
    L16:
        r104.append(r103);
        r104.append(r102);
        return r104.toString();
    }

    @JvmStatic
    public static final String a(String r100, long r101, boolean r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r104, "ownerType");
        return "fake_" + r100 + c(r102, "w", "") + c(true, String.valueOf(r101), "") + c(r103, "ownerType", r104);
    }
}
