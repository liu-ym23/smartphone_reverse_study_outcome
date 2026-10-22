package com.bytedance.android.shopping.mall.feed.ability;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "data", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ECMallFeedLynxOpenSchema$registerWhiteBoard$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ lk.c $whiteBoard;
    final /* synthetic */ a this$0;

    public ECMallFeedLynxOpenSchema$registerWhiteBoard$1(a r100, lk.c r101) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object r100) {
        if ((r100 instanceof Map) == true) goto L5;
        r100 = null;
    L5:
        Map r101 = (Map) r100;
        if (r101 == null) goto L22;
        Object r102 = r101.get("schema");
        if ((r102 instanceof String) == true) goto L10;
        r102 = null;
    L10:
        String r103 = (String) r102;
        if (r103 != null) goto L13;
    L16:
        boolean r104 = true;
    L17:
        if (r104 == false) goto L20;
        a r105 = this.this$0;
        int r106 = a.f176853c;
        r105.getClass();
        throw null;
    L20:
        a r107 = this.this$0;
        int r108 = a.f176853c;
        r107.getClass();
        throw null;
    L13:
        if (r103.length() == 0) goto L16;
        r104 = false;
        goto L17
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
