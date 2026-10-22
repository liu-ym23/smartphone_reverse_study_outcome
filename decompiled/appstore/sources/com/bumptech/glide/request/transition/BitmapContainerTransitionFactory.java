package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: classes.dex */
public abstract class BitmapContainerTransitionFactory<R> implements TransitionFactory<R> {
    private final TransitionFactory<Drawable> realFactory;

    public final class BitmapGlideAnimation implements Transition<R> {
        final /* synthetic */ BitmapContainerTransitionFactory this$0;
        private final Transition<Drawable> transition;

        public BitmapGlideAnimation(BitmapContainerTransitionFactory r10, Transition<Drawable> r11) {
            this.this$0 = r10;
            this.transition = r11;
        }

        @Override // com.bumptech.glide.request.transition.Transition
        public boolean transition(R r10, Transition.ViewAdapter r11) {
            BitmapDrawable r12 = new BitmapDrawable(r11.getView().getResources(), this.this$0.getBitmap(r10));
            return this.transition.transition(r12, r11);
        }
    }

    public BitmapContainerTransitionFactory(TransitionFactory<Drawable> r10) {
        this.realFactory = r10;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<R> build(DataSource r10, boolean r11) {
        return new BitmapGlideAnimation(this, this.realFactory.build(r10, r11));
    }

    public abstract Bitmap getBitmap(R r10);
}
