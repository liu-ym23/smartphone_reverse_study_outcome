package bk6;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import ek6.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f19368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gk6.a f19369b;

    /* JADX INFO: renamed from: bk6.a$a, reason: collision with other inner class name */
    public static final class C0311a {
    }

    static {
    }

    public a() {
        this.f19368a = new ArrayList();
    }

    public final void a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        ((ArrayList) this.f19368a).add(r100);
    }

    public final a insert(int r100, d r101) {
        Intrinsics.checkNotNullParameter(r101, "content");
        ListProtector.add(this.f19368a, r100, r101);
        return this;
    }
}
