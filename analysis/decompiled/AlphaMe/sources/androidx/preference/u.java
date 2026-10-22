package androidx.preference;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4163a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4164b;

    public /* synthetic */ u(int i4, Object obj) {
        this.f4163a = i4;
        this.f4164b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4163a) {
            case 0:
                RecyclerView recyclerView = ((y) this.f4164b).mList;
                recyclerView.focusableViewAvailable(recyclerView);
                break;
            case 1:
                ((C0333e) this.f4164b).m();
                break;
            default:
                ((C) this.f4164b).updatePreferences();
                break;
        }
    }
}
