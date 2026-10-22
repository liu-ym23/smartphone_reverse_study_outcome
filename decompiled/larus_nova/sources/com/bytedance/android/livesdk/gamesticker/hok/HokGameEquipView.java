package com.bytedance.android.livesdk.gamesticker.hok;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.model.i0;
import com.bytedance.android.livesdk.chatroom.model.j0;
import com.bytedance.lighten.core.CircleOptions;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import df6.q;
import df6.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\b\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gamesticker/hok/HokGameEquipView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/livesdk/gamesticker/hok/e;", "Lcom/bytedance/android/livesdk/chatroom/model/j0;", "equipState", "", "setEquipState", "Landroid/view/View;", "getView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HokGameEquipView extends LinearLayout implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f125544a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SmartImageView f125545a;

        public a(SmartImageView r100) {
            Intrinsics.checkNotNullParameter(r100, "equipIconView");
            this.f125545a = r100;
        }
    }

    public HokGameEquipView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public HokGameEquipView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.e
    public final void D2() {
        setEquipState(null);
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.e
    public View getView() {
        return this;
    }

    public final void setEquipState(j0 r110) {
        if (r110 == null) goto L52;
        long r100 = 0;
        if (r110.a() == 0) goto L52;
        if (((ArrayList) this.f125544a).size() != 0) goto L12;
        long r101 = r110.a();
    L10:
        if (r100 >= r101) goto L12;
        SmartImageView r102 = new SmartImageView(getContext());
        List<a> r103 = this.f125544a;
        ArrayList r104 = (ArrayList) r103;
        r104.add(new a(r102));
        r100 = r100 + 1;
    L12:
        ArrayList r105 = new ArrayList();
        List<i0> r111 = r110.b();
        if (r111 != null) goto L15;
        r111 = CollectionsKt.emptyList();
    L15:
        Iterator<i0> r112 = r111.iterator();
    L16:
        int r106 = 0;
        if (r112.hasNext() == false) goto L24;
        i0 r107 = r112.next();
        int r108 = (int) r107.a();
    L19:
        if (r106 >= r108) goto L16;
        String r109 = r107.b();
        if (r109 == null) goto L23;
        r105.add(r109);
    L23:
        r106 = r106 + 1;
        goto L19
    L24:
        int r113 = ((ArrayList) this.f125544a).size();
        int r114 = 0;
    L26:
        if (r114 >= r113) goto L43;
        a r115 = (a) ListProtector.get(this.f125544a, r114);
        if (r114 < r105.size()) goto L30;
        String r116 = null;
    L31:
        r115.getClass();
        if (r116 != null) goto L35;
        u r117 = q.f468227a.load(R.drawable.ttlive_game_hok_empty);
        r117.f468277c = r115.f125545a.getContext();
        r117.f468294t = r115.f125545a;
        r117.b("game_sticker");
        r117.c();
        r115.f125545a.setBackground(s1.m(R.drawable.ttlive_game_hok_empty));
    L41:
        r114 = r114 + 1;
        goto L26
    L35:
        if (r116.length() <= 0) goto L37;
        boolean r118 = true;
    L38:
        if (r118 == false) goto L40;
        u r119 = q.e(r116);
        CircleOptions.a r120 = new CircleOptions.a();
        r120.f254607a = true;
        r119.f468289o = new CircleOptions(r120);
        r119.f468277c = r115.f125545a.getContext();
        r119.f468294t = r115.f125545a;
        r119.b("game_sticker");
        r119.f468283i = R.drawable.ttlive_game_hok_empty;
        r119.d(new f("equip_icon"));
        goto L41
    L40:
        u r121 = q.f468227a.load(R.drawable.ttlive_game_hok_empty);
        r121.f468277c = r115.f125545a.getContext();
        r121.f468294t = r115.f125545a;
        r121.b("game_sticker");
        r121.c();
        r115.f125545a.setBackground(s1.m(R.drawable.ttlive_game_hok_empty));
        goto L41
    L37:
        r118 = false;
        goto L38
    L30:
        r116 = (String) ListProtector.get(r105, r114);
        goto L31
    L43:
        if (getChildCount() != 0) goto L50;
        int r122 = ((ArrayList) this.f125544a).size();
        int r123 = 0;
    L45:
        if (r123 >= r122) goto L50;
        LinearLayout.LayoutParams r124 = new LinearLayout.LayoutParams(s1.f(20.0f), s1.f(20.0f));
        float r125 = 2.0f;
        r124.leftMargin = s1.f(2.0f);
        if (r123 != (((ArrayList) this.f125544a).size() - 1)) goto L49;
        r125 = 12.0f;
    L49:
        r124.rightMargin = s1.f(r125);
        r124.gravity = 16;
        addView(((a) ListProtector.get(this.f125544a, r123)).f125545a, r124);
        r123 = r123 + 1;
    L50:
        setVisibility(0);
        return;
    L52:
        setVisibility(8);
    }

    public HokGameEquipView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f125544a = new ArrayList();
    }

    public /* synthetic */ HokGameEquipView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
