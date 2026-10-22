package com.stepos.ailauncher.agent.aispace.skill.wecom;

import Z8.C1173v;
import Z8.C1174w;
import com.stepos.ailauncher.agent.aispace.skill.feishu.RecommendedTask;
import com.stepos.ailauncher.agent.aispace.skill.feishu.net.CliHubInfoDto;
import com.stepos.ailauncher.agent.aispace.skill.wecom.net.WecomCliHubRepository;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.ArrayList;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.skill.wecom.WecomConnectFragment$loadRecommendedTasks$1", f = "WecomConnectFragment.kt", l = {911}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class WecomConnectFragment$loadRecommendedTasks$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ WecomConnectFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WecomConnectFragment$loadRecommendedTasks$1(WecomConnectFragment wecomConnectFragment, InterfaceC4014c<? super WecomConnectFragment$loadRecommendedTasks$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = wecomConnectFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        WecomConnectFragment$loadRecommendedTasks$1 wecomConnectFragment$loadRecommendedTasks$1 = new WecomConnectFragment$loadRecommendedTasks$1(this.this$0, interfaceC4014c);
        wecomConnectFragment$loadRecommendedTasks$1.L$0 = obj;
        return wecomConnectFragment$loadRecommendedTasks$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((WecomConnectFragment$loadRecommendedTasks$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        List<RecommendedTask> listI0;
        Object objD;
        Ua.M m10 = (Ua.M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                Result.Companion companion = Result.INSTANCE;
                WecomCliHubRepository wecomCliHubRepository = WecomCliHubRepository.INSTANCE;
                this.L$0 = g9.h.a(m10);
                this.L$1 = g9.h.a(m10);
                this.I$0 = 0;
                this.label = 1;
                objD = wecomCliHubRepository.d("wecom-cli", this);
                if (objD == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                objD = ((Result) obj).getValue();
            }
            if (Result.g(objD)) {
                objD = null;
            }
            objB = Result.b((CliHubInfoDto) objD);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        CliHubInfoDto cliHubInfoDto = (CliHubInfoDto) objB;
        List<String> listA = cliHubInfoDto != null ? cliHubInfoDto.a() : null;
        if (listA == null) {
            listA = C1173v.m();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : listA) {
            if (!La.H.x0((String) obj2)) {
                arrayList.add(obj2);
            }
        }
        if (arrayList.isEmpty()) {
            C4148a.d("AILauncher-WecomConn", "vipcases empty, fallback to built-in defaults", false, 4, null);
            listI0 = this.this$0.i0();
        } else {
            listI0 = new ArrayList<>(C1174w.x(arrayList, 10));
            int i11 = 0;
            for (Object obj3 : arrayList) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    C1173v.w();
                }
                String str = (String) obj3;
                listI0.add(new RecommendedTask("wecom_vipcase_" + i11, str, null, i11 == 0, str));
                i11 = i12;
            }
        }
        this.this$0.recommendedAdapter.f(listI0);
        return Y8.t.f7040a;
    }
}
