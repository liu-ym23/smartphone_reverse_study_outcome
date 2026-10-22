package com.bytedance.android.livesdk.livecommerce.livereplay.repository;

import com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository.ECReplayScrollProductCardDataSourceFactory;
import com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel;
import kotlin.jvm.internal.Intrinsics;
import nl2.c;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ECScrollProductCardDataSourceFactory f149348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ECReplayScrollProductCardDataSourceFactory f149349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f149350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f149351d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository.a f149352e;

    public a(AbsECScrollProductCardBaseVideModel r100, AbsECScrollProductCardBaseVideModel r101, AbsECScrollProductCardBaseVideModel r102) {
        Intrinsics.checkNotNullParameter(r100, "disposableScope");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "replayCallback");
        this.f149350c = r100;
        this.f149351d = r101;
        this.f149352e = r102;
    }
}
