package com.bytedance.android.ec.model.response;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ec/model/response/j0;", "", "Lcom/bytedance/android/ec/model/response/ActionType;", ReportConstant.COMMON_ACTION_TYPE, "Lcom/bytedance/android/ec/model/response/ActionType;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/model/response/ActionType;", "Lcom/bytedance/android/ec/model/response/c;", "bizAction", "Lcom/bytedance/android/ec/model/response/c;", "b", "()Lcom/bytedance/android/ec/model/response/c;", "Lcom/bytedance/android/ec/model/response/h0;", "jumpAction", "Lcom/bytedance/android/ec/model/response/h0;", "d", "()Lcom/bytedance/android/ec/model/response/h0;", "Lcom/bytedance/android/ec/model/response/l;", "deferRequestMeta", "Lcom/bytedance/android/ec/model/response/l;", "c", "()Lcom/bytedance/android/ec/model/response/l;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public class j0 {

    @SerializedName("action_type")
    private final ActionType actionType;

    @SerializedName("biz_action")
    private final c bizAction;

    @SerializedName("defer_request_meta")
    private final l deferRequestMeta;

    @SerializedName("jump_action")
    private final h0 jumpAction;

    public j0() {
        this(null, null, 15);
    }

    public final ActionType a() {
        return this.actionType;
    }

    public final c b() {
        return this.bizAction;
    }

    public final l c() {
        return this.deferRequestMeta;
    }

    public final h0 d() {
        return this.jumpAction;
    }

    public j0(ActionType r100, c r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this.actionType = r100;
        this.bizAction = r101;
        this.jumpAction = null;
        this.deferRequestMeta = null;
    }
}
