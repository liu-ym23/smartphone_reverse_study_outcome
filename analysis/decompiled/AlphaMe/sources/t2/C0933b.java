package t2;

import B0.g;
import android.os.Trace;
import android.util.Log;
import androidx.room.AbstractC0351g;
import com.google.android.gms.common.api.internal.p;
import com.stepos.renderfilter.RenderFilter;
import com.stepos.renderfilter.functor.DrawGlInfo;

/* renamed from: t2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0933b implements InterfaceC0934c {

    /* renamed from: a, reason: collision with root package name */
    public final String f15437a;

    /* renamed from: b, reason: collision with root package name */
    public final String f15438b;

    /* renamed from: c, reason: collision with root package name */
    public final String f15439c;

    /* renamed from: d, reason: collision with root package name */
    public final String f15440d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC0934c f15441e;

    /* renamed from: f, reason: collision with root package name */
    public final long f15442f;

    public C0933b(long j4, p pVar) {
        this.f15442f = j4;
        this.f15437a = AbstractC0351g.n("RenderFilter-onDraw-", j4);
        this.f15438b = AbstractC0351g.n("RenderFilter-onSync-", j4);
        this.f15439c = AbstractC0351g.n("RenderFilter-onInvoke-", j4);
        this.f15440d = AbstractC0351g.n("RenderFilter-onContextDestroyed-", j4);
        this.f15441e = pVar;
    }

    public static void a(String str, String str2, Object... objArr) {
        if (RenderFilter.f12294e) {
            StringBuilder sbW = g.w("[", str, "], ");
            sbW.append(String.format(str2, objArr));
            Log.v("RenderFilter", sbW.toString());
        }
    }

    @Override // t2.InterfaceC0934c
    public final void b() {
        try {
            Trace.beginSection(this.f15438b);
            a("onSync", "functor=%d", Long.valueOf(this.f15442f));
            this.f15441e.b();
        } finally {
            Trace.endSection();
        }
    }

    @Override // t2.InterfaceC0934c
    public final void d(DrawGlInfo drawGlInfo) {
        try {
            Trace.beginSection(this.f15437a);
            a("onDraw", "drawGlInfo=%s, functor=%d", drawGlInfo, Long.valueOf(this.f15442f));
            this.f15441e.d(drawGlInfo);
        } finally {
            Trace.endSection();
        }
    }

    @Override // t2.InterfaceC0934c
    public final void g() {
        try {
            Trace.beginSection(this.f15440d);
            a("onContextDestroyed", "functor=%d", Long.valueOf(this.f15442f));
            this.f15441e.g();
        } finally {
            Trace.endSection();
        }
    }

    @Override // t2.InterfaceC0934c
    public final void j(boolean z4) {
        try {
            Trace.beginSection(this.f15439c);
            a("onInvoke", "functor=%d", Long.valueOf(this.f15442f));
            this.f15441e.j(z4);
        } finally {
            Trace.endSection();
        }
    }
}
