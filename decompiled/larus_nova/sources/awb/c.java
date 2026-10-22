package awb;

import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.widget.TextView;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.textselection.MmSelectableSummaryTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f16600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f16601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f16602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f16603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f16604e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f16605f;

    public final void a(boolean r100) {
        if ((this.f16600a.getText() instanceof Spannable) == true) goto L8;
        TextView r101 = this.f16600a;
        CharSequence r102 = this.f16600a.getText();
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        r101.setText(new SpannableString(r102));
    L8:
        if (r100 == true) goto L10;
    L18:
        this.f16600a.setTextIsSelectable(false);
        this.f16600a.setCustomSelectionActionModeCallback(null);
        this.f16602c.removeCallbacks(this.f16605f);
        return;
    L10:
        if (this.f16601b.f16606a == false) goto L18;
        this.f16600a.setTextIsSelectable(true);     // Catch: Exception -> L13
    L14:
        Integer r103 = this.f16601b.f16608c;
        if (r103 == null) goto L17;
        int r104 = r103.intValue();
        this.f16600a.setHighlightColor(r104);
    L17:
        this.f16600a.setCustomSelectionActionModeCallback(new a(this));
    }

    public c(MmSelectableSummaryTextView r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        Intrinsics.checkNotNullParameter(r101, "config");
        this.f16600a = r100;
        this.f16601b = r101;
        this.f16602c = new Handler(Looper.getMainLooper());
        this.f16605f = new b(this);
    }
}
