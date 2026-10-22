package com.bytedanceos.appstore.buss.utilities;

import android.app.Activity;
import com.bytedanceos.common.ui.listener.AppStateHelper;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
public final class AppAd {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f8826b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f8827c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f8828a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final AppAd a() {
            return (AppAd) AppAd.a().getValue();
        }

        public a() {
        }
    }

    public static final class b implements AppStateHelper.AppStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppAd f8829a;

        public b(AppAd r10) {
            this.f8829a = r10;
        }

        @Override // com.bytedanceos.common.ui.listener.AppStateHelper.AppStateChangeListener
        public void onBackground(Activity r10) {
            kotlin.jvm.internal.q.g(r10, "activity");
            AppAd.b(this.f8829a, System.currentTimeMillis());
        }

        @Override // com.bytedanceos.common.ui.listener.AppStateHelper.AppStateChangeListener
        public void onForeground(Activity r10) {
            kotlin.jvm.internal.q.g(r10, "activity");
        }
    }

    static {
        f8826b = new a(null);
        f8827c = kotlin.b.b(AppAd$Companion$instance$2.INSTANCE);
    }

    public AppAd() {
    }

    public static final /* synthetic */ Lazy a() {
        return f8827c;
    }

    public static final /* synthetic */ void b(AppAd r10, long r11) {
        r10.f8828a = r11;
    }

    public final void c() {
        AppStateHelper.getInstance().addListener(new b(this));
    }
}
