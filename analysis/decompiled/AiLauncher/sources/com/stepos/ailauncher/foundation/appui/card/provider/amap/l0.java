package com.stepos.ailauncher.foundation.appui.card.provider.amap;

import android.content.Context;
import android.content.res.Resources;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.R$dimen;
import com.stepos.ailauncher.foundation.appui.card.provider.amap.C3270j0;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/l0;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)I", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/j0$a;", "c", "(Landroid/content/Context;)Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/j0$a;", "", "BOUNDS_PADDING_DP", "F", "MARKER_HALF_WIDTH_DP", "MARKER_HEIGHT_DP", "MARKER_SELECTED_TIP_DP", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class l0 {
    public static final float BOUNDS_PADDING_DP = 24.0f;
    public static final l0 INSTANCE = new l0();
    private static final float MARKER_HALF_WIDTH_DP = 22.0f;
    private static final float MARKER_HEIGHT_DP = 20.0f;
    private static final float MARKER_SELECTED_TIP_DP = 3.0f;

    public final int a(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        Resources resources = context.getResources();
        return C5685n.f((int) (resources.getDimension(R$dimen.card_map_poi_card_strip_height) + resources.getDimension(R$dimen.card_map_poi_card_strip_margin_bottom) + resources.getDimension(R$dimen.card_map_poi_overview_bottom_gap) + (context.getResources().getDisplayMetrics().density * 23.0f)), 0);
    }

    public final int b(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return (int) (context.getResources().getDisplayMetrics().density * 24.0f);
    }

    public final C3270j0.ViewportPadding c(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        float f10 = context.getResources().getDisplayMetrics().density;
        int iB = b(context);
        int i10 = (int) (f10 * 22.0f);
        return new C3270j0.ViewportPadding(Math.max(iB, i10), Math.max(iB, i10), Math.max(iB, i10), Math.max(iB + a(context), i10));
    }
}
