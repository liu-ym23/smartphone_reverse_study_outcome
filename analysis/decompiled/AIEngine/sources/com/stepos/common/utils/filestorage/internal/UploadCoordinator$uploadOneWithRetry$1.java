package com.stepos.common.utils.filestorage.internal;

import android.content.Context;
import java.io.Serializable;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import o8.h;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.common.utils.filestorage.internal.UploadCoordinator", f = "UploadCoordinator.kt", l = {160, 193}, m = "uploadOneWithRetry")
/* loaded from: classes.dex */
final class UploadCoordinator$uploadOneWithRetry$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public UploadCoordinator f6751a;

    /* renamed from: b, reason: collision with root package name */
    public Context f6752b;

    /* renamed from: c, reason: collision with root package name */
    public h f6753c;

    /* renamed from: d, reason: collision with root package name */
    public Long f6754d;

    /* renamed from: e, reason: collision with root package name */
    public n8.a f6755e;
    public Serializable h;

    /* renamed from: j, reason: collision with root package name */
    public String f6756j;

    /* renamed from: k, reason: collision with root package name */
    public int f6757k;

    /* renamed from: l, reason: collision with root package name */
    public int f6758l;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f6759m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ UploadCoordinator f6760n;

    /* renamed from: o, reason: collision with root package name */
    public int f6761o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadCoordinator$uploadOneWithRetry$1(UploadCoordinator uploadCoordinator, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f6760n = uploadCoordinator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6759m = obj;
        this.f6761o |= Integer.MIN_VALUE;
        return UploadCoordinator.a(this.f6760n, null, null, null, null, this);
    }
}
