package com.stepos.agentframework.chatui.dialog;

import com.stepos.agentframework.adapter.ApiManager;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatui.dialog.DislikeReportDialog$show$2$remote$1", f = "DislikeReportDialog.kt", l = {147}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class DislikeReportDialog$show$2$remote$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super List<? extends String>>, Object> {
    int label;

    public DislikeReportDialog$show$2$remote$1(InterfaceC4014c<? super DislikeReportDialog$show$2$remote$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new DislikeReportDialog$show$2$remote$1(interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Ua.M m10, InterfaceC4014c<? super List<String>> interfaceC4014c) {
        return ((DislikeReportDialog$show$2$remote$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        ApiManager apiManager = ApiManager.INSTANCE;
        this.label = 1;
        Object objH = apiManager.H(this);
        return objH == objG ? objG : objH;
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(Ua.M m10, InterfaceC4014c<? super List<? extends String>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super List<String>>) interfaceC4014c);
    }
}
