package com.bytedance.android.live.room.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/room/view/NewIndicatorTextSwitcher;", "Landroid/widget/TextSwitcher;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewIndicatorTextSwitcher extends TextSwitcher {

    public static final class a implements ViewSwitcher.ViewFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewIndicatorTextSwitcher f100398a;

        public a(NewIndicatorTextSwitcher r100) {
            this.f100398a = r100;
        }

        @Override // android.widget.ViewSwitcher.ViewFactory
        public final View makeView() {
            TextView r100 = new TextView(this.f100398a.getContext());
            r100.setSingleLine();
            r100.setTextSize(1, 10.0f);
            r100.setTextColor(this.f100398a.getResources().getColor(R.color.commonui_white));
            r100.setIncludeFontPadding(false);
            r100.setWidth(s1.f(52.0f));
            return r100;
        }
    }

    public NewIndicatorTextSwitcher(Context r100, AttributeSet r101) {
        super(r100, r101);
        setFactory(new a(this));
        setInAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.new_anim_text_in));
        setOutAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.new_anim_text_out));
    }
}
