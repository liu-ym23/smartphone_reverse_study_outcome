package com.bytedance.android.live.core.tetris.layer.core.layout;

import com.bytedance.android.live.core.tetris.layer.core.ViewLayer;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.android.live.core.tetris.layer.core.layout.a$a, reason: collision with other inner class name */
    public static final class C1085a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Element<?> f65775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<ElementConstraint.c> f65776b;

        public final String toString() {
            return "Dependency(element=" + this.f65775a + ", rules=" + this.f65776b + ")";
        }

        public final int hashCode() {
            return this.f65775a.hashCode();
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof C1085a) == true) goto L5;
            r100 = null;
        L5:
            C1085a r101 = (C1085a) r100;
            if (r101 != null) goto L8;
            return false;
        L8:
            return Intrinsics.areEqual(r101.f65775a, this.f65775a);
        }

        public C1085a(Element<?> r100, List<ElementConstraint.c> r101) {
            Intrinsics.checkNotNullParameter(r100, "element");
            Intrinsics.checkNotNullParameter(r101, "rules");
            this.f65775a = r100;
            this.f65776b = r101;
        }
    }

    boolean a(ViewLayer r100);

    boolean b(ViewLayer r100);

    void c(ViewLayer r100, C1085a r101);

    void d(ViewLayer r100, Element<?> r101);

    void g(Element<?> r100, ViewLayer r101);
}
