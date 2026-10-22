package com.bytedance.frameworks.baselib.network.http.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Locale;

/* JADX INFO: compiled from: MimeType.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements Externalizable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f8321c;

    public b() {
        this.f8319a = "application";
        this.f8320b = "*";
        this.f8321c = new c();
    }

    public b(String r1) {
        b(r1);
    }

    private void b(String r5) {
        int r0 = r5.indexOf(47);
        int r1 = r5.indexOf(59);
        if (r0 >= 0) goto L8;
        if (r1 >= 0) goto L8;
        throw new d("Unable to find a sub type.");
    L8:
        if (r0 >= 0) goto L14;
        if (r1 < 0) goto L14;
        throw new d("Unable to find a sub type.");
    L14:
        if (r0 < 0) goto L17;
        if (r1 >= 0) goto L17;
        this.f8319a = r5.substring(0, r0).trim().toLowerCase(Locale.ENGLISH);
        this.f8320b = r5.substring(r0 + 1).trim().toLowerCase(Locale.ENGLISH);
        this.f8321c = new c();
    L20:
        if (c(this.f8319a) == false) goto L27;
        if (c(this.f8320b) == false) goto L25;
        return;
    L25:
        throw new d("Sub type is invalid.");
    L27:
        throw new d("Primary type is invalid.");
    L17:
        if (r0 >= r1) goto L29;
        this.f8319a = r5.substring(0, r0).trim().toLowerCase(Locale.ENGLISH);
        this.f8320b = r5.substring(r0 + 1, r1).trim().toLowerCase(Locale.ENGLISH);
        this.f8321c = new c(r5.substring(r1));
        goto L20
    L29:
        throw new d("Unable to find a sub type.");
    }

    public String a() {
        return this.f8319a;
    }

    public String a(String r1) {
        return this.f8321c.b(r1);
    }

    public String toString() {
        return b() + this.f8321c.toString();
    }

    public String b() {
        return this.f8319a + "/" + this.f8320b;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r3) {
        ObjectOutput r4 = (ObjectOutput) ZeusTransformUtils.wrapperContextForParams(r3, ObjectOutput.class, "com.obric.aiagent.plugin");
        r4.writeUTF(toString());
        r4.flush();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r3) {
        b(((ObjectInput) ZeusTransformUtils.wrapperContextForParams(r3, ObjectInput.class, "com.obric.aiagent.plugin")).readUTF());     // Catch: d -> L5
        return;
    L5:
        e = move-exception;
        throw new IOException(e.toString());
    }

    private static boolean a(char r1) {
        if (r1 > ' ') goto L5;
    L9:
        return false;
    L5:
        if (r1 >= 127) goto L9;
        if ("()<>@,;:/[]?=\\\"".indexOf(r1) >= 0) goto L9;
        return true;
    }

    private boolean c(String r4) {
        int r3 = r4.length();
        if (r3 <= 0) goto L12;
        int r1 = 0;
    L5:
        if (r1 >= r3) goto L10;
        if (a(r4.charAt(r1)) == false) goto L8;
        r1 = r1 + 1;
        goto L5
    L8:
        return false;
    L10:
        return true;
    L12:
        return false;
    }
}
