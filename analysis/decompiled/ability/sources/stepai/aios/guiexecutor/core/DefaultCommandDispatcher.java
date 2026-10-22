package stepai.aios.guiexecutor.core;

import D7.v;
import J7.c;
import N9.j;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;
import stepai.aios.guiexecutor.api.GuiCommandHandler;
import stepai.aios.guiexecutor.api.GuiCommandType;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u000b¢\u0006\u0004\b\u001d\u0010\u0003R \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lstepai/aios/guiexecutor/core/DefaultCommandDispatcher;", "Lstepai/aios/guiexecutor/core/CommandDispatcher;", AppAgent.CONSTRUCT, "()V", "Lstepai/aios/guiexecutor/api/GuiCommand;", "command", "Lstepai/aios/guiexecutor/api/GuiResult;", "dispatch", "(Lstepai/aios/guiexecutor/api/GuiCommand;LH7/c;)Ljava/lang/Object;", "Lstepai/aios/guiexecutor/api/GuiCommandHandler;", "handler", "LC7/r;", "registerHandler", "(Lstepai/aios/guiexecutor/api/GuiCommandHandler;)V", "Lstepai/aios/guiexecutor/api/GuiCommandType;", "commandType", "unregisterHandler", "(Lstepai/aios/guiexecutor/api/GuiCommandType;)V", "", "isSupported", "(Lstepai/aios/guiexecutor/api/GuiCommandType;)Z", "", "getSupportedTypes", "()Ljava/util/Set;", "getHandler", "(Lstepai/aios/guiexecutor/api/GuiCommandType;)Lstepai/aios/guiexecutor/api/GuiCommandHandler;", "", "getAllHandlers", "()Ljava/util/Map;", "clear", "Ljava/util/concurrent/ConcurrentHashMap;", "handlers", "Ljava/util/concurrent/ConcurrentHashMap;", "Companion", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultCommandDispatcher implements CommandDispatcher {
    private static final String TAG = "CommandDispatcher";
    private final ConcurrentHashMap<GuiCommandType, GuiCommandHandler> handlers = new ConcurrentHashMap<>();

    @c(c = "stepai.aios.guiexecutor.core.DefaultCommandDispatcher", f = "CommandDispatcher.kt", l = {98}, m = "dispatch", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiexecutor.core.DefaultCommandDispatcher$dispatch$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultCommandDispatcher.this.dispatch(null, this);
        }
    }

    public final void clear() {
        int size = this.handlers.size();
        this.handlers.clear();
        j.H("Cleared " + size + " handlers", TAG);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    @Override // stepai.aios.guiexecutor.core.CommandDispatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object dispatch(stepai.aios.guiexecutor.api.GuiCommand r24, H7.c<? super stepai.aios.guiexecutor.api.GuiResult> r25) {
        /*
            Method dump skipped, instructions count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiexecutor.core.DefaultCommandDispatcher.dispatch(stepai.aios.guiexecutor.api.GuiCommand, H7.c):java.lang.Object");
    }

    public final Map<GuiCommandType, GuiCommandHandler> getAllHandlers() {
        return a.Y(this.handlers);
    }

    public final GuiCommandHandler getHandler(GuiCommandType commandType) {
        k.f(commandType, "commandType");
        return this.handlers.get(commandType);
    }

    @Override // stepai.aios.guiexecutor.core.CommandDispatcher
    public Set<GuiCommandType> getSupportedTypes() {
        Set<GuiCommandType> setKeySet = this.handlers.keySet();
        k.e(setKeySet, "<get-keys>(...)");
        return v.j1(setKeySet);
    }

    @Override // stepai.aios.guiexecutor.core.CommandDispatcher
    public boolean isSupported(GuiCommandType commandType) {
        k.f(commandType, "commandType");
        return this.handlers.containsKey(commandType);
    }

    @Override // stepai.aios.guiexecutor.core.CommandDispatcher
    public void registerHandler(GuiCommandHandler handler) {
        k.f(handler, "handler");
        if (this.handlers.put(handler.getSupportedType(), handler) != null) {
            j.J("Replaced existing handler for " + handler.getSupportedType(), TAG);
        }
        j.H("Registered handler for " + handler.getSupportedType(), TAG);
    }

    @Override // stepai.aios.guiexecutor.core.CommandDispatcher
    public void unregisterHandler(GuiCommandType commandType) {
        k.f(commandType, "commandType");
        if (this.handlers.remove(commandType) != null) {
            j.H("Unregistered handler for " + commandType, TAG);
        } else {
            j.J("No handler found to unregister for " + commandType, TAG);
        }
    }
}
