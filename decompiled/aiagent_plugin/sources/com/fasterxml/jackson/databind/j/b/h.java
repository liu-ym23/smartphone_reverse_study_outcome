package com.fasterxml.jackson.databind.j.b;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.DateFormat;
import java.util.Calendar;

/* JADX INFO: compiled from: CalendarSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public class h extends l<Calendar> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f12900a = null;

    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
        a((Calendar) ZeusTransformUtils.preCheckCast(r3, Calendar.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // com.fasterxml.jackson.databind.j.b.l
    public /* synthetic */ l<Calendar> b(Boolean r1, DateFormat r2) {
        return a(r1, r2);
    }

    static {
        f12900a = new h();
    }

    public h() {
        this(null, null);
    }

    public h(Boolean r2, DateFormat r3) {
        super(Calendar.class, r2, r3);
    }

    public h a(Boolean r1, DateFormat r2) {
        return new h(r1, r2);
    }

    public long a(Calendar r1) {
        if (r1 != null) goto L5;
        return 0;
    L5:
        return r1.getTimeInMillis();
    }

    public void a(Calendar r2, com.fasterxml.jackson.a.h r3, com.fasterxml.jackson.databind.ac r4) {
        if (a(r4) == false) goto L6;
        r3.b(a(r2));
        return;
    L6:
        b(r2.getTime(), r3, r4);
    }
}
