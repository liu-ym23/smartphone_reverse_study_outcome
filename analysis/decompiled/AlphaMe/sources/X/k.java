package X;

import android.os.Looper;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.lifecycle.AbstractC0328z;
import androidx.lifecycle.G;
import androidx.lifecycle.InterfaceC0315l;

/* loaded from: classes.dex */
public final class k implements InterfaceC0315l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC0328z f2064a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EmojiCompatInitializer f2065b;

    public k(EmojiCompatInitializer emojiCompatInitializer, AbstractC0328z abstractC0328z) {
        this.f2065b = emojiCompatInitializer;
        this.f2064a = abstractC0328z;
    }

    @Override // androidx.lifecycle.InterfaceC0315l
    public final void onResume(G g4) {
        this.f2065b.getClass();
        AbstractC0111b.a(Looper.getMainLooper()).postDelayed(new n(0), 500L);
        this.f2064a.b(this);
    }
}
