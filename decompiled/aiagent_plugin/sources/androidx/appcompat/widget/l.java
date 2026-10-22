package androidx.appcompat.widget;

import android.content.Context;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppCompatTextClassifierHelper.java */
/* JADX INFO: loaded from: classes.dex */
final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextClassifier f449b;

    /* JADX INFO: compiled from: AppCompatTextClassifierHelper.java */
    private static final class a {
        static TextClassifier a(TextView r2) {
            TextClassificationManager r3 = (TextClassificationManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService(TextClassificationManager.class), TextClassificationManager.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L7;
            return r3.getTextClassifier();
        L7:
            return TextClassifier.NO_OP;
        }
    }

    l(TextView r3) {
        this.f448a = (TextView) ZeusTransformUtils.preCheckCast(androidx.core.util.g.a(r3), TextView.class, "com.obric.aiagent.plugin");
    }

    public void a(TextClassifier r3) {
        this.f449b = (TextClassifier) ZeusTransformUtils.wrapperContextForParams(r3, TextClassifier.class, "com.obric.aiagent.plugin");
    }

    public TextClassifier a() {
        TextClassifier r0 = this.f449b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return a.a(this.f448a);
    }
}
