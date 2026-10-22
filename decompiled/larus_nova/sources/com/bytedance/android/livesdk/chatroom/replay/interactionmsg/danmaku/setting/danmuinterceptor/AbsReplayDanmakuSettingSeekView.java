package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.setting.danmuinterceptor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.setting.ReplayBarrageSettingDataContext;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.setting.seekbar.RangeSeekBar;
import com.bytedance.android.livesdk.chatroom.replay.ui.a;
import com.bytedance.android.livesdk.chatroom.vs_base.base.d;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.config.ReplayBarrageSetting;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sh6.b;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H&¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/setting/danmuinterceptor/AbsReplayDanmakuSettingSeekView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "getStepCount", "", "getTitle", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsReplayDanmakuSettingSeekView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f109176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RangeSeekBar f109177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f109178c;

    public AbsReplayDanmakuSettingSeekView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AbsReplayDanmakuSettingSeekView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public abstract String R5(int r100);

    public abstract int S5(ReplayBarrageSetting r100);

    public abstract void T5(int r100);

    public int getStepCount() {
        return 0;
    }

    public abstract String getTitle();

    public AbsReplayDanmakuSettingSeekView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        d r103 = ReplayRoomFragmentScopeUtil.f117917a;
        if (((a) ReplayRoomFragmentScopeUtil.a(a.class)).l() == false) goto L5;
        int r104 = R.layout.ttlive_layout_replay_barrage_setting_seek_portrait;
    L6:
        View.inflate(r100, r104, this);
        this.f109176a = (TextView) findViewById(R.id.title);
        this.f109177b = (RangeSeekBar) findViewById(R.id.seek_bar);
        this.f109178c = (TextView) findViewById(R.id.hintContent);
        TextView r105 = this.f109176a;
        if (r105 == null) goto L9;
        r105.setText(getTitle());
    L9:
        RangeSeekBar r106 = this.f109177b;
        if (r106 == null) goto L12;
        r106.setStepCount(getStepCount());
    L12:
        RangeSeekBar r107 = this.f109177b;
        if (r107 == null) goto L15;
        r107.setOnRangeChangedListener(new tl1.a(this));
    L15:
        ReplayBarrageSettingDataContext.a r108 = ReplayBarrageSettingDataContext.Companion;
        ReplayBarrageSettingDataContext r109 = r108.getContext();
        if (r109 == null) goto L20;
        n<ReplayBarrageSetting> r110 = r109.getBarrageSetting();
        if (r110 == null) goto L20;
        ReplayBarrageSetting r111 = r110.getValue();
    L21:
        if (r111 == null) goto L36;
        int r112 = S5(r111);
        RangeSeekBar r113 = this.f109177b;
        if (r113 == null) goto L25;
        int r114 = r113.getStepCount();
    L26:
        if (r114 <= 0) goto L30;
        RangeSeekBar r115 = this.f109177b;
        if (r115 == null) goto L33;
        r115.setStep(r112);
    L33:
        TextView r116 = this.f109178c;
        if (r116 == null) goto L36;
        r116.setText(R5(r112));
        goto L36
    L30:
        RangeSeekBar r117 = this.f109177b;
        if (r117 == null) goto L33;
        r117.setProgress(r112);
        goto L33
    L25:
        r114 = 0;
    L36:
        if (r109 == null) goto L51;
        n<ReplayBarrageSetting> r118 = r109.getBarrageSetting();
        if (r118 == null) goto L52;
        Observable<b<ReplayBarrageSetting>> r119 = r118.a();
        if (r119 == null) goto L53;
        Disposable r120 = r119.subscribe(new tl1.b(this));
        if (r120 == null) goto L54;
        Intrinsics.checkNotNullParameter(r120, "$this$bind");
        ReplayBarrageSettingDataContext r121 = r108.getContext();
        if (r121 == null) goto L55;
        i<CompositeDisposable> r122 = r121.getCompositeDisposable();
        if (r122 == null) goto L56;
        CompositeDisposable r123 = r122.getValue();
        if (r123 == null) goto L57;
        r123.add(r120);
        return;
    L57:
        return;
    L56:
        return;
    L55:
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L20:
        r111 = null;
        goto L21
    L5:
        r104 = R.layout.ttlive_layout_replay_barrage_setting_seek_opt;
        goto L6
    }

    public /* synthetic */ AbsReplayDanmakuSettingSeekView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
