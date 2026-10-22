package com.stepos.policy.sdk;

import android.content.Context;
import com.stepos.policy.sdk.bean.PolicyRecordRequest;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import java.util.ArrayList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class Z extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f12087a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String[] f12088b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f12089c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f12090d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f12091e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f12092f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f12093g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ ArrayList f12094h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ String f12095i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f12096j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f12097k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Function1 f12098l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z(Context context, String[] strArr, String str, String str2, String str3, String str4, String str5, ArrayList arrayList, String str6, String str7, String str8, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f12087a = context;
        this.f12088b = strArr;
        this.f12089c = str;
        this.f12090d = str2;
        this.f12091e = str3;
        this.f12092f = str4;
        this.f12093g = str5;
        this.f12094h = arrayList;
        this.f12095i = str6;
        this.f12096j = str7;
        this.f12097k = str8;
        this.f12098l = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new Z(this.f12087a, this.f12088b, this.f12089c, this.f12090d, this.f12091e, this.f12092f, this.f12093g, this.f12094h, this.f12095i, this.f12096j, this.f12097k, this.f12098l, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((Z) create((Z2.F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ArrayList arrayList;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        PolicyRecordRequest policyRecordRequestCreateRecordRequest = PolicyManager.createRecordRequest(this.f12087a, this.f12088b, this.f12089c, this.f12090d);
        String str = this.f12091e;
        policyRecordRequestCreateRecordRequest.setVerify_type(str);
        policyRecordRequestCreateRecordRequest.setServiceName(this.f12092f);
        policyRecordRequestCreateRecordRequest.setValidateCode(this.f12093g);
        if (!Intrinsics.areEqual(str, "0") && (arrayList = this.f12094h) != null && arrayList.size() > 0) {
            policyRecordRequestCreateRecordRequest.setDeleteInfoList(arrayList);
        }
        PolicySdkLogUtils.INSTANCE.d("uploadRecordToCleanServiceData", "verifyType " + str + " | policyRecordRequest.deleteInfoList = " + policyRecordRequestCreateRecordRequest.getDeleteInfoList());
        PolicyManager.uploadRecordByCustomRecordRequest(this.f12087a, this.f12095i, this.f12096j, this.f12097k, policyRecordRequestCreateRecordRequest, this.f12098l);
        return Unit.INSTANCE;
    }
}
