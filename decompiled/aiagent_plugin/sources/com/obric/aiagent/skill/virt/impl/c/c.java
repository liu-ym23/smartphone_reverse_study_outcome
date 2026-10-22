package com.obric.aiagent.skill.virt.impl.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.m;
import d.o.k;
import d.s;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: VirtShell.kt */
/* JADX INFO: loaded from: classes3.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f22164a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<m<k, String>> f22165b = null;

    private c() {
    }

    static {
        f22164a = new c();
        f22165b = p.b(new m[]{s.a(new k("rm\\s+-[rf]{1,2}\\s+/\\s*$"), "recursive remove on root"), s.a(new k("rm\\s+-[rf]{1,2}\\s+/\\s+"), "recursive remove on root"), s.a(new k(":\\(\\)\\s*\\{"), "fork bomb"), s.a(new k(">\\s*/dev/(sd|mmcblk|nvme)"), "write to block device"), s.a(new k("dd\\s+.*of\\s*=\\s*/dev/(sd|mmcblk|nvme)"), "dd to block device")});
    }

    public final String a(String r5) {
        o.e(r5, "command");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L6;
        return "Command is empty";
    L6:
        Iterator<m<k, String>> r4 = f22165b.iterator();
    L8:
        if (r4.hasNext() == false) goto L13;
        m r1 = (m) ZeusTransformUtils.preCheckCast(r4.next(), m.class, "com.obric.aiagent.plugin");
        k r2 = (k) ZeusTransformUtils.preCheckCast(r1.c(), k.class, "com.obric.aiagent.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.d(), String.class, "com.obric.aiagent.plugin");
        if (r2.b((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L8;
        return "Command blocked by security guard: " + r3;
    L13:
        return null;
    }
}
