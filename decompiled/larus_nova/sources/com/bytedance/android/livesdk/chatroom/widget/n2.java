package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.core.log.ALogger;
import com.lynx.tasm.LynxError;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class n2<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n2 f119149a = null;

    static {
        f119149a = new n2();
    }

    public n2() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        ALogger.e("VSAnchorInfoWidget", r101.getMessage());
    }
}
