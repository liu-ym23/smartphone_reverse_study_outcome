package com.bytedance.android.live.revlink.impl.multianchor.dialog;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/MultiLinkConfig;", "", "UNKNOWN", "FORBID_INVITE", "FORBID_APPLY", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MultiLinkConfig extends Enum<MultiLinkConfig> {
    public static final MultiLinkConfig FORBID_APPLY = null;
    public static final MultiLinkConfig FORBID_INVITE = null;
    public static final MultiLinkConfig UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultiLinkConfig[] f93242a = null;

    static {
        MultiLinkConfig r100 = new MultiLinkConfig("UNKNOWN", 0);
        UNKNOWN = r100;
        MultiLinkConfig r101 = new MultiLinkConfig("FORBID_INVITE", 1);
        FORBID_INVITE = r101;
        MultiLinkConfig r102 = new MultiLinkConfig("FORBID_APPLY", 2);
        FORBID_APPLY = r102;
        f93242a = new MultiLinkConfig[]{r100, r101, r102};
    }

    public static MultiLinkConfig valueOf(String r100) {
        return (MultiLinkConfig) r27.a.a(MultiLinkConfig.class, r100);
    }

    public static MultiLinkConfig[] values() {
        return (MultiLinkConfig[]) f93242a.clone();
    }

    public MultiLinkConfig(String r100, int r101) {
        super(r100, r101);
    }
}
