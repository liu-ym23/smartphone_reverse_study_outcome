package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: Picture.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2 = {"record", "Landroid/graphics/Picture;", MaterialConfigFormatNames.WIDTH, "", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "block", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PictureKt {
    public static final Picture record(Picture r1, int r2, int r3, Function1<? super Canvas, Unit> r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r4, "block");
        Canvas r5 = r1.beginRecording(r2, r3);
        Intrinsics.checkNotNullExpressionValue(r5, "beginRecording(width, height)");
        r4.invoke(r5);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r1.endRecording();
        InlineMarker.finallyEnd(1);
        return r1;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r1.endRecording();
        InlineMarker.finallyEnd(1);
        throw th;
    }
}
