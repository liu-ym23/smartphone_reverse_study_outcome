package com.bytedance.android.live.revlink.impl.multianchor.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0017B\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010B\u001b\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u000f\u0010\u0013B#\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u000f\u0010\u0016J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002R$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/ui/RoundedLabelTitle;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/revlink/impl/multianchor/constants/PlayMode;", "getCurrentPlayMode", "getPlayMode", "Lcom/bytedance/android/live/revlink/impl/multianchor/ui/RoundedLabelTitle$c;", "d", "Lcom/bytedance/android/live/revlink/impl/multianchor/ui/RoundedLabelTitle$c;", "getOnTapPlayModeListener", "()Lcom/bytedance/android/live/revlink/impl/multianchor/ui/RoundedLabelTitle$c;", "setOnTapPlayModeListener", "(Lcom/bytedance/android/live/revlink/impl/multianchor/ui/RoundedLabelTitle$c;)V", "onTapPlayModeListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoundedLabelTitle extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f94756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<PlayMode, View> f94757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PlayMode f94758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f94759d;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoundedLabelTitle f94760a;

        public a(RoundedLabelTitle r100) {
            this.f94760a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            RoundedLabelTitle r101 = this.f94760a;
            PlayMode r102 = PlayMode.PERSONAL_PK;
            c r103 = r101.f94759d;
            if (r103 == null) goto L6;
            r103.a(r102);
            return;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoundedLabelTitle f94761a;

        public b(RoundedLabelTitle r100) {
            this.f94761a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            RoundedLabelTitle r101 = this.f94761a;
            PlayMode r102 = PlayMode.TEAM_PK;
            c r103 = r101.f94759d;
            if (r103 == null) goto L6;
            r103.a(r102);
            return;
        }
    }

    public interface c {
        void a(PlayMode r100);
    }

    public final PlayMode getCurrentPlayMode() {
        return this.f94758c;
    }

    public final c getOnTapPlayModeListener() {
        return this.f94759d;
    }

    public final PlayMode getPlayMode() {
        return this.f94758c;
    }

    public RoundedLabelTitle(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f94756a = new LinkedHashMap();
        HashMap r101 = new HashMap();
        this.f94757b = r101;
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_multi_pk_panel_label_title, this);
        ((TextView) a(R.id.personal_pk)).setOnClickListener(new a(this));
        ((TextView) a(R.id.team_pk)).setOnClickListener(new b(this));
        r101.put(PlayMode.PERSONAL_PK, a(R.id.personal_pk));
        r101.put(PlayMode.TEAM_PK, a(R.id.team_pk));
    }

    public final View a(int r100) {
        if (this.f94756a != null) goto L5;
        this.f94756a = new LinkedHashMap();
    L5:
        View r101 = this.f94756a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f94756a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void b(PlayMode r100) {
        Intrinsics.checkNotNullParameter(r100, Keys.API_EVENT_KEY_PLAY_MODE);
        if (this.f94758c != r100) goto L5;
        return;
    L5:
        this.f94758c = r100;
        TextView r101 = (TextView) a(R.id.personal_pk);
        boolean r102 = false;
        if (r100 != PlayMode.PERSONAL_PK) goto L8;
        boolean r103 = true;
    L9:
        r101.setSelected(r103);
        TextView r104 = (TextView) a(R.id.team_pk);
        if (r100 != PlayMode.TEAM_PK) goto L12;
        r102 = true;
    L12:
        r104.setSelected(r102);
        View r105 = (View) ((HashMap) this.f94757b).get(r100);
        if (r105 == null) goto L16;
        r105.bringToFront();
        return;
    L16:
        return;
    L8:
        r103 = false;
        goto L9
    }

    public final void setOnTapPlayModeListener(c r100) {
        this.f94759d = r100;
    }

    public RoundedLabelTitle(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f94756a = new LinkedHashMap();
        HashMap r102 = new HashMap();
        this.f94757b = r102;
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_multi_pk_panel_label_title, this);
        ((TextView) a(R.id.personal_pk)).setOnClickListener(new a(this));
        ((TextView) a(R.id.team_pk)).setOnClickListener(new b(this));
        r102.put(PlayMode.PERSONAL_PK, a(R.id.personal_pk));
        r102.put(PlayMode.TEAM_PK, a(R.id.team_pk));
    }

    public RoundedLabelTitle(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f94756a = new LinkedHashMap();
        HashMap r103 = new HashMap();
        this.f94757b = r103;
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_multi_pk_panel_label_title, this);
        ((TextView) a(R.id.personal_pk)).setOnClickListener(new a(this));
        ((TextView) a(R.id.team_pk)).setOnClickListener(new b(this));
        r103.put(PlayMode.PERSONAL_PK, a(R.id.personal_pk));
        r103.put(PlayMode.TEAM_PK, a(R.id.team_pk));
    }
}
