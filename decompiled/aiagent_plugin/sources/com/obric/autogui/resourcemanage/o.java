package com.obric.autogui.resourcemanage;

import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: ResourceDescription.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30643a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final v f30644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DownloadBean f30645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f30646d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f30647e;
    private final int f;
    private final String g;
    private final String h;

    /* JADX INFO: compiled from: ResourceDescription.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final o a(String r21) {
            d.h.b.o.e(r21, "jsonString");
            JSONObject r1 = new JSONObject(r21);
            String r0 = r1.optString("packageName");
            int r16 = r1.optInt("versionCode");
            String r17 = r1.optString("md5");
            String r2 = r1.optString("resourceKey");
            if (r1.has("extraInfo") == false) goto L5;
            String r18 = r1.optString("extraInfo", null);
        L6:
            String r3 = r1.optString("installDirPath", null);
            d.h.b.o.a(r2);
            String r12 = d.o.o.b(r2, '#', "");
            d.h.b.o.a(r0);
            return new o(new v(r0, 0, 0, "", 0, 0, d.a.p.b(), ao.b(), 0, r12, "", "", ""), new DownloadBean(0, 0, r0, r16, null, 0, r17, r18, null, 0, Integer.MAX_VALUE, null), r3);
        L5:
            r18 = null;
            goto L6
        }
    }

    static {
        f30643a = new a(null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, o.class) == true) goto L8;
        return false;
    L8:
        o r6 = (o) ZeusTransformUtils.preCheckCast(r5, o.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f30644b, r6.f30644b) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f30645c, r6.f30645c) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f30646d, r6.f30646d) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f30644b.hashCode() * 31) + this.f30645c.hashCode()) * 31;
        String r2 = this.f30646d;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "ResourceDescription(request=" + this.f30644b + ", bean=" + this.f30645c + ", installDirPath=" + this.f30646d + ')';
    }

    public o(v r2, DownloadBean r3, String r4) {
        d.h.b.o.e(r2, Ext.KEY_REQUEST);
        d.h.b.o.e(r3, "bean");
        this.f30644b = r2;
        this.f30645c = r3;
        this.f30646d = r4;
        String r5 = r3.getMPackageName();
        if (r5 != null) goto L5;
        r5 = r2.a();
    L5:
        this.f30647e = r5;
        this.f = r3.getMVersionCode();
        String r6 = r3.getMMd5();
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        this.g = r6;
        o r7 = (o) ZeusTransformUtils.preCheckCast(this, o.class, "com.obric.aiagent.plugin");
        String r8 = com.bytedance.common.utility.d.a(r7.f30647e + ':' + r7.f + ':' + r7.g + ':' + r7.f30644b.b());
        d.h.b.o.c(r8, "run(...)");
        this.h = r8;
    }

    public /* synthetic */ o(v r1, DownloadBean r2, String r3, int r4, d.h.b.h r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }

    public final v a() {
        return this.f30644b;
    }

    public final DownloadBean b() {
        return this.f30645c;
    }

    public final String c() {
        return this.f30646d;
    }

    public final String d() {
        return this.f30647e;
    }

    public final int e() {
        return this.f;
    }

    public final String f() {
        return this.g;
    }

    public final String g() {
        return this.h;
    }

    public final String h() {
        return this.f30647e + ".zip";
    }

    public final File a(File r2) {
        d.h.b.o.e(r2, "baseDir");
        return new File(r2, h());
    }

    public final File b(File r3) {
        d.h.b.o.e(r3, "baseDir");
        return new File(new File(r3, this.f30647e), "install");
    }

    public final String i() {
        JSONObject r0 = new JSONObject();
        r0.put("packageName", this.f30647e);
        r0.put("versionCode", this.f);
        r0.put("md5", this.g);
        r0.put("resourceKey", this.f30644b.b());
        r0.put("extraInfo", this.f30645c.getExtraInfo());
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(this.f30646d, CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        r0.put("installDirPath", this.f30646d);
    L11:
        String r4 = r0.toString();
        d.h.b.o.c(r4, "toString(...)");
        return r4;
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
