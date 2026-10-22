package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR&\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000fR \u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR \u0010'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001e\u0010*\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R \u00100\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\b¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/BattleActivityUser;", "", "()V", "activityName", "", "getActivityName", "()Ljava/lang/String;", "setActivityName", "(Ljava/lang/String;)V", "backgroundList", "", "Lcom/bytedance/android/live/base/model/ImageModel;", "getBackgroundList", "()Ljava/util/List;", "setBackgroundList", "(Ljava/util/List;)V", "buttonImage", "getButtonImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setButtonImage", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "displayTabText", "Lcom/bytedance/android/livesdkapi/message/Text;", "getDisplayTabText", "()Lcom/bytedance/android/livesdkapi/message/Text;", "setDisplayTabText", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "isValid", "", "()Z", "setValid", "(Z)V", "labelList", "Lcom/bytedance/android/livesdkapi/depend/model/live/BattleRivalTag;", "getLabelList", "setLabelList", "reasonMessage", "getReasonMessage", "setReasonMessage", "subTabText", "getSubTabText", "setSubTabText", "userId", "", "getUserId", "()J", "setUserId", "(J)V", "userIdStr", "getUserIdStr", "setUserIdStr", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BattleActivityUser {

    @SerializedName("activity_name")
    private String activityName;

    @SerializedName("back_ground_images")
    private List<? extends ImageModel> backgroundList;

    @SerializedName("button_image")
    private ImageModel buttonImage;

    @SerializedName("display_tab_text")
    private Text displayTabText;

    @SerializedName(LocationMonitorConst.IS_VALID)
    private boolean isValid;

    @SerializedName("labels")
    private List<BattleRivalTag> labelList;

    @SerializedName("message")
    private String reasonMessage;

    @SerializedName("sub_tab_text")
    private String subTabText;

    @SerializedName("user_id")
    private long userId;

    @SerializedName("user_id_str")
    private String userIdStr;

    public BattleActivityUser() {
    }

    public final String getActivityName() {
        return this.activityName;
    }

    public final List<ImageModel> getBackgroundList() {
        return this.backgroundList;
    }

    public final ImageModel getButtonImage() {
        return this.buttonImage;
    }

    public final Text getDisplayTabText() {
        return this.displayTabText;
    }

    public final List<BattleRivalTag> getLabelList() {
        return this.labelList;
    }

    public final String getReasonMessage() {
        return this.reasonMessage;
    }

    public final String getSubTabText() {
        return this.subTabText;
    }

    public final long getUserId() {
        return this.userId;
    }

    public final String getUserIdStr() {
        return this.userIdStr;
    }

    public final boolean isValid() {
        return this.isValid;
    }

    public final void setActivityName(String r100) {
        this.activityName = r100;
    }

    public final void setBackgroundList(List<? extends ImageModel> r100) {
        this.backgroundList = r100;
    }

    public final void setButtonImage(ImageModel r100) {
        this.buttonImage = r100;
    }

    public final void setDisplayTabText(Text r100) {
        this.displayTabText = r100;
    }

    public final void setLabelList(List<BattleRivalTag> r100) {
        this.labelList = r100;
    }

    public final void setReasonMessage(String r100) {
        this.reasonMessage = r100;
    }

    public final void setSubTabText(String r100) {
        this.subTabText = r100;
    }

    public final void setUserId(long r100) {
        this.userId = r100;
    }

    public final void setUserIdStr(String r100) {
        this.userIdStr = r100;
    }

    public final void setValid(boolean r100) {
        this.isValid = r100;
    }
}
