package com.stepos.ailauncher.foundation.appui.card.provider.amap;

import android.graphics.PointF;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.amap.route.GeoPoint;
import com.stepos.ailauncher.amap.route.U;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/j0;", "", "<init>", "()V", "", "Lcom/stepos/ailauncher/amap/route/x;", "points", "", "widthPx", "heightPx", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/j0$a;", "padding", "Landroid/graphics/PointF;", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;IILcom/stepos/ailauncher/foundation/appui/card/provider/amap/j0$a;)Ljava/util/List;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.j0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3270j0 {
    public static final C3270j0 INSTANCE = new C3270j0();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\nB'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0010R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0017\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0018\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0019\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/j0$a;", "", "", "left", "top", "right", "bottom", "<init>", "(IIII)V", "Lcom/stepos/ailauncher/amap/route/U$b;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/amap/route/U$b;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getLeft", "getTop", "getRight", "getBottom", "Companion", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.j0$a, reason: from toString */
    public static final /* data */ class ViewportPadding {
        private final int bottom;
        private final int left;
        private final int right;
        private final int top;

        public ViewportPadding(int i10, int i11, int i12, int i13) {
            this.left = i10;
            this.top = i11;
            this.right = i12;
            this.bottom = i13;
        }

        public final U.Padding a() {
            return new U.Padding(this.left, this.top, this.right, this.bottom);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewportPadding)) {
                return false;
            }
            ViewportPadding viewportPadding = (ViewportPadding) other;
            return this.left == viewportPadding.left && this.top == viewportPadding.top && this.right == viewportPadding.right && this.bottom == viewportPadding.bottom;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.left) * 31) + Integer.hashCode(this.top)) * 31) + Integer.hashCode(this.right)) * 31) + Integer.hashCode(this.bottom);
        }

        public String toString() {
            return "ViewportPadding(left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ")";
        }
    }

    public final List<PointF> a(List<GeoPoint> points, int widthPx, int heightPx, ViewportPadding padding) {
        kotlin.jvm.internal.p.i(points, "points");
        kotlin.jvm.internal.p.i(padding, "padding");
        return com.stepos.ailauncher.amap.route.U.D(com.stepos.ailauncher.amap.route.U.INSTANCE, points, widthPx, heightPx, padding.a(), 0.0d, 16, null);
    }
}
