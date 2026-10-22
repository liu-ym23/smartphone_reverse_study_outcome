package a5b;

import com.ss.android.lark.chat.cot.CotViewBlock;
import com.ss.android.lark.chat.cot.CotViewBlockType;
import com.ss.android.lark.chat.cot.CustomExtra;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class g extends h {
    @Override // a5b.h
    public final CotViewBlock a() {
        return CotViewBlock.copy$default(super.a(), null, null, null, null, null, false, CustomExtra.INSTANCE, 63, null);
    }

    public g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "stableId");
        super(r100, CotViewBlockType.CUSTOM);
    }
}
