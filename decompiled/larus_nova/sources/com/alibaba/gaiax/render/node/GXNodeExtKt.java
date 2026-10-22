package com.alibaba.gaiax.render.node;

import android.view.View;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0014\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\t\u001a\u0004\u0018\u00010\u0006*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\n"}, d2 = {"findNodeById", "Lcom/alibaba/gaiax/render/node/GXNode;", "gxNode", "id", "", "findViewById", "Landroid/view/View;", "viewData", "getGXNodeById", "getGXViewById", "GaiaX"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class GXNodeExtKt {
    public static final GXNode getGXNodeById(GXNode r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "id");
        return findNodeById(r100, r100, r101);
    }

    public static final View getGXViewById(GXNode r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "id");
        return findViewById(r100, r100, r101);
    }

    private static final GXNode findNodeById(GXNode r100, GXNode r101, String r102) {
        if (Intrinsics.areEqual(r101.getTemplateNode().getLayer().getId(), r102) == false) goto L5;
        return r101;
    L5:
        List<GXNode> r103 = r101.getChildren();
        if (r103 == null) goto L13;
        Iterator<T> r104 = r103.iterator();
    L9:
        if (r104.hasNext() == false) goto L18;
        GXNode r105 = findNodeById(r100, (GXNode) r104.next(), r102);
        if (r105 == null) goto L9;
        return r105;
    L18:
        return null;
    L13:
        return null;
    }

    private static final View findViewById(GXNode r100, GXNode r101, String r102) {
        if (Intrinsics.areEqual(r101.getTemplateNode().getLayer().getId(), r102) == true) goto L5;
        List<GXNode> r103 = r101.getChildren();
        if (r103 == null) goto L14;
        Iterator<T> r104 = r103.iterator();
    L10:
        if (r104.hasNext() == false) goto L19;
        View r105 = findViewById(r100, (GXNode) r104.next(), r102);
        if (r105 == null) goto L10;
        return r105;
    L19:
        return null;
    L14:
        return null;
    L5:
        return r101.getView();
    }
}
