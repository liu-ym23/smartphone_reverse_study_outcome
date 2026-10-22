package bj8;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ReferenceBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReferenceBlock f19247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BotModel f19248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Message f19249c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f19247a, r101.f19247a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f19248b, r101.f19248b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f19249c, r101.f19249c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        ReferenceBlock r100 = this.f19247a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f19248b.hashCode()) * 31;
        Message r104 = this.f19249c;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BotReferenceTextVMData(block=" + this.f19247a + ", botModel=" + this.f19248b + ", refMessage=" + this.f19249c + ')';
    }

    public a(ReferenceBlock r100, BotModel r101, Message r102) {
        Intrinsics.checkNotNullParameter(r101, "botModel");
        this.f19247a = r100;
        this.f19248b = r101;
        this.f19249c = r102;
    }
}
