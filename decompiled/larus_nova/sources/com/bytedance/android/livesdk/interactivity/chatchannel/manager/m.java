package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import com.bytedance.android.logsdk.format.Spm;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f134310a = null;

    static {
        f134310a = new m();
    }

    public m() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = "failed to get emoji list. message is " + ((Throwable) r100).getMessage();
        int r102 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.f133003a;
        Intrinsics.checkNotNullParameter(r101, "info");
        Spm.Companion.getClass();
        vw2.a.a(Spm.a.a("a100.a100.a314.a999").e().addArg("info", r101), "ChatChannelTracer");
    }
}
