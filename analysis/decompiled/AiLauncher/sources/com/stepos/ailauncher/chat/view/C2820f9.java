package com.stepos.ailauncher.chat.view;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.TextView;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005JA\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/chat/view/f9;", "Landroid/text/InputFilter;", "Landroid/widget/TextView;", "toastView", "<init>", "(Landroid/widget/TextView;)V", "", "source", "", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "Landroid/text/Spanned;", "dest", "dstart", "dend", "filter", "(Ljava/lang/CharSequence;IILandroid/text/Spanned;II)Ljava/lang/CharSequence;", "LY8/t;", "c", "()V", "Landroid/widget/TextView;", "", "lastToastTime", "J", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.f9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2820f9 implements InputFilter {
    private long lastToastTime;
    private final TextView toastView;

    public C2820f9(TextView toastView) {
        kotlin.jvm.internal.p.i(toastView, "toastView");
        this.toastView = toastView;
    }

    public static final void d(final C2820f9 c2820f9) {
        c2820f9.toastView.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.stepos.ailauncher.chat.view.e9
            @Override // java.lang.Runnable
            public final void run() {
                C2820f9.e(this.f26121a);
            }
        }).start();
    }

    public static final void e(C2820f9 c2820f9) {
        c2820f9.toastView.setVisibility(8);
    }

    public final void c() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.lastToastTime < 1500) {
            return;
        }
        this.lastToastTime = jCurrentTimeMillis;
        this.toastView.setText("长度最大限制为20个字符");
        this.toastView.animate().cancel();
        this.toastView.setAlpha(1.0f);
        this.toastView.setVisibility(0);
        this.toastView.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.view.d9
            @Override // java.lang.Runnable
            public final void run() {
                C2820f9.d(this.f26107a);
            }
        }, 1500L);
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        kotlin.jvm.internal.p.i(source, "source");
        kotlin.jvm.internal.p.i(dest, "dest");
        int length = 20 - (dest.length() - (dend - dstart));
        if (length <= 0) {
            c();
            return "";
        }
        if (length >= end - start) {
            return null;
        }
        c();
        return source.subSequence(start, length + start);
    }
}
