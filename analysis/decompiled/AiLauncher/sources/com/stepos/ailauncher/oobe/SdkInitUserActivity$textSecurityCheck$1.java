package com.stepos.ailauncher.oobe;

import android.content.Intent;
import com.stepos.agentframework.chatcore.audit.ContentAuditClient;
import com.stepos.agentframework.chatcore.audit.g;
import com.stepos.ailauncher.foundation.appui.card.provider.amap.MapAspectFrameLayout;
import e9.InterfaceC4014c;
import f6.C4059a;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.oobe.SdkInitUserActivity$textSecurityCheck$1", f = "SdkInitUserActivity.kt", l = {MapAspectFrameLayout.DESIGN_WIDTH}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SdkInitUserActivity$textSecurityCheck$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $text;
    int label;
    final /* synthetic */ SdkInitUserActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SdkInitUserActivity$textSecurityCheck$1(String str, SdkInitUserActivity sdkInitUserActivity, InterfaceC4014c<? super SdkInitUserActivity$textSecurityCheck$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$text = str;
        this.this$0 = sdkInitUserActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SdkInitUserActivity$textSecurityCheck$1(this.$text, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SdkInitUserActivity$textSecurityCheck$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            ContentAuditClient contentAuditClient = ContentAuditClient.INSTANCE;
            String str = this.$text;
            this.label = 1;
            obj = contentAuditClient.g(null, str, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        if (kotlin.jvm.internal.p.d(((com.stepos.agentframework.chatcore.audit.g) obj).a(), g.a.INSTANCE)) {
            this.this$0.h0(R$string.oobe_text_audit_fail);
            this.this$0.isNavigating = false;
            return Y8.t.f7040a;
        }
        O.INSTANCE.h(this.$text);
        C4059a.INSTANCE.d(C4059a.STEP_PREFERENCE, "next", this.$text);
        this.this$0.startActivity(new Intent(this.this$0, (Class<?>) AgentConfigActivity.class));
        return Y8.t.f7040a;
    }
}
