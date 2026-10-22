package za;

import com.bytedanceos.common.model.AppInfo;
import com.obric.appstore.network.entity.CommonAppEntity;
import com.obric.appstore.network.entity.template.ElementAppEntity;
import com.obric.appstore.network.entity.template.ElementAppInfoEntity;
import com.obric.appstore.network.entity.template.ElementEntity;
import com.obric.appstore.network.entity.template.ElementTextEntity;
import com.obric.appstore.network.entity.template.ElementTextInfoEntity;
import com.obric.appstore.ui.adapter.ItemType;
import java.util.List;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AppInfo f26312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f26313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ItemType f26314d;

    public c() {
        this.f26313c = "";
        this.f26314d = ItemType.HOME_CARD;
    }

    @Override // za.f
    public ItemType a() {
        return this.f26314d;
    }

    @Override // za.f
    public void b(ElementEntity r10) {
        q.g(r10, "elementEntity");
        if ((r10 instanceof ElementAppEntity) == false) goto L12;
        ElementAppInfoEntity r11 = ((ElementAppEntity) r10).getElementInfo();
        if (r11 == null) goto L22;
        List<CommonAppEntity> r12 = r11.getValue();
        if (r12 != null) goto L9;
        return;
    L9:
        if (r12.isEmpty() == true) goto L24;
        this.f26312b = r12.get(0).convertAppInfo();
        return;
    L24:
        return;
    L22:
        return;
    L12:
        if ((r10 instanceof ElementTextEntity) == true) goto L14;
        return;
    L14:
        if (q.b(r10.getElementKey(), ElementTextEntity.Key.PICTURE) == false) goto L27;
        ElementTextInfoEntity r13 = ((ElementTextEntity) r10).getElementInfo();
        if (r13 == null) goto L19;
        String r14 = r13.getValue();
        if (r14 == null) goto L19;
    L20:
        this.f26313c = r14;
        return;
    L19:
        r14 = "";
        goto L20
    }

    public final AppInfo d() {
        return this.f26312b;
    }

    public final String e() {
        return this.f26313c;
    }
}
