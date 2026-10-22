package com.bytedance.android.livesdk.ktvimpl.realtimechorus.grouplive;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f146594a;

    public e(Context r100) {
        this.f146594a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        ALogger.e("GroupLiveGameInviteUtils", "inviteFriends failed", r101);
        ExceptionUtils.handleException(this.f146594a, r101);
    }
}
