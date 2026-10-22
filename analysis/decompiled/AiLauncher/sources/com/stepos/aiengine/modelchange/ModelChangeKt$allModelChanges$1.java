package com.stepos.aiengine.modelchange;

import Wa.s;
import Y8.t;
import com.stepos.aiengine.modelchange.ModelChangeEvent;
import com.stepos.core.deepbinder.IAIEngineDeepBinderService;
import com.stepos.core.deepbinder.IModelChangeListener;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.UUID;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.channels.ProduceKt;
import p9.InterfaceC5063a;
import p9.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LWa/p;", "Lcom/stepos/aiengine/modelchange/ModelChangeEvent;", "LY8/t;", "<anonymous>", "(LWa/p;)V"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.aiengine.modelchange.ModelChangeKt$allModelChanges$1", f = "ModelChange.kt", l = {137}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class ModelChangeKt$allModelChanges$1 extends SuspendLambda implements p<Wa.p<? super ModelChangeEvent>, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f23827a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f23828b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IAIEngineDeepBinderService f23829c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelChangeKt$allModelChanges$1(IAIEngineDeepBinderService iAIEngineDeepBinderService, InterfaceC4014c<? super ModelChangeKt$allModelChanges$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f23829c = iAIEngineDeepBinderService;
    }

    public static final t h(Wa.p pVar, IAIEngineDeepBinderService iAIEngineDeepBinderService, String str) {
        try {
            Result.Companion companion = Result.INSTANCE;
            iAIEngineDeepBinderService.unregisterGlobalModelChangeListener(str);
            Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        return t.f7040a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ModelChangeKt$allModelChanges$1 modelChangeKt$allModelChanges$1 = new ModelChangeKt$allModelChanges$1(this.f23829c, interfaceC4014c);
        modelChangeKt$allModelChanges$1.f23828b = obj;
        return modelChangeKt$allModelChanges$1;
    }

    @Override // p9.p
    public final Object invoke(Wa.p<? super ModelChangeEvent> pVar, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ModelChangeKt$allModelChanges$1) create(pVar, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f23827a;
        if (i10 == 0) {
            C4849c.b(obj);
            final Wa.p pVar = (Wa.p) this.f23828b;
            final String str = "flow-global-" + UUID.randomUUID();
            this.f23829c.registerGlobalModelChangeListener(str, new IModelChangeListener() { // from class: com.stepos.aiengine.modelchange.ModelChangeKt$allModelChanges$1$listener$1
                @Override // com.stepos.core.deepbinder.IModelChangeListener
                public void onModelChanged(String abilityId, int oldVersion, int newVersion, String installer) {
                    kotlin.jvm.internal.p.i(abilityId, "abilityId");
                    kotlin.jvm.internal.p.i(installer, "installer");
                    pVar.mo0trySendJP2dKIU(new ModelChangeEvent.Changed(abilityId, oldVersion, newVersion, installer, 0L, 16, null));
                }

                @Override // com.stepos.core.deepbinder.IModelChangeListener
                public void onModelRollback(String abilityId, int fromVersion, int toVersion, String reason) {
                    kotlin.jvm.internal.p.i(abilityId, "abilityId");
                    kotlin.jvm.internal.p.i(reason, "reason");
                    pVar.mo0trySendJP2dKIU(new ModelChangeEvent.Rollback(abilityId, fromVersion, toVersion, reason, 0L, 16, null));
                }

                @Override // com.stepos.core.deepbinder.IModelChangeListener
                public void onRecycle() {
                    s.a(pVar, null, 1, null);
                }
            });
            final IAIEngineDeepBinderService iAIEngineDeepBinderService = this.f23829c;
            InterfaceC5063a interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.aiengine.modelchange.a
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return ModelChangeKt$allModelChanges$1.h(pVar, iAIEngineDeepBinderService, str);
                }
            };
            this.f23827a = 1;
            if (ProduceKt.a(pVar, interfaceC5063a, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return t.f7040a;
    }
}
