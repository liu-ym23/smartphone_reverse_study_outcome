package J4;

import D7.v;
import D7.w;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import j9.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.text.Regex;

/* loaded from: classes3.dex */
public final class g extends MetricAffectingSpan {

    /* renamed from: a, reason: collision with root package name */
    public static final Regex f875a = new Regex("^(?:'ss01'|\"ss01\"|ss01)(?:\\s+.*)?$");

    public static void a(TextPaint textPaint) {
        String fontFeatureSettings = textPaint.getFontFeatureSettings();
        if (fontFeatureSettings == null) {
            fontFeatureSettings = "";
        }
        List listE0 = m.E0(fontFeatureSettings, new char[]{','});
        ArrayList arrayList = new ArrayList(w.c0(listE0, 10));
        Iterator it = listE0.iterator();
        while (it.hasNext()) {
            arrayList.add(m.R0((String) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            String str = (String) next;
            if (str.length() > 0 && !f875a.d(str)) {
                arrayList2.add(next);
            }
        }
        textPaint.setFontFeatureSettings(v.I0(v.R0(arrayList2, "'ss01' 1"), ", ", null, null, null, 62));
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint tp) {
        k.f(tp, "tp");
        a(tp);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint) {
        k.f(textPaint, "textPaint");
        a(textPaint);
    }
}
