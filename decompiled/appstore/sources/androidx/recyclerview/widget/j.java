package androidx.recyclerview.widget;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class j extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AsyncListDiffer f4424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AsyncListDiffer.ListListener f4425b;

    public class a implements AsyncListDiffer.ListListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f4426a;

        public a(j r10) {
            this.f4426a = r10;
        }

        @Override // androidx.recyclerview.widget.AsyncListDiffer.ListListener
        public void onCurrentListChanged(List r10, List r11) {
            this.f4426a.a(r10, r11);
        }
    }

    public j(DiffUtil.ItemCallback r10) {
        a r11 = new a(this);
        this.f4425b = r11;
        AsyncListDiffer r12 = new AsyncListDiffer(new androidx.recyclerview.widget.a(this), new b.a(r10).a());
        this.f4424a = r12;
        r12.a(r11);
    }

    public void a(List r10, List r11) {
    }

    public void b(List r10) {
        this.f4424a.e(r10);
    }

    public Object getItem(int r10) {
        return this.f4424a.b().get(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f4424a.b().size();
    }
}
