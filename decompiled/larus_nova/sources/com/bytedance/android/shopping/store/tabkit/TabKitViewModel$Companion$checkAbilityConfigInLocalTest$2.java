package com.bytedance.android.shopping.store.tabkit;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "config", "", "key", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class TabKitViewModel$Companion$checkAbilityConfigInLocalTest$2 extends Lambda implements Function2<Object, String, Boolean> {
    public static final TabKitViewModel$Companion$checkAbilityConfigInLocalTest$2 INSTANCE = null;

    static {
        INSTANCE = new TabKitViewModel$Companion$checkAbilityConfigInLocalTest$2();
    }

    public TabKitViewModel$Companion$checkAbilityConfigInLocalTest$2() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "key");
        if ((r100 instanceof TabKitAbilityConfig) == true) goto L5;
        r100 = null;
    L5:
        TabKitAbilityConfig r102 = (TabKitAbilityConfig) r100;
        if (r102 != null) goto L10;
        return false;
    L10:
        return r102.b(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(Object r100, String r101) {
        return Boolean.valueOf(invoke2(r100, r101));
    }
}
