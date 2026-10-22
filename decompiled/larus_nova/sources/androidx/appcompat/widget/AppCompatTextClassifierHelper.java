package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
final class AppCompatTextClassifierHelper {
    private TextClassifier mTextClassifier;
    private TextView mTextView;

    public TextClassifier getTextClassifier() {
        TextClassifier r100 = this.mTextClassifier;
        if (r100 != null) goto L10;
        TextClassificationManager r101 = (TextClassificationManager) this.mTextView.getContext().getSystemService(TextClassificationManager.class);
        if (r101 == null) goto L9;
        return r101.getTextClassifier();
    L9:
        return TextClassifier.NO_OP;
    L10:
        return r100;
    }

    public AppCompatTextClassifierHelper(TextView r100) {
        this.mTextView = (TextView) Preconditions.checkNotNull(r100);
    }

    public void setTextClassifier(TextClassifier r100) {
        this.mTextClassifier = r100;
    }
}
