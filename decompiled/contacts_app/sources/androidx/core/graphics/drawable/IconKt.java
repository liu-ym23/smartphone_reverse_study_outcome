package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Icon.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0004H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0005H\u0087\b¨\u0006\u0006"}, d2 = {"toAdaptiveIcon", "Landroid/graphics/drawable/Icon;", "Landroid/graphics/Bitmap;", "toIcon", "Landroid/net/Uri;", "", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IconKt {
    public static final Icon toAdaptiveIcon(Bitmap r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Icon r2 = Icon.createWithAdaptiveBitmap(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "createWithAdaptiveBitmap(this)");
        return r2;
    }

    public static final Icon toIcon(Bitmap r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Icon r2 = Icon.createWithBitmap(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "createWithBitmap(this)");
        return r2;
    }

    public static final Icon toIcon(Uri r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Icon r2 = Icon.createWithContentUri(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "createWithContentUri(this)");
        return r2;
    }

    public static final Icon toIcon(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Icon r3 = Icon.createWithData(r2, 0, r2.length);
        Intrinsics.checkNotNullExpressionValue(r3, "createWithData(this, 0, size)");
        return r3;
    }
}
