package com.obric.matrix.platform.sdk.ones.picolinks;

import android.util.Log;
import com.obric.matrix.proto.Response;
import com.obric.matrix.proto.ResponseBody;
import com.obric.matrix.proto.StartPicoLinksResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/matrix/proto/Response;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class PicoLinksHook$invokeStartPicoLinks$1 extends Lambda implements Function1<Response, Unit> {
    final /* synthetic */ PicoLinksHook$Callback $callback;
    final /* synthetic */ Ref$ObjectRef<Response> $response;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11937a = null;

        static {
            int[] r10 = new int[StartPicoLinksResponse.Phase.values().length];
            r10[StartPicoLinksResponse.Phase.URL_REDIRECT.ordinal()] = 1;
            r10[StartPicoLinksResponse.Phase.ASYNC_CALLBACK.ordinal()] = 2;
            f11937a = r10;
        }
    }

    public PicoLinksHook$invokeStartPicoLinks$1(Ref$ObjectRef<Response> r10, PicoLinksHook$Callback r11) {
        this.$response = r10;
        this.$callback = r11;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Response r10) {
        invoke2(r10);
        return Unit.f21064a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Response r10) {
        q.g(r10, "it");
        this.$response.element = r10;
        ResponseBody r11 = r10.body;
        if (r11 == null) goto L35;
        StartPicoLinksResponse r12 = r11.startPicoLinksResponse;
        if (r12 == null) goto L36;
        PicoLinksHook$Callback r13 = this.$callback;
        StartPicoLinksResponse.Phase r14 = r12.phase;
        if (r14 != null) goto L9;
        int r15 = -1;
    L11:
        if (r15 != 1) goto L13;
        String r16 = r12.phaseData.get("redirectUrl");
        if (r16 != null) goto L23;
        return;
    L23:
        if (r16.length() == 0) goto L43;
        if (r13 == null) goto L40;
        r13.onRedirect(r16);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        Log.w("PicoLinksHook", th);
        return;
    L40:
        return;
    L43:
        return;
    L13:
        if (r15 != 2) goto L41;
        if (r13 == null) goto L37;
        Map<String, String> r17 = r12.phaseData;     // Catch: Throwable -> L18
        q.f(r17, "resp.phaseData");     // Catch: Throwable -> L18
        r13.onResult(r17);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        Log.w("PicoLinksHook", th);
        return;
    L37:
        return;
    L41:
        return;
    L9:
        r15 = a.f11937a[r14.ordinal()];
        goto L11
    L36:
        return;
    }
}
