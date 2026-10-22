package com.bytedance.android.live.network.response;

import com.bytedance.android.live.base.model.Extra;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0001R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00028\u00008\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00028\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/network/response/ExtraResponse;", "", "DATA", "Lcom/bytedance/android/live/base/model/Extra;", "EXTRA", "", "logId", "Ljava/lang/String;", "data", "Ljava/lang/Object;", "extra", "Lcom/bytedance/android/live/base/model/Extra;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/network/response/d;", "lib_release"}, k = 1, mv = {1, 4, 0})
public abstract class ExtraResponse<DATA, EXTRA extends Extra> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f83936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f83937b;

    @SerializedName("data")
    public final DATA data;

    @SerializedName("extra")
    public final EXTRA extra;
    public final transient String logId;

    public ExtraResponse() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ExtraResponse(Object r100, Extra r101) {
        this.data = r100;
        this.extra = r101;
        this.logId = "";
        this.f83937b = "";
    }
}
