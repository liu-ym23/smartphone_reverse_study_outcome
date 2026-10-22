package com.bytedanceos.appstore.buss.utilities;

import com.bytedanceos.appstore.buss.entity.AllRecommendWrap;
import com.bytedanceos.appstore.buss.entity.AppEntityWrap;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.NewRecommendWrap;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k {
    public static final NewRecommendWrap a(List r24) {
        kotlin.jvm.internal.q.g(r24, ServerElements.LIST);
        NewRecommendWrap r10 = new NewRecommendWrap(null, null, null, null, 15, null);
        ArrayList r11 = new ArrayList();
        ArrayList r12 = new ArrayList();
        ArrayList r13 = new ArrayList();
        Iterator r14 = r24.iterator();
    L4:
        if (r14.hasNext() == false) goto L21;
        AllRecommendWrap r15 = (AllRecommendWrap) r14.next();
        if (r15.getLocation() == (-1)) goto L7;
        if (r15.getType() != 10003) goto L14;
        if (r15.getShow_count() < 9) goto L14;
        String r16 = String.valueOf(r15.getType());
        List<CommonAppEntity> r17 = r15.getItems();
        int r18 = r15.getLocation();
        r11.add(new AppEntityWrap(null, null, r16, null, r17, null, null, null, null, r15.getShow_count(), r18, null, null, 6635, null));
    L14:
        if (r15.getType() != 10003) goto L19;
        if (r15.getShow_count() >= 9) goto L19;
        String r19 = String.valueOf(r15.getType());
        List<CommonAppEntity> r110 = r15.getItems();
        int r111 = r15.getLocation();
        r12.add(new AppEntityWrap(null, null, r19, null, r110, null, null, null, null, r15.getShow_count(), r111, null, null, 6635, null));
    L19:
        if (r15.getType() != 10002) goto L4;
        r13.add(new AppEntityWrap(null, null, String.valueOf(r15.getType()), null, r15.getItems(), null, null, null, null, 0, r15.getLocation(), null, null, 7147, null));
        goto L4
    L7:
        r10.setTopics(new AppEntityWrap(null, null, String.valueOf(r15.getType()), null, r15.getItems(), null, null, null, null, 0, r15.getLocation(), null, null, 7147, null));
        goto L4
    L21:
        r10.setHorizontals(r11);
        r10.setVerticals(r12);
        r10.setBanners(r13);
        return r10;
    }
}
