package com.bytedance.android.livesdk.player;

import android.util.SparseIntArray;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/util/SparseIntArray;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class TTLivePlayer2$imageScaleMap$2 extends Lambda implements Function0<SparseIntArray> {
    public static final TTLivePlayer2$imageScaleMap$2 INSTANCE = null;

    static {
        INSTANCE = new TTLivePlayer2$imageScaleMap$2();
    }

    public TTLivePlayer2$imageScaleMap$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SparseIntArray invoke() {
        SparseIntArray r100 = new SparseIntArray(4);
        r100.put(0, 0);
        r100.put(1, 1);
        r100.put(2, 2);
        r100.put(3, 3);
        return r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ SparseIntArray invoke() {
        return invoke();
    }
}
