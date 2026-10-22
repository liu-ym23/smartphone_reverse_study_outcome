package com.bytedance.android.livesdk.ktvimpl.multichorus.model;

import com.bytedance.android.live.ktv.common.model.api.i0;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\nR(\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\f\u0010\r\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/e;", "", "", "userID", "J", "getUserID", "()J", "setUserID", "(J)V", "getUserID$annotations", "()V", "", "userOpenId", "Ljava/lang/String;", "getUserOpenId", "()Ljava/lang/String;", "setUserOpenId", "(Ljava/lang/String;)V", "getUserOpenId$annotations", "Lcom/bytedance/android/live/ktv/common/model/api/i0;", "multiChorusInfo", "Lcom/bytedance/android/live/ktv/common/model/api/i0;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/live/ktv/common/model/api/i0;", "setMultiChorusInfo", "(Lcom/bytedance/android/live/ktv/common/model/api/i0;)V", "<init>", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class e implements h {

    @SerializedName("multi_chorus_info")
    protected i0 multiChorusInfo;

    @IgnoreProtoFieldCheck
    @SerializedName("user_id")
    protected long userID;

    @IgnoreProtoFieldCheck
    @SerializedName("user_open_id")
    protected String userOpenId;

    public e() {
        this.userOpenId = "";
    }

    public final i0 a() {
        return this.multiChorusInfo;
    }

    public e(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.userID = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.multiChorusInfo = new i0(r100);
        goto L3
    L10:
        if (r102 != 5000) goto L11;
        this.userOpenId = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.userOpenId != null) goto L31;
        this.userOpenId = "";
        return;
    }
}
