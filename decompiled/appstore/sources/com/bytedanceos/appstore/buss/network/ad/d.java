package com.bytedanceos.appstore.buss.network.ad;

import com.bytedanceos.appstore.buss.network.HttpResultHead;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8790a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8791b;

        public a(String r10, int r11) {
            q.g(r10, "errorMsg");
            super(null);
            this.f8790a = r10;
            this.f8791b = r11;
        }

        public final String a() {
            return this.f8790a;
        }

        public String toString() {
            return String.valueOf(this.f8790a);
        }

        public /* synthetic */ a(String r10, int r11, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 2) == 0) goto L5;
            r11 = -1;
        L5:
            this(r10, r11);
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f8792a = null;

        static {
            f8792a = new b();
        }

        public b() {
            super(null);
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HttpResultHead f8793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f8794b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f8795c;

        public c(HttpResultHead r10, List r11, String r12) {
            q.g(r10, ServerElements.HEAD);
            super(null);
            this.f8793a = r10;
            this.f8794b = r11;
            this.f8795c = r12;
        }

        public final List a() {
            return this.f8794b;
        }

        public final HttpResultHead b() {
            return this.f8793a;
        }

        public final String c() {
            return this.f8795c;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (q.b(this.f8793a, r11.f8793a) == true) goto L12;
            return false;
        L12:
            if (q.b(this.f8794b, r11.f8794b) == true) goto L15;
            return false;
        L15:
            if (q.b(this.f8795c, r11.f8795c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r10 = this.f8793a.hashCode() * 31;
            List r11 = this.f8794b;
            int r12 = 0;
            if (r11 != null) goto L5;
            int r13 = 0;
        L6:
            int r14 = (r10 + r13) * 31;
            String r15 = this.f8795c;
            if (r15 == null) goto L11;
            r12 = r15.hashCode();
        L11:
            return r14 + r12;
        L5:
            r13 = r11.hashCode();
            goto L6
        }

        public String toString() {
            return "Success(head=" + this.f8793a + ", data=" + this.f8794b + ", message=" + this.f8795c + ')';
        }
    }

    public /* synthetic */ d(DefaultConstructorMarker r10) {
        this();
    }

    public d() {
    }
}
