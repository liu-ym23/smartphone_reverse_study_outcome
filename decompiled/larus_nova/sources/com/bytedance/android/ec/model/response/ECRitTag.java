package com.bytedance.android.ec.model.response;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.RitTagTrack;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b5\b\u0086\b\u0018\u0000 \u0082\u00012\u00020\u0001:\u0002\u0083\u0001B\u0087\u0003\u0012\b\b\u0002\u0010-\u001a\u00020\u0002\u0012\b\b\u0002\u0010.\u001a\u00020\u000b\u0012\b\b\u0002\u0010/\u001a\u00020\u000b\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u00103\u001a\u00020\u0002\u0012\b\b\u0002\u00104\u001a\u00020\u000b\u0012\b\b\u0002\u00105\u001a\u00020\u000b\u0012\b\b\u0002\u00106\u001a\u00020\u000b\u0012\b\b\u0002\u00107\u001a\u00020\u000b\u0012\b\b\u0002\u00108\u001a\u00020\u0005\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001a\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010 \u0012\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001a\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010$\u0012\u0016\b\u0002\u0010D\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010$\u0012\u0010\b\u0002\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u001a\u0012\b\b\u0002\u0010F\u001a\u00020\u0005\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010H\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010$\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010+¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\b\u0010\t\u001a\u0004\u0018\u00010\bJ\t\u0010\n\u001a\u00020\u0002HÆ\u0003J\t\u0010\f\u001a\u00020\u000bHÆ\u0003J\t\u0010\r\u001a\u00020\u000bHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0012\u001a\u00020\u000bHÆ\u0003J\t\u0010\u0013\u001a\u00020\u000bHÆ\u0003J\t\u0010\u0014\u001a\u00020\u000bHÆ\u0003J\t\u0010\u0015\u001a\u00020\u000bHÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001aHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010 HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001aHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0017\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010$HÆ\u0003J\u0017\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010$HÆ\u0003J\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u001aHÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0017\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010$HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010+HÆ\u0003J\u0087\u0003\u0010J\u001a\u00020\u00002\b\b\u0002\u0010-\u001a\u00020\u00022\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u000b2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u00103\u001a\u00020\u00022\b\b\u0002\u00104\u001a\u00020\u000b2\b\b\u0002\u00105\u001a\u00020\u000b2\b\b\u0002\u00106\u001a\u00020\u000b2\b\b\u0002\u00107\u001a\u00020\u000b2\b\b\u0002\u00108\u001a\u00020\u00052\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001a2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010 2\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001a2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010$2\u0016\b\u0002\u0010D\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010$2\u0010\b\u0002\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u001a2\b\b\u0002\u0010F\u001a\u00020\u00052\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010H\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010$2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010+HÆ\u0001J\t\u0010K\u001a\u00020\u0002HÖ\u0001J\t\u0010L\u001a\u00020\u0005HÖ\u0001J\u0013\u0010P\u001a\u00020O2\b\u0010N\u001a\u0004\u0018\u00010MHÖ\u0003R\u001a\u0010-\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010Q\u001a\u0004\bR\u0010SR\u001a\u0010.\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010T\u001a\u0004\bU\u0010VR\u001a\u0010/\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010T\u001a\u0004\bW\u0010VR\u001c\u00100\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010Q\u001a\u0004\bX\u0010SR\u001c\u00101\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010Q\u001a\u0004\bY\u0010SR\u001c\u00102\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010Q\u001a\u0004\bZ\u0010SR\u001a\u00103\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010Q\u001a\u0004\b[\u0010SR\u001a\u00104\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010T\u001a\u0004\b\\\u0010VR\u001a\u00105\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010T\u001a\u0004\b]\u0010VR\u001a\u00106\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010T\u001a\u0004\b^\u0010VR\u001a\u00107\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010T\u001a\u0004\b_\u0010VR\u001a\u00108\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010`\u001a\u0004\ba\u0010bR\u001c\u00109\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010Q\u001a\u0004\bc\u0010SR\u001c\u0010:\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010Q\u001a\u0004\bd\u0010SR\u001c\u0010;\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010Q\u001a\u0004\be\u0010SR\"\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010f\u001a\u0004\bg\u0010hR\u001c\u0010=\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010Q\u001a\u0004\bi\u0010SR\u001c\u0010>\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010j\u001a\u0004\bk\u0010lR\u001c\u0010?\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b?\u0010m\u001a\u0004\bn\u0010oR\u001c\u0010@\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010p\u001a\u0004\bq\u0010rR\"\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bA\u0010f\u001a\u0004\bs\u0010hR\u001c\u0010B\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bB\u0010Q\u001a\u0004\bt\u0010SR(\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010u\u001a\u0004\bv\u0010wR(\u0010D\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bD\u0010u\u001a\u0004\bx\u0010wR\"\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010f\u001a\u0004\by\u0010hR\u001a\u0010F\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\bF\u0010`\u001a\u0004\bz\u0010bR\u001c\u0010G\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bG\u0010Q\u001a\u0004\b{\u0010SR(\u0010H\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bH\u0010u\u001a\u0004\b|\u0010wR\u001c\u0010I\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bI\u0010}\u001a\u0004\b~\u0010\u007f¨\u0006\u0084\u0001"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECRitTag;", "Ljava/io/Serializable;", "", "getFirstText", "getFirstIconUrl", "", "getIconWidth", "getIconHeight", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getIconUrlModel", "component1", "", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "", "component16", "component17", "component18", "Lcom/bytedance/android/ec/model/response/ECUIConfig;", "component19", "Lcom/bytedance/android/ec/model/response/RitTagUI;", "component20", "component21", "component22", "", "component23", "component24", "component25", "component26", "component27", "component28", "Lcom/bytedance/android/ec/model/RitTagTrack;", "component29", "activityIcon", "activityType", "activityId", "activityBanner", "activityBannerSmall", "activityBannerLandscape", "labelName", "width", "height", "bannerWidth", "bannerHeight", "position", "tagId", "urlDoc", "jumpUrl", "text", "textHeader", "textIcon", "uiConfig", "ui", "animationText", "trackTag", "extraColors", "extraParams", "subTag", "type", "trackParam", "eventParam", "tagTrack", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getActivityIcon", "()Ljava/lang/String;", "J", "getActivityType", "()J", "getActivityId", "getActivityBanner", "getActivityBannerSmall", "getActivityBannerLandscape", "getLabelName", "getWidth", "getHeight", "getBannerWidth", "getBannerHeight", "I", "getPosition", "()I", "getTagId", "getUrlDoc", "getJumpUrl", "Ljava/util/List;", "getText", "()Ljava/util/List;", "getTextHeader", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getTextIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "Lcom/bytedance/android/ec/model/response/ECUIConfig;", "getUiConfig", "()Lcom/bytedance/android/ec/model/response/ECUIConfig;", "Lcom/bytedance/android/ec/model/response/RitTagUI;", "getUi", "()Lcom/bytedance/android/ec/model/response/RitTagUI;", "getAnimationText", "getTrackTag", "Ljava/util/Map;", "getExtraColors", "()Ljava/util/Map;", "getExtraParams", "getSubTag", "getType", "getTrackParam", "getEventParam", "Lcom/bytedance/android/ec/model/RitTagTrack;", "getTagTrack", "()Lcom/bytedance/android/ec/model/RitTagTrack;", "<init>", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;Lcom/bytedance/android/ec/model/response/ECUIConfig;Lcom/bytedance/android/ec/model/response/RitTagUI;Ljava/util/List;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;ILjava/lang/String;Ljava/util/Map;Lcom/bytedance/android/ec/model/RitTagTrack;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECRitTag implements Serializable {
    public static final String ACTIVITY_TYPE_BASE_SELECTION = "101";
    public static final a Companion = null;
    public static final String INSURANCE_REAL_ROOM = "insurance_real_room";
    public static final String QUALITY_ANCHOR = "quality_anchor";
    public static final String QUALITY_VERIFY_ROOM = "quality_verify";
    public static final String SECUREBUY_ROOM = "securebuy_room";

    @SerializedName("activity_banner")
    private final String activityBanner;

    @SerializedName("activity_banner_landscape")
    private final String activityBannerLandscape;

    @SerializedName("activity_banner_small")
    private final String activityBannerSmall;

    @SerializedName("activity_icon")
    private final String activityIcon;

    @SerializedName("activity_id")
    private final long activityId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ACTIVITY_TYPE)
    private final long activityType;

    @SerializedName("animation_text")
    private final List<String> animationText;

    @SerializedName("banner_height")
    private final long bannerHeight;

    @SerializedName("banner_width")
    private final long bannerWidth;

    @SerializedName("event_param")
    private final Map<String, String> eventParam;

    @SerializedName("color")
    private final Map<String, String> extraColors;

    @SerializedName("extra")
    private final Map<String, String> extraParams;

    @SerializedName("height")
    private final long height;

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME)
    private final String labelName;

    @SerializedName("position")
    private final int position;

    @SerializedName("sub_tag")
    private final List<ECRitTag> subTag;

    @SerializedName("tag_id")
    private final String tagId;

    @SerializedName("tag_track")
    private final RitTagTrack tagTrack;

    @SerializedName("text")
    private final List<String> text;

    @SerializedName("text_header")
    private final String textHeader;

    @SerializedName("text_icon")
    private final ECUrlModel textIcon;

    @SerializedName("track_param")
    private final String trackParam;

    @SerializedName("track_tag")
    private final String trackTag;

    @SerializedName("type")
    private final int type;

    /* JADX INFO: renamed from: ui, reason: collision with root package name */
    @SerializedName("ui")
    private final RitTagUI f47907ui;

    @SerializedName("ui_config")
    private final ECUIConfig uiConfig;

    @SerializedName("url_doc")
    private final String urlDoc;

    @SerializedName("width")
    private final long width;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECRitTag() {
        this(null, 0, 0, null, null, null, null, 0, 0, 0, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, 536870911, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECRitTag copy$default(ECRitTag r110, String r111, long r112, long r210, String r211, String r212, String r213, String r214, long r215, long r216, long r310, long r311, int r312, String r313, String r314, String r315, List r316, String r410, ECUrlModel r411, ECUIConfig r412, RitTagUI r413, List r414, String r415, Map r416, Map r417, List r418, int r419, String r510, Map r511, RitTagTrack r512, int r513, Object r514) {
        if ((r513 & 1) == 0) goto L5;
        String r100 = r110.activityIcon;
    L7:
        if ((r513 & 2) == 0) goto L9;
        long r101 = r110.activityType;
    L11:
        if ((r513 & 4) == 0) goto L13;
        long r102 = r110.activityId;
    L15:
        if ((r513 & 8) == 0) goto L17;
        String r103 = r110.activityBanner;
    L19:
        if ((r513 & 16) == 0) goto L21;
        String r104 = r110.activityBannerSmall;
    L23:
        if ((r513 & 32) == 0) goto L25;
        String r105 = r110.activityBannerLandscape;
    L27:
        if ((r513 & 64) == 0) goto L29;
        String r113 = r110.labelName;
    L31:
        if ((r513 & 128) == 0) goto L33;
        long r114 = r110.width;
    L35:
        if ((r513 & 256) == 0) goto L37;
        long r115 = r110.height;
    L38:
        long r217 = r115;
        if ((r513 & 512) == 0) goto L41;
        long r116 = r110.bannerWidth;
    L42:
        long r317 = r116;
        if ((r513 & 1024) == 0) goto L45;
        long r117 = r110.bannerHeight;
    L47:
        if ((r513 & 2048) == 0) goto L49;
        int r118 = r110.position;
    L50:
        int r318 = r118;
        if ((r513 & 4096) == 0) goto L53;
        String r119 = r110.tagId;
    L54:
        String r319 = r119;
        if ((r513 & 8192) == 0) goto L57;
        String r120 = r110.urlDoc;
    L58:
        String r320 = r120;
        if ((r513 & 16384) == 0) goto L61;
        String r121 = r110.jumpUrl;
    L62:
        String r321 = r121;
        if ((r513 & 32768) == 0) goto L65;
        List r122 = r110.text;
    L66:
        List r322 = r122;
        if ((r513 & 65536) == 0) goto L69;
        String r123 = r110.textHeader;
    L70:
        String r420 = r123;
        if ((r513 & 131072) == 0) goto L73;
        ECUrlModel r124 = r110.textIcon;
    L74:
        ECUrlModel r421 = r124;
        if ((r513 & 262144) == 0) goto L77;
        ECUIConfig r125 = r110.uiConfig;
    L78:
        ECUIConfig r422 = r125;
        if ((r513 & 524288) == 0) goto L81;
        RitTagUI r126 = r110.f47907ui;
    L82:
        RitTagUI r423 = r126;
        if ((r513 & 1048576) == 0) goto L85;
        List r127 = r110.animationText;
    L86:
        List r424 = r127;
        if ((r513 & 2097152) == 0) goto L89;
        String r128 = r110.trackTag;
    L90:
        String r425 = r128;
        if ((r513 & 4194304) == 0) goto L93;
        Map r129 = r110.extraColors;
    L94:
        Map r426 = r129;
        if ((r513 & 8388608) == 0) goto L97;
        Map r130 = r110.extraParams;
    L98:
        Map r427 = r130;
        if ((r513 & 16777216) == 0) goto L101;
        List r131 = r110.subTag;
    L102:
        List r428 = r131;
        if ((r513 & 33554432) == 0) goto L105;
        int r132 = r110.type;
    L106:
        int r429 = r132;
        if ((r513 & 67108864) == 0) goto L109;
        String r133 = r110.trackParam;
    L110:
        String r515 = r133;
        if ((r513 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        Map r134 = r110.eventParam;
    L115:
        if ((r513 & 268435456) == 0) goto L117;
        RitTagTrack r106 = r110.tagTrack;
    L119:
        return r110.copy(r100, r101, r102, r103, r104, r105, r113, r114, r217, r317, r117, r318, r319, r320, r321, r322, r420, r421, r422, r423, r424, r425, r426, r427, r428, r429, r515, r134, r106);
    L117:
        r106 = r512;
        goto L119
    L113:
        r134 = r511;
        goto L115
    L109:
        r133 = r510;
        goto L110
    L105:
        r132 = r419;
        goto L106
    L101:
        r131 = r418;
        goto L102
    L97:
        r130 = r417;
        goto L98
    L93:
        r129 = r416;
        goto L94
    L89:
        r128 = r415;
        goto L90
    L85:
        r127 = r414;
        goto L86
    L81:
        r126 = r413;
        goto L82
    L77:
        r125 = r412;
        goto L78
    L73:
        r124 = r411;
        goto L74
    L69:
        r123 = r410;
        goto L70
    L65:
        r122 = r316;
        goto L66
    L61:
        r121 = r315;
        goto L62
    L57:
        r120 = r314;
        goto L58
    L53:
        r119 = r313;
        goto L54
    L49:
        r118 = r312;
        goto L50
    L45:
        r117 = r311;
        goto L47
    L41:
        r116 = r310;
        goto L42
    L37:
        r115 = r216;
        goto L38
    L33:
        r114 = r215;
        goto L35
    L29:
        r113 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.activityIcon;
    }

    public final long component10() {
        return this.bannerWidth;
    }

    public final long component11() {
        return this.bannerHeight;
    }

    public final int component12() {
        return this.position;
    }

    public final String component13() {
        return this.tagId;
    }

    public final String component14() {
        return this.urlDoc;
    }

    public final String component15() {
        return this.jumpUrl;
    }

    public final List<String> component16() {
        return this.text;
    }

    public final String component17() {
        return this.textHeader;
    }

    public final ECUrlModel component18() {
        return this.textIcon;
    }

    public final ECUIConfig component19() {
        return this.uiConfig;
    }

    public final long component2() {
        return this.activityType;
    }

    public final RitTagUI component20() {
        return this.f47907ui;
    }

    public final List<String> component21() {
        return this.animationText;
    }

    public final String component22() {
        return this.trackTag;
    }

    public final Map<String, String> component23() {
        return this.extraColors;
    }

    public final Map<String, String> component24() {
        return this.extraParams;
    }

    public final List<ECRitTag> component25() {
        return this.subTag;
    }

    public final int component26() {
        return this.type;
    }

    public final String component27() {
        return this.trackParam;
    }

    public final Map<String, String> component28() {
        return this.eventParam;
    }

    public final RitTagTrack component29() {
        return this.tagTrack;
    }

    public final long component3() {
        return this.activityId;
    }

    public final String component4() {
        return this.activityBanner;
    }

    public final String component5() {
        return this.activityBannerSmall;
    }

    public final String component6() {
        return this.activityBannerLandscape;
    }

    public final String component7() {
        return this.labelName;
    }

    public final long component8() {
        return this.width;
    }

    public final long component9() {
        return this.height;
    }

    public final ECRitTag copy(String r310, long r410, long r411, String r412, String r413, String r414, String r415, long r416, long r510, long r511, long r512, int r513, String r514, String r515, String r516, List<String> r610, String r611, ECUrlModel r612, ECUIConfig r613, RitTagUI r614, List<String> r615, String r616, Map<String, String> r617, Map<String, String> r618, List<ECRitTag> r619, int r710, String r711, Map<String, String> r712, RitTagTrack r713) {
        Intrinsics.checkNotNullParameter(r310, "activityIcon");
        Intrinsics.checkNotNullParameter(r415, "labelName");
        return new ECRitTag(r310, r410, r411, r412, r413, r414, r415, r416, r510, r511, r512, r513, r514, r515, r516, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECRitTag) == false) goto L64;
        ECRitTag r101 = (ECRitTag) r100;
        if (Intrinsics.areEqual(this.activityIcon, r101.activityIcon) == true) goto L8;
        return false;
    L8:
        if (this.activityType == r101.activityType) goto L10;
        return false;
    L10:
        if (this.activityId == r101.activityId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.activityBanner, r101.activityBanner) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.activityBannerSmall, r101.activityBannerSmall) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.activityBannerLandscape, r101.activityBannerLandscape) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.labelName, r101.labelName) == true) goto L20;
        return false;
    L20:
        if (this.width == r101.width) goto L22;
        return false;
    L22:
        if (this.height == r101.height) goto L24;
        return false;
    L24:
        if (this.bannerWidth == r101.bannerWidth) goto L26;
        return false;
    L26:
        if (this.bannerHeight == r101.bannerHeight) goto L28;
        return false;
    L28:
        if (this.position == r101.position) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.tagId, r101.tagId) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.urlDoc, r101.urlDoc) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.textHeader, r101.textHeader) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.textIcon, r101.textIcon) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.uiConfig, r101.uiConfig) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.f47907ui, r101.f47907ui) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.animationText, r101.animationText) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.trackTag, r101.trackTag) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.extraColors, r101.extraColors) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.extraParams, r101.extraParams) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.subTag, r101.subTag) == true) goto L56;
        return false;
    L56:
        if (this.type == r101.type) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.trackParam, r101.trackParam) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.eventParam, r101.eventParam) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.tagTrack, r101.tagTrack) == true) goto L97;
        return false;
    L97:
        return true;
    L64:
        return false;
    }

    public int hashCode() {
        String r100 = this.activityIcon;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.activityType;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.activityId;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        String r107 = this.activityBanner;
        if (r107 == null) goto L9;
        int r108 = r107.hashCode();
    L10:
        int r109 = (r106 + r108) * 31;
        String r110 = this.activityBannerSmall;
        if (r110 == null) goto L13;
        int r111 = r110.hashCode();
    L14:
        int r112 = (r109 + r111) * 31;
        String r113 = this.activityBannerLandscape;
        if (r113 == null) goto L17;
        int r114 = r113.hashCode();
    L18:
        int r115 = (r112 + r114) * 31;
        String r116 = this.labelName;
        if (r116 == null) goto L21;
        int r117 = r116.hashCode();
    L22:
        int r118 = (r115 + r117) * 31;
        long r119 = this.width;
        int r120 = (r118 + ((int) (r119 ^ (r119 >>> 32)))) * 31;
        long r121 = this.height;
        int r122 = (r120 + ((int) (r121 ^ (r121 >>> 32)))) * 31;
        long r123 = this.bannerWidth;
        int r124 = (r122 + ((int) (r123 ^ (r123 >>> 32)))) * 31;
        long r125 = this.bannerHeight;
        int r126 = (((r124 + ((int) (r125 ^ (r125 >>> 32)))) * 31) + this.position) * 31;
        String r127 = this.tagId;
        if (r127 == null) goto L25;
        int r128 = r127.hashCode();
    L26:
        int r129 = (r126 + r128) * 31;
        String r130 = this.urlDoc;
        if (r130 == null) goto L29;
        int r131 = r130.hashCode();
    L30:
        int r132 = (r129 + r131) * 31;
        String r133 = this.jumpUrl;
        if (r133 == null) goto L33;
        int r134 = r133.hashCode();
    L34:
        int r135 = (r132 + r134) * 31;
        List<String> r136 = this.text;
        if (r136 == null) goto L37;
        int r137 = r136.hashCode();
    L38:
        int r138 = (r135 + r137) * 31;
        String r139 = this.textHeader;
        if (r139 == null) goto L41;
        int r140 = r139.hashCode();
    L42:
        int r141 = (r138 + r140) * 31;
        ECUrlModel r142 = this.textIcon;
        if (r142 == null) goto L45;
        int r143 = r142.hashCode();
    L46:
        int r144 = (r141 + r143) * 31;
        ECUIConfig r145 = this.uiConfig;
        if (r145 == null) goto L49;
        int r146 = r145.hashCode();
    L50:
        int r147 = (r144 + r146) * 31;
        RitTagUI r148 = this.f47907ui;
        if (r148 == null) goto L53;
        int r149 = r148.hashCode();
    L54:
        int r150 = (r147 + r149) * 31;
        List<String> r151 = this.animationText;
        if (r151 == null) goto L57;
        int r152 = r151.hashCode();
    L58:
        int r153 = (r150 + r152) * 31;
        String r154 = this.trackTag;
        if (r154 == null) goto L61;
        int r155 = r154.hashCode();
    L62:
        int r156 = (r153 + r155) * 31;
        Map<String, String> r157 = this.extraColors;
        if (r157 == null) goto L65;
        int r158 = r157.hashCode();
    L66:
        int r159 = (r156 + r158) * 31;
        Map<String, String> r160 = this.extraParams;
        if (r160 == null) goto L69;
        int r161 = r160.hashCode();
    L70:
        int r162 = (r159 + r161) * 31;
        List<ECRitTag> r163 = this.subTag;
        if (r163 == null) goto L73;
        int r164 = r163.hashCode();
    L74:
        int r165 = (((r162 + r164) * 31) + this.type) * 31;
        String r166 = this.trackParam;
        if (r166 == null) goto L77;
        int r167 = r166.hashCode();
    L78:
        int r168 = (r165 + r167) * 31;
        Map<String, String> r169 = this.eventParam;
        if (r169 == null) goto L81;
        int r170 = r169.hashCode();
    L82:
        int r171 = (r168 + r170) * 31;
        RitTagTrack r172 = this.tagTrack;
        if (r172 == null) goto L86;
        r101 = r172.hashCode();
    L86:
        return r171 + r101;
    L81:
        r170 = 0;
        goto L82
    L77:
        r167 = 0;
        goto L78
    L73:
        r164 = 0;
        goto L74
    L69:
        r161 = 0;
        goto L70
    L65:
        r158 = 0;
        goto L66
    L61:
        r155 = 0;
        goto L62
    L57:
        r152 = 0;
        goto L58
    L53:
        r149 = 0;
        goto L54
    L49:
        r146 = 0;
        goto L50
    L45:
        r143 = 0;
        goto L46
    L41:
        r140 = 0;
        goto L42
    L37:
        r137 = 0;
        goto L38
    L33:
        r134 = 0;
        goto L34
    L29:
        r131 = 0;
        goto L30
    L25:
        r128 = 0;
        goto L26
    L21:
        r117 = 0;
        goto L22
    L17:
        r114 = 0;
        goto L18
    L13:
        r111 = 0;
        goto L14
    L9:
        r108 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ECRitTag(activityIcon=" + this.activityIcon + ", activityType=" + this.activityType + ", activityId=" + this.activityId + ", activityBanner=" + this.activityBanner + ", activityBannerSmall=" + this.activityBannerSmall + ", activityBannerLandscape=" + this.activityBannerLandscape + ", labelName=" + this.labelName + ", width=" + this.width + ", height=" + this.height + ", bannerWidth=" + this.bannerWidth + ", bannerHeight=" + this.bannerHeight + ", position=" + this.position + ", tagId=" + this.tagId + ", urlDoc=" + this.urlDoc + ", jumpUrl=" + this.jumpUrl + ", text=" + this.text + ", textHeader=" + this.textHeader + ", textIcon=" + this.textIcon + ", uiConfig=" + this.uiConfig + ", ui=" + this.f47907ui + ", animationText=" + this.animationText + ", trackTag=" + this.trackTag + ", extraColors=" + this.extraColors + ", extraParams=" + this.extraParams + ", subTag=" + this.subTag + ", type=" + this.type + ", trackParam=" + this.trackParam + ", eventParam=" + this.eventParam + ", tagTrack=" + this.tagTrack + ")";
    }

    public final String getFirstIconUrl() {
        ECUrlModel r100 = this.textIcon;
        if (r100 == null) goto L7;
        List<String> r101 = r100.getUrlList();
        if (r101 == null) goto L7;
        return (String) CollectionsKt.firstOrNull(r101);
    L7:
        return null;
    }

    public final String getFirstText() {
        List<String> r100 = this.text;
        if (r100 != null) goto L7;
        return null;
    L7:
        return (String) CollectionsKt.firstOrNull(r100);
    }

    public final int getIconHeight() {
        ECUrlModel r100 = this.textIcon;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getHeight();
    }

    public final ECUrlModel getIconUrlModel() {
        ECUrlModel r100 = this.textIcon;
        if (r100 != null) goto L16;
        String r101 = this.activityIcon;
        if (r101.length() <= 0) goto L7;
        boolean r102 = true;
    L9:
        if (r102 == true) goto L12;
        r101 = null;
    L12:
        if (r101 == null) goto L15;
        ECUrlModel r103 = new ECUrlModel();
        r103.setWidth((int) this.width);
        r103.setHeight((int) this.height);
        r103.setUrlList(CollectionsKt.listOf(this.activityIcon));
        return r103;
    L15:
        return null;
    L7:
        r102 = false;
        goto L9
    L16:
        return r100;
    }

    public final int getIconWidth() {
        ECUrlModel r100 = this.textIcon;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getWidth();
    }

    public final String getActivityBanner() {
        return this.activityBanner;
    }

    public final String getActivityBannerLandscape() {
        return this.activityBannerLandscape;
    }

    public final String getActivityBannerSmall() {
        return this.activityBannerSmall;
    }

    public final String getActivityIcon() {
        return this.activityIcon;
    }

    public final long getActivityId() {
        return this.activityId;
    }

    public final long getActivityType() {
        return this.activityType;
    }

    public final List<String> getAnimationText() {
        return this.animationText;
    }

    public final long getBannerHeight() {
        return this.bannerHeight;
    }

    public final long getBannerWidth() {
        return this.bannerWidth;
    }

    public final Map<String, String> getEventParam() {
        return this.eventParam;
    }

    public final Map<String, String> getExtraColors() {
        return this.extraColors;
    }

    public final Map<String, String> getExtraParams() {
        return this.extraParams;
    }

    public final long getHeight() {
        return this.height;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getLabelName() {
        return this.labelName;
    }

    public final int getPosition() {
        return this.position;
    }

    public final List<ECRitTag> getSubTag() {
        return this.subTag;
    }

    public final String getTagId() {
        return this.tagId;
    }

    public final RitTagTrack getTagTrack() {
        return this.tagTrack;
    }

    public final List<String> getText() {
        return this.text;
    }

    public final String getTextHeader() {
        return this.textHeader;
    }

    public final ECUrlModel getTextIcon() {
        return this.textIcon;
    }

    public final String getTrackParam() {
        return this.trackParam;
    }

    public final String getTrackTag() {
        return this.trackTag;
    }

    public final int getType() {
        return this.type;
    }

    public final RitTagUI getUi() {
        return this.f47907ui;
    }

    public final ECUIConfig getUiConfig() {
        return this.uiConfig;
    }

    public final String getUrlDoc() {
        return this.urlDoc;
    }

    public final long getWidth() {
        return this.width;
    }

    @JvmStatic
    public static final boolean passToUiPromotion(String r100) {
        Companion.getClass();
        if (Intrinsics.areEqual(r100, SECUREBUY_ROOM) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r100, QUALITY_VERIFY_ROOM) == true) goto L8;
        return false;
    }

    public ECRitTag(String r100, long r101, long r102, String r110, String r111, String r112, String r113, long r114, long r115, long r116, long r210, int r211, String r212, String r213, String r214, List<String> r215, String r216, ECUrlModel r217, ECUIConfig r310, RitTagUI r311, List<String> r312, String r313, Map<String, String> r314, Map<String, String> r315, List<ECRitTag> r316, int r317, String r318, Map<String, String> r319, RitTagTrack r410) {
        Intrinsics.checkNotNullParameter(r100, "activityIcon");
        Intrinsics.checkNotNullParameter(r113, "labelName");
        this.activityIcon = r100;
        this.activityType = r101;
        this.activityId = r102;
        this.activityBanner = r110;
        this.activityBannerSmall = r111;
        this.activityBannerLandscape = r112;
        this.labelName = r113;
        this.width = r114;
        this.height = r115;
        this.bannerWidth = r116;
        this.bannerHeight = r210;
        this.position = r211;
        this.tagId = r212;
        this.urlDoc = r213;
        this.jumpUrl = r214;
        this.text = r215;
        this.textHeader = r216;
        this.textIcon = r217;
        this.uiConfig = r310;
        this.f47907ui = r311;
        this.animationText = r312;
        this.trackTag = r313;
        this.extraColors = r314;
        this.extraParams = r315;
        this.subTag = r316;
        this.type = r317;
        this.trackParam = r318;
        this.eventParam = r319;
        this.tagTrack = r410;
    }

    public /* synthetic */ ECRitTag(String r310, long r311, long r312, String r410, String r411, String r412, String r413, long r414, long r415, long r416, long r510, int r511, String r512, String r513, String r514, List r515, String r516, ECUrlModel r517, ECUIConfig r610, RitTagUI r611, List r612, String r613, Map r614, Map r615, List r616, int r617, String r618, Map r619, RitTagTrack r710, int r711, DefaultConstructorMarker r712) {
        String r100 = "";
        if ((r711 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r711 & 2) == 0) goto L9;
        long r102 = 0;
    L11:
        if ((r711 & 4) == 0) goto L13;
        long r103 = 0;
    L15:
        if ((r711 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r711 & 16) == 0) goto L21;
        String r110 = null;
    L23:
        if ((r711 & 32) == 0) goto L25;
        String r111 = null;
    L27:
        if ((r711 & 64) != 0) goto L31;
        r100 = r413;
    L31:
        if ((r711 & 128) == 0) goto L33;
        long r112 = 0;
    L35:
        if ((r711 & 256) == 0) goto L37;
        long r113 = 0;
    L39:
        if ((r711 & 512) == 0) goto L41;
        long r105 = 0;
    L43:
        if ((r711 & 1024) == 0) goto L45;
        long r114 = 0;
    L46:
        int r115 = 0;
        if ((r711 & 2048) == 0) goto L49;
        int r116 = 0;
    L50:
        int r713 = r116;
        if ((r711 & 4096) == 0) goto L53;
        String r117 = null;
    L54:
        String r210 = r117;
        if ((r711 & 8192) == 0) goto L57;
        String r118 = null;
    L58:
        String r211 = r118;
        if ((r711 & 16384) == 0) goto L61;
        String r119 = null;
    L63:
        if ((r711 & 32768) == 0) goto L65;
        List r212 = null;
    L67:
        if ((r711 & 65536) == 0) goto L69;
        String r213 = null;
    L71:
        if ((r711 & 131072) == 0) goto L73;
        ECUrlModel r214 = null;
    L75:
        if ((r711 & 262144) == 0) goto L77;
        ECUIConfig r215 = null;
    L79:
        if ((r711 & 524288) == 0) goto L81;
        RitTagUI r216 = null;
    L83:
        if ((r711 & 1048576) == 0) goto L85;
        List r217 = null;
    L87:
        if ((r711 & 2097152) == 0) goto L89;
        String r218 = null;
    L91:
        if ((r711 & 4194304) == 0) goto L93;
        Map r219 = null;
    L95:
        if ((r711 & 8388608) == 0) goto L97;
        Map r313 = null;
    L99:
        if ((r711 & 16777216) == 0) goto L101;
        List r314 = null;
    L103:
        if ((r711 & 33554432) != 0) goto L107;
        r115 = r617;
    L107:
        if ((r711 & 67108864) == 0) goto L109;
        String r315 = null;
    L111:
        if ((r711 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        Map r316 = null;
    L115:
        if ((r711 & 268435456) == 0) goto L117;
        RitTagTrack r106 = null;
    L118:
        this(r101, r102, r103, r104, r110, r111, r100, r112, r113, r105, r114, r713, r210, r211, r119, r212, r213, r214, r215, r216, r217, r218, r219, r313, r314, r115, r315, r316, r106);
        return;
    L117:
        r106 = r710;
        goto L118
    L113:
        r316 = r619;
        goto L115
    L109:
        r315 = r618;
        goto L111
    L101:
        r314 = r616;
        goto L103
    L97:
        r313 = r615;
        goto L99
    L93:
        r219 = r614;
        goto L95
    L89:
        r218 = r613;
        goto L91
    L85:
        r217 = r612;
        goto L87
    L81:
        r216 = r611;
        goto L83
    L77:
        r215 = r610;
        goto L79
    L73:
        r214 = r517;
        goto L75
    L69:
        r213 = r516;
        goto L71
    L65:
        r212 = r515;
        goto L67
    L61:
        r119 = r514;
        goto L63
    L57:
        r118 = r513;
        goto L58
    L53:
        r117 = r512;
        goto L54
    L49:
        r116 = r511;
        goto L50
    L45:
        r114 = r510;
        goto L46
    L41:
        r105 = r416;
        goto L43
    L37:
        r113 = r415;
        goto L39
    L33:
        r112 = r414;
        goto L35
    L25:
        r111 = r412;
        goto L27
    L21:
        r110 = r411;
        goto L23
    L17:
        r104 = r410;
        goto L19
    L13:
        r103 = r312;
        goto L15
    L9:
        r102 = r311;
        goto L11
    L5:
        r101 = r310;
        goto L7
    }
}
