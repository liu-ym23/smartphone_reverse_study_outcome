package com.bytedance.android.livesdkapi.broadcast;

import com.alipay.sdk.m.x.d;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010$\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u001e\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001e\u0010*\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010!\"\u0004\b,\u0010#R\u001e\u0010-\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\b¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdkapi/broadcast/StampInfo;", "", "()V", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "extra", "Lcom/bytedance/android/livesdkapi/broadcast/StampInfoExtra;", "getExtra", "()Lcom/bytedance/android/livesdkapi/broadcast/StampInfoExtra;", "setExtra", "(Lcom/bytedance/android/livesdkapi/broadcast/StampInfoExtra;)V", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "getIcon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setIcon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "id", "getId", "setId", "logExtra", "getLogExtra", "setLogExtra", RuleConditionBean.OPEN_URL_KEY, "getOpenUrl", "setOpenUrl", "status", "", "getStatus", "()I", "setStatus", "(I)V", DocCallbackImpl.KEY_THUMBNAIL, "getThumbnail", "setThumbnail", "title", "getTitle", d.f25925o, "type", "getType", "setType", NativeDownloadModel.JsonKey.WEB_URL, "getWebUrl", "setWebUrl", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StampInfo {

    @SerializedName("description")
    private String description;

    @SerializedName("extra")
    private StampInfoExtra extra;

    @SerializedName("icon")
    private ImageModel icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f162568id;

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

    public StampInfo() {
        this.f162568id = "";
        this.title = "";
        this.openUrl = "";
        this.webUrl = "";
        this.description = "";
        this.logExtra = "";
    }

    public final String getDescription() {
        return this.description;
    }

    public final StampInfoExtra getExtra() {
        return this.extra;
    }

    public final ImageModel getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.f162568id;
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

    public final void setDescription(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.description = r100;
    }

    public final void setExtra(StampInfoExtra r100) {
        this.extra = r100;
    }

    public final void setIcon(ImageModel r100) {
        this.icon = r100;
    }

    public final void setId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f162568id = r100;
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
