package I4;

import java.util.List;

/* loaded from: classes.dex */
public interface l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f3149a = new a();

    class a implements l {
        a() {
        }

        @Override // I4.l
        public boolean a(int i5, List<c> list) {
            return true;
        }

        @Override // I4.l
        public boolean b(int i5, List<c> list, boolean z5) {
            return true;
        }

        @Override // I4.l
        public boolean c(int i5, L4.g gVar, int i6, boolean z5) {
            gVar.skip(i6);
            return true;
        }

        @Override // I4.l
        public void d(int i5, b bVar) {
        }
    }

    boolean a(int i5, List<c> list);

    boolean b(int i5, List<c> list, boolean z5);

    boolean c(int i5, L4.g gVar, int i6, boolean z5);

    void d(int i5, b bVar);
}
