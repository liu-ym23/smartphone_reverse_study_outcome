package bv6;

import com.bytedance.android.ec.slice.SliceInitService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f20946a = 0;

    static {
    }

    public static boolean a(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(r100, SliceInitService.DEFAULT_SWITCH) == false) goto L14;
        return false;
    L14:
        return true;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }
}
