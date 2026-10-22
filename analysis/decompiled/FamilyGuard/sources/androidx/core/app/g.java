package androidx.core.app;

import android.content.res.Configuration;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f9458a;

    /* renamed from: b, reason: collision with root package name */
    private Configuration f9459b;

    public g(boolean z5) {
        this.f9458a = z5;
    }

    public final boolean a() {
        return this.f9458a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(boolean z5, Configuration configuration) {
        this(z5);
        j4.k.g(configuration, "newConfig");
        this.f9459b = configuration;
    }
}
