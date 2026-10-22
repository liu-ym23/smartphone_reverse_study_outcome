package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes8.dex */
public final class h implements com.bytedance.android.livesdk.interactivity.api.expression.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f118301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f118302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f118303c;

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final void b() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final void d(String r100, String r101) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final /* synthetic */ void e(com.bytedance.android.live.base.model.message.h r100, String r101) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final /* synthetic */ void f(com.bytedance.android.live.base.model.data.activityemoji.b r100) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final Object g() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final /* synthetic */ void h(com.bytedance.android.livesdk.interactivity.api.emoji.a r100) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final /* synthetic */ void i(String r100) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final void a() {
        this.f118302b.invoke();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final void dismissDialog() {
        this.f118303c.invoke();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final void c(BaseEmoji r100, String r101) {
        this.f118301a.invoke(r100, r101);
    }

    public h(Function2 r100, Function0 r101, Function0 r102) {
        this.f118301a = r100;
        this.f118302b = r101;
        this.f118303c = r102;
    }
}
