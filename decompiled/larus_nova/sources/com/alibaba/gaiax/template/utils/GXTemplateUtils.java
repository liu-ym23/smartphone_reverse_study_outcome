package com.alibaba.gaiax.template.utils;

import com.alibaba.gaiax.template.GXSize;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import u.a;
import u.d;
import u.e;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\"\u0010\u0007\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\"\u0010\u000b\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\bJ.\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00022\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00022\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0002J.\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002J.\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¨\u0006\u0014"}, d2 = {"Lcom/alibaba/gaiax/template/utils/GXTemplateUtils;", "", "Lu/d;", "Lu/a;", "it", "targetDimension", "", "updateDimension", "Lu/e;", "src", PickerReporterConstants.KEY.TARGET, "updateSize", "Lcom/alibaba/gaiax/template/GXSize;", "heightPriority", "lowPriority", "createRectGXSizeByPriority", "createRectDimensionByPriority", "createSizeDimensionByPriority", "<init>", "()V", "GaiaX"}, k = 1, mv = {1, 7, 1})
public final class GXTemplateUtils {
    public static final GXTemplateUtils INSTANCE = null;

    static {
        INSTANCE = new GXTemplateUtils();
    }

    private GXTemplateUtils() {
    }

    public final d<a> createRectDimensionByPriority(d<a> r100, d<a> r101) {
        if (r101 == null) goto L29;
        if (r100 == null) goto L29;
        a r102 = r100.f548090a;
        if ((r102 instanceof a.d) == false) goto L7;
    L9:
        a r103 = GXTemplateUtilsKt.copy(r101.f548090a);
    L10:
        a r104 = r100.f548091b;
        if ((r104 instanceof a.d) == false) goto L13;
    L15:
        a r105 = GXTemplateUtilsKt.copy(r101.f548091b);
    L16:
        a r106 = r100.f548092c;
        if ((r106 instanceof a.d) == false) goto L19;
    L21:
        a r107 = GXTemplateUtilsKt.copy(r101.f548092c);
    L22:
        a r108 = r100.f548093d;
        if ((r108 instanceof a.d) == false) goto L25;
    L27:
        a r109 = GXTemplateUtilsKt.copy(r101.f548093d);
    L37:
        return new d(r103, r105, r107, r109);
    L25:
        if ((r108 instanceof a.C7810a) == true) goto L27;
        r109 = GXTemplateUtilsKt.copy(r108);
        goto L37
    L19:
        if ((r106 instanceof a.C7810a) == true) goto L21;
        r107 = GXTemplateUtilsKt.copy(r106);
        goto L22
    L13:
        if ((r104 instanceof a.C7810a) == true) goto L15;
        r105 = GXTemplateUtilsKt.copy(r104);
        goto L16
    L7:
        if ((r102 instanceof a.C7810a) == true) goto L9;
        r103 = GXTemplateUtilsKt.copy(r102);
    L29:
        if (r100 != null) goto L32;
        if (r101 == null) goto L32;
        return new d(GXTemplateUtilsKt.copy(r101.f548090a), GXTemplateUtilsKt.copy(r101.f548091b), GXTemplateUtilsKt.copy(r101.f548092c), GXTemplateUtilsKt.copy(r101.f548093d));
    L32:
        if (r101 != null) goto L35;
        if (r100 == null) goto L35;
        return new d(GXTemplateUtilsKt.copy(r100.f548090a), GXTemplateUtilsKt.copy(r100.f548091b), GXTemplateUtilsKt.copy(r100.f548092c), GXTemplateUtilsKt.copy(r100.f548093d));
    L35:
        return null;
    }

    public final d<GXSize> createRectGXSizeByPriority(d<GXSize> r100, d<GXSize> r101) {
        if (r101 == null) goto L29;
        if (r100 == null) goto L29;
        GXSize r102 = r100.f548090a;
        if ((r102 instanceof GXSize.Undefined) == false) goto L7;
    L9:
        GXSize r103 = GXTemplateUtilsKt.copy(r101.f548090a);
    L10:
        GXSize r104 = r100.f548091b;
        if ((r104 instanceof GXSize.Undefined) == false) goto L13;
    L15:
        GXSize r105 = GXTemplateUtilsKt.copy(r101.f548091b);
    L16:
        GXSize r106 = r100.f548092c;
        if ((r106 instanceof GXSize.Undefined) == false) goto L19;
    L21:
        GXSize r107 = GXTemplateUtilsKt.copy(r101.f548092c);
    L22:
        GXSize r108 = r100.f548093d;
        if ((r108 instanceof GXSize.Undefined) == false) goto L25;
    L27:
        GXSize r109 = GXTemplateUtilsKt.copy(r101.f548093d);
    L37:
        return new d(r103, r105, r107, r109);
    L25:
        if ((r108 instanceof GXSize.Auto) == true) goto L27;
        r109 = GXTemplateUtilsKt.copy(r108);
        goto L37
    L19:
        if ((r106 instanceof GXSize.Auto) == true) goto L21;
        r107 = GXTemplateUtilsKt.copy(r106);
        goto L22
    L13:
        if ((r104 instanceof GXSize.Auto) == true) goto L15;
        r105 = GXTemplateUtilsKt.copy(r104);
        goto L16
    L7:
        if ((r102 instanceof GXSize.Auto) == true) goto L9;
        r103 = GXTemplateUtilsKt.copy(r102);
    L29:
        if (r100 != null) goto L32;
        if (r101 == null) goto L32;
        return new d(GXTemplateUtilsKt.copy(r101.f548090a), GXTemplateUtilsKt.copy(r101.f548091b), GXTemplateUtilsKt.copy(r101.f548092c), GXTemplateUtilsKt.copy(r101.f548093d));
    L32:
        if (r101 != null) goto L35;
        if (r100 == null) goto L35;
        return new d(GXTemplateUtilsKt.copy(r100.f548090a), GXTemplateUtilsKt.copy(r100.f548091b), GXTemplateUtilsKt.copy(r100.f548092c), GXTemplateUtilsKt.copy(r100.f548093d));
    L35:
        return null;
    }

    public final e<a> createSizeDimensionByPriority(e<a> r100, e<a> r101) {
        if (r101 == null) goto L17;
        if (r100 == null) goto L17;
        a r102 = r100.f548094a;
        if ((r102 instanceof a.d) == false) goto L7;
    L9:
        a r103 = GXTemplateUtilsKt.copy(r101.f548094a);
    L10:
        a r104 = r100.f548095b;
        if ((r104 instanceof a.d) == false) goto L13;
    L15:
        a r105 = GXTemplateUtilsKt.copy(r101.f548095b);
    L25:
        return new e(r103, r105);
    L13:
        if ((r104 instanceof a.C7810a) == true) goto L15;
        r105 = GXTemplateUtilsKt.copy(r104);
        goto L25
    L7:
        if ((r102 instanceof a.C7810a) == true) goto L9;
        r103 = GXTemplateUtilsKt.copy(r102);
    L17:
        if (r100 != null) goto L20;
        if (r101 == null) goto L20;
        return new e(GXTemplateUtilsKt.copy(r101.f548094a), GXTemplateUtilsKt.copy(r101.f548095b));
    L20:
        if (r101 != null) goto L23;
        if (r100 == null) goto L23;
        return new e(GXTemplateUtilsKt.copy(r100.f548094a), GXTemplateUtilsKt.copy(r100.f548095b));
    L23:
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T] */
    /* JADX WARN: Type inference failed for: r0v3, types: [T] */
    /* JADX WARN: Type inference failed for: r0v4, types: [T] */
    /* JADX WARN: Type inference failed for: r3v1, types: [T] */
    public final void updateDimension(d<a> r100, d<a> r101) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Intrinsics.checkNotNullParameter(r101, "targetDimension");
        ?? r102 = r100.f548090a;
        if ((r102 instanceof a.d) == true) goto L5;
        r101.f548090a = r102;
    L5:
        ?? r103 = r100.f548091b;
        if ((r103 instanceof a.d) == true) goto L8;
        r101.f548091b = r103;
    L8:
        ?? r104 = r100.f548092c;
        if ((r104 instanceof a.d) == true) goto L11;
        r101.f548092c = r104;
    L11:
        ?? r105 = r100.f548093d;
        if ((r105 instanceof a.d) == true) goto L15;
        r101.f548093d = r105;
        return;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T] */
    /* JADX WARN: Type inference failed for: r3v1, types: [T] */
    public final void updateSize(e<a> r100, e<a> r101) {
        Intrinsics.checkNotNullParameter(r100, "src");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        ?? r102 = r100.f548094a;
        if ((r102 instanceof a.d) == true) goto L5;
        r101.f548094a = r102;
    L5:
        ?? r103 = r100.f548095b;
        if ((r103 instanceof a.d) == true) goto L9;
        r101.f548095b = r103;
        return;
    }
}
