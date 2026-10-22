package com.stepos.ailauncher.chat;

import Ua.M;
import android.net.Uri;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"LUa/M;", "Lkotlin/Pair;", "", "", "<anonymous>", "(LUa/M;)Lkotlin/Pair;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.PickFileMediatorViewModel$acquireFileInfo$2", f = "PickFileMediatorActivity.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class PickFileMediatorViewModel$acquireFileInfo$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Pair<? extends String, ? extends Integer>>, Object> {
    final /* synthetic */ Uri $uri;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PickFileMediatorViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PickFileMediatorViewModel$acquireFileInfo$2(PickFileMediatorViewModel pickFileMediatorViewModel, Uri uri, InterfaceC4014c<? super PickFileMediatorViewModel$acquireFileInfo$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = pickFileMediatorViewModel;
        this.$uri = uri;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        PickFileMediatorViewModel$acquireFileInfo$2 pickFileMediatorViewModel$acquireFileInfo$2 = new PickFileMediatorViewModel$acquireFileInfo$2(this.this$0, this.$uri, interfaceC4014c);
        pickFileMediatorViewModel$acquireFileInfo$2.L$0 = obj;
        return pickFileMediatorViewModel$acquireFileInfo$2;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super Pair<String, Integer>> interfaceC4014c) {
        return ((PickFileMediatorViewModel$acquireFileInfo$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00c2 A[Catch: all -> 0x00b9, TryCatch #1 {all -> 0x00b9, blocks: (B:5:0x0019, B:7:0x002d, B:35:0x00b3, B:45:0x00ca, B:42:0x00be, B:43:0x00c1, B:44:0x00c2, B:8:0x002f, B:10:0x0038, B:13:0x0046, B:19:0x005b, B:21:0x0061, B:26:0x0075, B:28:0x007b, B:32:0x0084, B:34:0x008a, B:40:0x00bc), top: B:56:0x0019, inners: #0, #2 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.PickFileMediatorViewModel$acquireFileInfo$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super Pair<? extends String, ? extends Integer>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super Pair<String, Integer>>) interfaceC4014c);
    }
}
