package com.bytedance.android.live.revlink.impl.pk.utils;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f97089a = null;

    static {
        int[] r100 = new int[AutoMatchSource.values().length];
        f97089a = r100;
        r100[AutoMatchSource.MaxWaitTimeOut.ordinal()] = 1;
        r100[AutoMatchSource.PollingEnd.ordinal()] = 2;
        r100[AutoMatchSource.APIClientError.ordinal()] = 3;
        r100[AutoMatchSource.APIServerError.ordinal()] = 4;
        r100[AutoMatchSource.ConnectionInfoInvalid.ordinal()] = 5;
        r100[AutoMatchSource.ConnectApiFailed.ordinal()] = 6;
        r100[AutoMatchSource.ReceiveReplyWhenMatching.ordinal()] = 7;
        r100[AutoMatchSource.ReceiveMultiInviteWhenMatching.ordinal()] = 8;
        r100[AutoMatchSource.ReceiveDoubleInviteWhenMatching.ordinal()] = 9;
    }
}
