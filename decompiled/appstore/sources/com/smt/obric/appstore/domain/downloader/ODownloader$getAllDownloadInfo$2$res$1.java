package com.smt.obric.appstore.domain.downloader;

import com.bytedanceos.common.toolbox.j;
import com.obric.download.AsyncGetDownloadInfoList;
import com.obric.download.base.DownloadInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.t;
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
@DebugMetadata(c = "com.smt.obric.appstore.domain.downloader.ODownloader$getAllDownloadInfo$2$res$1", f = "ODownloader.kt", i = {}, l = {529}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nODownloader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ODownloader.kt\ncom/smt/obric/appstore/domain/downloader/ODownloader$getAllDownloadInfo$2$res$1\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,528:1\n314#2,11:529\n*S KotlinDebug\n*F\n+ 1 ODownloader.kt\ncom/smt/obric/appstore/domain/downloader/ODownloader$getAllDownloadInfo$2$res$1\n*L\n398#1:529,11\n*E\n"})
public final class ODownloader$getAllDownloadInfo$2$res$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends DownloadInfo>>, Object> {
    final /* synthetic */ String $nonNullOwnerPkg;
    final /* synthetic */ long $ts;
    long J$0;
    Object L$0;
    int label;

    public static final class a implements AsyncGetDownloadInfoList {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f18046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CancellableContinuation f18047b;

        public a(long r10, CancellableContinuation r11) {
            this.f18046a = r10;
            this.f18047b = r11;
        }

        @Override // com.obric.download.AsyncGetDownloadInfoList
        public void getDownloadInfoList(List r10) {
            if (r10 != null) goto L4;
            j.p("[AppStatus][ODownloader][Action] getAllDownloadInfo infos=null ts=" + this.f18046a);
        L13:
            if (this.f18047b.isActive() == false) goto L19;
            this.f18047b.resumeWith(Result.m35constructorimpl(r10));
            return;
        L19:
            return;
        L4:
            StringBuilder r11 = new StringBuilder();
            long r12 = this.f18046a;
            Iterator r13 = r10.iterator();
            int r14 = 0;
        L6:
            if (r13.hasNext() == false) goto L11;
            Object r15 = r13.next();
            int r16 = r14 + 1;
            if (r14 >= 0) goto L10;
            t.q();
        L10:
            r11.append("ts@" + r12 + " i@" + r14 + ": " + c.a((DownloadInfo) r15) + '\n');
            r14 = r16;
            goto L6
        L11:
            j.o("[AppStatus][ODownloader][Action] getAllDownloadInfo infos size=" + r10.size() + " ts=" + this.f18046a + ", infos=" + r11);
            goto L13
        }
    }

    public ODownloader$getAllDownloadInfo$2$res$1(String r10, long r11, Continuation<? super ODownloader$getAllDownloadInfo$2$res$1> r12) {
        this.$nonNullOwnerPkg = r10;
        this.$ts = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new ODownloader$getAllDownloadInfo$2$res$1(this.$nonNullOwnerPkg, this.$ts, r11);
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
        String r13 = (String) this.L$0;
        kotlin.c.b(r10);
    L13:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        String r14 = this.$nonNullOwnerPkg;
        long r15 = this.$ts;
        this.L$0 = r14;
        this.J$0 = r15;
        this.label = 1;
        n r16 = new n(IntrinsicsKt__IntrinsicsJvmKt.c(this), 1);
        r16.initCancellability();
        a r17 = new a(r15, r16);
        j.n("[AppStatus][ODownloader][Action] getAllDownloadInfo ownerPkg=" + r14 + " ts=" + r15);
        yb.c.f26207r.a().A(r14, r17);
        r10 = r16.q();
        if (r10 != kotlin.coroutines.intrinsics.a.d()) goto L11;
        tf.d.c(this);
    L11:
        if (r10 != r11) goto L13;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super List<DownloadInfo>> r11) {
        return ((ODownloader$getAllDownloadInfo$2$res$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
