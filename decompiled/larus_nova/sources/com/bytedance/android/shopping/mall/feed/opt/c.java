package com.bytedance.android.shopping.mall.feed.opt;

import android.content.Context;
import com.bytedance.android.ec.hybrid.list.entity.dto.ChipViewConfig;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListItemDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements a {
    public c() {
    }

    public static void c(HomePageDTO r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ArrayList r101 = new ArrayList();
        HomePageBffDTO r102 = r100.getBff();
        if (r102 == null) goto L24;
        ECHybridListDTO r103 = r102.getFeed();
        if (r103 == null) goto L24;
        List<ECHybridListSectionDTO> r104 = r103.getSections();
        if (r104 == null) goto L24;
        Iterator<T> r105 = r104.iterator();
    L12:
        if (r105.hasNext() == false) goto L24;
        ArrayList<ECHybridListItemDTO> r106 = ((ECHybridListSectionDTO) r105.next()).getItems();
        if (r106 == null) goto L12;
        Iterator<T> r107 = r106.iterator();
    L17:
        if (r107.hasNext() == false) goto L12;
        ECNAMallCardExtra r108 = ((ECHybridListItemDTO) r107.next()).getExtra();
        if (r108 == null) goto L17;
        ChipViewConfig r109 = r108.getChipViewConfig();
        if (r109 == null) goto L17;
        r101.add(r109);
    L24:
        if (r101.isEmpty() == true) goto L39;
        com.bytedance.android.ec.hybrid.a.d().submit(new b(r101));
        return;
    }

    @Override // com.bytedance.android.shopping.mall.feed.opt.a
    public final void a(Context r100, HomePageDTO r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        c(r101);
    }

    @Override // com.bytedance.android.shopping.mall.feed.opt.a
    public final void b(Context r100, HomePageDTO r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        c(r101);
    }
}
