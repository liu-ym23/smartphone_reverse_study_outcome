package com.bytedance.android.annie.xbridge.mix;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class q implements com.bytedance.ies.web.jsbridge2.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IDLXBridgeMethod f40186a;

    public static final class a extends com.bytedance.ies.web.jsbridge2.f<Map<String, ? extends Object>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IDLXBridgeMethod f40187a;

        /* JADX INFO: renamed from: com.bytedance.android.annie.xbridge.mix.q$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0754a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f40188a = null;

            static {
                int[] r100 = new int[IDLXBridgeMethod.Access.values().length];
                r100[IDLXBridgeMethod.Access.PRIVATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r100[IDLXBridgeMethod.Access.PROTECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r100[IDLXBridgeMethod.Access.PUBLIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r100[IDLXBridgeMethod.Access.SECURE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                f40188a = r100;
            }
        }

        @Override // com.bytedance.ies.web.jsbridge2.f
        public final void onTerminate() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.d
        public final PermissionGroup getPermissionGroup() {
            IDLXBridgeMethod.Access r100 = this.f40187a.getAccess();
            int r101 = C0754a.f40188a[r100.ordinal()];
            if (r101 == 1) goto L16;
            if (r101 == 2) goto L19;
            if (r101 == 3) goto L18;
            if (r101 != 4) goto L12;
            return PermissionGroup.SECURE;
        L12:
            throw new NoWhenBranchMatchedException();
        L18:
            return PermissionGroup.PUBLIC;
        L19:
            return PermissionGroup.PROTECTED;
        L16:
            return PermissionGroup.PRIVATE;
        }

        public a(IDLXBridgeMethod r100) {
            this.f40187a = r100;
        }

        @Override // com.bytedance.ies.web.jsbridge2.f
        public final void invoke(Map<String, ? extends Object> r100, CallContext r101) {
            Map<String, ? extends Object> r102 = r100;
            Intrinsics.checkNotNullParameter(r102, "params");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            IDLXBridgeMethod r103 = this.f40187a;
            List<String> r104 = s.f40190a;
            r103.realHandle(new p(new o(r101, r102, r103.getName()), r101), r102, new r(this));
        }
    }

    public q(IDLXBridgeMethod r100) {
        this.f40186a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f.b
    public final com.bytedance.ies.web.jsbridge2.f a() {
        return new a(this.f40186a);
    }
}
