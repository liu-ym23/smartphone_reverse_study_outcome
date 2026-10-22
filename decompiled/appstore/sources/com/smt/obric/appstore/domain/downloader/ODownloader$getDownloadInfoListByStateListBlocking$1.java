package com.smt.obric.appstore.domain.downloader;

import com.obric.download.base.DownloadInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/obric/download/base/DownloadInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.downloader.ODownloader$getDownloadInfoListByStateListBlocking$1", f = "ODownloader.kt", i = {}, l = {461}, m = "invokeSuspend", n = {}, s = {})
final class ODownloader$getDownloadInfoListByStateListBlocking$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends DownloadInfo>>, Object> {
    final /* synthetic */ String $ownerPkg;
    final /* synthetic */ List<Integer> $states;
    int label;

    public ODownloader$getDownloadInfoListByStateListBlocking$1(String r10, List<Integer> r11, Continuation<? super ODownloader$getDownloadInfoListByStateListBlocking$1> r12) {
        this.$ownerPkg = r10;
        this.$states = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new ODownloader$getDownloadInfoListByStateListBlocking$1(this.$ownerPkg, this.$states, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super List<? extends DownloadInfo>> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        kotlin.c.b(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        ODownloader r13 = ODownloader.f18038a;
        String r14 = this.$ownerPkg;
        List<Integer> r15 = this.$states;
        this.label = 1;
        r10 = r13.m(r14, r15, this);
        if (r10 != r11) goto L11;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super List<DownloadInfo>> r11) {
        return ((ODownloader$getDownloadInfoListByStateListBlocking$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
