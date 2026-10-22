package com.baidu.b;

import java.util.Comparator;

/* loaded from: classes.dex */
class d implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f4869a;

    public d(c cVar) {
        this.f4869a = cVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(b bVar, b bVar2) {
        int i4 = bVar2.f4733b - bVar.f4733b;
        if (i4 != 0) {
            return i4;
        }
        boolean z4 = bVar.f4735d;
        if (z4 && bVar2.f4735d) {
            return 0;
        }
        if (z4) {
            return -1;
        }
        if (bVar2.f4735d) {
            return 1;
        }
        return i4;
    }
}
