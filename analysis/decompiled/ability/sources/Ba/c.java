package Ba;

import N9.j;
import android.content.Context;
import android.graphics.Point;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import j9.t;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.config.Action;
import stepai.aios.guiagent.config.GuiAgentConfigKt;
import stepai.aios.guiexecutor.api.AwakeAction;
import stepai.aios.guiexecutor.api.GestureType;
import stepai.aios.guiexecutor.api.GuiCommand;
import stepai.aios.guiexecutor.api.GuiCommandType;
import stepai.aios.guiexecutor.api.GuiOptions;
import stepai.aios.guiexecutor.api.GuiParameters;
import stepai.aios.guiexecutor.api.GuiTarget;
import stepai.aios.guiexecutor.api.InputMethod;
import stepai.aios.guiexecutor.api.SystemNavigationAction;
import stepai.aios.guiexecutor.api.TaskAction;
import stepai.aios.guiexecutor.api.TouchAction;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final C7.f f267a = kotlin.a.a(new a(this));

    public c(Context context) {
    }

    public static GuiCommand c(Action action) {
        Object obj = action.getParameters().get("message");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = action.getParameters().get("result");
        return new GuiCommand(B7.a.k("gui_", action.getId()), GuiCommandType.TASK_ABORT, GuiTarget.INSTANCE.screen(), new GuiParameters.TaskParams(TaskAction.ABORT, str, obj2 instanceof Map ? (Map) obj2 : null), GuiOptions.INSTANCE.m7369default(), null, action, 32, null);
    }

    public static GuiCommand d(Action action) {
        Object obj = action.getParameters().get(GuiAgentConfigKt.META_KEY_APP_NAME);
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            Object obj2 = action.getParameters().get("packageName");
            str = obj2 instanceof String ? (String) obj2 : null;
            if (str == null) {
                throw new IllegalArgumentException("Missing app name or packageName");
            }
        }
        Object obj3 = action.getParameters().get("launchType");
        Integer num = obj3 instanceof Integer ? (Integer) obj3 : null;
        return new GuiCommand(B7.a.k("gui_", action.getId()), GuiCommandType.AWAKE_APP, GuiTarget.INSTANCE.screen(), new GuiParameters.AwakeParams(AwakeAction.LAUNCH_APP, str, num != null ? num.intValue() : 0), GuiOptions.INSTANCE.m7369default(), null, action, 32, null);
    }

    public static GuiCommand f(Action action) {
        Object obj = action.getParameters().get("message");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = action.getParameters().get("result");
        return new GuiCommand(B7.a.k("gui_", action.getId()), GuiCommandType.TASK_COMPLETE, GuiTarget.INSTANCE.screen(), new GuiParameters.TaskParams(TaskAction.COMPLETE, str, obj2 instanceof Map ? (Map) obj2 : null), GuiOptions.INSTANCE.m7369default(), null, action, 32, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003f A[PHI: r3
      0x003f: PHI (r3v16 java.lang.Long) = (r3v5 java.lang.Long), (r3v11 java.lang.Long) binds: [B:17:0x003d, B:26:0x005e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static stepai.aios.guiexecutor.api.GuiCommand g(stepai.aios.guiagent.config.Action r16) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Ba.c.g(stepai.aios.guiagent.config.Action):stepai.aios.guiexecutor.api.GuiCommand");
    }

    public static GuiCommand j(Action action) {
        long jLongValue;
        Object obj = action.getParameters().get(TypedValues.TransitionType.S_DURATION);
        Long l = obj instanceof Long ? (Long) obj : null;
        if (l != null) {
            jLongValue = l.longValue();
        } else {
            Object obj2 = action.getParameters().get(TypedValues.TransitionType.S_DURATION);
            String str = obj2 instanceof String ? (String) obj2 : null;
            Long lG0 = str != null ? t.g0(str) : null;
            jLongValue = lG0 != null ? lG0.longValue() : 1000L;
        }
        return new GuiCommand(B7.a.k("gui_", action.getId()), GuiCommandType.WAIT, GuiTarget.INSTANCE.screen(), new GuiParameters.WaitParams(jLongValue, null, 2, null), GuiOptions.INSTANCE.m7369default(), null, action, 32, null);
    }

    public final Point a(int i, int i6, String str) {
        C7.f fVar = this.f267a;
        ((e) fVar.getF4884a()).getClass();
        if (i < 0 || i >= 1001 || i6 < 0 || i6 >= 1001) {
            StringBuilder sbT = androidx.appfunctions.metadata.a.t(i, "Invalid normalized coordinate for ", str, ": (", ", ");
            sbT.append(i6);
            sbT.append(")");
            String string = sbT.toString();
            j.G(string, "ActionToGuiCommandTranslator");
            throw new IllegalArgumentException(string);
        }
        e eVar = (e) fVar.getF4884a();
        eVar.getClass();
        Point point = null;
        if (i < 0 || i >= 1001 || i6 < 0 || i6 >= 1001) {
            j.J(androidx.compose.foundation.b.o(i, "Invalid normalized coordinate: (", i6, ", ", ")"), "DefaultCoordinateTransformer");
        } else {
            if (eVar.a() != null) {
                float f = 1000;
                int i10 = (int) ((i / f) * r3.x);
                int i11 = (int) ((i6 / f) * r3.y);
                StringBuilder sbS = androidx.appfunctions.metadata.a.s(i, "Transformed normalized (", i6, ", ", ") to pixel (");
                sbS.append(i10);
                sbS.append(", ");
                sbS.append(i11);
                sbS.append(")");
                j.F(sbS.toString(), "DefaultCoordinateTransformer");
                point = new Point(i10, i11);
            }
        }
        if (point == null) {
            StringBuilder sbT2 = androidx.appfunctions.metadata.a.t(i, "Failed to transform ", str, " coordinates (", ", ");
            sbT2.append(i6);
            sbT2.append(") to pixel coordinates");
            String string2 = sbT2.toString();
            j.G(string2, "ActionToGuiCommandTranslator");
            throw new IllegalArgumentException(string2);
        }
        e eVar2 = (e) fVar.getF4884a();
        int i12 = point.x;
        int i13 = point.y;
        Point pointA = eVar2.a();
        if (pointA != null && i12 >= 0 && i12 <= pointA.x && i13 >= 0 && i13 <= pointA.y) {
            return point;
        }
        int i14 = point.x;
        int i15 = point.y;
        StringBuilder sbT3 = androidx.appfunctions.metadata.a.t(i14, "Transformed pixel coordinate for ", str, " is out of screen bounds: (", ", ");
        sbT3.append(i15);
        sbT3.append(")");
        String string3 = sbT3.toString();
        j.G(string3, "ActionToGuiCommandTranslator");
        throw new IllegalArgumentException(string3);
    }

    public final GuiCommand b(Action action) {
        Action action2;
        Exception exc;
        k.f(action, "action");
        try {
        } catch (Exception e) {
            e = e;
            action2 = action;
        }
        try {
            try {
                switch (b.f266a[action.getType().ordinal()]) {
                    case 1:
                        return e(action);
                    case 2:
                        return i(action);
                    case 3:
                        return h(action);
                    case 4:
                        return j(action);
                    case 5:
                        return d(action);
                    case 6:
                        return g(action);
                    case 7:
                        return f(action);
                    case 8:
                        return c(action);
                    case 9:
                        return new GuiCommand(B7.a.k("gui_", action.getId()), GuiCommandType.SYSTEM_NAVIGATION, GuiTarget.INSTANCE.screen(), new GuiParameters.SystemNavigationParams(SystemNavigationAction.BACK), GuiOptions.INSTANCE.m7369default(), null, action, 32, null);
                    case 10:
                        return new GuiCommand(B7.a.k("gui_", action.getId()), GuiCommandType.SYSTEM_NAVIGATION, GuiTarget.INSTANCE.screen(), new GuiParameters.SystemNavigationParams(SystemNavigationAction.HOME), GuiOptions.INSTANCE.m7369default(), null, action, 32, null);
                    case 11:
                        try {
                            return new GuiCommand(B7.a.k("gui_", action.getId()), GuiCommandType.SYSTEM_NAVIGATION, GuiTarget.INSTANCE.screen(), new GuiParameters.SystemNavigationParams(SystemNavigationAction.ENTER), GuiOptions.INSTANCE.m7369default(), null, action, 32, null);
                        } catch (Exception e6) {
                            e = e6;
                            action2 = action;
                            exc = e;
                            j.J(androidx.appfunctions.metadata.a.m("Failed to translate action ", action2.getId(), ": ", exc.getMessage(), " ,execute wait"), "ActionToGuiCommandTranslator");
                            return j(action2);
                        }
                    case 12:
                        throw new IllegalStateException("TAKEOVER must be handled in pipeline before GUI translation");
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            } catch (Exception e9) {
                e = e9;
            }
        } catch (Exception e10) {
            exc = e10;
            action2 = action;
            j.J(androidx.appfunctions.metadata.a.m("Failed to translate action ", action2.getId(), ": ", exc.getMessage(), " ,execute wait"), "ActionToGuiCommandTranslator");
            return j(action2);
        }
    }

    public final GuiCommand e(Action action) {
        Object obj = action.getParameters().get("x");
        Integer numF0 = obj instanceof Integer ? (Integer) obj : null;
        if (numF0 == null) {
            Object obj2 = action.getParameters().get("x");
            String str = obj2 instanceof String ? (String) obj2 : null;
            numF0 = str != null ? t.f0(str) : null;
            if (numF0 == null) {
                throw new IllegalArgumentException("Missing x coordinate for CLICK action");
            }
        }
        int iIntValue = numF0.intValue();
        Object obj3 = action.getParameters().get("y");
        Integer numF02 = obj3 instanceof Integer ? (Integer) obj3 : null;
        if (numF02 == null) {
            Object obj4 = action.getParameters().get("y");
            String str2 = obj4 instanceof String ? (String) obj4 : null;
            numF02 = str2 != null ? t.f0(str2) : null;
            if (numF02 == null) {
                throw new IllegalArgumentException("Missing y coordinate for CLICK action");
            }
        }
        int iIntValue2 = numF02.intValue();
        Point pointA = a(iIntValue, iIntValue2, "CLICK");
        Object obj5 = action.getParameters().get(TypedValues.TransitionType.S_DURATION);
        Long lG0 = obj5 instanceof Long ? (Long) obj5 : null;
        if (lG0 == null) {
            Object obj6 = action.getParameters().get(TypedValues.TransitionType.S_DURATION);
            String str3 = obj6 instanceof String ? (String) obj6 : null;
            lG0 = str3 != null ? t.g0(str3) : null;
            if (lG0 == null) {
                Object obj7 = action.getParameters().get(TypedValues.TransitionType.S_DURATION);
                lG0 = (obj7 instanceof Integer ? (Integer) obj7 : null) != null ? Long.valueOf(r4.intValue()) : null;
            }
        }
        TouchAction touchAction = (lG0 == null || lG0.longValue() < 500) ? TouchAction.TAP : TouchAction.LONG_PRESS;
        int i = pointA.x;
        int i6 = pointA.y;
        StringBuilder sbS = androidx.appfunctions.metadata.a.s(iIntValue, "Transformed click coordinates: normalized(", iIntValue2, ", ", ") -> pixel(");
        androidx.constraintlayout.core.dsl.a.y(sbS, i, ", ", i6, "), touchAction=");
        sbS.append(touchAction);
        sbS.append(", duration=");
        sbS.append(lG0);
        j.I(sbS.toString(), "ActionToGuiCommandTranslator");
        return new GuiCommand(B7.a.k("gui_", action.getId()), GuiCommandType.CLICK, GuiTarget.INSTANCE.coordinate(pointA.x, pointA.y), new GuiParameters.TouchParams(touchAction, 0, 2, null), GuiOptions.INSTANCE.m7369default(), null, action, 32, null);
    }

    public final GuiCommand h(Action action) {
        long jLongValue;
        Object obj = action.getParameters().get("x");
        Integer numF0 = obj instanceof Integer ? (Integer) obj : null;
        if (numF0 == null) {
            Object obj2 = action.getParameters().get("x1");
            String str = obj2 instanceof String ? (String) obj2 : null;
            numF0 = str != null ? t.f0(str) : null;
            if (numF0 == null) {
                throw new IllegalArgumentException("Missing startX");
            }
        }
        int iIntValue = numF0.intValue();
        Object obj3 = action.getParameters().get("y");
        Integer numF02 = obj3 instanceof Integer ? (Integer) obj3 : null;
        if (numF02 == null) {
            Object obj4 = action.getParameters().get("y1");
            String str2 = obj4 instanceof String ? (String) obj4 : null;
            numF02 = str2 != null ? t.f0(str2) : null;
            if (numF02 == null) {
                throw new IllegalArgumentException("Missing startY");
            }
        }
        int iIntValue2 = numF02.intValue();
        Object obj5 = action.getParameters().get("endX");
        Integer numF03 = obj5 instanceof Integer ? (Integer) obj5 : null;
        if (numF03 == null) {
            Object obj6 = action.getParameters().get("x2");
            String str3 = obj6 instanceof String ? (String) obj6 : null;
            numF03 = str3 != null ? t.f0(str3) : null;
            if (numF03 == null) {
                throw new IllegalArgumentException("Missing endX");
            }
        }
        int iIntValue3 = numF03.intValue();
        Object obj7 = action.getParameters().get("endY");
        Integer numF04 = obj7 instanceof Integer ? (Integer) obj7 : null;
        if (numF04 == null) {
            Object obj8 = action.getParameters().get("y2");
            String str4 = obj8 instanceof String ? (String) obj8 : null;
            numF04 = str4 != null ? t.f0(str4) : null;
            if (numF04 == null) {
                throw new IllegalArgumentException("Missing endY");
            }
        }
        int iIntValue4 = numF04.intValue();
        Object obj9 = action.getParameters().get(TypedValues.TransitionType.S_DURATION);
        Long l = obj9 instanceof Long ? (Long) obj9 : null;
        if (l != null) {
            jLongValue = l.longValue();
        } else {
            Object obj10 = action.getParameters().get(TypedValues.TransitionType.S_DURATION);
            String str5 = obj10 instanceof String ? (String) obj10 : null;
            Long lG0 = str5 != null ? t.g0(str5) : null;
            jLongValue = lG0 != null ? lG0.longValue() : 300L;
        }
        long j5 = jLongValue;
        Point pointA = a(iIntValue, iIntValue2, "SWIPE_START");
        Point pointA2 = a(iIntValue3, iIntValue4, "SWIPE_END");
        int i = pointA.x;
        int i6 = pointA.y;
        int i10 = pointA2.x;
        int i11 = pointA2.y;
        StringBuilder sbS = androidx.appfunctions.metadata.a.s(iIntValue, "Transformed swipe coordinates: start normalized(", iIntValue2, ", ", ") -> pixel(");
        androidx.constraintlayout.core.dsl.a.y(sbS, i, ", ", i6, "), end normalized(");
        androidx.constraintlayout.core.dsl.a.y(sbS, iIntValue3, ", ", iIntValue4, ") -> pixel(");
        sbS.append(i10);
        sbS.append(", ");
        sbS.append(i11);
        sbS.append(")");
        j.J(sbS.toString(), "ActionToGuiCommandTranslator");
        return new GuiCommand(B7.a.k("gui_", action.getId()), GuiCommandType.SWIPE, GuiTarget.INSTANCE.coordinate(pointA.x, pointA.y), new GuiParameters.GestureParams(GestureType.SWIPE, pointA, pointA2, j5, 0, 0.0f, 48, null), GuiOptions.INSTANCE.m7369default(), null, action, 32, null);
    }

    public final GuiCommand i(Action action) {
        GuiTarget guiTargetScreen;
        Object obj = action.getParameters().get("text");
        Integer numF0 = null;
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            throw new IllegalArgumentException("Missing text");
        }
        Object obj2 = action.getParameters().get("x");
        Integer numF02 = obj2 instanceof Integer ? (Integer) obj2 : null;
        if (numF02 == null) {
            Object obj3 = action.getParameters().get("x");
            String str2 = obj3 instanceof String ? (String) obj3 : null;
            numF02 = str2 != null ? t.f0(str2) : null;
        }
        Object obj4 = action.getParameters().get("y");
        Integer num = obj4 instanceof Integer ? (Integer) obj4 : null;
        if (num == null) {
            Object obj5 = action.getParameters().get("y");
            String str3 = obj5 instanceof String ? (String) obj5 : null;
            if (str3 != null) {
                numF0 = t.f0(str3);
            }
        } else {
            numF0 = num;
        }
        if (numF02 == null || numF0 == null) {
            guiTargetScreen = GuiTarget.INSTANCE.screen();
        } else {
            try {
                Point pointA = a(numF02.intValue(), numF0.intValue(), "TYPE");
                j.J("Transformed type coordinates: normalized(" + numF02 + ", " + numF0 + ") -> pixel(" + pointA.x + ", " + pointA.y + ")", "ActionToGuiCommandTranslator");
                guiTargetScreen = GuiTarget.INSTANCE.coordinate(pointA.x, pointA.y);
            } catch (IllegalArgumentException e) {
                j.G("Failed to transform type coordinates (" + numF02 + ", " + numF0 + "), using screen target: " + e.getMessage(), "ActionToGuiCommandTranslator");
                guiTargetScreen = GuiTarget.INSTANCE.screen();
            }
        }
        return new GuiCommand(B7.a.k("gui_", action.getId()), GuiCommandType.INPUT, guiTargetScreen, new GuiParameters.InputParams(str, false, InputMethod.ACCESSIBILITY, false, 10, null), GuiOptions.INSTANCE.m7369default(), null, action, 32, null);
    }
}
