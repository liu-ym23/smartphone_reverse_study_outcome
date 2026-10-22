package i;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import w7.e0;

/* loaded from: classes.dex */
public final class c extends e0 {

    /* renamed from: c, reason: collision with root package name */
    public final Object f4391c;

    /* renamed from: d, reason: collision with root package name */
    public final ExecutorService f4392d;

    public c() {
        super(21);
        this.f4391c = new Object();
        this.f4392d = Executors.newFixedThreadPool(4, new b());
    }
}
