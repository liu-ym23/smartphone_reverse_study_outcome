package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.common.preload;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0082@"}, d2 = {"", "schema", "sourceTag", "Lkotlin/coroutines/Continuation;", "Landroid/net/Uri;", "continuation", "", "processUrl"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.common.preload.PaidOpenSchemaWithDataAbility", f = "PaidOpenSchemaWithDataAbility.kt", i = {0, 0, 0}, l = {203}, m = "processUrl", n = {"this", "sourceTag", "uri"}, s = {"L$0", "L$1", "L$2"})
final class PaidOpenSchemaWithDataAbility$processUrl$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PaidOpenSchemaWithDataAbility this$0;

    public PaidOpenSchemaWithDataAbility$processUrl$1(PaidOpenSchemaWithDataAbility r100, Continuation r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return PaidOpenSchemaWithDataAbility.a(this.this$0, null, null, this);
    }
}
