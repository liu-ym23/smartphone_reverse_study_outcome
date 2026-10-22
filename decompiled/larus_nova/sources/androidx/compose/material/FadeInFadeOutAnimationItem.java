package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BF\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u00125\u0010\u0004\u001a1\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\f¢\u0006\u0002\b\b¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0015\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0010J=\u0010\u0016\u001a1\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\f¢\u0006\u0002\b\bHÆ\u0003¢\u0006\u0002\u0010\u0013JW\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u000027\b\u0002\u0010\u0004\u001a1\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\f¢\u0006\u0002\b\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010RB\u0010\u0004\u001a1\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\f¢\u0006\u0002\b\b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Landroidx/compose/material/FadeInFadeOutAnimationItem;", ExifInterface.GPS_DIRECTION_TRUE, "", "key", "transition", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", "name", "content", "Landroidx/compose/material/FadeInFadeOutTransition;", "<init>", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTransition", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "component1", "component2", "copy", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Landroidx/compose/material/FadeInFadeOutAnimationItem;", "equals", "", "other", "hashCode", "", "toString", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class FadeInFadeOutAnimationItem<T> {
    private final T key;
    private final Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> transition;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FadeInFadeOutAnimationItem copy$default(FadeInFadeOutAnimationItem r100, Object r101, Function3 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.key;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.transition;
    L9:
        return r100.copy(r101, r102);
    }

    public final T component1() {
        return this.key;
    }

    public final Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> component2() {
        return this.transition;
    }

    public final FadeInFadeOutAnimationItem<T> copy(T r100, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> r101) {
        return new FadeInFadeOutAnimationItem(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FadeInFadeOutAnimationItem) == true) goto L8;
        return false;
    L8:
        FadeInFadeOutAnimationItem r101 = (FadeInFadeOutAnimationItem) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.transition, r101.transition) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        T r100 = this.key;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.transition.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "FadeInFadeOutAnimationItem(key=" + this.key + ", transition=" + this.transition + ')';
    }

    public final T getKey() {
        return this.key;
    }

    public final Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> getTransition() {
        return this.transition;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FadeInFadeOutAnimationItem(T r100, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> r101) {
        this.key = r100;
        this.transition = r101;
    }
}
