package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a*\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\tH\u0080\b¢\u0006\u0002\u0010\n\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\u0007H\u0000\u001a\u0014\u0010\r\u001a\u00020\u000e*\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"DebugChanges", "", "DefaultDensity", "Landroidx/compose/ui/unit/Density;", "withComposeStackTrace", ExifInterface.GPS_DIRECTION_TRUE, "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "block", "Lkotlin/Function0;", "(Landroidx/compose/ui/node/LayoutNode;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "requireOwner", "Landroidx/compose/ui/node/Owner;", "add", "", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LayoutNodeKt {
    private static final boolean DebugChanges = false;
    private static final Density DefaultDensity = null;

    static {
        DefaultDensity = DensityKt.Density$default(1.0f, 0.0f, 2, null);
    }

    public static final /* synthetic */ Density access$getDefaultDensity$p() {
        return DefaultDensity;
    }

    public static final Owner requireOwner(LayoutNode r100) {
        Owner r101 = r100.getOwner$ui_release();
        if (r101 == null) goto L5;
        return r101;
    L5:
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("LayoutNode should be attached to an owner");
        throw new KotlinNothingValueException();
    }

    public static final void add(LayoutNode r100, LayoutNode r101) {
        r100.insertAt$ui_release(r100.getChildren$ui_release().size(), r101);
    }

    public static final <T> T withComposeStackTrace(LayoutNode r100, Function0<? extends T> r101) {
        return r101.invoke();
    L4:
        th = move-exception;
        r100.rethrowWithComposeStackTrace(th);
        throw new KotlinNothingValueException();
    }
}
