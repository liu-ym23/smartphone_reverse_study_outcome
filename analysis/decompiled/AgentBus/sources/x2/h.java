package x2;

import android.os.Looper;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.lifecycle.v;
import androidx.lifecycle.x;

/* loaded from: classes.dex */
public final class h implements androidx.lifecycle.f {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ x f11122f;

    public h(EmojiCompatInitializer emojiCompatInitializer, x xVar) {
        this.f11122f = xVar;
    }

    @Override // androidx.lifecycle.f
    public final void a(v vVar) {
        a.a(Looper.getMainLooper()).postDelayed(new j(), 500L);
        this.f11122f.f(this);
    }
}
