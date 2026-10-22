package com.stepos.ailauncher.chat.activity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.stepos.ailauncher.chat.activity.CardOpenSlideActivity;
import com.stepos.ailauncher.foundation.R$anim;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/CardOpenSlideActivity;", "Landroid/app/Activity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "c", "Landroid/net/Uri;", "targetUri", "Landroid/net/Uri;", "Landroid/graphics/Bitmap;", "snapshot", "Landroid/graphics/Bitmap;", "", "launched", "Z", "Ljava/lang/Runnable;", "timeoutLaunch", "Ljava/lang/Runnable;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CardOpenSlideActivity extends Activity {
    private boolean launched;
    private Bitmap snapshot;
    private Uri targetUri;
    private final Runnable timeoutLaunch = new Runnable() { // from class: com.stepos.ailauncher.chat.activity.h
        @Override // java.lang.Runnable
        public final void run() {
            CardOpenSlideActivity.d(this.f24824a);
        }
    };

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/chat/activity/CardOpenSlideActivity$a", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "()Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ View $decor;
        final /* synthetic */ CardOpenSlideActivity this$0;

        public a(View view, CardOpenSlideActivity cardOpenSlideActivity) {
            this.$decor = view;
            this.this$0 = cardOpenSlideActivity;
        }

        public static final void b(CardOpenSlideActivity cardOpenSlideActivity) {
            cardOpenSlideActivity.c();
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (this.$decor.getViewTreeObserver().isAlive()) {
                this.$decor.getViewTreeObserver().removeOnPreDrawListener(this);
            }
            View view = this.$decor;
            final CardOpenSlideActivity cardOpenSlideActivity = this.this$0;
            view.post(new Runnable() { // from class: com.stepos.ailauncher.chat.activity.i
                @Override // java.lang.Runnable
                public final void run() {
                    CardOpenSlideActivity.a.b(cardOpenSlideActivity);
                }
            });
            return true;
        }
    }

    public static final void d(CardOpenSlideActivity cardOpenSlideActivity) {
        cardOpenSlideActivity.c();
    }

    public final void c() {
        Uri uri;
        if (this.launched || isFinishing() || (uri = this.targetUri) == null) {
            return;
        }
        this.launched = true;
        getWindow().getDecorView().removeCallbacks(this.timeoutLaunch);
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        int i10 = R$anim.card_activity_open_enter;
        int i11 = R$anim.card_activity_open_exit;
        startActivity(intent, ActivityOptions.makeCustomAnimation(this, i10, i11).toBundle());
        finish();
        overridePendingTransition(i10, i11);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        String stringExtra;
        super.onCreate(savedInstanceState);
        Uri data = getIntent().getData();
        if (data == null || (stringExtra = data.toString()) == null) {
            stringExtra = getIntent().getStringExtra(N5.d.EXTRA_CARD_OPEN_URI);
        }
        Uri uri = null;
        if (stringExtra != null) {
            if (stringExtra.length() <= 0) {
                stringExtra = null;
            }
            if (stringExtra != null) {
                uri = Uri.parse(stringExtra);
            }
        }
        this.targetUri = uri;
        this.snapshot = N5.u.INSTANCE.b();
        if (this.targetUri == null) {
            finish();
            return;
        }
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setBackgroundColor(-16777216);
        Bitmap bitmap = this.snapshot;
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
        setContentView(imageView);
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.p.h(decorView, "getDecorView(...)");
        decorView.getViewTreeObserver().addOnPreDrawListener(new a(decorView, this));
        decorView.postDelayed(this.timeoutLaunch, 120L);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        getWindow().getDecorView().removeCallbacks(this.timeoutLaunch);
        this.snapshot = null;
        super.onDestroy();
    }
}
