package i1;

import android.os.Looper;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements androidx.lifecycle.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Lifecycle f9433a;

    public b(EmojiCompatInitializer emojiCompatInitializer, Lifecycle lifecycle) {
        this.f9433a = lifecycle;
    }

    @Override // androidx.lifecycle.e
    public final void o(q qVar) {
        a.a(Looper.getMainLooper()).postDelayed(new EmojiCompatInitializer.c(), 500L);
        this.f9433a.c(this);
    }
}
