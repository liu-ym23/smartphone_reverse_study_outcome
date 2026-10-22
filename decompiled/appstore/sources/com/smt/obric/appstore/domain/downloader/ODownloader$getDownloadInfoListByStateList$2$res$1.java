package com.smt.obric.appstore.domain.downloader;

import com.bytedanceos.common.toolbox.j;
import com.obric.download.AsyncGetDownloadInfoList;
import com.obric.download.base.DownloadInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/obric/download/base/DownloadInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.downloader.ODownloader$getDownloadInfoListByStateList$2$res$1", f = "ODownloader.kt", i = {}, l = {529}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nODownloader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ODownloader.kt\ncom/smt/obric/appstore/domain/downloader/ODownloader$getDownloadInfoListByStateList$2$res$1\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,528:1\n314#2,11:529\n*S KotlinDebug\n*F\n+ 1 ODownloader.kt\ncom/smt/obric/appstore/domain/downloader/ODownloader$getDownloadInfoListByStateList$2$res$1\n*L\n436#1:529,11\n*E\n"})
public final class ODownloader$getDownloadInfoListByStateList$2$res$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends DownloadInfo>>, Object> {
    final /* synthetic */ String $nonNullOwnerPkg;
    final /* synthetic */ List<Integer> $states;
    Object L$0;
    Object L$1;
    int label;

    public static final class a implements AsyncGetDownloadInfoList {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CancellableContinuation f18048a;

        public a(CancellableContinuation r10) {
            this.f18048a = r10;
        }

        @Override // com.obric.download.AsyncGetDownloadInfoList
        public void getDownloadInfoList(List r10) {
            if (r10 != null) goto L4;
            j.p("[AppStatus][ODownloader][Action] getAllDownloadInfoByStateList infos=null");
        L6:
            if (this.f18048a.isActive() == false) goto L9;
            this.f18048a.resumeWith(Result.m35constructorimpl(r10));
            return;
        L9:
            return;
        L4:
            j.o("[AppStatus][ODownloader][Action] getAllDownloadInfoByStateList infos size=" + r10.size());
            goto L6
        }
    }

    public ODownloader$getDownloadInfoListByStateList$2$res$1(String r10, List<Integer> r11, Continuation<? super ODownloader$getDownloadInfoListByStateList$2$res$1> r12) {
        this.$nonNullOwnerPkg = r10;
        this.$states = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new ODownloader$getDownloadInfoListByStateList$2$res$1(this.$nonNullOwnerPkg, this.$states, r11);
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
        List r13 = (List) this.L$1;
        String r14 = (String) this.L$0;
        kotlin.c.b(r10);
    L13:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        String r15 = this.$nonNullOwnerPkg;
        List<Integer> r16 = this.$states;
        this.L$0 = r15;
        this.L$1 = r16;
        this.label = 1;
        n r17 = new n(IntrinsicsKt__IntrinsicsJvmKt.c(this), 1);
        r17.initCancellability();
        a r18 = new a(r17);
        yb.c.f26207r.a().B(r15, b0.w0(r16), r18);
        r10 = r17.q();
        if (r10 != kotlin.coroutines.intrinsics.a.d()) goto L11;
        tf.d.c(this);
    L11:
        if (r10 != r11) goto L13;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super List<DownloadInfo>> r11) {
        return ((ODownloader$getDownloadInfoListByStateList$2$res$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
