package com.stepos.policy.sdk;

import android.content.Context;
import com.stepos.policy.sdk.bean.PolicyNewestPathResultBean;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: com.stepos.policy.sdk.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0513l extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Context f12217a;

    /* renamed from: b, reason: collision with root package name */
    public String f12218b;

    /* renamed from: c, reason: collision with root package name */
    public String f12219c;

    /* renamed from: d, reason: collision with root package name */
    public PolicySdkResultBean f12220d;

    /* renamed from: e, reason: collision with root package name */
    public PolicyNewestPathResultBean f12221e;

    /* renamed from: f, reason: collision with root package name */
    public String f12222f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f12223g;

    /* renamed from: h, reason: collision with root package name */
    public int f12224h;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f12223g = obj;
        this.f12224h |= Integer.MIN_VALUE;
        return PolicyManager.initPolicyNewestPath(null, null, null, this);
    }
}
