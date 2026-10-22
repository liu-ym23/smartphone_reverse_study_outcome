package com.bytedance.android.livesdk.gift.platform.business;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "", "Lcom/bytedance/android/livesdk/gift/platform/business/GiftPluginType;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class IGiftPluginKt$panelType2PluginTypeMap$2 extends Lambda implements Function0<Map<Integer, ? extends GiftPluginType>> {
    public static final IGiftPluginKt$panelType2PluginTypeMap$2 INSTANCE = null;

    static {
        INSTANCE = new IGiftPluginKt$panelType2PluginTypeMap$2();
    }

    public IGiftPluginKt$panelType2PluginTypeMap$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Integer, ? extends GiftPluginType> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Integer, ? extends GiftPluginType> invoke2() {
        return MapsKt.mapOf(new Pair[]{new Pair(3, GiftPluginType.TYPE_BANNER), new Pair(5, GiftPluginType.TYPE_RED_PACKET), new Pair(8, GiftPluginType.TYPE_GIFT_RELAY), new Pair(9, GiftPluginType.TYPE_PROP_POPULAR_CARD), new Pair(10, GiftPluginType.TYPE_GIFT_DOODLE), new Pair(11, GiftPluginType.TYPE_GAME_GIFT), new Pair(13, GiftPluginType.TYPE_BLIND_BOX), new Pair(14, GiftPluginType.TYPE_PERIOD_CARD), new Pair(15, GiftPluginType.TYPE_DEFAULT_BANNER), new Pair(16, GiftPluginType.TYPE_INTERACT_GIFT), new Pair(18, GiftPluginType.TYPE_RECHARGE_COUPON)});
    }
}
