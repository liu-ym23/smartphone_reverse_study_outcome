package com.bytedance.android.live.revlink.impl.multianchor.connect;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010&\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "K", "V", "<name for destructuring parameter 0>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class AnchorRtcForwardModel$printMap$1 extends Lambda implements Function1<Map.Entry<Object, Object>, CharSequence> {
    public static final AnchorRtcForwardModel$printMap$1 INSTANCE = null;

    static {
        INSTANCE = new AnchorRtcForwardModel$printMap$1();
    }

    public AnchorRtcForwardModel$printMap$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(Map.Entry<Object, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<name for destructuring parameter 0>");
        Object r101 = r100.getKey();
        Object r102 = r100.getValue();
        StringBuilder r103 = new StringBuilder("Key: ");
        String r104 = null;
        if (r101 == null) goto L5;
        String r105 = r101.toString();
    L6:
        r103.append(r105);
        r103.append(" | Value: ");
        if (r102 == null) goto L9;
        r104 = r102.toString();
    L9:
        r103.append(r104);
        return r103.toString();
    L5:
        r105 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<Object, Object> r100) {
        return invoke2(r100);
    }
}
