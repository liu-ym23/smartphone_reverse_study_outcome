package com.volcengine.tos;

import B7.a;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class UnexpectedStatusCodeException extends TosException {

    /* renamed from: a, reason: collision with root package name */
    public int f4217a;
    public ArrayList b;
    public String c;

    public UnexpectedStatusCodeException(int i, int i6, String str) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.f4217a = i;
        arrayList.add(Integer.valueOf(i6));
        this.c = str;
    }

    @Override // com.volcengine.tos.TosException
    public final int getStatusCode() {
        return this.f4217a;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        StringBuilder sb = new StringBuilder("UnexpectedStatusCodeException{statusCode=");
        sb.append(this.f4217a);
        sb.append(", expectedCodes=");
        sb.append(this.b);
        sb.append(", requestID='");
        return a.q(sb, this.c, "'}");
    }
}
