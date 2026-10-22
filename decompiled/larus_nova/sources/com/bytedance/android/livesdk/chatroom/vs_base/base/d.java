package com.bytedance.android.livesdk.chatroom.vs_base.base;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.sdk.widgets.DataCenter;
import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d extends j implements b, h<mm1.a> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f117881e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f117882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f117883g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f117884h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f117885i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final mm1.a f117886j;

    public final String toString() {
        return "com.bytedance.android.livesdk.chatroom.vs_base.base.__ScopeImpl_ReplayFragmentScope";
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.b
    public final FragmentActivity b() {
        return (FragmentActivity) this.f117884h;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.b
    public final int g() {
        Object r100 = this.f117883g;
        if (r100 == null) goto L7;
        return ((Integer) r100).intValue();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.b
    public final Bundle getArguments() {
        return (Bundle) this.f117885i;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.b
    public final DataCenter getDataCenter() {
        Object r100 = this.f117882f;
        if (r100 == null) goto L7;
        return (DataCenter) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.sdk.widgets.DataCenter");
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.b
    public final hq1.a z() {
        Object r100 = this.f117881e;
        if (r100 == null) goto L7;
        return (hq1.a) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.vs_base.base.listener.IReplayPlayFragment");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f117886j;
    }

    public d(mm1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f117886j = r100;
        Object r101 = k.f470908a;
        this.f117881e = r101;
        this.f117882f = r101;
        this.f117883g = r101;
        this.f117884h = r101;
        this.f117885i = r101;
    }
}
