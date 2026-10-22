package com.bytedance.android.live.emoji.api;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.emoji.EmojiUriNode;
import com.bytedance.android.live.core.widget.GradientEditText;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.interactivity.api.expression.i;
import com.bytedance.android.livesdk.interactivity.api.expression.j;
import com.bytedance.android.livesdk.interactivity.api.expression.k;
import db2.a;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public interface IEmojiService extends IService {
    GradientEditText createEmojiEditText(Context r100, int r101);

    View createEmojiSelectPanel(Context r100, boolean r101, int r102, k r103);

    View createNewEmojiSelectPanel(Context r100, boolean r101, int r102, i r103, j r104);

    View createVSEmojiSelectPanel(Context r100, boolean r101, int r102, int r103, k r104);

    List<BaseEmoji> getRecommendEmojiList();

    String getStringForMaxLength(String r100, int r101);

    /* synthetic */ Spannable parseEmoji(Spannable r100, int r101);

    Spannable parseEmojiForMiniGame(Spannable r100, int r101);

    List<a> parseEmojiIndexList(CharSequence r100);

    List<EmojiUriNode> parseEmojiUriList(CharSequence r100);

    SpannableString parseEmojiV2(SpannableString r100, int r101);

    SpannableString parseEmojiWithFontSize(Context r100, CharSequence r101, float r102, boolean r103);

    Spannable parseOnlyEmoji(Spannable r100, int r101);
}
