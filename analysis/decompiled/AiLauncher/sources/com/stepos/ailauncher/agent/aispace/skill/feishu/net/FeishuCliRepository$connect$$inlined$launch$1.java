package com.stepos.ailauncher.agent.aispace.skill.feishu.net;

import Ua.M;
import Y8.t;
import android.app.Application;
import android.widget.Toast;
import com.stepos.ailauncher.agent.R$string;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.skill.feishu.net.FeishuCliRepository$connect$$inlined$launch$1", f = "FeishuCliRepository.kt", l = {313, 318, 173}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class FeishuCliRepository$connect$$inlined$launch$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ String $action$inlined;
    final /* synthetic */ FeishuRequestBody $body$inlined;
    final /* synthetic */ String $opName;
    final /* synthetic */ FeishuRequestBody $requestBody;
    final /* synthetic */ String $traceIdHeader$inlined;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.skill.feishu.net.FeishuCliRepository$launch$1$3$1", f = "FeishuCliRepository.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.skill.feishu.net.FeishuCliRepository$connect$$inlined$launch$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ Application $ctx;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Application application, InterfaceC4014c interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$ctx = application;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$ctx, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            Application application = this.$ctx;
            Toast.makeText(application, application.getString(R$string.feishu_cli_toast_network_unavailable), 0).show();
            return t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeishuCliRepository$connect$$inlined$launch$1(String str, FeishuRequestBody feishuRequestBody, InterfaceC4014c interfaceC4014c, String str2, String str3, FeishuRequestBody feishuRequestBody2) {
        super(2, interfaceC4014c);
        this.$opName = str;
        this.$requestBody = feishuRequestBody;
        this.$action$inlined = str2;
        this.$traceIdHeader$inlined = str3;
        this.$body$inlined = feishuRequestBody2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        FeishuCliRepository$connect$$inlined$launch$1 feishuCliRepository$connect$$inlined$launch$1 = new FeishuCliRepository$connect$$inlined$launch$1(this.$opName, this.$requestBody, interfaceC4014c, this.$action$inlined, this.$traceIdHeader$inlined, this.$body$inlined);
        feishuCliRepository$connect$$inlined$launch$1.L$0 = obj;
        return feishuCliRepository$connect$$inlined$launch$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((FeishuCliRepository$connect$$inlined$launch$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x01d4, code lost:
    
        if (Ua.C1056g.j(r5, r6, r16) == r3) goto L56;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0128  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.skill.feishu.net.FeishuCliRepository$connect$$inlined$launch$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
