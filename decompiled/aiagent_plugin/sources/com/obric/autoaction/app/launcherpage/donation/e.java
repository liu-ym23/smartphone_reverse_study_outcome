package com.obric.autoaction.app.launcherpage.donation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: DonationTaskRecordCell.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: compiled from: DonationTaskRecordCell.kt */
    public static class a {
        public a() {
        }
    }

    /* JADX INFO: compiled from: DonationTaskRecordCell.kt */
    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f23736a;

        public b(String r2) {
            o.e(r2, "date");
            this.f23736a = r2;
        }

        public final String a() {
            return this.f23736a;
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            Class<?> r1 = getClass();
            if (r4 == null) goto L9;
            Class<?> r2 = r4.getClass();
        L11:
            if (o.a(r1, r2) == true) goto L14;
            return false;
        L14:
            o.a(r4, "null cannot be cast to non-null type com.obric.autoaction.app.launcherpage.donation.DonationTaskRecordCell.DateTitleBar");
            b r3 = (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin");
            return o.a(this.f23736a, ((b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin")).f23736a);
        L9:
            r2 = null;
            goto L11
        }

        public int hashCode() {
            return this.f23736a.hashCode();
        }
    }

    /* JADX INFO: compiled from: DonationTaskRecordCell.kt */
    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.autoaction.app.launcherpage.donation.model.a f23737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f23738b;

        public c(com.obric.autoaction.app.launcherpage.donation.model.a r2) {
            o.e(r2, "task");
            this.f23737a = r2;
        }

        public final com.obric.autoaction.app.launcherpage.donation.model.a a() {
            return this.f23737a;
        }

        public final void a(int r1) {
            this.f23738b = r1;
        }

        public final int b() {
            return this.f23738b;
        }

        public boolean equals(Object r6) {
            if (this != r6) goto L5;
            return true;
        L5:
            Class<?> r2 = getClass();
            if (r6 == null) goto L8;
            Class<?> r3 = r6.getClass();
        L10:
            if (o.a(r2, r3) == true) goto L12;
            return false;
        L12:
            o.a(r6, "null cannot be cast to non-null type com.obric.autoaction.app.launcherpage.donation.DonationTaskRecordCell.RecordCell");
            c r4 = (c) ZeusTransformUtils.preCheckCast(r6, c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f23737a, ((c) ZeusTransformUtils.preCheckCast(r6, c.class, "com.obric.aiagent.plugin")).f23737a) == true) goto L15;
            return false;
        L15:
            return true;
        L8:
            r3 = null;
            goto L10
        }

        public int hashCode() {
            return this.f23737a.hashCode();
        }
    }

    public boolean equals(Object r1) {
        return super.equals(r1);
    }

    public int hashCode() {
        return getClass().hashCode();
    }
}
