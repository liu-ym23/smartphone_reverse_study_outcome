package com.obric.matrix.platform.sdk.ones.picolinks;

import android.content.Context;
import android.net.Uri;
import com.GlobalProxyLancet;
import com.obric.capabilitykit.common.Ext;
import com.obric.matrix.proto.MATRIX_CMD;
import com.obric.matrix.proto.Request;
import com.obric.matrix.proto.RequestBody;
import com.obric.matrix.proto.Response;
import com.obric.matrix.proto.StartPicoLinksRequest;
import com.obric.matrix.proto.StatusCode;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PicoLinksHook.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ6\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0002J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004J.\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015J$\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/picolinks/PicoLinksHook;", "", "()V", "PATH_PICO_LINKS", "", "PHASE_DATA_KEY_REDIRECT_URL", "SCHEME_HTTP", "SCHEME_HTTPS", "SCHEME_PICO_LINKS", "TAG", "init", "", "context", "Landroid/content/Context;", "invokeStartPicoLinks", "", "scene", "Lcom/obric/matrix/proto/StartPicoLinksRequest$SCENE;", "targetUrl", "referrer", "callback", "Lcom/obric/matrix/platform/sdk/ones/picolinks/PicoLinksHook$Callback;", "isSync", "isPicoLinksUrl", "url", "Landroid/net/Uri;", "shouldOverrideUrlLoading", "startPicoLinks", "Callback", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PicoLinksHook {
    public static final PicoLinksHook INSTANCE = null;
    private static final String PATH_PICO_LINKS = "picolinks";
    private static final String PHASE_DATA_KEY_REDIRECT_URL = "redirectUrl";
    private static final String SCHEME_HTTP = "http";
    private static final String SCHEME_HTTPS = "https";
    private static final String SCHEME_PICO_LINKS = "picolinks";
    private static final String TAG = "PicoLinksHook";

    /* JADX INFO: compiled from: PicoLinksHook.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001c\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bH\u0016¨\u0006\t"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/picolinks/PicoLinksHook$Callback;", "", "onRedirect", "", "url", "", "onResult", "data", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Callback {

        /* JADX INFO: compiled from: PicoLinksHook.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void onRedirect(Callback r0, String r1) {
                Intrinsics.checkNotNullParameter(r1, "url");
            }

            public static void onResult(Callback r0, Map<String, String> r1) {
                Intrinsics.checkNotNullParameter(r1, "data");
            }
        }

        void onRedirect(String r1);

        void onResult(Map<String, String> r1);
    }

    static {
        INSTANCE = new PicoLinksHook();
    }

    public final void init(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
    }

    private PicoLinksHook() {
    }

    public final boolean isPicoLinksUrl(String r3) {
        String r0 = r3;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return false;
    L11:
        Uri r4 = Uri.parse(r3);
        Intrinsics.checkNotNullExpressionValue(r4, "parse(url)");
        return isPicoLinksUrl(r4);
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final boolean isPicoLinksUrl(Uri r5) {
        Intrinsics.checkNotNullParameter(r5, "url");
        if (StringsKt.equals(r5.getScheme(), "http", true) == true) goto L12;
        if (StringsKt.equals(r5.getScheme(), SCHEME_HTTPS, true) == true) goto L12;
        if (StringsKt.equals(r5.getScheme(), "picolinks", true) == true) goto L12;
        return false;
    L12:
        if (r5.getPathSegments().size() < 1) goto L17;
        if (StringsKt.equals(r5.getPathSegments().get(0), "picolinks", true) == false) goto L17;
        return true;
    L17:
        return false;
    }

    public static /* synthetic */ boolean shouldOverrideUrlLoading$default(PicoLinksHook r0, Context r1, String r2, String r3, Callback r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = null;
    L6:
        return r0.shouldOverrideUrlLoading(r1, r2, r3, r4);
    }

    public final boolean shouldOverrideUrlLoading(Context r9, String r10, String r11, Callback r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        long r0 = System.currentTimeMillis();
        boolean r8 = invokeStartPicoLinks(StartPicoLinksRequest.SCENE.BROWSER, r10, r11, r12, true);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "shouldOverrideUrlLoading=" + r8 + ", cost=" + (System.currentTimeMillis() - r0));
        return r8;
    }

    public static /* synthetic */ boolean startPicoLinks$default(PicoLinksHook r0, Context r1, String r2, Callback r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.startPicoLinks(r1, r2, r3);
    }

    public final boolean startPicoLinks(Context r9, String r10, Callback r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        long r0 = System.currentTimeMillis();
        boolean r8 = invokeStartPicoLinks(StartPicoLinksRequest.SCENE.NATIVE_APP, r10, r9.getPackageName(), r11, false);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "startPicoLinks=" + r8 + ", cost=" + (System.currentTimeMillis() - r0));
        return r8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean invokeStartPicoLinks(StartPicoLinksRequest.SCENE r3, String r4, String r5, final Callback r6, boolean r7) {
        if (isPicoLinksUrl(r4) == true) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, r4 + " is not PicoLinks");
        return false;
    L6:
        Request r2 = new Request.Builder().cmd(Integer.valueOf(MATRIX_CMD.CMD_PRIVATE_START_PICO_LINKS.getValue())).body(new RequestBody.Builder().startPicoLinksRequest(new StartPicoLinksRequest.Builder().scene(r3).referrer(r5).targetUrl(r4).build()).build()).build();
        final Ref.ObjectRef r8 = new Ref.ObjectRef();
        PicoLinksBroker r9 = PicoLinksBroker.INSTANCE;
        MATRIX_CMD r10 = MATRIX_CMD.CMD_PRIVATE_START_PICO_LINKS;
        Intrinsics.checkNotNullExpressionValue(r2, Ext.KEY_REQUEST);
        r9.sendCmd(r10, r2, r7, new AnonymousClass1(r8, r6));
        Response r11 = (Response) r8.element;
        if (r11 == null) goto L15;
        Integer r12 = r11.statusCode;
        int r13 = StatusCode.OK.getValue();
        if (r12 != null) goto L12;
        return false;
    L12:
        if (r12.intValue() != r13) goto L16;
        return true;
    L16:
        return false;
    L15:
        return false;
    }
}
