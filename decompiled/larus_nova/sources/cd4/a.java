package cd4;

import android.net.Uri;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public abstract class a implements ed4.i {
    public static final String CJPAY_ANNIE_LYNX_CARD_ERROR = "cjpay_annie_lynx_card_error";
    public static final String CJPAY_ANNIE_LYNX_CARD_LOAD_RESULT = "cjpay_annie_lynx_card_load_result";
    public static final C0434a Companion = null;
    private Uri uri;

    /* JADX INFO: renamed from: cd4.a$a, reason: collision with other inner class name */
    public static final class C0434a {
        public C0434a() {
        }
    }

    static {
        Companion = new C0434a();
    }

    public a() {
    }

    public abstract String getTAG();

    @Override // ed4.i
    public void onDataUpdated(ed4.g r100) {
        CJLogger.d(getTAG(), "onDataUpdated");
    }

    @Override // ed4.i
    public void onFirstScreen(ed4.g r100) {
        CJLogger.d(getTAG(), "onFirstScreen");
    }

    @Override // ed4.i
    public void onPageUpdate(ed4.g r100) {
        CJLogger.d(getTAG(), "onPageUpdate");
    }

    @Override // ed4.i
    public void onRuntimeReady(ed4.g r100) {
        CJLogger.d(getTAG(), "onRuntimeReady");
    }

    @Override // ed4.i
    public void onTimingSetup(Map<String, Object> r100) {
        CJLogger.d(getTAG(), "onRuntimeReady-timingInfo: " + r100);
    }

    @Override // ed4.i
    public String shouldRedirectImageUrl(String r100) {
        String r101 = getTAG();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        CJLogger.d(r101, "shouldRedirectImageUrl-".concat(r100));
        return null;
    }

    @Override // ed4.i
    public void onFirstLoadPerfReady(ed4.g r100, JSONObject r101) {
        CJLogger.d(getTAG(), "onFirstLoadPerfReady");
    }

    @Override // ed4.i
    public void onLoadFailed(ed4.g r100, ed4.e r101) {
        String r102 = getTAG();
        StringBuilder r103 = new StringBuilder("onLoadFailed: error_code: ");
        String r104 = null;
        if (r101 == null) goto L5;
        Integer r105 = r101.f472206a;
    L6:
        r103.append(r105);
        r103.append(" error_msg: ");
        if (r101 == null) goto L9;
        r104 = r101.f472207b;
    L9:
        r103.append(r104);
        CJLogger.b(r102, r103.toString());
        return;
    L5:
        r105 = null;
        goto L6
    }

    @Override // ed4.i
    public void onLoadStart(Uri r100, ed4.g r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        CJLogger.d(getTAG(), "onLoadStart-" + r100);
        this.uri = r100;
    }

    @Override // ed4.i
    public void onLoadUriSuccess(Uri r100, ed4.g r101) {
        CJLogger.d(getTAG(), "onLoadUriSuccess-" + r100);
        CJPayCallBackCenter r102 = CJPayCallBackCenter.getInstance();
        JSONObject r103 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r103, "tag", getTAG());
        KtSafeMethodExtensionKt.safePut(r103, "url", String.valueOf(r100));
        KtSafeMethodExtensionKt.safePut(r103, "success", 1);
        KtSafeMethodExtensionKt.safePut(r103, "error_msg", "success");
        Unit r104 = Unit.INSTANCE;
        r102.onMonitor(CJPAY_ANNIE_LYNX_CARD_LOAD_RESULT, r103);
    }

    @Override // ed4.i
    public void onPageStart(ed4.g r100, String r101) {
        String r102 = getTAG();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        CJLogger.d(r102, "onPageStart-".concat(r101));
    }

    @Override // ed4.i
    public void onReceivedError(ed4.g r100, ed4.e r101) {
        String r102 = getTAG();
        StringBuilder r103 = new StringBuilder("onReceivedError: is_fatal: ");
        Integer r104 = null;
        if (r101 == null) goto L5;
        Boolean r105 = Boolean.valueOf(r101.a());
    L6:
        r103.append(r105);
        r103.append(" error_code: ");
        if (r101 == null) goto L9;
        Integer r106 = r101.f472206a;
    L10:
        r103.append(r106);
        r103.append(" error_msg: ");
        if (r101 == null) goto L13;
        String r107 = r101.f472207b;
    L14:
        r103.append(r107);
        CJLogger.b(r102, r103.toString());
        CJPayCallBackCenter r108 = CJPayCallBackCenter.getInstance();
        JSONObject r109 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r109, "tag", getTAG());
        KtSafeMethodExtensionKt.safePut(r109, "url", String.valueOf(this.uri));
        if (r101 == null) goto L17;
        Integer r110 = r101.f472206a;
    L18:
        KtSafeMethodExtensionKt.safePut(r109, "error_code", r110);
        if (r101 == null) goto L21;
        String r111 = r101.f472207b;
    L22:
        KtSafeMethodExtensionKt.safePut(r109, "error_msg", r111);
        if (r101 == null) goto L25;
        r104 = (Integer) KtSafeMethodExtensionKt.tf(r101.a(), 1, 0);
    L25:
        KtSafeMethodExtensionKt.safePut(r109, "is_fatal", r104);
        Unit r112 = Unit.INSTANCE;
        r108.onMonitor(CJPAY_ANNIE_LYNX_CARD_ERROR, r109);
        return;
    L21:
        r111 = null;
        goto L22
    L17:
        r110 = null;
        goto L18
    L13:
        r107 = null;
        goto L14
    L9:
        r106 = null;
        goto L10
    L5:
        r105 = null;
        goto L6
    }

    @Override // ed4.i
    public void onUpdatePerfReady(ed4.g r100, JSONObject r101) {
        CJLogger.d(getTAG(), "onUpdatePerfReady");
    }

    @Override // ed4.i
    public void onLoadFail(Uri r100, Throwable r101, ed4.g r102) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "e");
        CJLogger.c(getTAG(), "onLoadFail-" + r100, r101);
        CJPayCallBackCenter r103 = CJPayCallBackCenter.getInstance();
        JSONObject r104 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r104, "tag", getTAG());
        KtSafeMethodExtensionKt.safePut(r104, "url", r100.toString());
        KtSafeMethodExtensionKt.safePut(r104, "success", 0);
        KtSafeMethodExtensionKt.safePut(r104, "error_msg", r101.getMessage());
        Unit r105 = Unit.INSTANCE;
        r103.onMonitor(CJPAY_ANNIE_LYNX_CARD_LOAD_RESULT, r104);
    }

    @Override // ed4.i
    public void onModuleMethodInvoked(String r100, String r101, int r102) {
        CJLogger.d(getTAG(), "shouldRedirectImageUrl-module: " + r100 + " ,method: " + r101 + " , error_code: " + r102);
    }

    @Override // ed4.i
    public void onTimingUpdate(Map<String, Object> r100, Map<String, Long> r101, String r102) {
        CJLogger.d(getTAG(), "onTimingUpdate-flag: " + r102 + ", timingInfo: " + r100 + ", updateTiming: " + r101);
    }
}
