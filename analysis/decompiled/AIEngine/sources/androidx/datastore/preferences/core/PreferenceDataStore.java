package androidx.datastore.preferences.core;

import d1.c;
import qb.b;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PreferenceDataStore implements c<g1.a> {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.datastore.core.c f1709a;

    public PreferenceDataStore(androidx.datastore.core.c cVar) {
        this.f1709a = cVar;
    }

    @Override // d1.c
    public final Object a(p<? super g1.a, ? super b<? super g1.a>, ? extends Object> pVar, b<? super g1.a> bVar) {
        return this.f1709a.a(new PreferenceDataStore$updateData$2(pVar, null), bVar);
    }
}
