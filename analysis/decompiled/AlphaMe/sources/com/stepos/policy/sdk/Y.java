package com.stepos.policy.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.bean.PolicyRecordRequest;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class Y extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public PolicyRecordRequest f12073a;

    /* renamed from: b, reason: collision with root package name */
    public int f12074b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f12075c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String[] f12076d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f12077e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f12078f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f12079g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f12080h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ String f12081i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ ArrayList f12082j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f12083k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f12084l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f12085m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Function1 f12086n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y(Context context, String[] strArr, String str, String str2, String str3, String str4, String str5, ArrayList arrayList, String str6, String str7, String str8, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f12075c = context;
        this.f12076d = strArr;
        this.f12077e = str;
        this.f12078f = str2;
        this.f12079g = str3;
        this.f12080h = str4;
        this.f12081i = str5;
        this.f12082j = arrayList;
        this.f12083k = str6;
        this.f12084l = str7;
        this.f12085m = str8;
        this.f12086n = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new Y(this.f12075c, this.f12076d, this.f12077e, this.f12078f, this.f12079g, this.f12080h, this.f12081i, this.f12082j, this.f12083k, this.f12084l, this.f12085m, this.f12086n, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((Y) create((Z2.F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PolicyRecordRequest policyRecordRequest;
        PolicyRecordRequest policyRecordRequest2;
        ArrayList arrayList;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f12074b;
        String str = this.f12079g;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            String str2 = this.f12077e;
            String str3 = this.f12078f;
            Context context = this.f12075c;
            PolicyRecordRequest policyRecordRequestCreateRecordRequest = PolicyManager.createRecordRequest(context, this.f12076d, str2, str3);
            policyRecordRequestCreateRecordRequest.setVerify_type(str);
            policyRecordRequestCreateRecordRequest.setServiceName(this.f12080h);
            policyRecordRequestCreateRecordRequest.setValidateCode(this.f12081i);
            if (!Intrinsics.areEqual(str, "0") && (arrayList = this.f12082j) != null && arrayList.size() > 0) {
                policyRecordRequestCreateRecordRequest.setDeleteInfoList(arrayList);
            }
            if (!Intrinsics.areEqual(str, "1") && !Intrinsics.areEqual(str, "3")) {
                policyRecordRequest2 = policyRecordRequestCreateRecordRequest;
                PolicySdkLogUtils.INSTANCE.d("uploadRecordToCleanServiceData", "verifyType " + str + " | policyRecordRequest.deleteInfoList = " + policyRecordRequest2.getDeleteInfoList());
                PolicyManager.uploadRecordByCustomRecordRequest(this.f12075c, this.f12083k, this.f12084l, this.f12085m, policyRecordRequest2, this.f12086n);
                return Unit.INSTANCE;
            }
            PolicyManager policyManager = PolicyManager.INSTANCE;
            V.f fVar = b0.f12129g;
            this.f12073a = policyRecordRequestCreateRecordRequest;
            this.f12074b = 1;
            Object dataStoreString = policyManager.getDataStoreString(context, fVar, this);
            if (dataStoreString == coroutine_suspended) {
                return coroutine_suspended;
            }
            policyRecordRequest = policyRecordRequestCreateRecordRequest;
            obj = dataStoreString;
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            policyRecordRequest = this.f12073a;
            ResultKt.throwOnFailure(obj);
        }
        String str4 = (String) obj;
        if (str4 != null && !TextUtils.isEmpty(str4)) {
            ArrayList<DeleteInfoBean> deleteInfoBeanByGson = PolicySdkToolsUtils.INSTANCE.getDeleteInfoBeanByGson(str4);
            PolicySdkLogUtils.INSTANCE.d("uploadRecordToCleanServiceData", "commonDeleteInfoList = " + deleteInfoBeanByGson);
            policyRecordRequest.setDeleteInfoList(CollectionsKt.toMutableList((Collection) CollectionsKt.plus((Collection) policyRecordRequest.getDeleteInfoList(), (Iterable) deleteInfoBeanByGson)));
        }
        policyRecordRequest2 = policyRecordRequest;
        PolicySdkLogUtils.INSTANCE.d("uploadRecordToCleanServiceData", "verifyType " + str + " | policyRecordRequest.deleteInfoList = " + policyRecordRequest2.getDeleteInfoList());
        PolicyManager.uploadRecordByCustomRecordRequest(this.f12075c, this.f12083k, this.f12084l, this.f12085m, policyRecordRequest2, this.f12086n);
        return Unit.INSTANCE;
    }
}
