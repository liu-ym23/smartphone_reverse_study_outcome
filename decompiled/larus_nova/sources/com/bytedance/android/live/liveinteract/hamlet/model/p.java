package com.bytedance.android.live.liveinteract.hamlet.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/liveinteract/hamlet/model/p;", "", "", ChameleonOpenTracker.Stage.RENDER, "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "setRender", "(Ljava/lang/Integer;)V", "", "Lcom/bytedance/android/live/liveinteract/hamlet/model/k;", "data", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "directing", "b", "setDirecting", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class p {

    @SerializedName("data")
    private List<k> data;

    @SerializedName("directing")
    private Integer directing;

    @SerializedName("r")
    private Integer render;

    public p() {
    }

    public final List<k> a() {
        return this.data;
    }

    public final Integer b() {
        return this.directing;
    }

    public final Integer c() {
        return this.render;
    }
}
