package com.bytedance.android.ec.model;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR$\u0010 \u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001c¨\u0006%"}, d2 = {"Lcom/bytedance/android/ec/model/o;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "xzgTitle", "Lcom/bytedance/android/ec/model/ECUrlModel;", ce.f26391f, "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setXzgTitle", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "", "xzgLevel", "Ljava/lang/Integer;", "f", "()Ljava/lang/Integer;", "setXzgLevel", "(Ljava/lang/Integer;)V", "xzgLabelLevel", "e", "setXzgLabelLevel", "liveXzgTitle", "c", "setLiveXzgTitle", "", "titleColor", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setTitleColor", "(Ljava/lang/String;)V", "defaultXzgText", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setDefaultXzgText", "liveXzgTextColor", "b", "setLiveXzgTextColor", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class o {

    @SerializedName("default_xzg_text")
    private String defaultXzgText;

    @SerializedName("live_xzg_text_color")
    private String liveXzgTextColor;

    @SerializedName("live_xzg_title")
    private ECUrlModel liveXzgTitle;

    @SerializedName("title_color")
    private String titleColor;

    @SerializedName("xzg_label_level")
    private Integer xzgLabelLevel;

    @SerializedName("xzg_level")
    private Integer xzgLevel;

    @SerializedName("xzg_title")
    private ECUrlModel xzgTitle;

    public o() {
    }

    public final String a() {
        return this.defaultXzgText;
    }

    public final String b() {
        return this.liveXzgTextColor;
    }

    public final ECUrlModel c() {
        return this.liveXzgTitle;
    }

    public final String d() {
        return this.titleColor;
    }

    public final Integer e() {
        return this.xzgLabelLevel;
    }

    public final Integer f() {
        return this.xzgLevel;
    }

    public final ECUrlModel g() {
        return this.xzgTitle;
    }
}
