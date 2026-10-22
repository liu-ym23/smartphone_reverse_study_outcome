package bp;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.shopping.extensions.b;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends LinearLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f19924b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f19925a;

    /* JADX INFO: renamed from: bp.a$a, reason: collision with other inner class name */
    public static final class C0324a {
    }

    static {
        f19924b = b.b(12);
    }

    public final TextView getTextView() {
        return this.f19925a;
    }

    public a(Context r100) {
        int r101 = b.b(44);
        int r102 = b.b(8);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        setGravity(17);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        ImageView r103 = new ImageView(r100);
        ViewGroup.LayoutParams r104 = new LinearLayout.LayoutParams(r101, r102);
        r103.setImageResource(R.drawable.window_ic_recommend_notice_arrow);
        r103.setAdjustViewBounds(true);
        addView(r103, r104);
        TextView r105 = new TextView(r100);
        r105.setTypeface(Typeface.DEFAULT_BOLD);
        r105.setTextColor(-15329245);
        r105.setTextSize(2, 15.0f);
        Unit r106 = Unit.INSTANCE;
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-2, -2);
        int r108 = f19924b;
        r107.leftMargin = r108;
        r107.rightMargin = r108;
        addView(r105, r107);
        this.f19925a = r105;
        ImageView r109 = new ImageView(r100);
        r109.setScaleX(-1.0f);
        r109.setImageResource(R.drawable.window_ic_recommend_notice_arrow);
        r109.setAdjustViewBounds(true);
        addView(r109, new LinearLayout.LayoutParams(r101, r102));
    }

    public final void setTextView(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f19925a = r100;
    }
}
