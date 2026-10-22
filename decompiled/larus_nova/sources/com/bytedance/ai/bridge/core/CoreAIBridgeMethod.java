package com.bytedance.ai.bridge.core;

import androidx.core.util.Consumer;
import com.alipay.sdk.m.p.e;
import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import e3.d;
import f3.g;
import f3.h;
import f3.i;
import f3.j;
import f3.n;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J6\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000fH\u0016J+\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H&¢\u0006\u0002\u0010\u0015J#\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u00172\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0015\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u001a\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010!\u001a\u00020\"2\u0006\u0010%\u001a\u00020 H\u0002J\b\u0010&\u001a\u00020'H\u0016¨\u0006("}, d2 = {"Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Param", "Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", "Result", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "Lcom/bytedance/ai/bridge/core/AIBridgeMethod;", "<init>", "()V", "realHandle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/google/gson/JsonObject;", JSEventListener.ACTION_RESOLVE, "Landroidx/core/util/Consumer;", "reject", "Lcom/bytedance/ai/bridge/core/AIBridgeMethod$Error;", "handle", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "(Lcom/bytedance/ai/bridge/context/IAIBridgeContext;Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;Lcom/bytedance/ai/bridge/core/CompletionBlock;)V", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "(Lcom/bytedance/ai/bridge/context/IAIBridgeContext;Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;)Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "realHandleSync", "createParamModelProxy", "dataSource", "(Lcom/google/gson/JsonObject;)Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", "getParamClazz", "Ljava/lang/Class;", "getParamFieldModel", "Lcom/bytedance/ai/bridge/core/ParamFieldModel;", e.f25671s, "Ljava/lang/reflect/Method;", "parseDefaultValue", "", "paramFieldModel", "mustRunInMain", "", "applet-bridge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class CoreAIBridgeMethod<Param extends ParamModel, Result extends ResultModel> implements AIBridgeMethod {

    public static final class a implements h<Result> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Consumer<JsonObject> f35240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JsonObject f35241b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Consumer<AIBridgeMethod.Error> f35242c;

        @Override // f3.h
        public final void a(String r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            if ((r101 instanceof String) == false) goto L6;
            this.f35241b.addProperty(r100, (String) r101);
            return;
        L6:
            if ((r101 instanceof Number) == false) goto L9;
            this.f35241b.addProperty(r100, (Number) r101);
            return;
        L9:
            if ((r101 instanceof Boolean) == false) goto L14;
            this.f35241b.addProperty(r100, (Boolean) r101);
            return;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // f3.h
        public final void b(Result r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Intrinsics.checkNotNullParameter(r101, "msg");
            JsonObject r102 = r100.toJson();
            Consumer<JsonObject> r103 = this.f35240a;
            JsonObject r104 = new JsonObject();
            JsonObject r105 = this.f35241b;
            r104.addProperty("code", 1);
            r104.add("data", r102);
            r104.addProperty("msg", r101);
            f3.a r106 = f3.a.f475263d;
            r104.addProperty("errNo", Integer.valueOf(r106.f475285a));
            r104.addProperty("errMsg", r106.f475286b);
            if (r105.size() <= 0) goto L5;
            r104.add("extras", r105);
        L5:
            r103.accept(r104);
        }

        public a(Consumer<JsonObject> r100, JsonObject r101, Consumer<AIBridgeMethod.Error> r102) {
            this.f35240a = r100;
            this.f35241b = r101;
            this.f35242c = r102;
        }

        @Override // f3.h
        public final void c(String r100, int r101, f3.a r102, JsonObject r103) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            Consumer<AIBridgeMethod.Error> r104 = this.f35242c;
            AIBridgeMethod.Error r105 = new AIBridgeMethod.Error(r101, r100, r103, r102);
            JsonObject r106 = this.f35241b;
            if (r106.size() <= 0) goto L5;
            r105.setExtras(r106);
        L5:
            r104.accept(r105);
        }
    }

    public CoreAIBridgeMethod() {
    }

    public static /* synthetic */ Object a(JsonObject r100, CoreAIBridgeMethod r101, Object r102, Method r103, Object[] r104) {
        return createParamModelProxy$lambda$7(r100, r101, r102, r103, r104);
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public List<String> getAltNames() {
        return null;
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public boolean getSupportSyncCall() {
        return false;
    }

    public abstract void handle(d r100, Param r101, h<Result> r102);

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public boolean mustRunInMain() {
        return false;
    }

    private final Class<?> getParamClazz() {
        ConcurrentHashMap<Class<? extends AIBridgeMethod>, f3.d> r100 = g.f475311a;
        Class<?> r101 = getClass();
        Intrinsics.checkNotNullParameter(r101, "clazz");
        f3.d r102 = g.f475311a.get(r101);
        if (r102 == null) goto L5;
        Class<?> r103 = r102.f475304a;
    L6:
        if (r103 == null) goto L8;
        return r103;
    L8:
        Class<?>[] r104 = getClass().getDeclaredClasses();
        ArrayList r105 = new ArrayList();
        int r106 = r104.length;
        int r107 = 0;
    L9:
        boolean r108 = true;
        if (r107 >= r106) goto L19;
        Class<?> r109 = r104[r107];
        if (r109.getAnnotation(AIBridgeParamModel.class) != null) goto L15;
        r108 = false;
    L15:
        if (r108 == false) goto L17;
        r105.add(r109);
    L17:
        r107 = r107 + 1;
        goto L9
    L19:
        if (r105.isEmpty() == false) goto L35;
        Class<?>[] r110 = getClass().getSuperclass().getDeclaredClasses();
        r105 = new ArrayList();
        int r111 = r110.length;
        int r112 = 0;
    L21:
        if (r112 >= r111) goto L30;
        Class<?> r113 = r110[r112];
        if (r113.getAnnotation(AIBridgeParamModel.class) == null) goto L25;
        boolean r114 = true;
    L26:
        if (r114 == false) goto L28;
        r105.add(r113);
    L28:
        r112 = r112 + 1;
        goto L21
    L25:
        r114 = false;
        goto L26
    L30:
        if (r105.isEmpty() == false) goto L35;
        throw new IllegalStateException("Illegal class format, no param model is defined in class");
    L35:
        return (Class) CollectionsKt.first(r105);
    L5:
        r103 = null;
        goto L6
    }

    private final Param createParamModelProxy(final JsonObject r100) {
        Class<?> r101 = getParamClazz();
        if (r101 == null) goto L7;
        Object r102 = Proxy.newProxyInstance(r101.getClassLoader(), new Class[]{r101}, new i(r100, this));
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type Param of com.bytedance.ai.bridge.core.CoreAIBridgeMethod");
        return (Param) r102;
    L7:
        throw new AIBridgeMethod.InvalidParamsError("Illegal class format, no param model is defined in class");
    }

    private final n getParamFieldModel(Method r110) {
        ConcurrentHashMap<Class<? extends AIBridgeMethod>, f3.d> r100 = g.f475311a;
        Class<?> r101 = getClass();
        Intrinsics.checkNotNullParameter(r101, "clazz");
        f3.d r102 = g.f475311a.get(r101);
        if (r102 == null) goto L7;
        f3.e r103 = r102.f475306c;
        if (r103 == null) goto L7;
        HashMap<Method, n> r104 = r103.f475309a;
    L8:
        if (r104 == null) goto L12;
        n r105 = r104.get(r110);
        if (r105 == null) goto L12;
        return r105;
    L12:
        AIBridgeParamField r111 = (AIBridgeParamField) r110.getAnnotation(AIBridgeParamField.class);
        if (r111 == null) goto L17;
        AIBridgeDefaultValue r106 = r111.defaultValue();
        return new n(r111.required(), r111.keyPath(), new j(r106.type(), r106.doubleValue(), r106.stringValue(), r106.intValue(), r106.boolValue(), r106.longValue()));
    L17:
        throw new IllegalStateException("annotation ParamField not found");
    L7:
        r104 = null;
        goto L8
    }

    private final Object parseDefaultValue(Method r100, n r101) {
        Class<?> r102 = r100.getReturnType();
        if (Intrinsics.areEqual(r102, Integer.TYPE) == true) goto L33;
        if (Intrinsics.areEqual(r102, Integer.class) == true) goto L33;
        if (Intrinsics.areEqual(r102, Double.TYPE) == true) goto L38;
        if (Intrinsics.areEqual(r102, Double.class) == true) goto L38;
        if (Intrinsics.areEqual(r102, Long.TYPE) == true) goto L37;
        if (Intrinsics.areEqual(r102, Long.class) == true) goto L37;
        if (Intrinsics.areEqual(r102, Boolean.TYPE) == true) goto L36;
        if (Intrinsics.areEqual(r102, Boolean.class) == true) goto L36;
        if (Intrinsics.areEqual(r102, String.class) == true) goto L35;
        if (Intrinsics.areEqual(r102, String.class) == true) goto L35;
        return null;
    L35:
        return r101.f475325c.f475317c;
    L36:
        return Boolean.valueOf(r101.f475325c.f475319e);
    L37:
        return Long.valueOf(r101.f475325c.f475320f);
    L38:
        return Double.valueOf(r101.f475325c.f475316b);
    L33:
        return Integer.valueOf(r101.f475325c.f475318d);
    }

    public com.bytedance.ai.bridge.core.a<Result> handleSync(d r100, Param r101) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        int r102 = com.bytedance.ai.bridge.core.a.f35243a;
        return com.bytedance.ai.bridge.core.a.C0684a.a(0, "sync call is not supported");
    }

    public final JsonObject realHandleSync(d r100, JsonObject r101) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        if (r101 != null) goto L5;
        r101 = new JsonObject();
    L5:
        com.bytedance.ai.bridge.core.a<Result> r102 = handleSync(r100, createParamModelProxy(r101));
        if ((r102 instanceof com.bytedance.ai.bridge.core.a.c) == false) goto L9;
        JsonObject r103 = new JsonObject();
        r103.addProperty("code", 1);
        com.bytedance.ai.bridge.core.a.c r104 = (com.bytedance.ai.bridge.core.a.c) r102;
        r103.add("data", ((BaseModel) r104.f35249b).toJson());
        r103.addProperty("msg", r104.f35250c);
        f3.a r105 = f3.a.f475263d;
        r103.addProperty("errNo", Integer.valueOf(r105.f475285a));
        r103.addProperty("errMsg", r105.f475286b);
        return r103;
    L9:
        if ((r102 instanceof com.bytedance.ai.bridge.core.a.b) == false) goto L18;
        JsonObject r106 = new JsonObject();
        com.bytedance.ai.bridge.core.a.b r107 = (com.bytedance.ai.bridge.core.a.b) r102;
        r106.addProperty("code", Integer.valueOf(r107.f35244b));
        r106.addProperty("msg", r107.f35245c);
        JsonObject r108 = r107.f35246d;
        if (r108 == null) goto L13;
        r106.add("data", r108);
    L13:
        f3.a r109 = r107.f35247e;
        if (r109 == null) goto L20;
        r106.addProperty("errNo", Integer.valueOf(r109.f475285a));
        r106.addProperty("errMsg", r109.f475286b);
        return r106;
    L20:
        return r106;
    L18:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public void realHandle(d r100, JsonObject r101, Consumer<JsonObject> r102, Consumer<AIBridgeMethod.Error> r103) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, JSEventListener.ACTION_RESOLVE);
        Intrinsics.checkNotNullParameter(r103, "reject");
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L8
        if (r101 != null) goto L6;
        r101 = new JsonObject();     // Catch: Throwable -> L8
    L6:
        handle(r100, createParamModelProxy(r101), new a(r102, new JsonObject(), r103));     // Catch: Throwable -> L8
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 != null) goto L13;
        return;
    L13:
        if ((r106 instanceof AIBridgeMethod.Error) == false) goto L15;
        r103.accept(r106);
    L16:
        com.bytedance.ai.applet.base.log.b r107 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", "method:" + getName(), r106);
        return;
    L15:
        r103.accept(new AIBridgeMethod.Error(r106.getMessage(), null, 2, null));
    L8:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private static final Object createParamModelProxy$lambda$7(JsonObject r100, CoreAIBridgeMethod r101, Object r102, Method r103, Object[] r104) {
        if (Intrinsics.areEqual(r103.getName(), "toJson") == false) goto L5;
        return r100;
    L5:
        Intrinsics.checkNotNull(r103);
        n r105 = r101.getParamFieldModel(r103);
        if (r100.has(r105.f475324b) == false) goto L17;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L9
        Lazy r107 = com.bytedance.ai.applet.base.gson.e.f34515a;     // Catch: Throwable -> L9
        JsonElement r108 = r100.get(r105.f475324b);     // Catch: Throwable -> L9
        Type r109 = r103.getGenericReturnType();     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r109, "typeOfT");     // Catch: Throwable -> L9
        return GsonProtectorUtils.fromJson((Gson) com.bytedance.ai.applet.base.gson.e.f34515a.getValue(), r108, r109);
    L9:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Object r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 != null) goto L15;
        return Result.m9448boximpl(r111);
    L15:
        throw new AIBridgeMethod.InvalidParamsError("convert param:" + r105.f475324b + " error with msg:" + r112.getMessage());
    L17:
        if (r105.f475325c.getType() == DefaultType.NONE) goto L21;
        return r101.parseDefaultValue(r103, r105);
    L21:
        if (r105.f475323a == true) goto L25;
        return null;
    L25:
        throw new AIBridgeMethod.InvalidParamsError("can not find required param:" + r105.f475324b);
    }
}
