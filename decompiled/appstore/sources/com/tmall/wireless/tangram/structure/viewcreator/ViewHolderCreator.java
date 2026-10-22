package com.tmall.wireless.tangram.structure.viewcreator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.toolbox.i;
import com.tmall.wireless.tangram.TangramBuilder;
import com.tmall.wireless.tangram.structure.viewcreator.ViewHolderCreator.ViewHolder;
import com.tmall.wireless.tangram.util.LogUtils;

/* JADX INFO: loaded from: classes4.dex */
public class ViewHolderCreator<T extends ViewHolder, V extends View> {
    public static final String TAG = "ViewHolderCreator";
    public final Class<T> mClz;
    public final int mLayoutResId;
    public final Class<V> viewClz;

    public static abstract class ViewHolder {
        protected final Context mContext;

        public ViewHolder(Context r10) {
            this.mContext = r10;
        }

        public abstract void onRootViewCreated(View r10);
    }

    public ViewHolderCreator(@LayoutRes int r10, Class<T> r11, Class<V> r12) {
        this.mLayoutResId = r10;
        this.mClz = r11;
        this.viewClz = r12;
    }

    public static ViewHolder getViewHolderFromView(@NonNull View r10) {
        Object r11 = r10.getTag(R$id.TANGRAM_VIEW_HOLDER_TAG);
        if ((r11 instanceof ViewHolder) == true) goto L5;
        return null;
    L5:
        return (ViewHolder) r11;
    }

    public V create(@NonNull Context r10, ViewGroup r11) {
        V r12 = this.viewClz.cast(LayoutInflater.from(r10).inflate(this.mLayoutResId, r11, false));     // Catch: Exception -> L5
        ViewHolder r13 = (T) this.mClz.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r10});
        r13.onRootViewCreated(r12);     // Catch: Exception -> L5
        r12.setTag(R$id.TANGRAM_VIEW_HOLDER_TAG, r13);     // Catch: Exception -> L5
        return r12;
    L5:
        e = move-exception;
        if (TangramBuilder.isPrintLog() == false) goto L13;
        LogUtils.e(TAG, "Exception when inflate layout: " + r10.getResources().getResourceName(this.mLayoutResId) + " stack: " + i.d(e), e);
        return null;
    L13:
        return null;
    }
}
