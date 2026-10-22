package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.livesdk.chatroom.ui.c9;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes8.dex */
public final class x1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveEndRemindWidget f117674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f117675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f117676c;

    public x1(LiveEndRemindWidget r100, Ref.ObjectRef r101, int r102) {
        this.f117674a = r100;
        this.f117675b = r101;
        this.f117676c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        c9 r102 = this.f117674a.f114980c;
        if (r102 == null) goto L6;
        r102.f112673h.setText(((String) this.f117675b.element) + '(' + ((((long) this.f117676c) - r101.longValue()) - 1) + "s)");
        return;
    }
}
