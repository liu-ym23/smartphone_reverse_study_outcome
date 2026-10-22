package com.tmall.wireless.tangram.structure;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedanceos.common.toolbox.i;
import com.tmall.wireless.tangram.TangramBuilder;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes4.dex */
public class ViewCreator<V extends View> {
    private static final String TAG = "ViewCreator";
    private Class<V> mClz;
    private V view;

    public ViewCreator(@NonNull Class<V> r10) {
        this.mClz = r10;
    }

    private void handleException(Exception r10) {
        if (TangramBuilder.isPrintLog() == false) goto L6;
        i.c(TAG, "Exception when create instance: " + this.mClz.getCanonicalName() + "  message: " + r10.getMessage(), r10);
    L6:
        throw new RuntimeException(r10);
    }

    public V create(@NonNull Context r10, ViewGroup r11) {
        V r12 = this.mClz.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r10});     // Catch: NoSuchMethodException -> L4 InvocationTargetException -> L6 IllegalAccessException -> L8 InstantiationException -> L10
        this.view = r12;     // Catch: NoSuchMethodException -> L4 InvocationTargetException -> L6 IllegalAccessException -> L8 InstantiationException -> L10
        return r12;
    L8:
        e = move-exception;
        handleException(e);
    L17:
        throw new RuntimeException("Failed to create View of class: " + this.mClz.getName());
    L10:
        e = move-exception;
        handleException(e);
    L4:
        e = move-exception;
        handleException(e);
    L6:
        e = move-exception;
        handleException(e);
        goto L17
    }
}
