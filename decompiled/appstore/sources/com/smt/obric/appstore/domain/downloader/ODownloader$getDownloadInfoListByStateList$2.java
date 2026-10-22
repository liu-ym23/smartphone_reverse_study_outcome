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
@DebugMetadata(c = "com.smt.obric.appstore.domain.downloader.ODownloader$getDownloadInfoListByStateList$2", f = "ODownloader.kt", i = {1}, l = {432, 435}, m = "invokeSuspend", n = {"timeout"}, s = {"J$0"})
public final class ODownloader$getDownloadInfoListByStateList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends DownloadInfo>>, Object> {
    final /* synthetic */ String $ownerPkg;
    final /* synthetic */ List<Integer> $states;
    long J$0;
    int label;

    public ODownloader$getDownloadInfoListByStateList$2(String r10, List<Integer> r11, Continuation<? super ODownloader$getDownloadInfoListByStateList$2> r12) {
        this.$ownerPkg = r10;
        this.$states = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new ODownloader$getDownloadInfoListByStateList$2(this.$ownerPkg, this.$states, r11);
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
        long r13 = this.J$0;
        kotlin.c.b(r10);
    L25:
        List r14 = (List) r10;
        if (r14 != null) goto L28;
        j.p("[AppStatus][ODownloader][Action] !!!! SDK ERROR !!!! getAllDownloadInfoByStateList timeout for " + r13 + "ms");
    L28:
        return r14;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        kotlin.c.b(r10);
    L13:
        String r15 = this.$ownerPkg;
        if (r15 != null) goto L19;
        Context r16 = ODownloader.b();
        if (r16 != null) goto L18;
        q.y("context");
        r16 = null;
    L18:
        r15 = r16.getPackageName();
    L19:
        if (r15 != null) goto L21;
        return null;
    L21:
        ODownloader$getDownloadInfoListByStateList$2$res$1 r17 = new ODownloader$getDownloadInfoListByStateList$2$res$1(r15, this.$states, null);
        this.J$0 = 20000;
        this.label = 2;
        r10 = TimeoutKt.d(20000, r17, this);
        if (r10 != r11) goto L24;
        return r11;
    L24:
        r13 = 20000;
        goto L25
    L10:
        kotlin.c.b(r10);
        ODownloader r18 = ODownloader.f18038a;
        this.label = 1;
        if (ODownloader.a(r18, this) != r11) goto L13;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super List<DownloadInfo>> r11) {
        return ((ODownloader$getDownloadInfoListByStateList$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
