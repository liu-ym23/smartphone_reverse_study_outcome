package com.android.server.policy;

import android.R;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import com.android.server.BinaryTransparencyService$Digest$$ExternalSyntheticRecord1;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class SingleKeyGestureDetector {
    private static final boolean DEBUG = false;
    private static final int MSG_KEY_DELAYED_PRESS = 2;
    private static final int MSG_KEY_LONG_PRESS = 0;
    private static final int MSG_KEY_UP = 3;
    private static final int MSG_KEY_VERY_LONG_PRESS = 1;
    static final long MULTI_PRESS_TIMEOUT = 0;
    private static final String TAG = "SingleKeyGesture";
    static long sDefaultLongPressTimeout;
    static long sDefaultVeryLongPressTimeout;
    private SingleKeyRule mActiveRule;
    private boolean mBeganFromDefaultDisplayOn;
    private boolean mBeganFromNonInteractive;
    private int mDownKeyCode;
    private boolean mHandledByLongPress;
    private final Handler mHandler;
    private int mKeyPressCounter;
    private long mLastDownTime;
    private long mLastPowerDownTime;
    private final ArrayList<SingleKeyRule> mRules;

    private class KeyHandler extends Handler {
        final /* synthetic */ SingleKeyGestureDetector this$0;

        KeyHandler(SingleKeyGestureDetector r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            MessageObject object = (MessageObject) msg.obj;
            SingleKeyRule rule = MessageObject.m7272$$Nest$fgetactiveRule(object);
            if (rule != null) goto L6;
            Log.wtf(SingleKeyGestureDetector.TAG, "No active rule.");
            return;
        L6:
            MessageObject.m7275$$Nest$fgetkeyCode(object);
            int pressCount = MessageObject.m7277$$Nest$fgetpressCount(object);
            int displayId = MessageObject.m7274$$Nest$fgetdisplayId(object);
            switch(msg.what) {
                case 0: goto L15;
                case 1: goto L14;
                case 2: goto L11;
                case 3: goto L9;
                default: goto L21;
            };
        L9:
            rule.onKeyUp(SingleKeyGestureDetector.m7271$$Nest$fgetmLastDownTime(this.this$0), pressCount, displayId, MessageObject.m7273$$Nest$fgetdeviceId(object), MessageObject.m7276$$Nest$fgetmetaState(object));
            return;
        L14:
            rule.onVeryLongPress(SingleKeyGestureDetector.m7271$$Nest$fgetmLastDownTime(this.this$0));
            return;
        L15:
            rule.onLongPress(SingleKeyGestureDetector.m7271$$Nest$fgetmLastDownTime(this.this$0));
            return;
        L21:
            return;
        L11:
            if (pressCount != 1) goto L13;
            rule.onPress(SingleKeyGestureDetector.m7271$$Nest$fgetmLastDownTime(this.this$0), displayId);
            return;
        L13:
            rule.onMultiPress(SingleKeyGestureDetector.m7271$$Nest$fgetmLastDownTime(this.this$0), pressCount, displayId);
        }
    }

    private static final class MessageObject extends Record {
        private final SingleKeyRule activeRule;
        private final int deviceId;
        private final int displayId;
        private final int keyCode;
        private final int metaState;
        private final int pressCount;

        private /* synthetic */ boolean $record$equals(Object r3) {
            if ((r3 instanceof MessageObject) == false) goto L18;
            MessageObject r4 = (MessageObject) r3;
            if (this.keyCode == r4.keyCode) goto L7;
            return false;
        L7:
            if (this.pressCount == r4.pressCount) goto L9;
            return false;
        L9:
            if (this.displayId == r4.displayId) goto L11;
            return false;
        L11:
            if (this.metaState == r4.metaState) goto L13;
            return false;
        L13:
            if (this.deviceId == r4.deviceId) goto L15;
            return false;
        L15:
            if (Objects.equals(this.activeRule, r4.activeRule) == false) goto L25;
            return true;
        L25:
            return false;
        L18:
            return false;
        }

        private /* synthetic */ Object[] $record$getFieldsAsObjects() {
            return new Object[]{this.activeRule, Integer.valueOf(this.keyCode), Integer.valueOf(this.pressCount), Integer.valueOf(this.displayId), Integer.valueOf(this.metaState), Integer.valueOf(this.deviceId)};
        }

        /* JADX INFO: renamed from: -$$Nest$fgetactiveRule, reason: not valid java name */
        static /* bridge */ /* synthetic */ SingleKeyRule m7272$$Nest$fgetactiveRule(MessageObject r0) {
            return r0.activeRule;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetdeviceId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m7273$$Nest$fgetdeviceId(MessageObject r0) {
            return r0.deviceId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetdisplayId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m7274$$Nest$fgetdisplayId(MessageObject r0) {
            return r0.displayId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetkeyCode, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m7275$$Nest$fgetkeyCode(MessageObject r0) {
            return r0.keyCode;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmetaState, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m7276$$Nest$fgetmetaState(MessageObject r0) {
            return r0.metaState;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetpressCount, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m7277$$Nest$fgetpressCount(MessageObject r0) {
            return r0.pressCount;
        }

        private MessageObject(SingleKeyRule activeRule, int keyCode, int pressCount, int displayId, int metaState, int deviceId) {
            this.activeRule = activeRule;
            this.keyCode = keyCode;
            this.pressCount = pressCount;
            this.displayId = displayId;
            this.metaState = metaState;
            this.deviceId = deviceId;
        }

        public SingleKeyRule activeRule() {
            return this.activeRule;
        }

        public int deviceId() {
            return this.deviceId;
        }

        public int displayId() {
            return this.displayId;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return $record$equals(o);
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return SingleKeyGestureDetector$MessageObject$$ExternalSyntheticRecord0.m(this.keyCode, this.pressCount, this.displayId, this.metaState, this.deviceId, this.activeRule);
        }

        public int keyCode() {
            return this.keyCode;
        }

        public int metaState() {
            return this.metaState;
        }

        public int pressCount() {
            return this.pressCount;
        }

        @Override // java.lang.Record
        public final String toString() {
            return BinaryTransparencyService$Digest$$ExternalSyntheticRecord1.m($record$getFieldsAsObjects(), MessageObject.class, "activeRule;keyCode;pressCount;displayId;metaState;deviceId");
        }

        MessageObject(SingleKeyRule activeRule, int keyCode, int pressCount, KeyEvent event) {
            this(activeRule, keyCode, pressCount, event.getDisplayId(), event.getMetaState(), event.getDeviceId());
        }
    }

    static abstract class SingleKeyRule {
        private final int mKeyCode;

        /* JADX INFO: renamed from: -$$Nest$fgetmKeyCode, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m7278$$Nest$fgetmKeyCode(SingleKeyRule r0) {
            return r0.mKeyCode;
        }

        /* JADX INFO: renamed from: -$$Nest$mshouldInterceptKey, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m7279$$Nest$mshouldInterceptKey(SingleKeyRule r0, int r1) {
            return r0.shouldInterceptKey(r1);
        }

        abstract void onPress(long r1, int r3);

        SingleKeyRule(int keyCode) {
            this.mKeyCode = keyCode;
        }

        private boolean shouldInterceptKey(int keyCode) {
            if (keyCode != this.mKeyCode) goto L5;
            return true;
        L5:
            return false;
        }

        boolean supportLongPress() {
            return false;
        }

        boolean supportVeryLongPress() {
            return false;
        }

        int getMaxMultiPressCount() {
            return 1;
        }

        void onMultiPress(long downTime, int count, int displayId) {
        }

        long getLongPressTimeoutMs() {
            return SingleKeyGestureDetector.sDefaultLongPressTimeout;
        }

        void onLongPress(long eventTime) {
        }

        long getVeryLongPressTimeoutMs() {
            return SingleKeyGestureDetector.sDefaultVeryLongPressTimeout;
        }

        void onVeryLongPress(long eventTime) {
        }

        void onKeyUp(long eventTime, int pressCount, int displayId, int deviceId, int metaState) {
        }

        public String toString() {
            return "KeyCode=" + KeyEvent.keyCodeToString(this.mKeyCode) + ", LongPress=" + supportLongPress() + ", VeryLongPress=" + supportVeryLongPress() + ", MaxMultiPressCount=" + getMaxMultiPressCount();
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if ((o instanceof SingleKeyRule) == false) goto L12;
            SingleKeyRule that = (SingleKeyRule) o;
            if (this.mKeyCode != that.mKeyCode) goto L11;
            return true;
        L11:
            return false;
        L12:
            return false;
        }

        public int hashCode() {
            return this.mKeyCode;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLastDownTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m7271$$Nest$fgetmLastDownTime(SingleKeyGestureDetector r2) {
        return r2.mLastDownTime;
    }

    static {
        MULTI_PRESS_TIMEOUT = ViewConfiguration.getMultiPressTimeout();
    }

    static SingleKeyGestureDetector get(Context context, Looper looper) {
        SingleKeyGestureDetector detector = new SingleKeyGestureDetector(looper);
        sDefaultLongPressTimeout = context.getResources().getInteger(R.integer.config_keepPreloadsMinDays);
        sDefaultVeryLongPressTimeout = context.getResources().getInteger(R.integer.config_zoomControlsTimeoutMillis);
        return detector;
    }

    private SingleKeyGestureDetector(Looper looper) {
        this.mBeganFromNonInteractive = false;
        this.mBeganFromDefaultDisplayOn = false;
        this.mRules = new ArrayList();
        this.mActiveRule = null;
        this.mDownKeyCode = 0;
        this.mHandledByLongPress = false;
        this.mLastDownTime = 0;
        this.mLastPowerDownTime = 0;
        this.mHandler = new KeyHandler(this, looper);
    }

    void addRule(SingleKeyRule rule) {
        if (this.mRules.contains(rule) == true) goto L7;
        this.mRules.add(rule);
        return;
    L7:
        throw new IllegalArgumentException("Rule : " + rule + " already exists.");
    }

    void removeRule(SingleKeyRule rule) {
        this.mRules.remove(rule);
    }

    void interceptKey(KeyEvent event, boolean interactive, boolean defaultDisplayOn) {
        if (event.getAction() == 0) goto L5;
        interceptKeyUp(event);
        return;
    L5:
        if (this.mDownKeyCode != 0) goto L7;
    L8:
        this.mBeganFromNonInteractive = !interactive;
        this.mBeganFromDefaultDisplayOn = defaultDisplayOn;
    L9:
        interceptKeyDown(event);
        return;
    L7:
        if (this.mDownKeyCode == event.getKeyCode()) goto L9;
        goto L8
    }

    private void interceptKeyDown(KeyEvent event) {
        int keyCode = event.getKeyCode();
        if (this.mDownKeyCode != keyCode) goto L15;
        if (this.mActiveRule != null) goto L7;
        return;
    L7:
        if ((event.getFlags() & 128) != 0) goto L9;
        return;
    L9:
        if (this.mActiveRule.supportLongPress() == true) goto L11;
        return;
    L11:
        if (this.mHandledByLongPress == true) goto L59;
        this.mHandledByLongPress = true;
        this.mHandler.removeMessages(0);
        this.mHandler.removeMessages(1);
        MessageObject object = new MessageObject(this.mActiveRule, keyCode, 1, event);
        Message msg = this.mHandler.obtainMessage(0, object);
        msg.setAsynchronous(true);
        this.mHandler.sendMessage(msg);
        return;
    L59:
        return;
    L15:
        if (this.mDownKeyCode == 0) goto L17;
    L20:
        reset();
    L21:
        this.mDownKeyCode = keyCode;
        long r4 = 0;
        if (this.mActiveRule != null) goto L31;
        int count = this.mRules.size();
        int index = 0;
    L24:
        if (index >= count) goto L29;
        SingleKeyRule rule = this.mRules.get(index);
        if (SingleKeyRule.m7279$$Nest$mshouldInterceptKey(rule, keyCode) == true) goto L27;
        index = index + 1;
        goto L24
    L27:
        this.mActiveRule = rule;
    L29:
        this.mLastDownTime = 0;
    L31:
        if (this.mActiveRule != null) goto L33;
        return;
    L33:
        long keyDownInterval = event.getDownTime() - this.mLastDownTime;
        this.mLastDownTime = event.getDownTime();
        if (26 != keyCode) goto L36;
        r4 = SystemClock.elapsedRealtime();
    L36:
        this.mLastPowerDownTime = r4;
        if (keyDownInterval < MULTI_PRESS_TIMEOUT) goto L39;
        this.mKeyPressCounter = 1;
    L41:
        if (this.mKeyPressCounter == 1) goto L43;
        this.mHandler.removeMessages(0);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        if (this.mActiveRule.getMaxMultiPressCount() > 1) goto L51;
        return;
    L51:
        if (this.mKeyPressCounter != this.mActiveRule.getMaxMultiPressCount()) goto L63;
        MessageObject object2 = new MessageObject(this.mActiveRule, keyCode, this.mKeyPressCounter, event);
        Message msg2 = this.mHandler.obtainMessage(2, object2);
        msg2.setAsynchronous(true);
        this.mHandler.sendMessage(msg2);
        return;
    L63:
        return;
    L43:
        if (this.mActiveRule.supportLongPress() == false) goto L46;
        MessageObject object3 = new MessageObject(this.mActiveRule, keyCode, this.mKeyPressCounter, event);
        Message msg3 = this.mHandler.obtainMessage(0, object3);
        msg3.setAsynchronous(true);
        this.mHandler.sendMessageDelayed(msg3, this.mActiveRule.getLongPressTimeoutMs());
    L46:
        if (this.mActiveRule.supportVeryLongPress() == false) goto L60;
        MessageObject object4 = new MessageObject(this.mActiveRule, keyCode, this.mKeyPressCounter, event);
        Message msg4 = this.mHandler.obtainMessage(1, object4);
        msg4.setAsynchronous(true);
        this.mHandler.sendMessageDelayed(msg4, this.mActiveRule.getVeryLongPressTimeoutMs());
        return;
    L60:
        return;
    L39:
        this.mKeyPressCounter++;
        goto L41
    L17:
        if (this.mActiveRule == null) goto L21;
        if (SingleKeyRule.m7279$$Nest$mshouldInterceptKey(this.mActiveRule, keyCode) == true) goto L21;
        goto L20
    }

    private boolean interceptKeyUp(KeyEvent event) {
        this.mDownKeyCode = 0;
        if (this.mActiveRule != null) goto L6;
        return false;
    L6:
        if (this.mHandledByLongPress == true) goto L16;
        long eventTime = event.getEventTime();
        if (eventTime >= (this.mLastDownTime + this.mActiveRule.getLongPressTimeoutMs())) goto L10;
        this.mHandler.removeMessages(0);
    L12:
        if (eventTime >= (this.mLastDownTime + this.mActiveRule.getVeryLongPressTimeoutMs())) goto L14;
        this.mHandler.removeMessages(1);
        goto L16
    L14:
        this.mHandledByLongPress |= this.mActiveRule.supportVeryLongPress();
        goto L16
    L10:
        this.mHandledByLongPress = this.mActiveRule.supportLongPress();
    L16:
        if (this.mHandledByLongPress == false) goto L20;
        this.mHandledByLongPress = false;
        this.mKeyPressCounter = 0;
        this.mActiveRule = null;
        return true;
    L20:
        if (event.getKeyCode() == SingleKeyRule.m7278$$Nest$fgetmKeyCode(this.mActiveRule)) goto L22;
        reset();
        return false;
    L22:
        if ((event.getEventTime() - this.mLastDownTime) < this.mActiveRule.getLongPressTimeoutMs()) goto L25;
        reset();
        return false;
    L25:
        MessageObject object = new MessageObject(this.mActiveRule, SingleKeyRule.m7278$$Nest$fgetmKeyCode(this.mActiveRule), this.mKeyPressCounter, event);
        Message msgKeyUp = this.mHandler.obtainMessage(3, object);
        msgKeyUp.setAsynchronous(true);
        this.mHandler.sendMessage(msgKeyUp);
        if (this.mActiveRule.getMaxMultiPressCount() != 1) goto L30;
        MessageObject object2 = new MessageObject(this.mActiveRule, SingleKeyRule.m7278$$Nest$fgetmKeyCode(this.mActiveRule), 1, event);
        Message msg = this.mHandler.obtainMessage(2, object2);
        msg.setAsynchronous(true);
        this.mHandler.sendMessage(msg);
        this.mActiveRule = null;
        return true;
    L30:
        if (this.mKeyPressCounter >= this.mActiveRule.getMaxMultiPressCount()) goto L32;
        MessageObject object3 = new MessageObject(this.mActiveRule, SingleKeyRule.m7278$$Nest$fgetmKeyCode(this.mActiveRule), this.mKeyPressCounter, event);
        Message msg2 = this.mHandler.obtainMessage(2, object3);
        msg2.setAsynchronous(true);
        this.mHandler.sendMessageDelayed(msg2, MULTI_PRESS_TIMEOUT - (SystemClock.elapsedRealtime() - this.mLastPowerDownTime));
    L32:
        return true;
    }

    int getKeyPressCounter(int keyCode) {
        if (this.mActiveRule != null) goto L5;
        return 0;
    L5:
        if (SingleKeyRule.m7278$$Nest$fgetmKeyCode(this.mActiveRule) == keyCode) goto L7;
        return 0;
    L7:
        return this.mKeyPressCounter;
    }

    void reset() {
        if (this.mActiveRule != null) goto L5;
    L11:
        this.mHandledByLongPress = false;
        this.mDownKeyCode = 0;
        return;
    L5:
        if (this.mDownKeyCode == 0) goto L8;
        this.mHandler.removeMessages(0);
        this.mHandler.removeMessages(1);
    L8:
        if (this.mKeyPressCounter <= 0) goto L10;
        this.mHandler.removeMessages(2);
        this.mKeyPressCounter = 0;
    L10:
        this.mActiveRule = null;
        goto L11
    }

    boolean isKeyIntercepted(int keyCode) {
        if (this.mActiveRule != null) goto L5;
    L7:
        return false;
    L5:
        if (SingleKeyRule.m7279$$Nest$mshouldInterceptKey(this.mActiveRule, keyCode) == false) goto L7;
        return true;
    }

    boolean beganFromNonInteractive() {
        return this.mBeganFromNonInteractive;
    }

    boolean beganFromDefaultDisplayOn() {
        return this.mBeganFromDefaultDisplayOn;
    }

    void dump(String prefix, PrintWriter pw) {
        pw.println(prefix + "SingleKey rules:");
        Iterator<SingleKeyRule> r0 = this.mRules.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        SingleKeyRule rule = r0.next();
        pw.println(prefix + "  " + rule);
        goto L4
    }
}
