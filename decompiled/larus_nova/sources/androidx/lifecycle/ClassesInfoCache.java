package androidx.lifecycle;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class ClassesInfoCache {
    private static final int CALL_TYPE_NO_ARG = 0;
    private static final int CALL_TYPE_PROVIDER = 1;
    private static final int CALL_TYPE_PROVIDER_WITH_EVENT = 2;
    static ClassesInfoCache sInstance;
    private final Map<Class<?>, CallbackInfo> mCallbackMap;
    private final Map<Class<?>, Boolean> mHasLifecycleMethods;

    public static class CallbackInfo {
        final Map<Lifecycle.Event, List<MethodReference>> mEventToHandlers;
        final Map<MethodReference, Lifecycle.Event> mHandlerToEvent;

        public CallbackInfo(Map<MethodReference, Lifecycle.Event> r100) {
            this.mHandlerToEvent = r100;
            this.mEventToHandlers = new HashMap();
            Iterator<Map.Entry<MethodReference, Lifecycle.Event>> r101 = r100.entrySet().iterator();
        L4:
            if (r101.hasNext() == false) goto L9;
            Map.Entry<MethodReference, Lifecycle.Event> r102 = r101.next();
            Lifecycle.Event r103 = r102.getValue();
            List<MethodReference> r104 = this.mEventToHandlers.get(r103);
            if (r104 != null) goto L8;
            r104 = new ArrayList();
            this.mEventToHandlers.put(r103, r104);
        L8:
            r104.add(r102.getKey());
            goto L4
        }

        public void invokeCallbacks(LifecycleOwner r100, Lifecycle.Event r101, Object r102) {
            invokeMethodsForEvent(this.mEventToHandlers.get(r101), r100, r101, r102);
            invokeMethodsForEvent(this.mEventToHandlers.get(Lifecycle.Event.ON_ANY), r100, r101, r102);
        }

        private static void invokeMethodsForEvent(List<MethodReference> r100, LifecycleOwner r101, Lifecycle.Event r102, Object r103) {
            if (r100 == null) goto L6;
            int r104 = r100.size() - 1;
        L4:
            if (r104 < 0) goto L8;
            ((MethodReference) ListProtector.get(r100, r104)).invokeCallback(r101, r102, r103);
            r104 = r104 - 1;
            goto L4
        L8:
            return;
        }
    }

    public static final class MethodReference {
        final int mCallType;
        final Method mMethod;

        public int hashCode() {
            return (this.mCallType * 31) + this.mMethod.getName().hashCode();
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof MethodReference) == true) goto L8;
            return false;
        L8:
            MethodReference r101 = (MethodReference) r100;
            if (this.mCallType == r101.mCallType) goto L11;
        L13:
            return false;
        L11:
            if (this.mMethod.getName().equals(r101.mMethod.getName()) == false) goto L13;
            return true;
        }

        public MethodReference(int r100, Method r101) {
            this.mCallType = r100;
            this.mMethod = r101;
            r101.setAccessible(true);
        }

        public void invokeCallback(LifecycleOwner r100, Lifecycle.Event r101, Object r102) {
            int r103 = this.mCallType;     // Catch: IllegalAccessException -> L13 InvocationTargetException -> L16
            if (r103 != 0) goto L5;
            this.mMethod.invoke(r102, new Object[0]);     // Catch: IllegalAccessException -> L13 InvocationTargetException -> L16
            return;
        L5:
            if (r103 != 1) goto L7;
            this.mMethod.invoke(r102, new Object[]{r100});     // Catch: IllegalAccessException -> L13 InvocationTargetException -> L16
            return;
        L7:
            if (r103 != 2) goto L20;
            this.mMethod.invoke(r102, new Object[]{r100, r101});     // Catch: IllegalAccessException -> L13 InvocationTargetException -> L16
            return;
        L20:
            return;
        L13:
            e = move-exception;
            throw new RuntimeException(e);
        L16:
            e = move-exception;
            throw new RuntimeException("Failed to call observer method", e.getCause());
        }
    }

    static {
        sInstance = new ClassesInfoCache();
    }

    public ClassesInfoCache() {
        this.mCallbackMap = new HashMap();
        this.mHasLifecycleMethods = new HashMap();
    }

    private Method[] getDeclaredMethods(Class<?> r100) {
        return r100.getDeclaredMethods();
    L4:
        e = move-exception;
        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
    }

    public CallbackInfo getInfo(Class<?> r100) {
        CallbackInfo r101 = this.mCallbackMap.get(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        return createInfo(r100, null);
    }

    public boolean hasLifecycleMethods(Class<?> r100) {
        Boolean r101 = this.mHasLifecycleMethods.get(r100);
        if (r101 != null) goto L5;
        Method[] r102 = getDeclaredMethods(r100);
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L13;
        if (((OnLifecycleEvent) r102[r104].getAnnotation(OnLifecycleEvent.class)) != null) goto L10;
        r104 = r104 + 1;
        goto L7
    L10:
        createInfo(r100, r102);
        return true;
    L13:
        this.mHasLifecycleMethods.put(r100, Boolean.FALSE);
        return false;
    L5:
        return r101.booleanValue();
    }

    private CallbackInfo createInfo(Class<?> r110, Method[] r111) {
        Class<?> r100 = r110.getSuperclass();
        HashMap r101 = new HashMap();
        if (r100 == null) goto L7;
        CallbackInfo r102 = getInfo(r100);
        if (r102 == null) goto L7;
        r101.putAll(r102.mHandlerToEvent);
    L7:
        Class<?>[] r103 = r110.getInterfaces();
        int r104 = r103.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L14;
        Iterator<Map.Entry<MethodReference, Lifecycle.Event>> r106 = getInfo(r103[r105]).mHandlerToEvent.entrySet().iterator();
    L11:
        if (r106.hasNext() == false) goto L13;
        Map.Entry<MethodReference, Lifecycle.Event> r107 = r106.next();
        verifyAndPutHandler(r101, r107.getKey(), r107.getValue(), r110);
        goto L11
    L13:
        r105 = r105 + 1;
        goto L8
    L14:
        if (r111 != null) goto L17;
        r111 = getDeclaredMethods(r110);
    L17:
        int r108 = r111.length;
        int r109 = 0;
        boolean r112 = false;
    L18:
        if (r109 >= r108) goto L47;
        Method r113 = r111[r109];
        OnLifecycleEvent r114 = (OnLifecycleEvent) r113.getAnnotation(OnLifecycleEvent.class);
        if (r114 == null) goto L44;
        Class<?>[] r115 = r113.getParameterTypes();
        if (r115.length > 0) goto L25;
        int r116 = 0;
    L30:
        Lifecycle.Event r117 = r114.value();
        if (r115.length <= 1) goto L42;
        if (Lifecycle.Event.class.isAssignableFrom(r115[1]) == false) goto L40;
        if (r117 != Lifecycle.Event.ON_ANY) goto L38;
        r116 = 2;
        goto L42
    L38:
        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
    L40:
        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
    L42:
        if (r115.length > 2) goto L46;
        verifyAndPutHandler(r101, new MethodReference(r116, r113), r117, r110);
        r112 = true;
        goto L44
    L46:
        throw new IllegalArgumentException("cannot have more than 2 params");
    L25:
        if (LifecycleOwner.class.isAssignableFrom(r115[0]) == false) goto L28;
        r116 = 1;
        goto L30
    L28:
        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
    L44:
        r109 = r109 + 1;
        goto L18
    L47:
        CallbackInfo r118 = new CallbackInfo(r101);
        this.mCallbackMap.put(r110, r118);
        this.mHasLifecycleMethods.put(r110, Boolean.valueOf(r112));
        return r118;
    }

    private void verifyAndPutHandler(Map<MethodReference, Lifecycle.Event> r100, MethodReference r101, Lifecycle.Event r102, Class<?> r103) {
        Lifecycle.Event r104 = r100.get(r101);
        if (r104 == null) goto L8;
        if (r102 == r104) goto L8;
        throw new IllegalArgumentException("Method " + r101.mMethod.getName() + " in " + r103.getName() + " already declared with different @OnLifecycleEvent value: previous value " + r104 + ", new value " + r102);
    L8:
        if (r104 != null) goto L11;
        r100.put(r101, r102);
        return;
    }
}
