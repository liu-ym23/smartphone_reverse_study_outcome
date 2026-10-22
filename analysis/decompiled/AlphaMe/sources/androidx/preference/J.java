package androidx.preference;

import K.C0069b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

/* loaded from: classes.dex */
public final class J extends RecyclerViewAccessibilityDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final RecyclerView f4033a;

    /* renamed from: b, reason: collision with root package name */
    public final C0069b f4034b;

    /* renamed from: c, reason: collision with root package name */
    public final I f4035c;

    public J(RecyclerView recyclerView) {
        super(recyclerView);
        this.f4034b = super.getItemDelegate();
        this.f4035c = new I(this);
        this.f4033a = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
    public final C0069b getItemDelegate() {
        return this.f4035c;
    }
}
