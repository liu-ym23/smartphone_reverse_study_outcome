package a5b;

import com.ss.android.lark.chat.cot.ActivityExtra;
import com.ss.android.lark.chat.cot.CotViewBlock;
import com.ss.android.lark.chat.cot.CotViewBlockType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f1907g;

    @Override // a5b.h
    public final CotViewBlock a() {
        CotViewBlock r100 = super.a();
        String r101 = this.f1907g;
        return CotViewBlock.copy$default(r100, null, null, null, r101, null, false, new ActivityExtra(r101), 55, null);
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "stableId");
        super(r100, CotViewBlockType.ACTIVITY);
    }
}
