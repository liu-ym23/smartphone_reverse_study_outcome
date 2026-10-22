package com.bytedance.android.ec.model.response;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECFloatWindowColumnInfo;", "Ljava/io/Serializable;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "", SlcElement.KEY_ELEMENTS, "Ljava/util/List;", "getElements", "()Ljava/util/List;", "setElements", "(Ljava/util/List;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECFloatWindowColumnInfo implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName(SlcElement.KEY_ELEMENTS)
    private List<String> elements;

    @SerializedName("title")
    private String title;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECFloatWindowColumnInfo() {
    }

    public final List<String> getElements() {
        return this.elements;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setElements(List<String> r100) {
        this.elements = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
