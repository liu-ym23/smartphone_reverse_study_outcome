package com.bytedance.android.live.revlink.impl.multianchor.match;

import com.bytedance.android.live.revlink.impl.multianchor.utils.x;

/* JADX INFO: loaded from: classes47.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f94381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f94382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f94383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f94384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f94385e;

    public static final class a extends c {
        @Override // com.bytedance.android.live.revlink.impl.multianchor.match.c
        public final String a() {
            return "ActiveMatching";
        }

        public a(int r100, int r101) {
            super(true, r100, false, false, r101, 32);
        }
    }

    public static final class b extends c {
        @Override // com.bytedance.android.live.revlink.impl.multianchor.match.c
        public final String a() {
            return "ActiveSpeedUpMatching";
        }

        public b(int r100, int r101) {
            super(true, r100, true, false, r101, 32);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.multianchor.match.c$c, reason: collision with other inner class name */
    public static final class C1460c extends c {
        public C1460c() {
            super(false, 0, false, false, 0, 48);
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.match.c
        public final String a() {
            return "NotMatching";
        }
    }

    public static final class d extends c {
        @Override // com.bytedance.android.live.revlink.impl.multianchor.match.c
        public final String a() {
            return "PassiveMatching";
        }

        public d(int r100) {
            super(true, r100, false, true, 0, 48);
        }
    }

    public static final class e extends c {
        @Override // com.bytedance.android.live.revlink.impl.multianchor.match.c
        public final String a() {
            return "Waiting2v2Match";
        }

        public e(int r100) {
            super(false, 11, false, false, r100);
        }
    }

    public abstract String a();

    public final String toString() {
        if (this.f94381a == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == false) goto L11;
        return "TeamPk" + a();
    L11:
        return a();
    L5:
        if (x.d(this.f94382b) == false) goto L7;
        r100 = true;
        goto L8
    }

    public c(boolean r100, int r101, boolean r102, boolean r103, int r104) {
        this.f94381a = r100;
        this.f94382b = r101;
        this.f94383c = r102;
        this.f94384d = r103;
        this.f94385e = r104;
    }

    public /* synthetic */ c(boolean r100, int r110, boolean r111, boolean r112, int r113, int r114) {
        if ((r114 & 4) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r114 & 8) == 0) goto L9;
        boolean r102 = false;
    L11:
        if ((r114 & 16) == 0) goto L13;
        int r103 = 0;
    L14:
        this(r100, r110, r101, r102, r103);
        return;
    L13:
        r103 = r113;
        goto L14
    L9:
        r102 = r112;
        goto L11
    L5:
        r101 = r111;
        goto L7
    }
}
