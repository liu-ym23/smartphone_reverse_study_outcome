package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.ActivityPKConf")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b+\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR \u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR \u0010'\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R \u0010*\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR \u0010-\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR \u00100\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001e\u00103\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0019\"\u0004\b5\u0010\u001bR \u00106\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR&\u00109\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\r\"\u0004\b;\u0010\u000fR \u0010<\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010!\"\u0004\b>\u0010#R \u0010?\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\b¨\u0006B"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/BattleActivityPKConfig;", "", "()V", "activityName", "", "getActivityName", "()Ljava/lang/String;", "setActivityName", "(Ljava/lang/String;)V", "backgroundImageList", "", "Lcom/bytedance/android/live/base/model/ImageModel;", "getBackgroundImageList", "()Ljava/util/List;", "setBackgroundImageList", "(Ljava/util/List;)V", "displayTabText", "Lcom/bytedance/android/livesdkapi/message/Text;", "getDisplayTabText", "()Lcom/bytedance/android/livesdkapi/message/Text;", "setDisplayTabText", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "endTime", "", "getEndTime", "()J", "setEndTime", "(J)V", "historyPageUrl", "getHistoryPageUrl", "setHistoryPageUrl", "inviteButtonImage", "getInviteButtonImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setInviteButtonImage", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "inviteButtonText", "getInviteButtonText", "setInviteButtonText", "randomButtonImage", "getRandomButtonImage", "setRandomButtonImage", "randomButtonText", "getRandomButtonText", "setRandomButtonText", "rulePageUrl", "getRulePageUrl", "setRulePageUrl", "searchTabText", "getSearchTabText", "setSearchTabText", DyPayConstant.KEY_START_TIME, "getStartTime", "setStartTime", "step", "getStep", "setStep", "tabImageList", "getTabImageList", "setTabImageList", "topRightImage", "getTopRightImage", "setTopRightImage", "topRightUrl", "getTopRightUrl", "setTopRightUrl", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BattleActivityPKConfig implements h {

    @SerializedName("activity_name")
    protected String activityName;

    @SerializedName("back_ground_images")
    protected List<? extends ImageModel> backgroundImageList;

    @SerializedName("display_tab_text")
    protected Text displayTabText;

    @SerializedName("end_time")
    protected long endTime;

    @SerializedName("history_page_url")
    protected String historyPageUrl;

    @SerializedName("invite_battle_button_image")
    protected ImageModel inviteButtonImage;

    @SerializedName("invite_battle_button_text")
    protected String inviteButtonText;

    @SerializedName("random_battle_button_image")
    protected ImageModel randomButtonImage;

    @SerializedName("random_battle_button_text")
    protected String randomButtonText;

    @SerializedName("rule_page_url")
    protected String rulePageUrl;

    @SerializedName("search_tab_text")
    protected String searchTabText;

    @SerializedName(ILoadStallMonitor.START_TIME)
    protected long startTime;

    @SerializedName("step")
    protected String step;

    @SerializedName("display_tab_images")
    protected List<? extends ImageModel> tabImageList;

    @SerializedName("top_right_image")
    protected ImageModel topRightImage;

    @SerializedName("top_right_image_tab_url")
    protected String topRightUrl;

    public BattleActivityPKConfig() {
    }

    public final String getActivityName() {
        return this.activityName;
    }

    public final List<ImageModel> getBackgroundImageList() {
        return this.backgroundImageList;
    }

    public final Text getDisplayTabText() {
        return this.displayTabText;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final String getHistoryPageUrl() {
        return this.historyPageUrl;
    }

    public final ImageModel getInviteButtonImage() {
        return this.inviteButtonImage;
    }

    public final String getInviteButtonText() {
        return this.inviteButtonText;
    }

    public final ImageModel getRandomButtonImage() {
        return this.randomButtonImage;
    }

    public final String getRandomButtonText() {
        return this.randomButtonText;
    }

    public final String getRulePageUrl() {
        return this.rulePageUrl;
    }

    public final String getSearchTabText() {
        return this.searchTabText;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final String getStep() {
        return this.step;
    }

    public final List<ImageModel> getTabImageList() {
        return this.tabImageList;
    }

    public final ImageModel getTopRightImage() {
        return this.topRightImage;
    }

    public final String getTopRightUrl() {
        return this.topRightUrl;
    }

    public BattleActivityPKConfig(g r100) {
        this.tabImageList = new ArrayList();
        this.backgroundImageList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        switch(r102) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L14;
            case 10: goto L13;
            case 11: goto L12;
            case 12: goto L11;
            case 13: goto L10;
            case 14: goto L9;
            case 15: goto L8;
            case 16: goto L7;
            default: goto L6;
        };
    L7:
        this.step = am3.h.c(r100);
        goto L3
    L8:
        this.historyPageUrl = am3.h.c(r100);
        goto L3
    L9:
        this.topRightUrl = am3.h.c(r100);
        goto L3
    L10:
        this.topRightImage = x.a(r100);
        goto L3
    L11:
        List<? extends ImageModel> r103 = this.backgroundImageList;
    L19:
        r103.add(x.a(r100));
        goto L3
    L12:
        this.inviteButtonText = am3.h.c(r100);
        goto L3
    L13:
        this.inviteButtonImage = x.a(r100);
        goto L3
    L14:
        this.randomButtonText = am3.h.c(r100);
        goto L3
    L15:
        this.randomButtonImage = x.a(r100);
        goto L3
    L16:
        this.rulePageUrl = am3.h.c(r100);
        goto L3
    L17:
        this.searchTabText = am3.h.c(r100);
        goto L3
    L18:
        r103 = this.tabImageList;
        goto L19
    L20:
        this.displayTabText = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L21:
        this.endTime = r100.j();
        goto L3
    L22:
        this.startTime = r100.j();
        goto L3
    L23:
        this.activityName = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L24:
        r100.d(r101);
    }

    public final void setActivityName(String r100) {
        this.activityName = r100;
    }

    public final void setBackgroundImageList(List<? extends ImageModel> r100) {
        this.backgroundImageList = r100;
    }

    public final void setDisplayTabText(Text r100) {
        this.displayTabText = r100;
    }

    public final void setEndTime(long r100) {
        this.endTime = r100;
    }

    public final void setHistoryPageUrl(String r100) {
        this.historyPageUrl = r100;
    }

    public final void setInviteButtonImage(ImageModel r100) {
        this.inviteButtonImage = r100;
    }

    public final void setInviteButtonText(String r100) {
        this.inviteButtonText = r100;
    }

    public final void setRandomButtonImage(ImageModel r100) {
        this.randomButtonImage = r100;
    }

    public final void setRandomButtonText(String r100) {
        this.randomButtonText = r100;
    }

    public final void setRulePageUrl(String r100) {
        this.rulePageUrl = r100;
    }

    public final void setSearchTabText(String r100) {
        this.searchTabText = r100;
    }

    public final void setStartTime(long r100) {
        this.startTime = r100;
    }

    public final void setStep(String r100) {
        this.step = r100;
    }

    public final void setTabImageList(List<? extends ImageModel> r100) {
        this.tabImageList = r100;
    }

    public final void setTopRightImage(ImageModel r100) {
        this.topRightImage = r100;
    }

    public final void setTopRightUrl(String r100) {
        this.topRightUrl = r100;
    }
}
