package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChannelMemberManagerDialog f134602a;

    public d(ChannelMemberManagerDialog r100) {
        this.f134602a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        ChannelMemberManagerDialog r102 = this.f134602a;
        r102.c1(r102.F, r102.G, r102.H);
    }
}
