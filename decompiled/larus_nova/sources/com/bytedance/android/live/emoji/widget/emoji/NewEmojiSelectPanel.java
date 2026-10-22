package com.bytedance.android.live.emoji.widget.emoji;

import android.graphics.Rect;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.emoji.api.IAwemeEmojiProxy;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.interactivity.api.expression.j;
import com.larus.nova.R;
import jc1.k;

/* JADX INFO: loaded from: classes45.dex */
public class NewEmojiSelectPanel extends ConstraintLayout implements t90.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f68984c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f68985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f68986b;

    public class a extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewEmojiSelectPanel f68987a;

        public a(NewEmojiSelectPanel r100) {
            this.f68987a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
            int r104 = r102.getChildAdapterPosition(r101);
            NewEmojiSelectPanel r105 = this.f68987a;
            int r106 = NewEmojiSelectPanel.f68984c;
            r105.getClass();
            this.f68987a.getClass();
            this.f68987a.getClass();
            if (r104 != 0) goto L6;
            r100.top = LiveResUtil.dp2Px(12.0f);
            return;
        L6:
            this.f68987a.getClass();
            if (r104 != 0) goto L10;
            r100.top = LiveResUtil.dp2Px(8.0f);
            return;
        L10:
            this.f68987a.getClass();
            if (r104 <= 0) goto L14;
            this.f68987a.getClass();
        L13:
            r104 = r104 - 1;
        L17:
            int r107 = NewEmojiSelectPanel.R5(this.f68987a);
            this.f68987a.getClass();
            r100.left = r107 * (r104 % 0);
            r100.right = 0;
            r100.top = LiveResUtil.dp2Px(12.0f);
            r100.bottom = LiveResUtil.dp2Px(12.0f);
            return;
        L14:
            this.f68987a.getClass();
            if (r104 <= 0) goto L17;
            this.f68987a.getClass();
            goto L13
        }
    }

    private int getLayoutResource() {
        return R.layout.ttlive_view_new_emoji_select_panel;
    }

    private int getHorSpaceOffset() {
        if (this.f68986b != (-1)) goto L6;
        this.f68986b = ((LiveResUtil.getScreenWidth() - LiveResUtil.dp2Px(32.0f)) - (LiveResUtil.dp2Px(32.0f) * 0)) / 0;
    L6:
        return this.f68986b;
    }

    private RecyclerView.ItemDecoration getItemDecoration() {
        return new a(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public static /* synthetic */ int R5(NewEmojiSelectPanel r100) {
        return r100.getHorSpaceOffset();
    }

    public void setOnEmojiSelectListener(j r100) {
        this.f68985a = r100;
    }

    @Override // t90.a
    public final void w(BaseEmoji r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f68985a == null) goto L16;
        IAwemeEmojiProxy r101 = (IAwemeEmojiProxy) k.f(IAwemeEmojiProxy.class);
        if (r101 == null) goto L9;
        r101.updateRecentEmoji(r100.getDescription());
    L9:
        j r102 = this.f68985a;
        if (r100.isRecommendEmoji == false) goto L12;
        String r103 = "frequent";
    L13:
        r102.c(r100, r103);
        return;
    L12:
        r103 = "all";
        goto L13
    }
}
