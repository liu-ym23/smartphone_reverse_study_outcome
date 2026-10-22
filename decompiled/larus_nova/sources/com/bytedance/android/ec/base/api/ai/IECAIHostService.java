package com.bytedance.android.ec.base.api.ai;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.base.api.ECApiServices;
import com.bytedance.android.ec.base.api.ai.framework.component.BackComponent;
import com.bytedance.android.ec.base.api.ai.framework.component.CapsuleComponent;
import com.bytedance.android.ec.base.api.ai.framework.model.PanelItem;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\t\bg\u0018\u0000 42\u00020\u0001:\u00015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH&J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H&J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H&J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0016H&J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010 \u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016J\b\u0010#\u001a\u00020\u0004H\u0016J\u0012\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010%\u001a\u00020$H\u0016J\u0012\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010%\u001a\u00020$H\u0016J<\u0010/\u001a\u00020\r2\u0006\u0010%\u001a\u00020$2\u0006\u0010*\u001a\u00020\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u00182\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010-H&J\u0010\u00100\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u0002H&J&\u00103\u001a\u00020\r2\u0006\u00101\u001a\u00020\u00022\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010-H&¨\u00066"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/IECAIHostService;", "", "", "pageName", "", "isChatComponentEnabled", "isAIInputDelayAttachEnabled", "Lcom/bytedance/android/ec/base/api/ai/AIChatComponentParam;", "param", "Lcom/bytedance/android/ec/base/api/ai/AIChatComponentHandle;", "createChatComponent", "Lcom/bytedance/android/ec/base/api/ai/AISnapshotRequest;", "request", "", "capture", "Landroid/view/View;", "view", "excluded", "setExcludedFromCapture", "snapshotId", "messageId", "associateSnapshot", "Lcom/bytedance/android/ec/base/api/ai/AIStateLogRequest;", "reportLog", "", "", "getHostActivityStyleRes", "Landroid/app/Activity;", "activity", "applyHostStyle", "Lcom/bytedance/android/ec/base/api/ai/MiniAppConfig;", "getMiniAppConfig", "isInApplet", "isInAppletAnim", "isLandingPage", "isGoToLandingPage", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/android/ec/base/api/ai/framework/component/BackComponent;", "createBackComponent", "Lcom/bytedance/android/ec/base/api/ai/framework/component/CapsuleComponent;", "createCapsuleComponent", "scene", "Lcom/bytedance/android/ec/base/api/ai/framework/model/PanelItem;", "items", "", "extra", "showAppletPanel", "closeApplet", "name", "params", "sendAppletLog", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public interface IECAIHostService {
    public static final a Companion = null;

    /* JADX INFO: renamed from: com.bytedance.android.ec.base.api.ai.IECAIHostService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            a r100 = IECAIHostService.Companion;
        }

        @JvmStatic
        public static IECAIHostService get() {
            IECAIHostService.Companion.getClass();
            return a.a();
        }

        @JvmStatic
        public static void register(Application r100, IECAIHostService r101) {
            IECAIHostService.Companion.getClass();
            a.b(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AtomicBoolean f42794a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f42795b = null;

        public a() {
        }

        static {
            f42795b = new a();
            f42794a = new AtomicBoolean(false);
        }

        @JvmStatic
        public static IECAIHostService a() {
            return (IECAIHostService) ECApiServices.getServiceOrDefault(IECAIHostService.class, DefaultECAIHostService.INSTANCE);
        }

        @JvmStatic
        public static void b(Application r100, IECAIHostService r101) {
            Intrinsics.checkNotNullParameter(r100, "application");
            Intrinsics.checkNotNullParameter(r101, "impl");
            ECApiServices.registerService(IECAIHostService.class, r101);
            if (f42794a.compareAndSet(false, true) == false) goto L6;
            r100.registerActivityLifecycleCallbacks(xe.a.f563311b);
            return;
        }
    }

    public static final class b {
        public static void a(IECAIHostService r100, Activity r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "activity");
            Intrinsics.checkNotNullParameter(r102, "pageName");
            if (r100.isChatComponentEnabled(r102) == false) goto L8;
            Iterator<T> r103 = r100.getHostActivityStyleRes().iterator();
        L6:
            if (r103.hasNext() == false) goto L10;
            int r104 = ((Number) r103.next()).intValue();
            r101.getTheme().applyStyle(r104, true);
            goto L6
        L10:
            return;
        }
    }

    static {
        Companion = a.f42795b;
    }

    void applyHostStyle(Activity r100, String r101);

    void associateSnapshot(String r100, String r101);

    void capture(AISnapshotRequest r100);

    void closeApplet(String r100);

    BackComponent createBackComponent(Context r100);

    CapsuleComponent createCapsuleComponent(Context r100);

    AIChatComponentHandle createChatComponent(AIChatComponentParam r100);

    List<Integer> getHostActivityStyleRes();

    MiniAppConfig getMiniAppConfig();

    boolean isAIInputDelayAttachEnabled(String r100);

    boolean isChatComponentEnabled(String r100);

    boolean isGoToLandingPage();

    boolean isInApplet();

    boolean isInAppletAnim();

    boolean isLandingPage();

    void reportLog(AIStateLogRequest r100);

    void sendAppletLog(String r100, Map<String, String> r101);

    void setExcludedFromCapture(View r100, boolean r101);

    void showAppletPanel(Context r100, String r101, List<PanelItem> r102, Map<String, ? extends Object> r103);
}
