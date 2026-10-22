package com.obric.livecard.api.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.livecard.api.IIslandCardCallback;
import com.obric.livecard.api.IslandCardCallback;
import com.obric.livecard.api.LiveCard;
import com.obric.livecard.api.annotation.Event;
import com.obric.livecard.api.annotation.Params;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.a.a;
import d.h.b.o;
import d.n;
import d.x;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: ClientCallback.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ClientCallback extends IIslandCardCallback.Stub {
    private final Map<String, MethodWrapper> customEventMethodMap;
    private final Handler mainHandler;
    private final IslandSession session;

    /* JADX INFO: compiled from: ClientCallback.kt */
    public static final class MethodWrapper {
        private final Method method;
        private final List<ParameterWrapper> parameters;

        public static /* synthetic */ MethodWrapper copy$default(MethodWrapper r0, Method r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.method;
        L6:
            return r0.copy(r1);
        }

        public final Method component1() {
            return this.method;
        }

        public final MethodWrapper copy(Method r1) {
            o.e(r1, "method");
            return new MethodWrapper(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, MethodWrapper.class) == true) goto L8;
            return false;
        L8:
            MethodWrapper r6 = (MethodWrapper) ZeusTransformUtils.preCheckCast(r5, MethodWrapper.class, "com.obric.aiagent.plugin");
            if (o.a(this.method, r6.method) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.method.hashCode();
        }

        public String toString() {
            return "MethodWrapper(method=" + this.method + ')';
        }

        public MethodWrapper(Method r3) {
            o.e(r3, "method");
            this.method = r3;
            this.parameters = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        }

        public final Method getMethod() {
            return this.method;
        }

        public final List<ParameterWrapper> getParameters() {
            return this.parameters;
        }
    }

    /* JADX INFO: compiled from: ClientCallback.kt */
    public static final class ParameterWrapper {
        private final String name;
        private final boolean required;
        private final Class<?> type;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ParameterWrapper copy$default(ParameterWrapper r0, boolean r1, String r2, Class r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.required;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.name;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.type;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final boolean component1() {
            return this.required;
        }

        public final String component2() {
            return this.name;
        }

        public final Class<?> component3() {
            return this.type;
        }

        public final ParameterWrapper copy(boolean r1, String r2, Class<?> r3) {
            o.e(r2, "name");
            o.e(r3, "type");
            return new ParameterWrapper(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, ParameterWrapper.class) == true) goto L8;
            return false;
        L8:
            ParameterWrapper r6 = (ParameterWrapper) ZeusTransformUtils.preCheckCast(r5, ParameterWrapper.class, "com.obric.aiagent.plugin");
            if (this.required == r6.required) goto L12;
            return false;
        L12:
            if (o.a(this.name, r6.name) == true) goto L15;
            return false;
        L15:
            if (o.a(this.type, r6.type) == true) goto L17;
            return false;
        L17:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean r0 = this.required;
            ?? r1 = r0;
            if (r0 == false) goto L6;
            r1 = 1;
        L6:
            return (((r1 * 31) + this.name.hashCode()) * 31) + this.type.hashCode();
        }

        public String toString() {
            return "ParameterWrapper(required=" + this.required + ", name=" + this.name + ", type=" + this.type + ')';
        }

        public ParameterWrapper(boolean r2, String r3, Class<?> r4) {
            o.e(r3, "name");
            o.e(r4, "type");
            this.required = r2;
            this.name = r3;
            this.type = r4;
        }

        public final boolean getRequired() {
            return this.required;
        }

        public final String getName() {
            return this.name;
        }

        public final Class<?> getType() {
            return this.type;
        }
    }

    public static /* synthetic */ void lambda$cizCpi22pv2i9PQPXZ91nUwcN3A(Bundle r0, ClientCallback r1) {
        onCardEvent$lambda$26(r0, r1);
    }

    public static /* synthetic */ void lambda$yV8SDbk5jW_wMLQpNBz3gFhLu6Y(ClientCallback r0, Bundle r1) {
        onCardEvent$lambda$28(r0, r1);
    }

    public ClientCallback(IslandSession r4) {
        o.e(r4, SensitiveType.SESSION);
        this.session = r4;
        this.customEventMethodMap = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        this.mainHandler = new Handler(Looper.getMainLooper());
        injectCustomEvent(r4.getCallback());
    }

    public final IslandSession getSession() {
        return this.session;
    }

    private final void injectCustomEvent(IslandCardCallback r17) {
        IslandCardCallback r0 = (IslandCardCallback) ZeusTransformUtils.wrapperContextForParams(r17, IslandCardCallback.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        Method[] r1 = r0.getClass().getDeclaredMethods();
        o.c(r1, "callback::class.java.declaredMethods");
        Object[] r2 = (Object[]) ZeusTransformUtils.preCheckCast(r1, Object[].class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r4 = r2.length;
        int r5 = 0;
    L6:
        boolean r6 = true;
        if (r5 >= r4) goto L18;
        Object r7 = r2[r5];
        Annotation[] r8 = ((Method) ZeusTransformUtils.preCheckCast(r7, Method.class, "com.obric.aiagent.plugin")).getAnnotations();
        o.c(r8, "it.annotations");
        Object[] r9 = (Object[]) ZeusTransformUtils.preCheckCast(r8, Object[].class, "com.obric.aiagent.plugin");
        int r10 = r9.length;
        int r11 = 0;
    L9:
        if (r11 >= r10) goto L14;
        if (ZeusTransformUtils.instanceOf((Annotation) ZeusTransformUtils.preCheckCast(r9[r11], Annotation.class, "com.obric.aiagent.plugin"), Event.class) == true) goto L15;
        r11 = r11 + 1;
    L15:
        if (r6 == false) goto L17;
        r3.add(r7);
    L17:
        r5 = r5 + 1;
        goto L6
    L14:
        r6 = false;
        goto L15
    L18:
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L20:
        if (r12.hasNext() == false) goto L32;
        Method r13 = (Method) ZeusTransformUtils.preCheckCast(r12.next(), Method.class, "com.obric.aiagent.plugin");
        r13.setAccessible(true);
        Event r14 = (Event) ZeusTransformUtils.preCheckCast(r13.getAnnotation(Event.class), Event.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L20;
        o.c(r14, "getAnnotation(Event::class.java)");
        Map<String, MethodWrapper> r15 = this.customEventMethodMap;
        String r16 = r14.name();
        o.c(r13, "method");
        MethodWrapper r18 = new MethodWrapper(r13);
        Parameter[] r19 = r13.getParameters();
        o.c(r19, "method.parameters");
        Object[] r20 = (Object[]) ZeusTransformUtils.preCheckCast(r19, Object[].class, "com.obric.aiagent.plugin");
        int r21 = r20.length;
        int r110 = 0;
    L24:
        if (r110 >= r21) goto L30;
        Parameter r111 = (Parameter) ZeusTransformUtils.preCheckCast(r20[r110], Parameter.class, "com.obric.aiagent.plugin");
        Params r112 = (Params) ZeusTransformUtils.preCheckCast(r111.getAnnotation(Params.class), Params.class, "com.obric.aiagent.plugin");
        if (r112 == null) goto L29;
        List<ParameterWrapper> r113 = r18.getParameters();
        boolean r114 = r112.required();
        String r115 = r112.name();
        Class<?> r116 = r111.getType();
        o.c(r116, "param.type");
        r113.add(new ParameterWrapper(r114, r115, r116));
        r110 = r110 + 1;
        goto L24
    L29:
        throw new IllegalArgumentException("参数" + r111.getName() + "缺少@Params注解");
    L30:
        r15.put(r16, r18);
        goto L20
    }

    private final Bundle handleCustomEvent(Bundle r10, IslandSession r11) {
        if (r10 == null) goto L49;
        String r1 = r10.getString("eventName");
        if (r1 == null) goto L49;
        String r12 = r10.getString("eventParams");
        if (r12 == null) goto L10;
        JsonObject r13 = (JsonObject) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r12, JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin");
    L11:
        IslandCardCallback r14 = r11.getCallback();
        if (r14 != null) goto L15;
        Bundle r9 = new Bundle();
        r9.putString("error_message", "client not register callback");
        return r9;
    L15:
        MethodWrapper r15 = (MethodWrapper) ZeusTransformUtils.preCheckCast(this.customEventMethodMap.get(r1), MethodWrapper.class, "com.obric.aiagent.plugin");
        if (r15 != null) goto L19;
        Bundle r16 = new Bundle();
        r16.putString("error_message", "not found method : " + r1);
        return r16;
    L19:
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r15.getParameters(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r2, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r3 = r2.iterator();
    L21:
        if (r3.hasNext() == false) goto L43;
        ParameterWrapper r5 = (ParameterWrapper) ZeusTransformUtils.preCheckCast(r3.next(), ParameterWrapper.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L36;
        JsonElement r6 = r13.get(r5.getName());
        if (r6 == null) goto L36;
        n.a r7 = n.f38560a;     // Catch: Throwable -> L28
        Object r8 = n.f(new Gson().fromJson(r6, r5.getType()));     // Catch: Throwable -> L28
    L31:
        if (n.c(r8) != null) goto L32;
        n.a(r8);
        if (n.b(r8) == true) goto L36;
    L38:
        if (r5.getRequired() == false) goto L42;
        if (r8 != null) goto L42;
        Bundle r17 = new Bundle();
        r17.putString("error_message", "the " + r5.getName() + " is required");
        return r17;
    L42:
        r4.add(r8);
        goto L21
    L32:
        Bundle r18 = new Bundle();
        r18.putString("error_message", "parse error, " + r5.getType() + " is not match " + r6 + ' ');
        return r18;
    L28:
        th = move-exception;
        n.a r19 = n.f38560a;
        r8 = n.f(d.o.a(th));
    L36:
        r8 = null;
        goto L38
    L43:
        List r110 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
        Bundle r0 = new Bundle();
        Method r20 = r15.getMethod();
        Object[] r111 = ((Collection) ZeusTransformUtils.preCheckCast(r110, Collection.class, "com.obric.aiagent.plugin")).toArray(new Object[0]);
        Objects.requireNonNull(r111, "null cannot be cast to non-null type kotlin.Array<T>");
        Object r21 = r20.invoke(r14, Arrays.copyOf(r111, r111.length));
        if (r21 == null) goto L48;
        o.c(r21, "invoke(callback, *args.toTypedArray())");
        String r22 = new Gson().toJson(r21);
        if (r22 == null) goto L48;
        o.c(r22, "let { Gson().toJson(it) }");
        r0.putString("result", r22);
    L48:
        return r0;
    L10:
        r13 = null;
    L49:
        Bundle r23 = new Bundle();
        r23.putString("error_message", "not found eventName");
        return r23;
    }

    @Override // com.obric.livecard.api.IIslandCardCallback
    public Bundle onCardEvent(String r11, final Bundle r12) {
        if (r11 == null) goto L91;
        boolean r2 = true;
        int r6 = 0;
        switch(r11.hashCode()) {
            case -1801488983: goto L87;
            case -1629899068: goto L82;
            case -1357275426: goto L77;
            case -1277610568: goto L73;
            case -1261615456: goto L69;
            case -657494225: goto L54;
            case -301924039: goto L49;
            case -180131773: goto L40;
            case -149134357: goto L36;
            case 183568797: goto L30;
            case 254225299: goto L14;
            case 1996594498: goto L8;
            default: goto L91;
        };
    L8:
        if (r11.equals("onSessionInactive") == false) goto L91;
        IslandCardCallback r13 = this.session.getCallback();
        if (r13 == null) goto L91;
        r13.onSessionInactive(this.session);
        goto L91
    L14:
        if (r11.equals("onSessionCreate") == false) goto L91;
        if (r12 == null) goto L26;
        Long r14 = Long.valueOf(r12.getLong(DBDefinition.TASK_ID));
        if (((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.aiagent.plugin")).longValue() != 0) goto L21;
        r2 = false;
    L21:
        if (r2 == true) goto L24;
        r14 = null;
    L24:
        if (r14 == null) goto L26;
        this.session.setTaskId(((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.aiagent.plugin")).longValue());
    L26:
        IslandCardCallback r15 = this.session.getCallback();
        if (r15 == null) goto L91;
        r15.onSessionCreate(this.session);
        goto L91
    L30:
        if (r11.equals("onSessionActive") == false) goto L91;
        IslandCardCallback r16 = this.session.getCallback();
        if (r16 == null) goto L91;
        r16.onSessionActive(this.session);
        goto L91
    L36:
        if (r11.equals("onSessionStatusChanged") == false) goto L91;
        this.mainHandler.post(new $$Lambda$ClientCallback$yV8SDbk5jW_wMLQpNBz3gFhLu6Y(this, r12));
        goto L91
    L40:
        if (r11.equals("onSessionDestroy") == false) goto L91;
        if (r12 == null) goto L44;
        r6 = r12.getInt("reason");
    L44:
        IslandCardCallback r17 = this.session.getCallback();
        if (r17 == null) goto L47;
        r17.onSessionDestroy(this.session, Integer.valueOf(r6));
    L47:
        LiveCard.INSTANCE.clearSession(this.session);
        goto L91
    L49:
        if (r11.equals("onCardClick") == false) goto L91;
        return handleCardOnClick(r12, this.session);
    L54:
        if (r11.equals("updateSessionConfig") == false) goto L91;
        if (r12 == null) goto L66;
        Long r18 = Long.valueOf(r12.getLong(DBDefinition.TASK_ID));
        if (((Number) ZeusTransformUtils.preCheckCast(r18, Number.class, "com.obric.aiagent.plugin")).longValue() != 0) goto L61;
        r2 = false;
    L61:
        if (r2 == true) goto L64;
        r18 = null;
    L64:
        if (r18 == null) goto L66;
        this.session.setTaskId(((Number) ZeusTransformUtils.preCheckCast(r18, Number.class, "com.obric.aiagent.plugin")).longValue());
    L66:
        if (r12 == null) goto L91;
        this.session.setCanFrontShow(Boolean.valueOf(r12.getBoolean("canFrontShow")));
        goto L91
    L69:
        if (r11.equals("onWidgetShow") == false) goto L91;
        handleWidgetOnShow(r12, this.session);
        goto L91
    L73:
        if (r11.equals("onFlagsChange") == false) goto L91;
        this.mainHandler.post(new $$Lambda$ClientCallback$cizCpi22pv2i9PQPXZ91nUwcN3A(r12, this));
        goto L91
    L77:
        if (r11.equals("hasCardClick") == false) goto L91;
        return handleHasCardClick(r12, this.session);
    L82:
        if (r11.equals("onViewClick") == false) goto L91;
        return handleViewOnClick(r12, this.session);
    L87:
        if (r11.equals("customEvent") == false) goto L91;
        return handleCustomEvent(r12, this.session);
    L91:
        return null;
    }

    private static final void onCardEvent$lambda$26(Bundle r2, ClientCallback r3) {
        o.e(r3, "this$0");
        if (r2 == null) goto L6;
        long r0 = r2.getLong("flags");
        r3.session.setFlags(r0);
        return;
    }

    private static final void onCardEvent$lambda$28(ClientCallback r1, Bundle r2) {
        o.e(r1, "this$0");
        if (r1.session.getCallback() != null) goto L5;
        return;
    L5:
        if (r2 == null) goto L8;
        int r3 = r2.getInt("status");
        r1.session.getCallback().onSessionStatusChanged(r1.session, r3);
        return;
    }

    @Override // com.obric.livecard.api.IIslandCardCallback
    public Bundle hasViewClickId(String r4) {
        Bundle r0 = new Bundle();
        a<x> r1 = null;
        if (r4 == null) goto L18;
        IslandWidget r2 = this.session.getCurrWidget();
        if (r2 == null) goto L10;
        a<x> r3 = r2.findOnViewClickCallbackById(r4);
        if (r3 == null) goto L10;
    L9:
        r1 = r3;
    L10:
        IslandWidget r5 = this.session.getCollapseWidget();
        if (r5 == null) goto L13;
        r3 = r5.findOnViewClickCallbackById(r4);
    L14:
        if (r3 != null) goto L9;
        IslandWidget r6 = this.session.getExpandWidget();
        if (r6 == null) goto L18;
        r1 = r6.findOnViewClickCallbackById(r4);
        goto L18
    L13:
        r3 = null;
    L18:
        if (r1 == null) goto L20;
        boolean r7 = true;
    L21:
        r0.putBoolean("result", r7);
        return r0;
    L20:
        r7 = false;
        goto L21
    }

    private final Bundle handleHasCardClick(Bundle r4, IslandSession r5) {
        a<x> r3 = null;
        if (r4 == null) goto L31;
        String r6 = r4.getString("templateId");
        if (r6 == null) goto L32;
        IslandWidget r0 = r5.getCollapseWidget();
        if (r0 == null) goto L9;
        String r1 = r0.getTemplateId();
    L10:
        boolean r2 = true;
        if (o.a(r6, r1) == false) goto L17;
        IslandWidget r7 = r5.getCollapseWidget();
        if (r7 == null) goto L15;
        r3 = r7.getOnCardClickCallback();
    L15:
        if (r3 != null) goto L29;
    L28:
        r2 = false;
    L29:
        Bundle r8 = new Bundle();
        r8.putBoolean("result", r2);
        return r8;
    L17:
        IslandWidget r9 = r5.getExpandWidget();
        if (r9 == null) goto L20;
        String r10 = r9.getTemplateId();
    L22:
        if (o.a(r6, r10) == false) goto L28;
        IslandWidget r11 = r5.getExpandWidget();
        if (r11 == null) goto L26;
        r3 = r11.getOnCardClickCallback();
    L26:
        if (r3 == null) goto L28;
    L20:
        r10 = null;
        goto L22
    L9:
        r1 = null;
        goto L10
    L32:
        return null;
    L31:
        return null;
    }

    private final Bundle handleCardOnClick(Bundle r3, IslandSession r4) {
        String r2 = null;
        if (r3 == null) goto L22;
        String r5 = r3.getString("templateId");
        if (r5 == null) goto L23;
        IslandWidget r0 = r4.getCollapseWidget();
        if (r0 == null) goto L9;
        String r1 = r0.getTemplateId();
    L11:
        if (o.a(r5, r1) == false) goto L13;
        boolean r6 = ((Boolean) ZeusTransformUtils.preCheckCast(ClientCallbackKt.runOnMainThreadBlock((a) ZeusTransformUtils.preCheckCast(new ClientCallback$handleCardOnClick$1$handled$1(r4), a.class, "com.obric.aiagent.plugin")), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L20:
        Bundle r7 = new Bundle();
        r7.putBoolean("handled", r6);
        return r7;
    L13:
        IslandWidget r8 = r4.getExpandWidget();
        if (r8 == null) goto L17;
        r2 = r8.getTemplateId();
    L17:
        if (o.a(r5, r2) == false) goto L19;
        r6 = ((Boolean) ZeusTransformUtils.preCheckCast(ClientCallbackKt.runOnMainThreadBlock((a) ZeusTransformUtils.preCheckCast(new ClientCallback$handleCardOnClick$1$handled$2(r4), a.class, "com.obric.aiagent.plugin")), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        goto L20
    L19:
        r6 = false;
        goto L20
    L9:
        r1 = null;
        goto L11
    L23:
        return null;
    L22:
        return null;
    }

    private final void handleWidgetOnShow(Bundle r2, IslandSession r3) {
        if (r2 == null) goto L26;
        String r1 = r2.getString("templateId");
        if (r1 == null) goto L27;
        IslandWidget r4 = r3.getCollapseWidget();
        if (r4 == null) goto L8;
        String r5 = r4.getTemplateId();
    L10:
        if (o.a(r1, r5) == false) goto L12;
        r3.setCurrWidget(r3.getCollapseWidget());
    L20:
        IslandWidget r6 = r3.getCurrWidget();
        if (r6 == null) goto L28;
        IslandCardCallback r7 = r3.getCallback();
        if (r7 == null) goto L29;
        r7.onWidgetShow(r6);
        return;
    L29:
        return;
    L28:
        return;
    L12:
        IslandWidget r8 = r3.getExpandWidget();
        if (r8 == null) goto L15;
        String r9 = r8.getTemplateId();
    L17:
        if (o.a(r1, r9) == false) goto L19;
        r3.setCurrWidget(r3.getExpandWidget());
        goto L20
    L19:
        r3.setCurrWidget(null);
        goto L20
    L15:
        r9 = null;
        goto L17
    L8:
        r5 = null;
        goto L10
    L27:
        return;
    }

    private final Bundle handleViewOnClick(Bundle r5, IslandSession r6) {
        if (r5 == null) goto L30;
        String r0 = r5.getString("viewId");
        if (r0 == null) goto L30;
        String r7 = r5.getString("templateId");
        a<x> r2 = null;
        if (r7 == null) goto L24;
        IslandWidget r3 = r6.getCollapseWidget();
        if (r3 == null) goto L11;
        String r4 = r3.getTemplateId();
    L13:
        if (o.a(r4, r7) == false) goto L15;
        IslandWidget r8 = r6.getCollapseWidget();
    L23:
        if (r8 == null) goto L24;
    L25:
        if (r8 == null) goto L27;
        r2 = r8.findOnViewClickCallbackById(r0);
    L27:
        ClientCallbackKt.runOnMainThreadBlock((a) ZeusTransformUtils.preCheckCast(new ClientCallback$handleViewOnClick$1$1(r2), a.class, "com.obric.aiagent.plugin"));
        Bundle r9 = new Bundle();
        if (r2 != null) goto L32;
        r9.putString("error_message", "client not register click listener");
        return r9;
    L32:
        return r9;
    L15:
        IslandWidget r10 = r6.getExpandWidget();
        if (r10 == null) goto L18;
        String r11 = r10.getTemplateId();
    L20:
        if (o.a(r11, r7) == false) goto L22;
        r8 = r6.getExpandWidget();
        goto L23
    L22:
        r8 = (IslandWidget) ZeusTransformUtils.preCheckCast(null, IslandWidget.class, "com.obric.aiagent.plugin");
        goto L23
    L18:
        r11 = null;
        goto L20
    L11:
        r4 = null;
    L24:
        r8 = r6.getCurrWidget();
    L30:
        Bundle r12 = new Bundle();
        r12.putString("error_message", "not found viewId");
        return r12;
    }

    @Override // com.obric.livecard.api.IIslandCardCallback.Stub, android.os.IInterface
    public IBinder asBinder() {
        return (IBinder) ZeusTransformUtils.preCheckCast(this, IBinder.class, "com.obric.aiagent.plugin");
    }
}
