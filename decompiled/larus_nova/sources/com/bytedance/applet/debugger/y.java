package com.bytedance.applet.debugger;

import com.bytedance.ai.api.DebuggerMode;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public interface y {

    public static final class a implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f191766a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f191766a, ((a) r100).f191766a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f191766a.hashCode();
        }

        public final String toString() {
            return "Ready(conversationId=" + this.f191766a + ')';
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            this.f191766a = r100;
        }
    }

    public static final class b implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f191767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DebuggerMode f191768b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f191767a, r101.f191767a) == true) goto L12;
            return false;
        L12:
            if (this.f191768b == r101.f191768b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f191767a.hashCode() * 31) + this.f191768b.hashCode();
        }

        public final String toString() {
            return "SwitchingMode(conversationId=" + this.f191767a + ", target=" + this.f191768b + ')';
        }

        public b(String r100, DebuggerMode r101) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
            this.f191767a = r100;
            this.f191768b = r101;
        }
    }
}
