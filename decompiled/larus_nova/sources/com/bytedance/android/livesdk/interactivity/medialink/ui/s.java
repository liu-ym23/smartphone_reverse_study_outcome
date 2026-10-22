package com.bytedance.android.livesdk.interactivity.medialink.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.bytedance.android.live.core.utils.s1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class s implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f138341a;

    public static final class a extends MetricAffectingSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f138342a;

        public a(s r100) {
            this.f138342a = r100;
        }

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "paint");
            r100.setTypeface(Typeface.createFromAsset(this.f138342a.getContext().getAssets(), "fonts/clarity_mono_bold.otf"));
            r100.setFakeBoldText(false);
            r100.setTextSize(s1.f(14.0f));
        }

        @Override // android.text.style.MetricAffectingSpan
        public final void updateMeasureState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "paint");
            r100.setTypeface(Typeface.createFromAsset(this.f138342a.getContext().getAssets(), "fonts/clarity_mono_bold.otf"));
            r100.setFakeBoldText(false);
            r100.setTextSize(s1.f(14.0f));
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.t
    public final MetricAffectingSpan a() {
        return new a(this);
    }

    public final Context getContext() {
        return this.f138341a;
    }

    public s(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f138341a = r100;
    }
}
