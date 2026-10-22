package com.bytedance.android.livesdk.chatroom.model.interact;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/OrderSingItemAction;", "", "", "value", "I", "getValue", "()I", "ORDER_SING_ACTION_UNKNOWN", "ORDER_SING_START_ITEM", "ORDER_SING_END_ITEM", "ORDER_SING_PIN_ITEM", "ORDER_SING_DEL_ITEM", "ORDER_SING_DEL_ALL_ITEM", "ORDER_SING_ADD_ITEM", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum OrderSingItemAction extends Enum<OrderSingItemAction> {
    public static final OrderSingItemAction ORDER_SING_ACTION_UNKNOWN = null;
    public static final OrderSingItemAction ORDER_SING_ADD_ITEM = null;
    public static final OrderSingItemAction ORDER_SING_DEL_ALL_ITEM = null;
    public static final OrderSingItemAction ORDER_SING_DEL_ITEM = null;
    public static final OrderSingItemAction ORDER_SING_END_ITEM = null;
    public static final OrderSingItemAction ORDER_SING_PIN_ITEM = null;
    public static final OrderSingItemAction ORDER_SING_START_ITEM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OrderSingItemAction[] f106936a = null;
    private final int value;

    static {
        OrderSingItemAction r100 = new OrderSingItemAction("ORDER_SING_ACTION_UNKNOWN", 0, 0);
        ORDER_SING_ACTION_UNKNOWN = r100;
        OrderSingItemAction r101 = new OrderSingItemAction("ORDER_SING_START_ITEM", 1, 1);
        ORDER_SING_START_ITEM = r101;
        OrderSingItemAction r102 = new OrderSingItemAction("ORDER_SING_END_ITEM", 2, 2);
        ORDER_SING_END_ITEM = r102;
        OrderSingItemAction r103 = new OrderSingItemAction("ORDER_SING_PIN_ITEM", 3, 3);
        ORDER_SING_PIN_ITEM = r103;
        OrderSingItemAction r104 = new OrderSingItemAction("ORDER_SING_DEL_ITEM", 4, 4);
        ORDER_SING_DEL_ITEM = r104;
        OrderSingItemAction r105 = new OrderSingItemAction("ORDER_SING_DEL_ALL_ITEM", 5, 5);
        ORDER_SING_DEL_ALL_ITEM = r105;
        OrderSingItemAction r106 = new OrderSingItemAction("ORDER_SING_ADD_ITEM", 6, 6);
        ORDER_SING_ADD_ITEM = r106;
        f106936a = new OrderSingItemAction[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static OrderSingItemAction valueOf(String r100) {
        return (OrderSingItemAction) r27.a.a(OrderSingItemAction.class, r100);
    }

    public static OrderSingItemAction[] values() {
        return (OrderSingItemAction[]) f106936a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public OrderSingItemAction(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
