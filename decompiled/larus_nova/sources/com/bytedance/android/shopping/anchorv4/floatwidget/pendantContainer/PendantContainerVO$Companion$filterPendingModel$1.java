package com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.shopping.anchorv4.dto.ConfigModel;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"predicate", "", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/android/shopping/anchorv4/floatwidget/pendantContainer/LynxElementVO;", "filterList", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class PendantContainerVO$Companion$filterPendingModel$1 extends Lambda implements Function2<LynxElementVO, List<LynxElementVO>, Boolean> {
    public static final PendantContainerVO$Companion$filterPendingModel$1 INSTANCE = null;

    static {
        INSTANCE = new PendantContainerVO$Companion$filterPendingModel$1();
    }

    public PendantContainerVO$Companion$filterPendingModel$1() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(LynxElementVO r100, List<LynxElementVO> r101) {
        Intrinsics.checkNotNullParameter(r101, "filterList");
        if (r100 == null) goto L15;
        ConfigModel r102 = r100.getConfig();
        if (r102 == null) goto L15;
        String r103 = r102.getAnchorContainer();
        if (r103 == null) goto L15;
        if (r103.length() <= 0) goto L11;
        boolean r104 = true;
    L12:
        if (r104 != true) goto L15;
        r101.add(r100);
        return false;
    L11:
        r104 = false;
    L15:
        return true;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(LynxElementVO r100, List<LynxElementVO> r101) {
        return Boolean.valueOf(invoke2(r100, r101));
    }
}
