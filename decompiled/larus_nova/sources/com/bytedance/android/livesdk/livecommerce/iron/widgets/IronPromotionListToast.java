package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/widgets/IronPromotionListToast;", "Landroid/widget/FrameLayout;", "", "", "c", "Lkotlin/Lazy;", "getToastList", "()Ljava/util/List;", "toastList", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IronPromotionListToast extends FrameLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f149130d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AnimatorSet f149131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f149132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f149133c;

    public IronPromotionListToast(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public IronPromotionListToast(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final List<String> getToastList() {
        return (List) this.f149133c.getValue();
    }

    public final void a() {
        setVisibility(8);
        getToastList().clear();
        AnimatorSet r100 = this.f149131a;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f149131a = null;
    }

    public final boolean c() {
        List<String> r100 = getToastList();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return false;
    L11:
        int r102 = CollectionsKt.getLastIndex(getToastList());
    L12:
        if (r102 < 0) goto L20;
        String r103 = this.f149132b;
        if (r103 == null) goto L19;
        if ((!Intrinsics.areEqual(r103, (String) ListProtector.get(getToastList(), r102))) == true) goto L19;
        r102 = r102 - 1;
    L19:
        String r104 = (String) ListProtector.get(getToastList(), r102);
    L21:
        getToastList().clear();
        if (r104 == null) goto L30;
        this.f149132b = r104;
        ((TextView) findViewById(R.id.tv_toast)).setText(r104);
        if (this.f149131a != null) goto L26;
        AnimatorSet r105 = new AnimatorSet();
        ObjectAnimator r106 = ObjectAnimator.ofFloat(this, "alpha", new float[]{0.0f, 1.0f}).setDuration(200);
        ObjectAnimator r107 = ObjectAnimator.ofFloat(this, "alpha", new float[]{1.0f, 1.0f}).setDuration(3000);
        ObjectAnimator r108 = ObjectAnimator.ofFloat(this, "alpha", new float[]{1.0f, 0.0f}).setDuration(200);
        r105.addListener(new e(this));
        r105.playSequentially(new Animator[]{r106, r107, r108});
        Unit r109 = Unit.INSTANCE;
        this.f149131a = r105;
    L26:
        AnimatorSet r110 = this.f149131a;
        if (r110 == null) goto L29;
        r110.start();
    L29:
        return true;
    L30:
        return false;
    L20:
        r104 = null;
        goto L21
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public final void b(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        getToastList().add(r100);
        AnimatorSet r102 = this.f149131a;
        if (r102 != null) goto L14;
    L15:
        c();
        return;
    L14:
        if (r102.isRunning() != true) goto L15;
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public IronPromotionListToast(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f149133c = LazyKt.lazy(LazyThreadSafetyMode.NONE, IronPromotionListToast$toastList$2.INSTANCE);
        th.a.c(r100, R.layout.shopping_layout_list_update_toast, this, true);
    }

    public /* synthetic */ IronPromotionListToast(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
