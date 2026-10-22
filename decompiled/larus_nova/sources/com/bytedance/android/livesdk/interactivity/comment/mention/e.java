package com.bytedance.android.livesdk.interactivity.comment.mention;

import android.text.TextUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.functions.BiPredicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e<T1, T2> implements BiPredicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f135304a = null;

    static {
        f135304a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.BiPredicate
    public final boolean test(Object r100, Object r101) {
        CharSequence r102 = (CharSequence) r100;
        CharSequence r103 = (CharSequence) r101;
        Intrinsics.checkNotNullParameter(r102, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r103, "b");
        return TextUtils.equals(r102, r103);
    }
}
