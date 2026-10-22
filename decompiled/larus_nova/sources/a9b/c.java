package a9b;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class c {
    public static final boolean a(a r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != null) goto L5;
    L32:
        return true;
    L5:
        if (StringsKt.isBlank(r101) == true) goto L32;
        String r102 = r100.a().user_name;
        if (r102 != null) goto L10;
    L12:
        boolean r103 = false;
    L13:
        if (r103 == false) goto L15;
        return true;
    L15:
        String r104 = r100.a().name_py;
        if (r104 != null) goto L18;
    L20:
        boolean r105 = false;
    L21:
        if (r105 == false) goto L23;
        return true;
    L23:
        String r106 = r100.a().tenant_name;
        if (r106 != null) goto L26;
    L28:
        boolean r107 = false;
    L29:
        if (r107 == false) goto L31;
        return true;
    L31:
        return false;
    L26:
        if (StringsKt.contains(r106, r101, false) != true) goto L28;
        r107 = true;
        goto L29
    L18:
        if (StringsKt.contains(r104, r101, false) != true) goto L20;
        r105 = true;
        goto L21
    L10:
        if (StringsKt.contains(r102, r101, false) != true) goto L12;
        r103 = true;
        goto L13
    }
}
