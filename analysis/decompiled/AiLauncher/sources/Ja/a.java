package Ja;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<InterfaceC5063a<?>, Object> f3806a = new ConcurrentHashMap<>();

    public static final Void a(String message) {
        p.i(message, "message");
        throw new IllegalStateException(message.toString());
    }

    public static /* synthetic */ Void b(String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "should not be called";
        }
        return a(str);
    }
}
