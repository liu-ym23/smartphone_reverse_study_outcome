package com.android.server.location.listeners;

import android.util.ArrayMap;
import android.util.ArraySet;
import com.android.internal.listeners.ListenerExecutor;
import com.android.internal.util.Preconditions;
import com.android.server.location.listeners.ListenerRegistration;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ListenerMultiplexer<TKey, TListener, TRegistration extends ListenerRegistration<TListener>, TMergedRegistration> {
    private int mActiveRegistrationsCount;
    private TMergedRegistration mMerged;
    protected final Object mMultiplexerLock;
    private final ListenerMultiplexer<TKey, TListener, TRegistration, TMergedRegistration>.ReentrancyGuard mReentrancyGuard;
    private final ArrayMap<TKey, TRegistration> mRegistrations;
    private boolean mServiceRegistered;
    private final ListenerMultiplexer<TKey, TListener, TRegistration, TMergedRegistration>.UpdateServiceBuffer mUpdateServiceBuffer;

    private final class ReentrancyGuard implements AutoCloseable {
        private int mGuardCount;
        private ArraySet<Map.Entry<TKey, ListenerRegistration<?>>> mScheduledRemovals;
        final /* synthetic */ ListenerMultiplexer this$0;

        ReentrancyGuard(ListenerMultiplexer r1) {
            this.this$0 = r1;
            this.mGuardCount = 0;
            this.mScheduledRemovals = null;
        }

        boolean isReentrant() {
            Object r0 = this.this$0.mMultiplexerLock;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.mGuardCount == 0) goto L7;
            boolean r1 = true;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L7:
            r1 = false;
            goto L8
        }

        void markForRemoval(TKey key, ListenerRegistration<?> registration) {
            Object r0 = this.this$0.mMultiplexerLock;
            monitor-enter(r0);
            Preconditions.checkState(isReentrant());     // Catch: Throwable -> L7
            if (this.mScheduledRemovals != null) goto L9;
            this.mScheduledRemovals = new ArraySet(ListenerMultiplexer.m5380$$Nest$fgetmRegistrations(this.this$0).size());     // Catch: Throwable -> L7
        L9:
            this.mScheduledRemovals.add(new AbstractMap.SimpleImmutableEntry(key, registration));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        ListenerMultiplexer<TKey, TListener, TRegistration, TMergedRegistration>.ReentrancyGuard acquire() {
            Object r0 = this.this$0.mMultiplexerLock;
            monitor-enter(r0);
            this.mGuardCount++;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            Object r0 = this.this$0.mMultiplexerLock;
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.mGuardCount <= 0) goto L7;
            boolean r1 = true;
        L8:
            Preconditions.checkState(r1);     // Catch: Throwable -> L11
            ArraySet<Map.Entry<TKey, ListenerRegistration<?>>> scheduledRemovals = null;
            int r3 = this.mGuardCount - 1;     // Catch: Throwable -> L11
            this.mGuardCount = r3;     // Catch: Throwable -> L11
            if (r3 != 0) goto L13;
            scheduledRemovals = this.mScheduledRemovals;     // Catch: Throwable -> L11
            this.mScheduledRemovals = null;     // Catch: Throwable -> L11
        L13:
            if (scheduledRemovals != null) goto L16;
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L16:
            ListenerMultiplexer<TKey, TListener, TRegistration, TMergedRegistration>.UpdateServiceBuffer ignored = ListenerMultiplexer.m5381$$Nest$fgetmUpdateServiceBuffer(this.this$0).acquire();     // Catch: Throwable -> L11
            int size = scheduledRemovals.size();     // Catch: Throwable -> L21
            int i = 0;
        L18:
            if (i >= size) goto L24;
            Map.Entry<TKey, ListenerRegistration<?>> entry = scheduledRemovals.valueAt(i);     // Catch: Throwable -> L21
            this.this$0.removeRegistration(entry.getKey(), entry.getValue());     // Catch: Throwable -> L21
            i = i + 1;
            goto L18
        L24:
            if (ignored == null) goto L26;
            ignored.close();     // Catch: Throwable -> L11
        L26:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L21:
            th = move-exception;
            if (ignored != null) goto L37;
        L34:
            throw th;     // Catch: Throwable -> L11
        L37:
            ignored.close();     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L11
            goto L34
        L7:
            r1 = false;
            goto L8
        }
    }

    private final class UpdateServiceBuffer implements AutoCloseable {
        private int mBufferCount;
        private boolean mUpdateServiceRequired;
        final /* synthetic */ ListenerMultiplexer this$0;

        UpdateServiceBuffer(ListenerMultiplexer r1) {
            this.this$0 = r1;
            this.mBufferCount = 0;
            this.mUpdateServiceRequired = false;
        }

        synchronized boolean isBuffered() {
            monitor-enter(this);
            if (this.mBufferCount == 0) goto L6;
            boolean r0 = true;
        L7:
            monitor-exit(this);
            return r0;
        L6:
            r0 = false;
        L9:
            th = move-exception;
            throw th;
        }

        synchronized void markUpdateServiceRequired() {
            monitor-enter(this);
            Preconditions.checkState(isBuffered());     // Catch: Throwable -> L6
            this.mUpdateServiceRequired = true;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized ListenerMultiplexer<TKey, TListener, TRegistration, TMergedRegistration>.UpdateServiceBuffer acquire() {
            monitor-enter(this);
            this.mBufferCount++;     // Catch: Throwable -> L6
            monitor-exit(this);
            return this;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            boolean updateServiceRequired = false;
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.mBufferCount <= 0) goto L7;
            boolean r1 = true;
        L8:
            Preconditions.checkState(r1);     // Catch: Throwable -> L11
            int r2 = this.mBufferCount - 1;     // Catch: Throwable -> L11
            this.mBufferCount = r2;     // Catch: Throwable -> L11
            if (r2 != 0) goto L13;
            updateServiceRequired = this.mUpdateServiceRequired;     // Catch: Throwable -> L11
            this.mUpdateServiceRequired = false;     // Catch: Throwable -> L11
        L13:
            monitor-exit(this);     // Catch: Throwable -> L11
            if (updateServiceRequired == false) goto L21;
            this.this$0.updateService();
            return;
        L21:
            return;
        L7:
            r1 = false;
            goto L8
        }
    }

    public static final class UpdateServiceLock implements AutoCloseable {
        private ListenerMultiplexer<?, ?, ?, ?>.UpdateServiceBuffer mUpdateServiceBuffer;

        UpdateServiceLock(ListenerMultiplexer<?, ?, ?, ?>.UpdateServiceBuffer updateServiceBuffer) {
            this.mUpdateServiceBuffer = updateServiceBuffer.acquire();
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            if (this.mUpdateServiceBuffer == null) goto L6;
            ListenerMultiplexer<?, ?, ?, ?>.UpdateServiceBuffer buffer = this.mUpdateServiceBuffer;
            this.mUpdateServiceBuffer = null;
            buffer.close();
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRegistrations, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m5380$$Nest$fgetmRegistrations(ListenerMultiplexer r0) {
        return r0.mRegistrations;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUpdateServiceBuffer, reason: not valid java name */
    static /* bridge */ /* synthetic */ UpdateServiceBuffer m5381$$Nest$fgetmUpdateServiceBuffer(ListenerMultiplexer r0) {
        return r0.mUpdateServiceBuffer;
    }

    protected abstract boolean isActive(TRegistration r1);

    protected abstract TMergedRegistration mergeRegistrations(Collection<TRegistration> r1);

    protected abstract boolean registerWithService(TMergedRegistration r1, Collection<TRegistration> r2);

    protected abstract void unregisterWithService();

    public ListenerMultiplexer() {
        this.mMultiplexerLock = new Object();
        this.mRegistrations = new ArrayMap();
        this.mUpdateServiceBuffer = new UpdateServiceBuffer(this);
        this.mReentrancyGuard = new ReentrancyGuard(this);
        this.mActiveRegistrationsCount = 0;
        this.mServiceRegistered = false;
    }

    protected boolean reregisterWithService(TMergedRegistration oldMerged, TMergedRegistration newMerged, Collection<TRegistration> registrations) {
        return registerWithService(newMerged, registrations);
    }

    protected void onRegister() {
    }

    protected void onUnregister() {
    }

    protected void onRegistrationAdded(TKey key, TRegistration registration) {
    }

    protected void onRegistrationReplaced(TKey oldKey, TRegistration oldRegistration, TKey newKey, TRegistration newRegistration) {
        onRegistrationRemoved(oldKey, oldRegistration);
        onRegistrationAdded(newKey, newRegistration);
    }

    protected void onRegistrationRemoved(TKey key, TRegistration registration) {
    }

    protected void onActive() {
    }

    protected void onInactive() {
    }

    protected final void putRegistration(TKey key, TRegistration registration) {
        replaceRegistration(key, key, registration);
    }

    protected final void replaceRegistration(TKey oldKey, TKey key, TRegistration registration) {
        oldKey.getClass();
        key.getClass();
        registration.getClass();
        Object r0 = this.mMultiplexerLock;
        monitor-enter(r0);
        boolean r2 = false;
        if (this.mReentrancyGuard.isReentrant() == true) goto L7;
        boolean r1 = true;
    L8:
        Preconditions.checkState(r1);     // Catch: Throwable -> L13
        if (oldKey == key) goto L15;
        if (this.mRegistrations.containsKey(key) == false) goto L15;
    L16:
        Preconditions.checkArgument(r2);     // Catch: Throwable -> L13
        ListenerMultiplexer<TKey, TListener, TRegistration, TMergedRegistration>.UpdateServiceBuffer ignored1 = this.mUpdateServiceBuffer.acquire();     // Catch: Throwable -> L13
        ListenerMultiplexer<TKey, TListener, TRegistration, TMergedRegistration>.ReentrancyGuard ignored2 = this.mReentrancyGuard.acquire();     // Catch: Throwable -> L39
        boolean wasEmpty = this.mRegistrations.isEmpty();     // Catch: Throwable -> L23
        TRegistration oldRegistration = null;
        int oldIndex = this.mRegistrations.indexOfKey(oldKey);     // Catch: Throwable -> L23
        if (oldIndex < 0) goto L25;
        oldRegistration = this.mRegistrations.valueAt(oldIndex);     // Catch: Throwable -> L23
        unregister(oldRegistration);     // Catch: Throwable -> L23
        oldRegistration.onUnregister();     // Catch: Throwable -> L23
        if (oldKey == key) goto L25;
        this.mRegistrations.removeAt(oldIndex);     // Catch: Throwable -> L23
    L25:
        if (oldKey != key) goto L28;
        if (oldIndex < 0) goto L28;
        this.mRegistrations.setValueAt(oldIndex, registration);     // Catch: Throwable -> L23
    L29:
        if (wasEmpty == false) goto L31;
        onRegister();     // Catch: Throwable -> L23
    L31:
        registration.onRegister(key);     // Catch: Throwable -> L23
        if (oldRegistration != null) goto L34;
        onRegistrationAdded(key, registration);     // Catch: Throwable -> L23
    L35:
        onRegistrationActiveChanged(registration);     // Catch: Throwable -> L23
        if (ignored2 == null) goto L41;
        ignored2.close();     // Catch: Throwable -> L39
    L41:
        if (ignored1 == null) goto L43;
        ignored1.close();     // Catch: Throwable -> L13
    L43:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L34:
        onRegistrationReplaced(oldKey, oldRegistration, key, registration);     // Catch: Throwable -> L23
    L28:
        this.mRegistrations.put(key, registration);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        if (ignored2 != null) goto L65;
    L50:
        throw th;     // Catch: Throwable -> L39
    L65:
        ignored2.close();     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        if (ignored1 != null) goto L62;
    L57:
        throw th;     // Catch: Throwable -> L13
    L62:
        ignored1.close();     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L13
    L15:
        r2 = true;
        goto L16
    L7:
        r1 = false;
    L13:
        th = move-exception;
        throw th;
    }

    protected final void removeRegistrationIf(Predicate<TKey> predicate) {
        Object r0 = this.mMultiplexerLock;
        monitor-enter(r0);
    L27:
        th = move-exception;
        throw th;
    L5:
        if (this.mReentrancyGuard.isReentrant() == true) goto L7;
        boolean r1 = true;
    L8:
        Preconditions.checkState(r1);     // Catch: Throwable -> L27
        ListenerMultiplexer<TKey, TListener, TRegistration, TMergedRegistration>.UpdateServiceBuffer ignored1 = this.mUpdateServiceBuffer.acquire();     // Catch: Throwable -> L27
        ListenerMultiplexer<TKey, TListener, TRegistration, TMergedRegistration>.ReentrancyGuard ignored2 = this.mReentrancyGuard.acquire();     // Catch: Throwable -> L23
        int size = this.mRegistrations.size();     // Catch: Throwable -> L16
        int i = 0;
    L11:
        if (i >= size) goto L20;
        TKey key = this.mRegistrations.keyAt(i);     // Catch: Throwable -> L16
        if (predicate.test(key) == false) goto L18;
        removeRegistration(key, this.mRegistrations.valueAt(i));     // Catch: Throwable -> L16
    L18:
        i = i + 1;
        goto L11
    L20:
        if (ignored2 == null) goto L25;
        ignored2.close();     // Catch: Throwable -> L23
    L25:
        if (ignored1 == null) goto L29;
        ignored1.close();     // Catch: Throwable -> L27
    L29:
        monitor-exit(r0);     // Catch: Throwable -> L27
        return;
    L16:
        th = move-exception;
        if (ignored2 != null) goto L50;
    L36:
        throw th;     // Catch: Throwable -> L23
    L50:
        ignored2.close();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        if (ignored1 != null) goto L47;
    L43:
        throw th;     // Catch: Throwable -> L27
    L47:
        ignored1.close();     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L27
        goto L43
    L7:
        r1 = false;
        goto L8
    }

    protected final void removeRegistration(TKey key) {
        Object r0 = this.mMultiplexerLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mReentrancyGuard.isReentrant() == true) goto L7;
        boolean r1 = true;
    L8:
        Preconditions.checkState(r1);     // Catch: Throwable -> L12
        int index = this.mRegistrations.indexOfKey(key);     // Catch: Throwable -> L12
        if (index >= 0) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L14:
        removeRegistration(index);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L7:
        r1 = false;
        goto L8
    }

    protected final void removeRegistration(TKey key, ListenerRegistration<?> registration) {
        Object r0 = this.mMultiplexerLock;
        monitor-enter(r0);
        int index = this.mRegistrations.indexOfKey(key);     // Catch: Throwable -> L8
        if (index >= 0) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        TRegistration r2 = this.mRegistrations.valueAt(index);     // Catch: Throwable -> L8
        if (r2 == registration) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L15:
        if (this.mReentrancyGuard.isReentrant() == false) goto L17;
        unregister(r2);     // Catch: Throwable -> L8
        this.mReentrancyGuard.markForRemoval(key, r2);     // Catch: Throwable -> L8
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L17:
        removeRegistration(index);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    private void removeRegistration(int index) {
        TKey key = this.mRegistrations.keyAt(index);
        TRegistration registration = this.mRegistrations.valueAt(index);
        ListenerMultiplexer<TKey, TListener, TRegistration, TMergedRegistration>.UpdateServiceBuffer ignored1 = this.mUpdateServiceBuffer.acquire();
        ListenerMultiplexer<TKey, TListener, TRegistration, TMergedRegistration>.ReentrancyGuard ignored2 = this.mReentrancyGuard.acquire();     // Catch: Throwable -> L13
        unregister(registration);     // Catch: Throwable -> L8
        onRegistrationRemoved(key, registration);     // Catch: Throwable -> L8
        registration.onUnregister();     // Catch: Throwable -> L8
        this.mRegistrations.removeAt(index);     // Catch: Throwable -> L8
        if (this.mRegistrations.isEmpty() == false) goto L10;
        onUnregister();     // Catch: Throwable -> L8
    L10:
        if (ignored2 == null) goto L15;
        ignored2.close();     // Catch: Throwable -> L13
    L15:
        if (ignored1 == null) goto L37;
        ignored1.close();
        return;
    L37:
        return;
    L8:
        th = move-exception;
        if (ignored2 != null) goto L34;
    L23:
        throw th;     // Catch: Throwable -> L13
    L34:
        ignored2.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        if (ignored1 != null) goto L32;
    L29:
        throw th;
    L32:
        ignored1.close();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.addSuppressed(th);
        goto L29
    }

    protected final void updateService() {
        Object r0 = this.mMultiplexerLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mUpdateServiceBuffer.isBuffered() == false) goto L11;
        this.mUpdateServiceBuffer.markUpdateServiceRequired();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        int size = this.mRegistrations.size();     // Catch: Throwable -> L9
        ArrayList<TRegistration> actives = new ArrayList(size);     // Catch: Throwable -> L9
        int i = 0;
    L12:
        if (i >= size) goto L17;
        TRegistration registration = this.mRegistrations.valueAt(i);     // Catch: Throwable -> L9
        if (registration.isActive() == false) goto L16;
        actives.add(registration);     // Catch: Throwable -> L9
    L16:
        i = i + 1;     // Catch: Throwable -> L9
        goto L12
    L17:
        TMergedRegistration r4 = null;
        if (actives.isEmpty() == true) goto L20;
        TMergedRegistration merged = mergeRegistrations(actives);     // Catch: Throwable -> L9
        if (this.mServiceRegistered == true) goto L25;
        this.mServiceRegistered = registerWithService(merged, actives);     // Catch: Throwable -> L9
        if (this.mServiceRegistered == false) goto L33;
        r4 = merged;
    L33:
        this.mMerged = r4;     // Catch: Throwable -> L9
    L34:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L25:
        if (Objects.equals(merged, this.mMerged) == true) goto L34;
        this.mServiceRegistered = reregisterWithService(this.mMerged, merged, actives);     // Catch: Throwable -> L9
        if (this.mServiceRegistered == false) goto L29;
        r4 = merged;
    L29:
        this.mMerged = r4;     // Catch: Throwable -> L9
        goto L34
    L20:
        if (this.mServiceRegistered == false) goto L34;
        this.mMerged = null;     // Catch: Throwable -> L9
        this.mServiceRegistered = false;     // Catch: Throwable -> L9
        unregisterWithService();     // Catch: Throwable -> L9
        goto L34
    }

    protected final void resetService() {
        Object r0 = this.mMultiplexerLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mServiceRegistered == false) goto L9;
        this.mMerged = null;     // Catch: Throwable -> L7
        this.mServiceRegistered = false;     // Catch: Throwable -> L7
        unregisterWithService();     // Catch: Throwable -> L7
        updateService();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public UpdateServiceLock newUpdateServiceLock() {
        return new UpdateServiceLock(this.mUpdateServiceBuffer);
    }

    protected final boolean findRegistration(Predicate<TRegistration> predicate) {
        Object r0 = this.mMultiplexerLock;
        monitor-enter(r0);
        ListenerMultiplexer<TKey, TListener, TRegistration, TMergedRegistration>.ReentrancyGuard ignored = this.mReentrancyGuard.acquire();     // Catch: Throwable -> L11
        int size = this.mRegistrations.size();     // Catch: Throwable -> L17
        int i = 0;
    L6:
        if (i >= size) goto L20;
        TRegistration registration = this.mRegistrations.valueAt(i);     // Catch: Throwable -> L17
        if (predicate.test(registration) == true) goto L9;
        i = i + 1;     // Catch: Throwable -> L11
        goto L6
    L9:
        if (ignored == null) goto L13;
        ignored.close();     // Catch: Throwable -> L11
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return true;
    L20:
        if (ignored == null) goto L22;
        ignored.close();     // Catch: Throwable -> L11
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return false;
    L17:
        th = move-exception;
        if (ignored != null) goto L36;
    L31:
        throw th;     // Catch: Throwable -> L11
    L36:
        ignored.close();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    protected final void updateRegistrations(Predicate<TRegistration> predicate) {
        Object r0 = this.mMultiplexerLock;
        monitor-enter(r0);
        ListenerMultiplexer<TKey, TListener, TRegistration, TMergedRegistration>.UpdateServiceBuffer ignored1 = this.mUpdateServiceBuffer.acquire();     // Catch: Throwable -> L23
        ListenerMultiplexer<TKey, TListener, TRegistration, TMergedRegistration>.ReentrancyGuard ignored2 = this.mReentrancyGuard.acquire();     // Catch: Throwable -> L19
        int size = this.mRegistrations.size();     // Catch: Throwable -> L12
        int i = 0;
    L7:
        if (i >= size) goto L16;
        TRegistration registration = this.mRegistrations.valueAt(i);     // Catch: Throwable -> L12
        if (predicate.test(registration) == false) goto L14;
        onRegistrationActiveChanged(registration);     // Catch: Throwable -> L12
    L14:
        i = i + 1;
        goto L7
    L16:
        if (ignored2 == null) goto L21;
        ignored2.close();     // Catch: Throwable -> L19
    L21:
        if (ignored1 == null) goto L25;
        ignored1.close();     // Catch: Throwable -> L23
    L25:
        monitor-exit(r0);     // Catch: Throwable -> L23
        return;
    L12:
        th = move-exception;
        if (ignored2 != null) goto L45;
    L32:
        throw th;     // Catch: Throwable -> L19
    L45:
        ignored2.close();     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        if (ignored1 != null) goto L42;
    L39:
        throw th;     // Catch: Throwable -> L23
    L42:
        ignored1.close();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    protected final boolean updateRegistration(Object key, Predicate<TRegistration> predicate) {
        Object r0 = this.mMultiplexerLock;
        monitor-enter(r0);
        ListenerMultiplexer<TKey, TListener, TRegistration, TMergedRegistration>.UpdateServiceBuffer ignored1 = this.mUpdateServiceBuffer.acquire();     // Catch: Throwable -> L15
        ListenerMultiplexer<TKey, TListener, TRegistration, TMergedRegistration>.ReentrancyGuard ignored2 = this.mReentrancyGuard.acquire();     // Catch: Throwable -> L11
        int index = this.mRegistrations.indexOfKey(key);     // Catch: Throwable -> L24
        if (index >= 0) goto L20;
        if (ignored2 == null) goto L13;
        ignored2.close();     // Catch: Throwable -> L11
    L13:
        if (ignored1 == null) goto L17;
        ignored1.close();     // Catch: Throwable -> L15
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return false;
    L20:
        TRegistration registration = this.mRegistrations.valueAt(index);     // Catch: Throwable -> L24
        if (predicate.test(registration) == false) goto L27;
        onRegistrationActiveChanged(registration);     // Catch: Throwable -> L24
    L27:
        if (ignored2 == null) goto L29;
        ignored2.close();     // Catch: Throwable -> L11
    L29:
        if (ignored1 == null) goto L31;
        ignored1.close();     // Catch: Throwable -> L15
    L31:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return true;
    L24:
        th = move-exception;
        if (ignored2 != null) goto L49;
    L39:
        throw th;     // Catch: Throwable -> L11
    L49:
        ignored2.close();     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (ignored1 != null) goto L54;
    L46:
        throw th;     // Catch: Throwable -> L15
    L54:
        ignored1.close();     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    private void onRegistrationActiveChanged(TRegistration registration) {
        if (registration.isRegistered() == true) goto L5;
    L7:
        boolean active = false;
    L8:
        boolean changed = registration.setActive(active);
        if (changed == false) goto L20;
        if (active == false) goto L15;
        int r3 = this.mActiveRegistrationsCount + 1;
        this.mActiveRegistrationsCount = r3;
        if (r3 != 1) goto L14;
        onActive();
    L14:
        registration.onActive();
    L18:
        updateService();
        return;
    L15:
        registration.onInactive();
        int r4 = this.mActiveRegistrationsCount - 1;
        this.mActiveRegistrationsCount = r4;
        if (r4 != 0) goto L18;
        onInactive();
        goto L18
    L20:
        return;
    L5:
        if (isActive(registration) == false) goto L7;
        active = true;
        goto L8
    }

    protected final void deliverToListeners(Function<TRegistration, ListenerExecutor.ListenerOperation<TListener>> function) {
        Object r0 = this.mMultiplexerLock;
        monitor-enter(r0);
        ListenerMultiplexer<TKey, TListener, TRegistration, TMergedRegistration>.ReentrancyGuard ignored = this.mReentrancyGuard.acquire();     // Catch: Throwable -> L19
        int size = this.mRegistrations.size();     // Catch: Throwable -> L13
        int i = 0;
    L6:
        if (i >= size) goto L17;
        TRegistration registration = this.mRegistrations.valueAt(i);     // Catch: Throwable -> L13
        if (registration.isActive() == false) goto L15;
        ListenerExecutor.ListenerOperation<TListener> operation = function.apply(registration);     // Catch: Throwable -> L13
        if (operation == null) goto L15;
        registration.executeOperation(operation);     // Catch: Throwable -> L13
    L15:
        i = i + 1;
        goto L6
    L17:
        if (ignored == null) goto L21;
        ignored.close();     // Catch: Throwable -> L19
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L13:
        th = move-exception;
        if (ignored != null) goto L32;
    L29:
        throw th;     // Catch: Throwable -> L19
    L32:
        ignored.close();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    protected final void deliverToListeners(ListenerExecutor.ListenerOperation<TListener> operation) {
        Object r0 = this.mMultiplexerLock;
        monitor-enter(r0);
        ListenerMultiplexer<TKey, TListener, TRegistration, TMergedRegistration>.ReentrancyGuard ignored = this.mReentrancyGuard.acquire();     // Catch: Throwable -> L17
        int size = this.mRegistrations.size();     // Catch: Throwable -> L11
        int i = 0;
    L6:
        if (i >= size) goto L15;
        TRegistration registration = this.mRegistrations.valueAt(i);     // Catch: Throwable -> L11
        if (registration.isActive() == false) goto L13;
        registration.executeOperation(operation);     // Catch: Throwable -> L11
    L13:
        i = i + 1;
        goto L6
    L15:
        if (ignored == null) goto L19;
        ignored.close();     // Catch: Throwable -> L17
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L11:
        th = move-exception;
        if (ignored != null) goto L33;
    L27:
        throw th;     // Catch: Throwable -> L17
    L33:
        ignored.close();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    private void unregister(TRegistration registration) {
        registration.unregisterInternal();
        onRegistrationActiveChanged(registration);
    }

    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        Object r0 = this.mMultiplexerLock;
        monitor-enter(r0);
        pw.print("service: ");     // Catch: Throwable -> L11
        pw.print(getServiceState());     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        if (this.mRegistrations.isEmpty() == true) goto L15;
        pw.println("listeners:");     // Catch: Throwable -> L11
        int size = this.mRegistrations.size();     // Catch: Throwable -> L11
        int i = 0;
    L7:
        if (i >= size) goto L15;
        TRegistration registration = this.mRegistrations.valueAt(i);     // Catch: Throwable -> L11
        pw.print("  ");     // Catch: Throwable -> L11
        pw.print(registration);     // Catch: Throwable -> L11
        if (registration.isActive() == true) goto L13;
        pw.println(" (inactive)");     // Catch: Throwable -> L11
    L14:
        i = i + 1;     // Catch: Throwable -> L11
        goto L7
    L13:
        pw.println();     // Catch: Throwable -> L11
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    protected String getServiceState() {
        if (this.mServiceRegistered == true) goto L5;
        return "unregistered";
    L5:
        if (this.mMerged != null) goto L7;
        return "registered";
    L7:
        return this.mMerged.toString();
    }
}
