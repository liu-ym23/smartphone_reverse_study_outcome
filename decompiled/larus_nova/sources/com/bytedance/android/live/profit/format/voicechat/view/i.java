package com.bytedance.android.live.profit.format.voicechat.view;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoiceChatAvatarView f87789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f87790b;

    public i(VoiceChatAvatarView r100, Function0 r101) {
        this.f87789a = r100;
        this.f87790b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Float r101 = (Float) r100;
        CircleProgressView r102 = this.f87789a.f87765c;
        if (r102 == null) goto L6;
        r102.setProgress(r101.floatValue());
    L6:
        if (Intrinsics.areEqual(r101, 0.0f) == false) goto L11;
        this.f87790b.invoke();
        Disposable r103 = this.f87789a.f87767e;
        if (r103 == null) goto L12;
        r103.dispose();
        return;
    L12:
        return;
    }
}
