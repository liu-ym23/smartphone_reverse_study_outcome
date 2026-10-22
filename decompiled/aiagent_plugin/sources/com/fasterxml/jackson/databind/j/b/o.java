package com.fasterxml.jackson.databind.j.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: FileSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class o extends ai<File> {
    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
        a((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    public o() {
        super(File.class);
    }

    public void a(File r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3) {
        r2.b(r1.getAbsolutePath());
    }
}
