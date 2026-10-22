package com.stepos.agentframework.chatui.folder;

import Ua.M;
import Y8.t;
import android.content.Context;
import com.stepos.agentframework.chatui.AgentFileSyncBridge;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import p9.r;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatui.folder.FolderTreeSheet$onNodeClick$1", f = "FolderTreeSheet.kt", l = {140}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class FolderTreeSheet$onNodeClick$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ String $fileId;
    final /* synthetic */ r<Context, AgentFileSyncBridge.Result, String, String, t> $launcher;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FolderTreeSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FolderTreeSheet$onNodeClick$1(String str, FolderTreeSheet folderTreeSheet, r<? super Context, ? super AgentFileSyncBridge.Result, ? super String, ? super String, t> rVar, InterfaceC4014c<? super FolderTreeSheet$onNodeClick$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$fileId = str;
        this.this$0 = folderTreeSheet;
        this.$launcher = rVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        FolderTreeSheet$onNodeClick$1 folderTreeSheet$onNodeClick$1 = new FolderTreeSheet$onNodeClick$1(this.$fileId, this.this$0, this.$launcher, interfaceC4014c);
        folderTreeSheet$onNodeClick$1.L$0 = obj;
        return folderTreeSheet$onNodeClick$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((FolderTreeSheet$onNodeClick$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        M m10 = (M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            p<String, InterfaceC4014c<? super AgentFileSyncBridge.Result>, Object> pVarA = AgentFileSyncBridge.a();
            if (pVarA != null) {
                String str = this.$fileId;
                this.L$0 = m10;
                this.label = 1;
                obj = pVarA.invoke(str, this);
                if (obj == objG) {
                    return objG;
                }
            }
            return t.f7040a;
        }
        if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        AgentFileSyncBridge.Result result = (AgentFileSyncBridge.Result) obj;
        if (result != null) {
            r<Context, AgentFileSyncBridge.Result, String, String, t> rVar = this.$launcher;
            FolderTreeSheet folderTreeSheet = this.this$0;
            String str2 = this.$fileId;
            try {
                Result.Companion companion = Result.INSTANCE;
                Context context = folderTreeSheet.getContext();
                kotlin.jvm.internal.p.h(context, "getContext(...)");
                rVar.invoke(context, result, str2, null);
                Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
            this.this$0.dismiss();
            return t.f7040a;
        }
        return t.f7040a;
    }
}
