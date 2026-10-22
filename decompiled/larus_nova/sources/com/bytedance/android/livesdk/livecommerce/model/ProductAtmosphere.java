package com.bytedance.android.livesdk.livecommerce.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("live.ProductAtmosphere")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ProductAtmosphere;", "", "", "atmosphereType", "I", "Lcom/bytedance/android/livesdk/livecommerce/model/ProductNumAtmosphere;", "numAtmosphere", "Lcom/bytedance/android/livesdk/livecommerce/model/ProductNumAtmosphere;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductAtmosphere {
    public static final a Companion = null;

    @SerializedName("atmosphere_type")
    public int atmosphereType;

    @SerializedName("num_atmosphere")
    public ProductNumAtmosphere numAtmosphere;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ProductAtmosphere() {
    }
}
