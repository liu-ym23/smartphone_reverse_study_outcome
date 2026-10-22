package za;

import com.obric.appstore.network.entity.template.ElementArrayEntity;
import com.obric.appstore.network.entity.template.ElementArrayInfoEntity;
import com.obric.appstore.network.entity.template.ElementEntity;
import com.obric.appstore.network.entity.template.ElementTextEntity;
import com.obric.appstore.network.entity.template.ElementTextInfoEntity;
import com.obric.appstore.ui.adapter.ItemType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f26317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f26318c;

    public e() {
        this.f26317b = "";
        this.f26318c = new ArrayList();
    }

    @Override // za.f
    public ItemType a() {
        return ItemType.GRID_CATEGORY;
    }

    @Override // za.f
    public void b(ElementEntity r10) {
        q.g(r10, "elementEntity");
        if ((r10 instanceof ElementTextEntity) == false) goto L12;
        ElementTextInfoEntity r11 = ((ElementTextEntity) r10).getElementInfo();
        if (r11 == null) goto L8;
        String r12 = r11.getValue();
        if (r12 == null) goto L8;
    L9:
        this.f26317b = r12;
        return;
    L8:
        r12 = "";
        goto L9
    L12:
        if ((r10 instanceof ElementArrayEntity) == true) goto L14;
        return;
    L14:
        this.f26318c.clear();
        ElementArrayInfoEntity r13 = ((ElementArrayEntity) r10).getElementInfo();
        if (r13 == null) goto L55;
        List<List<ElementEntity<?>>> r14 = r13.getValue();
        if (r14 == null) goto L76;
        Iterator<T> r15 = r14.iterator();
    L20:
        if (r15.hasNext() == false) goto L77;
        List r16 = (List) r15.next();
        com.obric.appstore.network.f r17 = new com.obric.appstore.network.f(null, null, null, 7, null);
        Iterator r18 = r16.iterator();
    L23:
        if (r18.hasNext() == false) goto L54;
        ElementEntity r19 = (ElementEntity) r18.next();
        if ((r19 instanceof ElementTextEntity) == false) goto L23;
        String r20 = r19.getElementKey();
        int r21 = r20.hashCode();
        String r22 = null;
        if (r21 != (-577741570)) goto L29;
        if (r20.equals(ElementTextEntity.Key.PICTURE) == false) goto L23;
        ElementTextInfoEntity r23 = ((ElementTextEntity) r19).getElementInfo();
        if (r23 == null) goto L53;
        r22 = r23.getValue();
    L53:
        r17.e(r22);
        goto L23
    L29:
        if (r21 != 338683180) goto L31;
        if (r20.equals(ElementTextEntity.Key.CATEGORY_NAME) == false) goto L23;
        ElementTextInfoEntity r24 = ((ElementTextEntity) r19).getElementInfo();
        if (r24 == null) goto L46;
        r22 = r24.getValue();
    L46:
        r17.f(r22);
        goto L23
    L31:
        if (r21 != 1537780732) goto L23;
        if (r20.equals(ElementTextEntity.Key.CATEGORY_ID) == false) goto L23;
        ElementTextInfoEntity r25 = ((ElementTextEntity) r19).getElementInfo();
        if (r25 == null) goto L39;
        r22 = r25.getValue();
    L39:
        r17.d(r22);
        goto L23
    L54:
        this.f26318c.add(r17);
        goto L20
    L77:
        return;
    L76:
        return;
    }

    public final ArrayList d() {
        return this.f26318c;
    }

    public final String e() {
        return this.f26317b;
    }
}
