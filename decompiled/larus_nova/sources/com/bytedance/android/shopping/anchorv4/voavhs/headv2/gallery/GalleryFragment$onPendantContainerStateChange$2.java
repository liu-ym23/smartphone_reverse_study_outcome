package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import com.bytedance.android.shopping.anchorv4.dto.ConfigModel;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.LynxElementVO;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, d2 = {"filterNeedBindData", "", "Lcom/bytedance/android/shopping/anchorv4/floatwidget/pendantContainer/LynxElementVO;", "list", "", "showDependsOn", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/ShowDependsOn;", "state", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/State;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class GalleryFragment$onPendantContainerStateChange$2 extends Lambda implements Function3<List<? extends LynxElementVO>, ShowDependsOn, State, List<LynxElementVO>> {
    public static final GalleryFragment$onPendantContainerStateChange$2 INSTANCE = null;

    static {
        INSTANCE = new GalleryFragment$onPendantContainerStateChange$2();
    }

    public GalleryFragment$onPendantContainerStateChange$2() {
        super(3);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<LynxElementVO> invoke2(List<LynxElementVO> r210, ShowDependsOn r211, State r212) {
        State r100 = r212;
        Intrinsics.checkNotNullParameter(r210, "list");
        Intrinsics.checkNotNullParameter(r211, "showDependsOn");
        Intrinsics.checkNotNullParameter(r100, "state");
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r210.iterator();
    L4:
        if (r102.hasNext() == false) goto L35;
        LynxElementVO r103 = (LynxElementVO) r102.next();
        ShowDependsOn.a r104 = ShowDependsOn.Companion;
        LynxElementVO r105 = null;
        if (r103 == null) goto L10;
        ConfigModel r106 = r103.getConfig();
        if (r106 == null) goto L10;
        String r107 = r106.getShowDependsOn();
    L11:
        r104.getClass();
        ShowDependsOn[] r108 = ShowDependsOn.values();
        int r109 = r108.length;
        int r110 = 0;
    L12:
        if (r110 >= r109) goto L17;
        ShowDependsOn r111 = r108[r110];
        if (Intrinsics.areEqual(r111.getValue(), r107) == true) goto L18;
        r110 = r110 + 1;
    L18:
        if (r111 != r211) goto L32;
        if (r103 == null) goto L30;
        Map<String, Object> r112 = r103.getQueryData();
        if (r112 == null) goto L24;
        Map r113 = MapsKt.toMutableMap(r112);
        if (r113 == null) goto L24;
    L25:
        Map r114 = r113;
        if (r100 != State.ANIM_END) goto L28;
        String r115 = "1";
    L29:
        r114.put("need_anim", r115);
        Unit r116 = Unit.INSTANCE;
        r105 = LynxElementVO.copy$default(r103, null, null, r114, null, null, null, null, null, null, null, null, null, null, 0, 0, 0, 0, r212, 131067, null);
        ArrayList r117 = r101;
    L31:
        r117.add(r105);
    L33:
        r100 = r212;
        r101 = r117;
        goto L4
    L28:
        r115 = "0";
    L24:
        r113 = new LinkedHashMap();
        goto L25
    L30:
        r117 = r101;
        goto L31
    L32:
        r117 = r101;
        goto L33
    L17:
        r111 = null;
    L10:
        r107 = null;
        goto L11
    L35:
        return r101;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ List<LynxElementVO> invoke(List<? extends LynxElementVO> r100, ShowDependsOn r101, State r102) {
        return invoke2(r100, r101, r102);
    }
}
