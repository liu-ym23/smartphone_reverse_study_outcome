package za;

import com.obric.appstore.network.entity.template.ElementEntity;
import com.obric.appstore.ui.adapter.ItemType;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ItemType f26308b;

    public a() {
        this.f26308b = ItemType.FIXED_ENTRANCE;
    }

    @Override // za.f
    public ItemType a() {
        return this.f26308b;
    }

    @Override // za.f
    public void b(ElementEntity r10) {
        q.g(r10, "elementEntity");
    }
}
