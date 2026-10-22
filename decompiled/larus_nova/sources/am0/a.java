package am0;

import com.bytedance.android.live.messagewindow.business.card.d;
import com.bytedance.android.live.room.api.messagewindow.identity.CardTypeAndPriority;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$GEO;
import kotlin.jvm.internal.Intrinsics;
import s71.e;
import s71.g;
import v61.c;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements g<v61.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f4222a;

    public a(d r100) {
        this.f4222a = r100;
    }

    @Override // s71.g
    public final s71.d a(v61.a r100, c r101) {
        v61.a r102 = (v61.a) r101;
        Intrinsics.checkNotNullParameter(r100, EnvConst$GEO.US);
        Intrinsics.checkNotNullParameter(r102, "others");
        if (r100.f553380k < r102.f553380k) goto L6;
        return s71.d.c.f540906a;
    L6:
        if (Intrinsics.areEqual(r102.f553379j, CardTypeAndPriority.AudienceLink.getType()) == false) goto L12;
        d r103 = this.f4222a;
        if (r103 == null) goto L14;
        r103.T();
    L14:
        return s71.d.C7580d.f540907a;
    L12:
        return new s71.d.b(0);
    }

    @Override // s71.g
    public final e b(c r100, v61.a r101) {
        Intrinsics.checkNotNullParameter((v61.a) r100, EnvConst$GEO.US);
        Intrinsics.checkNotNullParameter(r101, "winner");
        if (Intrinsics.areEqual(r101.f553379j, CardTypeAndPriority.AudienceLink.getType()) == false) goto L9;
        d r102 = this.f4222a;
        if (r102 == null) goto L10;
        r102.T();
    L10:
        return s71.b.f540901a;
    L9:
        return s71.c.a.f540903b;
    }
}
