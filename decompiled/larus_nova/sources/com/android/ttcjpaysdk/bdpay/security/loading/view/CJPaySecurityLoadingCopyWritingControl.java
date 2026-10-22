package com.android.ttcjpaysdk.bdpay.security.loading.view;

import com.android.ttcjpaysdk.base.ui.data.CJPaySecurityLoadingStyleInfo;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayCountDownTimeUtil;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001:\u00015B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\bJ<\u0010\u001f\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010#\u001a\u0004\u0018\u00010!2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J \u0010$\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002J&\u0010%\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010#\u001a\u0004\u0018\u00010!H\u0002J\u0006\u0010&\u001a\u00020\rJ\b\u0010'\u001a\u00020\u001dH\u0002J\b\u0010(\u001a\u00020\u001dH\u0002J\b\u0010)\u001a\u00020\u001dH\u0002J\b\u0010*\u001a\u00020\u001dH\u0002J\u000e\u0010+\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\rJ\u000e\u0010,\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\rJ\b\u0010-\u001a\u00020\u001dH\u0002J\u0006\u0010.\u001a\u00020\u001dJ\b\u0010/\u001a\u00020\u001dH\u0002J\b\u00100\u001a\u00020\u001dH\u0002J\b\u00101\u001a\u00020\u001dH\u0002J\b\u00102\u001a\u00020\u001dH\u0002J\b\u00103\u001a\u00020\u001dH\u0002J\b\u00104\u001a\u00020\u001dH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/security/loading/view/CJPaySecurityLoadingCopyWritingControl;", "", "callBack", "Lcom/android/ttcjpaysdk/bdpay/security/loading/view/CJPaySecurityLoadingCopyWritingControl$OnCopyWritingCallBack;", "(Lcom/android/ttcjpaysdk/bdpay/security/loading/view/CJPaySecurityLoadingCopyWritingControl$OnCopyWritingCallBack;)V", "beforeCopyWriting", "", "consumeTime", "", "countDownBeforeTag", "countDownPayTag", "countDownPreTag", "isBeforeTickFinish", "", "isPayingTickFinish", "isPreTickFinish", "isQueryEnd", "isShowCopyWriting", "isStart", "onBeforeTickListener", "Lcom/android/ttcjpaysdk/base/utils/CJPayCountDownTimeUtil$OnTickListener;", "onPayingTickListener", "onPreTickListener", "payingCopyWriting", "preCopyWriting", "showBeforeCopyWritingTime", "showPayingCopyWritingTime", "showPreCopyWritingTime", "cancelTimeCountDown", "", "getConsumeTime", "initData", "beforeShowInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPaySecurityLoadingStyleInfo$CJPaySecurityItemShowInfo;", "preShowInfo", "payingShowInfo", "initTickListener", "initTimeData", "isDoComplete", "processBeforeTickFinish", "processPayingTickFinish", "processPreTickFinish", BasicTestActionHandler.TEST_ACTION_RESET, "setQueryEnd", "setStart", "showBeforeCopyWriting", "showCopyWriting", "showDefaultCopyWriting", "showPayingCopyWriting", "showPreCopyWriting", "startBeforeTimeCountDown", "startPayingTimeCountDown", "startPreTimeCountDown", "OnCopyWritingCallBack", "bdpay-security-loading_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPaySecurityLoadingCopyWritingControl {
    private String beforeCopyWriting;
    private final OnCopyWritingCallBack callBack;
    private long consumeTime;
    private String countDownBeforeTag;
    private String countDownPayTag;
    private String countDownPreTag;
    private boolean isBeforeTickFinish;
    private boolean isPayingTickFinish;
    private boolean isPreTickFinish;
    private boolean isQueryEnd;
    private volatile boolean isShowCopyWriting;
    private boolean isStart;
    private CJPayCountDownTimeUtil.OnTickListener onBeforeTickListener;
    private CJPayCountDownTimeUtil.OnTickListener onPayingTickListener;
    private CJPayCountDownTimeUtil.OnTickListener onPreTickListener;
    private String payingCopyWriting;
    private String preCopyWriting;
    private long showBeforeCopyWritingTime;
    private long showPayingCopyWritingTime;
    private long showPreCopyWritingTime;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/security/loading/view/CJPaySecurityLoadingCopyWritingControl$OnCopyWritingCallBack;", "", "getDefaultCopyWriting", "", "onComplete", "", "setCopyWriting", "content", "isPreCopyWriting", "", "bdpay-security-loading_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnCopyWritingCallBack {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static /* synthetic */ void setCopyWriting$default(OnCopyWritingCallBack r100, String r101, boolean r102, int r103, Object r104) {
                if (r104 != null) goto L9;
                if ((r103 & 2) == 0) goto L6;
                r102 = false;
            L6:
                r100.setCopyWriting(r101, r102);
                return;
            L9:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCopyWriting");
            }
        }

        String getDefaultCopyWriting();

        void onComplete();

        void setCopyWriting(String r100, boolean r101);
    }

    private final void processBeforeTickFinish() {
        this.isBeforeTickFinish = true;
        long r100 = this.showPreCopyWritingTime;
        if (r100 >= 0) goto L10;
        if (this.showPayingCopyWritingTime >= 0) goto L10;
        this.isPreTickFinish = true;
        this.isPayingTickFinish = true;
        OnCopyWritingCallBack r101 = this.callBack;
        if (r101 == null) goto L14;
        r101.onComplete();
        return;
    L14:
        return;
    L10:
        if (r100 < 0) goto L12;
        showPreCopyWriting();
        return;
    L12:
        showPayingCopyWriting();
    }

    private final void processPayingTickFinish() {
        this.isPayingTickFinish = true;
        OnCopyWritingCallBack r100 = this.callBack;
        if (r100 == null) goto L6;
        r100.onComplete();
        return;
    }

    private final void processPreTickFinish() {
        this.isPreTickFinish = true;
        if (this.showPayingCopyWritingTime >= 0) goto L7;
        this.isPayingTickFinish = true;
        OnCopyWritingCallBack r100 = this.callBack;
        if (r100 == null) goto L9;
        r100.onComplete();
        return;
    L9:
        return;
    L7:
        showPayingCopyWriting();
    }

    private final void showDefaultCopyWriting() {
        this.isBeforeTickFinish = true;
        this.isPreTickFinish = true;
        this.isPayingTickFinish = true;
        OnCopyWritingCallBack r100 = this.callBack;
        if (r100 != null) goto L5;
    L9:
        OnCopyWritingCallBack r101 = this.callBack;
        if (r101 == null) goto L13;
        r101.onComplete();
        return;
    L13:
        return;
    L5:
        if (r100 == null) goto L7;
        String r102 = r100.getDefaultCopyWriting();
    L8:
        OnCopyWritingCallBack.DefaultImpls.setCopyWriting$default(r100, r102, false, 2, null);
        goto L9
    L7:
        r102 = null;
        goto L8
    }

    private final void showPayingCopyWriting() {
        this.isBeforeTickFinish = true;
        this.isPreTickFinish = true;
        String r100 = this.payingCopyWriting;
        if (r100 == null) goto L24;
        Unit r101 = null;
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L24;
        OnCopyWritingCallBack r102 = this.callBack;
        if (r102 == null) goto L12;
        OnCopyWritingCallBack.DefaultImpls.setCopyWriting$default(r102, r100, false, 2, null);
    L12:
        long r103 = this.showPayingCopyWritingTime;
        if (r103 <= 0) goto L16;
        startPayingTimeCountDown();
        r101 = Unit.INSTANCE;
    L23:
        if (r101 == null) goto L24;
        return;
    L16:
        if (r103 != 0) goto L20;
        this.isBeforeTickFinish = true;
        this.isPreTickFinish = true;
        this.isPayingTickFinish = true;
        OnCopyWritingCallBack r104 = this.callBack;
        if (r104 == null) goto L23;
        r104.onComplete();
        r101 = Unit.INSTANCE;
        goto L23
    L20:
        this.isPayingTickFinish = true;
        OnCopyWritingCallBack r105 = this.callBack;
        if (r105 == null) goto L23;
        r105.onComplete();
        r101 = Unit.INSTANCE;
    L24:
        this.isPayingTickFinish = true;
        OnCopyWritingCallBack r106 = this.callBack;
        if (r106 == null) goto L29;
        r106.onComplete();
        Unit r107 = Unit.INSTANCE;
        return;
    }

    private final void showPreCopyWriting() {
        this.isBeforeTickFinish = true;
        String r100 = this.preCopyWriting;
        Unit r101 = null;
        if (r100 != null) goto L5;
    L22:
        if (r101 != null) goto L25;
        this.isPreTickFinish = true;
        return;
    L25:
        return;
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L22;
        OnCopyWritingCallBack r102 = this.callBack;
        if (r102 == null) goto L12;
        r102.setCopyWriting(r100, true);
    L12:
        long r103 = this.showPreCopyWritingTime;
        if (r103 <= 0) goto L17;
        startPreTimeCountDown();
        Unit r104 = Unit.INSTANCE;
    L15:
        r101 = r104;
        goto L22
    L17:
        if (r103 != 0) goto L21;
        this.isBeforeTickFinish = true;
        this.isPreTickFinish = true;
        this.isPayingTickFinish = true;
        OnCopyWritingCallBack r105 = this.callBack;
        if (r105 == null) goto L22;
        r105.onComplete();
        r104 = Unit.INSTANCE;
        goto L15
    L21:
        this.isPreTickFinish = true;
        r104 = Unit.INSTANCE;
        goto L15
    }

    private final void showBeforeCopyWriting() {
        String r100 = this.beforeCopyWriting;
        Unit r101 = null;
        if (r100 != null) goto L5;
    L22:
        if (r101 != null) goto L25;
        this.isBeforeTickFinish = true;
        return;
    L25:
        return;
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L22;
        OnCopyWritingCallBack r102 = this.callBack;
        if (r102 == null) goto L12;
        r102.setCopyWriting(r100, true);
    L12:
        long r103 = this.showBeforeCopyWritingTime;
        if (r103 <= 0) goto L17;
        startBeforeTimeCountDown();
        Unit r104 = Unit.INSTANCE;
    L15:
        r101 = r104;
        goto L22
    L17:
        if (r103 != 0) goto L21;
        this.isBeforeTickFinish = true;
        this.isPreTickFinish = true;
        this.isPayingTickFinish = true;
        OnCopyWritingCallBack r105 = this.callBack;
        if (r105 == null) goto L22;
        r105.onComplete();
        r104 = Unit.INSTANCE;
        goto L15
    L21:
        this.isBeforeTickFinish = true;
        r104 = Unit.INSTANCE;
        goto L15
    }

    public final boolean isDoComplete() {
        if (this.isStart == true) goto L5;
    L14:
        return true;
    L5:
        if (this.isQueryEnd == true) goto L7;
    L13:
        return false;
    L7:
        if (this.isBeforeTickFinish == false) goto L13;
        if (this.isPreTickFinish == false) goto L13;
        if (this.isPayingTickFinish == false) goto L13;
        goto L13
    }

    public final void showCopyWriting() {
        if (this.isShowCopyWriting == false) goto L5;
        return;
    L5:
        if (this.isStart == false) goto L27;
        this.isShowCopyWriting = true;
        this.consumeTime = System.currentTimeMillis();
        long r100 = this.showBeforeCopyWritingTime;
        if (r100 >= 0) goto L14;
        if (this.showPreCopyWritingTime >= 0) goto L14;
        if (this.showPayingCopyWritingTime >= 0) goto L14;
        showDefaultCopyWriting();
        return;
    L14:
        if (r100 < 0) goto L17;
        showBeforeCopyWriting();
        return;
    L17:
        if (this.showPreCopyWritingTime < 0) goto L20;
        showPreCopyWriting();
        return;
    L20:
        if (this.showPayingCopyWritingTime < 0) goto L22;
        showPayingCopyWriting();
        return;
    L22:
        this.isBeforeTickFinish = true;
        this.isPreTickFinish = true;
        this.isPayingTickFinish = true;
        OnCopyWritingCallBack r101 = this.callBack;
        if (r101 == null) goto L32;
        r101.onComplete();
        return;
    L32:
        return;
    }

    private final void reset() {
        cancelTimeCountDown();
        this.onBeforeTickListener = null;
        this.onPreTickListener = null;
        this.onPayingTickListener = null;
        this.isBeforeTickFinish = false;
        this.isPreTickFinish = false;
        this.isPayingTickFinish = false;
        this.showBeforeCopyWritingTime = -1;
        this.showPreCopyWritingTime = -1;
        this.showPayingCopyWritingTime = -1;
        this.isStart = false;
        this.isQueryEnd = false;
        this.beforeCopyWriting = null;
        this.preCopyWriting = null;
        this.payingCopyWriting = null;
        this.isShowCopyWriting = false;
        this.consumeTime = -1;
        this.countDownBeforeTag = "cj_pay_security_loading_count_down_before_tag";
        this.countDownPreTag = "cj_pay_security_loading_count_down_pre_tag";
        this.countDownPayTag = "cj_pay_security_loading_count_down_pay_tag";
    }

    private final void startBeforeTimeCountDown() {
        CJPayCountDownTimeUtil r100 = CJPayCountDownTimeUtil.getInstance();
        String r101 = this.countDownBeforeTag;
        long r102 = this.showBeforeCopyWritingTime;
        r100.putCountDownTimer(r101, r102, r102, this.onBeforeTickListener);
    }

    private final void startPayingTimeCountDown() {
        CJPayCountDownTimeUtil r100 = CJPayCountDownTimeUtil.getInstance();
        String r101 = this.countDownPayTag;
        long r102 = this.showPayingCopyWritingTime;
        r100.putCountDownTimer(r101, r102, r102, this.onPayingTickListener);
    }

    private final void startPreTimeCountDown() {
        CJPayCountDownTimeUtil r100 = CJPayCountDownTimeUtil.getInstance();
        String r101 = this.countDownPreTag;
        long r102 = this.showPreCopyWritingTime;
        r100.putCountDownTimer(r101, r102, r102, this.onPreTickListener);
    }

    public final void cancelTimeCountDown() {
        CJPayCountDownTimeUtil.getInstance().cancel(this.countDownBeforeTag);
        CJPayCountDownTimeUtil.getInstance().cancel(this.countDownPreTag);
        CJPayCountDownTimeUtil.getInstance().cancel(this.countDownPayTag);
    }

    public final long getConsumeTime() {
        return this.consumeTime;
    }

    public CJPaySecurityLoadingCopyWritingControl(OnCopyWritingCallBack r100) {
        this.callBack = r100;
        this.showBeforeCopyWritingTime = -1;
        this.showPreCopyWritingTime = -1;
        this.showPayingCopyWritingTime = -1;
        this.consumeTime = -1;
        this.countDownBeforeTag = "cj_pay_security_loading_count_down_before_tag";
        this.countDownPreTag = "cj_pay_security_loading_count_down_pre_tag";
        this.countDownPayTag = "cj_pay_security_loading_count_down_pay_tag";
    }

    public static final /* synthetic */ void access$processBeforeTickFinish(CJPaySecurityLoadingCopyWritingControl r100) {
        r100.processBeforeTickFinish();
    }

    public static final /* synthetic */ void access$processPayingTickFinish(CJPaySecurityLoadingCopyWritingControl r100) {
        r100.processPayingTickFinish();
    }

    public static final /* synthetic */ void access$processPreTickFinish(CJPaySecurityLoadingCopyWritingControl r100) {
        r100.processPreTickFinish();
    }

    public final void setQueryEnd(boolean r100) {
        this.isQueryEnd = r100;
    }

    public final void setStart(boolean r100) {
        this.isStart = r100;
    }

    private final void initTickListener(String r100, String r101, String r102) {
        this.countDownBeforeTag = r100;
        this.countDownPreTag = r101;
        this.countDownPayTag = r102;
        this.onBeforeTickListener = new AnonymousClass1(this);
        this.onPreTickListener = new AnonymousClass2(this);
        this.onPayingTickListener = new AnonymousClass3(this);
    }

    private final void initTimeData(CJPaySecurityLoadingStyleInfo.CJPaySecurityItemShowInfo r110, CJPaySecurityLoadingStyleInfo.CJPaySecurityItemShowInfo r111, CJPaySecurityLoadingStyleInfo.CJPaySecurityItemShowInfo r112) {
        Boolean r100 = null;
        if (r110 == null) goto L5;
        String r101 = r110.text;
    L6:
        this.beforeCopyWriting = r101;
        if (r111 == null) goto L9;
        String r102 = r111.text;
    L10:
        this.preCopyWriting = r102;
        if (r112 == null) goto L13;
        String r103 = r112.text;
    L14:
        this.payingCopyWriting = r103;
        long r104 = -1;
        if (r110 != null) goto L103;
    L22:
        long r105 = -1;
    L23:
        if (r111 != null) goto L105;
    L30:
        long r113 = -1;
    L31:
        if (r112 != null) goto L101;
    L38:
        long r106 = -1;
    L40:
        if (r105 < 0) goto L42;
    L45:
        String r107 = this.beforeCopyWriting;
        if (r107 == null) goto L48;
        Boolean r108 = Boolean.valueOf(StringsKt.isBlank(r107));
    L49:
        if (r108 == null) goto L51;
        boolean r109 = r108.booleanValue();
    L52:
        if (r109 == false) goto L70;
        String r114 = this.preCopyWriting;
        if (r114 == null) goto L56;
        Boolean r115 = Boolean.valueOf(StringsKt.isBlank(r114));
    L57:
        if (r115 == null) goto L59;
        boolean r116 = r115.booleanValue();
    L60:
        if (r116 == false) goto L70;
        String r117 = this.payingCopyWriting;
        if (r117 == null) goto L64;
        Boolean r118 = Boolean.valueOf(StringsKt.isBlank(r117));
    L65:
        if (r118 == null) goto L67;
        boolean r119 = r118.booleanValue();
    L68:
        if (r119 == false) goto L70;
    L69:
        this.showBeforeCopyWritingTime = -1;
        this.showPreCopyWritingTime = -1;
        this.showPayingCopyWritingTime = -1;
        this.isBeforeTickFinish = true;
        this.isPreTickFinish = true;
        this.isPayingTickFinish = true;
        return;
    L67:
        r119 = true;
        goto L68
    L64:
        r118 = null;
        goto L65
    L59:
        r116 = true;
        goto L60
    L56:
        r115 = null;
    L70:
        String r120 = this.beforeCopyWriting;
        if (r120 == null) goto L73;
        Boolean r121 = Boolean.valueOf(!StringsKt.isBlank(r120));
    L75:
        if (r121 == null) goto L77;
        boolean r122 = r121.booleanValue();
    L78:
        if (r122 == true) goto L81;
        r105 = -1;
    L81:
        this.showBeforeCopyWritingTime = r105;
        String r123 = this.preCopyWriting;
        if (r123 == null) goto L84;
        Boolean r124 = Boolean.valueOf(!StringsKt.isBlank(r123));
    L85:
        if (r124 == null) goto L87;
        boolean r125 = r124.booleanValue();
    L88:
        if (r125 == true) goto L91;
        r113 = -1;
    L91:
        this.showPreCopyWritingTime = r113;
        String r126 = this.payingCopyWriting;
        if (r126 == null) goto L94;
        r100 = Boolean.valueOf(!StringsKt.isBlank(r126));
    L94:
        if (r100 == null) goto L96;
        boolean r127 = r100.booleanValue();
    L97:
        if (r127 == false) goto L99;
        r104 = r106;
    L99:
        this.showPayingCopyWritingTime = r104;
        this.isBeforeTickFinish = false;
        this.isPreTickFinish = false;
        this.isPayingTickFinish = false;
        return;
    L96:
        r127 = false;
        goto L97
    L87:
        r125 = false;
        goto L88
    L84:
        r124 = null;
        goto L85
    L77:
        r122 = false;
        goto L78
    L73:
        r121 = null;
        goto L75
    L51:
        r109 = true;
        goto L52
    L48:
        r108 = null;
        goto L49
    L42:
        if (r113 >= 0) goto L45;
        if (r106 < 0) goto L69;
    L101:
        String r128 = r112.min_time;     // Catch: Throwable -> L36
        if (r128 == null) goto L38;
        r106 = CastLongProtector.parseLong(r128);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPaySecurityLoadingCopyWritingControl#initTimeData", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPaySecurityLoadingCopyWritingControl#initTimeData", th);
        goto L38
    L105:
        String r129 = r111.min_time;     // Catch: Throwable -> L28
        if (r129 == null) goto L30;
        r113 = CastLongProtector.parseLong(r129);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPaySecurityLoadingCopyWritingControl#initTimeData", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPaySecurityLoadingCopyWritingControl#initTimeData", th);
        goto L30
    L103:
        String r130 = r110.min_time;     // Catch: Throwable -> L20
        if (r130 == null) goto L22;
        r105 = CastLongProtector.parseLong(r130);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPaySecurityLoadingCopyWritingControl#initTimeData", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPaySecurityLoadingCopyWritingControl#initTimeData", th);
        goto L22
    L13:
        r103 = null;
        goto L14
    L9:
        r102 = null;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    public final void initData(CJPaySecurityLoadingStyleInfo.CJPaySecurityItemShowInfo r100, CJPaySecurityLoadingStyleInfo.CJPaySecurityItemShowInfo r101, CJPaySecurityLoadingStyleInfo.CJPaySecurityItemShowInfo r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r103, "countDownBeforeTag");
        Intrinsics.checkNotNullParameter(r104, "countDownPreTag");
        Intrinsics.checkNotNullParameter(r105, "countDownPayTag");
        reset();
        initTimeData(r100, r101, r102);
        initTickListener(r103, r104, r105);
    }
}
