package com.obric.oui.privacy;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.List;

/* JADX INFO: compiled from: OPrivacySheetConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d {

    /* JADX INFO: compiled from: OPrivacySheetConfig.kt */
    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f36095a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<String> f36096b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f36095a, r6.f36095a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f36096b, r6.f36096b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f36095a.hashCode() * 31) + this.f36096b.hashCode();
        }

        public String toString() {
            return "PermissionItem(description=" + this.f36095a + ", permissions=" + this.f36096b + ')';
        }

        public final String a() {
            return this.f36095a;
        }

        public final List<String> b() {
            return this.f36096b;
        }
    }

    /* JADX INFO: compiled from: OPrivacySheetConfig.kt */
    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f36097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f36098b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f36099c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final d.h.a.b<Boolean, x> f36100d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f36097a, r6.f36097a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f36098b, r6.f36098b) == true) goto L15;
            return false;
        L15:
            if (this.f36099c == r6.f36099c) goto L18;
            return false;
        L18:
            if (o.a(this.f36100d, r6.f36100d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v7 */
        public int hashCode() {
            int r0 = this.f36097a.hashCode() * 31;
            String r1 = this.f36098b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            boolean r5 = this.f36099c;
            ?? r6 = r5;
            if (r5 == false) goto L9;
            r6 = 1;
        L9:
            int r7 = (r4 + r6) * 31;
            d.h.a.b<Boolean, x> r8 = this.f36100d;
            if (r8 == null) goto L14;
            r2 = r8.hashCode();
        L14:
            return r7 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "SwitchItem(title=" + this.f36097a + ", subtitle=" + this.f36098b + ", isChecked=" + this.f36099c + ", onCheckedChange=" + this.f36100d + ')';
        }

        public final String a() {
            return this.f36097a;
        }

        public final String b() {
            return this.f36098b;
        }

        public final boolean c() {
            return this.f36099c;
        }

        public final d.h.a.b<Boolean, x> d() {
            return this.f36100d;
        }
    }

    private d() {
    }
}
