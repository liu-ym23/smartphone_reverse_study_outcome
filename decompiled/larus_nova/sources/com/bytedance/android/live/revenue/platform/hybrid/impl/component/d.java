package com.bytedance.android.live.revenue.platform.hybrid.impl.component;

import android.view.View;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.card.base.BaseHybridComponent;
import com.bytedance.android.annie.container.dialog.BaseDialogFragment;
import com.bytedance.ies.web.jsbridge2.g;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class d<VIEW extends View> extends b<VIEW> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f91415d = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BaseHybridComponent f91416c;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static BaseHybridComponent a(IHybridComponent r100) {
            if ((r100 instanceof BaseHybridComponent) == false) goto L6;
            return (BaseHybridComponent) r100;
        L6:
            if ((r100 instanceof HybridCard) == false) goto L11;
            IHybridComponent r101 = ((HybridCard) r100).getMCurrentHybridComponent();
            if (r101 != null) goto L29;
        L26:
            return null;
        L29:
            return a(r101);
        L11:
            if ((r100 instanceof BaseDialogFragment) == false) goto L16;
            HybridFragment r102 = ((BaseDialogFragment) r100).f39243f;
            if (r102 == null) goto L26;
            return a(r102);
        L16:
            if ((r100 instanceof HybridDialog) == false) goto L21;
            IHybridComponent r103 = ((HybridDialog) r100).getHybridComponent();
            if (r103 == null) goto L26;
            return a(r103);
        L21:
            if ((r100 instanceof HybridFragment) == false) goto L25;
            IHybridComponent r104 = ((HybridFragment) r100).getHybridComponent();
            if (r104 == null) goto L26;
            return a(r104);
        L25:
            LocalTestManager.a(new Class[]{wy.a.class});
            goto L26
        }

        @JvmStatic
        public static d b(IHybridComponent r100) {
            Intrinsics.checkNotNullParameter(r100, "component");
            BaseHybridComponent r101 = a(r100);
            if (r101 == null) goto L13;
            IHybridComponent.HybridType r102 = r100.hybridType();
            int r103 = c.f91414a[r102.ordinal()];
            if (r103 != 1) goto L7;
            Function1 r104 = BaseHybridComponent$Companion$tryConvert$1.INSTANCE;
        L15:
            return (d) r104.invoke(r101);
        L7:
            if (r103 != 2) goto L10;
            r104 = BaseHybridComponent$Companion$tryConvert$2.INSTANCE;
            goto L15
        L10:
            throw new NoWhenBranchMatchedException();
        L13:
            return null;
        }
    }

    static {
        f91415d = new a();
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.impl.component.b, xy0.a
    public final VIEW getHybridView() {
        return (VIEW) this.f91416c.getHybridView();
    }

    public d(BaseHybridComponent r100) {
        Intrinsics.checkNotNullParameter(r100, "originalComponent");
        super(r100);
        this.f91416c = r100;
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.impl.component.b, xy0.a
    public final void updateData(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f91416c.updateData(r100);
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.impl.component.b, xy0.a
    public final void updateGlobalProps(Map<String, ? extends Object> r100) {
        this.f91416c.updateGlobalProps(r100);
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.impl.component.b, xy0.a, wy0.e
    public final void registerMethod(String r100, com.bytedance.ies.web.jsbridge2.f.b r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "methodProvider");
        this.f91416c.registerMethod(r100, r101);
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.impl.component.b, xy0.a
    public final void updateScreenMetrics(int r100, int r101) {
        this.f91416c.updateScreenMetrics(r100, r101);
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.impl.component.b, xy0.a, wy0.e
    public final void registerMethod(String r100, g<?, ?> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        this.f91416c.registerMethod(r100, r101);
    }
}
