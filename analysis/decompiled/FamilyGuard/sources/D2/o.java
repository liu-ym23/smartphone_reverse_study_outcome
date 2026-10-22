package D2;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.stepos.familyguard.R;
import com.stepos.familyguard.db.FamilyGuardDatabase;
import f2.C0702g;
import java.util.concurrent.ExecutionException;
import l2.C0833b;
import m2.C0863f;
import v0.ComponentCallbacks2C1180c;

/* loaded from: classes.dex */
public class o extends f<String, Drawable> {

    /* renamed from: h, reason: collision with root package name */
    private final long f1195h;

    public o(long j5) {
        this.f1195h = j5;
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
    /* JADX WARN: Multi-variable type inference failed */
    @Override // D2.h
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public Drawable g(v<String> vVar) {
        C0833b c0833bB;
        String str = vVar.get();
        if (TextUtils.isEmpty(str) || (c0833bB = FamilyGuardDatabase.x().u().b(this.f1195h, str)) == null) {
            return null;
        }
        String str2 = c0833bB.f18169e;
        String str3 = C0863f.c() + str + ".png";
        if (TextUtils.isEmpty(str2)) {
            str2 = str3;
        }
        C0702g.b("FamilyAppIconTask", "packageName = " + str + " uriString = " + str2);
        if (!TextUtils.equals(str2, str3)) {
            C0702g.O("FamilyAppIconTask", "onProcess package = " + str + " uriString = " + str2 + " defaultUriString = " + str3);
        }
        try {
            return (Drawable) ComponentCallbacks2C1180c.t(P1.a.a()).n().l0(Uri.parse(str2)).M(P1.a.a().getResources().getDimensionPixelSize(R.dimen.us_progress_item_image_size)).p0().get();
        } catch (InterruptedException e6) {
            e6.printStackTrace();
            return null;
        } catch (ExecutionException e7) {
            e7.printStackTrace();
            return null;
        }
    }
}
