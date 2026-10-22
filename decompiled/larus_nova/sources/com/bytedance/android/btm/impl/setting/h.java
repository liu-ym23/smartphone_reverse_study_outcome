package com.bytedance.android.btm.impl.setting;

import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.ugc.aweme.lazydata.LazyData;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0003\b\u0096\u0001\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\b²\u0001\u0010³\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\fR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\fR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\fR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\fR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\fR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\fR\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b&\u0010\fR\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\fR\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\fR\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\fR\"\u00100\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\fR\"\u00103\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0004\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\fR\"\u00106\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010\u0004\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\fR\"\u00109\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010\u0004\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\fR\"\u0010<\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010\u0004\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\fR\"\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010\u0004\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\fR\"\u0010B\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010\u0004\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\fR\"\u0010E\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010\u0004\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\fR\"\u0010H\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010\u0004\u001a\u0004\bI\u0010\u0006\"\u0004\bJ\u0010\fR\"\u0010K\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010\u0004\u001a\u0004\bL\u0010\u0006\"\u0004\bM\u0010\fR\"\u0010N\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bN\u0010\u0004\u001a\u0004\bO\u0010\u0006\"\u0004\bP\u0010\fR\"\u0010Q\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bQ\u0010\u0004\u001a\u0004\bR\u0010\u0006\"\u0004\bS\u0010\fR\"\u0010T\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bT\u0010\u0004\u001a\u0004\bU\u0010\u0006\"\u0004\bV\u0010\fR\"\u0010W\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bW\u0010\u0004\u001a\u0004\bX\u0010\u0006\"\u0004\bY\u0010\fR\"\u0010Z\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bZ\u0010\u0004\u001a\u0004\b[\u0010\u0006\"\u0004\b\\\u0010\fR\"\u0010]\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b]\u0010\u0004\u001a\u0004\b^\u0010\u0006\"\u0004\b_\u0010\fR\"\u0010`\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b`\u0010\u0004\u001a\u0004\ba\u0010\u0006\"\u0004\bb\u0010\fR\"\u0010c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bc\u0010\u0004\u001a\u0004\bd\u0010\u0006\"\u0004\be\u0010\fR\"\u0010f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bf\u0010\u0004\u001a\u0004\bg\u0010\u0006\"\u0004\bh\u0010\fR\"\u0010i\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bi\u0010\u0004\u001a\u0004\bj\u0010\u0006\"\u0004\bk\u0010\fR\"\u0010l\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bl\u0010\u0004\u001a\u0004\bm\u0010\u0006\"\u0004\bn\u0010\fR\"\u0010o\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bo\u0010\u0004\u001a\u0004\bp\u0010\u0006\"\u0004\bq\u0010\fR\"\u0010r\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\br\u0010\u0004\u001a\u0004\bs\u0010\u0006\"\u0004\bt\u0010\fR\"\u0010u\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bu\u0010\u0004\u001a\u0004\bv\u0010\u0006\"\u0004\bw\u0010\fR\"\u0010x\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bx\u0010\u0004\u001a\u0004\by\u0010\u0006\"\u0004\bz\u0010\fR\"\u0010{\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b{\u0010\u0004\u001a\u0004\b|\u0010\u0006\"\u0004\b}\u0010\fR#\u0010~\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0013\n\u0004\b~\u0010\u0004\u001a\u0004\b\u007f\u0010\u0006\"\u0005\b\u0080\u0001\u0010\fR&\u0010\u0081\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0081\u0001\u0010\u0004\u001a\u0005\b\u0082\u0001\u0010\u0006\"\u0005\b\u0083\u0001\u0010\fR&\u0010\u0084\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0084\u0001\u0010\u0004\u001a\u0005\b\u0085\u0001\u0010\u0006\"\u0005\b\u0086\u0001\u0010\fR&\u0010\u0087\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0087\u0001\u0010\u0004\u001a\u0005\b\u0088\u0001\u0010\u0006\"\u0005\b\u0089\u0001\u0010\fR&\u0010\u008a\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008a\u0001\u0010\u0004\u001a\u0005\b\u008b\u0001\u0010\u0006\"\u0005\b\u008c\u0001\u0010\fR&\u0010\u008d\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008d\u0001\u0010\u0004\u001a\u0005\b\u008e\u0001\u0010\u0006\"\u0005\b\u008f\u0001\u0010\fR&\u0010\u0090\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0090\u0001\u0010\u0004\u001a\u0005\b\u0091\u0001\u0010\u0006\"\u0005\b\u0092\u0001\u0010\fR&\u0010\u0093\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0093\u0001\u0010\u0004\u001a\u0005\b\u0094\u0001\u0010\u0006\"\u0005\b\u0095\u0001\u0010\fR&\u0010\u0096\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0096\u0001\u0010\u0004\u001a\u0005\b\u0097\u0001\u0010\u0006\"\u0005\b\u0098\u0001\u0010\fR1\u0010\u009b\u0001\u001a\n\u0012\u0005\u0012\u00030\u009a\u00010\u0099\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u009b\u0001\u0010\u009c\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010 \u0001R&\u0010¡\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¡\u0001\u0010\u0004\u001a\u0005\b¢\u0001\u0010\u0006\"\u0005\b£\u0001\u0010\fR&\u0010¤\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¤\u0001\u0010\u0004\u001a\u0005\b¥\u0001\u0010\u0006\"\u0005\b¦\u0001\u0010\fR&\u0010§\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b§\u0001\u0010\u0004\u001a\u0005\b¨\u0001\u0010\u0006\"\u0005\b©\u0001\u0010\fR8\u0010¬\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u009a\u0001\u0012\u0005\u0012\u00030«\u00010ª\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b¬\u0001\u0010\u00ad\u0001\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001¨\u0006´\u0001"}, d2 = {"Lcom/bytedance/android/btm/impl/setting/h;", "", "", "judgeTopActivity", "I", "V", "()I", "fixPageBufferNull", "getFixPageBufferNull", "fixBackActivityResumeFilter", "getFixBackActivityResumeFilter", "setFixBackActivityResumeFilter", "(I)V", "fixBackgroundResumeFilter", "p", "setFixBackgroundResumeFilter", "fixBackGround", ce.f26395j, "setFixBackGround", "fixRegisterPageWhenNotResume", "O", "setFixRegisterPageWhenNotResume", "fixFERegisterResume", "y", "setFixFERegisterResume", "fixPostResume", "K", "setFixPostResume", "fixBackInternal", ce.f26396k, "setFixBackInternal", "fixBackProcess", OfficeSDKRequestTag.KEY_NEW_USER, "setFixBackProcess", "fixEnterPageFilterSamePage", "x", "setFixEnterPageFilterSamePage", "fixPollBuffer", "setFixPollBuffer", "fixUnknownEvent", ExifInterface.LATITUDE_SOUTH, "setFixUnknownEvent", "fixUnknownPre", ExifInterface.GPS_DIRECTION_TRUE, "setFixUnknownPre", "fixUnknownPre2", "U", "setFixUnknownPre2", "appObserveV2", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAppObserveV2", "fixPageShowGap", FaceService.neutralLabel, "setFixPageShowGap", "fixRefreshShowId", "M", "setFixRefreshShowId", "fixDisableUserVisibleHint", "u", "setFixDisableUserVisibleHint", "fixAOP", "getFixAOP", "setFixAOP", "fixPollSelfBuffer", "J", "setFixPollSelfBuffer", "fixFilterTopActivity", "getFixFilterTopActivity", "setFixFilterTopActivity", "fixDecorView", "t", "setFixDecorView", "fixFragmentView", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "setFixFragmentView", "disableUserVisibleHintAOP", "c", "setDisableUserVisibleHintAOP", "fixEnterNewPage", BaseSwitches.V, "setFixEnterNewPage", "fixReuse", "P", "setFixReuse", "fixShowAPI", "Q", "setFixShowAPI", "fixBackResumerSort", "o", "setFixBackResumerSort", "fixBackInternalSort", "m", "setFixBackInternalSort", "fixBackInternalParent", "l", "setFixBackInternalParent", "fixNativeState", "C", "setFixNativeState", "fixEnterPage", "w", "setFixEnterPage", "fixAuto", RXScreenCaptureService.KEY_INDEX, "setFixAuto", "fixRegisterDelay", "N", "setFixRegisterDelay", "fixMultiTopActivity", "B", "setFixMultiTopActivity", "fixLastPageShow", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setFixLastPageShow", "fixAddNode", ce.f26391f, "setFixAddNode", "fixBcmDescriptionBigSize", "q", "setFixBcmDescriptionBigSize", "fixPageParams", FaceService.girlLabel, "setFixPageParams", "fixPageParamsEvent", "G", "setFixPageParamsEvent", "emptyBtmReturn", "e", "setEmptyBtmReturn", "fixPreNode", "L", "setFixPreNode", "fixPageInfoStack", ExifInterface.LONGITUDE_EAST, "setFixPageInfoStack", "fixAnniePreload", "h", "setFixAnniePreload", "fixNativeStatus", "D", "setFixNativeStatus", "clearErrorGecko", "getClearErrorGecko", "setClearErrorGecko", "fixBcmPageInfo", "r", "setFixBcmPageInfo", "fixSourceTokenError", "R", "setFixSourceTokenError", "fixBcmValueNotConvert", "s", "setFixBcmValueNotConvert", "", "", "backupTopPage", "Ljava/util/List;", "b", "()Ljava/util/List;", "setBackupTopPage", "(Ljava/util/List;)V", "enableDestroyedPageCache", "f", "setEnableDestroyedPageCache", "downgradeSwitch", "d", "setDowngradeSwitch", "removeQueueBufferWhenConsumeToken", "X", "setRemoveQueueBufferWhenConsumeToken", "", "Lcom/bytedance/android/btm/impl/setting/n;", "manualBackMap", "Ljava/util/Map;", ExifInterface.LONGITUDE_WEST, "()Ljava/util/Map;", "setManualBackMap", "(Ljava/util/Map;)V", "<init>", "()V", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
@LazyData
public final class h {

    @SerializedName("app_observe_v2")
    private int appObserveV2;

    @SerializedName("backup_top_page")
    private List<String> backupTopPage;

    @SerializedName("clear_error_gecko")
    private int clearErrorGecko;

    @SerializedName("disable_userVisibleHintAOP")
    private int disableUserVisibleHintAOP;

    @SerializedName("downgrade_switch")
    private int downgradeSwitch;

    @SerializedName("empty_btm_return")
    private int emptyBtmReturn;

    @SerializedName("enable_destroyed_page_cache")
    private int enableDestroyedPageCache;

    @SerializedName("fix_aop")
    private int fixAOP;

    @SerializedName("fix_add_node")
    private int fixAddNode;

    @SerializedName("fix_annie_preload")
    private int fixAnniePreload;

    @SerializedName("fix_auto")
    private int fixAuto;

    @SerializedName("fix_back_activity_resume_filter")
    private int fixBackActivityResumeFilter;

    @SerializedName("fix_back_ground")
    private int fixBackGround;

    @SerializedName("fix_back_internal")
    private int fixBackInternal;

    @SerializedName("fix_back_internal_parent")
    private int fixBackInternalParent;

    @SerializedName("fix_back_internal_sort")
    private int fixBackInternalSort;

    @SerializedName("fix_back_process")
    private int fixBackProcess;

    @SerializedName("fix_back_resumer_sort")
    private int fixBackResumerSort;

    @SerializedName("fix_background_resume_filter")
    private int fixBackgroundResumeFilter;

    @SerializedName("fix_bcm_description_big_size")
    private int fixBcmDescriptionBigSize;

    @SerializedName("fix_bcm_page_info")
    private int fixBcmPageInfo;

    @SerializedName("fix_bcm_value_not_convert")
    private int fixBcmValueNotConvert;

    @SerializedName("fix_decor_view")
    private int fixDecorView;

    @SerializedName("fix_disableUserVisibleHint")
    private int fixDisableUserVisibleHint;

    @SerializedName("fix_enter_new_page")
    private int fixEnterNewPage;

    @SerializedName("fix_enterPage")
    private int fixEnterPage;

    @SerializedName("fix_enter_page_filter_same_page")
    private int fixEnterPageFilterSamePage;

    @SerializedName("fix_fe_register_resume")
    private int fixFERegisterResume;

    @SerializedName("fix_filter_top_activity")
    private int fixFilterTopActivity;

    @SerializedName("fix_fragment_view")
    private int fixFragmentView;

    @SerializedName("fix_last_page_show")
    private int fixLastPageShow;

    @SerializedName("fix_multi_top_activity")
    private int fixMultiTopActivity;

    @SerializedName("fix_native_state")
    private int fixNativeState;

    @SerializedName("fix_native_status")
    private int fixNativeStatus;

    @SerializedName("fix_page_buffer_null")
    private final int fixPageBufferNull;

    @SerializedName("fix_page_info_stack")
    private int fixPageInfoStack;

    @SerializedName("fix_page_params")
    private int fixPageParams;

    @SerializedName("fix_page_params_event")
    private int fixPageParamsEvent;

    @SerializedName("fix_page_show_gap")
    private int fixPageShowGap;

    @SerializedName("fix_poll_buffer")
    private int fixPollBuffer;

    @SerializedName("fix_poll_self_buffer")
    private int fixPollSelfBuffer;

    @SerializedName("fix_post_resume")
    private int fixPostResume;

    @SerializedName("fix_pre_node")
    private int fixPreNode;

    @SerializedName("fix_refresh_show_id")
    private int fixRefreshShowId;

    @SerializedName("fix_register_delay")
    private int fixRegisterDelay;

    @SerializedName("fix_register_page_when_no_resume")
    private int fixRegisterPageWhenNotResume;

    @SerializedName("fix_reuse")
    private int fixReuse;

    @SerializedName("fix_show_api")
    private int fixShowAPI;

    @SerializedName("fix_source_token_error")
    private int fixSourceTokenError;

    @SerializedName("fix_unknown_event")
    private int fixUnknownEvent;

    @SerializedName("fix_unknown_pre")
    private int fixUnknownPre;

    @SerializedName("fix_unknown_pre_2")
    private int fixUnknownPre2;

    @SerializedName("judge_top_activity")
    private final int judgeTopActivity;

    @SerializedName("manual_back_map")
    private Map<String, n> manualBackMap;

    @SerializedName("remove_queue_buffer_when_consume_token")
    private int removeQueueBufferWhenConsumeToken;

    public h() {
        this.judgeTopActivity = 1;
        this.fixPageBufferNull = 1;
        this.fixBackActivityResumeFilter = 1;
        this.fixBackgroundResumeFilter = 1;
        this.fixBackGround = 1;
        this.fixRegisterPageWhenNotResume = 1;
        this.fixFERegisterResume = 2;
        this.fixPostResume = 1;
        this.fixBackInternal = 1;
        this.fixBackProcess = 1;
        this.fixEnterPageFilterSamePage = 1;
        this.fixPollBuffer = 1;
        this.fixUnknownEvent = 3;
        this.fixUnknownPre = 1;
        this.fixUnknownPre2 = 1;
        this.appObserveV2 = 1;
        this.fixPageShowGap = 2;
        this.fixRefreshShowId = 1;
        this.fixDisableUserVisibleHint = 1;
        this.fixPollSelfBuffer = 1;
        this.fixFilterTopActivity = 1;
        this.fixDecorView = 1;
        this.fixFragmentView = 1;
        this.disableUserVisibleHintAOP = 1;
        this.fixReuse = 2;
        this.fixShowAPI = 1;
        this.fixBackResumerSort = 1;
        this.fixBackInternalSort = 1;
        this.fixBackInternalParent = 1;
        this.fixNativeState = 1;
        this.fixEnterPage = 1;
        this.fixAuto = 1;
        this.fixRegisterDelay = 1;
        this.fixMultiTopActivity = 1;
        this.fixLastPageShow = 1;
        this.fixAddNode = 1;
        this.fixBcmDescriptionBigSize = 1;
        this.fixPageParams = 1;
        this.fixPageParamsEvent = 1;
        this.emptyBtmReturn = 1;
        this.fixPreNode = 1;
        this.fixPageInfoStack = 1;
        this.fixAnniePreload = 1;
        this.fixNativeStatus = 1;
        this.fixBcmPageInfo = 1;
        this.fixSourceTokenError = 1;
        this.fixBcmValueNotConvert = 1;
        this.backupTopPage = CollectionsKt.listOf("a1128.b9768");
        this.enableDestroyedPageCache = 1;
        this.downgradeSwitch = 1;
        this.removeQueueBufferWhenConsumeToken = 1;
        this.manualBackMap = MapsKt.mapOf(TuplesKt.to("a1128.b337213", new n()));
    }

    public final int A() {
        return this.fixLastPageShow;
    }

    public final int B() {
        return this.fixMultiTopActivity;
    }

    public final int C() {
        return this.fixNativeState;
    }

    public final int D() {
        return this.fixNativeStatus;
    }

    public final int E() {
        return this.fixPageInfoStack;
    }

    public final int F() {
        return this.fixPageParams;
    }

    public final int G() {
        return this.fixPageParamsEvent;
    }

    public final int H() {
        return this.fixPageShowGap;
    }

    public final int I() {
        return this.fixPollBuffer;
    }

    public final int J() {
        return this.fixPollSelfBuffer;
    }

    public final int K() {
        return this.fixPostResume;
    }

    public final int L() {
        return this.fixPreNode;
    }

    public final int M() {
        return this.fixRefreshShowId;
    }

    public final int N() {
        return this.fixRegisterDelay;
    }

    public final int O() {
        return this.fixRegisterPageWhenNotResume;
    }

    public final int P() {
        return this.fixReuse;
    }

    public final int Q() {
        return this.fixShowAPI;
    }

    public final int R() {
        return this.fixSourceTokenError;
    }

    public final int S() {
        return this.fixUnknownEvent;
    }

    public final int T() {
        return this.fixUnknownPre;
    }

    public final int U() {
        return this.fixUnknownPre2;
    }

    public final int V() {
        return this.judgeTopActivity;
    }

    public final Map<String, n> W() {
        return this.manualBackMap;
    }

    public final int X() {
        return this.removeQueueBufferWhenConsumeToken;
    }

    public final int a() {
        return this.appObserveV2;
    }

    public final List<String> b() {
        return this.backupTopPage;
    }

    public final int c() {
        return this.disableUserVisibleHintAOP;
    }

    public final int d() {
        return this.downgradeSwitch;
    }

    public final int e() {
        return this.emptyBtmReturn;
    }

    public final int f() {
        return this.enableDestroyedPageCache;
    }

    public final int g() {
        return this.fixAddNode;
    }

    public final int h() {
        return this.fixAnniePreload;
    }

    public final int i() {
        return this.fixAuto;
    }

    public final int j() {
        return this.fixBackGround;
    }

    public final int k() {
        return this.fixBackInternal;
    }

    public final int l() {
        return this.fixBackInternalParent;
    }

    public final int m() {
        return this.fixBackInternalSort;
    }

    public final int n() {
        return this.fixBackProcess;
    }

    public final int o() {
        return this.fixBackResumerSort;
    }

    public final int p() {
        return this.fixBackgroundResumeFilter;
    }

    public final int q() {
        return this.fixBcmDescriptionBigSize;
    }

    public final int r() {
        return this.fixBcmPageInfo;
    }

    public final int s() {
        return this.fixBcmValueNotConvert;
    }

    public final int t() {
        return this.fixDecorView;
    }

    public final int u() {
        return this.fixDisableUserVisibleHint;
    }

    public final int v() {
        return this.fixEnterNewPage;
    }

    public final int w() {
        return this.fixEnterPage;
    }

    public final int x() {
        return this.fixEnterPageFilterSamePage;
    }

    public final int y() {
        return this.fixFERegisterResume;
    }

    public final int z() {
        return this.fixFragmentView;
    }
}
