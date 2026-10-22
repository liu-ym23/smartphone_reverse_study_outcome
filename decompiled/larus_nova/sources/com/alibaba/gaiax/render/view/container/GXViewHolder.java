package com.alibaba.gaiax.render.view.container;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/alibaba/gaiax/render/view/container/GXViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "childTag", "", "getChildTag", "()Ljava/lang/Object;", "setChildTag", "(Ljava/lang/Object;)V", "childTemplateItem", "Lcom/alibaba/gaiax/template/GXTemplateItem;", "getChildTemplateItem", "()Lcom/alibaba/gaiax/template/GXTemplateItem;", "setChildTemplateItem", "(Lcom/alibaba/gaiax/template/GXTemplateItem;)V", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXViewHolder extends RecyclerView.ViewHolder {
    private Object childTag;
    private GXTemplateItem childTemplateItem;

    public final Object getChildTag() {
        return this.childTag;
    }

    public final GXTemplateItem getChildTemplateItem() {
        return this.childTemplateItem;
    }

    public GXViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }

    public final void setChildTag(Object r100) {
        this.childTag = r100;
    }

    public final void setChildTemplateItem(GXTemplateItem r100) {
        this.childTemplateItem = r100;
    }
}
