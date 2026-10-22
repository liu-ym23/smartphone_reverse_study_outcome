package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/NumberScrollViewFlipper;", "Landroid/widget/ViewFlipper;", "", "colorString", "", "setTextColor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class NumberScrollViewFlipper extends ViewFlipper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f146214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<TextView> f146215b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f146216a;

        public a(Function0 r100) {
            this.f146216a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f146216a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public NumberScrollViewFlipper(Context r100) {
        this(r100, null);
    }

    public final void setTextColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "colorString");
        Iterator<T> r101 = this.f146215b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((TextView) r101.next()).setTextColor(ColorProtector.parseColor(r100));
        goto L4
    }

    public NumberScrollViewFlipper(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f146214a = "0";
        this.f146215b = new ArrayList();
        int r102 = 0;
    L4:
        if (r102 >= 2) goto L6;
        TextView r103 = new TextView(r100);
        r103.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        r103.setGravity(17);
        com.bytedance.android.live.core.utils.a1.j(r103, 17);
        r103.setTextSize(10.0f);
        r103.setTextAlignment(4);
        r103.setTextColor(ColorProtector.parseColor("#ffffff"));
        addView(r103);
        this.f146215b.add(r103);
        r102 = r102 + 1;
        goto L4
    }

    public final void a(String r100, boolean r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "number");
        Intrinsics.checkNotNullParameter(r102, "onAnimationEnd");
        if (Intrinsics.areEqual(r100, this.f146214a) == false) goto L7;
        r102.invoke();
        return;
    L7:
        if (Intrinsics.areEqual(r100, "1") == false) goto L12;
        Iterator r103 = ((ArrayList) this.f146215b).iterator();
    L10:
        if (r103.hasNext() == false) goto L12;
        ((TextView) r103.next()).setText("1");
    L12:
        List<TextView> r104 = this.f146215b;
        if (getDisplayedChild() != 0) goto L15;
        int r105 = 1;
    L16:
        TextView r106 = (TextView) ListProtector.get(r104, r105);
        r106.setText(r100);
        if (r101 == false) goto L19;
        setInAnimation(getContext(), R.anim.slide_in_bottom);
        setOutAnimation(getContext(), R.anim.slide_out_top);
        showNext();
        postDelayed(new a(r102), 600);
    L20:
        this.f146214a = r100;
        return;
    L19:
        setInAnimation(null);
        setOutAnimation(null);
        setDisplayedChild(((ArrayList) this.f146215b).indexOf(r106));
        r102.invoke();
        goto L20
    L15:
        r105 = 0;
        goto L16
    }
}
