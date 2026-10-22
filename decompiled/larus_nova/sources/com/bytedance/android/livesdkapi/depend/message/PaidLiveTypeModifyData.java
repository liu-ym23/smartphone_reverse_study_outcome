package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeInfo;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.PaidLiveTypeModifyData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/PaidLiveTypeModifyData;", "", "()V", "data", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PrivilegeInfo;", "operatorType", "", "roomId", "", "Companion", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PaidLiveTypeModifyData implements h {
    public static final Companion Companion = null;
    public static final int OPERATE_TYPE_ADD = 1;
    public static final int OPERATE_TYPE_DEL = 3;
    public static final int OPERATE_TYPE_UPD = 2;

    @SerializedName("data")
    public PrivilegeInfo data;

    @SerializedName("operator_type")
    public int operatorType;

    @SerializedName("room_id")
    public long roomId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/PaidLiveTypeModifyData$Companion;", "", "()V", "OPERATE_TYPE_ADD", "", "OPERATE_TYPE_DEL", "OPERATE_TYPE_UPD", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PaidLiveTypeModifyData() {
    }

    public PaidLiveTypeModifyData(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.roomId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.data = new PrivilegeInfo(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.operatorType = r100.i();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
