package com.smt.obric.appstore.domain.oapplet;

import com.bytedanceos.common.model.AppInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/bytedanceos/common/model/AppInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.oapplet.GetAllOAppletUseCase$invoke$2$1", f = "GetAllOAppletUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nGetAllOAppletUseCase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GetAllOAppletUseCase.kt\ncom/smt/obric/appstore/domain/oapplet/GetAllOAppletUseCase$invoke$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1603#2,9:62\n1855#2:71\n1856#2:73\n1612#2:74\n1#3:72\n*S KotlinDebug\n*F\n+ 1 GetAllOAppletUseCase.kt\ncom/smt/obric/appstore/domain/oapplet/GetAllOAppletUseCase$invoke$2$1\n*L\n22#1:62,9\n22#1:71\n22#1:73\n22#1:74\n22#1:72\n*E\n"})
public final class GetAllOAppletUseCase$invoke$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends AppInfo>>, Object> {
    final /* synthetic */ GetAllOAppletUseCase $this_runCatching;
    int label;

    public GetAllOAppletUseCase$invoke$2$1(GetAllOAppletUseCase r10, Continuation<? super GetAllOAppletUseCase$invoke$2$1> r11) {
        this.$this_runCatching = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new GetAllOAppletUseCase$invoke$2$1(this.$this_runCatching, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super List<? extends AppInfo>> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) goto L12;
        c.b(r10);
        Object r11 = OAppletUtil.f18065a.d(GetAllOAppletUseCase.a(this.$this_runCatching));
        c.b(r11);
        List r12 = (List) r11;
        InstalledOApplets.f18057a.k(r12);
        GetAllOAppletUseCase r13 = this.$this_runCatching;
        ArrayList r14 = new ArrayList();
        Iterator r15 = r12.iterator();
    L6:
        if (r15.hasNext() == false) goto L10;
        OAppletInfo r16 = (OAppletInfo) r15.next();
        AppInfo r17 = GetAllOAppletUseCase.f18055b.a(r16, GetAllOAppletUseCase.a(r13));
        if (r17 == null) goto L6;
        r14.add(r17);
        goto L6
    L10:
        return r14;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super List<? extends AppInfo>> r11) {
        return ((GetAllOAppletUseCase$invoke$2$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
