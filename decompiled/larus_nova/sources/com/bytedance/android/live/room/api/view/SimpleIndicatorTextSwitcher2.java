package com.bytedance.android.live.room.api.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import kotlin.Metadata;
import p81.d;
import p81.e;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/room/api/view/SimpleIndicatorTextSwitcher2;", "Landroid/widget/TextSwitcher;", "", "c", "I", "getCurrentIndex", "()I", "setCurrentIndex", "(I)V", "currentIndex", "e", "getMeasureMaxWidth", "setMeasureMaxWidth", "measureMaxWidth", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimpleIndicatorTextSwitcher2 extends TextSwitcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f99155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<d> f99156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f99157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f99158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f99159e;

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Disposable r100 = this.f99158d;
        if (r100 != null) goto L5;
    L10:
        Animation r101 = getInAnimation();
        if (r101 == null) goto L13;
        r101.cancel();
    L13:
        Animation r102 = getOutAnimation();
        if (r102 == null) goto L16;
        r102.cancel();
    L16:
        super.onDetachedFromWindow();
        return;
    L5:
        if ((!r100.isDisposed()) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        r100.dispose();
        goto L10
    }

    public final int getCurrentIndex() {
        return this.f99157c;
    }

    public final int getMeasureMaxWidth() {
        return this.f99159e;
    }

    public final void setCurrentIndex(int r100) {
        this.f99157c = r100;
    }

    public final void setMeasureMaxWidth(int r100) {
        this.f99159e = r100;
    }

    public SimpleIndicatorTextSwitcher2(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f99155a = new e();
        this.f99156b = new ArrayList();
        this.f99159e = -1;
        setInAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_text_in));
        setOutAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_text_out));
    }
}
