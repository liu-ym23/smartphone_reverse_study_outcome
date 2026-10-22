package com.obric.oui.slider;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: SeekBarCompat.kt */
/* JADX INFO: loaded from: classes4.dex */
public class SeekBarCompat extends TickMarkSeekBar {
    private int offset;
    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;

    public SeekBarCompat(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public SeekBarCompat(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ SeekBarCompat(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ SeekBar.OnSeekBarChangeListener access$getOnSeekBarChangeListener$p(SeekBarCompat r0) {
        return r0.onSeekBarChangeListener;
    }

    public static final /* synthetic */ int access$toRealValue(SeekBarCompat r0, int r1) {
        return r0.toRealValue(r1);
    }

    public SeekBarCompat(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
    }

    @Override // android.widget.ProgressBar
    public int getProgress() {
        return toRealValue(super.getProgress());
    }

    public final int getMinRealValue() {
        return toRealValue(0);
    }

    public final int getMaxRealValue() {
        return toRealValue(getMax());
    }

    public final void setMinValue(int r1) {
        this.offset = r1;
        setMax(toWrapValue(getMax()));
    }

    public final void setMaxValue(int r1) {
        setMax(toWrapValue(r1));
    }

    @Override // com.obric.oui.slider.TickMarkSeekBar, android.widget.ProgressBar
    public void setProgress(int r1) {
        super.setProgress(toWrapValue(r1));
    }

    @Override // com.obric.oui.slider.TickMarkSeekBar, android.widget.ProgressBar
    public void setProgress(int r1, boolean r2) {
        super.setProgress(toWrapValue(r1), r2);
    }

    @Override // android.widget.SeekBar
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener r3) {
        this.onSeekBarChangeListener = (SeekBar.OnSeekBarChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, SeekBar.OnSeekBarChangeListener.class, "com.obric.aiagent.plugin");
        super.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), SeekBar.OnSeekBarChangeListener.class, "com.obric.aiagent.plugin"));
    }

    private final int toRealValue(int r1) {
        return r1 + this.offset;
    }

    private final int toWrapValue(int r1) {
        return r1 - this.offset;
    }
}
