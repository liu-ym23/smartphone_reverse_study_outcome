package com.bytedance.android.livehostapi.business.shareinter;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001:\u0001#B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\r\u0010\u0018\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u0003J\b\u0010\u001b\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u001c\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u001d\u001a\u00020\tJ\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011J\b\u0010\u001f\u001a\u0004\u0018\u00010\u0013J\u0006\u0010 \u001a\u00020\u0006J\u0006\u0010!\u001a\u00020\tJ\u0006\u0010\"\u001a\u00020\tJ\u0006\u0010\u000f\u001a\u00020\tJ\u0006\u0010\u0014\u001a\u00020\tR\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/android/livehostapi/business/shareinter/LiveIMSharePostscriptConfig;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "backgroundColor", "", "Ljava/lang/Integer;", "enableBigFontMode", "", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "listener", "Lcom/bytedance/android/livehostapi/business/shareinter/ILiveIMSharePostscriptListener;", "needIntercept", "onlyLightMode", "parent", "Landroid/view/ViewGroup;", "sharePackageGenerator", "Lcom/bytedance/android/livehostapi/business/depend/share/ShareParams;", "showVideoCover", "supportCreateGroup", "supportPostscript", "twoLinePanelSecondHeight", "getBackgroundColor", "()Ljava/lang/Integer;", "getContext", "getFragment", "getListener", "getNeedIntercept", "getParent", "getSharePackage", "getTwoLinePanelSecondHeight", "isSupportCreateGroup", "isSupportPostscript", "Builder", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveIMSharePostscriptConfig {
    private Integer backgroundColor;
    private final Activity context;
    private boolean enableBigFontMode;
    private Fragment fragment;
    private ILiveIMSharePostscriptListener listener;
    private boolean needIntercept;
    private boolean onlyLightMode;
    private ViewGroup parent;
    private ShareParams sharePackageGenerator;
    private boolean showVideoCover;
    private boolean supportCreateGroup;
    private boolean supportPostscript;
    private int twoLinePanelSecondHeight;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\u001b\u001a\u00020\u001c2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\tJ\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010 \u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010\u0013R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/android/livehostapi/business/shareinter/LiveIMSharePostscriptConfig$Builder;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "backgroundColor", "", "Ljava/lang/Integer;", "enableBigFontMode", "", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "listener", "Lcom/bytedance/android/livehostapi/business/shareinter/ILiveIMSharePostscriptListener;", "needIntercept", "onlyLightMode", "parent", "Landroid/view/ViewGroup;", "sharePackageGenerator", "Lcom/bytedance/android/livehostapi/business/depend/share/ShareParams;", "showVideoCover", "supportCreateGroup", "supportPostscript", "twoLinePanelSecondHeight", "build", "Lcom/bytedance/android/livehostapi/business/shareinter/LiveIMSharePostscriptConfig;", "setEnableBigFontMode", "setFragment", "", "setOnlyLightMode", "setParent", "setPostscriptListener", "setSharePackage", "sharePackage", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Builder {
        private Integer backgroundColor;
        private final Activity context;
        private boolean enableBigFontMode;
        private Fragment fragment;
        private ILiveIMSharePostscriptListener listener;
        private boolean needIntercept;
        private boolean onlyLightMode;
        private ViewGroup parent;
        private ShareParams sharePackageGenerator;
        private boolean showVideoCover;
        private boolean supportCreateGroup;
        private boolean supportPostscript;
        private int twoLinePanelSecondHeight;

        public final LiveIMSharePostscriptConfig build() {
            LiveIMSharePostscriptConfig r100 = new LiveIMSharePostscriptConfig(this.context, null);
            LiveIMSharePostscriptConfig.access$setParent$p(r100, this.parent);
            LiveIMSharePostscriptConfig.access$setFragment$p(r100, this.fragment);
            LiveIMSharePostscriptConfig.access$setSharePackageGenerator$p(r100, this.sharePackageGenerator);
            LiveIMSharePostscriptConfig.access$setSupportPostscript$p(r100, this.supportPostscript);
            LiveIMSharePostscriptConfig.access$setSupportCreateGroup$p(r100, this.supportCreateGroup);
            LiveIMSharePostscriptConfig.access$setShowVideoCover$p(r100, this.showVideoCover);
            LiveIMSharePostscriptConfig.access$setEnableBigFontMode$p(r100, this.enableBigFontMode);
            LiveIMSharePostscriptConfig.access$setOnlyLightMode$p(r100, this.onlyLightMode);
            LiveIMSharePostscriptConfig.access$setListener$p(r100, this.listener);
            LiveIMSharePostscriptConfig.access$setNeedIntercept$p(r100, this.needIntercept);
            LiveIMSharePostscriptConfig.access$setTwoLinePanelSecondHeight$p(r100, this.twoLinePanelSecondHeight);
            LiveIMSharePostscriptConfig.access$setBackgroundColor$p(r100, this.backgroundColor);
            return r100;
        }

        public Builder(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.context = r100;
            this.supportPostscript = true;
            this.supportCreateGroup = true;
            this.showVideoCover = true;
            this.enableBigFontMode = true;
            this.twoLinePanelSecondHeight = -1;
        }

        public final Builder setEnableBigFontMode(boolean r100) {
            this.enableBigFontMode = r100;
            return this;
        }

        public final void setFragment(Fragment r100) {
            this.fragment = r100;
        }

        public final Builder setOnlyLightMode(boolean r100) {
            this.onlyLightMode = r100;
            return this;
        }

        public final Builder setParent(ViewGroup r100) {
            this.parent = r100;
            return this;
        }

        public final Builder setPostscriptListener(ILiveIMSharePostscriptListener r100) {
            this.listener = r100;
            return this;
        }

        public final Builder setSharePackage(ShareParams r100) {
            this.sharePackageGenerator = r100;
            return this;
        }
    }

    public final boolean enableBigFontMode() {
        return this.enableBigFontMode;
    }

    public final Integer getBackgroundColor() {
        return this.backgroundColor;
    }

    public final Activity getContext() {
        return this.context;
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    public final ILiveIMSharePostscriptListener getListener() {
        return this.listener;
    }

    public final boolean getNeedIntercept() {
        return this.needIntercept;
    }

    public final ViewGroup getParent() {
        return this.parent;
    }

    public final ShareParams getSharePackage() {
        return this.sharePackageGenerator;
    }

    public final int getTwoLinePanelSecondHeight() {
        return this.twoLinePanelSecondHeight;
    }

    public final boolean isSupportCreateGroup() {
        return this.supportCreateGroup;
    }

    public final boolean isSupportPostscript() {
        return this.supportPostscript;
    }

    public final boolean onlyLightMode() {
        return this.onlyLightMode;
    }

    public final boolean showVideoCover() {
        return this.showVideoCover;
    }

    private LiveIMSharePostscriptConfig(Activity r100) {
        this.context = r100;
        this.supportPostscript = true;
        this.supportCreateGroup = true;
        this.showVideoCover = true;
        this.enableBigFontMode = true;
        this.twoLinePanelSecondHeight = -1;
    }

    public static final /* synthetic */ Integer access$getBackgroundColor$p(LiveIMSharePostscriptConfig r100) {
        return r100.backgroundColor;
    }

    public static final /* synthetic */ boolean access$getEnableBigFontMode$p(LiveIMSharePostscriptConfig r100) {
        return r100.enableBigFontMode;
    }

    public static final /* synthetic */ Fragment access$getFragment$p(LiveIMSharePostscriptConfig r100) {
        return r100.fragment;
    }

    public static final /* synthetic */ ILiveIMSharePostscriptListener access$getListener$p(LiveIMSharePostscriptConfig r100) {
        return r100.listener;
    }

    public static final /* synthetic */ boolean access$getNeedIntercept$p(LiveIMSharePostscriptConfig r100) {
        return r100.needIntercept;
    }

    public static final /* synthetic */ boolean access$getOnlyLightMode$p(LiveIMSharePostscriptConfig r100) {
        return r100.onlyLightMode;
    }

    public static final /* synthetic */ ViewGroup access$getParent$p(LiveIMSharePostscriptConfig r100) {
        return r100.parent;
    }

    public static final /* synthetic */ ShareParams access$getSharePackageGenerator$p(LiveIMSharePostscriptConfig r100) {
        return r100.sharePackageGenerator;
    }

    public static final /* synthetic */ boolean access$getShowVideoCover$p(LiveIMSharePostscriptConfig r100) {
        return r100.showVideoCover;
    }

    public static final /* synthetic */ boolean access$getSupportCreateGroup$p(LiveIMSharePostscriptConfig r100) {
        return r100.supportCreateGroup;
    }

    public static final /* synthetic */ boolean access$getSupportPostscript$p(LiveIMSharePostscriptConfig r100) {
        return r100.supportPostscript;
    }

    public static final /* synthetic */ int access$getTwoLinePanelSecondHeight$p(LiveIMSharePostscriptConfig r100) {
        return r100.twoLinePanelSecondHeight;
    }

    public /* synthetic */ LiveIMSharePostscriptConfig(Activity r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    public static final /* synthetic */ void access$setBackgroundColor$p(LiveIMSharePostscriptConfig r100, Integer r101) {
        r100.backgroundColor = r101;
    }

    public static final /* synthetic */ void access$setEnableBigFontMode$p(LiveIMSharePostscriptConfig r100, boolean r101) {
        r100.enableBigFontMode = r101;
    }

    public static final /* synthetic */ void access$setFragment$p(LiveIMSharePostscriptConfig r100, Fragment r101) {
        r100.fragment = r101;
    }

    public static final /* synthetic */ void access$setListener$p(LiveIMSharePostscriptConfig r100, ILiveIMSharePostscriptListener r101) {
        r100.listener = r101;
    }

    public static final /* synthetic */ void access$setNeedIntercept$p(LiveIMSharePostscriptConfig r100, boolean r101) {
        r100.needIntercept = r101;
    }

    public static final /* synthetic */ void access$setOnlyLightMode$p(LiveIMSharePostscriptConfig r100, boolean r101) {
        r100.onlyLightMode = r101;
    }

    public static final /* synthetic */ void access$setParent$p(LiveIMSharePostscriptConfig r100, ViewGroup r101) {
        r100.parent = r101;
    }

    public static final /* synthetic */ void access$setSharePackageGenerator$p(LiveIMSharePostscriptConfig r100, ShareParams r101) {
        r100.sharePackageGenerator = r101;
    }

    public static final /* synthetic */ void access$setShowVideoCover$p(LiveIMSharePostscriptConfig r100, boolean r101) {
        r100.showVideoCover = r101;
    }

    public static final /* synthetic */ void access$setSupportCreateGroup$p(LiveIMSharePostscriptConfig r100, boolean r101) {
        r100.supportCreateGroup = r101;
    }

    public static final /* synthetic */ void access$setSupportPostscript$p(LiveIMSharePostscriptConfig r100, boolean r101) {
        r100.supportPostscript = r101;
    }

    public static final /* synthetic */ void access$setTwoLinePanelSecondHeight$p(LiveIMSharePostscriptConfig r100, int r101) {
        r100.twoLinePanelSecondHeight = r101;
    }
}
