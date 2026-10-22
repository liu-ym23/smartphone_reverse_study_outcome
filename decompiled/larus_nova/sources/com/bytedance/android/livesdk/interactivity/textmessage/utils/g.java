package com.bytedance.android.livesdk.interactivity.textmessage.utils;

import com.ss.android.ugc.effectmanager.IFetchResourceListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements IFetchResourceListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f.a f141231a;

    public g(com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival.c r100) {
        this.f141231a = r100;
    }

    @Override // com.ss.android.ugc.effectmanager.IFetchResourceListener
    public final void onFailure(Exception r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        this.f141231a.onFailure();
    }

    @Override // com.ss.android.ugc.effectmanager.IFetchResourceListener
    public final void onSuccess(long r100) {
        this.f141231a.onSuccess();
    }
}
