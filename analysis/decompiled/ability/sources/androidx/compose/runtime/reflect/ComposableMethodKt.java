package androidx.compose.runtime.reflect;

import D7.F;
import D7.w;
import Y7.f;
import Z0.a;
import androidx.compose.runtime.Composer;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import g1.AbstractC1451a;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0018\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0002\u001a\u0012\u0010\t\u001a\u0004\u0018\u00010\n*\u0006\u0012\u0002\b\u00030\u000bH\u0002\u001a\f\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\b\u001a(\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000f\"\u0006\b\u0000\u0010\u0010\u0018\u0001*\u0002H\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0082\b¢\u0006\u0002\u0010\u0012\u001a7\u0010\u0013\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u001a\u0010\u0016\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000b0\u000f\"\u0006\u0012\u0002\b\u00030\u000b¢\u0006\u0002\u0010\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"BITS_PER_INT", "", "changedParamCount", "realValueParams", "thisParams", "defaultParamCount", "getComposableInfo", "Landroidx/compose/runtime/reflect/ComposableInfo;", "Ljava/lang/reflect/Method;", "getDefaultValue", "", "Ljava/lang/Class;", "asComposableMethod", "Landroidx/compose/runtime/reflect/ComposableMethod;", "dup", "", ExifInterface.GPS_DIRECTION_TRUE, "count", "(Ljava/lang/Object;I)[Ljava/lang/Object;", "getDeclaredComposableMethod", "methodName", "", "args", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Landroidx/compose/runtime/reflect/ComposableMethod;", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposableMethodKt {
    private static final int BITS_PER_INT = 31;

    public static final ComposableMethod asComposableMethod(Method method) {
        ComposableInfo composableInfo = getComposableInfo(method);
        if (composableInfo.isComposable()) {
            return new ComposableMethod(method, composableInfo);
        }
        return null;
    }

    private static final int changedParamCount(int i, int i6) {
        if (i == 0) {
            return 1;
        }
        return (int) Math.ceil((i + i6) / 10.0d);
    }

    private static final int defaultParamCount(int i) {
        return (int) Math.ceil(i / 31.0d);
    }

    private static final <T> T[] dup(T t9, int i) {
        f fVarX = AbstractC1451a.X(0, i);
        ArrayList arrayList = new ArrayList(w.c0(fVarX, 10));
        Iterator<T> it = fVarX.iterator();
        while (it.hasNext()) {
            ((F) it).nextInt();
            arrayList.add(t9);
        }
        k.m();
        throw null;
    }

    private static final ComposableInfo getComposableInfo(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        int length = parameterTypes.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (k.b(parameterTypes[length], Composer.class)) {
                    break;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
            length = -1;
        } else {
            length = -1;
        }
        if (length == -1) {
            return new ComposableInfo(false, method.getParameterTypes().length, 0, 0);
        }
        int iChangedParamCount = changedParamCount(length, !Modifier.isStatic(method.getModifiers()) ? 1 : 0);
        int i6 = length + 1 + iChangedParamCount;
        int length2 = method.getParameterTypes().length;
        int iDefaultParamCount = length2 != i6 ? defaultParamCount(length) : 0;
        return new ComposableInfo(i6 + iDefaultParamCount == length2, length, iChangedParamCount, iDefaultParamCount);
    }

    public static final ComposableMethod getDeclaredComposableMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException, SecurityException {
        Method declaredMethod;
        Class cls2 = Integer.TYPE;
        int iChangedParamCount = changedParamCount(clsArr.length, 0);
        try {
            a aVar = new a(3);
            ArrayList arrayList = (ArrayList) aVar.f1582a;
            aVar.E(clsArr);
            aVar.D(Composer.class);
            f fVarX = AbstractC1451a.X(0, iChangedParamCount);
            ArrayList arrayList2 = new ArrayList(w.c0(fVarX, 10));
            Iterator it = fVarX.iterator();
            while (it.hasNext()) {
                ((F) it).nextInt();
                arrayList2.add(cls2);
            }
            aVar.E(arrayList2.toArray(new Class[0]));
            declaredMethod = cls.getDeclaredMethod(str, (Class[]) arrayList.toArray(new Class[arrayList.size()]));
        } catch (ReflectiveOperationException unused) {
            int iDefaultParamCount = defaultParamCount(clsArr.length);
            try {
                a aVar2 = new a(4);
                ArrayList arrayList3 = (ArrayList) aVar2.f1582a;
                aVar2.E(clsArr);
                aVar2.D(Composer.class);
                f fVarX2 = AbstractC1451a.X(0, iChangedParamCount);
                ArrayList arrayList4 = new ArrayList(w.c0(fVarX2, 10));
                Iterator it2 = fVarX2.iterator();
                while (it2.hasNext()) {
                    ((F) it2).nextInt();
                    arrayList4.add(cls2);
                }
                aVar2.E(arrayList4.toArray(new Class[0]));
                f fVarX3 = AbstractC1451a.X(0, iDefaultParamCount);
                ArrayList arrayList5 = new ArrayList(w.c0(fVarX3, 10));
                Iterator it3 = fVarX3.iterator();
                while (it3.hasNext()) {
                    ((F) it3).nextInt();
                    arrayList5.add(cls2);
                }
                aVar2.E(arrayList5.toArray(new Class[0]));
                declaredMethod = cls.getDeclaredMethod(str, (Class[]) arrayList3.toArray(new Class[arrayList3.size()]));
            } catch (ReflectiveOperationException unused2) {
                declaredMethod = null;
            }
        }
        if (declaredMethod != null) {
            ComposableMethod composableMethodAsComposableMethod = asComposableMethod(declaredMethod);
            k.c(composableMethodAsComposableMethod);
            return composableMethodAsComposableMethod;
        }
        throw new NoSuchMethodException(cls.getName() + '.' + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object getDefaultValue(Class<?> cls) {
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    return Double.valueOf(0.0d);
                }
                return null;
            case 104431:
                return !name.equals("int") ? null : 0;
            case 3039496:
                return !name.equals("byte") ? null : (byte) 0;
            case 3052374:
                return !name.equals("char") ? null : (char) 0;
            case 3327612:
                return !name.equals("long") ? null : 0L;
            case 64711720:
                if (name.equals(TypedValues.Custom.S_BOOLEAN)) {
                    return Boolean.FALSE;
                }
                return null;
            case 97526364:
                if (name.equals(TypedValues.Custom.S_FLOAT)) {
                    return Float.valueOf(0.0f);
                }
                return null;
            case 109413500:
                return !name.equals("short") ? null : (short) 0;
            default:
                return null;
        }
    }
}
