package com.bytedance.android.livesdk.chatroom.replay.paid.privilegeClarity;

import android.text.TextUtils;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

/* JADX INFO: loaded from: classes7.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayPrivilegeClarityManager f109452a;

    public l(ReplayPrivilegeClarityManager r100) {
        this.f109452a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (TextUtils.equals((CharSequence) ((Pair) r100).getFirst(), "ticket_buy_success") == false) goto L6;
        this.f109452a.j("on js event ticket_buy_success");
        this.f109452a.m();
        return;
    }
}
