package com.baidu.mapsdkplatform.comapi.map;

import android.os.Message;

/* loaded from: classes.dex */
class o {

    /* renamed from: a, reason: collision with root package name */
    private n f8082a;

    public void a(n nVar) {
        this.f8082a = nVar;
    }

    public void b(n nVar) {
        this.f8082a = null;
    }

    public void a(Message message) {
        if (message.what != 65289) {
            return;
        }
        int i4 = message.arg1;
        if (i4 != 12 && i4 != 101 && i4 != 102) {
            switch (i4) {
            }
            return;
        }
        n nVar = this.f8082a;
        if (nVar != null) {
            nVar.a(i4, message.arg2);
        }
    }
}
