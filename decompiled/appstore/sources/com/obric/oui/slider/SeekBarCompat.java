package com.obric.oui.slider;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.SeekBar;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\u000bJ\r\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000bJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0015\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u0006*\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u0006*\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/obric/oui/slider/SeekBarCompat;", "Lcom/obric/oui/slider/TickMarkSeekBar;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getProgress", "()I", "getMinRealValue", "getMaxRealValue", "minValue", "", "setMinValue", "(I)V", "maxValue", "setMaxValue", "progress", "setProgress", "", "animate", "(IZ)V", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "l", "setOnSeekBarChangeListener", "(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V", "U", "(I)I", "V", "f0", "I", "offset", "g0", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onSeekBarChangeListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class SeekBarCompat extends TickMarkSeekBar {

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f16956f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public SeekBar.OnSeekBarChangeListener f16957g0;

    public static final class a implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SeekBarCompat f16958a;

        public a(SeekBarCompat r10) {
            this.f16958a = r10;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar r10, int r11, boolean r12) {
            Log.i("SeekBarCompat", String.valueOf(r11));
            SeekBar.OnSeekBarChangeListener r13 = SeekBarCompat.S(this.f16958a);
            if (r13 == null) goto L7;
            r13.onProgressChanged(r10, SeekBarCompat.T(this.f16958a, r11), r12);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar r10) {
            SeekBar.OnSeekBarChangeListener r11 = SeekBarCompat.S(this.f16958a);
            if (r11 == null) goto L7;
            r11.onStartTrackingTouch(r10);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar r10) {
            SeekBar.OnSeekBarChangeListener r11 = SeekBarCompat.S(this.f16958a);
            if (r11 == null) goto L7;
            r11.onStopTrackingTouch(r10);
            return;
        }
    }

    @JvmOverloads
    public SeekBarCompat(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static final /* synthetic */ SeekBar.OnSeekBarChangeListener S(SeekBarCompat r10) {
        return r10.f16957g0;
    }

    public static final /* synthetic */ int T(SeekBarCompat r10, int r11) {
        return r10.U(r11);
    }

    public final int U(int r10) {
        return r10 + this.f16956f0;
    }

    public final int V(int r10) {
        return r10 - this.f16956f0;
    }

    public final int getMaxRealValue() {
        return U(getMax());
    }

    public final int getMinRealValue() {
        return U(0);
    }

    @Override // android.widget.ProgressBar
    public int getProgress() {
        return U(super.getProgress());
    }

    public final void setMaxValue(int r10) {
        setMax(V(r10));
    }

    public final void setMinValue(int r10) {
        this.f16956f0 = r10;
        setMax(V(getMax()));
    }

    @Override // android.widget.SeekBar
    public void setOnSeekBarChangeListener(@Nullable SeekBar.OnSeekBarChangeListener r10) {
        this.f16957g0 = r10;
        super.setOnSeekBarChangeListener(new a(this));
    }

    @Override // com.obric.oui.slider.TickMarkSeekBar, android.widget.ProgressBar
    public void setProgress(int r10) {
        super.setProgress(V(r10));
    }

    @JvmOverloads
    public SeekBarCompat(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    @Override // com.obric.oui.slider.TickMarkSeekBar, android.widget.ProgressBar
    public void setProgress(int r10, boolean r11) {
        super.setProgress(V(r10), r11);
    }

    public /* synthetic */ SeekBarCompat(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public SeekBarCompat(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
    }
}
