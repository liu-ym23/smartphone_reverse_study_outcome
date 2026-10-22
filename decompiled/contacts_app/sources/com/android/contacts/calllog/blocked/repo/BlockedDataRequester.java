package com.android.contacts.calllog.blocked.repo;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.android.contacts.calllog.blocked.BlockedCall;
import com.obric.repo.core.DataRequestHandler;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: BlockedDataRequester.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001c\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ'\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014J!\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J&\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0019J\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006J\u0019\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u001c\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019J\u000e\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0019\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0016\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014J!\u0010 \u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J$\u0010!\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019J\u000e\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0019\u0010#\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/android/contacts/calllog/blocked/repo/BlockedDataRequester;", "", "()V", "clearBlockedCallAddStatus", "", "contentResolver", "Landroid/content/ContentResolver;", "clearBlockedCallAddStatusAsync", "(Landroid/content/ContentResolver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearBlockedCallAddStatusByExecute", "deleteBlockedCall", "", "ids", "", "", "deleteBlockedCallAsync", "(Landroid/content/ContentResolver;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWhitelist", "", "phoneNumber", "", "insertWhitelistAsync", "(Landroid/content/ContentResolver;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWhitelistWithCallback", "callback", "Lcom/android/contacts/calllog/blocked/repo/ICallback;", "queryBlockedCallAddStatus", "queryBlockedCallAddStatusAsync", "queryBlockedCallAddStatusWithCallback", "queryBlockedNumberTotalCount", "queryBlockedNumberTotalCountAsync", "queryIsPhoneNumberInWhiteList", "queryIsPhoneNumberInWhiteListAsync", "queryIsPhoneNumberInWhiteListWithCallback", "queryWhiteListTotalCount", "queryWhiteListTotalCountAsync", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BlockedDataRequester {
    public static final BlockedDataRequester INSTANCE = null;

    /* JADX INFO: renamed from: com.android.contacts.calllog.blocked.repo.BlockedDataRequester$clearBlockedCallAddStatusAsync$2, reason: invalid class name */
    /* JADX INFO: compiled from: BlockedDataRequester.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.blocked.repo.BlockedDataRequester$clearBlockedCallAddStatusAsync$2", f = "BlockedDataRequester.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ContentResolver $contentResolver;
        int label;

        AnonymousClass2(ContentResolver r1, Continuation<? super AnonymousClass2> r2) {
            this.$contentResolver = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass2(this.$contentResolver, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            BlockedDataRequester.INSTANCE.clearBlockedCallAddStatus(this.$contentResolver);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.blocked.repo.BlockedDataRequester$clearBlockedCallAddStatusByExecute$1, reason: invalid class name */
    /* JADX INFO: compiled from: BlockedDataRequester.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.blocked.repo.BlockedDataRequester$clearBlockedCallAddStatusByExecute$1", f = "BlockedDataRequester.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ ContentResolver $contentResolver;
        int label;

        AnonymousClass1(ContentResolver r1, Continuation<? super AnonymousClass1> r2) {
            this.$contentResolver = r1;
            super(1, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r2) {
            return new AnonymousClass1(this.$contentResolver, r2);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r1) {
            return invoke2(r1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r1) {
            return ((AnonymousClass1) create(r1)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            this.label = 1;
            if (BlockedDataRequester.INSTANCE.clearBlockedCallAddStatusAsync(this.$contentResolver, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.blocked.repo.BlockedDataRequester$deleteBlockedCallAsync$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BlockedDataRequester.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.blocked.repo.BlockedDataRequester$deleteBlockedCallAsync$2", f = "BlockedDataRequester.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01502 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        final /* synthetic */ ContentResolver $contentResolver;
        final /* synthetic */ Set<Long> $ids;
        int label;

        C01502(ContentResolver r1, Set<Long> r2, Continuation<? super C01502> r3) {
            this.$contentResolver = r1;
            this.$ids = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01502(this.$contentResolver, this.$ids, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Integer> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Integer> r2) {
            return ((C01502) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return Boxing.boxInt(BlockedDataRequester.INSTANCE.deleteBlockedCall(this.$contentResolver, this.$ids));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.blocked.repo.BlockedDataRequester$insertWhitelistAsync$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BlockedDataRequester.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.blocked.repo.BlockedDataRequester$insertWhitelistAsync$2", f = "BlockedDataRequester.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01512 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ ContentResolver $contentResolver;
        final /* synthetic */ String $phoneNumber;
        int label;

        C01512(ContentResolver r1, String r2, Continuation<? super C01512> r3) {
            this.$contentResolver = r1;
            this.$phoneNumber = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01512(this.$contentResolver, this.$phoneNumber, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return ((C01512) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return Boxing.boxBoolean(BlockedDataRequester.INSTANCE.insertWhitelist(this.$contentResolver, this.$phoneNumber));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.blocked.repo.BlockedDataRequester$insertWhitelistWithCallback$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BlockedDataRequester.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.blocked.repo.BlockedDataRequester$insertWhitelistWithCallback$1", f = "BlockedDataRequester.kt", i = {}, l = {261}, m = "invokeSuspend", n = {}, s = {})
    static final class C01521 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
        final /* synthetic */ ContentResolver $contentResolver;
        final /* synthetic */ String $phoneNumber;
        int label;

        C01521(ContentResolver r1, String r2, Continuation<? super C01521> r3) {
            this.$contentResolver = r1;
            this.$phoneNumber = r2;
            super(1, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r3) {
            return new C01521(this.$contentResolver, this.$phoneNumber, r3);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Boolean> r1) {
            return invoke2(r1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Boolean> r1) {
            return ((C01521) create(r1)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            this.label = 1;
            r6 = BlockedDataRequester.INSTANCE.insertWhitelistAsync(this.$contentResolver, this.$phoneNumber, this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.blocked.repo.BlockedDataRequester$queryBlockedCallAddStatusAsync$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BlockedDataRequester.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.blocked.repo.BlockedDataRequester$queryBlockedCallAddStatusAsync$2", f = "BlockedDataRequester.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01552 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ ContentResolver $contentResolver;
        int label;

        C01552(ContentResolver r1, Continuation<? super C01552> r2) {
            this.$contentResolver = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C01552(this.$contentResolver, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return ((C01552) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return Boxing.boxBoolean(BlockedDataRequester.INSTANCE.queryBlockedCallAddStatus(this.$contentResolver));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.blocked.repo.BlockedDataRequester$queryBlockedCallAddStatusWithCallback$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BlockedDataRequester.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.blocked.repo.BlockedDataRequester$queryBlockedCallAddStatusWithCallback$1", f = "BlockedDataRequester.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {})
    static final class C01561 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
        final /* synthetic */ ContentResolver $contentResolver;
        int label;

        C01561(ContentResolver r1, Continuation<? super C01561> r2) {
            this.$contentResolver = r1;
            super(1, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r2) {
            return new C01561(this.$contentResolver, r2);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Boolean> r1) {
            return invoke2(r1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Boolean> r1) {
            return ((C01561) create(r1)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            this.label = 1;
            r5 = BlockedDataRequester.INSTANCE.queryBlockedCallAddStatusAsync(this.$contentResolver, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.blocked.repo.BlockedDataRequester$queryBlockedNumberTotalCountAsync$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BlockedDataRequester.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.blocked.repo.BlockedDataRequester$queryBlockedNumberTotalCountAsync$2", f = "BlockedDataRequester.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01592 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        final /* synthetic */ ContentResolver $contentResolver;
        int label;

        C01592(ContentResolver r1, Continuation<? super C01592> r2) {
            this.$contentResolver = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C01592(this.$contentResolver, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Integer> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Integer> r2) {
            return ((C01592) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return Boxing.boxInt(BlockedDataRequester.INSTANCE.queryBlockedNumberTotalCount(this.$contentResolver));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.blocked.repo.BlockedDataRequester$queryIsPhoneNumberInWhiteListAsync$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BlockedDataRequester.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.blocked.repo.BlockedDataRequester$queryIsPhoneNumberInWhiteListAsync$2", f = "BlockedDataRequester.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01602 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ ContentResolver $contentResolver;
        final /* synthetic */ String $phoneNumber;
        int label;

        C01602(ContentResolver r1, String r2, Continuation<? super C01602> r3) {
            this.$contentResolver = r1;
            this.$phoneNumber = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01602(this.$contentResolver, this.$phoneNumber, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return ((C01602) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return Boxing.boxBoolean(BlockedDataRequester.INSTANCE.queryIsPhoneNumberInWhiteList(this.$contentResolver, this.$phoneNumber));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.blocked.repo.BlockedDataRequester$queryIsPhoneNumberInWhiteListWithCallback$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BlockedDataRequester.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.blocked.repo.BlockedDataRequester$queryIsPhoneNumberInWhiteListWithCallback$1", f = "BlockedDataRequester.kt", i = {}, l = {221}, m = "invokeSuspend", n = {}, s = {})
    static final class C01611 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
        final /* synthetic */ ContentResolver $contentResolver;
        final /* synthetic */ String $phoneNumber;
        int label;

        C01611(ContentResolver r1, String r2, Continuation<? super C01611> r3) {
            this.$contentResolver = r1;
            this.$phoneNumber = r2;
            super(1, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r3) {
            return new C01611(this.$contentResolver, this.$phoneNumber, r3);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Boolean> r1) {
            return invoke2(r1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Boolean> r1) {
            return ((C01611) create(r1)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            this.label = 1;
            r6 = BlockedDataRequester.INSTANCE.queryIsPhoneNumberInWhiteListAsync(this.$contentResolver, this.$phoneNumber, this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.blocked.repo.BlockedDataRequester$queryWhiteListTotalCountAsync$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BlockedDataRequester.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.blocked.repo.BlockedDataRequester$queryWhiteListTotalCountAsync$2", f = "BlockedDataRequester.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01642 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        final /* synthetic */ ContentResolver $contentResolver;
        int label;

        C01642(ContentResolver r1, Continuation<? super C01642> r2) {
            this.$contentResolver = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C01642(this.$contentResolver, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Integer> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Integer> r2) {
            return ((C01642) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return Boxing.boxInt(BlockedDataRequester.INSTANCE.queryWhiteListTotalCount(this.$contentResolver));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        INSTANCE = new BlockedDataRequester();
    }

    private BlockedDataRequester() {
    }

    public final int queryWhiteListTotalCount(ContentResolver r7) {
        Intrinsics.checkNotNullParameter(r7, "contentResolver");
        Cursor r6 = r7.query(BlockedCall.INSTANCE.getWHITELIST_URI(), null, null, null, null);
        int r8 = -1;
        if (r6 != null) goto L20;
    L17:
        if (r6 != null) goto L16;
    L19:
        return r8;
    L16:
        r6.close();
        goto L19
    L20:
    L15:
        if (r6 == null) goto L19;
    L11:
        th = move-exception;
        if (r6 == null) goto L14;
        r6.close();
    L14:
        throw th;
    L5:
        if (r6.moveToFirst() == false) goto L7;
        Cursor r0 = r6;
    L8:
        if (r0 == null) goto L17;
        r8 = r0.getInt(r0.getColumnIndex("wl_count"));     // Catch: Throwable -> L11 Exception -> L15
    L7:
        r0 = null;
        goto L8
    }

    public final Object queryWhiteListTotalCountAsync(ContentResolver r3, Continuation<? super Integer> r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C01642(r3, null), r4);
    }

    public final int queryBlockedNumberTotalCount(ContentResolver r7) {
        Intrinsics.checkNotNullParameter(r7, "contentResolver");
        Cursor r6 = r7.query(BlockedCall.INSTANCE.getBLACKLIST_URI(), null, null, null, null);
        int r8 = -1;
        if (r6 != null) goto L20;
    L17:
        if (r6 != null) goto L16;
    L19:
        return r8;
    L16:
        r6.close();
        goto L19
    L20:
    L15:
        if (r6 == null) goto L19;
    L11:
        th = move-exception;
        if (r6 == null) goto L14;
        r6.close();
    L14:
        throw th;
    L5:
        if (r6.moveToFirst() == false) goto L7;
        Cursor r0 = r6;
    L8:
        if (r0 == null) goto L17;
        r8 = r0.getInt(r0.getColumnIndex("bl_count"));     // Catch: Throwable -> L11 Exception -> L15
    L7:
        r0 = null;
        goto L8
    }

    public final Object queryBlockedNumberTotalCountAsync(ContentResolver r3, Continuation<? super Integer> r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C01592(r3, null), r4);
    }

    public final boolean queryBlockedCallAddStatus(ContentResolver r4) {
        Intrinsics.checkNotNullParameter(r4, "contentResolver");
        Bundle r5 = r4.call(BlockedCall.INSTANCE.getBLOCKED_CALL_URI(), BlockedCall.METHOD_CALL_INTERCEPT_ADD_STATUS, null, null);     // Catch: RuntimeException -> L8
        if (r5 == null) goto L11;
        return r5.getBoolean(BlockedCall.METHOD_CALL_INTERCEPT_ADD_STATUS, false);
    L11:
        return false;
    L12:
        return false;
    }

    public final Object queryBlockedCallAddStatusAsync(ContentResolver r3, Continuation<? super Boolean> r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C01552(r3, null), r4);
    }

    public final void queryBlockedCallAddStatusWithCallback(ContentResolver r3, final ICallback<Boolean> r4) {
        Intrinsics.checkNotNullParameter(r3, "contentResolver");
        Intrinsics.checkNotNullParameter(r4, "callback");
        DataRequestHandler.INSTANCE.executeRequestWithCancelable(new C01561(r3, null), new C01572(r4), new C01583(r4));
    }

    public final void clearBlockedCallAddStatus(ContentResolver r3) {
        Intrinsics.checkNotNullParameter(r3, "contentResolver");
        r3.call(BlockedCall.INSTANCE.getBLOCKED_CALL_URI(), BlockedCall.METHOD_CLEAR_CALL_INTERCEPT_ADD_STATUS, null, null);
    }

    public final Object clearBlockedCallAddStatusAsync(ContentResolver r3, Continuation<? super Unit> r4) {
        Object r2 = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(r3, null), r4);
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r2;
    L6:
        return Unit.INSTANCE;
    }

    public final void clearBlockedCallAddStatusByExecute(ContentResolver r3) {
        Intrinsics.checkNotNullParameter(r3, "contentResolver");
        DataRequestHandler.INSTANCE.executeRequestWithCancelable(new AnonymousClass1(r3, null), C01492.INSTANCE, AnonymousClass3.INSTANCE);
    }

    public final boolean queryIsPhoneNumberInWhiteList(ContentResolver r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "contentResolver");
        Intrinsics.checkNotNullParameter(r8, "phoneNumber");
        Uri r1 = Uri.parse("content://com.obric.nodisturb.provider/inwhitelist/" + r8);
        Intrinsics.checkNotNullExpressionValue(r1, "parse(this)");
        Cursor r6 = r7.query(r1, new String[]{"_id"}, null, null, null);
        Boolean r9 = null;
        if (r6 == null) goto L16;
        Cursor r10 = r6;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    L19:
        boolean r0 = r10.moveToFirst();     // Catch: Exception -> L8 Throwable -> L11
    L9:
        Boolean r2 = Boolean.valueOf(r0);     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r10, null);
        r9 = r2;
    L8:
        r0 = false;
    L16:
        if (r9 != null) goto L18;
        return false;
    L18:
        return r9.booleanValue();
    }

    public final Object queryIsPhoneNumberInWhiteListAsync(ContentResolver r3, String r4, Continuation<? super Boolean> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C01602(r3, r4, null), r5);
    }

    public final void queryIsPhoneNumberInWhiteListWithCallback(ContentResolver r3, String r4, final ICallback<Boolean> r5) {
        Intrinsics.checkNotNullParameter(r3, "contentResolver");
        Intrinsics.checkNotNullParameter(r4, "phoneNumber");
        Intrinsics.checkNotNullParameter(r5, "callback");
        DataRequestHandler.INSTANCE.executeRequestWithCancelable(new C01611(r3, r4, null), new C01622(r5), new C01633(r5));
    }

    public final boolean insertWhitelist(ContentResolver r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "contentResolver");
        Intrinsics.checkNotNullParameter(r4, "phoneNumber");
        ContentValues r0 = new ContentValues();
        r0.put("wl_phone_number", r4);
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
        BlockedDataRequester r2 = this;     // Catch: Throwable -> L5
        Uri r6 = Uri.parse("content://com.obric.nodisturb.provider/whitelist");     // Catch: Throwable -> L5
        Intrinsics.checkNotNullExpressionValue(r6, "parse(this)");     // Catch: Throwable -> L5
        Object r7 = Result.m803constructorimpl(r3.insert(r6, r0));     // Catch: Throwable -> L5
    L8:
        if (Result.m809isFailureimpl(r7) == false) goto L10;
        r7 = null;
    L10:
        if (r7 == null) goto L12;
        return true;
    L12:
        return false;
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final Object insertWhitelistAsync(ContentResolver r3, String r4, Continuation<? super Boolean> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C01512(r3, r4, null), r5);
    }

    public final void insertWhitelistWithCallback(ContentResolver r3, String r4, final ICallback<Boolean> r5) {
        Intrinsics.checkNotNullParameter(r3, "contentResolver");
        Intrinsics.checkNotNullParameter(r4, "phoneNumber");
        DataRequestHandler.INSTANCE.executeRequestWithCancelable(new C01521(r3, r4, null), new C01532(r5), new C01543(r5));
    }

    public final int deleteBlockedCall(ContentResolver r6, Set<Long> r7) {
        Intrinsics.checkNotNullParameter(r6, "contentResolver");
        Intrinsics.checkNotNullParameter(r7, "ids");
        if (r7.isEmpty() == false) goto L5;
        return 0;
    L5:
        StringBuilder r5 = new StringBuilder("_id IN (");
        Iterator<Long> r8 = r7.iterator();
        boolean r1 = true;
    L7:
        if (r8.hasNext() == false) goto L13;
        long r2 = r8.next().longValue();
        if (r1 == false) goto L11;
        r1 = false;
    L12:
        r5.append(r2);
        goto L7
    L11:
        r5.append(", ");
        goto L12
    L13:
        r5.append(")");
        return r6.delete(BlockedCall.INSTANCE.getBLOCKED_CALL_LOG_URI(), r5.toString(), null);
    }

    public final Object deleteBlockedCallAsync(ContentResolver r3, Set<Long> r4, Continuation<? super Integer> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C01502(r3, r4, null), r5);
    }
}
