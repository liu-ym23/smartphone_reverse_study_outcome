package com.bytedance.android.ec.model.response;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\"\u0010#R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006&"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECFloatWindowDetailInfo;", "Ljava/io/Serializable;", "", "image", "Ljava/lang/String;", "getImage", "()Ljava/lang/String;", "setImage", "(Ljava/lang/String;)V", "title", "getTitle", com.alipay.sdk.m.x.d.f25925o, "Lcom/bytedance/android/ec/model/ECUrlModel;", "titleImage", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getTitleImage", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setTitleImage", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "", "Lcom/bytedance/android/ec/model/response/ECFloatWindowColumnInfo;", "columnInfos", "Ljava/util/List;", "getColumnInfos", "()Ljava/util/List;", "setColumnInfos", "(Ljava/util/List;)V", "Lcom/bytedance/android/ec/model/response/ECFloatWindowColumnLayout;", "layout", "Lcom/bytedance/android/ec/model/response/ECFloatWindowColumnLayout;", "getLayout", "()Lcom/bytedance/android/ec/model/response/ECFloatWindowColumnLayout;", "setLayout", "(Lcom/bytedance/android/ec/model/response/ECFloatWindowColumnLayout;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECFloatWindowDetailInfo implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("column_infos")
    private List<ECFloatWindowColumnInfo> columnInfos;

    @SerializedName("image")
    private String image;

    @SerializedName("layout")
    private ECFloatWindowColumnLayout layout;

    @SerializedName("title")
    private String title;

    @SerializedName("title_image")
    private ECUrlModel titleImage;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECFloatWindowDetailInfo() {
        this.layout = new ECFloatWindowColumnLayout();
    }

    public final List<ECFloatWindowColumnInfo> getColumnInfos() {
        return this.columnInfos;
    }

    public final String getImage() {
        return this.image;
    }

    public final ECFloatWindowColumnLayout getLayout() {
        return this.layout;
    }

    public final String getTitle() {
        return this.title;
    }

    public final ECUrlModel getTitleImage() {
        return this.titleImage;
    }

    public final void setColumnInfos(List<ECFloatWindowColumnInfo> r100) {
        this.columnInfos = r100;
    }

    public final void setImage(String r100) {
        this.image = r100;
    }

    public final void setLayout(ECFloatWindowColumnLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.layout = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setTitleImage(ECUrlModel r100) {
        this.titleImage = r100;
    }
}
