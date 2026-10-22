package androidx.databinding;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends androidx.databinding.a {

    public class a extends Observable.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f2905a;

        public a(b r10) {
            this.f2905a = r10;
        }

        @Override // androidx.databinding.Observable.a
        public void a(Observable r10, int r11) {
            this.f2905a.notifyChange();
        }
    }

    public b() {
    }

    public b(Observable... r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.length == 0) goto L12;
        a r11 = new a(this);
        int r12 = 0;
    L8:
        if (r12 >= r10.length) goto L13;
        r10[r12].addOnPropertyChangedCallback(r11);
        r12 = r12 + 1;
        goto L8
    L13:
        return;
    }
}
