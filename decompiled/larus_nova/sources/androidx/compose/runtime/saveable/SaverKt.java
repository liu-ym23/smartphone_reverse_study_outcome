package androidx.compose.runtime.saveable;

import androidx.exifinterface.media.ExifInterface;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aw\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u00042.\u0010\u0005\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0006¢\u0006\u0002\b\u000b2#\u0010\f\u001a\u001f\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\r\u001a\u0018\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u00020\u00040\u0001\"\u0004\b\u0000\u0010\u000f\"\u001c\u0010\u0010\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Saver", "Landroidx/compose/runtime/saveable/Saver;", "Original", "Saveable", "", SVGRenderEngine.SAVE, "Lkotlin/Function2;", "Landroidx/compose/runtime/saveable/SaverScope;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/ExtensionFunctionType;", SVGRenderEngine.RESTORE, "Lkotlin/Function1;", "autoSaver", ExifInterface.GPS_DIRECTION_TRUE, "AutoSaver", "runtime-saveable"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SaverKt {
    private static final Saver<Object, Object> AutoSaver = null;

    private static final Object AutoSaver$lambda$0(SaverScope r100, Object r101) {
        return r101;
    }

    private static final Object AutoSaver$lambda$1(Object r100) {
        return r100;
    }

    public static /* synthetic */ Object a(SaverScope r100, Object r101) {
        return AutoSaver$lambda$0(r100, r101);
    }

    public static /* synthetic */ Object b(Object r100) {
        return AutoSaver$lambda$1(r100);
    }

    static {
        AutoSaver = Saver(new o(), new p());
    }

    public static final <T> Saver<T, Object> autoSaver() {
        Saver<T, Object> r100 = (Saver<T, Object>) AutoSaver;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.SaverKt.autoSaver, kotlin.Any>");
        return r100;
    }

    public static final <Original, Saveable> Saver<Original, Saveable> Saver(final Function2<? super SaverScope, ? super Original, ? extends Saveable> r100, final Function1<? super Saveable, ? extends Original> r101) {
        return new AnonymousClass1(r100, r101);
    }
}
