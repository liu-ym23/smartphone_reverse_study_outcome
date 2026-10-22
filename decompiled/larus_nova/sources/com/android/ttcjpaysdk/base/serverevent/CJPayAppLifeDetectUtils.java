package com.android.ttcjpaysdk.base.serverevent;

import android.content.Context;
import android.util.SparseArray;
import androidx.appcompat.app.AppCompatActivity;
import com.android.ttcjpaysdk.base.framework.manager.CJScreenshotRiskManager;
import com.bytedance.caijing.sdk.infra.base.api.msm.MSMService;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ve4.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/base/serverevent/CJPayAppLifeDetectUtils;", "", "()V", "TAG", "", "isRegister", "", "observerList", "Landroid/util/SparseArray;", "Lcom/android/ttcjpaysdk/base/serverevent/CJPayObservers;", "pageList", "Ljava/util/LinkedList;", "", "switchPage", "appBackgroundSwitch", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "riskDetectPage", "action", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayAppLifeDetectUtils {
    public static final CJPayAppLifeDetectUtils INSTANCE = null;
    private static final String TAG = "CJPayAppLifeDetectUtils";
    private static volatile boolean isRegister;
    private static final SparseArray<CJPayObservers> observerList = null;
    private static final LinkedList<Integer> pageList = null;
    private static int switchPage;

    private CJPayAppLifeDetectUtils() {
    }

    static {
        INSTANCE = new CJPayAppLifeDetectUtils();
        pageList = new LinkedList();
        observerList = new SparseArray();
        switchPage = -1;
    }

    public static final /* synthetic */ SparseArray access$getObserverList$p() {
        return observerList;
    }

    public static final /* synthetic */ LinkedList access$getPageList$p() {
        return pageList;
    }

    public static final /* synthetic */ int access$getSwitchPage$p() {
        return switchPage;
    }

    public static final /* synthetic */ void access$setSwitchPage$p(int r100) {
        switchPage = r100;
    }

    public final void appBackgroundSwitch(Context r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "action");
        if ((r100 instanceof AppCompatActivity) == false) goto L5;
        AppCompatActivity r103 = (AppCompatActivity) r100;
    L6:
        if (r103 != null) goto L9;
        return;
    L9:
        if (isRegister == true) goto L15;
        CJLogger.d(TAG, "register page: " + r101);
        a.f554342a.getClass();
        MSMService r104 = (MSMService) a.a(MSMService.class);
        if (r104 == null) goto L13;
        r104.registerScenePageNameCallback(1, new AnonymousClass1());
    L13:
        isRegister = true;
    L15:
        if (Intrinsics.areEqual(r102, Action.PUSH.getValue()) == false) goto L24;
        LinkedList<Integer> r105 = pageList;
        if (r105.contains(Integer.valueOf(r101)) == false) goto L23;
        r105.remove(Integer.valueOf(r101));
        r105.push(Integer.valueOf(r101));
        CJPayObservers r106 = observerList.get(r101);
        if (r106 == null) goto L30;
        CJScreenshotRiskManager r107 = r106.getScreenShot();
        if (r107 == null) goto L31;
        r107.startScreenShot(r103, r101);
        return;
    L31:
        return;
    L30:
        return;
    L23:
        CJPayLifecycleObserver r108 = new CJPayLifecycleObserver(r101, CJPayAppLifeDetectUtils$appBackgroundSwitch$switchObserver$1.INSTANCE);
        r108.start(r103);
        CJScreenshotRiskManager r109 = new CJScreenshotRiskManager();
        r109.startScreenShot(r103, r101);
        r105.push(Integer.valueOf(r101));
        observerList.put(r101, new CJPayObservers(r108, r109));
        return;
    L24:
        CJPayObservers r110 = observerList.get(r101);
        if (r110 == null) goto L34;
        CJScreenshotRiskManager r111 = r110.getScreenShot();
        if (r111 == null) goto L35;
        r111.stopScreenShot();
        return;
    L35:
        return;
    L34:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
