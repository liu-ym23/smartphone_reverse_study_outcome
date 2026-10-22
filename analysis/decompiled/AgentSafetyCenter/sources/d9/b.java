package d9;

import android.util.Log;
import com.stepos.agentsafetycenter.mcp.service.AbilityService;
import jb.v;
import xb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3295c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ AbilityService f3296f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ String f3297g;

    public /* synthetic */ b(int i) {
        this.f3295c = i;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        switch (this.f3295c) {
            case 0:
                AbilityService abilityService = this.f3296f;
                String str = this.f3297g;
                String str2 = abilityService.f2508c;
                ((b9.b) obj).getClass();
                Log.i(str2, "handle tool=" + str + " done isError=false");
                break;
            default:
                AbilityService abilityService2 = this.f3296f;
                String str3 = this.f3297g;
                Log.w(abilityService2.f2508c, "handle tool=" + str3 + " failed", (Throwable) obj);
                break;
        }
        return v.f6774a;
    }
}
