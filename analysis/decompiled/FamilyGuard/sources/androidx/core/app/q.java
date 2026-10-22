package androidx.core.app;

import android.content.res.Configuration;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f9572a;

    /* renamed from: b, reason: collision with root package name */
    private Configuration f9573b;

    public q(boolean z5) {
        this.f9572a = z5;
    }

    public final boolean a() {
        return this.f9572a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q(boolean z5, Configuration configuration) {
        this(z5);
        j4.k.g(configuration, "newConfig");
        this.f9573b = configuration;
    }
}
