package com.obric.oui.texteffects.a;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: TextEffectProtocol.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d {

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f36376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f36377b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final k f36378c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<l> f36379d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(a(), r6.a()) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f36377b, r6.f36377b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f36378c, r6.f36378c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(b(), r6.b()) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((a().hashCode() * 31) + this.f36377b.hashCode()) * 31;
            k r1 = this.f36378c;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + b().hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "ExternalView(id=" + a() + ", bindingKey=" + this.f36377b + ", material=" + this.f36378c + ", properties=" + b() + ')';
        }

        @Override // com.obric.oui.texteffects.a.d
        public String a() {
            return this.f36376a;
        }

        public final String c() {
            return this.f36377b;
        }

        public final k d() {
            return this.f36378c;
        }

        @Override // com.obric.oui.texteffects.a.d
        public List<l> b() {
            return this.f36379d;
        }

        public a(String r3, String r4, k r5, List<l> r6) {
            List<l> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, DbHelper.COL_ID);
            d.h.b.o.e(r4, "bindingKey");
            d.h.b.o.e(r7, "properties");
            super(null);
            this.f36376a = r3;
            this.f36377b = r4;
            this.f36378c = r5;
            this.f36379d = r7;
        }
    }

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f36380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final o f36381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final h f36382c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final com.obric.oui.texteffects.a.a f36383d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List<l> f36384e;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(a(), r6.a()) == true) goto L12;
            return false;
        L12:
            if (this.f36381b == r6.f36381b) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f36382c, r6.f36382c) == true) goto L18;
            return false;
        L18:
            if (this.f36383d == r6.f36383d) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(b(), r6.b()) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((a().hashCode() * 31) + this.f36381b.hashCode()) * 31) + this.f36382c.hashCode()) * 31) + this.f36383d.hashCode()) * 31) + b().hashCode();
        }

        public String toString() {
            return "Text(id=" + a() + ", source=" + this.f36381b + ", fill=" + this.f36382c + ", blend=" + this.f36383d + ", properties=" + b() + ')';
        }

        @Override // com.obric.oui.texteffects.a.d
        public String a() {
            return this.f36380a;
        }

        public final o c() {
            return this.f36381b;
        }

        public final h d() {
            return this.f36382c;
        }

        public /* synthetic */ b(String r7, o r8, h r9, com.obric.oui.texteffects.a.a r10, List r11, int r12, d.h.b.h r13) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
            if ((r12 & 8) == 0) goto L5;
            r10 = com.obric.oui.texteffects.a.a.f36361d;
        L5:
            this(r7, r8, r9, r10, r5);
        }

        public final com.obric.oui.texteffects.a.a e() {
            return this.f36383d;
        }

        @Override // com.obric.oui.texteffects.a.d
        public List<l> b() {
            return this.f36384e;
        }

        public b(String r3, o r4, h r5, com.obric.oui.texteffects.a.a r6, List<l> r7) {
            List<l> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, DbHelper.COL_ID);
            d.h.b.o.e(r4, DBHelper.BATTERY_COL_SOURCE);
            d.h.b.o.e(r5, "fill");
            d.h.b.o.e(r6, "blend");
            d.h.b.o.e(r8, "properties");
            super(null);
            this.f36380a = r3;
            this.f36381b = r4;
            this.f36382c = r5;
            this.f36383d = r6;
            this.f36384e = r8;
        }
    }

    public /* synthetic */ d(d.h.b.h r1) {
        this();
    }

    public abstract String a();

    public abstract List<l> b();

    private d() {
    }
}
