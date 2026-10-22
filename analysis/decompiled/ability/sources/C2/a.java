package C2;

import com.bytedance.apm.agent.v2.instrumentation.FragmentTimeAgent;

/* loaded from: classes2.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f282a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;

    public a(String str, long j5, long j6) {
        this.f282a = str;
        this.b = j5;
        this.c = j6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zContains = FragmentTimeAgent.sMethodSet.contains(FragmentTimeAgent.sFragmentName);
        FragmentTimeAgent.sMethodSet.add(FragmentTimeAgent.sFragmentName);
        FragmentTimeAgent.reportStats(zContains, this.f282a, this.b, this.c);
    }
}
