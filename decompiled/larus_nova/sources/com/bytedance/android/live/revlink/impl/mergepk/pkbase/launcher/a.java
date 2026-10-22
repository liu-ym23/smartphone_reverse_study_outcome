package com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.revlink.link.biz.component.MultiPKLauncher;
import com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage;
import com.bytedance.android.livesdk.link.model.ILinkMicBizInviteMessage;
import com.bytedance.android.livesdk.link.model.ILinkMicBizReplyMessage;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.e5;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import w20.o7;
import w20.q7;

/* JADX INFO: loaded from: classes47.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a$a, reason: collision with other inner class name */
    public static final class C1441a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ILinkMicBattleInviteMessage f92785a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C1441a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f92785a, ((C1441a) r100).f92785a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            ILinkMicBattleInviteMessage r100 = this.f92785a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "BattleInviteEvent(inviteMessage=" + this.f92785a + ")";
        }

        public C1441a(ILinkMicBattleInviteMessage r100) {
            Intrinsics.checkNotNullParameter(r100, "inviteMessage");
            this.f92785a = r100;
        }
    }

    public interface b {
        void a(q7 r100);

        void onFailed(Throwable r100);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e5 f92786a;

        public c() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f92786a, ((c) r100).f92786a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            e5 r100 = this.f92786a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "BattleReplyEvent(rejectMessage=" + this.f92786a + ")";
        }

        public c(e5 r100) {
            this.f92786a = r100;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ILinkMicBizInviteMessage f92787a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f92787a, ((d) r100).f92787a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            ILinkMicBizInviteMessage r100 = this.f92787a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "BizInviteEvent(bizInviteMessage=" + this.f92787a + ")";
        }

        public d(ILinkMicBizInviteMessage r100) {
            Intrinsics.checkNotNullParameter(r100, "bizInviteMessage");
            this.f92787a = r100;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ILinkMicBizReplyMessage f92788a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof e) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f92788a, ((e) r100).f92788a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            ILinkMicBizReplyMessage r100 = this.f92788a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "BizReplyEvent(bizReplyMessage=" + this.f92788a + ")";
        }

        public e(ILinkMicBizReplyMessage r100) {
            Intrinsics.checkNotNullParameter(r100, "bizReplyMessage");
            this.f92788a = r100;
        }
    }

    public static final class f {
        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof f) == false) goto L8;
            ((f) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L13;
            return false;
        L13:
            return true;
        L8:
            return false;
        }

        public final int hashCode() {
            return 0;
        }

        public final String toString() {
            return "BizReplyResponseEvent(bizReplyParams=null)";
        }
    }

    public static final class g {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(a r100, c21.e r101, MultiPKLauncher.c r102, Map r103, int r104) {
            if ((r104 & 2) == 0) goto L6;
            r102 = null;
        L6:
            if ((r104 & 4) == 0) goto L8;
            r103 = null;
        L8:
            r100.a(r101, r102, r103);
        }
    }

    void a(c21.e r100, c21.d r101, Map<String, String> r102);

    void b(c21.b r100, c21.a r101);

    void c(c21.g r100);

    void d(long r100, aa r101);

    MutableLiveData e();

    MutableLiveData f();

    MutableLiveData g();

    MutableLiveData h();

    void i(c21.i r100, b r101);

    MutableLiveData j();

    void k(c21.k r100);

    MutableLiveData l();

    void m(o7 r100, com.bytedance.android.live.revlink.impl.jsb.a r101);

    void n();

    void o(c21.j r100, b r101);

    boolean p();
}
