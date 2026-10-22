package com.stepos.alphame.persona.wifi;

import Z2.F;
import Z2.I;
import Z2.Q;
import androidx.lifecycle.P;
import androidx.lifecycle.U;
import com.stepos.alphame.persona.common.list.PersonalCommonRequester;
import com.stepos.alphame.persona.data.repo.PersonalRepo;
import com.stepos.alphame.persona.domain.event.EventId;
import com.stepos.alphame.persona.wifi.bean.WifiInfo;
import com.stepos.alphame.utils.AlphaMeLogger;
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

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R$\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0018j\b\u0012\u0004\u0012\u00020\n`\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001d\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0011\u0010%\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/stepos/alphame/persona/wifi/WifiRequester;", "Lcom/stepos/alphame/persona/common/list/PersonalCommonRequester;", "", "id", "", "setEventId", "(I)V", "requestDataList", "()V", "selectedIndex", "Lcom/stepos/alphame/persona/wifi/bean/WifiInfo;", "getWifiResult", "(I)Lcom/stepos/alphame/persona/wifi/bean/WifiInfo;", "result", "saveData", "(Lcom/stepos/alphame/persona/wifi/bean/WifiInfo;)V", "Landroidx/lifecycle/U;", "", "Lcom/stepos/alphame/persona/common/list/PersonalCommonEntity;", "_dataList", "Landroidx/lifecycle/U;", "Lcom/stepos/alphame/persona/domain/event/EventId;", "_eventId", "Lcom/stepos/alphame/persona/domain/event/EventId;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mWifiInfoList", "Ljava/util/ArrayList;", "Lcom/stepos/alphame/persona/data/repo/PersonalRepo;", "repo", "Lcom/stepos/alphame/persona/data/repo/PersonalRepo;", "Landroidx/lifecycle/P;", "getDataList", "()Landroidx/lifecycle/P;", "dataList", "getEventId", "()Lcom/stepos/alphame/persona/domain/event/EventId;", "eventId", "<init>", "app_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class WifiRequester extends PersonalCommonRequester {

    @NotNull
    private U _dataList = new U();

    @NotNull
    private EventId _eventId = EventId.HOME_WIFI;

    @NotNull
    private final ArrayList<WifiInfo> mWifiInfoList = new ArrayList<>();

    @NotNull
    private final PersonalRepo repo = PersonalRepo.INSTANCE.getINSTANCE();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.persona.wifi.WifiRequester$requestDataList$1", f = "WifiRequester.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nWifiRequester.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WifiRequester.kt\ncom/stepos/alphame/persona/wifi/WifiRequester$requestDataList$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,115:1\n1655#2,8:116\n*S KotlinDebug\n*F\n+ 1 WifiRequester.kt\ncom/stepos/alphame/persona/wifi/WifiRequester$requestDataList$1\n*L\n86#1:116,8\n*E\n"})
    /* renamed from: com.stepos.alphame.persona.wifi.WifiRequester$requestDataList$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return WifiRequester.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x00b1  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
            /*
                Method dump skipped, instructions count: 445
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.persona.wifi.WifiRequester.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @NotNull
    public final P getDataList() {
        return this._dataList;
    }

    @NotNull
    /* renamed from: getEventId, reason: from getter */
    public final EventId get_eventId() {
        return this._eventId;
    }

    @NotNull
    public final WifiInfo getWifiResult(int selectedIndex) {
        if (selectedIndex < 0 || selectedIndex >= this.mWifiInfoList.size()) {
            return new WifiInfo();
        }
        WifiInfo wifiInfo = this.mWifiInfoList.get(selectedIndex);
        Intrinsics.checkNotNullExpressionValue(wifiInfo, "get(...)");
        return wifiInfo;
    }

    @Override // com.stepos.alphame.persona.common.list.PersonalCommonRequester
    public void requestDataList() {
        J.y(I.t(this), Q.f2190b, new AnonymousClass1(null), 2);
    }

    public final void saveData(@NotNull WifiInfo result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.repo.setWifiInfo(get_eventId(), result);
    }

    public final void setEventId(int id) {
        AlphaMeLogger.debugLog("Personal", "page " + id);
        EventId eventId = EventId.HOME_WIFI;
        if (eventId.getId() != id) {
            eventId = EventId.COMPANY_WIFI;
        }
        this._eventId = eventId;
    }
}
