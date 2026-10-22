package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.text.TextUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.functions.BiPredicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b2<T1, T2> implements BiPredicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t1.c f135783a;

    public b2(t1.c r100) {
        this.f135783a = r100;
    }

    @Override // io.reactivex.functions.BiPredicate
    public final boolean test(Object r100, Object r101) {
        String r102 = (String) r100;
        String r103 = (String) r101;
        Intrinsics.checkNotNullParameter(r102, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r103, "b");
        t1.c r104 = this.f135783a;
        if (r104.f135985l == false) goto L6;
        r104.f135985l = false;
        return false;
    L6:
        return TextUtils.equals(r102, r103);
    }
}
