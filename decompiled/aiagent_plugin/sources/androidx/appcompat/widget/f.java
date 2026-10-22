package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppCompatEmojiTextHelper.java */
/* JADX INFO: loaded from: classes.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.emoji2.viewsintegration.b f434b;

    f(TextView r3) {
        this.f433a = r3;
        this.f434b = new androidx.emoji2.viewsintegration.b(r3, false);
    }

    void a(AttributeSet r6, int r7) {
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        TypedArray r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f433a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(r8, R.styleable.AppCompatTextView, r7, 0);
        boolean r2 = true;
        if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_emojiCompatEnabled, "styleable", "AppCompatTextView_emojiCompatEnabled")) == false) goto L6;
        r2 = r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.AppCompatTextView_emojiCompatEnabled, "styleable", "AppCompatTextView_emojiCompatEnabled"), true);     // Catch: Throwable -> L8
    L6:
        r9.recycle();
        a(r2);
        return;
    L8:
        th = move-exception;
        r9.recycle();
        throw th;
    }

    void a(boolean r1) {
        this.f434b.a(r1);
    }

    public boolean a() {
        return this.f434b.a();
    }

    InputFilter[] a(InputFilter[] r1) {
        return this.f434b.a(r1);
    }

    void b(boolean r1) {
        this.f434b.b(r1);
    }

    public TransformationMethod a(TransformationMethod r3) {
        TransformationMethod r4 = (TransformationMethod) ZeusTransformUtils.wrapperContextForParams(r3, TransformationMethod.class, "com.obric.aiagent.plugin");
        return this.f434b.a(r4);
    }
}
