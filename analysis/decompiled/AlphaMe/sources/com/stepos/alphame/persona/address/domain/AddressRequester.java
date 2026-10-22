package com.stepos.alphame.persona.address.domain;

import Z2.F;
import Z2.I;
import Z2.Q;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.P;
import androidx.lifecycle.U;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.database.EngineRoomDatabase;
import com.stepos.alphame.location.LocationManager;
import com.stepos.alphame.location.MapLocation;
import com.stepos.alphame.location.MapLocationClient;
import com.stepos.alphame.location.MapLocationListener;
import com.stepos.alphame.persona.PersonalContract;
import com.stepos.alphame.persona.address.contract.IAddressRequester;
import com.stepos.alphame.persona.address.data.AddressEntity;
import com.stepos.alphame.persona.address.data.AddressInfo;
import com.stepos.alphame.persona.address.data.AddressPage;
import com.stepos.alphame.persona.address.data.AddressTipBean;
import com.stepos.alphame.persona.address.domain.AddressRequester;
import com.stepos.alphame.persona.data.PersonalDataType;
import com.stepos.alphame.persona.data.repo.PersonalRepo;
import com.stepos.alphame.persona.domain.event.EventId;
import com.stepos.alphame.utils.AlphaMeLogger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t0.J;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\\\u0010\u0014J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\fJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010\fJ\r\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010 \u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010\u0014J\u0017\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0016H\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\r2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b,\u0010-R\"\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0/0.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\"\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0/0.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00101R\u0016\u00103\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020\r0.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00101R\u0017\u00106\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R$\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\r0:j\b\u0012\u0004\u0012\u00020\r`;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R$\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\r0:j\b\u0012\u0004\u0012\u00020\r`;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010=R$\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\r0:j\b\u0012\u0004\u0012\u00020\r`;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010=R\u0018\u0010@\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010B\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010AR\u0016\u0010D\u001a\u00020C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u001d\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0/0K8F¢\u0006\u0006\u001a\u0004\bL\u0010MR\u001d\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0/0K8F¢\u0006\u0006\u001a\u0004\bO\u0010MR\u0017\u0010R\u001a\b\u0012\u0004\u0012\u00020\r0K8F¢\u0006\u0006\u001a\u0004\bQ\u0010MR\u0013\u0010U\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0011\u0010X\u001a\u00020C8F¢\u0006\u0006\u001a\u0004\bV\u0010WR\u0011\u0010[\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bY\u0010Z¨\u0006]"}, d2 = {"Lcom/stepos/alphame/persona/address/domain/AddressRequester;", "LR1/a;", "Lcom/stepos/alphame/persona/address/contract/IAddressRequester;", "", "id", "", "setPageId", "(I)V", "setEventId", "Landroid/content/Context;", CoreConstants.CONTEXT_SCOPE_VALUE, "requestHistoricalAddressRecords", "(Landroid/content/Context;)V", "Lcom/stepos/alphame/persona/address/data/AddressEntity;", "addressEntity", "updateHistoricalAddressRecords", "(Landroid/content/Context;Lcom/stepos/alphame/persona/address/data/AddressEntity;)V", "requestData", "requestCurrentLocation", "requestCacheMainAddressList", "()V", "selectedIndex", "Lcom/stepos/alphame/persona/address/data/AddressInfo;", "getFinalResult", "(I)Lcom/stepos/alphame/persona/address/data/AddressInfo;", "result", "saveData", "(Lcom/stepos/alphame/persona/address/data/AddressInfo;)V", "currentAddressEntity", "", "isEnterAddressPageFirstly", "isCacheCurrentAddress", "requestAddressTipsWhenShowMainPage", "(Lcom/stepos/alphame/persona/address/data/AddressEntity;ZZ)V", "requestCacheCurrentLocation", "", "tip", "requestAddressTipsWhenShowSearchPage", "(Ljava/lang/String;)V", "addressInfo", "addressInfo2AddressEntity", "(Lcom/stepos/alphame/persona/address/data/AddressInfo;)Lcom/stepos/alphame/persona/address/data/AddressEntity;", "Lcom/stepos/alphame/persona/address/data/AddressTipBean;", "addressTipBean", "addressTipBean2AddressEntity", "(Lcom/stepos/alphame/persona/address/data/AddressTipBean;)Lcom/stepos/alphame/persona/address/data/AddressEntity;", "Landroidx/lifecycle/U;", "", "_mainAddressResult", "Landroidx/lifecycle/U;", "_searchAddressResult", "city", "Ljava/lang/String;", "_locationAddressEntity", "autoLearningState", "Z", PersonalContract.FUN_GET_AUTO_LEARNING_STATE, "()Z", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mCacheMainAddressTipList", "Ljava/util/ArrayList;", "mCurrentAddressTipList", "mHistoryAddressList", "mLearningAddress", "Lcom/stepos/alphame/persona/address/data/AddressEntity;", "mCurrentAddress", "Lcom/stepos/alphame/persona/domain/event/EventId;", "_eventId", "Lcom/stepos/alphame/persona/domain/event/EventId;", "_pageId", "I", "Lcom/stepos/alphame/persona/data/repo/PersonalRepo;", "repo", "Lcom/stepos/alphame/persona/data/repo/PersonalRepo;", "Landroidx/lifecycle/P;", "getMainAddressResult", "()Landroidx/lifecycle/P;", "mainAddressResult", "getSearchAddressResult", "searchAddressResult", "getLocationAddressEntity", "locationAddressEntity", "getCurrentAddress", "()Lcom/stepos/alphame/persona/address/data/AddressEntity;", "currentAddress", "getEventId", "()Lcom/stepos/alphame/persona/domain/event/EventId;", "eventId", "getPageId", "()I", "pageId", "<init>", "app_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nAddressRequester.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AddressRequester.kt\ncom/stepos/alphame/persona/address/domain/AddressRequester\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,333:1\n766#2:334\n857#2,2:335\n1#3:337\n*S KotlinDebug\n*F\n+ 1 AddressRequester.kt\ncom/stepos/alphame/persona/address/domain/AddressRequester\n*L\n125#1:334\n125#1:335,2\n*E\n"})
/* loaded from: classes.dex */
public final class AddressRequester extends R1.a implements IAddressRequester {

    @NotNull
    private EventId _eventId;
    private int _pageId;
    private final boolean autoLearningState;

    @NotNull
    private final ArrayList<AddressEntity> mCacheMainAddressTipList;

    @Nullable
    private AddressEntity mCurrentAddress;

    @NotNull
    private final ArrayList<AddressEntity> mCurrentAddressTipList;

    @NotNull
    private final ArrayList<AddressEntity> mHistoryAddressList;

    @Nullable
    private AddressEntity mLearningAddress;

    @NotNull
    private final PersonalRepo repo;

    @NotNull
    private U _mainAddressResult = new U();

    @NotNull
    private U _searchAddressResult = new U();

    @NotNull
    private String city = "珠海市";

    @NotNull
    private U _locationAddressEntity = new U();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.persona.address.domain.AddressRequester$requestAddressTipsWhenShowMainPage$1", f = "AddressRequester.kt", i = {}, l = {235}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nAddressRequester.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AddressRequester.kt\ncom/stepos/alphame/persona/address/domain/AddressRequester$requestAddressTipsWhenShowMainPage$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,333:1\n766#2:334\n857#2,2:335\n766#2:337\n857#2,2:338\n*S KotlinDebug\n*F\n+ 1 AddressRequester.kt\ncom/stepos/alphame/persona/address/domain/AddressRequester$requestAddressTipsWhenShowMainPage$1\n*L\n284#1:334\n284#1:335,2\n285#1:337\n285#1:338,2\n*E\n"})
    /* renamed from: com.stepos.alphame.persona.address.domain.AddressRequester$requestAddressTipsWhenShowMainPage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        final /* synthetic */ AddressEntity $currentAddressEntity;
        final /* synthetic */ boolean $isCacheCurrentAddress;
        final /* synthetic */ boolean $isEnterAddressPageFirstly;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AddressEntity addressEntity, boolean z4, boolean z5, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$currentAddressEntity = addressEntity;
            this.$isEnterAddressPageFirstly = z4;
            this.$isCacheCurrentAddress = z5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return AddressRequester.this.new AnonymousClass1(this.$currentAddressEntity, this.$isEnterAddressPageFirstly, this.$isCacheCurrentAddress, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00cb  */
        /* JADX WARN: Type inference failed for: r3v6, types: [T, com.stepos.alphame.persona.address.data.AddressInfo, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
            /*
                Method dump skipped, instructions count: 539
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.persona.address.domain.AddressRequester.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.persona.address.domain.AddressRequester$requestAddressTipsWhenShowSearchPage$1", f = "AddressRequester.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nAddressRequester.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AddressRequester.kt\ncom/stepos/alphame/persona/address/domain/AddressRequester$requestAddressTipsWhenShowSearchPage$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,333:1\n766#2:334\n857#2,2:335\n*S KotlinDebug\n*F\n+ 1 AddressRequester.kt\ncom/stepos/alphame/persona/address/domain/AddressRequester$requestAddressTipsWhenShowSearchPage$1\n*L\n326#1:334\n326#1:335,2\n*E\n"})
    /* renamed from: com.stepos.alphame.persona.address.domain.AddressRequester$requestAddressTipsWhenShowSearchPage$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04761 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $tip;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04761(String str, Continuation<? super C04761> continuation) {
            super(2, continuation);
            this.$tip = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return AddressRequester.this.new C04761(this.$tip, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((C04761) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List<AddressTipBean> listRequestAddressTipsV1 = AddressRequester.this.repo.requestAddressTipsV1(this.$tip, AddressRequester.this.city);
            ArrayList arrayList = new ArrayList();
            AlphaMeLogger.debugLog(PersonalContract.ADDRESS_TAG, "requestAddressTips list " + listRequestAddressTipsV1.size());
            Iterator<AddressTipBean> it = listRequestAddressTipsV1.iterator();
            while (it.hasNext()) {
                AddressEntity addressEntityAddressTipBean2AddressEntity = AddressRequester.this.addressTipBean2AddressEntity(it.next());
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : arrayList) {
                    if (Intrinsics.areEqual(((AddressEntity) obj2).getName(), addressEntityAddressTipBean2AddressEntity.getName())) {
                        arrayList2.add(obj2);
                    }
                }
                arrayList.add(addressEntityAddressTipBean2AddressEntity);
            }
            AddressRequester.this._searchAddressResult.h(arrayList);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.persona.address.domain.AddressRequester$requestCurrentLocation$1", f = "AddressRequester.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.persona.address.domain.AddressRequester$requestCurrentLocation$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04771 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;
        final /* synthetic */ AddressRequester this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04771(Context context, AddressRequester addressRequester, Continuation<? super C04771> continuation) {
            super(2, continuation);
            this.$context = context;
            this.this$0 = addressRequester;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(AddressRequester addressRequester, MapLocation mapLocation) {
            if (mapLocation != null && !TextUtils.isEmpty(mapLocation.getCity())) {
                AlphaMeLogger.debugLog(PersonalContract.ADDRESS_TAG, "current location " + mapLocation);
                String city = mapLocation.getCity();
                Intrinsics.checkNotNullExpressionValue(city, "getCity(...)");
                addressRequester.city = city;
                if (!TextUtils.isEmpty(mapLocation.getAddress())) {
                    long type = PersonalDataType.CUSTOM.getType();
                    String address = mapLocation.getAddress();
                    Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
                    String district = mapLocation.getDistrict();
                    Intrinsics.checkNotNullExpressionValue(district, "getDistrict(...)");
                    addressRequester.mCurrentAddress = new AddressEntity(type, address, district, mapLocation.getLongitude(), mapLocation.getLatitude(), false);
                }
            }
            addressRequester.requestAddressTipsWhenShowMainPage(addressRequester.mCurrentAddress, false, true);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C04771(this.$context, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((C04771) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            MapLocationClient locationClient = LocationManager.INSTANCE.getINSTANCE().getLocationClient(this.$context);
            final AddressRequester addressRequester = this.this$0;
            locationClient.setLocationListener(new MapLocationListener() { // from class: com.stepos.alphame.persona.address.domain.a
                @Override // com.stepos.alphame.location.MapLocationListener
                public final void onLocationChanged(MapLocation mapLocation) {
                    AddressRequester.C04771.invokeSuspend$lambda$0(addressRequester, mapLocation);
                }
            });
            locationClient.stopLocation();
            locationClient.startLocation();
            AlphaMeLogger.debugLog(PersonalContract.ADDRESS_TAG, "start location");
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.persona.address.domain.AddressRequester$requestHistoricalAddressRecords$1", f = "AddressRequester.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.persona.address.domain.AddressRequester$requestHistoricalAddressRecords$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04781 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;
        final /* synthetic */ AddressRequester this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04781(Context context, AddressRequester addressRequester, Continuation<? super C04781> continuation) {
            super(2, continuation);
            this.$context = context;
            this.this$0 = addressRequester;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C04781(this.$context, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((C04781) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                List<AddressEntity> historyAddressList = EngineRoomDatabase.INSTANCE.getDatabase(this.$context).getHistoryAddressDao().getHistoryAddressList();
                AlphaMeLogger.debugLog("Personal", "data " + historyAddressList);
                this.this$0.mHistoryAddressList.addAll(historyAddressList);
                this.this$0._searchAddressResult.h(this.this$0.mHistoryAddressList);
            } catch (Exception unused) {
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.persona.address.domain.AddressRequester$updateHistoricalAddressRecords$1", f = "AddressRequester.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.persona.address.domain.AddressRequester$updateHistoricalAddressRecords$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04791 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        final /* synthetic */ AddressEntity $addressEntity;
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04791(Context context, AddressEntity addressEntity, Continuation<? super C04791> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$addressEntity = addressEntity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C04791(this.$context, this.$addressEntity, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((C04791) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            EngineRoomDatabase.INSTANCE.getDatabase(this.$context).getHistoryAddressDao().insertAddress(this.$addressEntity);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.persona.address.domain.AddressRequester$updateHistoricalAddressRecords$2", f = "AddressRequester.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nAddressRequester.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AddressRequester.kt\ncom/stepos/alphame/persona/address/domain/AddressRequester$updateHistoricalAddressRecords$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,333:1\n1054#2:334\n*S KotlinDebug\n*F\n+ 1 AddressRequester.kt\ncom/stepos/alphame/persona/address/domain/AddressRequester$updateHistoricalAddressRecords$2\n*L\n137#1:334\n*E\n"})
    /* renamed from: com.stepos.alphame.persona.address.domain.AddressRequester$updateHistoricalAddressRecords$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ List<AddressEntity> $existedAddress;
        int label;
        final /* synthetic */ AddressRequester this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(List<AddressEntity> list, AddressRequester addressRequester, Context context, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$existedAddress = list;
            this.this$0 = addressRequester;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(this.$existedAddress, this.this$0, this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$existedAddress.get(0).setUpdateTime(System.currentTimeMillis());
            CollectionsKt.sortedWith(this.this$0.mHistoryAddressList, new Comparator() { // from class: com.stepos.alphame.persona.address.domain.AddressRequester$updateHistoricalAddressRecords$2$invokeSuspend$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t4, T t5) {
                    return ComparisonsKt.compareValues(Long.valueOf(((AddressEntity) t5).getUpdateTime()), Long.valueOf(((AddressEntity) t4).getUpdateTime()));
                }
            });
            AlphaMeLogger.debugLog(PersonalContract.ADDRESS_TAG, " sortedByDescending " + this.this$0.mHistoryAddressList);
            EngineRoomDatabase.INSTANCE.getDatabase(this.$context).getHistoryAddressDao().updateAddress(this.$existedAddress.get(0));
            return Unit.INSTANCE;
        }
    }

    public AddressRequester() {
        PersonalRepo.Companion companion = PersonalRepo.INSTANCE;
        this.autoLearningState = companion.getINSTANCE().getAutoLearningState();
        this.mCacheMainAddressTipList = new ArrayList<>();
        this.mCurrentAddressTipList = new ArrayList<>();
        this.mHistoryAddressList = new ArrayList<>();
        this._eventId = EventId.HOME_ADDRESS;
        this._pageId = AddressPage.MainPage.getType();
        this.repo = companion.getINSTANCE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AddressEntity addressInfo2AddressEntity(AddressInfo addressInfo) {
        try {
            List listSplit$default = StringsKt__StringsKt.split$default(addressInfo.getLocation(), new String[]{","}, false, 0, 6, (Object) null);
            if (listSplit$default.size() == 2) {
                return new AddressEntity(addressInfo.getType(), addressInfo.getName(), addressInfo.getDistrict(), Double.parseDouble((String) listSplit$default.get(0)), Double.parseDouble((String) listSplit$default.get(1)), false);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return new AddressEntity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AddressEntity addressTipBean2AddressEntity(AddressTipBean addressTipBean) {
        try {
            List listSplit$default = StringsKt__StringsKt.split$default(addressTipBean.getLocation(), new String[]{","}, false, 0, 6, (Object) null);
            if (listSplit$default.size() == 2) {
                return new AddressEntity(PersonalDataType.CUSTOM.getType(), addressTipBean.getName(), addressTipBean.getDistrict(), Double.parseDouble((String) listSplit$default.get(0)), Double.parseDouble((String) listSplit$default.get(1)), false);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return new AddressEntity();
    }

    public final boolean getAutoLearningState() {
        return this.autoLearningState;
    }

    @Nullable
    /* renamed from: getCurrentAddress, reason: from getter */
    public final AddressEntity getMCurrentAddress() {
        return this.mCurrentAddress;
    }

    @NotNull
    /* renamed from: getEventId, reason: from getter */
    public final EventId get_eventId() {
        return this._eventId;
    }

    @NotNull
    public final AddressInfo getFinalResult(int selectedIndex) {
        if (selectedIndex < 0 || selectedIndex >= this.mCacheMainAddressTipList.size()) {
            return new AddressInfo();
        }
        AddressEntity addressEntity = this.mCacheMainAddressTipList.get(selectedIndex);
        Intrinsics.checkNotNullExpressionValue(addressEntity, "get(...)");
        AddressEntity addressEntity2 = addressEntity;
        AlphaMeLogger.debugLog(PersonalContract.ADDRESS_TAG, "get addressEntity " + addressEntity2);
        return new AddressInfo(addressEntity2.getType(), addressEntity2.getName(), addressEntity2.getDistrict(), addressEntity2.getLongitude() + "," + addressEntity2.getLatitude());
    }

    @NotNull
    public final P getLocationAddressEntity() {
        return this._locationAddressEntity;
    }

    @NotNull
    public final P getMainAddressResult() {
        return this._mainAddressResult;
    }

    /* renamed from: getPageId, reason: from getter */
    public final int get_pageId() {
        return this._pageId;
    }

    @NotNull
    public final P getSearchAddressResult() {
        return this._searchAddressResult;
    }

    @Override // com.stepos.alphame.persona.address.contract.IAddressRequester
    public void requestAddressTipsWhenShowMainPage(@Nullable AddressEntity currentAddressEntity, boolean isEnterAddressPageFirstly, boolean isCacheCurrentAddress) {
        J.y(I.t(this), Q.f2190b, new AnonymousClass1(currentAddressEntity, isEnterAddressPageFirstly, isCacheCurrentAddress, null), 2);
    }

    @Override // com.stepos.alphame.persona.address.contract.IAddressRequester
    public void requestAddressTipsWhenShowSearchPage(@NotNull String tip) {
        Intrinsics.checkNotNullParameter(tip, "tip");
        J.y(I.t(this), Q.f2190b, new C04761(tip, null), 2);
    }

    @Override // com.stepos.alphame.persona.address.contract.IAddressRequester
    public void requestCacheCurrentLocation() {
        ArrayList arrayList = new ArrayList();
        AddressEntity addressEntity = this.mLearningAddress;
        if (addressEntity != null) {
            arrayList.add(addressEntity);
        }
        AddressEntity addressEntity2 = this.mCurrentAddress;
        if (addressEntity2 != null) {
            arrayList.add(addressEntity2);
        }
        arrayList.addAll(this.mCurrentAddressTipList);
        this._mainAddressResult.g(arrayList);
    }

    public final void requestCacheMainAddressList() {
        this._mainAddressResult.g(this.mCacheMainAddressTipList);
    }

    @Override // com.stepos.alphame.persona.address.contract.IAddressRequester
    public void requestCurrentLocation(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        J.y(I.t(this), Q.f2190b, new C04771(context, this, null), 2);
    }

    @Override // com.stepos.alphame.persona.address.contract.IAddressRequester
    public void requestData(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AlphaMeLogger.debugLog(PersonalContract.ADDRESS_TAG, " requestData");
        AddressInfo addressInfo = this.repo.getAddressInfo(get_eventId());
        if (TextUtils.isEmpty(addressInfo.getName()) || TextUtils.isEmpty(addressInfo.getLocation())) {
            requestCurrentLocation(context);
            return;
        }
        AddressEntity addressEntityAddressInfo2AddressEntity = addressInfo2AddressEntity(addressInfo);
        if (TextUtils.isEmpty(addressEntityAddressInfo2AddressEntity.getName())) {
            requestCurrentLocation(context);
        } else {
            requestAddressTipsWhenShowMainPage(addressEntityAddressInfo2AddressEntity, true, false);
        }
    }

    @Override // com.stepos.alphame.persona.address.contract.IAddressRequester
    public void requestHistoricalAddressRecords(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.mHistoryAddressList.size() != 0) {
            this._searchAddressResult.g(CollectionsKt___CollectionsKt.take(this.mHistoryAddressList, 5));
        } else {
            J.y(I.t(this), Q.f2190b, new C04781(context, this, null), 2);
        }
    }

    public final void saveData(@NotNull AddressInfo result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.repo.setAddressInfo(get_eventId(), result);
    }

    public final void setEventId(int id) {
        AlphaMeLogger.debugLog(PersonalContract.ADDRESS_TAG, "page " + id);
        EventId eventId = EventId.HOME_ADDRESS;
        if (id != eventId.getId()) {
            eventId = EventId.COMPANY_ADDRESS;
        }
        this._eventId = eventId;
    }

    public final void setPageId(int id) {
        this._pageId = id;
    }

    @Override // com.stepos.alphame.persona.address.contract.IAddressRequester
    public void updateHistoricalAddressRecords(@NotNull Context context, @NotNull AddressEntity addressEntity) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(addressEntity, "addressEntity");
        addressEntity.setUpdateTime(System.currentTimeMillis());
        ArrayList<AddressEntity> arrayList = this.mHistoryAddressList;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (Intrinsics.areEqual(((AddressEntity) obj).getName(), addressEntity.getName())) {
                arrayList2.add(obj);
            }
        }
        AlphaMeLogger.debugLog(PersonalContract.ADDRESS_TAG, "size " + arrayList2.size());
        try {
            if (arrayList2.isEmpty()) {
                this.mHistoryAddressList.add(0, addressEntity);
                J.y(I.t(this), Q.f2190b, new C04791(context, addressEntity, null), 2);
            } else {
                J.y(I.t(this), Q.f2190b, new AnonymousClass2(arrayList2, this, context, null), 2);
            }
        } catch (Exception unused) {
        }
    }
}
