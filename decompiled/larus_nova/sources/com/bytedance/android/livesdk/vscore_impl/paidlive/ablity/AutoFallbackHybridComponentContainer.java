package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import jc1.k;

/* JADX INFO: loaded from: classes11.dex */
public class AutoFallbackHybridComponentContainer extends FrameLayout implements com.bytedance.android.live.browser.jsbridge.f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f160029f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f160030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f160031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HybridCard f160032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.a f160033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f160034e;

    public interface a {
        void b();
    }

    public final void a() {
        if (v.a() == false) goto L6;
        TextView r100 = new TextView(getContext());
        r100.setBackgroundColor(FakePickerAvatarCreator.GREEN);
        r100.setTextColor(-1);
        r100.setText("null");
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-2, -2);
        r101.gravity = 0;
        r100.setLayoutParams(r101);
        addView(r100);
        return;
    }

    public AutoFallbackHybridComponentContainer(Context r100) {
        super(r100);
        a();
    }

    public final void b(String r100) {
        ALogger.i("AutoFallbackHybridComponentContainer", r100);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.a] */
    public final void loadUrl(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L17;
        Map<String, String> r101 = this.f160031b;
        if (r101 == null) goto L17;
        if (r101.isEmpty() == true) goto L17;
        Uri r102 = UriProtector.parse(r100);
        Uri.Builder r103 = r102.buildUpon();
        Set<String> r104 = UriProtector.getQueryParameterNames(r102);
        Iterator<String> r105 = this.f160031b.keySet().iterator();
    L12:
        if (r105.hasNext() == false) goto L16;
        String r106 = r105.next();
        if (r104.contains(r106) == true) goto L12;
        r103.appendQueryParameter(r106, this.f160031b.get(r106));
        goto L12
    L16:
        r100 = r103.build().toString();
    L17:
        this.f160030a = r100;
        this.f160033d = new com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.a(this);
        Uri r107 = x6.a.d(r100);
        IBrowserService r108 = (IBrowserService) k.f(IBrowserService.class);
        if (r108 != null) goto L21;
        b("lynx view create error. browser service is null, url is " + this.f160030a);
        return;
    L21:
        if (TextUtils.isEmpty(this.f160030a) == false) goto L23;
        b("view create error. url is null");
        return;
    L23:
        HybridCard r109 = this.f160032c;
        if (r109 == null) goto L26;
        r109.setOnTouchListener(null);
        removeView(this.f160032c);
        this.f160032c.release();
        this.f160032c = null;
    L26:
        HybridCard r110 = r108.getHybridCard(getContext(), r107, new b(this));
        this.f160032c = r110;
        if (r110 != null) goto L29;
        b("view create error. component is null, url is " + this.f160030a);
        return;
    L29:
        r110.setOnTouchListener(this.f160033d);
        this.f160032c.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.f160032c, 0);
        this.f160032c.load(null, null);
    }

    public void setListener(a r100) {
        this.f160034e = r100;
    }

    public void setParams(Map<String, String> r100) {
        this.f160031b = r100;
    }

    public AutoFallbackHybridComponentContainer(Context r100, AttributeSet r101) {
        super(r100, r101);
        a();
    }

    @Override // com.bytedance.android.live.browser.jsbridge.f
    public final <T> void sendJsEvent(String r100, T r101) {
        HybridCard r102 = this.f160032c;
        if (r102 == null) goto L6;
        r102.sendJsEvent(r100, r101);
        return;
    }

    public AutoFallbackHybridComponentContainer(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a();
    }
}
