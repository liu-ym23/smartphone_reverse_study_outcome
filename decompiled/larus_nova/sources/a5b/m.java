package a5b;

import com.ss.android.lark.chat.cot.CotViewBlock;
import com.ss.android.lark.chat.cot.CotViewBlockType;
import com.ss.android.lark.chat.cot.TextExtra;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class m extends h {
    @Override // a5b.h
    public final CotViewBlock a() {
        return CotViewBlock.copy$default(super.a(), null, null, null, null, null, false, TextExtra.INSTANCE, 63, null);
    }

    public m(String r100) {
        Intrinsics.checkNotNullParameter(r100, "stableId");
        super(r100, CotViewBlockType.TEXT);
    }
}
