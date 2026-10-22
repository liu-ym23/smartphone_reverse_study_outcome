package com.stepos.policy.sdk;

import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.stepos.policy.sdk.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0510i extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f12192a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0510i(Function1 function1) {
        super(1);
        this.f12192a = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        PolicyManager policyManager = PolicyManager.INSTANCE;
        PolicySdkLogUtils.INSTANCE.d("getPrivateDeleteInfoList", "result = " + arrayList);
        this.f12192a.invoke(arrayList);
        return Unit.INSTANCE;
    }
}
