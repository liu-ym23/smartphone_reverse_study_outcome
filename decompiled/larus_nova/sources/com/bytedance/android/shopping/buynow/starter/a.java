package com.bytedance.android.shopping.buynow.starter;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.larus.nova.R;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f171130a = 0;

    static {
    }

    public static void a(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Map<Activity, ShoppingAsyncCacheInflater> r101 = ShoppingAsyncCacheInflater.f45261d;
        ShoppingAsyncCacheInflater.a.a(r100).a().a(R.layout.buynow_layout_counter, 1).a(R.layout.buynow_layout_countdown, 1).a(R.layout.buynow_layout_marquee_content, 2).commit();
    }
}
