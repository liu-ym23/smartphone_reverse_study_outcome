package com.mdisdk.action;

import D7.q;
import android.content.Intent;
import androidx.exifinterface.media.ExifInterface;
import com.mdisdk.capability.model.IntentEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a \u00101\u001a\u0004\u0018\u0001H2\"\u0006\b\u0000\u00102\u0018\u0001*\u0006\u0012\u0002\b\u00030\u0002H\u0086\b¢\u0006\u0002\u00103\"\u001b\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u001b\u0010\t\u001a\u0004\u0018\u00010\n*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\"\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u001a*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u001e*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \"\u001b\u0010!\u001a\u0004\u0018\u00010\"*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b#\u0010$\"\u001b\u0010%\u001a\u0004\u0018\u00010&*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b'\u0010(\"\u001b\u0010)\u001a\u0004\u0018\u00010**\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b+\u0010,\"\u001b\u0010-\u001a\u0004\u0018\u00010.*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00064"}, d2 = {"openAppArgs", "Lcom/mdisdk/action/OpenAppArgs;", "Lcom/mdisdk/action/ActionResult;", "getOpenAppArgs", "(Lcom/mdisdk/action/ActionResult;)Lcom/mdisdk/action/OpenAppArgs;", "waitArgs", "Lcom/mdisdk/action/WaitArgs;", "getWaitArgs", "(Lcom/mdisdk/action/ActionResult;)Lcom/mdisdk/action/WaitArgs;", "clickArgs", "Lcom/mdisdk/action/ClickArgs;", "getClickArgs", "(Lcom/mdisdk/action/ActionResult;)Lcom/mdisdk/action/ClickArgs;", "longClickArgs", "Lcom/mdisdk/action/LongClickArgs;", "getLongClickArgs", "(Lcom/mdisdk/action/ActionResult;)Lcom/mdisdk/action/LongClickArgs;", "scaleArgs", "Lcom/mdisdk/action/ScaleArgs;", "getScaleArgs", "(Lcom/mdisdk/action/ActionResult;)Lcom/mdisdk/action/ScaleArgs;", "setTextArgs", "Lcom/mdisdk/action/SetTextArgs;", "getSetTextArgs", "(Lcom/mdisdk/action/ActionResult;)Lcom/mdisdk/action/SetTextArgs;", "keyEventArgs", "Lcom/mdisdk/action/KeyEventArgs;", "getKeyEventArgs", "(Lcom/mdisdk/action/ActionResult;)Lcom/mdisdk/action/KeyEventArgs;", "captureArgs", "Lcom/mdisdk/action/CaptureArgs;", "getCaptureArgs", "(Lcom/mdisdk/action/ActionResult;)Lcom/mdisdk/action/CaptureArgs;", "uiSnapshotArgs", "Lcom/mdisdk/action/UiSnapshotArgs;", "getUiSnapshotArgs", "(Lcom/mdisdk/action/ActionResult;)Lcom/mdisdk/action/UiSnapshotArgs;", "swipeArgs", "Lcom/mdisdk/action/SwipeArgs;", "getSwipeArgs", "(Lcom/mdisdk/action/ActionResult;)Lcom/mdisdk/action/SwipeArgs;", "flingArgs", "Lcom/mdisdk/action/FlingArgs;", "getFlingArgs", "(Lcom/mdisdk/action/ActionResult;)Lcom/mdisdk/action/FlingArgs;", "moveAppArgs", "Lcom/mdisdk/action/MoveAppArgs;", "getMoveAppArgs", "(Lcom/mdisdk/action/ActionResult;)Lcom/mdisdk/action/MoveAppArgs;", "typedArgs", ExifInterface.GPS_DIRECTION_TRUE, "(Lcom/mdisdk/action/ActionResult;)Ljava/lang/Object;", "mdisdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TypedActionArgsKt {
    public static final CaptureArgs getCaptureArgs(ActionResult<?> actionResult) {
        k.f(actionResult, "<this>");
        Object[] args = actionResult.getArgs();
        if (args == null) {
            return null;
        }
        Object objS0 = q.s0(0, args);
        Integer num = objS0 instanceof Integer ? (Integer) objS0 : null;
        Object objS02 = q.s0(1, args);
        return new CaptureArgs(num, objS02 instanceof String ? (String) objS02 : null);
    }

    public static final ClickArgs getClickArgs(ActionResult<?> actionResult) {
        k.f(actionResult, "<this>");
        Object[] args = actionResult.getArgs();
        if (args == null) {
            return null;
        }
        Object obj = args[0];
        k.d(obj, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) obj).intValue();
        Object obj2 = args[1];
        k.d(obj2, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue2 = ((Integer) obj2).intValue();
        Object obj3 = args[2];
        k.d(obj3, "null cannot be cast to non-null type kotlin.Long");
        long jLongValue = ((Long) obj3).longValue();
        Object objS0 = q.s0(3, args);
        Integer num = objS0 instanceof Integer ? (Integer) objS0 : null;
        Object objS02 = q.s0(4, args);
        String str = objS02 instanceof String ? (String) objS02 : null;
        Object objS03 = q.s0(5, args);
        return new ClickArgs(iIntValue, iIntValue2, jLongValue, num, str, objS03 instanceof String ? (String) objS03 : null);
    }

    public static final FlingArgs getFlingArgs(ActionResult<?> actionResult) {
        k.f(actionResult, "<this>");
        Object[] args = actionResult.getArgs();
        if (args == null) {
            return null;
        }
        Object obj = args[0];
        k.d(obj, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) obj).floatValue();
        Object obj2 = args[1];
        k.d(obj2, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue2 = ((Float) obj2).floatValue();
        Object obj3 = args[2];
        k.d(obj3, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue3 = ((Float) obj3).floatValue();
        Object obj4 = args[3];
        k.d(obj4, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue4 = ((Float) obj4).floatValue();
        Object obj5 = args[4];
        k.d(obj5, "null cannot be cast to non-null type kotlin.Long");
        long jLongValue = ((Long) obj5).longValue();
        Object objS0 = q.s0(5, args);
        return new FlingArgs(fFloatValue, fFloatValue2, fFloatValue3, fFloatValue4, jLongValue, objS0 instanceof Integer ? (Integer) objS0 : null);
    }

    public static final KeyEventArgs getKeyEventArgs(ActionResult<?> actionResult) {
        k.f(actionResult, "<this>");
        Object[] args = actionResult.getArgs();
        if (args == null) {
            return null;
        }
        Object obj = args[0];
        k.d(obj, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) obj).intValue();
        Object objS0 = q.s0(1, args);
        return new KeyEventArgs(iIntValue, objS0 instanceof Integer ? (Integer) objS0 : null);
    }

    public static final LongClickArgs getLongClickArgs(ActionResult<?> actionResult) {
        k.f(actionResult, "<this>");
        Object[] args = actionResult.getArgs();
        if (args == null) {
            return null;
        }
        Object obj = args[0];
        k.d(obj, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) obj).intValue();
        Object obj2 = args[1];
        k.d(obj2, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue2 = ((Integer) obj2).intValue();
        Object obj3 = args[2];
        k.d(obj3, "null cannot be cast to non-null type kotlin.Long");
        long jLongValue = ((Long) obj3).longValue();
        Object objS0 = q.s0(3, args);
        Integer num = objS0 instanceof Integer ? (Integer) objS0 : null;
        Object objS02 = q.s0(4, args);
        String str = objS02 instanceof String ? (String) objS02 : null;
        Object objS03 = q.s0(5, args);
        return new LongClickArgs(iIntValue, iIntValue2, jLongValue, num, str, objS03 instanceof String ? (String) objS03 : null);
    }

    public static final MoveAppArgs getMoveAppArgs(ActionResult<?> actionResult) {
        k.f(actionResult, "<this>");
        Object[] args = actionResult.getArgs();
        if (args == null) {
            return null;
        }
        Object obj = args[0];
        k.d(obj, "null cannot be cast to non-null type kotlin.String");
        String str = (String) obj;
        Object obj2 = args[1];
        k.d(obj2, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) obj2).intValue();
        Object objS0 = q.s0(2, args);
        Boolean bool = objS0 instanceof Boolean ? (Boolean) objS0 : null;
        Object objS02 = q.s0(3, args);
        return new MoveAppArgs(str, iIntValue, bool, objS02 instanceof Integer ? (Integer) objS02 : null);
    }

    public static final OpenAppArgs getOpenAppArgs(ActionResult<?> actionResult) {
        k.f(actionResult, "<this>");
        Object[] args = actionResult.getArgs();
        if (args == null) {
            return null;
        }
        Object obj = args[0];
        k.d(obj, "null cannot be cast to non-null type kotlin.String");
        String str = (String) obj;
        Object objS0 = q.s0(1, args);
        Intent intent = objS0 instanceof Intent ? (Intent) objS0 : null;
        Object objS02 = q.s0(2, args);
        IntentEntity intentEntity = objS02 instanceof IntentEntity ? (IntentEntity) objS02 : null;
        Object objS03 = q.s0(3, args);
        return new OpenAppArgs(str, intent, intentEntity, objS03 instanceof Integer ? (Integer) objS03 : null);
    }

    public static final ScaleArgs getScaleArgs(ActionResult<?> actionResult) {
        k.f(actionResult, "<this>");
        Object[] args = actionResult.getArgs();
        if (args == null) {
            return null;
        }
        Object obj = args[0];
        k.d(obj, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) obj).floatValue();
        Object obj2 = args[1];
        k.d(obj2, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue2 = ((Float) obj2).floatValue();
        Object obj3 = args[2];
        k.d(obj3, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue3 = ((Float) obj3).floatValue();
        Object obj4 = args[3];
        k.d(obj4, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue4 = ((Float) obj4).floatValue();
        Object obj5 = args[4];
        k.d(obj5, "null cannot be cast to non-null type kotlin.Long");
        long jLongValue = ((Long) obj5).longValue();
        Object objS0 = q.s0(5, args);
        return new ScaleArgs(fFloatValue, fFloatValue2, fFloatValue3, fFloatValue4, jLongValue, objS0 instanceof Integer ? (Integer) objS0 : null);
    }

    public static final SetTextArgs getSetTextArgs(ActionResult<?> actionResult) {
        k.f(actionResult, "<this>");
        Object[] args = actionResult.getArgs();
        if (args == null) {
            return null;
        }
        Object obj = args[0];
        k.d(obj, "null cannot be cast to non-null type kotlin.String");
        String str = (String) obj;
        Object objS0 = q.s0(1, args);
        Integer num = objS0 instanceof Integer ? (Integer) objS0 : null;
        Object objS02 = q.s0(2, args);
        Integer num2 = objS02 instanceof Integer ? (Integer) objS02 : null;
        Object objS03 = q.s0(3, args);
        String str2 = objS03 instanceof String ? (String) objS03 : null;
        Object objS04 = q.s0(4, args);
        String str3 = objS04 instanceof String ? (String) objS04 : null;
        Object objS05 = q.s0(5, args);
        String str4 = objS05 instanceof String ? (String) objS05 : null;
        Object objS06 = q.s0(6, args);
        return new SetTextArgs(str, num, num2, str2, str3, str4, objS06 instanceof Integer ? (Integer) objS06 : null);
    }

    public static final SwipeArgs getSwipeArgs(ActionResult<?> actionResult) {
        k.f(actionResult, "<this>");
        Object[] args = actionResult.getArgs();
        if (args == null) {
            return null;
        }
        Object obj = args[0];
        k.d(obj, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) obj).floatValue();
        Object obj2 = args[1];
        k.d(obj2, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue2 = ((Float) obj2).floatValue();
        Object obj3 = args[2];
        k.d(obj3, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue3 = ((Float) obj3).floatValue();
        Object obj4 = args[3];
        k.d(obj4, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue4 = ((Float) obj4).floatValue();
        Object obj5 = args[4];
        k.d(obj5, "null cannot be cast to non-null type kotlin.Long");
        long jLongValue = ((Long) obj5).longValue();
        Object obj6 = args[5];
        k.d(obj6, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) obj6).intValue();
        Object objS0 = q.s0(6, args);
        Integer num = objS0 instanceof Integer ? (Integer) objS0 : null;
        Object objS02 = q.s0(7, args);
        String str = objS02 instanceof String ? (String) objS02 : null;
        Object objS03 = q.s0(8, args);
        return new SwipeArgs(fFloatValue, fFloatValue2, fFloatValue3, fFloatValue4, jLongValue, iIntValue, num, str, objS03 instanceof String ? (String) objS03 : null);
    }

    public static final UiSnapshotArgs getUiSnapshotArgs(ActionResult<?> actionResult) {
        k.f(actionResult, "<this>");
        Object[] args = actionResult.getArgs();
        if (args == null) {
            return null;
        }
        Object objS0 = q.s0(0, args);
        String str = objS0 instanceof String ? (String) objS0 : null;
        Object objS02 = q.s0(1, args);
        String str2 = objS02 instanceof String ? (String) objS02 : null;
        Object objS03 = q.s0(2, args);
        String str3 = objS03 instanceof String ? (String) objS03 : null;
        Object objS04 = q.s0(3, args);
        Integer num = objS04 instanceof Integer ? (Integer) objS04 : null;
        Object objS05 = q.s0(4, args);
        Long l = objS05 instanceof Long ? (Long) objS05 : null;
        Object objS06 = q.s0(5, args);
        return new UiSnapshotArgs(str, str2, str3, num, l, objS06 instanceof Boolean ? (Boolean) objS06 : null);
    }

    public static final WaitArgs getWaitArgs(ActionResult<?> actionResult) {
        k.f(actionResult, "<this>");
        Object[] args = actionResult.getArgs();
        if (args == null) {
            return null;
        }
        Object obj = args[0];
        k.d(obj, "null cannot be cast to non-null type kotlin.Long");
        long jLongValue = ((Long) obj).longValue();
        Object objS0 = q.s0(1, args);
        return new WaitArgs(jLongValue, objS0 instanceof Integer ? (Integer) objS0 : null);
    }

    public static final <T> T typedArgs(ActionResult<?> actionResult) {
        k.f(actionResult, "<this>");
        k.m();
        throw null;
    }
}
