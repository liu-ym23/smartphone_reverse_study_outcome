package D2;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class d extends f<String, s> {

    /* renamed from: h, reason: collision with root package name */
    private final PackageManager f1174h = P1.a.a().getPackageManager();

    d() {
    }

    @Override // D2.f, D2.h, D2.A
    public /* bridge */ /* synthetic */ void a(r rVar, v vVar, z zVar, u uVar) {
        super.a(rVar, vVar, zVar, uVar);
    }

    @Override // D2.h, D2.A
    public /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // D2.h, D2.A
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // D2.f, D2.h, D2.A
    public /* bridge */ /* synthetic */ void cancel() {
        super.cancel();
    }

    @Override // D2.h, D2.A
    public /* bridge */ /* synthetic */ v d() {
        return super.d();
    }

    @Override // D2.h
    public /* bridge */ /* synthetic */ boolean f() {
        return super.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // D2.h
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public s g(v<String> vVar) throws PackageManager.NameNotFoundException {
        if (this.f1174h == null) {
            return null;
        }
        try {
            s sVar = new s();
            ApplicationInfo applicationInfo = this.f1174h.getApplicationInfo(vVar.get(), 0);
            sVar.f1197b = applicationInfo.uid;
            String string = this.f1174h.getApplicationLabel(applicationInfo).toString();
            sVar.f1196a = string;
            if (!TextUtils.isEmpty(string)) {
                return sVar;
            }
            sVar.f1196a = vVar.get();
            return sVar;
        } catch (PackageManager.NameNotFoundException e6) {
            e6.printStackTrace();
            s sVar2 = new s();
            sVar2.f1196a = vVar.get();
            return sVar2;
        }
    }
}
