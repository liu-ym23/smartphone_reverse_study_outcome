package com.bytedance.ai.bridge.remote;

import com.bytedance.ai.bridge.remote.model.AppMeta;
import com.bytedance.ai.bridge.remote.model.AppletPermissionDetail;
import com.bytedance.ai.bridge.remote.model.CheckType;
import com.bytedance.ai.bridge.remote.model.FetchDomainPolicyResponse;
import com.bytedance.ai.bridge.remote.model.UploadModelContextRequest;
import com.bytedance.ai.bridge.remote.model.UploadModelContextResponse;
import com.bytedance.ai.utils.g;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.IOException;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import p4.i;
import p4.n;
import p4.o;
import p4.p;

/* JADX INFO: loaded from: classes43.dex */
public final class UserAuthService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final UserAuthService f36075a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Retrofit f36076b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Retrofit f36077c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final UserAuthApi f36078d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final UserAuthApi f36079e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final UserAuthApi f36080f = null;

    public UserAuthService() {
    }

    static {
        f36075a = new UserAuthService();
        Retrofit r100 = RetrofitUtils.getSsRetrofit("https://mini-program.doubao.com");
        f36076b = r100;
        Retrofit r101 = RetrofitUtils.getSsRetrofit("https://api-normal.doubao.com");
        f36077c = r101;
        f36078d = (UserAuthApi) r100.create(UserAuthApi.class);
        f36079e = (UserAuthApi) r101.create(UserAuthApi.class);
        f36080f = (UserAuthApi) RetrofitUtils.getSsRetrofit("https://hello.doubao-dev.com").create(UserAuthApi.class);
    }

    public static final RemoteApiException b(Throwable r100) {
        if ((r100 instanceof RemoteApiException) == false) goto L6;
        return (RemoteApiException) r100;
    L6:
        if ((r100 instanceof IOException) == false) goto L8;
    L14:
        RemoteApiException r101 = new RemoteApiException.Network(r100);
    L16:
        return r101;
    L8:
        if ((r100 instanceof NetworkNotAvailabeException) == true) goto L14;
        String r102 = r100.getMessage();
        if (r102 != null) goto L13;
        r102 = "invalid response";
    L13:
        r101 = new RemoteApiException.InvalidResponse(r102);
        goto L16
    }

    public static p l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cardId");
        SsResponse<p> r101 = f36078d.getMessageInfoByCardId(new o(r100)).execute();     // Catch: Exception -> L13
        if (r101.isSuccessful() == true) goto L6;
    L11:
        g.f37637a.e("UserAuthService", "getMessageInfoByCardId: Http Error, code = " + r101.code());     // Catch: Exception -> L13
    L17:
        return null;
    L6:
        if (r101.body() == null) goto L11;
        p r102 = r101.body();     // Catch: Exception -> L13
        if (r102.d() == false) goto L10;
        return r102;
    L10:
        g.f37637a.e("UserAuthService", "getMessageInfoByCardId: Server Error: " + r102);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        g.f37637a.e("UserAuthService", "getMessageInfoByCardId ERROR: " + e.getMessage(), e);
        return null;
    }

    public final Object c(List<String> r100, Continuation<? super Result<p4.b>> r101) {
        if ((r101 instanceof UserAuthService$batchGetAppletMetaInfo$1) == false) goto L7;
        UserAuthService$batchGetAppletMetaInfo$1 r102 = (UserAuthService$batchGetAppletMetaInfo$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L18:
        return ((Result) r104).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        CoroutineDispatcher r107 = Dispatchers.getIO();
        UserAuthService$batchGetAppletMetaInfo$2 r108 = new UserAuthService$batchGetAppletMetaInfo$2(r100, null);
        r102.label = 1;
        r104 = BuildersKt.withContext(r107, r108, r102);
        if (r104 != r105) goto L18;
        return r105;
    L7:
        r102 = new UserAuthService$batchGetAppletMetaInfo$1(this, r101);
        goto L8
    }

    public final Object g(String r100, Continuation<? super Result<FetchDomainPolicyResponse.Data>> r101) {
        if ((r101 instanceof UserAuthService$fetchDomainPolicy$1) == false) goto L7;
        UserAuthService$fetchDomainPolicy$1 r102 = (UserAuthService$fetchDomainPolicy$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L18:
        return ((Result) r104).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        CoroutineDispatcher r107 = Dispatchers.getIO();
        UserAuthService$fetchDomainPolicy$2 r108 = new UserAuthService$fetchDomainPolicy$2(r100, null);
        r102.label = 1;
        r104 = BuildersKt.withContext(r107, r108, r102);
        if (r104 != r105) goto L18;
        return r105;
    L7:
        r102 = new UserAuthService$fetchDomainPolicy$1(this, r101);
        goto L8
    }

    public final Object h(String r100, Continuation<? super Result<AppMeta>> r101) {
        if ((r101 instanceof UserAuthService$getAppletMetaInfo$1) == false) goto L7;
        UserAuthService$getAppletMetaInfo$1 r102 = (UserAuthService$getAppletMetaInfo$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L18:
        return ((Result) r104).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        CoroutineDispatcher r107 = Dispatchers.getIO();
        UserAuthService$getAppletMetaInfo$2 r108 = new UserAuthService$getAppletMetaInfo$2(r100, null);
        r102.label = 1;
        r104 = BuildersKt.withContext(r107, r108, r102);
        if (r104 != r105) goto L18;
        return r105;
    L7:
        r102 = new UserAuthService$getAppletMetaInfo$1(this, r101);
        goto L8
    }

    public final Object i(String r100, Continuation<? super Result<n>> r101) {
        if ((r101 instanceof UserAuthService$getAwemeCommonLoginInfo$1) == false) goto L7;
        UserAuthService$getAwemeCommonLoginInfo$1 r102 = (UserAuthService$getAwemeCommonLoginInfo$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L18:
        return ((Result) r104).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        CoroutineDispatcher r107 = Dispatchers.getIO();
        UserAuthService$getAwemeCommonLoginInfo$2 r108 = new UserAuthService$getAwemeCommonLoginInfo$2(r100, null);
        r102.label = 1;
        r104 = BuildersKt.withContext(r107, r108, r102);
        if (r104 != r105) goto L18;
        return r105;
    L7:
        r102 = new UserAuthService$getAwemeCommonLoginInfo$1(this, r101);
        goto L8
    }

    public final Object m(String r100, Continuation<? super Result<String>> r101) {
        if ((r101 instanceof UserAuthService$getPhoneCode$1) == false) goto L7;
        UserAuthService$getPhoneCode$1 r102 = (UserAuthService$getPhoneCode$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L18:
        return ((Result) r104).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        CoroutineDispatcher r107 = Dispatchers.getIO();
        UserAuthService$getPhoneCode$2 r108 = new UserAuthService$getPhoneCode$2(r100, null);
        r102.label = 1;
        r104 = BuildersKt.withContext(r107, r108, r102);
        if (r104 != r105) goto L18;
        return r105;
    L7:
        r102 = new UserAuthService$getPhoneCode$1(this, r101);
        goto L8
    }

    public final Object n(String r100, Continuation<? super Result<String>> r101) {
        if ((r101 instanceof UserAuthService$getPhoneMask$1) == false) goto L7;
        UserAuthService$getPhoneMask$1 r102 = (UserAuthService$getPhoneMask$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L18:
        return ((Result) r104).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        CoroutineDispatcher r107 = Dispatchers.getIO();
        UserAuthService$getPhoneMask$2 r108 = new UserAuthService$getPhoneMask$2(r100, null);
        r102.label = 1;
        r104 = BuildersKt.withContext(r107, r108, r102);
        if (r104 != r105) goto L18;
        return r105;
    L7:
        r102 = new UserAuthService$getPhoneMask$1(this, r101);
        goto L8
    }

    public final Object s(UploadModelContextRequest r100, Continuation<? super Result<UploadModelContextResponse>> r101) {
        if ((r101 instanceof UserAuthService$uploadContext$1) == false) goto L7;
        UserAuthService$uploadContext$1 r102 = (UserAuthService$uploadContext$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L18:
        return ((Result) r104).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        CoroutineDispatcher r107 = Dispatchers.getIO();
        UserAuthService$uploadContext$2 r108 = new UserAuthService$uploadContext$2(r100, null);
        r102.label = 1;
        r104 = BuildersKt.withContext(r107, r108, r102);
        if (r104 != r105) goto L18;
        return r105;
    L7:
        r102 = new UserAuthService$uploadContext$1(this, r101);
        goto L8
    }

    public static /* synthetic */ Object p(List r100, List r101, Continuation r102) {
        return f36075a.o(r100, "zh_CN", r101, r102);
    }

    public final Object a(String r100, String r101, Continuation<? super Result<Boolean>> r102) {
        if ((r102 instanceof UserAuthService$acceptPrivacy$1) == false) goto L7;
        UserAuthService$acceptPrivacy$1 r103 = (UserAuthService$acceptPrivacy$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L18:
        return ((Result) r105).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        CoroutineDispatcher r108 = Dispatchers.getIO();
        UserAuthService$acceptPrivacy$2 r109 = new UserAuthService$acceptPrivacy$2(r100, r101, null);
        r103.label = 1;
        r105 = BuildersKt.withContext(r108, r109, r103);
        if (r105 != r106) goto L18;
        return r106;
    L7:
        r103 = new UserAuthService$acceptPrivacy$1(this, r102);
        goto L8
    }

    public final Object d(String r100, String r101, Continuation<? super Result<Boolean>> r102) {
        if ((r102 instanceof UserAuthService$checkPrivacy$1) == false) goto L7;
        UserAuthService$checkPrivacy$1 r103 = (UserAuthService$checkPrivacy$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L18:
        return ((Result) r105).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        CoroutineDispatcher r108 = Dispatchers.getIO();
        UserAuthService$checkPrivacy$2 r109 = new UserAuthService$checkPrivacy$2(r100, r101, null);
        r103.label = 1;
        r105 = BuildersKt.withContext(r108, r109, r103);
        if (r105 != r106) goto L18;
        return r106;
    L7:
        r103 = new UserAuthService$checkPrivacy$1(this, r102);
        goto L8
    }

    public static /* synthetic */ Object r(String r100, String r101, Integer r102, Continuation r103) {
        return f36075a.q(r100, r101, r102, null, r103);
    }

    public final Object e(String r100, String r101, CheckType r102, Continuation<? super Result<i>> r103) {
        if ((r103 instanceof UserAuthService$checkPrivacyOrLoginStatus$1) == false) goto L7;
        UserAuthService$checkPrivacyOrLoginStatus$1 r104 = (UserAuthService$checkPrivacyOrLoginStatus$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        ResultKt.throwOnFailure(r106);
    L18:
        return ((Result) r106).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        CoroutineDispatcher r109 = Dispatchers.getIO();
        UserAuthService$checkPrivacyOrLoginStatus$2 r110 = new UserAuthService$checkPrivacyOrLoginStatus$2(r100, r101, r102, null);
        r104.label = 1;
        r106 = BuildersKt.withContext(r109, r110, r104);
        if (r106 != r107) goto L18;
        return r107;
    L7:
        r104 = new UserAuthService$checkPrivacyOrLoginStatus$1(this, r103);
        goto L8
    }

    public final Object o(List<String> r100, String r101, List<String> r102, Continuation<? super Result<? extends List<AppletPermissionDetail>>> r103) {
        if ((r103 instanceof UserAuthService$getUserAppsPermissionDetail$1) == false) goto L7;
        UserAuthService$getUserAppsPermissionDetail$1 r104 = (UserAuthService$getUserAppsPermissionDetail$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        ResultKt.throwOnFailure(r106);
    L18:
        return ((Result) r106).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        CoroutineDispatcher r109 = Dispatchers.getIO();
        UserAuthService$getUserAppsPermissionDetail$2 r110 = new UserAuthService$getUserAppsPermissionDetail$2(r100, r101, r102, null);
        r104.label = 1;
        r106 = BuildersKt.withContext(r109, r110, r104);
        if (r106 != r107) goto L18;
        return r107;
    L7:
        r104 = new UserAuthService$getUserAppsPermissionDetail$1(this, r103);
        goto L8
    }

    public static /* synthetic */ Object k(String r100, String r101, String r102, Continuation r110, int r111) {
        UserAuthService r103 = f36075a;
        if ((r111 & 2) == 0) goto L5;
        r101 = "user_info";
    L5:
        String r104 = r101;
        if ((r111 & 4) == 0) goto L8;
        String r105 = "482431";
    L10:
        if ((r111 & 8) == 0) goto L12;
        String r106 = PrefetchTiming.JSB;
    L14:
        if ((r111 & 16) == 0) goto L16;
        String r107 = null;
    L18:
        return r103.j(r100, r104, r105, r106, r107, r110);
    L16:
        r107 = r102;
        goto L18
    L12:
        r106 = null;
        goto L14
    L8:
        r105 = null;
        goto L10
    }

    public final Object f(String r110, String r111, String r112, String r113, Continuation<? super Result<Boolean>> r114) {
        if ((r114 instanceof UserAuthService$exchangeCode$1) == false) goto L7;
        UserAuthService$exchangeCode$1 r100 = (UserAuthService$exchangeCode$1) r114;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r115 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r115);
    L18:
        return ((Result) r115).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r115);
        CoroutineDispatcher r116 = Dispatchers.getIO();
        UserAuthService$exchangeCode$2 r104 = new UserAuthService$exchangeCode$2(r112, r110, r111, r113, null);
        r100.label = 1;
        r115 = BuildersKt.withContext(r116, r104, r100);
        if (r115 != r102) goto L18;
        return r102;
    L7:
        r100 = new UserAuthService$exchangeCode$1(this, r114);
        goto L8
    }

    public final Object q(String r110, String r111, Integer r112, List<String> r113, Continuation<? super Result<Boolean>> r114) {
        if ((r114 instanceof UserAuthService$postUserAppsPermission$1) == false) goto L7;
        UserAuthService$postUserAppsPermission$1 r100 = (UserAuthService$postUserAppsPermission$1) r114;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r115 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r115);
    L18:
        return ((Result) r115).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r115);
        CoroutineDispatcher r116 = Dispatchers.getIO();
        UserAuthService$postUserAppsPermission$2 r104 = new UserAuthService$postUserAppsPermission$2(r111, r112, r110, r113, null);
        r100.label = 1;
        r115 = BuildersKt.withContext(r116, r104, r100);
        if (r115 != r102) goto L18;
        return r102;
    L7:
        r100 = new UserAuthService$postUserAppsPermission$1(this, r114);
        goto L8
    }

    public final Object j(String r110, String r111, String r112, String r113, String r114, Continuation<? super Result<String>> r115) {
        if ((r115 instanceof UserAuthService$getLoginCode$1) == false) goto L7;
        UserAuthService$getLoginCode$1 r100 = (UserAuthService$getLoginCode$1) r115;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L18:
        return ((Result) r102).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        CoroutineDispatcher r105 = Dispatchers.getIO();
        UserAuthService$getLoginCode$2 r106 = new UserAuthService$getLoginCode$2(r110, r112, r111, r113, r114, null);
        r100.label = 1;
        r102 = BuildersKt.withContext(r105, r106, r100);
        if (r102 != r103) goto L18;
        return r103;
    L7:
        r100 = new UserAuthService$getLoginCode$1(this, r115);
        goto L8
    }
}
