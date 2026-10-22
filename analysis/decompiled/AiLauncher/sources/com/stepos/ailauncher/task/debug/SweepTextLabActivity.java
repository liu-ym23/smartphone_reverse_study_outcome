package com.stepos.ailauncher.task.debug;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.widget.SweepTextView;
import com.stepos.ailauncher.task.R$string;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Arrays;
import java.util.Locale;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import p9.InterfaceC5074l;
import r9.C5227b;
import v9.C5685n;
import z5.ActivityC6361a;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 [2\u00020\u0001:\u0001\\B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\rJ3\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00060\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018JK\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00112\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00060\u0015H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010$\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b$\u0010%J3\u0010(\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00192\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00060\u0015H\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0013H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0006H\u0002¢\u0006\u0004\b-\u0010\u0003J\u0017\u0010/\u001a\u00020 2\u0006\u0010.\u001a\u00020\u0011H\u0002¢\u0006\u0004\b/\u00100J#\u00104\u001a\u0002032\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u00060\u0015H\u0002¢\u0006\u0004\b4\u00105J\u0019\u00107\u001a\u0004\u0018\u00010\u00192\u0006\u00106\u001a\u00020\u0011H\u0002¢\u0006\u0004\b7\u00108J\u0019\u00109\u001a\u0004\u0018\u00010\u00192\u0006\u00106\u001a\u00020\u0011H\u0002¢\u0006\u0004\b9\u00108J\u0017\u0010;\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\u0019H\u0002¢\u0006\u0004\b;\u0010<J+\u0010A\u001a\u00020@2\u0006\u0010:\u001a\u00020\u00112\u0006\u0010>\u001a\u00020=2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\bA\u0010BJ\u0017\u0010D\u001a\u00020\u00192\u0006\u0010C\u001a\u00020\u0019H\u0002¢\u0006\u0004\bD\u0010EJ\u0017\u0010F\u001a\u00020\u00192\u0006\u0010C\u001a\u00020=H\u0002¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u0019H\u0002¢\u0006\u0004\bH\u0010IJ\u001b\u0010L\u001a\u00020J*\u00020J2\u0006\u0010K\u001a\u00020\u0019H\u0002¢\u0006\u0004\bL\u0010MR\u0016\u0010O\u001a\u00020N8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010Q\u001a\u00020 8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010U\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010(R\u0016\u0010V\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010(R\u0016\u0010W\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010(R\u0016\u0010X\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010(R\u0016\u0010Y\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010(R\u0016\u0010Z\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010(¨\u0006]"}, d2 = {"Lcom/stepos/ailauncher/task/debug/SweepTextLabActivity;", "Lz5/a;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "onPause", "Landroid/view/View;", "K", "()Landroid/view/View;", "a0", "U", "L", "", "title", "", "checked", "Lkotlin/Function1;", "onChanged", "Y", "(Ljava/lang/String;ZLp9/l;)Landroid/view/View;", "", "min", "max", "initial", "suffix", ExifInterface.LONGITUDE_WEST, "(Ljava/lang/String;IIILjava/lang/String;Lp9/l;)Landroid/view/View;", "Landroid/widget/TextView;", "valueText", "Landroid/widget/SeekBar;", "seekBar", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Ljava/lang/String;Landroid/widget/TextView;Landroid/widget/SeekBar;)Landroid/view/View;", "initialColor", "onColorChanged", "I", "(Ljava/lang/String;ILp9/l;)Landroid/view/View;", "restart", "G", "(Z)V", "k0", "text", "f0", "(Ljava/lang/String;)Landroid/widget/TextView;", "Landroid/text/Editable;", "block", "Landroid/text/TextWatcher;", "F", "(Lp9/l;)Landroid/text/TextWatcher;", "raw", "g0", "(Ljava/lang/String;)Ljava/lang/Integer;", "h0", "color", "H", "(I)Ljava/lang/String;", "", "radiusDp", "strokeColor", "Landroid/graphics/drawable/GradientDrawable;", "i0", "(Ljava/lang/String;FLjava/lang/String;)Landroid/graphics/drawable/GradientDrawable;", UxipConstants.f30680s, "e0", "(I)I", "d0", "(F)I", "j0", "()I", "Landroid/widget/LinearLayout$LayoutParams;", "marginDp", "l0", "(Landroid/widget/LinearLayout$LayoutParams;I)Landroid/widget/LinearLayout$LayoutParams;", "Lcom/stepos/ailauncher/common/widget/SweepTextView;", "previewText", "Lcom/stepos/ailauncher/common/widget/SweepTextView;", "summaryText", "Landroid/widget/TextView;", "sweepEnabled", "Z", "previewTextSizeSp", "gradientColorA", "gradientColorB", "gradientCycleLengthDp", "gradientSpeedDpPerSecond", "gradientAngleDegrees", "Companion", Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SweepTextLabActivity extends ActivityC6361a {
    private static final Regex RGBA_REGEX = new Regex("rgba\\(\\s*(\\d{1,3})\\s*,\\s*(\\d{1,3})\\s*,\\s*(\\d{1,3})\\s*,\\s*([0-9.]+)\\s*\\)", RegexOption.IGNORE_CASE);
    private SweepTextView previewText;
    private TextView summaryText;
    private boolean sweepEnabled = true;
    private int previewTextSizeSp = 30;
    private int gradientColorA = Color.parseColor("#66FFFFFF");
    private int gradientColorB = Color.parseColor("#FFFFFFFF");
    private int gradientCycleLengthDp = 180;
    private int gradientSpeedDpPerSecond = 130;
    private int gradientAngleDegrees = 30;

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/stepos/ailauncher/task/debug/SweepTextLabActivity$b", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "LY8/t;", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements TextWatcher {
        final /* synthetic */ InterfaceC5074l<Editable, Y8.t> $block;

        /* JADX WARN: Multi-variable type inference failed */
        public b(InterfaceC5074l<? super Editable, Y8.t> interfaceC5074l) {
            this.$block = interfaceC5074l;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
            kotlin.jvm.internal.p.i(s10, "s");
            this.$block.invoke(s10);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int start, int before, int count) {
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"com/stepos/ailauncher/task/debug/SweepTextLabActivity$c", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/widget/SeekBar;", "seekBar", "", "progress", "", "fromUser", "LY8/t;", "onProgressChanged", "(Landroid/widget/SeekBar;IZ)V", "onStartTrackingTouch", "(Landroid/widget/SeekBar;)V", "onStopTrackingTouch", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements SeekBar.OnSeekBarChangeListener {
        final /* synthetic */ int $initial;
        final /* synthetic */ InterfaceC5074l<Integer, Y8.t> $onChanged;
        final /* synthetic */ String $suffix;
        final /* synthetic */ TextView $valueText;

        /* JADX WARN: Multi-variable type inference failed */
        public c(InterfaceC5074l<? super Integer, Y8.t> interfaceC5074l, TextView textView, String str, int i10) {
            this.$onChanged = interfaceC5074l;
            this.$valueText = textView;
            this.$suffix = str;
            this.$initial = i10;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            SweepTextLabActivity.X(this.$valueText, this.$suffix, progress);
            if (fromUser) {
                this.$onChanged.invoke(Integer.valueOf(progress));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            this.$onChanged.invoke(Integer.valueOf(seekBar != null ? seekBar.getProgress() : this.$initial));
        }
    }

    public static final Y8.t J(SweepTextLabActivity sweepTextLabActivity, EditText editText, View view, InterfaceC5074l interfaceC5074l, Editable it) {
        kotlin.jvm.internal.p.i(it, "it");
        Integer numG0 = sweepTextLabActivity.g0(it.toString());
        if (numG0 == null) {
            editText.setTextColor(Color.parseColor("#FFFF7A7A"));
        } else {
            editText.setTextColor(-1);
            view.setBackground(sweepTextLabActivity.i0(sweepTextLabActivity.H(numG0.intValue()), 6.0f, "#40FFFFFF"));
            interfaceC5074l.invoke(numG0);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t M(SweepTextLabActivity sweepTextLabActivity, Editable it) {
        kotlin.jvm.internal.p.i(it, "it");
        SweepTextView sweepTextView = sweepTextLabActivity.previewText;
        if (sweepTextView == null) {
            kotlin.jvm.internal.p.A("previewText");
            sweepTextView = null;
        }
        sweepTextView.setText(it.toString());
        sweepTextLabActivity.G(true);
        return Y8.t.f7040a;
    }

    public static final Y8.t N(SweepTextLabActivity sweepTextLabActivity, boolean z10) {
        sweepTextLabActivity.sweepEnabled = z10;
        sweepTextLabActivity.G(z10);
        return Y8.t.f7040a;
    }

    public static final Y8.t O(SweepTextLabActivity sweepTextLabActivity, int i10) {
        sweepTextLabActivity.previewTextSizeSp = i10;
        SweepTextView sweepTextView = sweepTextLabActivity.previewText;
        if (sweepTextView == null) {
            kotlin.jvm.internal.p.A("previewText");
            sweepTextView = null;
        }
        sweepTextView.setTextSize(2, i10);
        sweepTextLabActivity.G(true);
        return Y8.t.f7040a;
    }

    public static final Y8.t P(SweepTextLabActivity sweepTextLabActivity, int i10) {
        sweepTextLabActivity.gradientColorA = i10;
        sweepTextLabActivity.G(false);
        return Y8.t.f7040a;
    }

    public static final Y8.t Q(SweepTextLabActivity sweepTextLabActivity, int i10) {
        sweepTextLabActivity.gradientColorB = i10;
        sweepTextLabActivity.G(false);
        return Y8.t.f7040a;
    }

    public static final Y8.t R(SweepTextLabActivity sweepTextLabActivity, int i10) {
        sweepTextLabActivity.gradientCycleLengthDp = i10;
        sweepTextLabActivity.G(true);
        return Y8.t.f7040a;
    }

    public static final Y8.t S(SweepTextLabActivity sweepTextLabActivity, int i10) {
        sweepTextLabActivity.gradientSpeedDpPerSecond = i10;
        sweepTextLabActivity.G(true);
        return Y8.t.f7040a;
    }

    public static final Y8.t T(SweepTextLabActivity sweepTextLabActivity, int i10) {
        sweepTextLabActivity.gradientAngleDegrees = i10;
        sweepTextLabActivity.G(false);
        return Y8.t.f7040a;
    }

    public static final void X(TextView textView, String str, int i10) {
        textView.setText(i10 + str);
    }

    public static final void Z(InterfaceC5074l interfaceC5074l, CompoundButton compoundButton, boolean z10) {
        kotlin.jvm.internal.p.i(compoundButton, "<unused var>");
        interfaceC5074l.invoke(Boolean.valueOf(z10));
    }

    public static final void b0(SweepTextLabActivity sweepTextLabActivity, View view) {
        sweepTextLabActivity.finish();
    }

    public static final void c0(SweepTextLabActivity sweepTextLabActivity, View view) {
        SweepTextView sweepTextView = sweepTextLabActivity.previewText;
        if (sweepTextView == null) {
            kotlin.jvm.internal.p.A("previewText");
            sweepTextView = null;
        }
        SweepTextView.startSweep$default(sweepTextView, 0L, 1, null);
    }

    private final int e0(int value) {
        return (int) ((value * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final TextWatcher F(InterfaceC5074l<? super Editable, Y8.t> block) {
        return new b(block);
    }

    public final void G(boolean restart) {
        SweepTextView sweepTextView = this.previewText;
        SweepTextView sweepTextView2 = null;
        if (sweepTextView == null) {
            kotlin.jvm.internal.p.A("previewText");
            sweepTextView = null;
        }
        sweepTextView.setSweepEnabled(this.sweepEnabled);
        SweepTextView sweepTextView3 = this.previewText;
        if (sweepTextView3 == null) {
            kotlin.jvm.internal.p.A("previewText");
            sweepTextView3 = null;
        }
        sweepTextView3.setSweepAutoStart(true);
        SweepTextView sweepTextView4 = this.previewText;
        if (sweepTextView4 == null) {
            kotlin.jvm.internal.p.A("previewText");
            sweepTextView4 = null;
        }
        sweepTextView4.setSweepGradientColors(this.gradientColorA, this.gradientColorB);
        SweepTextView sweepTextView5 = this.previewText;
        if (sweepTextView5 == null) {
            kotlin.jvm.internal.p.A("previewText");
            sweepTextView5 = null;
        }
        sweepTextView5.setSweepGradientCycleLength(e0(this.gradientCycleLengthDp));
        SweepTextView sweepTextView6 = this.previewText;
        if (sweepTextView6 == null) {
            kotlin.jvm.internal.p.A("previewText");
            sweepTextView6 = null;
        }
        sweepTextView6.setSweepGradientSpeedDpPerSecond(this.gradientSpeedDpPerSecond);
        SweepTextView sweepTextView7 = this.previewText;
        if (sweepTextView7 == null) {
            kotlin.jvm.internal.p.A("previewText");
            sweepTextView7 = null;
        }
        sweepTextView7.setSweepGradientAngle(this.gradientAngleDegrees);
        boolean z10 = this.sweepEnabled;
        if (z10 && restart) {
            SweepTextView sweepTextView8 = this.previewText;
            if (sweepTextView8 == null) {
                kotlin.jvm.internal.p.A("previewText");
                sweepTextView8 = null;
            }
            SweepTextView.startSweep$default(sweepTextView8, 0L, 1, null);
        } else if (!z10) {
            SweepTextView sweepTextView9 = this.previewText;
            if (sweepTextView9 == null) {
                kotlin.jvm.internal.p.A("previewText");
            } else {
                sweepTextView2 = sweepTextView9;
            }
            sweepTextView2.stopSweep(true);
        }
        k0();
    }

    public final String H(int color) {
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format(Locale.US, "#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(color)}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        return str;
    }

    public final View I(String title, int initialColor, final InterfaceC5074l<? super Integer, Y8.t> onColorChanged) {
        final View view = new View(this);
        view.setBackground(i0(H(initialColor), 6.0f, "#40FFFFFF"));
        final EditText editText = new EditText(this);
        editText.setText(H(initialColor));
        editText.setSingleLine(true);
        editText.setTextSize(13.0f);
        editText.setTextColor(-1);
        editText.setHintTextColor(Color.parseColor("#66FFFFFF"));
        editText.setHint("#AARRGGBB / rgba(...)");
        editText.setBackground(i0("#14FFFFFF", 8.0f, "#22FFFFFF"));
        editText.setPadding(e0(10), 0, e0(10), 0);
        editText.addTextChangedListener(F(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.debug.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SweepTextLabActivity.J(this.f28408a, editText, view, onColorChanged, (Editable) obj);
            }
        }));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(0, e0(4), 0, e0(10));
        TextView textView = new TextView(linearLayout.getContext());
        textView.setText(title);
        textView.setTextSize(14.0f);
        textView.setTextColor(-1);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(0, -2, 1.0f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(e0(28), e0(28));
        layoutParams.setMarginEnd(e0(10));
        Y8.t tVar = Y8.t.f7040a;
        linearLayout.addView(view, layoutParams);
        linearLayout.addView(editText, new LinearLayout.LayoutParams(e0(178), e0(40)));
        return linearLayout;
    }

    public final View K() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(Color.parseColor("#050507"));
        linearLayout.addView(a0());
        linearLayout.addView(U());
        linearLayout.addView(L(), new LinearLayout.LayoutParams(-1, 0, 1.0f));
        return linearLayout;
    }

    public final View L() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(e0(20), e0(18), e0(20), e0(28));
        linearLayout.addView(f0("预览"));
        EditText editText = new EditText(this);
        SweepTextView sweepTextView = this.previewText;
        if (sweepTextView == null) {
            kotlin.jvm.internal.p.A("previewText");
            sweepTextView = null;
        }
        editText.setText(sweepTextView.getText());
        editText.setSingleLine(true);
        editText.setTextSize(15.0f);
        editText.setTextColor(-1);
        editText.setHintTextColor(Color.parseColor("#66FFFFFF"));
        editText.setHint("输入预览文案");
        editText.setBackground(i0("#14FFFFFF", 10.0f, "#22FFFFFF"));
        editText.setPadding(e0(12), 0, e0(12), 0);
        editText.addTextChangedListener(F(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.debug.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SweepTextLabActivity.M(this.f28407a, (Editable) obj);
            }
        }));
        linearLayout.addView(editText, l0(new LinearLayout.LayoutParams(-1, e0(46)), 14));
        linearLayout.addView(Y("启用扫光", this.sweepEnabled, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.debug.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SweepTextLabActivity.N(this.f28413a, ((Boolean) obj).booleanValue());
            }
        }));
        linearLayout.addView(W("文字大小", 16, 42, this.previewTextSizeSp, "sp", new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.debug.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SweepTextLabActivity.O(this.f28414a, ((Integer) obj).intValue());
            }
        }));
        linearLayout.addView(f0("扫光参数"));
        linearLayout.addView(I("渐变色 A", this.gradientColorA, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.debug.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SweepTextLabActivity.P(this.f28415a, ((Integer) obj).intValue());
            }
        }));
        linearLayout.addView(I("渐变色 B", this.gradientColorB, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.debug.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SweepTextLabActivity.Q(this.f28416a, ((Integer) obj).intValue());
            }
        }));
        linearLayout.addView(W("循环长度", 48, 420, this.gradientCycleLengthDp, "dp", new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.debug.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SweepTextLabActivity.R(this.f28417a, ((Integer) obj).intValue());
            }
        }));
        linearLayout.addView(W("移动速度", 12, 360, this.gradientSpeedDpPerSecond, "dp/s", new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.debug.i
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SweepTextLabActivity.S(this.f28418a, ((Integer) obj).intValue());
            }
        }));
        linearLayout.addView(W("移动角度", -75, 75, this.gradientAngleDegrees, "°", new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.debug.j
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SweepTextLabActivity.T(this.f28419a, ((Integer) obj).intValue());
            }
        }));
        linearLayout.addView(f0("参数快照"));
        TextView textView = new TextView(this);
        textView.setTextSize(12.0f);
        textView.setTextColor(Color.parseColor("#B3FFFFFF"));
        textView.setLineSpacing(e0(2), 1.0f);
        textView.setBackground(i0("#10FFFFFF", 8.0f, "#1AFFFFFF"));
        textView.setPadding(e0(12), e0(10), e0(12), e0(10));
        this.summaryText = textView;
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        ScrollView scrollView = new ScrollView(this);
        scrollView.setFillViewport(false);
        scrollView.addView(linearLayout);
        return scrollView;
    }

    public final View U() {
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setPadding(e0(20), e0(16), e0(20), e0(18));
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{Color.parseColor("#111318"), Color.parseColor("#191B25"), Color.parseColor("#0B0C10")});
        gradientDrawable.setCornerRadius(0.0f);
        frameLayout.setBackground(gradientDrawable);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, e0(178)));
        Context context = frameLayout.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        SweepTextView sweepTextView = new SweepTextView(context, null, 0, 6, null);
        sweepTextView.setText("Amoo正在理解你的问题");
        sweepTextView.setGravity(17);
        sweepTextView.setMaxLines(3);
        sweepTextView.setIncludeFontPadding(false);
        sweepTextView.setTypeface(Typeface.DEFAULT_BOLD);
        sweepTextView.setTextSize(2, this.previewTextSizeSp);
        sweepTextView.setSweepAutoStart(true);
        this.previewText = sweepTextView;
        frameLayout.addView(sweepTextView, new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    public final View V(String title, TextView valueText, SeekBar seekBar) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(0, e0(4), 0, e0(12));
        LinearLayout linearLayout2 = new LinearLayout(linearLayout.getContext());
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        TextView textView = new TextView(linearLayout2.getContext());
        textView.setText(title);
        textView.setTextSize(14.0f);
        textView.setTextColor(-1);
        linearLayout2.addView(textView, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout2.addView(valueText, new LinearLayout.LayoutParams(e0(92), -2));
        linearLayout.addView(linearLayout2);
        linearLayout.addView(seekBar, new LinearLayout.LayoutParams(-1, -2));
        return linearLayout;
    }

    public final View W(String title, int min, int max, int initial, String suffix, InterfaceC5074l<? super Integer, Y8.t> onChanged) {
        TextView textView = new TextView(this);
        textView.setTextSize(13.0f);
        textView.setTextColor(Color.parseColor("#B3FFFFFF"));
        textView.setGravity(8388613);
        SeekBar seekBar = new SeekBar(this);
        seekBar.setMin(min);
        seekBar.setMax(max);
        seekBar.setProgress(C5685n.n(initial, min, max));
        X(textView, suffix, seekBar.getProgress());
        seekBar.setOnSeekBarChangeListener(new c(onChanged, textView, suffix, initial));
        return V(title, textView, seekBar);
    }

    public final View Y(String title, boolean checked, final InterfaceC5074l<? super Boolean, Y8.t> onChanged) throws Resources.NotFoundException {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(0, e0(4), 0, e0(12));
        TextView textView = new TextView(linearLayout.getContext());
        textView.setText(title);
        textView.setTextSize(14.0f);
        textView.setTextColor(-1);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(0, -2, 1.0f));
        SwitchCompat switchCompat = new SwitchCompat(linearLayout.getContext());
        switchCompat.setChecked(checked);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.stepos.ailauncher.task.debug.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                SweepTextLabActivity.Z(onChanged, compoundButton, z10);
            }
        });
        linearLayout.addView(switchCompat);
        return linearLayout;
    }

    public final View a0() {
        int iJ0 = j0();
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(e0(12), iJ0, e0(16), 0);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, e0(58) + iJ0));
        TextView textView = new TextView(linearLayout.getContext());
        textView.setText("‹");
        textView.setTextSize(34.0f);
        textView.setGravity(17);
        textView.setTextColor(-1);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.debug.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SweepTextLabActivity.b0(this.f28420a, view);
            }
        });
        linearLayout.addView(textView, new LinearLayout.LayoutParams(e0(42), -1));
        TextView textView2 = new TextView(linearLayout.getContext());
        textView2.setText(getString(R$string.task_sweep_text_lab_title));
        textView2.setTextSize(18.0f);
        textView2.setTypeface(Typeface.DEFAULT_BOLD);
        textView2.setTextColor(-1);
        textView2.setGravity(16);
        linearLayout.addView(textView2, new LinearLayout.LayoutParams(0, -1, 1.0f));
        Button button = new Button(linearLayout.getContext());
        button.setText("重播");
        button.setTextSize(13.0f);
        button.setTextColor(-1);
        button.setBackground(i0("#1FFFFFFF", 16.0f, "#22FFFFFF"));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.debug.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SweepTextLabActivity.c0(this.f28421a, view);
            }
        });
        linearLayout.addView(button, new LinearLayout.LayoutParams(e0(72), e0(36)));
        return linearLayout;
    }

    public final int d0(float value) {
        return (int) ((value * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final TextView f0(String text) {
        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setTextSize(13.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextColor(Color.parseColor("#8FB1B7C9"));
        textView.setPadding(0, e0(16), 0, e0(8));
        return textView;
    }

    public final Integer g0(String raw) {
        Object objB;
        String string = La.H.D1(raw).toString();
        if (string.length() == 0) {
            return null;
        }
        if (La.D.V(string, "rgba", true)) {
            return h0(string);
        }
        if (!La.D.X(string, Const.STR_MART_WELL, false, 2, null)) {
            string = Const.STR_MART_WELL + string;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Integer.valueOf(Color.parseColor(string)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (Integer) (Result.g(objB) ? null : objB);
    }

    public final Integer h0(String raw) {
        Integer numW;
        int iB;
        La.m mVarJ = RGBA_REGEX.j(raw);
        if (mVarJ != null && (numW = La.C.w(mVarJ.c().get(1))) != null) {
            int iIntValue = numW.intValue();
            if (iIntValue < 0 || iIntValue >= 256) {
                numW = null;
            }
            if (numW != null) {
                int iIntValue2 = numW.intValue();
                Integer numW2 = La.C.w(mVarJ.c().get(2));
                if (numW2 != null) {
                    int iIntValue3 = numW2.intValue();
                    if (iIntValue3 < 0 || iIntValue3 >= 256) {
                        numW2 = null;
                    }
                    if (numW2 != null) {
                        int iIntValue4 = numW2.intValue();
                        Integer numW3 = La.C.w(mVarJ.c().get(3));
                        if (numW3 != null) {
                            int iIntValue5 = numW3.intValue();
                            if (iIntValue5 < 0 || iIntValue5 >= 256) {
                                numW3 = null;
                            }
                            if (numW3 != null) {
                                int iIntValue6 = numW3.intValue();
                                Float fU = La.B.u(mVarJ.c().get(4));
                                if (fU != null) {
                                    float fFloatValue = fU.floatValue();
                                    if (0.0f <= fFloatValue && fFloatValue <= 1.0f) {
                                        iB = C5227b.b(fFloatValue * 255.0f);
                                    } else if (0.0f <= fFloatValue && fFloatValue <= 255.0f) {
                                        iB = C5227b.b(fFloatValue);
                                    }
                                    return Integer.valueOf(Color.argb(iB, iIntValue2, iIntValue4, iIntValue6));
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public final GradientDrawable i0(String color, float radiusDp, String strokeColor) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(color));
        gradientDrawable.setCornerRadius(d0(radiusDp));
        if (strokeColor != null) {
            gradientDrawable.setStroke(e0(1), Color.parseColor(strokeColor));
        }
        return gradientDrawable;
    }

    public final int j0() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", UxipConstants.f30662a);
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public final void k0() {
        TextView textView = this.summaryText;
        if (textView == null) {
            return;
        }
        if (textView == null) {
            kotlin.jvm.internal.p.A("summaryText");
            textView = null;
        }
        textView.setText(La.w.n("\n            XML\n            app:sweepEnabled=\"" + this.sweepEnabled + "\"\n            app:sweepAutoStart=\"true\"\n            app:sweepGradientColorA=\"" + H(this.gradientColorA) + "\"\n            app:sweepGradientColorB=\"" + H(this.gradientColorB) + "\"\n            app:sweepGradientCycleLength=\"" + this.gradientCycleLengthDp + "dp\"\n            app:sweepGradientSpeed=\"" + this.gradientSpeedDpPerSecond + "\"\n            app:sweepGradientAngle=\"" + this.gradientAngleDegrees + "\"\n\n            Kotlin\n            setSweepGradientColors(Color.parseColor(\"" + H(this.gradientColorA) + "\"), Color.parseColor(\"" + H(this.gradientColorB) + "\"))\n            setSweepGradientCycleLength(dp(" + this.gradientCycleLengthDp + ").toFloat())\n            setSweepGradientSpeedDpPerSecond(" + this.gradientSpeedDpPerSecond + "f)\n            setSweepGradientAngle(" + this.gradientAngleDegrees + "f)\n        "));
    }

    public final LinearLayout.LayoutParams l0(LinearLayout.LayoutParams layoutParams, int i10) {
        layoutParams.bottomMargin = e0(i10);
        return layoutParams;
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        setContentView(K());
        G(true);
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onPause() {
        SweepTextView sweepTextView = this.previewText;
        if (sweepTextView == null) {
            kotlin.jvm.internal.p.A("previewText");
            sweepTextView = null;
        }
        sweepTextView.stopSweep(false);
        super.onPause();
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.sweepEnabled) {
            SweepTextView sweepTextView = this.previewText;
            if (sweepTextView == null) {
                kotlin.jvm.internal.p.A("previewText");
                sweepTextView = null;
            }
            SweepTextView.startSweep$default(sweepTextView, 0L, 1, null);
        }
    }
}
