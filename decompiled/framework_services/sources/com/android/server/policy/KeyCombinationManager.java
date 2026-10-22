package com.android.server.policy;

import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseLongArray;
import android.view.KeyEvent;
import com.android.internal.util.ToBooleanFunction;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public class KeyCombinationManager {
    private static final long COMBINE_KEY_DELAY_MILLIS = 150;
    private static final String TAG = "KeyCombinationManager";
    private final ArrayList<TwoKeysCombinationRule> mActiveRules;
    private final SparseLongArray mDownTimes;
    private final Handler mHandler;
    private final Object mLock;
    private final ArrayList<TwoKeysCombinationRule> mRules;
    private TwoKeysCombinationRule mTriggeredRule;

    public static abstract class TwoKeysCombinationRule {
        private int mKeyCode1;
        private int mKeyCode2;

        public abstract void cancel();

        public abstract void execute();

        public TwoKeysCombinationRule(int keyCode1, int keyCode2) {
            this.mKeyCode1 = keyCode1;
            this.mKeyCode2 = keyCode2;
        }

        public boolean preCondition() {
            return true;
        }

        boolean shouldInterceptKey(int keyCode) {
            if (keyCode == this.mKeyCode1) goto L7;
            if (keyCode == this.mKeyCode2) goto L7;
        L9:
            return false;
        L7:
            if (preCondition() == false) goto L9;
            return true;
        }

        boolean shouldInterceptKeys(SparseLongArray downTimes) {
            long now = SystemClock.uptimeMillis();
            if (downTimes.get(this.mKeyCode1) > 0) goto L5;
            return false;
        L5:
            if (downTimes.get(this.mKeyCode2) > 0) goto L7;
            return false;
        L7:
            if (now <= (downTimes.get(this.mKeyCode1) + 150)) goto L9;
            return false;
        L9:
            if (now > (downTimes.get(this.mKeyCode2) + 150)) goto L16;
            return true;
        L16:
            return false;
        }

        public long getKeyInterceptDelayMs() {
            return 150;
        }

        public String toString() {
            return KeyEvent.keyCodeToString(this.mKeyCode1) + " + " + KeyEvent.keyCodeToString(this.mKeyCode2);
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if ((o instanceof TwoKeysCombinationRule) == false) goto L18;
            TwoKeysCombinationRule that = (TwoKeysCombinationRule) o;
            if (this.mKeyCode1 != that.mKeyCode1) goto L12;
            if (this.mKeyCode2 != that.mKeyCode2) goto L12;
            return true;
        L12:
            if (this.mKeyCode1 != that.mKeyCode2) goto L17;
            if (this.mKeyCode2 != that.mKeyCode1) goto L17;
            return true;
        L17:
            return false;
        L18:
            return false;
        }

        public int hashCode() {
            int result = this.mKeyCode1;
            return (result * 31) + this.mKeyCode2;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$0ijNtPLwUYwFHT7MZ-Fe91P0mYQ, reason: not valid java name */
    public static /* synthetic */ boolean m7132$r8$lambda$0ijNtPLwUYwFHT7MZFe91P0mYQ(TwoKeysCombinationRule r0) {
        return lambda$isPowerKeyIntercepted$3(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$8IUu_paQ3WrrnJt2hjUdbfqunxQ(KeyCombinationManager r0, TwoKeysCombinationRule r1) {
        return r0.lambda$interceptKeyLocked$2(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$O6msDJSnX9dCYsqIQTDD0-VrMyw, reason: not valid java name */
    public static /* synthetic */ void m7133$r8$lambda$O6msDJSnX9dCYsqIQTDD0VrMyw(PrintWriter r0, String r1, TwoKeysCombinationRule r2) {
        lambda$dump$4(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$_UAQPtLEIzuwJErQ5JX08h6h6BQ(TwoKeysCombinationRule r0) {
        lambda$interceptKeyLocked$0(r0);
    }

    public static /* synthetic */ void $r8$lambda$n3LH_QOBTUG6i2zKeSgUaKwhLd4(KeyCombinationManager r0, int r1, TwoKeysCombinationRule r2) {
        r0.lambda$interceptKeyLocked$1(r1, r2);
    }

    public KeyCombinationManager(Handler handler) {
        this.mDownTimes = new SparseLongArray(2);
        this.mRules = new ArrayList();
        this.mLock = new Object();
        this.mActiveRules = new ArrayList();
        this.mHandler = handler;
    }

    public void addRule(TwoKeysCombinationRule rule) {
        if (this.mRules.contains(rule) == true) goto L7;
        this.mRules.add(rule);
        return;
    L7:
        throw new IllegalArgumentException("Rule : " + rule + " already exists.");
    }

    public void removeRule(TwoKeysCombinationRule rule) {
        this.mRules.remove(rule);
    }

    public boolean interceptKey(KeyEvent event, boolean isDefaultDisplayInteractive) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = interceptKeyLocked(event, isDefaultDisplayInteractive);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean interceptKeyLocked(KeyEvent event, boolean isDefaultDisplayInteractive) {
        if (event.getAction() != 0) goto L5;
        boolean down = true;
    L6:
        final int keyCode = event.getKeyCode();
        int count = this.mActiveRules.size();
        long eventTime = event.getEventTime();
        if (isDefaultDisplayInteractive == false) goto L36;
        if (down == false) goto L36;
        if (this.mDownTimes.size() <= 0) goto L22;
        if (count > 0) goto L13;
    L16:
        if (count != 0) goto L22;
        if (isCombinationStateExpired(eventTime) == false) goto L20;
        resetKeyCombinationState();
        goto L22
    L20:
        return false;
    L13:
        if (eventTime <= (this.mDownTimes.valueAt(0) + 150)) goto L16;
        Log.d(TAG, "down timeout cancel combination rule keyCode=" + keyCode);
        forAllRules(this.mActiveRules, new KeyCombinationManager$$ExternalSyntheticLambda2());
        this.mActiveRules.clear();
        return false;
    L22:
        if (this.mDownTimes.get(keyCode) != 0) goto L35;
        this.mDownTimes.put(keyCode, eventTime);
        if (this.mDownTimes.size() != 1) goto L29;
        this.mTriggeredRule = null;
        forAllRules(this.mRules, new KeyCombinationManager$$ExternalSyntheticLambda3(this, keyCode));
        if (this.mActiveRules.isEmpty() == false) goto L42;
        this.mDownTimes.delete(keyCode);
    L42:
        return false;
    L29:
        if (this.mTriggeredRule == null) goto L31;
        return true;
    L31:
        forAllActiveRules(new KeyCombinationManager$$ExternalSyntheticLambda4(this));
        this.mActiveRules.clear();
        if (this.mTriggeredRule == null) goto L42;
        this.mActiveRules.add(this.mTriggeredRule);
        return true;
    L35:
        return false;
    L36:
        this.mDownTimes.delete(keyCode);
        int index = count - 1;
    L37:
        if (index < 0) goto L42;
        final TwoKeysCombinationRule rule = this.mActiveRules.get(index);
        if (rule.shouldInterceptKey(keyCode) == false) goto L41;
        Log.d(TAG, "up or noInteractive cancel combination rule : " + rule);
        Handler r9 = this.mHandler;
        rule.getClass();
        r9.post(new KeyCombinationManager$$ExternalSyntheticLambda5(rule));
        this.mActiveRules.remove(index);
    L41:
        index = index - 1;
        goto L37
    L5:
        down = false;
        goto L6
    }

    private static /* synthetic */ void lambda$interceptKeyLocked$0(TwoKeysCombinationRule rule) {
        rule.cancel();
    }

    private /* synthetic */ void lambda$interceptKeyLocked$1(int keyCode, TwoKeysCombinationRule rule) {
        if (rule.shouldInterceptKey(keyCode) == false) goto L6;
        this.mActiveRules.add(rule);
        return;
    }

    private /* synthetic */ boolean lambda$interceptKeyLocked$2(final TwoKeysCombinationRule rule) {
        if (rule.shouldInterceptKeys(this.mDownTimes) == true) goto L6;
        return false;
    L6:
        Log.d(TAG, "Performing combination rule : " + rule);
        Handler r0 = this.mHandler;
        rule.getClass();
        r0.post(new KeyCombinationManager$$ExternalSyntheticLambda6(rule));
        this.mTriggeredRule = rule;
        return true;
    }

    public long getKeyInterceptTimeout(int keyCode) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mDownTimes.get(keyCode) != 0) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return 0;
    L10:
        long delayMs = 0;
        Iterator<TwoKeysCombinationRule> r3 = this.mActiveRules.iterator();     // Catch: Throwable -> L8
    L12:
        if (r3.hasNext() == false) goto L17;
        TwoKeysCombinationRule rule = r3.next();     // Catch: Throwable -> L8
        if (rule.shouldInterceptKey(keyCode) == false) goto L12;
        delayMs = Math.max(delayMs, rule.getKeyInterceptDelayMs());     // Catch: Throwable -> L8
        goto L12
    L17:
        long delayMs2 = Math.min(delayMs, 150);     // Catch: Throwable -> L8
        long r1 = this.mDownTimes.get(keyCode) + delayMs2;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r1;
    }

    public boolean isKeyConsumed(KeyEvent event) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r2 = false;
        if ((event.getFlags() & 1024) == 0) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L11:
        if (this.mTriggeredRule != null) goto L13;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r2;
    L13:
        if (this.mTriggeredRule.shouldInterceptKey(event.getKeyCode()) == false) goto L15;
        r2 = true;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean isPowerKeyIntercepted() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r2 = false;
        if (forAllActiveRules(new KeyCombinationManager$$ExternalSyntheticLambda0()) == true) goto L7;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return false;
    L7:
        if (this.mDownTimes.size() > 1) goto L13;
        if (this.mDownTimes.get(26) == 0) goto L13;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r2;
    L13:
        r2 = true;
    L11:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$isPowerKeyIntercepted$3(TwoKeysCombinationRule rule) {
        return rule.shouldInterceptKey(26);
    }

    private void forAllRules(ArrayList<TwoKeysCombinationRule> rules, Consumer<TwoKeysCombinationRule> callback) {
        int count = rules.size();
        int index = 0;
    L3:
        if (index >= count) goto L6;
        TwoKeysCombinationRule rule = rules.get(index);
        callback.accept(rule);
        index = index + 1;
        goto L3
    }

    private boolean forAllActiveRules(ToBooleanFunction<TwoKeysCombinationRule> callback) {
        int count = this.mActiveRules.size();
        int index = 0;
    L3:
        if (index >= count) goto L9;
        TwoKeysCombinationRule rule = this.mActiveRules.get(index);
        if (callback.apply(rule) == true) goto L6;
        index = index + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private boolean isCombinationStateExpired(long eventTime) {
        if (this.mDownTimes.size() != 0) goto L5;
        return false;
    L5:
        long lastDownTime = Long.MIN_VALUE;
        int index = 0;
    L7:
        if (index >= this.mDownTimes.size()) goto L10;
        lastDownTime = Math.max(lastDownTime, this.mDownTimes.valueAt(index));
        index = index + 1;
        goto L7
    L10:
        if (eventTime <= (150 + lastDownTime)) goto L14;
        return true;
    L14:
        return false;
    }

    private void resetKeyCombinationState() {
        this.mDownTimes.clear();
        this.mActiveRules.clear();
        this.mTriggeredRule = null;
    }

    public void dump(final String prefix, final PrintWriter pw) {
        pw.println(prefix + "KeyCombination rules:");
        forAllRules(this.mRules, new KeyCombinationManager$$ExternalSyntheticLambda1(pw, prefix));
    }

    private static /* synthetic */ void lambda$dump$4(PrintWriter pw, String prefix, TwoKeysCombinationRule rule) {
        pw.println(prefix + "  " + rule);
    }
}
