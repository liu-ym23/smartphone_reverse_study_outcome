package com.obric.capabilitykit.search;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import com.GlobalProxyLancet;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007J.\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/capabilitykit/search/EntitySearchImageSimilarityUtil;", "", "()V", "ENTITY_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "KEY_ENTITY_ID_LIST", "", "KEY_MEMORY_RESPONSE", "KEY_QUERY_TEXT", "METHOD_GET_IMAGES_SIMILARITY", "TAG", "getImagesSimilarityRankByTextFromVectorDB", "Lcom/obric/capabilitykit/search/Response;", "Lcom/obric/capabilitykit/search/Similarity;", "context", "Landroid/content/Context;", "entityIdList", "", "queryText", "innerCall", "uri", "method", "args", "Landroid/os/Bundle;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntitySearchImageSimilarityUtil {
    private static final Uri ENTITY_URI = null;
    public static final EntitySearchImageSimilarityUtil INSTANCE = null;
    private static final String KEY_ENTITY_ID_LIST = "entity_id_list";
    private static final String KEY_MEMORY_RESPONSE = "memory_response";
    private static final String KEY_QUERY_TEXT = "query_text";
    private static final String METHOD_GET_IMAGES_SIMILARITY = "getImagesSimilarityByTextFromVectorDB";
    private static final String TAG = "ImageSimilarity";

    static {
        INSTANCE = new EntitySearchImageSimilarityUtil();
        ENTITY_URI = Uri.parse("content://com.obric.memorydata.personalcontext.EntityProvider");
    }

    private EntitySearchImageSimilarityUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Response getImagesSimilarityRankByTextFromVectorDB$default(EntitySearchImageSimilarityUtil r1, Context r2, List r3, String r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = null;
    L9:
        return r1.getImagesSimilarityRankByTextFromVectorDB(r2, r3, r4);
    }

    private final String innerCall(Context r4, Uri r5, String r6, Bundle r7) {
        ContentProviderClient r8 = r4.getContentResolver().acquireUnstableContentProviderClient(r5);     // Catch: Exception -> L26
        if (r8 != null) goto L31;
        return null;
    L31:
        Bundle r9 = r8.call(r6, null, r7);     // Catch: Throwable -> L8 Exception -> L10 DeadObjectException -> L13
    L17:
        r8.close();     // Catch: Exception -> L26
        if (r9 != null) goto L20;
        return null;
    L20:
        String r3 = r9.getString(KEY_MEMORY_RESPONSE);     // Catch: Exception -> L26
        if (r3 != null) goto L33;
        return null;
    L33:
        return r3;
    L13:
        e = e;
        String r10 = "unstable provider died during call " + r6;     // Catch: Throwable -> L8
    L12:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, r10, e);     // Catch: Throwable -> L8
        r9 = null;
    L10:
        e = e;
        r10 = "provider call failed " + r6;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r8.close();     // Catch: Exception -> L26
        throw th;     // Catch: Exception -> L26
    L26:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, String.valueOf(e.getMessage()));
        return null;
    }

    public static /* synthetic */ String innerCall$default(EntitySearchImageSimilarityUtil r0, Context r1, Uri r2, String r3, Bundle r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = new Bundle();
    L6:
        return r0.innerCall(r1, r2, r3, r4);
    }

    public final Response<Similarity> getImagesSimilarityRankByTextFromVectorDB(Context r10, List<String> r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        boolean r0 = true;
        if (r12 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        if (r11 != null) goto L14;
    L17:
        boolean r3 = true;
    L18:
        if (r3 == true) goto L20;
        Uri r4 = ENTITY_URI;
        Intrinsics.checkNotNullExpressionValue(r4, "ENTITY_URI");
        Bundle r5 = new Bundle();
        r5.putStringArrayList(KEY_ENTITY_ID_LIST, new ArrayList(r11));
        r5.putString(KEY_QUERY_TEXT, r12);
        String r9 = innerCall(r10, r4, METHOD_GET_IMAGES_SIMILARITY, r5);
        if (r9 != null) goto L24;
    L27:
        if (r0 == false) goto L31;
        return new Response(1, "result is empty", null, 4, null);
    L31:
        return new Response(0, "ok", (Similarity) new Gson().fromJson(r9, Similarity.class));
    L24:
        if (r9.length() == 0) goto L27;
        r0 = false;
        goto L27
    L20:
        return new Response(1, "entityIdList is empty", null, 4, null);
    L14:
        if (r11.isEmpty() == true) goto L17;
        r3 = false;
        goto L18
    L11:
        return new Response(1, "queryText is empty", null, 4, null);
    L5:
        if (r12.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
