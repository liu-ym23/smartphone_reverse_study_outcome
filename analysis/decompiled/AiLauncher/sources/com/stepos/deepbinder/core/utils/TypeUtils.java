package com.stepos.deepbinder.core.utils;

import Z8.F;
import Z8.M;
import Z8.r;
import android.view.LifecycleOwner;
import b9.b;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.log.IPCLog;
import com.stepos.deepbinder.core.utils.TypeUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002WXB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ3\u0010\u000e\u001a\u00020\r2\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t2\u0010\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJU\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t2\u0010\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0019\u001a\u00020\u00042\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\n2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\nH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ/\u0010!\u001a\u00020 2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\"J\u001f\u0010&\u001a\u00020%2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\tH\u0002¢\u0006\u0004\b&\u0010'J'\u0010*\u001a\u00020\u00062\n\u0010(\u001a\u0006\u0012\u0002\b\u00030\n2\n\u0010)\u001a\u0006\u0012\u0002\b\u00030\nH\u0002¢\u0006\u0004\b*\u0010+J!\u0010&\u001a\u00020%2\u0010\u0010,\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tH\u0002¢\u0006\u0004\b&\u0010-J-\u00101\u001a\u00020\u00062\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\t2\u000e\u00100\u001a\n\u0012\u0006\b\u0001\u0012\u00020.0\n¢\u0006\u0004\b1\u00102J1\u00105\u001a\u00020\u00062\u0010\u00103\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t2\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t¢\u0006\u0004\b5\u00106J1\u00107\u001a\u00020\r2\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t2\u0010\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t¢\u0006\u0004\b7\u0010\u000fJ%\u00108\u001a\u00020\u00062\n\u0010(\u001a\u0006\u0012\u0002\b\u00030\n2\n\u0010)\u001a\u0006\u0012\u0002\b\u00030\n¢\u0006\u0004\b8\u0010+J\u0019\u0010:\u001a\u00020%2\n\u00109\u001a\u0006\u0012\u0002\b\u00030\n¢\u0006\u0004\b:\u0010;J+\u0010<\u001a\u00020%2\n\u00109\u001a\u0006\u0012\u0002\b\u00030\n2\u0010\u0010,\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t¢\u0006\u0004\b<\u0010=J\u0019\u0010?\u001a\u0004\u0018\u00010\u00012\b\u0010>\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b?\u0010@JA\u0010D\u001a\u0004\u0018\u00010C2\n\u00109\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010A\u001a\u00020%2\u0010\u0010,\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t2\n\u0010B\u001a\u0006\u0012\u0002\b\u00030\n¢\u0006\u0004\bD\u0010EJ;\u0010H\u001a\u00020C2\n\u00109\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010F\u001a\u00020%2\u0010\u0010,\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t2\u0006\u0010G\u001a\u00020\u0006¢\u0006\u0004\bH\u0010IJ?\u0010K\u001a\u00020C2\n\u00109\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010F\u001a\u00020%2\u0010\u0010,\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t2\n\u0010J\u001a\u0006\u0012\u0002\b\u00030\n¢\u0006\u0004\bK\u0010EJ%\u0010L\u001a\u00020%2\u0006\u0010F\u001a\u00020%2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\t¢\u0006\u0004\bL\u0010MJ\u001d\u0010P\u001a\u00020\u00042\u0006\u0010N\u001a\u00020%2\u0006\u0010O\u001a\u00020\u0001¢\u0006\u0004\bP\u0010QJ\u0019\u0010R\u001a\u00020\u00062\n\u00109\u001a\u0006\u0012\u0002\b\u00030\n¢\u0006\u0004\bR\u0010SJ\u0015\u0010L\u001a\u00020%2\u0006\u0010U\u001a\u00020T¢\u0006\u0004\bL\u0010V¨\u0006Y"}, d2 = {"Lcom/stepos/deepbinder/core/utils/TypeUtils;", "", "<init>", "()V", "", "modifier", "", "isSyntheticAndFinal", "(I)Z", "", "Ljava/lang/Class;", "methodParams", "callParams", "Lcom/stepos/deepbinder/core/utils/TypeUtils$MatchResult;", "findBestParameterMapping", "([Ljava/lang/Class;[Ljava/lang/Class;)Lcom/stepos/deepbinder/core/utils/TypeUtils$MatchResult;", "methodParamIndex", "callParamIndex", "", "currentMapping", "currentScore", "findBestMappingRecursive", "([Ljava/lang/Class;[Ljava/lang/Class;II[II)Lcom/stepos/deepbinder/core/utils/TypeUtils$MatchResult;", "subClass", "superClass", "getInheritanceDistance", "(Ljava/lang/Class;Ljava/lang/Class;)I", "target", "Ljava/util/Queue;", "Lcom/stepos/deepbinder/core/utils/FieldInfo;", "queue", "depth", "LY8/t;", "fillStackByTarget", "(Ljava/lang/Object;Ljava/util/Queue;I)V", "Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", "parameterWrappers", "", "getMethodParameters", "([Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;)Ljava/lang/String;", "class1", "class2", "primitiveMatch", "(Ljava/lang/Class;Ljava/lang/Class;)Z", "parameterTypes", "([Ljava/lang/Class;)Ljava/lang/String;", "Ljava/lang/annotation/Annotation;", "annotations", "annotationClass", "arrayContainsAnnotation", "([Ljava/lang/annotation/Annotation;Ljava/lang/Class;)Z", "fromClasses", "toClasses", "classAssignable", "([Ljava/lang/Class;[Ljava/lang/Class;)Z", "calculateMatchScore", "classMatch", "clazz", "getClassId", "(Ljava/lang/Class;)Ljava/lang/String;", "getConstructorId", "(Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/String;", "instance", "getExternalClass", "(Ljava/lang/Object;)Ljava/lang/Object;", "name", "returnType", "Lcom/stepos/deepbinder/core/utils/TypeUtils$MethodMatchResult;", "getMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;)Lcom/stepos/deepbinder/core/utils/TypeUtils$MethodMatchResult;", "methodName", "allowDifferentReturn", "getMethodForGettingInstance", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Z)Lcom/stepos/deepbinder/core/utils/TypeUtils$MethodMatchResult;", "expectedReturnType", "getMethodForKtInstance", "getMethodId", "(Ljava/lang/String;[Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;)Ljava/lang/String;", "typeName", "array", "getObjectArraySize", "(Ljava/lang/String;Ljava/lang/Object;)I", "isVoid", "(Ljava/lang/Class;)Z", "Ljava/lang/reflect/Method;", "method", "(Ljava/lang/reflect/Method;)Ljava/lang/String;", "MatchResult", "MethodMatchResult", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TypeUtils {
    public static final TypeUtils INSTANCE = new TypeUtils();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/stepos/deepbinder/core/utils/TypeUtils$MatchResult;", "", "score", "", "parameterMapping", "", "<init>", "(I[I)V", "getScore", "()I", "getParameterMapping", "()[I", "equals", "", "other", "hashCode", "component1", "component2", ChatTracker.CLICK_COPY, "toString", "", "Companion", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class MatchResult {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final MatchResult NO_MATCH = new MatchResult(-1, new int[0]);
        private final int[] parameterMapping;
        private final int score;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/deepbinder/core/utils/TypeUtils$MatchResult$Companion;", "", "<init>", "()V", "NO_MATCH", "Lcom/stepos/deepbinder/core/utils/TypeUtils$MatchResult;", "getNO_MATCH", "()Lcom/stepos/deepbinder/core/utils/TypeUtils$MatchResult;", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(i iVar) {
                this();
            }

            public final MatchResult getNO_MATCH() {
                return MatchResult.NO_MATCH;
            }

            private Companion() {
            }
        }

        public MatchResult(int i10, int[] parameterMapping) {
            p.i(parameterMapping, "parameterMapping");
            this.score = i10;
            this.parameterMapping = parameterMapping;
        }

        public static /* synthetic */ MatchResult copy$default(MatchResult matchResult, int i10, int[] iArr, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = matchResult.score;
            }
            if ((i11 & 2) != 0) {
                iArr = matchResult.parameterMapping;
            }
            return matchResult.copy(i10, iArr);
        }

        /* renamed from: component1, reason: from getter */
        public final int getScore() {
            return this.score;
        }

        /* renamed from: component2, reason: from getter */
        public final int[] getParameterMapping() {
            return this.parameterMapping;
        }

        public final MatchResult copy(int score, int[] parameterMapping) {
            p.i(parameterMapping, "parameterMapping");
            return new MatchResult(score, parameterMapping);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!p.d(MatchResult.class, other != null ? other.getClass() : null)) {
                return false;
            }
            p.g(other, "null cannot be cast to non-null type com.stepos.deepbinder.core.utils.TypeUtils.MatchResult");
            MatchResult matchResult = (MatchResult) other;
            return this.score == matchResult.score && Arrays.equals(this.parameterMapping, matchResult.parameterMapping);
        }

        public final int[] getParameterMapping() {
            return this.parameterMapping;
        }

        public final int getScore() {
            return this.score;
        }

        public int hashCode() {
            return (this.score * 31) + Arrays.hashCode(this.parameterMapping);
        }

        public String toString() {
            return "MatchResult(score=" + this.score + ", parameterMapping=" + Arrays.toString(this.parameterMapping) + ")";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/stepos/deepbinder/core/utils/TypeUtils$MethodMatchResult;", "", "method", "Ljava/lang/reflect/Method;", "matchResult", "Lcom/stepos/deepbinder/core/utils/TypeUtils$MatchResult;", "<init>", "(Ljava/lang/reflect/Method;Lcom/stepos/deepbinder/core/utils/TypeUtils$MatchResult;)V", "getMethod", "()Ljava/lang/reflect/Method;", "getMatchResult", "()Lcom/stepos/deepbinder/core/utils/TypeUtils$MatchResult;", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class MethodMatchResult {
        private final MatchResult matchResult;
        private final Method method;

        public MethodMatchResult(Method method, MatchResult matchResult) {
            p.i(method, "method");
            p.i(matchResult, "matchResult");
            this.method = method;
            this.matchResult = matchResult;
        }

        public static /* synthetic */ MethodMatchResult copy$default(MethodMatchResult methodMatchResult, Method method, MatchResult matchResult, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                method = methodMatchResult.method;
            }
            if ((i10 & 2) != 0) {
                matchResult = methodMatchResult.matchResult;
            }
            return methodMatchResult.copy(method, matchResult);
        }

        /* renamed from: component1, reason: from getter */
        public final Method getMethod() {
            return this.method;
        }

        /* renamed from: component2, reason: from getter */
        public final MatchResult getMatchResult() {
            return this.matchResult;
        }

        public final MethodMatchResult copy(Method method, MatchResult matchResult) {
            p.i(method, "method");
            p.i(matchResult, "matchResult");
            return new MethodMatchResult(method, matchResult);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MethodMatchResult)) {
                return false;
            }
            MethodMatchResult methodMatchResult = (MethodMatchResult) other;
            return p.d(this.method, methodMatchResult.method) && p.d(this.matchResult, methodMatchResult.matchResult);
        }

        public final MatchResult getMatchResult() {
            return this.matchResult;
        }

        public final Method getMethod() {
            return this.method;
        }

        public int hashCode() {
            return (this.method.hashCode() * 31) + this.matchResult.hashCode();
        }

        public String toString() {
            return "MethodMatchResult(method=" + this.method + ", matchResult=" + this.matchResult + ")";
        }
    }

    private TypeUtils() {
    }

    private final void fillStackByTarget(Object target, Queue<FieldInfo> queue, int depth) {
        Field[] declaredFields;
        if (target == null || (declaredFields = target.getClass().getDeclaredFields()) == null) {
            return;
        }
        ArrayList<Field> arrayList = new ArrayList();
        for (Field field : declaredFields) {
            if (INSTANCE.isSyntheticAndFinal(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        for (Field field2 : arrayList) {
            p.f(field2);
            queue.add(new FieldInfo(target, field2, depth));
        }
    }

    private final MatchResult findBestMappingRecursive(Class<?>[] methodParams, Class<?>[] callParams, int methodParamIndex, int callParamIndex, int[] currentMapping, int currentScore) {
        Class<?>[] clsArr = callParams;
        if (callParamIndex >= clsArr.length) {
            int length = currentScore + ((methodParams.length - clsArr.length) * 100);
            int[] iArrCopyOf = Arrays.copyOf(currentMapping, currentMapping.length);
            p.h(iArrCopyOf, "copyOf(...)");
            return new MatchResult(length, iArrCopyOf);
        }
        if (methodParamIndex >= methodParams.length) {
            return null;
        }
        Class<?> cls = clsArr[callParamIndex];
        int length2 = methodParams.length;
        MatchResult matchResult = null;
        int i10 = methodParamIndex;
        while (i10 < length2) {
            Class<?> cls2 = methodParams[i10];
            int inheritanceDistance = classMatch(cls2, cls) ? 0 : cls2.isAssignableFrom(cls) ? getInheritanceDistance(cls, cls2) : -1;
            if (inheritanceDistance >= 0) {
                int[] iArrCopyOf2 = Arrays.copyOf(currentMapping, currentMapping.length);
                p.h(iArrCopyOf2, "copyOf(...)");
                iArrCopyOf2[i10] = callParamIndex;
                MatchResult matchResultFindBestMappingRecursive = findBestMappingRecursive(methodParams, clsArr, i10 + 1, callParamIndex + 1, iArrCopyOf2, currentScore + inheritanceDistance);
                if (matchResultFindBestMappingRecursive != null && (matchResult == null || matchResultFindBestMappingRecursive.getScore() < matchResult.getScore())) {
                    matchResult = matchResultFindBestMappingRecursive;
                }
            }
            i10++;
            clsArr = callParams;
        }
        return matchResult;
    }

    private final MatchResult findBestParameterMapping(Class<?>[] methodParams, Class<?>[] callParams) {
        int length = methodParams.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = -1;
        }
        MatchResult matchResultFindBestMappingRecursive = findBestMappingRecursive(methodParams, callParams, 0, 0, iArr, 0);
        return matchResultFindBestMappingRecursive == null ? MatchResult.INSTANCE.getNO_MATCH() : matchResultFindBestMappingRecursive;
    }

    private final int getInheritanceDistance(Class<?> subClass, Class<?> superClass) {
        Class<? super Object> superclass = subClass.getSuperclass();
        int i10 = 1;
        while (superclass != null && !p.d(superclass, superClass)) {
            i10++;
            superclass = superclass.getSuperclass();
        }
        if (superclass == null && superClass.isInterface()) {
            Class<?>[] interfaces = subClass.getInterfaces();
            p.h(interfaces, "getInterfaces(...)");
            if (r.R(interfaces, superClass)) {
                return 10;
            }
            superclass = subClass.getSuperclass();
            while (superclass != null) {
                Class<?>[] interfaces2 = superclass.getInterfaces();
                p.h(interfaces2, "getInterfaces(...)");
                if (r.R(interfaces2, superClass)) {
                    return i10 + 10;
                }
                superclass = superclass.getSuperclass();
                i10++;
            }
        }
        if (superclass == null) {
            return 1000;
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getMethod$lambda$7(Class it) {
        p.i(it, "it");
        String simpleName = it.getSimpleName();
        p.h(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getMethodForGettingInstance$lambda$10(Class it) {
        p.i(it, "it");
        String simpleName = it.getSimpleName();
        p.h(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final String getMethodParameters(ParameterWrapper[] parameterWrappers) {
        String strW0;
        return (parameterWrappers == null || (strW0 = r.w0(parameterWrappers, Const.STR_MART_COMMA, null, null, 0, null, new InterfaceC5074l() { // from class: m7.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TypeUtils.getMethodParameters$lambda$12((ParameterWrapper) obj);
            }
        }, 30, null)) == null) ? "" : strW0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getMethodParameters$lambda$12(ParameterWrapper it) {
        p.i(it, "it");
        return ConvertUtils.INSTANCE.basicNameConvert(it.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getMethodParameters$lambda$13(Class it) {
        p.i(it, "it");
        return ConvertUtils.INSTANCE.basicNameConvert(INSTANCE.getClassId(it));
    }

    private final boolean isSyntheticAndFinal(int modifier) {
        return (modifier & 4112) == 4112;
    }

    private final boolean primitiveMatch(Class<?> class1, Class<?> class2) {
        boolean zD = p.d(class1, Boolean.class);
        Class cls = Boolean.TYPE;
        if (zD && p.d(class2, cls)) {
            return true;
        }
        boolean zD2 = p.d(class1, Byte.class);
        Class cls2 = Byte.TYPE;
        if (zD2 && p.d(class2, cls2)) {
            return true;
        }
        boolean zD3 = p.d(class1, Character.class);
        Class cls3 = Character.TYPE;
        if (zD3 && p.d(class2, cls3)) {
            return true;
        }
        boolean zD4 = p.d(class1, Short.class);
        Class cls4 = Short.TYPE;
        if (zD4 && p.d(class2, cls4)) {
            return true;
        }
        boolean zD5 = p.d(class1, Integer.class);
        Class cls5 = Integer.TYPE;
        if (zD5 && p.d(class2, cls5)) {
            return true;
        }
        boolean zD6 = p.d(class1, Long.class);
        Class cls6 = Long.TYPE;
        if (zD6 && p.d(class2, cls6)) {
            return true;
        }
        boolean zD7 = p.d(class1, Float.class);
        Class cls7 = Float.TYPE;
        if (zD7 && p.d(class2, cls7)) {
            return true;
        }
        boolean zD8 = p.d(class1, Double.class);
        Class cls8 = Double.TYPE;
        if (zD8 && p.d(class2, cls8)) {
            return true;
        }
        boolean zD9 = p.d(class1, Void.class);
        Class cls9 = Void.TYPE;
        if (zD9 && p.d(class2, cls9)) {
            return true;
        }
        if (p.d(class1, cls) && p.d(class2, Boolean.class)) {
            return true;
        }
        if (p.d(class1, cls2) && p.d(class2, Byte.class)) {
            return true;
        }
        if (p.d(class1, cls3) && p.d(class2, Character.class)) {
            return true;
        }
        if (p.d(class1, cls4) && p.d(class2, Short.class)) {
            return true;
        }
        if (p.d(class1, cls5) && p.d(class2, Integer.class)) {
            return true;
        }
        if (p.d(class1, cls6) && p.d(class2, Long.class)) {
            return true;
        }
        if (p.d(class1, cls7) && p.d(class2, Float.class)) {
            return true;
        }
        if (p.d(class1, cls8) && p.d(class2, Double.class)) {
            return true;
        }
        return p.d(class1, cls9) && p.d(class2, Void.class);
    }

    public final boolean arrayContainsAnnotation(Annotation[] annotations, Class<? extends Annotation> annotationClass) {
        p.i(annotationClass, "annotationClass");
        if (annotations != null) {
            for (Annotation annotation : annotations) {
                if (annotationClass.isInstance(annotation)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final MatchResult calculateMatchScore(Class<?>[] methodParams, Class<?>[] callParams) {
        int inheritanceDistance;
        p.i(methodParams, "methodParams");
        p.i(callParams, "callParams");
        if (callParams.length > methodParams.length) {
            return MatchResult.INSTANCE.getNO_MATCH();
        }
        if (callParams.length != methodParams.length) {
            return findBestParameterMapping(methodParams, callParams);
        }
        int length = callParams.length;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            Class<?> cls = methodParams[i11];
            Class<?> cls2 = callParams[i11];
            if (classMatch(cls, cls2)) {
                inheritanceDistance = 0;
            } else {
                if (!cls.isAssignableFrom(cls2)) {
                    return MatchResult.INSTANCE.getNO_MATCH();
                }
                inheritanceDistance = getInheritanceDistance(cls2, cls);
            }
            i10 += inheritanceDistance;
        }
        int length2 = methodParams.length;
        int[] iArr = new int[length2];
        for (int i12 = 0; i12 < length2; i12++) {
            iArr[i12] = i12;
        }
        return new MatchResult(i10, iArr);
    }

    public final boolean classAssignable(Class<?>[] fromClasses, Class<?>[] toClasses) {
        p.i(fromClasses, "fromClasses");
        p.i(toClasses, "toClasses");
        if (toClasses.length > fromClasses.length) {
            return false;
        }
        Iterable iterableA0 = r.a0(toClasses);
        if ((iterableA0 instanceof Collection) && ((Collection) iterableA0).isEmpty()) {
            return true;
        }
        Iterator it = iterableA0.iterator();
        while (it.hasNext()) {
            int iNextInt = ((M) it).nextInt();
            Class<?> cls = toClasses[iNextInt];
            if (cls != null && !INSTANCE.classMatch(fromClasses[iNextInt], cls) && !fromClasses[iNextInt].isAssignableFrom(cls)) {
                return false;
            }
        }
        return true;
    }

    public final boolean classMatch(Class<?> class1, Class<?> class2) {
        p.i(class1, "class1");
        p.i(class2, "class2");
        return p.d(class1, class2) || primitiveMatch(class1, class2);
    }

    public final String getClassId(Class<?> clazz) {
        p.i(clazz, "clazz");
        String name = clazz.getName();
        p.h(name, "getName(...)");
        return name;
    }

    public final String getConstructorId(Class<?> clazz, Class<?>[] parameterTypes) {
        p.i(clazz, "clazz");
        p.i(parameterTypes, "parameterTypes");
        return clazz.getSimpleName() + "(" + getMethodParameters(parameterTypes) + ")";
    }

    public final Object getExternalClass(Object instance) {
        try {
            LinkedList linkedList = new LinkedList();
            fillStackByTarget(instance, linkedList, 1);
            while (!linkedList.isEmpty()) {
                FieldInfo fieldInfoPoll = linkedList.poll();
                Object fieldValue = fieldInfoPoll.getFieldValue();
                if (fieldValue instanceof LifecycleOwner) {
                    return fieldValue;
                }
                if (fieldInfoPoll.getDepth() < 1) {
                    fillStackByTarget(fieldValue, linkedList, fieldInfoPoll.getDepth() + 1);
                }
            }
            return null;
        } catch (Exception e10) {
            IPCLog.INSTANCE.w("TypeUtils", "[getExternalClass] exception: " + e10, new Object[0]);
            return null;
        }
    }

    public final MethodMatchResult getMethod(Class<?> clazz, String name, Class<?>[] parameterTypes, Class<?> returnType) throws SecurityException {
        MethodMatchResult methodMatchResult;
        p.i(clazz, "clazz");
        p.i(name, "name");
        p.i(parameterTypes, "parameterTypes");
        p.i(returnType, "returnType");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        p.h(declaredMethods, "getDeclaredMethods(...)");
        ArrayList<Method> arrayList = new ArrayList();
        for (Method method : declaredMethods) {
            if (p.d(method.getName(), name)) {
                arrayList.add(method);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Method method2 : arrayList) {
            TypeUtils typeUtils = INSTANCE;
            Class<?>[] parameterTypes2 = method2.getParameterTypes();
            p.h(parameterTypes2, "getParameterTypes(...)");
            MatchResult matchResultCalculateMatchScore = typeUtils.calculateMatchScore(parameterTypes2, parameterTypes);
            if (matchResultCalculateMatchScore.getScore() >= 0) {
                p.f(method2);
                methodMatchResult = new MethodMatchResult(method2, matchResultCalculateMatchScore);
            } else {
                methodMatchResult = null;
            }
            if (methodMatchResult != null) {
                arrayList2.add(methodMatchResult);
            }
        }
        if (arrayList2.isEmpty()) {
            return null;
        }
        List listC1 = F.c1(arrayList2, new Comparator() { // from class: com.stepos.deepbinder.core.utils.TypeUtils$getMethod$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                return b.d(Integer.valueOf(((TypeUtils.MethodMatchResult) t10).getMatchResult().getScore()), Integer.valueOf(((TypeUtils.MethodMatchResult) t11).getMatchResult().getScore()));
            }
        });
        if (listC1.size() > 1 && ((MethodMatchResult) listC1.get(0)).getMatchResult().getScore() == ((MethodMatchResult) listC1.get(1)).getMatchResult().getScore()) {
            throw new IPCException(14, "Ambiguous method call: More than one method named " + name + " in " + clazz.getName() + " with equal match score for parameters: " + r.w0(parameterTypes, null, null, null, 0, null, new InterfaceC5074l() { // from class: m7.c
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return TypeUtils.getMethod$lambda$7((Class) obj);
                }
            }, 31, null));
        }
        MethodMatchResult methodMatchResult2 = (MethodMatchResult) F.q0(listC1);
        methodMatchResult2.getMethod().setAccessible(true);
        if (p.d(methodMatchResult2.getMethod().getReturnType(), returnType)) {
            return methodMatchResult2;
        }
        throw new IPCException(17, "Return type mismatch for method " + name + " in " + clazz.getName() + ": expected " + returnType.getName() + ", got " + methodMatchResult2.getMethod().getReturnType().getName());
    }

    public final MethodMatchResult getMethodForGettingInstance(Class<?> clazz, String methodName, Class<?>[] parameterTypes, boolean allowDifferentReturn) throws SecurityException {
        MethodMatchResult methodMatchResult;
        p.i(clazz, "clazz");
        p.i(methodName, "methodName");
        p.i(parameterTypes, "parameterTypes");
        if (methodName.length() == 0) {
            methodName = "getInstance";
        }
        Method[] declaredMethods = clazz.getDeclaredMethods();
        p.h(declaredMethods, "getDeclaredMethods(...)");
        ArrayList<Method> arrayList = new ArrayList();
        for (Method method : declaredMethods) {
            if (p.d(method.getName(), methodName)) {
                arrayList.add(method);
            }
        }
        if (arrayList.isEmpty()) {
            throw new IPCException(35, "Method " + methodName + " not found in " + clazz.getName());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Method method2 : arrayList) {
            TypeUtils typeUtils = INSTANCE;
            Class<?>[] parameterTypes2 = method2.getParameterTypes();
            p.h(parameterTypes2, "getParameterTypes(...)");
            MatchResult matchResultCalculateMatchScore = typeUtils.calculateMatchScore(parameterTypes2, parameterTypes);
            if (matchResultCalculateMatchScore.getScore() >= 0) {
                p.f(method2);
                methodMatchResult = new MethodMatchResult(method2, matchResultCalculateMatchScore);
            } else {
                methodMatchResult = null;
            }
            if (methodMatchResult != null) {
                arrayList2.add(methodMatchResult);
            }
        }
        if (arrayList2.isEmpty()) {
            throw new IPCException(35, "No matching method " + methodName + " found in " + clazz.getName() + " for parameters: " + r.w0(parameterTypes, null, null, null, 0, null, new InterfaceC5074l() { // from class: m7.a
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return TypeUtils.getMethodForGettingInstance$lambda$10((Class) obj);
                }
            }, 31, null));
        }
        List listC1 = F.c1(arrayList2, new Comparator() { // from class: com.stepos.deepbinder.core.utils.TypeUtils$getMethodForGettingInstance$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                return b.d(Integer.valueOf(((TypeUtils.MethodMatchResult) t10).getMatchResult().getScore()), Integer.valueOf(((TypeUtils.MethodMatchResult) t11).getMatchResult().getScore()));
            }
        });
        if (listC1.size() > 1 && ((MethodMatchResult) listC1.get(0)).getMatchResult().getScore() == ((MethodMatchResult) listC1.get(1)).getMatchResult().getScore()) {
            throw new IPCException(33, "Ambiguous method call: More than one method named " + methodName + " in " + clazz.getName() + " with equal match score");
        }
        MethodMatchResult methodMatchResult2 = (MethodMatchResult) F.q0(listC1);
        methodMatchResult2.getMethod().setAccessible(true);
        if (allowDifferentReturn || p.d(methodMatchResult2.getMethod().getReturnType(), clazz)) {
            return methodMatchResult2;
        }
        throw new IPCException(34, "Return type mismatch for " + methodName + " in " + clazz.getName() + ": expected " + clazz.getName() + ", got " + methodMatchResult2.getMethod().getReturnType().getName());
    }

    public final MethodMatchResult getMethodForKtInstance(Class<?> clazz, String methodName, Class<?>[] parameterTypes, Class<?> expectedReturnType) throws SecurityException {
        p.i(clazz, "clazz");
        p.i(methodName, "methodName");
        p.i(parameterTypes, "parameterTypes");
        p.i(expectedReturnType, "expectedReturnType");
        MethodMatchResult methodForGettingInstance = getMethodForGettingInstance(clazz, methodName, parameterTypes, true);
        if (p.d(methodForGettingInstance.getMethod().getReturnType(), expectedReturnType)) {
            return methodForGettingInstance;
        }
        throw new IPCException(34, "Return type mismatch for " + methodName + " in " + clazz.getName());
    }

    public final String getMethodId(String methodName, ParameterWrapper[] parameterWrappers) {
        p.i(methodName, "methodName");
        return methodName + "(" + getMethodParameters(parameterWrappers) + ")";
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public final int getObjectArraySize(String typeName, Object array) {
        p.i(typeName, "typeName");
        p.i(array, "array");
        int iHashCode = typeName.hashCode();
        if (iHashCode != 2891) {
            if (iHashCode != 2904) {
                if (iHashCode != 2911) {
                    if (iHashCode != 2894) {
                        if (iHashCode != 2895) {
                            switch (iHashCode) {
                                case 2887:
                                    if (typeName.equals("[B")) {
                                        return ((byte[]) array).length;
                                    }
                                    break;
                                case 2888:
                                    if (typeName.equals("[C")) {
                                        return ((char[]) array).length;
                                    }
                                    break;
                                case 2889:
                                    if (typeName.equals("[D")) {
                                        return ((double[]) array).length;
                                    }
                                    break;
                            }
                        } else if (typeName.equals("[J")) {
                            return ((long[]) array).length;
                        }
                    } else if (typeName.equals("[I")) {
                        return ((int[]) array).length;
                    }
                } else if (typeName.equals("[Z")) {
                    return ((boolean[]) array).length;
                }
            } else if (typeName.equals("[S")) {
                return ((short[]) array).length;
            }
        } else if (typeName.equals("[F")) {
            return ((float[]) array).length;
        }
        return ((Object[]) array).length;
    }

    public final boolean isVoid(Class<?> clazz) {
        p.i(clazz, "clazz");
        return p.d(Void.TYPE, clazz);
    }

    public final String getMethodId(Method method) {
        p.i(method, "method");
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        p.h(parameterTypes, "getParameterTypes(...)");
        return name + "(" + getMethodParameters(parameterTypes) + ")";
    }

    private final String getMethodParameters(Class<?>[] parameterTypes) {
        return r.w0(parameterTypes, Const.STR_MART_COMMA, null, null, 0, null, new InterfaceC5074l() { // from class: m7.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TypeUtils.getMethodParameters$lambda$13((Class) obj);
            }
        }, 30, null);
    }
}
