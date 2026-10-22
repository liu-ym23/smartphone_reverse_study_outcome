package com.stepos.ailauncher.sheet;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.LinkHeader;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/sheet/e;", "Lcom/stepos/ailauncher/sheet/j;", "<init>", "()V", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "Lcom/stepos/ailauncher/sheet/i;", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;)Lcom/stepos/ailauncher/sheet/i;", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.sheet.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3437e implements InterfaceC3456j {
    public static final C3437e INSTANCE = new C3437e();

    @Override // com.stepos.ailauncher.sheet.InterfaceC3456j
    public HandleBounds a(View anchor) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(anchor, "anchor");
        Resources resources = anchor.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        float f10 = displayMetrics.widthPixels;
        float f11 = displayMetrics.heightPixels;
        float dimension = resources.getDimension(R$dimen.ail_nav_handle_width);
        float dimension2 = resources.getDimension(R$dimen.ail_nav_handle_height);
        float f12 = (f10 - dimension) / 2.0f;
        float dimension3 = (f11 - resources.getDimension(R$dimen.ail_nav_handle_margin_bottom)) - (dimension2 / 2.0f);
        return new HandleBounds(f12, dimension3, dimension + f12, dimension2 + dimension3);
    }
}
