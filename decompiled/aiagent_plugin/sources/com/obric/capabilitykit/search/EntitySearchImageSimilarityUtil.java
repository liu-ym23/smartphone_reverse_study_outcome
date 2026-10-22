package com.obric.capabilitykit.search;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.util.Log;
import com.google.gson.Gson;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
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

    public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public static /* synthetic */ Response getImagesSimilarityRankByTextFromVectorDB$default(EntitySearchImageSimilarityUtil r1, Context r2, List r3, String r4, int r5, Object r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = null;
    L9:
        return r1.getImagesSimilarityRankByTextFromVectorDB(r7, r8, r4);
    }

    private final String innerCall(Context r3, Uri r4, String r5, Bundle r6) {
        ContentProviderClient r7 = ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getContentResolver().acquireUnstableContentProviderClient(r4);     // Catch: Exception -> L26
        if (r7 != null) goto L31;
        return null;
    L31:
        Bundle r8 = r7.call(r5, null, r6);     // Catch: Throwable -> L8 Exception -> L10 DeadObjectException -> L13
    L17:
        r7.close();     // Catch: Exception -> L26
        if (r8 != null) goto L20;
        return null;
    L20:
        String r2 = r8.getString(KEY_MEMORY_RESPONSE);     // Catch: Exception -> L26
        if (r2 != null) goto L33;
        return null;
    L33:
        return r2;
    L13:
        e = e;
        String r9 = "unstable provider died during call " + r5;     // Catch: Throwable -> L8
    L12:
        INVOKESTATIC_com_obric_capabilitykit_search_EntitySearchImageSimilarityUtil_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, r9, e);     // Catch: Throwable -> L8
        r8 = null;
    L10:
        e = e;
        r9 = "provider call failed " + r5;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r7.close();     // Catch: Exception -> L26
        throw th;     // Catch: Exception -> L26
    L26:
        e = move-exception;
        INVOKESTATIC_com_obric_capabilitykit_search_EntitySearchImageSimilarityUtil_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, String.valueOf(e.getMessage()));
        return null;
    }

    public static /* synthetic */ String innerCall$default(EntitySearchImageSimilarityUtil r1, Context r2, Uri r3, String r4, Bundle r5, int r6, Object r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L6;
        r5 = new Bundle();
    L6:
        return r1.innerCall(r8, r3, r4, r5);
    }

    public final Response<Similarity> getImagesSimilarityRankByTextFromVectorDB(Context r11, List<String> r12, String r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        o.e(r14, "context");
        boolean r0 = true;
        if (r13 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
        if (r15 != null) goto L14;
    L17:
        boolean r4 = true;
    L18:
        if (r4 == true) goto L20;
        Uri r5 = ENTITY_URI;
        o.c(r5, "ENTITY_URI");
        Bundle r6 = new Bundle();
        r6.putStringArrayList(KEY_ENTITY_ID_LIST, new ArrayList(r15));
        r6.putString(KEY_QUERY_TEXT, r13);
        String r10 = innerCall(r14, r5, METHOD_GET_IMAGES_SIMILARITY, r6);
        if (r10 != null) goto L24;
    L27:
        if (r0 == false) goto L31;
        return new Response(1, "result is empty", null, 4, null);
    L31:
        return new Response(0, "ok", (Similarity) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r10, Similarity.class), Similarity.class, "com.obric.aiagent.plugin"));
    L24:
        if (r10.length() == 0) goto L27;
        r0 = false;
        goto L27
    L20:
        return new Response(1, "entityIdList is empty", null, 4, null);
    L14:
        if (r15.isEmpty() == true) goto L17;
        r4 = false;
        goto L18
    L11:
        return new Response(1, "queryText is empty", null, 4, null);
    L5:
        if (r13.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_capabilitykit_search_EntitySearchImageSimilarityUtil_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_capabilitykit_search_EntitySearchImageSimilarityUtil_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
