package com.stepos.common.utils.filestorage.internal;

import android.net.Uri;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.common.utils.filestorage.internal.UploadCoordinator", f = "UploadCoordinator.kt", l = {227, 241}, m = "uploadOne")
/* loaded from: classes.dex */
final class UploadCoordinator$uploadOne$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f6735a;

    /* renamed from: b, reason: collision with root package name */
    public Object f6736b;

    /* renamed from: c, reason: collision with root package name */
    public Object f6737c;

    /* renamed from: d, reason: collision with root package name */
    public n8.a f6738d;

    /* renamed from: e, reason: collision with root package name */
    public Uri f6739e;
    public String h;

    /* renamed from: j, reason: collision with root package name */
    public Long f6740j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ Object f6741k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ UploadCoordinator f6742l;

    /* renamed from: m, reason: collision with root package name */
    public int f6743m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadCoordinator$uploadOne$1(UploadCoordinator uploadCoordinator, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f6742l = uploadCoordinator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6741k = obj;
        this.f6743m |= Integer.MIN_VALUE;
        return this.f6742l.e(null, null, null, null, this);
    }
}
