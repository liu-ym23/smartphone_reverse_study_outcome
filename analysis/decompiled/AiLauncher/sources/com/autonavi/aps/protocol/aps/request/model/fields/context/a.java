package com.autonavi.aps.protocol.aps.request.model.fields.context;

import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.protocol.aps.common.e.h;

/* loaded from: classes.dex */
public class a implements Comparable<a> {

    /* renamed from: a, reason: collision with root package name */
    public int f19033a;

    /* renamed from: b, reason: collision with root package name */
    public int f19034b;

    public a(int i10, int i11) {
        this.f19033a = i10;
        this.f19034b = i11;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        return this.f19034b > aVar.f19034b ? 1 : -1;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && this.f19033a == ((a) obj).f19033a;
    }

    public int hashCode() {
        return this.f19033a;
    }

    public String toString() {
        return h.a(new Object[]{Integer.valueOf(this.f19033a), Integer.valueOf(this.f19034b)}, Const.STR_MART_COMMA);
    }
}
