package d1;

import com.stepos.taskrobot.llmapi.stepfun.TaskTimeouts;

/* loaded from: classes2.dex */
public final class h extends AbstractC1374a {
    public int e;

    @Override // d1.AbstractC1374a, A8.b
    public final void K0(boolean z10) {
        if (z10) {
            this.e = 0;
        }
        super.K0(z10);
    }

    @Override // A8.b
    public final cc.dd.ee.ee.ee.d L0() {
        return cc.dd.ee.ee.ee.d.b;
    }

    @Override // d1.AbstractC1374a
    public final boolean P0(boolean z10) {
        if (!z10) {
            this.e = 0;
            c1.b bVar = (c1.b) this.f160a;
            synchronized (bVar) {
                bVar.a(bVar.h);
            }
            return true;
        }
        this.e++;
        I0("over time: " + this.e + " max over time: 2");
        if (this.e < 2) {
            return false;
        }
        this.e = 0;
        c1.b bVar2 = (c1.b) this.f160a;
        synchronized (bVar2) {
            bVar2.a(bVar2.f2082j);
        }
        return true;
    }

    @Override // d1.AbstractC1374a
    public final long Q0() {
        if (this.d) {
            return TaskTimeouts.TAKEOVER_IDLE_MS;
        }
        return 5000L;
    }

    @Override // d1.AbstractC1374a
    public final boolean R0() {
        this.e = 0;
        c1.b bVar = (c1.b) this.f160a;
        synchronized (bVar) {
            bVar.a(bVar.h);
        }
        return true;
    }
}
