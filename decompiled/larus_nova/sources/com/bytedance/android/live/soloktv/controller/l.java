package com.bytedance.android.live.soloktv.controller;

import com.bytedance.android.live.soloktv.view.SegmentSelectResult;

/* JADX INFO: loaded from: classes7.dex */
public abstract class l {

    public static final class a extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f101057a;

        public a() {
            this(false);
        }

        public a(boolean r100) {
            this.f101057a = r100;
        }
    }

    public static final class b extends l {
        public b() {
        }
    }

    public static final class c extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f101058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f101059b;

        public c() {
            this(false, false);
        }

        public c(boolean r100, boolean r101) {
            this.f101058a = r100;
            this.f101059b = r101;
        }
    }

    public static final class d extends l {
        public d() {
        }
    }

    public static final class e extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f101060a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f101061b;

        public e() {
            boolean r100 = false;
            this(r100, 3);
        }

        public /* synthetic */ e(boolean r100, int r101) {
            if ((r101 & 1) == 0) goto L5;
            r100 = false;
        L5:
            this(r100, false);
        }

        public e(boolean r100, boolean r101) {
            this.f101060a = r100;
            this.f101061b = r101;
        }
    }

    public static final class f extends l {
        public f() {
        }

        public f(int r100) {
        }

        public f(Object r100) {
        }
    }

    public static final class g extends l {
        public g() {
        }
    }

    public static final class h extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Long f101062a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f101063b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SegmentSelectResult f101064c;

        /* JADX WARN: Multi-variable type inference failed */
        public h() {
            Long r100 = null;
            Object[] r101 = 0 == true ? 1 : 0;
            this(r100, false, r101, 7);
        }

        public h(Long r100, boolean r101, SegmentSelectResult r102) {
            this.f101062a = r100;
            this.f101063b = r101;
            this.f101064c = r102;
        }

        public /* synthetic */ h(Long r100, boolean r101, SegmentSelectResult r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r100 = 0L;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = false;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = null;
        L11:
            this(r100, r101, r102);
        }
    }

    public static final class i extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f101065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Boolean f101066b;

        public i(boolean r100, Boolean r101) {
            this.f101065a = r100;
            this.f101066b = r101;
        }
    }

    public l() {
    }
}
