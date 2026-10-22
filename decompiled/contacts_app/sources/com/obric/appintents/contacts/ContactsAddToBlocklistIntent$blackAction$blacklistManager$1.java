package com.obric.appintents.contacts;

import android.content.Context;
import com.android.contacts.util.BlackListQueryHandler;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ContactsAddToBlocklistIntent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/android/contacts/util/BlackListQueryHandler;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.obric.appintents.contacts.ContactsAddToBlocklistIntent$blackAction$blacklistManager$1", f = "ContactsAddToBlocklistIntent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ContactsAddToBlocklistIntent$blackAction$blacklistManager$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BlackListQueryHandler>, Object> {
    final /* synthetic */ Context $context;
    int label;

    ContactsAddToBlocklistIntent$blackAction$blacklistManager$1(Context r1, Continuation<? super ContactsAddToBlocklistIntent$blackAction$blacklistManager$1> r2) {
        this.$context = r1;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new ContactsAddToBlocklistIntent$blackAction$blacklistManager$1(this.$context, r2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super BlackListQueryHandler> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r1, Continuation<? super BlackListQueryHandler> r2) {
        return ((ContactsAddToBlocklistIntent$blackAction$blacklistManager$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        return new BlackListQueryHandler(this.$context);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
