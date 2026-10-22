package com.bytedance.android.livesdk.chatroom.progressbar.highlight;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f107779a;

    public d(c r100) {
        this.f107779a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (Intrinsics.areEqual((Boolean) r100, Boolean.FALSE) == true) goto L5;
        return;
    L5:
        if (this.f107779a.h() == false) goto L9;
        this.f107779a.b();
        return;
    }
}
