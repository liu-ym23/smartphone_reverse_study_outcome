package com.bytedance.android.ec.model.response;

import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bD\u0010EJ\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00103\u001a\u00020,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u0010;\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R0\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010<8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006F"}, d2 = {"Lcom/bytedance/android/ec/model/response/IconItem;", "Ljava/io/Serializable;", "", "getUniqueKey", "businessKey", "Ljava/lang/String;", "getBusinessKey", "()Ljava/lang/String;", "setBusinessKey", "(Ljava/lang/String;)V", "iconKey", "getIconKey", "setIconKey", "animatedIcon", "getAnimatedIcon", "setAnimatedIcon", "Lcom/bytedance/android/ec/model/response/IconShowStrategy;", "showStrategy", "Lcom/bytedance/android/ec/model/response/IconShowStrategy;", "getShowStrategy", "()Lcom/bytedance/android/ec/model/response/IconShowStrategy;", "setShowStrategy", "(Lcom/bytedance/android/ec/model/response/IconShowStrategy;)V", "Lcom/bytedance/android/ec/model/response/LottieIconData;", "lottieIcon", "Lcom/bytedance/android/ec/model/response/LottieIconData;", "getLottieIcon", "()Lcom/bytedance/android/ec/model/response/LottieIconData;", "setLottieIcon", "(Lcom/bytedance/android/ec/model/response/LottieIconData;)V", "Lcom/bytedance/android/ec/model/response/RelatedAction;", "relatedAction", "Lcom/bytedance/android/ec/model/response/RelatedAction;", "getRelatedAction", "()Lcom/bytedance/android/ec/model/response/RelatedAction;", "setRelatedAction", "(Lcom/bytedance/android/ec/model/response/RelatedAction;)V", "", "priority", "I", "getPriority", "()I", "setPriority", "(I)V", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getSkip", "()Z", "setSkip", "(Z)V", "skip", "Lcom/bytedance/android/ec/model/response/LocalIconState;", "b", "Lcom/bytedance/android/ec/model/response/LocalIconState;", "getLocalIconState", "()Lcom/bytedance/android/ec/model/response/LocalIconState;", "setLocalIconState", "(Lcom/bytedance/android/ec/model/response/LocalIconState;)V", "localIconState", "", "c", "Ljava/util/Map;", "getReportParams", "()Ljava/util/Map;", "setReportParams", "(Ljava/util/Map;)V", "reportParams", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class IconItem implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient boolean f47908a;

    @SerializedName("animated_icon")
    private String animatedIcon;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient LocalIconState f47909b;

    @SerializedName(SpeechEngineDefines.PARAMS_KEY_BUSINESS_KEY_STRING)
    private String businessKey;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient Map<String, String> f47910c;

    @SerializedName("icon_key")
    private String iconKey;

    @SerializedName("lottie_icon")
    private LottieIconData lottieIcon;

    @SerializedName("priority")
    private int priority;

    @SerializedName("related_action")
    private RelatedAction relatedAction;

    @SerializedName("show_strategy")
    private IconShowStrategy showStrategy;

    public final String getUniqueKey() {
        StringBuilder r100 = new StringBuilder();
        String r101 = this.businessKey;
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.append(r101);
        r100.append('_');
        String r103 = this.iconKey;
        if (r103 == null) goto L9;
        r102 = r103;
    L9:
        r100.append(r102);
        return r100.toString();
    }

    public IconItem() {
        this.priority = Integer.MAX_VALUE;
    }

    public final String getAnimatedIcon() {
        return this.animatedIcon;
    }

    public final String getBusinessKey() {
        return this.businessKey;
    }

    public final String getIconKey() {
        return this.iconKey;
    }

    public final LocalIconState getLocalIconState() {
        return this.f47909b;
    }

    public final LottieIconData getLottieIcon() {
        return this.lottieIcon;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final RelatedAction getRelatedAction() {
        return this.relatedAction;
    }

    public final Map<String, String> getReportParams() {
        return this.f47910c;
    }

    public final IconShowStrategy getShowStrategy() {
        return this.showStrategy;
    }

    public final boolean getSkip() {
        return this.f47908a;
    }

    public final void setAnimatedIcon(String r100) {
        this.animatedIcon = r100;
    }

    public final void setBusinessKey(String r100) {
        this.businessKey = r100;
    }

    public final void setIconKey(String r100) {
        this.iconKey = r100;
    }

    public final void setLocalIconState(LocalIconState r100) {
        this.f47909b = r100;
    }

    public final void setLottieIcon(LottieIconData r100) {
        this.lottieIcon = r100;
    }

    public final void setPriority(int r100) {
        this.priority = r100;
    }

    public final void setRelatedAction(RelatedAction r100) {
        this.relatedAction = r100;
    }

    public final void setReportParams(Map<String, String> r100) {
        this.f47910c = r100;
    }

    public final void setShowStrategy(IconShowStrategy r100) {
        this.showStrategy = r100;
    }

    public final void setSkip(boolean r100) {
        this.f47908a = r100;
    }
}
