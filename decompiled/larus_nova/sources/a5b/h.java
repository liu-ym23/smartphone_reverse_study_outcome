package a5b;

import com.ss.android.lark.chat.cot.CotBlockStatus;
import com.ss.android.lark.chat.cot.CotViewBlock;
import com.ss.android.lark.chat.cot.CotViewBlockType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CotViewBlockType f1918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StringBuilder f1920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CotBlockStatus f1921e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1922f;

    public CotViewBlock a() {
        String r100 = this.f1917a;
        CotViewBlockType r101 = this.f1918b;
        String r102 = this.f1919c;
        if (this.f1920d.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        String r104 = null;
    L10:
        return new CotViewBlock(r100, r101, r102, r104, this.f1921e, this.f1922f, null);
    L8:
        r104 = this.f1920d.toString();
        goto L10
    L5:
        r103 = false;
        goto L6
    }

    public final CotViewBlockType getType() {
        return this.f1918b;
    }

    public final void b(CotBlockStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f1921e = r100;
    }

    public h(String r100, CotViewBlockType r101) {
        Intrinsics.checkNotNullParameter(r100, "stableId");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f1917a = r100;
        this.f1918b = r101;
        this.f1920d = new StringBuilder();
        this.f1921e = CotBlockStatus.PENDING;
    }
}
