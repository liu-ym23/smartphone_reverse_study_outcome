package com.bytedance.android.livesdk.chatroom.ui;

import android.view.View;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes8.dex */
public final class c7 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LandscapeVideoQualityViewHolder f112661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l5 f112662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f112663c;

    public c7(LandscapeVideoQualityViewHolder r100, l5 r101, Function1 r102) {
        this.f112661a = r100;
        this.f112662b = r101;
        this.f112663c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f112661a.T3(this.f112662b);
        this.f112663c.invoke(this.f112662b.f113656b);
    }
}
