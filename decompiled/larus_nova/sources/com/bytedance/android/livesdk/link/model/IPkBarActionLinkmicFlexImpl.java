package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.api.linkmic.TipBar.Action")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPkBarActionLinkmicFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/u7;", "Lpy/k;", "actionImg", "Lpy/k;", "getActionImg", "()Lpy/k;", "setActionImg", "(Lpy/k;)V", "", "actionContent$delegate", "Ljava/lang/Object;", "getActionContent", "()Ljava/lang/String;", ReportConstant.COMMON_ACTION_CONTENT, "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IPkBarActionLinkmicFlexImpl extends FlexModelBase<u7> implements u7, vh7.h {

    @SerializedName("action_content")
    protected String _$$actionContent;

    @SerializedName("action_img")
    protected py.k actionImg;

    public IPkBarActionLinkmicFlexImpl() {
        super(u7.class);
        this._$$actionContent = "";
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    public IPkBarActionLinkmicFlexImpl(am3.g r100) {
        super(u7.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$actionContent = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.actionImg = vh7.f.a(r100, py.k.class);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$actionContent != null) goto L25;
        this._$$actionContent = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.u7
    public final String getActionContent() {
        return this._$$actionContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.u7
    public py.k getActionImg() {
        return this.actionImg;
    }

    public void setActionImg(py.k r100) {
        this.actionImg = r100;
    }
}
