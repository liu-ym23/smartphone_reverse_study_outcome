package com.autonavi.aps.protocol.aps.common.b;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class b {
    public boolean a(int i10, a aVar) throws IOException {
        return false;
    }

    public void b(c cVar) throws IOException {
    }

    public void a(c cVar) {
        try {
            b(cVar);
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public int b(a aVar) throws IOException {
        int iC = aVar.c();
        if (aVar.f18493b >= aVar.f18494c) {
            throw new RuntimeException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iB = aVar.b(iC);
        aVar.f18493b++;
        return iB;
    }

    public b a(a aVar) {
        boolean z10 = false;
        while (!z10) {
            try {
                int iB = aVar.b();
                if (iB == 0 || (!a(iB, aVar) && !aVar.g(iB))) {
                    z10 = true;
                }
            } catch (Throwable th) {
                throw new RuntimeException(getClass().getSimpleName(), th);
            }
        }
        return this;
    }

    public void a(a aVar, int i10) {
        aVar.d(0);
        aVar.f18493b--;
        aVar.c(i10);
    }
}
