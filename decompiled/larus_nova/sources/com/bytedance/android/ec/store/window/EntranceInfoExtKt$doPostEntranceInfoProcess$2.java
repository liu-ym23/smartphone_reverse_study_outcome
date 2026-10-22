package com.bytedance.android.ec.store.window;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "oldValue", "", "newValue", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class EntranceInfoExtKt$doPostEntranceInfoProcess$2 extends Lambda implements Function2<Object, Object, Boolean> {
    public static final EntranceInfoExtKt$doPostEntranceInfoProcess$2 INSTANCE = null;

    static {
        INSTANCE = new EntranceInfoExtKt$doPostEntranceInfoProcess$2();
    }

    public EntranceInfoExtKt$doPostEntranceInfoProcess$2() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(Object r100, Object r101) {
        return Boolean.valueOf(invoke2(r100, r101));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Object r100, Object r101) {
        return !Intrinsics.areEqual(r100, r101);
    }
}
