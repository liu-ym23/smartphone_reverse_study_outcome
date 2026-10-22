package com.bytedance.android.livesdk.dislike.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nt1.b;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\b\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/layout/NotificationSettingItemLayout;", "Landroid/widget/LinearLayout;", "Lnt1/b;", "vo", "", "update", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NotificationSettingItemLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f122139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f122140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f122141c;

    public NotificationSettingItemLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        View.inflate(getContext(), R.layout.ttlive_dialog_notification_setting_option_desc_single, this);
        setOrientation(1);
        this.f122139a = (TextView) findViewById(R.id.desc);
        this.f122140b = (ImageView) findViewById(R.id.icon);
        this.f122141c = (ImageView) findViewById(R.id.notification_is_checked);
    }

    public final void update(b r100) {
        Intrinsics.checkNotNullParameter(r100, "vo");
        ImageView r101 = this.f122140b;
        if (r101 == null) goto L5;
        r101.setImageResource(r100.f520464a);
    L5:
        TextView r102 = this.f122139a;
        if (r102 == null) goto L9;
        r102.setText(getContext().getResources().getText(r100.f520465b));
    L9:
        if (r100.f520466c == false) goto L14;
        ImageView r103 = this.f122141c;
        if (r103 == null) goto L14;
        r103.setVisibility(0);
    L14:
        if (r100.f520466c == false) goto L16;
        String r104 = "已选中";
    L17:
        StringBuilder r105 = new StringBuilder();
        TextView r106 = this.f122139a;
        if (r106 == null) goto L20;
        CharSequence r107 = r106.getText();
    L21:
        r105.append(r107);
        r105.append(' ');
        r105.append(r104);
        setContentDescription(r105.toString());
        return;
    L20:
        r107 = null;
        goto L21
    L16:
        r104 = "未选中";
        goto L17
    }

    public NotificationSettingItemLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        View.inflate(getContext(), R.layout.ttlive_dialog_notification_setting_option_desc_single, this);
        setOrientation(1);
        this.f122139a = (TextView) findViewById(R.id.desc);
        this.f122140b = (ImageView) findViewById(R.id.icon);
        this.f122141c = (ImageView) findViewById(R.id.notification_is_checked);
    }

    public NotificationSettingItemLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View.inflate(getContext(), R.layout.ttlive_dialog_notification_setting_option_desc_single, this);
        setOrientation(1);
        this.f122139a = (TextView) findViewById(R.id.desc);
        this.f122140b = (ImageView) findViewById(R.id.icon);
        this.f122141c = (ImageView) findViewById(R.id.notification_is_checked);
    }
}
