package io.ktor.utils.io;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class o0 {

    /* renamed from: b, reason: collision with root package name */
    public static final List f3224b = c5.l.S(new o0[]{new o0(1), new o0(2), new o0(4)});

    /* renamed from: a, reason: collision with root package name */
    public final int f3225a;

    public /* synthetic */ o0(int i8) {
        this.f3225a = i8;
    }

    public static String a(int i8) {
        if (i8 == 1) {
            return "CR";
        }
        if (i8 == 2) {
            return "LF";
        }
        if (i8 == 4) {
            return "CRLF";
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : f3224b) {
            if ((((o0) obj).f3225a | i8) == i8) {
                arrayList.add(obj);
            }
        }
        return arrayList.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof o0) {
            return this.f3225a == ((o0) obj).f3225a;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f3225a);
    }

    public final String toString() {
        return a(this.f3225a);
    }
}
