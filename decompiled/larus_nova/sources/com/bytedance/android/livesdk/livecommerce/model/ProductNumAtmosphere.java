package com.bytedance.android.livesdk.livecommerce.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("live.ProductNumAtmosphere")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ProductNumAtmosphere;", "", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2UrlPicture;", "leftIcon", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2UrlPicture;", "background", "", "type", "I", "", "num", "Ljava/lang/String;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductNumAtmosphere {
    public static final a Companion = null;

    @SerializedName("background")
    public ECV2UrlPicture background;

    @SerializedName("left_icon")
    public ECV2UrlPicture leftIcon;

    @SerializedName("num")
    public String num;

    @SerializedName("type")
    public int type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ProductNumAtmosphere() {
    }
}
