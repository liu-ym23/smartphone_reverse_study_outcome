package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f132865a = null;

    static {
        f132865a = new m();
    }

    public m() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, "$this$prompt");
        if ((r101 instanceof CustomApiServerException) == false) goto L9;
        CustomApiServerException r102 = (CustomApiServerException) r101;
        String r103 = r102.getPrompt();
        if (r103 == null) goto L9;
        if ((!StringsKt.isBlank(r103)) != true) goto L9;
        String r104 = r102.getPrompt();
    L10:
        f2.c(r104, 0);
        return;
    L9:
        r104 = null;
        goto L10
    }
}
