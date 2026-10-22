package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import com.bytedance.android.live.base.model.user.UserEvent;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class p<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f123980a = null;

    static {
        f123980a = new p();
    }

    public p() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        UserEvent r101 = (UserEvent) r100;
        Intrinsics.checkNotNullParameter(r101, "res");
        if (r101.isLogOut() == false) goto L5;
    L8:
        return true;
    L5:
        if (r101.isLogin() == true) goto L8;
        return false;
    }
}
