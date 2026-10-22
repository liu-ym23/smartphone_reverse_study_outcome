package com.stepos.taskrobot.llmapi.stepfun.speculation;

import D7.q;
import H4.o;
import androidx.compose.foundation.b;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.RequestInfo;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.taskrobot.llmapi.stepfun.Actions;
import com.stepos.taskrobot.taskmanager.experiencelib.model.Step2RetrieveRequest;
import g1.AbstractC1451a;
import j9.m;
import j9.s;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.a;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001:\u000201B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rJ2\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rJ:\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rJ,\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001a2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0007JL\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00152\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010$2\u0006\u0010%\u001a\u00020\u00152\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010$2\b\b\u0002\u0010'\u001a\u00020 J4\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001a2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010$2\b\b\u0002\u0010*\u001a\u00020\u0015J.\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001a2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001a2\u0006\u0010\f\u001a\u00020\rJ0\u0010-\u001a\u00020 2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001a2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082T¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/speculation/ActionNormalizer;", "", AppAgent.CONSTRUCT, "()V", "NORMALIZED_COORD_MAX", "", "forClick", "Lcom/stepos/taskrobot/llmapi/stepfun/speculation/ActionNormalizer$NormalizedAction;", "x", "y", RequestInfo.FUNCTION_LONG_CLICK, "", "screenSize", "Lcom/stepos/taskrobot/llmapi/stepfun/speculation/ActionNormalizer$ScreenSize;", "forSwipe", "startX", "startY", "endX", "endY", "fromRecordedAction", "actionType", "", "point", "", "value", "normalizePoint", "Lkotlin/Pair;", "toRetrieveRequest", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveRequest;", "task", "normalizedAction", "DEFAULT_DISTANCE_THRESHOLD", "", "matchAction", "queryAction", "queryParams", "", "candidateAction", "candidateParams", "distanceThreshold", "parsePointFromParams", "params", "key", "toAbsolutePoint", "relativePoint", "pointDistance", "a", "b", "NormalizedAction", "ScreenSize", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ActionNormalizer {
    private static final double DEFAULT_DISTANCE_THRESHOLD = 50.0d;
    public static final ActionNormalizer INSTANCE = new ActionNormalizer();
    private static final int NORMALIZED_COORD_MAX = 1000;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/speculation/ActionNormalizer$NormalizedAction;", "", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "", "params", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/util/Map;)V", "getAction", "()Ljava/lang/String;", "getParams", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NormalizedAction {
        private final String action;
        private final Map<String, Object> params;

        public NormalizedAction(String action, Map<String, ? extends Object> params) {
            k.f(action, "action");
            k.f(params, "params");
            this.action = action;
            this.params = params;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ NormalizedAction copy$default(NormalizedAction normalizedAction, String str, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = normalizedAction.action;
            }
            if ((i & 2) != 0) {
                map = normalizedAction.params;
            }
            return normalizedAction.copy(str, map);
        }

        /* renamed from: component1, reason: from getter */
        public final String getAction() {
            return this.action;
        }

        public final Map<String, Object> component2() {
            return this.params;
        }

        public final NormalizedAction copy(String action, Map<String, ? extends Object> params) {
            k.f(action, "action");
            k.f(params, "params");
            return new NormalizedAction(action, params);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NormalizedAction)) {
                return false;
            }
            NormalizedAction normalizedAction = (NormalizedAction) other;
            return k.b(this.action, normalizedAction.action) && k.b(this.params, normalizedAction.params);
        }

        public final String getAction() {
            return this.action;
        }

        public final Map<String, Object> getParams() {
            return this.params;
        }

        public int hashCode() {
            return this.params.hashCode() + (this.action.hashCode() * 31);
        }

        public String toString() {
            return "NormalizedAction(action=" + this.action + ", params=" + this.params + ")";
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/speculation/ActionNormalizer$ScreenSize;", "", "width", "", "height", AppAgent.CONSTRUCT, "(II)V", "getWidth", "()I", "getHeight", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ScreenSize {
        private final int height;
        private final int width;

        public ScreenSize(int i, int i6) {
            this.width = i;
            this.height = i6;
        }

        public static /* synthetic */ ScreenSize copy$default(ScreenSize screenSize, int i, int i6, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                i = screenSize.width;
            }
            if ((i10 & 2) != 0) {
                i6 = screenSize.height;
            }
            return screenSize.copy(i, i6);
        }

        /* renamed from: component1, reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        /* renamed from: component2, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        public final ScreenSize copy(int width, int height) {
            return new ScreenSize(width, height);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScreenSize)) {
                return false;
            }
            ScreenSize screenSize = (ScreenSize) other;
            return this.width == screenSize.width && this.height == screenSize.height;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getWidth() {
            return this.width;
        }

        public int hashCode() {
            return Integer.hashCode(this.height) + (Integer.hashCode(this.width) * 31);
        }

        public String toString() {
            return b.o(this.width, "ScreenSize(width=", this.height, ", height=", ")");
        }
    }

    private ActionNormalizer() {
    }

    public static /* synthetic */ NormalizedAction forClick$default(ActionNormalizer actionNormalizer, int i, int i6, boolean z10, ScreenSize screenSize, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            screenSize = null;
        }
        return actionNormalizer.forClick(i, i6, z10, screenSize);
    }

    public static /* synthetic */ NormalizedAction forSwipe$default(ActionNormalizer actionNormalizer, int i, int i6, int i10, int i11, ScreenSize screenSize, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            screenSize = null;
        }
        return actionNormalizer.forSwipe(i, i6, i10, i11, screenSize);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NormalizedAction fromRecordedAction$default(ActionNormalizer actionNormalizer, String str, List list, String str2, ScreenSize screenSize, int i, Object obj) {
        if ((i & 2) != 0) {
            list = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            screenSize = null;
        }
        return actionNormalizer.fromRecordedAction(str, list, str2, screenSize);
    }

    public static /* synthetic */ boolean matchAction$default(ActionNormalizer actionNormalizer, String str, Map map, String str2, Map map2, double d, int i, Object obj) {
        if ((i & 16) != 0) {
            d = 50.0d;
        }
        return actionNormalizer.matchAction(str, map, str2, map2, d);
    }

    public static /* synthetic */ Pair parsePointFromParams$default(ActionNormalizer actionNormalizer, Map map, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "point";
        }
        return actionNormalizer.parsePointFromParams(map, str);
    }

    private final double pointDistance(Pair<Integer, Integer> a3, Pair<Integer, Integer> b) {
        double dIntValue = ((Number) a3.f4886a).intValue() - ((Number) b.f4886a).intValue();
        double dIntValue2 = ((Number) a3.b).intValue() - ((Number) b.b).intValue();
        return Math.sqrt((dIntValue2 * dIntValue2) + (dIntValue * dIntValue));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final NormalizedAction forClick(int x10, int y, boolean longClick, ScreenSize screenSize) {
        Pair<Integer, Integer> pairNormalizePoint = normalizePoint(x10, y, screenSize);
        return new NormalizedAction(longClick ? "LONGPRESS" : "CLICK", a.Q(new Pair("point", o.N(pairNormalizePoint.f4886a, pairNormalizePoint.b))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final NormalizedAction forSwipe(int startX, int startY, int endX, int endY, ScreenSize screenSize) {
        Pair<Integer, Integer> pairNormalizePoint = normalizePoint(startX, startY, screenSize);
        Pair<Integer, Integer> pairNormalizePoint2 = normalizePoint(endX, endY, screenSize);
        return new NormalizedAction("SLIDE", a.R(new Pair("point1", o.N(pairNormalizePoint.f4886a, pairNormalizePoint.b)), new Pair("point2", o.N(pairNormalizePoint2.f4886a, pairNormalizePoint2.b))));
    }

    public final NormalizedAction fromRecordedAction(String actionType, List<Integer> point, String value, ScreenSize screenSize) {
        k.f(actionType, "actionType");
        Actions actions = Actions.INSTANCE;
        if (actionType.equals(actions.getCLICK_ACTION())) {
            if (point != null) {
                if (point.size() < 2) {
                    point = null;
                }
                if (point != null) {
                    return INSTANCE.forClick(point.get(0).intValue(), point.get(1).intValue(), false, screenSize);
                }
            }
            return null;
        }
        if (actionType.equals(actions.getSWIPE())) {
            if (point != null) {
                if (point.size() < 4) {
                    point = null;
                }
                if (point != null) {
                    return INSTANCE.forSwipe(point.get(0).intValue(), point.get(1).intValue(), point.get(2).intValue(), point.get(3).intValue(), screenSize);
                }
            }
            return null;
        }
        if (actionType.equals(actions.getINPUT_ACTION())) {
            if (value == null) {
                value = "";
            }
            return new NormalizedAction("TYPE", B7.a.x("value", value));
        }
        if (actionType.equals(actions.getPRESS_BACK_ACTION())) {
            return new NormalizedAction("BACK", a.M());
        }
        if (actionType.equals(actions.getPRESS_HOME_ACTION())) {
            return new NormalizedAction("HOME", a.M());
        }
        if (actionType.equals(actions.getPRESS_ENTER_ACTION())) {
            return new NormalizedAction("ENTER", a.M());
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final boolean matchAction(String queryAction, Map<String, ? extends Object> queryParams, String candidateAction, Map<String, ? extends Object> candidateParams, double distanceThreshold) {
        Pair<Integer, Integer> pointFromParams;
        Pair<Integer, Integer> pointFromParams2;
        Pair<Integer, Integer> pointFromParams$default;
        k.f(queryAction, "queryAction");
        k.f(queryParams, "queryParams");
        k.f(candidateAction, "candidateAction");
        k.f(candidateParams, "candidateParams");
        Locale locale = Locale.ROOT;
        String upperCase = queryAction.toUpperCase(locale);
        k.e(upperCase, "toUpperCase(...)");
        String upperCase2 = candidateAction.toUpperCase(locale);
        k.e(upperCase2, "toUpperCase(...)");
        Set setK0 = q.K0(new String[]{"CLICK", "LONGPRESS"});
        if (setK0.contains(upperCase) && setK0.contains(upperCase2)) {
            Pair<Integer, Integer> pointFromParams$default2 = parsePointFromParams$default(this, queryParams, null, 2, null);
            if (pointFromParams$default2 != null && (pointFromParams$default = parsePointFromParams$default(this, candidateParams, null, 2, null)) != null && pointDistance(pointFromParams$default2, pointFromParams$default) < distanceThreshold) {
                return true;
            }
        } else {
            Set setK02 = q.K0(new String[]{"TYPE", "INPUT"});
            if (!setK02.contains(upperCase) || !setK02.contains(upperCase2)) {
                if (upperCase.equals(upperCase2)) {
                    switch (upperCase.hashCode()) {
                        case 2030823:
                            if (upperCase.equals("BACK")) {
                                return true;
                            }
                            break;
                        case 2223327:
                            if (upperCase.equals("HOME")) {
                                return true;
                            }
                            break;
                        case 66129592:
                            if (upperCase.equals("ENTER")) {
                                return true;
                            }
                            break;
                        case 78988689:
                            if (upperCase.equals("SLIDE") && (pointFromParams = parsePointFromParams(queryParams, "point1")) != null && (pointFromParams2 = parsePointFromParams(candidateParams, "point1")) != null && pointDistance(pointFromParams, pointFromParams2) < distanceThreshold) {
                                return true;
                            }
                            break;
                        case 835540813:
                            if (upperCase.equals("RECENTAPPS")) {
                                return true;
                            }
                            break;
                    }
                }
            } else {
                Object obj = queryParams.get("value");
                String str = obj instanceof String ? (String) obj : null;
                if (str == null) {
                    str = "";
                }
                Object obj2 = candidateParams.get("value");
                String str2 = obj2 instanceof String ? (String) obj2 : null;
                String str3 = str2 != null ? str2 : "";
                if (str.length() != 0 && str3.length() != 0 && (m.h0(str, str3, false) || m.h0(str3, str, false))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final Pair<Integer, Integer> normalizePoint(int x10, int y, ScreenSize screenSize) {
        if (screenSize == null || screenSize.getWidth() <= 0 || screenSize.getHeight() <= 0) {
            return new Pair<>(Integer.valueOf(x10), Integer.valueOf(y));
        }
        double d = 1000;
        return new Pair<>(Integer.valueOf(AbstractC1451a.u(U7.a.T((x10 * d) / screenSize.getWidth()), 0, 1000)), Integer.valueOf(AbstractC1451a.u(U7.a.T((y * d) / screenSize.getHeight()), 0, 1000)));
    }

    public final Pair<Integer, Integer> parsePointFromParams(Map<String, ? extends Object> params, String key) {
        k.f(params, "params");
        k.f(key, "key");
        Object obj = params.get(key);
        if (obj == null || !(obj instanceof List)) {
            return null;
        }
        List list = (List) obj;
        if (list.size() < 2) {
            return null;
        }
        Double dU = s.U(String.valueOf(list.get(0)));
        Integer numValueOf = dU != null ? Integer.valueOf((int) dU.doubleValue()) : null;
        Double dU2 = s.U(String.valueOf(list.get(1)));
        Integer numValueOf2 = dU2 != null ? Integer.valueOf((int) dU2.doubleValue()) : null;
        if (numValueOf == null || numValueOf2 == null) {
            return null;
        }
        return new Pair<>(numValueOf, numValueOf2);
    }

    public final Pair<Integer, Integer> toAbsolutePoint(Pair<Integer, Integer> relativePoint, ScreenSize screenSize) {
        k.f(relativePoint, "relativePoint");
        k.f(screenSize, "screenSize");
        long j5 = 1000;
        return new Pair<>(Integer.valueOf((int) ((((Number) relativePoint.f4886a).intValue() * screenSize.getWidth()) / j5)), Integer.valueOf((int) ((((Number) relativePoint.b).intValue() * screenSize.getHeight()) / j5)));
    }

    public final Step2RetrieveRequest toRetrieveRequest(String task, NormalizedAction normalizedAction) {
        k.f(task, "task");
        k.f(normalizedAction, "normalizedAction");
        return new Step2RetrieveRequest(task, normalizedAction.getAction(), normalizedAction.getParams());
    }
}
