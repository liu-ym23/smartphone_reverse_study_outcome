package com.bytedance.android.live.soloktv.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/soloktv/view/LyricSeekLine;", "Landroid/widget/RelativeLayout;", "Landroid/widget/TextView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/widget/TextView;", "getCurrentLocateTs", "()Landroid/widget/TextView;", "setCurrentLocateTs", "(Landroid/widget/TextView;)V", "currentLocateTs", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LyricSeekLine extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f101708a;

    public final TextView getCurrentLocateTs() {
        TextView r100 = this.f101708a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("currentLocateTs");
    L5:
        return r100;
    }

    public final void setCurrentLocateTs(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f101708a = r100;
    }

    public LyricSeekLine(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.view_lyric_locate, this);
        this.f101708a = (TextView) findViewById(R.id.tv_target_time);
    }
}
