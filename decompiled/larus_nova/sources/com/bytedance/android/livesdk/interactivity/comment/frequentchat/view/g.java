package com.bytedance.android.livesdk.interactivity.comment.frequentchat.view;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f134977a = null;

    static {
        f134977a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        int r102 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.b.f134926a;
        Intrinsics.checkNotNullParameter("recommend", "scene");
        String r103 = "";
        Intrinsics.checkNotNullParameter("", "defaultPrompt");
        if (r101 == null) goto L8;
        String r104 = ga2.e.a(r101);
        if (r104 == null) goto L8;
        r103 = r104;
    L8:
        ALogger.e("FrequentChatApi", "recommend Api Error: ".concat(r103));
    }
}
