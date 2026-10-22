package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g {
    public static final LayerDescriptorList b(com.bytedance.android.livesdk.widgetdescriptor.m r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getFirstScreenList");
        LayerDescriptorList r101 = new LayerDescriptorList();
        r101.addAll(r100.c());
        r101.addAll(r100.b());
        return r101;
    }

    public static final LayerDescriptorList c(com.bytedance.android.livesdk.widgetdescriptor.m r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getPreloadList");
        LayerDescriptorList r101 = new LayerDescriptorList();
        r101.addAll(r100.e());
        r101.addAll(r100.k());
        return r101;
    }

    public static final LinkedHashMap<f70.b, LayerDescriptorList> a(com.bytedance.android.livesdk.widgetdescriptor.m r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$getDescriptorMap");
        LayerDescriptorList r103 = new LayerDescriptorList();
        if (r101 == true) goto L6;
        if (r102 == true) goto L6;
        r103.addAll(r100.e());
        r103.addAll(r100.c());
    L9:
        r103.addAll(r100.g());
        r103.addAll(r100.i());
        r103.addAll(r100.j());
        r103.addAll(r100.d());
        LayerDescriptorList r104 = new LayerDescriptorList();
        if (r101 == true) goto L13;
        if (r102 == true) goto L13;
        r104.addAll(r100.k());
        r104.addAll(r100.b());
    L16:
        r104.addAll(r100.h());
        r104.addAll(r100.f());
        LinkedHashMap<f70.b, LayerDescriptorList> r105 = new LinkedHashMap();
        r105.put(mg2.e.f513710c, r103);
        r105.put(mg2.e.f513712e, r104);
        return r105;
    L13:
        if (r101 == false) goto L16;
        if (r102 == true) goto L16;
        r104.addAll(r100.b());
    L6:
        if (r101 == false) goto L9;
        if (r102 == true) goto L9;
        r103.addAll(r100.c());
        goto L9
    }
}
