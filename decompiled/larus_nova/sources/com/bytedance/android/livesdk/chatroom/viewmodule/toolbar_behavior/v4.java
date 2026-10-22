package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.network.CustomApiServerException;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes8.dex */
public final class v4<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f117439a;

    public v4(Function2 r100) {
        this.f117439a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        ALogger.e("ToolbarShakeMatchBehavior", "updateAudienceSettings fail-> errorInfo: " + r101);
        Function2 r102 = this.f117439a;
        Boolean r103 = Boolean.FALSE;
        if ((r101 instanceof CustomApiServerException) == true) goto L5;
        r101 = null;
    L5:
        r102.invoke(r103, (CustomApiServerException) r101);
    }
}
