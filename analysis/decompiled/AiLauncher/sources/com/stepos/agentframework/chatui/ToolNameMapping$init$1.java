package com.stepos.agentframework.chatui;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatui.ToolNameMapping$init$1", f = "ToolNameMapping.kt", l = {58}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ToolNameMapping$init$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int label;

    public ToolNameMapping$init$1(InterfaceC4014c<? super ToolNameMapping$init$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ToolNameMapping$init$1(interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ToolNameMapping$init$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            ToolNameMapping toolNameMapping = ToolNameMapping.INSTANCE;
            this.label = 1;
            obj = toolNameMapping.g(this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        Map map = (Map) obj;
        ToolNameMapping.cachedMap = map;
        C4148a.d("ToolNameMapping", "name map loaded: " + map.size() + " entries", false, 4, null);
        ToolNameMapping toolNameMapping2 = ToolNameMapping.INSTANCE;
        InterfaceC5063a<Y8.t> interfaceC5063aD = toolNameMapping2.d();
        toolNameMapping2.k(null);
        if (interfaceC5063aD != null) {
            Function2.b(new ToolNameMapping$init$1$1$1(interfaceC5063aD, null));
        }
        return Y8.t.f7040a;
    }
}
