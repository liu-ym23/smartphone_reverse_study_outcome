package com.stepos.datacenter.ame;

import Y8.t;
import Z8.C1173v;
import com.stepos.ame.sdk.AMEngineResult;
import com.stepos.ame.sdk.AMEngineSession;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "", "session", "Lcom/stepos/ame/sdk/AMEngineSession;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@InterfaceC4112d(c = "com.stepos.datacenter.ame.AmeVectorStorageProvider$listQuarantinedFiles$2$1", f = "AmeVectorStorageProvider.kt", l = {974}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AmeVectorStorageProvider$listQuarantinedFiles$2$1 extends SuspendLambda implements p<AMEngineSession, InterfaceC4014c<? super List<? extends String>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f29714a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f29715b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f29716c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmeVectorStorageProvider$listQuarantinedFiles$2$1(String str, InterfaceC4014c<? super AmeVectorStorageProvider$listQuarantinedFiles$2$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f29716c = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AmeVectorStorageProvider$listQuarantinedFiles$2$1 ameVectorStorageProvider$listQuarantinedFiles$2$1 = new AmeVectorStorageProvider$listQuarantinedFiles$2$1(this.f29716c, interfaceC4014c);
        ameVectorStorageProvider$listQuarantinedFiles$2$1.f29715b = obj;
        return ameVectorStorageProvider$listQuarantinedFiles$2$1;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(AMEngineSession aMEngineSession, InterfaceC4014c<? super List<String>> interfaceC4014c) {
        return ((AmeVectorStorageProvider$listQuarantinedFiles$2$1) create(aMEngineSession, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List list;
        Object objG = C4063a.g();
        int i10 = this.f29714a;
        if (i10 == 0) {
            C4849c.b(obj);
            AMEngineSession aMEngineSession = (AMEngineSession) this.f29715b;
            String str = this.f29716c;
            this.f29714a = 1;
            obj = aMEngineSession.collectionQuarantinedFiles(str, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        AMEngineResult.Success success = obj instanceof AMEngineResult.Success ? (AMEngineResult.Success) obj : null;
        return (success == null || (list = (List) success.getValue()) == null) ? C1173v.m() : list;
    }
}
