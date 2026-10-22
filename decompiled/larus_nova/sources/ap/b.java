package ap;

import android.view.View;
import com.bytedance.android.ec.window.base.product.widget.ECWindowTagFlowLayout;
import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECWindowTagFlowLayout f15824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f15825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f15826c;

    public b(ECWindowTagFlowLayout r100, e r101, int r102) {
        this.f15824a = r100;
        this.f15825b = r101;
        this.f15826c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ECWindowTagFlowLayout r101 = this.f15824a;
        e r102 = this.f15825b;
        int r103 = this.f15826c;
        int r104 = ECWindowTagFlowLayout.f49428m;
        r101.getClass();
        if (r102.f15833a == false) goto L5;
        r102.setChecked(false);
        if (r101.f49434f == null) goto L31;
        r102.getTagView();
    L31:
        Set<Integer> r105 = r101.f49435g;
        HashSet r106 = (HashSet) r105;
        r106.remove(Integer.valueOf(r103));
    L32:
        ECWindowTagFlowLayout.b r107 = this.f15824a.f49436h;
        if (r107 == null) goto L36;
        Intrinsics.checkNotNull(r107);
        r107.a(this.f15825b, this.f15824a);
        return;
    L36:
        return;
    L5:
        if (r101.f49433e != 1) goto L20;
        if (((HashSet) r101.f49435g).size() != 1) goto L20;
        int r108 = ((Number) ((HashSet) r101.f49435g).iterator().next()).intValue();
        View r109 = r101.getChildAt(r108);
        if (r109 == null) goto L18;
        e r110 = (e) r109;
        r110.setChecked(false);
        if (r101.f49434f == null) goto L13;
        r110.getTagView();
    L13:
        r102.setChecked(true);
        if (r101.f49434f == null) goto L16;
        r102.getTagView();
    L16:
        Set<Integer> r111 = r101.f49435g;
        HashSet r112 = (HashSet) r111;
        r112.remove(Integer.valueOf(r108));
        Set<Integer> r113 = r101.f49435g;
        HashSet r114 = (HashSet) r113;
        r114.add(Integer.valueOf(r103));
        goto L32
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.window.base.product.widget.WindowTagView");
    L20:
        if (r101.f49433e > 0) goto L22;
    L24:
        r102.setChecked(true);
        if (r101.f49434f == null) goto L27;
        r102.getTagView();
    L27:
        Set<Integer> r115 = r101.f49435g;
        HashSet r116 = (HashSet) r115;
        r116.add(Integer.valueOf(r103));
        goto L32
    L22:
        if (((HashSet) r101.f49435g).size() < r101.f49433e) goto L24;
        goto L24
    }
}
