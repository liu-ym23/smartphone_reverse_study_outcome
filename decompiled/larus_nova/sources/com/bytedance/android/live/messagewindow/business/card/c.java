package com.bytedance.android.live.messagewindow.business.card;

import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.room.api.messagewindow.identity.CardTypeAndPriority;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Single;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c extends v61.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final DataCenter f82925m;

    public static final class a implements t71.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f82926a;

        @Override // t71.a
        public final Single<Boolean> a() {
            return null;
        }

        @Override // t71.a
        public final Object getIdentity() {
            return null;
        }

        @Override // t71.a
        public final void onIntercept() {
        }

        public a(c r100) {
            this.f82926a = r100;
        }

        @Override // t71.a
        public final boolean b(v61.a r100) {
            Intrinsics.checkNotNullParameter(r100, "msgWindow");
            DataCenter r101 = this.f82926a.f82925m;
            if (r101 == null) goto L11;
            IRoom r102 = a0.n(r101);
            if (r102 == null) goto L11;
            IRoomAuthStatus r103 = r102.getRoomAuthStatus();
            if (r103 == null) goto L11;
            if (r103.enableBanner() == true) goto L11;
            return true;
        L11:
            return false;
        }
    }

    @Override // v61.a
    public final void I() {
        t(new am0.a(null));
        i(new a(this));
    }

    @Override // v61.c
    public final x61.h<?, ?> content() {
        x61.h.f562592a.getClass();
        return x61.a.f562582b;
    }

    @Override // v61.a, r61.b
    public final DataCenter getDataCenter() {
        return this.f82925m;
    }

    public c(DataCenter r100) {
        CardTypeAndPriority r101 = CardTypeAndPriority.Banner;
        super(r100, r101.getType(), r101.getPriority());
        this.f82925m = r100;
    }
}
