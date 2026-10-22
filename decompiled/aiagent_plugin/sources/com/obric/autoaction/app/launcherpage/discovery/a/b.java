package com.obric.autoaction.app.launcherpage.discovery.a;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DiscoveryModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements com.obric.autoaction.app.launcherpage.ui.h {

    /* JADX INFO: compiled from: DiscoveryModel.kt */
    public static final class a extends AbstractC0524b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f23573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e f23574b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.obric.autoaction.app.launcherpage.discovery.util.c f23575c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f23573a == r6.f23573a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f23574b, r6.f23574b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f23575c, r6.f23575c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.f23573a) * 31) + this.f23574b.hashCode()) * 31) + this.f23575c.hashCode();
        }

        public String toString() {
            return "AutoInstructionItem(isAdded=" + this.f23573a + ", instruction=" + this.f23574b + ", slotParseResult=" + this.f23575c + ')';
        }

        @Override // com.obric.autoaction.app.launcherpage.discovery.a.b.AbstractC0524b
        public e a() {
            return this.f23574b;
        }

        @Override // com.obric.autoaction.app.launcherpage.discovery.a.b.AbstractC0524b
        public com.obric.autoaction.app.launcherpage.discovery.util.c b() {
            return this.f23575c;
        }

        public a(boolean r2, e r3, com.obric.autoaction.app.launcherpage.discovery.util.c r4) {
            d.h.b.o.e(r3, "instruction");
            d.h.b.o.e(r4, "slotParseResult");
            super(r2, r3, r4);
            this.f23573a = r2;
            this.f23574b = r3;
            this.f23575c = r4;
        }

        @Override // com.obric.autoaction.app.launcherpage.ui.h
        public boolean a(com.obric.autoaction.app.launcherpage.ui.h r4) {
            com.obric.autoaction.app.launcherpage.ui.h r5 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "other");
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L5;
        L7:
            return false;
        L5:
            if (d.h.b.o.a(((a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin")).a(), a()) == false) goto L7;
            return true;
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.discovery.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DiscoveryModel.kt */
    public static abstract class AbstractC0524b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f23576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e f23577b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.obric.autoaction.app.launcherpage.discovery.util.c f23578c;

        @Override // com.obric.autoaction.app.launcherpage.discovery.a.b, com.obric.autoaction.app.launcherpage.ui.h
        public Object c(com.obric.autoaction.app.launcherpage.ui.h r2) {
            com.obric.autoaction.app.launcherpage.ui.h r1 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r1, "newItem");
            return r1;
        }

        public e a() {
            return this.f23577b;
        }

        public com.obric.autoaction.app.launcherpage.discovery.util.c b() {
            return this.f23578c;
        }

        public AbstractC0524b(boolean r2, e r3, com.obric.autoaction.app.launcherpage.discovery.util.c r4) {
            d.h.b.o.e(r3, "instruction");
            d.h.b.o.e(r4, "slotParseResult");
            super(null);
            this.f23576a = r2;
            this.f23577b = r3;
            this.f23578c = r4;
        }

        @Override // com.obric.autoaction.app.launcherpage.ui.h
        public boolean b(com.obric.autoaction.app.launcherpage.ui.h r3) {
            com.obric.autoaction.app.launcherpage.ui.h r4 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "other");
            return d.h.b.o.a(this, r4);
        }
    }

    /* JADX INFO: compiled from: DiscoveryModel.kt */
    public static final class c extends AbstractC0524b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f23579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e f23580b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.obric.autoaction.app.launcherpage.discovery.util.c f23581c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (this.f23579a == r6.f23579a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f23580b, r6.f23580b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f23581c, r6.f23581c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.f23579a) * 31) + this.f23580b.hashCode()) * 31) + this.f23581c.hashCode();
        }

        public String toString() {
            return "ShortInstructionItem(isAdded=" + this.f23579a + ", instruction=" + this.f23580b + ", slotParseResult=" + this.f23581c + ')';
        }

        @Override // com.obric.autoaction.app.launcherpage.discovery.a.b.AbstractC0524b
        public e a() {
            return this.f23580b;
        }

        @Override // com.obric.autoaction.app.launcherpage.discovery.a.b.AbstractC0524b
        public com.obric.autoaction.app.launcherpage.discovery.util.c b() {
            return this.f23581c;
        }

        public c(boolean r2, e r3, com.obric.autoaction.app.launcherpage.discovery.util.c r4) {
            d.h.b.o.e(r3, "instruction");
            d.h.b.o.e(r4, "slotParseResult");
            super(r2, r3, r4);
            this.f23579a = r2;
            this.f23580b = r3;
            this.f23581c = r4;
        }

        @Override // com.obric.autoaction.app.launcherpage.ui.h
        public boolean a(com.obric.autoaction.app.launcherpage.ui.h r4) {
            com.obric.autoaction.app.launcherpage.ui.h r5 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "other");
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L5;
        L7:
            return false;
        L5:
            if (d.h.b.o.a(((c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin")).a(), a()) == false) goto L7;
            return true;
        }
    }

    /* JADX INFO: compiled from: DiscoveryModel.kt */
    public static final class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f23582a;

        @Override // com.obric.autoaction.app.launcherpage.discovery.a.b, com.obric.autoaction.app.launcherpage.ui.h
        public Object c(com.obric.autoaction.app.launcherpage.ui.h r2) {
            com.obric.autoaction.app.launcherpage.ui.h r1 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r1, "newItem");
            return r1;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f23582a, r6.f23582a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f23582a.hashCode();
        }

        public String toString() {
            return "TitleItem(title=" + this.f23582a + ')';
        }

        public d(String r2) {
            d.h.b.o.e(r2, DBDefinition.TITLE);
            super(null);
            this.f23582a = r2;
        }

        public final String a() {
            return this.f23582a;
        }

        @Override // com.obric.autoaction.app.launcherpage.ui.h
        public boolean a(com.obric.autoaction.app.launcherpage.ui.h r4) {
            com.obric.autoaction.app.launcherpage.ui.h r5 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "other");
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L5;
        L7:
            return false;
        L5:
            if (d.h.b.o.a(((d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin")).f23582a, this.f23582a) == false) goto L7;
            return true;
        }

        @Override // com.obric.autoaction.app.launcherpage.ui.h
        public boolean b(com.obric.autoaction.app.launcherpage.ui.h r3) {
            com.obric.autoaction.app.launcherpage.ui.h r4 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "other");
            return d.h.b.o.a(this, r4);
        }
    }

    public /* synthetic */ b(d.h.b.h r1) {
        this();
    }

    private b() {
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public Object c(com.obric.autoaction.app.launcherpage.ui.h r3) {
        return com.obric.autoaction.app.launcherpage.ui.h.a.a(this, (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin"));
    }
}
