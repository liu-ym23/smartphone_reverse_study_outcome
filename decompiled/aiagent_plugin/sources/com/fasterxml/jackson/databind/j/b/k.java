package com.fasterxml.jackson.databind.j.b;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.DateFormat;
import java.util.Date;

/* JADX INFO: compiled from: DateSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public class k extends l<Date> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f12901a = null;

    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
        a((Date) ZeusTransformUtils.preCheckCast(r3, Date.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // com.fasterxml.jackson.databind.j.b.l
    public /* synthetic */ l<Date> b(Boolean r1, DateFormat r2) {
        return a(r1, r2);
    }

    static {
        f12901a = new k();
    }

    public k() {
        this(null, null);
    }

    public k(Boolean r2, DateFormat r3) {
        super(Date.class, r2, r3);
    }

    public k a(Boolean r1, DateFormat r2) {
        return new k(r1, r2);
    }

    public long a(Date r1) {
        if (r1 != null) goto L5;
        return 0;
    L5:
        return r1.getTime();
    }

    public void a(Date r2, com.fasterxml.jackson.a.h r3, com.fasterxml.jackson.databind.ac r4) {
        if (a(r4) == false) goto L6;
        r3.b(a(r2));
        return;
    L6:
        b(r2, r3, r4);
    }
}
