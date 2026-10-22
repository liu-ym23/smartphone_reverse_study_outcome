package com.stepos.policy.sdk;

import C7.r;
import kotlin.coroutines.intrinsics.CoroutineSingletons;

/* loaded from: classes3.dex */
public final class c implements p9.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3944a;
    public final /* synthetic */ p9.c b;

    public /* synthetic */ c(p9.c cVar, int i) {
        this.f3944a = i;
        this.b = cVar;
    }

    @Override // p9.c
    public final Object collect(p9.d dVar, H7.c cVar) {
        switch (this.f3944a) {
            case 0:
                Object objCollect = this.b.collect(new b(dVar, 0), cVar);
                if (objCollect != CoroutineSingletons.f4909a) {
                    break;
                }
                break;
            case 1:
                Object objCollect2 = this.b.collect(new b(dVar, 1), cVar);
                if (objCollect2 != CoroutineSingletons.f4909a) {
                    break;
                }
                break;
            case 2:
                Object objCollect3 = this.b.collect(new b(dVar, 2), cVar);
                if (objCollect3 != CoroutineSingletons.f4909a) {
                    break;
                }
                break;
            case 3:
                Object objCollect4 = this.b.collect(new b(dVar, 3), cVar);
                if (objCollect4 != CoroutineSingletons.f4909a) {
                    break;
                }
                break;
            default:
                Object objCollect5 = this.b.collect(new b(dVar, 4), cVar);
                if (objCollect5 != CoroutineSingletons.f4909a) {
                    break;
                }
                break;
        }
        return r.f317a;
    }
}
