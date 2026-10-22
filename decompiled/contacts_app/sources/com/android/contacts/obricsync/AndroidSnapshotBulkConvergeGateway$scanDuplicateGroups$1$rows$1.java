package com.android.contacts.obricsync;

import android.database.Cursor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: compiled from: ObricSyncSnapshotBulkConverger.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lcom/android/contacts/obricsync/SnapshotRow;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.android.contacts.obricsync.AndroidSnapshotBulkConvergeGateway$scanDuplicateGroups$1$rows$1", f = "ObricSyncSnapshotBulkConverger.kt", i = {0}, l = {199}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"})
final class AndroidSnapshotBulkConvergeGateway$scanDuplicateGroups$1$rows$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super SnapshotRow>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $contactIdIndex;
    final /* synthetic */ int $dataIdIndex;
    final /* synthetic */ Cursor $it;
    private /* synthetic */ Object L$0;
    int label;

    AndroidSnapshotBulkConvergeGateway$scanDuplicateGroups$1$rows$1(Cursor r1, int r2, int r3, Continuation<? super AndroidSnapshotBulkConvergeGateway$scanDuplicateGroups$1$rows$1> r4) {
        this.$it = r1;
        this.$contactIdIndex = r2;
        this.$dataIdIndex = r3;
        super(2, r4);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        AndroidSnapshotBulkConvergeGateway$scanDuplicateGroups$1$rows$1 r0 = new AndroidSnapshotBulkConvergeGateway$scanDuplicateGroups$1$rows$1(this.$it, this.$contactIdIndex, this.$dataIdIndex, r5);
        r0.L$0 = r4;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super SnapshotRow> r1, Continuation<? super Unit> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceScope<? super SnapshotRow> r1, Continuation<? super Unit> r2) {
        return ((AndroidSnapshotBulkConvergeGateway$scanDuplicateGroups$1$rows$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        SequenceScope r2 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r8);
    L10:
        if (this.$it.moveToNext() == false) goto L15;
        this.L$0 = r2;
        this.label = 1;
        if (r2.yield(new SnapshotRow(this.$it.getLong(this.$contactIdIndex), this.$it.getLong(this.$dataIdIndex)), this) != r0) goto L10;
        return r0;
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        r2 = (SequenceScope) this.L$0;
        goto L10
    }
}
