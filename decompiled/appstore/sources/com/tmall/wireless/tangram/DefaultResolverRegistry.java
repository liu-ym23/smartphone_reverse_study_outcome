package com.tmall.wireless.tangram;

import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import com.tmall.wireless.tangram.dataparser.concrete.BaseCardBinderResolver;
import com.tmall.wireless.tangram.dataparser.concrete.BaseCellBinder;
import com.tmall.wireless.tangram.dataparser.concrete.BaseCellBinderResolver;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import com.tmall.wireless.tangram.dataparser.concrete.CardResolver;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.structure.viewcreator.ViewHolderCreator;

/* JADX INFO: loaded from: classes4.dex */
public class DefaultResolverRegistry {
    final BaseCardBinderResolver mDefaultCardBinderResolver;
    final CardResolver mDefaultCardResolver;
    final BaseCellBinderResolver mDefaultCellBinderResolver;
    MVHelper mMVHelper;
    SparseArray<ViewHolderCreator> viewHolderMap;

    public DefaultResolverRegistry() {
        CardResolver r10 = new CardResolver();
        this.mDefaultCardResolver = r10;
        this.mDefaultCellBinderResolver = new BaseCellBinderResolver();
        this.mDefaultCardBinderResolver = new BaseCardBinderResolver(r10);
        this.viewHolderMap = new SparseArray(64);
    }

    public BaseCardBinderResolver getDefaultCardBinderResolver() {
        return this.mDefaultCardBinderResolver;
    }

    public CardResolver getDefaultCardResolver() {
        return this.mDefaultCardResolver;
    }

    public BaseCellBinderResolver getDefaultCellBinderResolver() {
        return this.mDefaultCellBinderResolver;
    }

    public MVHelper getMVHelper() {
        return this.mMVHelper;
    }

    public void registerCard(int r10, Class<? extends Card> r11) {
        this.mDefaultCardResolver.register(r10, r11);
    }

    public <V extends View> void registerCell(int r10, @NonNull Class<? extends BaseCell> r11, @NonNull Class<V> r12) {
        registerCell(r10, r12);
        this.mMVHelper.resolver().registerCompatible(r10, r11);
    }

    public void setMVHelper(MVHelper r10) {
        this.mMVHelper = r10;
    }

    public <V extends View> void registerCell(int r10, @NonNull Class<? extends BaseCell> r11, @NonNull ViewHolderCreator r12) {
        this.viewHolderMap.put(r10, r12);
        registerCell(r10, r11, r12.viewClz);
    }

    public <V extends View> void registerCell(int r10, @NonNull Class<V> r11) {
        if (this.viewHolderMap.get(r10) != null) goto L5;
        this.mDefaultCellBinderResolver.register(r10, new BaseCellBinder(r11, this.mMVHelper));
    L6:
        this.mMVHelper.resolver().register(r10, r11);
        return;
    L5:
        ViewHolderCreator r12 = this.viewHolderMap.get(r10);
        this.mDefaultCellBinderResolver.register(r10, new BaseCellBinder(r12, this.mMVHelper));
        goto L6
    }
}
