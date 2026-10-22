package com.bytedance.android.livesdk.livecommerce.intro.card.widget.info;

import android.content.Context;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ec.model.response.k;
import com.larus.nova.R;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c extends AppCompatTextView implements q83.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f148091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public StringBuilder f148092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f148093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f148094d;

    @Override // q83.a
    public final boolean onTick(long r110) {
        k r100 = this.f148091a;
        if (r100 == null) goto L25;
        long r101 = this.f148094d;
        if (r110 >= r101) goto L22;
        long r102 = r101 - r110;
        String r111 = r100.b();
        String r112 = "";
        if (r111 != null) goto L9;
        r111 = "";
    L9:
        String r103 = r100.d();
        if (r103 == null) goto L13;
        r112 = r103;
    L13:
        StringBuilder r104 = this.f148092b;
        Intrinsics.checkNotNullParameter(r111, "prefix");
        Intrinsics.checkNotNullParameter(r112, "suffix");
        double r105 = r102;
        if (r105 <= 0) goto L16;
        int r106 = (int) (r105 / ((double) BaseConstants.Time.HOUR));
        double r107 = r105 - ((double) (BaseConstants.Time.HOUR * r106));
        int r108 = (int) (r107 / ((double) 60000));
        int r109 = (int) ((r107 - ((double) (60000 * r108))) / ((double) 1000));
    L17:
        String r113 = getContext().getString(R.string.ec_promotion_list_time_format, new Object[]{Integer.valueOf(r106)});
        String r114 = getContext().getString(R.string.ec_promotion_list_time_format, new Object[]{Integer.valueOf(r108)});
        String r115 = getContext().getString(R.string.ec_promotion_list_time_format, new Object[]{Integer.valueOf(r109)});
        if (r104 == null) goto L20;
        r104.append(r106 + " 小时，" + r108 + " 分钟，" + r109 + " 秒");
    L20:
        setText(r111 + r113 + ':' + r114 + ':' + r115 + r112);
        return true;
    L16:
        r109 = 0;
        r106 = 0;
        r108 = 0;
        goto L17
    L22:
        Function0<Unit> r116 = this.f148093c;
        if (r116 == null) goto L25;
        Unit r117 = r116.invoke();
    L25:
        return false;
    }

    public c(Context r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 0);
        this.f148094d = r101;
    }
}
