package com.stepos.ailauncher.chat.fragment;

import android.content.Context;
import com.stepos.agentframework.chatui.AgentFileSyncBridge;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.FolderTreeFragment$onNodeClick$1", f = "FolderTreeFragment.kt", l = {112}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class FolderTreeFragment$onNodeClick$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $fileId;
    final /* synthetic */ p9.r<Context, AgentFileSyncBridge.Result, String, String, Y8.t> $launcher;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FolderTreeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FolderTreeFragment$onNodeClick$1(String str, FolderTreeFragment folderTreeFragment, p9.r<? super Context, ? super AgentFileSyncBridge.Result, ? super String, ? super String, Y8.t> rVar, InterfaceC4014c<? super FolderTreeFragment$onNodeClick$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$fileId = str;
        this.this$0 = folderTreeFragment;
        this.$launcher = rVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        FolderTreeFragment$onNodeClick$1 folderTreeFragment$onNodeClick$1 = new FolderTreeFragment$onNodeClick$1(this.$fileId, this.this$0, this.$launcher, interfaceC4014c);
        folderTreeFragment$onNodeClick$1.L$0 = obj;
        return folderTreeFragment$onNodeClick$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((FolderTreeFragment$onNodeClick$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        Ua.M m10 = (Ua.M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            p9.p<String, InterfaceC4014c<? super AgentFileSyncBridge.Result>, Object> pVarA = AgentFileSyncBridge.a();
            if (pVarA != null) {
                String str = this.$fileId;
                this.L$0 = m10;
                this.label = 1;
                obj = pVarA.invoke(str, this);
                if (obj == objG) {
                    return objG;
                }
            }
            return Y8.t.f7040a;
        }
        if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        AgentFileSyncBridge.Result result = (AgentFileSyncBridge.Result) obj;
        if (result != null) {
            if (!this.this$0.isAdded()) {
                return Y8.t.f7040a;
            }
            p9.r<Context, AgentFileSyncBridge.Result, String, String, Y8.t> rVar = this.$launcher;
            FolderTreeFragment folderTreeFragment = this.this$0;
            String str2 = this.$fileId;
            try {
                Result.Companion companion = Result.INSTANCE;
                Context contextRequireContext = folderTreeFragment.requireContext();
                kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
                rVar.invoke(contextRequireContext, result, str2, null);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            String str3 = this.$fileId;
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.t("FolderTreeFragment", "open preview failed fileId=" + str3, thE, false, 8, null);
            }
            return Y8.t.f7040a;
        }
        return Y8.t.f7040a;
    }
}
