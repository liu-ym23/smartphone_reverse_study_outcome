package com.bytedance.android.livesdk.chatroom.vs.video;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.livesdk.chatroom.ui.AutoFallbackHybridComponentContainer;
import com.bytedance.android.livesdk.chatroom.ui.m5;
import com.bytedance.android.livesdk.chatroom.ui.n5;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs/video/FullHybridViewFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FullHybridViewFragment extends BaseFragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f117757h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f117758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AutoFallbackHybridComponentContainer f117759e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f117760f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f117761g;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        AutoFallbackHybridComponentContainer r100 = this.f117759e;
        if (r100 == null) goto L7;
        HybridCard r101 = r100.f112114c;
        if (r101 == null) goto L7;
        r101.setOnTouchListener(null);
        r100.removeView(r100.f112114c);
        r100.f112114c.release();
        r100.f112114c = null;
    L7:
        super.onDestroy();
        Disposable r102 = this.f117761g;
        if (r102 == null) goto L11;
        r102.dispose();
        return;
    }

    public FullHybridViewFragment() {
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.android.livesdk.chatroom.ui.m5] */
    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.ttlive_full_hybrid_fragment_layout, r101, false);
        this.f117760f = r103;
        if (r103 == null) goto L5;
        final AutoFallbackHybridComponentContainer r104 = (AutoFallbackHybridComponentContainer) r103.findViewById(R.id.full_view_hybrid_container);
    L6:
        this.f117759e = r104;
        String r105 = this.f117758d;
        if (r105 == null) goto L37;
        if (r104 == null) goto L37;
        if (TextUtils.isEmpty(r105) == true) goto L24;
        Map<String, String> r106 = r104.f112113b;
        if (r106 == null) goto L24;
        if (r106.isEmpty() == true) goto L24;
        Uri r107 = UriProtector.parse(r105);
        Uri.Builder r108 = r107.buildUpon();
        Set<String> r109 = UriProtector.getQueryParameterNames(r107);
        Iterator<String> r110 = r104.f112113b.keySet().iterator();
    L19:
        if (r110.hasNext() == false) goto L23;
        String r111 = r110.next();
        if (r109.contains(r111) == true) goto L19;
        r108.appendQueryParameter(r111, r104.f112113b.get(r111));
        goto L19
    L23:
        r105 = r108.build().toString();
    L24:
        r104.f112112a = r105;
        r104.f112115d = new m5(r104);
        Uri r112 = x6.a.d(r105);
        IBrowserService r113 = (IBrowserService) k.f(IBrowserService.class);
        if (r113 != null) goto L28;
        r104.b("lynx view create error. browser service is null, url is " + r104.f112112a);
        goto L37
    L28:
        if (TextUtils.isEmpty(r104.f112112a) == false) goto L30;
        r104.b("view create error. url is null");
        goto L37
    L30:
        HybridCard r114 = r104.f112114c;
        if (r114 == null) goto L33;
        r114.setOnTouchListener(null);
        r104.removeView(r104.f112114c);
        r104.f112114c.release();
        r104.f112114c = null;
    L33:
        HybridCard r115 = r113.getHybridCard(r104.getContext(), r112, new n5(r104));
        r104.f112114c = r115;
        if (r115 != null) goto L36;
        r104.b("view create error. component is null, url is " + r104.f112112a);
        goto L37
    L36:
        r115.setOnTouchListener(r104.f112115d);
        r104.f112114c.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r104.addView(r104.f112114c, 0);
        r104.f112114c.load(null, null);
    L37:
        this.f117761g = ((IBrowserService) k.n(IBrowserService.class)).registerJsEventSubscriber("poster_detail_close").observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.chatroom.vs.video.a(this));
        return this.f117760f;
    L5:
        r104 = null;
        goto L6
    }
}
