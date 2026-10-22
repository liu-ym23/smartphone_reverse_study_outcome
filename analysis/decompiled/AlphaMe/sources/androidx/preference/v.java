package androidx.preference;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Preference f4165a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4166b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ y f4167c;

    public v(y yVar, Preference preference, String str) {
        this.f4167c = yVar;
        this.f4165a = preference;
        this.f4166b = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        y yVar = this.f4167c;
        RecyclerView.Adapter adapter = yVar.mList.getAdapter();
        if (!(adapter instanceof z)) {
            if (adapter != 0) {
                throw new IllegalStateException("Adapter must implement PreferencePositionCallback");
            }
            return;
        }
        String str = this.f4166b;
        Preference preference = this.f4165a;
        int preferenceAdapterPosition = preference != null ? ((z) adapter).getPreferenceAdapterPosition(preference) : ((z) adapter).getPreferenceAdapterPosition(str);
        if (preferenceAdapterPosition != -1) {
            yVar.mList.scrollToPosition(preferenceAdapterPosition);
        } else {
            adapter.registerAdapterDataObserver(new x(adapter, yVar.mList, preference, str));
        }
    }
}
