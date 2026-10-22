package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB×\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006¢\u0006\u0002\u0010\u001aR\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayOptimizeSwitch;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "redpacketFixType", "", "bindCardFailCallbackConfig", "", "payResultAnimatorConfig", "fixPayAgainCloseVerifyPage", "fixPayNewCardResultPageMethodTeaParam", "fixPayAgainResultPageTeaParam", "keepTradeConfirmPapiid", "supportMoneyScrollAnim", "fixPayNoneSelectPayMethodDefaultPtcodeParam", "lynxEventMemoryLeakFix", "ignorePwdPopLogicCheck", "measurePwdHeightOpt", "scrollAnimViewNullOpt", "scrollAnimViewOpt", "useMoneyStdView", "fpsOpen", "fontSizeOpt", "kmpUnifyCounterOpt", "loadingSwitch", "cjSwitchViewCheckedOpt", "kmpCacheUtilUseHybridMap", "(IZZZZZZZZZZZZZZZZZZZZ)V", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayOptimizeSwitch implements CJPayObject, Serializable {
    public static final Companion Companion = null;
    private static final Lazy<CJPayOptimizeSwitch> optimizeSwitch$delegate = null;
    public boolean bindCardFailCallbackConfig;
    public boolean cjSwitchViewCheckedOpt;
    public boolean fixPayAgainCloseVerifyPage;
    public boolean fixPayAgainResultPageTeaParam;
    public boolean fixPayNewCardResultPageMethodTeaParam;
    public boolean fixPayNoneSelectPayMethodDefaultPtcodeParam;
    public boolean fontSizeOpt;
    public boolean fpsOpen;
    public boolean ignorePwdPopLogicCheck;
    public boolean keepTradeConfirmPapiid;
    public boolean kmpCacheUtilUseHybridMap;
    public boolean kmpUnifyCounterOpt;
    public boolean loadingSwitch;
    public boolean lynxEventMemoryLeakFix;
    public boolean measurePwdHeightOpt;
    public boolean payResultAnimatorConfig;
    public int redpacketFixType;
    public boolean scrollAnimViewNullOpt;
    public boolean scrollAnimViewOpt;
    public boolean supportMoneyScrollAnim;
    public boolean useMoneyStdView;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayOptimizeSwitch$Companion;", "", "()V", "optimizeSwitch", "Lcom/android/ttcjpaysdk/base/settings/bean/CJPayOptimizeSwitch;", "getOptimizeSwitch", "()Lcom/android/ttcjpaysdk/base/settings/bean/CJPayOptimizeSwitch;", "optimizeSwitch$delegate", "Lkotlin/Lazy;", MonitorConstants.CONNECT_TYPE_GET, "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final CJPayOptimizeSwitch getOptimizeSwitch() {
            return (CJPayOptimizeSwitch) CJPayOptimizeSwitch.access$getOptimizeSwitch$delegate$cp().getValue();
        }

        public final CJPayOptimizeSwitch get() {
            return getOptimizeSwitch();
        }
    }

    public CJPayOptimizeSwitch() {
        this(0, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, 2097151, null);
    }

    static {
        Companion = new Companion(null);
        optimizeSwitch$delegate = LazyKt.lazy(CJPayOptimizeSwitch$Companion$optimizeSwitch$2.INSTANCE);
    }

    public static final /* synthetic */ Lazy access$getOptimizeSwitch$delegate$cp() {
        return optimizeSwitch$delegate;
    }

    public CJPayOptimizeSwitch(int r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r116, boolean r117, boolean r118, boolean r119, boolean r210, boolean r211, boolean r212, boolean r213) {
        this.redpacketFixType = r100;
        this.bindCardFailCallbackConfig = r101;
        this.payResultAnimatorConfig = r102;
        this.fixPayAgainCloseVerifyPage = r103;
        this.fixPayNewCardResultPageMethodTeaParam = r104;
        this.fixPayAgainResultPageTeaParam = r105;
        this.keepTradeConfirmPapiid = r106;
        this.supportMoneyScrollAnim = r110;
        this.fixPayNoneSelectPayMethodDefaultPtcodeParam = r111;
        this.lynxEventMemoryLeakFix = r112;
        this.ignorePwdPopLogicCheck = r113;
        this.measurePwdHeightOpt = r114;
        this.scrollAnimViewNullOpt = r115;
        this.scrollAnimViewOpt = r116;
        this.useMoneyStdView = r117;
        this.fpsOpen = r118;
        this.fontSizeOpt = r119;
        this.kmpUnifyCounterOpt = r210;
        this.loadingSwitch = r211;
        this.cjSwitchViewCheckedOpt = r212;
        this.kmpCacheUtilUseHybridMap = r213;
    }

    public /* synthetic */ CJPayOptimizeSwitch(int r210, boolean r211, boolean r212, boolean r213, boolean r214, boolean r215, boolean r216, boolean r310, boolean r311, boolean r312, boolean r313, boolean r314, boolean r315, boolean r316, boolean r317, boolean r318, boolean r319, boolean r410, boolean r411, boolean r412, boolean r413, int r414, DefaultConstructorMarker r415) {
        if ((r414 & 1) == 0) goto L5;
        int r100 = 1;
    L7:
        if ((r414 & 2) == 0) goto L9;
        boolean r101 = true;
    L10:
        boolean r102 = false;
        if ((r414 & 4) == 0) goto L13;
        boolean r103 = false;
    L15:
        if ((r414 & 8) == 0) goto L17;
        boolean r104 = true;
    L19:
        if ((r414 & 16) == 0) goto L21;
        boolean r105 = true;
    L23:
        if ((r414 & 32) == 0) goto L25;
        boolean r106 = true;
    L27:
        if ((r414 & 64) != 0) goto L31;
        r102 = r216;
    L31:
        if ((r414 & 128) == 0) goto L33;
        boolean r107 = true;
    L35:
        if ((r414 & 256) == 0) goto L37;
        boolean r110 = true;
    L39:
        if ((r414 & 512) == 0) goto L41;
        boolean r111 = true;
    L43:
        if ((r414 & 1024) == 0) goto L45;
        boolean r112 = true;
    L47:
        if ((r414 & 2048) == 0) goto L49;
        boolean r113 = true;
    L51:
        if ((r414 & 4096) == 0) goto L53;
        boolean r114 = true;
    L55:
        if ((r414 & 8192) == 0) goto L57;
        boolean r115 = true;
    L59:
        if ((r414 & 16384) == 0) goto L61;
        boolean r108 = true;
    L63:
        if ((r414 & 32768) == 0) goto L65;
        boolean r116 = true;
    L67:
        if ((r414 & 65536) == 0) goto L69;
        boolean r117 = true;
    L71:
        if ((r414 & 131072) == 0) goto L73;
        boolean r118 = true;
    L75:
        if ((r414 & 262144) == 0) goto L77;
        boolean r119 = true;
    L79:
        if ((r414 & 524288) == 0) goto L81;
        boolean r217 = true;
    L83:
        if ((r414 & 1048576) == 0) goto L85;
        boolean r109 = true;
    L86:
        this(r100, r101, r103, r104, r105, r106, r102, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r119, r217, r109);
        return;
    L85:
        r109 = r413;
        goto L86
    L81:
        r217 = r412;
        goto L83
    L77:
        r119 = r411;
        goto L79
    L73:
        r118 = r410;
        goto L75
    L69:
        r117 = r319;
        goto L71
    L65:
        r116 = r318;
        goto L67
    L61:
        r108 = r317;
        goto L63
    L57:
        r115 = r316;
        goto L59
    L53:
        r114 = r315;
        goto L55
    L49:
        r113 = r314;
        goto L51
    L45:
        r112 = r313;
        goto L47
    L41:
        r111 = r312;
        goto L43
    L37:
        r110 = r311;
        goto L39
    L33:
        r107 = r310;
        goto L35
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
        r101 = r211;
        goto L10
    L5:
        r100 = r210;
        goto L7
    }
}
