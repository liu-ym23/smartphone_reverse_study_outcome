package com.drakeet.multitype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends c {
    public b() {
    }

    @Override // com.drakeet.multitype.c
    @NotNull
    public final RecyclerView.ViewHolder onCreateViewHolder(@NotNull Context r10, @NotNull ViewGroup r11) {
        q.h(r10, "context");
        q.h(r11, "parent");
        LayoutInflater r12 = LayoutInflater.from(r10);
        q.c(r12, "LayoutInflater.from(context)");
        return onCreateViewHolder(r12, r11);
    }

    public abstract RecyclerView.ViewHolder onCreateViewHolder(LayoutInflater r10, ViewGroup r11);
}
