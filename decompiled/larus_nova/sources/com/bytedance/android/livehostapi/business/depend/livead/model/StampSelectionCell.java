package com.bytedance.android.livehostapi.business.depend.livead.model;

import com.alipay.sdk.m.x.d;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampSelectionCell;", "", "()V", "extra", "", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "getIcon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setIcon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "id", "getId", "setId", a.KEY_SCHEMA_URL, "getSchema_url", "setSchema_url", "subtitle", "getSubtitle", "setSubtitle", "title", "getTitle", d.f25925o, "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StampSelectionCell {

    @SerializedName("extra")
    private String extra;

    @SerializedName("icon")
    private ImageModel icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f102931id;

    @SerializedName(a.KEY_SCHEMA_URL)
    private String schema_url;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    private String subtitle;

    @SerializedName("title")
    private String title;

    public StampSelectionCell() {
        this.f102931id = "";
        this.title = "";
        this.subtitle = "";
        this.schema_url = "";
        this.extra = "";
    }

    public final String getExtra() {
        return this.extra;
    }

    public final ImageModel getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.f102931id;
    }

    public final String getSchema_url() {
        return this.schema_url;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
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
        this.f102931id = r100;
    }

    public final void setSchema_url(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.schema_url = r100;
    }

    public final void setSubtitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.subtitle = r100;
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.title = r100;
    }
}
