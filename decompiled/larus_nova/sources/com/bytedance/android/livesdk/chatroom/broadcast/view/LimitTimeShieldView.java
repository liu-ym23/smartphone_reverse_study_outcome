package com.bytedance.android.livesdk.chatroom.broadcast.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alipay.sdk.m.x.d;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\n\u0010\u000eB#\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\n\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/broadcast/view/LimitTimeShieldView;", "Landroid/widget/LinearLayout;", "", "title", "", d.f25925o, "content", "setContent", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdkshell_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LimitTimeShieldView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f105558a;

    public LimitTimeShieldView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f105558a = new LinkedHashMap();
        View.inflate(getContext(), R.layout.ttlive_broadcast_time_limit_view, this);
    }

    public final View a(int r100) {
        if (this.f105558a != null) goto L5;
        this.f105558a = new LinkedHashMap();
    L5:
        View r101 = this.f105558a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f105558a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void setContent(CharSequence r100) {
        TextView r101 = (TextView) a(R.id.time_limit_content);
        if (r101 == null) goto L9;
        if (r100 == null) goto L6;
        String r102 = r100.toString();
    L7:
        r101.setText(r102);
        return;
    L6:
        r102 = null;
        goto L7
    }

    public final void setTitle(CharSequence r100) {
        TextView r101 = (TextView) a(R.id.time_limit_title);
        if (r101 == null) goto L9;
        if (r100 == null) goto L6;
        String r102 = r100.toString();
    L7:
        r101.setText(r102);
        return;
    L6:
        r102 = null;
        goto L7
    }

    public LimitTimeShieldView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f105558a = new LinkedHashMap();
        View.inflate(getContext(), R.layout.ttlive_broadcast_time_limit_view, this);
    }

    public LimitTimeShieldView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f105558a = new LinkedHashMap();
        View.inflate(getContext(), R.layout.ttlive_broadcast_time_limit_view, this);
    }
}
