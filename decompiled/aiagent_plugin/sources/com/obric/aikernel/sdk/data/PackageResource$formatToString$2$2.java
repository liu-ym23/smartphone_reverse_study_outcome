package com.obric.aikernel.sdk.data;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.b;
import d.h.b.o;
import d.h.b.p;

/* JADX INFO: compiled from: PackageResource.kt */
/* JADX INFO: loaded from: classes3.dex */
final class PackageResource$formatToString$2$2 extends p implements b<String, CharSequence> {
    public static final PackageResource$formatToString$2$2 INSTANCE = null;

    static {
        INSTANCE = new PackageResource$formatToString$2$2();
    }

    PackageResource$formatToString$2$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(String r2) {
        o.e(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
    }

    @Override // d.h.a.b
    public /* synthetic */ CharSequence invoke(String r3) {
        return invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
    }
}
