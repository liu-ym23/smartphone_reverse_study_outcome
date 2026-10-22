package com.tmall.wireless.tangram.dataparser.concrete;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedanceos.common.R$id;
import com.tmall.wireless.tangram.MVHelper;
import com.tmall.wireless.tangram.core.protocol.ControlBinder;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.structure.ViewCreator;
import com.tmall.wireless.tangram.structure.viewcreator.ViewHolderCreator;
import com.tmall.wireless.tangram.structure.viewcreator.ViewHolderCreator.ViewHolder;
import com.tmall.wireless.tangram.util.Preconditions;

/* JADX INFO: loaded from: classes4.dex */
public class BaseCellBinder<T extends ViewHolderCreator.ViewHolder, V extends View> implements ControlBinder<BaseCell, V> {
    private static final String TAG = "BaseCellBinder";

    @NonNull
    private MVHelper mMVHelper;
    private ViewCreator<V> mViewCreator;
    private ViewHolderCreator<T, V> viewHolderCreator;

    public BaseCellBinder(@NonNull Class<V> r10, @NonNull MVHelper r11) {
        this.mViewCreator = new ViewCreator(r10);
        this.mMVHelper = (MVHelper) Preconditions.checkNotNull(r11, "mvHelper should not be null");
    }

    @Override // com.tmall.wireless.tangram.core.protocol.ViewCreator
    @NonNull
    public V createView(Context r10, ViewGroup r11) {
        ViewHolderCreator<T, V> r12 = this.viewHolderCreator;
        if (r12 == null) goto L5;
        V r13 = (V) r12.create(r10, r11);
    L7:
        if (r13.getId() > 0) goto L9;
        V r14 = r13;
        r14.setId(R$id.TANGRAM_VIEW_CONTAINER_ID);
    L9:
        return r13;
    L5:
        r13 = (V) this.mViewCreator.create(r10, r11);
        goto L7
    }

    @Override // com.tmall.wireless.tangram.core.protocol.ViewMounter
    public /* bridge */ /* synthetic */ void mountView(@NonNull Object r10, @NonNull View r11) {
        mountView((BaseCell) r10, r11);
    }

    @Override // com.tmall.wireless.tangram.core.protocol.ViewMounter
    public /* bridge */ /* synthetic */ void unmountView(@NonNull Object r10, @NonNull View r11) {
        unmountView((BaseCell) r10, r11);
    }

    public void mountView(@NonNull BaseCell r10, @NonNull V r11) {
        this.mMVHelper.mountView(r10, r11);
    }

    public void unmountView(@NonNull BaseCell r10, @NonNull V r11) {
        this.mMVHelper.unMountView(r10, r11);
    }

    public BaseCellBinder(@NonNull ViewHolderCreator<T, V> r10, @NonNull MVHelper r11) {
        this.viewHolderCreator = r10;
        this.mMVHelper = r11;
    }
}
