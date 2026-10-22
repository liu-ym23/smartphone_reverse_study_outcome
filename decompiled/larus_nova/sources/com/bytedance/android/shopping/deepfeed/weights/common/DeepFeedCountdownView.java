package com.bytedance.android.shopping.deepfeed.weights.common;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/common/DeepFeedCountdownView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "endTimeMs", "", "setEndTimestamp", "Lkotlin/Function0;", "listener", "setOnCountdownEndListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedCountdownView extends AppCompatTextView {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f174157h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f174158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f174159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f174160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Job f174161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f174162e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f174163f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f174164g;

    public DeepFeedCountdownView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DeepFeedCountdownView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void x() {
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f174159b == false) goto L5;
        return;
    L5:
        if (this.f174158a <= System.currentTimeMillis()) goto L9;
        x();
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f174159b = false;
        Job r100 = this.f174161d;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f174161d = null;
        this.f174159b = false;
    }

    public final void setEndTimestamp(long r100) {
        this.f174158a = r100;
        long r101 = System.currentTimeMillis();
        long r102 = this.f174158a;
        if (r102 <= r101) goto L5;
        long r103 = r102 - r101;
    L6:
        y(r103);
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public final void setOnCountdownEndListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f174160c = r100;
    }

    public final void y(long r100) {
        if (r100 > 0) goto L6;
        setText(this.f174162e + this.f174164g);
        return;
    L6:
        long r101 = r100 / ((long) 1000);
        long r102 = AnnouncementViewModel.HOUR_DURATION;
        int r103 = (int) (r101 / r102);
        long r104 = 60;
        int r105 = (int) ((r101 % r102) / r104);
        int r106 = (int) (r101 % r104);
        StringCompanionObject r107 = StringCompanionObject.INSTANCE;     // Catch: Exception -> L9
        setText(String.format("%s%02d:%02d:%02d", Arrays.copyOf(new Object[]{this.f174162e + this.f174163f, Integer.valueOf(r103), Integer.valueOf(r105), Integer.valueOf(r106)}, 4)));     // Catch: Exception -> L9
        return;
    }

    public DeepFeedCountdownView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f174162e = "";
        this.f174163f = "";
        this.f174164g = "已失效";
        setGravity(17);
    }

    public /* synthetic */ DeepFeedCountdownView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
