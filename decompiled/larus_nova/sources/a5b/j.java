package a5b;

import com.ss.android.lark.chat.cot.CotViewBlock;
import com.ss.android.lark.chat.cot.CotViewBlockType;
import com.ss.android.lark.chat.cot.ReasoningExtra;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class j extends h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f1923g;

    @Override // a5b.h
    public final CotViewBlock a() {
        CotViewBlock r100 = super.a();
        ArrayList r101 = (ArrayList) this.f1923g;
        ArrayList r102 = null;
        if ((!r101.isEmpty()) == true) goto L6;
        r101 = null;
    L6:
        if (r101 == null) goto L9;
        r102 = new ArrayList(r101);
    L9:
        return CotViewBlock.copy$default(r100, null, null, null, null, null, false, new ReasoningExtra(r102), 63, null);
    }

    public j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "stableId");
        super(r100, CotViewBlockType.REASONING);
        this.f1923g = new ArrayList();
    }
}
