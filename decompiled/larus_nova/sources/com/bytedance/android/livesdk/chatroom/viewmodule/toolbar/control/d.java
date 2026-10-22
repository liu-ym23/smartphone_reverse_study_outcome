package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control;

import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes8.dex */
public interface d {
    void bindDisposable(Disposable r100);

    void checkDataBeforeShowDialog(a r100);

    boolean hasDynamicData();

    boolean isRequesting();

    void requestData(int r100, Function1<? super Boolean, Unit> r101, Function1<? super Throwable, Unit> r102);
}
