package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: compiled from: ScopesHolderForClass.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ScopesHolderForClass<T extends MemberScope> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    public static final Companion Companion = null;
    private final ClassDescriptor classDescriptor;
    private final KotlinTypeRefiner kotlinTypeRefinerForOwnerModule;
    private final Function1<KotlinTypeRefiner, T> scopeFactory;
    private final NotNullLazyValue scopeForOwnerModule$delegate;

    /* JADX INFO: compiled from: ScopesHolderForClass.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final <T extends MemberScope> ScopesHolderForClass<T> create(ClassDescriptor r7, StorageManager r8, KotlinTypeRefiner r9, Function1<? super KotlinTypeRefiner, ? extends T> r10) {
            Intrinsics.checkNotNullParameter(r7, "classDescriptor");
            Intrinsics.checkNotNullParameter(r8, "storageManager");
            Intrinsics.checkNotNullParameter(r9, "kotlinTypeRefinerForOwnerModule");
            Intrinsics.checkNotNullParameter(r10, "scopeFactory");
            return new ScopesHolderForClass(r7, r8, r10, r9, null);
        }
    }

    public /* synthetic */ ScopesHolderForClass(ClassDescriptor r1, StorageManager r2, Function1 r3, KotlinTypeRefiner r4, DefaultConstructorMarker r5) {
        this(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ScopesHolderForClass(ClassDescriptor r1, StorageManager r2, Function1<? super KotlinTypeRefiner, ? extends T> r3, KotlinTypeRefiner r4) {
        this.classDescriptor = r1;
        this.scopeFactory = r3;
        this.kotlinTypeRefinerForOwnerModule = r4;
        this.scopeForOwnerModule$delegate = r2.createLazyValue(new ScopesHolderForClass$scopeForOwnerModule$2(this));
    }

    public static final /* synthetic */ KotlinTypeRefiner access$getKotlinTypeRefinerForOwnerModule$p(ScopesHolderForClass r0) {
        return r0.kotlinTypeRefinerForOwnerModule;
    }

    public static final /* synthetic */ Function1 access$getScopeFactory$p(ScopesHolderForClass r0) {
        return r0.scopeFactory;
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ScopesHolderForClass.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
        Companion = new Companion(null);
    }

    private final T getScopeForOwnerModule() {
        return (T) StorageKt.getValue(this.scopeForOwnerModule$delegate, this, $$delegatedProperties[0]);
    }

    public final T getScope(final KotlinTypeRefiner r3) {
        Intrinsics.checkNotNullParameter(r3, "kotlinTypeRefiner");
        if (r3.isRefinementNeededForModule(DescriptorUtilsKt.getModule(this.classDescriptor)) == false) goto L5;
        TypeConstructor r0 = this.classDescriptor.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(r0, "classDescriptor.typeConstructor");
        if (r3.isRefinementNeededForTypeConstructor(r0) == true) goto L11;
        return (T) getScopeForOwnerModule();
    L11:
        return (T) r3.getOrPutScopeForClass(this.classDescriptor, new AnonymousClass1(this, r3));
    L5:
        return (T) getScopeForOwnerModule();
    }
}
