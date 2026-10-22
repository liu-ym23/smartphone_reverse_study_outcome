package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class AutoFallbackHybridComponentContainer extends FrameLayout implements com.bytedance.android.live.browser.jsbridge.f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f112111e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f112112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f112113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HybridCard f112114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public m5 f112115d;

    public interface a {
    }

    public void setListener(a r100) {
    }

    public final void a() {
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L6;
        TextView r100 = new TextView(getContext());
        r100.setBackgroundColor(FakePickerAvatarCreator.GREEN);
        r100.setTextColor(-1);
        r100.setText("null");
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-2, -2);
        r101.gravity = 0;
        r100.setLayoutParams(r101);
        addView(r100);
        return;
    }

    public AutoFallbackHybridComponentContainer(Context r100) {
        super(r100);
        a();
    }

    public final void b(String r100) {
        ALogger.i("AutoFallbackHybridComponentContainer", r100);
    }

    public void setParams(Map<String, String> r100) {
        this.f112113b = r100;
    }

    public AutoFallbackHybridComponentContainer(Context r100, AttributeSet r101) {
        super(r100, r101);
        a();
    }

    public AutoFallbackHybridComponentContainer(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a();
    }
}
