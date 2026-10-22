package K;

import androidx.camera.core.impl.CameraCaptureFailure;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* renamed from: K.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0890m {

    /* renamed from: K.m$a */
    public static final class a extends AbstractC0889l {

        /* renamed from: a, reason: collision with root package name */
        public final List<AbstractC0889l> f4004a = new ArrayList();

        public a(List<AbstractC0889l> list) {
            for (AbstractC0889l abstractC0889l : list) {
                if (!(abstractC0889l instanceof b)) {
                    this.f4004a.add(abstractC0889l);
                }
            }
        }

        @Override // K.AbstractC0889l
        public void a(int i10) {
            Iterator<AbstractC0889l> it = this.f4004a.iterator();
            while (it.hasNext()) {
                it.next().a(i10);
            }
        }

        @Override // K.AbstractC0889l
        public void b(int i10, InterfaceC0891n interfaceC0891n) {
            Iterator<AbstractC0889l> it = this.f4004a.iterator();
            while (it.hasNext()) {
                it.next().b(i10, interfaceC0891n);
            }
        }

        @Override // K.AbstractC0889l
        public void c(int i10, CameraCaptureFailure cameraCaptureFailure) {
            Iterator<AbstractC0889l> it = this.f4004a.iterator();
            while (it.hasNext()) {
                it.next().c(i10, cameraCaptureFailure);
            }
        }

        @Override // K.AbstractC0889l
        public void d(int i10, int i11) {
            Iterator<AbstractC0889l> it = this.f4004a.iterator();
            while (it.hasNext()) {
                it.next().d(i10, i11);
            }
        }

        @Override // K.AbstractC0889l
        public void e(int i10) {
            Iterator<AbstractC0889l> it = this.f4004a.iterator();
            while (it.hasNext()) {
                it.next().e(i10);
            }
        }
    }

    /* renamed from: K.m$b */
    public static final class b extends AbstractC0889l {
        @Override // K.AbstractC0889l
        public void b(int i10, InterfaceC0891n interfaceC0891n) {
        }

        @Override // K.AbstractC0889l
        public void c(int i10, CameraCaptureFailure cameraCaptureFailure) {
        }

        @Override // K.AbstractC0889l
        public void e(int i10) {
        }
    }

    public static AbstractC0889l a(List<AbstractC0889l> list) {
        return list.isEmpty() ? c() : list.size() == 1 ? list.get(0) : new a(list);
    }

    public static AbstractC0889l b(AbstractC0889l... abstractC0889lArr) {
        return a(Arrays.asList(abstractC0889lArr));
    }

    public static AbstractC0889l c() {
        return new b();
    }
}
