package ck0;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.bytedance.android.live.core.utils.s1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f24017a;

    /* JADX INFO: renamed from: ck0.a$a, reason: collision with other inner class name */
    public static final class C0453a extends MetricAffectingSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f24018a;

        public C0453a(a r100) {
            this.f24018a = r100;
        }

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "paint");
            r100.setTypeface(Typeface.createFromAsset(this.f24018a.getContext().getAssets(), "fonts/clarity_mono_bold.otf"));
            r100.setFakeBoldText(false);
            r100.setTextSize(s1.I(14.0f));
        }

        @Override // android.text.style.MetricAffectingSpan
        public final void updateMeasureState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "paint");
            r100.setTypeface(Typeface.createFromAsset(this.f24018a.getContext().getAssets(), "fonts/clarity_mono_bold.otf"));
            r100.setFakeBoldText(false);
            r100.setTextSize(s1.I(14.0f));
        }
    }

    @Override // ck0.b
    public final MetricAffectingSpan a() {
        return new C0453a(this);
    }

    public final Context getContext() {
        return this.f24017a;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f24017a = r100;
    }
}
