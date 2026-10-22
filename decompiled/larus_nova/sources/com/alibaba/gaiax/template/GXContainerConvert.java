package com.alibaba.gaiax.template;

import android.graphics.Rect;
import com.alipay.sdk.m.u.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0005¨\u0006\n"}, d2 = {"Lcom/alibaba/gaiax/template/GXContainerConvert;", "", "()V", "direction", "", "", "edgeInsets", "Landroid/graphics/Rect;", "spacing", "itemSpacing", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXContainerConvert {
    public static final GXContainerConvert INSTANCE = null;

    static {
        INSTANCE = new GXContainerConvert();
    }

    private GXContainerConvert() {
    }

    public final int direction(String r100) {
        Intrinsics.checkNotNullParameter(r100, "direction");
        if (Intrinsics.areEqual(r100, "horizontal") == false) goto L5;
        return 0;
    L5:
        Intrinsics.areEqual(r100, "vertical");
        return 1;
    }

    public final Rect edgeInsets(String r110) {
        if (r110 != null) goto L5;
    L10:
        boolean r100 = false;
    L11:
        if (r100 == false) goto L13;
        List r101 = StringsKt.split$default(StringsKt.replace$default(StringsKt.replace$default(r110, "{", "", false, 4, null), i.f25855d, "", false, 4, null), new String[]{","}, false, 0, 6, null);
        GXSize.Companion r102 = GXSize.Companion;
        int r103 = r102.create((String) ListProtector.get(r101, 0)).getValueInt();
        int r104 = r102.create((String) ListProtector.get(r101, 1)).getValueInt();
        int r105 = r102.create((String) ListProtector.get(r101, 2)).getValueInt();
        return new Rect(r104, r103, r102.create((String) ListProtector.get(r101, 3)).getValueInt(), r105);
    L13:
        return null;
    L5:
        if (r110.length() <= 0) goto L7;
        boolean r106 = true;
    L8:
        if (r106 != true) goto L10;
        r100 = true;
        goto L11
    L7:
        r106 = false;
        goto L8
    }

    public final int spacing(String r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return GXSize.Companion.create(r100).getValueInt();
    }
}
