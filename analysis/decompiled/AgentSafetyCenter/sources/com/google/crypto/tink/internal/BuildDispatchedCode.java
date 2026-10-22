package com.google.crypto.tink.internal;

import android.os.Build;
import javax.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class BuildDispatchedCode {
    private BuildDispatchedCode() {
    }

    @Nullable
    public static Integer getApiLevel() {
        return Integer.valueOf(Build.VERSION.SDK_INT);
    }
}
