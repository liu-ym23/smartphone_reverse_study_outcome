package com.byted.cast.common.api.pin;

import com.byted.cast.common.source.ServiceInfo;

/* JADX INFO: loaded from: classes39.dex */
public interface IServiceInfoParseListener {
    public static final int PARSE_FAILURE_AUTHENTICATION_FAILED = 40006;
    public static final int PARSE_FAILURE_CONNECT_TIMEOUT = 40005;
    public static final int PARSE_FAILURE_NO_AGREEMENT_AVAILABLE = 40003;
    public static final int PARSE_FAILURE_PARSE_BEAN = 40004;
    public static final int PARSE_FAILURE_PRIVATE_CHANNEL_DIFF = 40001;
    public static final int PARSE_FAILURE_REMOTE = 40002;
    public static final int PARSE_SUCCESS = 40000;

    void onParseResult(int r100, ServiceInfo r101);
}
