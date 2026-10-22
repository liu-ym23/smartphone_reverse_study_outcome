package com.bytedance.android.livesdk.chatroom.vsplayer.model;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes8.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VSSeekBarMarkRepelStack f118434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f118435b;

    public f(VSSeekBarMarkRepelStack r100, Function2 r101) {
        this.f118434a = r100;
        this.f118435b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        VSSeekBarMarkRepelStack r101 = (VSSeekBarMarkRepelStack) r100;
        Function2 r102 = this.f118435b;
        VSSeekBarMarkRepelStack r103 = this.f118434a;
        r102.invoke(r103, r103.f118394a);
    }
}
