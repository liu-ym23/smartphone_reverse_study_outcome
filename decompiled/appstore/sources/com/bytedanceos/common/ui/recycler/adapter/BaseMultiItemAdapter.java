package com.bytedanceos.common.ui.recycler.adapter;

import android.content.Context;
import androidx.annotation.Nullable;
import com.bytedanceos.common.ui.recycler.listener.MultiViewWindowListener;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseMultiItemAdapter<T extends MultiItemEntity> extends BaseProviderMultiAdapter<T> {
    private Context mContext;
    protected MultiViewWindowListener mOnViewWindowListener;
    private String mPage;
    private String mSource;

    public BaseMultiItemAdapter(Context r10, @Nullable List<T> r11) {
        super(r11);
        this.mPage = "";
        this.mSource = "";
        this.mContext = r10;
        init();
    }

    public String getPage() {
        return this.mPage;
    }

    public String getSource() {
        return this.mSource;
    }

    public abstract void init();

    public void setOnViewWindowListener(MultiViewWindowListener r10) {
        this.mOnViewWindowListener = r10;
    }

    public void setPage(String r10) {
        this.mPage = r10;
    }

    public void setSource(String r10) {
        this.mSource = r10;
    }
}
