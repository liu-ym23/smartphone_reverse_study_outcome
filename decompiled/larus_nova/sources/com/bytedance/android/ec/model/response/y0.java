package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b(\u0010)R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u000b\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000f¨\u0006*"}, d2 = {"Lcom/bytedance/android/ec/model/response/y0;", "", "", "type", "I", "getType", "()I", "setType", "(I)V", "", "text", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "Lcom/bytedance/android/ec/model/response/t1;", "icon", "Lcom/bytedance/android/ec/model/response/t1;", "c", "()Lcom/bytedance/android/ec/model/response/t1;", "setIcon", "(Lcom/bytedance/android/ec/model/response/t1;)V", "Lcom/bytedance/android/ec/model/response/e0;", "foldableIcon", "Lcom/bytedance/android/ec/model/response/e0;", "b", "()Lcom/bytedance/android/ec/model/response/e0;", "setFoldableIcon", "(Lcom/bytedance/android/ec/model/response/e0;)V", "", "duration", "Ljava/lang/Long;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Long;", "setDuration", "(Ljava/lang/Long;)V", "tag", "d", "setTag", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class y0 {

    @SerializedName("duration")
    private Long duration;

    @SerializedName("foldable_icon")
    private e0 foldableIcon;

    @SerializedName("icon")
    private t1 icon;

    @SerializedName("tag")
    private String tag;

    @SerializedName("text")
    private String text;

    @SerializedName("icon_type")
    private int type;

    public static final class a {
    }

    static {
    }

    public y0() {
    }

    public final Long a() {
        return this.duration;
    }

    public final e0 b() {
        return this.foldableIcon;
    }

    public final t1 c() {
        return this.icon;
    }

    public final String d() {
        return this.tag;
    }

    public final String e() {
        return this.text;
    }

    public final int getType() {
        return this.type;
    }
}
