package com.bytedance.android.live.profit.fansclub.widget.entrance.data;

import com.bytedance.android.live.profit.fansclub.widget.entrance.facade.EntranceMVIFacade;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import eu0.c0;
import eu0.x;
import j40.k0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"updateFollow", "", "r", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class EntranceDataSource$subscribeEvent$6 extends Lambda implements Function1<IRoom, Unit> {
    final /* synthetic */ i this$0;

    public EntranceDataSource$subscribeEvent$6(i r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "r");
        if (k0.f497249a.getValue().booleanValue() == false) goto L7;
        if (this.this$0.A() == false) goto L7;
        return;
    L7:
        if (this.this$0.A() == false) goto L10;
        return;
    L10:
        if (com.bytedance.android.live.profit.fansclub.i.c() == false) goto L13;
        ((br2.a) vh6.c.b(br2.a.class)).Cc(r100.getOwner(), "EntranceDataSource-subscribeEvent", r100, new AnonymousClass1(this));
        return;
    L13:
        if (this.this$0.A() == false) goto L15;
        return;
    L15:
        boolean r101 = ((br2.a) vh6.c.b(br2.a.class)).Tg(r100.getOwner(), r100);
        EntranceMVIFacade r102 = fu0.b.b(i.a(this.this$0));
        if (r102 == null) goto L24;
        if (r101 == false) goto L19;
        Object r103 = new x(i.a(this.this$0));
    L20:
        r102.a(r103);
        return;
    L19:
        r103 = new c0(i.a(this.this$0));
        goto L20
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(IRoom r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
