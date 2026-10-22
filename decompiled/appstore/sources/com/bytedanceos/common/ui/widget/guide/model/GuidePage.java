package com.bytedanceos.common.ui.widget.guide.model;

import android.graphics.MaskFilter;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Animation;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import com.bytedanceos.common.ui.widget.guide.listener.OnHighlightDrewListener;
import com.bytedanceos.common.ui.widget.guide.listener.OnLayoutInflatedListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GuidePage {
    private int backgroundColor;
    private int[] clickToDismissIds;
    private Animation enterAnimation;
    private boolean everywhereCancelable;
    private Animation exitAnimation;
    private List<HighLight> highLights;
    private int layoutResId;
    private MaskFilter maskFilter;
    private OnHighlightDrewListener onHighlightDrewListener;
    private OnLayoutInflatedListener onLayoutInflatedListener;

    public GuidePage() {
        this.highLights = new ArrayList();
        this.everywhereCancelable = true;
    }

    public static GuidePage newInstance() {
        return new GuidePage();
    }

    public GuidePage addHighLight(View r10) {
        return addHighLight(r10, HighLight.Shape.RECTANGLE, 0, 0, null);
    }

    public GuidePage addHighLightWithOptions(View r10, HighlightOptions r11) {
        return addHighLightWithOptions(r10, HighLight.Shape.RECTANGLE, 0, 0, r11);
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public int[] getClickToDismissIds() {
        return this.clickToDismissIds;
    }

    public Animation getEnterAnimation() {
        return this.enterAnimation;
    }

    public Animation getExitAnimation() {
        return this.exitAnimation;
    }

    public List<HighLight> getHighLights() {
        return this.highLights;
    }

    public int getLayoutResId() {
        return this.layoutResId;
    }

    public MaskFilter getMaskFilter() {
        return this.maskFilter;
    }

    public OnLayoutInflatedListener getOnLayoutInflatedListener() {
        return this.onLayoutInflatedListener;
    }

    public List<RelativeGuide> getRelativeGuides() {
        ArrayList r10 = new ArrayList();
        Iterator<HighLight> r11 = this.highLights.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        HighlightOptions r12 = r11.next().getOptions();
        if (r12 == null) goto L4;
        RelativeGuide r13 = r12.relativeGuide;
        if (r13 == null) goto L4;
        r10.add(r13);
        goto L4
    L10:
        return r10;
    }

    public boolean isEmpty() {
        if (this.layoutResId == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.highLights.size() != 0) goto L7;
        return true;
    }

    public boolean isEverywhereCancelable() {
        return this.everywhereCancelable;
    }

    public GuidePage setBackgroundColor(int r10) {
        this.backgroundColor = r10;
        return this;
    }

    public GuidePage setEnterAnimation(Animation r10) {
        this.enterAnimation = r10;
        return this;
    }

    public GuidePage setEverywhereCancelable(boolean r10) {
        this.everywhereCancelable = r10;
        return this;
    }

    public GuidePage setExitAnimation(Animation r10) {
        this.exitAnimation = r10;
        return this;
    }

    public GuidePage setLayoutRes(@LayoutRes int r10, int... r11) {
        this.layoutResId = r10;
        this.clickToDismissIds = r11;
        return this;
    }

    public void setMaskFilter(MaskFilter r10) {
        this.maskFilter = r10;
    }

    public GuidePage setOnLayoutInflatedListener(OnLayoutInflatedListener r10) {
        this.onLayoutInflatedListener = r10;
        return this;
    }

    public GuidePage addHighLight(View r10, RelativeGuide r11) {
        return addHighLight(r10, HighLight.Shape.RECTANGLE, 0, 0, r11);
    }

    public GuidePage addHighLightWithOptions(View r10, HighLight.Shape r11, HighlightOptions r12) {
        return addHighLightWithOptions(r10, r11, 0, 0, r12);
    }

    public GuidePage addHighLight(View r10, HighLight.Shape r11) {
        return addHighLight(r10, r11, 0, 0, null);
    }

    public GuidePage addHighLightWithOptions(View r10, HighLight.Shape r11, int r12, int r13, HighlightOptions r14) {
        HighlightView r15 = new HighlightView(r10, r11, r12, r13);
        if (r14 == null) goto L7;
        RelativeGuide r16 = r14.relativeGuide;
        if (r16 == null) goto L7;
        r16.highLight = r15;
    L7:
        r15.setOptions(r14);
        this.highLights.add(r15);
        return this;
    }

    public GuidePage addHighLight(View r10, HighLight.Shape r11, RelativeGuide r12) {
        return addHighLight(r10, r11, 0, 0, r12);
    }

    public GuidePage addHighLight(View r10, HighLight.Shape r11, int r12) {
        return addHighLight(r10, r11, 0, r12, null);
    }

    public GuidePage addHighLight(View r10, HighLight.Shape r11, int r12, RelativeGuide r13) {
        return addHighLight(r10, r11, 0, r12, r13);
    }

    public GuidePage addHighLight(View r10, HighLight.Shape r11, int r12, int r13, @Nullable RelativeGuide r14) {
        HighlightView r15 = new HighlightView(r10, r11, r12, r13);
        if (r14 == null) goto L5;
        r14.highLight = r15;
        r15.setOptions(new HighlightOptions.Builder().setRelativeGuide(r14).build());
    L5:
        this.highLights.add(r15);
        return this;
    }

    public GuidePage addHighLightWithOptions(RectF r10, HighlightOptions r11) {
        return addHighLightWithOptions(r10, HighLight.Shape.RECTANGLE, 0, r11);
    }

    public GuidePage addHighLightWithOptions(RectF r10, HighLight.Shape r11, HighlightOptions r12) {
        return addHighLightWithOptions(r10, r11, 0, r12);
    }

    public GuidePage addHighLightWithOptions(RectF r10, HighLight.Shape r11, int r12, HighlightOptions r13) {
        HighlightRectF r14 = new HighlightRectF(r10, r11, r12);
        if (r13 == null) goto L7;
        RelativeGuide r15 = r13.relativeGuide;
        if (r15 == null) goto L7;
        r15.highLight = r14;
    L7:
        r14.setOptions(r13);
        this.highLights.add(r14);
        return this;
    }

    public GuidePage addHighLight(RectF r10) {
        return addHighLight(r10, HighLight.Shape.RECTANGLE, 0, null);
    }

    public GuidePage addHighLight(RectF r10, RelativeGuide r11) {
        return addHighLight(r10, HighLight.Shape.RECTANGLE, 0, r11);
    }

    public GuidePage addHighLight(RectF r10, HighLight.Shape r11) {
        return addHighLight(r10, r11, 0, null);
    }

    public GuidePage addHighLight(RectF r10, HighLight.Shape r11, RelativeGuide r12) {
        return addHighLight(r10, r11, 0, r12);
    }

    public GuidePage addHighLight(RectF r10, HighLight.Shape r11, int r12) {
        return addHighLight(r10, r11, r12, null);
    }

    public GuidePage addHighLight(RectF r10, HighLight.Shape r11, int r12, RelativeGuide r13) {
        HighlightRectF r14 = new HighlightRectF(r10, r11, r12);
        if (r13 == null) goto L5;
        r13.highLight = r14;
        r14.setOptions(new HighlightOptions.Builder().setRelativeGuide(r13).build());
    L5:
        this.highLights.add(r14);
        return this;
    }
}
