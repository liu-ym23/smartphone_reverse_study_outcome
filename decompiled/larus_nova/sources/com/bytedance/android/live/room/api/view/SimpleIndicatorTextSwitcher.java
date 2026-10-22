package com.bytedance.android.live.room.api.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/room/api/view/SimpleIndicatorTextSwitcher;", "Landroid/widget/TextSwitcher;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimpleIndicatorTextSwitcher extends TextSwitcher {
    public final TextView a(String r100) {
        TextView r101 = new TextView(getContext());
        r101.setSingleLine();
        r101.setTextSize(1, 15.0f);
        r101.setTextColor(r101.getResources().getColor(R.color.white));
        r101.setText(r100);
        r101.setIncludeFontPadding(false);
        r101.setSingleLine(true);
        r101.setGravity(GravityCompat.END);
        r101.setIncludeFontPadding(false);
        return r101;
    }

    public SimpleIndicatorTextSwitcher(Context r100, AttributeSet r101) {
        super(r100, r101);
        setInAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_text_in));
        setOutAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_text_out));
    }
}
