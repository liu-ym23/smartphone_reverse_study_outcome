package com.stepos.stepclaw.config;

import a6.f0;
import a6.i0;
import a6.r0;
import a6.x1;
import android.content.Context;
import androidx.emoji2.text.m;
import androidx.lifecycle.e0;
import h6.d;
import j0.c0;
import j0.f;
import j0.g0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.z;
import l0.b;
import l0.c;
import p5.l;
import r5.a;
import v5.h;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Landroid/content/Context;", "Lj0/f;", "Lm0/e;", "dataStore$delegate", "Lr5/a;", "getDataStore", "(Landroid/content/Context;)Lj0/f;", "dataStore", "step-runtime_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OpenClawConfigDataStoreKt {
    static final /* synthetic */ h[] $$delegatedProperties;
    private static final a dataStore$delegate;

    static {
        t tVar = new t(e.NO_RECEIVER, OpenClawConfigDataStoreKt.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;");
        z.f3687a.getClass();
        $$delegatedProperties = new h[]{tVar};
        h6.e eVar = r0.f210a;
        d dVar = d.f3059c;
        x1 x1VarC = i0.c();
        dVar.getClass();
        dataStore$delegate = new c(l0.a.f3726b, i0.b(b8.h.I(dVar, x1VarC)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final f getDataStore(Context thisRef) {
        m mVar;
        a aVar = dataStore$delegate;
        h property = $$delegatedProperties[0];
        c cVar = (c) aVar;
        cVar.getClass();
        p.e(thisRef, "thisRef");
        p.e(property, "property");
        m mVar2 = cVar.d;
        if (mVar2 != null) {
            return mVar2;
        }
        synchronized (cVar.f3731c) {
            try {
                if (cVar.d == null) {
                    Context applicationContext = thisRef.getApplicationContext();
                    l lVar = cVar.f3729a;
                    p.d(applicationContext, "applicationContext");
                    List migrations = (List) lVar.invoke(applicationContext);
                    f0 f0Var = cVar.f3730b;
                    b bVar = new b(applicationContext, cVar);
                    p.e(migrations, "migrations");
                    cVar.d = new m(new m(new c0(new g0(new e0(2, bVar)), a.a.S(new c4.c(migrations, 2, (f5.c) null)), new t1.f(19), f0Var)));
                }
                mVar = cVar.d;
                p.b(mVar);
            } catch (Throwable th) {
                throw th;
            }
        }
        return mVar;
    }
}
