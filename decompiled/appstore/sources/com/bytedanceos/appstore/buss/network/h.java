package com.bytedanceos.appstore.buss.network;

import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.j;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    public static final class a extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8816b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Throwable f8817c;

        public /* synthetic */ a(String r10, int r11, Throwable r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 2) == 0) goto L6;
            r11 = -1;
        L6:
            if ((r13 & 4) == 0) goto L8;
            r12 = null;
        L8:
            this(r10, r11, r12);
        }

        public final Throwable a() {
            return this.f8817c;
        }

        public final int b() {
            return this.f8816b;
        }

        public final String c() {
            return this.f8815a;
        }

        public String toString() {
            return String.valueOf(this.f8815a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public a(String r11, int r12, Throwable r13) {
            q.g(r11, "errorMsg");
            String r10 = 0;
            r10 = 0;
            r10 = 0;
            r10 = 0;
            super(r10);
            this.f8815a = r11;
            this.f8816b = r12;
            this.f8817c = r13;
            if (r13 == null) goto L12;
            StackTraceElement[] r14 = r13.getStackTrace();
            if (r14 == null) goto L12;
            Iterator r15 = kotlin.jvm.internal.h.a(r14);
            if (r15 == null) goto L12;
            Sequence r16 = SequencesKt__SequencesKt.c(r15);
            if (r16 == null) goto L12;
            r10 = SequencesKt___SequencesKt.q(r16, "\n", null, null, 0, null, null, 62, null);
        L12:
            if (r10 == 0) goto L14;
            j.a("NetSource.Error " + r10);
        L14:
            j.a("NetSource.Error " + r12 + "  " + r11);
        }
    }

    public static final class b extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f8818a = null;

        static {
            f8818a = new b();
        }

        public b() {
            super(null);
        }
    }

    public static final class c extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HttpResultHead f8819a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f8820b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f8821c;

        public c(HttpResultHead r10, Object r11, String r12) {
            q.g(r10, ServerElements.HEAD);
            super(null);
            this.f8819a = r10;
            this.f8820b = r11;
            this.f8821c = r12;
        }

        public final Object a() {
            return this.f8820b;
        }

        public final HttpResultHead b() {
            return this.f8819a;
        }

        public final String c() {
            return this.f8821c;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (q.b(this.f8819a, r11.f8819a) == true) goto L12;
            return false;
        L12:
            if (q.b(this.f8820b, r11.f8820b) == true) goto L15;
            return false;
        L15:
            if (q.b(this.f8821c, r11.f8821c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r10 = this.f8819a.hashCode() * 31;
            Object r11 = this.f8820b;
            int r12 = 0;
            if (r11 != null) goto L5;
            int r13 = 0;
        L6:
            int r14 = (r10 + r13) * 31;
            String r15 = this.f8821c;
            if (r15 == null) goto L11;
            r12 = r15.hashCode();
        L11:
            return r14 + r12;
        L5:
            r13 = r11.hashCode();
            goto L6
        }

        public String toString() {
            return "Success(head=" + this.f8819a + ", data=" + this.f8820b + ", message=" + this.f8821c + ')';
        }
    }

    public /* synthetic */ h(DefaultConstructorMarker r10) {
        this();
    }

    public h() {
    }
}
