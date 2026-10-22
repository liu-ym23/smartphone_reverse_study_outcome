package com.bytedance.android.livehostapi.business.depend.livead.model;

import com.alipay.sdk.m.x.d;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R\u001e\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001e\u0010'\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 R\u001e\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\b¨\u0006."}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampInfo;", "", "()V", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "extra", "getExtra", "setExtra", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "getIcon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setIcon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "id", "getId", "setId", "logExtra", "getLogExtra", "setLogExtra", RuleConditionBean.OPEN_URL_KEY, "getOpenUrl", "setOpenUrl", "status", "", "getStatus", "()I", "setStatus", "(I)V", DocCallbackImpl.KEY_THUMBNAIL, "getThumbnail", "setThumbnail", "title", "getTitle", d.f25925o, "type", "getType", "setType", NativeDownloadModel.JsonKey.WEB_URL, "getWebUrl", "setWebUrl", "Companion", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StampInfo {
    public static final Companion Companion = null;
    private static int STATUS_DEFAULT;
    private static int STATUS_OVER;
    private static int STATUS_START;

    @SerializedName("description")
    private String description;

    @SerializedName("extra")
    private String extra;

    @SerializedName("icon")
    private ImageModel icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f102928id;

    @SerializedName("log_extra")
    private String logExtra;

    @SerializedName("open_url")
    private String openUrl;

    @SerializedName("status")
    private int status;

    @SerializedName(DocCallbackImpl.KEY_THUMBNAIL)
    private ImageModel thumbnail;

    @SerializedName("title")
    private String title;

    @SerializedName("type")
    private int type;

    @SerializedName("web_url")
    private String webUrl;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampInfo$Companion;", "", "()V", "STATUS_DEFAULT", "", "getSTATUS_DEFAULT", "()I", "setSTATUS_DEFAULT", "(I)V", "STATUS_OVER", "getSTATUS_OVER", "setSTATUS_OVER", "STATUS_START", "getSTATUS_START", "setSTATUS_START", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public final int getSTATUS_DEFAULT() {
            return StampInfo.access$getSTATUS_DEFAULT$cp();
        }

        public final int getSTATUS_OVER() {
            return StampInfo.access$getSTATUS_OVER$cp();
        }

        public final int getSTATUS_START() {
            return StampInfo.access$getSTATUS_START$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final void setSTATUS_DEFAULT(int r100) {
            StampInfo.access$setSTATUS_DEFAULT$cp(r100);
        }

        public final void setSTATUS_OVER(int r100) {
            StampInfo.access$setSTATUS_OVER$cp(r100);
        }

        public final void setSTATUS_START(int r100) {
            StampInfo.access$setSTATUS_START$cp(r100);
        }
    }

    static {
        Companion = new Companion(null);
        STATUS_START = 1;
        STATUS_OVER = 2;
    }

    public StampInfo() {
        this.f102928id = "";
        this.title = "";
        this.openUrl = "";
        this.webUrl = "";
        this.description = "";
        this.extra = "";
        this.logExtra = "";
    }

    public static final /* synthetic */ int access$getSTATUS_DEFAULT$cp() {
        return STATUS_DEFAULT;
    }

    public static final /* synthetic */ int access$getSTATUS_OVER$cp() {
        return STATUS_OVER;
    }

    public static final /* synthetic */ int access$getSTATUS_START$cp() {
        return STATUS_START;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final ImageModel getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.f102928id;
    }

    public final String getLogExtra() {
        return this.logExtra;
    }

    public final String getOpenUrl() {
        return this.openUrl;
    }

    public final int getStatus() {
        return this.status;
    }

    public final ImageModel getThumbnail() {
        return this.thumbnail;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public final String getWebUrl() {
        return this.webUrl;
    }

    public static final /* synthetic */ void access$setSTATUS_DEFAULT$cp(int r100) {
        STATUS_DEFAULT = r100;
    }

    public static final /* synthetic */ void access$setSTATUS_OVER$cp(int r100) {
        STATUS_OVER = r100;
    }

    public static final /* synthetic */ void access$setSTATUS_START$cp(int r100) {
        STATUS_START = r100;
    }

    public final void setDescription(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.description = r100;
    }

    public final void setExtra(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extra = r100;
    }

    public final void setIcon(ImageModel r100) {
        this.icon = r100;
    }

    public final void setId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f102928id = r100;
    }

    public final void setLogExtra(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.logExtra = r100;
    }

    public final void setOpenUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.openUrl = r100;
    }

    public final void setStatus(int r100) {
        this.status = r100;
    }

    public final void setThumbnail(ImageModel r100) {
        this.thumbnail = r100;
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.title = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }

    public final void setWebUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.webUrl = r100;
    }
}
