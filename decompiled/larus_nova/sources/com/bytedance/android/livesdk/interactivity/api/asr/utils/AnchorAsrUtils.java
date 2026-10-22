package com.bytedance.android.livesdk.interactivity.api.asr.utils;

import com.bytedance.android.livesdk.interactivity.api.f;
import com.bytedance.android.livesdk.interactivity.api.o;
import com.bytedance.live.datacontext.j;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class AnchorAsrUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f132879a = 0;

    @JvmStatic
    public static final l22.e b() {
        f r100 = o.b();
        if (r100 == null) goto L9;
        j<l22.a> r101 = r100.getAnchorAsrContext();
        if (r101 == null) goto L9;
        l22.a r102 = r101.getValue();
        if (r102 == null) goto L9;
        return r102.getUserActionCollector();
    L9:
        return null;
    }

    static {
    }

    @JvmStatic
    @CheckReturnValue
    public static final Disposable a(final Function1<? super l22.c, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        f r101 = o.b();
        if (r101 == null) goto L7;
        j<l22.a> r102 = r101.getAnchorAsrContext();
        if (r102 == null) goto L7;
        return n32.a.a(r102, new AnchorAsrUtils$useAsrManager$1(r100));
    L7:
        return null;
    }
}
