package com.obric.autogui.net.ttnet.a.a;

import com.obric.autogui.common.api.logging.Loog;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: TTNetBaseExceptionInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public class b implements com.obric.autogui.tools.api.net.b {
    private static final String TAG = "TTN/ExpInfo/Base";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f29200a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.tools.api.net.c f29201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Throwable f29202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f29203d;

    /* JADX INFO: compiled from: TTNetBaseExceptionInfo.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f29200a = new a(null);
    }

    public b(com.obric.autogui.tools.api.net.c r2, Throwable r3, String r4) {
        o.e(r2, "type");
        this.f29201b = r2;
        this.f29202c = r3;
        this.f29203d = r4;
    }

    public /* synthetic */ b(com.obric.autogui.tools.api.net.c r1, Throwable r2, String r3, int r4, h r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }

    @Override // com.obric.autogui.tools.api.net.b
    public com.obric.autogui.tools.api.net.c getType() {
        return this.f29201b;
    }

    @Override // com.obric.autogui.tools.api.net.b
    public String a() {
        String r0 = this.f29203d;
        if (r0 == null) goto L6;
        return String.valueOf(r0);
    L6:
        return "T/" + getType().name();
    }

    @Override // com.obric.autogui.tools.api.net.b
    public void b() {
        Loog.INSTANCE.e(TAG, "[TTNetErrLogs] for " + getType() + " [code=" + a() + ']');
        if (this.f29202c == null) goto L6;
        Loog.INSTANCE.e(TAG, " - Throwable -> [" + this.f29202c.getClass().getSimpleName() + "], m: " + this.f29202c.getMessage());
        return;
    }
}
