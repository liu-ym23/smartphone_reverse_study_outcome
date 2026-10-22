package com.bytedance.android.livesdk.interactivity.service.messagelist;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f140888a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f140889b = null;

    static {
        int[] r100 = new int[MessageListScrollManager.ScrollState.values().length];
        f140888a = r100;
        r100[MessageListScrollManager.ScrollState.AutoScroll.ordinal()] = 1;
        r100[MessageListScrollManager.ScrollState.Focus.ordinal()] = 2;
        int[] r101 = new int[IMessageListManager.MessageChangeType.values().length];
        f140889b = r101;
        r101[IMessageListManager.MessageChangeType.INSERT_ITEM.ordinal()] = 1;
        r101[IMessageListManager.MessageChangeType.REMOVE_RANGE.ordinal()] = 2;
    }
}
