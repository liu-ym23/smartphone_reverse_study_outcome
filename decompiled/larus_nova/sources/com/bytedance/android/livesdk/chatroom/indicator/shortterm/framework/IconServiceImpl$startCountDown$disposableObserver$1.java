package com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "STATE", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class IconServiceImpl$startCountDown$disposableObserver$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public IconServiceImpl$startCountDown$disposableObserver$1(PublishSubject r100) {
        super(0, r100, PublishSubject.class, "onComplete", "onComplete()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((PublishSubject) this.receiver).onComplete();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
