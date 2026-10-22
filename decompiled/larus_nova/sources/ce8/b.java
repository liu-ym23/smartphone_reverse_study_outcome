package ce8;

import com.facebook.keyframes.model.KFAnimation;
import com.larus.bmhome.chat.component.fastsend.v;
import com.larus.bmhome.chat.component.fastsend.w;
import com.larus.bmhome.chat.component.fastsend.x;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes4.dex */
public final class b<T, D> implements ReadOnlyProperty<Object, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<D> f23468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<T, D, Boolean> f23469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f23470c;

    @Override // kotlin.properties.ReadOnlyProperty
    public final Boolean getValue(Object r100, KProperty r101) {
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        D r102 = this.f23468a.invoke();
        return this.f23469b.invoke((T) this.f23470c.getValue(), r102);
    }

    public b(v r100, w r101, x r102) {
        Intrinsics.checkNotNullParameter(r100, "lazyInitializer");
        Intrinsics.checkNotNullParameter(r101, "dynamicGetter");
        Intrinsics.checkNotNullParameter(r102, "combine");
        this.f23468a = r101;
        this.f23469b = r102;
        this.f23470c = LazyKt.lazy(r100);
    }
}
