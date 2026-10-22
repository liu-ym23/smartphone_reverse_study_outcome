package com.bytedanceos.appstore.buss.fragment;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.obric.appstore.R;
import com.tmall.wireless.tangram.eventbus.BusSupport;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u001d\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\t\u0010\u0004J\u0019\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0004R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001c\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010)8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/bytedanceos/appstore/buss/fragment/GiftFragment;", "Lh7/c;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "", "E", "initData", "F", "t", "Landroid/view/View;", "v", BusSupport.EVENT_ON_CLICK, "(Landroid/view/View;)V", "K", "onDestroyView", "L", "Lc7/a;", "f", "Lc7/a;", "adapter", "Lcom/bytedanceos/appstore/buss/fragment/GiftMyFragment;", "g", "Lcom/bytedanceos/appstore/buss/fragment/GiftMyFragment;", "giftMyFragment", "Lcom/bytedanceos/appstore/buss/fragment/GiftAllFragment;", "h", "Lcom/bytedanceos/appstore/buss/fragment/GiftAllFragment;", "giftAllFragment", "com/bytedanceos/appstore/buss/fragment/GiftFragment$b", "i", "Lcom/bytedanceos/appstore/buss/fragment/GiftFragment$b;", "onPageChangeListener", "", "q", "()Z", "showHeader", "", "n", "()I", "layoutId", "Lkotlin/Function0;", "o", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "Lx7/v;", "J", "()Lx7/v;", "fragmentTvGiftBinding", "j", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GiftFragment extends h7.c implements View.OnClickListener {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f8579j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c7.a f8580f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public GiftMyFragment f8581g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public GiftAllFragment f8582h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f8583i;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Fragment a() {
            return new GiftFragment();
        }

        public a() {
        }
    }

    public static final class b extends ViewPager.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftFragment f8584a;

        public b(GiftFragment r10) {
            this.f8584a = r10;
        }

        @Override // androidx.viewpager.widget.ViewPager.f, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r10) {
            super.onPageSelected(r10);
            GiftFragment.I(this.f8584a);
        }
    }

    static {
        f8579j = new a(null);
    }

    public GiftFragment() {
        this.f8583i = new b(this);
    }

    public static final /* synthetic */ void G(GiftFragment r10, GiftAllFragment r11) {
        r10.f8582h = r11;
    }

    public static final /* synthetic */ void H(GiftFragment r10, GiftMyFragment r11) {
        r10.f8581g = r11;
    }

    public static final /* synthetic */ void I(GiftFragment r10) {
        r10.L();
    }

    @Override // h7.c
    public void E() {
    }

    @Override // h7.c
    public void F() {
        if (J().f25773e != null) goto L6;
        return;
    L6:
        if (J().f25773e.getCurrentItem() != 0) goto L10;
        GiftAllFragment r10 = this.f8582h;
        if (r10 == null) goto L14;
        r10.F();
        return;
    L14:
        return;
    L10:
        GiftMyFragment r11 = this.f8581g;
        if (r11 == null) goto L16;
        r11.F();
        return;
    }

    public final x7.v J() {
        x7.v r10 = x7.v.a(m());
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public final void K() {
        J().f25773e.setCurrentItem(0);
    }

    public final void L() {
        if (J().f25773e.getCurrentItem() != 0) goto L5;
        J().f25771c.setSelected(true);
        J().f25772d.setSelected(false);
        return;
    L5:
        J().f25771c.setSelected(false);
        J().f25772d.setSelected(true);
    }

    @Override // h7.c
    public void initData() {
        J().f25771c.setOnClickListener(this);
        J().f25772d.setOnClickListener(this);
        Map r10 = kotlin.collections.k0.j(new Pair[]{kotlin.d.a(0, new AnonymousClass1(this)), kotlin.d.a(1, new AnonymousClass2(this))});
        FragmentManager r11 = getChildFragmentManager();
        kotlin.jvm.internal.q.f(r11, "getChildFragmentManager(...)");
        this.f8580f = new c7.a(new String[]{"全部礼包", "我的礼包"}, r10, r11);
        J().f25773e.setAdapter(this.f8580f);
        J().f25773e.addOnPageChangeListener(this.f8583i);
        J().f25773e.setCurrentItem(0);
        L();
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_gift;
    }

    @Override // h7.c
    public Function0 o() {
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        if (r10 == null) goto L4;
        Integer r11 = Integer.valueOf(r10.getId());
    L5:
        if (r11 != null) goto L8;
    L10:
        if (r11 != null) goto L13;
        return;
    L13:
        if (r11.intValue() != R.id.tv_gift_my) goto L17;
        J().f25773e.setCurrentItem(1);
        return;
    L17:
        return;
    L8:
        if (r11.intValue() != R.id.tv_gift_all) goto L10;
        J().f25773e.setCurrentItem(0);
        return;
    L4:
        r11 = null;
        goto L5
    }

    @Override // h7.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f8580f = null;
    }

    @Override // h7.c
    public boolean q() {
        return false;
    }

    @Override // h7.c
    public void t() {
        r();
    }
}
