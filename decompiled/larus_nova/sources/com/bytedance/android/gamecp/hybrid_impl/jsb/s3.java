package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b%\u0010&R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\tR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/s3;", "", "", "", "imageUrlList", "Ljava/util/List;", "b", "()Ljava/util/List;", "setImageUrlList", "(Ljava/util/List;)V", "originDataList", "getOriginDataList", "setOriginDataList", "", "position", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "setPosition", "(Ljava/lang/Integer;)V", "", "enableRotation", "Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Boolean;", "setEnableRotation", "(Ljava/lang/Boolean;)V", "thumbImageUrlList", "d", "setThumbImageUrlList", "Lcom/bytedance/android/gamecp/hybrid_impl/jsb/s3$a;", "trackerNode", "Lcom/bytedance/android/gamecp/hybrid_impl/jsb/s3$a;", "e", "()Lcom/bytedance/android/gamecp/hybrid_impl/jsb/s3$a;", "setTrackerNode", "(Lcom/bytedance/android/gamecp/hybrid_impl/jsb/s3$a;)V", "<init>", "()V", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s3 {

    @SerializedName("enableRotation")
    private Boolean enableRotation;

    @SerializedName("imageUrlList")
    private List<String> imageUrlList;

    @SerializedName("originDataList")
    private List<String> originDataList;

    @SerializedName("position")
    private Integer position;

    @SerializedName("thumbImageUrlList")
    private List<String> thumbImageUrlList;

    @SerializedName("trackerNode")
    private a trackerNode;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/s3$a;", "", "", "pageName", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setPageName", "(Ljava/lang/String;)V", "Lcom/google/gson/JsonObject;", SlcElement.KEY_ATTR, "Lcom/google/gson/JsonObject;", "b", "()Lcom/google/gson/JsonObject;", "setAttr", "(Lcom/google/gson/JsonObject;)V", "", "action", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "setAction", "(Ljava/lang/Integer;)V", CloudControlInf.ROUTE, "d", "setRoute", "<init>", "()V", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("action")
        private Integer action;

        @SerializedName(SlcElement.KEY_ATTR)
        private JsonObject attr;

        @SerializedName("pageName")
        private String pageName;

        @SerializedName(CloudControlInf.ROUTE)
        private JsonObject route;

        public a() {
        }

        public final Integer a() {
            return this.action;
        }

        public final JsonObject b() {
            return this.attr;
        }

        public final String c() {
            return this.pageName;
        }

        public final JsonObject d() {
            return this.route;
        }
    }

    public s3() {
    }

    public final Boolean a() {
        return this.enableRotation;
    }

    public final List<String> b() {
        return this.imageUrlList;
    }

    public final Integer c() {
        return this.position;
    }

    public final List<String> d() {
        return this.thumbImageUrlList;
    }

    public final a e() {
        return this.trackerNode;
    }
}
