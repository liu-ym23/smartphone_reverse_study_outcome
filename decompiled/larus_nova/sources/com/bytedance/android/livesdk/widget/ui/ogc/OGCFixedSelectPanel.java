package com.bytedance.android.livesdk.widget.ui.ogc;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdk.interactivity.api.expression.j;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.viewholder.OGCFixedEmojiViewBinder;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes11.dex */
public final class OGCFixedSelectPanel extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.api.quickcomment.c f162180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f162181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MultiTypeAdapter f162182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j f162183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f162184e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f162185f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f162186g;

    public static final class a {
    }

    static {
    }

    private final int getHorSpaceOffset() {
        if (this.f162186g != (-1)) goto L10;
        if (PadConfigUtils.c() == false) goto L7;
        int r100 = UtilityKotlinExtentionsKt.i(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS);
    L8:
        int r101 = (r100 - s1.f(32.0f)) - (this.f162185f * s1.f(80.0f));
        int r102 = this.f162185f;
        this.f162186g = r101 / (r102 * (r102 - 1));
        goto L10
    L7:
        r100 = s1.y();
    L10:
        return this.f162186g;
    }

    private final RecyclerView.ItemDecoration getItemDecoration() {
        return new AnonymousClass1(this);
    }

    public final com.bytedance.android.livesdk.interactivity.api.quickcomment.c getOgcFixedChatInfo() {
        return this.f162180a;
    }

    public OGCFixedSelectPanel(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f162184e = new CompositeDisposable();
        this.f162185f = 4;
        this.f162186g = -1;
        LayoutInflater.from(r100).inflate(R.layout.ttlive_view_ogc_fixed_select_panel, this);
    }

    public static final /* synthetic */ int a(OGCFixedSelectPanel r100) {
        return r100.getHorSpaceOffset();
    }

    public final void b(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = 4;
    L5:
        this.f162185f = r101;
        this.f162181b = (RecyclerView) findViewById(R.id.ogc_fixed_emoji_list);
        MultiTypeAdapter r102 = new MultiTypeAdapter();
        r102.z2(com.bytedance.android.livesdk.interactivity.api.quickcomment.a.class, new OGCFixedEmojiViewBinder(new OGCFixedSelectPanel$initView$1$1(this)));
        Unit r103 = Unit.INSTANCE;
        this.f162182c = r102;
        RecyclerView r104 = this.f162181b;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L8:
        MultiTypeAdapter r105 = this.f162182c;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("multiAdapter");
    L11:
        r104.setAdapter(r105);
        r104.setLayoutManager(new SSGridLayoutManager(r104.getContext(), this.f162185f, 1));
        r104.addItemDecoration(getItemDecoration());
        r104.setHasFixedSize(true);
        com.bytedance.android.livesdk.interactivity.api.quickcomment.c r106 = this.f162180a;
        if (r106 == null) goto L28;
        List<com.bytedance.android.livesdk.interactivity.api.quickcomment.a> r107 = r106.fixedEmojiList;
        if (r107 != null) goto L16;
        return;
    L16:
        if ((!r107.isEmpty()) != true) goto L30;
        MultiTypeAdapter r108 = this.f162182c;
        if (r108 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("multiAdapter");
    L20:
        List<com.bytedance.android.livesdk.interactivity.api.quickcomment.a> r109 = r106.fixedEmojiList;
        if (r109 != null) goto L23;
        r109 = CollectionsKt.emptyList();
    L23:
        r108.f513437a = r109;
        MultiTypeAdapter r110 = this.f162182c;
        if (r110 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("multiAdapter");
    L26:
        r110.notifyDataSetChanged();
        return;
    L30:
        return;
    L28:
        return;
    L4:
        r101 = 8;
        goto L5
    }

    public final void setOgcFixedChatInfo(com.bytedance.android.livesdk.interactivity.api.quickcomment.c r100) {
        this.f162180a = r100;
    }

    public final void setOnSubscribeEmojiSendListener(j r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f162183d = r100;
    }
}
