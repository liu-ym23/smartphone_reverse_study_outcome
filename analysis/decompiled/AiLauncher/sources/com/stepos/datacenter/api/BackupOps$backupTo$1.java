package com.stepos.datacenter.api;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.datacenter.api.BackupOps", f = "BackupOps.kt", l = {29}, m = "backupTo")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BackupOps$backupTo$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f29804a;

    /* renamed from: b, reason: collision with root package name */
    public Object f29805b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f29806c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BackupOps f29807d;

    /* renamed from: e, reason: collision with root package name */
    public int f29808e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackupOps$backupTo$1(BackupOps backupOps, InterfaceC4014c<? super BackupOps$backupTo$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f29807d = backupOps;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29806c = obj;
        this.f29808e |= Integer.MIN_VALUE;
        return this.f29807d.a(null, this);
    }
}
