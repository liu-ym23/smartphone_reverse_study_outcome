package com.bytedance.android.livesdk.chatroom.ssposter.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b$\u0010%R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR$\u0010!\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001d¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ssposter/model/TicketInfo;", "", "", "stageId", "Ljava/lang/Long;", "getStageId", "()Ljava/lang/Long;", "setStageId", "(Ljava/lang/Long;)V", "contentId", "getContentId", "setContentId", "", "Lcom/bytedance/android/live/base/model/ImageModel;", "backUpImageList", "Ljava/util/List;", "getBackUpImageList", "()Ljava/util/List;", "setBackUpImageList", "(Ljava/util/List;)V", "ticketImgList", "getTicketImgList", "setTicketImgList", "", "schema", "Ljava/lang/String;", "getSchema", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", ThumbGlideUrl.SOURCE_TEMPLATE, "getTemplate", "setTemplate", "shareScene", "getShareScene", "setShareScene", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TicketInfo {
    public static final a Companion = null;
    public static final long TEMPLATE_COMMON = 1;
    public static final long TEMPLATE_SJB = 2;

    @SerializedName("backup_img_list")
    private List<? extends ImageModel> backUpImageList;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID)
    private Long contentId;

    @SerializedName("schema")
    private String schema;

    @SerializedName("share_scene")
    private String shareScene;

    @SerializedName("stage_id")
    private Long stageId;

    @SerializedName(ThumbGlideUrl.SOURCE_TEMPLATE)
    private Long template;

    @SerializedName("pic_img_list")
    private List<? extends ImageModel> ticketImgList;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public TicketInfo() {
    }

    public final List<ImageModel> getBackUpImageList() {
        return this.backUpImageList;
    }

    public final Long getContentId() {
        return this.contentId;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getShareScene() {
        return this.shareScene;
    }

    public final Long getStageId() {
        return this.stageId;
    }

    public final Long getTemplate() {
        return this.template;
    }

    public final List<ImageModel> getTicketImgList() {
        return this.ticketImgList;
    }

    public final void setBackUpImageList(List<? extends ImageModel> r100) {
        this.backUpImageList = r100;
    }

    public final void setContentId(Long r100) {
        this.contentId = r100;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }

    public final void setShareScene(String r100) {
        this.shareScene = r100;
    }

    public final void setStageId(Long r100) {
        this.stageId = r100;
    }

    public final void setTemplate(Long r100) {
        this.template = r100;
    }

    public final void setTicketImgList(List<? extends ImageModel> r100) {
        this.ticketImgList = r100;
    }
}
