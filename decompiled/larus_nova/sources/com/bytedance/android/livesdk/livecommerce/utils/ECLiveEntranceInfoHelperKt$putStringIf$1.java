package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "old", "", "new", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ECLiveEntranceInfoHelperKt$putStringIf$1 extends Lambda implements Function2<Object, Object, Boolean> {
    final /* synthetic */ Function2 $condition;

    public ECLiveEntranceInfoHelperKt$putStringIf$1(Function2 r100) {
        this.$condition = r100;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(Object r100, Object r101) {
        return Boolean.valueOf(invoke2(r100, r101));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Object r100, Object r101) {
        if (r100 != null) goto L4;
    L5:
        if (r101 != null) goto L7;
    L11:
        Function2 r102 = this.$condition;
        if ((r100 instanceof String) == true) goto L14;
        r100 = null;
    L14:
        String r103 = (String) r100;
        if ((r101 instanceof String) == true) goto L18;
        r101 = null;
    L18:
        return ((Boolean) r102.invoke(r103, (String) r101)).booleanValue();
    L7:
        if ((r101 instanceof String) == true) goto L11;
        return false;
    L4:
        if ((r100 instanceof String) == true) goto L5;
        return false;
    }
}
