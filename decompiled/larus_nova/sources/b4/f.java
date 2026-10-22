package b4;

import com.bytedance.ai.bridge.method.net.core.RequestMethod;
import com.bytedance.ai.bridge.service.IHostNetworkDepend;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f17444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f17445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, String> f17446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f17447e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f17448f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f17449g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f17450h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f17451i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f17452j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f17453k;

    public f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f17443a = r100;
        this.f17453k = -1;
    }

    public final m delete(IHostNetworkDepend r100) {
        Intrinsics.checkNotNullParameter(r100, "hostNetworkDepend");
        b r101 = b.f17426a;
        RequestMethod r102 = RequestMethod.DELETE;
        r101.getClass();
        return b.f(r102, this, r100);
    }
}
