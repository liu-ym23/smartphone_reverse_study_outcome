package com.autonavi.amap.mapcore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class AmapDelegateListenerManager {
    private ConcurrentHashMap<Integer, ListenerWrapper> listenerWrapperMaps = new ConcurrentHashMap<>();

    public class ListenerWrapper<T> {
        public List<T> addedListeners = Collections.synchronizedList(new ArrayList());
        public T setListener = null;

        public ListenerWrapper() {
        }
    }

    public <T> void addListener(Integer num, T t10) {
        ConcurrentHashMap<Integer, ListenerWrapper> concurrentHashMap;
        if (t10 == null || (concurrentHashMap = this.listenerWrapperMaps) == null) {
            return;
        }
        try {
            ListenerWrapper listenerWrapper = concurrentHashMap.get(num);
            if (listenerWrapper == null) {
                listenerWrapper = new ListenerWrapper();
                this.listenerWrapperMaps.putIfAbsent(num, listenerWrapper);
            }
            List<T> list = listenerWrapper.addedListeners;
            if (list == null || list.contains(t10)) {
                return;
            }
            listenerWrapper.addedListeners.add(t10);
        } catch (Throwable unused) {
        }
    }

    public <T> void clear() {
        ConcurrentHashMap<Integer, ListenerWrapper> concurrentHashMap = this.listenerWrapperMaps;
        if (concurrentHashMap == null) {
            return;
        }
        try {
            Iterator<Map.Entry<Integer, ListenerWrapper>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                ListenerWrapper value = it.next().getValue();
                value.addedListeners.clear();
                value.setListener = null;
            }
            this.listenerWrapperMaps.clear();
        } catch (Throwable unused) {
        }
    }

    public <T> List<T> getListenerList(int i10) {
        try {
            ListenerWrapper listenerWrapper = this.listenerWrapperMaps.get(Integer.valueOf(i10));
            if (listenerWrapper != null) {
                return listenerWrapper.addedListeners;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public <T> void removeListener(Integer num, T t10) {
        ConcurrentHashMap<Integer, ListenerWrapper> concurrentHashMap;
        ListenerWrapper listenerWrapper;
        List<T> list;
        if (t10 == null || (concurrentHashMap = this.listenerWrapperMaps) == null) {
            return;
        }
        try {
            if (!concurrentHashMap.containsKey(num) || (listenerWrapper = this.listenerWrapperMaps.get(num)) == null || (list = listenerWrapper.addedListeners) == null || !list.contains(t10)) {
                return;
            }
            listenerWrapper.addedListeners.remove(t10);
        } catch (Throwable unused) {
        }
    }

    public <T> void removeListeners(Integer num) {
        ListenerWrapper listenerWrapper;
        List<T> list;
        try {
            if (!this.listenerWrapperMaps.containsKey(num) || (listenerWrapper = this.listenerWrapperMaps.get(num)) == null || (list = listenerWrapper.addedListeners) == null) {
                return;
            }
            list.clear();
        } catch (Throwable unused) {
        }
    }

    public <T> void setListener(int i10, T t10) {
        ConcurrentHashMap<Integer, ListenerWrapper> concurrentHashMap = this.listenerWrapperMaps;
        if (concurrentHashMap == null) {
            return;
        }
        try {
            ListenerWrapper listenerWrapper = concurrentHashMap.get(Integer.valueOf(i10));
            if (listenerWrapper == null) {
                listenerWrapper = new ListenerWrapper();
                this.listenerWrapperMaps.putIfAbsent(Integer.valueOf(i10), listenerWrapper);
            }
            if (listenerWrapper.setListener == t10) {
                return;
            }
            removeListener(Integer.valueOf(i10), listenerWrapper.setListener);
            listenerWrapper.setListener = t10;
            addListener(Integer.valueOf(i10), t10);
        } catch (Throwable unused) {
        }
    }
}
