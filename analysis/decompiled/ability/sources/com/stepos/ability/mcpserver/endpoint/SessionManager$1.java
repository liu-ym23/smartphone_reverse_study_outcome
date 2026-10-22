package com.stepos.ability.mcpserver.endpoint;

import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* synthetic */ class SessionManager$1 extends FunctionReferenceImpl implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public static final SessionManager$1 f3176a = new SessionManager$1();

    public SessionManager$1() {
        super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
    }

    @Override // S7.a
    public final Object invoke() {
        return Long.valueOf(System.currentTimeMillis());
    }
}
