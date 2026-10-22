package obric.api;

import android.util.Singleton;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public class TextViewSmt {
    public static final int BREAK_STRATEGY_BALANCED = 2;
    public static final int BREAK_STRATEGY_HIGH_QUALITY = 1;
    public static final int BREAK_STRATEGY_SIMPLE = 0;
    static final String TAG = "TextViewSmt";
    static final Singleton<TextViewSmt> sTextViewSmt = null;

    public void setHiddenContextMenuItem(TextView r1, int r2) {
    }

    /* synthetic */ TextViewSmt(AnonymousClass1 r1) {
        this();
    }

    static {
        sTextViewSmt = new AnonymousClass1();
    }

    public static TextViewSmt getInstance() {
        return (TextViewSmt) sTextViewSmt.get();
    }

    private TextViewSmt() {
    }

    public void setMaxTextSize(TextView r1, float r2) {
        r1.getSmtEx().setMaxTextSize(r2);
    }
}
