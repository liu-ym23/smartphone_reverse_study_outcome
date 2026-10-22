package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler;

import android.net.Uri;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: PersistentAwarenessSubscriptionIds.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f17272a = null;

    /* JADX INFO: compiled from: PersistentAwarenessSubscriptionIds.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f17273a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f17274b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f17275c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f17273a, r6.f17273a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f17274b, r6.f17274b) == true) goto L15;
            return false;
        L15:
            if (this.f17275c == r6.f17275c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f17273a.hashCode() * 31) + this.f17274b.hashCode()) * 31) + Integer.hashCode(this.f17275c);
        }

        public String toString() {
            return "ParsedSubscription(kind=" + this.f17273a + ", taskId=" + this.f17274b + ", conditionIndex=" + this.f17275c + ')';
        }

        public a(String r2, String r3, int r4) {
            o.e(r2, "kind");
            o.e(r3, DBDefinition.TASK_ID);
            this.f17273a = r2;
            this.f17274b = r3;
            this.f17275c = r4;
        }

        public final String a() {
            return this.f17273a;
        }

        public final String b() {
            return this.f17274b;
        }

        public final int c() {
            return this.f17275c;
        }
    }

    static {
        f17272a = new g();
    }

    private g() {
    }

    public final String a(String r10, String r11, int r12) {
        o.e(r10, "kind");
        o.e(r11, DBDefinition.TASK_ID);
        return p.a((Iterable) ZeusTransformUtils.preCheckCast(p.b(new String[]{"condition_task", r10, Uri.encode(r11), String.valueOf(r12)}), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(":", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    }

    public final a a(String r8) {
        o.e(r8, "subscriptionId");
        List r7 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{":"}, false, 0, 6, null);
        if (r7.size() == 4) goto L5;
        return null;
    L5:
        if (o.a(r7.get(0), "condition_task") == false) goto L13;
        Integer r9 = d.o.o.d((String) ZeusTransformUtils.preCheckCast(r7.get(3), String.class, "com.obric.aiagent.plugin"));
        if (r9 == null) goto L12;
        int r10 = r9.intValue();
        String r2 = (String) ZeusTransformUtils.preCheckCast(r7.get(1), String.class, "com.obric.aiagent.plugin");
        String r11 = Uri.decode((String) ZeusTransformUtils.preCheckCast(r7.get(2), String.class, "com.obric.aiagent.plugin"));
        o.c(r11, "decode(...)");
        return new a(r2, r11, r10);
    L12:
        return null;
    L13:
        return null;
    }
}
