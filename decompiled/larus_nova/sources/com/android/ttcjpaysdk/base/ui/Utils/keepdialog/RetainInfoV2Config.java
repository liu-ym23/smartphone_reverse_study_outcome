package com.android.ttcjpaysdk.base.ui.Utils.keepdialog;

import android.app.Dialog;
import com.android.ttcjpaysdk.base.ui.data.VoucherRetainInfo;
import com.android.ttcjpaysdk.base.ui.dialog.LynxDialogEvent;
import com.android.ttcjpaysdk.base.ui.dialog.LynxKeepDialogFromScene;
import com.android.ttcjpaysdk.base.ui.dialog.LynxKeepDialogShowPosition;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\bI\b\u0086\b\u0018\u00002\u00020\u0001BÔ\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012R\b\u0002\u0010\u0004\u001aL\u0012\u0004\u0012\u00020\u0006\u0012:\u00128\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007j\u0002`\u000e\u0018\u00010\u0005j\u0004\u0018\u0001`\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012'\b\u0002\u0010 \u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\r\u0018\u00010!\u0012\b\b\u0002\u0010#\u001a\u00020$\u0012\b\b\u0002\u0010%\u001a\u00020\u0018\u0012\b\b\u0002\u0010&\u001a\u00020\u0018\u0012\b\b\u0002\u0010'\u001a\u00020\u0015\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010+J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010QJ\u000b\u0010U\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u001eHÆ\u0003J(\u0010W\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\r\u0018\u00010!HÆ\u0003J\t\u0010X\u001a\u00020$HÆ\u0003J\t\u0010Y\u001a\u00020\u0018HÆ\u0003J\t\u0010Z\u001a\u00020\u0018HÆ\u0003J\t\u0010[\u001a\u00020\u0015HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003JS\u0010^\u001aL\u0012\u0004\u0012\u00020\u0006\u0012:\u00128\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007j\u0002`\u000e\u0018\u00010\u0005j\u0004\u0018\u0001`\u000fHÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u0010b\u001a\u00020\u0015HÆ\u0003J\t\u0010c\u001a\u00020\u0015HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001bHÆ\u0003JÝ\u0002\u0010g\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032R\b\u0002\u0010\u0004\u001aL\u0012\u0004\u0012\u00020\u0006\u0012:\u00128\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007j\u0002`\u000e\u0018\u00010\u0005j\u0004\u0018\u0001`\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2'\b\u0002\u0010 \u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\r\u0018\u00010!2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00182\b\b\u0002\u0010&\u001a\u00020\u00182\b\b\u0002\u0010'\u001a\u00020\u00152\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010hJ\u0013\u0010i\u001a\u00020\u00152\b\u0010j\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010k\u001a\u00020$HÖ\u0001J\t\u0010l\u001a\u00020\u0018HÖ\u0001R\u0011\u0010%\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001c\u0010*\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u0010)\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010/\"\u0004\b3\u00101Rd\u0010\u0004\u001aL\u0012\u0004\u0012\u00020\u0006\u0012:\u00128\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007j\u0002`\u000e\u0018\u00010\u0005j\u0004\u0018\u0001`\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010/R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R0\u0010 \u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\r\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0011\u0010\u0016\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010=R\u0011\u0010'\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b'\u0010=R\u0019\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0013\u0010(\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010/R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010/R\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\bD\u0010-R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\bG\u0010=R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010FR\u0011\u0010&\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bK\u0010-R\u001a\u0010L\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010=\"\u0004\bN\u0010OR\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010R\u001a\u0004\bP\u0010Q¨\u0006m"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/Utils/keepdialog/RetainInfoV2Config;", "", "retainInfoV2", "Lorg/json/JSONObject;", "eventHandlerMap", "", "Lcom/android/ttcjpaysdk/base/ui/dialog/LynxDialogEvent;", "Lkotlin/Function2;", "Landroid/app/Dialog;", "Lkotlin/ParameterName;", "name", "dialog", "data", "", "Lcom/android/ttcjpaysdk/base/ui/dialog/LynxDialogOnEvent;", "Lcom/android/ttcjpaysdk/base/ui/dialog/LynxDialogEventMap;", "fromScene", "Lcom/android/ttcjpaysdk/base/ui/dialog/LynxKeepDialogFromScene;", "showFromPosition", "Lcom/android/ttcjpaysdk/base/ui/dialog/LynxKeepDialogShowPosition;", "showDefaultKeepDialogOnly", "", "isFingerprintLocalEnable", "selectedPayType", "", ControlRule.KEY_EXTRA_DATA, SendEventContainerMethodParamModel.EventKinds.onShow, "Lkotlin/Function0;", "useMask", "selectedPayTypeVoucherInfo", "Lcom/android/ttcjpaysdk/base/ui/data/VoucherRetainInfo;", "superimposedRetainInfo", "initDataApply", "Lkotlin/Function1;", "initData", "retainShowStyle", "", "addiVoucherType", "teaSource", "isQueryPayTypeReady", "retainInfoBatch", "clientRetainInfo", "clientExtraData", "(Lorg/json/JSONObject;Ljava/util/Map;Lcom/android/ttcjpaysdk/base/ui/dialog/LynxKeepDialogFromScene;Lcom/android/ttcjpaysdk/base/ui/dialog/LynxKeepDialogShowPosition;ZZLjava/lang/String;Lorg/json/JSONObject;Lkotlin/jvm/functions/Function0;Ljava/lang/Boolean;Lcom/android/ttcjpaysdk/base/ui/data/VoucherRetainInfo;Lcom/android/ttcjpaysdk/base/ui/data/VoucherRetainInfo;Lkotlin/jvm/functions/Function1;ILjava/lang/String;Ljava/lang/String;ZLorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V", "getAddiVoucherType", "()Ljava/lang/String;", "getClientExtraData", "()Lorg/json/JSONObject;", "setClientExtraData", "(Lorg/json/JSONObject;)V", "getClientRetainInfo", "setClientRetainInfo", "getEventHandlerMap", "()Ljava/util/Map;", "setEventHandlerMap", "(Ljava/util/Map;)V", "getExtraData", "getFromScene", "()Lcom/android/ttcjpaysdk/base/ui/dialog/LynxKeepDialogFromScene;", "getInitDataApply", "()Lkotlin/jvm/functions/Function1;", "()Z", "getOnShow", "()Lkotlin/jvm/functions/Function0;", "getRetainInfoBatch", "getRetainInfoV2", "getRetainShowStyle", "()I", "getSelectedPayType", "getSelectedPayTypeVoucherInfo", "()Lcom/android/ttcjpaysdk/base/ui/data/VoucherRetainInfo;", "getShowDefaultKeepDialogOnly", "getShowFromPosition", "()Lcom/android/ttcjpaysdk/base/ui/dialog/LynxKeepDialogShowPosition;", "getSuperimposedRetainInfo", "getTeaSource", "useKeepDialogFrequencyForClientRetainInfo", "getUseKeepDialogFrequencyForClientRetainInfo", "setUseKeepDialogFrequencyForClientRetainInfo", "(Z)V", "getUseMask", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lorg/json/JSONObject;Ljava/util/Map;Lcom/android/ttcjpaysdk/base/ui/dialog/LynxKeepDialogFromScene;Lcom/android/ttcjpaysdk/base/ui/dialog/LynxKeepDialogShowPosition;ZZLjava/lang/String;Lorg/json/JSONObject;Lkotlin/jvm/functions/Function0;Ljava/lang/Boolean;Lcom/android/ttcjpaysdk/base/ui/data/VoucherRetainInfo;Lcom/android/ttcjpaysdk/base/ui/data/VoucherRetainInfo;Lkotlin/jvm/functions/Function1;ILjava/lang/String;Ljava/lang/String;ZLorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)Lcom/android/ttcjpaysdk/base/ui/Utils/keepdialog/RetainInfoV2Config;", "equals", "other", "hashCode", "toString", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RetainInfoV2Config {
    private final String addiVoucherType;
    private JSONObject clientExtraData;
    private JSONObject clientRetainInfo;
    private Map<LynxDialogEvent, ? extends Function2<? super Dialog, ? super JSONObject, Unit>> eventHandlerMap;
    private final JSONObject extraData;
    private final LynxKeepDialogFromScene fromScene;
    private final Function1<JSONObject, Unit> initDataApply;
    private final boolean isFingerprintLocalEnable;
    private final boolean isQueryPayTypeReady;
    private final Function0<Unit> onShow;
    private final JSONObject retainInfoBatch;
    private final JSONObject retainInfoV2;
    private final int retainShowStyle;
    private final String selectedPayType;
    private final VoucherRetainInfo selectedPayTypeVoucherInfo;
    private final boolean showDefaultKeepDialogOnly;
    private final LynxKeepDialogShowPosition showFromPosition;
    private final VoucherRetainInfo superimposedRetainInfo;
    private final String teaSource;
    private boolean useKeepDialogFrequencyForClientRetainInfo;
    private final Boolean useMask;

    public RetainInfoV2Config() {
        this(null, null, null, null, false, false, null, null, null, null, null, null, null, 0, null, null, false, null, null, null, 1048575, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RetainInfoV2Config copy$default(RetainInfoV2Config r110, JSONObject r111, Map r112, LynxKeepDialogFromScene r210, LynxKeepDialogShowPosition r211, boolean r212, boolean r213, String r214, JSONObject r215, Function0 r216, Boolean r217, VoucherRetainInfo r218, VoucherRetainInfo r219, Function1 r310, int r311, String r312, String r313, boolean r314, JSONObject r315, JSONObject r316, JSONObject r317, int r318, Object r319) {
        if ((r318 & 1) == 0) goto L5;
        JSONObject r100 = r110.retainInfoV2;
    L7:
        if ((r318 & 2) == 0) goto L9;
        Map r101 = r110.eventHandlerMap;
    L11:
        if ((r318 & 4) == 0) goto L13;
        LynxKeepDialogFromScene r102 = r110.fromScene;
    L15:
        if ((r318 & 8) == 0) goto L17;
        LynxKeepDialogShowPosition r103 = r110.showFromPosition;
    L19:
        if ((r318 & 16) == 0) goto L21;
        boolean r104 = r110.showDefaultKeepDialogOnly;
    L23:
        if ((r318 & 32) == 0) goto L25;
        boolean r105 = r110.isFingerprintLocalEnable;
    L27:
        if ((r318 & 64) == 0) goto L29;
        String r106 = r110.selectedPayType;
    L31:
        if ((r318 & 128) == 0) goto L33;
        JSONObject r107 = r110.extraData;
    L35:
        if ((r318 & 256) == 0) goto L37;
        Function0 r113 = r110.onShow;
    L39:
        if ((r318 & 512) == 0) goto L41;
        Boolean r114 = r110.useMask;
    L43:
        if ((r318 & 1024) == 0) goto L45;
        VoucherRetainInfo r115 = r110.selectedPayTypeVoucherInfo;
    L47:
        if ((r318 & 2048) == 0) goto L49;
        VoucherRetainInfo r116 = r110.superimposedRetainInfo;
    L51:
        if ((r318 & 4096) == 0) goto L53;
        Function1 r117 = r110.initDataApply;
    L55:
        if ((r318 & 8192) == 0) goto L57;
        int r118 = r110.retainShowStyle;
    L58:
        int r320 = r118;
        if ((r318 & 16384) == 0) goto L61;
        String r119 = r110.addiVoucherType;
    L62:
        String r321 = r119;
        if ((r318 & 32768) == 0) goto L65;
        String r120 = r110.teaSource;
    L66:
        String r322 = r120;
        if ((r318 & 65536) == 0) goto L69;
        boolean r121 = r110.isQueryPayTypeReady;
    L70:
        boolean r323 = r121;
        if ((r318 & 131072) == 0) goto L73;
        JSONObject r122 = r110.retainInfoBatch;
    L74:
        JSONObject r324 = r122;
        if ((r318 & 262144) == 0) goto L77;
        JSONObject r123 = r110.clientRetainInfo;
    L79:
        if ((r318 & 524288) == 0) goto L81;
        JSONObject r108 = r110.clientExtraData;
    L83:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r123, r108);
    L81:
        r108 = r317;
        goto L83
    L77:
        r123 = r316;
        goto L79
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
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

    public final JSONObject component1() {
        return this.retainInfoV2;
    }

    public final Boolean component10() {
        return this.useMask;
    }

    public final VoucherRetainInfo component11() {
        return this.selectedPayTypeVoucherInfo;
    }

    public final VoucherRetainInfo component12() {
        return this.superimposedRetainInfo;
    }

    public final Function1<JSONObject, Unit> component13() {
        return this.initDataApply;
    }

    public final int component14() {
        return this.retainShowStyle;
    }

    public final String component15() {
        return this.addiVoucherType;
    }

    public final String component16() {
        return this.teaSource;
    }

    public final boolean component17() {
        return this.isQueryPayTypeReady;
    }

    public final JSONObject component18() {
        return this.retainInfoBatch;
    }

    public final JSONObject component19() {
        return this.clientRetainInfo;
    }

    public final Map<LynxDialogEvent, Function2<Dialog, JSONObject, Unit>> component2() {
        return this.eventHandlerMap;
    }

    public final JSONObject component20() {
        return this.clientExtraData;
    }

    public final LynxKeepDialogFromScene component3() {
        return this.fromScene;
    }

    public final LynxKeepDialogShowPosition component4() {
        return this.showFromPosition;
    }

    public final boolean component5() {
        return this.showDefaultKeepDialogOnly;
    }

    public final boolean component6() {
        return this.isFingerprintLocalEnable;
    }

    public final String component7() {
        return this.selectedPayType;
    }

    public final JSONObject component8() {
        return this.extraData;
    }

    public final Function0<Unit> component9() {
        return this.onShow;
    }

    public final RetainInfoV2Config copy(JSONObject r210, Map<LynxDialogEvent, ? extends Function2<? super Dialog, ? super JSONObject, Unit>> r211, LynxKeepDialogFromScene r212, LynxKeepDialogShowPosition r213, boolean r214, boolean r215, String r216, JSONObject r310, Function0<Unit> r311, Boolean r312, VoucherRetainInfo r313, VoucherRetainInfo r314, Function1<? super JSONObject, Unit> r315, int r316, String r317, String r318, boolean r319, JSONObject r410, JSONObject r411, JSONObject r412) {
        Intrinsics.checkNotNullParameter(r317, "addiVoucherType");
        Intrinsics.checkNotNullParameter(r318, "teaSource");
        return new RetainInfoV2Config(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RetainInfoV2Config) == true) goto L8;
        return false;
    L8:
        RetainInfoV2Config r101 = (RetainInfoV2Config) r100;
        if (Intrinsics.areEqual(this.retainInfoV2, r101.retainInfoV2) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.eventHandlerMap, r101.eventHandlerMap) == true) goto L15;
        return false;
    L15:
        if (this.fromScene == r101.fromScene) goto L18;
        return false;
    L18:
        if (this.showFromPosition == r101.showFromPosition) goto L21;
        return false;
    L21:
        if (this.showDefaultKeepDialogOnly == r101.showDefaultKeepDialogOnly) goto L24;
        return false;
    L24:
        if (this.isFingerprintLocalEnable == r101.isFingerprintLocalEnable) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.selectedPayType, r101.selectedPayType) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.extraData, r101.extraData) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.onShow, r101.onShow) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.useMask, r101.useMask) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.selectedPayTypeVoucherInfo, r101.selectedPayTypeVoucherInfo) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.superimposedRetainInfo, r101.superimposedRetainInfo) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.initDataApply, r101.initDataApply) == true) goto L48;
        return false;
    L48:
        if (this.retainShowStyle == r101.retainShowStyle) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.addiVoucherType, r101.addiVoucherType) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.teaSource, r101.teaSource) == true) goto L57;
        return false;
    L57:
        if (this.isQueryPayTypeReady == r101.isQueryPayTypeReady) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.retainInfoBatch, r101.retainInfoBatch) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.clientRetainInfo, r101.clientRetainInfo) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.clientExtraData, r101.clientExtraData) == true) goto L68;
        return false;
    L68:
        return true;
    }

    public int hashCode() {
        JSONObject r100 = this.retainInfoV2;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<LynxDialogEvent, ? extends Function2<? super Dialog, ? super JSONObject, Unit>> r104 = this.eventHandlerMap;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        LynxKeepDialogFromScene r107 = this.fromScene;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        LynxKeepDialogShowPosition r110 = this.showFromPosition;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        int r113 = 1231;
        if (this.showDefaultKeepDialogOnly == false) goto L21;
        int r114 = 1231;
    L22:
        int r115 = (r112 + r114) * 31;
        if (this.isFingerprintLocalEnable == false) goto L25;
        int r116 = 1231;
    L26:
        int r117 = (r115 + r116) * 31;
        String r118 = this.selectedPayType;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        JSONObject r121 = this.extraData;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        Function0<Unit> r124 = this.onShow;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (r123 + r125) * 31;
        Boolean r127 = this.useMask;
        if (r127 != null) goto L41;
        int r128 = 0;
    L42:
        int r129 = (r126 + r128) * 31;
        VoucherRetainInfo r130 = this.selectedPayTypeVoucherInfo;
        if (r130 != null) goto L45;
        int r131 = 0;
    L46:
        int r132 = (r129 + r131) * 31;
        VoucherRetainInfo r133 = this.superimposedRetainInfo;
        if (r133 != null) goto L49;
        int r134 = 0;
    L50:
        int r135 = (r132 + r134) * 31;
        Function1<JSONObject, Unit> r136 = this.initDataApply;
        if (r136 != null) goto L53;
        int r137 = 0;
    L54:
        int r138 = (((((((r135 + r137) * 31) + this.retainShowStyle) * 31) + this.addiVoucherType.hashCode()) * 31) + this.teaSource.hashCode()) * 31;
        if (this.isQueryPayTypeReady == true) goto L58;
        r113 = 1237;
    L58:
        int r139 = (r138 + r113) * 31;
        JSONObject r140 = this.retainInfoBatch;
        if (r140 != null) goto L61;
        int r141 = 0;
    L62:
        int r142 = (r139 + r141) * 31;
        JSONObject r143 = this.clientRetainInfo;
        if (r143 != null) goto L65;
        int r144 = 0;
    L66:
        int r145 = (r142 + r144) * 31;
        JSONObject r146 = this.clientExtraData;
        if (r146 == null) goto L71;
        r101 = r146.hashCode();
    L71:
        return r145 + r101;
    L65:
        r144 = r143.hashCode();
        goto L66
    L61:
        r141 = r140.hashCode();
        goto L62
    L53:
        r137 = r136.hashCode();
        goto L54
    L49:
        r134 = r133.hashCode();
        goto L50
    L45:
        r131 = r130.hashCode();
        goto L46
    L41:
        r128 = r127.hashCode();
        goto L42
    L37:
        r125 = r124.hashCode();
        goto L38
    L33:
        r122 = r121.hashCode();
        goto L34
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = 1237;
        goto L26
    L21:
        r114 = 1237;
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "RetainInfoV2Config(retainInfoV2=" + this.retainInfoV2 + ", eventHandlerMap=" + this.eventHandlerMap + ", fromScene=" + this.fromScene + ", showFromPosition=" + this.showFromPosition + ", showDefaultKeepDialogOnly=" + this.showDefaultKeepDialogOnly + ", isFingerprintLocalEnable=" + this.isFingerprintLocalEnable + ", selectedPayType=" + this.selectedPayType + ", extraData=" + this.extraData + ", onShow=" + this.onShow + ", useMask=" + this.useMask + ", selectedPayTypeVoucherInfo=" + this.selectedPayTypeVoucherInfo + ", superimposedRetainInfo=" + this.superimposedRetainInfo + ", initDataApply=" + this.initDataApply + ", retainShowStyle=" + this.retainShowStyle + ", addiVoucherType=" + this.addiVoucherType + ", teaSource=" + this.teaSource + ", isQueryPayTypeReady=" + this.isQueryPayTypeReady + ", retainInfoBatch=" + this.retainInfoBatch + ", clientRetainInfo=" + this.clientRetainInfo + ", clientExtraData=" + this.clientExtraData + ')';
    }

    public final String getAddiVoucherType() {
        return this.addiVoucherType;
    }

    public final JSONObject getClientExtraData() {
        return this.clientExtraData;
    }

    public final JSONObject getClientRetainInfo() {
        return this.clientRetainInfo;
    }

    public final Map<LynxDialogEvent, Function2<Dialog, JSONObject, Unit>> getEventHandlerMap() {
        return this.eventHandlerMap;
    }

    public final JSONObject getExtraData() {
        return this.extraData;
    }

    public final LynxKeepDialogFromScene getFromScene() {
        return this.fromScene;
    }

    public final Function1<JSONObject, Unit> getInitDataApply() {
        return this.initDataApply;
    }

    public final Function0<Unit> getOnShow() {
        return this.onShow;
    }

    public final JSONObject getRetainInfoBatch() {
        return this.retainInfoBatch;
    }

    public final JSONObject getRetainInfoV2() {
        return this.retainInfoV2;
    }

    public final int getRetainShowStyle() {
        return this.retainShowStyle;
    }

    public final String getSelectedPayType() {
        return this.selectedPayType;
    }

    public final VoucherRetainInfo getSelectedPayTypeVoucherInfo() {
        return this.selectedPayTypeVoucherInfo;
    }

    public final boolean getShowDefaultKeepDialogOnly() {
        return this.showDefaultKeepDialogOnly;
    }

    public final LynxKeepDialogShowPosition getShowFromPosition() {
        return this.showFromPosition;
    }

    public final VoucherRetainInfo getSuperimposedRetainInfo() {
        return this.superimposedRetainInfo;
    }

    public final String getTeaSource() {
        return this.teaSource;
    }

    public final boolean getUseKeepDialogFrequencyForClientRetainInfo() {
        return this.useKeepDialogFrequencyForClientRetainInfo;
    }

    public final Boolean getUseMask() {
        return this.useMask;
    }

    public final boolean isFingerprintLocalEnable() {
        return this.isFingerprintLocalEnable;
    }

    public final boolean isQueryPayTypeReady() {
        return this.isQueryPayTypeReady;
    }

    public final void setClientExtraData(JSONObject r100) {
        this.clientExtraData = r100;
    }

    public final void setClientRetainInfo(JSONObject r100) {
        this.clientRetainInfo = r100;
    }

    public final void setEventHandlerMap(Map<LynxDialogEvent, ? extends Function2<? super Dialog, ? super JSONObject, Unit>> r100) {
        this.eventHandlerMap = r100;
    }

    public final void setUseKeepDialogFrequencyForClientRetainInfo(boolean r100) {
        this.useKeepDialogFrequencyForClientRetainInfo = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RetainInfoV2Config(JSONObject r100, Map<LynxDialogEvent, ? extends Function2<? super Dialog, ? super JSONObject, Unit>> r101, LynxKeepDialogFromScene r102, LynxKeepDialogShowPosition r103, boolean r104, boolean r110, String r111, JSONObject r112, Function0<Unit> r113, Boolean r114, VoucherRetainInfo r115, VoucherRetainInfo r116, Function1<? super JSONObject, Unit> r117, int r118, String r119, String r210, boolean r211, JSONObject r212, JSONObject r213, JSONObject r214) {
        Intrinsics.checkNotNullParameter(r119, "addiVoucherType");
        Intrinsics.checkNotNullParameter(r210, "teaSource");
        this.retainInfoV2 = r100;
        this.eventHandlerMap = r101;
        this.fromScene = r102;
        this.showFromPosition = r103;
        this.showDefaultKeepDialogOnly = r104;
        this.isFingerprintLocalEnable = r110;
        this.selectedPayType = r111;
        this.extraData = r112;
        this.onShow = r113;
        this.useMask = r114;
        this.selectedPayTypeVoucherInfo = r115;
        this.superimposedRetainInfo = r116;
        this.initDataApply = r117;
        this.retainShowStyle = r118;
        this.addiVoucherType = r119;
        this.teaSource = r210;
        this.isQueryPayTypeReady = r211;
        this.retainInfoBatch = r212;
        this.clientRetainInfo = r213;
        this.clientExtraData = r214;
    }

    public /* synthetic */ RetainInfoV2Config(JSONObject r210, Map r211, LynxKeepDialogFromScene r212, LynxKeepDialogShowPosition r213, boolean r214, boolean r215, String r216, JSONObject r217, Function0 r310, Boolean r311, VoucherRetainInfo r312, VoucherRetainInfo r313, Function1 r314, int r315, String r316, String r317, boolean r318, JSONObject r319, JSONObject r410, JSONObject r411, int r412, DefaultConstructorMarker r413) {
        if ((r412 & 1) == 0) goto L5;
        JSONObject r100 = null;
    L7:
        if ((r412 & 2) == 0) goto L9;
        Map r101 = MapsKt.emptyMap();
    L11:
        if ((r412 & 4) == 0) goto L13;
        LynxKeepDialogFromScene r102 = null;
    L15:
        if ((r412 & 8) == 0) goto L17;
        LynxKeepDialogShowPosition r103 = null;
    L19:
        if ((r412 & 16) == 0) goto L21;
        boolean r104 = false;
    L23:
        if ((r412 & 32) == 0) goto L25;
        boolean r105 = true;
    L27:
        if ((r412 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r412 & 128) == 0) goto L33;
        JSONObject r110 = null;
    L35:
        if ((r412 & 256) == 0) goto L37;
        Function0 r111 = null;
    L39:
        if ((r412 & 512) == 0) goto L41;
        Boolean r112 = Boolean.TRUE;
    L43:
        if ((r412 & 1024) == 0) goto L45;
        VoucherRetainInfo r113 = null;
    L47:
        if ((r412 & 2048) == 0) goto L49;
        VoucherRetainInfo r114 = null;
    L51:
        if ((r412 & 4096) == 0) goto L53;
        Function1 r115 = null;
    L55:
        if ((r412 & 8192) == 0) goto L57;
        int r107 = 0;
    L58:
        String r116 = "";
        if ((r412 & 16384) == 0) goto L61;
        String r108 = "";
    L63:
        if ((r412 & 32768) != 0) goto L67;
        r116 = r317;
    L67:
        if ((r412 & 65536) == 0) goto L69;
        boolean r117 = false;
    L71:
        if ((r412 & 131072) == 0) goto L73;
        JSONObject r118 = null;
    L75:
        if ((r412 & 262144) == 0) goto L77;
        JSONObject r119 = null;
    L79:
        if ((r412 & 524288) == 0) goto L81;
        JSONObject r109 = null;
    L82:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r107, r108, r116, r117, r118, r119, r109);
        return;
    L81:
        r109 = r411;
        goto L82
    L77:
        r119 = r410;
        goto L79
    L73:
        r118 = r319;
        goto L75
    L69:
        r117 = r318;
        goto L71
    L61:
        r108 = r316;
        goto L63
    L57:
        r107 = r315;
        goto L58
    L53:
        r115 = r314;
        goto L55
    L49:
        r114 = r313;
        goto L51
    L45:
        r113 = r312;
        goto L47
    L41:
        r112 = r311;
        goto L43
    L37:
        r111 = r310;
        goto L39
    L33:
        r110 = r217;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
