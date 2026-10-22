package com.stepos.ailauncher.chat.view;

import android.net.Uri;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.BaseInputView$replaceCircleSelectImage$1", f = "BaseInputView.kt", l = {4048, 4054}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class BaseInputView$replaceCircleSelectImage$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ InterfaceC5074l<Boolean, Y8.t> $onQueued;
    final /* synthetic */ int $requestId;
    final /* synthetic */ long $screenshotRound;
    final /* synthetic */ Uri $uri;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ BaseInputView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BaseInputView$replaceCircleSelectImage$1(long j10, InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l, Uri uri, int i10, BaseInputView baseInputView, InterfaceC4014c<? super BaseInputView$replaceCircleSelectImage$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$screenshotRound = j10;
        this.$onQueued = interfaceC5074l;
        this.$uri = uri;
        this.$requestId = i10;
        this.this$0 = baseInputView;
    }

    public static final void h(BaseInputView baseInputView) {
        RecyclerView recyclerView = baseInputView.imgRecyclerView;
        if (recyclerView != null) {
            recyclerView.setItemAnimator(new DefaultItemAnimator());
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        BaseInputView$replaceCircleSelectImage$1 baseInputView$replaceCircleSelectImage$1 = new BaseInputView$replaceCircleSelectImage$1(this.$screenshotRound, this.$onQueued, this.$uri, this.$requestId, this.this$0, interfaceC4014c);
        baseInputView$replaceCircleSelectImage$1.L$0 = obj;
        return baseInputView$replaceCircleSelectImage$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((BaseInputView$replaceCircleSelectImage$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d3  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.BaseInputView$replaceCircleSelectImage$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
