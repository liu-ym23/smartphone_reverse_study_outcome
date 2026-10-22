package com.bytedance.android.livesdk.interactivity.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.GradientEditText;
import com.bytedance.android.livehostapi.business.IMiddleWareHostEmoji;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.adapter.EmojiPanelAdapter;
import com.bytedance.android.livesdk.chatroom.ui.RtlViewPagerShower;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdk.interactivity.api.expression.MentionSpan;
import com.bytedance.android.livesdk.mention.MentionEditText;
import com.bytedance.android.livesdk.widget.EmojiEditView;
import com.bytedance.android.livesdk.widget.EmojiSelectPanel;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public class ExpressionService implements IExpressionService {
    public ExpressionService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IExpressionService
    public GradientEditText createEmojiEditText(Context r100, int r101) {
        EmojiEditView r102 = new EmojiEditView(r100);
        r102.setTextEmojiSize(r101);
        return r102;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IExpressionService
    public View createExpressionPanelV3(Context r100, com.bytedance.android.livesdk.interactivity.api.expression.a r101) {
        com.bytedance.android.livesdk.widget.newboard.c r102 = new com.bytedance.android.livesdk.widget.newboard.c(r100, r101);
        r102.setOnCommentSendDelegate(r101.f133196g);
        return r102;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IExpressionService
    public GradientEditText createEmojiEditText(Context r110, int r111, com.bytedance.android.livesdk.interactivity.api.expression.c r112) {
        MentionEditText r100 = new MentionEditText(r110);
        r100.setTextEmojiSize(r111);
        if (r112 == null) goto L27;
        Intrinsics.checkNotNullParameter(r100, "$this$addMentionText");
        Intrinsics.checkNotNullParameter(r112, "param");
        String r101 = r112.f133200d;
        String r102 = r112.f133199c;
        String r113 = r112.f133198b;
        int r114 = r100.getSelectionStart();
        Editable r103 = r100.getText();
        if (r103 == null) goto L27;
        SpannableString r104 = new SpannableString("@" + r113);
        r104.setSpan(new MentionSpan(new com.bytedance.android.livesdk.interactivity.api.expression.d(r112.f133197a, r104.toString(), r102, r101, r112.f133201e, false)), 0, r104.length(), 33);
        if (r100.getMentionTextTypeface() == 0) goto L11;
        r104.setSpan(new StyleSpan(r100.getMentionTextTypeface()), 0, r104.length(), 33);
    L11:
        if (TextUtils.isEmpty(r103) == false) goto L13;
        r103.insert(0, r104);
        r103.append(" ");
        goto L27
    L13:
        int r115 = r103.length();
        if (r114 < 0) goto L27;
        if (r115 < r114) goto L27;
        if (r114 <= 0) goto L21;
        int r105 = r114 - 1;
        if (TextUtils.equals(r103.subSequence(r105, r114), "@") == false) goto L21;
        r103.delete(r105, r114);
        r115 = r115 - 1;
        r114 = r105;
    L21:
        int r116 = Math.min(r115, Math.max(0, r114));
        r103.insert(r116, r104);
        if (r103.length() > r116) goto L24;
    L26:
        r103.insert(Math.min(r116 + r104.length(), r103.length()), " ");
        goto L27
    L24:
        if (r103.length() >= (r104.length() + r116)) goto L26;
    L27:
        return r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IExpressionService
    public com.bytedance.android.livesdk.interactivity.api.expression.b createSimpleExpressionPanelV3(Context r100, boolean r101, com.bytedance.android.livesdk.interactivity.api.expression.j r102) {
        com.bytedance.android.livesdk.widget.newboard.f r103 = new com.bytedance.android.livesdk.widget.newboard.f(r100, r101);
        r103.setOnCommentSendDelegate(r102);
        return r103;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IExpressionService
    public View createEmojiSelectPanel(Context r110, boolean r111, int r112, com.bytedance.android.livesdk.interactivity.api.expression.k r113) {
        EmojiSelectPanel r100 = new EmojiSelectPanel(r110);
        r100.setOnEmojiSelectListener(r113);
        if (r111 == false) goto L5;
        int r114 = 3;
    L6:
        r100.f160854h = r114;
        if (r111 == false) goto L9;
        int r115 = 6;
    L10:
        r100.f160855i = r115;
        r100.f160856j = r114 * r115;
        r100.f160857k = r112;
        r100.f160847a = (RecyclerView) r100.findViewById(R.id.list);
        r100.f160849c = (RtlViewPagerShower) r100.findViewById(R.id.pager_bottom_shower);
        EmojiPanelAdapter r116 = new EmojiPanelAdapter(r100.getContext(), r100.f160854h, r100.f160855i, r100.f160857k);
        r100.f160848b = r116;
        r116.f103067i = r100;
        r100.f160847a.setAdapter(r116);
        int r117 = 0;
        r100.f160847a.setLayoutManager(new SSGridLayoutManager(r100.getContext(), r100.f160854h, 0));
        r100.f160847a.setHasFixedSize(true);
        r100.f160847a.setItemViewCacheSize(36);
        com.bytedance.android.livesdk.widget.o r118 = new com.bytedance.android.livesdk.widget.o(r100);
        r118.h(r100.f160854h);
        r118.g(r100.f160855i);
        r118.attachToRecyclerView(r100.f160847a);
        r100.f160847a.addOnScrollListener(new com.bytedance.android.livesdk.widget.p(r100));
        r100.f160849c.setMargin((int) r100.getContext().getResources().getDimension(R.dimen.ttlive_pager_shower_margin));
        RtlViewPagerShower r119 = r100.f160849c;
        Drawable r120 = r100.getContext().getResources().getDrawable(R.drawable.ttlive_emoji_panel_dot_normal);
        Drawable r101 = r100.getContext().getResources().getDrawable(R.drawable.ttlive_emoji_panel_dot_selected);
        r119.f112524c = r120;
        r119.f112525d = r101;
        ab2.b.a().f2471a.getClass();
        IMiddleWareHostEmoji r121 = (IMiddleWareHostEmoji) jc1.k.f(IMiddleWareHostEmoji.class);
        if (r121 == null) goto L13;
        List<BaseEmoji> r122 = r121.loadAllBaseEmoji();
    L15:
        if (Lists.isEmpty(r122) == true) goto L46;
        EmojiPanelAdapter r123 = r100.f160848b;
        r123.getClass();
        if (Lists.isEmpty(r122) == false) goto L20;
        int r102 = 0;
    L25:
        int r103 = r123.f103064f * r102;
        int r104 = 1;
    L26:
        if (r104 > r102) goto L31;
        int r105 = (r123.f103064f * r104) - 1;
        if (r105 >= r122.size()) goto L30;
        ListProtector.add(r122, r105, new com.bytedance.android.livesdk.model.a(r123.f103066h));
    L30:
        r104 = r104 + 1;
        goto L26
    L31:
        BaseEmoji[] r106 = new BaseEmoji[r103];
        int r107 = 0;
    L32:
        if (r107 >= r103) goto L34;
        r106[r107] = new com.bytedance.android.livesdk.model.c();
        r107 = r107 + 1;
        goto L32
    L34:
        Iterator<BaseEmoji> r108 = r122.iterator();
    L36:
        if (r108.hasNext() == false) goto L41;
        BaseEmoji r109 = r108.next();
        int r124 = r123.f103062d;
        int r125 = r123.f103063e;
        int r126 = r123.f103064f;
        int r127 = r117 % r126;
        int r128 = ((r127 / r125) + 1) - 1;
        int r129 = ((r124 * (r127 - (r125 * r128))) + r128) + ((r117 / r126) * r126);
        r117 = r117 + 1;
        if (r129 >= r103) goto L36;
        r106[r129] = r109;
        goto L36
    L41:
        r106[r103 - 1] = new com.bytedance.android.livesdk.model.a(r123.f103066h);
        List r130 = Arrays.asList(r106);
        ((ArrayList) r123.f103061c).clear();
        if (r130 == null) goto L45;
        ((ArrayList) r123.f103061c).addAll(r130);
    L45:
        r100.f160848b.notifyDataSetChanged();
        int r131 = (r122.size() / r100.f160856j) + 1;
        r100.f160853g = r131;
        r100.f160849c.a(r131, r100.f160851e);
        goto L46
    L20:
        int r132 = r122.size() / (r123.f103064f - 1);
        if ((r122.size() % (r123.f103064f - 1)) <= 0) goto L23;
        int r133 = 1;
    L24:
        r102 = r132 + r133;
        goto L25
    L23:
        r133 = 0;
    L46:
        return r100;
    L13:
        r122 = new ArrayList();
        goto L15
    L9:
        r115 = 12;
        goto L10
    L5:
        r114 = 2;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IExpressionService
    public View createNewEmojiSelectPanel(Context r100, boolean r101, int r102, com.bytedance.android.livesdk.interactivity.api.expression.i r103, com.bytedance.android.livesdk.interactivity.api.expression.j r104) {
        com.bytedance.android.livesdk.widget.board.e r105 = new com.bytedance.android.livesdk.widget.board.e(r100, r102, r101, r103);
        r105.setOnCommentSendDelegate(r104);
        return r105;
    }
}
