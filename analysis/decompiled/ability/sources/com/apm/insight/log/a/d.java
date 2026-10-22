package com.apm.insight.log.a;

import com.apm.insight.log.a.b;
import java.util.Comparator;

/* loaded from: classes2.dex */
final class d implements Comparator<b.a> {
    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(b.a aVar, b.a aVar2) {
        long j5 = aVar.b;
        long j6 = aVar2.b;
        if (j5 < j6) {
            return 1;
        }
        return j5 == j6 ? 0 : -1;
    }
}
