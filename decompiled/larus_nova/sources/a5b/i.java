package a5b;

import com.ss.android.lark.chat.cot.CotViewBlock;
import com.ss.android.lark.chat.cot.CotViewBlockType;
import com.ss.android.lark.chat.cot.RawExtra;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class i extends h {
    @Override // a5b.h
    public final CotViewBlock a() {
        return CotViewBlock.copy$default(super.a(), null, null, null, null, null, false, RawExtra.INSTANCE, 63, null);
    }

    public i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "stableId");
        super(r100, CotViewBlockType.RAW);
    }
}
