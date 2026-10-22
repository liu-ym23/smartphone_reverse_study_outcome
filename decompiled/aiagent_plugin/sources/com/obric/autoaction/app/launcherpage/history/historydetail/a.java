package com.obric.autoaction.app.launcherpage.history.historydetail;

import com.obric.autoaction.app.launcherpage.ui.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: HistoryDetailState.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.history.historydetail.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HistoryDetailState.kt */
    public static final class C0538a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f23853a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0538a.class) == true) goto L8;
            return false;
        L8:
            C0538a r6 = (C0538a) ZeusTransformUtils.preCheckCast(r5, C0538a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f23853a, r6.f23853a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f23853a.hashCode();
        }

        public String toString() {
            return "Error(message=" + this.f23853a + ')';
        }
    }

    /* JADX INFO: compiled from: HistoryDetailState.kt */
    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f23854a = null;

        static {
            f23854a = new b();
        }

        private b() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: HistoryDetailState.kt */
    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<h> f23855a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f23855a, r6.f23855a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f23855a.hashCode();
        }

        public String toString() {
            return "Success(steps=" + this.f23855a + ')';
        }

        public c(List<? extends h> r3) {
            List<h> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            o.e(r4, "steps");
            super(null);
            this.f23855a = r4;
        }

        public final List<h> a() {
            return this.f23855a;
        }
    }

    public /* synthetic */ a(d.h.b.h r1) {
        this();
    }

    private a() {
    }
}
