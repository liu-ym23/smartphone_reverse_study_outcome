package com.alibaba.gaiax.template;

import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import com.alibaba.gaiax.render.view.drawable.GXLinearColorGradientDrawable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/alibaba/gaiax/template/GXLinearColor;", "", "direction", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "colors", "", "Lcom/alibaba/gaiax/template/GXColor;", "(Landroid/graphics/drawable/GradientDrawable$Orientation;Ljava/util/List;)V", "getColors", "()Ljava/util/List;", "getDirection", "()Landroid/graphics/drawable/GradientDrawable$Orientation;", "createDrawable", "Landroid/graphics/drawable/GradientDrawable;", "createShader", "Landroid/graphics/Shader;", "view", "Landroid/widget/TextView;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXLinearColor {
    private final List<GXColor> colors;
    private final GradientDrawable.Orientation direction;

    public final GradientDrawable createDrawable() {
        int r100 = 0;
        if (this.colors.size() != 1) goto L5;
        int r101 = GXColor.value$default((GXColor) ListProtector.get(this.colors, 0), null, 1, null);
        return new GXLinearColorGradientDrawable(this.direction, new int[]{r101, r101});
    L5:
        int[] r102 = new int[this.colors.size()];
        Iterator<T> r103 = this.colors.iterator();
    L7:
        if (r103.hasNext() == false) goto L13;
        Object r104 = r103.next();
        int r105 = r100 + 1;
        if (r100 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        r102[r100] = GXColor.value$default((GXColor) r104, null, 1, null);
        r100 = r105;
        goto L7
    L13:
        return new GXLinearColorGradientDrawable(this.direction, r102);
    }

    public final List<GXColor> getColors() {
        return this.colors;
    }

    public final GradientDrawable.Orientation getDirection() {
        return this.direction;
    }

    public final Shader createShader(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        float r101 = r100.getLayoutParams().height;
        float r102 = r100.getLayoutParams().width;
        int r103 = 0;
        if (this.colors.size() != 1) goto L5;
        int r104 = ((GXColor) ListProtector.get(this.colors, 0)).value(r100.getContext());
        return GXStyleConvert.Companion.getInstance().createLinearGradient(r102, r101, this.direction, new int[]{r104, r104});
    L5:
        int[] r105 = new int[this.colors.size()];
        Iterator<T> r106 = this.colors.iterator();
    L7:
        if (r106.hasNext() == false) goto L13;
        Object r107 = r106.next();
        int r108 = r103 + 1;
        if (r103 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        r105[r103] = ((GXColor) r107).value(r100.getContext());
        r103 = r108;
        goto L7
    L13:
        return GXStyleConvert.Companion.getInstance().createLinearGradient(r102, r101, this.direction, r105);
    }

    public GXLinearColor(GradientDrawable.Orientation r100, List<GXColor> r101) {
        Intrinsics.checkNotNullParameter(r100, "direction");
        Intrinsics.checkNotNullParameter(r101, "colors");
        this.direction = r100;
        this.colors = r101;
    }
}
