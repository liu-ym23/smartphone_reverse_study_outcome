package com.bytedance.ai.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import rv3.b0;
import rv3.c0;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006H&JF\u0010\u0007\u001a\u00020\u00032<\u0010\b\u001a8\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00030\tH&J\b\u0010\u000f\u001a\u00020\u0003H&J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013H&J\u001a\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&J\u001e\u0010\u001b\u001a\u00020\u00112\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001dH&J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\u001fH&J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0015H\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0016\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u001dH&J@\u0010$\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00150\u001f2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00030'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\rH&J\u0012\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\f\u001a\u00020\u0001H&J\u0012\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u0015H&J\u0010\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0015H&Je\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00152\u0006\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u0002062\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0002\u0010>J4\u0010?\u001a\u0002022\u0006\u00103\u001a\u00020\u00152\n\b\u0002\u0010@\u001a\u0004\u0018\u0001062\n\b\u0002\u0010A\u001a\u0004\u0018\u0001062\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010C\u001a\u0002022\u0006\u00103\u001a\u00020\u00152\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010E\u001a\u00020\u0011H&¨\u0006F"}, d2 = {"Lcom/bytedance/ai/api/AppletExtService;", "", "processAISDKConfig", "", "config", "init", "Lcom/bytedance/ai/api/AppletAppConfig;", "injectWidgetMenuAction", "deleteAction", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "widgetContainer", "Lkotlin/Function0;", "callback", "notifyChatWillReady", "checkIsAppletAppActivity", "", "activity", "Landroid/app/Activity;", "getAppletAppId", "", "interceptNavigation", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "args", "Landroid/os/Bundle;", "openAppletApp", "params", "", "getAlarmListWithKeepStatus", "", "triggerCalendarSync", "userId", "processRequest", "getLastPageInfo", "showMapSelectDialog", "optionList", "selectedCallback", "Lkotlin/Function1;", "", "cancelCallback", "obtainWidgetLongClickListener", "Landroid/view/View$OnLongClickListener;", "createAppletAppFragment", "Landroidx/fragment/app/Fragment;", "appId", "updateAppList", IFlowAppIntentIDL.PARAM_APPLET_ID, "showLiveCardByKey", "Lcom/bytedance/ai/api/LiveCardClientResult;", "sessionKey", "collapseTemplateId", "collapseTemplateData", "Lorg/json/JSONObject;", "expandTemplateId", "expandTemplateData", "canFrontShow", "autoDismissDurationMs", "", "traceBiz", "traceId", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/ai/api/LiveCardClientResult;", "updateLiveCardByKey", "collapsePatch", "expandPatch", "mode", "destroyLiveCardByKey", "reason", "dismissMapSelectDialog", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AppletExtService {
    void b(String r100);

    List<String> d();

    void e();

    boolean f(Context r100, List r101, b0 r102, c0 r103);

    String g(Activity r100);

    boolean h(Map<String, ? extends Object> r100);

    boolean i(String r100);

    Map<String, String> j();

    void k(Function2<Object, ? super Function0<Unit>, Unit> r100);

    View.OnLongClickListener l(Object r100);

    Fragment m(String r100);

    boolean n();

    boolean o(Activity r100);

    boolean p(Context r100, Bundle r101);

    Bundle q(Bundle r100);

    void r(a r100);

    void s(Object r100);
}
