package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RTChorusLogView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RTChorusLogView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f146219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ChorusUserAdapter f146220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f146221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f146222d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f146223e;

    public static final class a {
    }

    static {
    }

    public RTChorusLogView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RTChorusLogView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public static final void R5(RTChorusLogView r100) {
        r100.getClass();
        RealTimeChorusBusinessContext.a r101 = RealTimeChorusBusinessContext.Companion;
        int r102 = r101.b();
        int r103 = r101.d();
        if (r102 != 1) goto L5;
        String r104 = "主唱";
    L21:
        TextView r105 = r100.f146221c;
        if (r105 == null) goto L25;
        r105.setText(r104);
        return;
    L25:
        return;
    L5:
        if (r102 == 2) goto L11;
        if (r102 == 3) goto L10;
        if (r102 == 4) goto L9;
        r104 = PlayerResolution.NAME.UNKNOWN;
        goto L21
    L9:
        r104 = "观众";
        goto L21
    L10:
        r104 = "嘉宾";
        goto L21
    L11:
        if (r103 != 1) goto L13;
        r104 = "非静默副唱";
        goto L21
    L13:
        if (r103 != 2) goto L15;
        r104 = "静默副唱";
        goto L21
    L15:
        if (r103 == 3) goto L19;
        if (r103 == 4) goto L19;
        r104 = "未知副唱";
    L19:
        r104 = "非连线副唱";
        goto L21
    }

    public RTChorusLogView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ChorusUserAdapter r103 = new ChorusUserAdapter();
        this.f146220b = r103;
        this.f146223e = new CompositeDisposable();
        LayoutInflater.from(r100).inflate(R.layout.ttlive_real_time_chorus_log_info_layout, this);
        this.f146221c = (TextView) findViewById(R.id.chorus_tag);
        this.f146219a = (RecyclerView) findViewById(R.id.chorus_singer_list);
        this.f146222d = (TextView) findViewById(R.id.mix_stream_type);
        RecyclerView r104 = this.f146219a;
        if (r104 == null) goto L5;
        r104.setAdapter(r103);
    L5:
        RecyclerView r105 = this.f146219a;
        if (r105 == null) goto L9;
        r105.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        return;
    }

    public /* synthetic */ RTChorusLogView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
