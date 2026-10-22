package a0c;

import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.signinsdk_api.account.Tenant;
import com.ss.android.lark.passport.signinsdk_api.account.TenantInfo;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$UNIT;
import com.ss.android.lark.passport.signinsdk_api.env.EnvironmentType;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
@UserScope
public final class b implements yzb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final yzb.b f1357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kzb.b f1358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final izb.a f1359d;

    public static final class a {
    }

    static {
    }

    @Override // yzb.a
    public final kzb.a a() {
        User r100 = this.f1357b.a(this.f1356a);
        if (r100 != null) goto L5;
        r100 = new User();
        r100.userId = "absent_user";
    L5:
        String r101 = r100.userUnit;
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        String r103 = "";
        if (r102 == false) goto L23;
        String r104 = Reflection.getOrCreateKotlinClass(b.class).getSimpleName();
        if (r104 != null) goto L17;
        r104 = "";
    L17:
        String r105 = r100.userId;
        if (r105 == null) goto L21;
        r103 = r105;
    L21:
        PassportLog.b(r104, r103.concat(" hasn't unit (unit is null or blank)."));
        return this.f1358c.a();
    L23:
        EnvironmentType r106 = this.f1358c.a().getType();
        Tenant r107 = r100.tenant;
        if (r107 == null) goto L27;
        String r108 = r107.getTenantBrand();
        if (r108 == null) goto L27;
    L56:
        String r109 = r100.userGeo;
        if (r109 != null) goto L60;
        r109 = this.f1359d.b(r101);
    L60:
        return new kzb.a(r108, r101, r109, r106);
    L27:
        String r110 = Reflection.getOrCreateKotlinClass(b.class).getSimpleName();
        if (r110 == null) goto L32;
        r103 = r110;
    L32:
        switch(r101.hashCode()) {
            case 93912099: goto L51;
            case 93912675: goto L47;
            case 96855691: goto L44;
            case 96855972: goto L41;
            case 878174793: goto L38;
            case 886218363: goto L35;
            default: goto L55;
        };
    L55:
        PassportLog.b(r103, "Can't convertUnitToBrand, Unknown unit " + r101 + '.');
        r108 = r101;
        goto L56
    L35:
        if (r101.equals("larksgaws") == false) goto L55;
    L49:
        String r111 = "lark";
    L54:
        r108 = r111;
        goto L56
    L38:
        if (r101.equals("larkjpaws") == true) goto L49;
    L41:
        if (r101.equals("eu_nc") == false) goto L55;
    L53:
        r111 = "feishu";
        goto L54
    L44:
        if (r101.equals("eu_ea") == true) goto L49;
    L47:
        if (r101.equals(EnvConst$UNIT.BOE_VA) == true) goto L49;
    L51:
        if (r101.equals(EnvConst$UNIT.BOE_CN) == true) goto L53;
    L8:
        if (StringsKt.isBlank(r101) == true) goto L11;
        r102 = false;
        goto L12
    }

    @Override // yzb.a
    public final TenantInfo getTenantInfo() {
        yzb.b r100 = this.f1357b;
        User r101 = r100.a(this.f1356a);
        if (r101 != null) goto L6;
        r101 = new User();
        r101.userId = "absent_user";
    L6:
        return r100.b(r101);
    }

    @Inject
    public b(String r100, yzb.b r101, kzb.b r102, izb.a r103) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "larkUserListService");
        Intrinsics.checkNotNullParameter(r102, "globalEnvironmentService");
        Intrinsics.checkNotNullParameter(r103, "environmentDependency");
        this.f1356a = r100;
        this.f1357b = r101;
        this.f1358c = r102;
        this.f1359d = r103;
    }
}
