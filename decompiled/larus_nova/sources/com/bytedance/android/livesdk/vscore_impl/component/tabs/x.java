package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes11.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f160015a = 0;

    static {
    }

    public static void a(TextView r110, View r111) {
        Intrinsics.checkNotNullParameter(r110, "textView");
        Intrinsics.checkNotNullParameter(r111, "borderRoot");
        Object r100 = r110.getParent();
        int r101 = r110.getLeft();
    L4:
        if ((r100 instanceof View) == false) goto L8;
        if ((!Intrinsics.areEqual(r100, r111)) == false) goto L8;
        View r102 = (View) r100;
        r101 = r101 + r102.getLeft();
        r100 = r102.getParent();
    L8:
        int r103 = r101 - r111.getScrollX();
        int r104 = r110.getWidth() + r103;
        float r105 = r111.getWidth() * 0.08f;
        int r112 = r110.getCurrentTextColor() | ((int) BodyPartID.bodyIdMax);
        if ((r111.getWidth() - r105) >= r104) goto L11;
        LinearGradient r106 = new LinearGradient((r111.getWidth() - r103) - r105, 0.0f, r111.getWidth() - r103, 0.0f, r112, 0, Shader.TileMode.CLAMP);
    L12:
        r110.getPaint().setShader(r106);
        r110.postInvalidate();
        return;
    L11:
        r106 = null;
        goto L12
    }
}
