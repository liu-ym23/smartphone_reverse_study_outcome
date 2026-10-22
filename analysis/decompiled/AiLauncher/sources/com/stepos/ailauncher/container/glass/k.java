package com.stepos.ailauncher.container.glass;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "", "topPx", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;I)V", "container_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class k {

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/container/glass/k$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "v", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends ViewOutlineProvider {
        final /* synthetic */ int $topPx;

        public a(int i10) {
            this.$topPx = i10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View v10, Outline outline) {
            p.i(v10, "v");
            p.i(outline, "outline");
            outline.setRect(0, this.$topPx, v10.getWidth(), v10.getHeight());
        }
    }

    public static final void a(View view, int i10) {
        p.i(view, "<this>");
        view.setOutlineProvider(new a(i10));
        view.setClipToOutline(true);
    }

    public static /* synthetic */ void b(View view, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 2;
        }
        a(view, i10);
    }
}
