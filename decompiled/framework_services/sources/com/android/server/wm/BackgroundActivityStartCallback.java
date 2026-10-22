package com.android.server.wm;

import android.os.IBinder;
import com.android.server.BinaryTransparencyService$Digest$$ExternalSyntheticRecord1;
import com.android.server.input.AppLaunchShortcutManager$InterceptKeyResult$$ExternalSyntheticRecord0;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public interface BackgroundActivityStartCallback {
    public static final BackgroundActivityStartCallbackResult RESULT_FALSE = null;
    public static final BackgroundActivityStartCallbackResult RESULT_TRUE = null;

    public static final class BackgroundActivityStartCallbackResult extends Record {
        private final boolean allowed;
        private final IBinder token;

        private /* synthetic */ boolean $record$equals(Object r3) {
            if ((r3 instanceof BackgroundActivityStartCallbackResult) == false) goto L10;
            BackgroundActivityStartCallbackResult r4 = (BackgroundActivityStartCallbackResult) r3;
            if (this.allowed == r4.allowed) goto L7;
            return false;
        L7:
            if (Objects.equals(this.token, r4.token) == false) goto L13;
            return true;
        L13:
            return false;
        L10:
            return false;
        }

        private /* synthetic */ Object[] $record$getFieldsAsObjects() {
            return new Object[]{Boolean.valueOf(this.allowed), this.token};
        }

        public BackgroundActivityStartCallbackResult(boolean allowed, IBinder token) {
            this.allowed = allowed;
            this.token = token;
        }

        public boolean allowed() {
            return this.allowed;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return $record$equals(o);
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return AppLaunchShortcutManager$InterceptKeyResult$$ExternalSyntheticRecord0.m(this.allowed, this.token);
        }

        @Override // java.lang.Record
        public final String toString() {
            return BinaryTransparencyService$Digest$$ExternalSyntheticRecord1.m($record$getFieldsAsObjects(), BackgroundActivityStartCallbackResult.class, "allowed;token");
        }

        public IBinder token() {
            return this.token;
        }
    }

    boolean canCloseSystemDialogs(Collection<IBinder> r1, int r2);

    BackgroundActivityStartCallbackResult isActivityStartAllowed(Collection<IBinder> r1, int r2, String r3);

    static {
        RESULT_FALSE = new BackgroundActivityStartCallbackResult(false, null);
        RESULT_TRUE = new BackgroundActivityStartCallbackResult(true, null);
    }
}
