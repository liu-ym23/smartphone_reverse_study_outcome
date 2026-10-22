package com.stepos.ailauncher.chat.view;

import android.net.Uri;
import com.stepos.agentframework.chatcore.file.FileInfo;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "<anonymous>", "(LUa/M;)Lcom/stepos/agentframework/chatcore/file/FileInfo;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.BaseInputView$prepareSilentScreenshot$1$file$1", f = "BaseInputView.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class BaseInputView$prepareSilentScreenshot$1$file$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super FileInfo>, Object> {
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ BaseInputView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseInputView$prepareSilentScreenshot$1$file$1(BaseInputView baseInputView, Uri uri, InterfaceC4014c<? super BaseInputView$prepareSilentScreenshot$1$file$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = baseInputView;
        this.$uri = uri;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new BaseInputView$prepareSilentScreenshot$1$file$1(this.this$0, this.$uri, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super FileInfo> interfaceC4014c) {
        return ((BaseInputView$prepareSilentScreenshot$1$file$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        return this.this$0.l5(this.$uri);
    }
}
