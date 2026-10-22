package com.bytedance.android.livesdk.widget.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.data.activityemoji.ActivityEmojiGroup;
import com.bytedance.android.live.base.model.data.activityemoji.EffectiveActivityEmojiGroup;
import com.bytedance.android.live.base.model.message.i6;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdk.interactivity.api.expression.h;
import com.bytedance.android.livesdk.interactivity.api.expression.i;
import com.bytedance.android.livesdk.interactivity.api.expression.j;
import com.bytedance.android.livesdk.interactivity.api.input.ActivityEmojiAutoTestUtil;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdk.interactivity.service.emoji.recent.EmojiLocalRecentManager;
import com.bytedance.android.livesdk.interactivity.service.emoji.recent.c;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdk.viewholder.EmojiTitleViewBinder;
import com.bytedance.android.livesdk.viewholder.LowPcuGuideChatDataViewBinder;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import ec2.t0;
import fc2.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import me.drakeet.multitype.MultiTypeAdapter;
import tv2.d;
import tv2.e;

/* JADX INFO: loaded from: classes11.dex */
public class NewEmojiSelectPanelV3 extends ConstraintLayout implements jf2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MultiTypeAdapter f162159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f162160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f162161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f162162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f162163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f162164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f162165g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f162166h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f162167i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f162168j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f162169k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public EmojiLocalRecentManager f162170l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final i f162171m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f162172n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AnimatorSet f162173o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final a f162174p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f162175q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f162176r;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewEmojiSelectPanelV3 f162177a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.widget.ui.NewEmojiSelectPanelV3$a$a, reason: collision with other inner class name */
        public class C2480a implements Animator.AnimatorListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f162178a;

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator r100) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator r100) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator r100) {
            }

            public C2480a(a r100) {
                this.f162178a = r100;
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                UIUtils.setViewVisibility(this.f162178a.f162177a.f162172n, 8);
            }
        }

        public final void a() {
            TextView r100 = this.f162177a.f162172n;
            if (r100 == null) goto L6;
            int r101 = r100.getHeight();
            ObjectAnimator r102 = ObjectAnimator.ofFloat(this.f162177a.f162172n, "alpha", new float[]{1.0f, 0.0f}).setDuration(500);
            ValueAnimator r103 = ValueAnimator.ofInt(new int[]{r101, 0}).setDuration(500);
            r103.addUpdateListener(new e(this));
            this.f162177a.f162173o.addListener(new C2480a(this));
            this.f162177a.f162173o.playTogether(new Animator[]{r102, r103});
            this.f162177a.f162173o.start();
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(NewEmojiSelectPanelV3 r100) {
            this.f162177a = r100;
        }
    }

    public class b extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewEmojiSelectPanelV3 f162179a;

        public b(NewEmojiSelectPanelV3 r100) {
            this.f162179a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void getItemOffsets(Rect r100, View r101, RecyclerView r110, RecyclerView.State r111) {
            int r102 = r110.getChildAdapterPosition(r101);
            NewEmojiSelectPanelV3 r112 = this.f162179a;
            int r113 = r112.f162165g;
            if (r113 == (-1)) goto L5;
        L12:
            if (r102 != r113) goto L15;
            r100.top = s1.f(12.0f);
            return;
        L15:
            int r103 = r112.f162167i;
            if (r102 != r103) goto L19;
            r100.top = s1.f(8.0f);
            return;
        L19:
            int r104 = r112.f162169k;
            if (r102 != r104) goto L23;
            r100.top = s1.f(8.0f);
            return;
        L23:
            int r105 = r112.f162168j;
            if (r102 != r105) goto L27;
            r100.top = s1.f(8.0f);
            return;
        L27:
            int r106 = r112.f162166h;
            if (r102 != r106) goto L32;
            r100.top = s1.f(8.0f);
            return;
        L32:
            if (r102 > r106) goto L34;
            if (r102 > r105) goto L38;
            if (r102 > r103) goto L42;
            if (r102 <= r104) goto L46;
            r100.right = NewEmojiSelectPanelV3.R5(r112, false);
        L50:
            r100.left = 0;
            r100.top = s1.f(12.0f);
            r100.bottom = s1.f(12.0f);
            return;
        L46:
            if (r102 <= r113) goto L50;
            if (((r102 - r113) % r112.f162162d) == 0) goto L50;
            r100.right = NewEmojiSelectPanelV3.R5(r112, true);
            goto L50
        L42:
            if (((r102 - r103) % r112.f162164f) == 0) goto L50;
            r100.right = NewEmojiSelectPanelV3.R5(r112, false);
            goto L50
        L38:
            if (((r102 - r105) % r112.f162162d) == 0) goto L50;
            r100.right = NewEmojiSelectPanelV3.R5(r112, true);
            goto L50
        L34:
            if (((r102 - r106) % r112.f162162d) == 0) goto L50;
            r100.right = NewEmojiSelectPanelV3.R5(r112, true);
            goto L50
        L5:
            if (r112.f162166h != (-1)) goto L12;
            if (r112.f162167i != (-1)) goto L12;
            if (r112.f162168j != (-1)) goto L12;
            if (r112.f162169k == (-1)) goto L50;
            goto L12
        }
    }

    private int getLayoutResource() {
        return R.layout.ttlive_view_new_emoji_select_panel;
    }

    private RecyclerView.ItemDecoration getItemDecoration() {
        return new b(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f162170l == null) goto L13;
        ArrayList r100 = new ArrayList();
        LinkedHashMap<String, com.bytedance.android.livesdk.interactivity.service.emoji.recent.b> r101 = EmojiLocalRecentManager.f140850e;
        if (r101 == null) goto L11;
        Iterator<Map.Entry<String, com.bytedance.android.livesdk.interactivity.service.emoji.recent.b>> r102 = r101.entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L11;
        r100.add(r102.next().getValue());
    L11:
        if ((!r100.isEmpty()) == false) goto L13;
        com.bytedance.android.livesdk.sharedpref.e<c> r103 = EmojiLocalRecentManager.f140846a;
        c r104 = new c(r100);
        r103.getClass();
        f.d(r103, r104);
    L13:
        MainThreadPostUtils.d(this.f162174p);
        this.f162173o.cancel();
        this.f162173o.removeAllListeners();
    }

    @Override // jf2.b
    public final void S2(com.bytedance.android.live.base.model.data.activityemoji.b r100) {
        if (r100 == null) goto L8;
        j r101 = this.f162160b;
        if (r101 == null) goto L9;
        r101.f(r100);
        return;
    L9:
        return;
    }

    public final void S5(boolean r110) {
        this.f162161c = r110;
        int r100 = 7;
        if (r110 == false) goto L5;
        int r101 = 7;
    L6:
        this.f162162d = r101;
        if (r110 == false) goto L9;
        int r102 = 4;
    L10:
        this.f162164f = r102;
        if (r110 == false) goto L13;
        int r111 = 28;
    L14:
        this.f162163e = r111;
        RecyclerView r112 = (RecyclerView) findViewById(R.id.list);
        MultiTypeAdapter r103 = new MultiTypeAdapter();
        this.f162159a = r103;
        r103.z2(BaseEmoji.class, new com.bytedance.android.livesdk.viewholder.c(this));
        this.f162159a.z2(com.bytedance.android.live.base.model.data.activityemoji.b.class, new com.bytedance.android.livesdk.viewholder.a(this));
        this.f162159a.z2(com.bytedance.android.livesdk.model.e.class, new EmojiTitleViewBinder());
        this.f162159a.z2(i6.class, new LowPcuGuideChatDataViewBinder(this));
        this.f162159a.z2(com.bytedance.android.livesdk.interactivity.api.emoji.a.class, new com.bytedance.android.livesdk.viewholder.e(this));
        r112.setAdapter(this.f162159a);
        SSGridLayoutManager r104 = new SSGridLayoutManager(getContext(), this.f162163e, 1);
        r104.setSpanSizeLookup(new tv2.f(this));
        r112.setLayoutManager(r104);
        r112.addItemDecoration(getItemDecoration());
        r112.setHasFixedSize(true);
        TextView r113 = (TextView) findViewById(R.id.tv_panel_hint);
        this.f162172n = r113;
        if (r113 == null) goto L24;
        boolean r114 = this.f162171m.f133223i;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r105 = l42.a.f507330q;
        int r106 = r105.getValue().intValue();
        if (r114 == false) goto L23;
        if (r106 >= 3) goto L23;
        if (this.f162161c == false) goto L23;
        UIUtils.setViewVisibility(this.f162172n, 0);
        f.d(r105, Integer.valueOf(r106 + 1));
        MainThreadPostUtils.c(this.f162174p, 3000);
    L23:
        UIUtils.setViewVisibility(this.f162172n, 8);
    L24:
        i r115 = this.f162171m;
        if (r115 != null) goto L27;
    L29:
        findViewById(R.id.emoji_delete_btn).setVisibility(8);
    L30:
        this.f162170l = EmojiLocalRecentManager.f140851f;
        List r116 = EmojiLocalRecentManager.a();
        if (this.f162161c == true) goto L34;
        r100 = 12;
    L34:
        ArrayList r107 = new ArrayList();
        List<BaseEmoji> r108 = h.b(r100);
        if (r108.size() < r100) goto L37;
        this.f162165g = 0;
        ListProtector.add(r107, 0, new com.bytedance.android.livesdk.model.e(s1.B(R.string.ttlive_emoji_recent)));
        r107.addAll(r108.subList(0, r100));
    L38:
        List<com.bytedance.android.livesdk.interactivity.api.emoji.a> r109 = null;
        if (q.f() == null) goto L41;
        List<com.bytedance.android.live.base.model.message.h> r117 = q.f().a();
    L43:
        if (this.f162171m.f133222h == false) goto L65;
        g.f476335a.getClass();
        if (t0.f472058a.getValue().a() == false) goto L65;
        if (q.k() == true) goto L65;
        String r118 = q.e();
        if (r118 != null) goto L51;
    L52:
        if (r117 == null) goto L61;
        Iterator<com.bytedance.android.live.base.model.message.h> r119 = r117.iterator();
    L55:
        if (r119.hasNext() == false) goto L61;
        com.bytedance.android.live.base.model.message.h r120 = r119.next();
        if (r120 == null) goto L55;
        if (r120.getType() != 2) goto L55;
        r119.remove();
    L61:
        if (r117 == null) goto L65;
        if (r117.isEmpty() == true) goto L65;
        int r121 = r107.size();
        this.f162169k = r121;
        ListProtector.add(r107, r121, new com.bytedance.android.livesdk.model.e(s1.B(R.string.ttlive_emoji_guide_chat)));
        i6 r122 = new i6();
        r122.c(r117);
        r107.add(r122);
        goto L65
    L51:
        if (r118.isEmpty() == false) goto L61;
    L65:
        EffectiveActivityEmojiGroup r123 = q.c();
        if (this.f162171m.f133221g == false) goto L70;
        if (r123 == null) goto L70;
        ActivityEmojiGroup r124 = r123.getEmojiGroup();
        this.f162167i = r107.size();
        ListProtector.add(r107, this.f162167i, new com.bytedance.android.livesdk.model.e(r124.getName(), r124.getTagIcon()));
        r107.addAll(r124.getActivityEmojiList());
    L70:
        if (v.a() == false) goto L78;
        ActivityEmojiAutoTestUtil.f133250c.getClass();
        if (ActivityEmojiAutoTestUtil.f133248a == false) goto L78;
        if (this.f162171m.f133221g == false) goto L77;
        if (r123 == null) goto L77;
        ActivityEmojiAutoTestUtil.a(r123.getEmojiGroup().getActivityEmojiList(), "EmojiArea");
    L77:
        ActivityEmojiAutoTestUtil.a(null, "EmojiArea");
    L78:
        com.bytedance.android.livesdk.interactivity.api.h r125 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
        if (r125 == null) goto L86;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.emoji.e> r126 = r125.getFusionEmojiManager();
        if (r126 == null) goto L86;
        com.bytedance.android.livesdk.interactivity.api.emoji.e r127 = r126.getValue();
        if (r127 == null) goto L86;
        r109 = r127.f();
    L86:
        if (this.f162171m.f133223i == false) goto L91;
        if (r109 == null) goto L91;
        if (r109.isEmpty() == true) goto L91;
        int r128 = r107.size();
        this.f162168j = r128;
        ListProtector.add(r107, r128, new com.bytedance.android.livesdk.model.e(s1.B(R.string.ttlive_emoji_fusion_title)));
        r107.addAll(r109);
    L91:
        int r129 = r107.size();
        this.f162166h = r129;
        ListProtector.add(r107, r129, new com.bytedance.android.livesdk.model.e(s1.B(R.string.ttlive_emoji_all)));
        r107.addAll(r116);
        if (Lists.isEmpty(r107) == true) goto L103;
        MultiTypeAdapter r130 = this.f162159a;
        r130.f513437a = r107;
        r130.notifyDataSetChanged();
        return;
    L103:
        return;
    L41:
        r117 = null;
        goto L43
    L37:
        ALogger.e("NewEmojiSelectPanelV3", "not enough data!!!");
        goto L38
    L27:
        if (r115.f133218d == false) goto L29;
        findViewById(R.id.emoji_delete_btn_bg).setVisibility(0);
        findViewById(R.id.emoji_delete_btn).setVisibility(0);
        findViewById(R.id.emoji_delete_btn).setOnClickListener(new d(this));
        goto L30
    L13:
        r111 = 84;
        goto L14
    L9:
        r102 = 7;
        goto L10
    L5:
        r101 = 12;
        goto L6
    }

    @Override // jf2.b
    public final void W3(com.bytedance.android.livesdk.interactivity.api.emoji.a r100) {
        if (r100 == null) goto L8;
        j r101 = this.f162160b;
        if (r101 == null) goto L9;
        r101.h(r100);
        return;
    L9:
        return;
    }

    public void setOnEmojiSelectListener(j r100) {
        this.f162160b = r100;
    }

    @Override // jf2.b
    public final void w(BaseEmoji r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f162160b != null) goto L7;
        return;
    L7:
        if (this.f162170l == null) goto L9;
        EmojiLocalRecentManager.d(r100);
    L9:
        j r101 = this.f162160b;
        if (r100.isLatestUseEmoji == false) goto L12;
        String r102 = "frequent";
    L13:
        r101.c(r100, r102);
        return;
    L12:
        r102 = "all";
        goto L13
    }

    public NewEmojiSelectPanelV3(Context r100, i r101) {
        super(r100);
        this.f162165g = -1;
        this.f162166h = -1;
        this.f162167i = -1;
        this.f162168j = -1;
        this.f162169k = -1;
        this.f162173o = new AnimatorSet();
        this.f162174p = new a(this);
        this.f162175q = -1;
        this.f162176r = -1;
        this.f162171m = r101;
        LayoutInflater.from(r100).inflate(getLayoutResource(), this);
    }

    public static int R5(NewEmojiSelectPanelV3 r100, boolean r101) {
        if (r101 == false) goto L4;
        int r102 = r100.f162162d;
    L5:
        if (r101 == false) goto L7;
        int r103 = r100.f162175q;
    L8:
        if (r101 == false) goto L10;
        int r104 = 32;
    L12:
        if (r103 != (-1)) goto L18;
        r103 = ((s1.y() - s1.f(32.0f)) - (s1.f(r104) * r102)) / (r102 - 1);
        if (r101 == false) goto L16;
        r100.f162175q = r103;
        goto L18
    L16:
        int r105 = Math.max(r103, s1.f(6.0f));
        r100.f162176r = r105;
        return r105;
    L18:
        return r103;
    L10:
        r104 = 81;
        goto L12
    L7:
        r103 = r100.f162176r;
        goto L8
    L4:
        r102 = r100.f162164f;
        goto L5
    }

    @Override // jf2.b
    public final void t1(com.bytedance.android.live.base.model.message.h r100, String r101) {
        if (r100 == null) goto L8;
        j r102 = this.f162160b;
        if (r102 == null) goto L9;
        r102.e(r100, r101);
        return;
    L9:
        return;
    }
}
