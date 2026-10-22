package com.bytedance.android.live.revlink.impl.pk.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/utils/AutoMatchSource;", "", "NoneOfMyBusiness", "MaxWaitTimeOut", "PollingEnd", "MatchSuccess", "APIServerError", "APIClientError", "ConnectionInfoInvalid", "ConnectApiFailed", "Manual", "ReceiveReplyWhenMatching", "ReceiveMultiInviteWhenMatching", "ReceiveDoubleInviteWhenMatching", "ReceivePrecisionMatchMsg", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AutoMatchSource extends Enum<AutoMatchSource> {
    public static final AutoMatchSource APIClientError = null;
    public static final AutoMatchSource APIServerError = null;
    public static final AutoMatchSource ConnectApiFailed = null;
    public static final AutoMatchSource ConnectionInfoInvalid = null;
    public static final AutoMatchSource Manual = null;
    public static final AutoMatchSource MatchSuccess = null;
    public static final AutoMatchSource MaxWaitTimeOut = null;
    public static final AutoMatchSource NoneOfMyBusiness = null;
    public static final AutoMatchSource PollingEnd = null;
    public static final AutoMatchSource ReceiveDoubleInviteWhenMatching = null;
    public static final AutoMatchSource ReceiveMultiInviteWhenMatching = null;
    public static final AutoMatchSource ReceivePrecisionMatchMsg = null;
    public static final AutoMatchSource ReceiveReplyWhenMatching = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AutoMatchSource[] f97075a = null;

    static {
        AutoMatchSource r100 = new AutoMatchSource("NoneOfMyBusiness", 0);
        NoneOfMyBusiness = r100;
        AutoMatchSource r101 = new AutoMatchSource("MaxWaitTimeOut", 1);
        MaxWaitTimeOut = r101;
        AutoMatchSource r102 = new AutoMatchSource("PollingEnd", 2);
        PollingEnd = r102;
        AutoMatchSource r103 = new AutoMatchSource("MatchSuccess", 3);
        MatchSuccess = r103;
        AutoMatchSource r104 = new AutoMatchSource("APIServerError", 4);
        APIServerError = r104;
        AutoMatchSource r105 = new AutoMatchSource("APIClientError", 5);
        APIClientError = r105;
        AutoMatchSource r106 = new AutoMatchSource("ConnectionInfoInvalid", 6);
        ConnectionInfoInvalid = r106;
        AutoMatchSource r107 = new AutoMatchSource("ConnectApiFailed", 7);
        ConnectApiFailed = r107;
        AutoMatchSource r108 = new AutoMatchSource("Manual", 8);
        Manual = r108;
        AutoMatchSource r109 = new AutoMatchSource("ReceiveReplyWhenMatching", 9);
        ReceiveReplyWhenMatching = r109;
        AutoMatchSource r110 = new AutoMatchSource("ReceiveMultiInviteWhenMatching", 10);
        ReceiveMultiInviteWhenMatching = r110;
        AutoMatchSource r111 = new AutoMatchSource("ReceiveDoubleInviteWhenMatching", 11);
        ReceiveDoubleInviteWhenMatching = r111;
        AutoMatchSource r112 = new AutoMatchSource("ReceivePrecisionMatchMsg", 12);
        ReceivePrecisionMatchMsg = r112;
        f97075a = new AutoMatchSource[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112};
    }

    public static AutoMatchSource valueOf(String r100) {
        return (AutoMatchSource) r27.a.a(AutoMatchSource.class, r100);
    }

    public static AutoMatchSource[] values() {
        return (AutoMatchSource[]) f97075a.clone();
    }

    public AutoMatchSource(String r100, int r101) {
        super(r100, r101);
    }
}
