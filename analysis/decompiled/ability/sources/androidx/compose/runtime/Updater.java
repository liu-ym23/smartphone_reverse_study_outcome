package androidx.compose.runtime;

import C7.r;
import S7.n;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J4\u0010\u000e\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u001a\b\b\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tH\u0086\b¢\u0006\u0004\b\f\u0010\rJ5\u0010\u000e\u001a\u00020\n\"\u0004\b\u0001\u0010\u000f2\u0006\u0010\b\u001a\u00028\u00012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\f\u0010\u0010J4\u0010\u0012\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u001a\b\b\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tH\u0086\b¢\u0006\u0004\b\u0011\u0010\rJ5\u0010\u0012\u001a\u00020\n\"\u0004\b\u0001\u0010\u000f2\u0006\u0010\b\u001a\u00028\u00012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u0011\u0010\u0010J!\u0010\u0016\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\u0013¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0018\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\u0013¢\u0006\u0004\b\u0017\u0010\u0015J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b \u0010!R\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0004\u0010\"\u0012\u0004\b#\u0010$\u0088\u0001\u0004\u0092\u0001\u00020\u0003¨\u0006%"}, d2 = {"Landroidx/compose/runtime/Updater;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/compose/runtime/Composer;", "composer", "constructor-impl", "(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;", "", "value", "Lkotlin/Function2;", "LC7/r;", "block", "set-impl", "(Landroidx/compose/runtime/Composer;ILS7/n;)V", "set", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;LS7/n;)V", "update-impl", "update", "Lkotlin/Function1;", "init-impl", "(Landroidx/compose/runtime/Composer;LS7/k;)V", "init", "reconcile-impl", "reconcile", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/runtime/Composer;", "getComposer$annotations", "()V", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Updater<T> {
    private final Composer composer;

    private /* synthetic */ Updater(Composer composer) {
        this.composer = composer;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Updater m3473boximpl(Composer composer) {
        return new Updater(composer);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static <T> Composer m3474constructorimpl(Composer composer) {
        return composer;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3475equalsimpl(Composer composer, Object obj) {
        return (obj instanceof Updater) && kotlin.jvm.internal.k.b(composer, ((Updater) obj).getComposer());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3476equalsimpl0(Composer composer, Composer composer2) {
        return kotlin.jvm.internal.k.b(composer, composer2);
    }

    public static /* synthetic */ void getComposer$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3477hashCodeimpl(Composer composer) {
        return composer.hashCode();
    }

    /* renamed from: init-impl, reason: not valid java name */
    public static final void m3478initimpl(Composer composer, S7.k kVar) {
        if (composer.getInserting()) {
            composer.apply(r.f317a, new l(kVar, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r init_impl$lambda$4(S7.k kVar, Object obj, r rVar) {
        kVar.invoke(obj);
        return r.f317a;
    }

    /* renamed from: reconcile-impl, reason: not valid java name */
    public static final void m3479reconcileimpl(Composer composer, S7.k kVar) {
        composer.apply(r.f317a, new l(kVar, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r reconcile_impl$lambda$5(S7.k kVar, Object obj, r rVar) {
        kVar.invoke(obj);
        return r.f317a;
    }

    /* renamed from: set-impl, reason: not valid java name */
    public static final void m3480setimpl(Composer composer, int i, n nVar) {
        if (composer.getInserting() || !kotlin.jvm.internal.k.b(composer.rememberedValue(), Integer.valueOf(i))) {
            androidx.appfunctions.metadata.a.z(nVar, i, composer, i);
        }
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3482toStringimpl(Composer composer) {
        return "Updater(composer=" + composer + ')';
    }

    /* renamed from: update-impl, reason: not valid java name */
    public static final void m3483updateimpl(Composer composer, int i, n nVar) {
        boolean inserting = composer.getInserting();
        if (inserting || !kotlin.jvm.internal.k.b(composer.rememberedValue(), Integer.valueOf(i))) {
            composer.updateRememberedValue(Integer.valueOf(i));
            if (inserting) {
                return;
            }
            composer.apply(Integer.valueOf(i), nVar);
        }
    }

    public boolean equals(Object other) {
        return m3475equalsimpl(this.composer, other);
    }

    public int hashCode() {
        return m3477hashCodeimpl(this.composer);
    }

    public String toString() {
        return m3482toStringimpl(this.composer);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ Composer getComposer() {
        return this.composer;
    }

    /* renamed from: update-impl, reason: not valid java name */
    public static final <V> void m3484updateimpl(Composer composer, V v10, n nVar) {
        boolean inserting = composer.getInserting();
        if (inserting || !kotlin.jvm.internal.k.b(composer.rememberedValue(), v10)) {
            composer.updateRememberedValue(v10);
            if (inserting) {
                return;
            }
            composer.apply(v10, nVar);
        }
    }

    /* renamed from: set-impl, reason: not valid java name */
    public static final <V> void m3481setimpl(Composer composer, V v10, n nVar) {
        if (composer.getInserting() || !kotlin.jvm.internal.k.b(composer.rememberedValue(), v10)) {
            composer.updateRememberedValue(v10);
            composer.apply(v10, nVar);
        }
    }
}
