package I8;

import Yb.o;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.widget.TextView;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import io.noties.markwon.image.d;
import io.noties.markwon.image.f;
import java.util.HashMap;
import java.util.Map;
import u8.AbstractC5589a;
import u8.g;
import u8.k;

/* loaded from: classes4.dex */
public class a extends AbstractC5589a {

    /* renamed from: a, reason: collision with root package name */
    public final C0056a f3390a;

    /* renamed from: I8.a$a, reason: collision with other inner class name */
    public static class C0056a extends io.noties.markwon.image.b {

        /* renamed from: a, reason: collision with root package name */
        public final b f3391a;

        /* renamed from: b, reason: collision with root package name */
        public final Map<io.noties.markwon.image.a, Target<?>> f3392b = new HashMap(2);

        /* renamed from: I8.a$a$a, reason: collision with other inner class name */
        public class C0057a extends CustomTarget<Drawable> {

            /* renamed from: a, reason: collision with root package name */
            public final io.noties.markwon.image.a f3393a;

            public C0057a(io.noties.markwon.image.a aVar) {
                this.f3393a = aVar;
            }

            @Override // com.bumptech.glide.request.target.Target
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                if (C0056a.this.f3392b.remove(this.f3393a) == null || !this.f3393a.k()) {
                    return;
                }
                f.a(drawable);
                this.f3393a.p(drawable);
            }

            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(Drawable drawable) {
                if (this.f3393a.k()) {
                    this.f3393a.a();
                }
            }

            @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
            public void onLoadFailed(Drawable drawable) {
                if (C0056a.this.f3392b.remove(this.f3393a) == null || drawable == null || !this.f3393a.k()) {
                    return;
                }
                f.a(drawable);
                this.f3393a.p(drawable);
            }

            @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
            public void onLoadStarted(Drawable drawable) {
                if (drawable == null || !this.f3393a.k()) {
                    return;
                }
                f.a(drawable);
                this.f3393a.p(drawable);
            }
        }

        public C0056a(b bVar) {
            this.f3391a = bVar;
        }

        @Override // io.noties.markwon.image.b
        public void a(io.noties.markwon.image.a aVar) {
            Target<?> targetRemove = this.f3392b.remove(aVar);
            if (targetRemove != null) {
                this.f3391a.a(targetRemove);
            }
        }

        @Override // io.noties.markwon.image.b
        public void b(io.noties.markwon.image.a aVar) {
            C0057a c0057a = new C0057a(aVar);
            this.f3392b.put(aVar, c0057a);
            this.f3391a.b(aVar).into((RequestBuilder<Drawable>) c0057a);
        }

        @Override // io.noties.markwon.image.b
        public Drawable d(io.noties.markwon.image.a aVar) {
            return null;
        }
    }

    public interface b {
        void a(Target<?> target);

        RequestBuilder<Drawable> b(io.noties.markwon.image.a aVar);
    }

    public a(b bVar) {
        this.f3390a = new C0056a(bVar);
    }

    public static a l(b bVar) {
        return new a(bVar);
    }

    @Override // u8.AbstractC5589a, u8.i
    public void a(k.a aVar) {
        aVar.a(o.class, new io.noties.markwon.image.k());
    }

    @Override // u8.AbstractC5589a, u8.i
    public void e(TextView textView) {
        d.b(textView);
    }

    @Override // u8.AbstractC5589a, u8.i
    public void f(g.b bVar) {
        bVar.h(this.f3390a);
    }

    @Override // u8.AbstractC5589a, u8.i
    public void j(TextView textView, Spanned spanned) {
        d.c(textView);
    }
}
