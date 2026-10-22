package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
final class ClassesInfoCache {
    private static final int CALL_TYPE_NO_ARG = 0;
    private static final int CALL_TYPE_PROVIDER = 1;
    private static final int CALL_TYPE_PROVIDER_WITH_EVENT = 2;
    static ClassesInfoCache sInstance;
    private final Map<Class<?>, CallbackInfo> mCallbackMap;
    private final Map<Class<?>, Boolean> mHasLifecycleMethods;

    @Deprecated
    static class CallbackInfo {
        final Map<Lifecycle.Event, List<MethodReference>> mEventToHandlers;
        final Map<MethodReference, Lifecycle.Event> mHandlerToEvent;

        CallbackInfo(Map<MethodReference, Lifecycle.Event> r5) {
            this.mHandlerToEvent = r5;
            this.mEventToHandlers = new HashMap();
            Iterator<Map.Entry<MethodReference, Lifecycle.Event>> r6 = r5.entrySet().iterator();
        L4:
            if (r6.hasNext() == false) goto L9;
            Map.Entry<MethodReference, Lifecycle.Event> r0 = r6.next();
            Lifecycle.Event r1 = r0.getValue();
            List<MethodReference> r2 = this.mEventToHandlers.get(r1);
            if (r2 != null) goto L8;
            r2 = new ArrayList();
            this.mEventToHandlers.put(r1, r2);
        L8:
            r2.add(r0.getKey());
            goto L4
        }

        void invokeCallbacks(LifecycleOwner r2, Lifecycle.Event r3, Object r4) {
            invokeMethodsForEvent(this.mEventToHandlers.get(r3), r2, r3, r4);
            invokeMethodsForEvent(this.mEventToHandlers.get(Lifecycle.Event.ON_ANY), r2, r3, r4);
        }

        private static void invokeMethodsForEvent(List<MethodReference> r2, LifecycleOwner r3, Lifecycle.Event r4, Object r5) {
            if (r2 == null) goto L6;
            int r0 = r2.size() - 1;
        L4:
            if (r0 < 0) goto L8;
            r2.get(r0).invokeCallback(r3, r4, r5);
            r0 = r0 - 1;
            goto L4
        L8:
            return;
        }
    }

    @Deprecated
    static final class MethodReference {
        final int mCallType;
        final Method mMethod;

        MethodReference(int r1, Method r2) {
            this.mCallType = r1;
            this.mMethod = r2;
            r2.setAccessible(true);
        }

        void invokeCallback(LifecycleOwner r5, Lifecycle.Event r6, Object r7) {
            int r0 = this.mCallType;     // Catch: IllegalAccessException -> L13 InvocationTargetException -> L16
            if (r0 != 0) goto L5;
            this.mMethod.invoke(r7, new Object[0]);     // Catch: IllegalAccessException -> L13 InvocationTargetException -> L16
            return;
        L5:
            if (r0 != 1) goto L7;
            this.mMethod.invoke(r7, new Object[]{r5});     // Catch: IllegalAccessException -> L13 InvocationTargetException -> L16
            return;
        L7:
            if (r0 != 2) goto L20;
            this.mMethod.invoke(r7, new Object[]{r5, r6});     // Catch: IllegalAccessException -> L13 InvocationTargetException -> L16
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

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof MethodReference) == true) goto L8;
            return false;
        L8:
            MethodReference r6 = (MethodReference) r5;
            if (this.mCallType != r6.mCallType) goto L14;
            if (this.mMethod.getName().equals(r6.mMethod.getName()) == false) goto L14;
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            return (this.mCallType * 31) + this.mMethod.getName().hashCode();
        }
    }

    ClassesInfoCache() {
        this.mCallbackMap = new HashMap();
        this.mHasLifecycleMethods = new HashMap();
    }

    static {
        sInstance = new ClassesInfoCache();
    }

    boolean hasLifecycleMethods(Class<?> r7) {
        Boolean r0 = this.mHasLifecycleMethods.get(r7);
        if (r0 != null) goto L5;
        Method[] r1 = getDeclaredMethods(r7);
        int r2 = r1.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L13;
        if (((OnLifecycleEvent) r1[r3].getAnnotation(OnLifecycleEvent.class)) != null) goto L10;
        r3 = r3 + 1;
        goto L7
    L10:
        createInfo(r7, r1);
        return true;
    L13:
        this.mHasLifecycleMethods.put(r7, false);
        return false;
    L5:
        return r0.booleanValue();
    }

    private Method[] getDeclaredMethods(Class<?> r2) {
        return r2.getDeclaredMethods();
    L4:
        e = move-exception;
        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
    }

    CallbackInfo getInfo(Class<?> r2) {
        CallbackInfo r0 = this.mCallbackMap.get(r2);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return createInfo(r2, null);
    }

    private void verifyAndPutHandler(Map<MethodReference, Lifecycle.Event> r3, MethodReference r4, Lifecycle.Event r5, Class<?> r6) {
        Lifecycle.Event r2 = r3.get(r4);
        if (r2 == null) goto L8;
        if (r5 == r2) goto L8;
        throw new IllegalArgumentException("Method " + r4.mMethod.getName() + " in " + r6.getName() + " already declared with different @OnLifecycleEvent value: previous value " + r2 + ", new value " + r5);
    L8:
        if (r2 != null) goto L11;
        r3.put(r4, r5);
        return;
    }

    private CallbackInfo createInfo(Class<?> r12, Method[] r13) {
        Class<? super Object> r0 = r12.getSuperclass();
        HashMap r1 = new HashMap();
        if (r0 == null) goto L7;
        CallbackInfo r2 = getInfo(r0);
        if (r2 == null) goto L7;
        r1.putAll(r2.mHandlerToEvent);
    L7:
        Class<?>[] r3 = r12.getInterfaces();
        int r4 = r3.length;
        int r5 = 0;
    L8:
        if (r5 >= r4) goto L14;
        Iterator<Map.Entry<MethodReference, Lifecycle.Event>> r6 = getInfo(r3[r5]).mHandlerToEvent.entrySet().iterator();
    L11:
        if (r6.hasNext() == false) goto L13;
        Map.Entry<MethodReference, Lifecycle.Event> r7 = r6.next();
        verifyAndPutHandler(r1, r7.getKey(), r7.getValue(), r12);
        goto L11
    L13:
        r5 = r5 + 1;
        goto L8
    L14:
        if (r13 != null) goto L17;
        r13 = getDeclaredMethods(r12);
    L17:
        int r8 = r13.length;
        int r9 = 0;
        boolean r10 = false;
    L18:
        if (r9 >= r8) goto L47;
        Method r11 = r13[r9];
        OnLifecycleEvent r14 = (OnLifecycleEvent) r11.getAnnotation(OnLifecycleEvent.class);
        if (r14 == null) goto L44;
        Class<?>[] r15 = r11.getParameterTypes();
        if (r15.length > 0) goto L25;
        int r16 = 0;
    L30:
        Lifecycle.Event r17 = r14.value();
        if (r15.length <= 1) goto L42;
        if (Lifecycle.Event.class.isAssignableFrom(r15[1]) == false) goto L40;
        if (r17 != Lifecycle.Event.ON_ANY) goto L38;
        r16 = 2;
        goto L42
    L38:
        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
    L40:
        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
    L42:
        if (r15.length > 2) goto L46;
        verifyAndPutHandler(r1, new MethodReference(r16, r11), r17, r12);
        r10 = true;
        goto L44
    L46:
        throw new IllegalArgumentException("cannot have more than 2 params");
    L25:
        if (LifecycleOwner.class.isAssignableFrom(r15[0]) == false) goto L28;
        r16 = 1;
        goto L30
    L28:
        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
    L44:
        r9 = r9 + 1;
        goto L18
    L47:
        CallbackInfo r18 = new CallbackInfo(r1);
        this.mCallbackMap.put(r12, r18);
        this.mHasLifecycleMethods.put(r12, Boolean.valueOf(r10));
        return r18;
    }
}
