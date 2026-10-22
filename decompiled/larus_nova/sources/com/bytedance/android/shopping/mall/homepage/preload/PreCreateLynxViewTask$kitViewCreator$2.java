package com.bytedance.android.shopping.mall.homepage.preload;

import com.bytedance.android.ec.hybrid.card.cache.view.KitViewCreatorImpl;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/ec/hybrid/card/cache/view/KitViewCreatorImpl;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class PreCreateLynxViewTask$kitViewCreator$2 extends Lambda implements Function0<KitViewCreatorImpl> {
    public static final PreCreateLynxViewTask$kitViewCreator$2 INSTANCE = null;

    static {
        INSTANCE = new PreCreateLynxViewTask$kitViewCreator$2();
    }

    public PreCreateLynxViewTask$kitViewCreator$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final KitViewCreatorImpl invoke() {
        return new KitViewCreatorImpl();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ KitViewCreatorImpl invoke() {
        return invoke();
    }
}
