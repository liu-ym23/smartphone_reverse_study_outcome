package com.obric.autogui.platforms.tools.input.inject;

import android.hardware.input.InputManager;
import android.view.InputDevice;
import android.view.InputEvent;
import android.view.MotionEvent;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.logging.OmniDataFeedbackLog;
import com.obric.autogui.common.api.platform.annotation.CallingPlatform;
import com.obric.autogui.common.api.platform.input.InjectEventContext;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.DisplayOperatingSpace;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.i;
import d.a.p;
import d.f;
import d.g;
import d.j;
import d.m;
import d.n;
import d.o;
import d.s;
import d.x;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: StandardMotionEventInjector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private static final String TAG = "InputEventInjector";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f30311a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicLong f30312b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final f f30313c = null;

    /* JADX INFO: renamed from: lambda$-ORwZHX7Px-DChcCfumAW6tKSvs, reason: not valid java name */
    public static /* synthetic */ CharSequence m863lambda$ORwZHX7PxDChcCfumAW6tKSvs(MotionEvent.PointerProperties r0) {
        return a(r0);
    }

    public static /* synthetic */ Method lambda$fGYELzN7gePce8mz_U4CFwThwlU() {
        return b();
    }

    /* JADX INFO: renamed from: lambda$lX1gCy4QdFRwKnXp-bIl3bY9XFY, reason: not valid java name */
    public static /* synthetic */ CharSequence m864lambda$lX1gCy4QdFRwKnXpbIl3bY9XFY(MotionEvent r0, int r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$nww5nQHjzXmTV4maN1bQDTmW-us, reason: not valid java name */
    public static /* synthetic */ CharSequence m865lambda$nww5nQHjzXmTV4maN1bQDTmWus(Map.Entry r0) {
        return a(r0);
    }

    public static /* synthetic */ CharSequence lambda$yHkDSvC71YZr1NXvNM72TYUg1kw(MotionEvent.PointerCoords r0) {
        return a(r0);
    }

    private e() {
    }

    static {
        f30311a = new e();
        f30312b = new AtomicLong(0);
        f30313c = g.a(j.f38507c, $$Lambda$e$fGYELzN7gePce8mz_U4CFwThwlU.INSTANCE);
    }

    private final Method a() {
        return (Method) ZeusTransformUtils.preCheckCast(f30313c.b(), Method.class, "com.obric.aiagent.plugin");
    }

    private static final Method b() {
        n.a r0 = n.f38560a;     // Catch: Throwable -> L4
        Method r1 = InputEvent.class.getDeclaredMethod("getId", new Class[0]);     // Catch: Throwable -> L4
        r1.setAccessible(true);     // Catch: Throwable -> L4
        Object r2 = n.f(r1);     // Catch: Throwable -> L4
    L7:
        if (n.b(r2) == false) goto L10;
        r2 = null;
    L10:
        return (Method) ZeusTransformUtils.preCheckCast(r2, Method.class, "com.obric.aiagent.plugin");
    L4:
        th = move-exception;
        n.a r3 = n.f38560a;
        r2 = n.f(o.a(th));
        goto L7
    }

    public static /* synthetic */ com.obric.autogui.common.e a(e r14, int r15, long r16, long r18, float r20, float r21, float r22, int r23, String r24, InjectEventContext.Context r25, int r26, Object r27) {
        if ((r26 & 64) == 0) goto L5;
        int r11 = -1;
    L7:
        if ((r26 & 128) == 0) goto L9;
        String r12 = "";
    L11:
        if ((r26 & 256) == 0) goto L13;
        InjectEventContext.Context r13 = null;
    L15:
        return r14.a(r15, r16, r18, r20, r21, r22, r11, r12, r13);
    L13:
        r13 = r25;
        goto L15
    L9:
        r12 = r24;
        goto L11
    L5:
        r11 = r23;
        goto L7
    }

    public final com.obric.autogui.common.e a(int r14, long r15, long r17, float r19, float r20, float r21, int r22, String r23, InjectEventContext.Context r24) {
        d.h.b.o.e(r23, "traceLabel");
        long r1 = f30312b.incrementAndGet();
        Map<Integer, Float> r9 = ao.a(new m[]{s.a(0, Float.valueOf(r19)), s.a(1, Float.valueOf(r20)), s.a(2, Float.valueOf(r21))});
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L7;
        Loog.INSTANCE.d(TAG, "[MotionInput] request injectSeq=" + r1 + ", trace=" + r23 + ", action=" + MotionEvent.actionToString(r14) + ", downTime=" + r15 + ", eventTime=" + r17 + ", x=" + r19 + ", y=" + r20 + ", pressure=" + r21 + ", requestedDisplayId=" + r22 + ", source=" + f30311a.b(4098));
    L7:
        return a(r1, r23, r14, r15, r17, r9, 4098, r22, r24);
    }

    private final com.obric.autogui.common.e a(long r24, String r26, int r27, long r28, long r30, Map<Integer, Float> r32, int r33, int r34, InjectEventContext.Context r35) {
        Map<Integer, Float> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r32, Map.class, "com.obric.aiagent.plugin");
        MotionEvent.PointerProperties[] r10 = new MotionEvent.PointerProperties[1];
        int r6 = 0;
        int r7 = 0;
    L3:
        if (r7 >= 1) goto L5;
        MotionEvent.PointerProperties r8 = new MotionEvent.PointerProperties();
        r8.id = r7;
        r8.toolType = 1;
        x r9 = x.f38692a;
        r10[r7] = r8;
        r7 = r7 + 1;
        goto L3
    L5:
        MotionEvent.PointerCoords[] r11 = new MotionEvent.PointerCoords[1];
    L6:
        if (r6 >= 1) goto L13;
        MotionEvent.PointerCoords r12 = new MotionEvent.PointerCoords();
        r12.size = 1.0f;
        Iterator<Map.Entry<Integer, Float>> r13 = r3.entrySet().iterator();
    L9:
        if (r13.hasNext() == false) goto L11;
        Map.Entry r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r12.setAxisValue(((Number) ZeusTransformUtils.preCheckCast(r14.getKey(), Number.class, "com.obric.aiagent.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r14.getValue(), Number.class, "com.obric.aiagent.plugin")).floatValue());
        goto L9
    L11:
        x r15 = x.f38692a;
        r11[r6] = r12;
        r6 = r6 + 1;
        goto L6
    L13:
        if (r34 == (-1)) goto L15;
        int r16 = r34;
    L23:
        int r17 = a(r33);
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L26;
        Loog r18 = Loog.INSTANCE;
        StringBuilder r5 = new StringBuilder().append("[MotionInput] build event injectSeq=").append(r24).append(", trace=").append(r26).append(", action=").append(MotionEvent.actionToString(r27)).append(", pointerCount=").append(1).append(", pointerProperties=");
        e r19 = f30311a;
        r18.d(TAG, r5.append(r19.a(r10)).append(", pointerCoords=").append(r19.a(r11)).append(", finalDisplayId=").append(r16).append(", inputDeviceId=").append(r17).append(", source=").append(r19.b(r33)).append(", axisValues=").append(r19.a(r3)).toString());
    L26:
        MotionEvent r4 = com.obric.autogui.platforms.tools.internal.a.f.f30329a.a(r28, r30, r27, 1, r10, r11, 0, 0, 1.0f, 1.0f, r17, 0, r33, r16, 0);
        if (r4 != null) goto L31;
        OmniDataFeedbackLog.INSTANCE.e(TAG, "[MotionInput] obtainMotionEvent null injectSeq=" + r24 + ", trace=" + r26);
        return com.obric.autogui.common.e.f29014b.b("obtain-motion-event-null");
    L31:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L34;
        Loog.INSTANCE.d(TAG, "[MotionInput] obtained event injectSeq=" + r24 + ", trace=" + r26 + ", " + f30311a.a(r4));
    L34:
        return a(r4, r24, r26, r35);
    L15:
        AOOperatingSpace r20 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        if (r20 != null) goto L18;
    L35:
        OmniDataFeedbackLog.INSTANCE.e(TAG, "[MotionInput] resolve display failed injectSeq=" + r24 + ", trace=" + r26 + ", activeSpace=" + r20);
        return com.obric.autogui.common.e.f29014b.b("no-active-space");
    L18:
        if (ZeusTransformUtils.instanceOf(r20, DisplayOperatingSpace.class) == false) goto L35;
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L22;
        Loog.INSTANCE.d(TAG, "[MotionInput] resolve display injectSeq=" + r24 + ", trace=" + r26 + ", activeSpace=" + r20 + ", displayId=" + ((DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r20, DisplayOperatingSpace.class, "com.obric.aiagent.plugin")).getDisplayId());
    L22:
        r16 = ((DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r20, DisplayOperatingSpace.class, "com.obric.aiagent.plugin")).getDisplayId();
        goto L23
    }

    private final int a(int r7) {
        int[] r6 = InputDevice.getDeviceIds();
        d.h.b.o.a(r6);
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L13;
        int r3 = r6[r2];
        InputDevice r4 = InputDevice.getDevice(r3);
        boolean r5 = true;
        if (r4 != null) goto L7;
    L9:
        r5 = false;
    L10:
        if (r5 == true) goto L11;
        r2 = r2 + 1;
        goto L3
    L11:
        Integer r8 = Integer.valueOf(r3);
    L14:
        if (r8 != null) goto L16;
        return 0;
    L16:
        return r8.intValue();
    L7:
        if (r4.supportsSource(r7) != true) goto L9;
    L13:
        r8 = null;
        goto L14
    }

    public static /* synthetic */ com.obric.autogui.common.e a(e r6, MotionEvent r7, long r8, String r10, InjectEventContext.Context r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r8 = f30312b.incrementAndGet();
    L5:
        long r2 = r8;
        if ((r12 & 4) == 0) goto L8;
        r10 = "";
    L8:
        String r4 = r10;
        if ((r12 & 8) == 0) goto L12;
        r11 = null;
    L12:
        return r6.a(r7, r2, r4, r11);
    }

    @CallingPlatform
    public final com.obric.autogui.common.e a(MotionEvent r8, long r9, String r11, InjectEventContext.Context r12) {
        d.h.b.o.e(r8, "event");
        d.h.b.o.e(r11, "traceLabel");
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L5;
        Loog.INSTANCE.d(TAG, "[MotionInput] inputManager invoke injectSeq=" + r9 + ", trace=" + r11 + ", syncMode=0, " + f30311a.a(r8));
    L5:
        InputManager r1 = com.obric.autogui.platforms.tools.input.c.f30257a.a();
        if (r1 != null) goto L9;
        e r7 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin");
        OmniDataFeedbackLog.INSTANCE.e(TAG, "[MotionInput] inputManager null injectSeq=" + r9 + ", trace=" + r11);
        return com.obric.autogui.common.e.f29014b.b("im-null");
    L9:
        Method r5 = com.obric.autogui.platforms.tools.input.c.f30257a.b();
        if (r5 != null) goto L13;
        e r10 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin");
        OmniDataFeedbackLog.INSTANCE.e(TAG, "[MotionInput] injector method null injectSeq=" + r9 + ", trace=" + r11);
        return com.obric.autogui.common.e.f29014b.b("method-null");
    L13:
        Integer r13 = b(r8, r9, r11, r12);
        n.a r14 = n.f38560a;     // Catch: Throwable -> L19
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L17;
        Loog.INSTANCE.d(TAG, "[MotionInput] inputManager data injectSeq=" + r9 + ", trace=" + r11 + ", manager=" + r1.getClass().getName() + ", method=" + r5 + ", event=" + r8);     // Catch: Throwable -> L19
    L17:
        Object r15 = n.f(r5.invoke(r1, new Object[]{r8, 0}));     // Catch: Throwable -> L19
    L21:
        Throwable r16 = n.c(r15);
        if (r16 == null) goto L29;
        OmniDataFeedbackLog.INSTANCE.e(TAG, "[MotionInput] inputManager exception injectSeq=" + r9 + ", trace=" + r11 + ", " + f30311a.a(r8), r16);
        if (r13 == null) goto L27;
        InjectEventContext.INSTANCE.unregisterInjectEvent(((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.aiagent.plugin")).intValue(), "input-manager-exception");
    L27:
        return com.obric.autogui.common.e.f29014b.b("throwed=" + r16.getClass());
    L29:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L32;
        Loog.INSTANCE.d(TAG, "[MotionInput] inputManager done injectSeq=" + r9 + ", trace=" + r11);
    L32:
        return com.obric.autogui.common.e.f29014b.a();
    L19:
        th = move-exception;
        n.a r0 = n.f38560a;
        r15 = n.f(o.a(th));
        goto L21
    }

    private final Integer b(MotionEvent r7, long r8, String r10, InjectEventContext.Context r11) {
        Object r0 = null;
        if (r11 != null) goto L6;
        return null;
    L6:
        if (r7.getActionMasked() == 1) goto L8;
        return null;
    L8:
        Integer r9 = a((InputEvent) ZeusTransformUtils.preCheckCast(r7, InputEvent.class, "com.obric.aiagent.plugin"));
        if (r9 == null) goto L11;
        n.a r4 = n.f38560a;     // Catch: Throwable -> L16
        e r6 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        InjectEventContext.INSTANCE.registerInjectEvent(r9.intValue(), r11);     // Catch: Throwable -> L16
        Object r12 = n.f(Integer.valueOf(r9.intValue()));     // Catch: Throwable -> L16
    L18:
        Throwable r13 = n.c(r12);
        if (r13 == null) goto L24;
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L24;
        Loog.INSTANCE.w(TAG, "[MotionInput] react_view_tree register failed, injectSeq=" + r8 + ", trace=" + r10, r13);
    L24:
        if (n.b(r12) == true) goto L28;
        r0 = r12;
    L28:
        return (Integer) ZeusTransformUtils.preCheckCast(r0, Integer.class, "com.obric.aiagent.plugin");
    L16:
        th = move-exception;
        n.a r14 = n.f38560a;
        r12 = n.f(o.a(th));
        goto L18
    L11:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L13;
        Loog.INSTANCE.w(TAG, "[MotionInput] react_view_tree skip register, inputEventId unavailable, injectSeq=" + r8 + ", trace=" + r10 + ", " + r11.logFields());
    L13:
        return null;
    }

    private final Integer a(InputEvent r4) {
        Method r3 = a();
        Object r1 = null;
        if (r3 != null) goto L19;
        return null;
    L19:
        n.a r2 = n.f38560a;     // Catch: Throwable -> L11
        Object r5 = r3.invoke(r4, new Object[0]);     // Catch: Throwable -> L11
        if (ZeusTransformUtils.instanceOf(r5, Integer.class) == false) goto L8;
        Integer r6 = (Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
    L9:
        Object r7 = n.f(r6);     // Catch: Throwable -> L11
    L14:
        if (n.b(r7) == true) goto L18;
        r1 = r7;
    L18:
        return (Integer) ZeusTransformUtils.preCheckCast(r1, Integer.class, "com.obric.aiagent.plugin");
    L8:
        r6 = null;
    L11:
        th = move-exception;
        n.a r8 = n.f38560a;
        r7 = n.f(o.a(th));
        goto L14
    }

    private final String a(MotionEvent.PointerProperties[] r12) {
        return i.a(r12, null, (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.aiagent.plugin"), 0, null, $$Lambda$e$ORwZHX7PxDChcCfumAW6tKSvs.INSTANCE, 25, null);
    }

    private static final CharSequence a(MotionEvent.PointerProperties r3) {
        if (r3 != null) goto L6;
        return (CharSequence) ZeusTransformUtils.preCheckCast("null", CharSequence.class, "com.obric.aiagent.plugin");
    L6:
        return (CharSequence) ZeusTransformUtils.preCheckCast("{id=" + r3.id + ",toolType=" + f30311a.c(r3.toolType) + '}', CharSequence.class, "com.obric.aiagent.plugin");
    }

    private final String a(MotionEvent.PointerCoords[] r12) {
        return i.a(r12, null, (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.aiagent.plugin"), 0, null, $$Lambda$e$yHkDSvC71YZr1NXvNM72TYUg1kw.INSTANCE, 25, null);
    }

    private static final CharSequence a(MotionEvent.PointerCoords r3) {
        if (r3 != null) goto L6;
        return (CharSequence) ZeusTransformUtils.preCheckCast("null", CharSequence.class, "com.obric.aiagent.plugin");
    L6:
        return (CharSequence) ZeusTransformUtils.preCheckCast("{x=" + r3.x + ",y=" + r3.y + ",pressure=" + r3.pressure + ",size=" + r3.size + '}', CharSequence.class, "com.obric.aiagent.plugin");
    }

    private static final CharSequence a(Map.Entry r3) {
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<destruct>");
        int r0 = ((Number) ZeusTransformUtils.preCheckCast(r4.getKey(), Number.class, "com.obric.aiagent.plugin")).intValue();
        return (CharSequence) ZeusTransformUtils.preCheckCast(MotionEvent.axisToString(r0) + '=' + ((Number) ZeusTransformUtils.preCheckCast(r4.getValue(), Number.class, "com.obric.aiagent.plugin")).floatValue(), CharSequence.class, "com.obric.aiagent.plugin");
    }

    private final String a(Map<Integer, Float> r11) {
        return p.a((Iterable) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin")).entrySet(), Iterable.class, "com.obric.aiagent.plugin"), null, (CharSequence) ZeusTransformUtils.preCheckCast("{", CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("}", CharSequence.class, "com.obric.aiagent.plugin"), 0, null, $$Lambda$e$nww5nQHjzXmTV4maN1bQDTmWus.INSTANCE, 25, null);
    }

    private final String a(final MotionEvent r13) {
        String r0 = p.a((Iterable) ZeusTransformUtils.preCheckCast(d.l.n.b(0, r13.getPointerCount()), Iterable.class, "com.obric.aiagent.plugin"), null, (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.aiagent.plugin"), 0, null, new $$Lambda$e$lX1gCy4QdFRwKnXpbIl3bY9XFY(r13), 25, null);
        StringBuilder r1 = new StringBuilder();
        r1.append("event={inputEventId=").append(b((InputEvent) ZeusTransformUtils.preCheckCast(r13, InputEvent.class, "com.obric.aiagent.plugin"))).append(", action=").append(MotionEvent.actionToString(r13.getAction())).append(", actionMasked=").append(MotionEvent.actionToString(r13.getActionMasked())).append(", actionIndex=").append(r13.getActionIndex()).append(", downTime=").append(r13.getDownTime()).append(", eventTime=").append(r13.getEventTime()).append(", eventTimeNanos=").append(r13.getEventTimeNanos()).append(", deviceId=").append(r13.getDeviceId()).append(", source=").append(b(r13.getSource())).append(", flags=").append(r13.getFlags()).append(", edgeFlags=").append(r13.getEdgeFlags()).append(", metaState=");
        r1.append(r13.getMetaState()).append(", buttonState=").append(r13.getButtonState()).append(", xPrecision=").append(r13.getXPrecision()).append(", yPrecision=").append(r13.getYPrecision()).append(", pointerCount=").append(r13.getPointerCount()).append(", pointers=").append(r0).append(", eventString=").append(r13).append('}');
        return r1.toString();
    }

    private static final CharSequence a(MotionEvent r3, int r4) {
        return (CharSequence) ZeusTransformUtils.preCheckCast("{index=" + r4 + ",id=" + r3.getPointerId(r4) + ",tool=" + f30311a.c(r3.getToolType(r4)) + ",x=" + r3.getX(r4) + ",y=" + r3.getY(r4) + ",rawX=" + r3.getRawX() + ",rawY=" + r3.getRawY() + ",pressure=" + r3.getPressure(r4) + ",size=" + r3.getSize(r4) + '}', CharSequence.class, "com.obric.aiagent.plugin");
    }

    private final String b(InputEvent r2) {
        Method r1 = a();
        if (r1 != null) goto L21;
        return "unavailable";
    L21:
        n.a r0 = n.f38560a;     // Catch: Throwable -> L13
        Object r3 = r1.invoke(r2, new Object[0]);     // Catch: Throwable -> L13
        if (r3 == null) goto L10;
        String r4 = r3.toString();     // Catch: Throwable -> L13
        if (r4 == null) goto L10;
    L11:
        Object r5 = n.f(r4);     // Catch: Throwable -> L13
    L15:
        Throwable r6 = n.c(r5);
        if (r6 == null) goto L20;
        r5 = "error:" + r6.getClass().getSimpleName();
    L20:
        return (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");
    L10:
        r4 = "null";
    L13:
        th = move-exception;
        n.a r7 = n.f38560a;
        r5 = n.f(o.a(th));
        goto L15
    }

    private final String b(int r2) {
        StringBuilder r1 = new StringBuilder().append("0x");
        String r3 = Integer.toString(r2, d.o.a.a(16));
        d.h.b.o.c(r3, "toString(...)");
        return r1.append(r3).toString();
    }

    private final String c(int r1) {
        if (r1 != 0) goto L4;
        return "UNKNOWN";
    L4:
        if (r1 != 1) goto L6;
        return "FINGER";
    L6:
        if (r1 != 2) goto L8;
        return "STYLUS";
    L8:
        if (r1 != 3) goto L10;
        return "MOUSE";
    L10:
        if (r1 != 4) goto L18;
        return "ERASER";
    L18:
        return String.valueOf(r1);
    }
}
