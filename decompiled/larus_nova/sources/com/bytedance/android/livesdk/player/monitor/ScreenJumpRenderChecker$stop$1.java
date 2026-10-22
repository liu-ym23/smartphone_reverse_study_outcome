package com.bytedance.android.livesdk.player.monitor;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ScreenJumpRenderChecker$stop$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ScreenJumpRenderChecker this$0;

    public ScreenJumpRenderChecker$stop$1(ScreenJumpRenderChecker r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.f155813d.f155826a.clear();
        Iterator r100 = ((LinkedHashMap) this.this$0.f155811b).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ScreenJumpRenderChecker.b) ((Map.Entry) r100.next()).getValue()).a();
        goto L4
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
