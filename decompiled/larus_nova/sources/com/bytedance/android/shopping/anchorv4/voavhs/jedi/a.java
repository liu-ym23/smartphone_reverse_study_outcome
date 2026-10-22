package com.bytedance.android.shopping.anchorv4.voavhs.jedi;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.jedi.arch.JediArchPlugins;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes13.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f169926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DiffUtil.ItemCallback<T> f169927b;

    public a(DiffUtil.ItemCallback r100) {
        this.f169927b = r100;
        this.f169926a = JediArchPlugins.INSTANCE.getStoreExecutorFactory().invoke();
    }
}
