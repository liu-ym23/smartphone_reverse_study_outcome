package com.bytedance.android.livesdk.chatroom.ui;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class d6 {

    public static final class a extends d6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final wj0.b f112707a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f112707a, ((a) r100).f112707a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            wj0.b r100 = this.f112707a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "EmojiOnEndEvent(coreInfo=" + this.f112707a + ")";
        }

        public a(wj0.b r100) {
            this.f112707a = r100;
        }
    }

    public static final class b extends d6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final wj0.b f112708a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f112708a, ((b) r100).f112708a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            wj0.b r100 = this.f112708a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "EmojiOnRandomResultEvent(coreInfo=" + this.f112708a + ")";
        }

        public b(wj0.b r100) {
            this.f112708a = r100;
        }
    }

    public static final class c extends d6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final wj0.b f112709a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f112709a, ((c) r100).f112709a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            wj0.b r100 = this.f112709a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "EmojiOnStartEvent(coreInfo=" + this.f112709a + ")";
        }

        public c(wj0.b r100) {
            this.f112709a = r100;
        }
    }

    public d6() {
    }
}
