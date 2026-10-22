package ap7;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.bytedance.ug.sdk.yz.view.CoordinateTextView;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoordinateTextView f15859a;

    public a(CoordinateTextView r100) {
        this.f15859a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        CoordinateTextView r102 = this.f15859a;
        if (r102.f272371d != null) goto L6;
        r102.f272371d = CoordinateTextView.a(r102.getParent());
    L6:
        if (this.f15859a.f272371d != null) goto L8;
        return false;
    L8:
        boolean r103 = true;
        if (r101.getAction() != 0) goto L13;
        CoordinateTextView r104 = this.f15859a;
        r104.f272370c = r101.getY();
        this.f15859a.f272371d.requestDisallowInterceptTouchEvent(true);
        return false;
    L13:
        if (this.f15859a.canScrollVertically(1) == false) goto L25;
        CoordinateTextView r105 = this.f15859a;
        ViewParent r106 = r105.f272371d;
        if (r105.f272369b != 0) goto L17;
        boolean r107 = true;
    L18:
        if (r107 == true) goto L20;
    L23:
        r106.requestDisallowInterceptTouchEvent(r103);
    L37:
        return false;
    L20:
        if (r101.getY() < this.f15859a.f272370c) goto L23;
        r103 = false;
        goto L23
    L17:
        r107 = false;
        goto L18
    L25:
        if (this.f15859a.canScrollVertically(-1) == false) goto L36;
        CoordinateTextView r108 = this.f15859a;
        ViewParent r109 = r108.f272371d;
        if (r108.f272369b != r108.f272368a) goto L29;
        boolean r110 = true;
    L30:
        if (r110 == true) goto L32;
    L35:
        r109.requestDisallowInterceptTouchEvent(r103);
        goto L37
    L32:
        if (r101.getY() > this.f15859a.f272370c) goto L35;
        r103 = false;
        goto L35
    L29:
        r110 = false;
        goto L30
    L36:
        this.f15859a.f272371d.requestDisallowInterceptTouchEvent(false);
        goto L37
    }
}
