package org.greenrobot.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

/* JADX INFO: loaded from: classes4.dex */
public class EventBus {
    private static final EventBusBuilder DEFAULT_BUILDER = null;
    public static String TAG = "EventBus";
    static volatile EventBus defaultInstance;
    private static final Map<Class<?>, List<Class<?>>> eventTypesCache = null;
    private final AsyncPoster asyncPoster;
    private final BackgroundPoster backgroundPoster;
    private final ThreadLocal<PostingThreadState> currentPostingThreadState;
    private final boolean eventInheritance;
    private final ExecutorService executorService;
    private final int indexCount;
    private final boolean logNoSubscriberMessages;
    private final boolean logSubscriberExceptions;
    private final Logger logger;
    private final Poster mainThreadPoster;
    private final MainThreadSupport mainThreadSupport;
    private final boolean sendNoSubscriberEvent;
    private final boolean sendSubscriberExceptionEvent;
    private final Map<Class<?>, Object> stickyEvents;
    private final SubscriberMethodFinder subscriberMethodFinder;
    private final Map<Class<?>, CopyOnWriteArrayList<Subscription>> subscriptionsByEventType;
    private final boolean throwSubscriberException;
    private final Map<Object, List<Class<?>>> typesBySubscriber;

    /* JADX INFO: renamed from: org.greenrobot.eventbus.EventBus$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$greenrobot$eventbus$ThreadMode = null;

        static {
            int[] r10 = new int[ThreadMode.values().length];
            $SwitchMap$org$greenrobot$eventbus$ThreadMode = r10;
            r10[ThreadMode.POSTING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$org$greenrobot$eventbus$ThreadMode[ThreadMode.MAIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$org$greenrobot$eventbus$ThreadMode[ThreadMode.MAIN_ORDERED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$org$greenrobot$eventbus$ThreadMode[ThreadMode.BACKGROUND.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$org$greenrobot$eventbus$ThreadMode[ThreadMode.ASYNC.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public interface PostCallback {
        void onPostCompleted(List<SubscriberExceptionEvent> r10);
    }

    public static final class PostingThreadState {
        boolean canceled;
        Object event;
        final List<Object> eventQueue;
        boolean isMainThread;
        boolean isPosting;
        Subscription subscription;

        public PostingThreadState() {
            this.eventQueue = new ArrayList();
        }
    }

    static {
        DEFAULT_BUILDER = new EventBusBuilder();
        eventTypesCache = new HashMap();
    }

    public EventBus() {
        this(DEFAULT_BUILDER);
    }

    public static void addInterfaces(List<Class<?>> r10, Class<?>[] r11) {
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        Class<?> r14 = r11[r13];
        if (r10.contains(r14) == true) goto L7;
        r10.add(r14);
        addInterfaces(r10, r14.getInterfaces());
    L7:
        r13 = r13 + 1;
        goto L3
    }

    public static EventBusBuilder builder() {
        return new EventBusBuilder();
    }

    private void checkPostStickyEventToSubscription(Subscription r10, Object r11) {
        if (r11 == null) goto L5;
        postToSubscription(r10, r11, isMainThread());
        return;
    }

    public static void clearCaches() {
        SubscriberMethodFinder.clearCaches();
        eventTypesCache.clear();
    }

    public static EventBus getDefault() {
        if (defaultInstance != null) goto L16;
        monitor-enter(EventBus.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (defaultInstance != null) goto L11;
        defaultInstance = new EventBus();     // Catch: Throwable -> L9
    L11:
        monitor-exit(EventBus.class);     // Catch: Throwable -> L9
    L16:
        return defaultInstance;
    }

    private void handleSubscriberException(Subscription r10, Object r11, Throwable r12) {
        if ((r11 instanceof SubscriberExceptionEvent) == false) goto L8;
        if (this.logSubscriberExceptions == false) goto L18;
        Logger r13 = this.logger;
        Level r14 = Level.SEVERE;
        r13.log(r14, "SubscriberExceptionEvent subscriber " + r10.subscriber.getClass() + " threw an exception", r12);
        SubscriberExceptionEvent r15 = (SubscriberExceptionEvent) r11;
        this.logger.log(r14, "Initial event " + r15.causingEvent + " caused exception in " + r15.causingSubscriber, r15.throwable);
        return;
    L18:
        return;
    L8:
        if (this.throwSubscriberException == true) goto L17;
        if (this.logSubscriberExceptions == false) goto L13;
        this.logger.log(Level.SEVERE, "Could not dispatch event: " + r11.getClass() + " to subscribing class " + r10.subscriber.getClass(), r12);
    L13:
        if (this.sendSubscriberExceptionEvent == false) goto L20;
        post(new SubscriberExceptionEvent(this, r12, r11, r10.subscriber));
        return;
    L20:
        return;
    L17:
        throw new EventBusException("Invoking subscriber failed", r12);
    }

    private boolean isMainThread() {
        MainThreadSupport r10 = this.mainThreadSupport;
        if (r10 != null) goto L7;
        return true;
    L7:
        return r10.isMainThread();
    }

    private static List<Class<?>> lookupAllEventTypes(Class<?> r10) {
        Map<Class<?>, List<Class<?>>> r11 = eventTypesCache;
        monitor-enter(r11);
        List<Class<?>> r12 = r11.get(r10);     // Catch: Throwable -> L9
        if (r12 != null) goto L12;
        r12 = new ArrayList();     // Catch: Throwable -> L9
        Class<?> r13 = r10;
    L7:
        if (r13 == null) goto L11;
        r12.add(r13);     // Catch: Throwable -> L9
        addInterfaces(r12, r13.getInterfaces());     // Catch: Throwable -> L9
        r13 = r13.getSuperclass();     // Catch: Throwable -> L9
        goto L7
    L11:
        eventTypesCache.put(r10, r12);     // Catch: Throwable -> L9
    L12:
        monitor-exit(r11);     // Catch: Throwable -> L9
        return r12;
    L9:
        th = move-exception;
        throw th;
    }

    private void postSingleEvent(Object r10, PostingThreadState r11) throws Error {
        Class<?> r12 = r10.getClass();
        if (this.eventInheritance == false) goto L7;
        List<Class<?>> r13 = lookupAllEventTypes(r12);
        int r14 = r13.size();
        int r15 = 0;
        boolean r16 = false;
    L5:
        if (r15 >= r14) goto L8;
        r16 = r16 | postSingleEventForEventType(r10, r11, r13.get(r15));
        r15 = r15 + 1;
    L8:
        if (r16 == false) goto L10;
        return;
    L10:
        if (this.logNoSubscriberMessages == false) goto L13;
        this.logger.log(Level.FINE, "No subscribers registered for event " + r12);
    L13:
        if (this.sendNoSubscriberEvent == true) goto L15;
        return;
    L15:
        if (r12 != NoSubscriberEvent.class) goto L17;
        return;
    L17:
        if (r12 == SubscriberExceptionEvent.class) goto L24;
        post(new NoSubscriberEvent(this, r10));
        return;
    L24:
        return;
    L7:
        r16 = postSingleEventForEventType(r10, r11, r12);
        goto L8
    }

    private boolean postSingleEventForEventType(Object r10, PostingThreadState r11, Class<?> r12) {
        monitor-enter(this);
        CopyOnWriteArrayList<Subscription> r13 = this.subscriptionsByEventType.get(r12);     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        if (r13 != null) goto L8;
    L22:
        return false;
    L8:
        if (r13.isEmpty() == true) goto L22;
        Iterator<Subscription> r14 = r13.iterator();
    L11:
        if (r14.hasNext() == false) goto L20;
        Subscription r15 = r14.next();
        r11.event = r10;
        r11.subscription = r15;
        postToSubscription(r15, r10, r11.isMainThread);     // Catch: Throwable -> L17
        boolean r16 = r11.canceled;     // Catch: Throwable -> L17
        r11.event = null;
        r11.subscription = null;
        r11.canceled = false;
        if (r16 == false) goto L11;
        return true;
    L17:
        th = move-exception;
        r11.event = null;
        r11.subscription = null;
        r11.canceled = false;
        throw th;
    L20:
        return true;
    L23:
        th = move-exception;
        throw th;
    }

    private void postToSubscription(Subscription r10, Object r11, boolean r12) {
        int r13 = AnonymousClass2.$SwitchMap$org$greenrobot$eventbus$ThreadMode[r10.subscriberMethod.threadMode.ordinal()];
        if (r13 != 1) goto L5;
        invokeSubscriber(r10, r11);
        return;
    L5:
        if (r13 != 2) goto L7;
        if (r12 == false) goto L24;
        invokeSubscriber(r10, r11);
        return;
    L24:
        this.mainThreadPoster.enqueue(r10, r11);
        return;
    L7:
        if (r13 != 3) goto L9;
        Poster r14 = this.mainThreadPoster;
        if (r14 == null) goto L21;
        r14.enqueue(r10, r11);
        return;
    L21:
        invokeSubscriber(r10, r11);
        return;
    L9:
        if (r13 != 4) goto L11;
        if (r12 == false) goto L17;
        this.backgroundPoster.enqueue(r10, r11);
        return;
    L17:
        invokeSubscriber(r10, r11);
        return;
    L11:
        if (r13 != 5) goto L14;
        this.asyncPoster.enqueue(r10, r11);
        return;
    L14:
        throw new IllegalStateException("Unknown thread mode: " + r10.subscriberMethod.threadMode);
    }

    private void subscribe(Object r10, SubscriberMethod r11) {
        Class<?> r12 = r11.eventType;
        Subscription r13 = new Subscription(r10, r11);
        CopyOnWriteArrayList<Subscription> r14 = this.subscriptionsByEventType.get(r12);
        if (r14 != null) goto L6;
        r14 = new CopyOnWriteArrayList();
        this.subscriptionsByEventType.put(r12, r14);
    L7:
        int r15 = r14.size();
        int r16 = 0;
    L8:
        if (r16 > r15) goto L15;
        if (r16 == r15) goto L14;
        if (r11.priority > r14.get(r16).subscriberMethod.priority) goto L14;
        r16 = r16 + 1;
    L14:
        r14.add(r16, r13);
    L15:
        List<Class<?>> r17 = this.typesBySubscriber.get(r10);
        if (r17 != null) goto L18;
        r17 = new ArrayList();
        this.typesBySubscriber.put(r10, r17);
    L18:
        r17.add(r12);
        if (r11.sticky == true) goto L21;
        return;
    L21:
        if (this.eventInheritance == false) goto L28;
        Iterator<Map.Entry<Class<?>, Object>> r18 = this.stickyEvents.entrySet().iterator();
    L24:
        if (r18.hasNext() == false) goto L41;
        Map.Entry<Class<?>, Object> r19 = r18.next();
        if (r12.isAssignableFrom(r19.getKey()) == false) goto L24;
        checkPostStickyEventToSubscription(r13, r19.getValue());
        goto L24
    L41:
        return;
    L28:
        checkPostStickyEventToSubscription(r13, this.stickyEvents.get(r12));
        return;
    L6:
        if (r14.contains(r13) == false) goto L7;
        throw new EventBusException("Subscriber " + r10.getClass() + " already registered to event " + r12);
    }

    private void unsubscribeByEventType(Object r10, Class<?> r11) {
        CopyOnWriteArrayList<Subscription> r12 = this.subscriptionsByEventType.get(r11);
        if (r12 == null) goto L10;
        int r13 = r12.size();
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L14;
        Subscription r15 = r12.get(r14);
        if (r15.subscriber != r10) goto L9;
        r15.active = false;
        r12.remove(r14);
        r14 = r14 - 1;
        r13 = r13 - 1;
    L9:
        r14 = r14 + 1;
        goto L5
    L14:
        return;
    }

    public void cancelEventDelivery(Object r10) {
        PostingThreadState r11 = this.currentPostingThreadState.get();
        if (r11.isPosting == false) goto L18;
        if (r10 == null) goto L16;
        if (r11.event != r10) goto L14;
        if (r11.subscription.subscriberMethod.threadMode != ThreadMode.POSTING) goto L12;
        r11.canceled = true;
        return;
    L12:
        throw new EventBusException(" event handlers may only abort the incoming event");
    L14:
        throw new EventBusException("Only the currently handled event may be aborted");
    L16:
        throw new EventBusException("Event may not be null");
    L18:
        throw new EventBusException("This method may only be called from inside event handling methods on the posting thread");
    }

    public ExecutorService getExecutorService() {
        return this.executorService;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public <T> T getStickyEvent(Class<T> r10) {
        Map<Class<?>, Object> r11 = this.stickyEvents;
        monitor-enter(r11);
        T r12 = r10.cast(this.stickyEvents.get(r10));     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean hasSubscriberForEvent(Class<?> r10) {
        List<Class<?>> r11 = lookupAllEventTypes(r10);
        if (r11 == null) goto L19;
        int r12 = r11.size();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L19;
        Class<?> r14 = r11.get(r13);
        monitor-enter(this);
        CopyOnWriteArrayList<Subscription> r15 = this.subscriptionsByEventType.get(r14);     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        if (r15 == null) goto L15;
        if (r15.isEmpty() == true) goto L15;
        return true;
    L15:
        r13 = r13 + 1;
    L16:
        th = move-exception;
        throw th;
    L19:
        return false;
    }

    public void invokeSubscriber(PendingPost r10) {
        Object r11 = r10.event;
        Subscription r12 = r10.subscription;
        PendingPost.releasePendingPost(r10);
        if (r12.active == false) goto L6;
        invokeSubscriber(r12, r11);
        return;
    }

    public synchronized boolean isRegistered(Object r10) {
        monitor-enter(this);
        boolean r11 = this.typesBySubscriber.containsKey(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    public void post(Object r10) {
        PostingThreadState r11 = this.currentPostingThreadState.get();
        List<Object> r12 = r11.eventQueue;
        r12.add(r10);
        if (r11.isPosting == true) goto L18;
        r11.isMainThread = isMainThread();
        r11.isPosting = true;
        if (r11.canceled == true) goto L17;
    L19:
    L11:
        th = move-exception;
        r11.isPosting = false;
        r11.isMainThread = false;
        throw th;
    L8:
        if (r12.isEmpty() == true) goto L13;
        postSingleEvent(r12.remove(0), r11);     // Catch: Throwable -> L11
        goto L19
    L13:
        r11.isPosting = false;
        r11.isMainThread = false;
        return;
    L17:
        throw new EventBusException("Internal error. Abort state was not reset");
    }

    public void postSticky(Object r10) {
        Map<Class<?>, Object> r11 = this.stickyEvents;
        monitor-enter(r11);
        this.stickyEvents.put(r10.getClass(), r10);     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
        post(r10);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void register(Object r10) {
        Class<?> r11 = r10.getClass();
        List<SubscriberMethod> r12 = this.subscriberMethodFinder.findSubscriberMethods(r11);
        monitor-enter(this);
        Iterator<SubscriberMethod> r13 = r12.iterator();     // Catch: Throwable -> L8
    L6:
        if (r13.hasNext() == false) goto L10;
        subscribe(r10, r13.next());     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void removeAllStickyEvents() {
        Map<Class<?>, Object> r10 = this.stickyEvents;
        monitor-enter(r10);
        this.stickyEvents.clear();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public <T> T removeStickyEvent(Class<T> r10) {
        Map<Class<?>, Object> r11 = this.stickyEvents;
        monitor-enter(r11);
        T r12 = r10.cast(this.stickyEvents.remove(r10));     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public String toString() {
        return "EventBus[indexCount=" + this.indexCount + ", eventInheritance=" + this.eventInheritance + "]";
    }

    public synchronized void unregister(Object r10) {
        monitor-enter(this);
        List<Class<?>> r11 = this.typesBySubscriber.get(r10);     // Catch: Throwable -> L9
        if (r11 == null) goto L12;
        Iterator<Class<?>> r12 = r11.iterator();     // Catch: Throwable -> L9
    L7:
        if (r12.hasNext() == false) goto L11;
        unsubscribeByEventType(r10, r12.next());     // Catch: Throwable -> L9
        goto L7
    L11:
        this.typesBySubscriber.remove(r10);     // Catch: Throwable -> L9
    L13:
        monitor-exit(this);
        return;
    L12:
        this.logger.log(Level.WARNING, "Subscriber to unregister was not registered before: " + r10.getClass());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public EventBus(EventBusBuilder r10) {
        this.currentPostingThreadState = new AnonymousClass1(this);
        this.logger = r10.getLogger();
        this.subscriptionsByEventType = new HashMap();
        this.typesBySubscriber = new HashMap();
        this.stickyEvents = new ConcurrentHashMap();
        MainThreadSupport r11 = r10.getMainThreadSupport();
        this.mainThreadSupport = r11;
        if (r11 == null) goto L5;
        Poster r12 = r11.createPoster(this);
    L6:
        this.mainThreadPoster = r12;
        this.backgroundPoster = new BackgroundPoster(this);
        this.asyncPoster = new AsyncPoster(this);
        List<SubscriberInfoIndex> r13 = r10.subscriberInfoIndexes;
        if (r13 == null) goto L9;
        int r14 = r13.size();
    L10:
        this.indexCount = r14;
        this.subscriberMethodFinder = new SubscriberMethodFinder(r10.subscriberInfoIndexes, r10.strictMethodVerification, r10.ignoreGeneratedIndex);
        this.logSubscriberExceptions = r10.logSubscriberExceptions;
        this.logNoSubscriberMessages = r10.logNoSubscriberMessages;
        this.sendSubscriberExceptionEvent = r10.sendSubscriberExceptionEvent;
        this.sendNoSubscriberEvent = r10.sendNoSubscriberEvent;
        this.throwSubscriberException = r10.throwSubscriberException;
        this.eventInheritance = r10.eventInheritance;
        this.executorService = r10.executorService;
        return;
    L9:
        r14 = 0;
        goto L10
    L5:
        r12 = null;
        goto L6
    }

    public boolean removeStickyEvent(Object r10) {
        Map<Class<?>, Object> r11 = this.stickyEvents;
        monitor-enter(r11);
        Class<?> r12 = r10.getClass();     // Catch: Throwable -> L10
        if (r10.equals(this.stickyEvents.get(r12)) == false) goto L12;
        this.stickyEvents.remove(r12);     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
        return true;
    L12:
        monitor-exit(r11);     // Catch: Throwable -> L10
        return false;
    L10:
        th = move-exception;
        throw th;
    }

    public void invokeSubscriber(Subscription r10, Object r11) {
        r10.subscriberMethod.method.invoke(r10.subscriber, new Object[]{r11});     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L6
    L14:
        return;
    L4:
        e = move-exception;
        throw new IllegalStateException("Unexpected exception", e);
    L6:
        e = move-exception;
        handleSubscriberException(r10, r11, e.getCause());
    }
}
