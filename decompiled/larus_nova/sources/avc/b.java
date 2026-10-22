package avc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes42.dex */
public final class b extends FrameLayout implements xuc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterfaceC0238b f16398a;

    public interface a {
    }

    /* JADX INFO: renamed from: avc.b$b, reason: collision with other inner class name */
    public interface InterfaceC0238b {
        void a(int r100);

        void b();

        void onEnter();

        void onLeave();
    }

    public a getContentPositionDataProvider() {
        return null;
    }

    public void setContentPositionDataProvider(a r100) {
    }

    @Override // xuc.b
    public int getContentBottom() {
        return getBottom();
    }

    @Override // xuc.b
    public int getContentLeft() {
        return getLeft();
    }

    @Override // xuc.b
    public int getContentRight() {
        return getRight();
    }

    @Override // xuc.b
    public int getContentTop() {
        return getTop();
    }

    public InterfaceC0238b getOnPagerTitleChangeListener() {
        return this.f16398a;
    }

    public b(Context r100) {
        super(r100);
    }

    public void setContentView(int r100) {
        View r101 = LayoutInflater.from(getContext()).inflate(r100, null);
        removeAllViews();
        if (r101 == null) goto L6;
        addView(r101, new FrameLayout.LayoutParams(-1, -1));
        return;
    }

    public void setOnPagerTitleChangeListener(InterfaceC0238b r100) {
        this.f16398a = r100;
    }

    public void setContentView(View r100) {
        removeAllViews();
        if (r100 == null) goto L6;
        addView(r100, new FrameLayout.LayoutParams(-1, -1));
        return;
    }

    @Override // xuc.d
    public final void a(int r100, int r101) {
        InterfaceC0238b r102 = this.f16398a;
        if (r102 == null) goto L6;
        r102.a(r100);
        return;
    }

    @Override // xuc.d
    public final void b(int r100, int r101) {
        InterfaceC0238b r102 = this.f16398a;
        if (r102 == null) goto L6;
        r102.b();
        return;
    }

    @Override // xuc.d
    public final void c(int r100, int r101, float r102, boolean r103) {
        InterfaceC0238b r104 = this.f16398a;
        if (r104 == null) goto L6;
        r104.onEnter();
        return;
    }

    @Override // xuc.d
    public final void d(int r100, int r101, float r102, boolean r103) {
        InterfaceC0238b r104 = this.f16398a;
        if (r104 == null) goto L6;
        r104.onLeave();
        return;
    }
}
