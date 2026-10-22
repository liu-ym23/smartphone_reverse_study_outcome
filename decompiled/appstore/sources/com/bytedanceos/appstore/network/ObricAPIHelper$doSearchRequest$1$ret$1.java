package com.bytedanceos.appstore.network;

import com.bytedanceos.appstore.buss.network.AssistantHttpResult;
import com.bytedanceos.appstore.buss.network.StoreService;
import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import com.bytedanceos.appstore.buss.network.h;
import com.bytedanceos.common.toolbox.j;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.Deferred;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedanceos/appstore/buss/network/h;", "Lcom/google/gson/JsonObject;", "<anonymous>", "()Lcom/bytedanceos/appstore/buss/network/h;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.bytedanceos.appstore.network.ObricAPIHelper$doSearchRequest$1$ret$1", f = "ObricAPIHelper.kt", i = {}, l = {124, 125}, m = "invokeSuspend", n = {}, s = {})
public final class ObricAPIHelper$doSearchRequest$1$ret$1 extends SuspendLambda implements Function1<Continuation<? super h>, Object> {
    final /* synthetic */ JsonObject $params;
    int label;

    public ObricAPIHelper$doSearchRequest$1$ret$1(JsonObject r10, Continuation<? super ObricAPIHelper$doSearchRequest$1$ret$1> r11) {
        this.$params = r10;
        super(1, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> r10) {
        return new ObricAPIHelper$doSearchRequest$1$ret$1(this.$params, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super h> r10) {
        return invoke2(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r11) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 != 2) goto L8;
        c.b(r11);
    L16:
        return r11;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        c.b(r11);
    L13:
        ObricAPIHelper r13 = ObricAPIHelper.f9432a;
        this.label = 2;
        r11 = BaseRepository.b(r13, (Response) r11, null, null, this, 6, null);
        if (r11 != r10) goto L16;
        return r10;
    L10:
        c.b(r11);
        j.a("ObricAPIHelper doSearchRequest start for " + this.$params);
        ObricAPIHelper r14 = ObricAPIHelper.f9432a;
        StoreService r15 = ObricAPIHelper.g(r14);
        RequestBody r16 = ObricAPIHelper.j(r14, this.$params);
        q.f(r16, "access$toRequestBody(...)");
        Deferred<Response<AssistantHttpResult<JsonObject>>> r17 = r15.post(StoreService.SEARCH_APP_URL, r16);
        this.label = 1;
        r11 = r17.await(this);
        if (r11 != r10) goto L13;
        return r10;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@Nullable Continuation<? super h> r10) {
        return ((ObricAPIHelper$doSearchRequest$1$ret$1) create(r10)).invokeSuspend(Unit.f21064a);
    }
}
