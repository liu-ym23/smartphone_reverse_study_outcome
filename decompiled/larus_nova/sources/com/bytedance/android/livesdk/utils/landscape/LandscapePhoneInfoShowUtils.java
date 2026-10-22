package com.bytedance.android.livesdk.utils.landscape;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class LandscapePhoneInfoShowUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f159059a = null;

    static {
        f159059a = LazyKt.lazy(LandscapePhoneInfoShowUtils$landscapePhoneInfoShowStrategy$2.INSTANCE);
    }

    @JvmStatic
    public static final boolean a(Boolean r100) {
        Lazy r101 = f159059a;
        Integer r102 = (Integer) r101.getValue();
        if (r102 == null) goto L27;
        r102.intValue();
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L13;
        Integer r103 = (Integer) r101.getValue();
        if (r103 != null) goto L10;
        return false;
    L10:
        if (r103.intValue() != 2) goto L25;
        return true;
    L25:
        return false;
    L13:
        Integer r104 = (Integer) r101.getValue();
        if (r104 != null) goto L17;
    L18:
        Integer r105 = (Integer) r101.getValue();
        if (r105 != null) goto L22;
        return false;
    L22:
        if (r105.intValue() != 2) goto L28;
    L23:
        return true;
    L28:
        return false;
    L17:
        if (r104.intValue() == 1) goto L23;
    L27:
        return false;
    }
}
