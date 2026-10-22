package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1668i {

    /* renamed from: com.google.android.gms.common.internal.i$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final List f19833a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f19834b;

        public /* synthetic */ a(Object obj, G g10) {
            C1669j.k(obj);
            this.f19834b = obj;
            this.f19833a = new ArrayList();
        }

        public a a(String str, Object obj) {
            C1669j.k(str);
            this.f19833a.add(str + "=" + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(100);
            sb2.append(this.f19834b.getClass().getSimpleName());
            sb2.append('{');
            int size = this.f19833a.size();
            for (int i10 = 0; i10 < size; i10++) {
                sb2.append((String) this.f19833a.get(i10));
                if (i10 < size - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append('}');
            return sb2.toString();
        }
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a c(Object obj) {
        return new a(obj, null);
    }
}
