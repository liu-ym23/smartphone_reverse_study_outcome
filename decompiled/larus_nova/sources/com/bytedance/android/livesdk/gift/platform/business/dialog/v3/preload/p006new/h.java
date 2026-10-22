package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p006new;

import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftPanelMonitorService;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public abstract class h {

    public static final class a extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f128228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f128229b;

        public a(int r100, boolean r101) {
            this.f128228a = r100;
            this.f128229b = r101;
        }
    }

    public static final class b extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f128230a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f128231b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final k f128232c;

        public b(int r100, int r101, k r102) {
            this.f128230a = r100;
            this.f128231b = r101;
            this.f128232c = r102;
        }
    }

    public static final class c extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f128233a = null;

        static {
            f128233a = new c();
        }

        public c() {
        }
    }

    public static final class d extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f128234a = null;

        static {
            f128234a = new d();
        }

        public d() {
        }
    }

    public static final class e extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final GiftPanelMonitorService.b f128235a;

        public e(GiftPanelMonitorService.b r100) {
            this.f128235a = r100;
        }
    }

    public static final class f extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<w1> f128236a;

        /* JADX WARN: Multi-variable type inference failed */
        public f(List<? extends w1> r100) {
            Intrinsics.checkNotNullParameter(r100, "giftPages");
            this.f128236a = r100;
        }
    }

    public static final class g extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f128237a = null;

        static {
            f128237a = new g();
        }

        public g() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.new.h$h, reason: collision with other inner class name */
    public static final class C2058h extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f128238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f128239b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final IntRange f128240c;

        public C2058h(boolean r100, int r101, IntRange r102) {
            Intrinsics.checkNotNullParameter(r102, "currentRange");
            this.f128238a = r100;
            this.f128239b = r101;
            this.f128240c = r102;
        }
    }

    public static final class i extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f128241a = null;

        static {
            f128241a = new i();
        }

        public i() {
        }
    }

    public h() {
    }

    public final String toString() {
        if ((this instanceof i) == false) goto L6;
        return "TouchDown";
    L6:
        if ((this instanceof g) == false) goto L9;
        return "OpenRecharge";
    L9:
        if ((this instanceof d) == false) goto L12;
        return "CreatePanel";
    L12:
        if ((this instanceof c) == false) goto L15;
        return "ClosePanel";
    L15:
        if ((this instanceof f) == false) goto L18;
        return "EnterRoom";
    L18:
        if ((this instanceof e) == false) goto L21;
        return "DefaultSelect{" + ((e) this).f128235a + '}';
    L21:
        if ((this instanceof C2058h) == false) goto L24;
        StringBuilder r100 = new StringBuilder("ScrollList{firstDragging=");
        C2058h r101 = (C2058h) this;
        r100.append(r101.f128238a);
        r100.append(", tab=");
        r100.append(r101.f128239b);
        r100.append(", range=");
        r100.append(r101.f128240c);
        r100.append('}');
        return r100.toString();
    L24:
        if ((this instanceof a) == false) goto L27;
        return "ChangeTab{" + ((a) this).f128228a + '}';
    L27:
        if ((this instanceof b) == false) goto L31;
        StringBuilder r102 = new StringBuilder("ClickIcon{");
        b r103 = (b) this;
        r102.append(r103.f128231b);
        r102.append('-');
        r102.append(r103.f128230a);
        r102.append('}');
        return r102.toString();
    L31:
        throw new NoWhenBranchMatchedException();
    }
}
