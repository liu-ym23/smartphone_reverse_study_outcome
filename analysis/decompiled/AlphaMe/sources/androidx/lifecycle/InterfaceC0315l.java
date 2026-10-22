package androidx.lifecycle;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: androidx.lifecycle.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0315l extends F {
    default void onCreate(G owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
    }

    default void onDestroy(G owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
    }

    default void onPause(G owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
    }

    default void onResume(G owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
    }

    default void onStart(G owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
    }

    default void onStop(G owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
    }
}
