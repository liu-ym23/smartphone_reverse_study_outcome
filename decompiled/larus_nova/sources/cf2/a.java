package cf2;

import af2.b;
import af2.c;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.link.model.IBattleBarConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f23500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f23501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f23502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f23503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IBaseUser f23504e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IBattleBarConfig f23505f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f23506g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f23503d, r101.f23503d) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f23504e, r101.f23504e) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f23505f, r101.f23505f) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f23506g, r101.f23506g) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        b r100 = this.f23503d;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        IBaseUser r104 = this.f23504e;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        IBattleBarConfig r107 = this.f23505f;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f23506g;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BattleScoreWrapper(battleScore=" + this.f23503d + ", fromUser=" + this.f23504e + ", battleBarConfig=" + this.f23505f + ", fromUserId=" + this.f23506g + ")";
    }

    public a(b r100, IBaseUser r101, IBattleBarConfig r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "battleScore");
        this.f23503d = r100;
        this.f23504e = r101;
        this.f23505f = r102;
        this.f23506g = r103;
        this.f23500a = c.b(r100);
        this.f23501b = r100.getScoreText();
        this.f23502c = c.a(r100);
        r100.isHugeRewardPk();
        r100.getNewScoreOpen();
    }
}
