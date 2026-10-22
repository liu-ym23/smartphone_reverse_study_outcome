package androidx.compose.runtime;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006JH\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2.\b\b\u0010\r\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\n0\u000e¢\u0006\u0002\b\u0011H\u0086\b¢\u0006\u0004\b\u0012\u0010\u0013JI\u0010\t\u001a\u00020\n\"\u0004\b\u0001\u0010\u00142\u0006\u0010\u000b\u001a\u0002H\u00142,\u0010\r\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u0011H\u0014¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\n0\u000e¢\u0006\u0002\b\u0011¢\u0006\u0004\b\u0012\u0010\u0015JH\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2.\b\b\u0010\r\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\n0\u000e¢\u0006\u0002\b\u0011H\u0086\b¢\u0006\u0004\b\u0017\u0010\u0013JI\u0010\u0016\u001a\u00020\n\"\u0004\b\u0001\u0010\u00142\u0006\u0010\u000b\u001a\u0002H\u00142,\u0010\r\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u0011H\u0014¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\n0\u000e¢\u0006\u0002\b\u0011¢\u0006\u0004\b\u0017\u0010\u0015J&\u0010\u0018\u001a\u00020\n2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\u0019¢\u0006\u0002\b\u0011¢\u0006\u0004\b\u001a\u0010\u001bJ&\u0010\u001c\u001a\u00020\n2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\u0019¢\u0006\u0002\b\u0011¢\u0006\u0004\b\u001d\u0010\u001bJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010!\u001a\u00020\fHÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\b\u0088\u0001\u0003\u0092\u0001\u00020\u0004¨\u0006$"}, d2 = {"Landroidx/compose/runtime/Updater;", ExifInterface.GPS_DIRECTION_TRUE, "", ComposerHelper.CONFIG_TYPE_COMPOSER, "Landroidx/compose/runtime/Composer;", "constructor-impl", "(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;", "getComposer$annotations", "()V", "set", "", "value", "", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lkotlin/ExtensionFunctionType;", "set-impl", "(Landroidx/compose/runtime/Composer;ILkotlin/jvm/functions/Function2;)V", "V", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "update", "update-impl", "init", "Lkotlin/Function1;", "init-impl", "(Landroidx/compose/runtime/Composer;Lkotlin/jvm/functions/Function1;)V", "reconcile", "reconcile-impl", "equals", "", "other", "hashCode", "toString", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class Updater<T> {
    private final Composer composer;

    public static /* synthetic */ Unit a(Function1 r100, Object r101, Unit r102) {
        return init_impl$lambda$4(r100, r101, r102);
    }

    public static /* synthetic */ Unit b(Function1 r100, Object r101, Unit r102) {
        return reconcile_impl$lambda$5(r100, r101, r102);
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Updater m4165boximpl(Composer r100) {
        return new Updater(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static <T> Composer m4166constructorimpl(Composer r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4167equalsimpl(Composer r100, Object r101) {
        if ((r101 instanceof Updater) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r100, ((Updater) r101).m4177unboximpl()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4168equalsimpl0(Composer r100, Composer r101) {
        return Intrinsics.areEqual(r100, r101);
    }

    public static /* synthetic */ void getComposer$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4169hashCodeimpl(Composer r100) {
        return r100.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4174toStringimpl(Composer r100) {
        return "Updater(composer=" + r100 + ')';
    }

    public boolean equals(Object r100) {
        return m4167equalsimpl(this.composer, r100);
    }

    public int hashCode() {
        return m4169hashCodeimpl(this.composer);
    }

    public String toString() {
        return m4174toStringimpl(this.composer);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Composer m4177unboximpl() {
        return this.composer;
    }

    private /* synthetic */ Updater(Composer r100) {
        this.composer = r100;
    }

    /* JADX INFO: renamed from: init-impl, reason: not valid java name */
    public static final void m4170initimpl(Composer r100, final Function1<? super T, Unit> r101) {
        if (r100.getInserting() == false) goto L6;
        r100.apply(Unit.INSTANCE, new i0(r101));
        return;
    }

    /* JADX INFO: renamed from: reconcile-impl, reason: not valid java name */
    public static final void m4171reconcileimpl(Composer r100, final Function1<? super T, Unit> r101) {
        r100.apply(Unit.INSTANCE, new j0(r101));
    }

    private static final Unit init_impl$lambda$4(Function1 r100, Object r101, Unit r102) {
        r100.invoke(r101);
        return Unit.INSTANCE;
    }

    private static final Unit reconcile_impl$lambda$5(Function1 r100, Object r101, Unit r102) {
        r100.invoke(r101);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: set-impl, reason: not valid java name */
    public static final void m4172setimpl(Composer r100, int r101, Function2<? super T, ? super Integer, Unit> r102) {
        if (r100.getInserting() == false) goto L5;
    L6:
        r100.updateRememberedValue(Integer.valueOf(r101));
        r100.apply(Integer.valueOf(r101), r102);
        return;
    L5:
        if (Intrinsics.areEqual(r100.rememberedValue(), Integer.valueOf(r101)) == false) goto L6;
    }

    /* JADX INFO: renamed from: update-impl, reason: not valid java name */
    public static final void m4175updateimpl(Composer r100, int r101, Function2<? super T, ? super Integer, Unit> r102) {
        boolean r103 = r100.getInserting();
        if (r103 == false) goto L5;
    L6:
        r100.updateRememberedValue(Integer.valueOf(r101));
        if (r103 == true) goto L11;
        r100.apply(Integer.valueOf(r101), r102);
        return;
    L11:
        return;
    L5:
        if (Intrinsics.areEqual(r100.rememberedValue(), Integer.valueOf(r101)) == false) goto L6;
    }

    /* JADX INFO: renamed from: set-impl, reason: not valid java name */
    public static final <V> void m4173setimpl(Composer r100, V r101, Function2<? super T, ? super V, Unit> r102) {
        if (r100.getInserting() == false) goto L5;
    L6:
        r100.updateRememberedValue(r101);
        r100.apply(r101, r102);
        return;
    L5:
        if (Intrinsics.areEqual(r100.rememberedValue(), r101) == false) goto L6;
    }

    /* JADX INFO: renamed from: update-impl, reason: not valid java name */
    public static final <V> void m4176updateimpl(Composer r100, V r101, Function2<? super T, ? super V, Unit> r102) {
        boolean r103 = r100.getInserting();
        if (r103 == false) goto L5;
    L6:
        r100.updateRememberedValue(r101);
        if (r103 == true) goto L11;
        r100.apply(r101, r102);
        return;
    L11:
        return;
    L5:
        if (Intrinsics.areEqual(r100.rememberedValue(), r101) == false) goto L6;
    }
}
