package com.android.ttcjpaysdk.integrated.counter.component.lynx;

import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.integrated.counter.component.view.SelectFrom;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0015\u001a\u00020\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/lynx/RefreshInfo;", "", "initData", "Lorg/json/JSONObject;", "selectFrom", "Lcom/android/ttcjpaysdk/integrated/counter/component/view/SelectFrom;", "payTypeChangeInfo", "Lcom/android/ttcjpaysdk/integrated/counter/component/lynx/IPayTypeChangeInfo;", "(Lorg/json/JSONObject;Lcom/android/ttcjpaysdk/integrated/counter/component/view/SelectFrom;Lcom/android/ttcjpaysdk/integrated/counter/component/lynx/IPayTypeChangeInfo;)V", "dialogHeight", "", "getDialogHeight", "()I", "setDialogHeight", "(I)V", "getInitData", "()Lorg/json/JSONObject;", "getPayTypeChangeInfo", "()Lcom/android/ttcjpaysdk/integrated/counter/component/lynx/IPayTypeChangeInfo;", "getSelectFrom", "()Lcom/android/ttcjpaysdk/integrated/counter/component/view/SelectFrom;", CJPayConstant.CJ_PAY_SHARE_PARAMS_KEY_IS_ASSET_STANDARD, "", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RefreshInfo {
    private int dialogHeight;
    private final JSONObject initData;
    private final IPayTypeChangeInfo payTypeChangeInfo;
    private final SelectFrom selectFrom;

    public final boolean isAssetStd() {
        IPayTypeChangeInfo r100 = this.payTypeChangeInfo;
        if (r100 == null) goto L5;
        Boolean r101 = Boolean.valueOf(r100.isAssetStd());
    L6:
        if (r101 != null) goto L10;
        return false;
    L10:
        return r101.booleanValue();
    L5:
        r101 = null;
        goto L6
    }

    public final int getDialogHeight() {
        return this.dialogHeight;
    }

    public final JSONObject getInitData() {
        return this.initData;
    }

    public final IPayTypeChangeInfo getPayTypeChangeInfo() {
        return this.payTypeChangeInfo;
    }

    public final SelectFrom getSelectFrom() {
        return this.selectFrom;
    }

    public final void setDialogHeight(int r100) {
        this.dialogHeight = r100;
    }

    public RefreshInfo(JSONObject r100, SelectFrom r101, IPayTypeChangeInfo r102) {
        Intrinsics.checkNotNullParameter(r101, "selectFrom");
        this.initData = r100;
        this.selectFrom = r101;
        this.payTypeChangeInfo = r102;
        this.dialogHeight = 470;
    }
}
