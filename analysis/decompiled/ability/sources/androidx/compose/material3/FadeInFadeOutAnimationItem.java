package androidx.compose.material3;

import S7.o;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B7\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012&\u0010\t\u001a\"\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\b¢\u0006\u0002\b\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ0\u0010\u000e\u001a\"\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\b¢\u0006\u0002\b\u0007HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJJ\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002(\b\u0002\u0010\t\u001a\"\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\b¢\u0006\u0002\b\u0007HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\rR7\u0010\t\u001a\"\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\b¢\u0006\u0002\b\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010\u000f¨\u0006 "}, d2 = {"Landroidx/compose/material3/FadeInFadeOutAnimationItem;", ExifInterface.GPS_DIRECTION_TRUE, "", "key", "Lkotlin/Function1;", "Lkotlin/Function0;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/material3/FadeInFadeOutTransition;", "transition", AppAgent.CONSTRUCT, "(Ljava/lang/Object;LS7/o;)V", "component1", "()Ljava/lang/Object;", "component2", "()LS7/o;", "copy", "(Ljava/lang/Object;LS7/o;)Landroidx/compose/material3/FadeInFadeOutAnimationItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getKey", "LS7/o;", "getTransition", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final /* data */ class FadeInFadeOutAnimationItem<T> {
    private final T key;
    private final o transition;

    public FadeInFadeOutAnimationItem(T t9, o oVar) {
        this.key = t9;
        this.transition = oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FadeInFadeOutAnimationItem copy$default(FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem, Object obj, o oVar, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = fadeInFadeOutAnimationItem.key;
        }
        if ((i & 2) != 0) {
            oVar = fadeInFadeOutAnimationItem.transition;
        }
        return fadeInFadeOutAnimationItem.copy(obj, oVar);
    }

    public final T component1() {
        return this.key;
    }

    /* renamed from: component2, reason: from getter */
    public final o getTransition() {
        return this.transition;
    }

    public final FadeInFadeOutAnimationItem<T> copy(T key, o transition) {
        return new FadeInFadeOutAnimationItem<>(key, transition);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FadeInFadeOutAnimationItem)) {
            return false;
        }
        FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem = (FadeInFadeOutAnimationItem) other;
        return k.b(this.key, fadeInFadeOutAnimationItem.key) && k.b(this.transition, fadeInFadeOutAnimationItem.transition);
    }

    public final T getKey() {
        return this.key;
    }

    public final o getTransition() {
        return this.transition;
    }

    public int hashCode() {
        T t9 = this.key;
        return this.transition.hashCode() + ((t9 == null ? 0 : t9.hashCode()) * 31);
    }

    public String toString() {
        return "FadeInFadeOutAnimationItem(key=" + this.key + ", transition=" + this.transition + ')';
    }
}
