package com.bytedance.android.livesdk.interactivity.service.textrender.core;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.CharacterStyle;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, n> f141052a;

    public x() {
        this.f141052a = new HashMap();
    }

    public final void b(n r100) {
        Intrinsics.checkNotNullParameter(r100, "pieceRender");
        Map<Integer, n> r101 = this.f141052a;
        HashMap r102 = (HashMap) r101;
        r102.put(Integer.valueOf(r100.f141028a.getPieceType()), r100);
    }

    public static List a(SpannableString r100, tb2.c r101, Drawable r102, int r103, int r110) {
        Intrinsics.checkNotNullParameter(r100, "spannable");
        Intrinsics.checkNotNullParameter(r101, "renderPiece");
        ArrayList r104 = new ArrayList();
        Iterator r105 = ((HashSet) r.f141031c).iterator();
    L4:
        if (r105.hasNext() == false) goto L22;
        List<CharacterStyle> r106 = ((e) r105.next()).a(r101, r102);
        if (r106 == null) goto L4;
        r104.addAll(r106);
        Iterator<CharacterStyle> r107 = r106.iterator();
    L9:
        if (r107.hasNext() == false) goto L4;
        CharacterStyle r108 = r107.next();
        if ((r108 instanceof com.bytedance.android.livesdk.widget.a) == false) goto L21;
        com.bytedance.android.livesdk.widget.a r109 = (com.bytedance.android.livesdk.widget.a) r108;
        ITextPieceImage r111 = r101.getImageValue();
        if (r111 == null) goto L19;
        py.k r112 = r111.getImageModel();
        if (r112 == null) goto L19;
        py.k.b r113 = r112.getImageContent();
        if (r113 == null) goto L19;
        String r114 = r113.getAccessibilityText();
    L20:
        r109.f161402a = r114;
    L19:
        r114 = null;
    L21:
        r100.setSpan(r108, r103, r110, 33);
        goto L9
    L22:
        return r104;
    }
}
