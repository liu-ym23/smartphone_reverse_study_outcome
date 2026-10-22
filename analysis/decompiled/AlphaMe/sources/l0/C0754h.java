package l0;

import S.A;
import android.content.Context;
import k0.AbstractC0675c;
import k0.InterfaceC0674b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: l0.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0754h implements k0.g {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13445a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13446b;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC0675c f13447c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f13448d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f13449e;

    /* renamed from: f, reason: collision with root package name */
    public final Lazy f13450f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f13451g;

    public C0754h(Context context, String str, AbstractC0675c callback, boolean z4, boolean z5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f13445a = context;
        this.f13446b = str;
        this.f13447c = callback;
        this.f13448d = z4;
        this.f13449e = z5;
        this.f13450f = LazyKt.lazy(new A(4, this));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Lazy lazy = this.f13450f;
        if (lazy.isInitialized()) {
            ((C0753g) lazy.getValue()).close();
        }
    }

    @Override // k0.g
    public final InterfaceC0674b getWritableDatabase() {
        return ((C0753g) this.f13450f.getValue()).a(true);
    }

    @Override // k0.g
    public final void setWriteAheadLoggingEnabled(boolean z4) {
        Lazy lazy = this.f13450f;
        if (lazy.isInitialized()) {
            C0753g sQLiteOpenHelper = (C0753g) lazy.getValue();
            Intrinsics.checkNotNullParameter(sQLiteOpenHelper, "sQLiteOpenHelper");
            sQLiteOpenHelper.setWriteAheadLoggingEnabled(z4);
        }
        this.f13451g = z4;
    }
}
