package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.livesdk.vscore_api.tab.MultiTabType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class s extends s70.a<ru2.a<d90.d>, d90.d> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<MultiTabType, LayerDescriptorList> f160001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<MultiTabType, a> f160002c;

    public interface a extends s70.a.InterfaceC7579a {
        MultiTabType Ad();
    }

    public s() {
        this.f160001b = new LinkedHashMap();
        this.f160002c = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // s70.a
    public final void a(List<? extends ru2.a<d90.d>> r100) {
        Intrinsics.checkNotNullParameter(r100, "descList");
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L36;
        ru2.a r102 = (ru2.a) r101.next();
        T r103 = this.f540899a;
        if (r103 != 0) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L8:
        MultiTabType r104 = r102.x(r103);
        LinkedHashMap r105 = (LinkedHashMap) this.f160001b;
        Object r106 = r105.get(r104);
        if (r106 != null) goto L11;
        r106 = new LayerDescriptorList();
        r105.put(r104, r106);
    L11:
        LayerDescriptorList r107 = (LayerDescriptorList) r106;
        j70.h r108 = (j70.h) r102;
        T r109 = this.f540899a;
        if (r109 != 0) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L14:
        if (r109 == 0) goto L35;
        j70.f r110 = r108.C(r109);
        Iterator<j70.h<? extends h70.b>> r111 = r107.iterator();
    L17:
        if (r111.hasNext() == false) goto L28;
        j70.h<? extends h70.b> r112 = r111.next();
        j70.h<? extends h70.b> r113 = r112;
        if (r113 == null) goto L27;
        T r114 = this.f540899a;
        if (r114 != 0) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L24:
        if (Intrinsics.areEqual(r113.C(r114), r110) == false) goto L17;
    L29:
        if (r112 == null) goto L31;
        boolean r115 = true;
    L32:
        if (r115 == true) goto L4;
        r107.add(r108);
        goto L4
    L31:
        r115 = false;
        goto L32
    L27:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptor<com.bytedance.android.live.core.tetris.layer.LayerContext>");
    L28:
        r112 = null;
        goto L29
    L35:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.LayerContext");
    L36:
        Iterator r116 = ((LinkedHashMap) this.f160001b).entrySet().iterator();
    L38:
        if (r116.hasNext() == false) goto L43;
        Map.Entry r117 = (Map.Entry) r116.next();
        MultiTabType r118 = (MultiTabType) r117.getKey();
        LayerDescriptorList r119 = (LayerDescriptorList) r117.getValue();
        a r120 = (a) ((LinkedHashMap) this.f160002c).get(r118);
        if (r120 == null) goto L38;
        r120.To(r119);
        goto L38
    }
}
