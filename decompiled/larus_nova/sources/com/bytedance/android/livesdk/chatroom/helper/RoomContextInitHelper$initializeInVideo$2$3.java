package com.bytedance.android.livesdk.chatroom.helper;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lyz0/o;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lyz0/o;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class RoomContextInitHelper$initializeInVideo$2$3 extends Lambda implements Function1<yz0.o, Unit> {
    public static final RoomContextInitHelper$initializeInVideo$2$3 INSTANCE = null;

    static {
        INSTANCE = new RoomContextInitHelper$initializeInVideo$2$3();
    }

    public RoomContextInitHelper$initializeInVideo$2$3() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(yz0.o r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        r100.n8();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(yz0.o r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
