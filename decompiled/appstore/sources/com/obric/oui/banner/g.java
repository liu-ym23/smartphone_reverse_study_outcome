package com.obric.oui.banner;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class g extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f12459g = null;

    public static final class a implements IBannerViewHolderFactory {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        @Override // com.obric.oui.banner.IBannerViewHolderFactory
        public String getKey() {
            return "_stub";
        }

        @Override // com.obric.oui.banner.IBannerViewHolderFactory
        public d newInstance(ViewGroup r10) {
            q.g(r10, "parent");
            View r11 = new View(r10.getContext());
            r11.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return new g(r11);
        }

        public a() {
        }
    }

    static {
        f12459g = new a(null);
    }

    public g(View r10) {
        q.g(r10, "view");
        super(r10);
    }

    @Override // com.obric.oui.banner.d
    public void g(BannerData r10) {
        q.g(r10, "data");
    }
}
