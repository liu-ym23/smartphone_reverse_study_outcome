package bq4;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes15.dex */
public final class d extends CharacterStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f20036a;

    public d(Context r100) {
        this.f20036a = r100;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        r100.setTextSize(cu5.c.f());
        r100.setColor(this.f20036a.getResources().getColor(R.color.function_danger_fill_default));
    }
}
