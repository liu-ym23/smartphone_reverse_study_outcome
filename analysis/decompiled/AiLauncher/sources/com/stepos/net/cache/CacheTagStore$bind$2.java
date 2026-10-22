package com.stepos.net.cache;

import La.r;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* synthetic */ class CacheTagStore$bind$2 extends FunctionReferenceImpl implements InterfaceC5074l<String, Boolean> {

    /* renamed from: a, reason: collision with root package name */
    public static final CacheTagStore$bind$2 f30244a = new CacheTagStore$bind$2();

    public CacheTagStore$bind$2() {
        super(1, r.class, "isNotEmpty", "isNotEmpty(Ljava/lang/CharSequence;)Z", 1);
    }

    @Override // p9.InterfaceC5074l
    public final Boolean invoke(String p02) {
        p.i(p02, "p0");
        return Boolean.valueOf(p02.length() > 0);
    }
}
