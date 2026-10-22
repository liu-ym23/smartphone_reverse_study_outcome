package wd;

import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.ILoggerFactory;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements ILoggerFactory {

    /* renamed from: a, reason: collision with root package name */
    public boolean f13686a = false;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f13687b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedBlockingQueue<vd.c> f13688c = new LinkedBlockingQueue<>();

    @Override // org.slf4j.ILoggerFactory
    public final synchronized ud.a a(String str) {
        a aVar;
        aVar = (a) this.f13687b.get(str);
        if (aVar == null) {
            aVar = new a(str, this.f13688c, this.f13686a);
            this.f13687b.put(str, aVar);
        }
        return aVar;
    }
}
