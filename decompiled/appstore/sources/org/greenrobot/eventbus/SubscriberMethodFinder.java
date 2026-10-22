package org.greenrobot.eventbus;

import com.bytedance.librarian.LibrarianImpl;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

/* JADX INFO: loaded from: classes4.dex */
class SubscriberMethodFinder {
    private static final int BRIDGE = 64;
    private static final FindState[] FIND_STATE_POOL = null;
    private static final Map<Class<?>, List<SubscriberMethod>> METHOD_CACHE = null;
    private static final int MODIFIERS_IGNORE = 5192;
    private static final int POOL_SIZE = 4;
    private static final int SYNTHETIC = 4096;
    private final boolean ignoreGeneratedIndex;
    private final boolean strictMethodVerification;
    private List<SubscriberInfoIndex> subscriberInfoIndexes;

    public static class FindState {
        final Map<Class, Object> anyMethodByEventType;
        Class<?> clazz;
        final StringBuilder methodKeyBuilder;
        boolean skipSuperClasses;
        Class<?> subscriberClass;
        final Map<String, Class> subscriberClassByMethodKey;
        SubscriberInfo subscriberInfo;
        final List<SubscriberMethod> subscriberMethods;

        public FindState() {
            this.subscriberMethods = new ArrayList();
            this.anyMethodByEventType = new HashMap();
            this.subscriberClassByMethodKey = new HashMap();
            this.methodKeyBuilder = new StringBuilder(128);
        }

        private boolean checkAddWithMethodSignature(Method r10, Class<?> r11) {
            this.methodKeyBuilder.setLength(0);
            this.methodKeyBuilder.append(r10.getName());
            StringBuilder r12 = this.methodKeyBuilder;
            r12.append('>');
            r12.append(r11.getName());
            String r13 = this.methodKeyBuilder.toString();
            Class<?> r14 = r10.getDeclaringClass();
            Class r15 = this.subscriberClassByMethodKey.put(r13, r14);
            if (r15 != null) goto L5;
            return true;
        L5:
            if (r15.isAssignableFrom(r14) == true) goto L11;
            this.subscriberClassByMethodKey.put(r13, r15);
            return false;
        L11:
            return true;
        }

        public boolean checkAdd(Method r10, Class<?> r11) {
            Object r12 = this.anyMethodByEventType.put(r11, r10);
            if (r12 != null) goto L7;
            return true;
        L7:
            if ((r12 instanceof Method) == false) goto L14;
            if (checkAddWithMethodSignature((Method) r12, r11) == false) goto L12;
            this.anyMethodByEventType.put(r11, this);
            goto L14
        L12:
            throw new IllegalStateException();
        L14:
            return checkAddWithMethodSignature(r10, r11);
        }

        public void initForSubscriber(Class<?> r10) {
            this.clazz = r10;
            this.subscriberClass = r10;
            this.skipSuperClasses = false;
            this.subscriberInfo = null;
        }

        public void moveToSuperclass() {
            if (this.skipSuperClasses == false) goto L5;
            this.clazz = null;
            return;
        L5:
            Class<? super Object> r10 = this.clazz.getSuperclass();
            this.clazz = r10;
            String r11 = r10.getName();
            if (r11.startsWith("java.") == false) goto L8;
        L11:
            this.clazz = null;
            return;
        L8:
            if (r11.startsWith("javax.") == true) goto L11;
            if (r11.startsWith("android.") == true) goto L11;
        }

        public void recycle() {
            this.subscriberMethods.clear();
            this.anyMethodByEventType.clear();
            this.subscriberClassByMethodKey.clear();
            this.methodKeyBuilder.setLength(0);
            this.subscriberClass = null;
            this.clazz = null;
            this.skipSuperClasses = false;
            this.subscriberInfo = null;
        }
    }

    static {
        METHOD_CACHE = new ConcurrentHashMap();
        FIND_STATE_POOL = new FindState[4];
    }

    public SubscriberMethodFinder(List<SubscriberInfoIndex> r10, boolean r11, boolean r12) {
        this.subscriberInfoIndexes = r10;
        this.strictMethodVerification = r11;
        this.ignoreGeneratedIndex = r12;
    }

    public static void clearCaches() {
        METHOD_CACHE.clear();
    }

    private List<SubscriberMethod> findUsingInfo(Class<?> r10) {
        FindState r11 = prepareFindState();
        r11.initForSubscriber(r10);
    L4:
        if (r11.clazz == null) goto L16;
        SubscriberInfo r12 = getSubscriberInfo(r11);
        r11.subscriberInfo = r12;
        if (r12 == null) goto L13;
        SubscriberMethod[] r13 = r12.getSubscriberMethods();
        int r14 = r13.length;
        int r15 = 0;
    L8:
        if (r15 >= r14) goto L14;
        SubscriberMethod r16 = r13[r15];
        if (r11.checkAdd(r16.method, r16.eventType) == false) goto L12;
        r11.subscriberMethods.add(r16);
    L12:
        r15 = r15 + 1;
    L14:
        r11.moveToSuperclass();
        goto L4
    L13:
        findUsingReflectionInSingleClass(r11);
        goto L14
    L16:
        return getMethodsAndRelease(r11);
    }

    private List<SubscriberMethod> findUsingReflection(Class<?> r10) {
        FindState r11 = prepareFindState();
        r11.initForSubscriber(r10);
    L4:
        if (r11.clazz == null) goto L7;
        findUsingReflectionInSingleClass(r11);
        r11.moveToSuperclass();
        goto L4
    L7:
        return getMethodsAndRelease(r11);
    }

    private void findUsingReflectionInSingleClass(FindState r15) {
        Method[] r10 = r15.clazz.getDeclaredMethods();     // Catch: Throwable -> L5
    L6:
        int r11 = r10.length;
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L34;
        Method r13 = r10[r12];
        int r14 = r13.getModifiers();
        if ((r14 & 1) == 0) goto L27;
        if ((r14 & MODIFIERS_IGNORE) != 0) goto L27;
        Class<?>[] r16 = r13.getParameterTypes();
        if (r16.length != 1) goto L20;
        Subscribe r17 = (Subscribe) r13.getAnnotation(Subscribe.class);
        if (r17 == null) goto L33;
        Class<?> r18 = r16[0];
        if (r15.checkAdd(r13, r18) == false) goto L33;
        r15.subscriberMethods.add(new SubscriberMethod(r13, r18, r17.threadMode(), r17.priority(), r17.sticky()));
    L33:
        r12 = r12 + 1;
        goto L7
    L20:
        if (this.strictMethodVerification == false) goto L33;
        if (r13.isAnnotationPresent(Subscribe.class) == false) goto L33;
        throw new EventBusException("@Subscribe method " + (r13.getDeclaringClass().getName() + LibrarianImpl.Constants.DOT + r13.getName()) + "must have exactly 1 parameter but has " + r16.length);
    L27:
        if (this.strictMethodVerification == false) goto L33;
        if (r13.isAnnotationPresent(Subscribe.class) == false) goto L33;
        throw new EventBusException((r13.getDeclaringClass().getName() + LibrarianImpl.Constants.DOT + r13.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
    L34:
        return;
    L5:
        r10 = r15.clazz.getMethods();
        r15.skipSuperClasses = true;
        goto L6
    }

    private List<SubscriberMethod> getMethodsAndRelease(FindState r10) {
        ArrayList r11 = new ArrayList(r10.subscriberMethods);
        r10.recycle();
        FindState[] r12 = FIND_STATE_POOL;
        monitor-enter(r12);
        int r13 = 0;
    L6:
        if (r13 >= 4) goto L13;
        FindState[] r14 = FIND_STATE_POOL;     // Catch: Throwable -> L10
        if (r14[r13] == null) goto L9;
        r13 = r13 + 1;     // Catch: Throwable -> L10
        goto L6
    L9:
        r14[r13] = r10;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L13:
        monitor-exit(r12);     // Catch: Throwable -> L10
        return r11;
    }

    private SubscriberInfo getSubscriberInfo(FindState r10) {
        SubscriberInfo r11 = r10.subscriberInfo;
        if (r11 != null) goto L5;
    L9:
        List<SubscriberInfoIndex> r12 = this.subscriberInfoIndexes;
        if (r12 == null) goto L17;
        Iterator<SubscriberInfoIndex> r13 = r12.iterator();
    L13:
        if (r13.hasNext() == false) goto L22;
        SubscriberInfo r14 = r13.next().getSubscriberInfo(r10.clazz);
        if (r14 == null) goto L13;
        return r14;
    L22:
        return null;
    L17:
        return null;
    L5:
        if (r11.getSuperSubscriberInfo() == null) goto L9;
        SubscriberInfo r15 = r10.subscriberInfo.getSuperSubscriberInfo();
        if (r10.clazz != r15.getSubscriberClass()) goto L9;
        return r15;
    }

    private FindState prepareFindState() {
        FindState[] r10 = FIND_STATE_POOL;
        monitor-enter(r10);
        int r11 = 0;
    L6:
        if (r11 >= 4) goto L15;
        FindState[] r12 = FIND_STATE_POOL;     // Catch: Throwable -> L12
        FindState r13 = r12[r11];     // Catch: Throwable -> L12
        if (r13 != null) goto L9;
        r11 = r11 + 1;     // Catch: Throwable -> L12
        goto L6
    L9:
        r12[r11] = null;     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
        return r13;
    L12:
        th = move-exception;
        throw th;
    L15:
        monitor-exit(r10);     // Catch: Throwable -> L12
        return new FindState();
    }

    public List<SubscriberMethod> findSubscriberMethods(Class<?> r10) {
        Map<Class<?>, List<SubscriberMethod>> r11 = METHOD_CACHE;
        List<SubscriberMethod> r12 = r11.get(r10);
        if (r12 == null) goto L6;
        return r12;
    L6:
        if (this.ignoreGeneratedIndex == false) goto L8;
        List<SubscriberMethod> r13 = findUsingReflection(r10);
    L10:
        if (r13.isEmpty() == true) goto L14;
        r11.put(r10, r13);
        return r13;
    L14:
        throw new EventBusException("Subscriber " + r10 + " and its super classes have no public methods with the @Subscribe annotation");
    L8:
        r13 = findUsingInfo(r10);
        goto L10
    }
}
