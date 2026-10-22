package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/model/response/n0;", "", "", "text", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "color", "b", "setColor", "", CommodityText.BOLD, "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setBold", "(Z)V", "showStrikeThrough", "Ljava/lang/Boolean;", "getShowStrikeThrough", "()Ljava/lang/Boolean;", "setShowStrikeThrough", "(Ljava/lang/Boolean;)V", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class n0 {

    @SerializedName(CommodityText.BOLD)
    private boolean bold;

    @SerializedName("color")
    private String color;

    @SerializedName("show_strike_through")
    private Boolean showStrikeThrough;

    @SerializedName("text")
    private String text;

    public n0() {
    }

    public final boolean a() {
        return this.bold;
    }

    public final String b() {
        return this.color;
    }

    public final String c() {
        return this.text;
    }

    public final void d(String r100) {
        this.text = r100;
    }
}
