package com.bytedance.android.livesdk.chatroom.ui;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;

/* JADX INFO: loaded from: classes8.dex */
public final class a6 extends BaseControllerListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DynamicEmojiView f112580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ wj0.b f112581b;

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
    }

    public a6(DynamicEmojiView r100, wj0.b r101) {
        this.f112580a = r100;
        this.f112581b = r101;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        this.f112580a.f112133b.b(new wj0.a.C8118a(this.f112581b));
    }
}
