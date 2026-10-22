package com.bytedance.android.live.pushstream;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Predicate;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class n<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f89417a = null;

    static {
        f89417a = new n();
    }

    public n() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        File r101 = (File) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        ALogger.e("LiveStream", r101.getName());
        if (StringsKt.endsWith$default(r101.getName(), ".so", false, 2, null) == true) goto L5;
        return false;
    L5:
        if (r101.isFile() == false) goto L9;
        return true;
    L9:
        return false;
    }
}
