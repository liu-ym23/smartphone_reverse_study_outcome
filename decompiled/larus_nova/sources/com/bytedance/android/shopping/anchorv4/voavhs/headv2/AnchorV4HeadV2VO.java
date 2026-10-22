package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMetaMappedMap;
import com.bytedance.android.shopping.anchorv4.voavhs.ComponentIDs;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoOptionConstants;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b.\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0083\u0002\u0012\b\b\u0002\u00102\u001a\u00020\u0006\u0012\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0003\u0012\u0010\b\u0002\u00104\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u001c\u0012\u0016\b\u0002\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001e\u0012\u0016\b\u0002\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001e\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010:\u001a\u00020#\u0012\b\b\u0002\u0010;\u001a\u00020#\u0012\b\b\u0002\u0010<\u001a\u00020#\u0012\b\b\u0002\u0010=\u001a\u00020#\u0012\b\b\u0002\u0010>\u001a\u00020\u0006\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010#\u0012\u0016\b\u0002\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u000200\u0018\u00010\u001e¢\u0006\u0004\bt\u0010uJ\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003J#\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006J#\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0006J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u0017\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001eHÆ\u0003J\u0017\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001eHÆ\u0003J\u0012\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b!\u0010\"J\t\u0010$\u001a\u00020#HÆ\u0003J\t\u0010%\u001a\u00020#HÆ\u0003J\t\u0010&\u001a\u00020#HÆ\u0003J\t\u0010'\u001a\u00020#HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010)HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010+HÆ\u0003J\u0012\u0010-\u001a\u0004\u0018\u00010#HÆ\u0003¢\u0006\u0004\b-\u0010.J\u0012\u0010/\u001a\u0004\u0018\u00010#HÆ\u0003¢\u0006\u0004\b/\u0010.J\u0017\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u000200\u0018\u00010\u001eHÆ\u0003J\u008c\u0002\u0010D\u001a\u00020\u00002\b\b\u0002\u00102\u001a\u00020\u00062\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00032\u0010\b\u0002\u00104\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00032\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u001c2\u0016\b\u0002\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001e2\u0016\b\u0002\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001e2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010:\u001a\u00020#2\b\b\u0002\u0010;\u001a\u00020#2\b\b\u0002\u0010<\u001a\u00020#2\b\b\u0002\u0010=\u001a\u00020#2\b\b\u0002\u0010>\u001a\u00020\u00062\n\b\u0002\u0010?\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010#2\u0016\b\u0002\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u000200\u0018\u00010\u001eHÆ\u0001¢\u0006\u0004\bD\u0010EJ\t\u0010F\u001a\u00020\u0011HÖ\u0001J\t\u0010G\u001a\u00020\u0006HÖ\u0001J\u0013\u0010J\u001a\u00020#2\b\u0010I\u001a\u0004\u0018\u00010HHÖ\u0003R\"\u0010K\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0018\u0010Q\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u001a\u00102\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010S\u001a\u0004\bT\u0010UR\"\u00103\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010V\u001a\u0004\bW\u0010XR\"\u00104\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010V\u001a\u0004\bY\u0010XR\u001c\u00105\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010Z\u001a\u0004\b[\u0010\\R\u001c\u00106\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010]\u001a\u0004\b^\u0010_R(\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010`\u001a\u0004\ba\u0010bR(\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010`\u001a\u0004\bc\u0010bR\u001c\u00109\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010R\u001a\u0004\bd\u0010\"R\u001a\u0010:\u001a\u00020#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010L\u001a\u0004\be\u0010NR\u001a\u0010;\u001a\u00020#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010L\u001a\u0004\bf\u0010NR\u001a\u0010<\u001a\u00020#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010L\u001a\u0004\bg\u0010NR\u001a\u0010=\u001a\u00020#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010L\u001a\u0004\bh\u0010NR\u001a\u0010>\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010S\u001a\u0004\bi\u0010UR\u001c\u0010?\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b?\u0010j\u001a\u0004\bk\u0010lR\u001c\u0010@\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010m\u001a\u0004\bn\u0010oR\u001c\u0010A\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bA\u0010p\u001a\u0004\bq\u0010.R\u001c\u0010B\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bB\u0010p\u001a\u0004\br\u0010.R(\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u000200\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010`\u001a\u0004\bs\u0010b¨\u0006v"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/AnchorV4HeadV2VO;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/VOIdentifier;", "Ljava/io/Serializable;", "", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/m;", "getHeaderTabs", "", "position", "subPosition", "Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "getVideoData", "(ILjava/lang/Integer;)Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderContentModel;", "getMultiPreviewCell", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderMediaModel;", "getVideoMedia", "(ILjava/lang/Integer;)Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderMediaModel;", "", LocationMonitorConst.IDENTIFIER, "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/i;", "getCellStyle", "getLastScaleIndex", "component1", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantModel;", "component2", "component3", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPreviewMeta;", "component4", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ScrollContainerFooter;", "component5", "", "component6", "component7", "component8", "()Ljava/lang/Integer;", "", "component9", "component10", "component11", "component12", "component13", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/g;", "component14", "Lcom/bytedance/android/ec/model/ECUrlModel;", "component15", "component16", "()Ljava/lang/Boolean;", "component17", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "component18", "sizeType", "pendants", "cells", "previewMeta", ContainerPosition.FOOTER, "trackMeta", "actionMeta", "bottomHeight", "enableBottomFillBlur", "needSortPreview", "enableVideoCollection", "enableAIVideo", "changeKeyPosition", "containerConfig", "fakeVideoIcon", "enableLego26", "enablePreviewList", "actionMap", "copy", "(ILjava/util/List;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPreviewMeta;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ScrollContainerFooter;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Integer;ZZZZILcom/bytedance/android/shopping/anchorv4/voavhs/headv2/g;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/Map;)Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/AnchorV4HeadV2VO;", "toString", "hashCode", "", "other", "equals", "localIsFromJisoo", "Z", "getLocalIsFromJisoo", "()Z", "setLocalIsFromJisoo", "(Z)V", "localLastScaleCellIndex", "Ljava/lang/Integer;", "I", "getSizeType", "()I", "Ljava/util/List;", "getPendants", "()Ljava/util/List;", "getCells", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPreviewMeta;", "getPreviewMeta", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPreviewMeta;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ScrollContainerFooter;", "getFooter", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ScrollContainerFooter;", "Ljava/util/Map;", "getTrackMeta", "()Ljava/util/Map;", "getActionMeta", "getBottomHeight", "getEnableBottomFillBlur", "getNeedSortPreview", "getEnableVideoCollection", "getEnableAIVideo", "getChangeKeyPosition", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/g;", "getContainerConfig", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/g;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getFakeVideoIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "Ljava/lang/Boolean;", "getEnableLego26", "getEnablePreviewList", "getActionMap", "<init>", "(ILjava/util/List;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPreviewMeta;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ScrollContainerFooter;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Integer;ZZZZILcom/bytedance/android/shopping/anchorv4/voavhs/headv2/g;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/Map;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4HeadV2VO extends VOIdentifier implements Serializable {

    @SerializedName("action_map")
    private final Map<String, IAction> actionMap;

    @SerializedName("action_meta")
    private final Map<String, String> actionMeta;

    @SerializedName("bottom_height")
    private final Integer bottomHeight;

    @SerializedName("cells")
    private final List<HeaderContentModel> cells;

    @SerializedName("change_key_position")
    private final int changeKeyPosition;

    @SerializedName("container_config")
    private final g containerConfig;

    @SerializedName("enable_ai_video")
    private final boolean enableAIVideo;

    @SerializedName("enable_bottom_fill_blur")
    private final boolean enableBottomFillBlur;

    @SerializedName("enable_lego_26")
    private final Boolean enableLego26;

    @SerializedName("enable_preview_list")
    private final Boolean enablePreviewList;

    @SerializedName("enable_video_collection")
    private final boolean enableVideoCollection;

    @SerializedName("video_center_icon")
    private final ECUrlModel fakeVideoIcon;

    @SerializedName(ContainerPosition.FOOTER)
    private final ScrollContainerFooter footer;
    private boolean localIsFromJisoo;
    private Integer localLastScaleCellIndex;

    @SerializedName("need_sort_preview")
    private final boolean needSortPreview;

    @SerializedName("pendants")
    private final List<HeaderPendantModel> pendants;

    @SerializedName(FileInfoOptionConstants.OPTION_PREVIEW_META)
    private final HeaderPreviewMeta previewMeta;

    @SerializedName("size_type")
    private final int sizeType;

    @SerializedName(PageMetaMappedMap.TRACK_META_KEY)
    private final Map<String, String> trackMeta;

    public AnchorV4HeadV2VO() {
        this(0, null, null, null, null, null, null, null, false, false, false, false, 0, null, null, null, null, null, 262143, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4HeadV2VO copy$default(AnchorV4HeadV2VO r110, int r111, List r112, List r210, HeaderPreviewMeta r211, ScrollContainerFooter r212, Map r213, Map r214, Integer r215, boolean r216, boolean r217, boolean r218, boolean r219, int r310, g r311, ECUrlModel r312, Boolean r313, Boolean r314, Map r315, int r316, Object r317) {
        if ((r316 & 1) == 0) goto L5;
        int r100 = r110.sizeType;
    L7:
        if ((r316 & 2) == 0) goto L9;
        List r101 = r110.pendants;
    L11:
        if ((r316 & 4) == 0) goto L13;
        List r102 = r110.cells;
    L15:
        if ((r316 & 8) == 0) goto L17;
        HeaderPreviewMeta r103 = r110.previewMeta;
    L19:
        if ((r316 & 16) == 0) goto L21;
        ScrollContainerFooter r104 = r110.footer;
    L23:
        if ((r316 & 32) == 0) goto L25;
        Map r105 = r110.trackMeta;
    L27:
        if ((r316 & 64) == 0) goto L29;
        Map r106 = r110.actionMeta;
    L31:
        if ((r316 & 128) == 0) goto L33;
        Integer r107 = r110.bottomHeight;
    L35:
        if ((r316 & 256) == 0) goto L37;
        boolean r113 = r110.enableBottomFillBlur;
    L39:
        if ((r316 & 512) == 0) goto L41;
        boolean r114 = r110.needSortPreview;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        boolean r115 = r110.enableVideoCollection;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        boolean r116 = r110.enableAIVideo;
    L51:
        if ((r316 & 4096) == 0) goto L53;
        int r117 = r110.changeKeyPosition;
    L55:
        if ((r316 & 8192) == 0) goto L57;
        g r118 = r110.containerConfig;
    L58:
        g r318 = r118;
        if ((r316 & 16384) == 0) goto L61;
        ECUrlModel r119 = r110.fakeVideoIcon;
    L62:
        ECUrlModel r319 = r119;
        if ((r316 & 32768) == 0) goto L65;
        Boolean r120 = r110.enableLego26;
    L66:
        Boolean r320 = r120;
        if ((r316 & 65536) == 0) goto L69;
        Boolean r121 = r110.enablePreviewList;
    L71:
        if ((r316 & 131072) == 0) goto L73;
        Map r108 = r110.actionMap;
    L75:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r318, r319, r320, r121, r108);
    L73:
        r108 = r315;
        goto L75
    L69:
        r121 = r314;
        goto L71
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
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

    public final int component1() {
        return this.sizeType;
    }

    public final boolean component10() {
        return this.needSortPreview;
    }

    public final boolean component11() {
        return this.enableVideoCollection;
    }

    public final boolean component12() {
        return this.enableAIVideo;
    }

    public final int component13() {
        return this.changeKeyPosition;
    }

    public final g component14() {
        return this.containerConfig;
    }

    public final ECUrlModel component15() {
        return this.fakeVideoIcon;
    }

    public final Boolean component16() {
        return this.enableLego26;
    }

    public final Boolean component17() {
        return this.enablePreviewList;
    }

    public final Map<String, IAction> component18() {
        return this.actionMap;
    }

    public final List<HeaderPendantModel> component2() {
        return this.pendants;
    }

    public final List<HeaderContentModel> component3() {
        return this.cells;
    }

    public final HeaderPreviewMeta component4() {
        return this.previewMeta;
    }

    public final ScrollContainerFooter component5() {
        return this.footer;
    }

    public final Map<String, String> component6() {
        return this.trackMeta;
    }

    public final Map<String, String> component7() {
        return this.actionMeta;
    }

    public final Integer component8() {
        return this.bottomHeight;
    }

    public final boolean component9() {
        return this.enableBottomFillBlur;
    }

    public final AnchorV4HeadV2VO copy(int r210, List<HeaderPendantModel> r211, List<HeaderContentModel> r212, HeaderPreviewMeta r213, ScrollContainerFooter r214, Map<String, String> r215, Map<String, String> r216, Integer r217, boolean r218, boolean r310, boolean r311, boolean r312, int r313, g r314, ECUrlModel r315, Boolean r316, Boolean r317, Map<String, ? extends IAction> r318) {
        return new AnchorV4HeadV2VO(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, r318);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorV4HeadV2VO) == false) goto L42;
        AnchorV4HeadV2VO r101 = (AnchorV4HeadV2VO) r100;
        if (this.sizeType == r101.sizeType) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.pendants, r101.pendants) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.cells, r101.cells) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.previewMeta, r101.previewMeta) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.footer, r101.footer) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.trackMeta, r101.trackMeta) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.actionMeta, r101.actionMeta) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.bottomHeight, r101.bottomHeight) == true) goto L22;
        return false;
    L22:
        if (this.enableBottomFillBlur == r101.enableBottomFillBlur) goto L24;
        return false;
    L24:
        if (this.needSortPreview == r101.needSortPreview) goto L26;
        return false;
    L26:
        if (this.enableVideoCollection == r101.enableVideoCollection) goto L28;
        return false;
    L28:
        if (this.enableAIVideo == r101.enableAIVideo) goto L30;
        return false;
    L30:
        if (this.changeKeyPosition == r101.changeKeyPosition) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.containerConfig, r101.containerConfig) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.fakeVideoIcon, r101.fakeVideoIcon) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.enableLego26, r101.enableLego26) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.enablePreviewList, r101.enablePreviewList) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.actionMap, r101.actionMap) == true) goto L64;
        return false;
    L64:
        return true;
    L42:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v22, types: [int] */
    /* JADX WARN: Type inference failed for: r1v24, types: [int] */
    /* JADX WARN: Type inference failed for: r1v26, types: [int] */
    /* JADX WARN: Type inference failed for: r1v46 */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r1v56 */
    /* JADX WARN: Type inference failed for: r1v57 */
    /* JADX WARN: Type inference failed for: r1v58 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int r100 = this.sizeType * 31;
        List<HeaderPendantModel> r101 = this.pendants;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        List<HeaderContentModel> r105 = this.cells;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        HeaderPreviewMeta r108 = this.previewMeta;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        ScrollContainerFooter r111 = this.footer;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        Map<String, String> r114 = this.trackMeta;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (r113 + r115) * 31;
        Map<String, String> r117 = this.actionMeta;
        if (r117 == null) goto L25;
        int r118 = r117.hashCode();
    L26:
        int r119 = (r116 + r118) * 31;
        Integer r120 = this.bottomHeight;
        if (r120 == null) goto L29;
        int r121 = r120.hashCode();
    L30:
        int r122 = (r119 + r121) * 31;
        boolean r123 = this.enableBottomFillBlur;
        ?? r124 = 1;
        ?? r125 = r123;
        if (r123 == false) goto L33;
        r125 = 1;
    L33:
        int r126 = (r122 + r125) * 31;
        boolean r127 = this.needSortPreview;
        ?? r128 = r127;
        if (r127 == false) goto L36;
        r128 = 1;
    L36:
        int r129 = (r126 + r128) * 31;
        boolean r130 = this.enableVideoCollection;
        ?? r131 = r130;
        if (r130 == false) goto L39;
        r131 = 1;
    L39:
        int r132 = (r129 + r131) * 31;
        boolean r133 = this.enableAIVideo;
        if (r133 == true) goto L43;
        r124 = r133;
    L43:
        int r134 = (((r132 + r124) * 31) + this.changeKeyPosition) * 31;
        g r135 = this.containerConfig;
        if (r135 == null) goto L46;
        int r136 = r135.hashCode();
    L47:
        int r137 = (r134 + r136) * 31;
        ECUrlModel r138 = this.fakeVideoIcon;
        if (r138 == null) goto L50;
        int r139 = r138.hashCode();
    L51:
        int r140 = (r137 + r139) * 31;
        Boolean r141 = this.enableLego26;
        if (r141 == null) goto L54;
        int r142 = r141.hashCode();
    L55:
        int r143 = (r140 + r142) * 31;
        Boolean r144 = this.enablePreviewList;
        if (r144 == null) goto L58;
        int r145 = r144.hashCode();
    L59:
        int r146 = (r143 + r145) * 31;
        Map<String, IAction> r147 = this.actionMap;
        if (r147 == null) goto L63;
        r102 = r147.hashCode();
    L63:
        return r146 + r102;
    L58:
        r145 = 0;
        goto L59
    L54:
        r142 = 0;
        goto L55
    L50:
        r139 = 0;
        goto L51
    L46:
        r136 = 0;
        goto L47
    L29:
        r121 = 0;
        goto L30
    L25:
        r118 = 0;
        goto L26
    L21:
        r115 = 0;
        goto L22
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "AnchorV4HeadV2VO(sizeType=" + this.sizeType + ", pendants=" + this.pendants + ", cells=" + this.cells + ", previewMeta=" + this.previewMeta + ", footer=" + this.footer + ", trackMeta=" + this.trackMeta + ", actionMeta=" + this.actionMeta + ", bottomHeight=" + this.bottomHeight + ", enableBottomFillBlur=" + this.enableBottomFillBlur + ", needSortPreview=" + this.needSortPreview + ", enableVideoCollection=" + this.enableVideoCollection + ", enableAIVideo=" + this.enableAIVideo + ", changeKeyPosition=" + this.changeKeyPosition + ", containerConfig=" + this.containerConfig + ", fakeVideoIcon=" + this.fakeVideoIcon + ", enableLego26=" + this.enableLego26 + ", enablePreviewList=" + this.enablePreviewList + ", actionMap=" + this.actionMap + ")";
    }

    public final List<m> getHeaderTabs() {
        List<HeaderPendantModel> r100 = this.pendants;
        if (r100 == null) goto L20;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((HeaderPendantModel) r102).getId(), "tab") == false) goto L6;
    L11:
        HeaderPendantModel r103 = (HeaderPendantModel) r102;
        if (r103 == null) goto L21;
        HeaderPendantNative r104 = r103.getNative();
        if (r104 != null) goto L16;
        return null;
    L16:
        return r104.getHeaderTabs();
    L21:
        return null;
    L10:
        r102 = null;
        goto L11
    L20:
        return null;
    }

    public final int getLastScaleIndex() {
        if (this.localLastScaleCellIndex != null) goto L22;
        this.localLastScaleCellIndex = -1;
        List<HeaderContentModel> r100 = this.cells;
        int r101 = 0;
        if (r100 == null) goto L7;
        int r102 = r100.size();
    L8:
        if (r101 >= r102) goto L22;
        List<HeaderContentModel> r103 = this.cells;
        if (r103 == null) goto L16;
        HeaderContentModel r104 = (HeaderContentModel) CollectionsKt.getOrNull(r103, r101);
        if (r104 == null) goto L16;
        i r105 = r104.getStyle();
        if (r105 == null) goto L16;
        Float r106 = r105.a();
    L17:
        if (r106 == null) goto L22;
        if (r106.floatValue() >= 1.0f) goto L22;
        this.localLastScaleCellIndex = Integer.valueOf(r101);
        r101 = r101 + 1;
    L16:
        r106 = null;
        goto L17
    L7:
        r102 = 0;
    L22:
        Integer r107 = this.localLastScaleCellIndex;
        if (r107 != null) goto L25;
        return -1;
    L25:
        return r107.intValue();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier
    public String identifier() {
        return ComponentIDs.HEAD_SLIDES.getId();
    }

    public final Map<String, IAction> getActionMap() {
        return this.actionMap;
    }

    public final Map<String, String> getActionMeta() {
        return this.actionMeta;
    }

    public final Integer getBottomHeight() {
        return this.bottomHeight;
    }

    public final List<HeaderContentModel> getCells() {
        return this.cells;
    }

    public final int getChangeKeyPosition() {
        return this.changeKeyPosition;
    }

    public final g getContainerConfig() {
        return this.containerConfig;
    }

    public final boolean getEnableAIVideo() {
        return this.enableAIVideo;
    }

    public final boolean getEnableBottomFillBlur() {
        return this.enableBottomFillBlur;
    }

    public final Boolean getEnableLego26() {
        return this.enableLego26;
    }

    public final Boolean getEnablePreviewList() {
        return this.enablePreviewList;
    }

    public final boolean getEnableVideoCollection() {
        return this.enableVideoCollection;
    }

    public final ECUrlModel getFakeVideoIcon() {
        return this.fakeVideoIcon;
    }

    public final ScrollContainerFooter getFooter() {
        return this.footer;
    }

    public final boolean getLocalIsFromJisoo() {
        return this.localIsFromJisoo;
    }

    public final boolean getNeedSortPreview() {
        return this.needSortPreview;
    }

    public final List<HeaderPendantModel> getPendants() {
        return this.pendants;
    }

    public final HeaderPreviewMeta getPreviewMeta() {
        return this.previewMeta;
    }

    public final int getSizeType() {
        return this.sizeType;
    }

    public final Map<String, String> getTrackMeta() {
        return this.trackMeta;
    }

    public final i getCellStyle(int r100) {
        List<HeaderContentModel> r101 = this.cells;
        if (r101 == null) goto L7;
        HeaderContentModel r102 = (HeaderContentModel) CollectionsKt.getOrNull(r101, r100);
        if (r102 == null) goto L7;
        return r102.getStyle();
    L7:
        return null;
    }

    public final void setLocalIsFromJisoo(boolean r100) {
        this.localIsFromJisoo = r100;
    }

    public final HeaderContentModel getMultiPreviewCell(int r100, int r101) {
        List<HeaderContentModel> r102 = this.cells;
        if (r102 == null) goto L13;
        HeaderContentModel r103 = (HeaderContentModel) CollectionsKt.getOrNull(r102, r100);
        if (r103 == null) goto L13;
        r r104 = r103.getMultiPreview();
        if (r104 == null) goto L13;
        List<k> r105 = r104.a();
        if (r105 == null) goto L13;
        k r106 = (k) CollectionsKt.getOrNull(r105, r101);
        if (r106 == null) goto L13;
        return r106.a();
    L13:
        return null;
    }

    public final VideoModel getVideoData(int r100, Integer r101) {
        if (r101 != null) goto L20;
        List<HeaderContentModel> r102 = this.cells;
        if (r102 == null) goto L14;
        HeaderContentModel r103 = (HeaderContentModel) CollectionsKt.getOrNull(r102, r100);
        if (r103 == null) goto L14;
        HeaderMediaModel r104 = r103.getMedia();
        if (r104 == null) goto L14;
        VideoModel r105 = r104.getVideo();
        if (r105 == null) goto L14;
        return r105;
    L14:
        HeaderContentModel r106 = getMultiPreviewCell(r100, 0);
        if (r106 == null) goto L35;
        HeaderMediaModel r107 = r106.getMedia();
        if (r107 != null) goto L37;
        return null;
    L37:
        return r107.getVideo();
    L35:
        return null;
    L20:
        if (r101.intValue() >= 0) goto L28;
        List<HeaderContentModel> r108 = this.cells;
        if (r108 == null) goto L38;
        HeaderContentModel r109 = (HeaderContentModel) CollectionsKt.getOrNull(r108, r100);
        if (r109 == null) goto L39;
        HeaderMediaModel r110 = r109.getMedia();
        if (r110 != null) goto L41;
        return null;
    L41:
        return r110.getVideo();
    L39:
        return null;
    L38:
        return null;
    L28:
        HeaderContentModel r111 = getMultiPreviewCell(r100, r101.intValue());
        if (r111 == null) goto L42;
        HeaderMediaModel r112 = r111.getMedia();
        if (r112 != null) goto L33;
        return null;
    L33:
        return r112.getVideo();
    L42:
        return null;
    }

    public final HeaderMediaModel getVideoMedia(int r100, Integer r101) {
        if (r101 != null) goto L16;
        List<HeaderContentModel> r102 = this.cells;
        if (r102 == null) goto L12;
        HeaderContentModel r103 = (HeaderContentModel) CollectionsKt.getOrNull(r102, r100);
        if (r103 == null) goto L12;
        HeaderMediaModel r104 = r103.getMedia();
        if (r104 == null) goto L12;
        return r104;
    L12:
        HeaderContentModel r105 = getMultiPreviewCell(r100, 0);
        if (r105 != null) goto L28;
        return null;
    L28:
        return r105.getMedia();
    L16:
        if (r101.intValue() >= 0) goto L22;
        List<HeaderContentModel> r106 = this.cells;
        if (r106 == null) goto L29;
        HeaderContentModel r107 = (HeaderContentModel) CollectionsKt.getOrNull(r106, r100);
        if (r107 != null) goto L31;
        return null;
    L31:
        return r107.getMedia();
    L29:
        return null;
    L22:
        HeaderContentModel r108 = getMultiPreviewCell(r100, r101.intValue());
        if (r108 != null) goto L25;
        return null;
    L25:
        return r108.getMedia();
    }

    public static /* synthetic */ HeaderContentModel getMultiPreviewCell$default(AnchorV4HeadV2VO r100, int r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        return r100.getMultiPreviewCell(r101, r102);
    }

    public static /* synthetic */ VideoModel getVideoData$default(AnchorV4HeadV2VO r100, int r101, Integer r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.getVideoData(r101, r102);
    }

    public static /* synthetic */ HeaderMediaModel getVideoMedia$default(AnchorV4HeadV2VO r100, int r101, Integer r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.getVideoMedia(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4HeadV2VO(int r100, List<HeaderPendantModel> r101, List<HeaderContentModel> r102, HeaderPreviewMeta r103, ScrollContainerFooter r110, Map<String, String> r111, Map<String, String> r112, Integer r113, boolean r114, boolean r115, boolean r116, boolean r117, int r118, g r119, ECUrlModel r210, Boolean r211, Boolean r212, Map<String, ? extends IAction> r213) {
        this.sizeType = r100;
        this.pendants = r101;
        this.cells = r102;
        this.previewMeta = r103;
        this.footer = r110;
        this.trackMeta = r111;
        this.actionMeta = r112;
        this.bottomHeight = r113;
        this.enableBottomFillBlur = r114;
        this.needSortPreview = r115;
        this.enableVideoCollection = r116;
        this.enableAIVideo = r117;
        this.changeKeyPosition = r118;
        this.containerConfig = r119;
        this.fakeVideoIcon = r210;
        this.enableLego26 = r211;
        this.enablePreviewList = r212;
        this.actionMap = r213;
        VOIdentifier.scrollConfig$default(this, ComponentIDs.HEAD_SLIDES.getId(), 0, 2, null);
    }

    public /* synthetic */ AnchorV4HeadV2VO(int r210, List r211, List r212, HeaderPreviewMeta r213, ScrollContainerFooter r214, Map r215, Map r216, Integer r217, boolean r218, boolean r219, boolean r310, boolean r311, int r312, g r313, ECUrlModel r314, Boolean r315, Boolean r316, Map r317, int r318, DefaultConstructorMarker r319) {
        int r100 = 0;
        if ((r318 & 1) == 0) goto L5;
        int r101 = 0;
    L7:
        if ((r318 & 2) == 0) goto L9;
        List r102 = null;
    L11:
        if ((r318 & 4) == 0) goto L13;
        List r103 = null;
    L15:
        if ((r318 & 8) == 0) goto L17;
        HeaderPreviewMeta r104 = null;
    L19:
        if ((r318 & 16) == 0) goto L21;
        ScrollContainerFooter r105 = null;
    L23:
        if ((r318 & 32) == 0) goto L25;
        Map r106 = null;
    L27:
        if ((r318 & 64) == 0) goto L29;
        Map r107 = null;
    L31:
        if ((r318 & 128) == 0) goto L33;
        Integer r110 = null;
    L35:
        if ((r318 & 256) == 0) goto L37;
        boolean r111 = true;
    L39:
        if ((r318 & 512) == 0) goto L41;
        boolean r112 = false;
    L43:
        if ((r318 & 1024) == 0) goto L45;
        boolean r113 = false;
    L47:
        if ((r318 & 2048) == 0) goto L49;
        boolean r114 = false;
    L51:
        if ((r318 & 4096) != 0) goto L55;
        r100 = r312;
    L55:
        if ((r318 & 8192) == 0) goto L57;
        g r115 = null;
    L59:
        if ((r318 & 16384) == 0) goto L61;
        ECUrlModel r108 = null;
    L63:
        if ((r318 & 32768) == 0) goto L65;
        Boolean r116 = null;
    L67:
        if ((r318 & 65536) == 0) goto L69;
        Boolean r117 = null;
    L71:
        if ((r318 & 131072) == 0) goto L73;
        Map r109 = null;
    L74:
        this(r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r100, r115, r108, r116, r117, r109);
        return;
    L73:
        r109 = r317;
        goto L74
    L69:
        r117 = r316;
        goto L71
    L65:
        r116 = r315;
        goto L67
    L61:
        r108 = r314;
        goto L63
    L57:
        r115 = r313;
        goto L59
    L49:
        r114 = r311;
        goto L51
    L45:
        r113 = r310;
        goto L47
    L41:
        r112 = r219;
        goto L43
    L37:
        r111 = r218;
        goto L39
    L33:
        r110 = r217;
        goto L35
    L29:
        r107 = r216;
        goto L31
    L25:
        r106 = r215;
        goto L27
    L21:
        r105 = r214;
        goto L23
    L17:
        r104 = r213;
        goto L19
    L13:
        r103 = r212;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r101 = r210;
        goto L7
    }
}
