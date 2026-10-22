package com.android.server.input;

import android.os.UEventObserver;

/* JADX INFO: loaded from: classes2.dex */
interface UEventManager {

    public static abstract class UEventListener {
        private final UEventObserver mObserver;

        /* JADX INFO: renamed from: -$$Nest$fgetmObserver, reason: not valid java name */
        static /* bridge */ /* synthetic */ UEventObserver m4610$$Nest$fgetmObserver(UEventListener r0) {
            return r0.mObserver;
        }

        public abstract void onUEvent(UEventObserver.UEvent r1);

        public UEventListener() {
            this.mObserver = new AnonymousClass1(this);
        }
    }

    default void addListener(UEventListener listener, String match) {
        UEventListener.m4610$$Nest$fgetmObserver(listener).startObserving(match);
    }

    default void removeListener(UEventListener listener) {
        UEventListener.m4610$$Nest$fgetmObserver(listener).stopObserving();
    }
}
