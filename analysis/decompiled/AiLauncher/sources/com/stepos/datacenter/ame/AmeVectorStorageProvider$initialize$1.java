package com.stepos.datacenter.ame;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.modelcontextprotocol.spec.McpSchema;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.datacenter.ame.AmeVectorStorageProvider", f = "AmeVectorStorageProvider.kt", l = {1027, 76, 78}, m = McpSchema.METHOD_INITIALIZE)
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AmeVectorStorageProvider$initialize$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f29703a;

    /* renamed from: b, reason: collision with root package name */
    public Object f29704b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f29705c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AmeVectorStorageProvider f29706d;

    /* renamed from: e, reason: collision with root package name */
    public int f29707e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmeVectorStorageProvider$initialize$1(AmeVectorStorageProvider ameVectorStorageProvider, InterfaceC4014c<? super AmeVectorStorageProvider$initialize$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f29706d = ameVectorStorageProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29705c = obj;
        this.f29707e |= Integer.MIN_VALUE;
        return this.f29706d.B(this);
    }
}
