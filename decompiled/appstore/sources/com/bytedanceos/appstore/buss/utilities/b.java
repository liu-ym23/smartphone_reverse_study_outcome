package com.bytedanceos.appstore.buss.utilities;

import com.bytedanceos.appstore.buss.cms.beta.TemplateHelper;
import com.bytedanceos.appstore.buss.cms.beta.item.TemplateItem;
import com.bytedanceos.appstore.buss.cms.beta.item.template.TemplateCarouselBannerItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8835a = null;

    static {
        f8835a = new b();
    }

    public b() {
    }

    public final ArrayList a(List r10) {
        ArrayList r11 = new ArrayList();
        if (r10 != null) goto L5;
    L22:
        return r11;
    L5:
        if (r10.isEmpty() == true) goto L22;
        Iterator<T> r12 = TemplateHelper.INSTANCE.buildTemplateItemList(r10).iterator();
        int r13 = 0;
    L9:
        if (r12.hasNext() == false) goto L22;
        Object r14 = r12.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L13;
        kotlin.collections.t.q();
    L13:
        TemplateItem r16 = (TemplateItem) r14;
        if ((r16 instanceof TemplateCarouselBannerItem) == false) goto L19;
        if (r16.isAvailable() == false) goto L21;
        r11.add(r16);
    L21:
        r13 = r15;
        goto L9
    L19:
        if (r16.isAvailable() == false) goto L21;
        r11.addAll(r16.getItemList());
        goto L21
    }
}
