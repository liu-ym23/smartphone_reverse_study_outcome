package androidx.compose.runtime.reflect;

import androidx.compose.runtime.Composer;
import com.alipay.sdk.m.p.e;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\b\u001a\u00020\u0003J:\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u001a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000e\"\u0004\u0018\u00010\u0001H\u0086\u0002¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001f\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u000e8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Landroidx/compose/runtime/reflect/ComposableMethod;", "", e.f25671s, "Ljava/lang/reflect/Method;", "composableInfo", "Landroidx/compose/runtime/reflect/ComposableInfo;", "<init>", "(Ljava/lang/reflect/Method;Landroidx/compose/runtime/reflect/ComposableInfo;)V", "asMethod", "parameterCount", "", "getParameterCount", "()I", "parameters", "", "Ljava/lang/reflect/Parameter;", "getParameters", "()[Ljava/lang/reflect/Parameter;", "parameterTypes", "Ljava/lang/Class;", "getParameterTypes", "()[Ljava/lang/Class;", AbsMethodDelegate.TAG_INVOKE, ComposerHelper.CONFIG_TYPE_COMPOSER, "Landroidx/compose/runtime/Composer;", "instance", "args", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "equals", "", "other", "hashCode", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ComposableMethod {
    public static final int $stable = 8;
    private final ComposableInfo composableInfo;
    private final Method method;

    public final int getParameterCount() {
        return this.composableInfo.getRealParamsCount();
    }

    public final Class<?>[] getParameterTypes() {
        return (Class[]) ArraysKt.copyOfRange(this.method.getParameterTypes(), 0, this.composableInfo.getRealParamsCount());
    }

    public final Parameter[] getParameters() {
        return (Parameter[]) ArraysKt.copyOfRange(this.method.getParameters(), 0, this.composableInfo.getRealParamsCount());
    }

    public int hashCode() {
        return this.method.hashCode();
    }

    public final Method asMethod() {
        return this.method;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof ComposableMethod) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(this.method, ((ComposableMethod) r100).method);
    }

    public ComposableMethod(Method r100, ComposableInfo r101) {
        this.method = r100;
        this.composableInfo = r101;
    }

    public final Object invoke(Composer r110, Object r111, Object... r112) {
        ComposableInfo r100 = this.composableInfo;
        int r101 = r100.component2();
        int r102 = r100.component3();
        int r103 = r100.component4();
        int r104 = this.method.getParameterTypes().length;
        int r105 = r101 + 1;
        int r106 = r102 + r105;
        Object[] r107 = new Integer[r103];
        int r113 = 0;
    L4:
        if (r113 >= r103) goto L24;
        int r114 = r113 * 31;
        IntRange r115 = RangesKt.until(r114, Math.min(r114 + 31, r101));
        ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r115, 10));
        Iterator<Integer> r117 = r115.iterator();
    L7:
        if (r117.hasNext() == false) goto L16;
        int r118 = ((IntIterator) r117).nextInt();
        if (r118 < r112.length) goto L11;
    L14:
        int r119 = 1;
    L15:
        r116.add(Integer.valueOf(r119));
        goto L7
    L11:
        if (r112[r118] == null) goto L14;
        r119 = 0;
        goto L15
    L16:
        Iterator r120 = r116.iterator();
        int r121 = 0;
        int r122 = 0;
    L18:
        if (r120.hasNext() == false) goto L23;
        Object r123 = r120.next();
        int r124 = r122 + 1;
        if (r122 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        r121 = r121 | (((Number) r123).intValue() << r122);
        r122 = r124;
        goto L18
    L23:
        r107[r113] = Integer.valueOf(r121);
        r113 = r113 + 1;
        goto L4
    L24:
        Object[] r108 = new Object[r104];
        int r125 = 0;
    L25:
        if (r125 >= r104) goto L60;
        if (r125 < 0) goto L29;
        if (r125 >= r101) goto L29;
        boolean r126 = true;
    L30:
        if (r126 == false) goto L39;
        if (r125 >= 0) goto L33;
    L35:
        boolean r127 = false;
    L36:
        if (r127 == false) goto L38;
        Object r128 = r112[r125];
    L56:
        r108[r125] = r128;
        r125 = r125 + 1;
        goto L25
    L38:
        r128 = ComposableMethodKt.access$getDefaultValue(this.method.getParameterTypes()[r125]);
        goto L56
    L33:
        if (r125 >= r112.length) goto L35;
        r127 = true;
        goto L36
    L39:
        if (r125 != r101) goto L41;
        r128 = r110;
        goto L56
    L41:
        if (r125 != r105) goto L44;
    L42:
        r128 = 0;
        goto L56
    L44:
        if ((r105 + 1) > r125) goto L47;
        if (r125 >= r106) goto L47;
        boolean r129 = true;
    L48:
        if (r129 == true) goto L42;
        if (r106 > r125) goto L53;
        if (r125 >= r104) goto L53;
        boolean r130 = true;
    L54:
        if (r130 == false) goto L58;
        r128 = r107[r125 - r106];
        goto L56
    L58:
        throw new IllegalStateException("Unexpected index".toString());
    L53:
        r130 = false;
    L47:
        r129 = false;
    L29:
        r126 = false;
        goto L30
    L60:
        return this.method.invoke(r111, Arrays.copyOf(r108, r104));
    }
}
