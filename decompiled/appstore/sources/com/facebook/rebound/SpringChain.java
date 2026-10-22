package com.facebook.rebound;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class SpringChain implements SpringListener {
    private static final int DEFAULT_ATTACHMENT_FRICTION = 10;
    private static final int DEFAULT_ATTACHMENT_TENSION = 70;
    private static final int DEFAULT_MAIN_FRICTION = 6;
    private static final int DEFAULT_MAIN_TENSION = 40;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private static int f10270id;
    private static final SpringConfigRegistry registry = null;
    private final SpringConfig mAttachmentSpringConfig;
    private int mControlSpringIndex;
    private final CopyOnWriteArrayList<SpringListener> mListeners;
    private final SpringConfig mMainSpringConfig;
    private final SpringSystem mSpringSystem;
    private final CopyOnWriteArrayList<Spring> mSprings;

    static {
        registry = SpringConfigRegistry.getInstance();
        f10270id = 0;
    }

    private SpringChain() {
        this(40, 6, 70, 10);
    }

    public static SpringChain create() {
        return new SpringChain();
    }

    public SpringChain addSpring(SpringListener r10) {
        Spring r11 = this.mSpringSystem.createSpring().addListener(this).setSpringConfig(this.mAttachmentSpringConfig);
        this.mSprings.add(r11);
        this.mListeners.add(r10);
        return this;
    }

    public List<Spring> getAllSprings() {
        return this.mSprings;
    }

    public SpringConfig getAttachmentSpringConfig() {
        return this.mAttachmentSpringConfig;
    }

    public Spring getControlSpring() {
        return this.mSprings.get(this.mControlSpringIndex);
    }

    public SpringConfig getMainSpringConfig() {
        return this.mMainSpringConfig;
    }

    @Override // com.facebook.rebound.SpringListener
    public void onSpringActivate(Spring r10) {
        int r11 = this.mSprings.indexOf(r10);
        this.mListeners.get(r11).onSpringActivate(r10);
    }

    @Override // com.facebook.rebound.SpringListener
    public void onSpringAtRest(Spring r10) {
        int r11 = this.mSprings.indexOf(r10);
        this.mListeners.get(r11).onSpringAtRest(r10);
    }

    @Override // com.facebook.rebound.SpringListener
    public void onSpringEndStateChange(Spring r10) {
        int r11 = this.mSprings.indexOf(r10);
        this.mListeners.get(r11).onSpringEndStateChange(r10);
    }

    @Override // com.facebook.rebound.SpringListener
    public void onSpringUpdate(Spring r10) {
        int r11 = this.mSprings.indexOf(r10);
        SpringListener r12 = this.mListeners.get(r11);
        int r13 = this.mControlSpringIndex;
        if (r11 != r13) goto L5;
        int r14 = r11 - 1;
        int r15 = r11 + 1;
    L10:
        if (r15 > (-1)) goto L12;
    L14:
        if (r14 > (-1)) goto L16;
    L18:
        r12.onSpringUpdate(r10);
        return;
    L16:
        if (r14 >= this.mSprings.size()) goto L18;
        this.mSprings.get(r14).setEndValue(r10.getCurrentValue());
        goto L18
    L12:
        if (r15 >= this.mSprings.size()) goto L14;
        this.mSprings.get(r15).setEndValue(r10.getCurrentValue());
        goto L14
    L5:
        if (r11 >= r13) goto L7;
        r14 = r11 - 1;
        r15 = -1;
        goto L10
    L7:
        if (r11 <= r13) goto L9;
        r15 = r11 + 1;
        r14 = -1;
        goto L10
    L9:
        r15 = -1;
        r14 = -1;
        goto L10
    }

    public SpringChain setControlSpringIndex(int r10) {
        this.mControlSpringIndex = r10;
        if (this.mSprings.get(r10) != null) goto L6;
        return null;
    L6:
        Iterator<Spring> r11 = this.mSpringSystem.getAllSprings().iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        r11.next().setSpringConfig(this.mAttachmentSpringConfig);
        goto L8
    L10:
        getControlSpring().setSpringConfig(this.mMainSpringConfig);
        return this;
    }

    private SpringChain(int r10, int r11, int r12, int r13) {
        this.mSpringSystem = SpringSystem.create();
        this.mListeners = new CopyOnWriteArrayList();
        this.mSprings = new CopyOnWriteArrayList();
        this.mControlSpringIndex = -1;
        SpringConfig r14 = SpringConfig.fromOrigamiTensionAndFriction(r10, r11);
        this.mMainSpringConfig = r14;
        SpringConfig r15 = SpringConfig.fromOrigamiTensionAndFriction(r12, r13);
        this.mAttachmentSpringConfig = r15;
        SpringConfigRegistry r16 = registry;
        StringBuilder r17 = new StringBuilder();
        r17.append("main spring ");
        int r18 = f10270id;
        f10270id = r18 + 1;
        r17.append(r18);
        r16.addSpringConfig(r14, r17.toString());
        StringBuilder r19 = new StringBuilder();
        r19.append("attachment spring ");
        int r20 = f10270id;
        f10270id = r20 + 1;
        r19.append(r20);
        r16.addSpringConfig(r15, r19.toString());
    }

    public static SpringChain create(int r10, int r11, int r12, int r13) {
        return new SpringChain(r10, r11, r12, r13);
    }
}
