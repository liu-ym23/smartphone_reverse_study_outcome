package com.android.server.dispatcher;

import android.os.Bundle;
import com.android.server.scene.SceneUtils;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class KeyguardStateDispatcher extends AbsDispatcher<KeyguardStateObserver> {
    private static final AbsDispatcher.Lazy<KeyguardStateDispatcher> INSTANCE = null;
    public static final String TAG = "GameAssist.KeyguardStateDispatcher";
    private final Map<Integer, KeyguardState> mKeyguardStateMap;

    public static class KeyguardState {
        public final int mDisplayId;
        public final boolean mIsAodShowing;
        public final boolean mIsKeyguardShowing;

        public KeyguardState(int displayId, boolean keyguardShowing, boolean aodShowing) {
            this.mDisplayId = displayId;
            this.mIsKeyguardShowing = keyguardShowing;
            this.mIsAodShowing = aodShowing;
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if (o != null) goto L8;
        L19:
            return false;
        L8:
            if (getClass() != o.getClass()) goto L19;
            KeyguardState that = (KeyguardState) o;
            if (this.mDisplayId != that.mDisplayId) goto L18;
            if (this.mIsKeyguardShowing != that.mIsKeyguardShowing) goto L18;
            if (this.mIsAodShowing != that.mIsAodShowing) goto L18;
            return true;
        L18:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.mDisplayId), Boolean.valueOf(this.mIsKeyguardShowing), Boolean.valueOf(this.mIsAodShowing)});
        }

        public Bundle toBundle() {
            Bundle data = new Bundle();
            data.putInt(SceneUtils.KEY_DISPLAY_ID, this.mDisplayId);
            data.putBoolean("keyguardShowing", this.mIsKeyguardShowing);
            data.putBoolean("aodShowing", this.mIsAodShowing);
            return data;
        }

        public String toString() {
            return "KeyguardState{mDisplayId=" + this.mDisplayId + ", mIsKeyguardShowing=" + this.mIsKeyguardShowing + ", mIsAodShowing=" + this.mIsAodShowing + '}';
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$NkZ--AB6K2TJb3Bfo4VkxTtYW-s, reason: not valid java name */
    public static /* synthetic */ void m3555$r8$lambda$NkZAB6K2TJb3Bfo4VkxTtYWs(int r0, KeyguardState r1, KeyguardStateObserver r2) {
        lambda$notifyKeyguardState$1(r0, r1, r2);
    }

    public static /* synthetic */ KeyguardStateDispatcher $r8$lambda$iDmYQHXuc8gTzggaddVF39KwpQM() {
        return new KeyguardStateDispatcher();
    }

    public static /* synthetic */ void $r8$lambda$ifXpNLLdJ1QoK2VazaCvbdj9bcQ(KeyguardStateDispatcher r0, int r1, boolean r2, boolean r3) {
        r0.lambda$notifyKeyguardState$0(r1, r2, r3);
    }

    static {
        INSTANCE = new AbsDispatcher.Lazy(new KeyguardStateDispatcher$$ExternalSyntheticLambda2());
    }

    private KeyguardStateDispatcher() {
        this.mKeyguardStateMap = new ConcurrentHashMap();
    }

    public static KeyguardStateDispatcher getInstance() {
        return (KeyguardStateDispatcher) INSTANCE.get();
    }

    private /* synthetic */ void lambda$notifyKeyguardState$0(int displayId, boolean keyguardShowing, boolean aodShowing) {
        notifyKeyguardState(displayId, keyguardShowing, aodShowing);
    }

    public void notifyKeyguardState(final int displayId, final boolean keyguardShowing, final boolean aodShowing) {
        if (switchThreads(new KeyguardStateDispatcher$$ExternalSyntheticLambda0(this, displayId, keyguardShowing, aodShowing)) == false) goto L5;
        return;
    L5:
        final KeyguardState keyguardState = new KeyguardState(displayId, keyguardShowing, aodShowing);
        KeyguardState currentState = this.mKeyguardStateMap.get(Integer.valueOf(displayId));
        if (keyguardState.equals(currentState) == true) goto L9;
        this.mKeyguardStateMap.put(Integer.valueOf(displayId), keyguardState);
        notifyObserver(new KeyguardStateDispatcher$$ExternalSyntheticLambda1(displayId, keyguardState));
        return;
    }

    private static /* synthetic */ void lambda$notifyKeyguardState$1(int displayId, KeyguardState keyguardState, KeyguardStateObserver observer) {
        observer.onKeyguardStateChanged(displayId, keyguardState);
    }
}
