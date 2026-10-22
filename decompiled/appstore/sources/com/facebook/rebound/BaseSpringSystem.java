package com.facebook.rebound;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
public class BaseSpringSystem {
    private final Set<Spring> mActiveSprings;
    private boolean mIdle;
    private final CopyOnWriteArraySet<SpringSystemListener> mListeners;
    private final SpringLooper mSpringLooper;
    private final Map<String, Spring> mSpringRegistry;

    public BaseSpringSystem(SpringLooper r10) {
        this.mSpringRegistry = new HashMap();
        this.mActiveSprings = new CopyOnWriteArraySet();
        this.mListeners = new CopyOnWriteArraySet();
        this.mIdle = true;
        if (r10 == null) goto L7;
        this.mSpringLooper = r10;
        r10.setSpringSystem(this);
        return;
    L7:
        throw new IllegalArgumentException("springLooper is required");
    }

    public void activateSpring(String r10) {
        Spring r11 = this.mSpringRegistry.get(r10);
        if (r11 == null) goto L9;
        this.mActiveSprings.add(r11);
        if (getIsIdle() == false) goto L10;
        this.mIdle = false;
        this.mSpringLooper.start();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("springId " + r10 + " does not reference a registered spring");
    }

    public void addListener(SpringSystemListener r10) {
        if (r10 == null) goto L6;
        this.mListeners.add(r10);
        return;
    L6:
        throw new IllegalArgumentException("newListener is required");
    }

    public void advance(double r10) {
        Iterator<Spring> r11 = this.mActiveSprings.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        Spring r12 = r11.next();
        if (r12.systemShouldAdvance() == true) goto L7;
        this.mActiveSprings.remove(r12);
        goto L4
    L7:
        r12.advance(r10 / 1000.0d);
        goto L4
    }

    public Spring createSpring() {
        Spring r10 = new Spring(this);
        registerSpring(r10);
        return r10;
    }

    public void deregisterSpring(Spring r10) {
        if (r10 == null) goto L6;
        this.mActiveSprings.remove(r10);
        this.mSpringRegistry.remove(r10.getId());
        return;
    L6:
        throw new IllegalArgumentException("spring is required");
    }

    public List<Spring> getAllSprings() {
        Collection<Spring> r10 = this.mSpringRegistry.values();
        if ((r10 instanceof List) == false) goto L5;
        List r11 = (List) r10;
    L7:
        return Collections.unmodifiableList(r11);
    L5:
        r11 = new ArrayList(r10);
        goto L7
    }

    public boolean getIsIdle() {
        return this.mIdle;
    }

    public Spring getSpringById(String r10) {
        if (r10 == null) goto L6;
        return this.mSpringRegistry.get(r10);
    L6:
        throw new IllegalArgumentException("id is required");
    }

    public void loop(double r10) {
        Iterator<SpringSystemListener> r11 = this.mListeners.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onBeforeIntegrate(this);
        goto L4
    L6:
        advance(r10);
        if (this.mActiveSprings.isEmpty() == false) goto L9;
        this.mIdle = true;
    L9:
        Iterator<SpringSystemListener> r12 = this.mListeners.iterator();
    L11:
        if (r12.hasNext() == false) goto L14;
        r12.next().onAfterIntegrate(this);
        goto L11
    L14:
        if (this.mIdle == false) goto L19;
        this.mSpringLooper.stop();
        return;
    }

    public void registerSpring(Spring r10) {
        if (r10 == null) goto L10;
        if (this.mSpringRegistry.containsKey(r10.getId()) == true) goto L8;
        this.mSpringRegistry.put(r10.getId(), r10);
        return;
    L8:
        throw new IllegalArgumentException("spring is already registered");
    L10:
        throw new IllegalArgumentException("spring is required");
    }

    public void removeAllListeners() {
        this.mListeners.clear();
    }

    public void removeListener(SpringSystemListener r10) {
        if (r10 == null) goto L6;
        this.mListeners.remove(r10);
        return;
    L6:
        throw new IllegalArgumentException("listenerToRemove is required");
    }
}
