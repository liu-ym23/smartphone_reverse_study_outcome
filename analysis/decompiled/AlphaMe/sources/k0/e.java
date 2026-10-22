package k0;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13327a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13328b;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC0675c f13329c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f13330d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f13331e;

    public e(Context context, String str, AbstractC0675c callback, boolean z4, boolean z5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f13327a = context;
        this.f13328b = str;
        this.f13329c = callback;
        this.f13330d = z4;
        this.f13331e = z5;
    }
}
