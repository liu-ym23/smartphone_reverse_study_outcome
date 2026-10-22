package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton.c;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.f2.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class f2<ICON extends ExtendedToolbarButton.c, DATA extends b, BEHAVIOR extends c0.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<a, Pair<ICON, BEHAVIOR>> f116302a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f116303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f116304b;

        public final String toString() {
            return "Key(uniqueId=" + this.f116303a + ", groupType=" + this.f116304b + ")";
        }

        public final int hashCode() {
            return (this.f116303a.hashCode() * 31) + String.valueOf(this.f116304b).hashCode();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if ((!Intrinsics.areEqual(a.class, r101)) == false) goto L12;
            return false;
        L12:
            if (r100 == null) goto L21;
            a r102 = (a) r100;
            if ((!Intrinsics.areEqual(this.f116303a, r102.f116303a)) == false) goto L17;
            return false;
        L17:
            if (this.f116304b == r102.f116304b) goto L19;
            return false;
        L19:
            return true;
        L21:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.NetworkIconToolbarLoader.Key");
        L8:
            r101 = null;
            goto L10
        }

        public a(String r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "uniqueId");
            this.f116303a = r100;
            this.f116304b = r101;
        }
    }

    public interface b {
    }

    public abstract f10.f a(b r100);

    public abstract BEHAVIOR b(DATA r100);

    public abstract void c(DATA r100);

    public abstract f10.f d(b r100, ExtendedToolbarButton.c r101);

    public f2() {
        this.f116302a = new LinkedHashMap();
    }
}
