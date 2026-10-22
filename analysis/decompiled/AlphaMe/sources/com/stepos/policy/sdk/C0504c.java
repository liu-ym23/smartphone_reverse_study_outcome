package com.stepos.policy.sdk;

import com.stepos.policy.sdk.PolicySdk;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;

/* renamed from: com.stepos.policy.sdk.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0504c implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PolicySdk.PolicySdkEncryptCallback f12130a;

    public C0504c(PolicySdk.PolicySdkEncryptCallback policySdkEncryptCallback) {
        this.f12130a = policySdkEncryptCallback;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.f12130a.getResult((ArrayList) obj);
        return null;
    }
}
