package com.obric.memorydata.sdk;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Parcelable;
import android.util.Log;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.PCAppFcEntitySearchParams;
import com.obric.capabilitykit.common.intent.PCCommonGlobalSearchParams;
import com.obric.capabilitykit.common.intent.PCGlobalSearchParams;
import com.obric.capabilitykit.common.intent.PCIntentGlobalSearchParams;
import com.obric.capabilitykit.common.intent.PCPersonalContextFetchParams;
import com.obric.capabilitykit.common.intent.PCPersonalContextSearchParams;
import com.obric.capabilitykit.common.intent.PCSearchAppEntityParams;
import com.obric.capabilitykit.common.intent.RCSearchParams;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.sdk.entity.RecommendComplexQuery;
import com.obric.memorydata.sdk.entity.search.oauto.OAutoSearchResult;
import com.obric.memorydata.sdk.entity.search.userprofile.UserProfileMemoryResult;
import com.obric.memorydata.sdk.service.PermissionCheckResult;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: compiled from: MemoryAPI.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static final String TAG = "MemoryAPI";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33793a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Uri f33794b = null;

    private a() {
    }

    static {
        f33793a = new a();
        f33794b = Uri.parse("content://com.obric.memorydata.personalcontext.EntityProvider");
    }

    public final MemoryResponse<Void> a(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        return a(this, r1, "notifyUserAgreePrivacy", null, 4, null);
    }

    public final MemoryResponse<Void> b(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        return a(this, r1, "terminateService", null, 4, null);
    }

    public final MemoryResponse<Void> c(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        return a(this, r1, "preloadAssistantSearchModels", null, 4, null);
    }

    public final MemoryResponse<Void> d(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        return a(this, r1, "cancelUseAssistantSearchModels", null, 4, null);
    }

    public final MemoryResponse<List<RecommendComplexQuery>> a(Context r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        o.e(r13, "context");
        Bundle r1 = new Bundle();
        r1.putInt("limit", r12);
        return a(r13, "getComplexRecommendQuery", r1);
    L5:
        MemoryResponse r10 = a(r13, "getComplexRecommendQuery", r1);
        List r14 = (List) ZeusTransformUtils.preCheckCast(r10.getData(), List.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L12;
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r15, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r17 = r15.iterator();
    L9:
        if (r17.hasNext() == false) goto L11;
        r16.add(new RecommendComplexQuery((String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.aiagent.plugin"), "", "", null, 8, null));
        goto L9
    L11:
        List r18 = (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.aiagent.plugin");
    L14:
        return new MemoryResponse(r10.getCode(), r10.getMessage(), r18);
    L12:
        r18 = p.b();
        goto L14
    }

    public final MemoryResponse<String> b(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        Bundle r0 = new Bundle();
        r0.putInt("limit", r4);
        return a(r5, "queryUserKeyword", r0);
    }

    public final MemoryResponse<PermissionCheckResult> a(Context r4, String r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        o.e(r5, "pcSearchIntent");
        o.e(r6, "quResultJson");
        Bundle r2 = new Bundle();
        r2.putString("pcSearchIntent", r5);
        r2.putString("quResultJson", r6);
        return a(r7, "checkDependencyPermissionForSearchIntent", r2);
    }

    public final MemoryResponse<IntentResult<Empty>> a(PCSearchAppEntityParams r3, DispatchContext r4) {
        o.e(r3, "params");
        o.e(r4, "dispatchContext");
        return a("pcSearchAppEntityIntent", (IntentParams) ZeusTransformUtils.preCheckCast(r3, IntentParams.class, "com.obric.aiagent.plugin"), r4);
    }

    public final MemoryResponse<IntentResult<Empty>> a(PCAppFcEntitySearchParams r3, DispatchContext r4) {
        o.e(r3, "params");
        o.e(r4, "dispatchContext");
        return a("pcAppFcEntitySearchIntent", (IntentParams) ZeusTransformUtils.preCheckCast(r3, IntentParams.class, "com.obric.aiagent.plugin"), r4);
    }

    public final MemoryResponse<IntentResult<Empty>> a(PCGlobalSearchParams r3, DispatchContext r4) {
        o.e(r3, "params");
        o.e(r4, "dispatchContext");
        return a("pcGlobalSearchIntent", (IntentParams) ZeusTransformUtils.preCheckCast(r3, IntentParams.class, "com.obric.aiagent.plugin"), r4);
    }

    public final MemoryResponse<IntentResult<Empty>> a(PCCommonGlobalSearchParams r3, DispatchContext r4) {
        o.e(r3, "params");
        o.e(r4, "dispatchContext");
        return a("pcCommonGlobalSearchIntent", (IntentParams) ZeusTransformUtils.preCheckCast(r3, IntentParams.class, "com.obric.aiagent.plugin"), r4);
    }

    public final MemoryResponse<IntentResult<Empty>> a(PCPersonalContextSearchParams r3, DispatchContext r4) {
        o.e(r3, "params");
        o.e(r4, "dispatchContext");
        return a("pcPersonalContextSearchIntent", (IntentParams) ZeusTransformUtils.preCheckCast(r3, IntentParams.class, "com.obric.aiagent.plugin"), r4);
    }

    public final MemoryResponse<IntentResult<Empty>> a(PCPersonalContextFetchParams r3, DispatchContext r4) {
        o.e(r3, "params");
        o.e(r4, "dispatchContext");
        return a("pcPersonalContextFetchIntent", (IntentParams) ZeusTransformUtils.preCheckCast(r3, IntentParams.class, "com.obric.aiagent.plugin"), r4);
    }

    public final MemoryResponse<IntentResult<Empty>> a(String r3, Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "sessionJson");
        o.e(r5, "context");
        Bundle r0 = new Bundle();
        r0.putString("oAutoGlobalSearchExecutorParams", r3);
        return a(r5, "newOAutoGlobalSearchExecutorParams", r0);
    }

    public final MemoryResponse<IntentResult<Empty>> a(PCIntentGlobalSearchParams r3, DispatchContext r4) {
        o.e(r3, "params");
        o.e(r4, "dispatchContext");
        return a("pcIntentGlobalSearchIntent", (IntentParams) ZeusTransformUtils.preCheckCast(r3, IntentParams.class, "com.obric.aiagent.plugin"), r4);
    }

    public final MemoryResponse<OAutoSearchResult> a(JSONObject r3, Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "params");
        o.e(r5, "context");
        Bundle r0 = new Bundle();
        r0.putString("oAutoGlobalSearchExecutorParams", r3.toString());
        return a(r5, "oAutoGlobalSearchIntent", r0);
    }

    public final MemoryResponse<UserProfileMemoryResult> a(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "profileKey");
        Bundle r1 = new Bundle();
        r1.putString("profileKey", r4);
        return a(r5, "queryUserProfileMemory", r1);
    }

    public final MemoryResponse<String> b(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, AutoTestConstant.PARAM);
        Bundle r1 = new Bundle();
        r1.putString(AutoTestConstant.PARAM, r4);
        return a(r5, "queryUserInsightAndPreference", r1);
    }

    public final MemoryResponse<String> c(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, AutoTestConstant.PARAM);
        Bundle r1 = new Bundle();
        r1.putString(AutoTestConstant.PARAM, r4);
        return a(r5, "queryRealTimeAwarenessData", r1);
    }

    public final MemoryResponse<IntentResult<Empty>> a(RCSearchParams r3, DispatchContext r4) {
        o.e(r3, "params");
        o.e(r4, "dispatchContext");
        return a("rcGlobalSearchIntent", (IntentParams) ZeusTransformUtils.preCheckCast(r3, IntentParams.class, "com.obric.aiagent.plugin"), r4);
    }

    public static /* synthetic */ MemoryResponse a(a r1, Context r2, List r3, int r4, Object r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L6;
        r7 = null;
    L6:
        return r1.a(r6, r7);
    }

    public final MemoryResponse<String> a(Context r5, List<String> r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        Bundle r0 = new Bundle();
        if (r8 == null) goto L5;
        ArrayList<String> r2 = new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin"));
    L6:
        r0.putStringArrayList("feature_name_list", r2);
        x r9 = x.f38692a;
        return a(r7, "rcSearchStateWhenStartQuery", r0);
    L5:
        r2 = null;
        goto L6
    }

    public final MemoryResponse<String> a(Context r3, String r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r4, DownloadConstants.QUERY_KEY);
        Bundle r1 = new Bundle();
        r1.putString(DownloadConstants.QUERY_KEY, r4);
        r1.putBoolean("isFinished", r5);
        x r7 = x.f38692a;
        return a(r6, "notifyEvaluationQueryFinished", r1);
    }

    public final MemoryResponse<List<AppEntity>> a(Context r7, Map<String, ? extends List<String>> r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        o.e(r9, "context");
        o.e(r10, "entityMap");
        Bundle r0 = new Bundle();
        Iterator r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r0.putStringArrayList((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), new ArrayList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2.getValue(), List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")));
        goto L4
    L7:
        return a(r9, "getAppEntityListByEntityTypeAndEntityIdList", r0);
    }

    public final MemoryResponse<List<AppEntity>> a(Context r3, int r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        Bundle r0 = new Bundle();
        r0.putInt("entityType", r4);
        r0.putInt("limit", r5);
        return a(r6, "getAppEntityByEntityType", r0);
    }

    private final MemoryResponse<IntentResult<Empty>> a(String r5, IntentParams r6, DispatchContext r7) {
        IntentParams r8 = (IntentParams) ZeusTransformUtils.wrapperContextForParams(r6, IntentParams.class, "com.obric.aiagent.plugin");
        Bundle r0 = new Bundle();
        r0.putParcelable("memoryIntentExecutorParams", (Parcelable) ZeusTransformUtils.preCheckCast(r8, Parcelable.class, "com.obric.aiagent.plugin"));
        Long r9 = r7.getQuestionId();
        if (r9 == null) goto L6;
        r0.putLong("questionId", ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.aiagent.plugin")).longValue());
    L6:
        return a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5, r0);
    }

    static /* synthetic */ MemoryResponse a(a r1, Context r2, String r3, Bundle r4, int r5, Object r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L6;
        r4 = new Bundle();
    L6:
        return r1.a(r7, r3, r4);
    }

    private final <T> MemoryResponse<T> a(Context r10, String r11, Bundle r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        if (com.obric.capabilitykit.entity.memory.a.f32135a.c(r13) != com.obric.capabilitykit.entity.memory.b.f32136a) goto L5;
        ContentProviderClient r14 = r13.getContentResolver().acquireUnstableContentProviderClient(f33794b);     // Catch: Exception -> L28
        if (r14 == null) goto L9;
        Bundle r0 = null;
        r0 = r14.call(r11, null, r12);     // Catch: Throwable -> L14 Exception -> L16 DeadObjectException -> L18
    L12:
        r14.close();     // Catch: Exception -> L28
        if (r0 == null) goto L37;
        r0.setClassLoader(a.class.getClassLoader());     // Catch: Exception -> L28
        MemoryResponse<T> r15 = (MemoryResponse) ZeusTransformUtils.preCheckCast(r0.getParcelable("memory_response"), MemoryResponse.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L28
        if (r15 == null) goto L36;
        return r15;
    L36:
        return new MemoryResponse(400, "internal error", null, 4, null);
    L37:
        return new MemoryResponse(400, "internal error", null, 4, null);
    L14:
        th = move-exception;
        r14.close();     // Catch: Exception -> L28
        throw th;     // Catch: Exception -> L28
    L18:
        e = move-exception;
        a(TAG, d.a.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L14
    L16:
        e = move-exception;
        a(TAG, d.a.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L14
        goto L12
    L9:
        return new MemoryResponse(404, "provider client unavailable", null, 4, null);
    L28:
        e = move-exception;
        a(TAG, d.a.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));
        return new MemoryResponse(404, e.getMessage(), null, 4, null);
    L5:
        return new MemoryResponse(407, "Memory service component disabled", null, 4, null);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
