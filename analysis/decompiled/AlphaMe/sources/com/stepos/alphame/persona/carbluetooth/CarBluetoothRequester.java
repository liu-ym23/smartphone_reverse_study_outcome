package com.stepos.alphame.persona.carbluetooth;

import Z2.F;
import Z2.I;
import Z2.Q;
import androidx.lifecycle.U;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.R;
import com.stepos.alphame.common.data.DataStoreManager;
import com.stepos.alphame.common.data.DataStorePreferences;
import com.stepos.alphame.persona.carbluetooth.bean.BluetoothInfo;
import com.stepos.alphame.persona.common.list.PersonalCommonRequester;
import com.stepos.alphame.persona.data.repo.PersonalRepo;
import com.stepos.alphame.persona.domain.event.EventId;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t0.J;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R$\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0016j\b\u0012\u0004\u0012\u00020\u0007`\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001d\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r8F¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/stepos/alphame/persona/carbluetooth/CarBluetoothRequester;", "Lcom/stepos/alphame/persona/common/list/PersonalCommonRequester;", "", "requestDataList", "()V", "", "selectedIndex", "Lcom/stepos/alphame/persona/carbluetooth/bean/BluetoothInfo;", "getBluetoothResult", "(I)Lcom/stepos/alphame/persona/carbluetooth/bean/BluetoothInfo;", "result", "saveData", "(Lcom/stepos/alphame/persona/carbluetooth/bean/BluetoothInfo;)V", "Landroidx/lifecycle/U;", "", "Lcom/stepos/alphame/persona/common/list/PersonalCommonEntity;", "_dataList", "Landroidx/lifecycle/U;", "", "autoLearningBluetoothTip", "Ljava/lang/String;", "learning", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mBluetoothInfoList", "Ljava/util/ArrayList;", "Lcom/stepos/alphame/persona/data/repo/PersonalRepo;", "repo", "Lcom/stepos/alphame/persona/data/repo/PersonalRepo;", "Lcom/stepos/alphame/common/data/DataStorePreferences;", "mDataStore", "Lcom/stepos/alphame/common/data/DataStorePreferences;", "getDataList", "()Landroidx/lifecycle/U;", "dataList", "<init>", "app_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class CarBluetoothRequester extends PersonalCommonRequester {

    @NotNull
    private U _dataList = new U();

    @NotNull
    private final String autoLearningBluetoothTip;

    @NotNull
    private final String learning;

    @NotNull
    private final ArrayList<BluetoothInfo> mBluetoothInfoList;

    @NotNull
    private final DataStorePreferences mDataStore;

    @NotNull
    private final PersonalRepo repo;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.persona.carbluetooth.CarBluetoothRequester$requestDataList$1", f = "CarBluetoothRequester.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nCarBluetoothRequester.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CarBluetoothRequester.kt\ncom/stepos/alphame/persona/carbluetooth/CarBluetoothRequester$requestDataList$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,115:1\n1655#2,8:116\n*S KotlinDebug\n*F\n+ 1 CarBluetoothRequester.kt\ncom/stepos/alphame/persona/carbluetooth/CarBluetoothRequester$requestDataList$1\n*L\n83#1:116,8\n*E\n"})
    /* renamed from: com.stepos.alphame.persona.carbluetooth.CarBluetoothRequester$requestDataList$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return CarBluetoothRequester.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x00b8  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
            /*
                Method dump skipped, instructions count: 492
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.persona.carbluetooth.CarBluetoothRequester.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public CarBluetoothRequester() {
        String string = ApplicationImpl.getApplication().getString(R.string.automatic_learning_bluetooth);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.autoLearningBluetoothTip = string;
        String string2 = ApplicationImpl.getApplication().getString(R.string.learning);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.learning = string2;
        this.mBluetoothInfoList = new ArrayList<>();
        this.repo = PersonalRepo.INSTANCE.getINSTANCE();
        this.mDataStore = DataStoreManager.INSTANCE.getDataStore("personalPreference");
    }

    @NotNull
    public final BluetoothInfo getBluetoothResult(int selectedIndex) {
        if (selectedIndex < 0 || selectedIndex >= this.mBluetoothInfoList.size()) {
            return new BluetoothInfo();
        }
        BluetoothInfo bluetoothInfo = this.mBluetoothInfoList.get(selectedIndex);
        Intrinsics.checkNotNullExpressionValue(bluetoothInfo, "get(...)");
        return bluetoothInfo;
    }

    @NotNull
    /* renamed from: getDataList, reason: from getter */
    public final U get_dataList() {
        return this._dataList;
    }

    @Override // com.stepos.alphame.persona.common.list.PersonalCommonRequester
    public void requestDataList() {
        J.y(I.t(this), Q.f2190b, new AnonymousClass1(null), 2);
    }

    public final void saveData(@NotNull BluetoothInfo result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.repo.setCarBluetoothInfo(EventId.CAR_BLUETOOTH, result);
    }
}
