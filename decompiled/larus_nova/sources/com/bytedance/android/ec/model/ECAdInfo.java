package com.bytedance.android.ec.model;

import java.io.Serializable;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\f\u001a\u00020\rR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/model/ECAdInfo;", "Ljava/io/Serializable;", "cid", "", "logExtra", "", "(Ljava/lang/Long;Ljava/lang/String;)V", "getCid", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLogExtra", "()Ljava/lang/String;", "asJSONDescription", "Lorg/json/JSONObject;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECAdInfo implements Serializable {
    private final Long cid;
    private final String logExtra;

    public final JSONObject asJSONDescription() {
        JSONObject r100 = new JSONObject();
        r100.put("cid", this.cid);
        r100.put("log_extra", this.logExtra);
        return r100;
    }

    public final Long getCid() {
        return this.cid;
    }

    public final String getLogExtra() {
        return this.logExtra;
    }

    public ECAdInfo(Long r100, String r101) {
        this.cid = r100;
        this.logExtra = r101;
    }
}
