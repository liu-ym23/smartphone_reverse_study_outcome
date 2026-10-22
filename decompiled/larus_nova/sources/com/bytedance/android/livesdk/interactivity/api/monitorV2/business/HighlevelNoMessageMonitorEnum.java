package com.bytedance.android.livesdk.interactivity.api.monitorV2.business;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitorV2/business/HighlevelNoMessageMonitorEnum;", "", "", "valueNodeName", "Ljava/lang/String;", "getValueNodeName", "()Ljava/lang/String;", "MemberReceiveCount", "MemberDropCount", "MemberFilterCount", "MemberShowCount", "NotifyReceiveCount", "NotifyDropCount", "NotifyFilterCount", "NotifyShowCount", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum HighlevelNoMessageMonitorEnum extends Enum<HighlevelNoMessageMonitorEnum> {
    public static final HighlevelNoMessageMonitorEnum MemberDropCount = null;
    public static final HighlevelNoMessageMonitorEnum MemberFilterCount = null;
    public static final HighlevelNoMessageMonitorEnum MemberReceiveCount = null;
    public static final HighlevelNoMessageMonitorEnum MemberShowCount = null;
    public static final HighlevelNoMessageMonitorEnum NotifyDropCount = null;
    public static final HighlevelNoMessageMonitorEnum NotifyFilterCount = null;
    public static final HighlevelNoMessageMonitorEnum NotifyReceiveCount = null;
    public static final HighlevelNoMessageMonitorEnum NotifyShowCount = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HighlevelNoMessageMonitorEnum[] f133340a = null;
    private final String valueNodeName;

    public static HighlevelNoMessageMonitorEnum valueOf(String r100) {
        return (HighlevelNoMessageMonitorEnum) a.a(HighlevelNoMessageMonitorEnum.class, r100);
    }

    public static HighlevelNoMessageMonitorEnum[] values() {
        return (HighlevelNoMessageMonitorEnum[]) f133340a.clone();
    }

    static {
        HighlevelNoMessageMonitorEnum r100 = new HighlevelNoMessageMonitorEnum("MemberReceiveCount", 0, "member_receive_count");
        MemberReceiveCount = r100;
        HighlevelNoMessageMonitorEnum r101 = new HighlevelNoMessageMonitorEnum("MemberDropCount", 1, "member_drop_count");
        MemberDropCount = r101;
        HighlevelNoMessageMonitorEnum r102 = new HighlevelNoMessageMonitorEnum("MemberFilterCount", 2, "member_filter_count");
        MemberFilterCount = r102;
        HighlevelNoMessageMonitorEnum r103 = new HighlevelNoMessageMonitorEnum("MemberShowCount", 3, "member_show_count");
        MemberShowCount = r103;
        HighlevelNoMessageMonitorEnum r104 = new HighlevelNoMessageMonitorEnum("NotifyReceiveCount", 4, "notify_receive_count");
        NotifyReceiveCount = r104;
        HighlevelNoMessageMonitorEnum r105 = new HighlevelNoMessageMonitorEnum("NotifyDropCount", 5, "notify_drop_count");
        NotifyDropCount = r105;
        HighlevelNoMessageMonitorEnum r106 = new HighlevelNoMessageMonitorEnum("NotifyFilterCount", 6, "notify_filter_count");
        NotifyFilterCount = r106;
        HighlevelNoMessageMonitorEnum r107 = new HighlevelNoMessageMonitorEnum("NotifyShowCount", 7, "notify_show_count");
        NotifyShowCount = r107;
        f133340a = new HighlevelNoMessageMonitorEnum[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public final String getValueNodeName() {
        return this.valueNodeName;
    }

    public HighlevelNoMessageMonitorEnum(String r100, int r101, String r102) {
        super(r100, r101);
        this.valueNodeName = r102;
    }
}
