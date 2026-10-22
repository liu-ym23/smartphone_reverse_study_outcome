package com.bytedance.android.livesdkapi.depend.message;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/MultiLinkMessageMethods;", "", "()V", "LINKMIC_ANNOUNCE_METHOD", "", "getLINKMIC_ANNOUNCE_METHOD", "()Ljava/lang/String;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkMessageMethods {
    public static final MultiLinkMessageMethods INSTANCE = null;
    private static final String LINKMIC_ANNOUNCE_METHOD = null;

    private MultiLinkMessageMethods() {
    }

    static {
        INSTANCE = new MultiLinkMessageMethods();
        LINKMIC_ANNOUNCE_METHOD = "WebcastOpenLinkmicAnnounceMessage";
    }

    public final String getLINKMIC_ANNOUNCE_METHOD() {
        return LINKMIC_ANNOUNCE_METHOD;
    }
}
