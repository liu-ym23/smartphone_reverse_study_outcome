package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: classes39.dex */
public abstract class BitmapContainerTransitionFactory<R> implements TransitionFactory<R> {
    private final TransitionFactory<Drawable> realFactory;

    public final class BitmapGlideAnimation implements Transition<R> {
        final /* synthetic */ BitmapContainerTransitionFactory this$0;
        private final Transition<Drawable> transition;

        public BitmapGlideAnimation(BitmapContainerTransitionFactory r100, Transition<Drawable> r101) {
            this.this$0 = r100;
            this.transition = r101;
        }

        @Override // com.bumptech.glide.request.transition.Transition
        public boolean transition(R r100, Transition.ViewAdapter r101) {
            BitmapDrawable r102 = new BitmapDrawable(r101.getView().getResources(), this.this$0.getBitmap(r100));
            return this.transition.transition(r102, r101);
        }
    }

    public abstract Bitmap getBitmap(R r100);

    public BitmapContainerTransitionFactory(TransitionFactory<Drawable> r100) {
        this.realFactory = r100;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<R> build(DataSource r100, boolean r101) {
        return new BitmapGlideAnimation(this, this.realFactory.build(r100, r101));
    }
}
