package b0;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import java.util.ArrayList;
import s.k1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z implements k0.d, k1 {

    /* renamed from: c, reason: collision with root package name */
    public int f1801c;

    /* renamed from: f, reason: collision with root package name */
    public int f1802f;

    /* renamed from: g, reason: collision with root package name */
    public Object f1803g;

    public z(Context context, XmlResourceParser xmlResourceParser) throws Resources.NotFoundException {
        this.f1803g = new ArrayList();
        this.f1802f = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), z2.q.f16339h);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == 0) {
                this.f1801c = typedArrayObtainStyledAttributes.getResourceId(index, this.f1801c);
            } else if (index == 1) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f1802f);
                this.f1802f = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if ("layout".equals(resourceTypeName)) {
                    new z2.m().a(resourceId, context);
                }
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // k0.d
    public void c(int i, Object obj) {
        ((k0.d) this.f1803g).c(i + (this.f1802f == 0 ? this.f1801c : 0), obj);
    }

    @Override // k0.d
    public void d(Object obj) {
        this.f1802f++;
        ((k0.d) this.f1803g).d(obj);
    }

    @Override // k0.d
    public void e() {
        ((k0.d) this.f1803g).e();
    }

    @Override // k0.d
    public void f(int i, int i3, int i10) {
        int i11 = this.f1802f == 0 ? this.f1801c : 0;
        ((k0.d) this.f1803g).f(i + i11, i3 + i11, i10);
    }

    @Override // k0.d
    public void g(int i, int i3) {
        ((k0.d) this.f1803g).g(i + (this.f1802f == 0 ? this.f1801c : 0), i3);
    }

    @Override // s.j1
    public s.n h(long j10, s.n nVar, s.n nVar2, s.n nVar3) {
        return ((p5.i) this.f1803g).h(j10, nVar, nVar2, nVar3);
    }

    @Override // k0.d
    public void i() {
        if (this.f1802f <= 0) {
            k0.t.c("OffsetApplier up called with no corresponding down");
        }
        this.f1802f--;
        ((k0.d) this.f1803g).i();
    }

    @Override // k0.d
    public void j(int i, Object obj) {
        ((k0.d) this.f1803g).j(i + (this.f1802f == 0 ? this.f1801c : 0), obj);
    }

    @Override // s.j1
    public s.n k(long j10, s.n nVar, s.n nVar2, s.n nVar3) {
        return ((p5.i) this.f1803g).k(j10, nVar, nVar2, nVar3);
    }

    @Override // k0.d
    public Object m() {
        return ((k0.d) this.f1803g).m();
    }

    @Override // k0.d
    public void n(Object obj, xb.p pVar) {
        ((k0.d) this.f1803g).n(obj, pVar);
    }

    @Override // s.k1
    public int o() {
        return this.f1802f;
    }

    @Override // s.k1
    public int r() {
        return this.f1801c;
    }

    public z() {
        this.f1803g = new z[ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH];
        this.f1801c = 0;
        this.f1802f = 0;
    }
}
