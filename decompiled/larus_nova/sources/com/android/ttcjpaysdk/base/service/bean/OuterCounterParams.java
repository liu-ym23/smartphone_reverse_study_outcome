package com.android.ttcjpaysdk.base.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/bean/OuterCounterParams;", "Ljava/io/Serializable;", "()V", "dmSessionIdForForeignCard", "", "isIndependentBDCounter", "", "isSceneSourceFromJSBOrIM", "outerAppId", "payAddiTypeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "prePayId", "serverParams", "Lorg/json/JSONObject;", "voucher_show_info_type", "copy", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OuterCounterParams implements Serializable {
    public String dmSessionIdForForeignCard;
    public boolean isIndependentBDCounter;
    public boolean isSceneSourceFromJSBOrIM;
    public String outerAppId;
    public ArrayList<String> payAddiTypeList;
    public String prePayId;
    public JSONObject serverParams;
    public String voucher_show_info_type;

    public final OuterCounterParams copy() {
        OuterCounterParams r100 = new OuterCounterParams();
        r100.outerAppId = this.outerAppId;
        r100.prePayId = this.prePayId;
        r100.isIndependentBDCounter = this.isIndependentBDCounter;
        r100.isSceneSourceFromJSBOrIM = this.isSceneSourceFromJSBOrIM;
        r100.voucher_show_info_type = this.voucher_show_info_type;
        return r100;
    }

    public OuterCounterParams() {
        this.prePayId = "";
        this.outerAppId = "";
        this.voucher_show_info_type = "";
        this.dmSessionIdForForeignCard = "";
    }
}
