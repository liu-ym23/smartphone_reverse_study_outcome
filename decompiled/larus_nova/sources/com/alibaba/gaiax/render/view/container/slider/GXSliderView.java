package com.alibaba.gaiax.render.view.container.slider;

import android.R;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.gaiax.context.GXTemplateContext;
import com.alibaba.gaiax.render.view.GXIRootView;
import com.alibaba.gaiax.render.view.GXIViewBindData;
import com.alibaba.gaiax.template.GXColor;
import com.alibaba.gaiax.template.GXSize;
import com.alibaba.gaiax.template.GXSliderConfig;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010)\u001a\u0004\u0018\u00010\u0014J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0000H\u0002J\n\u0010-\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u00020/H\u0002J\b\u00103\u001a\u00020/H\u0002J\b\u00104\u001a\u00020/H\u0002J\u0012\u00105\u001a\u00020/2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0010\u00108\u001a\u00020/2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u000e\u00109\u001a\u00020/2\u0006\u0010:\u001a\u000201J\u0012\u0010;\u001a\u00020/2\b\u0010<\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010=\u001a\u00020/H\u0002J\b\u0010>\u001a\u00020/H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006?"}, d2 = {"Lcom/alibaba/gaiax/render/view/container/slider/GXSliderView;", "Landroid/widget/RelativeLayout;", "Lcom/alibaba/gaiax/render/view/GXIViewBindData;", "Lcom/alibaba/gaiax/render/view/GXIRootView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "INDICATOR_BOTTOM_MARGIN", "", "INDICATOR_HORIZONTAL_MARGIN", "INDICATOR_ITEM_HORIZONTAL_MARGIN", "INDICATOR_ITEM_SIZE", "TAG", "", "getTAG", "()Ljava/lang/String;", "config", "Lcom/alibaba/gaiax/template/GXSliderConfig;", "gxTemplateContext", "Lcom/alibaba/gaiax/context/GXTemplateContext;", "indicatorContainer", "Landroid/widget/LinearLayout;", "indicatorItems", "", "Landroid/view/View;", "mainHandler", "Landroid/os/Handler;", "selectedIndicatorItem", UploadTypeInf.TIMER, "Ljava/util/Timer;", "timerTask", "Ljava/util/TimerTask;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "getViewPager", "()Landroidx/viewpager/widget/ViewPager;", "setViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "getConfig", "getIndicatorItemDrawable", "Landroid/graphics/drawable/StateListDrawable;", "gxSliderView", "getTemplateContext", "indicatorChanged", "", "position", "", "initIndicator", "initView", "initViewPager", "onBindData", "data", "Lorg/json/JSONObject;", "setConfig", "setIndicatorCount", "count", "setTemplateContext", "gxContext", "startTimer", "stopTimer", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXSliderView extends RelativeLayout implements GXIViewBindData, GXIRootView {
    private final float INDICATOR_BOTTOM_MARGIN;
    private final float INDICATOR_HORIZONTAL_MARGIN;
    private final float INDICATOR_ITEM_HORIZONTAL_MARGIN;
    private final float INDICATOR_ITEM_SIZE;
    private final String TAG;
    private GXSliderConfig config;
    private GXTemplateContext gxTemplateContext;
    private LinearLayout indicatorContainer;
    private List<View> indicatorItems;
    private final Handler mainHandler;
    private View selectedIndicatorItem;
    private Timer timer;
    private TimerTask timerTask;
    private ViewPager viewPager;

    public static /* synthetic */ boolean a(GXSliderView r100, View r101, MotionEvent r102) {
        return initViewPager$lambda$0(r100, r101, r102);
    }

    private final void initIndicator() {
        LinearLayout r100 = new LinearLayout(getContext());
        r100.setOrientation(0);
        r100.setGravity(17);
        this.indicatorContainer = r100;
        RelativeLayout.LayoutParams r101 = new RelativeLayout.LayoutParams(-1, -2);
        r101.addRule(12);
        GXSize.Companion r102 = GXSize.Companion;
        r101.setMargins((int) r102.dpToPx(this.INDICATOR_HORIZONTAL_MARGIN), 0, (int) r102.dpToPx(this.INDICATOR_HORIZONTAL_MARGIN), (int) r102.dpToPx(this.INDICATOR_BOTTOM_MARGIN));
        Unit r103 = Unit.INSTANCE;
        addView(r100, r101);
    }

    private final void initViewPager() {
        ViewPager r100 = new ViewPager(getContext());
        this.viewPager = r100;
        r100.addOnPageChangeListener(new AnonymousClass1(this));
        ViewPager r101 = this.viewPager;
        if (r101 == null) goto L5;
        r101.setOnTouchListener(new a(this));
    L5:
        addView(this.viewPager, new RelativeLayout.LayoutParams(-1, -1));
    }

    private final void startTimer() {
        GXSliderConfig r100 = this.config;
        if (r100 == null) goto L10;
        long r101 = r100.getScrollTimeInterval();
        if (r101 <= 0) goto L11;
        this.timer = new PthreadTimer("/GXSliderView");
        GXSliderView$startTimer$1$1 r102 = new GXSliderView$startTimer$1$1(this);
        this.timerTask = r102;
        Timer r103 = this.timer;
        if (r103 == null) goto L12;
        r103.schedule(r102, r101, r101);
        return;
    L12:
        return;
    L11:
        return;
    }

    private final void stopTimer() {
        Timer r100 = this.timer;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        TimerTask r101 = this.timerTask;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        this.timer = null;
        this.timerTask = null;
    }

    private final void initView() {
        initViewPager();
        initIndicator();
    }

    public final GXSliderConfig getConfig() {
        return this.config;
    }

    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.alibaba.gaiax.render.view.GXIRootView
    public GXTemplateContext getTemplateContext() {
        return this.gxTemplateContext;
    }

    public final ViewPager getViewPager() {
        return this.viewPager;
    }

    public GXSliderView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.TAG = "GXSliderView";
        this.INDICATOR_HORIZONTAL_MARGIN = 10.0f;
        this.INDICATOR_BOTTOM_MARGIN = 10.0f;
        this.INDICATOR_ITEM_HORIZONTAL_MARGIN = 5.0f;
        this.INDICATOR_ITEM_SIZE = 8.0f;
        this.indicatorItems = new ArrayList();
        this.mainHandler = new Handler(Looper.getMainLooper());
        initView();
    }

    public static final /* synthetic */ GXSliderConfig access$getConfig$p(GXSliderView r100) {
        return r100.config;
    }

    public static final /* synthetic */ List access$getIndicatorItems$p(GXSliderView r100) {
        return r100.indicatorItems;
    }

    public static final /* synthetic */ Handler access$getMainHandler$p(GXSliderView r100) {
        return r100.mainHandler;
    }

    private final StateListDrawable getIndicatorItemDrawable(GXSliderView r100) {
        StateListDrawable r101 = new StateListDrawable();
        ShapeDrawable r102 = new ShapeDrawable(new OvalShape());
        ShapeDrawable r103 = new ShapeDrawable(new OvalShape());
        GXSize.Companion r104 = GXSize.Companion;
        r102.setIntrinsicWidth((int) r104.dpToPx(this.INDICATOR_ITEM_SIZE));
        r102.setIntrinsicHeight((int) r104.dpToPx(this.INDICATOR_ITEM_SIZE));
        r103.setIntrinsicWidth((int) r104.dpToPx(this.INDICATOR_ITEM_SIZE));
        r103.setIntrinsicHeight((int) r104.dpToPx(this.INDICATOR_ITEM_SIZE));
        r101.addState(new int[]{R.attr.state_selected}, r102);
        r101.addState(new int[0], r103);
        GXSliderConfig r105 = this.config;
        if (r105 == null) goto L10;
        GXColor r106 = r105.getIndicatorSelectedColor();
        if (r106 == null) goto L10;
        Paint r107 = r102.getPaint();
        if (r107 == null) goto L10;
        r107.setColor(r106.value(r100.getContext()));
    L10:
        GXSliderConfig r108 = this.config;
        if (r108 == null) goto L18;
        GXColor r109 = r108.getIndicatorUnselectedColor();
        if (r109 == null) goto L18;
        Paint r110 = r103.getPaint();
        if (r110 == null) goto L18;
        r110.setColor(r109.value(r100.getContext()));
    L18:
        return r101;
    }

    private final void indicatorChanged(int r100) {
        if (r100 >= 0) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L17;
        View r102 = (View) ListProtector.get(this.indicatorItems, r100);
        if (Intrinsics.areEqual(r102, this.selectedIndicatorItem) == true) goto L18;
        r102.setSelected(true);
        View r103 = this.selectedIndicatorItem;
        if (r103 == null) goto L15;
        r103.setSelected(false);
    L15:
        this.selectedIndicatorItem = r102;
        return;
    L18:
        return;
    L17:
        return;
    L5:
        if (r100 >= this.indicatorItems.size()) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.alibaba.gaiax.render.view.GXIViewBindData
    public void onBindData(JSONObject r100) {
        ViewPager r101 = this.viewPager;
        if (r101 == null) goto L7;
        PagerAdapter r102 = r101.getAdapter();
        if (r102 == null) goto L7;
        r102.notifyDataSetChanged();
    L7:
        GXSliderConfig r103 = this.config;
        if (r103 == null) goto L22;
        int r104 = r103.getSelectedIndex();
        ViewPager r105 = this.viewPager;
        if (r105 == null) goto L22;
        PagerAdapter r106 = r105.getAdapter();
        if (r106 == null) goto L22;
        int r107 = r106.getCount();
        if (r104 < 0) goto L17;
        if (r104 >= r107) goto L17;
        boolean r108 = true;
    L18:
        if (r108 == false) goto L22;
        ViewPager r109 = this.viewPager;
        if (r109 == null) goto L22;
        r109.setCurrentItem(r104, false);
    L17:
        r108 = false;
    L22:
        startTimer();
    }

    public final void setConfig(GXSliderConfig r100) {
        this.config = r100;
    }

    public final void setIndicatorCount(int r110) {
        this.indicatorItems.clear();
        LinearLayout r100 = this.indicatorContainer;
        if (r100 == null) goto L5;
        r100.removeAllViews();
    L5:
        GXSliderConfig r101 = this.config;
        if (r101 != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == true) goto L21;
        int r103 = 0;
    L13:
        if (r103 >= r110) goto L25;
        View r104 = new View(getContext());
        r104.setBackground(getIndicatorItemDrawable(this));
        if (r103 != 0) goto L17;
        this.selectedIndicatorItem = r104;
        r104.setSelected(true);
    L17:
        this.indicatorItems.add(r104);
        LinearLayout r105 = this.indicatorContainer;
        if (r105 == null) goto L20;
        GXSize.Companion r106 = GXSize.Companion;
        RelativeLayout.LayoutParams r107 = new RelativeLayout.LayoutParams((int) r106.dpToPx(this.INDICATOR_ITEM_SIZE), (int) r106.dpToPx(this.INDICATOR_ITEM_SIZE));
        r107.setMargins((int) r106.dpToPx(this.INDICATOR_ITEM_HORIZONTAL_MARGIN), 0, (int) r106.dpToPx(this.INDICATOR_ITEM_HORIZONTAL_MARGIN), 0);
        Unit r108 = Unit.INSTANCE;
        r105.addView(r104, r107);
    L20:
        r103 = r103 + 1;
        goto L13
    L25:
        return;
    L21:
        return;
    L8:
        if (r101.getHasIndicator() == true) goto L10;
        r102 = true;
        goto L11
    }

    @Override // com.alibaba.gaiax.render.view.GXIRootView
    public void setTemplateContext(GXTemplateContext r100) {
        this.gxTemplateContext = r100;
    }

    public final void setViewPager(ViewPager r100) {
        this.viewPager = r100;
    }

    public GXSliderView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.TAG = "GXSliderView";
        this.INDICATOR_HORIZONTAL_MARGIN = 10.0f;
        this.INDICATOR_BOTTOM_MARGIN = 10.0f;
        this.INDICATOR_ITEM_HORIZONTAL_MARGIN = 5.0f;
        this.INDICATOR_ITEM_SIZE = 8.0f;
        this.indicatorItems = new ArrayList();
        this.mainHandler = new Handler(Looper.getMainLooper());
        initView();
    }

    public static final /* synthetic */ void access$indicatorChanged(GXSliderView r100, int r101) {
        r100.indicatorChanged(r101);
    }

    private static final boolean initViewPager$lambda$0(GXSliderView r100, View r101, MotionEvent r102) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        int r103 = r102.getAction();
        if (r103 != 0) goto L5;
        r100.stopTimer();
        return false;
    L5:
        if (r103 != 1) goto L7;
        r100.startTimer();
        return false;
    L7:
        if (r103 != 2) goto L16;
        r100.stopTimer();
        return false;
    L16:
        return false;
    }
}
