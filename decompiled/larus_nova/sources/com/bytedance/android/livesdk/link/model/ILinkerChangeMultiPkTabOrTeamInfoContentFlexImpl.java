package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.im.LinkerChangeMultiPKTeamInfoContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkerChangeMultiPkTabOrTeamInfoContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/y5;", "Lcom/bytedance/android/livesdk/link/model/e7;", "multiPKModeInfo", "Lcom/bytedance/android/livesdk/link/model/e7;", "getMultiPKModeInfo", "()Lcom/bytedance/android/livesdk/link/model/e7;", "setMultiPKModeInfo", "(Lcom/bytedance/android/livesdk/link/model/e7;)V", "", "toast$delegate", "Ljava/lang/Object;", "getToast", "()Ljava/lang/String;", "toast", "", "showModeTab$delegate", "getShowModeTab", "()Ljava/lang/Boolean;", "showModeTab", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkerChangeMultiPkTabOrTeamInfoContentFlexImpl extends FlexModelBase<y5> implements y5, vh7.h {

    @SerializedName("show_mode_tab")
    protected Boolean _$$showModeTab;

    @SerializedName("toast")
    protected String _$$toast;

    @SerializedName("multi_pk_mode_info")
    protected e7 multiPKModeInfo;

    public ILinkerChangeMultiPkTabOrTeamInfoContentFlexImpl() {
        super(y5.class);
        this._$$toast = "";
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.livesdk.link.model.e7, java.lang.Object] */
    public ILinkerChangeMultiPkTabOrTeamInfoContentFlexImpl(am3.g r100) {
        super(y5.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.multiPKModeInfo = vh7.f.a(r100, e7.class);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$toast = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._$$showModeTab = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$toast != null) goto L31;
        this._$$toast = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.y5
    public e7 getMultiPKModeInfo() {
        return this.multiPKModeInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.y5
    public final Boolean getShowModeTab() {
        return this._$$showModeTab;
    }

    @Override // com.bytedance.android.livesdk.link.model.y5
    public final String getToast() {
        return this._$$toast;
    }

    public void setMultiPKModeInfo(e7 r100) {
        this.multiPKModeInfo = r100;
    }
}
