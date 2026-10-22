package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvControlArea$onRoomContextInit$2 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public KtvControlArea$onRoomContextInit$2(l r100) {
        super(1, r100, l.class, "updateControlButtonVisibilityForChallenge", "updateControlButtonVisibilityForChallenge(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100) {
        invoke(r100.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean r100) {
        l r101 = (l) this.receiver;
        int r102 = l.f145814x;
        r101.d(r100);
    }
}
