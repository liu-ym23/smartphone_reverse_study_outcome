package o0;

import android.text.TextUtils;
import com.bytedance.apm.insight.ApmInsight;
import e2.C1404a;
import e2.InterfaceC1405b;

/* loaded from: classes2.dex */
public final class f implements InterfaceC1405b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f5415a;

    public f(ApmInsight apmInsight, String str) {
        this.f5415a = str;
    }

    @Override // e2.InterfaceC1405b
    public final void a(String str, String str2, String str3) {
        String str4 = this.f5415a;
        if (TextUtils.isEmpty(C1404a.c(str4).b())) {
            return;
        }
        L0.d.f925a.b(new Y.a(str4, 1));
    }

    @Override // e2.InterfaceC1405b
    public final void b(boolean z10, String str, String str2, String str3, String str4, String str5, String str6) {
        String str7 = this.f5415a;
        if (TextUtils.isEmpty(C1404a.c(str7).b())) {
            return;
        }
        L0.d.f925a.b(new Y.a(str7, 1));
    }
}
