package com.bytedance.android.livehostapi.business.depend.gamecp;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.HashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H&J4\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u000bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001`\fH&JP\u0010\r\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\"\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u000bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001`\f2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0016\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0010H'J,\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006H&J \u0010\u0016\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012H&J\u001c\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00102\u0006\u0010\b\u001a\u00020\tH&Jt\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010!2:\u0010\"\u001a6\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00030#j\u0002`(H&J0\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u00122\b\b\u0002\u0010.\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u0012H'JL\u0010/\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u00010\u00012\u0006\u00101\u001a\u00020\t2 \u00102\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00100\u00102\u0006\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u0012H&J0\u00105\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u00106\u001a\u00020\u00062\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0010H&J&\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u00062\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0010H&JP\u00108\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00102\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00102\u0006\u0010'\u001a\u00020\u001dH&J$\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\t2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0010H&JP\u0010=\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u00182\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00102\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00102\u0006\u0010@\u001a\u00020\u0012H&J\u001a\u0010A\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u00010\u00012\u0006\u00101\u001a\u00020\tH&J2\u0010B\u001a\u00020\u00032\u0006\u00101\u001a\u00020\t2 \u00102\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00100\u0010H&J\u0010\u0010C\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\tH&¨\u0006DÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPTrackService;", "", "appendHijackInfo", "", "logMap", "", "", "filterRouterParams", "trackView", "Landroid/view/View;", "routeParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "filterViewParams", "viewParams", SlcElement.KEY_ATTR, "", "isResultEvent", "", "getGPCommonParams", "pageView", "uniqueKey", "getTrackEventName", "trackAction", "", "getViewTrackData", "monitorAppear", "targetView", "viewAppearRectLimit", "", "enableViewEffectiveDetachCheck", "needResetReport", "limitCheckArea", "Landroid/graphics/Rect;", "observer", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isAppear", "duration", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/OnAppearObserver;", "newGPViewAppearObserver", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGPViewAppearObserver;", "changeNotifyGapTimeMils", "", "needScrollMonitor", "appearRectLimit", "registerPageParamNode", "page", "pageRootView", "paramsMap", "doNotInheritPreNode", "autoRemove", "sendLog", "eventName", "extra", "sendViewTrackLog", "attrs", "tempAttrs", "setViewTrackAttrs", "view", "setViewTrackData", "dataType", "routeData", "needReportRouterAttr", "unRegisterPageParamNode", "updatePageParamNode", "viewIsWillDetached", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGameCPTrackService {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPTrackService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Map getGPCommonParams$default(IGameCPTrackService r100, View r101, String r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L7;
            r102 = null;
        L7:
            return r100.getGPCommonParams(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGPCommonParams");
        }

        public static /* synthetic */ IGPViewAppearObserver newGPViewAppearObserver$default(IGameCPTrackService r100, long r101, boolean r102, float r110, boolean r111, int r112, Object r113) {
            if (r113 != null) goto L21;
            if ((r112 & 1) == 0) goto L6;
            r101 = 200;
        L6:
            long r103 = r101;
            if ((r112 & 2) == 0) goto L9;
            boolean r104 = true;
        L11:
            if ((r112 & 4) == 0) goto L13;
            float r105 = 0.5f;
        L15:
            if ((r112 & 8) == 0) goto L17;
            boolean r106 = false;
        L19:
            return r100.newGPViewAppearObserver(r103, r104, r105, r106);
        L17:
            r106 = r111;
            goto L19
        L13:
            r105 = r110;
            goto L15
        L9:
            r104 = r102;
            goto L11
        L21:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: newGPViewAppearObserver");
        }

        public static /* synthetic */ void monitorAppear$default(IGameCPTrackService r100, View r101, float r102, boolean r110, boolean r111, Rect r112, Function2 r113, int r114, Object r115) {
            if (r115 != null) goto L18;
            if ((r114 & 2) == 0) goto L6;
            float r103 = 0.5f;
        L8:
            if ((r114 & 4) == 0) goto L10;
            boolean r104 = false;
        L12:
            if ((r114 & 8) == 0) goto L14;
            boolean r105 = false;
        L15:
            r100.monitorAppear(r101, r103, r104, r105, r112, r113);
            return;
        L14:
            r105 = r111;
            goto L15
        L10:
            r104 = r110;
            goto L12
        L6:
            r103 = r102;
            goto L8
        L18:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: monitorAppear");
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ Map getGPCommonParams$default(IGameCPTrackService r100, View r101, String r102, int r103, Object r104) {
            return CC.getGPCommonParams$default(r100, r101, r102, r103, r104);
        }

        public static /* synthetic */ IGPViewAppearObserver newGPViewAppearObserver$default(IGameCPTrackService r100, long r101, boolean r102, float r103, boolean r104, int r105, Object r106) {
            return CC.newGPViewAppearObserver$default(r100, r101, r102, r103, r104, r105, r106);
        }

        public static /* synthetic */ void monitorAppear$default(IGameCPTrackService r100, View r101, float r102, boolean r103, boolean r104, Rect r105, Function2 r106, int r107, Object r108) {
            CC.monitorAppear$default(r100, r101, r102, r103, r104, r105, r106, r107, r108);
        }
    }

    void appendHijackInfo(Map<String, String> r100);

    void filterRouterParams(View r100, HashMap<String, Object> r101);

    void filterViewParams(View r100, HashMap<String, Object> r101, Map<String, ? extends Object> r102, boolean r103);

    @Deprecated(message = "")
    Map<String, String> getGPCommonParams();

    Map<String, String> getGPCommonParams(View r100, String r101);

    String getTrackEventName(View r100, int r101, boolean r102);

    Map<String, Object> getViewTrackData(View r100);

    void monitorAppear(View r100, float r101, boolean r102, boolean r103, Rect r104, Function2<? super Boolean, ? super Float, Unit> r105);

    @Deprecated(message = "use monitorAppear代替")
    IGPViewAppearObserver newGPViewAppearObserver(long r100, boolean r101, float r102, boolean r103);

    void registerPageParamNode(Object r100, View r101, Map<String, ? extends Map<String, String>> r102, boolean r103, boolean r104);

    void sendLog(View r100, String r101, Map<String, String> r102);

    void sendLog(String r100, Map<String, String> r101);

    void sendViewTrackLog(View r100, int r101, boolean r102, Map<String, ? extends Object> r103, Map<String, ? extends Object> r104, float r105);

    void setViewTrackAttrs(View r100, Map<String, ? extends Object> r101);

    void setViewTrackData(View r100, String r101, int r102, Map<String, ? extends Object> r103, Map<String, ? extends Object> r104, boolean r105);

    void unRegisterPageParamNode(Object r100, View r101);

    void updatePageParamNode(View r100, Map<String, ? extends Map<String, String>> r101);

    boolean viewIsWillDetached(View r100);
}
