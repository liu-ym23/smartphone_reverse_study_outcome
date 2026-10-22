package com.bytedance.bdtracker;

import com.bytedance.bdtracker.b;

/* loaded from: classes.dex */
public final class c implements b.f {

    public class a implements Runnable {
        public final /* synthetic */ d a;

        public a(c cVar, d dVar) {
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = this.a;
            u1 u1Var = dVar.b("getConfig") ? null : dVar.q.e;
            if (u1Var == null || u1Var.q || u1Var.f.getBoolean("enter_background_not_send", false)) {
                return;
            }
            this.a.flush();
        }
    }

    @Override // com.bytedance.bdtracker.b.f
    public void a(d dVar) {
        x.a.execute(new a(this, dVar));
    }
}
