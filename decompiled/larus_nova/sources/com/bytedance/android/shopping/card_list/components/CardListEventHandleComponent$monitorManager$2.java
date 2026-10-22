package com.bytedance.android.shopping.card_list.components;

import com.bytedance.android.shopping.card_list.monitor.CardListYataMonitorManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/shopping/card_list/monitor/CardListYataMonitorManager;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class CardListEventHandleComponent$monitorManager$2 extends Lambda implements Function0<CardListYataMonitorManager> {
    final /* synthetic */ h this$0;

    public CardListEventHandleComponent$monitorManager$2(h r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final CardListYataMonitorManager invoke() {
        Map<String, CardListYataMonitorManager> r100 = CardListYataMonitorManager.f171668k;
        h r101 = this.this$0;
        int r102 = h.f171468d;
        r101.getClass();
        return CardListYataMonitorManager.a.a(null);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ CardListYataMonitorManager invoke() {
        return invoke();
    }
}
