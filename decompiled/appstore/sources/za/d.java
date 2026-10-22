package za;

import com.obric.appstore.network.entity.CommonAppEntity;
import com.obric.appstore.network.entity.template.ElementAppEntity;
import com.obric.appstore.network.entity.template.ElementAppInfoEntity;
import com.obric.appstore.network.entity.template.ElementEntity;
import com.obric.appstore.network.entity.template.ElementTextEntity;
import com.obric.appstore.network.entity.template.ElementTextInfoEntity;
import com.obric.appstore.ui.adapter.ItemType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f26315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f26316c;

    public d() {
        this.f26315b = "";
        this.f26316c = t.i();
    }

    @Override // za.f
    public ItemType a() {
        return ItemType.HOR_PAGER_HORIZONTAL_APP;
    }

    @Override // za.f
    public void b(ElementEntity r10) {
        q.g(r10, "elementEntity");
        this.f26316c = t.i();
        if ((r10 instanceof ElementTextEntity) == false) goto L13;
        if (q.b(r10.getElementKey(), "title") == false) goto L25;
        ElementTextInfoEntity r11 = ((ElementTextEntity) r10).getElementInfo();
        if (r11 == null) goto L10;
        String r12 = r11.getValue();
        if (r12 == null) goto L10;
    L11:
        this.f26315b = r12;
        return;
    L10:
        r12 = "";
        goto L11
    L25:
        return;
    L13:
        if ((r10 instanceof ElementAppEntity) == false) goto L27;
        ElementAppInfoEntity r13 = ((ElementAppEntity) r10).getElementInfo();
        if (r13 == null) goto L28;
        List<CommonAppEntity> r14 = r13.getValue();
        if (r14 == null) goto L29;
        ArrayList r15 = new ArrayList(u.r(r14, 10));
        Iterator<T> r16 = r14.iterator();
    L20:
        if (r16.hasNext() == false) goto L22;
        r15.add(((CommonAppEntity) r16.next()).convertAppInfo());
        goto L20
    L22:
        this.f26316c = r15;
        return;
    L29:
        return;
    L28:
        return;
    }

    public final List d() {
        return this.f26316c;
    }

    public final String e() {
        return this.f26315b;
    }
}
