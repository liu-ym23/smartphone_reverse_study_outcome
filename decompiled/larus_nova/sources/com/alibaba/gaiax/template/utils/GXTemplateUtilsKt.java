package com.alibaba.gaiax.template.utils;

import com.alibaba.gaiax.template.GXSize;
import kotlin.Metadata;
import u.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0001\u001a\u00020\u0000*\u0004\u0018\u00010\u0000H\u0000\u001a\u000e\u0010\u0001\u001a\u00020\u0002*\u0004\u0018\u00010\u0002H\u0000¨\u0006\u0003"}, d2 = {"Lu/a;", "copy", "Lcom/alibaba/gaiax/template/GXSize;", "GaiaX"}, k = 2, mv = {1, 7, 1})
public final class GXTemplateUtilsKt {
    public static final GXSize copy(GXSize r100) {
        if ((r100 instanceof GXSize.PX) == false) goto L6;
        GXSize.PX r101 = (GXSize.PX) r100;
        return new GXSize.PX(r101.getTargetName(), r101.getTargetValue());
    L6:
        if ((r100 instanceof GXSize.PT) == false) goto L9;
        GXSize.PT r102 = (GXSize.PT) r100;
        return new GXSize.PT(r102.getTargetName(), r102.getTargetValue());
    L9:
        if ((r100 instanceof GXSize.PE) == false) goto L12;
        GXSize.PE r103 = (GXSize.PE) r100;
        return new GXSize.PE(r103.getTargetName(), r103.getTargetValue());
    L12:
        if ((r100 instanceof GXSize.Auto) == false) goto L15;
        return GXSize.Auto.INSTANCE;
    L15:
        if ((r100 instanceof GXSize.Undefined) == false) goto L18;
        return GXSize.Undefined.INSTANCE;
    L18:
        return GXSize.Undefined.INSTANCE;
    }

    public static final a copy(a r100) {
        if ((r100 instanceof a.c) == false) goto L6;
        return new a.c(((a.c) r100).f548080a);
    L6:
        if ((r100 instanceof a.b) == false) goto L9;
        return new a.b(((a.b) r100).f548079a);
    L9:
        if ((r100 instanceof a.d) == false) goto L12;
        return a.d.f548081a;
    L12:
        if ((r100 instanceof a.C7810a) == false) goto L15;
        return a.C7810a.f548078a;
    L15:
        return a.d.f548081a;
    }
}
