package com.bytedance.common.wschannel.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: MessageAckEvent.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f6781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f6783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f6784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f6785e;
    private JSONObject f;

    /* JADX INFO: compiled from: MessageAckEvent.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6786a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f6787b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f6788c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f6789d = null;
        private static final /* synthetic */ a[] f = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f6790e;

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("Default", 0, 0);
            f6786a = r0;
            a r1 = new a("TimeOut", 1, 1);
            f6787b = r1;
            a r3 = new a("Failed", 2, 2);
            f6788c = r3;
            a r5 = new a("Success", 3, 3);
            f6789d = r5;
            f = new a[]{r0, r1, r3, r5};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f6790e = r3;
        }

        public int a() {
            return this.f6790e;
        }

        public static a a(int r1) {
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L13;
            if (r1 == 3) goto L11;
            return f6786a;
        L11:
            return f6789d;
        L13:
            return f6788c;
        L15:
            return f6787b;
        }
    }

    public d(String r2, int r3, int r4, int r5, String r6) {
        this.f6781a = a.f6786a;
        this.f6782b = r2;
        this.f6783c = r3;
        this.f6784d = r4;
        this.f6785e = r5;
        this.f = new JSONObject(r6);     // Catch: JSONException -> L5
        return;
    }

    public void a(a r1) {
        this.f6781a = r1;
    }

    public String toString() {
        return "UniqueId:" + this.f6782b + ", ChannelId:" + this.f6783c + ", methodId:" + this.f6785e + ", state:" + this.f6781a + ", logInfo:" + this.f.toString();
    }
}
