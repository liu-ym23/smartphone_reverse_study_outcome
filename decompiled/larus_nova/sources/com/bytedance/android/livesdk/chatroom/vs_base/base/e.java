package com.bytedance.android.livesdk.chatroom.vs_base.base;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.sdk.widgets.DataCenter;
import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e extends j implements c, h<b> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f117887e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f117888f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f117889g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final hq1.a f117890h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DataCenter f117891i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f117892j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final FragmentActivity f117893k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f117894l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f117895m;

    public final String toString() {
        return "com.bytedance.android.livesdk.chatroom.vs_base.base.__ScopeImpl_ReplayInteractionFragmentScope";
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.c
    public final zq1.a E() {
        Object r100 = this.f117887e;
        if (r100 == null) goto L7;
        return (zq1.a) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.vs_base.interact.video.IReplayInteractionFragment");
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.b
    public final int g() {
        Object r100 = this.f117892j;
        if (r100 == null) goto L7;
        return ((Integer) r100).intValue();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.b
    public final Bundle getArguments() {
        return (Bundle) this.f117894l;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.b
    public final DataCenter getDataCenter() {
        DataCenter r100 = this.f117891i;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.sdk.widgets.DataCenter");
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.b
    public final hq1.a z() {
        hq1.a r100 = this.f117890h;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.vs_base.base.listener.IReplayPlayFragment");
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.b
    public final FragmentActivity b() {
        return this.f117893k;
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f117895m;
    }

    public e(b r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f117895m = r100;
        Object r101 = k.f470908a;
        this.f117887e = r101;
        this.f117888f = r101;
        this.f117889g = r101;
        this.f117890h = r100.z();
        this.f117891i = r100.getDataCenter();
        this.f117892j = Integer.valueOf(r100.g());
        this.f117893k = r100.b();
        this.f117894l = r100.getArguments();
    }
}
