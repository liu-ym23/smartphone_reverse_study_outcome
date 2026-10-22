package bvc;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.badge.BadgeAnchor;
import xuc.d;

/* JADX INFO: loaded from: classes42.dex */
public final class a extends FrameLayout implements xuc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f20971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f20972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f20973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f20974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f20975e;

    @Override // xuc.b
    public int getContentBottom() {
        d r100 = this.f20971a;
        if ((r100 instanceof xuc.b) == false) goto L7;
        return ((xuc.b) r100).getContentBottom();
    L7:
        return getBottom();
    }

    @Override // xuc.b
    public int getContentLeft() {
        if ((this.f20971a instanceof xuc.b) == false) goto L7;
        return getLeft() + ((xuc.b) this.f20971a).getContentLeft();
    L7:
        return getLeft();
    }

    @Override // xuc.b
    public int getContentRight() {
        if ((this.f20971a instanceof xuc.b) == false) goto L7;
        return getLeft() + ((xuc.b) this.f20971a).getContentRight();
    L7:
        return getRight();
    }

    @Override // xuc.b
    public int getContentTop() {
        d r100 = this.f20971a;
        if ((r100 instanceof xuc.b) == false) goto L7;
        return ((xuc.b) r100).getContentTop();
    L7:
        return getTop();
    }

    public View getBadgeView() {
        return this.f20972b;
    }

    public d getInnerPagerTitleView() {
        return this.f20971a;
    }

    public b getXBadgeRule() {
        return this.f20974d;
    }

    public b getYBadgeRule() {
        return this.f20975e;
    }

    public a(Context r100) {
        super(r100);
        this.f20973c = true;
    }

    public void setAutoCancelBadge(boolean r100) {
        this.f20973c = r100;
    }

    public void setBadgeView(View r100) {
        if (this.f20972b != r100) goto L5;
        return;
    L5:
        this.f20972b = r100;
        removeAllViews();
        if ((this.f20971a instanceof View) == false) goto L9;
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-1, -1);
        addView((View) this.f20971a, r101);
    L9:
        if (this.f20972b == null) goto L12;
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-2, -2);
        addView(this.f20972b, r102);
        return;
    }

    public void setInnerPagerTitleView(d r100) {
        if (this.f20971a != r100) goto L5;
        return;
    L5:
        this.f20971a = r100;
        removeAllViews();
        if ((this.f20971a instanceof View) == false) goto L9;
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-1, -1);
        addView((View) this.f20971a, r101);
    L9:
        if (this.f20972b == null) goto L12;
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-2, -2);
        addView(this.f20972b, r102);
        return;
    }

    public void setXBadgeRule(b r100) {
        if (r100 == null) goto L20;
        BadgeAnchor r101 = r100.f20976a;
        if (r101 == BadgeAnchor.LEFT) goto L20;
        if (r101 == BadgeAnchor.RIGHT) goto L20;
        if (r101 == BadgeAnchor.CONTENT_LEFT) goto L20;
        if (r101 == BadgeAnchor.CONTENT_RIGHT) goto L20;
        if (r101 == BadgeAnchor.CENTER_X) goto L20;
        if (r101 == BadgeAnchor.LEFT_EDGE_CENTER_X) goto L20;
        if (r101 == BadgeAnchor.RIGHT_EDGE_CENTER_X) goto L20;
        throw new IllegalArgumentException("x badge rule is wrong.");
    L20:
        this.f20974d = r100;
    }

    public void setYBadgeRule(b r100) {
        if (r100 == null) goto L20;
        BadgeAnchor r101 = r100.f20976a;
        if (r101 == BadgeAnchor.TOP) goto L20;
        if (r101 == BadgeAnchor.BOTTOM) goto L20;
        if (r101 == BadgeAnchor.CONTENT_TOP) goto L20;
        if (r101 == BadgeAnchor.CONTENT_BOTTOM) goto L20;
        if (r101 == BadgeAnchor.CENTER_Y) goto L20;
        if (r101 == BadgeAnchor.TOP_EDGE_CENTER_Y) goto L20;
        if (r101 == BadgeAnchor.BOTTOM_EDGE_CENTER_Y) goto L20;
        throw new IllegalArgumentException("y badge rule is wrong.");
    L20:
        this.f20975e = r100;
    }

    @Override // xuc.d
    public final void a(int r100, int r101) {
        d r102 = this.f20971a;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
    L6:
        if (this.f20973c == false) goto L9;
        setBadgeView(null);
        return;
    }

    @Override // xuc.d
    public final void b(int r100, int r101) {
        d r102 = this.f20971a;
        if (r102 == null) goto L6;
        r102.b(r100, r101);
        return;
    }

    @Override // xuc.d
    public final void c(int r100, int r101, float r102, boolean r103) {
        d r104 = this.f20971a;
        if (r104 == null) goto L6;
        r104.c(r100, r101, r102, r103);
        return;
    }

    @Override // xuc.d
    public final void d(int r100, int r101, float r102, boolean r103) {
        d r104 = this.f20971a;
        if (r104 == null) goto L6;
        r104.d(r100, r101, r102, r103);
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r110, int r111) {
        super.onLayout(r100, r101, r102, r110, r111);
        Object r103 = this.f20971a;
        if ((r103 instanceof View) == true) goto L5;
        return;
    L5:
        if (this.f20972b == null) goto L21;
        int[] r104 = new int[14];
        View r105 = (View) r103;
        r104[0] = r105.getLeft();
        r104[1] = r105.getTop();
        r104[2] = r105.getRight();
        r104[3] = r105.getBottom();
        d r106 = this.f20971a;
        if ((r106 instanceof xuc.b) == false) goto L9;
        xuc.b r107 = (xuc.b) r106;
        r104[4] = r107.getContentLeft();
        r104[5] = r107.getContentTop();
        r104[6] = r107.getContentRight();
        r104[7] = r107.getContentBottom();
    L12:
        r104[8] = r105.getWidth() / 2;
        r104[9] = r105.getHeight() / 2;
        r104[10] = r104[4] / 2;
        r104[11] = r104[5] / 2;
        int r108 = r104[6];
        r104[12] = r108 + ((r104[2] - r108) / 2);
        int r109 = r104[7];
        r104[13] = r109 + ((r104[3] - r109) / 2);
        b r112 = this.f20974d;
        if (r112 == null) goto L15;
        int r113 = r104[r112.f20976a.ordinal()] + this.f20974d.f20977b;
        View r114 = this.f20972b;
        r114.offsetLeftAndRight(r113 - r114.getLeft());
    L15:
        b r115 = this.f20975e;
        if (r115 == null) goto L22;
        int r116 = r104[r115.f20976a.ordinal()] + this.f20975e.f20977b;
        View r117 = this.f20972b;
        r117.offsetTopAndBottom(r116 - r117.getTop());
        return;
    L22:
        return;
    L9:
        int r118 = 4;
    L10:
        if (r118 >= 8) goto L12;
        r104[r118] = r104[r118 - 4];
        r118 = r118 + 1;
        goto L10
    }
}
