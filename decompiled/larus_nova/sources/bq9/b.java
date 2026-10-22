package bq9;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f20091a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v5 */
    public static boolean b(String r110) {
        if (r110 == null) goto L77;
        List r100 = 0;
        r100 = 0;
        if ((!StringsKt.isBlank(r110)) == true) goto L8;
        r110 = null;
    L8:
        if (r110 == null) goto L78;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        Object r111 = Result.m9449constructorimpl(new URI(r110));     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r111) == false) goto L16;
        r111 = null;
    L16:
        URI r112 = (URI) r111;
        if (r112 == null) goto L79;
        String r102 = r112.getRawQuery();
        if (r102 == null) goto L41;
        List r103 = StringsKt.split$default(r102, new char[]{Typography.amp}, false, 0, 6, null);
        if (r103 == null) goto L41;
        List r104 = r103;
        if ((r104 instanceof Collection) == true) goto L25;
    L27:
        Iterator r105 = r104.iterator();
    L29:
        if (r105.hasNext() == false) goto L38;
        String r106 = (String) r105.next();
        if (Intrinsics.areEqual(StringsKt.substringBefore$default(r106, com.alipay.sdk.m.n.a.f25612h, null, 2, null), "isbaseapp") == true) goto L33;
    L35:
        boolean r107 = false;
    L36:
        if (r107 == false) goto L29;
        boolean r108 = true;
    L39:
        if (r108 != true) goto L41;
        boolean r109 = true;
    L42:
        if (r109 == false) goto L44;
        return true;
    L44:
        String r113 = r112.getPath();
        if (r113 == null) goto L57;
        List r114 = StringsKt.split$default(r113, new char[]{'/'}, false, 0, 6, null);
        if (r114 == null) goto L57;
        r100 = new ArrayList();
        Iterator r115 = r114.iterator();
    L50:
        if (r115.hasNext() == false) goto L57;
        Object r116 = r115.next();
        if (((String) r116).length() <= 0) goto L54;
        boolean r117 = true;
    L55:
        if (r117 == false) goto L50;
        r100.add(r116);
        goto L50
    L54:
        r117 = false;
    L57:
        if (r100 != 0) goto L59;
        r100 = CollectionsKt.emptyList();
    L59:
        int r118 = r100.indexOf("app");
        if (r118 >= 0) goto L62;
        return false;
    L62:
        if (r118 >= CollectionsKt.getLastIndex(r100)) goto L81;
        return true;
    L81:
        return false;
    L33:
        if (Intrinsics.areEqual(StringsKt.substringAfter(r106, com.alipay.sdk.m.n.a.f25612h, ""), "1") == false) goto L35;
        r107 = true;
    L38:
        r108 = false;
        goto L39
    L25:
        if (r104.isEmpty() == false) goto L27;
    L41:
        r109 = false;
        goto L42
    L79:
        return false;
    L11:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L78:
        return false;
    L77:
        return false;
    }

    public static boolean a(Integer r100, String r101) {
        if (r100 == null) goto L8;
        if (r100.intValue() == 1) goto L10;
        return false;
    L10:
        return true;
    L8:
        return b(r101);
    }
}
