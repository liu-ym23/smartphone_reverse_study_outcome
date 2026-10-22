package com.bytedance.android.livesdk.livecommerce.room;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012:\u0010\u0002\u001a6\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003j\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u0006`\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "it", "", "Lkotlin/Pair;", "", "", "Lcom/bytedance/revenue/platform/api/core/Entry;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ControllerCache$removeController$1 extends Lambda implements Function1<Map.Entry<? extends Pair<? extends String, ? extends String>, ? extends Object>, Boolean> {
    final /* synthetic */ String $roomId;
    final /* synthetic */ String $uniqueKey;

    public ControllerCache$removeController$1(String r100, String r101) {
        this.$roomId = r100;
        this.$uniqueKey = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Map.Entry<Pair<String, String>, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        if (Intrinsics.areEqual(r100.getKey().getFirst(), this.$roomId) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r100.getKey().getSecond(), this.$uniqueKey) == false) goto L7;
        return true;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Map.Entry<? extends Pair<? extends String, ? extends String>, ? extends Object> r100) {
        return Boolean.valueOf(invoke2(r100));
    }
}
