package com.bytedanceos.appstore.buss.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedanceos.appstore.buss.utilities.CommonUtil;
import com.bytedanceos.common.toolbox.TouchUtil;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.bytedanceos.common.tracker.TrackerElement;
import com.obric.appstore.R;
import com.tmall.wireless.tangram.eventbus.BusSupport;
import java.util.Observable;
import java.util.Observer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 12\u00020\u00012\u00020\u00022\u00020\u0003:\u00012B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\n\u0010\u0005J\u0019\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0005J#\u0010\u0018\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0005J\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u0005J\u000f\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u0005R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010%\u001a\n \"*\u0004\u0018\u00010!0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010)\u001a\n \"*\u0004\u0018\u00010&0&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001c\u00100\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010.8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010/¨\u00063"}, d2 = {"Lcom/bytedanceos/appstore/buss/fragment/g1;", "Lh7/c;", "Landroid/view/View$OnClickListener;", "Ljava/util/Observer;", "<init>", "()V", "", "E", "initData", "F", "t", "Landroid/view/View;", "v", BusSupport.EVENT_ON_CLICK, "(Landroid/view/View;)V", "Lp7/c;", "event", "onEvent", "(Lp7/c;)V", "onDestroyView", "Ljava/util/Observable;", "o", "", "arg", "update", "(Ljava/util/Observable;Ljava/lang/Object;)V", "J", "I", "K", "Lcom/bytedanceos/common/toolbox/TouchUtil;", "f", "Lcom/bytedanceos/common/toolbox/TouchUtil;", "mTouchUtil", "Lcom/bytedanceos/common/toolbox/cache/AccountDataCache;", "kotlin.jvm.PlatformType", "g", "Lcom/bytedanceos/common/toolbox/cache/AccountDataCache;", "acccountCache", "Lm8/a;", "h", "Lm8/a;", "accountRequestHelper", "", "n", "()I", "layoutId", "Lkotlin/Function0;", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "i", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class g1 extends h7.c implements View.OnClickListener, Observer {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f8713i = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TouchUtil f8714f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AccountDataCache f8715g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final m8.a f8716h;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Fragment a() {
            return new g1();
        }

        public a() {
        }
    }

    static {
        f8713i = new a(null);
    }

    public g1() {
        this.f8715g = AccountDataCache.b();
        this.f8716h = m8.a.i();
    }

    public static /* synthetic */ void G() {
        H();
    }

    public static final void H() {
    }

    @Override // h7.c
    public void E() {
    }

    @Override // h7.c
    public void F() {
    }

    public final void I() {
    }

    public final void J() {
    }

    public final void K() {
    }

    @Override // h7.c
    public void initData() {
        EventBus.getDefault().register(this);
        h7.c.w(this, getString(R.string.settings), false, false, 4, null);
        I();
        if (this.f8715g.n() == false) goto L6;
        this.f8716h.f();
        this.f8716h.addObserver(this);
        return;
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_setting;
    }

    @Override // h7.c
    public Function0 o() {
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        if (r10 == null) goto L5;
        Integer r11 = Integer.valueOf(r10.getId());
    L6:
        if (r11 != null) goto L9;
    L18:
        if (r11 != null) goto L21;
        return;
    L21:
        if (r11.intValue() == R.id.enable_events_sender) goto L23;
        return;
    L23:
        if (this.f8714f != null) goto L25;
        TouchUtil r12 = new TouchUtil();
        this.f8714f = r12;
        r12.a(new f1());
    L25:
        TouchUtil r13 = this.f8714f;
        if (r13 == null) goto L32;
        r13.b();
        return;
    L32:
        return;
    L9:
        if (r11.intValue() != R.id.tv_user_info) goto L18;
        Bundle r14 = new Bundle();
        if (this.f8715g.n() == false) goto L13;
        String r15 = "have_login";
    L14:
        r14.putString("user_login_status", r15);
        f9.b.b("click_setting_login", r14);
        if (this.f8715g.n() == false) goto L17;
        i7.a.g(this, UserInfoFragment.f8687j.a(), false, 2, null);
        return;
    L17:
        CommonUtil.f8830a.h(l(), "page_setting", true);
        l().overridePendingTransition(0, 0);
        return;
    L13:
        r15 = "not_login";
        goto L14
    L5:
        r11 = null;
        goto L6
    }

    @Override // h7.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Bundle r10 = new Bundle();
        if (this.f8715g.n() == false) goto L5;
        String r11 = "have_login";
    L6:
        r10.putString(TrackerElement.ISLOGIN, r11);
        f9.b.b("app_setting_state", r10);
        this.f8716h.deleteObserver(this);
        EventBus.getDefault().unregister(this);
        return;
    L5:
        r11 = "not_login";
        goto L6
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull p7.c r10) {
        kotlin.jvm.internal.q.g(r10, "event");
        K();
    }

    @Override // h7.c
    public void t() {
        J();
        K();
        r();
    }

    @Override // java.util.Observer
    public void update(Observable r10, Object r11) {
        K();
    }
}
