package com.bytedance.android.live.revlink.impl.multianchor.connect;

import com.bytedance.android.livesdk.link.model.i6;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class n {

    public static final class a extends n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i6 f93201a;

        public a(i6 r100) {
            Intrinsics.checkNotNullParameter(r100, "linkerMessage");
            this.f93201a = r100;
        }
    }

    public static final class b extends n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d11.o f93202a;

        public b(d11.o r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            this.f93202a = r100;
        }
    }

    public static final class c extends n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f93203a = null;

        static {
            f93203a = new c();
        }

        public c() {
        }
    }

    public n() {
    }

    public final String toString() {
        if (Intrinsics.areEqual(this, c.f93203a) == false) goto L6;
        return "None";
    L6:
        if ((this instanceof b) == false) goto L9;
        return "Inviting";
    L9:
        if ((this instanceof a) == false) goto L13;
        return "BeInvited";
    L13:
        throw new NoWhenBranchMatchedException();
    }
}
