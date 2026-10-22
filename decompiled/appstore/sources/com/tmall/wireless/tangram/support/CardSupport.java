package com.tmall.wireless.tangram.support;

import android.view.View;
import android.widget.ImageView;
import com.alibaba.android.vlayout.layout.FixAreaLayoutHelper;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import com.tmall.wireless.tangram.structure.entitycard.EntityCard;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CardSupport {
    public CardSupport() {
    }

    public abstract void onBindBackgroundView(View r10, Card r11);

    public void onBindBackgroundView(ImageView r10, EntityCard r11) {
    }

    public FixAreaLayoutHelper.FixViewAnimatorHelper onGetFixViewAppearAnimator(Card r10) {
        return null;
    }

    public void onUnbindBackgroundView(View r10, Card r11) {
    }
}
