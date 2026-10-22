package com.stepos.ailauncher.task.detail.render;

import Ua.C1056g;
import Ua.Y;
import com.stepos.ailauncher.task.detail.TaskWebView;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.detail.render.ArtifactContentView$fetchTextWithUrl$1", f = "ArtifactContentView.kt", l = {1047}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ArtifactContentView$fetchTextWithUrl$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ boolean $asHtml;
    final /* synthetic */ InterfaceC5063a<Y8.t> $onFailRetry;
    final /* synthetic */ String $url;
    final /* synthetic */ TaskWebView $web;
    Object L$0;
    int label;
    final /* synthetic */ ArtifactContentView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactContentView$fetchTextWithUrl$1(InterfaceC5063a<Y8.t> interfaceC5063a, ArtifactContentView artifactContentView, TaskWebView taskWebView, boolean z10, String str, InterfaceC4014c<? super ArtifactContentView$fetchTextWithUrl$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$onFailRetry = interfaceC5063a;
        this.this$0 = artifactContentView;
        this.$web = taskWebView;
        this.$asHtml = z10;
        this.$url = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ArtifactContentView$fetchTextWithUrl$1(this.$onFailRetry, this.this$0, this.$web, this.$asHtml, this.$url, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ArtifactContentView$fetchTextWithUrl$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Ref$ObjectRef ref$ObjectRef;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            Ua.I iB = Y.b();
            ArtifactContentView$fetchTextWithUrl$1$text$1 artifactContentView$fetchTextWithUrl$1$text$1 = new ArtifactContentView$fetchTextWithUrl$1$text$1(this.$url, ref$ObjectRef2, null);
            this.L$0 = ref$ObjectRef2;
            this.label = 1;
            Object objJ = C1056g.j(iB, artifactContentView$fetchTextWithUrl$1$text$1, this);
            if (objJ == objG) {
                return objG;
            }
            ref$ObjectRef = ref$ObjectRef2;
            obj = objJ;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ref$ObjectRef = (Ref$ObjectRef) this.L$0;
            C4849c.b(obj);
        }
        String str = (String) obj;
        if (str != null && str.length() != 0) {
            this.this$0.q1(this.$web, this.$asHtml, str);
            return Y8.t.f7040a;
        }
        InterfaceC5063a<Y8.t> interfaceC5063a = this.$onFailRetry;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        } else {
            ArtifactContentView artifactContentView = this.this$0;
            artifactContentView.O1(artifactContentView.k1((Integer) ref$ObjectRef.f34820a), "preview");
        }
        return Y8.t.f7040a;
    }
}
