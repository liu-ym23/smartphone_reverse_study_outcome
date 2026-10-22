package com.stepos.policy.sdk;

import com.stepos.policy.sdk.PolicySdk;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;

/* renamed from: com.stepos.policy.sdk.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0505d implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PolicySdk.PolicySdkEncryptCallback f12139a;

    public C0505d(PolicySdk.PolicySdkEncryptCallback policySdkEncryptCallback) {
        this.f12139a = policySdkEncryptCallback;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.f12139a.getResult((ArrayList) obj);
        return null;
    }
}
