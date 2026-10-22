package com.bytedance.android.livesdk.livecommerce.broadcast.ui;

import vi2.v0;
import xi2.p;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements v0<p> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRoomCouponListViewModel.b f147704a;

    public c(LiveRoomCouponListViewModel.b r100) {
        this.f147704a = r100;
    }

    @Override // vi2.v0
    public final void onError(Throwable r100) {
        this.f147704a.f147698a.getFullLoadingFinishData().postValue(null);
        LiveRoomCouponListViewModel.access$1200(this.f147704a.f147698a);
        LiveRoomCouponListViewModel.access$1002(this.f147704a.f147698a, null);
    }

    @Override // vi2.v0
    public final void onSuccess(p r100) {
        this.f147704a.f147698a.getFullLoadingFinishData().postValue(null);
        LiveRoomCouponListViewModel.access$1100(this.f147704a.f147698a);
        LiveRoomCouponListViewModel.access$1002(this.f147704a.f147698a, null);
    }
}
