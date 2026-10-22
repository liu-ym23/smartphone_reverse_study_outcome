package com.android.ttcjpaysdk.verify.base;

import android.app.Activity;
import android.content.Context;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.service.CustomizedConfig;
import com.android.ttcjpaysdk.base.service.ICJPayDyVerifyService;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.settings.bean.CJPayFaceVerifyConfig;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.facelive.view.CJPayFaceGuideActivity;
import com.android.ttcjpaysdk.verify.data.DyVerifyToken;
import com.android.ttcjpaysdk.verify.utils.DyVerifyLog;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010\u000b2\b\u0010*\u001a\u0004\u0018\u00010\u000bH\u0002J&\u0010+\u001a\u0004\u0018\u00010,2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010)\u001a\u0004\u0018\u00010\u000b2\b\u0010*\u001a\u0004\u0018\u00010\u000bJ\b\u0010-\u001a\u0004\u0018\u00010\tJ\u0010\u0010.\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bJ\b\u0010/\u001a\u0004\u0018\u00010\u0007J\b\u00100\u001a\u00020\u0011H\u0002J\u0006\u00101\u001a\u00020\u0011J\u0010\u00101\u001a\u00020\u00112\b\u00102\u001a\u0004\u0018\u00010\u000bJ\u0006\u00103\u001a\u00020\u0011J\"\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u000b2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010:\u001a\u000205J\u0010\u0010;\u001a\u0002052\b\u0010<\u001a\u0004\u0018\u00010\u0005J\u001a\u0010=\u001a\u0002052\u0006\u0010>\u001a\u00020\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000bJ,\u0010?\u001a\u0002052\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tR\u0018\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR*\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0019j\b\u0012\u0004\u0012\u00020\u000b`\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010 \u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u001f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006@"}, d2 = {"Lcom/android/ttcjpaysdk/verify/base/DyVerifyCenter;", "", "()V", "activityHolder", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "callback", "Lcom/android/ttcjpaysdk/base/service/ICJPayDyVerifyService$IDyVerifyCallback;", "config", "Lcom/android/ttcjpaysdk/base/service/CustomizedConfig;", "curVerifyProduct", "", "getCurVerifyProduct", "()Ljava/lang/String;", "setCurVerifyProduct", "(Ljava/lang/String;)V", "isSmsNewStyle", "", "isVerifying", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isVerifyingId", "<set-?>", "verifyId", "getVerifyId", "verifyList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getVerifyList", "()Ljava/util/ArrayList;", "setVerifyList", "(Ljava/util/ArrayList;)V", "Lcom/android/ttcjpaysdk/verify/data/DyVerifyToken;", "verifyToken", "getVerifyToken", "()Lcom/android/ttcjpaysdk/verify/data/DyVerifyToken;", "buildHostInfo", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "ctx", "Landroid/content/Context;", "riskInfoParams", "", "appId", "merchantId", "createHostInfo", "Lorg/json/JSONObject;", "getConfig", "getIsVerifying", "getVerifyCallback", "isDyAtHostStackTop", "isTokenValid", "token", "needMask", "notifyResult", "", "code", "", "msg", "ext", "release", "setActivityHolder", "activity", "setIsVerifying", "isDoing", "setVerifyInfo", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DyVerifyCenter {
    public static final DyVerifyCenter INSTANCE = null;
    private static WeakReference<Activity> activityHolder = null;
    private static ICJPayDyVerifyService.IDyVerifyCallback callback = null;
    private static CustomizedConfig config = null;
    private static String curVerifyProduct = null;
    public static final boolean isSmsNewStyle = true;
    private static AtomicBoolean isVerifying;
    private static String isVerifyingId;
    private static String verifyId;
    private static ArrayList<String> verifyList;
    private static DyVerifyToken verifyToken;

    private DyVerifyCenter() {
    }

    private final boolean isDyAtHostStackTop() {
        ve4.a.f554342a.getClass();     // Catch: Throwable -> L50
        Activity[] r100 = ((FaceService) ve4.a.d(FaceService.class)).getHostActivityStack();     // Catch: Throwable -> L50
        if (r100 != null) goto L6;
    L12:
        boolean r101 = false;
    L13:
        if (r101 == false) goto L49;
        WeakReference<Activity> r102 = activityHolder;     // Catch: Throwable -> L50
        Activity r103 = null;
        if (r102 == null) goto L17;
        Activity r104 = r102.get();     // Catch: Throwable -> L50
    L18:
        if (r104 == null) goto L29;
        if (r100 == null) goto L27;
        WeakReference<Activity> r105 = activityHolder;     // Catch: Throwable -> L50
        if (r105 == null) goto L23;
        Activity r106 = r105.get();     // Catch: Throwable -> L50
    L25:
        if (ArraysKt.contains(r100, r106) != true) goto L27;
        boolean r107 = true;
    L28:
        if (r107 == false) goto L49;
    L23:
        r106 = null;
    L27:
        r107 = false;
    L29:
        WeakReference<Activity> r108 = activityHolder;     // Catch: Throwable -> L50
        if (r108 == null) goto L32;
        Activity r109 = r108.get();     // Catch: Throwable -> L50
    L33:
        if (r109 == null) goto L48;
        WeakReference<Activity> r110 = activityHolder;     // Catch: Throwable -> L50
        if (r110 == null) goto L37;
        Activity r111 = r110.get();     // Catch: Throwable -> L50
    L38:
        if (r100 == null) goto L40;
        Activity r112 = (Activity) ArraysKt.lastOrNull(r100);     // Catch: Throwable -> L50
    L42:
        if (Intrinsics.areEqual(r111, r112) == true) goto L49;
        if (r100 == null) goto L45;
        r103 = (Activity) ArraysKt.lastOrNull(r100);     // Catch: Throwable -> L50
    L45:
        if ((r103 instanceof CJPayFaceGuideActivity) == false) goto L48;
    L40:
        r112 = null;
        goto L42
    L37:
        r111 = null;
    L48:
        return false;
    L32:
        r109 = null;
        goto L33
    L17:
        r104 = null;
    L49:
        return true;
    L6:
        if (r100.length != 0) goto L8;
        boolean r113 = true;
    L10:
        if ((!r113) != true) goto L12;
        r101 = true;
        goto L13
    L8:
        r113 = false;
    L50:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("DyVerifyCenter#isDyAtHostStackTop", th);
        CJBasicCommonUtils.logCatch("CJCatch", "DyVerifyCenter#isDyAtHostStackTop", th);
        return true;
    }

    static {
        INSTANCE = new DyVerifyCenter();
        verifyId = "";
        verifyToken = new DyVerifyToken(null, null, null, null, 15, null);
        verifyList = new ArrayList();
        isVerifying = new AtomicBoolean(false);
    }

    public final boolean isTokenValid() {
        return verifyToken.isValid();
    }

    public final boolean needMask() {
        return verifyToken.product.needMask((String) CollectionsKt.firstOrNull(verifyList));
    }

    public final void release() {
        verifyToken = new DyVerifyToken(null, null, null, null, 15, null);
        callback = null;
        verifyList.clear();
        curVerifyProduct = "";
        setIsVerifying$default(this, false, null, 2, null);
        config = null;
        verifyId = "";
        setActivityHolder(null);
    }

    public final CustomizedConfig getConfig() {
        return config;
    }

    public final String getCurVerifyProduct() {
        return curVerifyProduct;
    }

    public final ICJPayDyVerifyService.IDyVerifyCallback getVerifyCallback() {
        return callback;
    }

    public final String getVerifyId() {
        return verifyId;
    }

    public final ArrayList<String> getVerifyList() {
        return verifyList;
    }

    public final DyVerifyToken getVerifyToken() {
        return verifyToken;
    }

    public final boolean getIsVerifying(String r100) {
        if (isVerifying.get() == true) goto L5;
        return false;
    L5:
        CJPayFaceVerifyConfig r101 = CJPaySettingsManager.getInstance().getCJPayFaceVerifyConfig();
        if (r101 != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == true) goto L32;
        if (isDyAtHostStackTop() == true) goto L32;
        String r103 = isVerifyingId;
        Boolean r104 = null;
        if (r103 == null) goto L17;
        Boolean r105 = Boolean.valueOf(!StringsKt.isBlank(r103));
    L18:
        if (r105 == null) goto L20;
        boolean r106 = r105.booleanValue();
    L21:
        if (r106 == false) goto L32;
        if (r100 == null) goto L24;
        r104 = Boolean.valueOf(!StringsKt.isBlank(r100));
    L24:
        if (r104 == null) goto L26;
        boolean r107 = r104.booleanValue();
    L27:
        if (r107 == false) goto L32;
        if (Intrinsics.areEqual(isVerifyingId, r100) == true) goto L32;
        return false;
    L26:
        r107 = false;
        goto L27
    L20:
        r106 = false;
        goto L21
    L17:
        r105 = null;
    L32:
        return isVerifying.get();
    L8:
        if (r101.cashier_multi_forbidden != true) goto L10;
        r102 = true;
        goto L11
    }

    public final boolean isTokenValid(String r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if ((!StringsKt.isBlank(r100)) == true) goto L7;
        r100 = null;
    L7:
        if (r100 != null) goto L9;
        return false;
    L9:
        return DyVerifyToken.Companion.getVerifyToken(r100).isValid();
    }

    public final void setActivityHolder(Activity r100) {
        if (r100 == null) goto L4;
        WeakReference<Activity> r101 = new WeakReference(r100);
    L5:
        activityHolder = r101;
        return;
    L4:
        r101 = null;
        goto L5
    }

    public final void setCurVerifyProduct(String r100) {
        curVerifyProduct = r100;
    }

    public final void setVerifyList(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        verifyList = r100;
    }

    public final void setIsVerifying(boolean r100, String r101) {
        isVerifying.set(r100);
        if (r100 == true) goto L6;
        r101 = null;
    L6:
        isVerifyingId = r101;
    }

    public final JSONObject createHostInfo(Context r100, String r101, String r102) {
        Map<String, String> r103 = CJPayBasicUtils.getBasicRiskInfo("");     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");     // Catch: Throwable -> L5
    L8:
        return CJPayHostInfo.Companion.toJson$default(CJPayHostInfo.Companion, buildHostInfo(r100, r103, r101, r102), null, 2, null);
    L5:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("DyVerifyCenter#createHostInfo", th);
        CJBasicCommonUtils.logCatch("CJCatch", "DyVerifyCenter#createHostInfo", th);
        r103 = null;
        goto L8
    }

    public final void notifyResult(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        ICJPayDyVerifyService.IDyVerifyCallback r103 = callback;
        if (r103 == null) goto L8;
        String r104 = curVerifyProduct;
        if (r104 != null) goto L7;
        r104 = "";
    L7:
        r103.onResult(r100, r101, r104, r102);
    L8:
        DyVerifyLog.INSTANCE.reportCallbackEvent(r100, r101, verifyToken.verify_flow, r102);
        release();
    }

    private final CJPayHostInfo buildHostInfo(Context r100, Map<String, String> r101, String r102, String r103) {
        CJPayHostInfo r104 = new CJPayHostInfo();
        r104.setContext(r100);
        if (r102 != null) goto L5;
    L10:
        if (r103 != null) goto L12;
    L17:
        HashMap r105 = new HashMap();
        if (r101 == null) goto L20;
        r105.putAll(r101);
    L20:
        r104.setRiskInfoParams(r105);
        return r104;
    L12:
        if ((!StringsKt.isBlank(r103)) == true) goto L15;
        r103 = null;
    L15:
        if (r103 == null) goto L17;
        r104.merchantId = r103;
        goto L17
    L5:
        if ((!StringsKt.isBlank(r102)) == true) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L10;
        r104.appId = r102;
        goto L10
    }

    public final void setVerifyInfo(String r100, String r101, ICJPayDyVerifyService.IDyVerifyCallback r102, CustomizedConfig r103) {
        Intrinsics.checkNotNullParameter(r100, "verifyId");
        Intrinsics.checkNotNullParameter(r101, "verifyToken");
        verifyId = r100;
        verifyToken = DyVerifyToken.Companion.getVerifyToken(r101);
        verifyList.clear();
        curVerifyProduct = "";
        verifyList.addAll(verifyToken.getVerifyList());
        callback = r102;
        config = r103;
    }

    public static /* synthetic */ void setIsVerifying$default(DyVerifyCenter r100, boolean r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.setIsVerifying(r101, r102);
    }

    public static /* synthetic */ void notifyResult$default(DyVerifyCenter r100, int r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = null;
    L5:
        r100.notifyResult(r101, r102, r103);
    }

    public static /* synthetic */ void setVerifyInfo$default(DyVerifyCenter r100, String r101, String r102, ICJPayDyVerifyService.IDyVerifyCallback r103, CustomizedConfig r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L5;
        r104 = null;
    L5:
        r100.setVerifyInfo(r101, r102, r103, r104);
    }
}
