package com.bytedance.android.live.liveinteract.revenue.linkroomfight.api;

import am3.g;
import com.bytedance.android.livesdk.multilink.base.model.t;
import com.bytedance.android.livesdkapi.depend.model.live.link.IRoomBattleProcessInfo;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/LinkRoomFightInviteResult;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/t;", "Lcom/bytedance/android/livesdkapi/depend/model/live/link/IRoomBattleProcessInfo;", "processStatus", "Lcom/bytedance/android/livesdkapi/depend/model/live/link/IRoomBattleProcessInfo;", "getProcessStatus", "()Lcom/bytedance/android/livesdkapi/depend/model/live/link/IRoomBattleProcessInfo;", "setProcessStatus", "(Lcom/bytedance/android/livesdkapi/depend/model/live/link/IRoomBattleProcessInfo;)V", "", "toast", "Ljava/lang/String;", "getToast", "()Ljava/lang/String;", "setToast", "(Ljava/lang/String;)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkRoomFightInviteResult extends FlexModelBase<t> implements t, h {

    @SerializedName("process_info")
    protected IRoomBattleProcessInfo processStatus;

    @SerializedName("Toast")
    protected String toast;

    public LinkRoomFightInviteResult() {
        super(t.class);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.livesdkapi.depend.model.live.link.IRoomBattleProcessInfo, java.lang.Object] */
    public LinkRoomFightInviteResult(g r100) {
        super(t.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.processStatus = f.a(r100, IRoomBattleProcessInfo.class);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.toast = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.t
    public IRoomBattleProcessInfo getProcessStatus() {
        return this.processStatus;
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.t
    public String getToast() {
        return this.toast;
    }

    public void setProcessStatus(IRoomBattleProcessInfo r100) {
        this.processStatus = r100;
    }

    public void setToast(String r100) {
        this.toast = r100;
    }
}
