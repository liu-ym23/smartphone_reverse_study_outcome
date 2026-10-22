package cmb;

import android.content.Context;
import com.bytedance.ee.bear.contract.NetService;
import com.ss.android.lark.integrator.ccm.CCMApiImpl;

/* JADX INFO: loaded from: classes36.dex */
public final /* synthetic */ class a implements e05.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NetService f24245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f24246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f24247c;

    public /* synthetic */ a(NetService r100, String r101, Context r102) {
        this.f24245a = r100;
        this.f24246b = r101;
        this.f24247c = r102;
    }

    public final void a(e05.c r100) {
        CCMApiImpl.a(this.f24245a, this.f24246b, this.f24247c, r100);
    }
}
