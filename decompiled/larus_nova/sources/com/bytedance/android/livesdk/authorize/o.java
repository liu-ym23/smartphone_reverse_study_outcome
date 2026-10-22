package com.bytedance.android.livesdk.authorize;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: classes7.dex */
public final class o<T> implements sy.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f104218a;

    public o(Context r100) {
        this.f104218a = r100;
    }

    @Override // sy.a
    public final void invoke(Object r100) {
        Boolean r101 = (Boolean) r100;
        ALogger.i("NewAuthGuide", "showGuideDialog hasConfirm:" + r101);
        if (r101.booleanValue() == false) goto L5;
        NewAuthGuideManager.b(NewAuthGuideManager.f104175l, this.f104218a, null);
        return;
    L5:
        NewAuthGuideManager.f104175l.e(this.f104218a, null);
    }
}
