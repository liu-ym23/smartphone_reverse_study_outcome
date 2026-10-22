package com.alibaba.gaiax.template;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/alibaba/gaiax/template/GXLinearColorGradient;", "Landroid/graphics/LinearGradient;", "x0", "", "y0", "x1", "y1", "colors", "", "positions", "", "tile", "Landroid/graphics/Shader$TileMode;", "(FFFF[I[FLandroid/graphics/Shader$TileMode;)V", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXLinearColorGradient extends LinearGradient {
    public GXLinearColorGradient(float r100, float r101, float r102, float r103, int[] r104, float[] r105, Shader.TileMode r106) {
        Intrinsics.checkNotNullParameter(r104, "colors");
        Intrinsics.checkNotNullParameter(r106, "tile");
        super(r100, r101, r102, r103, r104, r105, r106);
    }
}
