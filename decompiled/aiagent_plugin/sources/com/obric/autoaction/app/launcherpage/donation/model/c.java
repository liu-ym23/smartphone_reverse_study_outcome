package com.obric.autoaction.app.launcherpage.donation.model;

import android.graphics.Bitmap;
import com.obric.autogui.common.api.platform.screen.capture.OScreenEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import org.json.JSONObject;

/* JADX INFO: compiled from: ScreenOperation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OScreenEvent f23811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bitmap f23812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f23813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f23814d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f23815e;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f23811a, r6.f23811a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f23812b, r6.f23812b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        OScreenEvent r0 = this.f23811a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Bitmap r4 = this.f23812b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ScreenOperation(event=" + this.f23811a + ", bitmap=" + this.f23812b + ')';
    }

    public c(OScreenEvent r1, Bitmap r2) {
        this.f23811a = r1;
        this.f23812b = r2;
    }

    public final OScreenEvent a() {
        return this.f23811a;
    }

    public final Bitmap b() {
        return this.f23812b;
    }

    public final String c() {
        return this.f23813c;
    }

    public final void a(String r7) {
        if (r7 == null) goto L4;
        String r8 = d.o.o.a(r7, "\\u0026", "&", false, 4, null);
    L5:
        this.f23813c = r8;
        return;
    L4:
        r8 = null;
        goto L5
    }

    public final void b(String r1) {
        this.f23814d = r1;
    }

    public final String d() {
        return this.f23814d;
    }

    public final void c(String r1) {
        this.f23815e = r1;
    }

    public final String e() {
        return this.f23815e;
    }

    public final JSONObject f() {
        JSONObject r0 = new JSONObject();
        r0.put("uri", this.f23815e);
        r0.put("describe", this.f23814d);
        OScreenEvent r3 = this.f23811a;
        if (r3 == null) goto L5;
        JSONObject r4 = r3.toJson();
    L6:
        r0.put("operation", r4);
        return r0;
    L5:
        r4 = null;
        goto L6
    }
}
