package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.LinkerLowBalanceForPaidLinkmicContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerLowBalanceForPaidLinkmicContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLowBalanceForPaidLinkmicContent;", "()V", "_toast", "", "get_toast", "()Ljava/lang/String;", "set_toast", "(Ljava/lang/String;)V", "toast", "getToast", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkerLowBalanceForPaidLinkmicContent extends FlexModelBase<ILinkerLowBalanceForPaidLinkmicContent> implements ILinkerLowBalanceForPaidLinkmicContent, h {

    @SerializedName("toast")
    protected String _toast;

    public LinkerLowBalanceForPaidLinkmicContent() {
        super(ILinkerLowBalanceForPaidLinkmicContent.class);
    }

    public LinkerLowBalanceForPaidLinkmicContent(g r100) {
        super(ILinkerLowBalanceForPaidLinkmicContent.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this._toast = am3.h.c(r100);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLowBalanceForPaidLinkmicContent
    public String getToast() {
        return this._toast;
    }

    public final String get_toast() {
        return this._toast;
    }

    public final void set_toast(String r100) {
        this._toast = r100;
    }
}
