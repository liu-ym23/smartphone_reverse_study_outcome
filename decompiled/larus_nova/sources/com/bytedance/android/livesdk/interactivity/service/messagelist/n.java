package com.bytedance.android.livesdk.interactivity.service.messagelist;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f140909a = null;

    static {
        int[] r100 = new int[IMessageListManager.MessageChangeType.values().length];
        f140909a = r100;
        r100[IMessageListManager.MessageChangeType.INIT_LIST.ordinal()] = 1;
        r100[IMessageListManager.MessageChangeType.INSERT_BOTTOM.ordinal()] = 2;
        r100[IMessageListManager.MessageChangeType.INSERT_ITEM.ordinal()] = 3;
        r100[IMessageListManager.MessageChangeType.RELOAD_ALL.ordinal()] = 4;
        r100[IMessageListManager.MessageChangeType.REMOVE_RANGE.ordinal()] = 5;
    }
}
