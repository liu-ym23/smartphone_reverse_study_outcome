package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001aB'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/ui/SelfDisciplineTimerView;", "Landroid/widget/FrameLayout;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "getMDurationHolder", "()Ljava/util/concurrent/ConcurrentHashMap;", "mDurationHolder", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "c", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "getMPlayerInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "setMPlayerInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;)V", "mPlayerInfo", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SelfDisciplineTimerView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f79721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, Long> f79722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ILinkPlayerInfoBridge f79723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f79724d;

    public static final class a {
    }

    static {
    }

    public SelfDisciplineTimerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SelfDisciplineTimerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void b() {
        Disposable r100 = this.f79724d;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f79723c = null;
        TextView r101 = (TextView) a(R.id.tv_timer);
        if (r101 == null) goto L8;
        r101.setText(d(0));
    L8:
        TextView r102 = (TextView) a(R.id.tv_timer);
        if (r102 == null) goto L12;
        r102.setVisibility(8);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable r100 = this.f79724d;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        TextView r101 = (TextView) a(R.id.tv_timer);
        if (r101 == null) goto L8;
        r101.setText(d(0));
    L8:
        TextView r102 = (TextView) a(R.id.tv_timer);
        if (r102 == null) goto L12;
        r102.setVisibility(4);
        return;
    }

    public final ConcurrentHashMap<String, Long> getMDurationHolder() {
        return this.f79722b;
    }

    public final ILinkPlayerInfoBridge getMPlayerInfo() {
        return this.f79723c;
    }

    public static String c(long r100) {
        if (r100 != 0) goto L5;
        return CustomAlbumViewModel.DEFAULT_TAB_ID;
    L5:
        long r101 = 9;
        if (1 > r100) goto L12;
        if (r101 < r100) goto L12;
        return "0" + r100;
    L12:
        return String.valueOf(r100);
    }

    public static String d(long r100) {
        long r101 = 60;
        long r102 = r100 % r101;
        TimeUnit r103 = TimeUnit.SECONDS;
        long r104 = r103.toMinutes(r100) % r101;
        return c(r103.toHours(r100)) + ':' + c(r104) + ':' + c(r102);
    }

    public final View a(int r100) {
        if (this.f79721a != null) goto L5;
        this.f79721a = new LinkedHashMap();
    L5:
        View r101 = this.f79721a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f79721a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void setMPlayerInfo(ILinkPlayerInfoBridge r100) {
        this.f79723c = r100;
    }

    public SelfDisciplineTimerView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f79721a = new LinkedHashMap();
        SelfDisciplineContext r103 = SelfDisciplineContext.Companion.getContext();
        if (r103 == null) goto L6;
        ConcurrentHashMap<String, Long> r104 = r103.getDurationHolder();
        if (r104 == null) goto L6;
    L7:
        this.f79722b = r104;
        LayoutInflater.from(r100).inflate(R.layout.ttlive_self_discipline_timer_view, this);
        ((TextView) a(R.id.tv_timer)).setVisibility(8);
        setOnClickListener(x0.a(new AnonymousClass1(this, r100)));
        return;
    L6:
        r104 = new ConcurrentHashMap();
        goto L7
    }

    public /* synthetic */ SelfDisciplineTimerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
