package com.bytedance.ai.uiu;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f37611a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Regex f37612b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Regex f37613c = null;

    static {
        f37611a = g.class.getName();
        f37612b = new Regex("(?=;[cligbnpt]:\\d{3})");
        f37613c = new Regex("^\\d{3}(&&\\d{3})*$");
    }

    public static u5.c a(String r100, String r101) {
        com.bytedance.ai.utils.g r102 = com.bytedance.ai.utils.g.f37637a;
        String r103 = f37611a;
        r102.d(r103, "parseUIOperations data: " + r100);
        if (r100 != null) goto L5;
    L8:
        boolean r104 = true;
    L10:
        if (r104 == false) goto L13;
        return null;
    L13:
        if (StringsKt.startsWith$default(r100, "\"", false, 2, null) == false) goto L16;
        r100 = r100.substring(1);
    L16:
        if (StringsKt.endsWith$default(r100, com.alipay.sdk.m.u.i.f25853b, false, 2, null) == false) goto L18;
        r100 = StringsKt.dropLast(r100, 1);
    L18:
        List r105 = Regex.split$default(f37612b, r100, 0, 2, null);
        if (r105.isEmpty() == false) goto L22;
        r102.d(r103, "parseUIOperations No data to split for uiOperations");
        return null;
    L22:
        if (r101 != null) goto L25;
        r101 = (String) ListProtector.get(r105, 0);
    L25:
        return new u5.c(r101, SequencesKt.toList(SequencesKt.flattenSequenceOfIterable(SequencesKt.mapNotNull(SequencesKt.drop(CollectionsKt.asSequence(r105), 1), new f()))));
    L5:
        if (r100.length() == 0) goto L8;
        r104 = false;
        goto L10
    }
}
