package ap6;

import android.os.Looper;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    public static final String a() {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L5;
        return PullConfiguration.PROCESS_NAME_MAIN;
    L5:
        return "others";
    }

    public static final boolean b(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        return !r101;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L10
    }

    public static final Boolean c(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return null;
    L11:
        Locale r102 = Locale.ROOT;
        if (r100 == null) goto L21;
        String r103 = r100.toLowerCase(r102);
        if (Intrinsics.areEqual(r103, "1") == false) goto L17;
        return Boolean.TRUE;
    L17:
        if (Intrinsics.areEqual(r103, "0") == true) goto L19;
        return null;
    L19:
        return Boolean.FALSE;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r101 = false;
        goto L9
    }

    public static final String d(Boolean r100) {
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L5;
        return "1";
    L5:
        return "0";
    }
}
