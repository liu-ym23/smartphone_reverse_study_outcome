package com.stepos.deepbinder.core.cache;

import La.H;
import Z8.F;
import Z8.r;
import android.text.TextUtils;
import android.util.LruCache;
import b9.b;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.deepbinder.core.cache.TypeCache;
import com.stepos.deepbinder.core.entity.internal.InternalMethod;
import com.stepos.deepbinder.core.entity.wrapper.BaseWrapper;
import com.stepos.deepbinder.core.entity.wrapper.MethodWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.log.IPCLog;
import com.stepos.deepbinder.core.utils.TypeUtils;
import com.stepos.widget.recipient.StepOSEmailRecipientAdapter;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0002#$B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\nJ\u0014\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u0013J%\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015¢\u0006\u0002\u0010\u0018J)\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0010\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\u0015¢\u0006\u0002\u0010\u001dJ7\u0010\u001e\u001a\u00020\u000f2\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015¢\u0006\u0002\u0010\"R\u0018\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/stepos/deepbinder/core/cache/TypeCache;", "", "<init>", "()V", StepOSEmailRecipientAdapter.LOOKUP_KEY, "Ljava/lang/invoke/MethodHandles$Lookup;", "kotlin.jvm.PlatformType", "Ljava/lang/invoke/MethodHandles$Lookup;", "classCache", "Landroid/util/LruCache;", "", "Ljava/lang/Class;", "constructorCache", "Ljava/lang/reflect/Constructor;", "methodCache", "Lcom/stepos/deepbinder/core/entity/internal/InternalMethod;", "getClassType", "typeName", "wrapper", "Lcom/stepos/deepbinder/core/entity/wrapper/BaseWrapper;", "getClassTypes", "", "parameterWrappers", "Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", "([Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;)[Ljava/lang/Class;", "getConstructor", "Lcom/stepos/deepbinder/core/cache/TypeCache$ConstructorMatchResult;", "clazz", "parameterTypes", "(Ljava/lang/Class;[Ljava/lang/Class;)Lcom/stepos/deepbinder/core/cache/TypeCache$ConstructorMatchResult;", "getMethod", "methodSignature", "methodWrapper", "Lcom/stepos/deepbinder/core/entity/wrapper/MethodWrapper;", "(Ljava/lang/Class;Ljava/lang/String;Lcom/stepos/deepbinder/core/entity/wrapper/MethodWrapper;[Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;)Lcom/stepos/deepbinder/core/entity/internal/InternalMethod;", "ConstructorMatchResult", "Companion", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TypeCache {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "TypeCache";
    private static volatile TypeCache instance;
    private final LruCache<String, Class<?>> classCache;
    private final LruCache<String, Constructor<?>> constructorCache;
    private final MethodHandles.Lookup lookup;
    private final LruCache<String, InternalMethod> methodCache;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stepos/deepbinder/core/cache/TypeCache$Companion;", "", "<init>", "()V", "TAG", "", "instance", "Lcom/stepos/deepbinder/core/cache/TypeCache;", "getInstance", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final TypeCache getInstance() {
            TypeCache typeCache;
            TypeCache typeCache2 = TypeCache.instance;
            if (typeCache2 != null) {
                return typeCache2;
            }
            synchronized (this) {
                typeCache = TypeCache.instance;
                if (typeCache == null) {
                    typeCache = new TypeCache(null);
                    TypeCache.instance = typeCache;
                }
            }
            return typeCache;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/stepos/deepbinder/core/cache/TypeCache$ConstructorMatchResult;", "", "constructor", "Ljava/lang/reflect/Constructor;", "matchResult", "Lcom/stepos/deepbinder/core/utils/TypeUtils$MatchResult;", "<init>", "(Ljava/lang/reflect/Constructor;Lcom/stepos/deepbinder/core/utils/TypeUtils$MatchResult;)V", "getConstructor", "()Ljava/lang/reflect/Constructor;", "getMatchResult", "()Lcom/stepos/deepbinder/core/utils/TypeUtils$MatchResult;", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class ConstructorMatchResult {
        private final Constructor<?> constructor;
        private final TypeUtils.MatchResult matchResult;

        public ConstructorMatchResult(Constructor<?> constructor, TypeUtils.MatchResult matchResult) {
            p.i(constructor, "constructor");
            p.i(matchResult, "matchResult");
            this.constructor = constructor;
            this.matchResult = matchResult;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ConstructorMatchResult copy$default(ConstructorMatchResult constructorMatchResult, Constructor constructor, TypeUtils.MatchResult matchResult, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                constructor = constructorMatchResult.constructor;
            }
            if ((i10 & 2) != 0) {
                matchResult = constructorMatchResult.matchResult;
            }
            return constructorMatchResult.copy(constructor, matchResult);
        }

        public final Constructor<?> component1() {
            return this.constructor;
        }

        /* renamed from: component2, reason: from getter */
        public final TypeUtils.MatchResult getMatchResult() {
            return this.matchResult;
        }

        public final ConstructorMatchResult copy(Constructor<?> constructor, TypeUtils.MatchResult matchResult) {
            p.i(constructor, "constructor");
            p.i(matchResult, "matchResult");
            return new ConstructorMatchResult(constructor, matchResult);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConstructorMatchResult)) {
                return false;
            }
            ConstructorMatchResult constructorMatchResult = (ConstructorMatchResult) other;
            return p.d(this.constructor, constructorMatchResult.constructor) && p.d(this.matchResult, constructorMatchResult.matchResult);
        }

        public final Constructor<?> getConstructor() {
            return this.constructor;
        }

        public final TypeUtils.MatchResult getMatchResult() {
            return this.matchResult;
        }

        public int hashCode() {
            return (this.constructor.hashCode() * 31) + this.matchResult.hashCode();
        }

        public String toString() {
            return "ConstructorMatchResult(constructor=" + this.constructor + ", matchResult=" + this.matchResult + ")";
        }
    }

    public /* synthetic */ TypeCache(i iVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getConstructor$lambda$3(Class it) {
        p.i(it, "it");
        String simpleName = it.getSimpleName();
        p.h(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getConstructor$lambda$5(Class it) {
        p.i(it, "it");
        String simpleName = it.getSimpleName();
        p.h(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public static final TypeCache getInstance() {
        return INSTANCE.getInstance();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Class<?> getClassType(java.lang.String r2) throws java.lang.ClassNotFoundException {
        /*
            r1 = this;
            java.lang.String r0 = "typeName"
            kotlin.jvm.internal.p.i(r2, r0)
            android.util.LruCache<java.lang.String, java.lang.Class<?>> r0 = r1.classCache
            java.lang.Object r0 = r0.get(r2)
            java.lang.Class r0 = (java.lang.Class) r0
            if (r0 == 0) goto L10
            return r0
        L10:
            int r0 = r2.hashCode()
            switch(r0) {
                case -1325958191: goto L7c;
                case 104431: goto L70;
                case 3039496: goto L64;
                case 3052374: goto L58;
                case 3327612: goto L4c;
                case 3625364: goto L40;
                case 64711720: goto L34;
                case 97526364: goto L27;
                case 109413500: goto L19;
                default: goto L17;
            }
        L17:
            goto L84
        L19:
            java.lang.String r0 = "short"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L23
            goto L84
        L23:
            java.lang.Class r0 = java.lang.Short.TYPE
            goto L94
        L27:
            java.lang.String r0 = "float"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L30
            goto L84
        L30:
            java.lang.Class r0 = java.lang.Float.TYPE
            goto L94
        L34:
            java.lang.String r0 = "boolean"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L3d
            goto L84
        L3d:
            java.lang.Class r0 = java.lang.Boolean.TYPE
            goto L94
        L40:
            java.lang.String r0 = "void"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L49
            goto L84
        L49:
            java.lang.Class r0 = java.lang.Void.TYPE
            goto L94
        L4c:
            java.lang.String r0 = "long"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L55
            goto L84
        L55:
            java.lang.Class r0 = java.lang.Long.TYPE
            goto L94
        L58:
            java.lang.String r0 = "char"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L61
            goto L84
        L61:
            java.lang.Class r0 = java.lang.Character.TYPE
            goto L94
        L64:
            java.lang.String r0 = "byte"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L6d
            goto L84
        L6d:
            java.lang.Class r0 = java.lang.Byte.TYPE
            goto L94
        L70:
            java.lang.String r0 = "int"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L79
            goto L84
        L79:
            java.lang.Class r0 = java.lang.Integer.TYPE
            goto L94
        L7c:
            java.lang.String r0 = "double"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L92
        L84:
            java.lang.Class r0 = java.lang.Class.forName(r2)     // Catch: java.lang.ClassNotFoundException -> L89
            goto L94
        L89:
            r1 = move-exception
            com.stepos.deepbinder.core.exception.IPCException r2 = new com.stepos.deepbinder.core.exception.IPCException
            r0 = 21
            r2.<init>(r0, r1)
            throw r2
        L92:
            java.lang.Class r0 = java.lang.Double.TYPE
        L94:
            android.util.LruCache<java.lang.String, java.lang.Class<?>> r1 = r1.classCache
            r1.put(r2, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.deepbinder.core.cache.TypeCache.getClassType(java.lang.String):java.lang.Class");
    }

    public final Class<?>[] getClassTypes(ParameterWrapper[] parameterWrappers) {
        if (parameterWrappers == null) {
            return new Class[0];
        }
        int length = parameterWrappers.length;
        Class<?>[] clsArr = new Class[length];
        for (int i10 = 0; i10 < length; i10++) {
            ParameterWrapper parameterWrapper = parameterWrappers[i10];
            Class<?> classType = getClassType(parameterWrapper);
            if (classType == null) {
                String name = parameterWrapper.getName();
                Object data = parameterWrapper.getData();
                throw new IPCException(21, "Failed to get class type for parameter at index " + i10 + ": name='" + name + "', data=" + (data != null ? data.getClass().getName() : null));
            }
            clsArr[i10] = classType;
        }
        return clsArr;
    }

    public final ConstructorMatchResult getConstructor(Class<?> clazz, Class<?>[] parameterTypes) throws SecurityException {
        ConstructorMatchResult constructorMatchResult;
        p.i(clazz, "clazz");
        p.i(parameterTypes, "parameterTypes");
        TypeUtils typeUtils = TypeUtils.INSTANCE;
        String constructorId = typeUtils.getConstructorId(clazz, parameterTypes);
        Constructor<?> constructor = this.constructorCache.get(constructorId);
        if (constructor != null) {
            Class<?>[] parameterTypes2 = constructor.getParameterTypes();
            p.h(parameterTypes2, "getParameterTypes(...)");
            return new ConstructorMatchResult(constructor, typeUtils.calculateMatchScore(parameterTypes2, parameterTypes));
        }
        Constructor<?>[] constructors = clazz.getConstructors();
        p.h(constructors, "getConstructors(...)");
        ArrayList arrayList = new ArrayList();
        for (Constructor<?> constructor2 : constructors) {
            TypeUtils typeUtils2 = TypeUtils.INSTANCE;
            Class<?>[] parameterTypes3 = constructor2.getParameterTypes();
            p.h(parameterTypes3, "getParameterTypes(...)");
            TypeUtils.MatchResult matchResultCalculateMatchScore = typeUtils2.calculateMatchScore(parameterTypes3, parameterTypes);
            if (matchResultCalculateMatchScore.getScore() >= 0) {
                p.f(constructor2);
                constructorMatchResult = new ConstructorMatchResult(constructor2, matchResultCalculateMatchScore);
            } else {
                constructorMatchResult = null;
            }
            if (constructorMatchResult != null) {
                arrayList.add(constructorMatchResult);
            }
        }
        if (arrayList.isEmpty()) {
            throw new IPCException(16, "No matching constructor found in " + clazz.getName() + " for parameters: " + r.w0(parameterTypes, null, null, null, 0, null, new InterfaceC5074l() { // from class: h7.g
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return TypeCache.getConstructor$lambda$3((Class) obj);
                }
            }, 31, null));
        }
        List listC1 = F.c1(arrayList, new Comparator() { // from class: com.stepos.deepbinder.core.cache.TypeCache$getConstructor$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                return b.d(Integer.valueOf(((TypeCache.ConstructorMatchResult) t10).getMatchResult().getScore()), Integer.valueOf(((TypeCache.ConstructorMatchResult) t11).getMatchResult().getScore()));
            }
        });
        if (listC1.size() <= 1 || ((ConstructorMatchResult) listC1.get(0)).getMatchResult().getScore() != ((ConstructorMatchResult) listC1.get(1)).getMatchResult().getScore()) {
            ConstructorMatchResult constructorMatchResult2 = (ConstructorMatchResult) F.q0(listC1);
            constructorMatchResult2.getConstructor().setAccessible(true);
            this.constructorCache.put(constructorId, constructorMatchResult2.getConstructor());
            return constructorMatchResult2;
        }
        throw new IPCException(15, "Ambiguous constructor call: " + clazz.getName() + " has multiple constructors with equal match score for parameters: " + r.w0(parameterTypes, null, null, null, 0, null, new InterfaceC5074l() { // from class: h7.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TypeCache.getConstructor$lambda$5((Class) obj);
            }
        }, 31, null));
    }

    public final InternalMethod getMethod(Class<?> clazz, String methodSignature, MethodWrapper methodWrapper, ParameterWrapper[] parameterWrappers) throws ClassNotFoundException, SecurityException {
        p.i(clazz, "clazz");
        p.i(methodSignature, "methodSignature");
        p.i(methodWrapper, "methodWrapper");
        String str = clazz.getName() + methodSignature;
        InternalMethod internalMethod = this.methodCache.get(str);
        if (internalMethod != null) {
            return internalMethod;
        }
        InternalMethod internalMethod2 = new InternalMethod();
        String strW1 = H.w1(methodSignature, '(', null, 2, null);
        String returnType = methodWrapper.getIsVoid() ? "void" : methodWrapper.getReturnType();
        if (returnType == null) {
            throw new IPCException(12, "getMethod className not found: " + methodWrapper + " class " + clazz);
        }
        TypeUtils typeUtils = TypeUtils.INSTANCE;
        Class<?>[] classTypes = getClassTypes(parameterWrappers);
        Class<?> classType = getClassType(returnType);
        p.f(classType);
        TypeUtils.MethodMatchResult method = typeUtils.getMethod(clazz, strW1, classTypes, classType);
        if (method == null) {
            throw new IPCException(12, "Method not found: " + methodWrapper + " in class " + clazz.getName());
        }
        Method method2 = method.getMethod();
        method2.setAccessible(true);
        internalMethod2.setMethod(method2);
        internalMethod2.setParameterMapping(method.getMatchResult().getParameterMapping());
        try {
            internalMethod2.setMethodHandle(this.lookup.unreflect(method2));
        } catch (IllegalAccessException e10) {
            IPCLog.INSTANCE.w(TAG, "unreflect method error", e10);
        }
        this.methodCache.put(str, internalMethod2);
        return internalMethod2;
    }

    private TypeCache() {
        this.lookup = MethodHandles.lookup();
        this.classCache = new LruCache<>(500);
        this.constructorCache = new LruCache<>(500);
        this.methodCache = new LruCache<>(1000);
    }

    public final Class<?> getClassType(BaseWrapper wrapper) {
        p.i(wrapper, "wrapper");
        String name = wrapper.getName();
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        return getClassType(name);
    }
}
