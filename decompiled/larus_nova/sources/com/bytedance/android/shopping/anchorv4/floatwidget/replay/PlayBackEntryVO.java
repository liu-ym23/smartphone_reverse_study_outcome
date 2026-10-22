package com.bytedance.android.shopping.anchorv4.floatwidget.replay;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.Link;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.voavhs.head.AnchorV4HeadVO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ScrollContainerFooter;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b(\b\u0086\b\u0018\u0000 g2\u00020\u0001:\u0001hBã\u0001\u0012\b\u0010+\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010,\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u00104\u001a\u00020\u0002\u0012\b\b\u0002\u00105\u001a\u00020 \u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0018\u0012\u001c\b\u0002\u00107\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010#j\u0004\u0018\u0001`$\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010:\u001a\u00020\u0002\u0012\b\b\u0002\u0010;\u001a\u00020\u0002\u0012\b\b\u0002\u0010<\u001a\u00020\u0002¢\u0006\u0004\be\u0010fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0019\u0010\u0005\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0002HÆ\u0003J\t\u0010!\u001a\u00020 HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u001d\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010#j\u0004\u0018\u0001`$HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u0012\u0010'\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b'\u0010\u0011J\t\u0010(\u001a\u00020\u0002HÆ\u0003J\t\u0010)\u001a\u00020\u0002HÆ\u0003J\t\u0010*\u001a\u00020\u0002HÆ\u0003Jð\u0001\u0010=\u001a\u00020\u00002\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u00104\u001a\u00020\u00022\b\b\u0002\u00105\u001a\u00020 2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00182\u001c\b\u0002\u00107\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010#j\u0004\u0018\u0001`$2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010:\u001a\u00020\u00022\b\b\u0002\u0010;\u001a\u00020\u00022\b\b\u0002\u0010<\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b=\u0010>J\t\u0010?\u001a\u00020\u0013HÖ\u0001J\t\u0010@\u001a\u00020\u000fHÖ\u0001J\u0013\u0010C\u001a\u00020\u00022\b\u0010B\u001a\u0004\u0018\u00010AHÖ\u0003R\u0019\u0010+\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b+\u0010D\u001a\u0004\bE\u0010\u0011R$\u0010,\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010D\u001a\u0004\bF\u0010\u0011\"\u0004\bG\u0010HR\u0019\u0010-\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b-\u0010I\u001a\u0004\bJ\u0010KR\u0019\u0010.\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b.\u0010L\u001a\u0004\b.\u0010\u0016R\u0019\u0010/\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b/\u0010L\u001a\u0004\b/\u0010\u0016R\u0019\u00100\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b0\u0010M\u001a\u0004\bN\u0010OR\u0019\u00101\u001a\u0004\u0018\u00010\u001a8\u0006¢\u0006\f\n\u0004\b1\u0010P\u001a\u0004\bQ\u0010RR\u0019\u00102\u001a\u0004\u0018\u00010\u001a8\u0006¢\u0006\f\n\u0004\b2\u0010P\u001a\u0004\bS\u0010RR\u0019\u00103\u001a\u0004\u0018\u00010\u001d8\u0006¢\u0006\f\n\u0004\b3\u0010T\u001a\u0004\bU\u0010VR\u001a\u00104\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010W\u001a\u0004\bX\u0010YR\u0017\u00105\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b5\u0010Z\u001a\u0004\b[\u0010\\R\u0019\u00106\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b6\u0010M\u001a\u0004\b]\u0010OR+\u00107\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010#j\u0004\u0018\u0001`$8\u0006¢\u0006\f\n\u0004\b7\u0010^\u001a\u0004\b_\u0010`R\u0019\u00108\u001a\u0004\u0018\u00010\u001d8\u0006¢\u0006\f\n\u0004\b8\u0010T\u001a\u0004\ba\u0010VR\u0019\u00109\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b9\u0010D\u001a\u0004\bb\u0010\u0011R\u0017\u0010:\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b:\u0010W\u001a\u0004\b:\u0010YR\u0017\u0010;\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b;\u0010W\u001a\u0004\b;\u0010YR\"\u0010<\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010W\u001a\u0004\b<\u0010Y\"\u0004\bc\u0010d¨\u0006i"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/floatwidget/replay/PlayBackEntryVO;", "Ljava/io/Serializable;", "", "isFloatEntryVisible", "forceFullscreenMode", "enablePlayBackEntryDraggable", "(Ljava/lang/Boolean;)Z", "showNewStylePlayBackEntry", "showNewStylePlayBackEntryInComponent", "enableIconSlideAnimation", "showLottie", "shouldGoneWithHead", "enablePlayBackEntryAlphaTrans", "repositionEntryPosition", "isShowLiveIcon", "", "component1", "()Ljava/lang/Integer;", "component2", "", "component3", "component4", "()Ljava/lang/Boolean;", "component5", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "component6", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;", "component7", "component8", "Lcom/bytedance/android/ec/model/ECUrlModel;", "component9", "component10", "", "component11", "component12", "", "Lcom/bytedance/android/shopping/anchorv4/floatwidget/replay/PlayBackTrackExtra;", "component13", "component14", "component15", "component16", "component17", "component18", "showStyle", "initState", "entryText", "isHeadHasScrollMore", "isHeadAreaLengthened", "playBackIcon", "replayLink", "livingLink", "bottomPrefixIcon", "fullscreenMode", "transformAnimStartTime", "lottie", "trackExtra", "videoCoverImage", "initPosition", "isHeadV2", "isFromCache", "isFromLive", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;Lcom/bytedance/android/ec/model/ECUrlModel;ZJLcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Ljava/util/Map;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/Integer;ZZZ)Lcom/bytedance/android/shopping/anchorv4/floatwidget/replay/PlayBackEntryVO;", "toString", "hashCode", "", "other", "equals", "Ljava/lang/Integer;", "getShowStyle", "getInitState", "setInitState", "(Ljava/lang/Integer;)V", "Ljava/lang/String;", "getEntryText", "()Ljava/lang/String;", "Ljava/lang/Boolean;", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "getPlayBackIcon", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;", "getReplayLink", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;", "getLivingLink", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getBottomPrefixIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "Z", "getFullscreenMode", "()Z", "J", "getTransformAnimStartTime", "()J", "getLottie", "Ljava/util/Map;", "getTrackExtra", "()Ljava/util/Map;", "getVideoCoverImage", "getInitPosition", "setFromLive", "(Z)V", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;Lcom/bytedance/android/ec/model/ECUrlModel;ZJLcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Ljava/util/Map;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/Integer;ZZZ)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayBackEntryVO implements Serializable {
    public static final a Companion = null;
    public static final int SHADE_BY_SCROLL_MORE_VIEW = 5;
    public static final int STATE_LIVING = 1;
    public static final int STATE_PLAYBACK_ICON = 0;
    public static final int STATE_PLAYBACK_VIDEO = 2;
    public static final int STYLE_ICON = 1;
    public static final int STYLE_ON_LINE = 0;
    public static final int STYLE_VIDEO_AND_ICON = 2;
    public static final int STYLE_VIDEO_GONE_WITH_HEAD = 3;
    public static final int STYLE_VIDEO_TO_ICON = 6;
    public static final int STYLE_VIDEO_VISIBLE = 4;
    private final ECUrlModel bottomPrefixIcon;
    private final String entryText;

    @SerializedName("fullscreenMode")
    private final boolean fullscreenMode;
    private final Integer initPosition;
    private Integer initState;
    private final boolean isFromCache;
    private boolean isFromLive;
    private final Boolean isHeadAreaLengthened;
    private final Boolean isHeadHasScrollMore;
    private final boolean isHeadV2;
    private final Link livingLink;
    private final ImageModel lottie;
    private final ImageModel playBackIcon;
    private final Link replayLink;
    private final Integer showStyle;
    private final Map<String, String> trackExtra;
    private final long transformAnimStartTime;
    private final ECUrlModel videoCoverImage;

    public static final class a {
        public a() {
        }

        public static PlayBackEntryVO b(ComponentDTO r210, AnchorV4HeadV2VO r211, boolean r212) {
            if (r210 != null) goto L83;
            return null;
        L83:
            VO r100 = r210.getVo();     // Catch: Exception -> L80
            if (r100 == null) goto L8;
            JsonObject r101 = r100.getDisplay();     // Catch: Exception -> L80
        L9:
            PlayBackEntryDisplay r102 = (PlayBackEntryDisplay) u0.a(r101, PlayBackEntryDisplay.class);     // Catch: Exception -> L80
            VO r103 = r210.getVo();     // Catch: Exception -> L80
            if (r103 == null) goto L12;
            JsonObject r104 = r103.getMeta();     // Catch: Exception -> L80
        L13:
            PlayBackEntryMeta r105 = (PlayBackEntryMeta) u0.a(r104, PlayBackEntryMeta.class);     // Catch: Exception -> L80
            if (r102 == null) goto L18;
            Integer r106 = r102.getShowStyle();     // Catch: Exception -> L80
            if (r106 == null) goto L18;
            int r107 = r106.intValue();     // Catch: Exception -> L80
        L19:
            Integer r108 = Integer.valueOf(r107);     // Catch: Exception -> L80
            if (r102 == null) goto L22;
            Integer r109 = r102.getInitState();     // Catch: Exception -> L80
        L23:
            if (r102 == null) goto L27;
            TextElement r110 = r102.getEntryText();     // Catch: Exception -> L80
            if (r110 == null) goto L27;
            String r111 = r110.getText();     // Catch: Exception -> L80
        L28:
            if (r211 == null) goto L30;
            ScrollContainerFooter r112 = r211.getFooter();     // Catch: Exception -> L80
        L32:
            if (r112 == null) goto L34;
            boolean r113 = true;
        L35:
            Boolean r114 = Boolean.valueOf(r113);     // Catch: Exception -> L80
            if (r211 != null) goto L38;
        L40:
            boolean r115 = false;
        L41:
            Boolean r116 = Boolean.valueOf(r115);     // Catch: Exception -> L80
            if (r102 == null) goto L44;
            ImageModel r117 = r102.getFloatEntryIcon();     // Catch: Exception -> L80
        L45:
            if (r105 == null) goto L49;
            PlayBackBusinessExtra r118 = r105.getBusinessMeta();     // Catch: Exception -> L80
            if (r118 == null) goto L49;
            Link r119 = r118.getReplayLink();     // Catch: Exception -> L80
        L50:
            if (r105 == null) goto L54;
            PlayBackBusinessExtra r120 = r105.getBusinessMeta();     // Catch: Exception -> L80
            if (r120 == null) goto L54;
            Link r121 = r120.getLivingLinkUrl();     // Catch: Exception -> L80
        L55:
            if (r102 == null) goto L59;
            ImageModel r122 = r102.getTextPrefixIcon();     // Catch: Exception -> L80
            if (r122 == null) goto L59;
            ECUrlModel r123 = r122.getRemote();     // Catch: Exception -> L80
        L60:
            boolean r124 = false;
            Integer r125 = r102.getPlayTime();     // Catch: Exception -> L80
            if (r125 == null) goto L63;
            int r126 = r125.intValue();     // Catch: Exception -> L80
        L64:
            long r127 = 1000 * ((long) r126);     // Catch: Exception -> L80
            ImageModel r128 = r102.getLottie();     // Catch: Exception -> L80
            if (r105 == null) goto L67;
            Map<String, String> r129 = r105.getTrackMeta();     // Catch: Exception -> L80
        L68:
            Background r130 = r102.getReplayViewBackground();     // Catch: Exception -> L80
            if (r130 == null) goto L73;
            ImageModel r131 = r130.getBackgroundImageModel();     // Catch: Exception -> L80
            if (r131 == null) goto L73;
            ECUrlModel r213 = r131.getRemote();     // Catch: Exception -> L80
        L74:
            Integer r214 = r102.getInitPosition();     // Catch: Exception -> L80
            if (r211 == null) goto L77;
            boolean r215 = true;
        L78:
            return new PlayBackEntryVO(r108, r109, r111, r114, r116, r117, r119, r121, r123, r124, r127, r128, r129, r213, r214, r215, r212, false, 131584, null);
        L77:
            r215 = false;
        L73:
            r213 = null;
            goto L74
        L67:
            r129 = null;
            goto L68
        L63:
            r126 = 3;
        L59:
            r123 = null;
        L54:
            r121 = null;
        L49:
            r119 = null;
            goto L50
        L44:
            r117 = null;
            goto L45
        L38:
            if (r211.getSizeType() != 1) goto L40;
            r115 = true;
            goto L41
        L34:
            r113 = false;
            goto L35
        L30:
            r112 = null;
        L27:
            r111 = null;
            goto L28
        L22:
            r109 = null;
        L18:
            r107 = 1;
            goto L19
        L12:
            r104 = null;
            goto L13
        L8:
            r101 = null;
        L80:
            e = move-exception;
            ECExceptionMonitor.e(e);
            return null;
        }

        public static PlayBackEntryVO a(ComponentDTO r210, AnchorV4HeadVO r211, AnchorV4HeadV2VO r212, boolean r310, boolean r311) {
            if (r210 != null) goto L88;
            return null;
        L88:
            VO r100 = r210.getVo();     // Catch: Exception -> L85
            if (r100 == null) goto L8;
            JsonObject r101 = r100.getDisplay();     // Catch: Exception -> L85
        L9:
            PlayBackEntryDisplay r102 = (PlayBackEntryDisplay) u0.a(r101, PlayBackEntryDisplay.class);     // Catch: Exception -> L85
            VO r103 = r210.getVo();     // Catch: Exception -> L85
            if (r103 == null) goto L12;
            JsonObject r104 = r103.getMeta();     // Catch: Exception -> L85
        L13:
            PlayBackEntryMeta r105 = (PlayBackEntryMeta) u0.a(r104, PlayBackEntryMeta.class);     // Catch: Exception -> L85
            if (r102 == null) goto L18;
            Integer r106 = r102.getShowStyle();     // Catch: Exception -> L85
            if (r106 == null) goto L18;
            int r107 = r106.intValue();     // Catch: Exception -> L85
        L19:
            Integer r108 = Integer.valueOf(r107);     // Catch: Exception -> L85
            if (r102 == null) goto L22;
            Integer r109 = r102.getInitState();     // Catch: Exception -> L85
        L23:
            if (r102 == null) goto L27;
            TextElement r110 = r102.getEntryText();     // Catch: Exception -> L85
            if (r110 == null) goto L27;
            String r111 = r110.getText();     // Catch: Exception -> L85
        L28:
            if (r211 != null) goto L30;
        L32:
            if (r212 == null) goto L34;
            ScrollContainerFooter r112 = r212.getFooter();     // Catch: Exception -> L85
        L35:
            if (r112 == null) goto L37;
        L36:
            boolean r113 = true;
        L38:
            Boolean r114 = Boolean.valueOf(r113);     // Catch: Exception -> L85
            if (r211 == null) goto L41;
            boolean r115 = r211.isLengthenedPicture();     // Catch: Exception -> L85
        L46:
            Boolean r116 = Boolean.valueOf(r115);     // Catch: Exception -> L85
            if (r102 == null) goto L49;
            ImageModel r117 = r102.getFloatEntryIcon();     // Catch: Exception -> L85
        L50:
            if (r105 == null) goto L54;
            PlayBackBusinessExtra r118 = r105.getBusinessMeta();     // Catch: Exception -> L85
            if (r118 == null) goto L54;
            Link r119 = r118.getReplayLink();     // Catch: Exception -> L85
        L55:
            if (r105 == null) goto L59;
            PlayBackBusinessExtra r120 = r105.getBusinessMeta();     // Catch: Exception -> L85
            if (r120 == null) goto L59;
            Link r121 = r120.getLivingLinkUrl();     // Catch: Exception -> L85
        L60:
            if (r102 == null) goto L64;
            ImageModel r122 = r102.getTextPrefixIcon();     // Catch: Exception -> L85
            if (r122 == null) goto L64;
            ECUrlModel r123 = r122.getRemote();     // Catch: Exception -> L85
        L65:
            Integer r124 = r102.getPlayTime();     // Catch: Exception -> L85
            if (r124 == null) goto L68;
            int r125 = r124.intValue();     // Catch: Exception -> L85
        L69:
            long r126 = 1000 * ((long) r125);     // Catch: Exception -> L85
            ImageModel r127 = r102.getLottie();     // Catch: Exception -> L85
            if (r105 == null) goto L72;
            Map<String, String> r128 = r105.getTrackMeta();     // Catch: Exception -> L85
        L73:
            Background r129 = r102.getReplayViewBackground();     // Catch: Exception -> L85
            if (r129 == null) goto L78;
            ImageModel r130 = r129.getBackgroundImageModel();     // Catch: Exception -> L85
            if (r130 == null) goto L78;
            ECUrlModel r213 = r130.getRemote();     // Catch: Exception -> L85
        L79:
            Integer r214 = r102.getInitPosition();     // Catch: Exception -> L85
            if (r212 == null) goto L82;
            boolean r215 = true;
        L83:
            return new PlayBackEntryVO(r108, r109, r111, r114, r116, r117, r119, r121, r123, r310, r126, r127, r128, r213, r214, r215, r311, false, 131072, null);
        L82:
            r215 = false;
        L78:
            r213 = null;
            goto L79
        L72:
            r128 = null;
            goto L73
        L68:
            r125 = 3;
        L64:
            r123 = null;
        L59:
            r121 = null;
        L54:
            r119 = null;
            goto L55
        L49:
            r117 = null;
            goto L50
        L41:
            if (r212 != null) goto L43;
        L45:
            r115 = false;
            goto L46
        L43:
            if (r212.getSizeType() != 1) goto L45;
            r115 = true;
            goto L46
        L37:
            r113 = false;
            goto L38
        L34:
            r112 = null;
            goto L35
        L30:
            if (r211.getScrollMoreText() == null) goto L32;
        L27:
            r111 = null;
            goto L28
        L22:
            r109 = null;
        L18:
            r107 = 1;
            goto L19
        L12:
            r104 = null;
            goto L13
        L8:
            r101 = null;
        L85:
            e = move-exception;
            ECExceptionMonitor.e(e);
            return null;
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlayBackEntryVO copy$default(PlayBackEntryVO r110, Integer r111, Integer r112, String r210, Boolean r211, Boolean r212, ImageModel r213, Link r214, Link r215, ECUrlModel r216, boolean r217, long r218, ImageModel r310, Map r311, ECUrlModel r312, Integer r313, boolean r314, boolean r315, boolean r316, int r317, Object r318) {
        if ((r317 & 1) == 0) goto L5;
        Integer r100 = r110.showStyle;
    L7:
        if ((r317 & 2) == 0) goto L9;
        Integer r101 = r110.initState;
    L11:
        if ((r317 & 4) == 0) goto L13;
        String r102 = r110.entryText;
    L15:
        if ((r317 & 8) == 0) goto L17;
        Boolean r103 = r110.isHeadHasScrollMore;
    L19:
        if ((r317 & 16) == 0) goto L21;
        Boolean r104 = r110.isHeadAreaLengthened;
    L23:
        if ((r317 & 32) == 0) goto L25;
        ImageModel r105 = r110.playBackIcon;
    L27:
        if ((r317 & 64) == 0) goto L29;
        Link r106 = r110.replayLink;
    L31:
        if ((r317 & 128) == 0) goto L33;
        Link r107 = r110.livingLink;
    L35:
        if ((r317 & 256) == 0) goto L37;
        ECUrlModel r113 = r110.bottomPrefixIcon;
    L39:
        if ((r317 & 512) == 0) goto L41;
        boolean r114 = r110.fullscreenMode;
    L43:
        if ((r317 & 1024) == 0) goto L45;
        long r115 = r110.transformAnimStartTime;
    L47:
        if ((r317 & 2048) == 0) goto L49;
        ImageModel r116 = r110.lottie;
    L51:
        if ((r317 & 4096) == 0) goto L53;
        Map r117 = r110.trackExtra;
    L54:
        Map r319 = r117;
        if ((r317 & 8192) == 0) goto L57;
        ECUrlModel r118 = r110.videoCoverImage;
    L58:
        ECUrlModel r320 = r118;
        if ((r317 & 16384) == 0) goto L61;
        Integer r119 = r110.initPosition;
    L62:
        Integer r321 = r119;
        if ((r317 & 32768) == 0) goto L65;
        boolean r120 = r110.isHeadV2;
    L66:
        boolean r322 = r120;
        if ((r317 & 65536) == 0) goto L69;
        boolean r121 = r110.isFromCache;
    L71:
        if ((r317 & 131072) == 0) goto L73;
        boolean r108 = r110.isFromLive;
    L75:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r319, r320, r321, r322, r121, r108);
    L73:
        r108 = r316;
        goto L75
    L69:
        r121 = r315;
        goto L71
    L65:
        r120 = r314;
        goto L66
    L61:
        r119 = r313;
        goto L62
    L57:
        r118 = r312;
        goto L58
    L53:
        r117 = r311;
        goto L54
    L49:
        r116 = r310;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
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

    public final Integer component1() {
        return this.showStyle;
    }

    public final boolean component10() {
        return this.fullscreenMode;
    }

    public final long component11() {
        return this.transformAnimStartTime;
    }

    public final ImageModel component12() {
        return this.lottie;
    }

    public final Map<String, String> component13() {
        return this.trackExtra;
    }

    public final ECUrlModel component14() {
        return this.videoCoverImage;
    }

    public final Integer component15() {
        return this.initPosition;
    }

    public final boolean component16() {
        return this.isHeadV2;
    }

    public final boolean component17() {
        return this.isFromCache;
    }

    public final boolean component18() {
        return this.isFromLive;
    }

    public final Integer component2() {
        return this.initState;
    }

    public final String component3() {
        return this.entryText;
    }

    public final Boolean component4() {
        return this.isHeadHasScrollMore;
    }

    public final Boolean component5() {
        return this.isHeadAreaLengthened;
    }

    public final ImageModel component6() {
        return this.playBackIcon;
    }

    public final Link component7() {
        return this.replayLink;
    }

    public final Link component8() {
        return this.livingLink;
    }

    public final ECUrlModel component9() {
        return this.bottomPrefixIcon;
    }

    public final PlayBackEntryVO copy(Integer r210, Integer r211, String r212, Boolean r213, Boolean r214, ImageModel r215, Link r216, Link r217, ECUrlModel r310, boolean r311, long r312, ImageModel r313, Map<String, String> r314, ECUrlModel r315, Integer r316, boolean r317, boolean r318, boolean r410) {
        return new PlayBackEntryVO(r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PlayBackEntryVO) == false) goto L42;
        PlayBackEntryVO r101 = (PlayBackEntryVO) r100;
        if (Intrinsics.areEqual(this.showStyle, r101.showStyle) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.initState, r101.initState) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.entryText, r101.entryText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isHeadHasScrollMore, r101.isHeadHasScrollMore) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.isHeadAreaLengthened, r101.isHeadAreaLengthened) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.playBackIcon, r101.playBackIcon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.replayLink, r101.replayLink) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.livingLink, r101.livingLink) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.bottomPrefixIcon, r101.bottomPrefixIcon) == true) goto L24;
        return false;
    L24:
        if (this.fullscreenMode == r101.fullscreenMode) goto L26;
        return false;
    L26:
        if (this.transformAnimStartTime == r101.transformAnimStartTime) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.lottie, r101.lottie) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.trackExtra, r101.trackExtra) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.videoCoverImage, r101.videoCoverImage) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.initPosition, r101.initPosition) == true) goto L36;
        return false;
    L36:
        if (this.isHeadV2 == r101.isHeadV2) goto L38;
        return false;
    L38:
        if (this.isFromCache == r101.isFromCache) goto L40;
        return false;
    L40:
        if (this.isFromLive == r101.isFromLive) goto L64;
        return false;
    L64:
        return true;
    L42:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v32, types: [int] */
    /* JADX WARN: Type inference failed for: r0v34, types: [int] */
    /* JADX WARN: Type inference failed for: r0v36, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v25, types: [int] */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Integer r100 = this.showStyle;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.initState;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.entryText;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.isHeadHasScrollMore;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.isHeadAreaLengthened;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        ImageModel r116 = this.playBackIcon;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Link r119 = this.replayLink;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Link r122 = this.livingLink;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        ECUrlModel r125 = this.bottomPrefixIcon;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        boolean r128 = this.fullscreenMode;
        ?? r129 = 1;
        ?? r130 = r128;
        if (r128 == false) goto L41;
        r130 = 1;
    L41:
        long r131 = this.transformAnimStartTime;
        int r132 = (((r127 + r130) * 31) + ((int) (r131 ^ (r131 >>> 32)))) * 31;
        ImageModel r133 = this.lottie;
        if (r133 == null) goto L44;
        int r134 = r133.hashCode();
    L45:
        int r135 = (r132 + r134) * 31;
        Map<String, String> r136 = this.trackExtra;
        if (r136 == null) goto L48;
        int r137 = r136.hashCode();
    L49:
        int r138 = (r135 + r137) * 31;
        ECUrlModel r139 = this.videoCoverImage;
        if (r139 == null) goto L52;
        int r140 = r139.hashCode();
    L53:
        int r141 = (r138 + r140) * 31;
        Integer r142 = this.initPosition;
        if (r142 == null) goto L56;
        r101 = r142.hashCode();
    L56:
        int r143 = (r141 + r101) * 31;
        boolean r144 = this.isHeadV2;
        ?? r145 = r144;
        if (r144 == false) goto L59;
        r145 = 1;
    L59:
        int r146 = (r143 + r145) * 31;
        boolean r147 = this.isFromCache;
        ?? r148 = r147;
        if (r147 == false) goto L62;
        r148 = 1;
    L62:
        int r149 = (r146 + r148) * 31;
        boolean r150 = this.isFromLive;
        if (r150 == true) goto L67;
        r129 = r150;
    L67:
        return r149 + r129;
    L52:
        r140 = 0;
        goto L53
    L48:
        r137 = 0;
        goto L49
    L44:
        r134 = 0;
        goto L45
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PlayBackEntryVO(showStyle=" + this.showStyle + ", initState=" + this.initState + ", entryText=" + this.entryText + ", isHeadHasScrollMore=" + this.isHeadHasScrollMore + ", isHeadAreaLengthened=" + this.isHeadAreaLengthened + ", playBackIcon=" + this.playBackIcon + ", replayLink=" + this.replayLink + ", livingLink=" + this.livingLink + ", bottomPrefixIcon=" + this.bottomPrefixIcon + ", fullscreenMode=" + this.fullscreenMode + ", transformAnimStartTime=" + this.transformAnimStartTime + ", lottie=" + this.lottie + ", trackExtra=" + this.trackExtra + ", videoCoverImage=" + this.videoCoverImage + ", initPosition=" + this.initPosition + ", isHeadV2=" + this.isHeadV2 + ", isFromCache=" + this.isFromCache + ", isFromLive=" + this.isFromLive + ")";
    }

    public final boolean a() {
        Integer r100 = this.initState;
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 0) goto L8;
        return true;
    }

    public final boolean enablePlayBackEntryAlphaTrans() {
        Integer r100 = this.showStyle;
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 5) goto L8;
        return true;
    }

    public final boolean isFloatEntryVisible() {
        Integer r100 = this.showStyle;
        if (r100 != null) goto L6;
    L7:
        Integer r101 = this.showStyle;
        if (r101 != null) goto L11;
    L14:
        return true;
    L11:
        if (r101.intValue() != 5) goto L14;
    L13:
        if (isShowLiveIcon() == true) goto L14;
        return false;
    L6:
        if (r100.intValue() == 0) goto L13;
        goto L7
    }

    public final boolean isShowLiveIcon() {
        Integer r100 = this.initState;
        if (r100 != null) goto L6;
    L16:
        return false;
    L6:
        if (r100.intValue() != 1) goto L16;
        if (this.isHeadV2 == false) goto L16;
        if (this.fullscreenMode == true) goto L14;
        if (this.isFromLive == true) goto L16;
    L14:
        if (this.livingLink == null) goto L16;
        return true;
    }

    public final boolean repositionEntryPosition() {
        Integer r100 = this.initPosition;
        if (r100 != null) goto L6;
    L7:
        Integer r101 = this.initPosition;
        if (r101 != null) goto L11;
    L13:
        return false;
    L11:
        if (r101.intValue() != 5) goto L13;
    L14:
        return true;
    L6:
        if (r100.intValue() == 4) goto L14;
        goto L7
    }

    public final boolean shouldGoneWithHead() {
        if (isFloatEntryVisible() == false) goto L10;
        Integer r100 = this.showStyle;
        if (r100 == null) goto L10;
        if (r100.intValue() != 3) goto L10;
        return true;
    L10:
        return false;
    }

    public final ECUrlModel getBottomPrefixIcon() {
        return this.bottomPrefixIcon;
    }

    public final String getEntryText() {
        return this.entryText;
    }

    public final boolean getFullscreenMode() {
        return this.fullscreenMode;
    }

    public final Integer getInitPosition() {
        return this.initPosition;
    }

    public final Integer getInitState() {
        return this.initState;
    }

    public final Link getLivingLink() {
        return this.livingLink;
    }

    public final ImageModel getLottie() {
        return this.lottie;
    }

    public final ImageModel getPlayBackIcon() {
        return this.playBackIcon;
    }

    public final Link getReplayLink() {
        return this.replayLink;
    }

    public final Integer getShowStyle() {
        return this.showStyle;
    }

    public final Map<String, String> getTrackExtra() {
        return this.trackExtra;
    }

    public final long getTransformAnimStartTime() {
        return this.transformAnimStartTime;
    }

    public final ECUrlModel getVideoCoverImage() {
        return this.videoCoverImage;
    }

    public final boolean isFromCache() {
        return this.isFromCache;
    }

    public final boolean isFromLive() {
        return this.isFromLive;
    }

    public final Boolean isHeadAreaLengthened() {
        return this.isHeadAreaLengthened;
    }

    public final Boolean isHeadHasScrollMore() {
        return this.isHeadHasScrollMore;
    }

    public final boolean isHeadV2() {
        return this.isHeadV2;
    }

    public final boolean enableIconSlideAnimation(Boolean r100) {
        if (r100 == null) goto L4;
        boolean r101 = r100.booleanValue();
    L5:
        if (r101 == false) goto L24;
        Integer r102 = this.showStyle;
        if (r102 != null) goto L10;
    L11:
        Integer r103 = this.showStyle;
        if (r103 != null) goto L15;
    L16:
        Integer r104 = this.showStyle;
        if (r104 == null) goto L24;
        if (r104.intValue() != 4) goto L24;
    L22:
        if (a() == true) goto L24;
        return true;
    L15:
        if (r103.intValue() == 3) goto L22;
    L10:
        if (r102.intValue() == 2) goto L22;
    L24:
        return false;
    L4:
        r101 = this.fullscreenMode;
        goto L5
    }

    public final boolean enablePlayBackEntryDraggable(Boolean r100) {
        if (r100 == null) goto L4;
        boolean r101 = r100.booleanValue();
    L5:
        if (r101 == false) goto L19;
        Integer r102 = this.showStyle;
        if (r102 != null) goto L10;
    L11:
        Integer r103 = this.showStyle;
        if (r103 == null) goto L19;
        if (r103.intValue() != 4) goto L19;
    L17:
        if (a() == true) goto L19;
        return true;
    L10:
        if (r102.intValue() == 3) goto L17;
    L19:
        return false;
    L4:
        r101 = this.fullscreenMode;
        goto L5
    }

    public final void setFromLive(boolean r100) {
        this.isFromLive = r100;
    }

    public final void setInitState(Integer r100) {
        this.initState = r100;
    }

    public final boolean showLottie(Boolean r100) {
        if (r100 == null) goto L4;
        boolean r101 = r100.booleanValue();
    L5:
        if (r101 == false) goto L14;
        Integer r102 = this.showStyle;
        if (r102 == null) goto L14;
        if (r102.intValue() != 2) goto L14;
        if (a() == true) goto L14;
        return true;
    L14:
        return false;
    L4:
        r101 = this.fullscreenMode;
        goto L5
    }

    public final boolean showNewStylePlayBackEntry(Boolean r100) {
        if (r100 == null) goto L4;
        boolean r101 = r100.booleanValue();
    L5:
        if (r101 == false) goto L24;
        Integer r102 = this.showStyle;
        if (r102 != null) goto L10;
    L11:
        Integer r103 = this.showStyle;
        if (r103 != null) goto L15;
    L16:
        Integer r104 = this.showStyle;
        if (r104 == null) goto L24;
        if (r104.intValue() != 4) goto L24;
    L22:
        if (a() == true) goto L24;
        return true;
    L15:
        if (r103.intValue() == 3) goto L22;
    L10:
        if (r102.intValue() == 2) goto L22;
    L24:
        return false;
    L4:
        r101 = this.fullscreenMode;
        goto L5
    }

    public final boolean showNewStylePlayBackEntryInComponent(Boolean r100) {
        if (r100 == null) goto L4;
        boolean r101 = r100.booleanValue();
    L5:
        if (r101 == false) goto L29;
        Integer r102 = this.showStyle;
        if (r102 != null) goto L10;
    L11:
        Integer r103 = this.showStyle;
        if (r103 != null) goto L15;
    L16:
        Integer r104 = this.showStyle;
        if (r104 != null) goto L20;
    L21:
        Integer r105 = this.showStyle;
        if (r105 == null) goto L29;
        if (r105.intValue() != 4) goto L29;
    L27:
        if (a() == true) goto L29;
        return true;
    L20:
        if (r104.intValue() == 3) goto L27;
    L15:
        if (r103.intValue() == 6) goto L27;
    L10:
        if (r102.intValue() == 2) goto L27;
    L29:
        return false;
    L4:
        r101 = this.fullscreenMode;
        goto L5
    }

    public static /* synthetic */ boolean enableIconSlideAnimation$default(PlayBackEntryVO r100, Boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        return r100.enableIconSlideAnimation(r101);
    }

    public static /* synthetic */ boolean enablePlayBackEntryDraggable$default(PlayBackEntryVO r100, Boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        return r100.enablePlayBackEntryDraggable(r101);
    }

    public static /* synthetic */ boolean showLottie$default(PlayBackEntryVO r100, Boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        return r100.showLottie(r101);
    }

    public static /* synthetic */ boolean showNewStylePlayBackEntry$default(PlayBackEntryVO r100, Boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        return r100.showNewStylePlayBackEntry(r101);
    }

    public static /* synthetic */ boolean showNewStylePlayBackEntryInComponent$default(PlayBackEntryVO r100, Boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        return r100.showNewStylePlayBackEntryInComponent(r101);
    }

    public PlayBackEntryVO(Integer r100, Integer r101, String r102, Boolean r103, Boolean r104, ImageModel r105, Link r110, Link r111, ECUrlModel r112, boolean r113, long r114, ImageModel r115, Map<String, String> r116, ECUrlModel r117, Integer r118, boolean r210, boolean r211, boolean r212) {
        this.showStyle = r100;
        this.initState = r101;
        this.entryText = r102;
        this.isHeadHasScrollMore = r103;
        this.isHeadAreaLengthened = r104;
        this.playBackIcon = r105;
        this.replayLink = r110;
        this.livingLink = r111;
        this.bottomPrefixIcon = r112;
        this.fullscreenMode = r113;
        this.transformAnimStartTime = r114;
        this.lottie = r115;
        this.trackExtra = r116;
        this.videoCoverImage = r117;
        this.initPosition = r118;
        this.isHeadV2 = r210;
        this.isFromCache = r211;
        this.isFromLive = r212;
    }

    public /* synthetic */ PlayBackEntryVO(Integer r210, Integer r211, String r212, Boolean r213, Boolean r214, ImageModel r215, Link r310, Link r311, ECUrlModel r312, boolean r313, long r314, ImageModel r315, Map r316, ECUrlModel r317, Integer r318, boolean r410, boolean r411, boolean r412, int r413, DefaultConstructorMarker r414) {
        if ((r413 & 4) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r413 & 8) == 0) goto L9;
        Boolean r101 = null;
    L11:
        if ((r413 & 16) == 0) goto L13;
        Boolean r102 = null;
    L15:
        if ((r413 & 32) == 0) goto L17;
        ImageModel r103 = null;
    L19:
        if ((r413 & 64) == 0) goto L21;
        Link r110 = null;
    L23:
        if ((r413 & 128) == 0) goto L25;
        Link r111 = null;
    L27:
        if ((r413 & 256) == 0) goto L29;
        ECUrlModel r112 = null;
    L31:
        if ((r413 & 512) == 0) goto L33;
        boolean r113 = false;
    L35:
        if ((r413 & 1024) == 0) goto L37;
        long r114 = 3000;
    L39:
        if ((r413 & 2048) == 0) goto L41;
        ImageModel r115 = null;
    L43:
        if ((r413 & 4096) == 0) goto L45;
        Map r116 = null;
    L47:
        if ((r413 & 8192) == 0) goto L49;
        ECUrlModel r117 = null;
    L51:
        if ((r413 & 16384) == 0) goto L53;
        Integer r118 = null;
    L55:
        if ((32768 & r413) == 0) goto L57;
        boolean r216 = false;
    L59:
        if ((65536 & r413) == 0) goto L61;
        boolean r217 = false;
    L63:
        if ((r413 & 131072) == 0) goto L65;
        boolean r218 = false;
    L66:
        this(r210, r211, r100, r101, r102, r103, r110, r111, r112, r113, r114, r115, r116, r117, r118, r216, r217, r218);
        return;
    L65:
        r218 = r412;
        goto L66
    L61:
        r217 = r411;
        goto L63
    L57:
        r216 = r410;
        goto L59
    L53:
        r118 = r318;
        goto L55
    L49:
        r117 = r317;
        goto L51
    L45:
        r116 = r316;
        goto L47
    L41:
        r115 = r315;
        goto L43
    L37:
        r114 = r314;
        goto L39
    L33:
        r113 = r313;
        goto L35
    L29:
        r112 = r312;
        goto L31
    L25:
        r111 = r311;
        goto L27
    L21:
        r110 = r310;
        goto L23
    L17:
        r103 = r215;
        goto L19
    L13:
        r102 = r214;
        goto L15
    L9:
        r101 = r213;
        goto L11
    L5:
        r100 = r212;
        goto L7
    }
}
