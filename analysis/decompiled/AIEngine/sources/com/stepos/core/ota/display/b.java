package com.stepos.core.ota.display;

import android.content.Context;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.datastore.preferences.protobuf.b1;
import androidx.lifecycle.x;
import h2.m;
import java.io.File;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7565a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7566b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f7567c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f7568d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f7569e;
    public final /* synthetic */ Object h;

    public /* synthetic */ b(b1 b1Var, String str, zb.a aVar, x xVar, CallbackToFutureAdapter.a aVar2) {
        this.f7567c = b1Var;
        this.f7566b = str;
        this.f7568d = aVar;
        this.f7569e = xVar;
        this.h = aVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f7565a;
        Object obj = this.h;
        Object obj2 = this.f7569e;
        Object obj3 = this.f7568d;
        String str = this.f7566b;
        Object obj4 = this.f7567c;
        switch (i10) {
            case 0:
                ModelDisplayResourceStore.stagePresetDisplayAsync$lambda$29$lambda$28((ModelDisplayResourceStore) obj4, (Context) obj3, str, (File) obj, (String) obj2);
                return;
            default:
                b1 b1Var = (b1) obj4;
                zb.a aVar = (zb.a) obj3;
                x xVar = (x) obj2;
                CallbackToFutureAdapter.a aVar2 = (CallbackToFutureAdapter.a) obj;
                b1Var.getClass();
                boolean zA = c2.b.a();
                if (zA) {
                    try {
                        b1Var.h(str);
                    } finally {
                        if (zA) {
                            b1Var.D();
                        }
                    }
                }
                try {
                    aVar.invoke();
                    m.a.c cVar = m.f9276a;
                    xVar.g(cVar);
                    aVar2.a(cVar);
                } catch (Throwable th) {
                    xVar.g(new m.a.C0089a(th));
                    aVar2.b(th);
                }
                n nVar = n.f10413a;
                if (zA) {
                    return;
                } else {
                    return;
                }
        }
    }

    public /* synthetic */ b(ModelDisplayResourceStore modelDisplayResourceStore, Context context, String str, File file, String str2) {
        this.f7567c = modelDisplayResourceStore;
        this.f7568d = context;
        this.f7566b = str;
        this.h = file;
        this.f7569e = str2;
    }
}
