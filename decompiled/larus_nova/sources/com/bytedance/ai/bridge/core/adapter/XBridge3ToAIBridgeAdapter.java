package com.bytedance.ai.bridge.core.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.core.util.Consumer;
import bx7.b;
import com.bytedance.ai.applet.base.gson.c;
import com.bytedance.ai.bridge.core.AIBridgeMethod;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import d3.a0;
import e3.d;
import f2.k;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J6\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ai/bridge/core/adapter/XBridge3ToAIBridgeAdapter;", "Lcom/bytedance/ai/bridge/core/AIBridgeMethod;", "bridgeMethod", "Lcom/ivy/ivykit/api/bridge/core/IvyBridgeMethodInvoker;", "<init>", "(Lcom/ivy/ivykit/api/bridge/core/IvyBridgeMethodInvoker;)V", "name", "", "getName", "()Ljava/lang/String;", "realHandle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/google/gson/JsonObject;", JSEventListener.ACTION_RESOLVE, "Landroidx/core/util/Consumer;", "reject", "Lcom/bytedance/ai/bridge/core/AIBridgeMethod$Error;", "mustRunInMain", "", "AIBridgeCallContext", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class XBridge3ToAIBridgeAdapter implements AIBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f35251a;

    public static final class a implements bx7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f35252a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f35253b;

        @Override // bx7.a
        public final View getEngineView() {
            return this.f35252a.getEngineView();
        }

        @Override // bx7.a
        public final Activity getOwnerActivity() {
            Activity r100 = this.f35252a.getOwnerActivity();
            if (r100 != null) goto L12;
            View r101 = getEngineView();
            if (r101 == null) goto L7;
            Context r102 = r101.getContext();
        L8:
            Activity r103 = getActivity(r102);
            if (r103 == null) goto L11;
            return r103;
        L11:
            return k.b();
        L7:
            r102 = null;
            goto L8
        L12:
            return r100;
        }

        public a(d r100) {
            Intrinsics.checkNotNullParameter(r100, "bridgeContext");
            this.f35252a = r100;
            a0 r101 = r100.getContainerContext();
            if (r101 == null) goto L6;
            String r102 = r101.getContainerId();
            if (r102 == null) goto L6;
        L7:
            this.f35253b = r102;
            return;
        L6:
            r102 = "";
            goto L7
        }

        private final Activity getActivity(Context r100) {
        L3:
            if (r100 == null) goto L11;
            if ((r100 instanceof Activity) == true) goto L7;
            if ((r100 instanceof ContextWrapper) == false) goto L11;
            r100 = ((ContextWrapper) r100).getBaseContext();
            goto L3
        L7:
            return (Activity) r100;
        L11:
            return null;
        }

        @Override // bx7.a
        public final <T> T getService(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "clazz");
            return (T) this.f35252a.d(r100);
        }

        @Override // bx7.a
        public final void sendEvent(String r100, Map<String, ? extends Object> r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            JsonElement r102 = GsonProtectorUtils.toJsonTree(c.a(), r101);
            if ((r102 instanceof JsonObject) == false) goto L5;
            JsonObject r103 = (JsonObject) r102;
        L6:
            this.f35252a.a(r100, r103);
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final List<String> getAltNames() {
        return null;
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return false;
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f35251a.getName();
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        com.bytedance.ai.settings.a<Integer> r100 = com.bytedance.ai.settings.b.f37574a;
        if (com.bytedance.ai.settings.b.f37582i.a().contains(getName()) == false) goto L6;
        return true;
    L6:
        if (this.f35251a.b() == false) goto L11;
        return false;
    L11:
        return true;
    }

    public XBridge3ToAIBridgeAdapter(b r100) {
        Intrinsics.checkNotNullParameter(r100, "bridgeMethod");
        this.f35251a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [g3.a] */
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
    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final void realHandle(d r100, JsonObject r101, final Consumer<JsonObject> r102, final Consumer<AIBridgeMethod.Error> r103) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, JSEventListener.ACTION_RESOLVE);
        Intrinsics.checkNotNullParameter(r103, "reject");
        int r104 = gx7.a.f483121a;
        if (r101 != null) goto L5;
        r101 = new JsonObject();
    L5:
        Map r105 = gx7.a.b(new JSONObject(r101.toString()));
        this.f35251a.a(new a(r100), r105, new g3.a(this, r102, r103));
    }
}
