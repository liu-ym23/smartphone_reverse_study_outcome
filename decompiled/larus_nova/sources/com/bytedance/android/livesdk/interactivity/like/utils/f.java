package com.bytedance.android.livesdk.interactivity.like.utils;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.message.model.d4;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f137727a = null;

    static {
        f137727a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        d4 r101 = (d4) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        User r102 = r101.b();
        if (r102 == null) goto L5;
        ImageModel r103 = r102.getAvatarThumb();
    L6:
        if (r103 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r103 = null;
        goto L6
    }
}
