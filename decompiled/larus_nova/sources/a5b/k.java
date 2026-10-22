package a5b;

import com.ss.android.lark.chat.cot.CotViewBlock;
import com.ss.android.lark.chat.cot.CotViewBlockType;
import com.ss.android.lark.chat.cot.RunExtra;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class k extends h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f1924g;

    @Override // a5b.h
    public final CotViewBlock a() {
        return CotViewBlock.copy$default(super.a(), null, null, null, null, null, false, new RunExtra(this.f1924g), 63, null);
    }

    public k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "stableId");
        super(r100, CotViewBlockType.RUN);
    }
}
