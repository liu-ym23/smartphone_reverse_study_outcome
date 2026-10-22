package com.stepos.ailauncher.chat.view;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.core.ability.AbilityType;
import kotlin.Metadata;
import r9.C5227b;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a1\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a1\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroid/view/View;", AbilityType.CHAT, "slot", "", "floorPx", "", "allowTallOverlap", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;Landroid/view/View;IZ)I", "", "overlap", "chatHeight", Const.INTENT_KEY_PKGNAME, "(FIIZ)I", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.b7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2774b7 {
    public static final int a(View chat, View slot, int i10, boolean z10) {
        kotlin.jvm.internal.p.i(chat, "chat");
        kotlin.jvm.internal.p.i(slot, "slot");
        Matrix matrix = new Matrix();
        slot.transformMatrixToGlobal(matrix);
        chat.transformMatrixToLocal(matrix);
        RectF rectF = new RectF(0.0f, 0.0f, slot.getWidth(), slot.getHeight());
        matrix.mapRect(rectF);
        return b(chat.getHeight() - rectF.top, chat.getHeight(), i10, z10);
    }

    public static final int b(float f10, int i10, int i11, boolean z10) {
        return (Math.abs(f10) > Float.MAX_VALUE || i10 <= 0 || (!z10 && f10 > ((float) i10) / 2.0f)) ? i11 : Math.max(i11, C5227b.b(C5685n.i(f10, i10)));
    }
}
