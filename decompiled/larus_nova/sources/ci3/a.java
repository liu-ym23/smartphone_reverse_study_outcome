package ci3;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f23852a = 0;

    static {
    }

    public static String a(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "btm");
        Intrinsics.checkNotNullParameter(r111, "cd");
        return CollectionsKt.joinToString$default(StringsKt.split$default(r110, new String[]{"."}, false, 0, 6, null).subList(0, 2), ".", null, null, 0, null, null, 62, null) + '.' + r111;
    }
}
