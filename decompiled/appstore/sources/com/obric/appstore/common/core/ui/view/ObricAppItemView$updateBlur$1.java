package com.obric.appstore.common.core.ui.view;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bytedanceos.common.toolbox.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class ObricAppItemView$updateBlur$1 extends Lambda implements Function1<Bitmap, Unit> {
    final /* synthetic */ ObricAppItemView this$0;

    public ObricAppItemView$updateBlur$1(ObricAppItemView r10) {
        this.this$0 = r10;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Bitmap r10) {
        invoke2(r10);
        return Unit.f21064a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable Bitmap r10) {
        if (r10 != null) goto L6;
        i.b("DebugFragment", "blurBitmapGlide failed");
        return;
    L6:
        BitmapDrawable r11 = new BitmapDrawable(this.this$0.getResources(), r10);
        i.a("DebugFragment", "blurBitmapWithRenderScript success");
        this.this$0.setBackground(r11);
    }
}
