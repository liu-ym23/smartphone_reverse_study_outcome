package k0;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: k0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0676d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13322a;

    /* renamed from: b, reason: collision with root package name */
    public String f13323b;

    /* renamed from: c, reason: collision with root package name */
    public AbstractC0675c f13324c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f13325d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13326e;

    public C0676d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f13322a = context;
    }

    public final e a() {
        String str;
        AbstractC0675c abstractC0675c = this.f13324c;
        if (abstractC0675c == null) {
            throw new IllegalArgumentException("Must set a callback to create the configuration.".toString());
        }
        if (this.f13325d && ((str = this.f13323b) == null || str.length() == 0)) {
            throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.".toString());
        }
        return new e(this.f13322a, this.f13323b, abstractC0675c, this.f13325d, this.f13326e);
    }
}
