package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.data.StampInfo")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0007\u0018\u0000 12\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b/\u00100R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR$\u0010&\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u001e\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\"\u0010)\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u000b\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000fR\"\u0010,\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u000b\u001a\u0004\b-\u0010\r\"\u0004\b.\u0010\u000f¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/StampMessageInfo;", "", "", "type", "I", "getType", "()I", "setType", "(I)V", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "title", "getTitle", com.alipay.sdk.m.x.d.f25925o, RuleConditionBean.OPEN_URL_KEY, "getOpenUrl", "setOpenUrl", NativeDownloadModel.JsonKey.WEB_URL, "getWebUrl", "setWebUrl", "description", "getDescription", "setDescription", "Lcom/bytedance/android/live/base/model/ImageModel;", DocCallbackImpl.KEY_THUMBNAIL, "Lcom/bytedance/android/live/base/model/ImageModel;", "getThumbnail", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setThumbnail", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "status", "getStatus", "setStatus", "icon", "getIcon", "setIcon", "extra", "getExtra", "setExtra", "logExtra", "getLogExtra", "setLogExtra", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StampMessageInfo implements vh7.h {
    public static final a Companion = null;
    public static final String HOST_APP_TAG = "host_app_tag";
    public static final int HOST_APP_TAG_DOUYIN = 1;
    public static final int HOST_APP_TAG_OTHER = 2;

    @SerializedName("description")
    protected String description;

    @SerializedName("extra")
    protected String extra;

    @SerializedName("icon")
    protected ImageModel icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    protected String f153616id;

    @SerializedName("log_extra")
    protected String logExtra;

    @SerializedName("open_url")
    protected String openUrl;

    @SerializedName("status")
    protected int status;

    @SerializedName(DocCallbackImpl.KEY_THUMBNAIL)
    protected ImageModel thumbnail;

    @SerializedName("title")
    protected String title;

    @SerializedName("type")
    protected int type;

    @SerializedName("web_url")
    protected String webUrl;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public StampMessageInfo() {
        this.f153616id = "";
        this.title = "";
        this.openUrl = "";
        this.webUrl = "";
        this.description = "";
        this.extra = "";
        this.logExtra = "";
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
        return this.f153616id;
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

    public StampMessageInfo(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L22;
        if (r102 != 98) goto L8;
        this.extra = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 99) goto L9;
        this.logExtra = am3.h.c(r100);
        goto L3
    L9:
        switch(r102) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            default: goto L10;
        };
    L11:
        this.thumbnail = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L12:
        this.description = am3.h.c(r100);
        goto L3
    L13:
        this.status = r100.i();
        goto L3
    L14:
        this.icon = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L15:
        this.webUrl = am3.h.c(r100);
        goto L3
    L16:
        this.openUrl = am3.h.c(r100);
        goto L3
    L17:
        this.title = am3.h.c(r100);
        goto L3
    L18:
        this.f153616id = am3.h.c(r100);
        goto L3
    L19:
        this.type = r100.i();
        goto L3
    L10:
        am3.h.e(r100);
        goto L3
    L22:
        r100.d(r101);
        if (this.f153616id != null) goto L26;
        this.f153616id = "";
    L26:
        if (this.title != null) goto L29;
        this.title = "";
    L29:
        if (this.openUrl != null) goto L32;
        this.openUrl = "";
    L32:
        if (this.webUrl != null) goto L35;
        this.webUrl = "";
    L35:
        if (this.description != null) goto L38;
        this.description = "";
    L38:
        if (this.extra != null) goto L41;
        this.extra = "";
    L41:
        if (this.logExtra != null) goto L72;
        this.logExtra = "";
        return;
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
        this.f153616id = r100;
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
