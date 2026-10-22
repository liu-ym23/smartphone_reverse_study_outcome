package com.bytedance.android.shopping.mall.homepage.tools;

import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECListItemConfigDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f178538a = 0;

    static {
    }

    public static boolean a(HomePageDTO r100) {
        Intrinsics.checkNotNullParameter(r100, "dto");
        HomePageBffDTO r101 = r100.getBff();
        if (r101 == null) goto L5;
        ECHybridListDTO r102 = r101.getFeed();
    L7:
        if (r102 == null) goto L26;
        List<ECHybridListSectionDTO> r103 = r102.getSections();
        if (r103 != null) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == true) goto L27;
        Map<String, ECListItemConfigDTO> r105 = r102.getItemConfigs();
        if (r105 != null) goto L19;
    L22:
        boolean r106 = true;
    L23:
        if (r106 == true) goto L28;
        return true;
    L28:
        return false;
    L19:
        if (r105.isEmpty() == true) goto L22;
        r106 = false;
        goto L23
    L27:
        return false;
    L11:
        if (r103.isEmpty() == true) goto L14;
        r104 = false;
        goto L15
    L26:
        return false;
    L5:
        r102 = null;
        goto L7
    }
}
