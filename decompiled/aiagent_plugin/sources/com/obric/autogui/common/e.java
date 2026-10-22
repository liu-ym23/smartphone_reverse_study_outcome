package com.obric.autogui.common;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: StatusMessage.kt */
/* JADX INFO: loaded from: classes3.dex */
public class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f29014b = null;
    private static final e f = null;
    private static final e g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f29015a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f29016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f29017d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f29018e;

    /* JADX INFO: compiled from: StatusMessage.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final e a() {
            return e.j();
        }

        public final e b() {
            return e.k();
        }

        public final e a(String r7) {
            o.e(r7, "msg");
            return new e(true, r7, 0, 4, null);
        }

        public final e a(int r3) {
            return new e(true, "", r3);
        }

        public final e b(String r7) {
            o.e(r7, "msg");
            return new e(false, r7, 0, 4, null);
        }

        public final e c(String r7) {
            o.e(r7, "msg");
            e r6 = new e(false, r7, 0, 4, null);
            r6.a(true);
            return r6;
        }

        public static /* synthetic */ e a(a r0, int r1, String r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = "failed";
        L6:
            return r0.a(r1, r2);
        }

        public final e a(int r2, String r3) {
            o.e(r3, "msg");
            return new e(false, r3, r2);
        }
    }

    public e(boolean r2, String r3, int r4) {
        o.e(r3, "message");
        this.f29015a = r2;
        this.f29016c = r3;
        this.f29017d = r4;
    }

    public /* synthetic */ e(boolean r1, String r2, int r3, int r4, h r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = 0;
    L5:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ e j() {
        return f;
    }

    public static final /* synthetic */ e k() {
        return g;
    }

    public final boolean g() {
        return this.f29015a;
    }

    public final String h() {
        return this.f29016c;
    }

    public final void a(int r1) {
        this.f29017d = r1;
    }

    public final int i() {
        return this.f29017d;
    }

    static {
        f29014b = new a(null);
        f = new e(true, "", 0, 4, null);
        g = new e(false, "", 0, 4, null);
    }

    public final void a(boolean r1) {
        this.f29018e = r1;
    }

    public final CharSequence a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        if (this.f29018e == true) goto L10;
        int r2 = this.f29017d;
        if (r2 == 0) goto L9;
        CharSequence r5 = r4.getText(r2);
        o.a(r5);
        return r5;
    L9:
        return (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L10:
        return (CharSequence) ZeusTransformUtils.preCheckCast(this.f29016c, CharSequence.class, "com.obric.aiagent.plugin");
    }

    public String toString() {
        return "StatusMessage(ok=" + this.f29015a + ", message='" + this.f29016c + "')";
    }
}
