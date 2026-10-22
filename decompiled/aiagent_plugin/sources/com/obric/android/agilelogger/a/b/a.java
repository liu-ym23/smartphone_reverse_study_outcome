package com.obric.android.agilelogger.a.b;

import com.obric.android.agilelogger.a.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Date;

/* JADX INFO: compiled from: DefaultDateFormatter.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements b<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Date f22377a;

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public String a2(String r1) {
        return r1;
    }

    @Override // com.obric.android.agilelogger.a.b
    public /* synthetic */ String a(String r3) {
        return a2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
    }

    public a() {
        this("MM-dd HH:mm:ss");
    }

    public a(String r1) {
        this.f22377a = new Date();
    }
}
