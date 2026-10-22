package com.bytedance.android.window.shop.eventcard;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001j\u0002`\u00042\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001j\u0002`\u0004¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "", "", "Lcom/bytedance/android/window/shop/eventcard/EventParam;", "p1", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class WindowPageCardBridge$makeJsBridgeMap$2 extends FunctionReferenceImpl implements Function1<Map<String, ? extends Object>, Map<String, ? extends Object>> {
    public WindowPageCardBridge$makeJsBridgeMap$2(WindowPageCardBridge r100) {
        super(1, r100, WindowPageCardBridge.class, "handleDirectJsbEvent", "handleDirectJsbEvent(Ljava/util/Map;)Ljava/util/Map;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<String, Object> invoke2(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        return WindowPageCardBridge.a((WindowPageCardBridge) this.receiver, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Map<String, ? extends Object> invoke(Map<String, ? extends Object> r100) {
        return invoke2(r100);
    }
}
