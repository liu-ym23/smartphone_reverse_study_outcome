package com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea;

import com.bytedance.android.shopping.api.mall.common.tools.p;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class BadgeController$toolBadgeFilter$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.ObjectRef $clickedBadge;
    final /* synthetic */ String $storageJSONStr;

    public BadgeController$toolBadgeFilter$2$1(Ref.ObjectRef r100, String r101) {
        this.$clickedBadge = r100;
        this.$storageJSONStr = r101;
        super(0);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea.BadgeStorageStruct] */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Ref.ObjectRef r100 = this.$clickedBadge;
        r100.element = (BadgeStorageStruct) GsonProtectorUtils.fromJson(p.b(), this.$storageJSONStr, BadgeStorageStruct.class);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
