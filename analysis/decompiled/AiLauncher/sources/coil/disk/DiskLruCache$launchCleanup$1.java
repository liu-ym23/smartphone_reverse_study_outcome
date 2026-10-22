package coil.disk;

import Mb.u;
import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.io.IOException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "coil.disk.DiskLruCache$launchCleanup$1", f = "DiskLruCache.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DiskLruCache$launchCleanup$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f15641a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DiskLruCache f15642b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiskLruCache$launchCleanup$1(DiskLruCache diskLruCache, InterfaceC4014c<? super DiskLruCache$launchCleanup$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f15642b = diskLruCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new DiskLruCache$launchCleanup$1(this.f15642b, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((DiskLruCache$launchCleanup$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.f15641a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        DiskLruCache diskLruCache = this.f15642b;
        synchronized (diskLruCache) {
            if (!diskLruCache.initialized || diskLruCache.com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland.REASON_CLOSED java.lang.String) {
                return t.f7040a;
            }
            try {
                diskLruCache.m1();
            } catch (IOException unused) {
                diskLruCache.mostRecentTrimFailed = true;
            }
            try {
                if (diskLruCache.R0()) {
                    diskLruCache.t1();
                }
            } catch (IOException unused2) {
                diskLruCache.mostRecentRebuildFailed = true;
                diskLruCache.journalWriter = u.b(u.a());
            }
            return t.f7040a;
        }
    }
}
