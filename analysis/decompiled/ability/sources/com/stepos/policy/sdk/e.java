package com.stepos.policy.sdk;

import C7.r;
import androidx.datastore.preferences.core.Preferences;
import kotlin.coroutines.intrinsics.CoroutineSingletons;

/* loaded from: classes3.dex */
public final class e implements p9.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3947a;
    public final /* synthetic */ p9.c b;
    public final /* synthetic */ Object c;

    public /* synthetic */ e(p9.c cVar, Object obj, int i) {
        this.f3947a = i;
        this.b = cVar;
        this.c = obj;
    }

    @Override // p9.c
    public final Object collect(p9.d dVar, H7.c cVar) {
        switch (this.f3947a) {
            case 0:
                Object objCollect = this.b.collect(new d(0, dVar, (Preferences.Key) this.c), cVar);
                if (objCollect != CoroutineSingletons.f4909a) {
                    break;
                }
                break;
            default:
                Object objCollect2 = this.b.collect(new d(1, dVar, (String) this.c), cVar);
                if (objCollect2 != CoroutineSingletons.f4909a) {
                    break;
                }
                break;
        }
        return r.f317a;
    }
}
