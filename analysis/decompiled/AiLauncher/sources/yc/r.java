package yc;

import java.util.concurrent.Executor;
import yc.c;
import yc.s;

/* loaded from: classes5.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final Executor f44414a;

    /* renamed from: b, reason: collision with root package name */
    public static final s f44415b;

    /* renamed from: c, reason: collision with root package name */
    public static final c f44416c;

    static {
        String property = System.getProperty("java.vm.name");
        property.getClass();
        if (property.equals("RoboVM")) {
            f44414a = null;
            f44415b = new s();
            f44416c = new c();
        } else if (property.equals("Dalvik")) {
            f44414a = new ExecutorC6042a();
            f44415b = new s.a();
            f44416c = new c.a();
        } else {
            f44414a = null;
            f44415b = new s.b();
            f44416c = new c.a();
        }
    }
}
