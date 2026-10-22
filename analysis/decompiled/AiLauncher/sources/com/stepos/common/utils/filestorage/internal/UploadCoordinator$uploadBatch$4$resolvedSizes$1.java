package com.stepos.common.utils.filestorage.internal;

import P6.UploadRequest;
import Ua.M;
import Y8.t;
import Z8.C1174w;
import android.content.Context;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.ArrayList;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$resolvedSizes$1", f = "UploadCoordinator.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class UploadCoordinator$uploadBatch$4$resolvedSizes$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super List<? extends Long>>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ List<UploadRequest> $items;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ UploadCoordinator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadCoordinator$uploadBatch$4$resolvedSizes$1(List<UploadRequest> list, UploadCoordinator uploadCoordinator, Context context, InterfaceC4014c<? super UploadCoordinator$uploadBatch$4$resolvedSizes$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$items = list;
        this.this$0 = uploadCoordinator;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        UploadCoordinator$uploadBatch$4$resolvedSizes$1 uploadCoordinator$uploadBatch$4$resolvedSizes$1 = new UploadCoordinator$uploadBatch$4$resolvedSizes$1(this.$items, this.this$0, this.$context, interfaceC4014c);
        uploadCoordinator$uploadBatch$4$resolvedSizes$1.L$0 = obj;
        return uploadCoordinator$uploadBatch$4$resolvedSizes$1;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super List<Long>> interfaceC4014c) {
        return ((UploadCoordinator$uploadBatch$4$resolvedSizes$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        List<UploadRequest> list = this.$items;
        UploadCoordinator uploadCoordinator = this.this$0;
        Context context = this.$context;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        for (UploadRequest uploadRequest : list) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(uploadCoordinator.i(context, uploadCoordinator.h(uploadRequest.getUriOrPath())));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (Result.g(objB)) {
                objB = null;
            }
            arrayList.add((Long) objB);
        }
        return arrayList;
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super List<? extends Long>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super List<Long>>) interfaceC4014c);
    }
}
