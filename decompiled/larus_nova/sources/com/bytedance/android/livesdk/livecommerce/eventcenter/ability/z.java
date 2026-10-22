package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import android.content.DialogInterface;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class z implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ sl.i f147806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e0 f147807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ sl.k f147808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f147809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f147810e;

    public z(sl.i r100, e0 r101, sl.k r102, Context r103, Object r104) {
        this.f147806a = r100;
        this.f147807b = r101;
        this.f147808c = r102;
        this.f147809d = r103;
        this.f147810e = r104;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
        e0 r102 = this.f147807b;
        String r103 = this.f147808c.d();
        Map<String, String> r104 = this.f147808c.e();
        r102.getClass();
        oh.a.c("ECAlertDialogConfirmEvent", new c0(r103, r104));
        e0.c(this.f147807b, this.f147809d, this.f147806a.a(), this.f147810e);
    }
}
