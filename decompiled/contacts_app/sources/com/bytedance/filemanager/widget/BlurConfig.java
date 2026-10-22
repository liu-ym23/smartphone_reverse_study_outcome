package com.bytedance.filemanager.widget;

import com.obric.common.oea.foundation.blur.BlurUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TopBlurView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bR \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/filemanager/widget/BlurConfig;", "", "blurRadius", "", "blurType", "Lcom/obric/common/oea/foundation/blur/BlurUtils$BlurType;", "colors", "", "blendModes", "", "Lcom/obric/common/oea/foundation/blur/BlurUtils$BLEND_MODE;", "(FLcom/obric/common/oea/foundation/blur/BlurUtils$BlurType;[ILjava/util/List;)V", "getBlendModes", "()Ljava/util/List;", "setBlendModes", "(Ljava/util/List;)V", "getBlurRadius", "()F", "setBlurRadius", "(F)V", "getBlurType", "()Lcom/obric/common/oea/foundation/blur/BlurUtils$BlurType;", "setBlurType", "(Lcom/obric/common/oea/foundation/blur/BlurUtils$BlurType;)V", "getColors", "()[I", "setColors", "([I)V", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BlurConfig {
    private List<? extends BlurUtils.BLEND_MODE> blendModes;
    private float blurRadius;
    private BlurUtils.BlurType blurType;
    private int[] colors;

    public BlurConfig(float r2, BlurUtils.BlurType r3, int[] r4, List<? extends BlurUtils.BLEND_MODE> r5) {
        Intrinsics.checkNotNullParameter(r3, "blurType");
        Intrinsics.checkNotNullParameter(r4, "colors");
        Intrinsics.checkNotNullParameter(r5, "blendModes");
        this.blurRadius = r2;
        this.blurType = r3;
        this.colors = r4;
        this.blendModes = r5;
    }

    public final float getBlurRadius() {
        return this.blurRadius;
    }

    public final void setBlurRadius(float r1) {
        this.blurRadius = r1;
    }

    public /* synthetic */ BlurConfig(float r1, BlurUtils.BlurType r2, int[] r3, List r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = 0.0f;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r2 = BlurUtils.BlurType.NONE;
    L8:
        this(r1, r2, r3, r4);
    }

    public final BlurUtils.BlurType getBlurType() {
        return this.blurType;
    }

    public final void setBlurType(BlurUtils.BlurType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.blurType = r2;
    }

    public final int[] getColors() {
        return this.colors;
    }

    public final void setColors(int[] r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.colors = r2;
    }

    public final List<BlurUtils.BLEND_MODE> getBlendModes() {
        return this.blendModes;
    }

    public final void setBlendModes(List<? extends BlurUtils.BLEND_MODE> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.blendModes = r2;
    }
}
