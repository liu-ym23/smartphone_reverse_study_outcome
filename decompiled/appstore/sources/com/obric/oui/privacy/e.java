package com.obric.oui.privacy;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e {

    public static final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f16398a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f16399b;

        public a(String r10, List r11) {
            q.g(r10, "description");
            q.g(r11, "permissions");
            super(null);
            this.f16398a = r10;
            this.f16399b = r11;
        }

        public final String a() {
            return this.f16398a;
        }

        public final List b() {
            return this.f16399b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (q.b(this.f16398a, r11.f16398a) == true) goto L12;
            return false;
        L12:
            if (q.b(this.f16399b, r11.f16399b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f16398a.hashCode() * 31) + this.f16399b.hashCode();
        }

        public String toString() {
            return "PermissionItem(description=" + this.f16398a + ", permissions=" + this.f16399b + ')';
        }
    }

    public static final class b extends e {
    }

    public /* synthetic */ e(DefaultConstructorMarker r10) {
        this();
    }

    public e() {
    }
}
