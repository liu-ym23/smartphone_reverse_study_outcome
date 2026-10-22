package com.bytedance.ai.debugscene;

import android.content.Context;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.jsbridge.LynxModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J&\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/debugscene/DoubaoJsbDebugLynxModule;", "Lcom/lynx/jsbridge/LynxModule;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "param", "", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "runtimeHandle", "Lcom/bytedance/ai/debugscene/JsbDebugRuntimeHandle;", "panelMessageDispatcher", "Lcom/bytedance/ai/debugscene/AIDebugPanelMessageDispatcher;", "postMessage", "", "channel", "", "message", "Lcom/lynx/react/bridge/ReadableMap;", "postPanelMessage", "type", "callback", "Lcom/lynx/react/bridge/Callback;", "ai-sdk-debug-scene_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoJsbDebugLynxModule extends LynxModule {
    private final k0 panelMessageDispatcher;
    private final q2 runtimeHandle;

    public static /* synthetic */ void a(Callback r100, int r101, String r102, String r103) {
        postPanelMessage$lambda$1(r100, r101, r102, r103);
    }

    public DoubaoJsbDebugLynxModule(Context r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        k0 r102 = null;
        if ((r101 instanceof q2) == false) goto L5;
        q2 r103 = (q2) r101;
    L6:
        this.runtimeHandle = r103;
        if ((r101 instanceof k0) == false) goto L9;
        r102 = (k0) r101;
    L9:
        this.panelMessageDispatcher = r102;
        return;
    L5:
        r103 = null;
        goto L6
    }

    @LynxMethod
    public final void postMessage(String r100, ReadableMap r101) {
        Function2<? super q2, ? super String, Unit> r102 = p2.f36473a;
        q2 r103 = this.runtimeHandle;
        if (r101 == null) goto L5;
        String r104 = m4.f.b(r101).toString();
    L7:
        if (Intrinsics.areEqual(r100, "doubao_jsb_debug") == true) goto L9;
        com.bytedance.ai.utils.g.f37637a.w("JsbDebugNativeChannel", "ignore message from unexpected channel: " + r100);
        return;
    L9:
        if (r104 != null) goto L11;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == false) goto L17;
        com.bytedance.ai.utils.g.f37637a.w("JsbDebugNativeChannel", "ignore empty JSB debug message");
        return;
    L17:
        if (r103 != null) goto L19;
        com.bytedance.ai.utils.g.f37637a.w("JsbDebugNativeChannel", "drop JSB debug message without runtime handle");
        return;
    L19:
        com.bytedance.ai.utils.g r106 = com.bytedance.ai.utils.g.f37637a;
        r106.d("JsbDebugNativeChannel", "receive runtime message, handle:" + r103.f36484a + ", messageLength:" + r104.length());
        Function2<? super q2, ? super String, Unit> r107 = p2.f36473a;
        if (r107 == null) goto L22;
        r107.invoke(r103, r104);
        return;
    L22:
        r106.w("JsbDebugNativeChannel", "JSB debug handler is not active");
        return;
    L11:
        if (StringsKt.isBlank(r104) == true) goto L14;
        r105 = false;
        goto L15
    L5:
        r104 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.ai.debugscene.o2] */
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
    @LynxMethod
    public final void postPanelMessage(String r100, String r101, final Callback r102) {
        ?? r103 = new o2(r102);
        boolean r104 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r105 = true;
    L10:
        if (r105 == true) goto L23;
        if (r101 != null) goto L13;
    L16:
        if (r104 == true) goto L23;
        k0 r106 = this.panelMessageDispatcher;
        if (r106 == 0) goto L21;
        r106.a(r100, r101, r103);
        return;
    L21:
        r103.a(-2, "MESSAGE_TYPE_NOT_REGISTERED", null);
        return;
    L13:
        if (StringsKt.isBlank(r101) == true) goto L16;
        r104 = false;
    L23:
        r103.a(-3, "INVALID_PARAM", null);
        return;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r105 = false;
        goto L10
    }

    private static final void postPanelMessage$lambda$1(Callback r100, int r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "msg");
        if (r100 == null) goto L6;
        JavaOnlyMap r104 = new JavaOnlyMap();
        r104.putInt("code", r101);
        r104.putString("msg", r102);
        r104.putString("data", r103);
        Unit r105 = Unit.INSTANCE;
        r100.invoke(new Object[]{r104});
        return;
    }
}
