package f9;

import android.content.ContentResolver;
import com.stepos.agentsafetycenter.perfbinder.PerfBinderTestActivity;
import i9.h;
import jb.v;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4044c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ PerfBinderTestActivity f4045f;

    @Override // xb.a
    public final Object invoke() {
        int i = this.f4044c;
        v vVar = v.f6774a;
        PerfBinderTestActivity perfBinderTestActivity = this.f4045f;
        switch (i) {
            case 0:
                int i3 = PerfBinderTestActivity.f2510f;
                perfBinderTestActivity.c("writeGlobalPolicy ok=" + ac.a.l0(true, "TASK_EXECUTION", null));
                ContentResolver contentResolver = perfBinderTestActivity.getApplicationContext().getContentResolver();
                contentResolver.getClass();
                h hVarR = a.a.R(contentResolver);
                perfBinderTestActivity.c("readback enabled=" + (hVarR != null ? Boolean.valueOf(hVarR.f5863a) : null) + " scope=" + (hVarR != null ? hVarR.f5864b : null));
                break;
            case 1:
                int i10 = PerfBinderTestActivity.f2510f;
                perfBinderTestActivity.c("writeGlobalPolicy(off) ok=" + ac.a.l0(false, "TASK_EXECUTION", null));
                break;
            default:
                int i11 = PerfBinderTestActivity.f2510f;
                perfBinderTestActivity.c("isLockPasswordEnabled=" + ac.a.C());
                break;
        }
        return vVar;
    }
}
