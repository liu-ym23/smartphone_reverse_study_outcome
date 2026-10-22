package com.stepos.alphame.persona.information_used.domain;

import R1.a;
import Z2.F;
import Z2.I;
import androidx.lifecycle.P;
import androidx.lifecycle.U;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.R;
import com.stepos.alphame.persona.data.config.PersonalPreferenceConfigs;
import com.stepos.alphame.persona.information_used.data.InformationUsedEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t0.J;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R \u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR<\u0010\u0012\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f0\u000ej\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f`\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/stepos/alphame/persona/information_used/domain/InformationUsedRequester;", "LR1/a;", "", "requestDataList", "()V", "Landroidx/lifecycle/U;", "", "Lcom/stepos/alphame/persona/information_used/data/InformationUsedEntity;", "_dataList", "Landroidx/lifecycle/U;", "Lcom/stepos/alphame/ApplicationImpl;", "kotlin.jvm.PlatformType", CoreConstants.CONTEXT_SCOPE_VALUE, "Lcom/stepos/alphame/ApplicationImpl;", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "", "Lkotlin/collections/ArrayList;", "pairList", "Ljava/util/ArrayList;", "Landroidx/lifecycle/P;", "getDataList", "()Landroidx/lifecycle/P;", "dataList", "<init>", "app_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class InformationUsedRequester extends a {

    @NotNull
    private final U _dataList = new U();
    private final ApplicationImpl context;

    @NotNull
    private final ArrayList<Pair<String, String>> pairList;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.persona.information_used.domain.InformationUsedRequester$requestDataList$1", f = "InformationUsedRequester.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.persona.information_used.domain.InformationUsedRequester$requestDataList$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return InformationUsedRequester.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList = new ArrayList();
            int size = PersonalPreferenceConfigs.INSTANCE.getKeyList().size();
            for (int i4 = 0; i4 < size; i4++) {
                Object obj2 = InformationUsedRequester.this.pairList.get(i4);
                Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
                Pair pair = (Pair) obj2;
                PersonalPreferenceConfigs personalPreferenceConfigs = PersonalPreferenceConfigs.INSTANCE;
                String str = personalPreferenceConfigs.getKeyList().get(i4);
                Intrinsics.checkNotNullExpressionValue(str, "get(...)");
                boolean zBooleanValue = ((Boolean) personalPreferenceConfigs.getData(str, Boxing.boxBoolean(true))).booleanValue();
                Object first = pair.getFirst();
                Intrinsics.checkNotNullExpressionValue(first, "<get-first>(...)");
                Object second = pair.getSecond();
                Intrinsics.checkNotNullExpressionValue(second, "<get-second>(...)");
                arrayList.add(new InformationUsedEntity((String) first, (String) second, zBooleanValue));
            }
            InformationUsedRequester.this._dataList.g(arrayList);
            return Unit.INSTANCE;
        }
    }

    public InformationUsedRequester() {
        ApplicationImpl application = ApplicationImpl.getApplication();
        this.context = application;
        this.pairList = CollectionsKt.arrayListOf(new Pair(application.getString(R.string.voice_app), application.getString(R.string.use_address_information)), new Pair(application.getString(R.string.note_app), application.getString(R.string.use_address_information)), new Pair(application.getString(R.string.setting_app), application.getString(R.string.use_address_information)), new Pair(application.getString(R.string.system_ui_tool_app), application.getString(R.string.use_address_information)), new Pair(application.getString(R.string.aicy_butler), application.getString(R.string.use_address_information)), new Pair(application.getString(R.string.weather), application.getString(R.string.use_address_information)));
    }

    @NotNull
    public final P getDataList() {
        return this._dataList;
    }

    public final void requestDataList() {
        J.y(I.t(this), null, new AnonymousClass1(null), 3);
    }
}
