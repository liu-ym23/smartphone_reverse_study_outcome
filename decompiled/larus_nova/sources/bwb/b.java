package bwb;

import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f21271a = 0;

    static {
    }

    public b() {
    }

    public static String c(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        return r100.getClass().getSimpleName() + '@' + Integer.toString(System.identityHashCode(r100), CharsKt.checkRadix(36));
    }

    public static String e(String r100, String r101, String r102) {
        if (r102 != null) goto L4;
    L7:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        String r104 = "[" + r100 + ']';
    L13:
        if (StringsKt.isBlank(r101) == false) goto L16;
        return r104;
    L16:
        return r104 + ' ' + r101;
    L11:
        r104 = r102 + " [" + r100 + ']';
        goto L13
    L4:
        if (StringsKt.isBlank(r102) == true) goto L7;
        r103 = false;
        goto L9
    }

    public static void a(MmUiLogScene r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "functionName");
        Intrinsics.checkNotNullParameter(r102, "message");
        lvb.a.a(r100.getTag(), e(r101, r102, r103));
    }

    public static void d(MmUiLogScene r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "functionName");
        Intrinsics.checkNotNullParameter(r102, "message");
        lvb.a.b(r100.getTag(), e(r101, r102, r103));
    }

    public static void f(MmUiLogScene r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "functionName");
        Intrinsics.checkNotNullParameter(r102, "message");
        lvb.a.e(r100.getTag(), e(r101, r102, r103));
    }

    public static void h(MmUiLogScene r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "functionName");
        Intrinsics.checkNotNullParameter(r102, "message");
        lvb.a.h(r100.getTag(), e(r101, r102, r103));
    }

    public static /* synthetic */ void b(MmUiLogScene r100, String r101, String r102, String r103, int r104) {
        if ((r104 & 4) == 0) goto L6;
        r102 = "";
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        a(r100, r101, r102, r103);
    }

    public static /* synthetic */ void g(MmUiLogScene r100, String r101, String r102, String r103, int r104) {
        if ((r104 & 4) == 0) goto L6;
        r102 = "";
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        f(r100, r101, r102, r103);
    }
}
