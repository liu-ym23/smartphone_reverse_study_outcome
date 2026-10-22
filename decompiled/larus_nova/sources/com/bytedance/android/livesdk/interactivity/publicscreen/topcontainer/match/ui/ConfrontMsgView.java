package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.config.s51;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import ec2.u0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pa2.a;
import ra2.c;
import ra2.d;
import ra2.e;
import ra2.f;
import ra2.g;
import ra2.h;
import ra2.i;
import ra2.m;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/match/ui/ConfrontMsgView;", "Landroid/widget/FrameLayout;", "Lra2/m;", "Lpa2/a;", "c", "", "setManagerCallBack", "", "isRunning", "Z", "()Z", "setRunning", "(Z)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ConfrontMsgView extends FrameLayout implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f140060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GroupMsgView f140061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GroupMsgView f140062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f140063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i f140064e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f140065f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f140066g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f140067h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e f140068i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f f140069j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public g f140070k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public h f140071l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f140072m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f140073n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f140074o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f140075p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f140076q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final long f140077r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f140078s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final long f140079t;

    public final void setRunning(boolean r100) {
    }

    @Override // ra2.m
    public final boolean a() {
        s51 r100 = u0.f472061a.getValue();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.a() != true) goto L7;
        return true;
    }

    public final void b() {
        GroupMsgView r100 = this.f140061b;
        long r101 = 0;
        if (r100 == null) goto L5;
        long r102 = r100.getCurCombo();
    L6:
        GroupMsgView r103 = this.f140062c;
        if (r103 == null) goto L9;
        r101 = r103.getCurCombo();
    L9:
        GroupMsgView.GroupAnimType r104 = null;
        if (r102 >= r101) goto L29;
        GroupMsgView r105 = this.f140061b;
        if (r105 == null) goto L14;
        GroupMsgView.GroupAnimType r106 = r105.getPos();
    L15:
        GroupMsgView.GroupAnimType r107 = GroupMsgView.GroupAnimType.TOP;
        if (r106 != r107) goto L29;
        GroupMsgView r108 = this.f140062c;
        if (r108 == null) goto L20;
        GroupMsgView.GroupAnimType r109 = r108.getPos();
    L21:
        GroupMsgView.GroupAnimType r110 = GroupMsgView.GroupAnimType.DOWN;
        if (r109 != r110) goto L29;
        GroupMsgView r111 = this.f140061b;
        if (r111 == null) goto L26;
        r111.m(r110);
    L26:
        GroupMsgView r112 = this.f140062c;
        if (r112 == null) goto L48;
        r112.m(r107);
        return;
    L48:
        return;
    L20:
        r109 = null;
        goto L21
    L14:
        r106 = null;
    L29:
        if (r102 <= r101) goto L50;
        GroupMsgView r113 = this.f140061b;
        if (r113 == null) goto L33;
        GroupMsgView.GroupAnimType r114 = r113.getPos();
    L34:
        GroupMsgView.GroupAnimType r115 = GroupMsgView.GroupAnimType.DOWN;
        if (r114 != r115) goto L51;
        GroupMsgView r116 = this.f140062c;
        if (r116 == null) goto L39;
        r104 = r116.getPos();
    L39:
        GroupMsgView.GroupAnimType r117 = GroupMsgView.GroupAnimType.TOP;
        if (r104 != r117) goto L52;
        GroupMsgView r118 = this.f140061b;
        if (r118 == null) goto L44;
        r118.m(r117);
    L44:
        GroupMsgView r119 = this.f140062c;
        if (r119 == null) goto L53;
        r119.m(r115);
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L33:
        r114 = null;
        goto L34
    L50:
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public final void c() {
        GroupMsgView r100 = this.f140061b;
        if (r100 == null) goto L5;
        r100.l();
    L5:
        GroupMsgView r101 = this.f140062c;
        if (r101 == null) goto L8;
        r101.l();
    L8:
        this.f140076q = this.f140072m;
        this.f140064e = null;
        this.f140063d = null;
        removeCallbacks(this.f140066g);
        removeCallbacks(this.f140069j);
        removeCallbacks(this.f140067h);
        removeCallbacks(this.f140068i);
        removeCallbacks(this.f140070k);
        removeCallbacks(this.f140071l);
        clearAnimation();
    }

    public void setManagerCallBack(a r100) {
        Intrinsics.checkNotNullParameter(r100, "c");
        this.f140063d = r100;
    }

    public ConfrontMsgView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f140072m = -1;
        this.f140073n = 1;
        this.f140074o = 2;
        this.f140075p = 3;
        this.f140076q = 0;
        this.f140077r = 3000;
        this.f140078s = 15000;
        this.f140079t = 500;
        this.f140065f = LayoutInflater.from(r100).inflate(R.layout.ttlive_view_confront_msg, this);
        ViewGroup r103 = (ViewGroup) findViewById(R.id.confront_msg_container);
        this.f140060a = r103;
        GroupMsgView r104 = (GroupMsgView) findViewById(R.id.main_group_view);
        this.f140061b = r104;
        GroupMsgView r105 = (GroupMsgView) findViewById(R.id.guest_group_view);
        this.f140062c = r105;
        if (r103 == null) goto L7;
        ViewGroup r106 = UtilityKotlinExtentionsKt.p(r103);
        if (r106 == null) goto L7;
        r106.setClipChildren(false);
    L7:
        i r107 = new i(this);
        this.f140064e = r107;
        if (r104 == null) goto L10;
        r104.setCallback(r107);
    L10:
        if (r105 == null) goto L12;
        r105.setCallback(this.f140064e);
    L12:
        this.f140066g = new c(this);
        this.f140067h = new d(this);
        this.f140068i = new e(this);
        this.f140069j = new f(this);
        this.f140070k = new g(this);
        this.f140071l = new h(this);
    }
}
