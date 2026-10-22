package b04;

import android.app.Activity;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends BaseElement<i, j, tz3.a, jz3.a> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Activity f16861g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o f16862h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f16863i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f16864j;

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void onCreate() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.a b() {
        return new i();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b c() {
        return new j();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c d() {
        return new h(getContext(), g(), h());
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void o() {
        a r100 = this.f16863i;
        if (r100 == null) goto L5;
        this.f16862h.removePlayStateListener(r100);
    L5:
        this.f16863i = null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void k() {
        h().f16878a.b(Boolean.TRUE);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void m() {
        h().f16878a.b(Boolean.FALSE);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d e() {
        return com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.a.f196609f;
    }

    public final Activity getActivity() {
        return this.f16861g;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void l(jz3.a r100) {
        jz3.a r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f16864j = r101.f501173a.c();
        if (this.f16862h.getPageConfig().isTeenagerModel() == false) goto L5;
    L12:
        j();
        return;
    L5:
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.f195993e == true) goto L12;
        if (Intrinsics.areEqual(this.f16862h.getPageConfig().getEnterFrom(), "volc_agent_card") == true) goto L12;
        e24.b r102 = r101.f501173a.z();
        p();
        h().f16880c.b(r102);
        if (this.f16863i != null) goto L14;
        a r103 = new a(this);
        this.f16862h.addPlayStateListener(r103);
        this.f16863i = r103;
        return;
    }

    public b(Activity r100, o r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "vm");
        super(r100);
        this.f16861g = r100;
        this.f16862h = r101;
    }
}
