package com.tmall.wireless.tangram.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.tmall.wireless.tangram.core.service.ServiceManager;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.eventbus.BusSupport;
import com.tmall.wireless.tangram.ext.HorizontalOverScrollBounceEffectDecoratorExt;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.structure.cell.LinearScrollCell;
import com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle;
import eg.a;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class LinearScrollView extends LinearLayout implements ITangramViewLifeCycle, HorizontalOverScrollBounceEffectDecoratorExt.OnMotionEventListener, HorizontalOverScrollBounceEffectDecoratorExt.OnOverScrollListener {
    private boolean enableOverScrollPull;
    private View indicator;
    private View indicatorContainer;
    private LinearScrollCell lSCell;
    private RecyclerView.OnScrollListener onScrollListener;
    private HorizontalOverScrollBounceEffectDecoratorExt overScrollDecorator;
    private RecyclerView recyclerView;
    private float totalDistance;
    private float totalDistanceOfIndicator;
    private int touchSlop;
    private float xDown;
    private float yDown;

    public LinearScrollView(Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ LinearScrollCell access$000(LinearScrollView r10) {
        return r10.lSCell;
    }

    public static /* synthetic */ float access$100(LinearScrollView r10) {
        return r10.totalDistance;
    }

    public static /* synthetic */ float access$200(LinearScrollView r10) {
        return r10.totalDistanceOfIndicator;
    }

    public static /* synthetic */ View access$300(LinearScrollView r10) {
        return r10.indicator;
    }

    private int computeFirstCompletelyVisibleItemPositionForScrolledX(float[] r10) {
        if (this.lSCell == null) goto L15;
        if (r10 == null) goto L15;
        if (r10.length <= 0) goto L15;
        int r11 = 0;
    L10:
        if (r11 >= r10.length) goto L15;
        if (r10[r11] > this.lSCell.currentDistance) goto L13;
        r11 = r11 + 1;
        goto L10
    L13:
        return r11;
    L15:
        return 0;
    }

    private int getScreenWidth() {
        Resources r10 = getContext().getResources();
        DisplayMetrics r11 = r10.getDisplayMetrics();
        if (r10.getConfiguration().orientation != 1) goto L6;
        return r11.widthPixels;
    L6:
        return r11.heightPixels;
    }

    private void init() {
        setGravity(1);
        setOrientation(1);
        LinearLayout.inflate(getContext(), R$layout.tangram_linearscrollview, this);
        setClickable(true);
        this.recyclerView = (RecyclerView) findViewById(R$id.tangram_linearscrollview_container);
        this.indicator = findViewById(R$id.tangram_linearscrollview_indicator);
        this.indicatorContainer = findViewById(R$id.tangram_linearscrollview_indicator_container);
        LinearLayoutManager r10 = new LinearLayoutManager(getContext());
        r10.setOrientation(0);
        r10.setRecycleChildrenOnDetach(true);
        this.recyclerView.setLayoutManager(r10);
        this.totalDistanceOfIndicator = Style.dp2px(34.0d);
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.overScrollDecorator = new HorizontalOverScrollBounceEffectDecoratorExt(new a(this));
    }

    private void setViewColor(View r10, int r11) {
        if ((r10.getBackground() instanceof GradientDrawable) == false) goto L6;
        ((GradientDrawable) r10.getBackground().mutate()).setColor(r11);
        return;
    }

    @Override // com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle
    public void cellInited(BaseCell r10) {
        if ((r10 instanceof LinearScrollCell) == false) goto L6;
        this.lSCell = (LinearScrollCell) r10;
        return;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        int r11 = r10.getAction();
        float r12 = r10.getRawX();
        float r13 = r10.getRawY();
        if (r11 != 0) goto L5;
        this.xDown = r12;
        this.yDown = r13;
    L28:
        return false;
    L5:
        if (r11 == 1) goto L25;
        if (r11 != 2) goto L9;
        int r14 = (int) (r12 - this.xDown);
        int r15 = (int) (r13 - this.yDown);
        if (Math.abs(r14) <= this.touchSlop) goto L28;
        if (Math.abs(r14) <= Math.abs(r15)) goto L28;
        if (this.recyclerView.canScrollHorizontally(-1) == true) goto L19;
        if (r14 <= 0) goto L19;
    L21:
        this.enableOverScrollPull = true;
        return true;
    L19:
        if (this.recyclerView.canScrollHorizontally(1) == true) goto L23;
        if (r14 < 0) goto L21;
    L23:
        this.enableOverScrollPull = false;
        goto L28
    L9:
        if (r11 != 3) goto L28;
    L25:
        if (this.enableOverScrollPull == false) goto L28;
        return true;
    }

    @Override // com.tmall.wireless.tangram.ext.HorizontalOverScrollBounceEffectDecoratorExt.OnMotionEventListener
    public void onMotionEvent(View r10, MotionEvent r11) {
        if (r11.getAction() != 1) goto L10;
        LinearScrollCell r12 = this.lSCell;
        if (r12 == null) goto L11;
        ServiceManager r13 = r12.serviceManager;
        if (r13 == null) goto L12;
        BusSupport r14 = (BusSupport) r13.getService(BusSupport.class);
        ArrayMap r15 = new ArrayMap();
        r15.put("spmcOffset", String.valueOf(this.lSCell.cells.size()));
        r14.post(BusSupport.obtainEvent("onMotionEvent", null, r15, null));
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.tmall.wireless.tangram.ext.HorizontalOverScrollBounceEffectDecoratorExt.OnOverScrollListener
    public void onOverScroll(View r10, float r11) {
        LinearScrollCell r12 = this.lSCell;
        if (r12 == null) goto L8;
        ServiceManager r13 = r12.serviceManager;
        if (r13 == null) goto L9;
        BusSupport r14 = (BusSupport) r13.getService(BusSupport.class);
        ArrayMap r15 = new ArrayMap();
        r15.put("offset", String.valueOf(r11));
        r14.post(BusSupport.obtainEvent("onOverScroll", null, r15, null));
        return;
    L9:
        return;
    }

    @Override // com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle
    public void postBindView(BaseCell r10) {
        LinearScrollCell r11 = this.lSCell;
        if (r11 != null) goto L5;
        return;
    L5:
        this.recyclerView.setRecycledViewPool(r11.getRecycledViewPool());
        List<BaseCell> r12 = this.lSCell.cells;
        int r13 = 0;
        if (r12 != null) goto L8;
    L24:
        float[] r14 = null;
    L25:
        this.totalDistance -= getScreenWidth();
        ViewGroup.LayoutParams r15 = this.recyclerView.getLayoutParams();
        if (Double.isNaN(this.lSCell.pageHeight) == true) goto L28;
        r15.height = (int) (this.lSCell.pageHeight + 0.5d);
    L28:
        this.recyclerView.setLayoutParams(r15);
        this.recyclerView.setAdapter(this.lSCell.adapter);
        LinearScrollCell r16 = this.lSCell;
        if (r16.hasIndicator == true) goto L31;
    L33:
        this.indicatorContainer.setVisibility(8);
    L34:
        this.overScrollDecorator.setOnOverScrollListener(this);
        this.overScrollDecorator.setOnMotionEventListener(this);
        setBackgroundColor(this.lSCell.bgColor);
        if (this.lSCell.retainScrollState == false) goto L48;
        int r17 = computeFirstCompletelyVisibleItemPositionForScrolledX(r14);
        LinearLayoutManager r18 = (LinearLayoutManager) this.recyclerView.getLayoutManager();
        if (r14 != null) goto L39;
    L42:
        r18.scrollToPositionWithOffset(r17, r13);
        return;
    L39:
        if (r14.length <= r17) goto L42;
        r13 = (int) (r14[r17] - this.lSCell.currentDistance);
        goto L42
    L48:
        return;
    L31:
        if (this.totalDistance <= 0.0f) goto L33;
        setViewColor(this.indicator, r16.indicatorColor);
        setViewColor(this.indicatorContainer, this.lSCell.defaultIndicatorColor);
        this.indicatorContainer.setVisibility(0);
        goto L34
    L8:
        if (r12.size() <= 0) goto L24;
        r14 = new float[this.lSCell.cells.size()];
        int r19 = 0;
    L11:
        if (r19 >= this.lSCell.cells.size()) goto L25;
        r14[r19] = this.totalDistance;
        BaseCell r20 = this.lSCell.cells.get(r19);
        Style r21 = r20.style;
        if (r21 == null) goto L18;
        int[] r22 = r21.margin;
        if (r22.length <= 0) goto L18;
        this.totalDistance = (this.totalDistance + r22[1]) + r22[3];
    L18:
        if (Double.isNaN(this.lSCell.pageWidth) == true) goto L23;
        if (Double.isNaN(r20.extras.optDouble(LinearScrollCell.KEY_PAGE_WIDTH)) == true) goto L22;
        this.totalDistance += Style.dp2px(r20.extras.optDouble(LinearScrollCell.KEY_PAGE_WIDTH));
        goto L23
    L22:
        this.totalDistance = (float) (((double) this.totalDistance) + this.lSCell.pageWidth);
    L23:
        r19 = r19 + 1;
        goto L11
    }

    @Override // com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle
    public void postUnBindView(BaseCell r10) {
        LinearScrollCell r11 = this.lSCell;
        if (r11 != null) goto L5;
        return;
    L5:
        this.totalDistance = 0.0f;
        this.totalDistanceOfIndicator = 0.0f;
        if (r11.hasIndicator == false) goto L8;
        this.indicator.setTranslationX(0.0f);
    L8:
        this.overScrollDecorator.setOnOverScrollListener(null);
        this.overScrollDecorator.setOnMotionEventListener(null);
        this.recyclerView.setAdapter(null);
        this.lSCell = null;
    }

    public LinearScrollView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public LinearScrollView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.totalDistanceOfIndicator = 0.0f;
        this.totalDistance = 0.0f;
        this.onScrollListener = new AnonymousClass1(this);
        init();
    }
}
