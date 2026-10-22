package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\rB'\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/widgets/ECShopETAView;", "Landroid/widget/LinearLayout;", "Lkotlin/Pair;", "", "getETARealShowInfo", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopETAView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<Integer> f149121a;

    public static final class a {
    }

    static {
    }

    public ECShopETAView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECShopETAView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final Pair<Boolean, Boolean> getETARealShowInfo() {
        List<Integer> r100 = this.f149121a;
        boolean r101 = false;
        if (r100 == null) goto L5;
        boolean r102 = r100.contains(1);
    L6:
        Boolean r103 = Boolean.valueOf(r102);
        List<Integer> r104 = this.f149121a;
        if (r104 == null) goto L10;
        r101 = r104.contains(2);
    L10:
        return new Pair(r103, Boolean.valueOf(r101));
    L5:
        r102 = false;
        goto L6
    }

    public ECShopETAView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setLayoutParams(new LinearLayout.LayoutParams(-2, UtilityKotlinExtentionsKt.d(16)));
        setOrientation(0);
        setGravity(16);
    }

    public /* synthetic */ ECShopETAView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
