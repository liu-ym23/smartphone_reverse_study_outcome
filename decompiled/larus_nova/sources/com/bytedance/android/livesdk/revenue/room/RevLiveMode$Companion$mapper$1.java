package com.bytedance.android.livesdk.revenue.room;

import com.bytedance.android.livesdkapi.depend.model.live.ILiveMode;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveMode;", "p1", "Lcom/bytedance/android/livesdk/revenue/room/RevLiveMode;", "Lkotlin/ParameterName;", "name", "revLiveMode", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevLiveMode$Companion$mapper$1 extends FunctionReferenceImpl implements Function1<RevLiveMode, ILiveMode> {
    public RevLiveMode$Companion$mapper$1(com.bytedance.android.livesdk.revenue.service.room.b r100) {
        super(1, r100, com.bytedance.android.livesdk.revenue.service.room.b.class, "mapLiveMode", "mapLiveMode(Lcom/bytedance/android/livesdk/revenue/room/RevLiveMode;)Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveMode;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ILiveMode invoke2(RevLiveMode r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        return ((com.bytedance.android.livesdk.revenue.service.room.b) this.receiver).Ad(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ILiveMode invoke(RevLiveMode r100) {
        return invoke2(r100);
    }
}
