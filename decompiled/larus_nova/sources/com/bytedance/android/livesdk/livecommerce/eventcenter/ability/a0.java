package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import android.content.DialogInterface;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class a0 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ sl.i f147764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e0 f147765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ sl.k f147766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f147767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f147768e;

    public a0(sl.i r100, e0 r101, sl.k r102, Context r103, Object r104) {
        this.f147764a = r100;
        this.f147765b = r101;
        this.f147766c = r102;
        this.f147767d = r103;
        this.f147768e = r104;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
        e0 r102 = this.f147765b;
        String r103 = this.f147766c.d();
        Map<String, String> r104 = this.f147766c.e();
        r102.getClass();
        oh.a.c("ECAlertDialogCancelEvent", new b0(r103, r104));
        e0.c(this.f147765b, this.f147767d, this.f147764a.a(), this.f147768e);
    }
}
