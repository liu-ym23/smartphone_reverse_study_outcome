package com.stepos.ailauncher.task.space;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.space.AmooMemoryFragment$loadMemorySetting$1", f = "AmooMemoryFragment.kt", l = {79}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AmooMemoryFragment$loadMemorySetting$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int label;
    final /* synthetic */ AmooMemoryFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmooMemoryFragment$loadMemorySetting$1(AmooMemoryFragment amooMemoryFragment, InterfaceC4014c<? super AmooMemoryFragment$loadMemorySetting$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = amooMemoryFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AmooMemoryFragment$loadMemorySetting$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AmooMemoryFragment$loadMemorySetting$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            MemorySettingApi memorySettingApi = MemorySettingApi.INSTANCE;
            this.label = 1;
            obj = memorySettingApi.L(this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        MemorySettingState memorySettingState = (MemorySettingState) obj;
        if (memorySettingState != null) {
            this.this$0.currentVersion = memorySettingState.getVersion();
            this.this$0.N().switchMemoryShare.setChecked(memorySettingState.getMemoryShareEnabled());
            C4148a.d("AILauncher-AmooMemory", "Loaded setting: enabled=" + memorySettingState.getMemoryShareEnabled() + ", version=" + memorySettingState.getVersion(), false, 4, null);
        } else {
            C4148a.u("AILauncher-AmooMemory", "Failed to load memory setting, using default", false, 4, null);
        }
        return Y8.t.f7040a;
    }
}
