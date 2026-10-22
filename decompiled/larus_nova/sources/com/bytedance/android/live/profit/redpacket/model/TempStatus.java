package com.bytedance.android.live.profit.redpacket.model;

import com.bytedance.tools.kcp.aio.runtime.RpcEnum;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@RpcEnum(messageName = "webcast.revenue.biz.luckyBox.TempStatus")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0087\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/model/TempStatus;", "", "", "typeIndex", "I", "getTypeIndex", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "TempStatusUnknown", "TempStatusSingle", "TempStatusHot", "TempStatusCountDown", "TempStatusManualHost", "TempStatusEnter", "TempStatusInterest", "TempStatusBehavior", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum TempStatus extends Enum<TempStatus> {
    public static final a Companion = null;
    public static final TempStatus TempStatusBehavior = null;
    public static final TempStatus TempStatusCountDown = null;
    public static final TempStatus TempStatusEnter = null;
    public static final TempStatus TempStatusHot = null;
    public static final TempStatus TempStatusInterest = null;
    public static final TempStatus TempStatusManualHost = null;
    public static final TempStatus TempStatusSingle = null;
    public static final TempStatus TempStatusUnknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TempStatus[] f88662a = null;
    private final int typeIndex;

    public static TempStatus valueOf(String r100) {
        return (TempStatus) r27.a.a(TempStatus.class, r100);
    }

    public static TempStatus[] values() {
        return (TempStatus[]) f88662a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.profit.redpacket.model.TempStatus$a] */
    static {
        TempStatus r100 = new TempStatus("TempStatusUnknown", 0, 0);
        TempStatusUnknown = r100;
        TempStatus r101 = new TempStatus("TempStatusSingle", 1, 1);
        TempStatusSingle = r101;
        TempStatus r102 = new TempStatus("TempStatusHot", 2, 2);
        TempStatusHot = r102;
        TempStatus r103 = new TempStatus("TempStatusCountDown", 3, 3);
        TempStatusCountDown = r103;
        TempStatus r104 = new TempStatus("TempStatusManualHost", 4, 4);
        TempStatusManualHost = r104;
        TempStatus r105 = new TempStatus("TempStatusEnter", 5, 5);
        TempStatusEnter = r105;
        TempStatus r106 = new TempStatus("TempStatusInterest", 6, 6);
        TempStatusInterest = r106;
        TempStatus r107 = new TempStatus("TempStatusBehavior", 7, 7);
        TempStatusBehavior = r107;
        f88662a = new TempStatus[]{r100, r101, r102, r103, r104, r105, r106, r107};
        Companion = new a();
    }

    public final int getTypeIndex() {
        return this.typeIndex;
    }

    public TempStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.typeIndex = r102;
    }
}
