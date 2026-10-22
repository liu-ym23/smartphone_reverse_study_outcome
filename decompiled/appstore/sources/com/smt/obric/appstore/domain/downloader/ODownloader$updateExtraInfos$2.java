package com.smt.obric.appstore.domain.downloader;

import com.obric.download.base.TaskOperateResult;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/download/base/TaskOperateResult;", SlideCard.KEY_INDEX, "", "id", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.downloader.ODownloader$updateExtraInfos$2", f = "ODownloader.kt", i = {}, l = {360}, m = "invokeSuspend", n = {}, s = {})
public final class ODownloader$updateExtraInfos$2 extends SuspendLambda implements Function3<Integer, Long, Continuation<? super TaskOperateResult>, Object> {
    final /* synthetic */ List<String> $extraInfos;
    /* synthetic */ int I$0;
    /* synthetic */ long J$0;
    int label;

    public ODownloader$updateExtraInfos$2(List<String> r10, Continuation<? super ODownloader$updateExtraInfos$2> r11) {
        this.$extraInfos = r10;
        super(3, r11);
    }

    @Nullable
    public final Object invoke(int r10, long r11, @Nullable Continuation<? super TaskOperateResult> r12) {
        ODownloader$updateExtraInfos$2 r13 = new ODownloader$updateExtraInfos$2(this.$extraInfos, r12);
        r13.I$0 = r10;
        r13.J$0 = r11;
        return r13.invokeSuspend(Unit.f21064a);
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
        int r13 = this.I$0;
        long r14 = this.J$0;
        ODownloader r15 = ODownloader.f18038a;
        String r16 = this.$extraInfos.get(r13);
        this.label = 1;
        r10 = r15.B(r14, r16, this);
        if (r10 != r11) goto L11;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Integer r10, Long r11, Continuation<? super TaskOperateResult> r12) {
        return invoke(r10.intValue(), r11.longValue(), r12);
    }
}
