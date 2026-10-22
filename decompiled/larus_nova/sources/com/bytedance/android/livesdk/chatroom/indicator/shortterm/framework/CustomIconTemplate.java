package com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.livesdkapi.sti.framework.ICustomIconTemplate;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013R.\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@WX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/indicator/shortterm/framework/CustomIconTemplate;", "Lcom/bytedance/android/livesdk/chatroom/indicator/shortterm/framework/BaseIconTemplate;", "Lcom/bytedance/android/livesdkapi/sti/framework/ICustomIconTemplate;", "Landroid/view/View;", "value", "f", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "contentView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
public class CustomIconTemplate extends BaseIconTemplate implements ICustomIconTemplate {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f106582f;

    public CustomIconTemplate(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CustomIconTemplate(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ICustomIconTemplate
    public View getContentView() {
        return this.f106582f;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ICustomIconTemplate
    public final View inflateContentView(int r100) {
        return LayoutInflater.from(getContext()).inflate(r100, getContentContainer(), false);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ICustomIconTemplate
    public void setContentView(View r100) {
        if ((!Intrinsics.areEqual(r100, this.f106582f)) == false) goto L15;
        getContentContainer().removeView(r100);
        if (r100 == null) goto L13;
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == true) goto L9;
        r101 = null;
    L9:
        ViewGroup r102 = (ViewGroup) r101;
        if (r102 == null) goto L12;
        r102.removeView(r100);
    L12:
        getContentContainer().addView(r100);
    L13:
        this.f106582f = r100;
        return;
    }

    public CustomIconTemplate(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ CustomIconTemplate(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
