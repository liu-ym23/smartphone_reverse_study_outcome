package p1;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import com.google.android.material.textfield.TextInputLayout;
import com.stepos.stepclaw.SecurePrefs;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f4704a;

    /* renamed from: b, reason: collision with root package name */
    public final TextPaint f4705b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4706c;
    public int d;

    /* renamed from: k, reason: collision with root package name */
    public boolean f4713k;

    /* renamed from: m, reason: collision with root package name */
    public j1.a f4715m;

    /* renamed from: e, reason: collision with root package name */
    public Layout.Alignment f4707e = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: f, reason: collision with root package name */
    public int f4708f = Integer.MAX_VALUE;

    /* renamed from: g, reason: collision with root package name */
    public float f4709g = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    public float f4710h = 1.0f;

    /* renamed from: i, reason: collision with root package name */
    public int f4711i = 1;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4712j = true;

    /* renamed from: l, reason: collision with root package name */
    public TextUtils.TruncateAt f4714l = null;

    public g(CharSequence charSequence, TextPaint textPaint, int i8) {
        this.f4704a = charSequence;
        this.f4705b = textPaint;
        this.f4706c = i8;
        this.d = charSequence.length();
    }

    public final StaticLayout a() {
        if (this.f4704a == null) {
            this.f4704a = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        int iMax = Math.max(0, this.f4706c);
        CharSequence charSequenceEllipsize = this.f4704a;
        int i8 = this.f4708f;
        TextPaint textPaint = this.f4705b;
        if (i8 == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint, iMax, this.f4714l);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.d);
        this.d = iMin;
        if (this.f4713k && this.f4708f == 1) {
            this.f4707e = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, 0, iMin, textPaint, iMax);
        builderObtain.setAlignment(this.f4707e);
        builderObtain.setIncludePad(this.f4712j);
        builderObtain.setTextDirection(this.f4713k ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f4714l;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.f4708f);
        float f3 = this.f4709g;
        if (f3 != 0.0f || this.f4710h != 1.0f) {
            builderObtain.setLineSpacing(f3, this.f4710h);
        }
        if (this.f4708f > 1) {
            builderObtain.setHyphenationFrequency(this.f4711i);
        }
        j1.a aVar = this.f4715m;
        if (aVar != null) {
            builderObtain.setBreakStrategy(((TextInputLayout) aVar.f3473a).f1391v.getBreakStrategy());
        }
        return builderObtain.build();
    }
}
