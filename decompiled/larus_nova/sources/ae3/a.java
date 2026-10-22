package ae3;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.bytedance.android.shopping.extensions.b;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f3076a = 0;

    public a() {
    }

    static {
    }

    public static void a(Context r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "content");
        FrameLayout r103 = new FrameLayout(r100);
        r103.setPadding(b.b(16), b.b(10), b.b(16), b.b(10));
        r103.setBackgroundResource(R.drawable.commerce_bg_inflow_toast);
        TextView r104 = new TextView(r100);
        r104.setText(r101);
        r104.setTextColor(ContextCompat.getColor(r100, R.color.TextPrimaryDark));
        r104.setTextSize(14.0f);
        r103.addView(r104);
        Toast r105 = new Toast(r100);
        r105.setGravity(17, 0, 0);
        r105.setDuration(r102);
        r105.setView(r103);
        r105.show();
    }
}
