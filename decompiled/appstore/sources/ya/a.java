package ya;

import com.bytedanceos.common.toolbox.i;
import com.bytedanceos.common.toolbox.j;
import com.obric.appstore.network.entity.CommonAppEntity;
import com.obric.appstore.network.entity.PageListResp;
import com.obric.appstore.network.entity.TemplateResp;
import com.obric.appstore.network.entity.template.ElementAppEntity;
import com.obric.appstore.network.entity.template.ElementAppInfoEntity;
import com.obric.appstore.network.entity.template.ElementEntity;
import com.obric.appstore.network.entity.template.ElementType;
import com.obric.appstore.network.entity.template.PageType;
import com.obric.appstore.network.entity.template.TemplateType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.b0;
import kotlin.collections.u;
import kotlin.jvm.internal.q;
import za.c;
import za.d;
import za.e;
import za.f;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final List a(PageListResp r10, PageType r11) {
        q.g(r10, "<this>");
        q.g(r11, "pageType");
        ArrayList r12 = new ArrayList();
        List r13 = r10.getList();
        if (r13 == null) goto L23;
        Iterator r14 = r13.iterator();
    L6:
        if (r14.hasNext() == false) goto L23;
        TemplateResp r15 = (TemplateResp) r14.next();
        i.e("DebugFragment", "template: " + r15.getTemplate());
        String r16 = r15.getTemplate();
        if (q.b(r16, TemplateType.HOME_CARD.getValue()) == false) goto L11;
        f r17 = new c();
    L20:
        if (r17 == null) goto L6;
        r17.c(r15);
        r12.add(r17);
        goto L6
    L11:
        if (q.b(r16, TemplateType.COLUMN.getValue()) == false) goto L14;
        i.e("DebugFragment", "column");
        r17 = new d();
        goto L20
    L14:
        if (q.b(r16, TemplateType.APP_LIST.getValue()) == false) goto L16;
    L19:
        r17 = null;
        goto L20
    L16:
        if (q.b(r16, TemplateType.APP_CATEGORY_LIST.getValue()) == false) goto L18;
        r17 = new e();
        goto L20
    L18:
        j.m("buildTemplateList, unknown template: " + r15.getTemplate());
    L23:
        if (r11 == PageType.HOMEPAGE) goto L25;
    L30:
        return r12;
    L25:
        if (r12.isEmpty() == false) goto L27;
    L29:
        r12.add(0, new za.a());
        goto L30
    L27:
        if ((r12.get(0) instanceof c) == false) goto L29;
        r12.add(1, new za.a());
        goto L30
    }

    public static final List b(PageListResp r10) {
        q.g(r10, "<this>");
        List r11 = r10.getList();
        ArrayList r12 = null;
        if (r11 == null) goto L32;
        TemplateResp r13 = (TemplateResp) b0.a0(r11, 0);
        if (r13 == null) goto L32;
        List<ElementEntity<?>> r14 = r13.getData();
        if (r14 == null) goto L32;
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r14.iterator();
    L10:
        if (r16.hasNext() == false) goto L14;
        Object r17 = r16.next();
        if (((ElementEntity) r17).getElementType() != ElementType.APP.getValue()) goto L10;
        r15.add(r17);
        goto L10
    L14:
        ArrayList r18 = new ArrayList(u.r(r15, 10));
        Iterator r19 = r15.iterator();
    L16:
        if (r19.hasNext() == false) goto L22;
        ElementEntity r20 = (ElementEntity) r19.next();
        if ((r20 instanceof ElementAppEntity) == false) goto L20;
        ElementAppEntity r21 = (ElementAppEntity) r20;
    L21:
        r18.add(r21);
        goto L16
    L20:
        r21 = null;
        goto L21
    L22:
        ElementAppEntity r22 = (ElementAppEntity) b0.a0(r18, 0);
        if (r22 == null) goto L32;
        ElementAppInfoEntity r23 = r22.getElementInfo();
        if (r23 == null) goto L32;
        List<CommonAppEntity> r24 = r23.getValue();
        if (r24 == null) goto L32;
        r12 = new ArrayList(u.r(r24, 10));
        Iterator<T> r25 = r24.iterator();
    L30:
        if (r25.hasNext() == false) goto L32;
        r12.add(((CommonAppEntity) r25.next()).convertAppInfo());
    L32:
        return r12;
    }
}
