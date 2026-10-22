package com.bytedance.android.shopping.mall.feed.ability;

import com.bytedance.android.ec.hybrid.list.ability.x;
import com.bytedance.android.shopping.api.mall.common.tools.MallBehaviorUtil;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a.C2620a f176859a;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.feed.ability.d$a$a, reason: collision with other inner class name */
        public static final class C2620a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f176860a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof C2620a) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.f176860a, ((C2620a) r100).f176860a) == true) goto L13;
                return false;
            L13:
                return true;
            }

            public final int hashCode() {
                String r100 = this.f176860a;
                if (r100 != null) goto L7;
                return 0;
            L7:
                return r100.hashCode();
            }

            public final String toString() {
                return "MallEnginLynxCardHelpParams(pageName=" + this.f176860a + ")";
            }

            public C2620a(String r100) {
                Intrinsics.checkNotNullParameter(r100, "pageName");
                this.f176860a = r100;
            }
        }
    }

    static {
    }

    public d(a.C2620a r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f176859a = r100;
    }

    @Override // com.bytedance.android.ec.hybrid.list.ability.x
    public final List<Object> a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cardSchema");
        Lazy r101 = MallBehaviorUtil.f170407a;
        a.C2620a r102 = this.f176859a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "schema");
        return MallBehaviorUtil.a(new MallBehaviorUtil.a(r102.f176860a, r100));
    }
}
