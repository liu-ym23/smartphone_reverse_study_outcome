package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.deepfeed.slice.DeepFeedSlcCardContainer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class DeepFeedChainAction extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, ? extends Object> f173386d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007R\u001c\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/slice/action/DeepFeedChainAction$MergedAction;", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "originAction", "params", "", "", "", "(Lcom/bytedance/android/ecom/arch/slice/action/IAction;Ljava/util/Map;)V", SlcCommonAction.KEY_ACTIONS, "", "getActions", "()Ljava/util/List;", "disable", "", "getDisable", "()Z", "exposureThreshold", "", "getExposureThreshold", "()F", "getParams", "()Ljava/util/Map;", "scrollCallbackThreshold", "", "getScrollCallbackThreshold", "()J", "type", "getType", "()Ljava/lang/String;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class MergedAction implements IAction {
        private final List<IAction> actions;
        private final boolean disable;
        private final float exposureThreshold;
        private final IAction originAction;
        private final Map<String, Object> params;
        private final long scrollCallbackThreshold;
        private final String type;

        @Override // com.bytedance.android.ecom.arch.slice.action.IAction
        public List<IAction> getActions() {
            return this.actions;
        }

        @Override // com.bytedance.android.ecom.arch.slice.action.IAction
        public boolean getDisable() {
            return this.disable;
        }

        @Override // com.bytedance.android.ecom.arch.slice.action.IAction
        public float getExposureThreshold() {
            return this.exposureThreshold;
        }

        @Override // com.bytedance.android.ecom.arch.slice.action.IAction
        public Map<String, Object> getParams() {
            return this.params;
        }

        @Override // com.bytedance.android.ecom.arch.slice.action.IAction
        public long getScrollCallbackThreshold() {
            return this.scrollCallbackThreshold;
        }

        @Override // com.bytedance.android.ecom.arch.slice.action.IAction
        public String getType() {
            return this.type;
        }

        public MergedAction(IAction r100, Map<String, ? extends Object> r101) {
            Intrinsics.checkNotNullParameter(r100, "originAction");
            Intrinsics.checkNotNullParameter(r101, "params");
            this.originAction = r100;
            this.params = r101;
            this.type = r100.getType();
            this.disable = r100.getDisable();
            this.exposureThreshold = r100.getExposureThreshold();
            this.scrollCallbackThreshold = r100.getScrollCallbackThreshold();
            this.actions = r100.getActions();
        }
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.a
    public final boolean d(IAction r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "targetView");
        return false;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.a, com.bytedance.android.shopping.deepfeed.slice.action.v
    public final void b(Map r100) {
        this.f173386d = r100;
    }

    public DeepFeedChainAction(DeepFeedSlcCardContainer r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "name");
        super(r100);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.a, com.bytedance.android.shopping.deepfeed.slice.action.v
    public final boolean m(IAction r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "targetView");
        Map<String, ? extends Object> r102 = this.f173386d;
        if (r102 != null) goto L5;
    L10:
        v r103 = this.f173396a;
        if (r103 != null) goto L15;
        return false;
    L15:
        return r103.m(r100, r101);
    L5:
        if ((!r102.isEmpty()) == false) goto L10;
        LinkedHashMap r104 = new LinkedHashMap();
        Map<String, Object> r105 = r100.getParams();
        if (r105 == null) goto L9;
        r104.putAll(r105);
    L9:
        r104.putAll(r102);
        r100 = new MergedAction(r100, r104);
        goto L10
    }
}
