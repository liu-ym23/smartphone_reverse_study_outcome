package com.autonavi.aps.protocol.aps.impl.v56.a;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class d {
    public void a(e eVar) throws IOException {
    }

    public void b(e eVar) {
        try {
            a(eVar);
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public boolean a(int i10, c cVar) throws IOException {
        return false;
    }

    public d a(c cVar) {
        boolean z10 = false;
        while (!z10) {
            try {
                int iB = cVar.b();
                if (iB == 0 || (!a(iB, cVar) && !cVar.g(iB))) {
                    z10 = true;
                }
            } catch (Throwable th) {
                throw new RuntimeException(getClass().getSimpleName(), th);
            }
        }
        return this;
    }

    public int b(c cVar) throws IOException {
        int iC = cVar.c();
        if (cVar.f18686b < cVar.f18687c) {
            int iB = cVar.b(iC);
            cVar.f18686b++;
            return iB;
        }
        throw new RuntimeException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public void a(c cVar, int i10) {
        cVar.d(0);
        cVar.f18686b--;
        cVar.c(i10);
    }
}
