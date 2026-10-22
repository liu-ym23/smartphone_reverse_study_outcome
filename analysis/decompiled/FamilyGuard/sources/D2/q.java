package D2;

import android.text.TextUtils;
import com.stepos.familyguard.db.FamilyGuardDatabase;
import l2.C0833b;

/* loaded from: classes.dex */
public class q extends f<String, String> {
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
    public String g(v<String> vVar) {
        C0833b c0833bA;
        String str = vVar.get();
        if (TextUtils.isEmpty(str) || (c0833bA = FamilyGuardDatabase.x().u().a(str)) == null) {
            return null;
        }
        return c0833bA.f18168d;
    }
}
