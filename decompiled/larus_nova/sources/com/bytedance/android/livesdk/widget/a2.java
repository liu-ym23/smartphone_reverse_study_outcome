package com.bytedance.android.livesdk.widget;

import com.bytedance.android.live.core.log.ALogger;
import com.lynx.tasm.LynxError;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a2<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a2 f161412a = null;

    static {
        f161412a = new a2();
    }

    public a2() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        ALogger.e("MagicGestureActivityAudienceWidget", r101.getMessage());
    }
}
