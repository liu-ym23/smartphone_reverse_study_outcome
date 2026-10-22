package c35;

import android.graphics.RectF;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.bytedance.ee.bear.document.onboarding.c;
import com.bytedance.ee.bear.onboarding.export.Direction;
import com.bytedance.ee.bear.onboarding.export.ui.FlowStyleHollowShape;
import com.bytedance.ee.util.ui.n;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;
import uk5.e;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends com.bytedance.ee.bear.document.onboarding.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f22274d;

    /* JADX INFO: renamed from: c35.a$a, reason: collision with other inner class name */
    public static final class C0397a {
    }

    static {
    }

    @Override // tk5.d
    public final String getId() {
        return this.f220703a.getAction();
    }

    @Override // tk5.d
    public final String getBiz() {
        return this.f22273c;
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b
    public final boolean c(c r100, OnBoardingData r101) {
        Intrinsics.checkNotNullParameter(r100, "ui");
        Intrinsics.checkNotNullParameter(r101, "data");
        StringBuilder r102 = new StringBuilder("show, type is ");
        OnBoardingData.CustomData r103 = r101.customData;
        OnBoardingData.OnBoardingType r104 = null;
        if (r103 == null) goto L5;
        OnBoardingData.OnBoardingType r105 = r103.type;
    L6:
        r102.append(r105);
        r102.append(", id = ");
        r102.append(getId());
        tt5.a.h("CustomOnBoardingMission", r102.toString());
        OnBoardingData.CustomData r106 = r101.customData;     // Catch: Exception -> L30
        if (r106 == null) goto L10;
        OnBoardingData.OnBoardingType r107 = r106.type;     // Catch: Exception -> L30
    L12:
        if (r107 == OnBoardingData.OnBoardingType.TEXT) goto L14;
        if (r106 == null) goto L17;
        OnBoardingData.OnBoardingType r108 = r106.type;     // Catch: Exception -> L30
    L19:
        if (r108 == OnBoardingData.OnBoardingType.FLOW) goto L21;
        if (r106 == null) goto L25;
        r104 = r106.type;     // Catch: Exception -> L30
    L25:
        if (r104 == OnBoardingData.OnBoardingType.CARD) goto L27;
        tt5.a.h("CustomOnBoardingMission", "show is false");     // Catch: Exception -> L30
        return false;
    L27:
        return d(r100, r101);
    L21:
        return e(r100, r101);
    L17:
        r108 = null;
        goto L19
    L14:
        return f(r100, r101);
    L10:
        r107 = null;
    L30:
        e = move-exception;
        tt5.a.e("CustomOnBoardingMission", "show error", e, false);
        return false;
    L5:
        r105 = null;
        goto L6
    }

    public final boolean d(c r100, OnBoardingData r101) {
        OnBoardingData.CustomData r102 = r101.customData;
        if (r102 != null) goto L5;
        return false;
    L5:
        FragmentActivity r103 = r100.getActivity();
        if (r103 != null) goto L8;
        return false;
    L8:
        String r104 = r102.title;
        String r105 = "";
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        String r106 = r102.body;
        if (r106 != null) goto L14;
        r106 = "";
    L14:
        String r107 = r102.confirmText;
        if (r107 == null) goto L18;
        r105 = r107;
    L18:
        uk5.b r108 = new uk5.b(r104, Integer.valueOf(n.n(r103, r102.imgRes)));
        r108.f550497c = r106;
        r108.f550499e = r105;
        r108.f550500f = true;
        r100.b(r103.getWindow(), r108, new b(this, this.f22274d));
        return true;
    }

    public final boolean e(c r100, OnBoardingData r110) {
        OnBoardingData.CustomData r111 = r110.customData;
        if (r111 != null) goto L5;
        return false;
    L5:
        String r101 = r111.onboardingViewTag;
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        String r103 = r111.title;
        RectF r104 = new RectF();
        OnBoardingData.Position r105 = this.f220703a.position;
        float r106 = r105.f220697x;
        r104.left = r106;
        float r107 = r105.f220698y;
        r104.top = r107;
        r104.right = r106 + r105.width;
        r104.bottom = r107 + r105.height;
        uk5.c r108 = new uk5.c(r103, true, r104);
    L21:
        r108.f550512m = r111.confirmText;
        r108.f550508i = FlowStyleHollowShape.None;
        r108.f550502c = r111.body;
        r100.c(r100.getActivity().getWindow(), r108, new b(this, null));
        return true;
    L14:
        View r109 = r100.f220705g.findMenuView(r111.onboardingViewTag);
        if (r109 != null) goto L20;
        r109 = r100.f220706h.findViewWithTag(r111.onboardingViewTag);
        if (r109 != null) goto L20;
        tt5.a.k("CustomOnBoardingMission", "showFlow... view is null");
        return false;
    L20:
        r108 = new uk5.c(r111.title, r109);
        goto L21
    L8:
        if (r101.length() == 0) goto L11;
        r102 = false;
        goto L12
    }

    public final boolean f(c r100, OnBoardingData r110) {
        OnBoardingData.CustomData r111 = r110.customData;
        if (r111 != null) goto L5;
        return false;
    L5:
        String r101 = r111.onboardingViewTag;
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        String r103 = r111.title;
        RectF r104 = new RectF();
        OnBoardingData.Position r105 = this.f220703a.position;
        float r106 = r105.f220697x;
        r104.left = r106;
        float r107 = r105.f220698y;
        r104.top = r107;
        r104.right = r106 + r105.width;
        r104.bottom = r107 + r105.height;
        e r108 = new e(r103, r104);
    L21:
        r108.f550517c = r111.body;
        r108.f550525k = r111.makeTextCenter;
        r108.f550526l = r111.hideArrow;
        OnBoardingData.Direction r112 = r111.suggestedDirection;
        if (r112 != OnBoardingData.Direction.DOWN) goto L25;
        Direction r113 = Direction.DOWN;
    L28:
        r108.f550521g = r113;
        r100.d(r100.getActivity().getWindow(), r108, new b(this, null));
        return true;
    L25:
        if (r112 != OnBoardingData.Direction.UP) goto L27;
        r113 = Direction.UP;
        goto L28
    L27:
        r113 = Direction.NONE;
        goto L28
    L14:
        View r109 = r100.f220705g.findMenuView(r111.onboardingViewTag);
        if (r109 != null) goto L20;
        r109 = r100.f220706h.findViewWithTag(r111.onboardingViewTag);
        if (r109 != null) goto L20;
        tt5.a.k("CustomOnBoardingMission", "showText... view is null");
        return false;
    L20:
        r108 = new e(r111.title, r109);
        goto L21
    L8:
        if (r101.length() == 0) goto L11;
        r102 = false;
        goto L12
    }

    public a(OnBoardingData r100, String r101, m r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "biz");
        super(r100);
        this.f22273c = r101;
        this.f22274d = r102;
    }
}
