package com.obric.matrix.platform.sdk.ones.picolinks;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.GlobalProxyLancet;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.matrix.proto.MATRIX_CMD;
import com.obric.matrix.proto.PicoLinksCallback;
import com.obric.matrix.proto.Request;
import com.obric.matrix.proto.RequestBody;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: PicoLinksRoute.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/picolinks/PicoLinksRoute;", "", "()V", "PICO_LINKS_ID", "", "PICO_LINKS_URL", "TAG", "processPicoLinksIntent", "", "activity", "Landroid/app/Activity;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "handler", "Lcom/obric/matrix/platform/sdk/ones/picolinks/PicoLinksRoute$Handler;", "Context", "Handler", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PicoLinksRoute {
    public static final PicoLinksRoute INSTANCE = null;
    private static final String PICO_LINKS_ID = "pico_links_id";
    private static final String PICO_LINKS_URL = "pico_links_url";
    private static final String TAG = "PicoLinksRoute";

    /* JADX INFO: compiled from: PicoLinksRoute.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/picolinks/PicoLinksRoute$Context;", "", "activity", "Landroid/app/Activity;", "url", "Landroid/net/Uri;", "callbackId", "", "(Landroid/app/Activity;Landroid/net/Uri;I)V", "getActivity", "()Landroid/app/Activity;", "getUrl", "()Landroid/net/Uri;", "setResult", "", "data", "", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Context {
        private final Activity activity;
        private final int callbackId;
        private final Uri url;

        public Context(Activity r2, Uri r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "url");
            this.activity = r2;
            this.url = r3;
            this.callbackId = r4;
        }

        public final Activity getActivity() {
            return this.activity;
        }

        public final Uri getUrl() {
            return this.url;
        }

        public final void setResult(Map<String, String> r8) {
            Intrinsics.checkNotNullParameter(r8, "data");
            PicoLinksCallback r7 = new PicoLinksCallback.Builder().callbackId(Integer.valueOf(this.callbackId)).callbackData(r8).build();
            Request r2 = new Request.Builder().cmd(Integer.valueOf(MATRIX_CMD.CMD_PRIVATE_PICO_LINKS_CALLBACK.getValue())).body(new RequestBody.Builder().picoLinksCallback(r7).build()).build();
            PicoLinksBroker r0 = PicoLinksBroker.INSTANCE;     // Catch: Throwable -> L5
            MATRIX_CMD r1 = MATRIX_CMD.CMD_PRIVATE_PICO_LINKS_CALLBACK;     // Catch: Throwable -> L5
            Intrinsics.checkNotNullExpressionValue(r2, Ext.KEY_REQUEST);     // Catch: Throwable -> L5
            PicoLinksBroker.sendCmd$default(r0, r1, r2, false, null, 12, null);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            Log.w(PicoLinksRoute.TAG, th);
        }
    }

    /* JADX INFO: compiled from: PicoLinksRoute.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/picolinks/PicoLinksRoute$Handler;", "", "handlePicoLinks", "", "context", "Lcom/obric/matrix/platform/sdk/ones/picolinks/PicoLinksRoute$Context;", "path", "", "params", "Landroid/os/Bundle;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Handler {
        void handlePicoLinks(Context r1, String r2, Bundle r3);
    }

    public static /* synthetic */ void $r8$lambda$QcHOUh1s2oJbfQWg4QKQYb5XWgM(String r0, Bundle r1, Handler r2, Activity r3, Uri r4, int r5) {
        m382processPicoLinksIntent$lambda3(r0, r1, r2, r3, r4, r5);
    }

    static {
        INSTANCE = new PicoLinksRoute();
    }

    private PicoLinksRoute() {
    }

    public final boolean processPicoLinksIntent(final Activity r19, Intent r20, final Handler r21) {
        Intrinsics.checkNotNullParameter(r19, "activity");
        Intrinsics.checkNotNullParameter(r21, "handler");
        if (r20 != null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "intent is null");
        return false;
    L6:
        final Uri r7 = (Uri) r20.getParcelableExtra(PICO_LINKS_URL);
        final int r8 = r20.getIntExtra(PICO_LINKS_ID, 0);
        if (r7 != null) goto L11;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "url is null");
        return false;
    L11:
        if (PicoLinksHook.INSTANCE.isPicoLinksUrl(r7) == true) goto L14;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "is no PicoLinks url");
        return false;
    L14:
        List<String> r0 = r7.getPathSegments();
        Intrinsics.checkNotNullExpressionValue(r0, "url.pathSegments");
        List r1 = CollectionsKt.toMutableList(r0);
        CollectionsKt.removeFirstOrNull(r1);
        CollectionsKt.removeFirstOrNull(r1);
        final String r3 = CollectionsKt.joinToString$default(r1, LibrarianImpl.Constants.SEPARATOR, null, null, 0, null, null, 62, null);
        final Bundle r4 = new Bundle();
        String r2 = r7.getQueryParameter("params");
        if (r2 == null) goto L29;
        JSONObject r5 = new JSONObject(r2);
        Iterator<String> r6 = r5.keys();
        Intrinsics.checkNotNullExpressionValue(r6, "jsonParams.keys()");
    L18:
        if (r6.hasNext() == false) goto L29;
        String r9 = r6.next();
        Object r10 = r5.get(r9);
        if ((r10 instanceof Integer) == true) goto L21;
        if ((r10 instanceof Boolean) == true) goto L24;
        if ((r10 instanceof String) == true) goto L27;
        r4.putString(r9, r10.toString());
        goto L18
    L27:
        r4.putString(r9, (String) r10);
        goto L18
    L24:
        r4.putBoolean(r9, ((Boolean) r10).booleanValue());
        goto L18
    L21:
        r4.putInt(r9, ((Number) r10).intValue());
    L29:
        new android.os.Handler(Looper.getMainLooper()).post(new PicoLinksRoute$$ExternalSyntheticLambda0(r3, r4, r21, r19, r7, r8));
        return true;
    }

    /* JADX INFO: renamed from: processPicoLinksIntent$lambda-3, reason: not valid java name */
    private static final void m382processPicoLinksIntent$lambda3(String r3, Bundle r4, Handler r5, Activity r6, Uri r7, int r8) {
        Intrinsics.checkNotNullParameter(r3, "$path");
        Intrinsics.checkNotNullParameter(r4, "$params");
        Intrinsics.checkNotNullParameter(r5, "$handler");
        Intrinsics.checkNotNullParameter(r6, "$activity");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "handlePicoLinks, path=" + r3 + ", params=" + r4);     // Catch: Throwable -> L5
        r5.handlePicoLinks(new Context(r6, r7, r8), r3, r4);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.w(TAG, th);
    }
}
