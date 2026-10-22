package androidx.compose.runtime;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\t\u001a\u00020\n2\u001d\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\u000eH\u0086\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\b\u0088\u0001\u0003\u0092\u0001\u00020\u0004¨\u0006\u0018"}, d2 = {"Landroidx/compose/runtime/SkippableUpdater;", ExifInterface.GPS_DIRECTION_TRUE, "", ComposerHelper.CONFIG_TYPE_COMPOSER, "Landroidx/compose/runtime/Composer;", "constructor-impl", "(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;", "getComposer$annotations", "()V", "update", "", "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/Updater;", "Lkotlin/ExtensionFunctionType;", "update-impl", "(Landroidx/compose/runtime/Composer;Lkotlin/jvm/functions/Function1;)V", "equals", "", "other", "hashCode", "", "toString", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class SkippableUpdater<T> {
    private final Composer composer;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ SkippableUpdater m4139boximpl(Composer r100) {
        return new SkippableUpdater(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static <T> Composer m4140constructorimpl(Composer r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4141equalsimpl(Composer r100, Object r101) {
        if ((r101 instanceof SkippableUpdater) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r100, ((SkippableUpdater) r101).m4146unboximpl()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4142equalsimpl0(Composer r100, Composer r101) {
        return Intrinsics.areEqual(r100, r101);
    }

    public static /* synthetic */ void getComposer$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4143hashCodeimpl(Composer r100) {
        return r100.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4144toStringimpl(Composer r100) {
        return "SkippableUpdater(composer=" + r100 + ')';
    }

    public boolean equals(Object r100) {
        return m4141equalsimpl(this.composer, r100);
    }

    public int hashCode() {
        return m4143hashCodeimpl(this.composer);
    }

    public String toString() {
        return m4144toStringimpl(this.composer);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Composer m4146unboximpl() {
        return this.composer;
    }

    private /* synthetic */ SkippableUpdater(Composer r100) {
        this.composer = r100;
    }

    /* JADX INFO: renamed from: update-impl, reason: not valid java name */
    public static final void m4145updateimpl(Composer r100, Function1<? super Updater<T>, Unit> r101) {
        r100.startReplaceableGroup(509942095);
        r101.invoke(Updater.m4165boximpl(Updater.m4166constructorimpl(r100)));
        r100.endReplaceableGroup();
    }
}
