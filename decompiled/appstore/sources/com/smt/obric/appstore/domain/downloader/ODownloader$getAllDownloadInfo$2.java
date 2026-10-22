package com.smt.obric.appstore.domain.downloader;

import android.content.Context;
import com.bytedanceos.common.toolbox.j;
import com.obric.download.base.DownloadInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/obric/download/base/DownloadInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.downloader.ODownloader$getAllDownloadInfo$2", f = "ODownloader.kt", i = {1, 1}, l = {391, 397}, m = "invokeSuspend", n = {"timeout", "ts"}, s = {"J$0", "J$1"})
public final class ODownloader$getAllDownloadInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends DownloadInfo>>, Object> {
    final /* synthetic */ String $ownerPkg;
    long J$0;
    long J$1;
    int label;

    public ODownloader$getAllDownloadInfo$2(String r10, Continuation<? super ODownloader$getAllDownloadInfo$2> r11) {
        this.$ownerPkg = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new ODownloader$getAllDownloadInfo$2(this.$ownerPkg, r11);
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
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 != 2) goto L8;
        long r13 = this.J$1;
        long r14 = this.J$0;
        kotlin.c.b(r10);
    L25:
        List r15 = (List) r10;
        if (r15 != null) goto L28;
        j.p("[AppStatus][ODownloader][Action] !!!! SDK ERROR !!!! getAllDownloadInfo timeout for " + r14 + "ms ts=" + r13);
    L28:
        return r15;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        kotlin.c.b(r10);
    L13:
        String r16 = this.$ownerPkg;
        if (r16 != null) goto L19;
        Context r17 = ODownloader.b();
        if (r17 != null) goto L18;
        q.y("context");
        r17 = null;
    L18:
        r16 = r17.getPackageName();
    L19:
        if (r16 != null) goto L21;
        return null;
    L21:
        long r18 = System.currentTimeMillis();
        ODownloader$getAllDownloadInfo$2$res$1 r19 = new ODownloader$getAllDownloadInfo$2$res$1(r16, r18, null);
        this.J$0 = 20000;
        this.J$1 = r18;
        this.label = 2;
        r10 = TimeoutKt.d(20000, r19, this);
        if (r10 != r11) goto L24;
        return r11;
    L24:
        r13 = r18;
        r14 = 20000;
        goto L25
    L10:
        kotlin.c.b(r10);
        ODownloader r20 = ODownloader.f18038a;
        this.label = 1;
        if (ODownloader.a(r20, this) != r11) goto L13;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super List<DownloadInfo>> r11) {
        return ((ODownloader$getAllDownloadInfo$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
