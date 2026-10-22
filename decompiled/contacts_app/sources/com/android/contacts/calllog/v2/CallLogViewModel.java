package com.android.contacts.calllog.v2;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import com.GlobalProxyLancet;
import com.obric.contactsdk.loader.ContractKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: CallLogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\"\n\u0002\b\u000b\u0018\u0000 /2\u00020\u0001:\u0002/0B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\nJ\u0006\u0010\u001e\u001a\u00020\u001bJ\u0006\u0010\u001f\u001a\u00020\u001bJ\u0006\u0010 \u001a\u00020\u001bJ$\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010#\u001a\u00020\u000eH\u0002J\u0014\u0010$\u001a\u00020\u001b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00150&J\u0006\u0010'\u001a\u00020\u001bJ\u0006\u0010(\u001a\u00020\u001bJ\u0010\u0010)\u001a\u00020\u001b2\b\u0010*\u001a\u0004\u0018\u00010\fJ\u000e\u0010+\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u000eJ\u0014\u0010,\u001a\u00020\u001b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00150\tJ\u000e\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u0015R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u00061"}, d2 = {"Lcom/android/contacts/calllog/v2/CallLogViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/android/contacts/calllog/v2/CallLogRepository;", "(Lcom/android/contacts/calllog/v2/CallLogRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/android/contacts/calllog/v2/CallLogUiState;", "allItems", "", "Lcom/android/contacts/calllog/v2/CallLogItem;", "contactNumber", "", "currentTab", "Lcom/android/contacts/calllog/v2/CallLogTab;", "editModeManager", "Lcom/android/contacts/calllog/v2/EditModeManager;", "isSingleContactMode", "", "()Z", "refreshTrigger", "", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "deleteSelected", "", "deleteSingle", "item", "deselectAll", "enterEditMode", "exitEditMode", "filterByTab", "items", "tab", "optimisticDelete", "ids", "", "refresh", "selectAll", "setContactNumber", "number", "switchTab", "toggleGroupSelection", "toggleSelection", "id", "Companion", "Factory", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallLogViewModel extends ViewModel {
    public static final Companion Companion = null;
    private static final String TAG = "CallLogV2";
    private final MutableStateFlow<CallLogUiState> _uiState;
    private final MutableStateFlow<List<CallLogItem>> allItems;
    private final MutableStateFlow<String> contactNumber;
    private final MutableStateFlow<CallLogTab> currentTab;
    private final EditModeManager editModeManager;
    private final MutableStateFlow<Long> refreshTrigger;
    private final CallLogRepository repository;
    private final StateFlow<CallLogUiState> uiState;

    /* JADX INFO: renamed from: com.android.contacts.calllog.v2.CallLogViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: CallLogViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.v2.CallLogViewModel$1", f = "CallLogViewModel.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CallLogViewModel this$0;

        /* JADX INFO: renamed from: com.android.contacts.calllog.v2.CallLogViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: CallLogViewModel.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "number", "<anonymous parameter 1>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.android.contacts.calllog.v2.CallLogViewModel$1$1", f = "CallLogViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00241 extends SuspendLambda implements Function3<String, Long, Continuation<? super String>, Object> {
            /* synthetic */ Object L$0;
            int label;

            C00241(Continuation<? super C00241> r2) {
                super(3, r2);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(String r3, Long r4, Continuation<? super String> r5) {
                return invoke(r3, r4.longValue(), r5);
            }

            public final Object invoke(String r1, long r2, Continuation<? super String> r4) {
                C00241 r0 = new C00241(r4);
                r0.L$0 = r1;
                return r0.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                return (String) this.L$0;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass1(CallLogViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(this.this$0, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            Flow r7 = FlowKt.transformLatest(FlowKt.combine(CallLogViewModel.access$getContactNumber$p(this.this$0), CallLogViewModel.access$getRefreshTrigger$p(this.this$0), new C00241(null)), new CallLogViewModel$1$invokeSuspend$$inlined$flatMapLatest$1(null, this.this$0));
            final CallLogViewModel r3 = this.this$0;
            this.label = 1;
            if (r7.collect(new AnonymousClass3(r3), this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.v2.CallLogViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: CallLogViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.v2.CallLogViewModel$2", f = "CallLogViewModel.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CallLogViewModel this$0;

        /* JADX INFO: renamed from: com.android.contacts.calllog.v2.CallLogViewModel$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: CallLogViewModel.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/android/contacts/calllog/v2/CallLogItem;", "items", "tab", "Lcom/android/contacts/calllog/v2/CallLogTab;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.android.contacts.calllog.v2.CallLogViewModel$2$1", f = "CallLogViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function3<List<? extends CallLogItem>, CallLogTab, Continuation<? super List<? extends CallLogItem>>, Object> {
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;
            final /* synthetic */ CallLogViewModel this$0;

            AnonymousClass1(CallLogViewModel r1, Continuation<? super AnonymousClass1> r2) {
                this.this$0 = r1;
                super(3, r2);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(List<? extends CallLogItem> r1, CallLogTab r2, Continuation<? super List<? extends CallLogItem>> r3) {
                return invoke2(r1, r2, r3);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(List<CallLogItem> r2, CallLogTab r3, Continuation<? super List<CallLogItem>> r4) {
                AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
                r0.L$0 = r2;
                r0.L$1 = r3;
                return r0.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                List r3 = (List) this.L$0;
                CallLogTab r0 = (CallLogTab) this.L$1;
                return CallLogViewModel.access$filterByTab(this.this$0, r3, r0);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass2(CallLogViewModel r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass2(this.this$0, r2);
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
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            Flow r8 = FlowKt.combine(CallLogViewModel.access$getAllItems$p(this.this$0), CallLogViewModel.access$getCurrentTab$p(this.this$0), new AnonymousClass1(this.this$0, null));
            final CallLogViewModel r3 = this.this$0;
            this.label = 1;
            if (r8.collect(new C00252(r3), this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.v2.CallLogViewModel$3, reason: invalid class name */
    /* JADX INFO: compiled from: CallLogViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.v2.CallLogViewModel$3", f = "CallLogViewModel.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CallLogViewModel this$0;

        AnonymousClass3(CallLogViewModel r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass3(this.this$0, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass3) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            StateFlow<EditModeState> r6 = CallLogViewModel.access$getEditModeManager$p(this.this$0).getState();
            final CallLogViewModel r3 = this.this$0;
            this.label = 1;
            if (r6.collect(new AnonymousClass1(r3), this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: CallLogViewModel.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/contacts/calllog/v2/CallLogViewModel$Companion;", "", "()V", "TAG", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: CallLogViewModel.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0016¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/contacts/calllog/v2/CallLogViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "repository", "Lcom/android/contacts/calllog/v2/CallLogRepository;", "(Lcom/android/contacts/calllog/v2/CallLogRepository;)V", ContractKt.OBRIC_ACTION_CREATE, ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Factory implements ViewModelProvider.Factory {
        private final CallLogRepository repository;

        public Factory(CallLogRepository r2) {
            Intrinsics.checkNotNullParameter(r2, "repository");
            this.repository = r2;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> r2) {
            Intrinsics.checkNotNullParameter(r2, "modelClass");
            return new CallLogViewModel(this.repository);
        }
    }

    /* JADX INFO: compiled from: CallLogViewModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[CallLogTab.values().length];
            r0[CallLogTab.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[CallLogTab.MISSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[CallLogTab.SIM1.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[CallLogTab.SIM2.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.v2.CallLogViewModel$deleteSelected$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CallLogViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.v2.CallLogViewModel$deleteSelected$1", f = "CallLogViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CallLogViewModel this$0;

        C01821(CallLogViewModel r1, Continuation<? super C01821> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C01821(this.this$0, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C01821) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            Set<Long> r4 = ((CallLogUiState) CallLogViewModel.access$get_uiState$p(this.this$0).getValue()).getEditMode().getSelectedIds();
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallLogViewModel.TAG, "deleteCallLogs: ids=" + r4.size());
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallLogViewModel.TAG, "deleteCallLogs: success=" + CallLogViewModel.access$getRepository$p(this.this$0).deleteCallLogs(r4));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.v2.CallLogViewModel$deleteSingle$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CallLogViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.v2.CallLogViewModel$deleteSingle$1", f = "CallLogViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CallLogItem $item;
        int label;
        final /* synthetic */ CallLogViewModel this$0;

        C01831(CallLogItem r1, CallLogViewModel r2, Continuation<? super C01831> r3) {
            this.$item = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01831(this.$item, this.this$0, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C01831) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            Set<Long> r4 = CollectionsKt.toSet(this.$item.getChildIds());
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallLogViewModel.TAG, "deleteSingle: ids=" + r4.size());
            CallLogViewModel.access$getRepository$p(this.this$0).deleteCallLogs(r4);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.v2.CallLogViewModel$optimisticDelete$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CallLogViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.v2.CallLogViewModel$optimisticDelete$1", f = "CallLogViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Set<Long> $ids;
        int label;
        final /* synthetic */ CallLogViewModel this$0;

        C01841(CallLogViewModel r1, Set<Long> r2, Continuation<? super C01841> r3) {
            this.this$0 = r1;
            this.$ids = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01841(this.this$0, this.$ids, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C01841) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            CallLogViewModel.access$getRepository$p(this.this$0).deleteCallLogs(this.$ids);
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallLogViewModel.TAG, "[DEL-ANIM] optimisticDelete: DB delete completed, ids=" + this.$ids.size());
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ List access$filterByTab(CallLogViewModel r0, List r1, CallLogTab r2) {
        return r0.filterByTab(r1, r2);
    }

    public static final /* synthetic */ MutableStateFlow access$getAllItems$p(CallLogViewModel r0) {
        return r0.allItems;
    }

    public static final /* synthetic */ MutableStateFlow access$getContactNumber$p(CallLogViewModel r0) {
        return r0.contactNumber;
    }

    public static final /* synthetic */ MutableStateFlow access$getCurrentTab$p(CallLogViewModel r0) {
        return r0.currentTab;
    }

    public static final /* synthetic */ EditModeManager access$getEditModeManager$p(CallLogViewModel r0) {
        return r0.editModeManager;
    }

    public static final /* synthetic */ MutableStateFlow access$getRefreshTrigger$p(CallLogViewModel r0) {
        return r0.refreshTrigger;
    }

    public static final /* synthetic */ CallLogRepository access$getRepository$p(CallLogViewModel r0) {
        return r0.repository;
    }

    public static final /* synthetic */ MutableStateFlow access$get_uiState$p(CallLogViewModel r0) {
        return r0._uiState;
    }

    public CallLogViewModel(CallLogRepository r14) {
        Intrinsics.checkNotNullParameter(r14, "repository");
        this.repository = r14;
        MutableStateFlow<CallLogUiState> r15 = StateFlowKt.MutableStateFlow(new CallLogUiState(null, false, null, null, 15, null));
        this._uiState = r15;
        this.uiState = FlowKt.asStateFlow(r15);
        this.currentTab = StateFlowKt.MutableStateFlow(CallLogTab.ALL);
        this.contactNumber = StateFlowKt.MutableStateFlow(null);
        this.refreshTrigger = StateFlowKt.MutableStateFlow(0L);
        this.editModeManager = new EditModeManager();
        this.allItems = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        CallLogViewModel r0 = this;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(r0), null, null, new AnonymousClass1(this, null), 3, null);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(r0), null, null, new AnonymousClass2(this, null), 3, null);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(r0), null, null, new AnonymousClass3(this, null), 3, null);
    }

    public final StateFlow<CallLogUiState> getUiState() {
        return this.uiState;
    }

    private final List<CallLogItem> filterByTab(List<CallLogItem> r5, CallLogTab r6) {
        int r4 = WhenMappings.$EnumSwitchMapping$0[r6.ordinal()];
        if (r4 != 1) goto L5;
        return r5;
    L5:
        if (r4 == 2) goto L31;
        if (r4 != 3) goto L8;
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r5.iterator();
    L23:
        if (r8.hasNext() == false) goto L59;
        Object r0 = r8.next();
        if (((CallLogItem) r0).getSimSlot() != 0) goto L27;
        boolean r1 = true;
    L28:
        if (r1 == false) goto L23;
        r7.add(r0);
        goto L23
    L27:
        r1 = false;
        goto L28
    L59:
        return r7;
    L8:
        if (r4 != 4) goto L20;
        ArrayList r9 = new ArrayList();
        Iterator<T> r10 = r5.iterator();
    L11:
        if (r10.hasNext() == false) goto L58;
        Object r2 = r10.next();
        if (((CallLogItem) r2).getSimSlot() != 1) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == false) goto L11;
        r9.add(r2);
        goto L11
    L15:
        r3 = false;
        goto L16
    L58:
        return r9;
    L20:
        throw new NoWhenBranchMatchedException();
    L31:
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r5.iterator();
    L33:
        if (r12.hasNext() == false) goto L41;
        Object r13 = r12.next();
        if (((CallLogItem) r13).getCallType() != 3) goto L37;
        boolean r14 = true;
    L38:
        if (r14 == false) goto L33;
        r11.add(r13);
        goto L33
    L37:
        r14 = false;
        goto L38
    L41:
        return r11;
    }

    public final void switchTab(CallLogTab r3) {
        Intrinsics.checkNotNullParameter(r3, "tab");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "switchTab: " + this.currentTab.getValue() + " -> " + r3);
        this.currentTab.setValue(r3);
    }

    public final void setContactNumber(String r1) {
        this.contactNumber.setValue(r1);
    }

    public final boolean isSingleContactMode() {
        String r1 = this.contactNumber.getValue();
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        return !r2;
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L10
    }

    public final void refresh() {
        this.refreshTrigger.setValue(Long.valueOf(System.currentTimeMillis()));
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "refresh: triggered");
    }

    public final void enterEditMode() {
        this.editModeManager.enter();
    }

    public final void exitEditMode() {
        this.editModeManager.exit();
    }

    public final void toggleSelection(long r1) {
        this.editModeManager.toggle(r1);
    }

    public final void toggleGroupSelection(List<Long> r4) {
        Intrinsics.checkNotNullParameter(r4, "ids");
        List<CallLogItem> r0 = this._uiState.getValue().getItems();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        CollectionsKt.addAll(r1, ((CallLogItem) r2.next()).getChildIds());
        goto L4
    L6:
        this.editModeManager.toggleGroup(r4, r1);
    }

    public final void selectAll() {
        List<CallLogItem> r0 = this._uiState.getValue().getItems();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        CollectionsKt.addAll(r1, ((CallLogItem) r2.next()).getChildIds());
        goto L4
    L6:
        EditModeManager r3 = this.editModeManager;
        r3.selectAll(r1);
    }

    public final void deselectAll() {
        this.editModeManager.deselectAll();
    }

    public final void deleteSelected() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01821(this, null), 2, null);
    }

    public final void deleteSingle(CallLogItem r8) {
        Intrinsics.checkNotNullParameter(r8, "item");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01831(r8, this, null), 2, null);
    }

    public final void optimisticDelete(Set<Long> r9) {
        Intrinsics.checkNotNullParameter(r9, "ids");
        List<CallLogItem> r0 = this.allItems.getValue();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L18;
        Object r3 = r2.next();
        List<Long> r4 = ((CallLogItem) r3).getChildIds();
        boolean r5 = false;
        if ((r4 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r6 = r4.iterator();
    L12:
        if (r6.hasNext() == false) goto L16;
        if (r9.contains(Long.valueOf(((Number) r6.next()).longValue())) == false) goto L12;
        r5 = true;
    L16:
        if (r5 == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        if (r4.isEmpty() == false) goto L10;
    L18:
        ArrayList r7 = r1;
        if (r7.isEmpty() == false) goto L21;
        return;
    L21:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "[DEL-ANIM] optimisticDelete: removing " + r7.size() + " items from memory, ids=" + r9.size());
        MutableStateFlow<List<CallLogItem>> r8 = this.allItems;
        r8.setValue(CollectionsKt.minus(r8.getValue(), CollectionsKt.toSet(r7)));
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "[DEL-ANIM] optimisticDelete: allItems emitted, new size=" + this.allItems.getValue().size());
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01841(this, r9, null), 2, null);
    }
}
