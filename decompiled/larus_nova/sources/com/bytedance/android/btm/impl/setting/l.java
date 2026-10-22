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
import com.ss.ttvideoengine.log.IVideoEventLogger;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\bÄ\u0001\u0010Å\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0004\u0010\u000bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\u0015R\"\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u000e\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u001cR\"\u0010'\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u000e\u001a\u0004\b(\u0010\u0010\"\u0004\b)\u0010\u001cR\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\u0015R\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\u0015R\"\u00100\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u000e\u001a\u0004\b1\u0010\u0010\"\u0004\b2\u0010\u001cR\"\u00103\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u000e\u001a\u0004\b4\u0010\u0010\"\u0004\b5\u0010\u001cR\"\u00106\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010\u0004\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\u0015R\"\u00109\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010\u0004\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\u0015R\"\u0010<\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010\u0004\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\u0015R\"\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010\u0004\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\u0015R\"\u0010B\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010\u0004\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\u0015R(\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00020E8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010L\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bL\u0010\t\u001a\u0004\bM\u0010\u000b\"\u0004\bN\u0010OR\"\u0010P\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bP\u0010\u0004\u001a\u0004\bQ\u0010\u0006\"\u0004\bR\u0010\u0015R\"\u0010T\u001a\u00020S8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR(\u0010[\u001a\b\u0012\u0004\u0012\u00020Z0E8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b[\u0010G\u001a\u0004\b\\\u0010I\"\u0004\b]\u0010KR(\u0010^\u001a\b\u0012\u0004\u0012\u00020Z0E8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b^\u0010G\u001a\u0004\b_\u0010I\"\u0004\b`\u0010KR(\u0010b\u001a\b\u0012\u0004\u0012\u00020a0E8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bb\u0010G\u001a\u0004\bc\u0010I\"\u0004\bd\u0010KR(\u0010e\u001a\b\u0012\u0004\u0012\u00020a0E8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\be\u0010G\u001a\u0004\bf\u0010I\"\u0004\bg\u0010KR\"\u0010h\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bh\u0010\u0004\u001a\u0004\bi\u0010\u0006\"\u0004\bj\u0010\u0015R\"\u0010k\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bk\u0010\t\u001a\u0004\bl\u0010\u000b\"\u0004\bm\u0010OR\"\u0010n\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bn\u0010\u0004\u001a\u0004\bo\u0010\u0006\"\u0004\bp\u0010\u0015R\"\u0010q\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bq\u0010\u0004\u001a\u0004\br\u0010\u0006\"\u0004\bs\u0010\u0015R\"\u0010u\u001a\u00020t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\"\u0010{\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b{\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u0004\b|\u0010\u0015R&\u0010~\u001a\u00020}8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R&\u0010\u0084\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0084\u0001\u0010\u0004\u001a\u0005\b\u0085\u0001\u0010\u0006\"\u0005\b\u0086\u0001\u0010\u0015R,\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020Z0E8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0087\u0001\u0010G\u001a\u0005\b\u0088\u0001\u0010I\"\u0005\b\u0089\u0001\u0010KR&\u0010\u008a\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008a\u0001\u0010\u0004\u001a\u0005\b\u008b\u0001\u0010\u0006\"\u0005\b\u008c\u0001\u0010\u0015R*\u0010\u008e\u0001\u001a\u00030\u008d\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R&\u0010\u0094\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0094\u0001\u0010\u0004\u001a\u0005\b\u0095\u0001\u0010\u0006\"\u0005\b\u0096\u0001\u0010\u0015R*\u0010\u0098\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R,\u0010\u009e\u0001\u001a\b\u0012\u0004\u0012\u00020Z0E8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009e\u0001\u0010G\u001a\u0005\b\u009f\u0001\u0010I\"\u0005\b \u0001\u0010KR*\u0010¢\u0001\u001a\u00030¡\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b¢\u0001\u0010£\u0001\u001a\u0006\b¤\u0001\u0010¥\u0001\"\u0006\b¦\u0001\u0010§\u0001R&\u0010¨\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¨\u0001\u0010\u0004\u001a\u0005\b©\u0001\u0010\u0006\"\u0005\bª\u0001\u0010\u0015R&\u0010«\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b«\u0001\u0010\u0004\u001a\u0005\b¬\u0001\u0010\u0006\"\u0005\b\u00ad\u0001\u0010\u0015R&\u0010®\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b®\u0001\u0010\u0004\u001a\u0005\b¯\u0001\u0010\u0006\"\u0005\b°\u0001\u0010\u0015R&\u0010±\u0001\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b±\u0001\u0010\u000e\u001a\u0005\b²\u0001\u0010\u0010\"\u0005\b³\u0001\u0010\u001cR&\u0010´\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b´\u0001\u0010\u0004\u001a\u0005\bµ\u0001\u0010\u0006\"\u0005\b¶\u0001\u0010\u0015R*\u0010¸\u0001\u001a\u00030·\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b¸\u0001\u0010¹\u0001\u001a\u0006\bº\u0001\u0010»\u0001\"\u0006\b¼\u0001\u0010½\u0001R&\u0010¾\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¾\u0001\u0010\u0004\u001a\u0005\b¿\u0001\u0010\u0006\"\u0005\bÀ\u0001\u0010\u0015R,\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00020Z0E8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÁ\u0001\u0010G\u001a\u0005\bÂ\u0001\u0010I\"\u0005\bÃ\u0001\u0010K¨\u0006Æ\u0001"}, d2 = {"Lcom/bytedance/android/btm/impl/setting/l;", "", "", "removeInstanceId", "I", "C", "()I", "", "bufferTimeout", "J", ce.f26395j, "()J", "", "enableSdkThreadPool", "Z", "o", "()Z", "startNodeNextPageWaitTime", "enableStartNode", "p", "setEnableStartNode", "(I)V", "aLog", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setALog", "bcmCheckSwitch", "f", "setBcmCheckSwitch", "(Z)V", "Lcom/bytedance/android/btm/impl/setting/d;", "bcmCheckV2", "Lcom/bytedance/android/btm/impl/setting/d;", ce.f26391f, "()Lcom/bytedance/android/btm/impl/setting/d;", "setBcmCheckV2", "(Lcom/bytedance/android/btm/impl/setting/d;)V", "loadBcmParamsSwitch", BaseSwitches.V, "setLoadBcmParamsSwitch", "bcmCheckPopDialogSwitch", "getBcmCheckPopDialogSwitch", "setBcmCheckPopDialogSwitch", "showIdChain", "G", "setShowIdChain", "instanceIdSwitch", "t", "setInstanceIdSwitch", "enterPageWaitStartNode", "r", "setEnterPageWaitStartNode", "reissuedEnterPageWhenPageShow", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setReissuedEnterPageWhenPageShow", "unknownSwitch", "L", "setUnknownSwitch", "unknownDialogFragSwitch", "K", "setUnknownDialogFragSwitch", "alogBcmStackMaxLength", "d", "setAlogBcmStackMaxLength", "lastBtmIdSwitch", "u", "setLastBtmIdSwitch", "uploadALog", "N", "setUploadALog", "", "uploadALogErrorCodeList", "Ljava/util/List;", "O", "()Ljava/util/List;", "setUploadALogErrorCodeList", "(Ljava/util/List;)V", "uploadALogGapSeconds", "P", "setUploadALogGapSeconds", "(J)V", "uploadTimesPerErr", "Q", "setUploadTimesPerErr", "Lcom/bytedance/android/btm/impl/setting/s;", "schemaPath", "Lcom/bytedance/android/btm/impl/setting/s;", FaceService.girlLabel, "()Lcom/bytedance/android/btm/impl/setting/s;", "setSchemaPath", "(Lcom/bytedance/android/btm/impl/setting/s;)V", "", "noUnknownPrePage", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "setNoUnknownPrePage", "noUnknownClass", "y", "setNoUnknownClass", "Lcom/bytedance/android/btm/impl/setting/q;", "preCDNonNull", "getPreCDNonNull", "setPreCDNonNull", "incorrectBtmPre", "getIncorrectBtmPre", "setIncorrectBtmPre", "checkEventSwitch", "getCheckEventSwitch", "setCheckEventSwitch", "errCode2015Timemillis", "s", "setErrCode2015Timemillis", "removeEnterPage", "B", "setRemoveEnterPage", "enableBcmReport", ce.f26396k, "setEnableBcmReport", "Lcom/bytedance/android/btm/impl/setting/e;", "bcmBizKeyWhitelist", "Lcom/bytedance/android/btm/impl/setting/e;", "e", "()Lcom/bytedance/android/btm/impl/setting/e;", "setBcmBizKeyWhitelist", "(Lcom/bytedance/android/btm/impl/setting/e;)V", "tokenRepeatUse", "setTokenRepeatUse", "Lcom/bytedance/android/btm/impl/setting/c;", "reportBcmChain", "Lcom/bytedance/android/btm/impl/setting/c;", ExifInterface.LONGITUDE_EAST, "()Lcom/bytedance/android/btm/impl/setting/c;", "setReportBcmChain", "(Lcom/bytedance/android/btm/impl/setting/c;)V", "enablePushLink", OfficeSDKRequestTag.KEY_NEW_USER, "setEnablePushLink", "bstGroupTypeCheckPages", "h", "setBstGroupTypeCheckPages", "updateBstGroupTypeCheck", "M", "setUpdateBstGroupTypeCheck", "Lcom/bytedance/android/btm/impl/setting/f;", "btmQuality", "Lcom/bytedance/android/btm/impl/setting/f;", RXScreenCaptureService.KEY_INDEX, "()Lcom/bytedance/android/btm/impl/setting/f;", "setBtmQuality", "(Lcom/bytedance/android/btm/impl/setting/f;)V", "addTokenInChain", "b", "setAddTokenInChain", "Lcom/bytedance/android/btm/impl/setting/m;", "loggerBackupAddBtm", "Lcom/bytedance/android/btm/impl/setting/m;", "w", "()Lcom/bytedance/android/btm/impl/setting/m;", "setLoggerBackupAddBtm", "(Lcom/bytedance/android/btm/impl/setting/m;)V", "trackCoreEvent", "getTrackCoreEvent", "setTrackCoreEvent", "Lcom/bytedance/android/btm/impl/setting/w;", "unknownPageMonitor", "Lcom/bytedance/android/btm/impl/setting/w;", "getUnknownPageMonitor", "()Lcom/bytedance/android/btm/impl/setting/w;", "setUnknownPageMonitor", "(Lcom/bytedance/android/btm/impl/setting/w;)V", "showUnknownPageScheme", FaceService.neutralLabel, "setShowUnknownPageScheme", "removePageId", "D", "setRemovePageId", "newBtmShowId", "x", "setNewBtmShowId", "enablePreDefineBtmShowId", "m", "setEnablePreDefineBtmShowId", "enableTopPageQuery", "q", "setEnableTopPageQuery", "Lcom/bytedance/android/btm/impl/setting/x;", "virtualNode", "Lcom/bytedance/android/btm/impl/setting/x;", "R", "()Lcom/bytedance/android/btm/impl/setting/x;", "setVirtualNode", "(Lcom/bytedance/android/btm/impl/setting/x;)V", "enableDuplicateEnterPage", "l", "setEnableDuplicateEnterPage", "allowRepeatRegisterPages", "c", "setAllowRepeatRegisterPages", "<init>", "()V", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
@LazyData
public final class l {

    @SerializedName("aLog")
    private int aLog;

    @SerializedName("add_token_in_chain")
    private int addTokenInChain;

    @SerializedName("reregister_btm_allowlist")
    private List<String> allowRepeatRegisterPages;

    @SerializedName("alog_bcm_stack_max_length")
    private int alogBcmStackMaxLength;

    @SerializedName("bcm_biz_key_whitelist")
    private e bcmBizKeyWhitelist;

    @SerializedName("bcm_check_pop_dialog_switch")
    private boolean bcmCheckPopDialogSwitch;

    @SerializedName("bcm_check_switch")
    private boolean bcmCheckSwitch;

    @SerializedName("bcm_check_v2")
    private d bcmCheckV2;

    @SerializedName("bst_group_type_check_pages")
    private List<String> bstGroupTypeCheckPages;

    @SerializedName("btm_quality")
    private f btmQuality;

    @SerializedName(IVideoEventLogger.FEATURE_KEY_BUFFER_TIMEOUT)
    private final long bufferTimeout;

    @SerializedName("check_event_switch")
    private int checkEventSwitch;

    @SerializedName("enable_bcm_report")
    private int enableBcmReport;

    @SerializedName("enable_duplicate_enter_page")
    private int enableDuplicateEnterPage;

    @SerializedName("enable_predefine_btm_show_id")
    private boolean enablePreDefineBtmShowId;

    @SerializedName("push_into_link")
    private int enablePushLink;

    @SerializedName("enable_sdk_thread_pool")
    private final boolean enableSdkThreadPool;

    @SerializedName("initial_node")
    private int enableStartNode;

    @SerializedName("enable_top_page_query")
    private int enableTopPageQuery;

    @SerializedName("enter_page_wait_start_node")
    private boolean enterPageWaitStartNode;

    @SerializedName("errcode_2015_timemillis")
    private long errCode2015Timemillis;

    @SerializedName("incorrect_btm_pre")
    private List<q> incorrectBtmPre;

    @SerializedName("instance_id_switch")
    private int instanceIdSwitch;

    @SerializedName("last_btmId_switch")
    private int lastBtmIdSwitch;

    @SerializedName("load_bcm_params_switch")
    private boolean loadBcmParamsSwitch;

    @SerializedName("logger_backup_add_btm")
    private m loggerBackupAddBtm;

    @SerializedName("new_btm_show_id")
    private int newBtmShowId;

    @SerializedName("prefix_need_check_unknown")
    private List<String> noUnknownClass;

    @SerializedName("page_need_check_previous_unknown")
    private List<String> noUnknownPrePage;

    @SerializedName("pre_cd_non_null")
    private List<q> preCDNonNull;

    @SerializedName("reissued_enter_page_when_page_show")
    private boolean reissuedEnterPageWhenPageShow;

    @SerializedName("remove_enter_page")
    private int removeEnterPage;

    @SerializedName("remove_instance_id")
    private final int removeInstanceId;

    @SerializedName("remove_page_id")
    private int removePageId;

    @SerializedName("bcm_chain_in_logger")
    private c reportBcmChain;

    @SerializedName("schema_path")
    private s schemaPath;

    @SerializedName("show_id_chain_switch")
    private int showIdChain;

    @SerializedName("show_unknown_page_scheme")
    private int showUnknownPageScheme;

    @SerializedName("start_node_next_page_wait_time")
    private final long startNodeNextPageWaitTime;

    @SerializedName("token_repeat_use")
    private int tokenRepeatUse;

    @SerializedName("track_core_event_name")
    private List<String> trackCoreEvent;

    @SerializedName("unknown_dialog_frag_switch")
    private int unknownDialogFragSwitch;

    @SerializedName("unknown_page_monitor")
    private w unknownPageMonitor;

    @SerializedName("unknown_switch")
    private int unknownSwitch;

    @SerializedName("update_bst_group_type_check")
    private int updateBstGroupTypeCheck;

    @SerializedName("upload_alog_switch")
    private int uploadALog;

    @SerializedName("upload_alog_errCode_list")
    private List<Integer> uploadALogErrorCodeList;

    @SerializedName("upload_alog_gap_seconds")
    private long uploadALogGapSeconds;

    @SerializedName("upload_times_per_err")
    private int uploadTimesPerErr;

    @SerializedName("virtual_node")
    private x virtualNode;

    public l() {
        this.removeInstanceId = 1;
        this.bufferTimeout = 5000;
        this.startNodeNextPageWaitTime = 500;
        this.enableStartNode = 1;
        this.aLog = 1;
        this.bcmCheckV2 = new d();
        this.loadBcmParamsSwitch = true;
        this.showIdChain = 3;
        this.instanceIdSwitch = 3;
        this.enterPageWaitStartNode = true;
        this.reissuedEnterPageWhenPageShow = true;
        this.unknownSwitch = 1;
        this.lastBtmIdSwitch = 1;
        this.uploadALogErrorCodeList = new ArrayList();
        this.uploadALogGapSeconds = 300;
        this.uploadTimesPerErr = 5;
        this.schemaPath = new s();
        this.noUnknownPrePage = CollectionsKt.emptyList();
        this.noUnknownClass = CollectionsKt.emptyList();
        this.preCDNonNull = CollectionsKt.emptyList();
        this.incorrectBtmPre = CollectionsKt.emptyList();
        this.errCode2015Timemillis = 2000;
        this.removeEnterPage = 1;
        this.bcmBizKeyWhitelist = new e();
        this.tokenRepeatUse = 1;
        this.reportBcmChain = new c();
        this.enablePushLink = 1;
        this.bstGroupTypeCheckPages = CollectionsKt.listOf(new String[]{"a1.b8094.c0.d0", "a1.b5267.c0.d0", "a1.b7411.c0.d0"});
        this.updateBstGroupTypeCheck = 1;
        this.btmQuality = new f();
        this.addTokenInChain = 1;
        this.loggerBackupAddBtm = new m();
        this.trackCoreEvent = CollectionsKt.emptyList();
        this.unknownPageMonitor = new w();
        this.showUnknownPageScheme = 1;
        this.removePageId = 1;
        this.newBtmShowId = 1;
        this.enablePreDefineBtmShowId = true;
        this.enableTopPageQuery = 1;
        this.virtualNode = new x();
        this.allowRepeatRegisterPages = CollectionsKt.emptyList();
    }

    public final boolean A() {
        return this.reissuedEnterPageWhenPageShow;
    }

    public final int B() {
        return this.removeEnterPage;
    }

    public final int C() {
        return this.removeInstanceId;
    }

    public final int D() {
        return this.removePageId;
    }

    public final c E() {
        return this.reportBcmChain;
    }

    public final s F() {
        return this.schemaPath;
    }

    public final int G() {
        return this.showIdChain;
    }

    public final int H() {
        return this.showUnknownPageScheme;
    }

    public final long I() {
        return this.startNodeNextPageWaitTime;
    }

    public final int J() {
        return this.tokenRepeatUse;
    }

    public final int K() {
        return this.unknownDialogFragSwitch;
    }

    public final int L() {
        return this.unknownSwitch;
    }

    public final int M() {
        return this.updateBstGroupTypeCheck;
    }

    public final int N() {
        return this.uploadALog;
    }

    public final List<Integer> O() {
        return this.uploadALogErrorCodeList;
    }

    public final long P() {
        return this.uploadALogGapSeconds;
    }

    public final int Q() {
        return this.uploadTimesPerErr;
    }

    public final x R() {
        return this.virtualNode;
    }

    public final int a() {
        return this.aLog;
    }

    public final int b() {
        return this.addTokenInChain;
    }

    public final List<String> c() {
        return this.allowRepeatRegisterPages;
    }

    public final int d() {
        return this.alogBcmStackMaxLength;
    }

    public final e e() {
        return this.bcmBizKeyWhitelist;
    }

    public final boolean f() {
        return this.bcmCheckSwitch;
    }

    public final d g() {
        return this.bcmCheckV2;
    }

    public final List<String> h() {
        return this.bstGroupTypeCheckPages;
    }

    public final f i() {
        return this.btmQuality;
    }

    public final long j() {
        return this.bufferTimeout;
    }

    public final int k() {
        return this.enableBcmReport;
    }

    public final int l() {
        return this.enableDuplicateEnterPage;
    }

    public final boolean m() {
        return this.enablePreDefineBtmShowId;
    }

    public final int n() {
        return this.enablePushLink;
    }

    public final boolean o() {
        return this.enableSdkThreadPool;
    }

    public final int p() {
        return this.enableStartNode;
    }

    public final int q() {
        return this.enableTopPageQuery;
    }

    public final boolean r() {
        return this.enterPageWaitStartNode;
    }

    public final long s() {
        return this.errCode2015Timemillis;
    }

    public final int t() {
        return this.instanceIdSwitch;
    }

    public final int u() {
        return this.lastBtmIdSwitch;
    }

    public final boolean v() {
        return this.loadBcmParamsSwitch;
    }

    public final m w() {
        return this.loggerBackupAddBtm;
    }

    public final int x() {
        return this.newBtmShowId;
    }

    public final List<String> y() {
        return this.noUnknownClass;
    }

    public final List<String> z() {
        return this.noUnknownPrePage;
    }
}
