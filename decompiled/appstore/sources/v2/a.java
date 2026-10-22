package v2;

import com.bytedance.apm6.cpu.exception.ICpuExceptionState;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements ICpuExceptionState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f25050a;

    public a(d r10) {
        this.f25050a = r10;
    }

    public void a(String r10) {
        if (r3.a.c() == false) goto L6;
        s3.a.d("APM-CPU", "[" + provideType() + "]: " + r10);
        return;
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onEnterThisState(u2.b r10, boolean r11) {
        if (r3.a.c() == false) goto L6;
        s3.a.d("APM-CPU", "enter : " + provideType());
        return;
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onLifeCycleChange(boolean r10) {
        if (r3.a.c() == false) goto L6;
        s3.a.d("APM-CPU", "onLifeCycleChange when state is : " + provideType());
        return;
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onStopDetect() {
        if (r3.a.c() == false) goto L6;
        s3.a.d("APM-CPU", "stop detect when state is : " + provideType());
        return;
    }
}
