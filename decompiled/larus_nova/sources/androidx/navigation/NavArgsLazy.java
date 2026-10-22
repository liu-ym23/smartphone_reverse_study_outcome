package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavArgs;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B!\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Landroidx/navigation/NavArgsLazy;", "Args", "Landroidx/navigation/NavArgs;", "Lkotlin/Lazy;", "navArgsClass", "Lkotlin/reflect/KClass;", "argumentProducer", "Lkotlin/Function0;", "Landroid/os/Bundle;", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)V", "cached", "Landroidx/navigation/NavArgs;", "value", "getValue", "()Landroidx/navigation/NavArgs;", "isInitialized", "", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavArgsLazy<Args extends NavArgs> implements Lazy<Args> {
    private final Function0<Bundle> argumentProducer;
    private Args cached;
    private final KClass<Args> navArgsClass;

    @Override // kotlin.Lazy
    public Args getValue() {
        Args r100 = this.cached;
        if (r100 != null) goto L12;
        Bundle r101 = this.argumentProducer.invoke();
        Method r102 = NavArgsLazyKt.getMethodMap().get(this.navArgsClass);
        if (r102 != null) goto L7;
        Class r103 = JvmClassMappingKt.getJavaClass(this.navArgsClass);
        Class<Bundle>[] r104 = NavArgsLazyKt.getMethodSignature();
        r102 = r103.getMethod("fromBundle", (Class[]) Arrays.copyOf(r104, r104.length));
        NavArgsLazyKt.getMethodMap().put(this.navArgsClass, r102);
    L7:
        Object r105 = r102.invoke(null, new Object[]{r101});
        if (r105 == null) goto L11;
        Args r106 = (Args) r105;
        this.cached = r106;
        return r106;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type Args of androidx.navigation.NavArgsLazy");
    L12:
        return r100;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        if (this.cached == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.Lazy
    public /* bridge */ /* synthetic */ Object getValue() {
        return getValue();
    }

    public NavArgsLazy(KClass<Args> r100, Function0<Bundle> r101) {
        Intrinsics.checkNotNullParameter(r100, "navArgsClass");
        Intrinsics.checkNotNullParameter(r101, "argumentProducer");
        this.navArgsClass = r100;
        this.argumentProducer = r101;
    }
}
