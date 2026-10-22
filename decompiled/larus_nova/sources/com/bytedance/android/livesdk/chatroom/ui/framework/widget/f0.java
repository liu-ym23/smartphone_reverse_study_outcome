package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.common.utility.Logger;
import com.lynx.tasm.LynxError;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f0 f113338a = null;

    static {
        f113338a = new f0();
    }

    public f0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        Logger.e(r101.getMessage());
    }
}
