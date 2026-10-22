package com.bytedance.android.shopping.anchorv4.nav.controls;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.nav.ShareMeta;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.TagsScrollBoxComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006J\b\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/nav/controls/ShareBtnAnimController;", "", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/bytedance/android/shopping/anchorv4/nav/controls/d;", "", "onAnchorV4Stop", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShareBtnAnimController implements LifecycleObserver, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f167122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f167123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f167124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f167125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Calendar f167126e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SimpleDraweeView f167127f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f167128g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f167129h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TagsScrollBoxComponentView f167130i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TagsScrollBoxComponent f167131j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TopRightControlsMeta f167132k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lifecycle f167133l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f167134m;

    public static final class a {
    }

    static {
    }

    public final h b() {
        if (this.f167129h == null) goto L5;
        return (h) u0.b(q.f48131a.getString("action_share", "{\"day\":0}"), h.class);
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return new h(0);
    L5:
        return new h(0);
    }

    public final boolean d() {
        if (this.f167123b == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f167124c == true) goto L7;
        return true;
    }

    public final boolean e() {
        TopRightControlsMeta r100 = this.f167132k;
        if (r100 == null) goto L7;
        ShareMeta r101 = r100.getShareMeta();
        if (r101 == null) goto L7;
        Integer r102 = r101.getShareButtonAnimation();
    L8:
        if (r102 != null) goto L11;
    L13:
        return false;
    L11:
        if (r102.intValue() != 1) goto L13;
        return true;
    L7:
        r102 = null;
        goto L8
    }

    @Override // com.bytedance.android.shopping.anchorv4.nav.controls.d
    public final void a() {
        if (e() == false) goto L7;
        b r100 = this.f167134m;
        if (r100 == null) goto L7;
        r100.a(false);
    L7:
        h r101 = b();
        Iterator<T> r102 = r101.f167144b.iterator();
    L8:
        View r103 = null;
        if (r102.hasNext() == false) goto L13;
        Object r104 = r102.next();
        if (Intrinsics.areEqual(((e) r104).f167136a, this.f167129h) == false) goto L8;
    L14:
        e r105 = (e) r104;
        Iterator<T> r106 = r101.f167144b.iterator();
        int r107 = 0;
    L16:
        if (r106.hasNext() == false) goto L19;
        r107 = r107 + (((e) r106.next()).f167138c ? 1 : 0);
        goto L16
    L19:
        if (e() == false) goto L45;
        boolean r108 = true;
        if (r101.f167143a != this.f167126e.get(6)) goto L46;
        List<e> r109 = r101.f167144b;
        if ((r109 instanceof Collection) == true) goto L27;
    L29:
        Iterator<T> r110 = r109.iterator();
    L31:
        if (r110.hasNext() == false) goto L35;
        if (((e) r110.next()).f167137b == false) goto L31;
        boolean r111 = true;
    L36:
        if (r111 == true) goto L45;
        if (r105 == null) goto L43;
        if (r105.f167138c == true) goto L45;
    L43:
        if (r107 >= 5) goto L45;
    L35:
        r111 = false;
        goto L36
    L27:
        if (r109.isEmpty() == false) goto L29;
    L46:
        if (r108 == false) goto L82;
        TagsScrollBoxComponent r112 = this.f167131j;
        if (r112 == null) goto L82;
        List<TextWithOneIconElement> r113 = r112.getButtonList();
        if (r113 == null) goto L82;
        Iterator<TextWithOneIconElement> r114 = r113.iterator();
        int r115 = 0;
    L54:
        if (r114.hasNext() == false) goto L63;
        Action r116 = r114.next().getAction();
        if (r116 == null) goto L58;
        String r117 = r116.getId();
    L60:
        if (Intrinsics.areEqual(r117, "action_share") == true) goto L64;
        r115 = r115 + 1;
    L64:
        TagsScrollBoxComponentView r118 = this.f167130i;
        if (r118 == null) goto L73;
        List<View> r119 = com.bytedance.commerce.base.view.b.a(r118);
        if (r119 == null) goto L73;
        View r120 = (View) CollectionsKt.getOrNull(r119, 0);
        if (r120 == null) goto L73;
        List<View> r121 = com.bytedance.commerce.base.view.b.a(r120);
        if (r121 == null) goto L73;
        View r122 = (View) CollectionsKt.getOrNull(r121, r115);
    L75:
        if ((r122 instanceof TextWithOneIconElementView) == false) goto L78;
        r103 = r122;
    L78:
        final TextWithOneIconElementView r123 = (TextWithOneIconElementView) r103;
        if (r123 == null) goto L82;
        this.f167122a = new ShareBtnAnimController$initShareBtnAnim$1(this, r123);
    L73:
        r122 = null;
        goto L75
    L58:
        r117 = null;
        goto L60
    L63:
        r115 = -1;
    L82:
        Lifecycle r124 = this.f167133l;
        if (r124 == null) goto L95;
        r124.addObserver(this);
        return;
    L95:
        return;
    L45:
        r108 = false;
        goto L46
    L13:
        r104 = null;
        goto L14
    }

    public final void c() {
        if (e() == true) goto L5;
        return;
    L5:
        if (this.f167123b == false) goto L19;
        View r100 = this.f167128g;
        if (r100 == null) goto L10;
        r100.setScaleX(1.0f);
        r100.setScaleY(1.0f);
        r100.setAlpha(1.0f);
        r100.setVisibility(0);
    L10:
        SimpleDraweeView r101 = this.f167127f;
        if (r101 == null) goto L13;
        r101.setVisibility(4);
    L13:
        b r102 = this.f167134m;
        if (r102 == null) goto L16;
        r102.a(false);
    L16:
        this.f167124c = true;
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onAnchorV4Stop() {
        if (e() == false) goto L36;
        List<e> r100 = b().f167144b;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
        boolean r103 = false;
    L6:
        if (r102.hasNext() == false) goto L19;
        e r104 = (e) r102.next();
        if (Intrinsics.areEqual(r104.f167136a, this.f167129h) == true) goto L9;
        r101.add(r104);
        goto L6
    L9:
        String r105 = this.f167129h;
        if (r104.f167137b == false) goto L12;
        boolean r106 = true;
    L14:
        if (r104.f167138c == false) goto L16;
        boolean r107 = true;
    L17:
        r101.add(new e(r105, r106, r107));
        r103 = true;
        goto L6
    L16:
        r107 = this.f167123b;
        goto L17
    L12:
        r106 = this.f167125d;
        goto L14
    L19:
        if (r103 == true) goto L28;
        String r108 = this.f167129h;
        if (r108 == null) goto L28;
        r101.add(new e(r108, this.f167125d, this.f167123b));
    L28:
        q.f48131a.putString("action_share", u0.d(new h(this.f167126e.get(6), r101)));     // Catch: Exception -> L25
        return;
    L25:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    }

    public final void f(int r100) {
        Intrinsics.checkNotNullParameter("action_share", "actionName");
        if (r100 > 1000) goto L5;
        return;
    L5:
        if (this.f167123b == true) goto L11;
        this.f167123b = true;
        Function0<Unit> r101 = this.f167122a;
        if (r101 == null) goto L12;
        Unit r102 = r101.invoke();
        return;
    L12:
        return;
    }

    public ShareBtnAnimController(String r100, TagsScrollBoxComponentView r101, TagsScrollBoxComponent r102, TopRightControlsMeta r103, Lifecycle r104, b r105) {
        this.f167129h = r100;
        this.f167130i = r101;
        this.f167131j = r102;
        this.f167132k = r103;
        this.f167133l = r104;
        this.f167134m = r105;
        this.f167126e = Calendar.getInstance();
    }
}
