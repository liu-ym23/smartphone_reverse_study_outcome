package com.drakeet.multitype;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007JG\u0010\u0006\u001a\u00020\u000526\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\u0006\u0010\u000eJ\u001d\u0010\u0011\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016JY\u0010\u0015\u001a\u00020\u00052H\u0010\u0014\u001aD\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0016\u0012\u0014\u0012\u0010\b\u0001\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u00180\u00170\bH\u0016¢\u0006\u0004\b\u0015\u0010\u000eJY\u0010\u0011\u001a\u00020\u00052H\u0010\u0014\u001aD\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0016\u0012\u0014\u0012\u0010\b\u0001\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u00180\u00190\bH\u0002¢\u0006\u0004\b\u0011\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/drakeet/multitype/OneToManyEndpoint;", "T", "", "Lcom/drakeet/multitype/Linker;", "linker", "", "withLinker", "(Lcom/drakeet/multitype/Linker;)V", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "item", "(Lkotlin/jvm/functions/Function2;)V", "Lcom/drakeet/multitype/JavaClassLinker;", "javaClassLinker", "withJavaClassLinker", "(Lcom/drakeet/multitype/JavaClassLinker;)V", "Lcom/drakeet/multitype/KotlinClassLinker;", "classLinker", "withKotlinClassLinker", "(Lcom/drakeet/multitype/KotlinClassLinker;)V", "Lkotlin/reflect/KClass;", "Lcom/drakeet/multitype/c;", "Ljava/lang/Class;", "multitype"}, k = 1, mv = {1, 4, 0})
public interface OneToManyEndpoint<T> {

    /* JADX INFO: renamed from: com.drakeet.multitype.OneToManyEndpoint$withKotlinClassLinker$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u0014\u0012\u0010\b\u0001\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u00050\u0004\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"T", "", "position", "item", "Ljava/lang/Class;", "Lcom/drakeet/multitype/c;", "invoke", "(ILjava/lang/Object;)Ljava/lang/Class;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    final class AnonymousClass1 extends Lambda implements Function2<Integer, Object, Class<? extends c>> {
        final /* synthetic */ KotlinClassLinker $classLinker;

        public AnonymousClass1(KotlinClassLinker r10) {
            this.$classLinker = r10;
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Class<? extends c> mo0invoke(Integer r10, Object r11) {
            return invoke(r10.intValue(), r11);
        }

        @NotNull
        public final Class<? extends c> invoke(int r10, Object r11) {
            return xf.a.a(this.$classLinker.index(r10, r11));
        }
    }

    /* JADX INFO: renamed from: com.drakeet.multitype.OneToManyEndpoint$withKotlinClassLinker$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u0014\u0012\u0010\b\u0001\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u00050\u0004\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"T", "", "position", "item", "Ljava/lang/Class;", "Lcom/drakeet/multitype/c;", "invoke", "(ILjava/lang/Object;)Ljava/lang/Class;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    final class AnonymousClass2 extends Lambda implements Function2<Integer, Object, Class<? extends c>> {
        final /* synthetic */ Function2 $classLinker;

        public AnonymousClass2(Function2 r10) {
            this.$classLinker = r10;
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Class<? extends c> mo0invoke(Integer r10, Object r11) {
            return invoke(r10.intValue(), r11);
        }

        @NotNull
        public final Class<? extends c> invoke(int r10, Object r11) {
            return xf.a.a((KClass) this.$classLinker.mo0invoke(Integer.valueOf(r10), r11));
        }
    }

    void withJavaClassLinker(@NotNull JavaClassLinker<T> r10);

    void withKotlinClassLinker(@NotNull KotlinClassLinker<T> r10);

    void withKotlinClassLinker(@NotNull Function2<? super Integer, ? super T, ? extends KClass<? extends c>> r10);

    void withLinker(@NotNull Linker<T> r10);

    void withLinker(@NotNull Function2<? super Integer, ? super T, Integer> r10);
}
