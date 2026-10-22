package com.bytedance.android.shopping.store.slicecard;

import com.bytedance.android.shopping.store.slicecard.dto.ShopSliceItemConfig;
import com.bytedance.android.shopping.store.slicecard.dto.SliceTemplate;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/shopping/store/slicecard/dto/SliceTemplate;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ShopSlcCardFactory$createTopHeaderCard$1 extends Lambda implements Function0<SliceTemplate> {
    final /* synthetic */ String $remoteTemplateName;

    public ShopSlcCardFactory$createTopHeaderCard$1(String r100) {
        this.$remoteTemplateName = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SliceTemplate invoke() {
        com.bytedance.android.ec.store.setting.j r100 = ShopSlcTemplateManager.f186315a;
        String r101 = this.$remoteTemplateName;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        Object r103 = null;
        if (r102 == true) goto L26;
        ShopSliceItemConfig r104 = ShopSlcTemplateManager.f186323i.get(SliceItemType.SHOP_PROFILE_CONCISE.getType());
        if (r104 == null) goto L25;
        Iterator<T> r105 = r104.getTemplates().iterator();
    L16:
        if (r105.hasNext() == false) goto L21;
        Object r106 = r105.next();
        if (Intrinsics.areEqual(((SliceTemplate) r106).getName(), r101) == false) goto L16;
        r103 = r106;
    L21:
        return (SliceTemplate) r103;
    L25:
        return null;
    L26:
        return null;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ SliceTemplate invoke() {
        return invoke();
    }
}
