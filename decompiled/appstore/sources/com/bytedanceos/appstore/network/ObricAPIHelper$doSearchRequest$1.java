package com.bytedanceos.appstore.network;

import com.android.volley.VolleyError;
import com.bytedanceos.appstore.buss.network.h;
import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.collections.k0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import org.apache.http.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.network.ObricAPIHelper$doSearchRequest$1", f = "ObricAPIHelper.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
public final class ObricAPIHelper$doSearchRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $origParams;
    final /* synthetic */ y8.a $response;
    int label;

    public ObricAPIHelper$doSearchRequest$1(Map<String, String> r10, y8.a r11, Continuation<? super ObricAPIHelper$doSearchRequest$1> r12) {
        this.$origParams = r10;
        this.$response = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new ObricAPIHelper$doSearchRequest$1(this.$origParams, this.$response, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r11) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        JsonElement r13 = null;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        c.b(r11);
    L22:
        h r14 = (h) r11;
        if ((r14 instanceof h.c) == false) goto L40;
        JsonObject r15 = new JsonObject();
        JsonObject r16 = new JsonObject();
        h.c r17 = (h.c) r14;
        JsonObject r18 = (JsonObject) r17.a();
        if (r18 == null) goto L27;
        r13 = r18.get("apps");
    L27:
        if (r13 != null) goto L29;
        r13 = new JsonArray();
    L30:
        r16.add("apps", r13);
        Unit r19 = Unit.f21064a;
        r15.add(ServerElements.BODY, r16);
        JsonObject r20 = new JsonObject();
        r20.addProperty(ServerElements.CODE, tf.a.c(0));
        r20.addProperty("message", "");
        JsonObject r110 = (JsonObject) r17.a();
        if (r110 == null) goto L35;
        JsonElement r111 = r110.get(ServerElements.HAS_MORE);
        if (r111 == null) goto L35;
        boolean r112 = r111.getAsBoolean();
    L36:
        r20.addProperty(ServerElements.HAS_MORE, tf.a.a(r112));
        r20.addProperty(ServerElements.FIRST_YYB, tf.a.a(false));
        r15.add(ServerElements.HEAD, r20);
        y8.a r113 = this.$response;
        if (r113 == null) goto L48;
        r113.c(new y8.a.C0414a(200, k0.h(), r15.toString()));
    L48:
        return Unit.f21064a;
    L35:
        r112 = false;
        goto L36
    L29:
        q.d(r13);
        goto L30
    L40:
        if ((r14 instanceof h.a) == false) goto L44;
        y8.a r114 = this.$response;
        if (r114 == null) goto L48;
        Map r21 = k0.h();
        StringBuilder r22 = new StringBuilder();
        h.a r115 = (h.a) r14;
        r22.append(r115.b());
        r22.append(TokenParser.SP);
        r22.append(r115.c());
        r114.a(new y8.a.C0414a(400, r21, new VolleyError(r22.toString(), r115.a())));
        goto L48
    L44:
        y8.a r116 = this.$response;
        if (r116 == null) goto L48;
        r116.a(new y8.a.C0414a(400, k0.h(), new VolleyError("error!!!")));
        goto L48
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        c.b(r11);
        String r117 = this.$origParams.get("kwd");
        if (r117 != null) goto L11;
        r117 = "";
    L11:
        String r23 = this.$origParams.get("page");
        if (r23 == null) goto L14;
        int r24 = Integer.parseInt(r23);
    L15:
        String r25 = this.$origParams.get("size");
        if (r25 == null) goto L18;
    L17:
        int r26 = Integer.parseInt(r25);
        JsonObject r27 = new JsonObject();
        r27.addProperty("kwd", r117);
        r27.addProperty("page", tf.a.c(r24));
        r27.addProperty("size", tf.a.c(r26));
        ObricAPIHelper r118 = ObricAPIHelper.f9432a;
        ObricAPIHelper$doSearchRequest$1$ret$1 r28 = new ObricAPIHelper$doSearchRequest$1$ret$1(r27, null);
        this.label = 1;
        r11 = ObricAPIHelper.h(r118, r28, this);
        if (r11 != r10) goto L22;
        return r10;
    L18:
        r25 = "20";
        goto L17
    L14:
        r24 = 1;
        goto L15
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((ObricAPIHelper$doSearchRequest$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
