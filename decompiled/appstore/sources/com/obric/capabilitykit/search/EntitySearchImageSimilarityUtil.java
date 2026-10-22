package com.obric.capabilitykit.search;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007J.\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/capabilitykit/search/EntitySearchImageSimilarityUtil;", "", "()V", "ENTITY_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "KEY_ENTITY_ID_LIST", "", "KEY_MEMORY_RESPONSE", "KEY_QUERY_TEXT", "METHOD_GET_IMAGES_SIMILARITY", "TAG", "getImagesSimilarityRankByTextFromVectorDB", "Lcom/obric/capabilitykit/search/Response;", "Lcom/obric/capabilitykit/search/Similarity;", "context", "Landroid/content/Context;", "entityIdList", "", "queryText", "innerCall", "uri", "method", "args", "Landroid/os/Bundle;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntitySearchImageSimilarityUtil {
    private static final Uri ENTITY_URI = null;

    @NotNull
    public static final EntitySearchImageSimilarityUtil INSTANCE = null;

    @NotNull
    private static final String KEY_ENTITY_ID_LIST = "entity_id_list";

    @NotNull
    private static final String KEY_MEMORY_RESPONSE = "memory_response";

    @NotNull
    private static final String KEY_QUERY_TEXT = "query_text";

    @NotNull
    private static final String METHOD_GET_IMAGES_SIMILARITY = "getImagesSimilarityByTextFromVectorDB";

    @NotNull
    private static final String TAG = "ImageSimilarity";

    static {
        INSTANCE = new EntitySearchImageSimilarityUtil();
        ENTITY_URI = Uri.parse("content://com.obric.memorydata.personalcontext.EntityProvider");
    }

    private EntitySearchImageSimilarityUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Response getImagesSimilarityRankByTextFromVectorDB$default(EntitySearchImageSimilarityUtil r10, Context r11, List r12, String r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = null;
    L9:
        return r10.getImagesSimilarityRankByTextFromVectorDB(r11, r12, r13);
    }

    private final String innerCall(Context r10, Uri r11, String r12, Bundle r13) {
        ContentProviderClient r14 = r10.getContentResolver().acquireUnstableContentProviderClient(r11);     // Catch: Exception -> L23
        if (r14 != null) goto L31;
        return null;
    L31:
        Bundle r15 = r14.call(r12, null, r13);     // Catch: Throwable -> L8 Exception -> L10 DeadObjectException -> L13
    L16:
        r14.close();     // Catch: Exception -> L23
        if (r15 != null) goto L19;
        return null;
    L19:
        String r16 = r15.getString(KEY_MEMORY_RESPONSE);     // Catch: Exception -> L23
        if (r16 != null) goto L33;
        return null;
    L33:
        return r16;
    L13:
        e = e;
        String r17 = "unstable provider died during call " + r12;     // Catch: Throwable -> L8
    L12:
        Log.e(TAG, r17, e);     // Catch: Throwable -> L8
        r15 = null;
    L10:
        e = e;
        r17 = "provider call failed " + r12;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r14.close();     // Catch: Exception -> L23
        throw th;     // Catch: Exception -> L23
    L23:
        e = move-exception;
        Log.e(TAG, String.valueOf(e.getMessage()));
        return null;
    }

    public static /* synthetic */ String innerCall$default(EntitySearchImageSimilarityUtil r10, Context r11, Uri r12, String r13, Bundle r14, int r15, Object r16) {
        if ((r15 & 8) == 0) goto L6;
        r14 = new Bundle();
    L6:
        return r10.innerCall(r11, r12, r13, r14);
    }

    @NotNull
    public final Response<Similarity> getImagesSimilarityRankByTextFromVectorDB(@NotNull Context r13, @Nullable List<String> r14, @Nullable String r15) {
        q.g(r13, "context");
        if (r15 == null) goto L23;
        if (r15.length() == 0) goto L23;
        if (r14 == null) goto L21;
        if (r14.isEmpty() == true) goto L21;
        Uri r10 = ENTITY_URI;
        q.f(r10, "ENTITY_URI");
        Bundle r11 = new Bundle();
        r11.putStringArrayList(KEY_ENTITY_ID_LIST, new ArrayList(r14));
        r11.putString(KEY_QUERY_TEXT, r15);
        String r12 = innerCall(r13, r10, METHOD_GET_IMAGES_SIMILARITY, r11);
        if (r12 == null) goto L19;
        if (r12.length() == 0) goto L19;
        return new Response(0, "ok", (Similarity) new Gson().fromJson(r12, Similarity.class));
    L19:
        return new Response(1, "result is empty", null, 4, null);
    L21:
        return new Response(1, "entityIdList is empty", null, 4, null);
    L23:
        return new Response(1, "queryText is empty", null, 4, null);
    }
}
