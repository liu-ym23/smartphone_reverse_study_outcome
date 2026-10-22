package com.stepos.alphame.common.utils;

import com.stepos.alphame.appinfo.AppInfoDbHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u001a\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"PKG_QUICK_APP", "", "PREFIX_PAYMENT_ACTIVITIES", "isPayment", "", AppInfoDbHelper.TAG_U_PACKAGE_NAME, "isQuickApp", "pkg", "common_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppUtilsKt {

    @NotNull
    public static final String PKG_QUICK_APP = "com.stepos.directservice";

    @NotNull
    public static final String PREFIX_PAYMENT_ACTIVITIES = "payment_";

    public static final boolean isPayment(@Nullable String str) {
        return str != null && StringsKt.y(str, "payment_");
    }

    public static final boolean isQuickApp(@NotNull String pkg) {
        Intrinsics.checkNotNullParameter(pkg, "pkg");
        return Intrinsics.areEqual("com.stepos.directservice", pkg);
    }
}
