package com.stepos.net.cache;

import La.H;
import La.r;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* synthetic */ class CacheTagStore$bind$1 extends FunctionReferenceImpl implements InterfaceC5074l<String, String> {

    /* renamed from: a, reason: collision with root package name */
    public static final CacheTagStore$bind$1 f30243a = new CacheTagStore$bind$1();

    public CacheTagStore$bind$1() {
        super(1, r.class, "trim", "trim(Ljava/lang/String;)Ljava/lang/String;", 1);
    }

    @Override // p9.InterfaceC5074l
    public final String invoke(String p02) {
        p.i(p02, "p0");
        return H.D1(p02).toString();
    }
}
